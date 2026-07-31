#!/usr/bin/env python3
"""Rewrites legacy GT `Materials`/`OrePrefixes` call sites to MaterialLib's Materials2 API.

Field inventories are read from GT5-Unofficial's `gregtech/api/enums/materials` package, but the
emitted spellings are the `Materials2*` ones the pinned GT5U build still exposes.

Three passes, selectable with `--passes`:

  `staticimports`
      Drops `import static gregtech.api.enums.{Materials,OrePrefixes}.<X>;` and re-qualifies the
      bare `<X>` references they covered, so the other passes can see them.

  `stacks`
      1. `GTOreDictUnificator.get(OrePrefixes.P, Materials.M, amount)` (3-arg only)
      2. `Materials.M.get<Getter>(amount)` for the item getters (Dust, DustSmall, DustTiny, Gems,
         Ingots, Nuggets, Plates, Cells, Blocks, Nanite) and the fluid getters (Fluid, Gas, Plasma,
         Molten)
      3. `Materials.M.getPart(OrePrefixes.P, amount)`

  `itemdata`
      `OrePrefixes.P.get(Materials.M)` -> `MU.craftIngredient(OrePrefixes.P, Materials2Materials.M)`

A (material, shape) pair becomes a `MaterialLibAPI.getStack`/`getFluidStack` call only when
`ml-materials.json` lists that shape for that material. Otherwise the call routes back through
`MU.materialOf(Materials2Materials.M)`, keeping the legacy ore-dictionary lookup for prefixes
MaterialLib does not own (`block`, `frameGt`, the wire/cable/pipe families) and the legacy fluid
slot for materials whose fluid is registered outside MaterialLib (water, lava, UU-Matter).
`getSolid` is excluded outright.

Legacy constants with no MaterialLib counterpart at all -- the `Any*` wildcard markers and the
handful of never-ported decorative materials -- are reported as skips and left for hand-fixing.

Everything else -- variables in place of a literal prefix/material, `addItemDataFromInputs`/
`addAssociation` donor sites, association constructors like `new ItemData(Materials.M, amount)`,
property reads such as `mFluid`/`mName` -- does not match these patterns and is left alone.

Usage: migrate_materials2.py <file-or-dir> [<file-or-dir> ...] [--apply] [--passes a,b]
                             [--report OUT.json]

Without --apply this is a dry run: prints a per-file summary of what would change and why call
sites were skipped. Import lines are added for whichever of MaterialLibAPI/MU/Materials2Materials/
Materials2Shapes/Materials2FluidShapes/Materials2CellShapes end up used, and the legacy
`gregtech.api.enums.Materials`/`OrePrefixes` imports are dropped when no occurrence remains.
Run `./gradlew spotlessApply` after --apply; this script does not format its output.
"""
from __future__ import annotations

import argparse
import json
import re
import subprocess
import sys
from pathlib import Path

GT5U_ROOT = Path("C:/Users/alexw/Documents/GitHub/gtnh/GT5-Unofficial")
ML_MATERIALS_JSON = GT5U_ROOT / "scripts/mu/dumps/ml-materials.json"
MATERIALS_DIR = GT5U_ROOT / "src/main/java/gregtech/api/enums/materials"
MATERIALS_INIT_REF = "origin/master:src/main/java/gregtech/loaders/materials/MaterialsInit.java"

HARD_EXCLUDE_PREFIXES = {"solid"}

# Bare getter name -> OrePrefixes name. The prefix doubles as the shape field name and as the
# fallback `GTOreDictUnificator.get` prefix.
ITEM_GETTERS = {
    "getDust": "dust",
    "getDustSmall": "dustSmall",
    "getDustTiny": "dustTiny",
    "getGems": "gem",
    "getIngots": "ingot",
    "getNuggets": "nugget",
    "getPlates": "plate",
    "getCells": "cell",
    "getBlocks": "block",
    "getNanite": "nanite",
}
# Bare getter name -> (ml-materials.json fluid slot, FluidShapes field)
FLUID_GETTERS = {
    "getFluid": ("fluid", "fluidLiquid"),
    "getGas": ("gas", "fluidGas"),
    "getPlasma": ("plasma", "fluidPlasma"),
    "getMolten": ("molten", "fluidMolten"),
}
ALL_GETTERS = sorted(set(ITEM_GETTERS) | set(FLUID_GETTERS) | {"getPart"})

IMPORT_MATERIALLIBAPI = "import com.ruling_0.materiallib.api.MaterialLibAPI;"
IMPORT_MU = "import gregtech.api.material.MU;"
IMPORT_M2MATERIALS = "import gregtech.api.enums.materials2.Materials2Materials;"
IMPORT_M2SHAPES = "import gregtech.api.enums.materials2.Materials2Shapes;"
IMPORT_M2FLUIDSHAPES = "import gregtech.api.enums.materials2.Materials2FluidShapes;"
IMPORT_M2CELLSHAPES = "import gregtech.api.enums.materials2.Materials2CellShapes;"
IMPORT_UNIFICATOR = "import gregtech.api.util.GTOreDictUnificator;"
IMPORT_LEGACY_MATERIALS = "import gregtech.api.enums.Materials;"
IMPORT_LEGACY_OREPREFIXES = "import gregtech.api.enums.OrePrefixes;"

USE_IMPORTS = [
    ("materiallibapi", IMPORT_MATERIALLIBAPI),
    ("mu", IMPORT_MU),
    ("materials", IMPORT_M2MATERIALS),
    ("shapes", IMPORT_M2SHAPES),
    ("fluidshapes", IMPORT_M2FLUIDSHAPES),
    ("cellshapes", IMPORT_M2CELLSHAPES),
    ("oreprefixes", IMPORT_LEGACY_OREPREFIXES),
    ("legacymaterials", IMPORT_LEGACY_MATERIALS),
    ("unificator", IMPORT_UNIFICATOR),
]

STATIC_IMPORT_RE = re.compile(r"^import static gregtech\.api\.enums\.(Materials|OrePrefixes)\.(\w+);$")


def load_ml_materials():
    data = json.loads(ML_MATERIALS_JSON.read_text(encoding="utf-8"))
    return {m["name"]: m for m in data}


def load_shape_fields(class_name):
    text = (MATERIALS_DIR / f"{class_name}.java").read_text(encoding="utf-8")
    return set(re.findall(r"public static Shape (\w+);", text))


def load_material_fields():
    text = (MATERIALS_DIR / "Materials.java").read_text(encoding="utf-8")
    return set(re.findall(r"public static Material (\w+);", text))


def sanitize(name: str) -> str:
    """The identifier `Materials` exposes for a material whose internal name is `name`."""
    field = re.sub(r"[^A-Za-z0-9]", "", name)
    return "_" + field if field[:1].isdigit() else field


def load_legacy_material_map(material_fields):
    """Legacy `Materials` constant -> the identifier the unified `Materials` exposes it under.

    Built from master's `MaterialsInit`, which pairs each legacy constant with the loader that
    supplies its internal name; the unified class names its field after that internal name. Legacy
    constants with no counterpart (marker pseudo-materials, circuit tiers, component stand-ins) are
    absent, so their call sites are reported as skips rather than rewritten.
    """
    text = subprocess.run(
        ["git", "-C", str(GT5U_ROOT), "show", MATERIALS_INIT_REF],
        capture_output=True,
        check=True,
    ).stdout.decode("utf-8")
    loaders = {}
    for m in re.finditer(r"private static Materials (load\w+)\(\)\s*\{(.*?)\n    \}", text, re.S):
        name = re.search(r'\.setName\("([^"]*)"\)', m.group(2))
        if name:
            loaders[m.group(1)] = name.group(1)
    mapping = {}
    for chain, loader in re.findall(r"((?:Materials\.\w+\s*=\s*)+)(load\w+)\(\)", text):
        internal = loaders.get(loader)
        if internal is None:
            continue
        ported = sanitize(internal)
        if ported not in material_fields:
            continue
        for field in re.findall(r"Materials\.(\w+)", chain):
            mapping[field] = ported
    return mapping


ML_MATERIALS = load_ml_materials()
ITEM_SHAPE_FIELDS = load_shape_fields("Shapes")
CELL_SHAPE_FIELDS = load_shape_fields("CellShapes")
FLUID_SHAPE_FIELDS = load_shape_fields("FluidShapes")
MATERIAL_FIELDS = load_material_fields()
LEGACY_MATERIAL_MAP = load_legacy_material_map(MATERIAL_FIELDS)


def classify_prefix(prefix: str):
    """Returns ('item'|'cell', shape_field) or None if this prefix has no MaterialLib shape."""
    if prefix in HARD_EXCLUDE_PREFIXES:
        return None
    if prefix in ITEM_SHAPE_FIELDS:
        return ("item", prefix)
    if prefix in CELL_SHAPE_FIELDS:
        return ("cell", prefix)
    return None


def material_has_shape(material: str, prefix: str) -> bool:
    m = ML_MATERIALS.get(material)
    return m is not None and prefix in m.get("shapes", [])


def material_has_fluid_slot(material: str, key: str) -> bool:
    m = ML_MATERIALS.get(material)
    return m is not None and m.get("fluids", {}).get(key) is not None


# ---------------------------------------------------------------------------
# Text scanning: no real Java parser: match a call's opening token, then walk
# forward balancing (), [], {} and skipping string/char literals to find the
# matching close paren, then split top-level arguments on commas.
# ---------------------------------------------------------------------------


def find_matching_paren(text: str, open_idx: int) -> int:
    assert text[open_idx] == "("
    depth = 0
    i = open_idx
    n = len(text)
    while i < n:
        c = text[i]
        if c == '"':
            i += 1
            while i < n and text[i] != '"':
                if text[i] == "\\":
                    i += 1
                i += 1
        elif c == "'":
            i += 1
            while i < n and text[i] != "'":
                if text[i] == "\\":
                    i += 1
                i += 1
        elif c in "([{":
            depth += 1
        elif c in ")]}":
            depth -= 1
            if depth == 0:
                return i
        i += 1
    raise ValueError("unbalanced parens")


def split_top_level_args(arg_text: str):
    args = []
    depth = 0
    current = []
    i = 0
    n = len(arg_text)
    while i < n:
        c = arg_text[i]
        if c == '"':
            current.append(c)
            i += 1
            while i < n and arg_text[i] != '"':
                if arg_text[i] == "\\" and i + 1 < n:
                    current.append(arg_text[i])
                    i += 1
                current.append(arg_text[i])
                i += 1
            if i < n:
                current.append(arg_text[i])
                i += 1
            continue
        if c == "'":
            current.append(c)
            i += 1
            while i < n and arg_text[i] != "'":
                if arg_text[i] == "\\" and i + 1 < n:
                    current.append(arg_text[i])
                    i += 1
                current.append(arg_text[i])
                i += 1
            if i < n:
                current.append(arg_text[i])
                i += 1
            continue
        if c in "([{":
            depth += 1
            current.append(c)
        elif c in ")]}":
            depth -= 1
            current.append(c)
        elif c == "," and depth == 0:
            args.append("".join(current))
            current = []
        else:
            current.append(c)
        i += 1
    if arg_text.strip():
        args.append("".join(current))
    return [a.strip() for a in args]


LITERAL_OREPREFIX_RE = re.compile(r"^OrePrefixes\.(\w+)$")
LITERAL_MATERIAL_RE = re.compile(r"^Materials\.(\w+)$")

UNIFICATOR_GET_RE = re.compile(r"\bGTOreDictUnificator\s*\.\s*get\(")
MATERIALS_GETTER_RE = re.compile(r"\bMaterials\.(\w+)\.(" + "|".join(ALL_GETTERS) + r")\(")
ITEMDATA_GET_RE = re.compile(r"\bOrePrefixes\.(\w+)\.get\(")


def ported(material: str):
    return LEGACY_MATERIAL_MAP.get(material)


def build_stack_call(material: str, shape_kind: str, shape_field: str, amount_text: str, uses):
    shape_class = "Materials2Shapes" if shape_kind == "item" else "Materials2CellShapes"
    uses.add("shapes" if shape_kind == "item" else "cellshapes")
    uses.add("materiallibapi")
    uses.add("materials")
    return (
        f"MaterialLibAPI.getStack(Materials2Materials.{material}, "
        f"{shape_class}.{shape_field}, (int) ({amount_text}))"
    )


def build_fluid_call(material: str, shape_field: str, amount_text: str, uses):
    uses.add("fluidshapes")
    uses.add("materiallibapi")
    uses.add("materials")
    return (
        f"MaterialLibAPI.getFluidStack(Materials2Materials.{material}, "
        f"Materials2FluidShapes.{shape_field}, (int) ({amount_text}))"
    )


def build_legacy_material_ref(material: str, uses):
    """The bridge back to the legacy constant, for lookups MaterialLib does not own."""
    uses.add("mu")
    uses.add("materials")
    return f"MU.materialOf(Materials2Materials.{material})"


def build_unificator_call(prefix: str, material: str, amount_text: str, uses):
    uses.add("oreprefixes")
    uses.add("unificator")
    return (
        f"GTOreDictUnificator.get(OrePrefixes.{prefix}, "
        f"{build_legacy_material_ref(material, uses)}, {amount_text})"
    )


def process_unificator_get(text: str, start: int, uses, skip_log):
    open_idx = text.index("(", start)
    close_idx = find_matching_paren(text, open_idx)
    args = split_top_level_args(text[open_idx + 1 : close_idx])
    if len(args) != 3:
        return None
    prefix_m = LITERAL_OREPREFIX_RE.match(args[0])
    material_m = LITERAL_MATERIAL_RE.match(args[1])
    if not prefix_m or not material_m:
        return None
    prefix, legacy = prefix_m.group(1), material_m.group(1)
    snippet = text[start : close_idx + 1][:120]
    material = ported(legacy)
    if material is None:
        skip_log.append(("never-ported-material", legacy, prefix, snippet))
        return None
    classified = classify_prefix(prefix)
    if classified is None or not material_has_shape(material, prefix):
        # Only the material token moves; the ore-dictionary lookup itself is unchanged.
        mat_start = open_idx + 1 + text[open_idx + 1 : close_idx].index(args[1])
        return mat_start, mat_start + len(args[1]), build_legacy_material_ref(material, uses)
    kind, field = classified
    return start, close_idx + 1, build_stack_call(material, kind, field, args[2], uses)


def process_materials_getter(text: str, m: re.Match, uses, skip_log):
    legacy, getter = m.group(1), m.group(2)
    start = m.start()
    open_idx = m.end() - 1
    close_idx = find_matching_paren(text, open_idx)
    args = split_top_level_args(text[open_idx + 1 : close_idx])
    snippet = text[start : close_idx + 1][:120]
    material = ported(legacy)
    if material is None:
        skip_log.append(("never-ported-material", legacy, getter, snippet))
        return None

    if getter == "getPart":
        if len(args) != 2:
            return None
        prefix_m = LITERAL_OREPREFIX_RE.match(args[0])
        if not prefix_m:
            return None
        prefix, amount = prefix_m.group(1), args[1]
    elif getter in ITEM_GETTERS:
        if len(args) != 1:
            return None
        prefix, amount = ITEM_GETTERS[getter], args[0]
    else:
        if len(args) != 1:
            return None
        key, field = FLUID_GETTERS[getter]
        if not material_has_fluid_slot(material, key):
            bridge = build_legacy_material_ref(material, uses)
            return start, close_idx + 1, f"{bridge}.{getter}({args[0]})"
        return start, close_idx + 1, build_fluid_call(material, field, args[0], uses)

    classified = classify_prefix(prefix)
    if classified is None or not material_has_shape(material, prefix):
        return start, close_idx + 1, build_unificator_call(prefix, material, amount, uses)
    kind, field = classified
    return start, close_idx + 1, build_stack_call(material, kind, field, amount, uses)


def process_itemdata_get(text: str, m: re.Match, uses, skip_log):
    prefix = m.group(1)
    start = m.start()
    open_idx = m.end() - 1
    close_idx = find_matching_paren(text, open_idx)
    args = split_top_level_args(text[open_idx + 1 : close_idx])
    if len(args) != 1:
        return None
    material_m = LITERAL_MATERIAL_RE.match(args[0])
    if not material_m:
        return None
    legacy = material_m.group(1)
    material = ported(legacy)
    if material is None:
        skip_log.append(("never-ported-material", legacy, prefix, text[start : close_idx + 1][:120]))
        return None
    uses.add("mu")
    uses.add("materials")
    replacement = f"MU.craftIngredient(OrePrefixes.{prefix}, Materials2Materials.{material})"
    return start, close_idx + 1, replacement


def apply_static_import_pass(text: str):
    lines = text.split("\n")
    names = {"Materials": [], "OrePrefixes": []}
    kept = []
    for line in lines:
        m = STATIC_IMPORT_RE.match(line.strip())
        if m:
            names[m.group(1)].append(m.group(2))
        else:
            kept.append(line)
    total = sum(len(v) for v in names.values())
    if not total:
        return text, 0
    patterns = [
        (holder, re.compile(r"(?<![\w.])(" + "|".join(sorted(v, key=len, reverse=True)) + r")\b"))
        for holder, v in names.items()
        if v
    ]
    out = []
    for line in "\n".join(kept).split("\n"):
        if line.lstrip().startswith("import "):
            out.append(line)
            continue
        spans = []
        for span, quoted in split_literals(line):
            for holder, pattern in patterns:
                if not quoted:
                    span = pattern.sub(holder + r".\1", span)
            spans.append(span)
        out.append("".join(spans))
    return "\n".join(out), total


def split_literals(line: str):
    """Splits a line into (text, is_string_or_char_literal) spans."""
    spans = []
    i = 0
    start = 0
    n = len(line)
    while i < n:
        if line[i] in "\"'":
            quote = line[i]
            spans.append((line[start:i], False))
            j = i + 1
            while j < n and line[j] != quote:
                j += 2 if line[j] == "\\" else 1
            spans.append((line[i : j + 1], True))
            i = start = j + 1
        else:
            i += 1
    spans.append((line[start:], False))
    return spans


def collect_edits(text: str, passes, uses, skip_log):
    edits = []
    if "stacks" in passes:
        for m in UNIFICATOR_GET_RE.finditer(text):
            result = process_unificator_get(text, m.start(), uses, skip_log)
            if result:
                edits.append(result)
        for m in MATERIALS_GETTER_RE.finditer(text):
            result = process_materials_getter(text, m, uses, skip_log)
            if result:
                edits.append(result)
    if "itemdata" in passes:
        for m in ITEMDATA_GET_RE.finditer(text):
            result = process_itemdata_get(text, m, uses, skip_log)
            if result:
                edits.append(result)
    edits.sort(key=lambda e: e[0])
    pruned = []
    for edit in edits:
        if pruned and edit[0] < pruned[-1][1]:
            continue
        pruned.append(edit)
    return pruned


def fix_imports(text: str, uses):
    # Word-boundary (not just dotted-call) scan, and blind to the legacy import lines themselves,
    # so a bare type reference (e.g. a `Materials material` parameter) still pins the import.
    body = "\n".join(
        l
        for l in text.split("\n")
        if l.strip() not in (IMPORT_LEGACY_MATERIALS, IMPORT_LEGACY_OREPREFIXES)
    )
    remaining_materials = re.search(r"\bMaterials\b", body)
    remaining_oreprefixes = re.search(r"\bOrePrefixes\b", body)

    import_lines = [imp for key, imp in USE_IMPORTS if key in uses and imp not in text]
    if import_lines:
        lines = text.split("\n")
        last_import_idx = max(i for i, l in enumerate(lines) if l.startswith("import "))
        lines[last_import_idx + 1 : last_import_idx + 1] = import_lines
        text = "\n".join(lines)

    drop = set()
    if not remaining_materials:
        drop.add(IMPORT_LEGACY_MATERIALS)
    if not remaining_oreprefixes:
        drop.add(IMPORT_LEGACY_OREPREFIXES)
    if drop:
        text = "\n".join(l for l in text.split("\n") if l.strip() not in drop)
    return text


def rewrite_file(path: Path, apply: bool, passes):
    text = path.read_text(encoding="utf-8")
    original = text
    uses = set()
    skip_log = []

    qualified = 0
    if "staticimports" in passes:
        text, qualified = apply_static_import_pass(text)
        if qualified:
            uses.add("legacymaterials")
            uses.add("oreprefixes")

    edits = collect_edits(text, passes, uses, skip_log)
    for start, end, replacement in reversed(edits):
        text = text[:start] + replacement + text[end:]

    if edits or qualified:
        text = fix_imports(text, uses)

    if apply and text != original:
        path.write_text(text, encoding="utf-8")

    return len(edits), qualified, skip_log


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("paths", nargs="+")
    parser.add_argument("--apply", action="store_true")
    parser.add_argument("--passes", default="staticimports,stacks")
    parser.add_argument("--report", type=Path, default=None)
    args = parser.parse_args()

    passes = {p.strip() for p in args.passes.split(",") if p.strip()}
    unknown = passes - {"staticimports", "stacks", "itemdata"}
    if unknown:
        sys.exit(f"unknown pass(es): {', '.join(sorted(unknown))}")

    files = []
    for p in args.paths:
        path = Path(p)
        if path.is_dir():
            files.extend(sorted(path.rglob("*.java")))
        else:
            files.append(path)

    total_edits = 0
    report = {}
    for f in files:
        n, qualified, skip_log = rewrite_file(f, args.apply, passes)
        if n or skip_log or qualified:
            report[str(f)] = {"edits": n, "qualified": qualified, "skips": skip_log}
            print(f"{f}: {n} edits, {qualified} static imports qualified, {len(skip_log)} skipped")
            for kind, mat, prefix, snippet in skip_log:
                print(f"    SKIP[{kind}] {mat} / {prefix}: {snippet}")
        total_edits += n

    print(f"\nTotal: {total_edits} edits across {len(files)} files")
    if args.report:
        args.report.write_text(json.dumps(report, indent=2), encoding="utf-8")


if __name__ == "__main__":
    main()
