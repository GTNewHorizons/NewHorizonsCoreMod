package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
import WayofTime.alchemicalWizardry.api.bindingRegistry.BindingRegistry;
import WayofTime.alchemicalWizardry.api.items.ShapedBloodOrbRecipe;

import com.dreammaster.bloodmagic.BloodMagicHelper;
import com.dreammaster.tinkersConstruct.TConstructHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptBloodArsenal implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Blood Arsenal";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.BloodArsenal.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("BloodArsenal", "blood_lamp", 1, 0, missing),
                new Object[] { "plateBloodInfusedIron",
                        getModItem("BloodArsenal", "blood_stained_glass", 1, 0, missing), "plateBloodInfusedIron",
                        getModItem("BloodArsenal", "blood_stained_glass", 1, 0, missing),
                        getModItem("minecraft", "redstone_lamp", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_stained_glass", 1, 0, missing), "plateBloodInfusedIron",
                        getModItem("BloodArsenal", "blood_stained_glass", 1, 0, missing), "plateBloodInfusedIron" });

        BloodMagicHelper.removeBindingRecipe(getModItem("BloodArsenal", "bound_sickle", 1, 0, missing));
        BloodMagicHelper.removeBindingRecipe(getModItem("BloodArsenal", "bound_bow", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem("BloodArsenal", "blood_infused_iron_block", 1, 0, missing));
        BloodMagicHelper.removeBindingRecipe(getModItem("BloodArsenal", "bound_igniter", 1, 0, missing));
        BloodMagicHelper.removeBindingRecipe(getModItem("BloodArsenal", "bound_shears", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem("BloodArsenal", "blood_infused_diamond_active", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem("BloodArsenal", "blood_infused_glowstone_dust", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem("BloodArsenal", "soul_fragment", 1, 0, missing));

        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem("BloodArsenal", "blood_infused_pickaxe_wood", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                        'b',
                        getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                        'c',
                        getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                        'd',
                        "screwStainlessSteel",
                        'e',
                        getModItem("BloodArsenal", "blood_infused_stick", 1, 0, missing),
                        'f',
                        "screwStainlessSteel",
                        'g',
                        getModItem("AWWayofTime", "apprenticeBloodOrb", 1, 0, missing),
                        'h',
                        getModItem("BloodArsenal", "blood_infused_stick", 1, 0, missing),
                        'i',
                        "craftingToolScrewdriver"));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem("BloodArsenal", "blood_infused_axe_wood", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                        'b',
                        getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                        'c',
                        "screwStainlessSteel",
                        'd',
                        getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                        'e',
                        getModItem("BloodArsenal", "blood_infused_stick", 1, 0, missing),
                        'f',
                        "craftingToolScrewdriver",
                        'g',
                        "screwStainlessSteel",
                        'h',
                        getModItem("BloodArsenal", "blood_infused_stick", 1, 0, missing),
                        'i',
                        getModItem("AWWayofTime", "apprenticeBloodOrb", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem("BloodArsenal", "blood_infused_shovel_wood", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "screwStainlessSteel",
                        'b',
                        getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                        'c',
                        "screwStainlessSteel",
                        'd',
                        getModItem("AWWayofTime", "apprenticeBloodOrb", 1, 0, missing),
                        'e',
                        getModItem("BloodArsenal", "blood_infused_stick", 1, 0, missing),
                        'f',
                        "craftingToolScrewdriver",
                        'h',
                        getModItem("BloodArsenal", "blood_infused_stick", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem("BloodArsenal", "blood_infused_sword_wood", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "screwStainlessSteel",
                        'b',
                        getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                        'c',
                        "screwStainlessSteel",
                        'd',
                        getModItem("AWWayofTime", "apprenticeBloodOrb", 1, 0, missing),
                        'e',
                        getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                        'f',
                        "craftingToolScrewdriver",
                        'h',
                        getModItem("BloodArsenal", "blood_infused_stick", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem("BloodArsenal", "blood_infused_pickaxe_iron", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                        'b',
                        "ingotBloodInfusedIron",
                        'c',
                        "ingotBloodInfusedIron",
                        'd',
                        "screwBloodInfusedIron",
                        'e',
                        getModItem("BloodArsenal", "blood_infused_pickaxe_wood", 1, 0, missing),
                        'f',
                        "craftingToolScrewdriver",
                        'g',
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        'h',
                        getModItem("AWWayofTime", "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem("BloodArsenal", "blood_infused_axe_iron", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                        'b',
                        "ingotBloodInfusedIron",
                        'c',
                        "screwBloodInfusedIron",
                        'd',
                        getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                        'e',
                        getModItem("BloodArsenal", "blood_infused_axe_wood", 1, 0, missing),
                        'f',
                        "craftingToolScrewdriver",
                        'g',
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        'h',
                        getModItem("AWWayofTime", "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem("BloodArsenal", "blood_infused_shovel_iron", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "screwBloodInfusedIron",
                        'b',
                        getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                        'c',
                        "screwBloodInfusedIron",
                        'd',
                        "craftingToolScrewdriver",
                        'e',
                        getModItem("BloodArsenal", "blood_infused_shovel_wood", 1, 0, missing),
                        'f',
                        "screwBloodInfusedIron",
                        'g',
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        'h',
                        getModItem("AWWayofTime", "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem("BloodArsenal", "blood_infused_sword_iron", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "screwBloodInfusedIron",
                        'b',
                        getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                        'c',
                        "craftingToolScrewdriver",
                        'd',
                        getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                        'e',
                        getModItem("BloodArsenal", "blood_infused_sword_wood", 1, 0, missing),
                        'f',
                        "screwBloodInfusedIron",
                        'g',
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        'h',
                        getModItem("AWWayofTime", "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem("BloodArsenal", "blood_infused_pickaxe_diamond", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "screwTungstenSteel",
                        'b',
                        getModItem("BloodArsenal", "blood_infused_diamond_block", 1, 0, missing),
                        'c',
                        "screwTungstenSteel",
                        'd',
                        "craftingToolScrewdriver",
                        'e',
                        getModItem("BloodArsenal", "blood_infused_pickaxe_iron", 1, 0, missing),
                        'f',
                        getModItem("BloodArsenal", "blood_infused_diamond_bound", 1, 0, missing),
                        'g',
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        'h',
                        getModItem("AWWayofTime", "masterBloodOrb", 1, 0, missing),
                        'i',
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem("BloodArsenal", "blood_infused_axe_diamond", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "screwTungstenSteel",
                        'b',
                        getModItem("BloodArsenal", "blood_infused_diamond_block", 1, 0, missing),
                        'c',
                        "screwTungstenSteel",
                        'd',
                        "craftingToolScrewdriver",
                        'e',
                        getModItem("BloodArsenal", "blood_infused_axe_iron", 1, 0, missing),
                        'f',
                        getModItem("BloodArsenal", "blood_infused_diamond_bound", 1, 0, missing),
                        'g',
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        'h',
                        getModItem("AWWayofTime", "masterBloodOrb", 1, 0, missing),
                        'i',
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem("BloodArsenal", "blood_infused_shovel_diamond", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "screwTungstenSteel",
                        'b',
                        getModItem("BloodArsenal", "blood_infused_diamond_block", 1, 0, missing),
                        'c',
                        "screwTungstenSteel",
                        'd',
                        "craftingToolScrewdriver",
                        'e',
                        getModItem("BloodArsenal", "blood_infused_shovel_iron", 1, 0, missing),
                        'f',
                        getModItem("BloodArsenal", "blood_infused_diamond_bound", 1, 0, missing),
                        'g',
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        'h',
                        getModItem("AWWayofTime", "masterBloodOrb", 1, 0, missing),
                        'i',
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem("BloodArsenal", "blood_infused_sword_diamond", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "screwTungstenSteel",
                        'b',
                        getModItem("BloodArsenal", "blood_infused_diamond_block", 1, 0, missing),
                        'c',
                        "screwTungstenSteel",
                        'd',
                        "craftingToolScrewdriver",
                        'e',
                        getModItem("BloodArsenal", "blood_infused_sword_iron", 1, 0, missing),
                        'f',
                        getModItem("BloodArsenal", "blood_infused_diamond_bound", 1, 0, missing),
                        'g',
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        'h',
                        getModItem("AWWayofTime", "masterBloodOrb", 1, 0, missing),
                        'i',
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem("BloodArsenal", "self_sacrifice_amulet", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                        'b',
                        getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                        'c',
                        getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                        'd',
                        getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                        'e',
                        getModItem("AWWayofTime", "apprenticeBloodOrb", 1, 0, missing),
                        'f',
                        getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                        'g',
                        "gemFlawlessGarnetYellow",
                        'h',
                        getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                        'i',
                        getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem("BloodArsenal", "sacrifice_amulet", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                        'b',
                        getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                        'c',
                        getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                        'd',
                        getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                        'e',
                        getModItem("AWWayofTime", "apprenticeBloodOrb", 1, 0, missing),
                        'f',
                        getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                        'g',
                        "gemFlawlessRuby",
                        'h',
                        getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                        'i',
                        getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem("BloodArsenal", "empowered_sacrifice_amulet", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        'b',
                        getModItem("BloodArsenal", "blood_infused_glowstone_dust", 1, 0, missing),
                        'c',
                        getModItem("AWWayofTime", "runeOfSacrifice", 1, 0, missing),
                        'd',
                        getModItem("AWWayofTime", "runeOfSacrifice", 1, 0, missing),
                        'e',
                        getModItem("BloodArsenal", "sacrifice_amulet", 1, 0, missing),
                        'f',
                        getModItem("BloodArsenal", "blood_infused_glowstone_dust", 1, 0, missing),
                        'g',
                        "gemExquisiteRuby",
                        'h',
                        getModItem("AWWayofTime", "runeOfSacrifice", 1, 0, missing),
                        'i',
                        "stickLongBlaze"));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem("BloodArsenal", "empowered_self_sacrifice_amulet", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        'b',
                        getModItem("BloodArsenal", "blood_infused_glowstone_dust", 1, 0, missing),
                        'c',
                        getModItem("AWWayofTime", "runeOfSelfSacrifice", 1, 0, missing),
                        'd',
                        getModItem("AWWayofTime", "runeOfSelfSacrifice", 1, 0, missing),
                        'e',
                        getModItem("BloodArsenal", "self_sacrifice_amulet", 1, 0, missing),
                        'f',
                        getModItem("BloodArsenal", "blood_infused_glowstone_dust", 1, 0, missing),
                        'g',
                        "gemExquisiteGarnetYellow",
                        'h',
                        getModItem("AWWayofTime", "runeOfSelfSacrifice", 1, 0, missing),
                        'i',
                        "stickLongBlaze"));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem("BloodArsenal", "glass_sacrificial_dagger", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem("BloodArsenal", "glass_shard", 1, 0, missing),
                        'b',
                        getModItem("gregtech", "gt.metaitem.01", 1, 32200, missing),
                        'c',
                        getModItem("BloodArsenal", "glass_shard", 1, 0, missing),
                        'd',
                        getModItem("BloodArsenal", "glass_shard", 1, 0, missing),
                        'e',
                        getModItem("AWWayofTime", "sacrificialKnife", 1, 0, missing),
                        'f',
                        getModItem("BloodArsenal", "glass_shard", 1, 0, missing),
                        'g',
                        getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                        'h',
                        getModItem("AWWayofTime", "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem("TConstruct", "heavyPlate", 1, 251, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem("BloodArsenal", "glass_dagger_of_sacrifice", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem("BloodArsenal", "glass_shard", 1, 0, missing),
                        'b',
                        getModItem("gregtech", "gt.metaitem.01", 1, 32200, missing),
                        'c',
                        getModItem("BloodArsenal", "glass_shard", 1, 0, missing),
                        'd',
                        getModItem("BloodArsenal", "glass_shard", 1, 0, missing),
                        'e',
                        getModItem("AWWayofTime", "daggerOfSacrifice", 1, 0, missing),
                        'f',
                        getModItem("BloodArsenal", "glass_shard", 1, 0, missing),
                        'g',
                        getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                        'h',
                        getModItem("AWWayofTime", "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem("TConstruct", "heavyPlate", 1, 251, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem("BloodArsenal", "vampire_ring", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem("BloodArsenal", "blood_infused_diamond_bound", 1, 0, missing),
                        'b',
                        "wireFineBloodInfusedIron",
                        'd',
                        "wireFineBloodInfusedIron",
                        'e',
                        getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 1, missing),
                        'f',
                        "wireFineBloodInfusedIron",
                        'g',
                        getModItem("AWWayofTime", "masterBloodOrb", 1, 0, missing),
                        'h',
                        "wireFineBloodInfusedIron"));

        AltarRecipeRegistry.registerAltarRecipe(
                getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                getModItem("minecraft", "log", 1, 0, missing),
                2,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                getModItem("minecraft", "log", 1, 1, missing),
                2,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                getModItem("minecraft", "log", 1, 2, missing),
                2,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                getModItem("minecraft", "log", 1, 3, missing),
                2,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                getModItem("minecraft", "log2", 1, 0, missing),
                2,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                getModItem("minecraft", "log2", 1, 1, missing),
                2,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem("BloodArsenal", "blood_stained_glass", 1, 0, missing),
                getModItem("minecraft", "glass", 1, 0, missing),
                1,
                200,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem("BloodArsenal", "blood_stained_ice", 1, 0, missing),
                getModItem("minecraft", "ice", 1, 0, missing),
                1,
                400,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem("BloodArsenal", "blood_stained_ice_packed", 1, 0, missing),
                getModItem("minecraft", "packed_ice", 1, 0, missing),
                1,
                600,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem("BloodArsenal", "blood_infused_iron_block", 1, 0, missing),
                getModItem("minecraft", "iron_block", 1, 0, missing),
                4,
                64000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem("BloodArsenal", "blood_infused_glowstone", 1, 0, missing),
                getModItem("minecraft", "glowstone", 1, 0, missing),
                4,
                28000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem("BloodArsenal", "blood_infused_diamond_active", 1, 0, missing),
                getModItem("BloodArsenal", "blood_infused_diamond_unactive", 1, 0, missing),
                4,
                120000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem("BloodArsenal", "blood_diamond", 1, 0, missing),
                getModItem("gregtech", "gt.metaitem.02", 1, 30500, missing),
                4,
                12000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem("BloodArsenal", "blood_infused_glowstone_dust", 1, 0, missing),
                getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                3,
                7000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                getModItem("witchery", "ingredient", 1, 102, missing),
                2,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem("BloodArsenal", "soul_fragment", 1, 0, missing),
                getModItem("BloodArsenal", "heart", 1, 0, missing),
                4,
                100000,
                20,
                20,
                false);
        BindingRegistry.registerRecipe(
                getModItem("BloodArsenal", "bound_sickle", 1, 0, missing),
                getModItem("Thaumcraft", "ItemHoeElemental", 1, 0, missing));
        BindingRegistry.registerRecipe(
                getModItem("BloodArsenal", "bound_bow", 1, 0, missing),
                getModItem("Thaumcraft", "ItemBowBone", 1, 0, missing));
        BindingRegistry.registerRecipe(
                getModItem("BloodArsenal", "bound_igniter", 1, 0, missing),
                getModItem("Natura", "natura.flintandblaze", 1, 0, missing));
        BindingRegistry.registerRecipe(
                getModItem("BloodArsenal", "bound_shears", 1, 0, missing),
                getModItem("EnderIO", "item.darkSteel_shears", 1, 0, missing));

        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "pickaxeHead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "shovelHead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "hatchetHead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "heavyPlate", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "toughRod", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "toughBinding", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "swordBlade", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "wideGuard", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "handGuard", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "crossbar", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "knifeBlade", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "frypanHead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "signHead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "chiselHead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "broadAxeHead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "excavatorHead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "largeSwordBlade", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "hammerHead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "arrowhead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "ShurikenPart", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "BowLimbPart", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "CrossbowLimbPart", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "CrossbowBodyPart", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "fullGuard", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "scytheBlade", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "binding", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "toolRod", 1, 251, missing));
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_money", 4, 0, missing))
                .itemOutputs(getModItem("BloodArsenal", "blood_money", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_money", 4, 1, missing))
                .itemOutputs(getModItem("BloodArsenal", "blood_money", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_money", 4, 2, missing))
                .itemOutputs(getModItem("BloodArsenal", "blood_money", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_money", 1, 1, missing))
                .itemOutputs(
                        getModItem("BloodArsenal", "blood_money", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_money", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_money", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_money", 1, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).noFluidInputs().noFluidOutputs().duration(400).eut(30)
                .addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_money", 1, 2, missing))
                .itemOutputs(
                        getModItem("BloodArsenal", "blood_money", 1, 1, missing),
                        getModItem("BloodArsenal", "blood_money", 1, 1, missing),
                        getModItem("BloodArsenal", "blood_money", 1, 1, missing),
                        getModItem("BloodArsenal", "blood_money", 1, 1, missing))
                .outputChances(10000, 10000, 10000, 10000).noFluidInputs().noFluidOutputs().duration(400).eut(30)
                .addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_money", 1, 3, missing))
                .itemOutputs(
                        getModItem("BloodArsenal", "blood_money", 1, 2, missing),
                        getModItem("BloodArsenal", "blood_money", 1, 2, missing),
                        getModItem("BloodArsenal", "blood_money", 1, 2, missing),
                        getModItem("BloodArsenal", "blood_money", 1, 2, missing))
                .outputChances(10000, 10000, 10000, 10000).noFluidInputs().noFluidOutputs().duration(400).eut(30)
                .addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing))
                .itemOutputs(getModItem("BloodArsenal", "blood_infused_planks", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 10)).noFluidOutputs().duration(200).eut(120)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing))
                .itemOutputs(getModItem("BloodArsenal", "blood_infused_planks", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 6)).noFluidOutputs().duration(200)
                .eut(120).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing))
                .itemOutputs(getModItem("BloodArsenal", "blood_infused_planks", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).noFluidOutputs().duration(100).eut(120)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_infused_planks", 1, 0, missing))
                .itemOutputs(getModItem("BloodArsenal", "blood_infused_stick", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(8).addTo(sLatheRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_infused_iron", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 2977, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "blood_infused_iron_block", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 9, 2977, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);

    }
}
