package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.BloodMagic;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.ElectroMagicTools;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.Gadomancy;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.TaintedMagic;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TinkersGregworks;
import static gregtech.api.enums.Mods.UniversalSingularities;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sExtruderRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sPressRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.dreammaster.avaritia.AvaritiaHelper;
import com.dreammaster.thaumcraft.TCHelper;

import fox.spiteful.avaritia.crafting.CompressorManager;
import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GT_Values;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class ScriptAvaritia implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Avaritia";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                AdvancedSolarPanel.ID,
                Avaritia.ID,
                BloodArsenal.ID,
                BloodMagic.ID,
                DraconicEvolution.ID,
                ElectroMagicTools.ID,
                EternalSingularity.ID,
                ExtraUtilities.ID,
                ForbiddenMagic.ID,
                GalaxySpace.ID,
                GraviSuite.ID,
                IndustrialCraft2.ID,
                ThaumicTinkerer.ID,
                TinkerConstruct.ID,
                TinkersGregworks.ID,
                UniversalSingularities.ID,
                Thaumcraft.ID,
                ThaumicBases.ID,
                Gadomancy.ID,
                TaintedMagic.ID);
    }

    @Override
    public void loadRecipes() {

        addShapedRecipe(
                getModItem(Avaritia.ID, "Dire_Crafting", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(Avaritia.ID, "Triple_Craft", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing), "waferAdvanced",
                        getModItem(Avaritia.ID, "Crystal_Matrix", 1, 0, missing), "waferAdvanced",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32642, missing), "circuitElite",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32642, missing) });
        addShapedRecipe(
                getModItem(Avaritia.ID, "Resource", 1, 0, missing),
                new Object[] { "screwDiamond", "plateDiamond", "screwDiamond", "plateDiamond",
                        getModItem(NewHorizonsCoreMod.ID, "item.StainlessSteelBars", 1, 0, missing), "plateDiamond",
                        "screwDiamond", "plateDiamond", "screwDiamond" });

        AvaritiaHelper.removeExtremeCraftingRecipe(getModItem(Avaritia.ID, "Neutron_Collector", 1, 0, missing));
        AvaritiaHelper.removeExtremeCraftingRecipe(getModItem(Avaritia.ID, "Neutronium_Compressor", 1, 0, missing));
        AvaritiaHelper
                .removeExtremeCraftingRecipe(getModItem(EternalSingularity.ID, "eternal_singularity", 1, 0, missing));
        AvaritiaHelper.removeExtremeCraftingRecipe(getModItem(Avaritia.ID, "Orb_Armok", 1, 0, missing));
        AvaritiaHelper.removeExtremeCraftingRecipe(getModItem(Avaritia.ID, "Infinity_Sword", 1, 0, missing));
        AvaritiaHelper.removeExtremeCraftingRecipe(getModItem(Avaritia.ID, "Infinity_Pickaxe", 1, 0, missing));
        AvaritiaHelper.removeExtremeCraftingRecipe(getModItem(Avaritia.ID, "Infinity_Shovel", 1, 0, missing));
        AvaritiaHelper.removeExtremeCraftingRecipe(
                createItemStack(Thaumcraft.ID, "WandCasting", 1, 9000, "{cap:\"matrix\",rod:\"infinity\"}", missing));
        AvaritiaHelper.removeExtremeCraftingRecipe(getModItem(Avaritia.ID, "Infinity_Axe", 1, 0, missing));
        AvaritiaHelper.removeExtremeCraftingRecipe(getModItem(Avaritia.ID, "Infinity_Bow", 1, 0, missing));
        AvaritiaHelper.removeExtremeCraftingRecipe(getModItem(Avaritia.ID, "Infinity_Helm", 1, 0, missing));
        AvaritiaHelper.removeExtremeCraftingRecipe(getModItem(Avaritia.ID, "Infinity_Chest", 1, 0, missing));
        AvaritiaHelper.removeExtremeCraftingRecipe(getModItem(Avaritia.ID, "Infinity_Pants", 1, 0, missing));
        AvaritiaHelper.removeExtremeCraftingRecipe(getModItem(Avaritia.ID, "Infinity_Shoes", 1, 0, missing));
        AvaritiaHelper.removeExtremeCraftingRecipe(getModItem(Avaritia.ID, "Skull_Sword", 1, 0, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(EternalSingularity.ID, "combined_singularity", 1, 0, missing),
                "---------",
                "--aa--a--",
                "-a--b--a-",
                "---cde-a-",
                "--fdgdh--",
                "-a-idj---",
                "-a--k--a-",
                "--a--aa--",
                "---------",
                'a',
                "blockBlackPlutonium",
                'b',
                getModItem(Avaritia.ID, "Singularity", 1, 2, missing),
                'c',
                getModItem(Avaritia.ID, "Singularity", 1, 1, missing),
                'd',
                getModItem(ExtraUtilities.ID, "block_bedrockium", 1, 0, missing),
                'e',
                getModItem(Avaritia.ID, "Singularity", 1, 8, missing),
                'f',
                getModItem(Avaritia.ID, "Singularity", 1, 0, missing),
                'g',
                getModItem(Avaritia.ID, "Singularity", 1, 3, missing),
                'h',
                getModItem(Avaritia.ID, "Singularity", 1, 6, missing),
                'i',
                getModItem(Avaritia.ID, "Singularity", 1, 7, missing),
                'j',
                getModItem(Avaritia.ID, "Singularity", 1, 5, missing),
                'k',
                getModItem(Avaritia.ID, "Singularity", 1, 4, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(EternalSingularity.ID, "combined_singularity", 1, 1, missing),
                "---------",
                "--aa--a--",
                "-a--b--a-",
                "---cde-a-",
                "--fdgdh--",
                "-a-idj---",
                "-a--k--a-",
                "--a--aa--",
                "---------",
                'a',
                "blockBlackPlutonium",
                'b',
                getModItem(Avaritia.ID, "Singularity", 1, 9, missing),
                'c',
                getModItem(Avaritia.ID, "Singularity", 1, 10, missing),
                'd',
                getModItem(ExtraUtilities.ID, "block_bedrockium", 1, 0, missing),
                'e',
                getModItem(UniversalSingularities.ID, "universal.vanilla.singularity", 1, 0, missing),
                'f',
                getModItem(UniversalSingularities.ID, "universal.vanilla.singularity", 1, 2, missing),
                'g',
                getModItem(UniversalSingularities.ID, "universal.vanilla.singularity", 1, 1, missing),
                'h',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 3, missing),
                'i',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 0, missing),
                'j',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 1, missing),
                'k',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 2, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(EternalSingularity.ID, "combined_singularity", 1, 2, missing),
                "---------",
                "--aa--a--",
                "-a--b--a-",
                "---cde-a-",
                "--fdgdh--",
                "-a-idj---",
                "-a--k--a-",
                "--a--aa--",
                "---------",
                'a',
                "blockBlackPlutonium",
                'b',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 4, missing),
                'c',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 5, missing),
                'd',
                getModItem(ExtraUtilities.ID, "block_bedrockium", 1, 0, missing),
                'e',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 6, missing),
                'f',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 7, missing),
                'g',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 8, missing),
                'h',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 9, missing),
                'i',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 10, missing),
                'j',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 11, missing),
                'k',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 12, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(EternalSingularity.ID, "combined_singularity", 1, 3, missing),
                "---------",
                "--aa--a--",
                "-a--b--a-",
                "---cde-a-",
                "--fdgdh--",
                "-a-idj---",
                "-a--k--a-",
                "--a--aa--",
                "---------",
                'a',
                "blockBlackPlutonium",
                'b',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 13, missing),
                'c',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 14, missing),
                'd',
                getModItem(ExtraUtilities.ID, "block_bedrockium", 1, 0, missing),
                'e',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 15, missing),
                'f',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 16, missing),
                'g',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 17, missing),
                'h',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 18, missing),
                'i',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 19, missing),
                'j',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 20, missing),
                'k',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 21, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(EternalSingularity.ID, "combined_singularity", 1, 4, missing),
                "---------",
                "--aa--a--",
                "-a--b--a-",
                "---cde-a-",
                "--fdgdh--",
                "-a-idj---",
                "-a--k--a-",
                "--a--aa--",
                "---------",
                'a',
                "blockBlackPlutonium",
                'b',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 22, missing),
                'c',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 23, missing),
                'd',
                getModItem(ExtraUtilities.ID, "block_bedrockium", 1, 0, missing),
                'e',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 24, missing),
                'f',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 25, missing),
                'g',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 26, missing),
                'h',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 27, missing),
                'i',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 28, missing),
                'j',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 29, missing),
                'k',
                getModItem(UniversalSingularities.ID, "universal.general.singularity", 1, 30, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(EternalSingularity.ID, "combined_singularity", 1, 5, missing),
                "---------",
                "--aa--a--",
                "-a--b--a-",
                "---cde-a-",
                "--fdgdh--",
                "-a-idj---",
                "-a--k--a-",
                "--a--aa--",
                "---------",
                'a',
                "blockBlackPlutonium",
                'b',
                getModItem(UniversalSingularities.ID, "universal.draconicEvolution.singularity", 1, 0, missing),
                'c',
                getModItem(UniversalSingularities.ID, "universal.draconicEvolution.singularity", 1, 1, missing),
                'd',
                getModItem(ExtraUtilities.ID, "block_bedrockium", 1, 0, missing),
                'e',
                getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 0, missing),
                'f',
                getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 1, missing),
                'g',
                getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 2, missing),
                'h',
                getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 3, missing),
                'i',
                getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 4, missing),
                'j',
                getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 5, missing),
                'k',
                getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 6, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(EternalSingularity.ID, "combined_singularity", 1, 6, missing),
                "---------",
                "--aa--a--",
                "-a--b--a-",
                "---cde-a-",
                "--fdgdh--",
                "-a-idj---",
                "-a--k--a-",
                "--a--aa--",
                "---------",
                'a',
                "blockBlackPlutonium",
                'b',
                getModItem(UniversalSingularities.ID, "universal.enderIO.singularity", 1, 7, missing),
                'c',
                getModItem(UniversalSingularities.ID, "universal.extraUtilities.singularity", 1, 0, missing),
                'd',
                getModItem(ExtraUtilities.ID, "block_bedrockium", 1, 0, missing),
                'e',
                getModItem(UniversalSingularities.ID, "universal.projectRed.singularity", 1, 0, missing),
                'f',
                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 0, missing),
                'g',
                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 1, missing),
                'h',
                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 2, missing),
                'i',
                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 3, missing),
                'j',
                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 4, missing),
                'k',
                getModItem(UniversalSingularities.ID, "universal.tinkersConstruct.singularity", 1, 6, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(EternalSingularity.ID, "eternal_singularity", 1, 0, missing),
                "-----a---",
                "--bb--b--",
                "-b--c--b-",
                "a--dae-b-",
                "--aafaa--",
                "-b-gah--a",
                "-b--i--b-",
                "--b--bb--",
                "---a-----",
                'a',
                getModItem(Avaritia.ID, "Resource_Block", 1, 0, missing),
                'b',
                "blockBlackPlutonium",
                'c',
                getModItem(EternalSingularity.ID, "combined_singularity", 1, 0, missing),
                'd',
                getModItem(EternalSingularity.ID, "combined_singularity", 1, 1, missing),
                'e',
                getModItem(EternalSingularity.ID, "combined_singularity", 1, 2, missing),
                'f',
                getModItem(EternalSingularity.ID, "combined_singularity", 1, 3, missing),
                'g',
                getModItem(EternalSingularity.ID, "combined_singularity", 1, 4, missing),
                'h',
                getModItem(EternalSingularity.ID, "combined_singularity", 1, 5, missing),
                'i',
                getModItem(EternalSingularity.ID, "combined_singularity", 1, 6, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(Avaritia.ID, "Orb_Armok", 1, 0, missing),
                "---aaa---",
                "--ababa--",
                "--aacaa--",
                "-dababad-",
                "ddeafagdd",
                "-dddhddd-",
                "---ddd---",
                "---------",
                "---------",
                'a',
                "plateInfinity",
                'b',
                getModItem(ForbiddenMagic.ID, "EldritchOrb", 1, 0, missing),
                'c',
                getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0, missing),
                'd',
                "plateCosmicNeutronium",
                'e',
                getModItem(TaintedMagic.ID, "ItemFocusTime", 1, 0, missing),
                'f',
                getModItem(Avaritia.ID, "Resource", 1, 5, missing),
                'g',
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1, 0, missing),
                'h',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 500, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(Avaritia.ID, "Infinity_Sword", 1, 0, missing),
                "-------ab",
                "------aca",
                "-----ada-",
                "----aea--",
                "-f-aga---",
                "--fha----",
                "--if-----",
                "-i--f----",
                "j--------",
                'a',
                "plateInfinity",
                'b',
                createItemStack(
                        TinkersGregworks.ID,
                        "tGregToolPartLargeSwordBlade",
                        1,
                        1511,
                        "{material:\"Neutronium\"}",
                        missing),
                'c',
                getModItem(TaintedMagic.ID, "ItemPrimordialEdge", 1, 0, missing),
                'd',
                getModItem(IndustrialCraft2.ID, "itemNanoSaber", 1, 32767, missing),
                'e',
                getModItem(ThaumicTinkerer.ID, "ichorSwordGem", 1, 32767, missing),
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 5, missing),
                'g',
                getModItem(Avaritia.ID, "Skull_Sword", 1, 0, missing),
                'h',
                getModItem(DraconicEvolution.ID, "draconicDistructionStaff", 1, 32767, missing),
                'i',
                "blockCosmicNeutronium",
                'j',
                getModItem(Avaritia.ID, "Resource", 1, 5, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                createItemStack(
                        Avaritia.ID,
                        "Infinity_Pickaxe",
                        1,
                        0,
                        "{ench:[0:{lvl:10s,id:35s}],hammer:0b}",
                        missing),
                "-aaaaaaa-",
                "abbcdebba",
                "aa-fgh-aa",
                "----i----",
                "----i----",
                "----i----",
                "----i----",
                "----i----",
                "---jkj---",
                'a',
                "plateInfinity",
                'b',
                createItemStack(
                        TinkersGregworks.ID,
                        "tGregToolPartLargePlate",
                        1,
                        1511,
                        "{material:\"Neutronium\"}",
                        missing),
                'c',
                getModItem(BloodArsenal.ID, "blood_infused_pickaxe_diamond", 1, 32767, missing),
                'd',
                getModItem(DraconicEvolution.ID, "draconicPickaxe", 1, 0, missing),
                'e',
                getModItem(GraviSuite.ID, "advDDrill", 1, 1, missing),
                'f',
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1, 0, missing),
                'g',
                getModItem(ThaumicTinkerer.ID, "ichorPickGem", 1, 32767, missing),
                'h',
                getModItem(TaintedMagic.ID, "ItemFocusTime", 1, 0, missing),
                'i',
                "blockCosmicNeutronium",
                'j',
                getModItem(Avaritia.ID, "big_pearl", 1, 0, missing),
                'k',
                getModItem(Avaritia.ID, "Resource", 1, 5, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                createItemStack(Avaritia.ID, "Infinity_Shovel", 1, 0, "{destroyer:0b}", missing),
                "------aaa",
                "-----abca",
                "------dea",
                "-----f-a-",
                "----f----",
                "---f-----",
                "-gf------",
                "hfi------",
                "jh-------",
                'a',
                "plateInfinity",
                'b',
                getModItem(GraviSuite.ID, "advDDrill", 1, 1, missing),
                'c',
                getModItem(DraconicEvolution.ID, "draconicShovel", 1, 0, missing),
                'd',
                getModItem(ThaumicTinkerer.ID, "ichorShovelGem", 1, 32767, missing),
                'e',
                getModItem(BloodArsenal.ID, "blood_infused_shovel_diamond", 1, 0, missing),
                'f',
                "blockCosmicNeutronium",
                'g',
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1, 0, missing),
                'h',
                getModItem(Avaritia.ID, "big_pearl", 1, 0, missing),
                'i',
                getModItem(TaintedMagic.ID, "ItemFocusTime", 1, 0, missing),
                'j',
                getModItem(Avaritia.ID, "Resource", 1, 5, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                createItemStack(Thaumcraft.ID, "WandCasting", 1, 9000, "{cap:\"matrix\",rod:\"infinity\"}", missing),
                "--a------",
                "-aba-----",
                "acdef----",
                "-aegeh---",
                "--iegej--",
                "---kegea-",
                "----ledma",
                "-----aba-",
                "------a--",
                'a',
                "plateInfinity",
                'b',
                getModItem(ThaumicTinkerer.ID, "blockTalisman", 1, 0, missing),
                'c',
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1, 0, missing),
                'd',
                getModItem(Avaritia.ID, "Resource", 1, 5, missing),
                'e',
                "plateCosmicNeutronium",
                'f',
                getModItem(BloodMagic.ID, "dawnScribeTool", 1, 0, missing),
                'g',
                createItemStack(
                        Thaumcraft.ID,
                        "WandCasting",
                        1,
                        562,
                        "{cap:\"ICHOR\",rod:\"ICHORCLOTH\",sceptre:1b}",
                        missing),
                'h',
                getModItem(BloodMagic.ID, "waterScribeTool", 1, 0, missing),
                'i',
                getModItem(BloodMagic.ID, "duskScribeTool", 1, 0, missing),
                'j',
                getModItem(BloodMagic.ID, "airScribeTool", 1, 0, missing),
                'k',
                getModItem(BloodMagic.ID, "fireScribeTool", 1, 0, missing),
                'l',
                getModItem(BloodMagic.ID, "earthScribeTool", 1, 0, missing),
                'm',
                getModItem(TaintedMagic.ID, "ItemFocusTime", 1, 0, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(Avaritia.ID, "Infinity_Axe", 1, 0, missing),
                "-a-------",
                "abaaa----",
                "acda-----",
                "-ae------",
                "--e------",
                "--e------",
                "--e------",
                "--e------",
                "-fgh-----",
                'a',
                "plateInfinity",
                'b',
                getModItem(GraviSuite.ID, "advChainsaw", 1, 1, missing),
                'c',
                getModItem(ThaumicTinkerer.ID, "ichorAxeGem", 1, 32767, missing),
                'd',
                getModItem(DraconicEvolution.ID, "draconicAxe", 1, 0, missing),
                'e',
                "blockCosmicNeutronium",
                'f',
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1, 0, missing),
                'g',
                getModItem(Avaritia.ID, "Resource", 1, 5, missing),
                'h',
                getModItem(TaintedMagic.ID, "ItemFocusTime", 1, 0, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(Avaritia.ID, "Infinity_Bow", 1, 0, missing),
                "---aab---",
                "--a-c----",
                "-a--c----",
                "a---c----",
                "d---ef---",
                "a---c----",
                "-a--c----",
                "--a-c----",
                "---aab---",
                'a',
                "plateInfinity",
                'b',
                getModItem(TaintedMagic.ID, "ItemFocusMeteorology", 1, 0, missing),
                'c',
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1, missing),
                'd',
                getModItem(Avaritia.ID, "Resource", 1, 5, missing),
                'e',
                getModItem(DraconicEvolution.ID, "draconicBow", 1, 0, missing),
                'f',
                getModItem(TaintedMagic.ID, "ItemFocusTime", 1, 0, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(Avaritia.ID, "Infinity_Helm", 1, 0, missing),
                "--aaaaa--",
                "-abbcbba-",
                "-a-ded-a-",
                "-abfghba-",
                "-abbibba-",
                "-abjklba-",
                "---------",
                "---------",
                "---------",
                'a',
                "plateCosmicNeutronium",
                'b',
                "plateInfinity",
                'c',
                getModItem(AdvancedSolarPanel.ID, "ultimate_solar_helmet", 1, 32767, missing),
                'd',
                getModItem(Avaritia.ID, "Resource", 1, 5, missing),
                'e',
                getModItem(ThaumicTinkerer.ID, "ichorclothHelmGem", 1, 32767, missing),
                'f',
                createItemStack(BloodArsenal.ID, "life_imbued_helmet", 1, 0, "{LPStored:0}", missing),
                'g',
                getModItem(DraconicEvolution.ID, "draconicHelm", 1, 0, missing),
                'h',
                getModItem(BloodMagic.ID, "sanguineHelmet", 1, 0, missing),
                'i',
                getModItem(GalaxySpace.ID, "item.spacesuit_helmetglasses", 1, 0, missing),
                'j',
                getModItem(TaintedMagic.ID, "ItemFocusTime", 1, 0, missing),
                'k',
                getModItem(BloodArsenal.ID, "sigil_of_divinity", 1, 0, missing),
                'l',
                getModItem(ElectroMagicTools.ID, "ShieldFocus", 1, 0, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(Avaritia.ID, "Infinity_Chest", 1, 0, missing),
                "-aa---aa-",
                "aba---aba",
                "abba-abba",
                "-abbcbba-",
                "-abdefba-",
                "-abghiba-",
                "-abjklba-",
                "-abbbbba-",
                "--aaaaa--",
                'a',
                "plateCosmicNeutronium",
                'b',
                "plateInfinity",
                'c',
                getModItem(GraviSuite.ID, "graviChestPlate", 1, 32767, missing),
                'd',
                createItemStack(BloodArsenal.ID, "life_imbued_chestplate", 1, 0, "{LPStored:0}", missing),
                'e',
                getModItem(ThaumicTinkerer.ID, "ichorclothChestGem", 1, 32767, missing),
                'f',
                getModItem(BloodMagic.ID, "sanguineRobe", 1, 0, missing),
                'g',
                getModItem(GalaxySpace.ID, "item.spacesuit_jetplate", 1, 0, missing),
                'h',
                getModItem(Avaritia.ID, "Resource", 1, 5, missing),
                'i',
                getModItem(DraconicEvolution.ID, "draconicChest", 1, 0, missing),
                'j',
                getModItem(ElectroMagicTools.ID, "ShieldFocus", 1, 0, missing),
                'k',
                getModItem(BloodArsenal.ID, "sigil_of_divinity", 1, 0, missing),
                'l',
                getModItem(TaintedMagic.ID, "ItemFocusTime", 1, 0, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(Avaritia.ID, "Infinity_Pants", 1, 0, missing),
                "aaaaaaaaa",
                "abcdefgha",
                "aiiijiiia",
                "aiaakaaia",
                "aia---aia",
                "ala---ala",
                "aia---aia",
                "aia---aia",
                "aaa---aaa",
                'a',
                "plateCosmicNeutronium",
                'b',
                getModItem(TaintedMagic.ID, "ItemFocusTime", 1, 0, missing),
                'c',
                getModItem(GalaxySpace.ID, "item.spacesuit_leg", 1, 0, missing),
                'd',
                createItemStack(BloodArsenal.ID, "life_imbued_leggings", 1, 0, "{LPStored:0}", missing),
                'e',
                getModItem(BloodArsenal.ID, "sigil_of_divinity", 1, 0, missing),
                'f',
                getModItem(ThaumicTinkerer.ID, "ichorclothLegsGem", 1, 32767, missing),
                'g',
                getModItem(IndustrialCraft2.ID, "itemArmorQuantumLegs", 1, 32767, missing),
                'h',
                getModItem(ElectroMagicTools.ID, "ShieldFocus", 1, 0, missing),
                'i',
                "plateInfinity",
                'j',
                getModItem(DraconicEvolution.ID, "draconicLeggs", 1, 0, missing),
                'k',
                getModItem(Avaritia.ID, "Resource", 1, 5, missing),
                'l',
                getModItem(Avaritia.ID, "big_pearl", 1, 0, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(Avaritia.ID, "Infinity_Shoes", 1, 0, missing),
                "---------",
                "---------",
                "-aaa-aaa-",
                "-aba-aba-",
                "-aba-aba-",
                "aaba-abaa",
                "acda-aefa",
                "agha-aija",
                "bbbbkbbbb",
                'a',
                "plateCosmicNeutronium",
                'b',
                "plateInfinity",
                'c',
                getModItem(ThaumicTinkerer.ID, "ichorclothBootsGem", 1, 32767, missing),
                'd',
                getModItem(DraconicEvolution.ID, "draconicBoots", 1, 0, missing),
                'e',
                getModItem(IndustrialCraft2.ID, "itemArmorQuantumBoots", 1, 32767, missing),
                'f',
                createItemStack(BloodArsenal.ID, "life_imbued_boots", 1, 0, "{LPStored:0}", missing),
                'g',
                getModItem(TaintedMagic.ID, "ItemFocusTime", 1, 0, missing),
                'h',
                getModItem(BloodMagic.ID, "sanguineBoots", 1, 0, missing),
                'i',
                getModItem(GalaxySpace.ID, "item.spacesuit_gravityboots", 1, 0, missing),
                'j',
                getModItem(ElectroMagicTools.ID, "ShieldFocus", 1, 0, missing),
                'k',
                getModItem(BloodArsenal.ID, "sigil_of_divinity", 1, 0, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(Avaritia.ID, "Neutron_Collector", 1, 0, missing),
                "abcdedcba",
                "b---c---b",
                "c-f-g-f-c",
                "d-h-g-h-d",
                "eijikijie",
                "d-h-g-h-d",
                "c-f-g-f-c",
                "b---c---b",
                "abcdedcba",
                'a',
                "blockBlackPlutonium",
                'b',
                getModItem(Avaritia.ID, "Resource_Block", 1, 0, missing),
                'c',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 315, missing),
                'd',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 500, missing),
                'e',
                getModItem(Avaritia.ID, "Crystal_Matrix", 1, 0, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32697, missing),
                'g',
                "circuitInfinite",
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32687, missing),
                'i',
                "plateInfinity",
                'j',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32608, missing),
                'k',
                getModItem(Avaritia.ID, "Resource", 1, 5, missing));

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("Avaritia", "Neutron_Collector", 1, 0, missing),
                "abcdedcba",
                "b---c---b",
                "c-f-g-f-c",
                "d-h-g-h-d",
                "eijikijie",
                "d-h-g-h-d",
                "c-f-g-f-c",
                "b---c---b",
                "abcdedcba",
                'a',
                "blockBlackPlutonium",
                'b',
                getModItem("Avaritia", "Resource_Block", 1, 0, missing),
                'c',
                getModItem("TConstruct", "heavyPlate", 1, 315, missing),
                'd',
                getModItem("TConstruct", "heavyPlate", 1, 1671, missing),
                'e',
                getModItem("Avaritia", "Crystal_Matrix", 1, 0, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32697, missing),
                'g',
                "circuitInfinite",
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 32687, missing),
                'i',
                "plateInfinity",
                'j',
                getModItem("gregtech", "gt.metaitem.01", 1, 32608, missing),
                'k',
                getModItem("Avaritia", "Resource", 1, 5, missing));

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(Avaritia.ID, "Neutronium_Compressor", 1, 0, missing),
                "abacdcaba",
                "c-e-f-e-c",
                "dghgfghgd",
                "b-eijie-b",
                "bffjkjffb",
                "b-eijie-b",
                "dghgfghgd",
                "c-e-f-e-c",
                "abacdcaba",
                'a',
                getModItem(Avaritia.ID, "Resource_Block", 1, 0, missing),
                'b',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 500, missing),
                'c',
                getModItem(Avaritia.ID, "Resource", 1, 1, missing),
                'd',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 315, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32647, missing),
                'f',
                createItemStack(
                        TinkersGregworks.ID,
                        "tGregToolPartLargePlate",
                        1,
                        1657,
                        "{material:\"BlackPlutonium\"}",
                        missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32637, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32608, missing),
                'i',
                "circuitInfinite",
                'j',
                "plateNeutronium",
                'k',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 10812, missing));

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("Avaritia", "Neutronium_Compressor", 1, 0, missing),
                "abacdcaba",
                "c-e-f-e-c",
                "dghgfghgd",
                "b-eijie-b",
                "bffjkjffb",
                "b-eijie-b",
                "dghgfghgd",
                "c-e-f-e-c",
                "abacdcaba",
                'a',
                getModItem("Avaritia", "Resource_Block", 1, 0, missing),
                'b',
                getModItem("TConstruct", "heavyPlate", 1, 1671, missing),
                'c',
                getModItem("Avaritia", "Resource", 1, 1, missing),
                'd',
                getModItem("TConstruct", "heavyPlate", 1, 315, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32647, missing),
                'f',
                createItemStack(
                        "TGregworks",
                        "tGregToolPartLargePlate",
                        1,
                        1657,
                        "{material:\"BlackPlutonium\"}",
                        missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 32637, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 32608, missing),
                'i',
                "circuitInfinite",
                'j',
                "plateNeutronium",
                'k',
                getModItem("gregtech", "gt.blockmachines", 1, 10812, missing));

        CompressorManager.addRecipe(
                getModItem(Avaritia.ID, "Resource", 1, 5, missing),
                64,
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2394));

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Avaritia.ID, "Resource", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32309, missing))
                .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(2400).eut(480).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Avaritia.ID, "Resource_Block", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32306, missing))
                .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(4800).eut(480).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Avaritia.ID, "Resource", 4, 0, missing),
                        getModItem(Minecraft.ID, "nether_star", 2, 0, missing))
                .itemOutputs(getModItem(Avaritia.ID, "Resource", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Avaritia.ID, "Resource_Block", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32355, missing))
                .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(1000).eut(524000).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Avaritia.ID, "Resource_Block", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32355, missing))
                .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 6, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(524000).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Avaritia.ID, "Resource", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32350, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 17397, missing)).noFluidInputs()
                .noFluidOutputs().duration(4000).eut(524000).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11397, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32350, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 17397, missing)).noFluidInputs()
                .noFluidOutputs().duration(4000).eut(524000).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Avaritia.ID, "Resource", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32350, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 17982, missing)).noFluidInputs()
                .noFluidOutputs().duration(3000).eut(524000).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11982, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32350, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 17982, missing)).noFluidInputs()
                .noFluidOutputs().duration(3000).eut(524000).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17500, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.StainlessSteelBars", 1, 0, missing))
                .itemOutputs(getModItem(Avaritia.ID, "Resource", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(120).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Avaritia.ID, "Resource", 1, 3, missing))
                .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 2, missing)).outputChances(10000).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);

        TCHelper.removeInfusionRecipe(getModItem(Avaritia.ID, "Akashic_Record", 1, 0, missing));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "AKASHIC",
                getModItem(Avaritia.ID, "Akashic_Record", 1, 0, missing),
                24,
                new AspectList().add(Aspect.getAspect("praecantatio"), 512).add(Aspect.getAspect("cognitio"), 128)
                        .add(Aspect.getAspect("sensus"), 96).add(Aspect.getAspect("luxuria"), 96)
                        .add(Aspect.getAspect("tempus"), 64).add(Aspect.getAspect("terminus"), 128),
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17397, missing),
                new ItemStack[] { getModItem(TaintedMagic.ID, "ItemFocusTime", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "knoseFragment", 1, 6, missing),
                        getModItem(ThaumicBases.ID, "knoseFragment", 1, 6, missing),
                        getModItem(ThaumicBases.ID, "knoseFragment", 1, 6, missing),
                        getModItem(ThaumicBases.ID, "knoseFragment", 1, 6, missing),
                        getModItem(Avaritia.ID, "big_pearl", 1, 0, missing),
                        getModItem(Gadomancy.ID, "BlockKnowledgeBook", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemThaumonomicon", 1, 0, missing),
                        getModItem(TaintedMagic.ID, "ItemFocusMeteorology", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 1, missing),
                        getModItem(Gadomancy.ID, "BlockKnowledgeBook", 1, 0, missing),
                        getModItem(Avaritia.ID, "big_pearl", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "knoseFragment", 1, 6, missing),
                        getModItem(ThaumicBases.ID, "knoseFragment", 1, 6, missing),
                        getModItem(ThaumicBases.ID, "knoseFragment", 1, 6, missing),
                        getModItem(ThaumicBases.ID, "knoseFragment", 1, 6, missing), });
        TCHelper.refreshResearchPages("AKASHIC");
    }
}
