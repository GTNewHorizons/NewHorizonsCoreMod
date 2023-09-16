package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.RemoteIO;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

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
import gtPlusPlus.core.item.chemistry.GenericChem;
import gtPlusPlus.core.lib.CORE;
import gtPlusPlus.core.util.minecraft.ItemUtils;

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
                getModItem(GregTech.ID, "gt.blockmachines", 1, 875, missing),
                getModItem(RemoteIO.ID, "tile.machine", 1, 1, missing),
                ItemList.Machine_HV_Centrifuge.get(1L),
                getModItem(RemoteIO.ID, "tile.machine", 1, 1, missing),
                "gearGtTungstenSteel",
                "circuitElite",
                "gearGtTungstenSteel",
                getModItem(RemoteIO.ID, "tile.machine", 1, 1, missing),
                ItemList.Machine_HV_Centrifuge.get(1L),
                getModItem(RemoteIO.ID, "tile.machine", 1, 1, missing));
        addShapelessRecipe(CustomItemList.CoinBeesI.get(16L), getModItem(GTPlusPlus.ID, "frameUseless", 1, 0, missing));
        addShapedRecipe(
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                "craftingToolFile",
                null,
                null,
                null,
                getModItem(GTPlusPlus.ID, "itemIngotTumbaga", 1, 0, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(GTPlusPlus.ID, "blockFrameGtTumbaga", 2, 0, missing),
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                "craftingToolWrench",
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing));
        addShapedRecipe(
                getModItem(GTPlusPlus.ID, "itemGearTumbaga", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "itemPlateTumbaga", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "itemPlateTumbaga", 1, 0, missing),
                "craftingToolWrench",
                getModItem(GTPlusPlus.ID, "itemPlateTumbaga", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "itemPlateTumbaga", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing));
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockmachines", 1, 798, missing),
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
                getModItem(GregTech.ID, "gt.blockmachines", 1, 753, missing),
                ItemList.Electric_Pump_LV.get(1L),
                "circuitBasic",
                ItemList.Electric_Pump_LV.get(1L),
                getModItem(GTPlusPlus.ID, "itemBoilerChassis", 1, 0, missing),
                ItemList.Casing_LV.get(1L),
                getModItem(GTPlusPlus.ID, "itemBoilerChassis", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Steel, 1L),
                ItemList.Machine_Steel_Boiler.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Steel, 1L));
        addShapedRecipe(
                getModItem(GTPlusPlus.ID, "itemBoilerChassis", 1, 0, missing),
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
                getModItem(GregTech.ID, "gt.blockmachines", 1, 754, missing),
                ItemList.Electric_Pump_MV.get(1L),
                "circuitGood",
                ItemList.Electric_Pump_MV.get(1L),
                getModItem(GTPlusPlus.ID, "itemBoilerChassis", 1, 1, missing),
                ItemList.Casing_MV.get(1L),
                getModItem(GTPlusPlus.ID, "itemBoilerChassis", 1, 1, missing),
                GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.StainlessSteel, 1L),
                ItemList.Machine_Steel_Boiler.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.StainlessSteel, 1L));
        addShapedRecipe(
                getModItem(GTPlusPlus.ID, "itemBoilerChassis", 1, 1, missing),
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
                getModItem(GregTech.ID, "gt.blockmachines", 1, 755, missing),
                ItemList.Electric_Pump_HV.get(1L),
                "circuitAdvanced",
                ItemList.Electric_Pump_HV.get(1L),
                getModItem(GTPlusPlus.ID, "itemBoilerChassis", 1, 2, missing),
                ItemList.Casing_HV.get(1L),
                getModItem(GTPlusPlus.ID, "itemBoilerChassis", 1, 2, missing),
                GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Titanium, 1L),
                ItemList.Machine_Steel_Boiler.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Titanium, 1L));
        addShapedRecipe(
                getModItem(GTPlusPlus.ID, "itemBoilerChassis", 1, 2, missing),
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
                getModItem(GregTech.ID, "gt.blockmachines", 1, 820, missing),
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
                getModItem(GTPlusPlus.ID, "frameAccelerated", 1, 0, missing),
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
                getModItem(GTPlusPlus.ID, "frameMutagenic", 1, 0, missing),
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
                getModItem(GTPlusPlus.ID, "frameBusy", 1, 0, missing),
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
                getModItem(GTPlusPlus.ID, "frameDecaying", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22304, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23304, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22304, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23304, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 29304, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23304, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22304, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23304, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22304, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "frameSlowing", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GTPlusPlus.ID, "itemRodLongTumbaga", 1, 0, missing),
                'b',
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                'c',
                getModItem(GTPlusPlus.ID, "itemRodLongTumbaga", 1, 0, missing),
                'd',
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                'e',
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 1L),
                'f',
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                'g',
                getModItem(GTPlusPlus.ID, "itemRodLongTumbaga", 1, 0, missing),
                'h',
                getModItem(GTPlusPlus.ID, "itemRodTumbaga", 1, 0, missing),
                'i',
                getModItem(GTPlusPlus.ID, "itemRodLongTumbaga", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                getModItem(GTPlusPlus.ID, "frameStabilizing", 1, 0, missing),
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
                getModItem(GTPlusPlus.ID, "frameArborists", 1, 0, missing),
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

        GT_Values.RA.stdBuilder().itemInputs(getModItem(GTPlusPlus.ID, "item.BasicMetaFood", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 1L)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(100).eut(4).addTo(sMaceratorRecipes);

        // Shirabon and Eternity
        CORE.RA.addQuantumTransformerRecipe(
                new ItemStack[] { getModItem(EternalSingularity.ID, "combined_singularity", 1, 15, missing),
                        ItemList.EnergisedTesseract.get(1),
                        ItemUtils.getSimpleStack(GenericChem.TemporalHarmonyCatalyst, 0) },
                new FluidStack[] { MaterialsUEVplus.PrimordialMatter.getFluid(1152) },
                new FluidStack[] { MaterialsUEVplus.Eternity.getMolten(9216), MaterialsUEVplus.Time.getMolten(18432) },
                new ItemStack[] { GT_OreDictUnificator.get("dustShirabon", 64), ItemList.Timepiece.get(1) },
                new int[] { 2500, 2500, 2500, 2500 },
                20 * 20,
                (int) TierEU.RECIPE_UMV,
                4);

    }
}
