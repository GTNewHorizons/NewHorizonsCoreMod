package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.Botany;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.EtFuturumRequiem;
import static gregtech.api.enums.Mods.ExtraBees;
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.Gendustry;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.MCFrames;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.ProjectRedCore;
import static gregtech.api.enums.Mods.ProjectRedExpansion;
import static gregtech.api.enums.Mods.ProjectRedExploration;
import static gregtech.api.enums.Mods.ProjectRedFabrication;
import static gregtech.api.enums.Mods.ProjectRedIntegration;
import static gregtech.api.enums.Mods.ProjectRedTransmission;
import static gregtech.api.enums.Mods.ProjectRedTransportation;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.ThaumicHorizons;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.cannerRecipes;
import static gregtech.api.recipe.RecipeMaps.chemicalBathRecipes;
import static gregtech.api.recipe.RecipeMaps.circuitAssemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static gregtech.api.recipe.RecipeMaps.laserEngraverRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.recipe.RecipeMaps.packagerRecipes;
import static gregtech.api.recipe.RecipeMaps.unpackagerRecipes;
import static gregtech.api.recipe.RecipeMaps.wiremillRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.chisel.ChiselHelper;
import com.dreammaster.item.NHItemList;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gtPlusPlus.core.material.MaterialsAlloy;
import mrtjp.projectred.ProjectRedCore;
import mrtjp.projectred.ProjectRedExploration;

public class ScriptProjectRed implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Project Red";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                BiomesOPlenty.ID,
                Botania.ID,
                Botany.ID,
                BuildCraftFactory.ID,
                EtFuturumRequiem.ID,
                ExtraBees.ID,
                ForbiddenMagic.ID,
                Forestry.ID,
                GalacticraftAmunRa.ID,
                Gendustry.ID,
                IndustrialCraft2.ID,
                MCFrames.ID,
                Natura.ID,
                OpenBlocks.ID,
                OpenComputers.ID,
                PamsHarvestCraft.ID,
                ProjectRedCore.ID,
                ProjectRedExploration.ID,
                ProjectRedTransmission.ID,
                ProjectRedTransportation.ID,
                ProjectRedExpansion.ID,
                ProjectRedFabrication.ID,
                Railcraft.ID,
                StevesCarts2.ID,
                ThaumicHorizons.ID,
                TinkerConstruct.ID);
    }

    // This should ideally be shared somewhere; pending more cleanup/rewrite.
    private static final Materials[] solderingMaterials = new Materials[] { Materials.SolderingAlloy, Materials.Tin,
            Materials.Lead };

    /**
     * Gives a FluidStack of soldering material of appropriate size.
     *
     * @param material   Material to use. Must be one of {@link #solderingMaterials}.
     * @param baseAmount Amount of soldering alloy to use. Tin is 2x, Lead is 4x this amount.
     * @return FluidStack of the appropriate material and amount.
     */
    private static FluidStack getSolderingFluid(Materials material, long baseAmount) {
        if (material.contains(SubTag.SOLDERING_MATERIAL_GOOD)) return material.getMolten(baseAmount);
        if (material.contains(SubTag.SOLDERING_MATERIAL_BAD)) return material.getMolten(baseAmount * 4);
        if (material.contains(SubTag.SOLDERING_MATERIAL)) return material.getMolten(baseAmount * 2);
        return null;
    }

    @Override
    public void loadRecipes() {
        craftingRecipes();

        recipes1();
        circuitAssemblerRecipes();
        recipes2();

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(ProjectRedFabrication.ID, "projectred.fabrication.icchip", 1, 1),
                "aaaaaaaaa",
                "abbbbbbba",
                "abcccccba",
                "abcdedcba",
                "abcefecba",
                "abcdedcba",
                "abcccccba",
                "abbbbbbba",
                "aaaaaaaaa",
                'a',
                "plateNeutronium",
                'b',
                "circuitMaster",
                'c',
                "circuitUltimate",
                'd',
                "circuitSuperconductor",
                'e',
                "circuitInfinite",
                'f',
                getModItem(OpenComputers.ID, "item", 1, 43));

        ChiselHelper.addGroup("ruby");
        ChiselHelper.addGroup("sapphire");
        ChiselHelper.addGroup("peridot");
        ChiselHelper.addVariationFromStack("ruby", getModItem(BiomesOPlenty.ID, "gemOre", 1, 3));
        ChiselHelper.addVariationFromStack("ruby", new ItemStack(GregTechAPI.sBlockGem2, 1, 11));
        ChiselHelper.addVariationFromStack(
                "ruby",
                getModItem(ProjectRedExploration.ID, "projectred.exploration.stone", 1, 5));
        ChiselHelper.addVariationFromStack("sapphire", getModItem(BiomesOPlenty.ID, "gemOre", 1, 13));
        ChiselHelper.addVariationFromStack("sapphire", new ItemStack(GregTechAPI.sBlockGem2, 1, 12));
        ChiselHelper.addVariationFromStack(
                "sapphire",
                getModItem(ProjectRedExploration.ID, "projectred.exploration.stone", 1, 6));
        ChiselHelper.addVariationFromStack("peridot", getModItem(BiomesOPlenty.ID, "gemOre", 1, 5));
        ChiselHelper
                .addVariationFromStack("peridot", GTOreDictUnificator.get(OrePrefixes.block, Materials.Olivine, 1L));
        ChiselHelper.addVariationFromStack(
                "peridot",
                getModItem(ProjectRedExploration.ID, "projectred.exploration.stone", 1, 7));

    }

    private void craftingRecipes() {
        addShapedRecipe(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine1", 1, 1),
                getModItem(Minecraft.ID, "brick_block", 1, 0),
                getModItem(Minecraft.ID, "brick_block", 1, 0),
                getModItem(Minecraft.ID, "brick_block", 1, 0),
                "itemCasingSteel",
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.emptybattery", 1, 0),
                "itemCasingSteel",
                "circuitBasic",
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.emptybattery", 1, 0),
                "circuitBasic");
        addShapedRecipe(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 0),
                "itemCasingSteel",
                ItemList.Electric_Motor_LV.get(1L),
                "itemCasingSteel",
                NHItemList.DiamondDrillTip.getIS(1),
                getModItem(IndustrialCraft2.ID, "blockMiningPipe", 1, 0),
                "circuitBasic",
                "itemCasingSteel",
                "gearSteel",
                "itemCasingSteel");
        addShapelessRecipe(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 0),
                getModItem(OpenBlocks.ID, "blockbreaker", 1, 0));
        addShapedRecipe(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 1),
                "itemCasingSteel",
                ItemList.Electric_Motor_LV.get(1L),
                "itemCasingSteel",
                "circuitBasic",
                "pipeMediumTin",
                ItemList.Conveyor_Module_LV.get(1L),
                "itemCasingSteel",
                "craftingPiston",
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 2),
                "itemCasingSteel",
                ItemList.Electric_Motor_LV.get(1L),
                "itemCasingSteel",
                ItemList.Conveyor_Module_LV.get(1L),
                "pipeMediumTin",
                "circuitBasic",
                "itemCasingSteel",
                "craftingPiston",
                "itemCasingSteel");
        addShapelessRecipe(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 2),
                getModItem(OpenBlocks.ID, "blockPlacer", 1, 0));
        addShapedRecipe(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 3),
                "itemCasingAluminium",
                ItemList.Electric_Motor_MV.get(1L),
                "itemCasingAluminium",
                "circuitGood",
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 1),
                ItemList.Conveyor_Module_MV.get(1L),
                "itemCasingAluminium",
                "craftingFilter",
                "itemCasingAluminium");
        addShapedRecipe(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 4),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 7),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 7),
                "circuitBasic",
                getModItem(Minecraft.ID, "flint_and_steel", 1, 0),
                ItemList.Conveyor_Module_LV.get(1L),
                "itemCasingSteel",
                "craftingPiston",
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 5),
                "plateSteel",
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.emptybattery", 1, 0),
                "plateSteel",
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.emptybattery", 1, 0),
                ItemList.Hull_LV.get(1L),
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.emptybattery", 1, 0),
                "plateSteel",
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.emptybattery", 1, 0),
                "plateSteel");
        addShapelessRecipe(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.solar_panel", 1, 0),
                ItemList.Cover_SolarPanel.get(1L));
        addShapelessRecipe(
                getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 1L));
        addShapedRecipe(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.sawgold", 1, 0),
                "stickWood",
                "stickSteel",
                "stickSteel",
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.toolHeadSaw, Materials.Gold, 1L),
                "stickSteel",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.sawruby", 1, 0),
                "stickWood",
                "stickSteel",
                "stickSteel",
                "stickWood",
                NHItemList.SawBladeRuby.getIS(1),
                "stickSteel",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.sawsapphire", 1, 0),
                "stickWood",
                "stickSteel",
                "stickSteel",
                "stickWood",
                NHItemList.SawBladeSapphire.getIS(1),
                "stickSteel",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.sawperidot", 1, 0),
                "stickWood",
                "stickSteel",
                "stickSteel",
                "stickWood",
                NHItemList.SawBladePeridot.getIS(1),
                "stickSteel",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.rubyboots", 1, 0),
                "plateRuby",
                null,
                "plateRuby",
                "plateRuby",
                "craftingToolHardHammer",
                "plateRuby",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.rubychestplate", 1, 0),
                "plateRuby",
                "craftingToolHardHammer",
                "plateRuby",
                "plateRuby",
                "plateRuby",
                "plateRuby",
                "plateRuby",
                "plateRuby",
                "plateRuby");
        addShapedRecipe(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.rubyhelmet", 1, 0),
                "plateRuby",
                "plateRuby",
                "plateRuby",
                "plateRuby",
                "craftingToolHardHammer",
                "plateRuby",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.rubyleggings", 1, 0),
                "plateRuby",
                "plateRuby",
                "plateRuby",
                "plateRuby",
                "craftingToolHardHammer",
                "plateRuby",
                "plateRuby",
                null,
                "plateRuby");
        addShapedRecipe(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.sapphireboots", 1, 0),
                "plateSapphire",
                null,
                "plateSapphire",
                "plateSapphire",
                "craftingToolHardHammer",
                "plateSapphire",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.sapphirechestplate", 1, 0),
                "plateSapphire",
                "craftingToolHardHammer",
                "plateSapphire",
                "plateSapphire",
                "plateSapphire",
                "plateSapphire",
                "plateSapphire",
                "plateSapphire",
                "plateSapphire");
        addShapedRecipe(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.sapphirehelmet", 1, 0),
                "plateSapphire",
                "plateSapphire",
                "plateSapphire",
                "plateSapphire",
                "craftingToolHardHammer",
                "plateSapphire",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.sapphireleggings", 1, 0),
                "plateSapphire",
                "plateSapphire",
                "plateSapphire",
                "plateSapphire",
                "craftingToolHardHammer",
                "plateSapphire",
                "plateSapphire",
                null,
                "plateSapphire");
        addShapedRecipe(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.peridotboots", 1, 0),
                "plateOlivine",
                null,
                "plateOlivine",
                "plateOlivine",
                "craftingToolHardHammer",
                "plateOlivine",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.peridotchestplate", 1, 0),
                "plateOlivine",
                "craftingToolHardHammer",
                "plateOlivine",
                "plateOlivine",
                "plateOlivine",
                "plateOlivine",
                "plateOlivine",
                "plateOlivine",
                "plateOlivine");
        addShapedRecipe(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.peridothelmet", 1, 0),
                "plateOlivine",
                "plateOlivine",
                "plateOlivine",
                "plateOlivine",
                "craftingToolHardHammer",
                "plateOlivine",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.peridotleggings", 1, 0),
                "plateOlivine",
                "plateOlivine",
                "plateOlivine",
                "plateOlivine",
                "craftingToolHardHammer",
                "plateOlivine",
                "plateOlivine",
                null,
                "plateOlivine");
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 44),
                "wireGt01Gold",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 0),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 0),
                "wireGt01Gold",
                "circuitPrimitive",
                "wireGt01Gold",
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel");
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.screwdriver", 1, 0),
                null,
                "craftingToolFile",
                "stickSteel",
                "stickAnyRubber",
                "stickSteel",
                "craftingToolHardHammer",
                "stickAnyRubber",
                "stickAnyRubber",
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.wiredebugger", 1, 0),
                "wireGt01RedAlloy",
                "stickSteelMagnetic",
                "wireGt01RedAlloy",
                "itemCasingSteel",
                "plateGlowstone",
                "itemCasingSteel",
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel");
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 0),
                null,
                "craftingToolFile",
                null,
                "stickIron",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                "stickIron",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 0),
                null,
                "craftingToolFile",
                null,
                "stickIron",
                "paneGlass",
                "stickIron",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 0),
                null,
                "craftingToolFile",
                null,
                "stickIron",
                "plateGlass",
                "stickIron",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 2, 0),
                null,
                "craftingToolFile",
                null,
                "stickLongIron",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                "stickLongIron",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 2, 0),
                null,
                "craftingToolFile",
                null,
                "stickLongIron",
                "paneGlass",
                "stickLongIron",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 2, 0),
                null,
                "craftingToolFile",
                null,
                "stickLongIron",
                "plateGlass",
                "stickLongIron",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 4, 0),
                null,
                "craftingToolFile",
                null,
                "stickSteel",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                "stickSteel",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 4, 0),
                null,
                "craftingToolFile",
                null,
                "stickSteel",
                "paneGlass",
                "stickSteel",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 4, 0),
                null,
                "craftingToolFile",
                null,
                "stickSteel",
                "plateGlass",
                "stickSteel",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 8, 0),
                null,
                "craftingToolFile",
                null,
                "stickLongSteel",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                "stickLongSteel",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 8, 0),
                null,
                "craftingToolFile",
                null,
                "stickLongSteel",
                "paneGlass",
                "stickLongSteel",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 8, 0),
                null,
                "craftingToolFile",
                null,
                "stickLongSteel",
                "plateGlass",
                "stickLongSteel",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 0),
                null,
                "craftingToolFile",
                null,
                "stickAluminium",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                "stickAluminium",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 0),
                null,
                "craftingToolFile",
                null,
                "stickAluminium",
                "paneGlass",
                "stickAluminium",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 0),
                null,
                "craftingToolFile",
                null,
                "stickAluminium",
                "plateGlass",
                "stickAluminium",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 32, 0),
                null,
                "craftingToolFile",
                null,
                "stickLongAluminium",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                "stickLongAluminium",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 32, 0),
                null,
                "craftingToolFile",
                null,
                "stickLongAluminium",
                "paneGlass",
                "stickLongAluminium",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 32, 0),
                null,
                "craftingToolFile",
                null,
                "stickLongAluminium",
                "plateGlass",
                "stickLongAluminium",
                null,
                "craftingToolSaw",
                null);
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 4, 1),
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 0),
                "stickSteel",
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 0),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 33),
                "gearSteel",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 32),
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 0),
                "stickSteel",
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 0));
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 2),
                "screwIron",
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 1),
                "screwIron",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                ItemList.Circuit_Board_Coated_Basic.get(1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                "screwIron",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Redstone, 1L),
                "screwIron");
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 4),
                "screwSteel",
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 1),
                "screwSteel",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                ItemList.Circuit_Board_Coated_Basic.get(1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "screwSteel",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Redstone, 1L),
                "screwSteel");
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 1, 0),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 20),
                "wireGt01RedAlloy",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 20),
                "plateCopper",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 44),
                "circuitBasic",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 20),
                "wireGt01RedAlloy",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 20));
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 1, 1),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 20),
                "wireGt01RedAlloy",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 28),
                "plateBronze",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 44),
                "circuitBasic",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 20),
                "wireGt01RedAlloy",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 28));
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 1, 2),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 32),
                "wireGt01RedAlloy",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 32),
                "plateIron",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 44),
                "circuitBasic",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 32),
                "wireGt01RedAlloy",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 32));
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 1, 3),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 29),
                "wireGt01RedAlloy",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 26),
                "plateTin",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 44),
                "circuitBasic",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 29),
                "wireGt01RedAlloy",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 26));
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 1, 4),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 28),
                "wireGt01RedAlloy",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 28),
                "plateSteel",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 44),
                "circuitBasic",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 28),
                "wireGt01RedAlloy",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 28));
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 1, 5),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 21),
                "wireGt01RedAlloy",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 21),
                "plateGold",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 44),
                "circuitBasic",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 21),
                "wireGt01RedAlloy",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 21));
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 1, 6),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 30),
                "wireGt01RedAlloy",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 30),
                "plateCobaltBrass",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 44),
                "circuitBasic",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 30),
                "wireGt01RedAlloy",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 30));
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 1, 7),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 24),
                "wireGt01RedAlloy",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 24),
                "plateGlowstone",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 44),
                "circuitBasic",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 24),
                "wireGt01RedAlloy",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 24));
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 1, 8),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 33),
                "wireGt01RedAlloy",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 33),
                "plateSilver",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 44),
                "circuitBasic",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 33),
                "wireGt01RedAlloy",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 33));
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routerutil", 1, 0),
                "wireGt01RedAlloy",
                "itemCasingSteel",
                "wireGt01RedAlloy",
                "circuitBasic",
                "plateEmerald",
                "circuitBasic",
                "itemCasingSteel",
                createItemStack(GregTech.ID, "gt.metaitem.01", 1, 32510, "{GT.ItemCharge:18000L}", missing),
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routerutil", 1, 0),
                "wireGt01RedAlloy",
                "itemCasingSteel",
                "wireGt01RedAlloy",
                "circuitBasic",
                "plateEmerald",
                "circuitBasic",
                "itemCasingSteel",
                createItemStack(GregTech.ID, "gt.metaitem.01", 1, 32511, "{GT.ItemCharge:32000L}", missing),
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routerutil", 1, 0),
                "wireGt01RedAlloy",
                "itemCasingSteel",
                "wireGt01RedAlloy",
                "circuitBasic",
                "plateEmerald",
                "circuitBasic",
                "itemCasingSteel",
                createItemStack(GregTech.ID, "gt.metaitem.01", 1, 32517, "{GT.ItemCharge:75000L}", missing),
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routerutil", 1, 0),
                "wireGt01RedAlloy",
                "itemCasingSteel",
                "wireGt01RedAlloy",
                "circuitBasic",
                "plateEmerald",
                "circuitBasic",
                "itemCasingSteel",
                createItemStack(GregTech.ID, "gt.metaitem.01", 1, 32518, "{GT.ItemCharge:100000L}", missing),
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routerutil", 1, 0),
                "wireGt01RedAlloy",
                "itemCasingSteel",
                "wireGt01RedAlloy",
                "circuitBasic",
                "plateEmerald",
                "circuitBasic",
                "itemCasingSteel",
                createItemStack(GregTech.ID, "gt.metaitem.01", 1, 32519, "{GT.ItemCharge:50000L}", missing),
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.jetpack", 1, 6400),
                "circuitBasic",
                "wireGt04Gold",
                "circuitBasic",
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.emptybattery", 1, 0),
                getModItem(Minecraft.ID, "diamond_chestplate", 1, 0),
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.emptybattery", 1, 0),
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.emptybattery", 1, 0),
                "plateGlowstone",
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.emptybattery", 1, 0));
        addShapedRecipe(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 6),
                "wireGt04Copper",
                "plateSteel",
                "wireGt04Copper",
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.emptybattery", 1, 0),
                ItemList.Hull_LV.get(1L),
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.emptybattery", 1, 0),
                "circuitBasic",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 16),
                "circuitBasic");
        addShapedRecipe(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 8),
                "circuitBasic",
                "plateSteel",
                "circuitBasic",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 16),
                ItemList.Hull_LV.get(1L),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 16),
                "wireGt04Copper",
                ItemList.Electric_Motor_LV.get(1L),
                "wireGt04Copper");
        addShapedRecipe(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 9),
                "plateSteel",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 59),
                "plateSteel",
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 16),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 16),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 18),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 59),
                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 18));
        addShapedRecipe(
                getModItem(ProjectRedFabrication.ID, "projectred.integration.icblock", 1, 0),
                "plateSteel",
                "plateSteel",
                "plateSteel",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(ProjectRedFabrication.ID, "projectred.integration.icblock", 1, 1),
                "blockGlass",
                "blockGlass",
                "blockGlass",
                "plateObsidian",
                "stickSteel",
                "plateObsidian",
                "stickSteel",
                ItemList.Machine_LV_Printer.get(1L),
                "stickSteel");
        addShapelessRecipe(
                getModItem(MCFrames.ID, "mcframes.frame", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L));
        addShapelessRecipe(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 10),
                getModItem(Forestry.ID, "factory2", 1, 2));
        addShapelessRecipe(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 11),
                getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0));
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 19),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "dye", 1, 15),
                getModItem(Minecraft.ID, "dye", 1, 15),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 19),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(BiomesOPlenty.ID, "misc", 1, 8),
                getModItem(BiomesOPlenty.ID, "misc", 1, 8),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 19),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ExtraBees.ID, "misc", 1, 23),
                getModItem(ExtraBees.ID, "misc", 1, 23),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 19),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Botany.ID, "pigment", 1, 77),
                getModItem(Botany.ID, "pigment", 1, 77),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 19),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                ItemList.Color_15.get(1L),
                ItemList.Color_15.get(1L),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 19),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 0),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 0),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 20),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "dye", 1, 14),
                getModItem(Minecraft.ID, "dye", 1, 14),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 20),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                ItemList.Color_14.get(1L),
                ItemList.Color_14.get(1L),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 20),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 1),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 1),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 20),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Botany.ID, "pigment", 1, 51),
                getModItem(Botany.ID, "pigment", 1, 51),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 21),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "dye", 1, 13),
                getModItem(Minecraft.ID, "dye", 1, 13),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 21),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Botany.ID, "pigment", 1, 40),
                getModItem(Botany.ID, "pigment", 1, 40),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 21),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 2),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 2),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 21),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                ItemList.Color_13.get(1L),
                ItemList.Color_13.get(1L),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 22),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "dye", 1, 12),
                getModItem(Minecraft.ID, "dye", 1, 12),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 22),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Botany.ID, "pigment", 1, 22),
                getModItem(Botany.ID, "pigment", 1, 22),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 22),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 3),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 3),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 22),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                ItemList.Color_12.get(1L),
                ItemList.Color_12.get(1L),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 23),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "dye", 1, 11),
                getModItem(Minecraft.ID, "dye", 1, 11),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 23),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ExtraBees.ID, "misc", 1, 20),
                getModItem(ExtraBees.ID, "misc", 1, 20),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 23),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Botany.ID, "pigment", 1, 78),
                getModItem(Botany.ID, "pigment", 1, 78),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 23),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 4),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 4),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 23),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                ItemList.Color_11.get(1L),
                ItemList.Color_11.get(1L),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 24),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "dye", 1, 10),
                getModItem(Minecraft.ID, "dye", 1, 10),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 24),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Botany.ID, "pigment", 1, 38),
                getModItem(Botany.ID, "pigment", 1, 38),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 24),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 5),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 5),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 24),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                ItemList.Color_10.get(1L),
                ItemList.Color_10.get(1L),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 25),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "dye", 1, 9),
                getModItem(Minecraft.ID, "dye", 1, 9),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 25),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Botany.ID, "pigment", 1, 29),
                getModItem(Botany.ID, "pigment", 1, 29),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 25),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 6),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 6),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 25),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                ItemList.Color_09.get(1L),
                ItemList.Color_09.get(1L),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 26),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "dye", 1, 8),
                getModItem(Minecraft.ID, "dye", 1, 8),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 26),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Botany.ID, "pigment", 1, 10),
                getModItem(Botany.ID, "pigment", 1, 10),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 26),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                ItemList.Color_08.get(1L),
                ItemList.Color_08.get(1L),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 26),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 7),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 7),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 27),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "dye", 1, 7),
                getModItem(Minecraft.ID, "dye", 1, 7),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 27),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 8),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 8),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 27),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                ItemList.Color_07.get(1L),
                ItemList.Color_07.get(1L),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 27),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Botany.ID, "pigment", 1, 35),
                getModItem(Botany.ID, "pigment", 1, 35),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 28),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "dye", 1, 6),
                getModItem(Minecraft.ID, "dye", 1, 6),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 28),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Botany.ID, "pigment", 1, 8),
                getModItem(Botany.ID, "pigment", 1, 8),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 28),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                ItemList.Color_06.get(1L),
                ItemList.Color_06.get(1L),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 28),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 9),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 9),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 29),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "dye", 1, 5),
                getModItem(Minecraft.ID, "dye", 1, 5),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 29),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Botany.ID, "pigment", 1, 20),
                getModItem(Botany.ID, "pigment", 1, 20),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 29),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 10),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 10),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 29),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                ItemList.Color_05.get(1L),
                ItemList.Color_05.get(1L),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 30),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "dye", 1, 4),
                getModItem(Minecraft.ID, "dye", 1, 15),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 30),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(BiomesOPlenty.ID, "misc", 1, 5),
                getModItem(Minecraft.ID, "dye", 1, 5),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 30),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ExtraBees.ID, "misc", 1, 21),
                getModItem(ExtraBees.ID, "misc", 1, 21),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 30),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Botany.ID, "pigment", 1, 24),
                getModItem(Botany.ID, "pigment", 1, 24),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 30),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 11),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 11),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 30),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                ItemList.Color_04.get(1L),
                ItemList.Color_04.get(1L),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 30),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                ItemList.Dye_Indigo.get(1L),
                ItemList.Dye_Indigo.get(1L),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 31),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(BiomesOPlenty.ID, "misc", 1, 6),
                getModItem(BiomesOPlenty.ID, "misc", 1, 6),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 31),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ExtraBees.ID, "misc", 1, 25),
                getModItem(ExtraBees.ID, "misc", 1, 25),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 31),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "dye", 1, 3),
                getModItem(Minecraft.ID, "dye", 1, 3),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 31),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Botany.ID, "pigment", 1, 65),
                getModItem(Botany.ID, "pigment", 1, 65),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 31),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                ItemList.Color_03.get(1L),
                ItemList.Color_03.get(1L),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 31),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 12),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 12),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 32),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "dye", 1, 2),
                getModItem(Minecraft.ID, "dye", 1, 2),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 32),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(BiomesOPlenty.ID, "misc", 1, 7),
                getModItem(BiomesOPlenty.ID, "misc", 1, 7),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 32),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ExtraBees.ID, "misc", 1, 22),
                getModItem(ExtraBees.ID, "misc", 1, 22),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 32),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Botany.ID, "pigment", 1, 28),
                getModItem(Botany.ID, "pigment", 1, 28),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 32),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 13),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 13),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 32),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                ItemList.Color_02.get(1L),
                ItemList.Color_02.get(1L),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "dye", 1, 1),
                getModItem(Minecraft.ID, "dye", 1, 1),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ExtraBees.ID, "misc", 1, 19),
                getModItem(ExtraBees.ID, "misc", 1, 19),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Botany.ID, "pigment", 1, 59),
                getModItem(Botany.ID, "pigment", 1, 59),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 14),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 14),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                ItemList.Color_01.get(1L),
                ItemList.Color_01.get(1L),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 34),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "dye", 1, 0),
                getModItem(Minecraft.ID, "dye", 1, 0),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 34),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(BiomesOPlenty.ID, "misc", 1, 9),
                getModItem(BiomesOPlenty.ID, "misc", 1, 9),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 34),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ExtraBees.ID, "misc", 1, 24),
                getModItem(ExtraBees.ID, "misc", 1, 24),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 34),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Botany.ID, "pigment", 1, 1),
                getModItem(Botany.ID, "pigment", 1, 1),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 34),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 15),
                getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 15),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 34),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                ItemList.Color_00.get(1L),
                ItemList.Color_00.get(1L),
                null,
                null,
                null,
                null,
                null);
    }

    private void recipes1() {
        GTValues.RA.stdBuilder().itemInputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 0)).circuit(1)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 1))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(10 * SECONDS).eut(16)
                .requireMods(ProjectRedCore).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 1),
                        getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 0))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 2)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransmission).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 1L))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 2)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 1),
                        getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 17))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 3)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransmission).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 1),
                        getModItem(Minecraft.ID, "redstone", 3, 0))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 4)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 1),
                        getModItem(Minecraft.ID, "redstone_torch", 1, 0))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 5)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 5),
                        GTOreDictUnificator.get(OrePrefixes.lens, Materials.Ruby, 1L))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 6)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 5),
                        GTOreDictUnificator.get(OrePrefixes.lens, Materials.Spinel, 1L))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 6)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 2),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Polyethylene, 4L))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 9)).duration(15 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Paper, 1L))
                .circuit(1).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.datacard", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(10 * SECONDS).eut(16)
                .requireMods(ProjectRedCore).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.screwdriver", 1, 0),
                        getModItem(ProjectRedExpansion.ID, "projectred.expansion.battery", 1, 0))
                .itemOutputs(getModItem(ProjectRedExpansion.ID, "projectred.expansion.electric_screwdriver", 1, 0))
                .duration(5 * SECONDS).eut(16).requireMods(ProjectRedCore, ProjectRedExpansion).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 2L))
                .circuit(19)
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 2, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation, TinkerConstruct)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 2L))
                .circuit(19)
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 2, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 2L))
                .circuit(19)
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 2, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Iron, 2L))
                .circuit(19)
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 4, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation, TinkerConstruct)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Iron, 2L))
                .circuit(19)
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 4, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Iron, 2L))
                .circuit(19)
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 4, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2L))
                .circuit(19)
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 8, 0))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation, TinkerConstruct)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2L))
                .circuit(19)
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 8, 0))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2L))
                .circuit(19)
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 8, 0))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 2L))
                .circuit(19)
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 0))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation, TinkerConstruct)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 2L))
                .circuit(19)
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 0))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 2L))
                .circuit(19)
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 0))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2L))
                .circuit(19)
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 32, 0))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation, TinkerConstruct)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2L))
                .circuit(19)
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 32, 0))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation, TinkerConstruct)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2L))
                .circuit(19)
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 32, 0))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Aluminium, 2L))
                .circuit(19)
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 64, 0))
                .duration(20 * SECONDS).requireMods(ProjectRedTransportation, TinkerConstruct).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Aluminium, 2L))
                .circuit(19)
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 64, 0))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Aluminium, 2L))
                .circuit(19)
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 64, 0))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 8, 0),
                        GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 2L),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4L))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 8, 1))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 0),
                        GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Aluminium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 4L))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 1))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 32, 0),
                        GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.StainlessSteel, 2L),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 4L))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 32, 1))
                .duration(80 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 64, 0),
                        GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Titanium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 4L))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 64, 1))
                .duration(100 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 2, 1),
                        ItemList.Circuit_Board_Coated_Basic.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 2, 2))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 4, 1),
                        ItemList.Circuit_Board_Phenolic_Good.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 4, 2))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 8, 1),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 8, 2))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 1),
                        ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 2))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 32, 1),
                        ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 32, 2))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 64, 1),
                        ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 64, 2))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(70 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 1),
                        ItemList.Circuit_Board_Coated_Basic.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 4))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 2, 1),
                        ItemList.Circuit_Board_Phenolic_Good.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 2, 4))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 4, 1),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 4, 4))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 8, 1),
                        ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 8, 4))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 1),
                        ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 4))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 32, 1),
                        ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 32, 4))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(70 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 1),
                        ItemList.Component_Filter.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1L))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 6))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1440)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 0),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 60))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 9))
                .requireMods(ProjectRedTransportation, StevesCarts2).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 0))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 10))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 1440)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 0))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 10))
                .fluidInputs(FluidRegistry.getFluidStack("molten.styrenebutadienerubber", 720)).duration(10 * SECONDS)
                .requireMods(ProjectRedTransportation).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 0))
                .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 10))
                .fluidInputs(FluidRegistry.getFluidStack("molten.silicone", 384)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransportation).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 1L))
                .itemOutputs(getModItem(ProjectRedFabrication.ID, "projectred.fabrication.icchip", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedFabrication).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Epoxy.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 4L))
                .itemOutputs(getModItem(ProjectRedFabrication.ID, "projectred.fabrication.icblueprint", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedFabrication).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Paper, 1L))
                .circuit(1).itemOutputs(getModItem(ProjectRedExpansion.ID, "projectred.expansion.plan", 1, 0))
                .duration(5 * SECONDS).eut(8).addTo(assemblerRecipes);
    }

    private void circuitAssemblerRecipes() {
        for (Materials solderingMaterial : solderingMaterials) {
            // Null-Logic Routing Chip
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Gold, 4L))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 44)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(circuitAssemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 8, 0),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Gold, 6L))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 8, 44)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(circuitAssemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 16, 0),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Gold, 8L))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 16, 44)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(circuitAssemblerRecipes);

            // Item Responder chip
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 1L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 4, 0))
                    .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 8, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 2L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 8, 0))
                    .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 16, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.AnnealedCopper, 1),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 4L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 20))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(
                            getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 16, 0))
                    .duration(50 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            // Dynamic Item Responder chip
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 1L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 20),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 28))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 4, 1))
                    .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 8, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L),
                            MaterialsAlloy.POTIN.getPlate(1),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 2L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 20),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 28))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 8, 1))
                    .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 16, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.BlackBronze, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 2L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 20),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 28))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(
                            getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 16, 1))
                    .duration(50 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            // Item Overflow Responder chip
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 1L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 4, 2))
                    .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 8, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 2L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 8, 2))
                    .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 16, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.ConductiveIron, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 4L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 32))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(
                            getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 16, 2))
                    .duration(50 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            // Item Terminator chip
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 1L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 29),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 26))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 4, 3))
                    .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 8, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.TinAlloy, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 2L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 29),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 26))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 8, 3))
                    .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 16, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderiumBase, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 4L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 29),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 26))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(
                            getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 16, 3))
                    .duration(50 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            // Item Extractor chip
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 1L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 28))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 4, 4))
                    .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 8, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 2L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 28))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 8, 4))
                    .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 16, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.DarkSteel, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 4L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 28))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(
                            getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 16, 4))
                    .duration(50 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            // Item Broadcaster chip
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 1L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 21))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 4, 5))
                    .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 8, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Electrum, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 2L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 21))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 8, 5))
                    .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 16, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 4L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 21))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(
                            getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 16, 5))
                    .duration(50 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            // Item Stock Keeper chip
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.CobaltBrass, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 1L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 4, 6))
                    .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 8, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Cobalt, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 2L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 8, 6))
                    .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 16, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 4L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 30))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(
                            getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 16, 6))
                    .duration(50 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            // Item Crafting chip
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 1L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 24))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 4, 7))
                    .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 8, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.RedstoneAlloy, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 2L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 24))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 8, 7))
                    .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 16, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.BlueAlloy, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 4L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 24))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(
                            getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 16, 7))
                    .duration(50 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            // Item Crafting Extension chip
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Silver, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 1L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 33))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 4, 8))
                    .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 8, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.SterlingSilver, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 2L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 33))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 8, 8))
                    .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 16, 44),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticSilver, 1L),
                            GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 4L),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 33))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 36))
                    .itemOutputs(
                            getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 16, 8))
                    .duration(50 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedTransportation)
                    .addTo(circuitAssemblerRecipes);
            // OR Gate
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 5))
                    .circuit(1).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 0))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);

            // NOR Gate
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 4),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 5))
                    .circuit(2).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 1))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // NOT Gate
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 4),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 5))
                    .circuit(3).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 2))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // AND Gate
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 4),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 5))
                    .circuit(4).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 3))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // NAND Gate
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 4),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 5))
                    .circuit(5).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 4))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // XOR Gate
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 4),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 5))
                    .circuit(1).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 5))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // XNOR Gate
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 4),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 5))
                    .circuit(2).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 6))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Buffer Gate
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 4),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 5))
                    .circuit(6).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 7))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Multiplexr
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 4),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 5))
                    .circuit(7).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 8))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Pulser Former
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 4),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 5))
                    .circuit(8).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 9))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Repeater
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 4),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 5))
                    .circuit(9).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 10))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Randomizer
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 8))
                    .circuit(10).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 11))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // RS Latch
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 4),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 5))
                    .circuit(11).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 12))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Toggle Latch
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 1),
                            getModItem(Minecraft.ID, "lever", 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 5))
                    .circuit(12).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 13))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Transparent Latch
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 4),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 5, 5))
                    .circuit(13).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 14))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Light Sensor
            for (ItemStack itemStack : OreDictionary.getOres("dyeBlue")) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(ProjectRedCore.ID, "projectred.core.part", 5, 0),
                                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 1),
                                GTUtility.copyAmount(3, itemStack))
                        .circuit(14)
                        .itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 15))
                        .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedIntegration)
                        .addTo(circuitAssemblerRecipes);
            }
            // Rain Sensor
            for (ItemStack itemStack : OreDictionary.getOres("slimeball")) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(ProjectRedCore.ID, "projectred.core.part", 5, 0),
                                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 1),
                                GTUtility.copyAmount(3, itemStack))
                        .circuit(15)
                        .itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 16))
                        .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedIntegration)
                        .addTo(circuitAssemblerRecipes);
            }
            // Timer
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 4),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 5),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 6))
                    .circuit(16).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 17))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Sequenzer
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 5),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 6))
                    .circuit(17).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 18))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Counter
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 5),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 6))
                    .circuit(18).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 19))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // State Cell
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 4),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 5),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 6),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 7))
                    .circuit(19).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 20))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Synchronizer
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 5, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 4),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 5),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 7))
                    .circuit(3).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 21))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Bus Transceiver
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 6, 3),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 7))
                    .circuit(20).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 22))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Null Cell
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 2),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 9))
                    .circuit(21).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 23))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Inverter Cell
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 2),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 5),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 9))
                    .circuit(22).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 24))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Buffer Cell
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 2),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 5),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 9))
                    .circuit(23).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 25))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Comparator
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 6, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 5),
                            getModItem(Minecraft.ID, "comparator", 1))
                    .circuit(4).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // And Cell
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 0),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 2),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 5),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 9))
                    .circuit(24).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 27))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Bus Randomizer
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 6, 3),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 8))
                    .circuit(5).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 28))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Bus Converter
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 5, 3),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 7))
                    .circuit(6).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 29))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Bus Input Pannel
            for (ItemStack itemStack : OreDictionary.getOres("projredIllumar")) {
                GTValues.RA.stdBuilder()
                        .itemInputs(
                                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 1),
                                getModItem(ProjectRedCore.ID, "projectred.core.part", 7, 3),
                                getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 7),
                                GTUtility.copyAmount(1, itemStack))
                        .circuit(17)
                        .itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 30))
                        .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS)
                        .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore, ProjectRedIntegration)
                        .addTo(circuitAssemblerRecipes);
            }
            // Data Cell
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 3, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 2),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 5, 5))
                    .circuit(8).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 31))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Segment Display Gate
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 3),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 7),
                            getModItem(Minecraft.ID, "quartz", 3))
                    .circuit(9).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 32))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
            // Dec Randomizer
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 1),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 4),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 5),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 7),
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 8))
                    .circuit(10).itemOutputs(getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 33))
                    .fluidInputs(getSolderingFluid(solderingMaterial, 72)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                    .requireMods(ProjectRedCore, ProjectRedIntegration).addTo(circuitAssemblerRecipes);
        }
    }

    private void recipes2() {
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 6, 56),
                        ItemList.Battery_Hull_LV.get(1L))
                .itemOutputs(getModItem(ProjectRedExpansion.ID, "projectred.expansion.emptybattery", 1, 0))
                .duration(5 * SECONDS).eut(2).requireMods(ProjectRedCore, ProjectRedExpansion).addTo(cannerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 0),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 13))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 7)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 0),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 14))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 8)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(formingPressRecipes);
        for (ItemStack itemStack : OreDictionary.getOres("craftingLensRed")) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 42),
                            GTUtility.copyAmount(0, itemStack))
                    .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 13)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(laserEngraverRecipes);
        }
        for (ItemStack itemStack : OreDictionary.getOres("craftingLensYellow")) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 43),
                            GTUtility.copyAmount(0, itemStack))
                    .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 14)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(laserEngraverRecipes);
        }
        for (ItemStack itemStack : OreDictionary.getOres("craftingLensBlue")) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 58),
                            GTUtility.copyAmount(0, itemStack))
                    .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 59)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(laserEngraverRecipes);
        }
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Circuit_Silicon_Wafer.get(1L), getModItem(Minecraft.ID, "redstone", 8, 0))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 42)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Circuit_Silicon_Wafer2.get(1L), getModItem(Minecraft.ID, "redstone", 16, 0))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 42)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Circuit_Silicon_Wafer3.get(1L), getModItem(Minecraft.ID, "redstone", 32, 0))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 42)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Circuit_Silicon_Wafer.get(1L), getModItem(Minecraft.ID, "glowstone_dust", 8, 0))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 43)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Circuit_Silicon_Wafer2.get(1L), getModItem(Minecraft.ID, "glowstone_dust", 16, 0))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 43)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Circuit_Silicon_Wafer3.get(1L), getModItem(Minecraft.ID, "glowstone_dust", 32, 0))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 43)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Silicon_Wafer.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 8, 56))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 58)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Silicon_Wafer2.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 16, 56))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 2, 58)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Silicon_Wafer3.get(1L),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 32, 56))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 58)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "iron_ingot", 1, 0),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 8, 56))
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 57)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Minecraft.ID, "dye", 1, 15)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 19))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Botania.ID, "dye", 1, 0))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 19))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(BiomesOPlenty.ID, "misc", 1, 8))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 19))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), ItemList.Color_15.get(1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 19))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(ExtraBees.ID, "misc", 1, 23)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 19))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 0))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 19))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Gendustry.ID, "HoneyDrop", 1, 25))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 19))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Minecraft.ID, "dye", 1, 14)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 20))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Botania.ID, "dye", 1, 1))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 20))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), ItemList.Color_14.get(1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 20))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 1))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 20))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ProjectRedExploration)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Gendustry.ID, "HoneyDrop", 1, 24))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 20))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Minecraft.ID, "dye", 1, 13)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 21))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Botania.ID, "dye", 1, 2))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 21))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Botania).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), ItemList.Color_13.get(1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 21))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 2))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 21))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ProjectRedExploration)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Gendustry.ID, "HoneyDrop", 1, 23))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 21))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Minecraft.ID, "dye", 1, 12)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 22))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Botania.ID, "dye", 1, 3))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 22))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), ItemList.Color_12.get(1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 22))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 3))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 22))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ProjectRedExploration)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Gendustry.ID, "HoneyDrop", 1, 22))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 22))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Minecraft.ID, "dye", 1, 11)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 23))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Botania.ID, "dye", 1, 4))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 23))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.YellowLimonite, 1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 23))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), ItemList.Color_11.get(1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 23))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(ExtraBees.ID, "misc", 1, 20)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 23))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ExtraBees).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 4))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 23))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ProjectRedExploration)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Gendustry.ID, "HoneyDrop", 1, 21))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 23))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Minecraft.ID, "dye", 1, 10)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 24))
                .duration(1 * SECONDS + 5 * TICKS).requireMods(ProjectRedCore).eut(8).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Botania.ID, "dye", 1, 5))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 24))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), ItemList.Color_10.get(1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 24))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 5))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 24))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ProjectRedExploration)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Gendustry.ID, "HoneyDrop", 1, 20))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 24))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Gendustry).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Soapstone, 1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 24))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Minecraft.ID, "dye", 1, 9)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 25))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Botania.ID, "dye", 1, 6))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 25))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), ItemList.Color_09.get(1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 25))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 6))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 25))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ProjectRedExploration)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Gendustry.ID, "HoneyDrop", 1, 19))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 25))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Gendustry).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Minecraft.ID, "dye", 1, 8)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 26))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Botania.ID, "dye", 1, 7))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 26))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Botania).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), ItemList.Color_08.get(1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 26))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 7))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 26))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ProjectRedExploration)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Gendustry.ID, "HoneyDrop", 1, 18))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 26))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Gendustry).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Minecraft.ID, "dye", 1, 7)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 27))
                .duration(1 * SECONDS + 5 * TICKS).requireMods(ProjectRedCore).eut(8).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Botania.ID, "dye", 1, 8))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 27))
                .duration(1 * SECONDS + 5 * TICKS).requireMods(ProjectRedCore, Botania).eut(8).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), ItemList.Color_07.get(1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 27))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 8))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 27))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ProjectRedExploration)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Gendustry.ID, "HoneyDrop", 1, 17))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 27))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Gendustry).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Minecraft.ID, "dye", 1, 6)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 28))
                .duration(1 * SECONDS + 5 * TICKS).requireMods(ProjectRedCore).eut(8).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Botania.ID, "dye", 1, 9))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 28))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lazurite, 1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 28))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        GTOreDictUnificator.get(OrePrefixes.gem, Materials.Lazurite, 1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 28))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), ItemList.Color_06.get(1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 28))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 9))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 28))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ProjectRedExploration)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Gendustry.ID, "HoneyDrop", 1, 16))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 28))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Gendustry).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Minecraft.ID, "dye", 1, 5)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 29))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Botania.ID, "dye", 1, 10)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 29))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Botania).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), ItemList.Color_05.get(1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 29))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 10))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 29))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ProjectRedExploration)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Gendustry.ID, "HoneyDrop", 1, 15))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 29))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Gendustry).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Minecraft.ID, "dye", 1, 4)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 30))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Botania.ID, "dye", 1, 11)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 30))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Botania).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Natura.ID, "barleyFood", 1, 8))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 30))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Natura).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(BiomesOPlenty.ID, "misc", 1, 5))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 30))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, BiomesOPlenty)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sodalite, 1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 30))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 30))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        GTOreDictUnificator.get(OrePrefixes.gem, Materials.Sodalite, 1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 30))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), ItemList.Dye_Indigo.get(1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 30))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), ItemList.Color_04.get(1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 30))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(ExtraBees.ID, "misc", 1, 21)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 30))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ExtraBees).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 11))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 30))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ProjectRedExploration)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Gendustry.ID, "HoneyDrop", 1, 14))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 30))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Gendustry).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Minecraft.ID, "dye", 1, 3)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 31))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        getModItem(GalacticraftAmunRa.ID, "item.baseItem", 1, 29))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 31))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, GalacticraftAmunRa)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Botania.ID, "dye", 1, 12)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 31))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Botania).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(BiomesOPlenty.ID, "misc", 1, 6))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 31))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, BiomesOPlenty)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Cocoa, 1))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 31))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coffee, 1))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 31))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BrownLimonite, 1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 31))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(ExtraBees.ID, "misc", 1, 25)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 31))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ExtraBees).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 12))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 31))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ProjectRedExploration)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Gendustry.ID, "HoneyDrop", 1, 13))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 31))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Gendustry).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Minecraft.ID, "dye", 1, 2)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 32))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Botania.ID, "dye", 1, 13)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 32))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Botania).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(BiomesOPlenty.ID, "misc", 1, 7))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 32))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, BiomesOPlenty)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), ItemList.Color_02.get(1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 32))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(ExtraBees.ID, "misc", 1, 22)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 32))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ExtraBees).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 13))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 32))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ProjectRedExploration)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Gendustry.ID, "HoneyDrop", 1, 12))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 32))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Gendustry).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Minecraft.ID, "dye", 1, 1)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Botania.ID, "dye", 1, 14)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Botania).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), ItemList.Color_01.get(1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(ExtraBees.ID, "misc", 1, 19)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ExtraBees).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 14))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ProjectRedExploration)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Gendustry.ID, "HoneyDrop", 1, 11))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 33))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Gendustry).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Minecraft.ID, "dye", 1, 0)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 34))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Botania.ID, "dye", 1, 15)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 34))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Botania).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(BiomesOPlenty.ID, "misc", 1, 9))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 34))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, BiomesOPlenty)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glowstone_dust, 1), ItemList.Color_00.get(1L))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 34))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(ForbiddenMagic.ID, "FMResource", 1, 1))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 34))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ForbiddenMagic)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(ThaumicHorizons.ID, "inkEgg", 1, 0))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 34))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ThaumicHorizons)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(ExtraBees.ID, "misc", 1, 24)).circuit(8)
                .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 34))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ExtraBees).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 1),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 1, 15))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 34))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, ProjectRedExploration)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.glowstone_dust, 1), getModItem(Gendustry.ID, "HoneyDrop", 1, 10))
                .circuit(8).itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 4, 34))
                .duration(1 * SECONDS + 5 * TICKS).eut(8).requireMods(ProjectRedCore, Gendustry).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 1L))
                .circuit(2).itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 0))
                .duration(1 * SECONDS).eut(8).requireMods(ProjectRedTransmission).addTo(wiremillRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTModHandler.getModItem(EtFuturumRequiem.ID, "barrel", 1L, 0),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.WoodSealed, 4L))
                .circuit(5)
                .itemOutputs(GTModHandler.getModItem(ProjectRedExploration.ID, "projectred.exploration.barrel", 1L, 0))
                .duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedExploration)
                .addTo(assemblerRecipes);

        // Base (Black) Insulated Wire
        addShapelessRecipe(
                getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 16),
                getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 0),
                "plateAnyRubber");

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 1))
                .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 16))
                .duration(5 * SECONDS).eut(8).requireMods(ProjectRedTransmission).addTo(packagerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 1L))
                .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 16))
                .duration(5 * SECONDS).eut(8).requireMods(ProjectRedTransmission).addTo(packagerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RubberSilicone, 1L))
                .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 16))
                .duration(5 * SECONDS).eut(8).requireMods(ProjectRedTransmission).addTo(packagerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 16))
                .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 0))
                .duration(5 * SECONDS).eut(8).requireMods(ProjectRedTransmission).addTo(unpackagerRecipes);

        // Base Bundled Cable
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 5, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 5))
                .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 17))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransmission)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 5, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 5L))
                .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 17))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransmission)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 5, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RubberSilicone, 5L))
                .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 17))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_LV).requireMods(ProjectRedTransmission)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 17))
                .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 5, 0))
                .duration(5 * SECONDS).eut(8).requireMods(ProjectRedTransmission).addTo(unpackagerRecipes);

        // Low Load Power Cable
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.ElectrotineWire.getIS(1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 1))
                .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 34))
                .duration(5 * SECONDS).eut(8).requireMods(ProjectRedTransmission).addTo(packagerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.ElectrotineWire.getIS(1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 1L))
                .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 34))
                .duration(5 * SECONDS).eut(8).requireMods(ProjectRedTransmission).addTo(packagerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.ElectrotineWire.getIS(1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RubberSilicone, 1L))
                .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 34))
                .duration(5 * SECONDS).eut(8).requireMods(ProjectRedTransmission).addTo(packagerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 34))
                .itemOutputs(NHItemList.ElectrotineWire.getIS(1)).duration(5 * SECONDS).eut(8)
                .requireMods(ProjectRedTransmission).addTo(unpackagerRecipes);

        // All Framed Wire Variants
        for (int i = 0; i <= 34; i++) {
            if (i >= 18 && i <= 33) continue;
            addShapedRecipe(
                    getModItem(ProjectRedTransmission.ID, "projectred.transmission.framewire", 1, i),
                    "stickWood",
                    "stickWood",
                    "stickWood",
                    "stickWood",
                    getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, i),
                    "stickWood",
                    "stickWood",
                    "stickWood",
                    "stickWood");

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, i),
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.framewire", 1, i))
                    .duration(5 * SECONDS).eut(8).requireMods(ProjectRedTransmission).addTo(packagerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.framewire", 1, i))
                    .itemOutputs(
                            getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, i),
                            GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L))
                    .duration(5 * SECONDS).eut(8).requireMods(ProjectRedTransmission).addTo(unpackagerRecipes);
        }

        final String[] cableDyes = { "dyeblack", "dyered", "dyegreen", "dyebrown", "dyeblue", "dyepurple", "dyecyan",
                "dyelightgray", "dyegray", "dyepink", "dyelime", "dyeyellow", "dyelightblue", "dyemagenta", "dyeorange",
                "dyewhite" };

        final String[] craftingCableDyes = { "dyeBlack", "dyeRed", "dyeGreen", "dyeBrown", "dyeBlue", "dyePurple",
                "dyeCyan", "dyeLightGray", "dyeGray", "dyePink", "dyeLime", "dyeYellow", "dyeLightBlue", "dyeMagenta",
                "dyeOrange", "dyeWhite" };

        // Insulated Wire Dyeing
        for (int i = 1; i < cableDyes.length; i++) {
            int outputMeta = 16 - i;

            addShapelessRecipe(
                    getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, outputMeta),
                    getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 16),
                    craftingCableDyes[i]);

            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 16))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, outputMeta))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed." + cableDyes[i], 18))
                    .duration(SECONDS + 5 * TICKS).eut(2).addTo(chemicalBathRecipes);
        }

        // Insulated Wire Undyeing
        for (int i = 1; i < 16; i++) {
            addShapelessRecipe(
                    getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 16),
                    getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, i));
        }

        // Bundled Cable Dyeing
        for (int i = 0; i < cableDyes.length; i++) {
            int outputMeta = 33 - i;

            addShapelessRecipe(
                    getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, outputMeta),
                    getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 17),
                    craftingCableDyes[i]);

            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 17))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, outputMeta))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed." + cableDyes[i], 36))
                    .duration(SECONDS + 5 * TICKS).eut(2).requireMods(ProjectRedTransmission)
                    .addTo(chemicalBathRecipes);
        }

        // Bundled Cable Undyeing
        for (int i = 18; i < 34; i++) {
            addShapelessRecipe(
                    getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 17),
                    getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, i));
        }
    }
}
