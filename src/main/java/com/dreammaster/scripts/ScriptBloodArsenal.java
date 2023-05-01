package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.BloodMagic;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCompressorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCutterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sLatheRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;

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

public class ScriptBloodArsenal implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Blood Arsenal";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                BloodArsenal.ID,
                BloodMagic.ID,
                EnderIO.ID,
                Natura.ID,
                Thaumcraft.ID,
                TinkerConstruct.ID,
                Witchery.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(BloodArsenal.ID, "blood_lamp", 1, 0, missing),
                new Object[] { "plateBloodInfusedIron",
                        getModItem(BloodArsenal.ID, "blood_stained_glass", 1, 0, missing), "plateBloodInfusedIron",
                        getModItem(BloodArsenal.ID, "blood_stained_glass", 1, 0, missing),
                        getModItem(Minecraft.ID, "redstone_lamp", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_stained_glass", 1, 0, missing), "plateBloodInfusedIron",
                        getModItem(BloodArsenal.ID, "blood_stained_glass", 1, 0, missing), "plateBloodInfusedIron" });

        BloodMagicHelper.removeBindingRecipe(getModItem(BloodArsenal.ID, "bound_sickle", 1, 0, missing));
        BloodMagicHelper.removeBindingRecipe(getModItem(BloodArsenal.ID, "bound_bow", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0, missing));
        BloodMagicHelper.removeBindingRecipe(getModItem(BloodArsenal.ID, "bound_igniter", 1, 0, missing));
        BloodMagicHelper.removeBindingRecipe(getModItem(BloodArsenal.ID, "bound_shears", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodArsenal.ID, "blood_infused_diamond_active", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodArsenal.ID, "soul_fragment", 1, 0, missing));

        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodArsenal.ID, "blood_infused_pickaxe_wood", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                        'b',
                        getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                        'c',
                        getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                        'd',
                        "screwStainlessSteel",
                        'e',
                        getModItem(BloodArsenal.ID, "blood_infused_stick", 1, 0, missing),
                        'f',
                        "screwStainlessSteel",
                        'g',
                        getModItem(BloodMagic.ID, "apprenticeBloodOrb", 1, 0, missing),
                        'h',
                        getModItem(BloodArsenal.ID, "blood_infused_stick", 1, 0, missing),
                        'i',
                        "craftingToolScrewdriver"));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodArsenal.ID, "blood_infused_axe_wood", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                        'b',
                        getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                        'c',
                        "screwStainlessSteel",
                        'd',
                        getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                        'e',
                        getModItem(BloodArsenal.ID, "blood_infused_stick", 1, 0, missing),
                        'f',
                        "craftingToolScrewdriver",
                        'g',
                        "screwStainlessSteel",
                        'h',
                        getModItem(BloodArsenal.ID, "blood_infused_stick", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "apprenticeBloodOrb", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodArsenal.ID, "blood_infused_shovel_wood", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "screwStainlessSteel",
                        'b',
                        getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                        'c',
                        "screwStainlessSteel",
                        'd',
                        getModItem(BloodMagic.ID, "apprenticeBloodOrb", 1, 0, missing),
                        'e',
                        getModItem(BloodArsenal.ID, "blood_infused_stick", 1, 0, missing),
                        'f',
                        "craftingToolScrewdriver",
                        'h',
                        getModItem(BloodArsenal.ID, "blood_infused_stick", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodArsenal.ID, "blood_infused_sword_wood", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "screwStainlessSteel",
                        'b',
                        getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                        'c',
                        "screwStainlessSteel",
                        'd',
                        getModItem(BloodMagic.ID, "apprenticeBloodOrb", 1, 0, missing),
                        'e',
                        getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                        'f',
                        "craftingToolScrewdriver",
                        'h',
                        getModItem(BloodArsenal.ID, "blood_infused_stick", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodArsenal.ID, "blood_infused_pickaxe_iron", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                        'b',
                        "ingotBloodInfusedIron",
                        'c',
                        "ingotBloodInfusedIron",
                        'd',
                        "screwBloodInfusedIron",
                        'e',
                        getModItem(BloodArsenal.ID, "blood_infused_pickaxe_wood", 1, 0, missing),
                        'f',
                        "craftingToolScrewdriver",
                        'g',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodArsenal.ID, "blood_infused_axe_iron", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                        'b',
                        "ingotBloodInfusedIron",
                        'c',
                        "screwBloodInfusedIron",
                        'd',
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                        'e',
                        getModItem(BloodArsenal.ID, "blood_infused_axe_wood", 1, 0, missing),
                        'f',
                        "craftingToolScrewdriver",
                        'g',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodArsenal.ID, "blood_infused_shovel_iron", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "screwBloodInfusedIron",
                        'b',
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                        'c',
                        "screwBloodInfusedIron",
                        'd',
                        "craftingToolScrewdriver",
                        'e',
                        getModItem(BloodArsenal.ID, "blood_infused_shovel_wood", 1, 0, missing),
                        'f',
                        "screwBloodInfusedIron",
                        'g',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodArsenal.ID, "blood_infused_sword_iron", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "screwBloodInfusedIron",
                        'b',
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                        'c',
                        "craftingToolScrewdriver",
                        'd',
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                        'e',
                        getModItem(BloodArsenal.ID, "blood_infused_sword_wood", 1, 0, missing),
                        'f',
                        "screwBloodInfusedIron",
                        'g',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodArsenal.ID, "blood_infused_pickaxe_diamond", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "screwTungstenSteel",
                        'b',
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0, missing),
                        'c',
                        "screwTungstenSteel",
                        'd',
                        "craftingToolScrewdriver",
                        'e',
                        getModItem(BloodArsenal.ID, "blood_infused_pickaxe_iron", 1, 0, missing),
                        'f',
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0, missing),
                        'g',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodArsenal.ID, "blood_infused_axe_diamond", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "screwTungstenSteel",
                        'b',
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0, missing),
                        'c',
                        "screwTungstenSteel",
                        'd',
                        "craftingToolScrewdriver",
                        'e',
                        getModItem(BloodArsenal.ID, "blood_infused_axe_iron", 1, 0, missing),
                        'f',
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0, missing),
                        'g',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodArsenal.ID, "blood_infused_shovel_diamond", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "screwTungstenSteel",
                        'b',
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0, missing),
                        'c',
                        "screwTungstenSteel",
                        'd',
                        "craftingToolScrewdriver",
                        'e',
                        getModItem(BloodArsenal.ID, "blood_infused_shovel_iron", 1, 0, missing),
                        'f',
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0, missing),
                        'g',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodArsenal.ID, "blood_infused_sword_diamond", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "screwTungstenSteel",
                        'b',
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0, missing),
                        'c',
                        "screwTungstenSteel",
                        'd',
                        "craftingToolScrewdriver",
                        'e',
                        getModItem(BloodArsenal.ID, "blood_infused_sword_iron", 1, 0, missing),
                        'f',
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0, missing),
                        'g',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodArsenal.ID, "self_sacrifice_amulet", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                        'b',
                        getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                        'c',
                        getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                        'd',
                        getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "apprenticeBloodOrb", 1, 0, missing),
                        'f',
                        getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                        'g',
                        "gemFlawlessGarnetYellow",
                        'h',
                        getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                        'i',
                        getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodArsenal.ID, "sacrifice_amulet", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                        'b',
                        getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                        'c',
                        getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                        'd',
                        getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "apprenticeBloodOrb", 1, 0, missing),
                        'f',
                        getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                        'g',
                        "gemFlawlessRuby",
                        'h',
                        getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                        'i',
                        getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodArsenal.ID, "empowered_sacrifice_amulet", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        'b',
                        getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0, missing),
                        'c',
                        getModItem(BloodMagic.ID, "runeOfSacrifice", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "runeOfSacrifice", 1, 0, missing),
                        'e',
                        getModItem(BloodArsenal.ID, "sacrifice_amulet", 1, 0, missing),
                        'f',
                        getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0, missing),
                        'g',
                        "gemExquisiteRuby",
                        'h',
                        getModItem(BloodMagic.ID, "runeOfSacrifice", 1, 0, missing),
                        'i',
                        "stickLongBlaze"));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodArsenal.ID, "empowered_self_sacrifice_amulet", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        'b',
                        getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0, missing),
                        'c',
                        getModItem(BloodMagic.ID, "runeOfSelfSacrifice", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "runeOfSelfSacrifice", 1, 0, missing),
                        'e',
                        getModItem(BloodArsenal.ID, "self_sacrifice_amulet", 1, 0, missing),
                        'f',
                        getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0, missing),
                        'g',
                        "gemExquisiteGarnetYellow",
                        'h',
                        getModItem(BloodMagic.ID, "runeOfSelfSacrifice", 1, 0, missing),
                        'i',
                        "stickLongBlaze"));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodArsenal.ID, "glass_sacrificial_dagger", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodArsenal.ID, "glass_shard", 1, 0, missing),
                        'b',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32200, missing),
                        'c',
                        getModItem(BloodArsenal.ID, "glass_shard", 1, 0, missing),
                        'd',
                        getModItem(BloodArsenal.ID, "glass_shard", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "sacrificialKnife", 1, 0, missing),
                        'f',
                        getModItem(BloodArsenal.ID, "glass_shard", 1, 0, missing),
                        'g',
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodArsenal.ID, "glass_dagger_of_sacrifice", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodArsenal.ID, "glass_shard", 1, 0, missing),
                        'b',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32200, missing),
                        'c',
                        getModItem(BloodArsenal.ID, "glass_shard", 1, 0, missing),
                        'd',
                        getModItem(BloodArsenal.ID, "glass_shard", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "daggerOfSacrifice", 1, 0, missing),
                        'f',
                        getModItem(BloodArsenal.ID, "glass_shard", 1, 0, missing),
                        'g',
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodArsenal.ID, "vampire_ring", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0, missing),
                        'b',
                        "wireFineBloodInfusedIron",
                        'd',
                        "wireFineBloodInfusedIron",
                        'e',
                        getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 1, missing),
                        'f',
                        "wireFineBloodInfusedIron",
                        'g',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0, missing),
                        'h',
                        "wireFineBloodInfusedIron"));

        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                getModItem(Minecraft.ID, "log", 1, 0, missing),
                2,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                getModItem(Minecraft.ID, "log", 1, 1, missing),
                2,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                getModItem(Minecraft.ID, "log", 1, 2, missing),
                2,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                getModItem(Minecraft.ID, "log", 1, 3, missing),
                2,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                getModItem(Minecraft.ID, "log2", 1, 0, missing),
                2,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                getModItem(Minecraft.ID, "log2", 1, 1, missing),
                2,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodArsenal.ID, "blood_stained_glass", 1, 0, missing),
                getModItem(Minecraft.ID, "glass", 1, 0, missing),
                1,
                200,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodArsenal.ID, "blood_stained_ice", 1, 0, missing),
                getModItem(Minecraft.ID, "ice", 1, 0, missing),
                1,
                400,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodArsenal.ID, "blood_stained_ice_packed", 1, 0, missing),
                getModItem(Minecraft.ID, "packed_ice", 1, 0, missing),
                1,
                600,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0, missing),
                getModItem(Minecraft.ID, "iron_block", 1, 0, missing),
                4,
                64000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodArsenal.ID, "blood_infused_glowstone", 1, 0, missing),
                getModItem(Minecraft.ID, "glowstone", 1, 0, missing),
                4,
                28000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodArsenal.ID, "blood_infused_diamond_active", 1, 0, missing),
                getModItem(BloodArsenal.ID, "blood_infused_diamond_unactive", 1, 0, missing),
                4,
                120000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodArsenal.ID, "blood_diamond", 1, 0, missing),
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 30500, missing),
                4,
                12000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0, missing),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                3,
                7000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                getModItem(Witchery.ID, "ingredient", 1, 102, missing),
                2,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodArsenal.ID, "soul_fragment", 1, 0, missing),
                getModItem(BloodArsenal.ID, "heart", 1, 0, missing),
                4,
                100000,
                20,
                20,
                false);
        BindingRegistry.registerRecipe(
                getModItem(BloodArsenal.ID, "bound_sickle", 1, 0, missing),
                getModItem(Thaumcraft.ID, "ItemHoeElemental", 1, 0, missing));
        BindingRegistry.registerRecipe(
                getModItem(BloodArsenal.ID, "bound_bow", 1, 0, missing),
                getModItem(Thaumcraft.ID, "ItemBowBone", 1, 0, missing));
        BindingRegistry.registerRecipe(
                getModItem(BloodArsenal.ID, "bound_igniter", 1, 0, missing),
                getModItem(Natura.ID, "natura.flintandblaze", 1, 0, missing));
        BindingRegistry.registerRecipe(
                getModItem(BloodArsenal.ID, "bound_shears", 1, 0, missing),
                getModItem(EnderIO.ID, "item.darkSteel_shears", 1, 0, missing));

        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "pickaxeHead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "shovelHead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "hatchetHead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "toughRod", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "toughBinding", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "swordBlade", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "wideGuard", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "handGuard", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "crossbar", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "knifeBlade", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "frypanHead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "signHead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "chiselHead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "broadAxeHead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "excavatorHead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "largeSwordBlade", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "hammerHead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "arrowhead", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "ShurikenPart", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "BowLimbPart", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "fullGuard", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "scytheBlade", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "binding", 1, 251, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "toolRod", 1, 251, missing));
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_money", 4, 0, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_money", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_money", 4, 1, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_money", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_money", 4, 2, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_money", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_money", 1, 1, missing))
                .itemOutputs(
                        getModItem(BloodArsenal.ID, "blood_money", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_money", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_money", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_money", 1, 0, missing))
                .outputChances(10000, 10000, 10000, 10000).noFluidInputs().noFluidOutputs().duration(400).eut(30)
                .addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_money", 1, 2, missing))
                .itemOutputs(
                        getModItem(BloodArsenal.ID, "blood_money", 1, 1, missing),
                        getModItem(BloodArsenal.ID, "blood_money", 1, 1, missing),
                        getModItem(BloodArsenal.ID, "blood_money", 1, 1, missing),
                        getModItem(BloodArsenal.ID, "blood_money", 1, 1, missing))
                .outputChances(10000, 10000, 10000, 10000).noFluidInputs().noFluidOutputs().duration(400).eut(30)
                .addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_money", 1, 3, missing))
                .itemOutputs(
                        getModItem(BloodArsenal.ID, "blood_money", 1, 2, missing),
                        getModItem(BloodArsenal.ID, "blood_money", 1, 2, missing),
                        getModItem(BloodArsenal.ID, "blood_money", 1, 2, missing),
                        getModItem(BloodArsenal.ID, "blood_money", 1, 2, missing))
                .outputChances(10000, 10000, 10000, 10000).noFluidInputs().noFluidOutputs().duration(400).eut(30)
                .addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_infused_planks", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 10)).noFluidOutputs().duration(200).eut(120)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_infused_planks", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 6)).noFluidOutputs().duration(200)
                .eut(120).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_infused_planks", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).noFluidOutputs().duration(100).eut(120)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_infused_planks", 1, 0, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_infused_stick", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(8).addTo(sLatheRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_infused_iron", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2977, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 9, 2977, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);

    }
}
