#!/usr/bin/env python3
"""Diffs `recipe-census.json` (a fresh dedicated-server dump, `run/server/material-dump/recipe-census.json`)
against the pinned `scripts/mu/dumps/recipe-census-baseline.json`, order-normalized per recipe map (a
`digests` list is a multiset -- registration order is not stable across boots).

Adapted from GT5-Unofficial's `scripts/mu/diff_census.py` for this repo: NHCM has no gtpp cutover tables
(those are GT5-Unofficial-internal), so there is no legacy-token allowlist here -- every retired token is
reported. A new token whose domain is `materiallib` is the expected shape of an accepted-by-policy digest
(a recipe's foreign-mod oredict-claimed item replaced by the equivalent MaterialLib stack of the same
(material, shape)); anything else retired or new is a bug per the campaign's standing policy.

Usage: python scripts/mu/diff_census.py [fresh_census_path]
(defaults to run/server/material-dump/recipe-census.json)
"""

import json
import sys
from collections import Counter
from pathlib import Path

SCRIPT_DIR = Path(__file__).resolve().parent
REPO_ROOT = SCRIPT_DIR.parent.parent
BASELINE_PATH = SCRIPT_DIR / "dumps" / "recipe-census-baseline.json"


def load_json(path):
    with open(path, encoding="utf-8") as f:
        return json.load(f)


def parse_digest_tokens(digest):
    """Every `domain:name` item token referenced on the `in=`/`out=` sides of one digest string (damage/
    amount/bool dropped for the retired/new-token comparison -- a pure quantity or damage-meta change on an
    otherwise-unrelated item is not what this differ is hunting for). The digest format is
    `in=<item>,<item>,...|out=...|fin=<fluidName>:<amount>,...|fout=...`; items and fluids are disjoint field
    groups (`in`/`out` vs `fin`/`fout`), so only the first two are parsed as `domain:name:damage:amount:bool`
    item tokens here."""
    tokens = set()
    sections = digest.split("|")
    for section in sections:
        if not (section.startswith("in=") or section.startswith("out=")):
            continue
        _, _, body = section.partition("=")
        if not body:
            continue
        for item in body.split(","):
            parts = item.split(":")
            if len(parts) < 2:
                continue
            tokens.add(f"{parts[0]}:{parts[1]}")
    return tokens


def parse_digest_fluids(digest):
    """Every fluid name referenced on the `fin=`/`fout=` sides of one digest string (`<name>:<amount>` pairs,
    comma-separated; amount dropped)."""
    tokens = set()
    for section in digest.split("|"):
        if not (section.startswith("fin=") or section.startswith("fout=")):
            continue
        _, _, body = section.partition("=")
        if not body:
            continue
        for fluid in body.split(","):
            name = fluid.rsplit(":", 1)[0] if ":" in fluid else fluid
            if name:
                tokens.add(name)
    return tokens


def known_new_domains():
    return {"materiallib"}


def main():
    fresh_path = Path(sys.argv[1]) if len(sys.argv) > 1 else REPO_ROOT / "run/server/material-dump/recipe-census.json"

    base = load_json(BASELINE_PATH)
    fresh = load_json(fresh_path)

    base_maps = {m["name"]: m for m in base["recipeMaps"]}
    fresh_maps = {m["name"]: m for m in fresh["recipeMaps"]}

    only_base = set(base_maps) - set(fresh_maps)
    only_fresh = set(fresh_maps) - set(base_maps)
    if only_base or only_fresh:
        print(f"MAP SET CHANGED: only in baseline={sorted(only_base)}, only in fresh={sorted(only_fresh)}")

    total_removed_digests = 0
    total_added_digests = 0
    unexplained_retired = {}
    unexplained_new = {}
    net_count_changes = []
    fluid_deltas = {}

    for name in sorted(set(base_maps) & set(fresh_maps)):
        b_digests = base_maps[name]["digests"]
        f_digests = fresh_maps[name]["digests"]
        bc, fc = Counter(b_digests), Counter(f_digests)
        if bc == fc:
            continue

        removed = bc - fc
        added = fc - bc
        n_removed = sum(removed.values())
        n_added = sum(added.values())
        total_removed_digests += n_removed
        total_added_digests += n_added

        removed_tokens = set()
        for d, n in removed.items():
            removed_tokens |= parse_digest_tokens(d)
        added_tokens = set()
        for d, n in added.items():
            added_tokens |= parse_digest_tokens(d)

        retired_tokens = removed_tokens - added_tokens
        new_tokens = added_tokens - removed_tokens

        removed_fluids = set()
        for d in removed:
            removed_fluids |= parse_digest_fluids(d)
        added_fluids = set()
        for d in added:
            added_fluids |= parse_digest_fluids(d)
        fluid_only_removed = removed_fluids - added_fluids
        fluid_only_added = added_fluids - removed_fluids
        if fluid_only_removed or fluid_only_added:
            fluid_deltas[name] = (fluid_only_removed, fluid_only_added)

        for tok in retired_tokens:
            unexplained_retired.setdefault(tok, set()).add(name)

        for tok in new_tokens:
            domain = tok.split(":", 1)[0]
            if domain in known_new_domains():
                continue
            unexplained_new.setdefault(tok, set()).add(name)

        base_count = base_maps[name]["count"]
        fresh_count = fresh_maps[name]["count"]
        if base_count != fresh_count:
            net_count_changes.append((name, base_count, fresh_count, fresh_count - base_count))

    print(f"recipe maps compared: {len(set(base_maps) & set(fresh_maps))}")
    print(f"maps with a digest delta: "
          f"{len([1 for n in base_maps if n in fresh_maps and Counter(base_maps[n]['digests']) != Counter(fresh_maps[n]['digests'])])}")
    print(f"total removed digest instances: {total_removed_digests}, total added: {total_added_digests}")
    print(f"craftingTableMlRecipes: base={base.get('craftingTableMlRecipes')} fresh={fresh.get('craftingTableMlRecipes')}")
    print()
    print(f"maps with a net recipe-count change: {len(net_count_changes)}")
    for name, b, f, delta in net_count_changes:
        print(f"  {name}: {b} -> {f} ({delta:+d})")
    print()
    print(f"retired item/fluid tokens: {len(unexplained_retired)}")
    for tok, maps in sorted(unexplained_retired.items()):
        print(f"  {tok}  (in {len(maps)} map(s): {sorted(maps)[:5]}{'...' if len(maps) > 5 else ''})")
    print()
    print(f"new item/fluid tokens NOT under a known new domain (materiallib): {len(unexplained_new)}")
    for tok, maps in sorted(unexplained_new.items()):
        print(f"  {tok}  (in {len(maps)} map(s): {sorted(maps)[:5]}{'...' if len(maps) > 5 else ''})")
    print()
    print(f"maps with a fin=/fout= fluid-name delta (expected: NONE): {len(fluid_deltas)}")
    for name, (removed_f, added_f) in sorted(fluid_deltas.items()):
        print(f"  {name}: retired={sorted(removed_f)} new={sorted(added_f)}")


if __name__ == "__main__":
    main()
