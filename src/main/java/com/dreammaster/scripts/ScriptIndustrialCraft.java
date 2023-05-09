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
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sBenderRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sBlastRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCompressorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sExtruderRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sFluidCannerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sFluidSolidficationRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sLatheRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMixerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sPolarizerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sVacuumRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sWiremillRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.dreammaster.oredict.OreDictHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GT_Values;

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

        addShapelessCraftingRecipe(
                getModItem(IndustrialCraft2.ID, "blockMiningPipe", 1, 0, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "blockMiningTip", 1, 0, missing) });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 3, missing),
                new Object[] { "cableGt01AnyCopper", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32501, missing),
                        "cableGt01AnyCopper", "circuitBasic", getModItem(GregTech.ID, "gt.blockcasings", 1, 2, missing),
                        "circuitBasic", "itemCasingSteel",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing), "itemCasingSteel" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 8, missing),
                new Object[] { "itemCasingSteel", getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing),
                        "itemCasingSteel", getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing), "circuitBasic",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing) });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing),
                new Object[] { "plateAnyRubber", "plateCopper", "plateAnyRubber", "plateCopper", "plateSilver",
                        "plateCopper", "plateAnyRubber", "plateCopper", "plateAnyRubber" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 0, missing),
                new Object[] { "cableGt01Tin", "plateSteel", "cableGt01Tin",
                        getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 11, missing),
                        getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing), "plateSteel",
                        getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing), "plateSteel" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 7, missing),
                new Object[] { "cableGt01AnyCopper", "plateBronze", "cableGt01AnyCopper",
                        getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing),
                        getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, 32767, missing), "plateBronze",
                        getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, 32767, missing), "plateBronze" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 1, missing),
                new Object[] { "cableGt01Gold", "batteryElite", "cableGt01Gold", "batteryElite",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 13, missing), "batteryElite",
                        "plateStainlessSteel", "batteryElite", "plateStainlessSteel" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 2, missing),
                new Object[] { "cableGt01TungstenSteel", "batteryMaster", "cableGt01TungstenSteel", "batteryMaster",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 14, missing), "batteryMaster", "circuitData",
                        "batteryMaster", "circuitData" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing),
                new Object[] { "plateAnyRubber", "plateAnyRubber", "plateAnyRubber", "plateAnyRubber", "plateAnyRubber",
                        "plateAnyRubber", null, null, null });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockScaffold", 1, 0, missing),
                new Object[] { "screwIron", getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing), "screwIron",
                        "craftingToolWrench", "frameGtWood", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockIronScaffold", 1, 0, missing),
                new Object[] { "screwSteel", "plateIron", "screwSteel", "craftingToolWrench", "frameGtIron",
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemToolMiningLaser", 1, 0, missing),
                new Object[] { "plateTitanium", getModItem(NewHorizonsCoreMod.ID, "item.LaserEmitter", 1, 0, missing),
                        "plateTitanium", "circuitMaster", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32527, missing),
                        "circuitMaster", "craftingToolFile",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 2, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorPlating", 1, 0, missing),
                new Object[] { "plateAlloyAdvanced", "plateAlloyAdvanced", "plateAlloyAdvanced", "plateAlloyAdvanced",
                        "plateDenseLead", "plateAlloyAdvanced", "plateAlloyAdvanced", "plateAlloyAdvanced",
                        "plateAlloyAdvanced" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1, 0, missing),
                new Object[] { "plateDenseCopper", "plateCopper", "plateDenseCopper", "plateSilver",
                        getModItem(IndustrialCraft2.ID, "reactorPlating", 1, 0, missing), "plateSilver",
                        "plateDenseCopper", "plateCopper", "plateDenseCopper" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorPlatingExplosive", 1, 0, missing),
                new Object[] { "plateDenseLead", "plateAlloyAdvanced", "plateDenseLead", "plateAlloyAdvanced",
                        getModItem(IndustrialCraft2.ID, "reactorPlating", 1, 0, missing), "plateAlloyAdvanced",
                        "plateDenseLead", "plateAlloyAdvanced", "plateDenseLead" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 7, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing), "ringStainlessSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing) });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemwoodrotor", 1, 1, missing),
                new Object[] { "screwSteel", getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 7, missing),
                        "craftingToolWrench", getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 7, missing),
                        "ringStainlessSteel", getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 7, missing),
                        "craftingToolScrewdriver", getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 7, missing),
                        "screwSteel" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 8, missing),
                new Object[] { "plateIron", "plateIron", "plateIron", "plateIron", "ringTitanium", "plateIron",
                        "plateIron", "plateIron", "plateIron" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemironrotor", 1, 1, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 11, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 8, missing), "craftingToolHardHammer",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 8, missing), "ringTitanium",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 8, missing), "craftingToolWrench",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 8, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 11, missing) });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 10, missing),
                new Object[] { "plateStainlessSteel", "plateStainlessSteel", "plateStainlessSteel",
                        "plateStainlessSteel", "ringTungstenSteel", "plateStainlessSteel", "plateStainlessSteel",
                        "plateStainlessSteel", "plateStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 10, missing),
                new Object[] { getModItem(Railcraft.ID, "part.turbine.blade", 1, 0, missing) });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemsteelrotor", 1, 1, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 10, missing), "craftingToolHardHammer",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 10, missing), "ringTungstenSteel",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 10, missing), "craftingToolWrench",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 10, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12, missing) });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 9, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing), "ringIridium",
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing) });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemwcarbonrotor", 1, 1, missing),
                new Object[] { getModItem(GTPlusPlus.ID, "itemTungstenSteelShaft", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 9, missing), "craftingToolHardHammer",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 9, missing), "ringIridium",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 9, missing), "craftingToolWrench",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 9, missing),
                        getModItem(GTPlusPlus.ID, "itemTungstenSteelShaft", 1, 0, missing) });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 5, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing), "circuitGood",
                        getModItem(GregTech.ID, "gt.blockcasings", 1, 11, missing), "circuitGood",
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(IndustrialCraft2.ID, "itemSteamTurbineBlade", 1, 0, missing),
                new Object[] { getModItem(Railcraft.ID, "part.turbine.disk", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(IndustrialCraft2.ID, "itemSteamTurbine", 1, 0, missing),
                new Object[] { getModItem(Railcraft.ID, "part.turbine.rotor", 1, 0, missing) });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemSteamTurbine", 1, 0, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "itemSteamTurbineBlade", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemSteamTurbineBlade", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemSteamTurbineBlade", 1, 0, missing), null,
                        "craftingToolWrench", null });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine", 1, 1, missing),
                new Object[] { "plateAnyIron", "plateAnyIron", "plateAnyIron", "plateAnyIron", "craftingToolWrench",
                        "plateAnyIron", "plateAnyIron", getModItem(Minecraft.ID, "furnace", 1, 0, missing),
                        "plateAnyIron" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1, missing),
                new Object[] { "plateAluminium", getModItem(Minecraft.ID, "iron_bars", 1, 0, missing), "plateAluminium",
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing), "plateAluminium",
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing), "plateAluminium" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorVentCore", 1, 1, missing),
                new Object[] { "plateDoubleCopper", "plateSilver", "plateDoubleCopper", "plateSilver",
                        getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1, missing), "plateSilver",
                        "plateDoubleCopper", "plateSilver", "plateDoubleCopper" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1, missing),
                new Object[] { getModItem(NewHorizonsCoreMod.ID, "item.StainlessSteelBars", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.StainlessSteelBars", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.StainlessSteelBars", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIndustrialDiamond", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.StainlessSteelBars", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.StainlessSteelBars", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.StainlessSteelBars", 1, 0, missing) });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorVentGold", 1, 1, missing),
                new Object[] { "screwStainlessSteel", "plateGold", "screwStainlessSteel", "plateGold",
                        getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1, missing), "plateGold",
                        "screwStainlessSteel", "plateGold", "screwStainlessSteel" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorVentSpread", 1, 0, missing),
                new Object[] { getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing), "plateDenseTin",
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing), "plateDenseTin",
                        getModItem(IndustrialCraft2.ID, "reactorVent", 1, 1, missing), "plateDenseTin",
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing), "plateDenseTin",
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing) });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1, missing),
                new Object[] { "plateSilver", "circuitAdvanced", "plateSilver", "plateAluminium", "plateCopper",
                        "plateAluminium", "plateSilver", "plateAluminium", "plateSilver" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchCore", 1, 1, missing),
                new Object[] { "plateDoubleCopper", "plateSilver", "plateDoubleCopper", "plateSilver",
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1, missing), "plateSilver",
                        "plateDoubleCopper", "plateSilver", "plateDoubleCopper" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1, 1, missing),
                new Object[] { "screwStainlessSteel", "plateGold", "screwStainlessSteel", "plateGold",
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1, missing), "plateGold",
                        "screwStainlessSteel", "plateGold", "screwStainlessSteel" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1, missing),
                new Object[] { "plateLapis", "circuitData", "plateLapis",
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1, missing), "plateDiamond",
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, 1, missing), "plateLapis",
                        "circuitData", "plateLapis" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, 1, missing),
                new Object[] { "plateRedAlloy", getModItem(IndustrialCraft2.ID, "reactorHeatSwitchCore", 1, 1, missing),
                        "plateRedAlloy", "plateRedAlloy",
                        getModItem(IndustrialCraft2.ID, "reactorVentCore", 1, 1, missing), "plateRedAlloy",
                        "plateRedAlloy", getModItem(IndustrialCraft2.ID, "reactorHeatSwitchCore", 1, 1, missing),
                        "plateRedAlloy" });
        addShapelessCraftingRecipe(
                getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, 1, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, 32767, missing), "dustRedAlloy",
                        "dustRedAlloy", "dustRedAlloy", "dustRedAlloy", "dustRedAlloy", "dustRedAlloy", "dustRedAlloy",
                        "dustRedAlloy" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "reactorCondensatorLap", 1, 1, missing),
                new Object[] { "plateDoubleRedAlloy", getModItem(IndustrialCraft2.ID, "reactorVentGold", 1, 1, missing),
                        "plateDoubleRedAlloy", getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, 1, missing),
                        "plateDenseLapis", getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, 1, missing),
                        "plateDoubleRedAlloy",
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1, 1, missing),
                        "plateDoubleRedAlloy" });
        addShapelessCraftingRecipe(
                getModItem(IndustrialCraft2.ID, "reactorCondensatorLap", 1, 1, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "reactorCondensatorLap", 1, 32767, missing), "dustLapis",
                        "dustLapis", "dustLapis", "dustLapis", "dustLapis", "dustLapis", "dustLapis", "dustLapis" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemTreetap", 1, 0, missing),
                new Object[] { "craftingToolSoftHammer", "screwWood", "craftingToolScrewdriver", "pipeMediumWood",
                        "pipeMediumWood", "pipeSmallWood", "pipeLargeWood", "craftingToolSaw", "craftingToolFile" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 6, missing),
                new Object[] { "itemCasingAnyCopper", "itemCasingAnyCopper", "itemCasingAnyCopper", "screwCopper",
                        "craftingToolWrench", "screwCopper", "itemCasingAnyCopper", "itemCasingAnyCopper",
                        "itemCasingAnyCopper" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemBarrel", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing), "ringIron",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing), "craftingToolHardHammer",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing), "ringIron",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing) });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemMugEmpty", 1, 0, missing),
                new Object[] { "plateStone", "craftingToolHardHammer", "plateStone", null, "plateStone", null });
        addShapelessCraftingRecipe(
                getModItem(IndustrialCraft2.ID, "itemCofeePowder", 1, 0, missing),
                new Object[] { "craftingToolMortar", "cropCoffee" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemBoat", 1, 3, missing),
                new Object[] { "screwSteel", "plateSteel", "screwSteel", "craftingToolWrench",
                        getModItem(NewHorizonsCoreMod.ID, "item.ElectricBoatHull", 1, 0, missing),
                        "craftingToolScrewdriver", getModItem(GregTech.ID, "gt.metaitem.02", 1, 21057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 21057, missing) });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemBoat", 1, 1, missing),
                new Object[] { "plateAnyRubber", "craftingToolSaw", "plateAnyRubber", "plateAnyRubber",
                        "craftingToolSoftHammer", "plateAnyRubber", "plateAnyRubber", "plateAnyRubber",
                        "plateAnyRubber" });
        addShapelessCraftingRecipe(
                getModItem(IndustrialCraft2.ID, "itemBoat", 1, 1, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "itemBoat", 1, 2, missing), "plateAnyRubber",
                        "plateAnyRubber", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "windmeter", 1, 0, missing),
                new Object[] { "screwStainlessSteel", "rotorAluminium", "craftingToolScrewdriver",
                        "gearGtSmallStainlessSteel", getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 3, missing),
                        "gearGtSmallStainlessSteel", "plateStainlessSteel", "batteryBasic", "plateStainlessSteel" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemDoorAlloy", 1, 0, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockAlloyGlass", 1, 0, missing), "craftingToolHardHammer",
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing), "ringLead", "screwLead",
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing), "plateDenseLead",
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", null, "stickSteel", null, null, "stickSteel",
                        null });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemBatChargeRE", 1, 0, missing),
                new Object[] { "batteryBasic", "cableGt01Tin", "batteryBasic", "circuitBasic",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17315, missing), "circuitBasic", "batteryBasic",
                        "cableGt01Tin", "batteryBasic" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockPersonal", 1, 0, missing),
                new Object[] { "screwIron", "circuitBasic", "screwIron", "craftingToolScrewdriver",
                        getModItem(GregTech.ID, "gt.blockcasings", 1, 1, missing), "craftingToolHardHammer",
                        "screwIron", "chestIron", "screwIron" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockCrop", 1, 0, missing),
                new Object[] { "stickLongWood", null, "stickLongWood", "stickLongWood", null, "stickLongWood" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemFoamSprayer", 1, 0, missing),
                new Object[] { "pipeSmallSteel", "craftingToolScrewdriver", "screwIron", "craftingToolSaw",
                        "pipeSmallSteel", getModItem(IndustrialCraft2.ID, "itemFluidCell", 1, 0, missing), "screwIron",
                        getModItem(Minecraft.ID, "stone_button", 1, 0, missing), "circuitBasic" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorAlloyChestplate", 1, 0, missing),
                new Object[] { "plateAlloyAdvanced", "craftingToolHardHammer", "plateAlloyAdvanced",
                        "plateAlloyAdvanced", getModItem(Railcraft.ID, "armor.steel.plate", 1, 0, missing),
                        "plateAlloyAdvanced", "plateAlloyAdvanced",
                        getModItem(Minecraft.ID, "leather_chestplate", 1, 0, missing), "plateAlloyAdvanced" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorAlloyChestplate", 1, 0, missing),
                new Object[] { "plateAlloyAdvanced", "craftingToolHardHammer", "plateAlloyAdvanced",
                        "plateAlloyAdvanced", getModItem(Minecraft.ID, "leather_chestplate", 1, 0, missing),
                        "plateAlloyAdvanced", "plateAlloyAdvanced",
                        getModItem(Railcraft.ID, "armor.steel.plate", 1, 0, missing), "plateAlloyAdvanced" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing),
                new Object[] { "itemCasingSteel", "craftingToolHardHammer", "itemCasingSteel",
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing), "screwSteel",
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing), "itemCasingSteel",
                        "craftingToolScrewdriver", "itemCasingSteel" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemNanoSaber", 1, 0, missing),
                new Object[] { "plateAlloyIridium",
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartLargeSwordBlade",
                                1,
                                1529,
                                "{material:\"TungstenSteel\"}",
                                missing),
                        "plateAlloyIridium", "circuitMaster", "batteryMaster", "circuitMaster", "craftingToolFile",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 2, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "obscurator", 1, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "cableGt01Gold",
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing), "cableGt01Gold",
                        "itemCasingAnyIron", "batteryAdvanced", "itemCasingAnyIron" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemScanner", 1, 0, missing),
                new Object[] { "itemCasingGold", "plateStainlessSteel", "itemCasingGold", "circuitAdvanced",
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing), "circuitAdvanced",
                        "cableGt01Gold", "batteryElite", "cableGt01Gold" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemScannerAdv", 1, 0, missing),
                new Object[] { "itemCasingTitanium", getModItem(IndustrialCraft2.ID, "itemScanner", 1, 32767, missing),
                        "itemCasingTitanium", "circuitData",
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing), "circuitData",
                        "cableGt01Nichrome", "batteryMaster", "cableGt01Nichrome" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 3, missing),
                new Object[] { "cableGt01AnyCopper", "itemCasingSteel", "cableGt01AnyCopper", "itemCasingSteel",
                        "craftingToolScrewdriver", "itemCasingSteel", "circuitBasic",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "circuitBasic" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 2, missing),
                new Object[] { "cableGt02Gold", "itemCasingStainlessSteel", "cableGt02Gold", "itemCasingStainlessSteel",
                        "craftingToolScrewdriver", "itemCasingStainlessSteel", "circuitAdvanced",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing), "circuitAdvanced" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockPersonal", 1, 1, missing),
                new Object[] { "screwSteel", "plateSteel", "screwSteel", "circuitBasic",
                        getModItem(GregTech.ID, "gt.blockcasings", 1, 1, missing), "circuitBasic",
                        "craftingToolHardHammer", "plateSteel", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockPersonal", 1, 2, missing),
                new Object[] { "screwSteel", getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing),
                        "screwSteel", "circuitBasic", getModItem(GregTech.ID, "gt.blockcasings", 1, 1, missing),
                        "circuitBasic", "craftingToolHardHammer",
                        getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing),
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 2, missing),
                new Object[] { getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing), "chestIron",
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing), "itemCasingSteel",
                        getModItem(GregTech.ID, "gt.blockcasings", 1, 1, missing), "itemCasingSteel", "circuitBasic",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "circuitBasic" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine3", 1, 6, missing),
                new Object[] { "itemCasingAnyIron", "itemCasingAnyIron", "itemCasingAnyIron", "craftingChest",
                        getModItem(GregTech.ID, "gt.blockcasings", 1, 1, missing), "craftingChest", "itemCasingAnyIron",
                        "itemCasingAnyIron", "itemCasingAnyIron" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine3", 1, 5, missing),
                new Object[] { "itemCasingAnyIron", "circuitBasic", "itemCasingAnyIron",
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.blockcasings", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 3, missing), "itemCasingAnyIron",
                        "craftingChest", "itemCasingAnyIron" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine3", 1, 4, missing),
                new Object[] { "itemCasingAnyIron", "circuitBasic", "itemCasingAnyIron",
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.blockcasings", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 4, missing), "pipeLargeSteel",
                        getModItem(IndustrialCraft2.ID, "itemFluidCell", 1, 0, missing), "pipeLargeSteel" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine3", 1, 3, missing),
                new Object[] { "itemCasingAnyIron", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32750, missing),
                        "itemCasingAnyIron", getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockcasings", 1, 1, missing),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing), "itemCasingAnyIron",
                        "circuitBasic", "itemCasingAnyIron" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine3", 1, 0, missing),
                new Object[] { "itemCasingSteel", "circuitBasic", "itemCasingSteel", "pipeMediumSteel",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 6, missing), "pipeMediumSteel",
                        "itemCasingSteel", getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing),
                        "itemCasingSteel" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 15, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "reactorCoolantSimple", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "reactorCoolantSimple", 1, 1, missing), "pipeMediumSteel",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 6, missing), "pipeMediumSteel",
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing), "circuitBasic",
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 14, missing),
                new Object[] { "itemCasingSteel", "itemCasingSteel", "itemCasingSteel", "pipeMediumSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32611, missing), "pipeMediumSteel",
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing), "circuitBasic",
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 12, missing),
                new Object[] { "itemCasingSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                        "itemCasingSteel", getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing), "chestSteel",
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing), "itemCasingSteel", "circuitBasic",
                        "itemCasingSteel" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 11, missing),
                new Object[] { "circuitElite", getModItem(IndustrialCraft2.ID, "blockElectric", 1, 2, missing),
                        "circuitElite", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32604, missing),
                        getModItem(IndustrialCraft2.ID, "blockMachine", 1, 12, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32604, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32654, missing),
                        getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32654, missing) });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 1, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 4, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing), "circuitAdvanced",
                        "cableGt04Gold", "circuitAdvanced" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockMachine", 1, 9, missing),
                new Object[] { "plateRedAlloy", "itemCasingSteel", "plateRedAlloy", "springSteelMagnetic",
                        getModItem(GregTech.ID, "gt.blockcasings", 1, 1, missing), "springSteelMagnetic",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "circuitBasic",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing) });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockChargepad", 1, 3, missing),
                new Object[] { "screwStainlessSteel",
                        getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing), "screwStainlessSteel",
                        "circuitData", getModItem(IndustrialCraft2.ID, "blockElectric", 1, 2, missing), "circuitData",
                        "itemCasingStainlessSteel", "craftingToolScrewdriver", "itemCasingStainlessSteel" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockChargepad", 1, 2, missing),
                new Object[] { "screwAluminium",
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing), "screwAluminium",
                        "circuitAdvanced", getModItem(IndustrialCraft2.ID, "blockElectric", 1, 1, missing),
                        "circuitAdvanced", "itemCasingAluminium", "craftingToolScrewdriver", "itemCasingAluminium" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockChargepad", 1, 1, missing),
                new Object[] { "screwSteel", getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing),
                        "screwSteel", "circuitGood", getModItem(IndustrialCraft2.ID, "blockElectric", 1, 7, missing),
                        "circuitGood", "itemCasingSteel", "craftingToolScrewdriver", "itemCasingSteel" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockChargepad", 1, 0, missing),
                new Object[] { "screwIron", getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0, missing),
                        "screwIron", "circuitBasic", getModItem(IndustrialCraft2.ID, "blockElectric", 1, 0, missing),
                        "circuitBasic", "itemCasingAnyIron", "craftingToolScrewdriver", "itemCasingAnyIron" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 1, missing),
                new Object[] { "itemCasingSteel", getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing),
                        "itemCasingSteel", "pipeMediumSteel",
                        getModItem(GregTech.ID, "gt.blockcasings3", 1, 14, missing), "pipeMediumSteel",
                        "itemCasingSteel", getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        "itemCasingSteel" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 0, missing),
                new Object[] { "itemCasingSteel", getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing),
                        "itemCasingSteel", "screwSteel", getModItem(GregTech.ID, "gt.blockcasings3", 1, 14, missing),
                        "screwSteel", "itemCasingSteel", "craftingIronFurnace", "itemCasingSteel" });
        addShapelessCraftingRecipe(
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 1, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 1, missing) });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 2, missing),
                new Object[] { "itemCasingStainlessSteel", "rotorStainlessSteel", "itemCasingStainlessSteel",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 13, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12, missing), "cableGt04Gold",
                        "rotorStainlessSteel", "cableGt04Gold" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 1, missing),
                new Object[] { "itemCasingStainlessSteel", "rotorStainlessSteel", "itemCasingStainlessSteel",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12, missing),
                        getModItem(Railcraft.ID, "machine.beta", 1, 4, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12, missing), "circuitAdvanced",
                        "rotorStainlessSteel", "circuitAdvanced" });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 7, missing),
                new Object[] { "itemCasingSteel", getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        "itemCasingSteel", getModItem(GregTech.ID, "gt.blockmachines", 1, 2006, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 11, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 2006, missing), "itemCasingSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "itemCasingSteel" });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17084, missing),
                new Object[] { "craftingToolHardHammer", null, null, "ingotIridium", null, null, "ingotIridium", null,
                        null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17084, missing),
                new Object[] { "craftingToolHardHammer", null, null,
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 13084, missing), null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 16, 17084, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.03", 1, 3084, missing), "craftingToolCrowbar",
                        null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 3084, missing),
                new Object[] { "plateIridium", "ingotIridium", "craftingToolHardHammer", "plateIridium", null, null,
                        "craftingToolFile", null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 4084, missing),
                new Object[] { "plateIridium", "ingotIridium", "craftingToolHardHammer", "craftingToolFile", null,
                        null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 12084, missing),
                new Object[] { "plateIridium", "plateIridium", "ingotIridium", "craftingToolHardHammer",
                        "craftingToolFile", null });
        addShapedRecipe(
                createItemStack(
                        GregTech.ID,
                        "gt.metatool.01",
                        1,
                        12,
                        "{GT.ToolStats:{PrimaryMaterial:\"Iridium\",MaxDamage:512000L,SecondaryMaterial:\"Steel\"}}",
                        missing),
                new Object[] { "ingotIridium", "ingotIridium", null, "ingotIridium", "ingotIridium", "stickSteel",
                        "ingotIridium", "ingotIridium", null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 1084, missing),
                new Object[] { "plateIridium", "ingotIridium", "ingotIridium", "craftingToolFile", null,
                        "craftingToolHardHammer", null, null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 13084, missing),
                new Object[] { "plateIridium", "plateIridium", null, "plateIridium", "plateIridium", null,
                        "craftingToolHardHammer", "craftingToolFile", null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 84, missing),
                new Object[] { null, "plateIridium", null, "craftingToolFile", "plateIridium", "craftingToolHardHammer",
                        null, null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 7084, missing),
                new Object[] { "plateIridium", "plateIridium", null, "craftingToolFile", "craftingToolHardHammer", null,
                        null, null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 2084, missing),
                new Object[] { "craftingToolFile", "plateIridium", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 16, 11084, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.03", 1, 1084, missing), "craftingToolCrowbar",
                        null });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemWeedingTrowel", 1, 0, missing),
                new Object[] { "screwSteel", "stickSteel", "craftingToolScrewdriver", "plateAnyRubber", "stickSteel",
                        "stickSteel", "stickSteel", "plateAnyRubber", "screwSteel" });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32750, missing),
                new Object[] { "craftingToolCrowbar", getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3, missing),
                        "craftingToolScrewdriver", "craftingToolWrench", "craftingToolHardHammer",
                        "craftingToolFile" });
        addShapelessCraftingRecipe(
                getModItem(IndustrialCraft2.ID, "itemFluidCell", 1, 0, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 0, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "itemFluidCell", 1, 0, missing) });
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemPartCFPowder", 1, 0, missing),
                new Object[] { "dustCalcite", "dustCalcite", "dustStone", "dustClay", "dustQuartzSand", null, null,
                        null, null });
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
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32612, missing),
                'e',
                "cableGt01Platinum",
                'f',
                "circuitData",
                'g',
                getModItem(GregTech.ID, "gt.blockcasings2", 1, 3, missing),
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
                getModItem(GregTech.ID, "gt.blockmachines", 1, 13, missing),
                'f',
                "cableGt01Platinum",
                'g',
                "circuitData",
                'h',
                getModItem(GregTech.ID, "gt.blockcasings2", 1, 11, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing),
                'j',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32538, missing));
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
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32672, missing),
                'd',
                getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, 32767, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32603, missing),
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
                getModItem(GregTech.ID, "gt.blockcasings2", 1, 3, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing));

        GT_Values.RA.addFuel(
                createItemStack(
                        IndustrialCraft2.ID,
                        "itemFluidCell",
                        1,
                        0,
                        "{Fluid:{FluidName:\"ic2biogas\",Amount:1000}}",
                        missing),
                getModItem(IndustrialCraft2.ID, "itemFluidCell", 1, 0, missing),
                40,
                1);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemUran238", 9, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMetal", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "reeds", 8, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "sapling", 8, 32767, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "saplings", 8, 32767, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "colorizedSaplings", 8, 32767, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "blockRubSapling", 8, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Forestry.ID, "sapling", 8, 32767, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "florasapling", 8, 32767, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Rare Sapling", 8, 32767, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCustomPlant", 8, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCustomPlant", 8, 1, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TwilightForest.ID, "tile.TFSapling", 8, 32767, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 2880, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MoldBoots", 0, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorRubBoots", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 17880, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MoldBoots", 0, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorRubBoots", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 11300, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MoldBoots", 0, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorBronzeBoots", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 11300, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MoldChestplate", 0, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorBronzeChestplate", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 11300, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MoldHelmet", 0, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorBronzeHelmet", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 7, 11300, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MoldLeggings", 0, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorBronzeLegs", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 10, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32750, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 72)).noFluidOutputs().duration(600).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 10, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32750, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36)).noFluidOutputs().duration(600)
                .eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 10, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32750, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 144)).noFluidOutputs().duration(600).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 231, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 431, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMachine", 1, 6, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 3, 5, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 576)).noFluidOutputs().duration(600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 8, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 576)).noFluidOutputs().duration(600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1246, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 22, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1367, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(250).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 23, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1428, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 5, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 24, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1529, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 6, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23355, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 16, 1360, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "coal_block", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCoalBlock", 8, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemPartCoalChunk", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 3, 5102, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemTreetap", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4905, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockScaffold", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4128, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17032, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockIronScaffold", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemBoat", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17880, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemBoat", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 23305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemWeedingTrowel", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 144)).noFluidOutputs().duration(400).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32740, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32702, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemCropnalyzer", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).noFluidOutputs().duration(1200)
                .eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32740, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 2, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolMEter", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glowstone", 288)).noFluidOutputs().duration(600)
                .eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 3, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockAlloyGlass", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemDoorAlloy", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 720)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemRemote", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1466, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(1200).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "reactorCoolantTriple", 1, 1, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).noFluidOutputs().duration(1200).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 2, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 288)).noFluidOutputs().duration(1200).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).noFluidOutputs().duration(1200).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).noFluidOutputs().duration(1200).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).noFluidOutputs().duration(1200).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).noFluidOutputs().duration(1200).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 144)).noFluidOutputs().duration(1200).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 17880, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.ReinforcedGlassLense", 2, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 144)).noFluidOutputs().duration(500).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 17880, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.ReinforcedGlassLense", 2, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 144)).noFluidOutputs().duration(500).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17880, missing),
                        getModItem(Minecraft.ID, "wool", 4, 1, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorHazmatChestplate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 144)).noFluidOutputs().duration(500).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17880, missing),
                        getModItem(Minecraft.ID, "wool", 4, 1, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorHazmatChestplate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 144)).noFluidOutputs().duration(500).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 7, 17880, missing),
                        getModItem(Minecraft.ID, "carpet", 4, 1, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorHazmatLeggings", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 144)).noFluidOutputs().duration(500).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 7, 17880, missing),
                        getModItem(Minecraft.ID, "carpet", 4, 1, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorHazmatLeggings", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 144)).noFluidOutputs().duration(500).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "iron_helmet", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32750, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemSolarHelmet", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 288)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "iron_helmet", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32750, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemSolarHelmet", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "iron_helmet", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32750, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemSolarHelmet", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(600)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 8, 6, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemContainmentbox", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 8, 18089, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemContainmentbox", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 5, 2, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolbox", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 5, 18300, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolbox", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemUran238", 6, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlutonium", 3, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemMOX", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 1000)).noFluidOutputs().duration(400).eut(256)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemUran238", 6, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemUran235small", 3, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemUran", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 1000)).noFluidOutputs().duration(400).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17089, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockreactorvessel", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockreactorvessel", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32612, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockReactorFluidPort", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockreactorvessel", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockReactorAccessHatch", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockreactorvessel", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32731, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockReactorRedstonePort", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 30087, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 8, 1360, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockLuminatorDark", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 1152)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 30004, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 16, 1360, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockLuminatorDark", 16, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 1152)).noFluidOutputs().duration(400).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "furnace", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 17032, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMachine", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 8, 22809, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockCrop", 16, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(150).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.BioChunk", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemPartCoalChunk", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).specialValue(1000).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.BioOrganicMesh", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemPartCarbonMesh", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).specialValue(1000).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.BioCarbonPlate", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).specialValue(1000).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterBlack", 1, 0, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblack", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterRed", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyered", 144)).noFluidOutputs().duration(200)
                .eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterGreen", 1, 0, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterBrown", 1, 0, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyebrown", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterBlue", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 144)).noFluidOutputs().duration(200)
                .eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterPurple", 1, 0, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepurple", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterCyan", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyecyan", 144)).noFluidOutputs().duration(200)
                .eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterLightGrey", 1, 0, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightgray", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterDarkGrey", 1, 0, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegray", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterPink", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepink", 144)).noFluidOutputs().duration(200)
                .eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterLime", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelime", 144)).noFluidOutputs().duration(200)
                .eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterYellow", 1, 0, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeyellow", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterCloud", 1, 0, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightblue", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterMagenta", 1, 0, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyemagenta", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterOrange", 1, 0, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterWhite", 1, 0, missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyewhite", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonMesh", 8, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.ExtruderShapeBoat", 0, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemBoat", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 11880, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.ExtruderShapeBoat", 0, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemBoat", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "iron_ingot", 8, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.ExtruderShapeBoat", 0, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.ElectricBoatHull", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(30).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5130, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32358, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1).eut(64).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5131, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32358, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(4).eut(64).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5132, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32358, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(8).eut(64).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5133, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32358, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 8, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(16).eut(64).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5134, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32358, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 16, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(32).eut(64).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5140, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32358, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 8, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(4).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5141, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32358, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 16, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(8).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5142, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32358, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 32, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(16).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5143, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32358, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 64, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(32).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemMugEmpty", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemMugCoffee", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("potion.darkcoffee", 500)).noFluidOutputs().duration(8).eut(1)
                .addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemMugEmpty", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemMugCoffee", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("potion.cafeaulait", 500)).noFluidOutputs().duration(8).eut(1)
                .addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemFoamSprayer", 1, 0, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemFoamSprayer",
                                1,
                                0,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:8000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 8000)).noFluidOutputs().duration(129)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                24,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:8000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 8000)).noFluidOutputs().duration(129)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                21,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:16000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 16000)).noFluidOutputs().duration(258)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                19,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:24000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 24000)).noFluidOutputs().duration(387)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                16,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:32000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 32000)).noFluidOutputs().duration(516)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                13,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:40000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 40000)).noFluidOutputs().duration(645)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                10,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:48000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 48000)).noFluidOutputs().duration(774)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                7,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:54000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 54000)).noFluidOutputs().duration(870)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                4,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:62000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 62000)).noFluidOutputs().duration(1000)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                1,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:70000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 70000)).noFluidOutputs().duration(1129)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 26, missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemArmorCFPack",
                                1,
                                1,
                                "{Fluid:{FluidName:\"ic2constructionfoam\",Amount:80000}}",
                                missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2constructionfoam", 80000)).noFluidOutputs().duration(1290)
                .eut(1).addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.TenKCell", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "reactorCoolantSimple", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 1000)).noFluidOutputs().duration(16).eut(1)
                .addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.ThirtyKCell", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "reactorCoolantTriple", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 3000)).noFluidOutputs().duration(48).eut(1)
                .addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.SixtyKCell", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "reactorCoolantSix", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 6000)).noFluidOutputs().duration(96).eut(1)
                .addTo(sFluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.MoldBoots", 0, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemArmorRubBoots", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 720)).noFluidOutputs().duration(300).eut(30)
                .addTo(sFluidSolidficationRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(IndustrialCraft2.ID, "itemPartIndustrialDiamond", 1, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 1500, missing))
                .noFluidInputs().noFluidOutputs().duration(3830).eut(16).addTo(sLatheRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 9, 17804, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7, missing)).noFluidInputs()
                .noFluidOutputs().duration(3600).eut(96).addTo(sBenderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 9, 17526, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 8, missing)).noFluidInputs()
                .noFluidOutputs().duration(3600).eut(96).addTo(sBenderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "blockBasalt", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2844, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, 32767, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.LapotronDust", 30, 0, missing))
                .outputChances(10000).noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemDust", 8, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2802, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemPartCoalBall", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "iron_boots", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemStaticBoots", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sPolarizerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.blockmachines", 1, 5130, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(4).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.blockmachines", 1, 5131, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(150).eut(8).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.blockmachines", 1, 5132, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.blockmachines", 1, 5133, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 8, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(250).eut(30).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.blockmachines", 1, 5134, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 16, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(64).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.blockmachines", 1, 5140, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 8, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.blockmachines", 1, 5141, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 16, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(250).eut(96).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.blockmachines", 1, 5142, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 32, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(120).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.blockmachines", 1, 5143, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 64, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(350).eut(256).addTo(sWiremillRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"ic2hotcoolant\",Amount:1000}}",
                                missing))
                .itemOutputs(
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"ic2coolant\",Amount:1000}}",
                                missing))
                .noFluidInputs().noFluidOutputs().duration(200).eut(120).addTo(sVacuumRecipes);

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
