package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.RemoteIO;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeConstants.QFT_FOCUS_TIER;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.quantumForceTransformerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.gthandler.CustomItemList;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_OreDictUnificator;
import gtPlusPlus.core.item.ModItems;
import gtPlusPlus.core.item.chemistry.GenericChem;
import gtPlusPlus.core.material.ALLOY;
import gtPlusPlus.core.util.minecraft.ItemUtils;
import gtPlusPlus.xmod.forestry.bees.items.FR_ItemRegistry;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;

public class ScriptGregtechPlusPlus implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "GT++";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Mods.GTPlusPlus.ID,
                Forestry.ID,
                IndustrialCraft2.ID,
                IronTanks.ID,
                RemoteIO.ID,
                EternalSingularity.ID,
                GregTech.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                GregtechItemList.GT4_Thermal_Boiler.get(1),
                getModItem(RemoteIO.ID, "tile.machine", 1, 1, missing),
                ItemList.Machine_HV_Centrifuge.get(1L),
                getModItem(RemoteIO.ID, "tile.machine", 1, 1, missing),
                "gearGtTungstenSteel",
                "circuitElite",
                "gearGtTungstenSteel",
                getModItem(RemoteIO.ID, "tile.machine", 1, 1, missing),
                ItemList.Machine_HV_Centrifuge.get(1L),
                getModItem(RemoteIO.ID, "tile.machine", 1, 1, missing));
        addShapelessRecipe(CustomItemList.CoinBeesI.get(16L), new ItemStack(FR_ItemRegistry.hiveFrameVoid));
        addShapedRecipe(
                ALLOY.TUMBAGA.getRod(1),
                "craftingToolFile",
                null,
                null,
                null,
                ALLOY.TUMBAGA.getIngot(1),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                ALLOY.TUMBAGA.getFrameBox(2),
                ALLOY.TUMBAGA.getRod(1),
                ALLOY.TUMBAGA.getRod(1),
                ALLOY.TUMBAGA.getRod(1),
                ALLOY.TUMBAGA.getRod(1),
                "craftingToolWrench",
                ALLOY.TUMBAGA.getRod(1),
                ALLOY.TUMBAGA.getRod(1),
                ALLOY.TUMBAGA.getRod(1),
                ALLOY.TUMBAGA.getRod(1));
        addShapedRecipe(
                ALLOY.TUMBAGA.getGear(1),
                ALLOY.TUMBAGA.getRod(1),
                ALLOY.TUMBAGA.getPlate(1),
                ALLOY.TUMBAGA.getRod(1),
                ALLOY.TUMBAGA.getPlate(1),
                "craftingToolWrench",
                ALLOY.TUMBAGA.getPlate(1),
                ALLOY.TUMBAGA.getRod(1),
                ALLOY.TUMBAGA.getPlate(1),
                ALLOY.TUMBAGA.getRod(1));
        addShapedRecipe(
                GregtechItemList.Industrial_WireFactory.get(1),
                "plateBlueSteel",
                ItemList.Casing_IV.get(1L),
                "plateBlueSteel",
                "circuitElite",
                ItemList.Machine_IV_Wiremill.get(1L),
                "circuitElite",
                "plateBlueSteel",
                ItemList.Casing_IV.get(1L),
                "plateBlueSteel");
        addShapedRecipe(
                GregtechItemList.Boiler_Advanced_LV.get(1),
                ItemList.Electric_Pump_LV.get(1L),
                "circuitBasic",
                ItemList.Electric_Pump_LV.get(1L),
                new ItemStack(ModItems.itemBoilerChassis, 1, 0),
                ItemList.Casing_LV.get(1L),
                new ItemStack(ModItems.itemBoilerChassis, 1, 0),
                GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Steel, 1L),
                ItemList.Machine_Steel_Boiler.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Steel, 1L));
        addShapedRecipe(
                new ItemStack(ModItems.itemBoilerChassis, 1, 0),
                "plateDoubleLead",
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L),
                "plateDoubleLead",
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.AnyBronze, 1L),
                getModItem(IronTanks.ID, "silverTank", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.AnyBronze, 1L),
                "plateDoubleLead",
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L),
                "plateDoubleLead");
        addShapedRecipe(
                GregtechItemList.Boiler_Advanced_MV.get(1),
                ItemList.Electric_Pump_MV.get(1L),
                "circuitGood",
                ItemList.Electric_Pump_MV.get(1L),
                new ItemStack(ModItems.itemBoilerChassis, 1, 1),
                ItemList.Casing_MV.get(1L),
                new ItemStack(ModItems.itemBoilerChassis, 1, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.StainlessSteel, 1L),
                ItemList.Machine_Steel_Boiler.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.StainlessSteel, 1L));
        addShapedRecipe(
                new ItemStack(ModItems.itemBoilerChassis, 1, 1),
                "plateDoubleStainlessSteel",
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1L),
                "plateDoubleStainlessSteel",
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L),
                getModItem(IronTanks.ID, "stainlesssteelTank", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L),
                "plateDoubleStainlessSteel",
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1L),
                "plateDoubleStainlessSteel");
        addShapedRecipe(
                GregtechItemList.Boiler_Advanced_HV.get(1),
                ItemList.Electric_Pump_HV.get(1L),
                "circuitAdvanced",
                ItemList.Electric_Pump_HV.get(1L),
                new ItemStack(ModItems.itemBoilerChassis, 1, 2),
                ItemList.Casing_HV.get(1L),
                new ItemStack(ModItems.itemBoilerChassis, 1, 2),
                GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Titanium, 1L),
                ItemList.Machine_Steel_Boiler.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Titanium, 1L));
        addShapedRecipe(
                new ItemStack(ModItems.itemBoilerChassis, 1, 2),
                "plateDoubleTitanium",
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1L),
                "plateDoubleTitanium",
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1L),
                getModItem(IronTanks.ID, "titaniumTank", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1L),
                "plateDoubleTitanium",
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1L),
                "plateDoubleTitanium");
        addShapedRecipe(
                GregtechItemList.GT_FluidTank_HV.get(1),
                "circuitPrimitive",
                "plateAluminium",
                "circuitPrimitive",
                "plateDarkSteel",
                "pipeMediumSteel",
                "plateDarkSteel",
                "circuitPrimitive",
                ItemList.Electric_Pump_MV.get(1L),
                "circuitPrimitive");

        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                new ItemStack(FR_ItemRegistry.hiveFrameAccelerated, 1, 0),
                "abc",
                "def",
                "ghi",
                'a',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Electrum, 1L),
                'b',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 1L),
                'c',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Electrum, 1L),
                'd',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 1L),
                'e',
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 1L),
                'f',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 1L),
                'g',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Electrum, 1L),
                'h',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 1L),
                'i',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Electrum, 1L));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                new ItemStack(FR_ItemRegistry.hiveFrameMutagenic, 1, 0),
                "abc",
                "def",
                "ghi",
                'a',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Uranium235, 1L),
                'b',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Plutonium241, 1L),
                'c',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Uranium235, 1L),
                'd',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Plutonium241, 1L),
                'e',
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Plutonium241, 1L),
                'f',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Plutonium241, 1L),
                'g',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Uranium235, 1L),
                'h',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Plutonium241, 1L),
                'i',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Uranium235, 1L));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                new ItemStack(FR_ItemRegistry.hiveFrameBusy),
                "abc",
                "def",
                "ghi",
                'a',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.BlueSteel, 1L),
                'b',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.BlueSteel, 1L),
                'c',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.BlueSteel, 1L),
                'd',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.BlueSteel, 1L),
                'e',
                getModItem(Minecraft.ID, "nether_star", 1, 0, missing),
                'f',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.BlueSteel, 1L),
                'g',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.BlueSteel, 1L),
                'h',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.BlueSteel, 1L),
                'i',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.BlueSteel, 1L));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                new ItemStack(FR_ItemRegistry.hiveFrameDecay),
                "abc",
                "def",
                "ghi",
                'a',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.WroughtIron, 1),
                'b',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 1),
                'c',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.WroughtIron, 1),
                'd',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 1),
                'e',
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.WroughtIron, 1),
                'f',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 1),
                'g',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.WroughtIron, 1),
                'h',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 1),
                'i',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.WroughtIron, 1));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                new ItemStack(FR_ItemRegistry.hiveFrameSlow),
                "abc",
                "def",
                "ghi",
                'a',
                ALLOY.TUMBAGA.getLongRod(1),
                'b',
                ALLOY.TUMBAGA.getRod(1),
                'c',
                ALLOY.TUMBAGA.getLongRod(1),
                'd',
                ALLOY.TUMBAGA.getRod(1),
                'e',
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 1L),
                'f',
                ALLOY.TUMBAGA.getRod(1),
                'g',
                ALLOY.TUMBAGA.getLongRod(1),
                'h',
                ALLOY.TUMBAGA.getRod(1),
                'i',
                ALLOY.TUMBAGA.getLongRod(1));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                new ItemStack(FR_ItemRegistry.hiveFrameStalilize),
                "abc",
                "def",
                "ghi",
                'a',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmiridium, 1L),
                'b',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Osmiridium, 1L),
                'c',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmiridium, 1L),
                'd',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Osmiridium, 1L),
                'e',
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Osmiridium, 1L),
                'f',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Osmiridium, 1L),
                'g',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmiridium, 1L),
                'h',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Osmiridium, 1L),
                'i',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Osmiridium, 1L));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                new ItemStack(FR_ItemRegistry.hiveFrameArborist),
                "abc",
                "def",
                "ghi",
                'a',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.WoodSealed, 1L),
                'b',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WoodSealed, 1L),
                'c',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.WoodSealed, 1L),
                'd',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WoodSealed, 1L),
                'e',
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                'f',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WoodSealed, 1L),
                'g',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.WoodSealed, 1L),
                'h',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WoodSealed, 1L),
                'i',
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.WoodSealed, 1L));

        // Shirabon and Eternity
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EternalSingularity.ID, "combined_singularity", 1, 15, missing),
                        ItemList.EnergisedTesseract.get(1),
                        ItemUtils.getSimpleStack(GenericChem.TemporalHarmonyCatalyst, 0))
                .itemOutputs(GT_OreDictUnificator.get("dustShirabon", 64), ItemList.Timepiece.get(1))
                .fluidInputs(MaterialsUEVplus.PrimordialMatter.getFluid(1152))
                .fluidOutputs(MaterialsUEVplus.Eternity.getMolten(9216), MaterialsUEVplus.Time.getMolten(18432))
                .metadata(QFT_FOCUS_TIER, 4).duration(20 * SECONDS).eut(TierEU.RECIPE_UMV)
                .addTo(quantumForceTransformerRecipes);
    }
}
