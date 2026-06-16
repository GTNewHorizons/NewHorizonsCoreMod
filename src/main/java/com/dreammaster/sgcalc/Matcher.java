package com.dreammaster.sgcalc;

import java.util.Locale;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.main.MainRegistry;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.interfaces.IItemContainer;
import gregtech.api.objects.ItemData;
import gregtech.api.util.GTOreDictUnificator;

/**
 * A parsed predicate over an {@link SGItem}, used both for the high-/low-level frontier allowlists and for
 * recipe-selection overrides. Spec grammar: `type:value[:meta][|label[|unit]]` where `type` is one of:
 *
 * - `mod:<modid>:<name>[:<meta>]` -- a specific registered item (meta optional, omitted = any meta) - `gt:<ItemList>`
 * -- a GregTech {@link ItemList} entry - `container:<fully.qualified.Enum.CONSTANT>` -- any {@link IItemContainer} enum
 * constant by name (e.g. a TecTech `CustomItemList` entry), resolved reflectively - `material:<Materials name>` -- any
 * item/fluid associated with that GregTech material; contributes the material amount in litres -
 * `prefixmat:<OrePrefixes>:<Materials name>` -- a specific material form (e.g. `block`, `plateSuperdense`, `nanite`) of
 * a material, counted as items; distinguishes the several Magmatter forms in the high-level table - `fluid:<fluid
 * registry name>` -- a specific fluid - `ore:<ore dictionary name>` -- any item registered under that ore dictionary
 * entry
 *
 * The optional `label` overrides the displayed name and `unit` (e.g. `L`) is rendered as `(unit)` before the name.
 */
public final class Matcher {

    public enum Type {
        MOD,
        GT,
        CONTAINER,
        MATERIAL,
        PREFIXMAT,
        FLUID,
        ORE
    }

    public final Type type;
    public final String value;
    public final String material;
    public final int meta;
    private final String label;
    public final String unit;

    private boolean containerResolved;
    private String containerKey;

    private Matcher(Type type, String value, String material, int meta, String label, String unit) {
        this.type = type;
        this.value = value;
        this.material = material;
        this.meta = meta;
        this.label = label;
        this.unit = unit;
    }

    public static Matcher parse(String spec) {
        String body = spec;
        String label = null;
        String unit = "";
        int bar = spec.indexOf('|');
        if (bar >= 0) {
            body = spec.substring(0, bar);
            String rest = spec.substring(bar + 1);
            int bar2 = rest.indexOf('|');
            if (bar2 >= 0) {
                label = rest.substring(0, bar2);
                unit = rest.substring(bar2 + 1);
            } else {
                label = rest;
            }
        }
        String[] p = body.split(":", -1);
        Type type = Type.valueOf(p[0].trim().toUpperCase(Locale.ROOT));
        if (type == Type.MOD) {
            String value = p[1] + ":" + p[2];
            int meta = p.length > 3 && !p[3].isEmpty() ? Integer.parseInt(p[3].trim()) : -1;
            return new Matcher(type, value, null, meta, label, unit);
        }
        if (type == Type.PREFIXMAT) {
            return new Matcher(type, p[1].trim(), p[2].trim(), -1, label, unit);
        }
        return new Matcher(type, p[1].trim(), null, -1, label, unit);
    }

    public String bucketKey() {
        if (type == Type.PREFIXMAT) return type + ":" + value + ":" + material;
        return type + ":" + value + (meta >= 0 ? ":" + meta : "");
    }

    public boolean matches(SGItem item) {
        switch (type) {
            case MOD -> {
                if (item.stack == null) return false;
                return value.equals(registryName(item.stack)) && (meta < 0 || item.stack.getItemDamage() == meta);
            }
            case GT, CONTAINER -> {
                if (item.stack == null) return false;
                String key = resolveContainerKey();
                return key != null && key.equals(item.key);
            }
            case MATERIAL -> {
                if (item.fluid != null) {
                    Materials m = Materials.getGtMaterialFromFluid(item.fluid.getFluid());
                    return m != null && value.equals(m.mName);
                }
                if (item.stack == null) return false;
                ItemData d = GTOreDictUnificator.getAssociation(item.stack);
                return d != null && d.mMaterial != null
                        && d.mMaterial.mMaterial != null
                        && value.equals(d.mMaterial.mMaterial.mName);
            }
            case PREFIXMAT -> {
                if (item.stack == null) return false;
                ItemData d = GTOreDictUnificator.getAssociation(item.stack);
                return d != null && d.mPrefix != null
                        && d.mMaterial != null
                        && d.mMaterial.mMaterial != null
                        && value.equals(d.mPrefix.toString())
                        && material.equals(d.mMaterial.mMaterial.mName);
            }
            case FLUID -> {
                return item.fluid != null && item.fluid.getFluid() != null
                        && value.equals(item.fluid.getFluid().getName());
            }
            case ORE -> {
                if (item.stack == null) return false;
                int target = OreDictionary.getOreID(value);
                for (int id : OreDictionary.getOreIDs(item.stack)) {
                    if (id == target) return true;
                }
                return false;
            }
        }
        return false;
    }

    public String label(SGItem matched) {
        if (label != null) return label;
        if (type == Type.MATERIAL && !matched.isFluid()) return value;
        return matched.displayName();
    }

    private String resolveContainerKey() {
        if (!containerResolved) {
            containerResolved = true;
            ItemStack s = resolveContainerStack();
            if (s != null) containerKey = SGItem.of(s).key;
        }
        return containerKey;
    }

    /**
     * Resolves a `gt:`/`container:` spec to its {@link ItemStack}. `gt:` names a {@link ItemList} entry; `container:`
     * names any {@link IItemContainer} enum constant by fully-qualified name (e.g.
     * `tectech.thing.CustomItemList.Godforge_StellarEnergySiphonCasing`), resolved reflectively so no mod has to be a
     * compile dependency. Lookups can throw {@link IllegalAccessError} for an unbound entry or other errors for a bad
     * name, so a failure is logged and treated as "no such item" rather than aborting the run.
     */
    private ItemStack resolveContainerStack() {
        try {
            if (type == Type.GT) {
                return ItemList.valueOf(value).get(1L);
            }
            int dot = value.lastIndexOf('.');
            Class<?> enumClass = Class.forName(value.substring(0, dot));
            String constant = value.substring(dot + 1);
            for (Object entry : enumClass.getEnumConstants()) {
                if (((Enum<?>) entry).name().equals(constant)) {
                    return ((IItemContainer) entry).get(1L);
                }
            }
            return null;
        } catch (Throwable t) {
            MainRegistry.LOGGER.warn("sgcalc: could not resolve " + type + " matcher '" + value + "': " + t);
            return null;
        }
    }

    /**
     * Resolves a `mod:`/`gt:`/`container:` spec to a concrete one-count {@link ItemStack}, used for the resolution
     * roots. Other matcher types cannot be turned into a single stack and return null.
     */
    public ItemStack toStack() {
        if (type == Type.MOD) {
            String[] parts = value.split(":", 2);
            net.minecraft.item.Item item = GameRegistry.findItem(parts[0], parts[1]);
            if (item == null) return null;
            return new ItemStack(item, 1, Math.max(0, meta));
        }
        if (type == Type.GT || type == Type.CONTAINER) {
            return resolveContainerStack();
        }
        return null;
    }

    static String registryName(ItemStack stack) {
        Object name = net.minecraft.item.Item.itemRegistry.getNameForObject(stack.getItem());
        return name == null ? "?" : name.toString();
    }
}
