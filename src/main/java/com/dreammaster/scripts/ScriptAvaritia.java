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
import static gregtech.api.enums.Mods.TaintedMagic;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TinkersGregworks;
import static gregtech.api.enums.Mods.UniversalSingularities;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.recipe.RecipeMaps.extruderRecipes;
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.HOURS;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import com.dreammaster.avaritia.AvaritiaHelper;
import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.thaumcraft.TCHelper;
import com.rwtema.extrautils.ExtraUtils;

import fox.spiteful.avaritia.compat.ticon.Tonkers;
import fox.spiteful.avaritia.crafting.CompressorManager;
import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.recipe.RecipeCategories;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import tconstruct.smeltery.TinkerSmeltery;
import tconstruct.tools.TinkerTools;
import tconstruct.tools.items.Pattern;
import tconstruct.weaponry.TinkerWeaponry;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import vexatos.tgregworks.reference.PartTypes;
import vexatos.tgregworks.util.TGregUtils;

@SuppressWarnings("PointlessArithmeticExpression")
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
                ItemList.Robot_Arm_HV.get(1L),
                getModItem(Avaritia.ID, "Triple_Craft", 1, 0, missing),
                ItemList.Robot_Arm_HV.get(1L),
                "waferAdvanced",
                getModItem(Avaritia.ID, "Crystal_Matrix", 1, 0, missing),
                "waferAdvanced",
                ItemList.Electric_Piston_HV.get(1L),
                "circuitElite",
                ItemList.Electric_Piston_HV.get(1L));
        addShapedRecipe(
                getModItem(Avaritia.ID, "Resource", 1, 0, missing),
                "screwDiamond",
                "plateDiamond",
                "screwDiamond",
                "plateDiamond",
                CustomItemList.StainlessSteelBars.get(1L),
                "plateDiamond",
                "screwDiamond",
                "plateDiamond",
                "screwDiamond");

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
                new ItemStack(TinkerTools.largePlate, 1, Tonkers.neutroniumId));

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
                getModItem(IndustrialCraft2.ID, "itemNanoSaber", 1, wildcard, missing),
                'e',
                getModItem(ThaumicTinkerer.ID, "ichorSwordGem", 1, wildcard, missing),
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 5, missing),
                'g',
                getModItem(Avaritia.ID, "Skull_Sword", 1, 0, missing),
                'h',
                getModItem(DraconicEvolution.ID, "draconicDistructionStaff", 1, wildcard, missing),
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
                TGregUtils.newItemStack(Materials.Neutronium, PartTypes.LargePlate, 1),
                'c',
                getModItem(BloodArsenal.ID, "blood_infused_pickaxe_diamond", 1, wildcard, missing),
                'd',
                getModItem(DraconicEvolution.ID, "draconicPickaxe", 1, 0, missing),
                'e',
                getModItem(GraviSuite.ID, "advDDrill", 1, 1, missing),
                'f',
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1, 0, missing),
                'g',
                getModItem(ThaumicTinkerer.ID, "ichorPickGem", 1, wildcard, missing),
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
                getModItem(ThaumicTinkerer.ID, "ichorShovelGem", 1, wildcard, missing),
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
                getModItem(ThaumicTinkerer.ID, "ichorAxeGem", 1, wildcard, missing),
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
                getModItem(AdvancedSolarPanel.ID, "ultimate_solar_helmet", 1, wildcard, missing),
                'd',
                getModItem(Avaritia.ID, "Resource", 1, 5, missing),
                'e',
                getModItem(ThaumicTinkerer.ID, "ichorclothHelmGem", 1, wildcard, missing),
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
                getModItem(GraviSuite.ID, "graviChestPlate", 1, wildcard, missing),
                'd',
                createItemStack(BloodArsenal.ID, "life_imbued_chestplate", 1, 0, "{LPStored:0}", missing),
                'e',
                getModItem(ThaumicTinkerer.ID, "ichorclothChestGem", 1, wildcard, missing),
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
                getModItem(ThaumicTinkerer.ID, "ichorclothLegsGem", 1, wildcard, missing),
                'g',
                getModItem(IndustrialCraft2.ID, "itemArmorQuantumLegs", 1, wildcard, missing),
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
                getModItem(ThaumicTinkerer.ID, "ichorclothBootsGem", 1, wildcard, missing),
                'd',
                getModItem(DraconicEvolution.ID, "draconicBoots", 1, 0, missing),
                'e',
                getModItem(IndustrialCraft2.ID, "itemArmorQuantumBoots", 1, wildcard, missing),
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
                new ItemStack(TinkerTools.largePlate, 1, ExtraUtils.tcon_bedrock_material_id),
                'd',
                new ItemStack(TinkerTools.largePlate, 1, Tonkers.neutroniumId),
                'e',
                getModItem(Avaritia.ID, "Crystal_Matrix", 1, 0, missing),
                'f',
                ItemList.Sensor_UV.get(1L),
                'g',
                "circuitInfinite",
                'h',
                ItemList.Emitter_UV.get(1L),
                'i',
                "plateInfinity",
                'j',
                ItemList.Electric_Motor_UV.get(1L),
                'k',
                getModItem(Avaritia.ID, "Resource", 1, 5, missing));

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
                new ItemStack(TinkerTools.largePlate, 1, Tonkers.neutroniumId),
                'c',
                getModItem(Avaritia.ID, "Resource", 1, 1, missing),
                'd',
                new ItemStack(TinkerTools.largePlate, 1, ExtraUtils.tcon_bedrock_material_id),
                'e',
                ItemList.Electric_Piston_UV.get(1L),
                'f',
                TGregUtils.newItemStack(Materials.BlackPlutonium, PartTypes.LargePlate, 1),
                'g',
                ItemList.Conveyor_Module_UV.get(1L),
                'h',
                ItemList.Electric_Motor_UV.get(1L),
                'i',
                "circuitInfinite",
                'j',
                "plateNeutronium",
                'k',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 10812, missing));

        CompressorManager.addRecipe(
                getModItem(Avaritia.ID, "Resource", 1, 5, missing),
                64,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfinityCatalyst, 1L));

        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Avaritia.ID, "Resource", 1, 4, missing), ItemList.Shape_Mold_Nugget.get(0L))
                .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 3, missing)).duration(2 * MINUTES).eut(480)
                .addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Avaritia.ID, "Resource_Block", 1, 0, missing), ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 4, missing)).duration(4 * MINUTES).eut(480)
                .addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Avaritia.ID, "Resource", 4, 0, missing),
                        getModItem(Minecraft.ID, "nether_star", 2, 0, missing))
                .itemOutputs(getModItem(Avaritia.ID, "Resource", 1, 1, missing)).duration(1 * MINUTES).eut(480)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Avaritia.ID, "Double_Craft", 1, 0))
                .itemOutputs(new ItemStack(Blocks.crafting_table, 9)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Avaritia.ID, "Triple_Craft", 1, 0))
                .itemOutputs(getModItem(Avaritia.ID, "Double_Craft", 9, 0, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Avaritia.ID, "Crystal_Matrix", 1, 0))
                .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 1, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Avaritia.ID, "Resource_Block", 1, 0, missing),
                        ItemList.Shape_Extruder_Ingot.get(0L))
                .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 4, missing)).duration(50 * SECONDS).eut(524000)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Avaritia.ID, "Resource_Block", 1, 1, missing),
                        ItemList.Shape_Extruder_Ingot.get(0L))
                .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 6, missing)).duration(1 * MINUTES).eut(524000)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Avaritia.ID, "Resource", 1, 6, missing), ItemList.Shape_Extruder_Plate.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Infinity, 1L))
                .duration(3 * MINUTES + 20 * SECONDS).eut(524000).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11397, missing),
                        ItemList.Shape_Extruder_Plate.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Infinity, 1L))
                .duration(3 * MINUTES + 20 * SECONDS).eut(524000).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Avaritia.ID, "Resource", 1, 4, missing), ItemList.Shape_Extruder_Plate.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CosmicNeutronium, 1L))
                .duration(2 * MINUTES + 30 * SECONDS).eut(524000).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11982, missing),
                        ItemList.Shape_Extruder_Plate.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CosmicNeutronium, 1L))
                .duration(2 * MINUTES + 30 * SECONDS).eut(524000).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 4L),
                        CustomItemList.StainlessSteelBars.get(1L))
                .itemOutputs(getModItem(Avaritia.ID, "Resource", 1, 0, missing)).duration(10 * SECONDS).eut(120)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Avaritia.ID, "Resource", 1, 3, missing))
                .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 2, missing)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

        TCHelper.removeInfusionRecipe(getModItem(Avaritia.ID, "Akashic_Record", 1, 0, missing));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "AKASHIC",
                getModItem(Avaritia.ID, "Akashic_Record", 1, 0, missing),
                24,
                new AspectList().add(Aspect.getAspect("praecantatio"), 512).add(Aspect.getAspect("cognitio"), 128)
                        .add(Aspect.getAspect("sensus"), 96).add(Aspect.getAspect("luxuria"), 96)
                        .add(Aspect.getAspect("tempus"), 64).add(Aspect.getAspect("terminus"), 128),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Infinity, 1L),
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

        registerTinkerPartsRecipes();
    }

    private void registerTinkerPartsRecipes() {
        List<TinkerMaterialWrapper> materials = Arrays.asList(
                new TinkerMaterialWrapper(
                        Materials.Iron.getIngots(1),
                        TinkerTools.MaterialID.Iron,
                        3 * MINUTES + 20 * SECONDS + 8 * TICKS,
                        TierEU.RECIPE_LV),
                new TinkerMaterialWrapper(
                        Materials.Obsidian.getIngots(1),
                        TinkerTools.MaterialID.Obsidian,
                        1 * MINUTES + 11 * SECONDS + 12 * TICKS,
                        TierEU.RECIPE_MV),
                new TinkerMaterialWrapper(
                        new ItemStack(Items.netherbrick, 1, 0),
                        TinkerTools.MaterialID.Netherrack,
                        1 * MINUTES + 38 * SECONDS,
                        TierEU.RECIPE_LV),
                new TinkerMaterialWrapper(
                        Materials.Cobalt.getIngots(1),
                        TinkerTools.MaterialID.Cobalt,
                        10 * MINUTES + 40 * SECONDS,
                        TierEU.RECIPE_MV),
                new TinkerMaterialWrapper(
                        Materials.Ardite.getIngots(1),
                        TinkerTools.MaterialID.Ardite,
                        8 * MINUTES + 5 * SECONDS + 4 * TICKS,
                        TierEU.RECIPE_MV),
                new TinkerMaterialWrapper(
                        Materials.Manyullyn.getIngots(1),
                        TinkerTools.MaterialID.Manyullyn,
                        16 * MINUTES,
                        TierEU.RECIPE_MV),
                new TinkerMaterialWrapper(
                        Materials.Copper.getIngots(1),
                        TinkerTools.MaterialID.Copper,
                        2 * MINUTES + 24 * SECONDS,
                        TierEU.RECIPE_LV),
                new TinkerMaterialWrapper(
                        Materials.Bronze.getIngots(1),
                        TinkerTools.MaterialID.Bronze,
                        6 * MINUTES + 24 * SECONDS,
                        TierEU.RECIPE_LV),
                new TinkerMaterialWrapper(
                        Materials.Alumite.getIngots(1),
                        TinkerTools.MaterialID.Alumite,
                        7 * MINUTES + 20 * SECONDS + 8 * TICKS,
                        TierEU.RECIPE_MV),
                new TinkerMaterialWrapper(
                        Materials.Steel.getIngots(1),
                        TinkerTools.MaterialID.Steel,
                        5 * MINUTES + 20 * SECONDS,
                        TierEU.RECIPE_LV),
                new TinkerMaterialWrapper(
                        Materials.PigIron.getIngots(1),
                        TinkerTools.MaterialID.PigIron,
                        8 * MINUTES + 53 * SECONDS + 4 * TICKS,
                        TierEU.RECIPE_LV),
                new TinkerMaterialWrapper(
                        new ItemStack(ExtraUtils.unstableIngot, 1, 0),
                        ExtraUtils.tcon_unstable_material_id,
                        1 * MINUTES + 20 * SECONDS,
                        TierEU.RECIPE_LV),
                new TinkerMaterialWrapper(
                        new ItemStack(ExtraUtils.unstableIngot, 1, 2),
                        ExtraUtils.tcon_unstable_material_id,
                        1 * MINUTES + 20 * SECONDS,
                        TierEU.RECIPE_LV),
                new TinkerMaterialWrapper(
                        Materials.Bedrockium.getIngots(1),
                        ExtraUtils.tcon_bedrock_material_id,
                        1 * HOURS + 40 * MINUTES,
                        TierEU.RECIPE_MV),
                new TinkerMaterialWrapper(
                        new ItemStack(ExtraUtils.decorative1, 1, 8),
                        ExtraUtils.tcon_magical_wood_id,
                        1 * MINUTES + 18 * SECONDS,
                        TierEU.RECIPE_LV),
                new TinkerMaterialWrapper(
                        GT_ModHandler.getModItem(BloodArsenal.ID, "blood_infused_iron", 1L, 0),
                        251, // com.arc.bloodarsenal.common.BloodArsenalConfig.bloodInfusedIronID
                        24 * MINUTES,
                        TierEU.RECIPE_LV),
                new TinkerMaterialWrapper(
                        Materials.CosmicNeutronium.getIngots(1),
                        Tonkers.neutroniumId,
                        40 * SECONDS,
                        TierEU.RECIPE_ZPM),
                new TinkerMaterialWrapper(
                        Materials.Infinity.getIngots(1),
                        Tonkers.infinityMetalId,
                        10 * MINUTES + 40 * SECONDS,
                        TierEU.RECIPE_ZPM));

        // List of Pair<Pattern item, Tool item>
        List<Pair<ItemStack, Item>> patterns = Arrays.asList(
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 1), TinkerTools.toolRod),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 2), TinkerTools.pickaxeHead),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 3), TinkerTools.shovelHead),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 4), TinkerTools.hatchetHead),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 5), TinkerTools.swordBlade),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 6), TinkerTools.wideGuard),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 7), TinkerTools.handGuard),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 8), TinkerTools.crossbar),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 9), TinkerTools.binding),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 10), TinkerTools.frypanHead),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 11), TinkerTools.signHead),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 12), TinkerTools.knifeBlade),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 13), TinkerTools.chiselHead),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 14), TinkerTools.toughRod),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 15), TinkerTools.toughBinding),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 16), TinkerTools.largePlate),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 17), TinkerTools.broadAxeHead),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 18), TinkerTools.scytheBlade),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 19), TinkerTools.excavatorHead),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 20), TinkerTools.largeSwordBlade),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 21), TinkerTools.hammerHead),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 22), TinkerTools.fullGuard),
                ImmutablePair.of(new ItemStack(TinkerSmeltery.metalPattern, 0, 25), TinkerWeaponry.arrowhead),
                ImmutablePair.of(new ItemStack(TinkerWeaponry.metalPattern, 0, 0), TinkerWeaponry.partShuriken),
                ImmutablePair.of(new ItemStack(TinkerWeaponry.metalPattern, 0, 1), TinkerWeaponry.partCrossbowLimb),
                ImmutablePair.of(new ItemStack(TinkerWeaponry.metalPattern, 0, 2), TinkerWeaponry.partCrossbowBody),
                ImmutablePair.of(new ItemStack(TinkerWeaponry.metalPattern, 0, 3), TinkerWeaponry.partBowLimb));

        for (Pair<ItemStack, Item> pattern : patterns) {
            ItemStack patternItem = pattern.getLeft();
            Item toolItem = pattern.getRight();
            if (!(patternItem.getItem() instanceof Pattern)) throw new RuntimeException();
            int cost = ((Pattern) patternItem.getItem()).getPatternCost(patternItem);
            for (TinkerMaterialWrapper material : materials) {
                if (material.ingot == null) continue;
                ItemStack input = material.ingot.copy();
                input.stackSize = (int) Math.ceil((float) cost / 2);
                GT_Values.RA.stdBuilder().itemInputs(input, patternItem)
                        .itemOutputs(new ItemStack(toolItem, 1, material.materialId))
                        .recipeCategory(RecipeCategories.ticPartExtruding)
                        .duration(Math.min((long) material.durationPer16 * cost / 16, Integer.MAX_VALUE))
                        .eut(material.voltage).addTo(extruderRecipes);
            }
        }
    }

    private static class TinkerMaterialWrapper {

        private final ItemStack ingot;
        private final int materialId;
        private final int durationPer16;
        private final long voltage;

        private TinkerMaterialWrapper(ItemStack ingot, int materialId, int durationPer16, long voltage) {
            this.ingot = ingot;
            this.materialId = materialId;
            this.durationPer16 = durationPer16;
            this.voltage = voltage;
        }
    }
}
