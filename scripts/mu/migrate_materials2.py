#!/usr/bin/env python3
"""Rewrites legacy GT `Materials`/`OrePrefixes` call sites to MaterialLib's Materials2 API.

Handles exactly three source patterns, each only when every operand is a literal the script can
validate (never a variable, never a computed prefix):

  1. `GTOreDictUnificator.get(OrePrefixes.P, Materials.M, amount)` (3-arg only)
  2. `Materials.M.get<Getter>(amount)` for the item getters (Dust, DustSmall, DustTiny, Gems,
     Ingots, Nuggets, Plates, Cells) and the fluid getters (Fluid, Gas, Plasma, Molten)
  3. `Materials.M.getPart(OrePrefixes.P, amount)`

`getSolid`, `getBlocks`, `getNanite`, and the `cellMolten` prefix are hard-excluded regardless of
validation. A (material, shape) pair is only rewritten when `ml-materials.json` lists that shape
for that material (item/cell prefixes) or has a non-null fluid slot (fluid getters). A prefix with
no corresponding `shape*` field in Materials2Shapes/Materials2CellShapes is left untouched (its
call site stays on the legacy API).

Everything else -- variables in place of a literal prefix/material, the 2-arg
`OrePrefixes.P.get(Materials.M)` wildcard ItemData idiom, `addItemDataFromInputs`/`addAssociation`
donor sites, association constructors like `new ItemData(Materials.M, amount)` -- does not match
these patterns and is left alone.

Usage: migrate_materials2.py <file-or-dir> [<file-or-dir> ...] [--apply] [--report OUT.json]

Without --apply this is a dry run: prints a per-file summary of what would change and why call
sites were skipped. Import lines are added for whichever of MaterialLibAPI/Materials2Materials/
Materials2Shapes/Materials2FluidShapes/Materials2CellShapes end up used, and the legacy
`gregtech.api.enums.Materials`/`OrePrefixes` imports are dropped when no occurrence remains.
Run `./gradlew spotlessApply` after --apply; this script does not format its output.
"""
from __future__ import annotations

import argparse
import json
import re
import sys
from pathlib import Path

ML_MATERIALS_JSON = Path(
    "C:/Users/alexw/Documents/GitHub/gtnh/GT5-Unofficial/scripts/mu/dumps/ml-materials.json"
)
MATERIALS2_DIR = Path(
    "C:/Users/alexw/Documents/GitHub/gtnh/GT5-Unofficial/src/main/java/gregtech/api/enums/materials2"
)

HARD_EXCLUDE_PREFIXES = {"block", "nanite", "cellMolten", "solid"}

# Bare getter name -> (kind, shape-lookup-key)
# kind "item" validates against material['shapes']; kind "fluid" validates against material['fluids'][key].
ITEM_GETTERS = {
    "getDust": "dust",
    "getDustSmall": "dustSmall",
    "getDustTiny": "dustTiny",
    "getGems": "gem",
    "getIngots": "ingot",
    "getNuggets": "nugget",
    "getPlates": "plate",
    "getCells": "cell",
}
FLUID_GETTERS = {
    "getFluid": ("fluid", "Liquid"),
    "getGas": ("gas", "Gas"),
    "getPlasma": ("plasma", "Plasma"),
    "getMolten": ("molten", "Molten"),
}
ALL_GETTERS = sorted(set(ITEM_GETTERS) | set(FLUID_GETTERS) | {"getPart"})

IMPORT_MATERIALLIBAPI = "import com.ruling_0.materiallib.api.MaterialLibAPI;"
IMPORT_M2MATERIALS = "import gregtech.api.enums.materials2.Materials2Materials;"
IMPORT_M2SHAPES = "import gregtech.api.enums.materials2.Materials2Shapes;"
IMPORT_M2FLUIDSHAPES = "import gregtech.api.enums.materials2.Materials2FluidShapes;"
IMPORT_M2CELLSHAPES = "import gregtech.api.enums.materials2.Materials2CellShapes;"
IMPORT_LEGACY_MATERIALS = "import gregtech.api.enums.Materials;"
IMPORT_LEGACY_OREPREFIXES = "import gregtech.api.enums.OrePrefixes;"


def load_ml_materials():
    data = json.loads(ML_MATERIALS_JSON.read_text(encoding="utf-8"))
    return {m["name"]: m for m in data}


def load_shape_fields():
    def extract(path):
        text = path.read_text(encoding="utf-8")
        return set(re.findall(r"public static Shape (\w+);", text))

    item_shapes = extract(MATERIALS2_DIR / "Materials2Shapes.java")
    cell_shapes = extract(MATERIALS2_DIR / "Materials2CellShapes.java")
    fluid_shapes = extract(MATERIALS2_DIR / "Materials2FluidShapes.java")
    return item_shapes, cell_shapes, fluid_shapes


def load_material_fields():
    text = (MATERIALS2_DIR / "Materials2Materials.java").read_text(encoding="utf-8")
    return set(re.findall(r"public static Material (\w+);", text))


ML_MATERIALS = load_ml_materials()
ITEM_SHAPE_FIELDS, CELL_SHAPE_FIELDS, FLUID_SHAPE_FIELDS = load_shape_fields()
MATERIAL_FIELDS = load_material_fields()


def shape_field_name(prefix: str) -> str:
    return "shape" + prefix[0].upper() + prefix[1:]


def classify_prefix(prefix: str):
    """Returns ('item'|'cell', shape_field) or None if this prefix has no ML shape."""
    if prefix in HARD_EXCLUDE_PREFIXES:
        return None
    field = shape_field_name(prefix)
    if field in ITEM_SHAPE_FIELDS:
        return ("item", field)
    if field in CELL_SHAPE_FIELDS:
        return ("cell", field)
    return None


def material_has_shape(material: str, prefix: str) -> bool:
    m = ML_MATERIALS.get(material)
    if m is None:
        return False
    return prefix in m.get("shapes", [])


def material_has_fluid_slot(material: str, key: str) -> bool:
    m = ML_MATERIALS.get(material)
    if m is None:
        return False
    return m.get("fluids", {}).get(key) is not None


def material_known(material: str) -> bool:
    return material in MATERIAL_FIELDS and material in ML_MATERIALS


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

UNIFICATOR_GET_RE = re.compile(r"\bGTOreDictUnificator\.get\(")
MATERIALS_GETTER_RE = re.compile(
    r"\bMaterials\.(\w+)\.(" + "|".join(ALL_GETTERS) + r")\("
)


class Skip(Exception):
    def __init__(self, reason):
        self.reason = reason


def build_stack_call(material: str, shape_kind: str, shape_field: str, amount_text: str, uses):
    amount = f"(int) ({amount_text})"
    if shape_kind == "item":
        uses.add("shapes")
        shape_ref = f"Materials2Shapes.{shape_field}"
    else:
        uses.add("cellshapes")
        shape_ref = f"Materials2CellShapes.{shape_field}"
    uses.add("materiallibapi")
    uses.add("materials")
    return f"MaterialLibAPI.getStack(Materials2Materials.{material}, {shape_ref}, {amount})"


def build_fluid_call(material: str, fluid_suffix: str, amount_text: str, uses):
    amount = f"(int) ({amount_text})"
    uses.add("fluidshapes")
    uses.add("materiallibapi")
    uses.add("materials")
    return (
        f"MaterialLibAPI.getFluidStack(Materials2Materials.{material}, "
        f"Materials2FluidShapes.shapeFluid{fluid_suffix}, {amount})"
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
    prefix, material = prefix_m.group(1), material_m.group(1)
    if not material_known(material):
        skip_log.append(("never-ported-material", material, prefix, text[start:close_idx + 1][:120]))
        return None
    classified = classify_prefix(prefix)
    if classified is None:
        skip_log.append(("no-shape-prefix", material, prefix, text[start:close_idx + 1][:120]))
        return None
    kind, field = classified
    if not material_has_shape(material, prefix):
        skip_log.append(("shape-lacking-pair", material, prefix, text[start:close_idx + 1][:120]))
        return None
    replacement = build_stack_call(material, kind, field, args[2], uses)
    return start, close_idx + 1, replacement


def process_materials_getter(text: str, m: re.Match, uses, skip_log):
    material, getter = m.group(1), m.group(2)
    start = m.start()
    open_idx = m.end() - 1
    close_idx = find_matching_paren(text, open_idx)
    args = split_top_level_args(text[open_idx + 1 : close_idx])
    if not material_known(material):
        skip_log.append(("never-ported-material", material, getter, text[start:close_idx + 1][:120]))
        return None

    if getter == "getPart":
        if len(args) != 2:
            return None
        prefix_m = LITERAL_OREPREFIX_RE.match(args[0])
        if not prefix_m:
            return None
        prefix = prefix_m.group(1)
        classified = classify_prefix(prefix)
        if classified is None:
            skip_log.append(("no-shape-prefix", material, prefix, text[start:close_idx + 1][:120]))
            return None
        kind, field = classified
        if not material_has_shape(material, prefix):
            skip_log.append(("shape-lacking-pair", material, prefix, text[start:close_idx + 1][:120]))
            return None
        replacement = build_stack_call(material, kind, field, args[1], uses)
        return start, close_idx + 1, replacement

    if len(args) != 1:
        return None

    if getter in ITEM_GETTERS:
        prefix = ITEM_GETTERS[getter]
        classified = classify_prefix(prefix)
        if classified is None:
            skip_log.append(("no-shape-prefix", material, prefix, text[start:close_idx + 1][:120]))
            return None
        kind, field = classified
        if not material_has_shape(material, prefix):
            skip_log.append(("shape-lacking-pair", material, prefix, text[start:close_idx + 1][:120]))
            return None
        replacement = build_stack_call(material, kind, field, args[0], uses)
        return start, close_idx + 1, replacement

    if getter in FLUID_GETTERS:
        key, suffix = FLUID_GETTERS[getter]
        if not material_has_fluid_slot(material, key):
            skip_log.append(("shape-lacking-pair", material, key, text[start:close_idx + 1][:120]))
            return None
        replacement = build_fluid_call(material, suffix, args[0], uses)
        return start, close_idx + 1, replacement

    return None


def rewrite_file(path: Path, apply: bool):
    text = path.read_text(encoding="utf-8")
    uses = set()
    skip_log = []
    edits = []

    for m in UNIFICATOR_GET_RE.finditer(text):
        result = process_unificator_get(text, m.start(), uses, skip_log)
        if result:
            edits.append(result)

    for m in MATERIALS_GETTER_RE.finditer(text):
        result = process_materials_getter(text, m, uses, skip_log)
        if result:
            edits.append(result)

    edits.sort(key=lambda e: e[0])
    for i in range(1, len(edits)):
        if edits[i][0] < edits[i - 1][1]:
            raise RuntimeError(f"{path}: overlapping edits at {edits[i]} vs {edits[i-1]}")

    if not edits:
        return 0, skip_log, uses

    new_text = text
    for start, end, replacement in sorted(edits, key=lambda e: -e[0]):
        new_text = new_text[:start] + replacement + new_text[end:]

    # Word-boundary (not just dotted-call) scan, and blind to the legacy import lines themselves,
    # so a bare type reference (e.g. a `Materials material` parameter) still pins the import.
    body_without_legacy_imports = "\n".join(
        l
        for l in new_text.split("\n")
        if l.strip() not in (IMPORT_LEGACY_MATERIALS, IMPORT_LEGACY_OREPREFIXES)
    )
    remaining_materials = re.search(r"\bMaterials\b", body_without_legacy_imports)
    remaining_oreprefixes = re.search(r"\bOrePrefixes\b", body_without_legacy_imports)

    import_lines = []
    if "materiallibapi" in uses and IMPORT_MATERIALLIBAPI not in new_text:
        import_lines.append(IMPORT_MATERIALLIBAPI)
    if "materials" in uses and IMPORT_M2MATERIALS not in new_text:
        import_lines.append(IMPORT_M2MATERIALS)
    if "shapes" in uses and IMPORT_M2SHAPES not in new_text:
        import_lines.append(IMPORT_M2SHAPES)
    if "fluidshapes" in uses and IMPORT_M2FLUIDSHAPES not in new_text:
        import_lines.append(IMPORT_M2FLUIDSHAPES)
    if "cellshapes" in uses and IMPORT_M2CELLSHAPES not in new_text:
        import_lines.append(IMPORT_M2CELLSHAPES)

    if import_lines:
        lines = new_text.split("\n")
        last_import_idx = max(i for i, l in enumerate(lines) if l.startswith("import "))
        lines[last_import_idx + 1 : last_import_idx + 1] = import_lines
        new_text = "\n".join(lines)

    if not remaining_materials and IMPORT_LEGACY_MATERIALS in new_text:
        new_text = "\n".join(
            l for l in new_text.split("\n") if l.strip() != IMPORT_LEGACY_MATERIALS
        )
    if not remaining_oreprefixes and IMPORT_LEGACY_OREPREFIXES in new_text:
        new_text = "\n".join(
            l for l in new_text.split("\n") if l.strip() != IMPORT_LEGACY_OREPREFIXES
        )

    if apply:
        path.write_text(new_text, encoding="utf-8")

    return len(edits), skip_log, uses


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("paths", nargs="+")
    parser.add_argument("--apply", action="store_true")
    parser.add_argument("--report", type=Path, default=None)
    args = parser.parse_args()

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
        n, skip_log, uses = rewrite_file(f, args.apply)
        if n or skip_log:
            report[str(f)] = {"edits": n, "skips": skip_log}
            print(f"{f}: {n} edits, {len(skip_log)} skipped candidates")
            for kind, mat, prefix, snippet in skip_log:
                print(f"    SKIP[{kind}] {mat} / {prefix}: {snippet}")
        total_edits += n

    print(f"\nTotal: {total_edits} edits across {len(files)} files")
    if args.report:
        args.report.write_text(json.dumps(report, indent=2), encoding="utf-8")


if __name__ == "__main__":
    main()
