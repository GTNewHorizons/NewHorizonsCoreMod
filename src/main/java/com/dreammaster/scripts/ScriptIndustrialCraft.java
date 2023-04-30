package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.oredict.OreDictHelper;
import gregtech.api.enums.GT_Values;

public class ScriptIndustrialCraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Industrial Craft 2";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList();
    }

    @Override
    public void loadRecipes() {
        addShapelessCraftingRecipe(
                getModItem("IC2", "blockMiningPipe", 1, 0, missing),
                new Object[] { getModItem("IC2", "blockMiningTip", 1, 0, missing) });
        addShapedRecipe(
                getModItem("IC2", "blockHeatGenerator", 1, 3, missing),
                new Object[] { "cableGt01AnyCopper", getModItem("gregtech", "gt.metaitem.01", 1, 32501, missing),
                        "cableGt01AnyCopper", "circuitBasic", getModItem("gregtech", "gt.blockcasings", 1, 2, missing),
                        "circuitBasic", "itemCasingSteel", getModItem("IC2", "itemRecipePart", 1, 5, missing),
                        "itemCasingSteel" });
        addShapedRecipe(
                getModItem("IC2", "blockGenerator", 1, 8, missing),
                new Object[] { "itemCasingSteel", getModItem("IC2", "itemBatREDischarged", 1, 0, missing),
                        "itemCasingSteel", getModItem("IC2", "itemBatREDischarged", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("IC2", "itemBatREDischarged", 1, 0, missing), "circuitBasic",
                        getModItem("IC2", "itemRecipePart", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing) });
        addShapedRecipe(
                getModItem("IC2", "itemRecipePart", 1, 5, missing),
                new Object[] { "plateAnyRubber", "plateCopper", "plateAnyRubber", "plateCopper", "plateSilver",
                        "plateCopper", "plateAnyRubber", "plateCopper", "plateAnyRubber" });
        addShapedRecipe(
                getModItem("IC2", "blockElectric", 1, 0, missing),
                new Object[] { "cableGt01Tin", "plateSteel", "cableGt01Tin",
                        getModItem("IC2", "itemBatREDischarged", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 11, missing),
                        getModItem("IC2", "itemBatREDischarged", 1, 0, missing), "plateSteel",
                        getModItem("IC2", "itemBatREDischarged", 1, 0, missing), "plateSteel" });
        addShapedRecipe(
                getModItem("IC2", "blockElectric", 1, 7, missing),
                new Object[] { "cableGt01AnyCopper", "plateBronze", "cableGt01AnyCopper",
                        getModItem("IC2", "itemAdvBat", 1, 32767, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing),
                        getModItem("IC2", "itemAdvBat", 1, 32767, missing), "plateBronze",
                        getModItem("IC2", "itemAdvBat", 1, 32767, missing), "plateBronze" });
        addShapedRecipe(
                getModItem("IC2", "blockElectric", 1, 1, missing),
                new Object[] { "cableGt01Gold", "batteryElite", "cableGt01Gold", "batteryElite",
                        getModItem("gregtech", "gt.blockmachines", 1, 13, missing), "batteryElite",
                        "plateStainlessSteel", "batteryElite", "plateStainlessSteel" });
        addShapedRecipe(
                getModItem("IC2", "blockElectric", 1, 2, missing),
                new Object[] { "cableGt01TungstenSteel", "batteryMaster", "cableGt01TungstenSteel", "batteryMaster",
                        getModItem("gregtech", "gt.blockmachines", 1, 14, missing), "batteryMaster", "circuitData",
                        "batteryMaster", "circuitData" });
        addShapedRecipe(
                getModItem("IC2", "blockRubber", 1, 0, missing),
                new Object[] { "plateAnyRubber", "plateAnyRubber", "plateAnyRubber", "plateAnyRubber", "plateAnyRubber",
                        "plateAnyRubber", null, null, null });
        addShapedRecipe(
                getModItem("IC2", "blockScaffold", 1, 0, missing),
                new Object[] { "screwIron", getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), "screwIron",
                        "craftingToolWrench", "frameGtWood", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IC2", "blockIronScaffold", 1, 0, missing),
                new Object[] { "screwSteel", "plateIron", "screwSteel", "craftingToolWrench", "frameGtIron",
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IC2", "itemToolMiningLaser", 1, 0, missing),
                new Object[] { "plateTitanium", getModItem("dreamcraft", "item.LaserEmitter", 1, 0, missing),
                        "plateTitanium", "circuitMaster", getModItem("gregtech", "gt.metaitem.01", 1, 32527, missing),
                        "circuitMaster", "craftingToolFile", getModItem("IC2", "itemRecipePart", 1, 2, missing),
                        "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("IC2", "reactorPlating", 1, 0, missing),
                new Object[] { "plateAlloyAdvanced", "plateAlloyAdvanced", "plateAlloyAdvanced", "plateAlloyAdvanced",
                        "plateDenseLead", "plateAlloyAdvanced", "plateAlloyAdvanced", "plateAlloyAdvanced",
                        "plateAlloyAdvanced" });
        addShapedRecipe(
                getModItem("IC2", "reactorPlatingHeat", 1, 0, missing),
                new Object[] { "plateDenseCopper", "plateCopper", "plateDenseCopper", "plateSilver",
                        getModItem("IC2", "reactorPlating", 1, 0, missing), "plateSilver", "plateDenseCopper",
                        "plateCopper", "plateDenseCopper" });
        addShapedRecipe(
                getModItem("IC2", "reactorPlatingExplosive", 1, 0, missing),
                new Object[] { "plateDenseLead", "plateAlloyAdvanced", "plateDenseLead", "plateAlloyAdvanced",
                        getModItem("IC2", "reactorPlating", 1, 0, missing), "plateAlloyAdvanced", "plateDenseLead",
                        "plateAlloyAdvanced", "plateDenseLead" });
        addShapedRecipe(
                getModItem("IC2", "itemRecipePart", 1, 7, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), "ringStainlessSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing) });
        addShapedRecipe(
                getModItem("IC2", "itemwoodrotor", 1, 1, missing),
                new Object[] { "screwSteel", getModItem("IC2", "itemRecipePart", 1, 7, missing), "craftingToolWrench",
                        getModItem("IC2", "itemRecipePart", 1, 7, missing), "ringStainlessSteel",
                        getModItem("IC2", "itemRecipePart", 1, 7, missing), "craftingToolScrewdriver",
                        getModItem("IC2", "itemRecipePart", 1, 7, missing), "screwSteel" });
        addShapedRecipe(
                getModItem("IC2", "itemRecipePart", 1, 8, missing),
                new Object[] { "plateIron", "plateIron", "plateIron", "plateIron", "ringTitanium", "plateIron",
                        "plateIron", "plateIron", "plateIron" });
        addShapedRecipe(
                getModItem("IC2", "itemironrotor", 1, 1, missing),
                new Object[] { getModItem("IC2", "itemRecipePart", 1, 11, missing),
                        getModItem("IC2", "itemRecipePart", 1, 8, missing), "craftingToolHardHammer",
                        getModItem("IC2", "itemRecipePart", 1, 8, missing), "ringTitanium",
                        getModItem("IC2", "itemRecipePart", 1, 8, missing), "craftingToolWrench",
                        getModItem("IC2", "itemRecipePart", 1, 8, missing),
                        getModItem("IC2", "itemRecipePart", 1, 11, missing) });
        addShapedRecipe(
                getModItem("IC2", "itemRecipePart", 1, 10, missing),
                new Object[] { "plateStainlessSteel", "plateStainlessSteel", "plateStainlessSteel",
                        "plateStainlessSteel", "ringTungstenSteel", "plateStainlessSteel", "plateStainlessSteel",
                        "plateStainlessSteel", "plateStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem("IC2", "itemRecipePart", 1, 10, missing),
                new Object[] { getModItem("Railcraft", "part.turbine.blade", 1, 0, missing) });
        addShapedRecipe(
                getModItem("IC2", "itemsteelrotor", 1, 1, missing),
                new Object[] { getModItem("IC2", "itemRecipePart", 1, 12, missing),
                        getModItem("IC2", "itemRecipePart", 1, 10, missing), "craftingToolHardHammer",
                        getModItem("IC2", "itemRecipePart", 1, 10, missing), "ringTungstenSteel",
                        getModItem("IC2", "itemRecipePart", 1, 10, missing), "craftingToolWrench",
                        getModItem("IC2", "itemRecipePart", 1, 10, missing),
                        getModItem("IC2", "itemRecipePart", 1, 12, missing) });
        addShapedRecipe(
                getModItem("IC2", "itemRecipePart", 1, 9, missing),
                new Object[] { getModItem("IC2", "itemPartCarbonPlate", 1, 0, missing),
                        getModItem("IC2", "itemPartCarbonPlate", 1, 0, missing),
                        getModItem("IC2", "itemPartCarbonPlate", 1, 0, missing),
                        getModItem("IC2", "itemPartCarbonPlate", 1, 0, missing), "ringIridium",
                        getModItem("IC2", "itemPartCarbonPlate", 1, 0, missing),
                        getModItem("IC2", "itemPartCarbonPlate", 1, 0, missing),
                        getModItem("IC2", "itemPartCarbonPlate", 1, 0, missing),
                        getModItem("IC2", "itemPartCarbonPlate", 1, 0, missing) });
        addShapedRecipe(
                getModItem("IC2", "itemwcarbonrotor", 1, 1, missing),
                new Object[] { getModItem("miscutils", "itemTungstenSteelShaft", 1, 0, missing),
                        getModItem("IC2", "itemRecipePart", 1, 9, missing), "craftingToolHardHammer",
                        getModItem("IC2", "itemRecipePart", 1, 9, missing), "ringIridium",
                        getModItem("IC2", "itemRecipePart", 1, 9, missing), "craftingToolWrench",
                        getModItem("IC2", "itemRecipePart", 1, 9, missing),
                        getModItem("miscutils", "itemTungstenSteelShaft", 1, 0, missing) });
        addShapedRecipe(
                getModItem("IC2", "blockKineticGenerator", 1, 5, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                        getModItem("IC2", "itemRecipePart", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing), "circuitGood",
                        getModItem("gregtech", "gt.blockcasings", 1, 11, missing), "circuitGood",
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                        getModItem("IC2", "itemRecipePart", 1, 5, missing),
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("IC2", "itemSteamTurbineBlade", 1, 0, missing),
                new Object[] { getModItem("Railcraft", "part.turbine.disk", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("IC2", "itemSteamTurbine", 1, 0, missing),
                new Object[] { getModItem("Railcraft", "part.turbine.rotor", 1, 0, missing) });
        addShapedRecipe(
                getModItem("IC2", "itemSteamTurbine", 1, 0, missing),
                new Object[] { getModItem("IC2", "itemSteamTurbineBlade", 1, 0, missing),
                        getModItem("IC2", "itemSteamTurbineBlade", 1, 0, missing),
                        getModItem("IC2", "itemSteamTurbineBlade", 1, 0, missing), null, "craftingToolWrench", null });
        addShapedRecipe(
                getModItem("IC2", "blockMachine", 1, 1, missing),
                new Object[] { "plateAnyIron", "plateAnyIron", "plateAnyIron", "plateAnyIron", "craftingToolWrench",
                        "plateAnyIron", "plateAnyIron", getModItem("minecraft", "furnace", 1, 0, missing),
                        "plateAnyIron" });
        addShapedRecipe(
                getModItem("IC2", "reactorVent", 1, 1, missing),
                new Object[] { "plateAluminium", getModItem("minecraft", "iron_bars", 1, 0, missing), "plateAluminium",
                        getModItem("minecraft", "iron_bars", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                        getModItem("minecraft", "iron_bars", 1, 0, missing), "plateAluminium",
                        getModItem("minecraft", "iron_bars", 1, 0, missing), "plateAluminium" });
        addShapedRecipe(
                getModItem("IC2", "reactorVentCore", 1, 1, missing),
                new Object[] { "plateDoubleCopper", "plateSilver", "plateDoubleCopper", "plateSilver",
                        getModItem("IC2", "reactorVent", 1, 1, missing), "plateSilver", "plateDoubleCopper",
                        "plateSilver", "plateDoubleCopper" });
        addShapedRecipe(
                getModItem("IC2", "reactorVentDiamond", 1, 1, missing),
                new Object[] { getModItem("dreamcraft", "item.StainlessSteelBars", 1, 0, missing),
                        getModItem("IC2", "reactorVent", 1, 1, missing),
                        getModItem("dreamcraft", "item.StainlessSteelBars", 1, 0, missing),
                        getModItem("dreamcraft", "item.StainlessSteelBars", 1, 0, missing),
                        getModItem("IC2", "itemPartIndustrialDiamond", 1, 0, missing),
                        getModItem("dreamcraft", "item.StainlessSteelBars", 1, 0, missing),
                        getModItem("dreamcraft", "item.StainlessSteelBars", 1, 0, missing),
                        getModItem("IC2", "reactorVent", 1, 1, missing),
                        getModItem("dreamcraft", "item.StainlessSteelBars", 1, 0, missing) });
        addShapedRecipe(
                getModItem("IC2", "reactorVentGold", 1, 1, missing),
                new Object[] { "screwStainlessSteel", "plateGold", "screwStainlessSteel", "plateGold",
                        getModItem("IC2", "reactorVentDiamond", 1, 1, missing), "plateGold", "screwStainlessSteel",
                        "plateGold", "screwStainlessSteel" });
        addShapedRecipe(
                getModItem("IC2", "reactorVentSpread", 1, 0, missing),
                new Object[] { getModItem("dreamcraft", "item.SteelBars", 1, 0, missing), "plateDenseTin",
                        getModItem("dreamcraft", "item.SteelBars", 1, 0, missing), "plateDenseTin",
                        getModItem("IC2", "reactorVent", 1, 1, missing), "plateDenseTin",
                        getModItem("dreamcraft", "item.SteelBars", 1, 0, missing), "plateDenseTin",
                        getModItem("dreamcraft", "item.SteelBars", 1, 0, missing) });
        addShapedRecipe(
                getModItem("IC2", "reactorHeatSwitch", 1, 1, missing),
                new Object[] { "plateSilver", "circuitAdvanced", "plateSilver", "plateAluminium", "plateCopper",
                        "plateAluminium", "plateSilver", "plateAluminium", "plateSilver" });
        addShapedRecipe(
                getModItem("IC2", "reactorHeatSwitchCore", 1, 1, missing),
                new Object[] { "plateDoubleCopper", "plateSilver", "plateDoubleCopper", "plateSilver",
                        getModItem("IC2", "reactorHeatSwitch", 1, 1, missing), "plateSilver", "plateDoubleCopper",
                        "plateSilver", "plateDoubleCopper" });
        addShapedRecipe(
                getModItem("IC2", "reactorHeatSwitchSpread", 1, 1, missing),
                new Object[] { "screwStainlessSteel", "plateGold", "screwStainlessSteel", "plateGold",
                        getModItem("IC2", "reactorHeatSwitch", 1, 1, missing), "plateGold", "screwStainlessSteel",
                        "plateGold", "screwStainlessSteel" });
        addShapedRecipe(
                getModItem("IC2", "reactorHeatSwitchDiamond", 1, 1, missing),
                new Object[] { "plateLapis", "circuitData", "plateLapis",
                        getModItem("IC2", "reactorHeatSwitch", 1, 1, missing), "plateDiamond",
                        getModItem("IC2", "reactorHeatSwitch", 1, 1, missing), "plateLapis", "circuitData",
                        "plateLapis" });
        addShapedRecipe(
                getModItem("IC2", "reactorCondensator", 1, 1, missing),
                new Object[] { "plateRedAlloy", getModItem("IC2", "reactorHeatSwitchCore", 1, 1, missing),
                        "plateRedAlloy", "plateRedAlloy", getModItem("IC2", "reactorVentCore", 1, 1, missing),
                        "plateRedAlloy", "plateRedAlloy", getModItem("IC2", "reactorHeatSwitchCore", 1, 1, missing),
                        "plateRedAlloy" });
        addShapelessCraftingRecipe(
                getModItem("IC2", "reactorCondensator", 1, 1, missing),
                new Object[] { getModItem("IC2", "reactorCondensator", 1, 32767, missing), "dustRedAlloy",
                        "dustRedAlloy", "dustRedAlloy", "dustRedAlloy", "dustRedAlloy", "dustRedAlloy", "dustRedAlloy",
                        "dustRedAlloy" });
        addShapedRecipe(
                getModItem("IC2", "reactorCondensatorLap", 1, 1, missing),
                new Object[] { "plateDoubleRedAlloy", getModItem("IC2", "reactorVentGold", 1, 1, missing),
                        "plateDoubleRedAlloy", getModItem("IC2", "reactorCondensator", 1, 1, missing),
                        "plateDenseLapis", getModItem("IC2", "reactorCondensator", 1, 1, missing),
                        "plateDoubleRedAlloy", getModItem("IC2", "reactorHeatSwitchSpread", 1, 1, missing),
                        "plateDoubleRedAlloy" });
        addShapelessCraftingRecipe(
                getModItem("IC2", "reactorCondensatorLap", 1, 1, missing),
                new Object[] { getModItem("IC2", "reactorCondensatorLap", 1, 32767, missing), "dustLapis", "dustLapis",
                        "dustLapis", "dustLapis", "dustLapis", "dustLapis", "dustLapis", "dustLapis" });
        addShapedRecipe(
                getModItem("IC2", "itemTreetap", 1, 0, missing),
                new Object[] { "craftingToolSoftHammer", "screwWood", "craftingToolScrewdriver", "pipeMediumWood",
                        "pipeMediumWood", "pipeSmallWood", "pipeLargeWood", "craftingToolSaw", "craftingToolFile" });
        addShapedRecipe(
                getModItem("IC2", "itemRecipePart", 1, 6, missing),
                new Object[] { "itemCasingAnyCopper", "itemCasingAnyCopper", "itemCasingAnyCopper", "screwCopper",
                        "craftingToolWrench", "screwCopper", "itemCasingAnyCopper", "itemCasingAnyCopper",
                        "itemCasingAnyCopper" });
        addShapedRecipe(
                getModItem("IC2", "itemBarrel", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), "ringIron",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), "ringIron",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing) });
        addShapedRecipe(
                getModItem("IC2", "itemMugEmpty", 1, 0, missing),
                new Object[] { "plateStone", "craftingToolHardHammer", "plateStone", null, "plateStone", null });
        addShapelessCraftingRecipe(
                getModItem("IC2", "itemCofeePowder", 1, 0, missing),
                new Object[] { "craftingToolMortar", "cropCoffee" });
        addShapedRecipe(
                getModItem("IC2", "itemBoat", 1, 3, missing),
                new Object[] { "screwSteel", "plateSteel", "screwSteel", "craftingToolWrench",
                        getModItem("dreamcraft", "item.ElectricBoatHull", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem("gregtech", "gt.metaitem.02", 1, 21057, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 21057, missing) });
        addShapedRecipe(
                getModItem("IC2", "itemBoat", 1, 1, missing),
                new Object[] { "plateAnyRubber", "craftingToolSaw", "plateAnyRubber", "plateAnyRubber",
                        "craftingToolSoftHammer", "plateAnyRubber", "plateAnyRubber", "plateAnyRubber",
                        "plateAnyRubber" });
        addShapelessCraftingRecipe(
                getModItem("IC2", "itemBoat", 1, 1, missing),
                new Object[] { getModItem("IC2", "itemBoat", 1, 2, missing), "plateAnyRubber", "plateAnyRubber",
                        "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("IC2", "windmeter", 1, 0, missing),
                new Object[] { "screwStainlessSteel", "rotorAluminium", "craftingToolScrewdriver",
                        "gearGtSmallStainlessSteel", getModItem("IC2", "itemRecipePart", 1, 3, missing),
                        "gearGtSmallStainlessSteel", "plateStainlessSteel", "batteryBasic", "plateStainlessSteel" });
        addShapedRecipe(
                getModItem("IC2", "itemDoorAlloy", 1, 0, missing),
                new Object[] { getModItem("IC2", "itemPartAlloy", 1, 0, missing),
                        getModItem("IC2", "blockAlloyGlass", 1, 0, missing), "craftingToolHardHammer",
                        getModItem("IC2", "itemPartAlloy", 1, 0, missing), "ringLead", "screwLead",
                        getModItem("IC2", "itemPartAlloy", 1, 0, missing), "plateDenseLead",
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IC2", "itemToolPainter", 1, 0, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", null, "stickSteel", null, null, "stickSteel",
                        null });
        addShapedRecipe(
                getModItem("IC2", "itemBatChargeRE", 1, 0, missing),
                new Object[] { "batteryBasic", "cableGt01Tin", "batteryBasic", "circuitBasic",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17315, missing), "circuitBasic", "batteryBasic",
                        "cableGt01Tin", "batteryBasic" });
        addShapedRecipe(
                getModItem("IC2", "blockPersonal", 1, 0, missing),
                new Object[] { "screwIron", "circuitBasic", "screwIron", "craftingToolScrewdriver",
                        getModItem("gregtech", "gt.blockcasings", 1, 1, missing), "craftingToolHardHammer", "screwIron",
                        "chestIron", "screwIron" });
        addShapedRecipe(
                getModItem("IC2", "blockCrop", 1, 0, missing),
                new Object[] { "stickLongWood", null, "stickLongWood", "stickLongWood", null, "stickLongWood" });
        addShapedRecipe(
                getModItem("IC2", "itemFoamSprayer", 1, 0, missing),
                new Object[] { "pipeSmallSteel", "craftingToolScrewdriver", "screwIron", "craftingToolSaw",
                        "pipeSmallSteel", getModItem("IC2", "itemFluidCell", 1, 0, missing), "screwIron",
                        getModItem("minecraft", "stone_button", 1, 0, missing), "circuitBasic" });
        addShapedRecipe(
                getModItem("IC2", "itemArmorAlloyChestplate", 1, 0, missing),
                new Object[] { "plateAlloyAdvanced", "craftingToolHardHammer", "plateAlloyAdvanced",
                        "plateAlloyAdvanced", getModItem("Railcraft", "armor.steel.plate", 1, 0, missing),
                        "plateAlloyAdvanced", "plateAlloyAdvanced",
                        getModItem("minecraft", "leather_chestplate", 1, 0, missing), "plateAlloyAdvanced" });
        addShapedRecipe(
                getModItem("IC2", "itemArmorAlloyChestplate", 1, 0, missing),
                new Object[] { "plateAlloyAdvanced", "craftingToolHardHammer", "plateAlloyAdvanced",
                        "plateAlloyAdvanced", getModItem("minecraft", "leather_chestplate", 1, 0, missing),
                        "plateAlloyAdvanced", "plateAlloyAdvanced",
                        getModItem("Railcraft", "armor.steel.plate", 1, 0, missing), "plateAlloyAdvanced" });
        addShapedRecipe(
                getModItem("IC2", "itemArmorCFPack", 1, 26, missing),
                new Object[] { "itemCasingSteel", "craftingToolHardHammer", "itemCasingSteel",
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing), "screwSteel",
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing), "itemCasingSteel",
                        "craftingToolScrewdriver", "itemCasingSteel" });
        addShapedRecipe(
                getModItem("IC2", "itemNanoSaber", 1, 0, missing),
                new Object[] { "plateAlloyIridium",
                        createItemStack(
                                "TGregworks",
                                "tGregToolPartLargeSwordBlade",
                                1,
                                1529,
                                "{material:\"TungstenSteel\"}",
                                missing),
                        "plateAlloyIridium", "circuitMaster", "batteryMaster", "circuitMaster", "craftingToolFile",
                        getModItem("IC2", "itemRecipePart", 1, 2, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("IC2", "obscurator", 1, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "cableGt01Gold",
                        getModItem("dreamcraft", "item.Display", 1, 0, missing), "cableGt01Gold", "itemCasingAnyIron",
                        "batteryAdvanced", "itemCasingAnyIron" });
        addShapedRecipe(
                getModItem("IC2", "itemScanner", 1, 0, missing),
                new Object[] { "itemCasingGold", "plateStainlessSteel", "itemCasingGold", "circuitAdvanced",
                        getModItem("dreamcraft", "item.Display", 1, 0, missing), "circuitAdvanced", "cableGt01Gold",
                        "batteryElite", "cableGt01Gold" });
        addShapedRecipe(
                getModItem("IC2", "itemScannerAdv", 1, 0, missing),
                new Object[] { "itemCasingTitanium", getModItem("IC2", "itemScanner", 1, 32767, missing),
                        "itemCasingTitanium", "circuitData", getModItem("dreamcraft", "item.Display", 1, 0, missing),
                        "circuitData", "cableGt01Nichrome", "batteryMaster", "cableGt01Nichrome" });
        addShapedRecipe(
                getModItem("IC2", "itemRecipePart", 1, 3, missing),
                new Object[] { "cableGt01AnyCopper", "itemCasingSteel", "cableGt01AnyCopper", "itemCasingSteel",
                        "craftingToolScrewdriver", "itemCasingSteel", "circuitBasic",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "circuitBasic" });
        addShapedRecipe(
                getModItem("IC2", "itemRecipePart", 1, 2, missing),
                new Object[] { "cableGt02Gold", "itemCasingStainlessSteel", "cableGt02Gold", "itemCasingStainlessSteel",
                        "craftingToolScrewdriver", "itemCasingStainlessSteel", "circuitAdvanced",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing), "circuitAdvanced" });
        addShapedRecipe(
                getModItem("IC2", "blockPersonal", 1, 1, missing),
                new Object[] { "screwSteel", "plateSteel", "screwSteel", "circuitBasic",
                        getModItem("gregtech", "gt.blockcasings", 1, 1, missing), "circuitBasic",
                        "craftingToolHardHammer", "plateSteel", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IC2", "blockPersonal", 1, 2, missing),
                new Object[] { "screwSteel", getModItem("IC2", "itemBatREDischarged", 1, 0, missing), "screwSteel",
                        "circuitBasic", getModItem("gregtech", "gt.blockcasings", 1, 1, missing), "circuitBasic",
                        "craftingToolHardHammer", getModItem("IC2", "itemBatREDischarged", 1, 0, missing),
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IC2", "blockMachine2", 1, 2, missing),
                new Object[] { getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing), "chestIron",
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing), "itemCasingSteel",
                        getModItem("gregtech", "gt.blockcasings", 1, 1, missing), "itemCasingSteel", "circuitBasic",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "circuitBasic" });
        addShapedRecipe(
                getModItem("IC2", "blockMachine3", 1, 6, missing),
                new Object[] { "itemCasingAnyIron", "itemCasingAnyIron", "itemCasingAnyIron", "craftingChest",
                        getModItem("gregtech", "gt.blockcasings", 1, 1, missing), "craftingChest", "itemCasingAnyIron",
                        "itemCasingAnyIron", "itemCasingAnyIron" });
        addShapedRecipe(
                getModItem("IC2", "blockMachine3", 1, 5, missing),
                new Object[] { "itemCasingAnyIron", "circuitBasic", "itemCasingAnyIron",
                        getModItem("IC2", "upgradeModule", 1, 3, missing),
                        getModItem("gregtech", "gt.blockcasings", 1, 1, missing),
                        getModItem("IC2", "upgradeModule", 1, 3, missing), "itemCasingAnyIron", "craftingChest",
                        "itemCasingAnyIron" });
        addShapedRecipe(
                getModItem("IC2", "blockMachine3", 1, 4, missing),
                new Object[] { "itemCasingAnyIron", "circuitBasic", "itemCasingAnyIron",
                        getModItem("IC2", "upgradeModule", 1, 4, missing),
                        getModItem("gregtech", "gt.blockcasings", 1, 1, missing),
                        getModItem("IC2", "upgradeModule", 1, 4, missing), "pipeLargeSteel",
                        getModItem("IC2", "itemFluidCell", 1, 0, missing), "pipeLargeSteel" });
        addShapedRecipe(
                getModItem("IC2", "blockMachine3", 1, 3, missing),
                new Object[] { "itemCasingAnyIron", getModItem("gregtech", "gt.metaitem.01", 1, 32750, missing),
                        "itemCasingAnyIron", getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                        getModItem("gregtech", "gt.blockcasings", 1, 1, missing),
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing), "itemCasingAnyIron",
                        "circuitBasic", "itemCasingAnyIron" });
        addShapedRecipe(
                getModItem("IC2", "blockMachine3", 1, 0, missing),
                new Object[] { "itemCasingSteel", "circuitBasic", "itemCasingSteel", "pipeMediumSteel",
                        getModItem("IC2", "itemRecipePart", 1, 6, missing), "pipeMediumSteel", "itemCasingSteel",
                        getModItem("IC2", "itemRecipePart", 1, 5, missing), "itemCasingSteel" });
        addShapedRecipe(
                getModItem("IC2", "blockMachine2", 1, 15, missing),
                new Object[] { getModItem("IC2", "reactorCoolantSimple", 1, 1, missing),
                        getModItem("IC2", "itemRecipePart", 1, 0, missing),
                        getModItem("IC2", "reactorCoolantSimple", 1, 1, missing), "pipeMediumSteel",
                        getModItem("IC2", "itemRecipePart", 1, 6, missing), "pipeMediumSteel",
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing), "circuitBasic",
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem("IC2", "blockMachine2", 1, 14, missing),
                new Object[] { "itemCasingSteel", "itemCasingSteel", "itemCasingSteel", "pipeMediumSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32611, missing), "pipeMediumSteel",
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing), "circuitBasic",
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem("IC2", "blockMachine2", 1, 12, missing),
                new Object[] { "itemCasingSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                        "itemCasingSteel", getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing), "chestSteel",
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing), "itemCasingSteel", "circuitBasic",
                        "itemCasingSteel" });
        addShapedRecipe(
                getModItem("IC2", "blockMachine2", 1, 11, missing),
                new Object[] { "circuitElite", getModItem("IC2", "blockElectric", 1, 2, missing), "circuitElite",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32604, missing),
                        getModItem("IC2", "blockMachine", 1, 12, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32604, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32654, missing),
                        getModItem("IC2", "blockMachine2", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32654, missing) });
        addShapedRecipe(
                getModItem("IC2", "blockMachine2", 1, 1, missing),
                new Object[] { getModItem("IC2", "itemRecipePart", 1, 0, missing),
                        getModItem("IC2", "itemRecipePart", 1, 0, missing),
                        getModItem("IC2", "itemRecipePart", 1, 0, missing),
                        getModItem("IC2", "itemRecipePart", 1, 0, missing),
                        getModItem("IC2", "blockElectric", 1, 4, missing),
                        getModItem("IC2", "itemRecipePart", 1, 0, missing), "circuitAdvanced", "cableGt04Gold",
                        "circuitAdvanced" });
        addShapedRecipe(
                getModItem("IC2", "blockMachine", 1, 9, missing),
                new Object[] { "plateRedAlloy", "itemCasingSteel", "plateRedAlloy", "springSteelMagnetic",
                        getModItem("gregtech", "gt.blockcasings", 1, 1, missing), "springSteelMagnetic",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "circuitBasic",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing) });
        addShapedRecipe(
                getModItem("IC2", "blockChargepad", 1, 3, missing),
                new Object[] { "screwStainlessSteel",
                        getModItem("minecraft", "light_weighted_pressure_plate", 1, 0, missing), "screwStainlessSteel",
                        "circuitData", getModItem("IC2", "blockElectric", 1, 2, missing), "circuitData",
                        "itemCasingStainlessSteel", "craftingToolScrewdriver", "itemCasingStainlessSteel" });
        addShapedRecipe(
                getModItem("IC2", "blockChargepad", 1, 2, missing),
                new Object[] { "screwAluminium",
                        getModItem("minecraft", "heavy_weighted_pressure_plate", 1, 0, missing), "screwAluminium",
                        "circuitAdvanced", getModItem("IC2", "blockElectric", 1, 1, missing), "circuitAdvanced",
                        "itemCasingAluminium", "craftingToolScrewdriver", "itemCasingAluminium" });
        addShapedRecipe(
                getModItem("IC2", "blockChargepad", 1, 1, missing),
                new Object[] { "screwSteel", getModItem("minecraft", "stone_pressure_plate", 1, 0, missing),
                        "screwSteel", "circuitGood", getModItem("IC2", "blockElectric", 1, 7, missing), "circuitGood",
                        "itemCasingSteel", "craftingToolScrewdriver", "itemCasingSteel" });
        addShapedRecipe(
                getModItem("IC2", "blockChargepad", 1, 0, missing),
                new Object[] { "screwIron", getModItem("minecraft", "wooden_pressure_plate", 1, 0, missing),
                        "screwIron", "circuitBasic", getModItem("IC2", "blockElectric", 1, 0, missing), "circuitBasic",
                        "itemCasingAnyIron", "craftingToolScrewdriver", "itemCasingAnyIron" });
        addShapedRecipe(
                getModItem("IC2", "blockHeatGenerator", 1, 1, missing),
                new Object[] { "itemCasingSteel", getModItem("IC2", "itemRecipePart", 1, 5, missing), "itemCasingSteel",
                        "pipeMediumSteel", getModItem("gregtech", "gt.blockcasings3", 1, 14, missing),
                        "pipeMediumSteel", "itemCasingSteel",
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing), "itemCasingSteel" });
        addShapedRecipe(
                getModItem("IC2", "blockHeatGenerator", 1, 0, missing),
                new Object[] { "itemCasingSteel", getModItem("IC2", "itemRecipePart", 1, 5, missing), "itemCasingSteel",
                        "screwSteel", getModItem("gregtech", "gt.blockcasings3", 1, 14, missing), "screwSteel",
                        "itemCasingSteel", "craftingIronFurnace", "itemCasingSteel" });
        addShapelessCraftingRecipe(
                getModItem("IC2", "itemRecipePart", 1, 1, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                new Object[] { getModItem("IC2", "itemRecipePart", 1, 1, missing) });
        addShapedRecipe(
                getModItem("IC2", "blockKineticGenerator", 1, 2, missing),
                new Object[] { "itemCasingStainlessSteel", "rotorStainlessSteel", "itemCasingStainlessSteel",
                        getModItem("IC2", "itemRecipePart", 1, 12, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 13, missing),
                        getModItem("IC2", "itemRecipePart", 1, 12, missing), "cableGt04Gold", "rotorStainlessSteel",
                        "cableGt04Gold" });
        addShapedRecipe(
                getModItem("IC2", "blockKineticGenerator", 1, 1, missing),
                new Object[] { "itemCasingStainlessSteel", "rotorStainlessSteel", "itemCasingStainlessSteel",
                        getModItem("IC2", "itemRecipePart", 1, 12, missing),
                        getModItem("Railcraft", "machine.beta", 1, 4, missing),
                        getModItem("IC2", "itemRecipePart", 1, 12, missing), "circuitAdvanced", "rotorStainlessSteel",
                        "circuitAdvanced" });
        addShapedRecipe(
                getModItem("IC2", "blockGenerator", 1, 7, missing),
                new Object[] { "itemCasingSteel", getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                        "itemCasingSteel", getModItem("gregtech", "gt.blockmachines", 1, 2006, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 11, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 2006, missing), "itemCasingSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "itemCasingSteel" });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 17084, missing),
                new Object[] { "craftingToolHardHammer", null, null, "ingotIridium", null, null, "ingotIridium", null,
                        null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 17084, missing),
                new Object[] { "craftingToolHardHammer", null, null,
                        getModItem("gregtech", "gt.metaitem.01", 1, 13084, missing), null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 16, 17084, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.03", 1, 3084, missing), "craftingToolCrowbar",
                        null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 3084, missing),
                new Object[] { "plateIridium", "ingotIridium", "craftingToolHardHammer", "plateIridium", null, null,
                        "craftingToolFile", null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 4084, missing),
                new Object[] { "plateIridium", "ingotIridium", "craftingToolHardHammer", "craftingToolFile", null,
                        null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 12084, missing),
                new Object[] { "plateIridium", "plateIridium", "ingotIridium", "craftingToolHardHammer",
                        "craftingToolFile", null });
        addShapedRecipe(
                createItemStack(
                        "gregtech",
                        "gt.metatool.01",
                        1,
                        12,
                        "{GT.ToolStats:{PrimaryMaterial:\"Iridium\",MaxDamage:512000L,SecondaryMaterial:\"Steel\"}}",
                        missing),
                new Object[] { "ingotIridium", "ingotIridium", null, "ingotIridium", "ingotIridium", "stickSteel",
                        "ingotIridium", "ingotIridium", null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 1084, missing),
                new Object[] { "plateIridium", "ingotIridium", "ingotIridium", "craftingToolFile", null,
                        "craftingToolHardHammer", null, null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 13084, missing),
                new Object[] { "plateIridium", "plateIridium", null, "plateIridium", "plateIridium", null,
                        "craftingToolHardHammer", "craftingToolFile", null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 84, missing),
                new Object[] { null, "plateIridium", null, "craftingToolFile", "plateIridium", "craftingToolHardHammer",
                        null, null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 7084, missing),
                new Object[] { "plateIridium", "plateIridium", null, "craftingToolFile", "craftingToolHardHammer", null,
                        null, null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 2084, missing),
                new Object[] { "craftingToolFile", "plateIridium", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 16, 11084, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.03", 1, 1084, missing), "craftingToolCrowbar",
                        null });
        addShapedRecipe(
                getModItem("IC2", "itemWeedingTrowel", 1, 0, missing),
                new Object[] { "screwSteel", "stickSteel", "craftingToolScrewdriver", "plateAnyRubber", "stickSteel",
                        "stickSteel", "stickSteel", "plateAnyRubber", "screwSteel" });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32750, missing),
                new Object[] { "craftingToolCrowbar", getModItem("IC2", "blockGenerator", 1, 3, missing),
                        "craftingToolScrewdriver", "craftingToolWrench", "craftingToolHardHammer",
                        "craftingToolFile" });
        addShapelessCraftingRecipe(
                getModItem("IC2", "itemFluidCell", 1, 0, missing),
                new Object[] { getModItem("IC2", "itemCellEmpty", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("IC2", "itemCellEmpty", 1, 0, missing),
                new Object[] { getModItem("IC2", "itemFluidCell", 1, 0, missing) });
        addShapedRecipe(
                getModItem("IC2", "itemPartCFPowder", 1, 0, missing),
                new Object[] { "dustCalcite", "dustCalcite", "dustStone", "dustClay", "dustQuartzSand", null, null,
                        null, null });
        addShapedRecipe(
                getModItem("IC2", "itemArmorRubBoots", 1, 0, missing),
                new Object[] { "plateRubber", getModItem("IC2", "itemArmorRubBoots", 1, 32767, missing), "plateRubber",
                        null, "craftingToolSoftHammer", null, null, getModItem("TConstruct", "buckets", 1, 25, missing),
                        null });
        addShapedRecipe(
                getModItem("IC2", "itemArmorHazmatHelmet", 1, 0, missing),
                new Object[] { "plateRubber", getModItem("IC2", "itemArmorHazmatHelmet", 1, 32767, missing),
                        "plateRubber", null, "craftingToolSoftHammer", null, null,
                        getModItem("TConstruct", "buckets", 1, 25, missing), null });
        addShapedRecipe(
                getModItem("IC2", "itemArmorHazmatChestplate", 1, 0, missing),
                new Object[] { "plateRubber", getModItem("IC2", "itemArmorHazmatChestplate", 1, 32767, missing),
                        "plateRubber", null, "craftingToolSoftHammer", null, null,
                        getModItem("TConstruct", "buckets", 1, 25, missing), null });
        addShapedRecipe(
                getModItem("IC2", "itemArmorHazmatLeggings", 1, 0, missing),
                new Object[] { "plateRubber", getModItem("IC2", "itemArmorHazmatLeggings", 1, 32767, missing),
                        "plateRubber", null, "craftingToolSoftHammer", null, null,
                        getModItem("TConstruct", "buckets", 1, 25, missing), null });

        OreDictHelper.removeOreDict("plateSteel", getModItem("IC2", "itemPlates", 1, 5, missing));

        GT_Values.RA.addFuel(
                createItemStack("IC2", "itemFluidCell", 1, 0, "{Fluid:{FluidName:\"ic2biogas\",Amount:1000}}", missing),
                getModItem("IC2", "itemFluidCell", 1, 0, missing),
                40,
                1);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemUran238", 9, 0, missing))
                .itemOutputs(getModItem("IC2", "blockMetal", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "reeds", 8, 0, missing))
                .itemOutputs(getModItem("IC2", "itemFuelPlantBall", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "sapling", 8, 32767, missing))
                .itemOutputs(getModItem("IC2", "itemFuelPlantBall", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "saplings", 8, 32767, missing))
                .itemOutputs(getModItem("IC2", "itemFuelPlantBall", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "colorizedSaplings", 8, 32767, missing))
                .itemOutputs(getModItem("IC2", "itemFuelPlantBall", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "blockRubSapling", 8, 0, missing))
                .itemOutputs(getModItem("IC2", "itemFuelPlantBall", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Forestry", "sapling", 8, 32767, missing))
                .itemOutputs(getModItem("IC2", "itemFuelPlantBall", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "florasapling", 8, 32767, missing))
                .itemOutputs(getModItem("IC2", "itemFuelPlantBall", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Rare Sapling", 8, 32767, missing))
                .itemOutputs(getModItem("IC2", "itemFuelPlantBall", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Thaumcraft", "blockCustomPlant", 8, 0, missing))
                .itemOutputs(getModItem("IC2", "itemFuelPlantBall", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Thaumcraft", "blockCustomPlant", 8, 1, missing))
                .itemOutputs(getModItem("IC2", "itemFuelPlantBall", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("TwilightForest", "tile.TFSapling", 8, 32767, missing))
                .itemOutputs(getModItem("IC2", "itemFuelPlantBall", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 6, 2880, missing),
                        getModItem("dreamcraft", "item.MoldBoots", 0, 0, missing))
                .itemOutputs(getModItem("IC2", "itemArmorRubBoots", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 6, 17880, missing),
                        getModItem("dreamcraft", "item.MoldBoots", 0, 0, missing))
                .itemOutputs(getModItem("IC2", "itemArmorRubBoots", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 11300, missing),
                        getModItem("dreamcraft", "item.MoldBoots", 0, 0, missing))
                .itemOutputs(getModItem("IC2", "itemArmorBronzeBoots", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 8, 11300, missing),
                        getModItem("dreamcraft", "item.MoldChestplate", 0, 0, missing))
                .itemOutputs(getModItem("IC2", "itemArmorBronzeChestplate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 5, 11300, missing),
                        getModItem("dreamcraft", "item.MoldHelmet", 0, 0, missing))
                .itemOutputs(getModItem("IC2", "itemArmorBronzeHelmet", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 7, 11300, missing),
                        getModItem("dreamcraft", "item.MoldLeggings", 0, 0, missing))
                .itemOutputs(getModItem("IC2", "itemArmorBronzeLegs", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 10, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32750, missing))
                .itemOutputs(getModItem("IC2", "blockGenerator", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 10, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32750, missing))
                .itemOutputs(getModItem("IC2", "blockGenerator", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 10, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32750, missing))
                .itemOutputs(getModItem("IC2", "blockGenerator", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 231, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 431, missing))
                .itemOutputs(getModItem("IC2", "blockMachine", 1, 6, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "blockGenerator", 1, 5, missing),
                        getModItem("IC2", "itemRecipePart", 3, 5, missing))
                .itemOutputs(getModItem("IC2", "blockHeatGenerator", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 576)).noFluidOutputs().duration(600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "blockGenerator", 1, 5, missing),
                        getModItem("IC2", "blockGenerator", 1, 8, missing))
                .itemOutputs(getModItem("IC2", "blockGenerator", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 576)).noFluidOutputs().duration(600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 21, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 1246, missing))
                .itemOutputs(getModItem("IC2", "blockElectric", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 22, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 1367, missing))
                .itemOutputs(getModItem("IC2", "blockElectric", 1, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(250).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 23, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 1428, missing))
                .itemOutputs(getModItem("IC2", "blockElectric", 1, 5, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 24, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 1529, missing))
                .itemOutputs(getModItem("IC2", "blockElectric", 1, 6, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 23355, missing),
                        getModItem("gregtech", "gt.blockmachines", 16, 1360, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("IC2", "itemRecipePart", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "coal_block", 1, 0, missing),
                        getModItem("IC2", "itemPartCoalBlock", 8, 0, missing))
                .itemOutputs(getModItem("IC2", "itemPartCoalChunk", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 3, 5102, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing))
                .itemOutputs(getModItem("IC2", "itemTreetap", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 4905, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing))
                .itemOutputs(getModItem("IC2", "blockScaffold", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 4128, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing))
                .itemOutputs(getModItem("IC2", "blockIronScaffold", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemBoat", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17880, missing))
                .itemOutputs(getModItem("IC2", "itemBoat", 1, 1, missing)).noFluidInputs().noFluidOutputs().duration(20)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 23305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IC2", "itemWeedingTrowel", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 144)).noFluidOutputs().duration(400).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing))
                .itemOutputs(getModItem("IC2", "itemCropnalyzer", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).noFluidOutputs().duration(1200)
                .eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing),
                        getModItem("IC2", "itemPartCircuit", 2, 0, missing))
                .itemOutputs(getModItem("IC2", "itemToolMEter", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glowstone", 288)).noFluidOutputs().duration(600)
                .eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemPartAlloy", 3, 0, missing),
                        getModItem("IC2", "blockAlloyGlass", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemDoorAlloy", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 720)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemFreq", 1, 0, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemRemote", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 1466, missing))
                .itemOutputs(getModItem("IC2", "itemFreq", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(1200).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "reactorCoolantTriple", 1, 1, missing))
                .itemOutputs(getModItem("IC2", "upgradeModule", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).noFluidOutputs().duration(1200).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "itemRecipePart", 2, 0, missing))
                .itemOutputs(getModItem("IC2", "upgradeModule", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 288)).noFluidOutputs().duration(1200).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "itemBatREDischarged", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "upgradeModule", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).noFluidOutputs().duration(1200).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing))
                .itemOutputs(getModItem("IC2", "upgradeModule", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).noFluidOutputs().duration(1200).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "upgradeModule", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing))
                .itemOutputs(getModItem("IC2", "upgradeModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).noFluidOutputs().duration(1200).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing))
                .itemOutputs(getModItem("IC2", "upgradeModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).noFluidOutputs().duration(1200).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing))
                .itemOutputs(getModItem("IC2", "upgradeModule", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).noFluidOutputs().duration(1200).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 5, 17880, missing),
                        getModItem("dreamcraft", "item.ReinforcedGlassLense", 2, 0, missing))
                .itemOutputs(getModItem("IC2", "itemArmorHazmatHelmet", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 144)).noFluidOutputs().duration(500).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 5, 17880, missing),
                        getModItem("dreamcraft", "item.ReinforcedGlassLense", 2, 0, missing))
                .itemOutputs(getModItem("IC2", "itemArmorHazmatHelmet", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 144)).noFluidOutputs().duration(500).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 8, 17880, missing),
                        getModItem("minecraft", "wool", 4, 1, missing))
                .itemOutputs(getModItem("IC2", "itemArmorHazmatChestplate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 144)).noFluidOutputs().duration(500).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 8, 17880, missing),
                        getModItem("minecraft", "wool", 4, 1, missing))
                .itemOutputs(getModItem("IC2", "itemArmorHazmatChestplate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 144)).noFluidOutputs().duration(500).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 7, 17880, missing),
                        getModItem("minecraft", "carpet", 4, 1, missing))
                .itemOutputs(getModItem("IC2", "itemArmorHazmatLeggings", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 144)).noFluidOutputs().duration(500).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 7, 17880, missing),
                        getModItem("minecraft", "carpet", 4, 1, missing))
                .itemOutputs(getModItem("IC2", "itemArmorHazmatLeggings", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 144)).noFluidOutputs().duration(500).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "iron_helmet", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32750, missing))
                .itemOutputs(getModItem("IC2", "itemSolarHelmet", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 288)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "iron_helmet", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32750, missing))
                .itemOutputs(getModItem("IC2", "itemSolarHelmet", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "iron_helmet", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32750, missing))
                .itemOutputs(getModItem("IC2", "itemSolarHelmet", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "chest", 1, 0, missing),
                        getModItem("IC2", "itemCasing", 8, 6, missing))
                .itemOutputs(getModItem("IC2", "itemContainmentbox", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "chest", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 8, 18089, missing))
                .itemOutputs(getModItem("IC2", "itemContainmentbox", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "chest", 1, 0, missing),
                        getModItem("IC2", "itemCasing", 5, 2, missing))
                .itemOutputs(getModItem("IC2", "itemToolbox", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "chest", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 5, 18300, missing))
                .itemOutputs(getModItem("IC2", "itemToolbox", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemUran238", 6, 0, missing),
                        getModItem("IC2", "itemPlutonium", 3, 0, missing))
                .itemOutputs(getModItem("IC2", "itemMOX", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 1000)).noFluidOutputs().duration(400).eut(256)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemUran238", 6, 0, missing),
                        getModItem("IC2", "itemUran235small", 3, 0, missing))
                .itemOutputs(getModItem("IC2", "itemUran", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 1000)).noFluidOutputs().duration(400).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "blockAlloy", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17089, missing))
                .itemOutputs(getModItem("IC2", "blockreactorvessel", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "blockreactorvessel", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32612, missing))
                .itemOutputs(getModItem("IC2", "blockReactorFluidPort", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "blockreactorvessel", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing))
                .itemOutputs(getModItem("IC2", "blockReactorAccessHatch", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "blockreactorvessel", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32731, missing))
                .itemOutputs(getModItem("IC2", "blockReactorRedstonePort", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 30087, missing),
                        getModItem("gregtech", "gt.blockmachines", 8, 1360, missing))
                .itemOutputs(getModItem("IC2", "blockLuminatorDark", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 1152)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 30004, missing),
                        getModItem("gregtech", "gt.blockmachines", 16, 1360, missing))
                .itemOutputs(getModItem("IC2", "blockLuminatorDark", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 1152)).noFluidOutputs().duration(400).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "furnace", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 5, 17032, missing))
                .itemOutputs(getModItem("IC2", "blockMachine", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.02", 8, 22809, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IC2", "blockCrop", 16, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(150).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.BioChunk", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemPartCoalChunk", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(120).specialValue(1000).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.BioOrganicMesh", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemPartCarbonMesh", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(120).specialValue(1000).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.BioCarbonPlate", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemPartCarbonPlate", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(120).specialValue(1000).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemToolPainterBlack", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblack", 144)).noFluidOutputs().duration(200)
                .eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemToolPainterRed", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyered", 144)).noFluidOutputs().duration(200)
                .eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemToolPainterGreen", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 144)).noFluidOutputs().duration(200)
                .eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemToolPainterBrown", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyebrown", 144)).noFluidOutputs().duration(200)
                .eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemToolPainterBlue", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 144)).noFluidOutputs().duration(200)
                .eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemToolPainterPurple", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepurple", 144)).noFluidOutputs()
                .duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemToolPainterCyan", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyecyan", 144)).noFluidOutputs().duration(200)
                .eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemToolPainterLightGrey", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightgray", 144)).noFluidOutputs()
                .duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemToolPainterDarkGrey", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegray", 144)).noFluidOutputs().duration(200)
                .eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemToolPainterPink", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepink", 144)).noFluidOutputs().duration(200)
                .eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemToolPainterLime", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelime", 144)).noFluidOutputs().duration(200)
                .eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemToolPainterYellow", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeyellow", 144)).noFluidOutputs()
                .duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemToolPainterCloud", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightblue", 144)).noFluidOutputs()
                .duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemToolPainterMagenta", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyemagenta", 144)).noFluidOutputs()
                .duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemToolPainterOrange", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 144)).noFluidOutputs()
                .duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemToolPainterWhite", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyewhite", 144)).noFluidOutputs().duration(200)
                .eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemPartCarbonMesh", 8, 0, missing),
                        getModItem("dreamcraft", "item.ExtruderShapeBoat", 0, 0, missing))
                .itemOutputs(getModItem("IC2", "itemBoat", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(30).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 11880, missing),
                        getModItem("dreamcraft", "item.ExtruderShapeBoat", 0, 0, missing))
                .itemOutputs(getModItem("IC2", "itemBoat", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "iron_ingot", 8, 0, missing),
                        getModItem("dreamcraft", "item.ExtruderShapeBoat", 0, 0, missing))
                .itemOutputs(getModItem("dreamcraft", "item.ElectricBoatHull", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(30).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 5130, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32358, missing))
                .itemOutputs(getModItem("IC2", "blockMiningPipe", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1).eut(64).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 5131, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32358, missing))
                .itemOutputs(getModItem("IC2", "blockMiningPipe", 2, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(4).eut(64).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 5132, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32358, missing))
                .itemOutputs(getModItem("IC2", "blockMiningPipe", 4, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(8).eut(64).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 5133, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32358, missing))
                .itemOutputs(getModItem("IC2", "blockMiningPipe", 8, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(16).eut(64).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 5134, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32358, missing))
                .itemOutputs(getModItem("IC2", "blockMiningPipe", 16, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(32).eut(64).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 5140, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32358, missing))
                .itemOutputs(getModItem("IC2", "blockMiningPipe", 8, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(4).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 5141, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32358, missing))
                .itemOutputs(getModItem("IC2", "blockMiningPipe", 16, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(8).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 5142, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32358, missing))
                .itemOutputs(getModItem("IC2", "blockMiningPipe", 32, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(16).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 5143, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32358, missing))
                .itemOutputs(getModItem("IC2", "blockMiningPipe", 64, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(32).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemMugEmpty", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemMugCoffee", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("potion.darkcoffee", 500)).noFluidOutputs().duration(8).eut(1)
                .addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemMugEmpty", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemMugCoffee", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("potion.cafeaulait", 500)).noFluidOutputs().duration(8).eut(1)
                .addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemFoamSprayer", 1, 0, missing))
                .itemOutputs(
                        createItemStack(
                                "IC2",
                                "itemFoamSprayer",
                                1,
                                0,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:8000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 8000)).noFluidOutputs().duration(129)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                "IC2",
                                "itemArmorCFPack",
                                1,
                                24,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:8000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 8000)).noFluidOutputs().duration(129)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                "IC2",
                                "itemArmorCFPack",
                                1,
                                21,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:16000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 16000)).noFluidOutputs().duration(258)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                "IC2",
                                "itemArmorCFPack",
                                1,
                                19,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:24000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 24000)).noFluidOutputs().duration(387)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                "IC2",
                                "itemArmorCFPack",
                                1,
                                16,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:32000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 32000)).noFluidOutputs().duration(516)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                "IC2",
                                "itemArmorCFPack",
                                1,
                                13,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:40000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 40000)).noFluidOutputs().duration(645)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                "IC2",
                                "itemArmorCFPack",
                                1,
                                10,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:48000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 48000)).noFluidOutputs().duration(774)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                "IC2",
                                "itemArmorCFPack",
                                1,
                                7,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:54000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 54000)).noFluidOutputs().duration(870)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                "IC2",
                                "itemArmorCFPack",
                                1,
                                4,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:62000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 62000)).noFluidOutputs().duration(1000)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                "IC2",
                                "itemArmorCFPack",
                                1,
                                1,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:70000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 70000)).noFluidOutputs().duration(1129)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                "IC2",
                                "itemArmorCFPack",
                                1,
                                1,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:80000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 80000)).noFluidOutputs().duration(1290)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.TenKCell", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "reactorCoolantSimple", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 1000)).noFluidOutputs().duration(16).eut(1)
                .addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.ThirtyKCell", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "reactorCoolantTriple", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 3000)).noFluidOutputs().duration(48).eut(1)
                .addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.SixtyKCell", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "reactorCoolantSix", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 6000)).noFluidOutputs().duration(96).eut(1)
                .addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("dreamcraft", "item.MoldBoots", 0, 0, missing))
                .itemOutputs(getModItem("IC2", "itemArmorRubBoots", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 720)).noFluidOutputs().duration(300).eut(30)
                .addTo(sFluidSolidficationRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemPartIndustrialDiamond", 1, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 23500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 1500, missing))
                .noFluidInputs().noFluidOutputs().duration(3830).eut(16).addTo(sLatheRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 9, 17804, missing))
                .itemOutputs(getModItem("IC2", "itemDensePlates", 1, 7, missing)).noFluidInputs().noFluidOutputs()
                .duration(3600).eut(96).addTo(sBenderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 9, 17526, missing))
                .itemOutputs(getModItem("IC2", "itemDensePlates", 1, 8, missing)).noFluidInputs().noFluidOutputs()
                .duration(3600).eut(96).addTo(sBenderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "blockBasalt", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 2844, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemBatLamaCrystal", 1, 32767, missing))
                .itemOutputs(getModItem("dreamcraft", "item.LapotronDust", 30, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemDust", 8, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2802, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("IC2", "itemPartCoalBall", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(16).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "iron_boots", 1, 0, missing))
                .itemOutputs(getModItem("IC2", "itemStaticBoots", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(30).addTo(sPolarizerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.blockmachines", 1, 5130, missing))
                .itemOutputs(getModItem("IC2", "blockMiningPipe", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.blockmachines", 1, 5131, missing))
                .itemOutputs(getModItem("IC2", "blockMiningPipe", 2, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(150).eut(8).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.blockmachines", 1, 5132, missing))
                .itemOutputs(getModItem("IC2", "blockMiningPipe", 4, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.blockmachines", 1, 5133, missing))
                .itemOutputs(getModItem("IC2", "blockMiningPipe", 8, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(250).eut(30).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.blockmachines", 1, 5134, missing))
                .itemOutputs(getModItem("IC2", "blockMiningPipe", 16, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(64).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.blockmachines", 1, 5140, missing))
                .itemOutputs(getModItem("IC2", "blockMiningPipe", 8, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.blockmachines", 1, 5141, missing))
                .itemOutputs(getModItem("IC2", "blockMiningPipe", 16, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(250).eut(96).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.blockmachines", 1, 5142, missing))
                .itemOutputs(getModItem("IC2", "blockMiningPipe", 32, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(120).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.blockmachines", 1, 5143, missing))
                .itemOutputs(getModItem("IC2", "blockMiningPipe", 64, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(350).eut(256).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(
                                "IC2",
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"ic2hotcoolant\",Amount:1000}}",
                                missing))
                .itemOutputs(
                        createItemStack(
                                "IC2",
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"ic2coolant\",Amount:1000}}",
                                missing))
                .noFluidInputs().noFluidOutputs().duration(200).eut(120).addTo(sVacuumRecipes);

    }
}
