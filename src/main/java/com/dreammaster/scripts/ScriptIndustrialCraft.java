package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.createItemStack;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TinkersGregworks;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.blastFurnaceRecipes;
import static gregtech.api.recipe.RecipeMaps.cannerRecipes;
import static gregtech.api.recipe.RecipeMaps.extruderRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidSolidifierRecipes;
import static gregtech.api.recipe.RecipeMaps.latheRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.recipe.RecipeMaps.polarizerRecipes;
import static gregtech.api.recipe.RecipeMaps.vacuumFreezerRecipes;
import static gregtech.api.recipe.RecipeMaps.wiremillRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.dreammaster.item.NHItemList;
import com.dreammaster.oredict.OreDictHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.ToolDictNames;
import gregtech.api.objects.ItemData;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;

public class ScriptIndustrialCraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Industrial Craft 2";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                BiomesOPlenty.ID,
                BuildCraftFactory.ID,
                Forestry.ID,
                IndustrialCraft2.ID,
                Natura.ID,
                Railcraft.ID,
                Thaumcraft.ID,
                TinkerConstruct.ID,
                TinkersGregworks.ID,
                TwilightForest.ID);
    }

    @Override
    public void loadRecipes() {
        OreDictHelper.removeOreDict("plateSteel", getModItem(IndustrialCraft2.ID, "itemPlates", 1, 5));

        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "blockMiningPipe", 1, 0),
                getModItem(IndustrialCraft2.ID, "blockMiningTip", 1, 0));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 3),
                "cableGt01AnyCopper",
                ItemList.Battery_Hull_MV.get(1L),
                "cableGt01AnyCopper",
                "circuitBasic",
                ItemList.Casing_MV.get(1L),
                "circuitBasic",
                "itemCasingSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5),
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 8),
                "itemCasingSteel",
                getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0),
                "itemCasingSteel",
                getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0),
                ItemList.Hull_MV.get(1L),
                getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0),
                "circuitBasic",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5),
                ItemList.Electric_Motor_MV.get(1L));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5),
                "plateAnyRubber",
                "plateCopper",
                "plateAnyRubber",
                "plateCopper",
                "plateSilver",
                "plateCopper",
                "plateAnyRubber",
                "plateCopper",
                "plateAnyRubber");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 0),
                "cableGt01Tin",
                "plateSteel",
                "cableGt01Tin",
                getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0),
                ItemList.Hull_LV.get(1L),
                getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0),
                "plateSteel",
                getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0),
                "plateSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 7),
                "cableGt01AnyCopper",
                "plateBronze",
                "cableGt01AnyCopper",
                getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, wildcard),
                ItemList.Hull_MV.get(1L),
                getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, wildcard),
                "plateBronze",
                getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, wildcard),
                "plateBronze");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 1),
                "cableGt01Gold",
                "batteryAdvanced",
                "cableGt01Gold",
                "batteryAdvanced",
                ItemList.Hull_HV.get(1L),
                "batteryAdvanced",
                "plateStainlessSteel",
                "batteryAdvanced",
                "plateStainlessSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 2),
                "cableGt01TungstenSteel",
                "batteryData",
                "cableGt01TungstenSteel",
                "batteryData",
                ItemList.Hull_EV.get(1L),
                "batteryData",
                "circuitData",
                "batteryData",
                "circuitData");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0),
                "plateAnyRubber",
                "plateAnyRubber",
                "plateAnyRubber",
                "plateAnyRubber",
                "plateAnyRubber",
                "plateAnyRubber",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockScaffold", 1, 0),
                "screwIron",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "screwIron",
                "craftingToolWrench",
                "frameGtWood",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockIronScaffold", 1, 0),
                "screwSteel",
                "plateIron",
                "screwSteel",
                "craftingToolWrench",
                "frameGtIron",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemToolMiningLaser", 1, 0),
                "plateTitanium",
                NHItemList.LaserEmitter.get(1),
                "plateTitanium",
                "circuitMaster",
                ItemList.Battery_RE_MV_Cadmium.get(1L),
                "circuitMaster",
                "craftingToolFile",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 2),
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorPlating", 1, 0),
                "plateAlloyAdvanced",
                "plateAlloyAdvanced",
                "plateAlloyAdvanced",
                "plateAlloyAdvanced",
                "plateDenseLead",
                "plateAlloyAdvanced",
                "plateAlloyAdvanced",
                "plateAlloyAdvanced",
                "plateAlloyAdvanced");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1, 0),
                "plateDenseCopper",
                "plateCopper",
                "plateDenseCopper",
                "plateSilver",
                getModItem(IndustrialCraft2.ID, "reactorPlating", 1, 0),
                "plateSilver",
                "plateDenseCopper",
                "plateCopper",
                "plateDenseCopper");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorPlatingExplosive", 1, 0),
                "plateDenseLead",
                "plateAlloyAdvanced",
                "plateDenseLead",
                "plateAlloyAdvanced",
                getModItem(IndustrialCraft2.ID, "reactorPlating", 1, 0),
                "plateAlloyAdvanced",
                "plateDenseLead",
                "plateAlloyAdvanced",
                "plateDenseLead");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 7),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "ringStainlessSteel",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemwoodrotor", 1, 1),
                "screwSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 7),
                "craftingToolWrench",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 7),
                "ringStainlessSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 7),
                "craftingToolScrewdriver",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 7),
                "screwSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 8),
                "plateIron",
                "plateIron",
                "plateIron",
                "plateIron",
                "ringTitanium",
                "plateIron",
                "plateIron",
                "plateIron",
                "plateIron");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemironrotor", 1, 1),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 11),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 8),
                "craftingToolHardHammer",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 8),
                "ringTitanium",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 8),
                "craftingToolWrench",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 8),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 11));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 10),
                "plateStainlessSteel",
                "plateStainlessSteel",
                "plateStainlessSteel",
                "plateStainlessSteel",
                "ringTungstenSteel",
                "plateStainlessSteel",
                "plateStainlessSteel",
                "plateStainlessSteel",
                "plateStainlessSteel");
        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 10),
                getModItem(Railcraft.ID, "part.turbine.blade", 1, 0));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemsteelrotor", 1, 1),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 10),
                "craftingToolHardHammer",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 10),
                "ringTungstenSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 10),
                "craftingToolWrench",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 10),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 9),
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0),
                "ringIridium",
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemwcarbonrotor", 1, 1),
                GregtechItemList.TungstenSteelShaft.get(1),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 9),
                "craftingToolHardHammer",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 9),
                "ringIridium",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 9),
                "craftingToolWrench",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 9),
                GregtechItemList.TungstenSteelShaft.get(1));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 5),
                ItemList.Electric_Motor_MV.get(1L),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5),
                ItemList.Electric_Motor_MV.get(1L),
                "circuitGood",
                ItemList.Casing_HeatProof.get(1L),
                "circuitGood",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0));
        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "itemSteamTurbineBlade", 1, 0),
                getModItem(Railcraft.ID, "part.turbine.disk", 1, 0));
        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "itemSteamTurbine", 1, 0),
                getModItem(Railcraft.ID, "part.turbine.rotor", 1, 0));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemSteamTurbine", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemSteamTurbineBlade", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemSteamTurbineBlade", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemSteamTurbineBlade", 1, 0),
                null,
                "craftingToolWrench",
                null);
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1),
                "plateAluminium",
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                "plateAluminium",
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                "plateAluminium",
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                "plateAluminium");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorVentCore", 1, 1),
                "plateDoubleCopper",
                "plateSilver",
                "plateDoubleCopper",
                "plateSilver",
                getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1),
                "plateSilver",
                "plateDoubleCopper",
                "plateSilver",
                "plateDoubleCopper");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1),
                NHItemList.StainlessSteelBars.get(),
                getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1),
                NHItemList.StainlessSteelBars.get(),
                NHItemList.StainlessSteelBars.get(),
                getModItem(IndustrialCraft2.ID, "itemPartIndustrialDiamond", 1, 0),
                NHItemList.StainlessSteelBars.get(),
                NHItemList.StainlessSteelBars.get(),
                getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1),
                NHItemList.StainlessSteelBars.get());
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorVentGold", 1, 1),
                "screwStainlessSteel",
                "plateGold",
                "screwStainlessSteel",
                "plateGold",
                getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1),
                "plateGold",
                "screwStainlessSteel",
                "plateGold",
                "screwStainlessSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorVentSpread", 1, 0),
                NHItemList.SteelBars.get(),
                "plateDenseTin",
                NHItemList.SteelBars.get(),
                "plateDenseTin",
                getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1),
                "plateDenseTin",
                NHItemList.SteelBars.get(),
                "plateDenseTin",
                NHItemList.SteelBars.get());
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1),
                "plateSilver",
                "circuitAdvanced",
                "plateSilver",
                "plateAluminium",
                "plateCopper",
                "plateAluminium",
                "plateSilver",
                "plateAluminium",
                "plateSilver");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchCore", 1, 1),
                "plateDoubleCopper",
                "plateSilver",
                "plateDoubleCopper",
                "plateSilver",
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1),
                "plateSilver",
                "plateDoubleCopper",
                "plateSilver",
                "plateDoubleCopper");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1, 1),
                "screwStainlessSteel",
                "plateGold",
                "screwStainlessSteel",
                "plateGold",
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1),
                "plateGold",
                "screwStainlessSteel",
                "plateGold",
                "screwStainlessSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1),
                "plateLapis",
                "circuitData",
                "plateLapis",
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1),
                "plateDiamond",
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1),
                "plateLapis",
                "circuitData",
                "plateLapis");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, 1),
                "plateRedAlloy",
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchCore", 1, 1),
                "plateRedAlloy",
                "plateRedAlloy",
                getModItem(IndustrialCraft2.ID, "reactorVentCore", 1, 1),
                "plateRedAlloy",
                "plateRedAlloy",
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchCore", 1, 1),
                "plateRedAlloy");
        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, 1),
                getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, wildcard),
                "dustRedAlloy",
                "dustRedAlloy",
                "dustRedAlloy",
                "dustRedAlloy",
                "dustRedAlloy",
                "dustRedAlloy",
                "dustRedAlloy",
                "dustRedAlloy");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorCondensatorLap", 1, 1),
                "plateDoubleRedAlloy",
                getModItem(IndustrialCraft2.ID, "reactorVentGold", 1, 1),
                "plateDoubleRedAlloy",
                getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, 1),
                "plateDenseLapis",
                getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, 1),
                "plateDoubleRedAlloy",
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1, 1),
                "plateDoubleRedAlloy");
        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "reactorCondensatorLap", 1, 1),
                getModItem(IndustrialCraft2.ID, "reactorCondensatorLap", 1, wildcard),
                "dustLapis",
                "dustLapis",
                "dustLapis",
                "dustLapis",
                "dustLapis",
                "dustLapis",
                "dustLapis",
                "dustLapis");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemTreetap", 1, 0),
                ToolDictNames.craftingToolSoftMallet.name(),
                "screwWood",
                "craftingToolScrewdriver",
                "pipeMediumWood",
                "pipeMediumWood",
                "pipeSmallWood",
                "pipeLargeWood",
                "craftingToolSaw",
                "craftingToolFile");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 6),
                "itemCasingAnyCopper",
                "itemCasingAnyCopper",
                "itemCasingAnyCopper",
                "screwCopper",
                "craftingToolWrench",
                "screwCopper",
                "itemCasingAnyCopper",
                "itemCasingAnyCopper",
                "itemCasingAnyCopper");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemBarrel", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "ringIron",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "ringIron",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemBoat", 1, 3),
                "screwSteel",
                "plateSteel",
                "screwSteel",
                "craftingToolWrench",
                NHItemList.ElectricBoatHull.get(1),
                "craftingToolScrewdriver",
                ItemList.Rotor_LV.get(1L),
                ItemList.Electric_Motor_LV.get(1L),
                ItemList.Rotor_LV.get(1L));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemBoat", 1, 1),
                "plateAnyRubber",
                "craftingToolSaw",
                "plateAnyRubber",
                "plateAnyRubber",
                ToolDictNames.craftingToolSoftMallet.name(),
                "plateAnyRubber",
                "plateAnyRubber",
                "plateAnyRubber",
                "plateAnyRubber");
        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "itemBoat", 1, 1),
                getModItem(IndustrialCraft2.ID, "itemBoat", 1, 2),
                "plateAnyRubber",
                "plateAnyRubber",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "windmeter", 1, 0),
                "screwStainlessSteel",
                "rotorAluminium",
                "craftingToolScrewdriver",
                "gearGtSmallStainlessSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 3),
                "gearGtSmallStainlessSteel",
                "plateStainlessSteel",
                "batteryBasic",
                "plateStainlessSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemTreetapElectric", 1, 0),
                "craftingToolScrewdriver",
                "stickLongSteel",
                OrePrefixes.toolHeadDrill.get(Materials.Steel),
                "stickLongSteel",
                ItemList.Electric_Pump_LV,
                "batteryBasic",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 3),
                OrePrefixes.cableGt01.get(Materials.Tin),
                "screwSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemToolHoe", 1, 0),
                "craftingToolScrewdriver",
                "plateSteel",
                "stickSteel",
                "plateSteel",
                "gearGtSmallSteel",
                "batteryBasic",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 3),
                null,
                "screwSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemDoorAlloy", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0),
                getModItem(IndustrialCraft2.ID, "blockAlloyGlass", 1, 0),
                "craftingToolHardHammer",
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0),
                "ringLead",
                "screwLead",
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0),
                "plateDenseLead",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0),
                "blockWool",
                "blockWool",
                "blockWool",
                null,
                "stickSteel",
                null,
                null,
                "stickSteel",
                null);
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemBatChargeRE", 1, 0),
                "batteryBasic",
                "cableGt01Tin",
                "batteryBasic",
                "circuitBasic",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 1L),
                "circuitBasic",
                "batteryBasic",
                "cableGt01Tin",
                "batteryBasic");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockPersonal", 1, 0),
                "screwIron",
                "circuitBasic",
                "screwIron",
                "craftingToolScrewdriver",
                ItemList.Casing_LV.get(1L),
                "craftingToolHardHammer",
                "screwIron",
                "chestIron",
                "screwIron");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemFoamSprayer", 1, 0),
                "pipeSmallSteel",
                "craftingToolScrewdriver",
                "screwIron",
                "craftingToolSaw",
                "pipeSmallSteel",
                Materials.Empty.getCells(1),
                "screwIron",
                getModItem(Minecraft.ID, "stone_button", 1, 0),
                "circuitBasic");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorAlloyChestplate", 1, 0),
                "plateAlloyAdvanced",
                "craftingToolHardHammer",
                "plateAlloyAdvanced",
                "plateAlloyAdvanced",
                getModItem(Railcraft.ID, "armor.steel.plate", 1, 0),
                "plateAlloyAdvanced",
                "plateAlloyAdvanced",
                getModItem(Minecraft.ID, "leather_chestplate", 1, 0),
                "plateAlloyAdvanced");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorAlloyChestplate", 1, 0),
                "plateAlloyAdvanced",
                "craftingToolHardHammer",
                "plateAlloyAdvanced",
                "plateAlloyAdvanced",
                getModItem(Minecraft.ID, "leather_chestplate", 1, 0),
                "plateAlloyAdvanced",
                "plateAlloyAdvanced",
                getModItem(Railcraft.ID, "armor.steel.plate", 1, 0),
                "plateAlloyAdvanced");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26),
                "itemCasingSteel",
                "craftingToolHardHammer",
                "itemCasingSteel",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                "screwSteel",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                "itemCasingSteel",
                "craftingToolScrewdriver",
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemNanoSaber", 1, 0),
                "plateAlloyIridium",
                createItemStack(
                        TinkersGregworks.ID,
                        "tGregToolPartLargeSwordBlade",
                        1,
                        1529,
                        "{material:\"TungstenSteel\"}"),
                "plateAlloyIridium",
                "circuitMaster",
                "batteryData",
                "circuitMaster",
                "craftingToolFile",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 2),
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "obscurator", 1, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "cableGt01Gold",
                NHItemList.Display.get(),
                "cableGt01Gold",
                "itemCasingAnyIron",
                "batteryAdvanced",
                "itemCasingAnyIron");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 3),
                "cableGt01AnyCopper",
                "itemCasingSteel",
                "cableGt01AnyCopper",
                "itemCasingSteel",
                "craftingToolScrewdriver",
                "itemCasingSteel",
                "circuitBasic",
                ItemList.Electric_Motor_LV.get(1L),
                "circuitBasic");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 2),
                "cableGt02Gold",
                "itemCasingStainlessSteel",
                "cableGt02Gold",
                "itemCasingStainlessSteel",
                "craftingToolScrewdriver",
                "itemCasingStainlessSteel",
                "circuitAdvanced",
                ItemList.Electric_Motor_MV.get(1L),
                "circuitAdvanced");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine3", 1, 0),
                "itemCasingSteel",
                "circuitBasic",
                "itemCasingSteel",
                "pipeMediumSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 6),
                "pipeMediumSteel",
                "itemCasingSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5),
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 15),
                getModItem(IndustrialCraft2.ID, "reactorCoolantSimple", 1, 1),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0),
                getModItem(IndustrialCraft2.ID, "reactorCoolantSimple", 1, 1),
                "pipeMediumSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 6),
                "pipeMediumSteel",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                "circuitBasic",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 1),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0),
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 4),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0),
                "circuitAdvanced",
                "cableGt04Gold",
                "circuitAdvanced");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockChargepad", 1, 3),
                "screwStainlessSteel",
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0),
                "screwStainlessSteel",
                "circuitData",
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 2),
                "circuitData",
                "itemCasingStainlessSteel",
                "craftingToolScrewdriver",
                "itemCasingStainlessSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockChargepad", 1, 2),
                "screwAluminium",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0),
                "screwAluminium",
                "circuitAdvanced",
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 1),
                "circuitAdvanced",
                "itemCasingAluminium",
                "craftingToolScrewdriver",
                "itemCasingAluminium");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockChargepad", 1, 1),
                "screwSteel",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0),
                "screwSteel",
                "circuitGood",
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 7),
                "circuitGood",
                "itemCasingSteel",
                "craftingToolScrewdriver",
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockChargepad", 1, 0),
                "screwIron",
                getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0),
                "screwIron",
                "circuitBasic",
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 0),
                "circuitBasic",
                "itemCasingAnyIron",
                "craftingToolScrewdriver",
                "itemCasingAnyIron");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 1),
                "itemCasingSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5),
                "itemCasingSteel",
                "pipeMediumSteel",
                ItemList.Casing_Firebox_Steel.get(1L),
                "pipeMediumSteel",
                "itemCasingSteel",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 0),
                "itemCasingSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5),
                "itemCasingSteel",
                "screwSteel",
                ItemList.Casing_Firebox_Steel.get(1L),
                "screwSteel",
                "itemCasingSteel",
                "craftingBlastFurnace",
                "itemCasingSteel");
        addShapelessRecipe(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 1), ItemList.Electric_Motor_LV.get(1L));
        addShapelessRecipe(ItemList.Electric_Motor_LV.get(1L), getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 1));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 2),
                "itemCasingStainlessSteel",
                "rotorStainlessSteel",
                "itemCasingStainlessSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12),
                ItemList.Hull_HV.get(1L),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12),
                "cableGt04Gold",
                "rotorStainlessSteel",
                "cableGt04Gold");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 1),
                "itemCasingStainlessSteel",
                "rotorStainlessSteel",
                "itemCasingStainlessSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12),
                getModItem(Railcraft.ID, "machine.beta", 1, 4),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12),
                "circuitAdvanced",
                "rotorStainlessSteel",
                "circuitAdvanced");
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1L),
                "craftingToolHardHammer",
                null,
                null,
                "ingotIridium",
                null,
                null,
                "ingotIridium",
                null,
                null);

        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.toolHeadSaw, Materials.Iridium, 1L),
                "plateIridium",
                "plateIridium",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null,
                null,
                null,
                null);
        addShapedRecipe(
                ItemList.Cover_SolarPanel.get(1L),
                "craftingToolCrowbar",
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3),
                "craftingToolScrewdriver",
                "craftingToolWrench",
                "craftingToolHardHammer",
                "craftingToolFile");
        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "itemFluidCell", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 0));
        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemFluidCell", 1, 0));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemPartCFPowder", 1, 0),
                "dustCalcite",
                "dustCalcite",
                "dustStone",
                "dustClay",
                "dustQuartzSand",
                null,
                null,
                null,
                null);
        GameRegistry.addRecipe(
                new ArmorRepairRecipe(
                        getModItem(IndustrialCraft2.ID, "itemArmorRubBoots", 1, 0),
                        "aba",
                        "-c-",
                        "-d-",
                        'a',
                        "plateAnyRubber",
                        'b',
                        getModItem(IndustrialCraft2.ID, "itemArmorRubBoots", 1, wildcard),
                        'c',
                        ToolDictNames.craftingToolSoftMallet.name(),
                        'd',
                        getModItem(TinkerConstruct.ID, "buckets", 1, 25)));
        GameRegistry.addRecipe(
                new ArmorRepairRecipe(
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, 0),
                        "aba",
                        "-c-",
                        "-d-",
                        'a',
                        "plateAnyRubber",
                        'b',
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, wildcard),
                        'c',
                        ToolDictNames.craftingToolSoftMallet.name(),
                        'd',
                        getModItem(TinkerConstruct.ID, "buckets", 1, 25)));
        GameRegistry.addRecipe(
                new ArmorRepairRecipe(
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatChestplate", 1, 0),
                        "aba",
                        "-c-",
                        "-d-",
                        'a',
                        "plateAnyRubber",
                        'b',
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatChestplate", 1, wildcard),
                        'c',
                        ToolDictNames.craftingToolSoftMallet.name(),
                        'd',
                        getModItem(TinkerConstruct.ID, "buckets", 1, 25)));
        GameRegistry.addRecipe(
                new ArmorRepairRecipe(
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatLeggings", 1, 0),
                        "aba",
                        "-c-",
                        "-d-",
                        'a',
                        "plateAnyRubber",
                        'b',
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatLeggings", 1, wildcard),
                        'c',
                        ToolDictNames.craftingToolSoftMallet.name(),
                        'd',
                        getModItem(TinkerConstruct.ID, "buckets", 1, 25)));

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 4),
                "---------",
                "---------",
                "--aabaa--",
                "--cdedc--",
                "--bfgfb--",
                "--chehc--",
                "--aabaa--",
                "---------",
                "---------",
                'a',
                "plateDoubleStainlessSteel",
                'b',
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12),
                'c',
                "itemCasingStainlessSteel",
                'd',
                ItemList.Electric_Pump_HV.get(1L),
                'e',
                "cableGt01Platinum",
                'f',
                "circuitData",
                'g',
                ItemList.Casing_Gearbox_Steel.get(1L),
                'h',
                "gearGtSmallTitanium");
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 9),
                "---------",
                "---------",
                "--aabaa--",
                "--cdedc--",
                "--fghgf--",
                "--cijic--",
                "--aabaa--",
                "---------",
                "---------",
                'a',
                "plateDoubleStainlessSteel",
                'b',
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12),
                'c',
                "rotorStainlessSteel",
                'd',
                "gearTitanium",
                'e',
                ItemList.Hull_HV.get(1L),
                'f',
                "cableGt01Platinum",
                'g',
                "circuitData",
                'h',
                ItemList.Casing_Motor.get(1L),
                'i',
                ItemList.Electric_Motor_HV.get(1L),
                'j',
                ItemList.Battery_RE_HV_Lithium.get(1L));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 0),
                "---------",
                "---------",
                "---------",
                "--abcba--",
                "--defed--",
                "--agaga--",
                "---------",
                "---------",
                "---------",
                'a',
                "plateTitanium",
                'b',
                "lensNetherStar",
                'c',
                ItemList.Field_Generator_HV.get(1L),
                'd',
                getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard),
                'e',
                ItemList.Electric_Motor_EV.get(1L),
                'f',
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 5),
                'g',
                "cableGt04Aluminium");
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 0),
                "---------",
                "---------",
                "--aabaa--",
                "--cdedc--",
                "--bfgfb--",
                "--chehc--",
                "--aabaa--",
                "---------",
                "---------",
                'a',
                "plateDoubleStainlessSteel",
                'b',
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12),
                'c',
                "itemCasingStainlessSteel",
                'd',
                "gearGtSmallTitanium",
                'e',
                "cableGt01Platinum",
                'f',
                "circuitData",
                'g',
                ItemList.Casing_Gearbox_Steel.get(1L),
                'h',
                ItemList.Electric_Motor_HV.get(1L));

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Rubber, 6L),
                        NHItemList.MoldBoots.get(0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorRubBoots", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                        NHItemList.MoldBoots.get(0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorRubBoots", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 4L),
                        NHItemList.MoldBoots.get(0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorBronzeBoots", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 8L),
                        NHItemList.MoldChestplate.get(0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorBronzeChestplate", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 5L),
                        NHItemList.MoldHelmet.get(0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorBronzeHelmet", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 7L),
                        NHItemList.MoldLeggings.get(0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorBronzeLegs", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder().itemInputs(ItemList.Hull_ULV.get(1L), ItemList.Cover_SolarPanel.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(ItemList.Hull_ULV.get(1L), ItemList.Cover_SolarPanel.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(ItemList.Hull_ULV.get(1L), ItemList.Cover_SolarPanel.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 5),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 3, 5))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 2))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 576)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 5),
                        getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 8))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 6))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 576)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 3)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_HV_MV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.cableGt02, Materials.Copper, 2L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 4)).duration(12 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_EV_HV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.cableGt04, Materials.Gold, 2L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 5)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_IV_EV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.cableGt08, Materials.Steel, 2L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 6)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 16L))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "coal_block", 1, 0),
                        getModItem(IndustrialCraft2.ID, "itemPartCoalBlock", 8, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemPartCoalChunk", 1, 0)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Wood, 3L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemTreetap", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockScaffold", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Iron, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockIronScaffold", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemBoat", 1, 2),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 1))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemBoat", 1, 1)).duration(20).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Cover_Screen.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 2))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolMEter", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glowstone", 288)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 3, 0),
                        getModItem(IndustrialCraft2.ID, "blockAlloyGlass", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemDoorAlloy", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 720)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemRemote", 1, 0)).duration(1 * MINUTES).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1),
                        GTOreDictUnificator.get(OrePrefixes.cableGt01, Materials.Silver, 2L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(1 * MINUTES).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1),
                        getModItem(IndustrialCraft2.ID, "reactorCoolantTriple", 1, 1))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 2, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 1))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 288)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1),
                        getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 2))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1),
                        ItemList.Electric_Piston_LV.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 3))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 3), ItemList.Electric_Pump_LV.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 4))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 5))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1),
                        ItemList.Conveyor_Module_LV.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 6))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 5),
                        NHItemList.ReinforcedGlassLense.get(2))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 144)).duration(25 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 5),
                        NHItemList.ReinforcedGlassLense.get(2))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 144)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 8),
                        getModItem(Minecraft.ID, "wool", 4, 1))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorHazmatChestplate", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 144)).duration(25 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 8),
                        getModItem(Minecraft.ID, "wool", 4, 1))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorHazmatChestplate", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 144)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 7),
                        getModItem(Minecraft.ID, "carpet", 4, 1))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorHazmatLeggings", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 144)).duration(25 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 7),
                        getModItem(Minecraft.ID, "carpet", 4, 1))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorHazmatLeggings", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 144)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "iron_helmet", 1, 0), ItemList.Cover_SolarPanel.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemSolarHelmet", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 288)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "iron_helmet", 1, 0), ItemList.Cover_SolarPanel.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemSolarHelmet", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "iron_helmet", 1, 0), ItemList.Cover_SolarPanel.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemSolarHelmet", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 8, 6))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemContainmentbox", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Lead, 2L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockreactorvessel", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTOreDictUnificator.addItemData(
                getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0),
                new ItemData(
                        new ItemData(Materials.Steel, 2 * GTValues.M),
                        new ItemData(Materials.Concrete, 1 * GTValues.M)));
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockreactorvessel", 1, 0),
                        ItemList.Electric_Pump_HV.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockReactorFluidPort", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockreactorvessel", 1, 0),
                        ItemList.Conveyor_Module_HV.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockReactorAccessHatch", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockreactorvessel", 1, 0),
                        ItemList.Cover_ActivityDetector.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockReactorRedstonePort", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Mercury, 1L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 8L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockLuminatorDark", 8, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 1152)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 16L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockLuminatorDark", 16, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 1152)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Steel, 2L),
                        getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 3, 0),
                        ItemList.Hull_MV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5),
                        ItemList.Electric_Motor_MV.get(1L))
                .circuit(1).itemOutputs(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 8)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4L),
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 2, 0),
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 2, 0),
                        getModItem(IndustrialCraft2.ID, "blockMachine", 1, 0))
                .circuit(1).itemOutputs(getModItem(IndustrialCraft2.ID, "blockMachine", 1, 12))
                .duration(1 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, missing, 4L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Copper, missing, 4L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Silver, missing, 1L))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RubberSilicone, missing, 4L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Copper, missing, 4L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Silver, missing, 1L))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, missing, 4L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Copper, missing, 4L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Silver, missing, 1L))
                .circuit(3).itemOutputs(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.BioChunk.get(1))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemPartCoalChunk", 1, 0)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_MV).specialValue(1000).addTo(blastFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.BioOrganicMesh.get(1))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemPartCarbonMesh", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).specialValue(1000).addTo(blastFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.BioCarbonPlate.get(1))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).specialValue(1000).addTo(blastFurnaceRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonMesh", 8, 0),
                        NHItemList.ExtruderShapeBoat.get(0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemBoat", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Rubber, 4L),
                        NHItemList.ExtruderShapeBoat.get(0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemBoat", 1, 1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "iron_ingot", 8, 0), NHItemList.ExtruderShapeBoat.get(0))
                .itemOutputs(NHItemList.ElectricBoatHull.get(1)).duration(1 * MINUTES).eut(TierEU.RECIPE_LV)
                .addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Steel, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 1, 0)).duration(1)
                .eut(TierEU.RECIPE_MV / 2).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Steel, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 2, 0)).duration(4)
                .eut(TierEU.RECIPE_MV / 2).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 4, 0)).duration(8)
                .eut(TierEU.RECIPE_MV / 2).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Steel, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 8, 0)).duration(16)
                .eut(TierEU.RECIPE_MV / 2).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Steel, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 16, 0))
                .duration(1 * SECONDS + 12 * TICKS).eut(TierEU.RECIPE_MV / 2).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeTiny, Materials.StainlessSteel, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 8, 0)).duration(4).eut(TierEU.RECIPE_MV)
                .addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.StainlessSteel, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 16, 0)).duration(8)
                .eut(TierEU.RECIPE_MV).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 32, 0)).duration(16)
                .eut(TierEU.RECIPE_MV).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.StainlessSteel, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 64, 0))
                .duration(1 * SECONDS + 12 * TICKS).eut(TierEU.RECIPE_MV).addTo(extruderRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemFoamSprayer", 1, 0))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemFoamSprayer",
                                1,
                                0,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:8000}}"))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 8000)).duration(6 * SECONDS + 9 * TICKS)
                .eut(1).addTo(cannerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                24,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:8000}}"))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 8000)).duration(6 * SECONDS + 9 * TICKS)
                .eut(1).addTo(cannerRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.TenKCell.get())
                .itemOutputs(getModItem(IndustrialCraft2.ID, "reactorCoolantSimple", 1, 1))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 1000)).duration(16).eut(1).addTo(cannerRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.ThirtyKCell.get())
                .itemOutputs(getModItem(IndustrialCraft2.ID, "reactorCoolantTriple", 1, 1))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 3000)).duration(2 * SECONDS + 8 * TICKS).eut(1)
                .addTo(cannerRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.SixtyKCell.get())
                .itemOutputs(getModItem(IndustrialCraft2.ID, "reactorCoolantSix", 1, 1))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 6000)).duration(4 * SECONDS + 16 * TICKS).eut(1)
                .addTo(cannerRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldBoots.get(0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorRubBoots", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 720)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(fluidSolidifierRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemPartIndustrialDiamond", 1, 0))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Diamond, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Diamond, 2L))
                .duration(3 * MINUTES + 11 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV / 2).addTo(latheRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "blockBasalt", 1, 0))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Basalt, 1L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard))
                .itemOutputs(NHItemList.LapotronDust.get(30)).outputChances(10000).duration(15 * SECONDS).eut(2)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemDust", 8, 2),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L))
                .circuit(1).itemOutputs(getModItem(IndustrialCraft2.ID, "itemPartCoalBall", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "iron_boots", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemStaticBoots", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(polarizerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Steel, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 2, 0))
                .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_ULV).addTo(wiremillRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 4, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(wiremillRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Steel, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 8, 0))
                .duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV).addTo(wiremillRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Steel, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 16, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(wiremillRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.pipeTiny, Materials.StainlessSteel, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 8, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(wiremillRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.StainlessSteel, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 16, 0))
                .duration(12 * SECONDS + 10 * TICKS).eut(96).addTo(wiremillRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 32, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(wiremillRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.pipeLarge, Materials.StainlessSteel, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 64, 0))
                .duration(17 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV / 2).addTo(wiremillRecipes);
        GTValues.RA.stdBuilder().fluidInputs(FluidRegistry.getFluidStack("ic2hotcoolant", 1000))
                .fluidOutputs(FluidRegistry.getFluidStack("ic2coolant", 1000)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(vacuumFreezerRecipes);
    }

    private static class ArmorRepairRecipe extends ShapedOreRecipe {

        public ArmorRepairRecipe(ItemStack result, Object... recipe) {
            super(result, recipe);
        }

        @Override
        public ItemStack getCraftingResult(InventoryCrafting crafting) {
            ItemStack result = super.getCraftingResult(crafting);
            for (int i = 0, imax = crafting.getSizeInventory(); i < imax; i++) {
                ItemStack stack = crafting.getStackInSlot(i);
                if (stack != null && stack.getItem() == result.getItem()) {
                    result.stackTagCompound = stack.stackTagCompound;
                    break;
                }
            }
            return result;
        }
    }
}
