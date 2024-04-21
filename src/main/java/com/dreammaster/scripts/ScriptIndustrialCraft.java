package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TinkersGregworks;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.blastFurnaceRecipes;
import static gregtech.api.recipe.RecipeMaps.extruderRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidCannerRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidSolidifierRecipes;
import static gregtech.api.recipe.RecipeMaps.latheRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.recipe.RecipeMaps.polarizerRecipes;
import static gregtech.api.recipe.RecipeMaps.vacuumFreezerRecipes;
import static gregtech.api.recipe.RecipeMaps.wiremillRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.oredict.OreDictHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

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
                GTPlusPlus.ID,
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
        OreDictHelper.removeOreDict("plateSteel", getModItem(IndustrialCraft2.ID, "itemPlates", 1, 5, missing));

        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "blockMiningPipe", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "blockMiningTip", 1, 0, missing));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 3, missing),
                "cableGt01AnyCopper",
                ItemList.Battery_Hull_MV.get(1L),
                "cableGt01AnyCopper",
                "circuitBasic",
                ItemList.Casing_MV.get(1L),
                "circuitBasic",
                "itemCasingSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing),
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 8, missing),
                "itemCasingSteel",
                getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing),
                "itemCasingSteel",
                getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing),
                ItemList.Hull_MV.get(1L),
                getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing),
                "circuitBasic",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing),
                ItemList.Electric_Motor_MV.get(1L));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing),
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
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 0, missing),
                "cableGt01Tin",
                "plateSteel",
                "cableGt01Tin",
                getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing),
                ItemList.Hull_LV.get(1L),
                getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing),
                "plateSteel",
                getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing),
                "plateSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 7, missing),
                "cableGt01AnyCopper",
                "plateBronze",
                "cableGt01AnyCopper",
                getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, wildcard, missing),
                ItemList.Hull_MV.get(1L),
                getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, wildcard, missing),
                "plateBronze",
                getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, wildcard, missing),
                "plateBronze");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 1, missing),
                "cableGt01Gold",
                "batteryElite",
                "cableGt01Gold",
                "batteryElite",
                ItemList.Hull_HV.get(1L),
                "batteryElite",
                "plateStainlessSteel",
                "batteryElite",
                "plateStainlessSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 2, missing),
                "cableGt01TungstenSteel",
                "batteryMaster",
                "cableGt01TungstenSteel",
                "batteryMaster",
                ItemList.Hull_EV.get(1L),
                "batteryMaster",
                "circuitData",
                "batteryMaster",
                "circuitData");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing),
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
                getModItem(IndustrialCraft2.ID, "blockScaffold", 1, 0, missing),
                "screwIron",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "screwIron",
                "craftingToolWrench",
                "frameGtWood",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockIronScaffold", 1, 0, missing),
                "screwSteel",
                "plateIron",
                "screwSteel",
                "craftingToolWrench",
                "frameGtIron",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemToolMiningLaser", 1, 0, missing),
                "plateTitanium",
                getModItem(NewHorizonsCoreMod.ID, "item.LaserEmitter", 1, 0, missing),
                "plateTitanium",
                "circuitMaster",
                ItemList.Battery_RE_MV_Cadmium.get(1L),
                "circuitMaster",
                "craftingToolFile",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 2, missing),
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorPlating", 1, 0, missing),
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
                getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1, 0, missing),
                "plateDenseCopper",
                "plateCopper",
                "plateDenseCopper",
                "plateSilver",
                getModItem(IndustrialCraft2.ID, "reactorPlating", 1, 0, missing),
                "plateSilver",
                "plateDenseCopper",
                "plateCopper",
                "plateDenseCopper");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorPlatingExplosive", 1, 0, missing),
                "plateDenseLead",
                "plateAlloyAdvanced",
                "plateDenseLead",
                "plateAlloyAdvanced",
                getModItem(IndustrialCraft2.ID, "reactorPlating", 1, 0, missing),
                "plateAlloyAdvanced",
                "plateDenseLead",
                "plateAlloyAdvanced",
                "plateDenseLead");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 7, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "ringStainlessSteel",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemwoodrotor", 1, 1, missing),
                "screwSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 7, missing),
                "craftingToolWrench",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 7, missing),
                "ringStainlessSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 7, missing),
                "craftingToolScrewdriver",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 7, missing),
                "screwSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 8, missing),
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
                getModItem(IndustrialCraft2.ID, "itemironrotor", 1, 1, missing),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 11, missing),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 8, missing),
                "craftingToolHardHammer",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 8, missing),
                "ringTitanium",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 8, missing),
                "craftingToolWrench",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 8, missing),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 11, missing));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 10, missing),
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
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 10, missing),
                getModItem(Railcraft.ID, "part.turbine.blade", 1, 0, missing));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemsteelrotor", 1, 1, missing),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12, missing),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 10, missing),
                "craftingToolHardHammer",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 10, missing),
                "ringTungstenSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 10, missing),
                "craftingToolWrench",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 10, missing),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12, missing));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 9, missing),
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                "ringIridium",
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemwcarbonrotor", 1, 1, missing),
                getModItem(GTPlusPlus.ID, "itemTungstenSteelShaft", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 9, missing),
                "craftingToolHardHammer",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 9, missing),
                "ringIridium",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 9, missing),
                "craftingToolWrench",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 9, missing),
                getModItem(GTPlusPlus.ID, "itemTungstenSteelShaft", 1, 0, missing));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 5, missing),
                ItemList.Electric_Motor_MV.get(1L),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing),
                ItemList.Electric_Motor_MV.get(1L),
                "circuitGood",
                ItemList.Casing_HeatProof.get(1L),
                "circuitGood",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "itemSteamTurbineBlade", 1, 0, missing),
                getModItem(Railcraft.ID, "part.turbine.disk", 1, 0, missing));
        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "itemSteamTurbine", 1, 0, missing),
                getModItem(Railcraft.ID, "part.turbine.rotor", 1, 0, missing));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemSteamTurbine", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemSteamTurbineBlade", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemSteamTurbineBlade", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemSteamTurbineBlade", 1, 0, missing),
                null,
                "craftingToolWrench",
                null);
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine", 1, 1, missing),
                "plateAnyIron",
                "plateAnyIron",
                "plateAnyIron",
                "plateAnyIron",
                "craftingToolWrench",
                "plateAnyIron",
                "plateAnyIron",
                getModItem(Minecraft.ID, "furnace", 1, 0, missing),
                "plateAnyIron");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1, missing),
                "plateAluminium",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "plateAluminium",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "plateAluminium",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "plateAluminium");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorVentCore", 1, 1, missing),
                "plateDoubleCopper",
                "plateSilver",
                "plateDoubleCopper",
                "plateSilver",
                getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1, missing),
                "plateSilver",
                "plateDoubleCopper",
                "plateSilver",
                "plateDoubleCopper");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1, missing),
                CustomItemList.StainlessSteelBars.get(1L),
                getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1, missing),
                CustomItemList.StainlessSteelBars.get(1L),
                CustomItemList.StainlessSteelBars.get(1L),
                getModItem(IndustrialCraft2.ID, "itemPartIndustrialDiamond", 1, 0, missing),
                CustomItemList.StainlessSteelBars.get(1L),
                CustomItemList.StainlessSteelBars.get(1L),
                getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1, missing),
                CustomItemList.StainlessSteelBars.get(1L));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorVentGold", 1, 1, missing),
                "screwStainlessSteel",
                "plateGold",
                "screwStainlessSteel",
                "plateGold",
                getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1, missing),
                "plateGold",
                "screwStainlessSteel",
                "plateGold",
                "screwStainlessSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorVentSpread", 1, 0, missing),
                CustomItemList.SteelBars.get(1L),
                "plateDenseTin",
                CustomItemList.SteelBars.get(1L),
                "plateDenseTin",
                getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1, missing),
                "plateDenseTin",
                CustomItemList.SteelBars.get(1L),
                "plateDenseTin",
                CustomItemList.SteelBars.get(1L));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1, missing),
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
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchCore", 1, 1, missing),
                "plateDoubleCopper",
                "plateSilver",
                "plateDoubleCopper",
                "plateSilver",
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1, missing),
                "plateSilver",
                "plateDoubleCopper",
                "plateSilver",
                "plateDoubleCopper");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1, 1, missing),
                "screwStainlessSteel",
                "plateGold",
                "screwStainlessSteel",
                "plateGold",
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1, missing),
                "plateGold",
                "screwStainlessSteel",
                "plateGold",
                "screwStainlessSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1, missing),
                "plateLapis",
                "circuitData",
                "plateLapis",
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1, missing),
                "plateDiamond",
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1, missing),
                "plateLapis",
                "circuitData",
                "plateLapis");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, 1, missing),
                "plateRedAlloy",
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchCore", 1, 1, missing),
                "plateRedAlloy",
                "plateRedAlloy",
                getModItem(IndustrialCraft2.ID, "reactorVentCore", 1, 1, missing),
                "plateRedAlloy",
                "plateRedAlloy",
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchCore", 1, 1, missing),
                "plateRedAlloy");
        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, 1, missing),
                getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, wildcard, missing),
                "dustRedAlloy",
                "dustRedAlloy",
                "dustRedAlloy",
                "dustRedAlloy",
                "dustRedAlloy",
                "dustRedAlloy",
                "dustRedAlloy",
                "dustRedAlloy");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorCondensatorLap", 1, 1, missing),
                "plateDoubleRedAlloy",
                getModItem(IndustrialCraft2.ID, "reactorVentGold", 1, 1, missing),
                "plateDoubleRedAlloy",
                getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, 1, missing),
                "plateDenseLapis",
                getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, 1, missing),
                "plateDoubleRedAlloy",
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1, 1, missing),
                "plateDoubleRedAlloy");
        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "reactorCondensatorLap", 1, 1, missing),
                getModItem(IndustrialCraft2.ID, "reactorCondensatorLap", 1, wildcard, missing),
                "dustLapis",
                "dustLapis",
                "dustLapis",
                "dustLapis",
                "dustLapis",
                "dustLapis",
                "dustLapis",
                "dustLapis");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemTreetap", 1, 0, missing),
                "craftingToolSoftHammer",
                "screwWood",
                "craftingToolScrewdriver",
                "pipeMediumWood",
                "pipeMediumWood",
                "pipeSmallWood",
                "pipeLargeWood",
                "craftingToolSaw",
                "craftingToolFile");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 6, missing),
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
                getModItem(IndustrialCraft2.ID, "itemBarrel", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "ringIron",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "ringIron",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemMugEmpty", 1, 0, missing),
                "plateStone",
                "craftingToolHardHammer",
                "plateStone",
                null,
                "plateStone",
                null);
        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "itemCofeePowder", 1, 0, missing),
                "craftingToolMortar",
                "cropCoffee");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemBoat", 1, 3, missing),
                "screwSteel",
                "plateSteel",
                "screwSteel",
                "craftingToolWrench",
                getModItem(NewHorizonsCoreMod.ID, "item.ElectricBoatHull", 1, 0, missing),
                "craftingToolScrewdriver",
                ItemList.Rotor_LV.get(1L),
                ItemList.Electric_Motor_LV.get(1L),
                ItemList.Rotor_LV.get(1L));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemBoat", 1, 1, missing),
                "plateAnyRubber",
                "craftingToolSaw",
                "plateAnyRubber",
                "plateAnyRubber",
                "craftingToolSoftHammer",
                "plateAnyRubber",
                "plateAnyRubber",
                "plateAnyRubber",
                "plateAnyRubber");
        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "itemBoat", 1, 1, missing),
                getModItem(IndustrialCraft2.ID, "itemBoat", 1, 2, missing),
                "plateAnyRubber",
                "plateAnyRubber",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "windmeter", 1, 0, missing),
                "screwStainlessSteel",
                "rotorAluminium",
                "craftingToolScrewdriver",
                "gearGtSmallStainlessSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 3, missing),
                "gearGtSmallStainlessSteel",
                "plateStainlessSteel",
                "batteryBasic",
                "plateStainlessSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemDoorAlloy", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "blockAlloyGlass", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing),
                "ringLead",
                "screwLead",
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing),
                "plateDenseLead",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing),
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
                getModItem(IndustrialCraft2.ID, "itemBatChargeRE", 1, 0, missing),
                "batteryBasic",
                "cableGt01Tin",
                "batteryBasic",
                "circuitBasic",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 1L),
                "circuitBasic",
                "batteryBasic",
                "cableGt01Tin",
                "batteryBasic");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockPersonal", 1, 0, missing),
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
                getModItem(IndustrialCraft2.ID, "blockCrop", 1, 0, missing),
                "stickLongWood",
                null,
                "stickLongWood",
                "stickLongWood",
                null,
                "stickLongWood");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemFoamSprayer", 1, 0, missing),
                "pipeSmallSteel",
                "craftingToolScrewdriver",
                "screwIron",
                "craftingToolSaw",
                "pipeSmallSteel",
                Materials.Empty.getCells(1),
                "screwIron",
                getModItem(Minecraft.ID, "stone_button", 1, 0, missing),
                "circuitBasic");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorAlloyChestplate", 1, 0, missing),
                "plateAlloyAdvanced",
                "craftingToolHardHammer",
                "plateAlloyAdvanced",
                "plateAlloyAdvanced",
                getModItem(Railcraft.ID, "armor.steel.plate", 1, 0, missing),
                "plateAlloyAdvanced",
                "plateAlloyAdvanced",
                getModItem(Minecraft.ID, "leather_chestplate", 1, 0, missing),
                "plateAlloyAdvanced");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorAlloyChestplate", 1, 0, missing),
                "plateAlloyAdvanced",
                "craftingToolHardHammer",
                "plateAlloyAdvanced",
                "plateAlloyAdvanced",
                getModItem(Minecraft.ID, "leather_chestplate", 1, 0, missing),
                "plateAlloyAdvanced",
                "plateAlloyAdvanced",
                getModItem(Railcraft.ID, "armor.steel.plate", 1, 0, missing),
                "plateAlloyAdvanced");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing),
                "itemCasingSteel",
                "craftingToolHardHammer",
                "itemCasingSteel",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                "screwSteel",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                "itemCasingSteel",
                "craftingToolScrewdriver",
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemNanoSaber", 1, 0, missing),
                "plateAlloyIridium",
                createItemStack(
                        TinkersGregworks.ID,
                        "tGregToolPartLargeSwordBlade",
                        1,
                        1529,
                        "{material:\"TungstenSteel\"}",
                        missing),
                "plateAlloyIridium",
                "circuitMaster",
                "batteryMaster",
                "circuitMaster",
                "craftingToolFile",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 2, missing),
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "obscurator", 1, 0, missing),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "cableGt01Gold",
                CustomItemList.Display.get(1L),
                "cableGt01Gold",
                "itemCasingAnyIron",
                "batteryAdvanced",
                "itemCasingAnyIron");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemScanner", 1, 0, missing),
                "itemCasingGold",
                "plateStainlessSteel",
                "itemCasingGold",
                "circuitAdvanced",
                CustomItemList.Display.get(1L),
                "circuitAdvanced",
                "cableGt01Gold",
                "batteryElite",
                "cableGt01Gold");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemScannerAdv", 1, 0, missing),
                "itemCasingTitanium",
                getModItem(IndustrialCraft2.ID, "itemScanner", 1, wildcard, missing),
                "itemCasingTitanium",
                "circuitData",
                CustomItemList.Display.get(1L),
                "circuitData",
                "cableGt01Nichrome",
                "batteryMaster",
                "cableGt01Nichrome");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 3, missing),
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
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 2, missing),
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
                getModItem(IndustrialCraft2.ID, "blockPersonal", 1, 1, missing),
                "screwSteel",
                "plateSteel",
                "screwSteel",
                "circuitBasic",
                ItemList.Casing_LV.get(1L),
                "circuitBasic",
                "craftingToolHardHammer",
                "plateSteel",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockPersonal", 1, 2, missing),
                "screwSteel",
                getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing),
                "screwSteel",
                "circuitBasic",
                ItemList.Casing_LV.get(1L),
                "circuitBasic",
                "craftingToolHardHammer",
                getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 2, missing),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                "chestIron",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                "itemCasingSteel",
                ItemList.Casing_LV.get(1L),
                "itemCasingSteel",
                "circuitBasic",
                ItemList.Electric_Motor_LV.get(1L),
                "circuitBasic");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine3", 1, 6, missing),
                "itemCasingAnyIron",
                "itemCasingAnyIron",
                "itemCasingAnyIron",
                "craftingChest",
                ItemList.Casing_LV.get(1L),
                "craftingChest",
                "itemCasingAnyIron",
                "itemCasingAnyIron",
                "itemCasingAnyIron");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine3", 1, 5, missing),
                "itemCasingAnyIron",
                "circuitBasic",
                "itemCasingAnyIron",
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 3, missing),
                ItemList.Casing_LV.get(1L),
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 3, missing),
                "itemCasingAnyIron",
                "craftingChest",
                "itemCasingAnyIron");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine3", 1, 4, missing),
                "itemCasingAnyIron",
                "circuitBasic",
                "itemCasingAnyIron",
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 4, missing),
                ItemList.Casing_LV.get(1L),
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 4, missing),
                "pipeLargeSteel",
                Materials.Empty.getCells(1),
                "pipeLargeSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine3", 1, 3, missing),
                "itemCasingAnyIron",
                ItemList.Cover_SolarPanel.get(1L),
                "itemCasingAnyIron",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                ItemList.Casing_LV.get(1L),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                "itemCasingAnyIron",
                "circuitBasic",
                "itemCasingAnyIron");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine3", 1, 0, missing),
                "itemCasingSteel",
                "circuitBasic",
                "itemCasingSteel",
                "pipeMediumSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 6, missing),
                "pipeMediumSteel",
                "itemCasingSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing),
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 15, missing),
                getModItem(IndustrialCraft2.ID, "reactorCoolantSimple", 1, 1, missing),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "reactorCoolantSimple", 1, 1, missing),
                "pipeMediumSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 6, missing),
                "pipeMediumSteel",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                "circuitBasic",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 14, missing),
                "itemCasingSteel",
                "itemCasingSteel",
                "itemCasingSteel",
                "pipeMediumSteel",
                ItemList.Electric_Pump_MV.get(1L),
                "pipeMediumSteel",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                "circuitBasic",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 12, missing),
                "itemCasingSteel",
                ItemList.Electric_Pump_LV.get(1L),
                "itemCasingSteel",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                "chestSteel",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                "itemCasingSteel",
                "circuitBasic",
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 11, missing),
                "circuitElite",
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 2, missing),
                "circuitElite",
                ItemList.Electric_Motor_IV.get(1L),
                getModItem(IndustrialCraft2.ID, "blockMachine", 1, 12, missing),
                ItemList.Electric_Motor_IV.get(1L),
                ItemList.Robot_Arm_IV.get(1L),
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 0, missing),
                ItemList.Robot_Arm_IV.get(1L));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 1, missing),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 4, missing),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                "circuitAdvanced",
                "cableGt04Gold",
                "circuitAdvanced");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine", 1, 9, missing),
                "plateRedAlloy",
                "itemCasingSteel",
                "plateRedAlloy",
                "springSteelMagnetic",
                ItemList.Casing_LV.get(1L),
                "springSteelMagnetic",
                ItemList.Electric_Motor_LV.get(1L),
                "circuitBasic",
                ItemList.Electric_Motor_LV.get(1L));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockChargepad", 1, 3, missing),
                "screwStainlessSteel",
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing),
                "screwStainlessSteel",
                "circuitData",
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 2, missing),
                "circuitData",
                "itemCasingStainlessSteel",
                "craftingToolScrewdriver",
                "itemCasingStainlessSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockChargepad", 1, 2, missing),
                "screwAluminium",
                getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                "screwAluminium",
                "circuitAdvanced",
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 1, missing),
                "circuitAdvanced",
                "itemCasingAluminium",
                "craftingToolScrewdriver",
                "itemCasingAluminium");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockChargepad", 1, 1, missing),
                "screwSteel",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing),
                "screwSteel",
                "circuitGood",
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 7, missing),
                "circuitGood",
                "itemCasingSteel",
                "craftingToolScrewdriver",
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockChargepad", 1, 0, missing),
                "screwIron",
                getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0, missing),
                "screwIron",
                "circuitBasic",
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 0, missing),
                "circuitBasic",
                "itemCasingAnyIron",
                "craftingToolScrewdriver",
                "itemCasingAnyIron");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 1, missing),
                "itemCasingSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing),
                "itemCasingSteel",
                "pipeMediumSteel",
                ItemList.Casing_Firebox_Steel.get(1L),
                "pipeMediumSteel",
                "itemCasingSteel",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 0, missing),
                "itemCasingSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing),
                "itemCasingSteel",
                "screwSteel",
                ItemList.Casing_Firebox_Steel.get(1L),
                "screwSteel",
                "itemCasingSteel",
                "craftingIronFurnace",
                "itemCasingSteel");
        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 1, missing),
                ItemList.Electric_Motor_LV.get(1L));
        addShapelessRecipe(
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 1, missing));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 2, missing),
                "itemCasingStainlessSteel",
                "rotorStainlessSteel",
                "itemCasingStainlessSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12, missing),
                ItemList.Hull_HV.get(1L),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12, missing),
                "cableGt04Gold",
                "rotorStainlessSteel",
                "cableGt04Gold");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 1, missing),
                "itemCasingStainlessSteel",
                "rotorStainlessSteel",
                "itemCasingStainlessSteel",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12, missing),
                getModItem(Railcraft.ID, "machine.beta", 1, 4, missing),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12, missing),
                "circuitAdvanced",
                "rotorStainlessSteel",
                "circuitAdvanced");
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 7, missing),
                "itemCasingSteel",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                "itemCasingSteel",
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 1L),
                ItemList.Hull_LV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.RedAlloy, 1L),
                "itemCasingSteel",
                ItemList.Electric_Motor_LV.get(1L),
                "itemCasingSteel");
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1L),
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
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1L),
                "craftingToolHardHammer",
                null,
                null,
                GT_OreDictUnificator.get(OrePrefixes.ingotDouble, Materials.Iridium, 1L),
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 16L),
                GT_OreDictUnificator.get(OrePrefixes.crateGtPlate, Materials.Iridium, 1L),
                "craftingToolCrowbar",
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.toolHeadAxe, Materials.Iridium, 1L),
                "plateIridium",
                "ingotIridium",
                "craftingToolHardHammer",
                "plateIridium",
                null,
                null,
                "craftingToolFile",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.toolHeadHoe, Materials.Iridium, 1L),
                "plateIridium",
                "ingotIridium",
                "craftingToolHardHammer",
                "craftingToolFile",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.toolHeadSense, Materials.Iridium, 1L),
                "plateIridium",
                "plateIridium",
                "ingotIridium",
                "craftingToolHardHammer",
                "craftingToolFile",
                null);
        addShapedRecipe(
                createItemStack(
                        GregTech.ID,
                        "gt.metatool.01",
                        1,
                        12,
                        "{GT.ToolStats:{PrimaryMaterial:\"Iridium\",MaxDamage:512000L,SecondaryMaterial:\"Steel\"}}",
                        missing),
                "ingotIridium",
                "ingotIridium",
                null,
                "ingotIridium",
                "ingotIridium",
                "stickSteel",
                "ingotIridium",
                "ingotIridium",
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.toolHeadPickaxe, Materials.Iridium, 1L),
                "plateIridium",
                "ingotIridium",
                "ingotIridium",
                "craftingToolFile",
                null,
                "craftingToolHardHammer",
                null,
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.toolHeadPlow, Materials.Iridium, 1L),
                "plateIridium",
                "plateIridium",
                null,
                "plateIridium",
                "plateIridium",
                null,
                "craftingToolHardHammer",
                "craftingToolFile",
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.toolHeadSword, Materials.Iridium, 1L),
                null,
                "plateIridium",
                null,
                "craftingToolFile",
                "plateIridium",
                "craftingToolHardHammer",
                null,
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.toolHeadSaw, Materials.Iridium, 1L),
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
                GT_OreDictUnificator.get(OrePrefixes.toolHeadShovel, Materials.Iridium, 1L),
                "craftingToolFile",
                "plateIridium",
                "craftingToolHardHammer");
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iridium, 16L),
                GT_OreDictUnificator.get(OrePrefixes.crateGtIngot, Materials.Iridium, 1L),
                "craftingToolCrowbar",
                null);
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemWeedingTrowel", 1, 0, missing),
                "screwSteel",
                "stickSteel",
                "craftingToolScrewdriver",
                "plateAnyRubber",
                "stickSteel",
                "stickSteel",
                "stickSteel",
                "plateAnyRubber",
                "screwSteel");
        addShapedRecipe(
                ItemList.Cover_SolarPanel.get(1L),
                "craftingToolCrowbar",
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3, missing),
                "craftingToolScrewdriver",
                "craftingToolWrench",
                "craftingToolHardHammer",
                "craftingToolFile");
        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "itemFluidCell", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 0, missing));
        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemFluidCell", 1, 0, missing));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemPartCFPowder", 1, 0, missing),
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
                        getModItem(IndustrialCraft2.ID, "itemArmorRubBoots", 1, 0, missing),
                        "aba",
                        "-c-",
                        "-d-",
                        'a',
                        "plateRubber",
                        'b',
                        getModItem(IndustrialCraft2.ID, "itemArmorRubBoots", 1, wildcard, missing),
                        'c',
                        "craftingToolSoftHammer",
                        'd',
                        getModItem(TinkerConstruct.ID, "buckets", 1, 25, missing)));
        GameRegistry.addRecipe(
                new ArmorRepairRecipe(
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, 0, missing),
                        "aba",
                        "-c-",
                        "-d-",
                        'a',
                        "plateRubber",
                        'b',
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, wildcard, missing),
                        'c',
                        "craftingToolSoftHammer",
                        'd',
                        getModItem(TinkerConstruct.ID, "buckets", 1, 25, missing)));
        GameRegistry.addRecipe(
                new ArmorRepairRecipe(
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatChestplate", 1, 0, missing),
                        "aba",
                        "-c-",
                        "-d-",
                        'a',
                        "plateRubber",
                        'b',
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatChestplate", 1, wildcard, missing),
                        'c',
                        "craftingToolSoftHammer",
                        'd',
                        getModItem(TinkerConstruct.ID, "buckets", 1, 25, missing)));
        GameRegistry.addRecipe(
                new ArmorRepairRecipe(
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatLeggings", 1, 0, missing),
                        "aba",
                        "-c-",
                        "-d-",
                        'a',
                        "plateRubber",
                        'b',
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatLeggings", 1, wildcard, missing),
                        'c',
                        "craftingToolSoftHammer",
                        'd',
                        getModItem(TinkerConstruct.ID, "buckets", 1, 25, missing)));

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 4, missing),
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
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12, missing),
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
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 9, missing),
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
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12, missing),
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
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 0, missing),
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
                getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing),
                'e',
                ItemList.Electric_Motor_EV.get(1L),
                'f',
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 5, missing),
                'g',
                "cableGt04Aluminium");
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 0, missing),
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
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12, missing),
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

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Rubber, 6L),
                        CustomItemList.MoldBoots.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorRubBoots", 1, 0, missing)).duration(15 * SECONDS)
                .eut(30).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 17880, missing),
                        CustomItemList.MoldBoots.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorRubBoots", 1, 0, missing)).duration(10 * SECONDS)
                .eut(30).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 4L),
                        CustomItemList.MoldBoots.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorBronzeBoots", 1, 0, missing))
                .duration(20 * SECONDS).eut(30).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 8L),
                        CustomItemList.MoldChestplate.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorBronzeChestplate", 1, 0, missing))
                .duration(20 * SECONDS).eut(30).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 5L),
                        CustomItemList.MoldHelmet.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorBronzeHelmet", 1, 0, missing))
                .duration(20 * SECONDS).eut(30).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 7L),
                        CustomItemList.MoldLeggings.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorBronzeLegs", 1, 0, missing))
                .duration(20 * SECONDS).eut(30).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(ItemList.Hull_ULV.get(1L), ItemList.Cover_SolarPanel.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).duration(30 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(ItemList.Hull_ULV.get(1L), ItemList.Cover_SolarPanel.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).duration(30 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(ItemList.Hull_ULV.get(1L), ItemList.Cover_SolarPanel.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).duration(30 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Machine_LV_Canner.get(1L), ItemList.Machine_LV_FluidCanner.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMachine", 1, 6, missing)).duration(1 * MINUTES)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 3, 5, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 576)).duration(30 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 8, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 576)).duration(30 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_MV_LV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 3, missing)).duration(15 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_HV_MV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Copper, 2L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 4, missing))
                .duration(12 * SECONDS + 10 * TICKS).eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_EV_HV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.Gold, 2L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 5, missing)).duration(10 * SECONDS)
                .eut(480).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Transformer_IV_EV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.Steel, 2L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 6, missing)).duration(5 * SECONDS)
                .eut(1920).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 16L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing)).duration(10 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "coal_block", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCoalBlock", 8, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemPartCoalChunk", 1, 0, missing)).duration(1 * MINUTES)
                .eut(64).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Wood, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemTreetap", 1, 0, missing)).duration(10 * SECONDS)
                .eut(8).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockScaffold", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Iron, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockIronScaffold", 1, 0, missing)).duration(15 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemBoat", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17880, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemBoat", 1, 1, missing)).duration(20).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemWeedingTrowel", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 144)).duration(20 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(ItemList.Cover_Screen.get(1L), ItemList.Circuit_Good.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemCropnalyzer", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).duration(1 * MINUTES).eut(16)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Cover_Screen.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolMEter", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glowstone", 288)).duration(30 * SECONDS).eut(16)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 3, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockAlloyGlass", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemDoorAlloy", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 720)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemRemote", 1, 0, missing)).duration(1 * MINUTES).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Silver, 2L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(1 * MINUTES).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "reactorCoolantTriple", 1, 1, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).duration(1 * MINUTES).eut(16)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 2, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 288)).duration(1 * MINUTES).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).duration(1 * MINUTES).eut(16)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        ItemList.Electric_Piston_LV.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).duration(1 * MINUTES).eut(16)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 3, missing),
                        ItemList.Electric_Pump_LV.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).duration(1 * MINUTES).eut(16)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).duration(1 * MINUTES).eut(16)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        ItemList.Conveyor_Module_LV.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).duration(1 * MINUTES).eut(16)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 17880, missing),
                        CustomItemList.ReinforcedGlassLense.get(2L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 144)).duration(25 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 17880, missing),
                        CustomItemList.ReinforcedGlassLense.get(2L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 144)).duration(25 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17880, missing),
                        getModItem(Minecraft.ID, "wool", 4, 1, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorHazmatChestplate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 144)).duration(25 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17880, missing),
                        getModItem(Minecraft.ID, "wool", 4, 1, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorHazmatChestplate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 144)).duration(25 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 7, 17880, missing),
                        getModItem(Minecraft.ID, "carpet", 4, 1, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorHazmatLeggings", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 144)).duration(25 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 7, 17880, missing),
                        getModItem(Minecraft.ID, "carpet", 4, 1, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorHazmatLeggings", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 144)).duration(25 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "iron_helmet", 1, 0, missing), ItemList.Cover_SolarPanel.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemSolarHelmet", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 288)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "iron_helmet", 1, 0, missing), ItemList.Cover_SolarPanel.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemSolarHelmet", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "iron_helmet", 1, 0, missing), ItemList.Cover_SolarPanel.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemSolarHelmet", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 8, 6, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemContainmentbox", 1, 0, missing))
                .duration(15 * SECONDS).eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "chest", 1, 0, missing), ItemList.IC2_Item_Casing_Lead.get(8L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemContainmentbox", 1, 0, missing))
                .duration(15 * SECONDS).eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 5, 2, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolbox", 1, 0, missing)).duration(15 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "chest", 1, 0, missing), ItemList.IC2_Item_Casing_Bronze.get(5L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolbox", 1, 0, missing)).duration(15 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemUran238", 6, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlutonium", 3, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemMOX", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 1000)).duration(20 * SECONDS).eut(256)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemUran238", 6, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemUran235small", 3, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemUran", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 1000)).duration(20 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lead, 2L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockreactorvessel", 1, 0, missing))
                .duration(10 * SECONDS).eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockreactorvessel", 1, 0, missing),
                        ItemList.Electric_Pump_HV.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockReactorFluidPort", 1, 0, missing))
                .duration(20 * SECONDS).eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockreactorvessel", 1, 0, missing),
                        ItemList.Conveyor_Module_HV.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockReactorAccessHatch", 1, 0, missing))
                .duration(20 * SECONDS).eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockreactorvessel", 1, 0, missing),
                        ItemList.Cover_ActivityDetector.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockReactorRedstonePort", 1, 0, missing))
                .duration(20 * SECONDS).eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Mercury, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 8L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockLuminatorDark", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 1152)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 16L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockLuminatorDark", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 1152)).duration(20 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "furnace", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 5L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMachine", 1, 1, missing)).duration(20 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Wood, 8L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockCrop", 16, 0, missing))
                .duration(7 * SECONDS + 10 * TICKS).eut(30).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Steel, 2L),
                        getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 3, 0, missing),
                        ItemList.Hull_MV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing),
                        ItemList.Electric_Motor_MV.get(1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 8, missing)).duration(30 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4L),
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 2, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 2, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockMachine", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMachine", 1, 12, missing))
                .duration(1 * SECONDS + 5 * TICKS).eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, missing, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, missing, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silver, missing, 1L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing)).duration(30 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, missing, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, missing, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silver, missing, 1L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing)).duration(30 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, missing, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, missing, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silver, missing, 1L),
                        GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing)).duration(30 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.BioChunk", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemPartCoalChunk", 1, 0, missing)).duration(1 * MINUTES)
                .eut(120).specialValue(1000).addTo(blastFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.BioOrganicMesh", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemPartCarbonMesh", 1, 0, missing))
                .duration(30 * SECONDS).eut(120).specialValue(1000).addTo(blastFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.BioCarbonPlate", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing))
                .duration(30 * SECONDS).eut(120).specialValue(1000).addTo(blastFurnaceRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonMesh", 8, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.ExtruderShapeBoat", 0, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemBoat", 1, 0, missing)).duration(30 * SECONDS).eut(30)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Rubber, 4L),
                        getModItem(NewHorizonsCoreMod.ID, "item.ExtruderShapeBoat", 0, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemBoat", 1, 1, missing)).duration(10 * SECONDS).eut(16)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "iron_ingot", 8, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.ExtruderShapeBoat", 0, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.ElectricBoatHull", 1, 0, missing))
                .duration(1 * MINUTES).eut(30).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Steel, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 1, 0, missing)).duration(1).eut(64)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Steel, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 2, 0, missing)).duration(4).eut(64)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 4, 0, missing)).duration(8).eut(64)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Steel, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 8, 0, missing)).duration(16).eut(64)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Steel, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 16, 0, missing))
                .duration(1 * SECONDS + 12 * TICKS).eut(64).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.StainlessSteel, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 8, 0, missing)).duration(4).eut(120)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.StainlessSteel, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 16, 0, missing)).duration(8).eut(120)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 32, 0, missing)).duration(16).eut(120)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.StainlessSteel, 1L),
                        ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 64, 0, missing))
                .duration(1 * SECONDS + 12 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemMugEmpty", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemMugCoffee", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("potion.darkcoffee", 500)).duration(8).eut(1)
                .addTo(fluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemMugEmpty", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemMugCoffee", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("potion.cafeaulait", 500)).duration(8).eut(1)
                .addTo(fluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemFoamSprayer", 1, 0, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemFoamSprayer",
                                1,
                                0,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:8000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 8000)).duration(6 * SECONDS + 9 * TICKS)
                .eut(1).addTo(fluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                24,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:8000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 8000)).duration(6 * SECONDS + 9 * TICKS)
                .eut(1).addTo(fluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                21,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:16000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 16000))
                .duration(12 * SECONDS + 18 * TICKS).eut(1).addTo(fluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                19,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:24000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 24000))
                .duration(19 * SECONDS + 7 * TICKS).eut(1).addTo(fluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                16,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:32000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 32000))
                .duration(25 * SECONDS + 16 * TICKS).eut(1).addTo(fluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                13,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:40000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 40000))
                .duration(32 * SECONDS + 5 * TICKS).eut(1).addTo(fluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                10,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:48000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 48000))
                .duration(38 * SECONDS + 14 * TICKS).eut(1).addTo(fluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                7,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:54000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 54000))
                .duration(43 * SECONDS + 10 * TICKS).eut(1).addTo(fluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                4,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:62000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 62000)).duration(50 * SECONDS).eut(1)
                .addTo(fluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                1,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:70000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 70000))
                .duration(56 * SECONDS + 9 * TICKS).eut(1).addTo(fluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                1,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:80000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 80000))
                .duration(1 * MINUTES + 4 * SECONDS + 10 * TICKS).eut(1).addTo(fluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.TenKCell.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "reactorCoolantSimple", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 1000)).duration(16).eut(1)
                .addTo(fluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.ThirtyKCell.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "reactorCoolantTriple", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 3000)).duration(2 * SECONDS + 8 * TICKS).eut(1)
                .addTo(fluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.SixtyKCell.get(1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "reactorCoolantSix", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 6000)).duration(4 * SECONDS + 16 * TICKS).eut(1)
                .addTo(fluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.MoldBoots.get(0L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorRubBoots", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 720)).duration(15 * SECONDS).eut(30)
                .addTo(fluidSolidifierRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(IndustrialCraft2.ID, "itemPartIndustrialDiamond", 1, 0, missing))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Diamond, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Diamond, 2L))
                .duration(3 * MINUTES + 11 * SECONDS + 10 * TICKS).eut(16).addTo(latheRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "blockBasalt", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Basalt, 1L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing))
                .itemOutputs(CustomItemList.LapotronDust.get(30L)).outputChances(10000).duration(15 * SECONDS).eut(2)
                .addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemDust", 8, 2, missing),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemPartCoalBall", 1, 0, missing)).duration(5 * SECONDS)
                .eut(16).addTo(mixerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "iron_boots", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemStaticBoots", 1, 0, missing)).duration(30 * SECONDS)
                .eut(30).addTo(polarizerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Steel, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 1, 0, missing)).duration(5 * SECONDS)
                .eut(4).addTo(wiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Steel, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 2, 0, missing))
                .duration(7 * SECONDS + 10 * TICKS).eut(8).addTo(wiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 4, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(wiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Steel, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 8, 0, missing))
                .duration(12 * SECONDS + 10 * TICKS).eut(30).addTo(wiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Steel, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 16, 0, missing)).duration(15 * SECONDS)
                .eut(64).addTo(wiremillRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.StainlessSteel, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 8, 0, missing)).duration(10 * SECONDS)
                .eut(64).addTo(wiremillRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.StainlessSteel, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 16, 0, missing))
                .duration(12 * SECONDS + 10 * TICKS).eut(96).addTo(wiremillRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 32, 0, missing)).duration(15 * SECONDS)
                .eut(120).addTo(wiremillRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.StainlessSteel, 1L))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 64, 0, missing))
                .duration(17 * SECONDS + 10 * TICKS).eut(256).addTo(wiremillRecipes);
        GT_Values.RA.stdBuilder().fluidInputs(FluidRegistry.getFluidStack("ic2hotcoolant", 1000))
                .fluidOutputs(FluidRegistry.getFluidStack("ic2coolant", 1000)).duration(10 * SECONDS).eut(120)
                .addTo(vacuumFreezerRecipes);
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
