package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.Smeltery;
import cpw.mods.fml.common.registry.GameRegistry;
import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;
import gregtech.api.util.GT_ModHandler;

public class ScriptCoreMod implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Core Mod";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.TinkerConstruct.ID, Mods.BartWorks.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("dreamcraft", "item.SandStoneRod", 1, 0, missing),
                new Object[] { "craftingToolFile", "sandstone", "craftingToolSaw" });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 23299, missing),
                new Object[] { "craftingToolFile", "cobblestone", "craftingToolSaw" });
        addShapedRecipe(
                getModItem("dreamcraft", "item.LongObsidianRod", 2, 0, missing),
                new Object[] { "craftingToolSaw", "stoneObsidian", "craftingToolFile" });
        addShapedRecipe(
                getModItem("dreamcraft", "item.LongStoneRod", 2, 0, missing),
                new Object[] { "craftingToolSaw", "stone", "craftingToolFile" });
        addShapedRecipe(
                getModItem("dreamcraft", "item.MushroomPowder", 1, 0, missing),
                new Object[] { "listAllmushroom", null, null, "craftingToolMortar", null, null, null, null, null });
        addShapedRecipe(
                getModItem("dreamcraft", "item.Display", 1, 0, missing),
                new Object[] { "platePlastic", getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing),
                        "platePlastic", "circuitBasic", "cableGt01Tin", "circuitBasic", "screwIron",
                        "craftingToolScrewdriver", "screwIron" });
        addShapedRecipe(
                getModItem("dreamcraft", "item.LaserEmitter", 1, 0, missing),
                new Object[] { "itemCasingTitanium", "lensRuby", "itemCasingTitanium",
                        getModItem("IC2", "reactorCoolantSix", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing),
                        getModItem("IC2", "reactorCoolantSix", 1, 1, missing), "plateAlloyAdvanced",
                        "plateAlloyAdvanced", "plateAlloyAdvanced" });
        addShapedRecipe(
                getModItem("dreamcraft", "item.DiamondDrillTip", 1, 0, missing),
                new Object[] { "plateDiamond", "plateSteel", "plateDiamond", "plateDiamond", "plateSteel",
                        "plateDiamond", "plateSteel", "craftingToolHardHammer", "plateSteel" });
        addShapedRecipe(
                getModItem("dreamcraft", "item.ReinforcedIridiumDrillTip", 1, 0, missing),
                new Object[] { "plateAlloyIridium", "plateSteel", "plateAlloyIridium", "plateAlloyIridium",
                        "plateSteel", "plateAlloyIridium", "plateSteel", "craftingToolHardHammer", "plateSteel" });
        addShapedRecipe(
                getModItem("dreamcraft", "item.SawBladeDiamond", 1, 0, missing),
                new Object[] { "plateDiamond", "plateDiamond", null, "craftingToolFile", "craftingToolHardHammer",
                        null });
        addShapedRecipe(
                getModItem("dreamcraft", "item.SawBladeStone", 1, 0, missing),
                new Object[] { "plateStone", "plateStone", null, "craftingToolFile", "craftingToolHardHammer", null });
        addShapedRecipe(
                getModItem("dreamcraft", "item.SawBladeArdite", 1, 0, missing),
                new Object[] { "plateArdite", "plateArdite", null, "craftingToolFile", "craftingToolHardHammer",
                        null });
        addShapedRecipe(
                getModItem("dreamcraft", "item.SawBladeManyullyn", 1, 0, missing),
                new Object[] { "plateManyullyn", "plateManyullyn", null, "craftingToolFile", "craftingToolHardHammer",
                        null });
        addShapedRecipe(
                getModItem("dreamcraft", "item.SawBladeRuby", 1, 0, missing),
                new Object[] { "plateRuby", "plateRuby", null, "craftingToolFile", "craftingToolHardHammer", null });
        addShapedRecipe(
                getModItem("dreamcraft", "item.SawBladeSapphire", 1, 0, missing),
                new Object[] { "plateSapphire", "plateSapphire", null, "craftingToolFile", "craftingToolHardHammer",
                        null });
        addShapedRecipe(
                getModItem("dreamcraft", "item.SawBladePeridot", 1, 0, missing),
                new Object[] { "platePeridot", "platePeridot", null, "craftingToolFile", "craftingToolHardHammer",
                        null });
        addShapedRecipe(
                getModItem("dreamcraft", "item.BowFletchingCast", 1, 0, missing),
                new Object[] { null, null, "craftingToolHardHammer", null,
                        getModItem("TConstruct", "blankPattern", 1, 1, missing), "craftingToolKnife", null, null,
                        "craftingToolFile" });
        addShapedRecipe(
                getModItem("dreamcraft", "item.BowFletchingCast", 1, 0, missing),
                new Object[] { null, null, "craftingToolHardHammer", null, "plateBrass", "craftingToolKnife", null,
                        null, "craftingToolFile" });
        addShapedRecipe(
                getModItem("dreamcraft", "item.BowStringCast", 1, 0, missing),
                new Object[] { null, null, null, null, getModItem("TConstruct", "blankPattern", 1, 1, missing),
                        "craftingToolHardHammer", null, "craftingToolFile", "craftingToolKnife" });
        addShapedRecipe(
                getModItem("dreamcraft", "item.BowStringCast", 1, 0, missing),
                new Object[] { null, null, null, null, "plateBrass", "craftingToolHardHammer", null, "craftingToolFile",
                        "craftingToolKnife" });
        addShapedRecipe(
                getModItem("minecraft", "coal", 1, 1, missing),
                new Object[] { getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null, null, null, null, null,
                        null, null, null });
        addShapedRecipe(
                getModItem("minecraft", "redstone", 1, 0, missing),
                new Object[] { null, getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null, null, null, null,
                        null, null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2890, missing),
                new Object[] { null, null, getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null, null, null,
                        null, null, null });
        addShapedRecipe(
                getModItem("minecraft", "string", 1, 0, missing),
                new Object[] { null, null, null, null, getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null,
                        null, null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2805, missing),
                new Object[] { null, null, null, getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null, null,
                        null, null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2299, missing),
                new Object[] { null, null, null, null, null, getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        null, null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 1802, missing),
                new Object[] { null, null, null, null, null, null,
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2934, missing),
                new Object[] { getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2823, missing),
                new Object[] { null, null, getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null, null,
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2022, missing),
                new Object[] { getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null,
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2939, missing),
                new Object[] { null, getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2032, missing),
                new Object[] { getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null, null,
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2057, missing),
                new Object[] { getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null,
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2034, missing),
                new Object[] { getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2035, missing),
                new Object[] { null, getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null, null,
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2896, missing),
                new Object[] { null, null, null, null, null, getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        null, getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2804, missing),
                new Object[] { getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 1625, missing),
                new Object[] { null, null, getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2304, missing),
                new Object[] { getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null,
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing) });
        addShapedRecipe(
                getModItem("IC2", "itemHarz", 1, 0, missing),
                new Object[] { getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 39, missing),
                new Object[] { getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null,
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null,
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "materials", 1, 40, missing),
                new Object[] { getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 1054, missing),
                new Object[] { getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null,
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2086, missing),
                new Object[] { getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null,
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 37, missing),
                new Object[] { getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null,
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "leather", 1, 0, missing),
                new Object[] { getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing), null,
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 1343, missing),
                new Object[] { getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing),
                        getModItem("OpenBlocks", "filledbucket", 1, 0, missing) });
        addShapedRecipe(
                getModItem("dreamcraft", "item.RawSDHCAlloy", 1, 0, missing),
                new Object[] { "screwStainlessSteel", "craftingToolScrewdriver", "screwStainlessSteel",
                        getModItem("GalaxySpace", "item.CompressedDualBronze", 1, 0, missing),
                        getModItem("GalaxySpace", "item.CompressedCoal", 1, 0, missing),
                        getModItem("GalaxySpace", "item.CompressedDualAluminium", 1, 0, missing), "screwStainlessSteel",
                        "craftingToolHardHammer", "screwStainlessSteel" });
        addShapedRecipe(
                createItemStack("dreamcraft", "item.OvenGlove", 1, 0, "{Durability:1000}", missing),
                new Object[] { getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "itemLeather",
                        getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "itemLeather",
                        getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "itemLeather",
                        getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "string", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack("dreamcraft", "item.OvenGlove", 1, 0, "{Durability:1000}", missing),
                new Object[] { getModItem("dreamcraft", "item.OvenGlove", 1, 0, missing), "itemLeather", "itemLeather",
                        "itemLeather" });
        addShapedRecipe(
                createItemStack("dreamcraft", "item.OvenGlove", 1, 1, "{Durability:1000}", missing),
                new Object[] { "itemLeather", getModItem("harvestcraft", "wovencottonItem", 1, 0, missing),
                        "itemLeather", getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "itemLeather",
                        getModItem("harvestcraft", "wovencottonItem", 1, 0, missing),
                        getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "string", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack("dreamcraft", "item.OvenGlove", 1, 1, "{Durability:1000}", missing),
                new Object[] { getModItem("dreamcraft", "item.OvenGlove", 1, 1, missing), "itemLeather", "itemLeather",
                        "itemLeather" });
        addShapedRecipe(
                getModItem("dreamcraft", "tile.DiamondFrameBox", 1, 0, missing),
                new Object[] { "stickDiamond", "stickDiamond", "stickDiamond", "stickDiamond", "craftingToolWrench",
                        "stickDiamond", "stickDiamond", "stickDiamond", "stickDiamond" });
        addShapedRecipe(
                getModItem("dreamcraft", "item.MoldFormCoinage", 1, 0, missing),
                new Object[] { null, null, null, null, getModItem("TConstruct", "blankPattern", 1, 1, missing), null,
                        "craftingToolFile", "craftingToolWireCutter", null });

        GT_ModHandler.addSmeltingRecipe(
                getModItem("dreamcraft", "item.UnfiredCokeOvenBrick", 1, 0, missing),
                getModItem("dreamcraft", "item.CokeOvenBrick", 1, 0, missing));

        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeBolt", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeHoeHead", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeGear", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapePlate", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormAnvil", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormPlate", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormLeggings", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormBaguette", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormGear", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormRotor", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeBottle", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeRotor", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeTurbineBlade", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeSmallGear", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormBoots", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeLargePipe", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormSmallGear", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormCasing", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeWire", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormChestplate", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeShovelHead", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormBread", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeIngot", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormIngot", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeFileHead", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeRod", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeHugePipe", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeSwordBlade", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeRing", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeCasing", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormNuggets", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeSmallPipe", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormName", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeHammerHead", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeTinyPipe", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormCylinder", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormBottle", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeAxeHead", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeSawBlade", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormBlock", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeCell", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormArrowHead", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeBoat", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormCoinage", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormBall", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeBlock", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormHelmet", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapePickaxeHead", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormBuns", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ShapeNormalPipe", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MarshmallowFormMold", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormStick", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormStickLong", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormScrew", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormRing", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormBolt", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormRound", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormTurbineBlade", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormPipeTiny", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormPipeSmall", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormPipeMedium", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormPipeLarge", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldFormPipeHuge", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.LedoxDust", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.LedoxIngot", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 9, 11388, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.BlackPlutonium", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.MytrylIngot", 9, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.Mytryl", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.blockgem3", 9, 4, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.CompressedCharcoal", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "coal_block", 9, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.CompressedCoal", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Railcraft", "cube", 9, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.CompressedCoalCoke", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "tile.CompressedCharcoal", 9, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.DoubleCompressedCharcoal", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "tile.CompressedCoal", 9, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.DoubleCompressedCoal", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "tile.CompressedCoalCoke", 9, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.DoubleCompressedCoalCoke", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "tile.DoubleCompressedCharcoal", 9, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.TripleCompressedCharcoal", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "tile.DoubleCompressedCoal", 9, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.TripleCompressedCoal", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "tile.DoubleCompressedCoalCoke", 9, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.TripleCompressedCoalCoke", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "tile.TripleCompressedCharcoal", 9, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.QuadrupleCompressedCharcoal", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "tile.TripleCompressedCoal", 9, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.QuadrupleCompressedCoal", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "tile.TripleCompressedCoalCoke", 9, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.QuadrupleCompressedCoalCoke", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("dreamcraft", "tile.QuadrupleCompressedCharcoal", 9, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.QuintupleCompressedCharcoal", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "tile.QuadrupleCompressedCoal", 9, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.QuintupleCompressedCoal", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem("dreamcraft", "tile.QuadrupleCompressedCoalCoke", 9, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.QuintupleCompressedCoalCoke", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.ChargedCertusQuartzDust", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.ChargedCertusQuartzPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.BioBall", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.CompressedBioBall", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.BioOrganicMesh", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.BioCarbonPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Railcraft", "machine.alpha", 1, 7, missing))
                .itemOutputs(getModItem("dreamcraft", "item.CokeOvenBrick", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Railcraft", "machine.alpha", 1, 12, missing))
                .itemOutputs(getModItem("dreamcraft", "item.AdvancedCokeOvenBrick", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("seedoil", 500),
                getModItem("Forestry", "sturdyMachine", 1, 0, missing),
                getModItem("dreamcraft", "item.EngineCore", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                'e',
                getModItem("minecraft", "piston", 1, 0, missing));
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("dreamcraft", "item.ExtruderShapeBoat", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeBoat", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("dreamcraft", "item.MoldBoots", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormBoots", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("dreamcraft", "item.MoldChestplate", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormChestplate", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("dreamcraft", "item.MoldHelmet", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormHelmet", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("dreamcraft", "item.MoldLeggings", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormLeggings", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("dreamcraft", "item.MarshmallowForm", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MarshmallowFormMold", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("dreamcraft", "item.BowFletchingCast", 1, 0, missing),
                FluidRegistry.getFluidStack("aluminumbrass.molten", 144),
                getModItem("TConstruct", "fletching", 1, 32767, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("dreamcraft", "item.BowStringCast", 1, 0, missing),
                FluidRegistry.getFluidStack("aluminumbrass.molten", 144),
                getModItem("TConstruct", "bowstring", 1, 32767, missing),
                true,
                100);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 22327, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EnrichedNaquadriaSunnariumAlloy", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(2000).eut(500000).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.EnrichedNaquadriaSunnariumAlloy", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 22129, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EnrichedNaquadriaNeutroniumSunnariumAlloy", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(2400).eut(2000000).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.EnrichedNaquadriaNeutroniumSunnariumAlloy", 1, 0, missing),
                        getModItem("dreamcraft", "item.BedrockiumPlate", 18, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EnrichedXSunnariumAlloy", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(2800).eut(8000000).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "blockAlloy", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 6, 17300, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.BronzePlatedReinforcedStone", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 144)).noFluidOutputs().duration(200).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "blockAlloy", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 6, 17305, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.SteelPlatedReinforcedStone", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).noFluidOutputs().duration(250)
                .eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "blockAlloy", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 6, 17028, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.TitaniumPlatedReinforcedStone", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.platinum", 144)).noFluidOutputs().duration(300).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "blockAlloy", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 6, 17316, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.TungstensteelPlatedReinforcedStone", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iridium", 144)).noFluidOutputs().duration(350).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "blockAlloy", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 6, 17324, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.NaquadahPlatedReinforcedStone", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.osmium", 144)).noFluidOutputs().duration(450).eut(256)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "blockAlloy", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 6, 17129, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.NeutroniumPlatedReinforcedStone", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.naquadria", 144)).noFluidOutputs().duration(500)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftMars", "item.itemBasicAsteroids", 2, 6, missing),
                        getModItem("GalacticraftCore", "item.basicItem", 2, 14, missing))
                .itemOutputs(getModItem("dreamcraft", "item.LightBinding", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.RawBioFiber", 2, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("dreamcraft", "item.BioOrganicMesh", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(800).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockgem3", 1, 4, missing),
                        getModItem("dreamcraft", "item.CompressedBioBall", 8, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.BioChunk", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 23500, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.DiamondFrameBox", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(64).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stone", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2865, missing))
                .itemOutputs(getModItem("dreamcraft", "tile.CompressedGraphite", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("RIO", "item.chip.location", 1, 0, missing),
                        getModItem("RIO", "item.blank_plate", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.BlankPlatedChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("dreamcraft", "item.PulsatingSpatialCoreChip", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngineeringProcessorSpatialPulsatingCore", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(7680).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("dreamcraft", "item.DiamondFluidCoreChip", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngineeringProcessorFluidDiamondCore", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("dreamcraft", "item.EmeraldAdvancedFluidCoreChip", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngineeringProcessorFluidEmeraldCore", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(7680).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem("dreamcraft", "item.GoldCoreChip", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.LogicProcessorItemGoldCore", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("dreamcraft", "item.DiamondCoreChip", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngineeringProcessorItemDiamondCore", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("dreamcraft", "item.EmeraldAdvancedCoreChip", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngineeringProcessorItemEmeraldCore", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(7680).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem("dreamcraft", "item.EmeraldHighAdvancedCoreChip", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngineeringProcessorItemAdvEmeraldCore", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(100).eut(30720).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalaxySpace", "item.CompressedPlates", 1, 3, missing),
                        getModItem("GalaxySpace", "item.CompressedPlates", 1, 6, missing))
                .itemOutputs(getModItem("dreamcraft", "item.LeadNickelPlate", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 2000)).noFluidOutputs().duration(600).eut(1024)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.ReinforcedAluminiumIronPlate", 1, 0, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 6, missing),
                        getModItem("IC2", "itemPartIndustrialDiamond", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17308, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 27308, missing))
                .itemOutputs(getModItem("dreamcraft", "item.IrradiantReinforcedAluminiumPlate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 144)).noFluidOutputs().duration(600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.ReinforcedTitaniumIronPlate", 1, 0, missing),
                        getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17341, missing),
                        getModItem("IC2", "itemPlates", 2, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 27308, missing))
                .itemOutputs(getModItem("dreamcraft", "item.IrradiantReinforcedTitaniumPlate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs().duration(600)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.ReinforcedTitaniumIronPlate", 1, 0, missing),
                        getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17341, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17526, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 27308, missing))
                .itemOutputs(getModItem("dreamcraft", "item.IrradiantReinforcedTitaniumPlate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).noFluidOutputs().duration(600)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.ReinforcedTungstenIronPlate", 1, 0, missing),
                        getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17098, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17339, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 27308, missing))
                .itemOutputs(getModItem("dreamcraft", "item.IrradiantReinforcedTungstenPlate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 576)).noFluidOutputs().duration(600)
                .eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.ReinforcedTungstenSteelIronPlate", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 20318, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17100, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17362, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 27308, missing))
                .itemOutputs(getModItem("dreamcraft", "item.IrradiantReinforcedTungstenSteelPlate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 1152)).noFluidOutputs().duration(600)
                .eut(7680).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.ReinforcedChromeIronPlate", 1, 0, missing),
                        getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17358, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17346, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 27308, missing))
                .itemOutputs(getModItem("dreamcraft", "item.IrradiantReinforcedChromePlate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 2304)).noFluidOutputs().duration(600)
                .eut(30720).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 7, missing),
                        getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17083, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17084, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 27308, missing))
                .itemOutputs(getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 4608)).noFluidOutputs().duration(600)
                .eut(122880).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.ReinforcedNaquadriaIronPlate", 1, 0, missing),
                        getModItem("dreamcraft", "item.EnrichedNaquadriaSunnariumAlloy", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17391, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17317, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 27308, missing))
                .itemOutputs(getModItem("dreamcraft", "item.IrradiantReinforcedNaquadriaPlate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 9216)).noFluidOutputs().duration(600)
                .eut(500000).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.ReinforcedNaquadriaIronPlate", 1, 0, missing),
                        getModItem("dreamcraft", "item.EnrichedNaquadriaSunnariumAlloy", 1, 0, missing),
                        getModItem("dreamcraft", "item.QuantinumPlate", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17317, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 27308, missing))
                .itemOutputs(getModItem("dreamcraft", "item.IrradiantReinforcedNaquadriaPlate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 9216)).noFluidOutputs().duration(600)
                .eut(500000).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.ReinforcedNeutroniumIronPlate", 1, 0, missing),
                        getModItem("dreamcraft", "item.EnrichedNaquadriaNeutroniumSunnariumAlloy", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17398, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17397, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 27308, missing))
                .itemOutputs(getModItem("dreamcraft", "item.IrradiantReinforcedNeutroniumPlate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 18432)).noFluidOutputs().duration(600)
                .eut(2000000).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.ReinforcedNeutroniumIronPlate", 1, 0, missing),
                        getModItem("dreamcraft", "item.EnrichedNaquadriaNeutroniumSunnariumAlloy", 1, 0, missing),
                        getModItem("dreamcraft", "item.MysteriousCrystalPlate", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17397, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 27308, missing))
                .itemOutputs(getModItem("dreamcraft", "item.IrradiantReinforcedNeutroniumPlate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 18432)).noFluidOutputs().duration(600)
                .eut(2000000).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.ReinforcedBedrockiumIronPlate", 1, 0, missing),
                        getModItem("dreamcraft", "item.EnrichedXSunnariumAlloy", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17976, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17394, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 27308, missing))
                .itemOutputs(getModItem("dreamcraft", "item.IrradiantReinforcedBedrockiumPlate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36864)).noFluidOutputs().duration(600)
                .eut(8000000).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2398, missing))
                .itemOutputs(getModItem("GalaxySpace", "item.UnknowCrystal", 1, 0, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).noFluidOutputs().duration(3600).eut(480)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2398, missing))
                .itemOutputs(getModItem("GalaxySpace", "item.UnknowCrystal", 1, 0, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 800)).noFluidOutputs().duration(2400)
                .eut(480).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2398, missing))
                .itemOutputs(getModItem("GalaxySpace", "item.UnknowCrystal", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 288)).noFluidOutputs().duration(1200).eut(480)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemFuelPlantBall", 16, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.RawBioFiber", 1, 0, missing)).outputChances(3300)
                .fluidInputs(FluidRegistry.getFluidStack("ic2biomass", 8)).noFluidOutputs().duration(200).eut(20)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemFuelPlantBall", 16, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.RawBioFiber", 1, 0, missing)).outputChances(5000)
                .fluidInputs(FluidRegistry.getFluidStack("methanol", 8)).noFluidOutputs().duration(150).eut(20)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemFuelPlantBall", 16, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.RawBioFiber", 1, 0, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("fuel", 8)).noFluidOutputs().duration(100).eut(20)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemFuelPlantBall", 16, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.RawBioFiber", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("nitrofuel", 8)).noFluidOutputs().duration(50).eut(20)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2098, missing)).noItemOutputs()
                .fluidInputs(FluidRegistry.getFluidStack("bacterialsludge", 750))
                .fluidOutputs(FluidRegistry.getFluidStack("enrichedbacterialsludge", 750)).duration(128).eut(4)
                .addTo(sBrewingRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 97, missing)).noItemOutputs()
                .fluidInputs(FluidRegistry.getFluidStack("bacterialsludge", 750))
                .fluidOutputs(FluidRegistry.getFluidStack("enrichedbacterialsludge", 750)).duration(128).eut(4)
                .addTo(sBrewingRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemPartIridium", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.IridiumAlloyItemCasing", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 288)).noFluidOutputs().duration(1200).eut(256)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemPartIridium", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.IridiumAlloyItemCasing", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 160)).noFluidOutputs().duration(1200)
                .eut(256).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemPartIridium", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.IridiumAlloyItemCasing", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 64)).noFluidOutputs().duration(600).eut(256)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "tile.CallistoColdIce", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.CallistoIcePlate", 9, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 1000)).noFluidOutputs().duration(3600).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                .fluidInputs(FluidRegistry.getFluidStack("enrichedbacterialsludge", 750))
                .fluidOutputs(FluidRegistry.getFluidStack("fermentedbacterialsludge", 75)).duration(2400).eut(2)
                .addTo(sFermentingRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17500, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngravedDiamondCrystalChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(1920).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24502, missing),
                        getModItem("IC2", "itemBatCrystal", 1, 32767, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngravedEnergyChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(4096).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24511, missing),
                        getModItem("IC2", "itemBatCrystal", 1, 32767, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngravedEnergyChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(4096).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24512, missing),
                        getModItem("IC2", "itemBatCrystal", 1, 32767, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngravedEnergyChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(4096).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24527, missing),
                        getModItem("IC2", "itemBatCrystal", 1, 32767, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngravedEnergyChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(4096).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24541, missing),
                        getModItem("IC2", "itemBatCrystal", 1, 32767, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngravedEnergyChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(4096).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24540, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30528, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngravedQuantumChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(30720).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24521, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30528, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngravedQuantumChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(30720).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24528, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30528, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngravedQuantumChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(30720).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24533, missing),
                        getModItem("IC2", "itemBatCrystal", 1, 32767, missing))
                .itemOutputs(getModItem("dreamcraft", "item.NanoCrystal", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(480).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24532, missing),
                        getModItem("IC2", "itemBatCrystal", 1, 32767, missing))
                .itemOutputs(getModItem("dreamcraft", "item.NanoCrystal", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(480).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24533, missing),
                        getModItem("IC2", "itemBatLamaCrystal", 1, 32767, missing))
                .itemOutputs(getModItem("dreamcraft", "item.QuantumCrystal", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(800).eut(1920).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24532, missing),
                        getModItem("IC2", "itemBatLamaCrystal", 1, 32767, missing))
                .itemOutputs(getModItem("dreamcraft", "item.QuantumCrystal", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(800).eut(1920).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24508, missing),
                        getModItem("dreamcraft", "item.ManyullynPlate", 4, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.ManyullynCrystal", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(1920).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24509, missing),
                        getModItem("dreamcraft", "item.ManyullynPlate", 4, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.ManyullynCrystal", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(1920).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24508, missing),
                        getModItem("dreamcraft", "item.ManyullynCrystal", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngravedManyullynCrystalChip", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(900).eut(7680).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24509, missing),
                        getModItem("dreamcraft", "item.ManyullynCrystal", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngravedManyullynCrystalChip", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(900).eut(7680).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24506, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngravedGoldChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24515, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngravedGoldChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24545, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngravedGoldChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24890, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngravedGoldChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EngravedGoldChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sLaserEngraverRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .noItemOutputs().fluidInputs(FluidRegistry.getFluidStack("fermentedbacterialsludge", 100))
                .fluidOutputs(FluidRegistry.getFluidStack("mutagen", 10)).duration(600).eut(1920)
                .addTo(sDistilleryRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32357, missing))
                .itemOutputs(getModItem("dreamcraft", "item.IridiumAlloyItemCasing", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(384).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "materials", 2, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32371, missing))
                .itemOutputs(getModItem("dreamcraft", "item.SawBladeArdite", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "materials", 2, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32371, missing))
                .itemOutputs(getModItem("dreamcraft", "item.SawBladeManyullyn", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "materials", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32350, missing))
                .itemOutputs(getModItem("dreamcraft", "item.ManyullynPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(480).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "feather", 1, 0, missing),
                        getModItem("dreamcraft", "item.BowFletchingCast", 0, 0, missing))
                .itemOutputs(getModItem("TConstruct", "fletching", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "materials", 1, 1, missing),
                        getModItem("dreamcraft", "item.BowFletchingCast", 0, 0, missing))
                .itemOutputs(getModItem("TConstruct", "fletching", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "materials", 1, 17, missing),
                        getModItem("dreamcraft", "item.BowFletchingCast", 0, 0, missing))
                .itemOutputs(getModItem("TConstruct", "fletching", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "leaves", 1, 0, missing),
                        getModItem("dreamcraft", "item.BowFletchingCast", 0, 0, missing))
                .itemOutputs(getModItem("TConstruct", "fletching", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "slime.leaves", 1, 0, missing),
                        getModItem("dreamcraft", "item.BowFletchingCast", 0, 0, missing))
                .itemOutputs(getModItem("TConstruct", "fletching", 1, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "string", 3, 0, missing),
                        getModItem("dreamcraft", "item.BowStringCast", 0, 0, missing))
                .itemOutputs(getModItem("TConstruct", "bowstring", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(30).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "barleyFood", 3, 7, missing),
                        getModItem("dreamcraft", "item.BowStringCast", 0, 0, missing))
                .itemOutputs(getModItem("TConstruct", "bowstring", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(30).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Thaumcraft", "ItemResource", 3, 7, missing),
                        getModItem("dreamcraft", "item.BowStringCast", 0, 0, missing))
                .itemOutputs(getModItem("TConstruct", "bowstring", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(30).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 1, missing))
                .itemOutputs(getModItem("dreamcraft", "item.ChargedCertusQuartzDust", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(10).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.EngravedManyullynCrystalChip", 1, 0, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 4, missing))
                .itemOutputs(getModItem("dreamcraft", "item.PulsatingSpatialCoreChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(7680).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32714, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 3, missing))
                .itemOutputs(getModItem("dreamcraft", "item.DiamondFluidCoreChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(480).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32714, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 7, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EmeraldAdvancedFluidCoreChip", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(300).eut(1024).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.EngravedGoldChip", 1, 0, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 2, missing))
                .itemOutputs(getModItem("dreamcraft", "item.GoldCoreChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(256).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.EngravedDiamondCrystalChip", 1, 0, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 3, missing))
                .itemOutputs(getModItem("dreamcraft", "item.DiamondCoreChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(480).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.EngravedEnergyChip", 1, 0, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 7, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EmeraldAdvancedCoreChip", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(1024).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.EngravedQuantumChip", 1, 0, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 7, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EmeraldHighAdvancedCoreChip", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(300).eut(4096).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32713, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 4, missing))
                .itemOutputs(getModItem("dreamcraft", "item.GeneticCircuit", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(480).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32713, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 3, missing))
                .itemOutputs(getModItem("dreamcraft", "item.EnvironmentalCircuit", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(480).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17019, missing),
                        getModItem("IC2", "itemPlates", 4, 4, missing))
                .itemOutputs(getModItem("dreamcraft", "item.AluminiumIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17019, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17032, missing))
                .itemOutputs(getModItem("dreamcraft", "item.AluminiumIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17019, missing),
                        getModItem("Railcraft", "part.plate", 4, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.AluminiumIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17028, missing),
                        getModItem("IC2", "itemPlates", 4, 4, missing))
                .itemOutputs(getModItem("dreamcraft", "item.TitaniumIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(480).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17028, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17032, missing))
                .itemOutputs(getModItem("dreamcraft", "item.TitaniumIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(480).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17028, missing),
                        getModItem("Railcraft", "part.plate", 4, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.TitaniumIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(480).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17081, missing),
                        getModItem("IC2", "itemPlates", 4, 4, missing))
                .itemOutputs(getModItem("dreamcraft", "item.TungstenIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(1920).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17081, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17032, missing))
                .itemOutputs(getModItem("dreamcraft", "item.TungstenIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(1920).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17081, missing),
                        getModItem("Railcraft", "part.plate", 4, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.TungstenIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(1920).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17316, missing),
                        getModItem("IC2", "itemPlates", 4, 4, missing))
                .itemOutputs(getModItem("dreamcraft", "item.TungstenSteelIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(7680).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17316, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17032, missing))
                .itemOutputs(getModItem("dreamcraft", "item.TungstenSteelIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(7680).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17316, missing),
                        getModItem("Railcraft", "part.plate", 4, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.TungstenSteelIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(7680).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17030, missing),
                        getModItem("IC2", "itemPlates", 4, 4, missing))
                .itemOutputs(getModItem("dreamcraft", "item.ChromeIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30720).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17030, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17032, missing))
                .itemOutputs(getModItem("dreamcraft", "item.ChromeIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30720).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17030, missing),
                        getModItem("Railcraft", "part.plate", 4, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.ChromeIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30720).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17084, missing),
                        getModItem("IC2", "itemPlates", 4, 4, missing))
                .itemOutputs(getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 6, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(122880).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17084, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17032, missing))
                .itemOutputs(getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 6, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(122880).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17084, missing),
                        getModItem("Railcraft", "part.plate", 4, 0, missing))
                .itemOutputs(getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 6, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(122880).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17327, missing),
                        getModItem("IC2", "itemPlates", 4, 4, missing))
                .itemOutputs(getModItem("dreamcraft", "item.NaquadriaIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(500000).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17327, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17032, missing))
                .itemOutputs(getModItem("dreamcraft", "item.NaquadriaIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(500000).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17327, missing),
                        getModItem("Railcraft", "part.plate", 4, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.NaquadriaIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(500000).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17129, missing),
                        getModItem("IC2", "itemPlates", 4, 4, missing))
                .itemOutputs(getModItem("dreamcraft", "item.NeutroniumIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(2000000).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17129, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17032, missing))
                .itemOutputs(getModItem("dreamcraft", "item.NeutroniumIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(2000000).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17129, missing),
                        getModItem("Railcraft", "part.plate", 4, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.NeutroniumIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(2000000).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17395, missing),
                        getModItem("IC2", "itemPlates", 4, 4, missing))
                .itemOutputs(getModItem("dreamcraft", "item.BedrockiumIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(8000000).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.BedrockiumPlate", 2, 0, missing),
                        getModItem("IC2", "itemPlates", 4, 4, missing))
                .itemOutputs(getModItem("dreamcraft", "item.BedrockiumIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(8000000).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17395, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17032, missing))
                .itemOutputs(getModItem("dreamcraft", "item.BedrockiumIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(8000000).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.BedrockiumPlate", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17032, missing))
                .itemOutputs(getModItem("dreamcraft", "item.BedrockiumIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(8000000).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17395, missing),
                        getModItem("Railcraft", "part.plate", 4, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.BedrockiumIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(8000000).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.BedrockiumPlate", 2, 0, missing),
                        getModItem("Railcraft", "part.plate", 4, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.BedrockiumIronPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(8000000).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "obsidian", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.LongObsidianRod", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(640).eut(16).addTo(sLatheRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "stone", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.LongStoneRod", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(320).eut(16).addTo(sLatheRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("appliedenergistics2", "item.ItemMultiMaterial", 2, 1, missing))
                .itemOutputs(
                        getModItem("dreamcraft", "item.ChargedCertusQuartzRod", 2, 0, missing),
                        getModItem("dreamcraft", "item.ChargedCertusQuartzDust", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(200).eut(16).addTo(sLatheRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "sandstone", 1, 32767, missing))
                .itemOutputs(getModItem("dreamcraft", "item.SandStoneRod", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(160).eut(16).addTo(sLatheRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "cobblestone", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 23299, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 1299, missing))
                .noFluidInputs().noFluidOutputs().duration(160).eut(16).addTo(sLatheRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Forestry", "mushroom", 1, 32767, missing))
                .itemOutputs(getModItem("dreamcraft", "item.MushroomPowder", 2, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "brown_mushroom", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.MushroomPowder", 2, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "mushrooms", 1, 32767, missing))
                .itemOutputs(getModItem("dreamcraft", "item.MushroomPowder", 2, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("harvestcraft", "whitemushroomItem", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.MushroomPowder", 2, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.MoldHelmet", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 4, 2305, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.ExtruderShapeBoat", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 4, 2305, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.MoldLeggings", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 4, 2305, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.MoldBoots", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 4, 2305, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.MoldChestplate", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 4, 2305, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.MarshmallowForm", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 4, 2305, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.AluminiumItemCasing", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 2, 1019, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.StainlessSteelItemCasing", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 2, 1306, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.TitaniumItemCasing", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 2, 1028, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.ChromeItemCasing", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 2, 1030, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.TungstenItemCasing", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 2, 1081, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.TungstenSteelItemCasing", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 2, 1316, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.IridiumItemCasing", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 2, 1084, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.IridiumAlloyItemCasing", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 8, 1084, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.OsmiumItemCasing", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 2, 1083, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.NeutroniumItemCasing", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 2, 1129, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("GalaxySpace", "item.UnknowCrystal", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 2398, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.MysteriousCrystal", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 9, 2398, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.RawMytryl", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.MytrylDust", 1, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "tile.Mytryl", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.MytrylDust", 9, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.MytrylCompressedPlate", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.MytrylDust", 3, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.MytrylIngot", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.MytrylDust", 1, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.MytrylPlate", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.MytrylDust", 1, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.MytrylDensePlate", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.MytrylDust", 9, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.QuantinumDensePlate", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.QuantinumDust", 9, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.QuantinumPlate", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.QuantinumDust", 1, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.QuantinumCompressedPlate", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.QuantinumDust", 3, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.QuantinumRod", 2, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.QuantinumDust", 1, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.BlackPlutoniumDensePlate", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.BlackPlutoniumDust", 18, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.BlackPlutoniumPlate", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.BlackPlutoniumDust", 2, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "tile.CallistoColdIce", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.CallistoIceDust", 9, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.CallistoIcePlate", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.CallistoIceDust", 1, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.CallistoIceCompressedPlate", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.CallistoIceDust", 3, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "tile.Ledox", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.LedoxDust", 9, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.LedoxDensePlate", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.LedoxDust", 9, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.LedoxPlate", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.LedoxDust", 1, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.LedoxCompressedPlate", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.LedoxDust", 3, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 1, missing))
                .itemOutputs(getModItem("dreamcraft", "item.ChargedCertusQuartzDust", 1, 0, missing))
                .outputChances(10000).noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.ChargedCertusQuartzPlate", 1, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.ChargedCertusQuartzDust", 1, 0, missing))
                .outputChances(10000).noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.ChargedCertusQuartzRod", 2, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.ChargedCertusQuartzDust", 1, 0, missing))
                .outputChances(10000).noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.QuantinumPlate", 9, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.QuantinumDensePlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sBenderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.MytrylPlate", 9, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.MytrylDensePlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(120).addTo(sBenderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.LedoxPlate", 9, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.LedoxDensePlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sBenderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.BlackPlutoniumPlate", 9, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.BlackPlutoniumDensePlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(480).addTo(sBenderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 11804, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 17804, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(24).addTo(sBenderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ProjRed|Core", "projectred.core.part", 1, 55, missing))
                .itemOutputs(getModItem("dreamcraft", "item.ElectrotineWire", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(4).addTo(sWiremillRecipes);

    }
}
