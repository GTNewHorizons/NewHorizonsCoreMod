package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import tconstruct.library.crafting.Smeltery;

import com.dreammaster.chisel.ChiselHelper;
import com.dreammaster.tinkersConstruct.TConstructHelper;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptProjectRed implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Project Red";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Mods.ProjectRedCore.ID,
                "ProjRed|Exploration",
                "ProjRed|Transmission",
                "ProjRed|Transportation",
                Mods.TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {
        craftingRecipes();

        recipes1();
        recipes2();

        ChiselHelper.addGroup("ruby");
        ChiselHelper.addGroup("sapphire");
        ChiselHelper.addGroup("peridot");
        TConstructHelper.removeSmelterAlloyMix(FluidRegistry.getFluidStack("redmetal.molten", 144));
        Smeltery.addAlloyMixing(
                FluidRegistry.getFluidStack("redmetal.molten", 144),
                FluidRegistry.getFluidStack("redstone.molten", 576),
                FluidRegistry.getFluidStack("copper.molten", 144));
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 9, 2812, missing))
                .itemOutputs(getModItem("ProjRed|Exploration", "projectred.exploration.stone", 1, 11, missing))
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 57, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 55, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        ChiselHelper.addVariationFromStack("ruby", getModItem("BiomesOPlenty", "gemOre", 1, 3, missing));
        ChiselHelper.addVariationFromStack("ruby", getModItem("gregtech", "gt.blockgem2", 1, 11, missing));
        ChiselHelper.addVariationFromStack(
                "ruby",
                getModItem("ProjRed|Exploration", "projectred.exploration.stone", 1, 5, missing));
        ChiselHelper.addVariationFromStack("sapphire", getModItem("BiomesOPlenty", "gemOre", 1, 13, missing));
        ChiselHelper.addVariationFromStack("sapphire", getModItem("gregtech", "gt.blockgem2", 1, 12, missing));
        ChiselHelper.addVariationFromStack(
                "sapphire",
                getModItem("ProjRed|Exploration", "projectred.exploration.stone", 1, 6, missing));
        ChiselHelper.addVariationFromStack("peridot", getModItem("BiomesOPlenty", "gemOre", 1, 5, missing));
        ChiselHelper.addVariationFromStack("peridot", getModItem("gregtech", "gt.blockgem2", 1, 4, missing));
        ChiselHelper.addVariationFromStack(
                "peridot",
                getModItem("ProjRed|Exploration", "projectred.exploration.stone", 1, 7, missing));

    }

    private void craftingRecipes() {
        addShapedRecipe(
                getModItem("ProjRed|Expansion", "projectred.expansion.machine1", 1, 1, missing),
                new Object[] { getModItem("minecraft", "brick_block", 1, 0, missing),
                        getModItem("minecraft", "brick_block", 1, 0, missing),
                        getModItem("minecraft", "brick_block", 1, 0, missing), "itemCasingSteel",
                        getModItem("ProjRed|Expansion", "projectred.expansion.emptybattery", 1, 0, missing),
                        "itemCasingSteel", "circuitBasic",
                        getModItem("ProjRed|Expansion", "projectred.expansion.emptybattery", 1, 0, missing),
                        "circuitBasic" });
        addShapedRecipe(
                getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 0, missing),
                new Object[] { "itemCasingSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                        "itemCasingSteel", getModItem("dreamcraft", "item.DiamondDrillTip", 1, 0, missing),
                        getModItem("IC2", "blockMiningPipe", 1, 0, missing), "circuitBasic", "itemCasingSteel",
                        "gearSteel", "itemCasingSteel" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 0, missing),
                new Object[] { getModItem("OpenBlocks", "blockbreaker", 1, 0, missing) });
        addShapedRecipe(
                getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 1, missing),
                new Object[] { "itemCasingSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                        "itemCasingSteel", "circuitBasic", "pipeMediumTin",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing), "itemCasingSteel",
                        "craftingPiston", "itemCasingSteel" });
        addShapedRecipe(
                getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 2, missing),
                new Object[] { "itemCasingSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                        "itemCasingSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing), "pipeMediumTin",
                        "circuitBasic", "itemCasingSteel", "craftingPiston", "itemCasingSteel" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 2, missing),
                new Object[] { getModItem("OpenBlocks", "blockPlacer", 1, 0, missing) });
        addShapedRecipe(
                getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 3, missing),
                new Object[] { "itemCasingAluminium", getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                        "itemCasingAluminium", "circuitGood",
                        getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32631, missing), "itemCasingAluminium",
                        "craftingFilter", "itemCasingAluminium" });
        addShapedRecipe(
                getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 4, missing),
                new Object[] { getModItem("TConstruct", "heavyPlate", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 7, missing), "circuitBasic",
                        getModItem("minecraft", "flint_and_steel", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing), "itemCasingSteel",
                        "craftingPiston", "itemCasingSteel" });
        addShapedRecipe(
                getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 5, missing),
                new Object[] { "plateSteel",
                        getModItem("ProjRed|Expansion", "projectred.expansion.emptybattery", 1, 0, missing),
                        "plateSteel",
                        getModItem("ProjRed|Expansion", "projectred.expansion.emptybattery", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 11, missing),
                        getModItem("ProjRed|Expansion", "projectred.expansion.emptybattery", 1, 0, missing),
                        "plateSteel",
                        getModItem("ProjRed|Expansion", "projectred.expansion.emptybattery", 1, 0, missing),
                        "plateSteel" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Expansion", "projectred.expansion.solar_panel", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32750, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.blockmachines", 1, 2000, missing) });
        addShapedRecipe(
                getModItem("ProjRed|Exploration", "projectred.exploration.sawgold", 1, 0, missing),
                new Object[] { "stickWood", "stickSteel", "stickSteel", "stickWood",
                        getModItem("gregtech", "gt.metaitem.02", 1, 7086, missing), "stickSteel", null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Exploration", "projectred.exploration.sawruby", 1, 0, missing),
                new Object[] { "stickWood", "stickSteel", "stickSteel", "stickWood",
                        getModItem("dreamcraft", "item.SawBladeRuby", 1, 0, missing), "stickSteel", null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Exploration", "projectred.exploration.sawsapphire", 1, 0, missing),
                new Object[] { "stickWood", "stickSteel", "stickSteel", "stickWood",
                        getModItem("dreamcraft", "item.SawBladeSapphire", 1, 0, missing), "stickSteel", null, null,
                        null });
        addShapedRecipe(
                getModItem("ProjRed|Exploration", "projectred.exploration.sawperidot", 1, 0, missing),
                new Object[] { "stickWood", "stickSteel", "stickSteel", "stickWood",
                        getModItem("dreamcraft", "item.SawBladePeridot", 1, 0, missing), "stickSteel", null, null,
                        null });
        addShapedRecipe(
                getModItem("ProjRed|Exploration", "projectred.exploration.rubyboots", 1, 0, missing),
                new Object[] { "plateRuby", null, "plateRuby", "plateRuby", "craftingToolHardHammer", "plateRuby", null,
                        null, null });
        addShapedRecipe(
                getModItem("ProjRed|Exploration", "projectred.exploration.rubychestplate", 1, 0, missing),
                new Object[] { "plateRuby", "craftingToolHardHammer", "plateRuby", "plateRuby", "plateRuby",
                        "plateRuby", "plateRuby", "plateRuby", "plateRuby" });
        addShapedRecipe(
                getModItem("ProjRed|Exploration", "projectred.exploration.rubyhelmet", 1, 0, missing),
                new Object[] { "plateRuby", "plateRuby", "plateRuby", "plateRuby", "craftingToolHardHammer",
                        "plateRuby", null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Exploration", "projectred.exploration.rubyleggings", 1, 0, missing),
                new Object[] { "plateRuby", "plateRuby", "plateRuby", "plateRuby", "craftingToolHardHammer",
                        "plateRuby", "plateRuby", null, "plateRuby" });
        addShapedRecipe(
                getModItem("ProjRed|Exploration", "projectred.exploration.sapphireboots", 1, 0, missing),
                new Object[] { "plateSapphire", null, "plateSapphire", "plateSapphire", "craftingToolHardHammer",
                        "plateSapphire", null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Exploration", "projectred.exploration.sapphirechestplate", 1, 0, missing),
                new Object[] { "plateSapphire", "craftingToolHardHammer", "plateSapphire", "plateSapphire",
                        "plateSapphire", "plateSapphire", "plateSapphire", "plateSapphire", "plateSapphire" });
        addShapedRecipe(
                getModItem("ProjRed|Exploration", "projectred.exploration.sapphirehelmet", 1, 0, missing),
                new Object[] { "plateSapphire", "plateSapphire", "plateSapphire", "plateSapphire",
                        "craftingToolHardHammer", "plateSapphire", null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Exploration", "projectred.exploration.sapphireleggings", 1, 0, missing),
                new Object[] { "plateSapphire", "plateSapphire", "plateSapphire", "plateSapphire",
                        "craftingToolHardHammer", "plateSapphire", "plateSapphire", null, "plateSapphire" });
        addShapedRecipe(
                getModItem("ProjRed|Exploration", "projectred.exploration.peridotboots", 1, 0, missing),
                new Object[] { "platePeridot", null, "platePeridot", "platePeridot", "craftingToolHardHammer",
                        "platePeridot", null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Exploration", "projectred.exploration.peridotchestplate", 1, 0, missing),
                new Object[] { "platePeridot", "craftingToolHardHammer", "platePeridot", "platePeridot", "platePeridot",
                        "platePeridot", "platePeridot", "platePeridot", "platePeridot" });
        addShapedRecipe(
                getModItem("ProjRed|Exploration", "projectred.exploration.peridothelmet", 1, 0, missing),
                new Object[] { "platePeridot", "platePeridot", "platePeridot", "platePeridot", "craftingToolHardHammer",
                        "platePeridot", null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Exploration", "projectred.exploration.peridotleggings", 1, 0, missing),
                new Object[] { "platePeridot", "platePeridot", "platePeridot", "platePeridot", "craftingToolHardHammer",
                        "platePeridot", "platePeridot", null, "platePeridot" });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                new Object[] { "wireGt01Gold", getModItem("ProjRed|Core", "projectred.core.part", 1, 0, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 0, missing), "wireGt01Gold",
                        "circuitPrimitive", "wireGt01Gold", "screwSteel", "craftingToolScrewdriver", "screwSteel" });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.screwdriver", 1, 0, missing),
                new Object[] { null, "craftingToolFile", "stickSteel", "stickAnyRubber", "stickSteel",
                        "craftingToolHardHammer", "stickAnyRubber", "stickAnyRubber", null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.wiredebugger", 1, 0, missing),
                new Object[] { "wireGt01RedAlloy", "stickSteelMagnetic", "wireGt01RedAlloy", "itemCasingSteel",
                        "plateGlowstone", "itemCasingSteel", "screwSteel", "craftingToolScrewdriver", "screwSteel" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 0, missing),
                        "plateAnyRubber" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 1, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                        "dyeWhite" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 2, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                        "dyeOrange" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 3, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                        "dyeMagenta" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 4, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                        "dyeLightBlue" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 4, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 5, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                        "dyeYellow" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 5, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 6, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                        "dyeLime" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 6, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 7, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                        "dyePink" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 7, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 8, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                        "dyeGray" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 8, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 9, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                        "dyeLightGray" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 9, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 10, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                        "dyeCyan" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 10, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 11, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                        "dyePurple" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 11, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 12, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                        "dyeBlue" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 12, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 13, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                        "dyeBrown" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 13, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 14, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                        "dyeGreen" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 14, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 15, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                        "dyeRed" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 15, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 18, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                        "dyeWhite" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 18, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 19, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                        "dyeOrange" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 19, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 20, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                        "dyeMagenta" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 20, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 21, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                        "dyeLightBlue" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 21, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 22, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                        "dyeYellow" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 22, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 23, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                        "dyeLime" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 23, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 24, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                        "dyePink" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 24, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 25, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                        "dyeGray" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 25, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 26, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                        "dyeLightGray" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 26, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 27, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                        "dyeCyan" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 27, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 28, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                        "dyePurple" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 28, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 29, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                        "dyeBlue" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 29, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 30, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                        "dyeBrown" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 30, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 31, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                        "dyeGreen" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 31, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 32, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                        "dyeRed" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 32, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 33, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                        "dyeBlack" });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 33, missing) });
        addShapedRecipe(
                getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 0, missing),
                new Object[] { null, "craftingToolFile", null, "stickLongIron",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickLongIron", null, "craftingToolSaw",
                        null });
        addShapedRecipe(
                getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 0, missing),
                new Object[] { null, "craftingToolFile", null, "stickLongIron", "paneGlass", "stickLongIron", null,
                        "craftingToolSaw", null });
        addShapedRecipe(
                getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 4, 1, missing),
                new Object[] { getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 0, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 13, missing),
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 0, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 33, missing), "stickAluminium",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 32, missing),
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 0, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 13, missing),
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 0, missing) });
        addShapedRecipe(
                getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing),
                new Object[] { getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing), "wireGt01RedAlloy",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing), "plateCopper",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing), "circuitGood",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing), "wireGt01RedAlloy",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing) });
        addShapedRecipe(
                getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing),
                new Object[] { getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing), "wireGt01RedAlloy",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing), "plateBronze",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing), "circuitGood",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing), "wireGt01RedAlloy",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing) });
        addShapedRecipe(
                getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing),
                new Object[] { getModItem("ProjRed|Core", "projectred.core.part", 1, 32, missing), "wireGt01RedAlloy",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 32, missing), "plateIron",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing), "circuitGood",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 32, missing), "wireGt01RedAlloy",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 32, missing) });
        addShapedRecipe(
                getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing),
                new Object[] { getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing), "wireGt01RedAlloy",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing), "plateTin",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing), "circuitBasic",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing), "wireGt01RedAlloy",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing) });
        addShapedRecipe(
                getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing),
                new Object[] { getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing), "wireGt01RedAlloy",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing), "plateSteel",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing), "circuitGood",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing), "wireGt01RedAlloy",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing) });
        addShapedRecipe(
                getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing),
                new Object[] { getModItem("ProjRed|Core", "projectred.core.part", 1, 21, missing), "wireGt02RedAlloy",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 21, missing), "plateGold",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing), "circuitBasic",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 21, missing), "wireGt02RedAlloy",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 21, missing) });
        addShapedRecipe(
                getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 6, missing),
                new Object[] { getModItem("ProjRed|Core", "projectred.core.part", 1, 30, missing), "wireGt02RedAlloy",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 30, missing), "plateAluminium",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing), "circuitBasic",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 30, missing), "wireGt02RedAlloy",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 30, missing) });
        addShapedRecipe(
                getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 7, missing),
                new Object[] { getModItem("ProjRed|Core", "projectred.core.part", 1, 24, missing), "wireGt02RedAlloy",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 24, missing), "plateGlowstone",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing), "circuitBasic",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 24, missing), "wireGt02RedAlloy",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 24, missing) });
        addShapedRecipe(
                getModItem("ProjRed|Transportation", "projectred.transportation.routerutil", 1, 0, missing),
                new Object[] { "wireGt01RedAlloy", "itemCasingSteel", "wireGt01RedAlloy", "circuitGood", "plateEmerald",
                        "circuitGood", "itemCasingSteel",
                        createItemStack("gregtech", "gt.metaitem.01", 1, 32510, "{GT.ItemCharge:18000L}", missing),
                        "itemCasingSteel" });
        addShapedRecipe(
                getModItem("ProjRed|Expansion", "projectred.expansion.jetpack", 1, 6400, missing),
                new Object[] { "circuitBasic", "wireGt04Gold", "circuitBasic",
                        getModItem("ProjRed|Expansion", "projectred.expansion.emptybattery", 1, 0, missing),
                        getModItem("minecraft", "diamond_chestplate", 1, 0, missing),
                        getModItem("ProjRed|Expansion", "projectred.expansion.emptybattery", 1, 0, missing),
                        getModItem("ProjRed|Expansion", "projectred.expansion.emptybattery", 1, 0, missing),
                        "plateGlowstone",
                        getModItem("ProjRed|Expansion", "projectred.expansion.emptybattery", 1, 0, missing) });
        addShapedRecipe(
                getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 6, missing),
                new Object[] { "wireGt04Copper", "plateSteel", "wireGt04Copper",
                        getModItem("ProjRed|Expansion", "projectred.expansion.emptybattery", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 11, missing),
                        getModItem("ProjRed|Expansion", "projectred.expansion.emptybattery", 1, 0, missing),
                        "circuitBasic", getModItem("ProjRed|Core", "projectred.core.part", 1, 16, missing),
                        "circuitBasic" });
        addShapedRecipe(
                getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 8, missing),
                new Object[] { "circuitBasic", "plateSteel", "circuitBasic",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 16, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 11, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 16, missing), "wireGt04Copper",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "wireGt04Copper" });
        addShapedRecipe(
                getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 9, missing),
                new Object[] { "plateSteel", getModItem("ProjRed|Core", "projectred.core.part", 1, 59, missing),
                        "plateSteel", getModItem("ProjRed|Core", "projectred.core.part", 1, 16, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 4401, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 16, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 18, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 59, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 18, missing) });
        addShapedRecipe(
                getModItem("ProjRed|Fabrication", "projectred.integration.icblock", 1, 0, missing),
                new Object[] { "plateSteel", "plateSteel", "plateSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing) });
        addShapedRecipe(
                getModItem("ProjRed|Fabrication", "projectred.integration.icblock", 1, 1, missing),
                new Object[] { "blockGlass", "blockGlass", "blockGlass", "plateObsidian", "stickSteel", "plateObsidian",
                        "stickSteel", getModItem("gregtech", "gt.blockmachines", 1, 321, missing), "stickSteel" });
        addShapelessCraftingRecipe(
                getModItem("MCFrames", "mcframes.frame", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.blockmachines", 1, 4905, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 4905, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 10, missing),
                new Object[] { getModItem("Forestry", "factory2", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 11, missing),
                new Object[] { getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 19, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "dye", 1, 15, missing), getModItem("minecraft", "dye", 1, 15, missing),
                        null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 19, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("BiomesOPlenty", "misc", 1, 8, missing),
                        getModItem("BiomesOPlenty", "misc", 1, 8, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 19, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ExtraBees", "misc", 1, 23, missing),
                        getModItem("ExtraBees", "misc", 1, 23, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 19, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("Botany", "pigment", 1, 77, missing),
                        getModItem("Botany", "pigment", 1, 77, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 19, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32429, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32429, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 19, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 0, missing), null, null,
                        null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 20, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "dye", 1, 14, missing), getModItem("minecraft", "dye", 1, 14, missing),
                        null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 20, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32428, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32428, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 20, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 1, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 1, missing), null, null,
                        null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 20, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("Botany", "pigment", 1, 51, missing),
                        getModItem("Botany", "pigment", 1, 51, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 21, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "dye", 1, 13, missing), getModItem("minecraft", "dye", 1, 13, missing),
                        null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 21, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("Botany", "pigment", 1, 40, missing),
                        getModItem("Botany", "pigment", 1, 40, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 21, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 2, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 2, missing), null, null,
                        null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 21, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32427, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32427, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 22, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "dye", 1, 12, missing), getModItem("minecraft", "dye", 1, 12, missing),
                        null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 22, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("Botany", "pigment", 1, 22, missing),
                        getModItem("Botany", "pigment", 1, 22, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 22, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 3, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 3, missing), null, null,
                        null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 22, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32426, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32426, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 23, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "dye", 1, 11, missing), getModItem("minecraft", "dye", 1, 11, missing),
                        null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 23, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ExtraBees", "misc", 1, 20, missing),
                        getModItem("ExtraBees", "misc", 1, 20, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 23, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("Botany", "pigment", 1, 78, missing),
                        getModItem("Botany", "pigment", 1, 78, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 23, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 4, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 4, missing), null, null,
                        null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 23, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32425, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32425, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 24, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "dye", 1, 10, missing), getModItem("minecraft", "dye", 1, 10, missing),
                        null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 24, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("Botany", "pigment", 1, 38, missing),
                        getModItem("Botany", "pigment", 1, 38, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 24, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 5, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 5, missing), null, null,
                        null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 24, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32424, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32424, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 25, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "dye", 1, 9, missing), getModItem("minecraft", "dye", 1, 9, missing),
                        null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 25, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("Botany", "pigment", 1, 29, missing),
                        getModItem("Botany", "pigment", 1, 29, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 25, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 6, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 6, missing), null, null,
                        null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 25, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32423, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32423, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 26, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "dye", 1, 8, missing), getModItem("minecraft", "dye", 1, 8, missing),
                        null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 26, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("Botany", "pigment", 1, 10, missing),
                        getModItem("Botany", "pigment", 1, 10, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 26, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32422, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32422, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 26, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 7, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 7, missing), null, null,
                        null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 27, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "dye", 1, 7, missing), getModItem("minecraft", "dye", 1, 7, missing),
                        null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 27, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 8, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 8, missing), null, null,
                        null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 27, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32421, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32421, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 27, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("Botany", "pigment", 1, 35, missing),
                        getModItem("Botany", "pigment", 1, 35, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 28, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "dye", 1, 6, missing), getModItem("minecraft", "dye", 1, 6, missing),
                        null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 28, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("Botany", "pigment", 1, 8, missing), getModItem("Botany", "pigment", 1, 8, missing),
                        null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 28, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32420, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32420, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 28, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 9, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 9, missing), null, null,
                        null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 29, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "dye", 1, 5, missing), getModItem("minecraft", "dye", 1, 5, missing),
                        null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 29, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("Botany", "pigment", 1, 20, missing),
                        getModItem("Botany", "pigment", 1, 20, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 29, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 10, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 10, missing), null,
                        null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 29, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32419, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32419, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 30, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "dye", 1, 4, missing), getModItem("minecraft", "dye", 1, 15, missing),
                        null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 30, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("BiomesOPlenty", "misc", 1, 5, missing),
                        getModItem("minecraft", "dye", 1, 5, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 30, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ExtraBees", "misc", 1, 21, missing),
                        getModItem("ExtraBees", "misc", 1, 21, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 30, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("Botany", "pigment", 1, 24, missing),
                        getModItem("Botany", "pigment", 1, 24, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 30, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 11, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 11, missing), null,
                        null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 30, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32418, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32418, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 30, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32410, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32410, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 31, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("BiomesOPlenty", "misc", 1, 6, missing),
                        getModItem("BiomesOPlenty", "misc", 1, 6, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 31, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ExtraBees", "misc", 1, 25, missing),
                        getModItem("ExtraBees", "misc", 1, 25, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 31, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "dye", 1, 3, missing), getModItem("minecraft", "dye", 1, 3, missing),
                        null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 31, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("Botany", "pigment", 1, 65, missing),
                        getModItem("Botany", "pigment", 1, 65, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 31, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32417, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32417, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 31, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 12, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 12, missing), null,
                        null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 32, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "dye", 1, 2, missing), getModItem("minecraft", "dye", 1, 2, missing),
                        null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 32, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("BiomesOPlenty", "misc", 1, 7, missing),
                        getModItem("BiomesOPlenty", "misc", 1, 7, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 32, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ExtraBees", "misc", 1, 22, missing),
                        getModItem("ExtraBees", "misc", 1, 22, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 32, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("Botany", "pigment", 1, 28, missing),
                        getModItem("Botany", "pigment", 1, 28, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 32, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 13, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 13, missing), null,
                        null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 32, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32416, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32416, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 33, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "dye", 1, 1, missing), getModItem("minecraft", "dye", 1, 1, missing),
                        null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 33, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ExtraBees", "misc", 1, 19, missing),
                        getModItem("ExtraBees", "misc", 1, 19, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 33, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("Botany", "pigment", 1, 59, missing),
                        getModItem("Botany", "pigment", 1, 59, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 33, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 14, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 14, missing), null,
                        null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 33, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32415, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32415, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 34, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "dye", 1, 0, missing), getModItem("minecraft", "dye", 1, 0, missing),
                        null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 34, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("BiomesOPlenty", "misc", 1, 9, missing),
                        getModItem("BiomesOPlenty", "misc", 1, 9, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 34, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ExtraBees", "misc", 1, 24, missing),
                        getModItem("ExtraBees", "misc", 1, 24, missing), null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 34, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("Botany", "pigment", 1, 1, missing), getModItem("Botany", "pigment", 1, 1, missing),
                        null, null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 34, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 15, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 1, 15, missing), null,
                        null, null, null, null });
        addShapedRecipe(
                getModItem("ProjRed|Core", "projectred.core.part", 4, 34, missing),
                new Object[] { getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32414, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32414, missing), null, null, null, null, null });
    }

    private void recipes1() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(200).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 1, missing),
                        getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 0, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 2000, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 1, missing),
                        getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 1, missing),
                        getModItem("minecraft", "redstone", 3, 0, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 1, missing),
                        getModItem("minecraft", "redstone_torch", 1, 0, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 5, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 24502, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 6, missing)).noFluidInputs()
                .noFluidOutputs().duration(500).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 24512, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 6, missing)).noFluidInputs()
                .noFluidOutputs().duration(500).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 23874, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 9, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 20879, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.datacard", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(200).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.screwdriver", 1, 0, missing),
                        getModItem("ProjRed|Expansion", "projectred.expansion.battery", 1, 0, missing))
                .itemOutputs(
                        getModItem("ProjRed|Expansion", "projectred.expansion.electric_screwdriver", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transmission", "projectred.transmission.wire", 5, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 5, 17880, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing))
                .noFluidInputs().noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transmission", "projectred.transmission.wire", 5, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 5, 17635, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing))
                .noFluidInputs().noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transmission", "projectred.transmission.wire", 5, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 5, 17471, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 17, missing))
                .noFluidInputs().noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 22032, missing))
                .itemOutputs(getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glass_pane", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 22032, missing))
                .itemOutputs(getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 4, 0, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 13, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 26019, missing))
                .itemOutputs(getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 4, 1, missing))
                .noFluidInputs().noFluidOutputs().duration(800).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing))
                .itemOutputs(getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(400).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17500, missing))
                .itemOutputs(getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 864)).noFluidOutputs().duration(400).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 1, missing),
                        getModItem("minecraft", "magma_cream", 4, 0, missing))
                .itemOutputs(getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lava", 4000)).noFluidOutputs().duration(400).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 0, missing),
                        getModItem("StevesCarts", "ModuleComponents", 1, 60, missing))
                .itemOutputs(getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 9, missing))
                .noFluidInputs().noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing))
                .itemOutputs(getModItem("ProjRed|Fabrication", "projectred.fabrication.icchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(300).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32711, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17526, missing))
                .itemOutputs(getModItem("ProjRed|Fabrication", "projectred.fabrication.icblueprint", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 18879, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("ProjRed|Expansion", "projectred.expansion.plan", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1420, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 4, 44, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1420, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 4, 44, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1420, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 4, 44, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1420, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 4, 44, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1420, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 4, 44, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1420, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 4, 44, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1420, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 4, 44, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1420, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 4, 44, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1420, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 4, 44, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1420, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 4, 44, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1420, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 4, 44, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 4, 0, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.blockmachines", 4, 1420, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 4, 44, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("IC2", "itemPlates", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("IC2", "itemPlates", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("IC2", "itemPlates", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("IC2", "itemPlates", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("Railcraft", "part.plate", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("Railcraft", "part.plate", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("Railcraft", "part.plate", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("Railcraft", "part.plate", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("Railcraft", "part.plate", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("IC2", "itemPlates", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("IC2", "itemPlates", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("IC2", "itemPlates", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("IC2", "itemPlates", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("Railcraft", "part.plate", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("Railcraft", "part.plate", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("Railcraft", "part.plate", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("Railcraft", "part.plate", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("Railcraft", "part.plate", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("IC2", "itemPlates", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("IC2", "itemPlates", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("IC2", "itemPlates", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("IC2", "itemPlates", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("Railcraft", "part.plate", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("Railcraft", "part.plate", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("Railcraft", "part.plate", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("Railcraft", "part.plate", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("Railcraft", "part.plate", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 20, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("IC2", "itemPlates", 1, 2, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17300, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 20, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 4, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("IC2", "itemPlates", 1, 4, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("IC2", "itemPlates", 1, 4, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("IC2", "itemPlates", 1, 4, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("IC2", "itemPlates", 1, 4, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("Railcraft", "part.plate", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("Railcraft", "part.plate", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("Railcraft", "part.plate", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("Railcraft", "part.plate", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("Railcraft", "part.plate", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 4, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("IC2", "itemPlates", 1, 4, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("IC2", "itemPlates", 1, 4, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("IC2", "itemPlates", 1, 4, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("IC2", "itemPlates", 1, 4, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("Railcraft", "part.plate", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("Railcraft", "part.plate", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("Railcraft", "part.plate", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("Railcraft", "part.plate", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("Railcraft", "part.plate", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 4, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("IC2", "itemPlates", 1, 4, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("IC2", "itemPlates", 1, 4, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("IC2", "itemPlates", 1, 4, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("IC2", "itemPlates", 1, 4, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("Railcraft", "part.plate", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("Railcraft", "part.plate", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("Railcraft", "part.plate", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("Railcraft", "part.plate", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("Railcraft", "part.plate", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 32, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("IC2", "itemPlates", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("IC2", "itemPlates", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("IC2", "itemPlates", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17057, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17057, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17057, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17057, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("IC2", "itemPlates", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("IC2", "itemPlates", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("IC2", "itemPlates", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17057, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17057, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17057, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17057, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("IC2", "itemPlates", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("IC2", "itemPlates", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("IC2", "itemPlates", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17057, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17057, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17057, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17057, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 29, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 26, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
    }

    private void recipes2() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("dreamcraft", "item.CircuitMV", 1, 0, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 6, missing),
                        getModItem("Railcraft", "part.plate", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 28, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("IC2", "itemPlates", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("IC2", "itemPlates", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("IC2", "itemPlates", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("IC2", "itemPlates", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("IC2", "itemPlates", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("IC2", "itemPlates", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "itemPlates", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("IC2", "itemPlates", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("IC2", "itemPlates", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("IC2", "itemPlates", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 21, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17019, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17019, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17019, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17019, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17019, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17019, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17019, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17019, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17019, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17019, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17019, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17019, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 30, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17811, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 24, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17811, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 24, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17811, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 24, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17811, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 24, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17811, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 24, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17811, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 24, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17811, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 24, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17811, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 24, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(900).eut(30)
                .addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17811, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 24, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17811, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 24, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17811, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 24, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 44, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17811, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2000, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 2, 24, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.routingchip", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(900)
                .eut(30).addTo(sCircuitAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 6, 56, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32500, missing))
                .itemOutputs(getModItem("ProjRed|Expansion", "projectred.expansion.emptybattery", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(2).addTo(sCannerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 16, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 15, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyered", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 16, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 14, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 16, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 13, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyebrown", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 16, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 12, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 16, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 11, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepurple", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 16, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 10, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyecyan", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 16, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 9, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightgray", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 16, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 8, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegray", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 16, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 7, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepink", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 16, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 6, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelime", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 16, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 5, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeyellow", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 16, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 4, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightblue", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 16, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 3, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyemagenta", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 16, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 2, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 16, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 1, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyewhite", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 17, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 33, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblack", 288))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 17, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 32, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyered", 288))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 17, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 31, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 288))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 17, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 30, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyebrown", 288))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 17, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 29, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 288))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 17, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 28, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepurple", 288))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 17, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 27, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyecyan", 288))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 17, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 26, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightgray", 288))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 17, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 25, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegray", 288))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 17, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 24, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepink", 288))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 17, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 23, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelime", 288))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 17, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 22, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeyellow", 288))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 17, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 21, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightblue", 288))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 17, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 20, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyemagenta", 288))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 17, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 19, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 288))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 17, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 8, 18, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyewhite", 288))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 0, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 13, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 7, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 0, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 14, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 8, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 2020, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32307, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 12, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 42, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32307, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 13, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 43, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32307, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 14, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 58, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32307, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 59, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Exploration", "projectred.exploration.stone", 1, 11, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 9, 56, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 12, missing),
                        getModItem("minecraft", "redstone", 8, 0, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 42, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(30).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 2020, missing),
                        getModItem("minecraft", "glowstone_dust", 8, 0, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 43, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(30).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 2020, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 8, 56, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 58, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(30).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "iron_ingot", 1, 0, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 8, 56, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 57, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(30).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("minecraft", "dye", 2, 15, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 19, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("Botania", "dye", 2, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 19, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("BiomesOPlenty", "misc", 2, 8, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 19, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 32429, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 19, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ExtraBees", "misc", 2, 23, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 19, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 2, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 19, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gendustry", "HoneyDrop", 2, 25, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 19, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("minecraft", "dye", 2, 14, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 20, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("Botania", "dye", 2, 1, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 20, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 32428, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 20, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 2, 1, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 20, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gendustry", "HoneyDrop", 2, 24, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 20, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("minecraft", "dye", 2, 13, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 21, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("Botania", "dye", 2, 2, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 21, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 32427, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 21, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 2, 2, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 21, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gendustry", "HoneyDrop", 2, 23, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 21, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("minecraft", "dye", 2, 12, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 22, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("Botania", "dye", 2, 3, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 22, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 32426, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 22, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 2, 3, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 22, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gendustry", "HoneyDrop", 2, 22, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 22, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("minecraft", "dye", 2, 11, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 23, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("Botania", "dye", 2, 4, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 23, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2931, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 23, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 32425, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 23, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ExtraBees", "misc", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 23, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 2, 4, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 23, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gendustry", "HoneyDrop", 2, 21, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 23, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("minecraft", "dye", 2, 10, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 24, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("Botania", "dye", 2, 5, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 24, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 32424, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 24, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 2, 5, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 24, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gendustry", "HoneyDrop", 2, 20, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 24, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2877, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 24, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("minecraft", "dye", 2, 9, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 25, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("Botania", "dye", 2, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 25, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 32423, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 25, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 2, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 25, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gendustry", "HoneyDrop", 2, 19, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 25, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("minecraft", "dye", 2, 8, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 26, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("Botania", "dye", 2, 7, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 26, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 32422, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 26, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 2, 7, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 26, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gendustry", "HoneyDrop", 2, 18, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 26, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("minecraft", "dye", 2, 7, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 27, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("Botania", "dye", 2, 8, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 27, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 32421, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 27, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 2, 8, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 27, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gendustry", "HoneyDrop", 2, 17, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 27, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("minecraft", "dye", 2, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 28, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("Botania", "dye", 2, 9, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 28, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2524, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 28, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 8524, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 28, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 32420, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 28, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 2, 9, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 28, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gendustry", "HoneyDrop", 2, 16, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 28, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("minecraft", "dye", 2, 5, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 29, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("Botania", "dye", 2, 10, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 29, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 32419, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 29, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 2, 10, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 29, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gendustry", "HoneyDrop", 2, 15, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 29, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("minecraft", "dye", 2, 4, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 30, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("IC2", "itemDust", 2, 12, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 30, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("Botania", "dye", 2, 11, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 30, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("Natura", "barleyFood", 2, 8, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 30, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("BiomesOPlenty", "misc", 2, 5, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 30, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2525, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 30, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2526, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 30, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 8525, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 30, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 32410, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 30, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 32418, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 30, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ExtraBees", "misc", 2, 21, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 30, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 2, 11, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 30, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gendustry", "HoneyDrop", 2, 14, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 30, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("minecraft", "dye", 2, 3, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 31, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("GalacticraftAmunRa", "item.baseItem", 2, 29, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 31, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("Botania", "dye", 2, 12, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 31, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("BiomesOPlenty", "misc", 2, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 31, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("harvestcraft", "cocoapowderItem", 2, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 31, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2887, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 31, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2888, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 31, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2930, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 31, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 32417, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 31, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("IC2", "itemCofeePowder", 2, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 31, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ExtraBees", "misc", 2, 25, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 31, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 2, 12, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 31, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gendustry", "HoneyDrop", 2, 13, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 31, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("minecraft", "dye", 2, 2, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 32, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("Botania", "dye", 2, 13, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 32, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("BiomesOPlenty", "misc", 2, 7, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 32, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 32416, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 32, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ExtraBees", "misc", 2, 22, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 32, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 2, 13, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 32, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gendustry", "HoneyDrop", 2, 12, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 32, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("minecraft", "dye", 2, 1, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 33, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("Botania", "dye", 2, 14, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 33, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 32415, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 33, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ExtraBees", "misc", 2, 19, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 33, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 2, 14, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 33, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gendustry", "HoneyDrop", 2, 11, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 33, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("minecraft", "dye", 2, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 34, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("Botania", "dye", 2, 15, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 34, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("BiomesOPlenty", "misc", 2, 9, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 34, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 32414, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 34, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ForbiddenMagic", "FMResource", 2, 1, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 34, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ThaumicHorizons", "inkEgg", 2, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 34, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ExtraBees", "misc", 2, 24, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 34, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("ProjRed|Exploration", "projectred.exploration.lilyseed", 2, 15, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 34, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glowstone_dust", 2, 0, missing),
                        getModItem("gendustry", "HoneyDrop", 2, 10, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("ProjRed|Core", "projectred.core.part", 8, 34, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(8).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17880, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(8).addTo(sBoxinatorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17635, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(8).addTo(sBoxinatorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17471, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(8).addTo(sBoxinatorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.ElectrotineWire", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17880, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 34, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(8).addTo(sBoxinatorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.ElectrotineWire", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17635, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 34, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(8).addTo(sBoxinatorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.ElectrotineWire", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17471, missing))
                .itemOutputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 34, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(8).addTo(sBoxinatorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 16, missing))
                .itemOutputs(
                        getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17880, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(8).addTo(sUnboxinatorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 34, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.ElectrotineWire", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17880, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(8).addTo(sUnboxinatorRecipes);

    }
}
