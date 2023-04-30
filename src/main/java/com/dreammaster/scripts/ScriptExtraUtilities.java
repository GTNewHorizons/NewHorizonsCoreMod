package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

import com.dreammaster.thaumcraft.TCHelper;
import com.dreammaster.tinkersConstruct.TConstructHelper;
import com.rwtema.extrautils.tileentity.enderconstructor.EnderConstructorRecipesHandler;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptExtraUtilities implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "ExtraUtilities";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Mods.ExtraUtilities.ID,
                Mods.Thaumcraft.ID,
                Mods.ProjectRedIllumination.ID,
                Mods.TinkerConstruct.ID,
                Mods.Avaritia.ID,
                Mods.GTPlusPlus.ID,
                Mods.TwilightForest.ID,
                Mods.Botania.ID);
    }

    @Override
    public void loadRecipes() {

        addShapedRecipe(
                getModItem("ExtraUtilities", "decorativeBlock1", 1, 12, missing),
                new Object[] { getModItem("ExtraUtilities", "decorativeBlock1", 1, 11, missing), "plateDiamond",
                        getModItem("ExtraUtilities", "decorativeBlock1", 1, 11, missing), "plateTitanium",
                        "circuitData", "plateTitanium",
                        getModItem("ExtraUtilities", "decorativeBlock1", 1, 11, missing), "plateDiamond",
                        getModItem("ExtraUtilities", "decorativeBlock1", 1, 11, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "curtains", 1, 0, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 15, missing),
                        getModItem("minecraft", "carpet", 1, 15, missing), null,
                        getModItem("minecraft", "carpet", 1, 15, missing),
                        getModItem("minecraft", "carpet", 1, 15, missing), null,
                        getModItem("minecraft", "carpet", 1, 15, missing),
                        getModItem("minecraft", "carpet", 1, 15, missing), null });
        addShapedRecipe(
                getModItem("ExtraUtilities", "timer", 1, 0, missing),
                new Object[] { "plateRedAlloy", "gearWood", "plateRedAlloy", "gearWood",
                        getModItem("minecraft", "clock", 1, 0, missing), "gearWood", "plateRedAlloy", "stickRedAlloy",
                        "plateRedAlloy" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing),
                new Object[] { getModItem("ExtraUtilities", "decorativeBlock1", 1, 1, missing), "plateStainlessSteel",
                        getModItem("ExtraUtilities", "decorativeBlock1", 1, 1, missing), "plateStainlessSteel",
                        "gemEnderEye", "plateStainlessSteel",
                        getModItem("ExtraUtilities", "decorativeBlock1", 1, 1, missing), "plateStainlessSteel",
                        getModItem("ExtraUtilities", "decorativeBlock1", 1, 1, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 1, missing),
                new Object[] { getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing),
                        getModItem("ExtraUtilities", "cobblestone_compressed", 1, 4, missing),
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing),
                        getModItem("ExtraUtilities", "cobblestone_compressed", 1, 11, missing), "gearDiamond",
                        getModItem("ExtraUtilities", "cobblestone_compressed", 1, 11, missing),
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing),
                        getModItem("ExtraUtilities", "cobblestone_compressed", 1, 4, missing),
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 2, missing),
                new Object[] { getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing),
                        getModItem("TConstruct", "materials", 1, 26, missing),
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing), "plateTitanium",
                        "gearDiamond", "plateTitanium",
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing),
                        getModItem("TConstruct", "materials", 1, 26, missing),
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 3, missing),
                new Object[] { getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing), "plateTitanium",
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing), "plateTitanium",
                        "gearDiamond", "plateTitanium",
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing), "plateTitanium",
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 4, missing),
                new Object[] { getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing), "plateTungstenSteel",
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing), "plateTungstenSteel",
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 3, missing), "plateTungstenSteel",
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing), "plateTungstenSteel",
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 5, missing),
                new Object[] { getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing), "plateChrome",
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing), "plateChrome",
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 4, missing), "plateChrome",
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing), "plateChrome",
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 6, missing),
                new Object[] { getModItem("gregtech", "gt.blockmachines", 1, 11102, missing), "gearTitanium",
                        getModItem("gregtech", "gt.blockmachines", 1, 11102, missing),
                        getModItem("ExtraUtilities", "nodeUpgrade", 1, 0, missing), "gearDiamond",
                        getModItem("ExtraUtilities", "nodeUpgrade", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 11102, missing), "gearTitanium",
                        getModItem("gregtech", "gt.blockmachines", 1, 11102, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 7, missing),
                new Object[] { getModItem("gregtech", "gt.blockmachines", 1, 11103, missing), "gearTungstenSteel",
                        getModItem("gregtech", "gt.blockmachines", 1, 11103, missing), "gearTungstenSteel",
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 6, missing), "gearTungstenSteel",
                        getModItem("gregtech", "gt.blockmachines", 1, 11103, missing), "gearTungstenSteel",
                        getModItem("gregtech", "gt.blockmachines", 1, 11103, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 8, missing),
                new Object[] { getModItem("gregtech", "gt.blockmachines", 1, 11104, missing), "gearChrome",
                        getModItem("gregtech", "gt.blockmachines", 1, 11104, missing), "gearChrome",
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 7, missing), "gearChrome",
                        getModItem("gregtech", "gt.blockmachines", 1, 11104, missing), "gearChrome",
                        getModItem("gregtech", "gt.blockmachines", 1, 11104, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 9, missing),
                new Object[] { getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing),
                        getModItem("ExtraUtilities", "enderThermicPump", 1, 0, missing),
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing), "pipeLargeTungstenSteel",
                        "pipeSmallStainlessSteel", "pipeLargeTungstenSteel",
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing),
                        getModItem("ExtraUtilities", "enderThermicPump", 1, 0, missing),
                        getModItem("ExtraUtilities", "enderQuarryUpgrade", 1, 0, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "nodeUpgrade", 1, 0, missing),
                new Object[] { "plateRedAlloy", "plateDiamond", "plateRedAlloy", "plateDiamond", "gearStainlessSteel",
                        "plateDiamond", "plateRedAlloy", "plateDiamond", "plateRedAlloy" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "nodeUpgrade", 1, 1, missing),
                new Object[] { "plateRedAlloy", getModItem("minecraft", "iron_bars", 1, 0, missing), "plateRedAlloy",
                        getModItem("minecraft", "iron_bars", 1, 0, missing), "gearStainlessSteel",
                        getModItem("minecraft", "iron_bars", 1, 0, missing), "plateRedAlloy",
                        getModItem("minecraft", "iron_bars", 1, 0, missing), "plateRedAlloy" });
        addShapelessCraftingRecipe(
                getModItem("ExtraUtilities", "nodeUpgrade", 1, 1, missing),
                new Object[] { getModItem("ExtraUtilities", "nodeUpgrade", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("ExtraUtilities", "nodeUpgrade", 1, 1, missing),
                new Object[] { getModItem("ExtraUtilities", "nodeUpgrade", 1, 1, missing), "craftingRedstoneTorch" });
        addShapelessCraftingRecipe(
                getModItem("ExtraUtilities", "nodeUpgrade", 1, 1, missing),
                new Object[] { getModItem("ExtraUtilities", "nodeUpgrade", 1, 1, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem("ExtraUtilities", "nodeUpgrade", 1, 1, missing),
                new Object[] { getModItem("ExtraUtilities", "nodeUpgrade", 1, 1, missing), "stickWood" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "nodeUpgrade", 1, 10, missing),
                new Object[] { "plateLapis", getModItem("dreamcraft", "item.SteelBars", 1, 0, missing), "plateLapis",
                        getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                        getModItem("ExtraUtilities", "nodeUpgrade", 1, 1, missing),
                        getModItem("dreamcraft", "item.SteelBars", 1, 0, missing), "plateLapis",
                        getModItem("dreamcraft", "item.SteelBars", 1, 0, missing), "plateLapis" });
        addShapelessCraftingRecipe(
                getModItem("ExtraUtilities", "nodeUpgrade", 1, 10, missing),
                new Object[] { getModItem("ExtraUtilities", "nodeUpgrade", 1, 10, missing) });
        addShapelessCraftingRecipe(
                getModItem("ExtraUtilities", "nodeUpgrade", 1, 10, missing),
                new Object[] { getModItem("ExtraUtilities", "nodeUpgrade", 1, 10, missing), "craftingRedstoneTorch" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "nodeUpgrade", 1, 2, missing),
                new Object[] { "plateLapis", getModItem("minecraft", "diamond_pickaxe", 1, 0, missing), "plateLapis",
                        getModItem("minecraft", "iron_pickaxe", 1, 0, missing), "gearDiamond",
                        getModItem("minecraft", "iron_pickaxe", 1, 0, missing), "plateLapis",
                        getModItem("minecraft", "diamond_pickaxe", 1, 0, missing), "plateLapis" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "nodeUpgrade", 1, 5, missing),
                new Object[] { "plateEnderEye", getModItem("ExtraUtilities", "nodeUpgrade", 1, 2, missing),
                        "plateEnderEye", "gearIridium", getModItem("WR-CBE|Logic", "wirelessLogic", 1, 0, missing),
                        "gearIridium", "plateEnderEye", "plateNetherStar", "plateEnderEye" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "nodeUpgrade", 1, 6, missing),
                new Object[] { "plateEnderEye", getModItem("ExtraUtilities", "nodeUpgrade", 1, 2, missing),
                        "plateEnderEye", "gearIridium", getModItem("WR-CBE|Core", "recieverDish", 1, 0, missing),
                        "gearIridium", "plateEnderEye", "plateNetherStar", "plateEnderEye" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "nodeUpgrade", 1, 7, missing),
                new Object[] { "plateRedAlloy", getModItem("ExtraUtilities", "nodeUpgrade", 1, 0, missing),
                        "plateRedAlloy", "craftingToolWrench", "gearDiamond",
                        getModItem("ExtraUtilities", "nodeUpgrade", 1, 0, missing), "plateRedAlloy",
                        getModItem("ExtraUtilities", "nodeUpgrade", 1, 0, missing), "plateRedAlloy" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "nodeUpgrade", 1, 8, missing),
                new Object[] { "plateRedAlloy", "craftingToolWrench", "plateRedAlloy",
                        getModItem("ExtraUtilities", "nodeUpgrade", 1, 0, missing), "gearDiamond",
                        getModItem("ExtraUtilities", "nodeUpgrade", 1, 0, missing), "plateRedAlloy", null,
                        "plateRedAlloy" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "nodeUpgrade", 1, 8, missing),
                new Object[] { "plateRedAlloy", null, "plateRedAlloy",
                        getModItem("ExtraUtilities", "nodeUpgrade", 1, 0, missing), "gearDiamond",
                        getModItem("ExtraUtilities", "nodeUpgrade", 1, 0, missing), "plateRedAlloy",
                        "craftingToolWrench", "plateRedAlloy" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "nodeUpgrade", 1, 9, missing),
                new Object[] { "plateRedAlloy", getModItem("ExtraUtilities", "nodeUpgrade", 1, 0, missing),
                        "plateRedAlloy", getModItem("ExtraUtilities", "nodeUpgrade", 1, 0, missing), "gearDiamond",
                        "craftingToolWrench", "plateRedAlloy",
                        getModItem("ExtraUtilities", "nodeUpgrade", 1, 0, missing), "plateRedAlloy" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "nodeUpgrade", 1, 3, missing),
                new Object[] { "plateRedAlloy", getModItem("ExtraUtilities", "nodeUpgrade", 1, 0, missing),
                        "plateRedAlloy", "craftingToolWrench", "gearDiamond",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32641, missing), "plateRedAlloy",
                        getModItem("ExtraUtilities", "nodeUpgrade", 1, 0, missing), "plateRedAlloy" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                new Object[] { null, getModItem("harvestcraft", "wovencottonItem", 1, 0, missing),
                        getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), null, "stickWood",
                        getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "stickWood", null, null });
        addShapedRecipe(
                getModItem("ExtraUtilities", "drum", 1, 0, missing),
                new Object[] { "plateSteel", "ringMeteoricSteel", "plateSteel", "plateSteel", "pipeHugeSteel",
                        "plateSteel", "plateSteel", "ringMeteoricSteel", "plateSteel" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "drum", 1, 1, missing),
                new Object[] { "plateBedrockium", "ringTungstenSteel", "plateBedrockium", "plateBedrockium",
                        getModItem("ExtraUtilities", "drum", 1, 0, missing), "plateBedrockium", "plateBedrockium",
                        "ringTungstenSteel", "plateBedrockium" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "conveyor", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem("minecraft", "rail", 1, 0, missing),
                        "craftingToolWrench", getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                        "frameGtSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing), "gearGtSmallSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "gearGtSmallSteel" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "filing", 1, 0, missing),
                new Object[] { "plateSteel", "chestWood", "plateSteel", "screwSteel",
                        getModItem("IronChest", "BlockIronChest", 1, 0, missing), "screwSteel", "plateSteel",
                        "chestWood", "plateSteel" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "filing", 1, 1, missing),
                new Object[] { getModItem("ExtraUtilities", "decorativeBlock1", 1, 8, missing),
                        getModItem("ExtraUtilities", "filing", 1, 0, missing),
                        getModItem("ExtraUtilities", "decorativeBlock1", 1, 8, missing), "screwSteel",
                        getModItem("ExtraUtilities", "filing", 1, 0, missing), "screwSteel",
                        getModItem("ExtraUtilities", "decorativeBlock1", 1, 8, missing),
                        getModItem("ExtraUtilities", "filing", 1, 0, missing),
                        getModItem("ExtraUtilities", "decorativeBlock1", 1, 8, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "watering_can", 1, 1, missing),
                new Object[] { "craftingToolHardHammer", "ringSteel", "craftingToolScrewdriver", "plateAnyIron",
                        "plateAnyIron", "stickAnyIron", "plateAnyIron", "plateAnyIron", "screwSteel" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "watering_can", 1, 1, missing),
                new Object[] { "craftingToolScrewdriver", "ringSteel", "craftingToolHardHammer", "plateAnyIron",
                        "plateAnyIron", "stickAnyIron", "plateAnyIron", "plateAnyIron", "screwSteel" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "watering_can", 1, 3, missing),
                new Object[] { "craftingToolHardHammer", "ringNeutronium", "craftingToolScrewdriver", "plateBedrockium",
                        "plateBedrockium", "plateBedrockium", "plateBedrockium", "plateBedrockium",
                        "screwNeutronium" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "watering_can", 1, 3, missing),
                new Object[] { "craftingToolScrewdriver", "ringNeutronium", "craftingToolHardHammer", "plateBedrockium",
                        "plateBedrockium", "plateBedrockium", "plateBedrockium", "plateBedrockium",
                        "screwNeutronium" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "sound_muffler", 1, 0, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool",
                        getModItem("minecraft", "noteblock", 1, 0, missing), "blockWool", "blockWool",
                        getModItem("ExtraUtilities", "budoff", 1, 0, missing), "blockWool" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "sound_muffler", 1, 1, missing),
                new Object[] { "blockWool", getModItem("ExtraUtilities", "sound_muffler", 1, 0, missing), "blockWool",
                        getModItem("ExtraUtilities", "sound_muffler", 1, 0, missing),
                        getModItem("minecraft", "water_bucket", 1, 0, missing),
                        getModItem("ExtraUtilities", "sound_muffler", 1, 0, missing),
                        getModItem("ExtraUtilities", "sound_muffler", 1, 0, missing),
                        getModItem("ExtraUtilities", "budoff", 1, 0, missing),
                        getModItem("ExtraUtilities", "sound_muffler", 1, 0, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "pipes", 1, 0, missing),
                new Object[] { "foilSteel", "plateSteel", "foilSteel", "craftingToolWrench", "stickRedAlloy",
                        "craftingToolHardHammer", "foilSteel", "plateSteel", "foilSteel" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "pipes", 1, 8, missing),
                new Object[] { "foilSteel", "circuitBasic", "foilSteel", "craftingToolWrench",
                        getModItem("ExtraUtilities", "pipes", 1, 0, missing), "craftingToolHardHammer", "foilSteel",
                        "circuitBasic", "foilSteel" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "pipes", 1, 9, missing),
                new Object[] { "foilSteel", "circuitGood", "foilSteel", "craftingToolWrench",
                        getModItem("ExtraUtilities", "pipes", 1, 0, missing), "craftingToolHardHammer", "foilSteel",
                        "circuitGood", "foilSteel" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "pipes", 1, 10, missing),
                new Object[] { "foilSteel", "circuitAdvanced", "foilSteel", "craftingToolWrench",
                        getModItem("ExtraUtilities", "pipes", 1, 8, missing), "craftingToolHardHammer", "foilSteel",
                        "circuitAdvanced", "foilSteel" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "pipes.1", 1, 0, missing),
                new Object[] { "foilSteel", "circuitData", "foilSteel", "craftingToolWrench",
                        getModItem("ExtraUtilities", "pipes", 1, 10, missing), "craftingToolHardHammer", "foilSteel",
                        "circuitData", "foilSteel" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "pipes", 1, 11, missing),
                new Object[] { "foilRedAlloy", "plateRedAlloy", "foilRedAlloy", "craftingToolWrench",
                        getModItem("ExtraUtilities", "pipes", 1, 0, missing), "craftingToolHardHammer", "foilRedAlloy",
                        "plateRedAlloy", "foilRedAlloy" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "pipes", 1, 12, missing),
                new Object[] { "craftingToolHardHammer", getModItem("ExtraUtilities", "pipes", 1, 0, missing),
                        "screwSteel", getModItem("ExtraUtilities", "pipes", 1, 0, missing),
                        getModItem("ExtraUtilities", "pipes", 1, 0, missing),
                        getModItem("ExtraUtilities", "pipes", 1, 0, missing), "screwSteel",
                        getModItem("ExtraUtilities", "pipes", 1, 0, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "pipes", 1, 12, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("ExtraUtilities", "pipes", 1, 0, missing),
                        "screwSteel", getModItem("ExtraUtilities", "pipes", 1, 0, missing),
                        getModItem("ExtraUtilities", "pipes", 1, 0, missing),
                        getModItem("ExtraUtilities", "pipes", 1, 0, missing), "screwSteel",
                        getModItem("ExtraUtilities", "pipes", 1, 0, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "pipes", 1, 13, missing),
                new Object[] { "foilSteel", "circuitBasic", "foilSteel", "craftingToolWrench",
                        getModItem("ExtraUtilities", "pipes", 1, 8, missing), "craftingToolHardHammer", "foilSteel",
                        "circuitBasic", "foilSteel" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "pipes", 1, 14, missing),
                new Object[] { "foilElectrum", "plateElectrum", "foilElectrum", "craftingToolWrench",
                        getModItem("ExtraUtilities", "pipes", 1, 11, missing), "craftingToolHardHammer", "foilElectrum",
                        "plateElectrum", "foilElectrum" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "extractor_base_remote", 1, 0, missing),
                new Object[] { "craftingToolWrench", getModItem("ExtraUtilities", "pipes", 1, 32767, missing),
                        "craftingToolHardHammer", "screwEnderPearl",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing), "screwEnderPearl",
                        getModItem("ExtraUtilities", "extractor_base", 1, 0, missing),
                        getModItem("ExtraUtilities", "extractor_base", 1, 0, missing),
                        getModItem("ExtraUtilities", "extractor_base", 1, 0, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "extractor_base_remote", 1, 6, missing),
                new Object[] { "craftingToolWrench", getModItem("ExtraUtilities", "pipes", 1, 32767, missing),
                        "craftingToolHardHammer", "screwEnderPearl",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing), "screwEnderPearl",
                        getModItem("ExtraUtilities", "extractor_base", 1, 6, missing),
                        getModItem("ExtraUtilities", "extractor_base", 1, 6, missing),
                        getModItem("ExtraUtilities", "extractor_base", 1, 6, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "extractor_base", 1, 0, missing),
                new Object[] { "craftingToolWrench", getModItem("ExtraUtilities", "pipes", 1, 32767, missing),
                        "craftingToolHardHammer", "screwEnderPearl",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing), "screwEnderPearl",
                        getModItem("gregtech", "gt.metaitem.02", 1, 20305, missing), "pipeMediumBrass",
                        getModItem("gregtech", "gt.metaitem.02", 1, 20305, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "extractor_base", 1, 6, missing),
                new Object[] { "craftingToolWrench", getModItem("ExtraUtilities", "pipes", 1, 32767, missing),
                        "craftingToolHardHammer", "screwEnderPearl",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing), "screwEnderPearl",
                        getModItem("gregtech", "gt.blockmachines", 1, 5132, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 5132, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "trashcan", 1, 0, missing),
                new Object[] { "plateIron", "craftingToolHardHammer", "plateIron", "plateIron", "gemEnderPearl",
                        "plateIron", "plateIron", "plateIron", "plateIron" });
        addShapelessCraftingRecipe(
                getModItem("ExtraUtilities", "decorativeBlock2", 1, 0, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("ExtraUtilities", "unstableingot", 1, 0, missing),
                new Object[] { getModItem("ExtraUtilities", "unstableingot", 1, 2, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "chestFull", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        "craftingToolSaw", getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), "chestWood",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), null,
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), null });
        addShapedRecipe(
                getModItem("ExtraUtilities", "chestMini", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        "craftingToolSaw", getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), "itemFlint",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), null,
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), null });
        addShapedRecipe(
                getModItem("ExtraUtilities", "enderCollector", 1, 0, missing),
                new Object[] { "lensEnderPearl", "blockEnderObsidian", "lensEnderPearl", "craftingToolHardHammer",
                        "blockEnderObsidian", "craftingToolWrench", "stoneObsidian", "stoneObsidian",
                        "stoneObsidian" });
        addShapelessCraftingRecipe(
                getModItem("ExtraUtilities", "enderCollector", 1, 0, missing),
                new Object[] { getModItem("RandomThings", "advancedItemCollector", 1, 0, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "endConstructor", 1, 0, missing),
                new Object[] { "plateEnderEye", getModItem("HardcoreEnderExpansion", "altar_nexus", 1, 0, missing),
                        "plateEnderEye", "blockEnderObsidian",
                        getModItem("Thaumcraft", "blockStoneDevice", 1, 2, missing), "blockEnderObsidian",
                        "plateTitanium", getModItem("ExtraUtilities", "decorativeBlock1", 1, 12, missing),
                        "plateTitanium" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "spike_base_wood", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("minecraft", "wooden_sword", 1, 0, missing),
                        "craftingToolScrewdriver", "screwWood", "plateWood", "screwWood", "plateWood", "logWood",
                        "plateWood" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "spike_base", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("minecraft", "iron_sword", 1, 0, missing),
                        "craftingToolScrewdriver", "screwIron", "plateAnyIron", "screwIron", "plateAnyIron",
                        "blockIron", "plateAnyIron" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "spike_base_gold", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("minecraft", "golden_sword", 1, 0, missing),
                        "craftingToolScrewdriver", "screwGold", "plateGold", "screwGold", "plateGold", "blockGold",
                        "plateGold" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "spike_base_diamond", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("minecraft", "diamond_sword", 1, 0, missing),
                        "craftingToolScrewdriver", "screwDiamond", "plateDiamond", "screwDiamond", "plateDiamond",
                        "blockDiamond", "plateDiamond" });
        addShapedRecipe(
                getModItem("ExtraUtilities", "builderswand", 1, 0, missing),
                new Object[] { null, null, "ingotUnstable", null, "ingotUnstable", null, "stickObsidian", null, null });
        addShapedRecipe(
                getModItem("ExtraUtilities", "creativebuilderswand", 1, 0, missing),
                new Object[] { null, "ingotUnstable", "ingotUnstable", null, "ingotUnstable", "ingotUnstable",
                        "stickObsidian", null, null });
        addShapedRecipe(
                getModItem("ExtraUtilities", "shears", 1, 0, missing),
                new Object[] { "ingotUnstable", null, "ingotUnstable",
                        getModItem("ExtraUtilities", "angelBlock", 1, 0, missing),
                        getModItem("minecraft", "shears", 1, 0, missing),
                        getModItem("ExtraUtilities", "angelBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem("ExtraUtilities", "ethericsword", 1, 0, missing),
                new Object[] { null, "ingotUnstable", null, null, "ingotUnstable", null, null,
                        getModItem("RandomThings", "ingredient", 1, 1, missing), null });
        addShapedRecipe(
                getModItem("ExtraUtilities", "lawSword", 1, 0, missing),
                new Object[] { null, getModItem("TConstruct", "largeSwordBlade", 1, 314, missing), null, null,
                        "ingotUnstable", null, null, getModItem("RandomThings", "ingredient", 1, 1, missing), null });
        addShapedRecipe(
                getModItem("ExtraUtilities", "erosionShovel", 1, 0, missing),
                new Object[] { null, "ingotUnstable", null, null,
                        getModItem("RandomThings", "ingredient", 1, 1, missing), null, null,
                        getModItem("RandomThings", "ingredient", 1, 1, missing), null });
        addShapedRecipe(
                getModItem("ExtraUtilities", "destructionpickaxe", 1, 0, missing),
                new Object[] { "ingotUnstable", "ingotUnstable", "ingotUnstable", null,
                        getModItem("RandomThings", "ingredient", 1, 1, missing), null, null,
                        getModItem("RandomThings", "ingredient", 1, 1, missing), null });
        addShapedRecipe(
                getModItem("ExtraUtilities", "defoliageAxe", 1, 0, missing),
                new Object[] { "ingotUnstable", "ingotUnstable", null, "ingotUnstable",
                        getModItem("RandomThings", "ingredient", 1, 1, missing), null, null,
                        getModItem("RandomThings", "ingredient", 1, 1, missing), null });
        addShapedRecipe(
                getModItem("ExtraUtilities", "temporalHoe", 1, 0, missing),
                new Object[] { "ingotUnstable", "ingotUnstable", null, null,
                        getModItem("RandomThings", "ingredient", 1, 1, missing), null, null,
                        getModItem("RandomThings", "ingredient", 1, 1, missing), null });
        addShapedRecipe(
                getModItem("ExtraUtilities", "unstableingot", 1, 0, missing),
                new Object[] { getModItem("minecraft", "iron_ingot", 1, 0, missing),
                        createItemStack("ExtraUtilities", "divisionSigil", 1, 0, "{damage:256}", missing),
                        getModItem("minecraft", "diamond", 1, 0, missing) });

        // mods.extraUtils.QED.removeRecipe(<*>); // <- scripts
        EnderConstructorRecipesHandler.recipes.clear();

        TConstructHelper.removeTableRecipe(getModItem("ExtraUtilities", "bedrockiumIngot", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem("ExtraUtilities", "block_bedrockium", 1, 0, missing));
        EnderConstructorRecipesHandler.addRecipe(
                getModItem("ExtraUtilities", "enderQuarry", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                "plateEuropium",
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 32675, missing),
                'c',
                "plateEuropium",
                'd',
                getModItem("ExtraUtilities", "enderThermicPump", 1, 0, missing),
                'e',
                getModItem("ExtraUtilities", "decorativeBlock1", 1, 12, missing),
                'f',
                getModItem("ExtraUtilities", "enderThermicPump", 1, 0, missing),
                'g',
                getModItem("ExtraUtilities", "decorativeBlock1", 1, 11, missing),
                'h',
                getModItem("IC2", "blockMachine2", 1, 11, missing),
                'i',
                getModItem("ExtraUtilities", "decorativeBlock1", 1, 11, missing));
        EnderConstructorRecipesHandler.addRecipe(
                getModItem("ExtraUtilities", "enderThermicPump", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("ExtraUtilities", "decorativeBlock1", 1, 1, missing),
                'b',
                "circuitData",
                'c',
                getModItem("ExtraUtilities", "decorativeBlock1", 1, 1, missing),
                'd',
                getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                'e',
                getModItem("ExtraUtilities", "decorativeBlock1", 1, 11, missing),
                'f',
                getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                'g',
                getModItem("ExtraUtilities", "decorativeBlock1", 1, 1, missing),
                'h',
                getModItem("gregtech", "gt.blockmachines", 1, 1143, missing),
                'i',
                getModItem("ExtraUtilities", "decorativeBlock1", 1, 1, missing));
        EnderConstructorRecipesHandler.addRecipe(
                getModItem("ExtraUtilities", "magnumTorch", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("minecraft", "potion", 1, 8225, missing),
                'b',
                getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                'c',
                getModItem("minecraft", "potion", 1, 8229, missing),
                'd',
                getModItem("ExtraUtilities", "chandelier", 1, 0, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 23306, missing),
                'f',
                getModItem("ExtraUtilities", "chandelier", 1, 0, missing),
                'g',
                getModItem("ExtraUtilities", "chandelier", 1, 0, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 23306, missing),
                'i',
                getModItem("ExtraUtilities", "chandelier", 1, 0, missing));
        EnderConstructorRecipesHandler.addRecipe(
                getModItem("ExtraUtilities", "extractor_base", 1, 12, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("ExtraUtilities", "extractor_base", 1, 0, missing),
                'b',
                getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowerdiamond", 1, 0, missing),
                'c',
                getModItem("ExtraUtilities", "extractor_base", 1, 0, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 17533, missing),
                'e',
                getModItem("ExtraUtilities", "nodeUpgrade", 1, 8, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 17533, missing),
                'g',
                getModItem("ExtraUtilities", "extractor_base", 1, 0, missing),
                'h',
                getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowerdiamond", 1, 0, missing),
                'i',
                getModItem("ExtraUtilities", "extractor_base", 1, 0, missing));
        EnderConstructorRecipesHandler.addRecipe(
                getModItem("ExtraUtilities", "extractor_base", 1, 13, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("ExtraUtilities", "extractor_base", 1, 12, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 17533, missing),
                'c',
                getModItem("ExtraUtilities", "extractor_base", 1, 12, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 17533, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 11395, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 17533, missing),
                'g',
                getModItem("ExtraUtilities", "extractor_base", 1, 12, missing),
                'h',
                getModItem("ExtraUtilities", "extractor_base", 1, 12, missing),
                'i',
                getModItem("ExtraUtilities", "extractor_base", 1, 12, missing));
        EnderConstructorRecipesHandler.addRecipe(
                getModItem("miscutils", "blockCompressedObsidian", 1, 5, missing),
                "abc",
                "def",
                "ghi",
                'a',
                "dustRedstone",
                'b',
                "dustGlowstone",
                'c',
                "dustRedstone",
                'd',
                "dustGlowstone",
                'e',
                "blockObsidian",
                'f',
                "dustGlowstone",
                'g',
                "dustRedstone",
                'h',
                "dustGlowstone",
                'i',
                "dustRedstone");
        EnderConstructorRecipesHandler.addRecipe(
                getModItem("ExtraUtilities", "endMarker", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("minecraft", "ender_eye", 1, 0, missing),
                'e',
                getModItem("ExtraUtilities", "decorativeBlock1", 1, 1, missing),
                'h',
                getModItem("ExtraUtilities", "decorativeBlock1", 1, 1, missing));
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraUtilities", "unstableingot", 9, 2, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock1", 1, 5, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraUtilities", "unstableingot", 9, 0, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock1", 1, 5, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 0, missing))
                .itemOutputs(getModItem("minecraft", "cobblestone", 9, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 1, missing))
                .itemOutputs(getModItem("ExtraUtilities", "cobblestone_compressed", 9, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 2, missing))
                .itemOutputs(getModItem("ExtraUtilities", "cobblestone_compressed", 9, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 3, missing))
                .itemOutputs(getModItem("ExtraUtilities", "cobblestone_compressed", 9, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 4, missing))
                .itemOutputs(getModItem("ExtraUtilities", "cobblestone_compressed", 9, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 5, missing))
                .itemOutputs(getModItem("ExtraUtilities", "cobblestone_compressed", 9, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 6, missing))
                .itemOutputs(getModItem("ExtraUtilities", "cobblestone_compressed", 9, 5, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 7, missing))
                .itemOutputs(getModItem("ExtraUtilities", "cobblestone_compressed", 9, 6, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 8, missing))
                .itemOutputs(getModItem("minecraft", "dirt", 9, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 9, missing))
                .itemOutputs(getModItem("ExtraUtilities", "cobblestone_compressed", 9, 8, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 10, missing))
                .itemOutputs(getModItem("ExtraUtilities", "cobblestone_compressed", 9, 9, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 11, missing))
                .itemOutputs(getModItem("ExtraUtilities", "cobblestone_compressed", 9, 10, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 12, missing))
                .itemOutputs(getModItem("minecraft", "gravel", 9, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 13, missing))
                .itemOutputs(getModItem("ExtraUtilities", "cobblestone_compressed", 9, 12, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 14, missing))
                .itemOutputs(getModItem("minecraft", "sand", 9, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 15, missing))
                .itemOutputs(getModItem("ExtraUtilities", "cobblestone_compressed", 9, 14, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "quartz_block", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2816, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock1", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(80).eut(64).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "decorativeBlock2", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 2804, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock2", 1, 5, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(8).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "decorativeBlock2", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2086, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock2", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(8).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "decorativeBlock2", 1, 0, missing),
                        getModItem("minecraft", "gunpowder", 1, 0, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock2", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(8).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "decorativeBlock2", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17811, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock2", 1, 7, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "decorativeBlock2", 1, 0, missing),
                        getModItem("minecraft", "dye", 1, 9, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock2", 1, 8, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(8).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "cobblestone_compressed", 4, 3, missing),
                        getModItem("minecraft", "diamond_block", 1, 0, missing))
                .itemOutputs(getModItem("ExtraUtilities", "bedrockiumIngot", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "decorativeBlock2", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock2", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "decorativeBlock2", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock2", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "decorativeBlock2", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock2", 1, 6, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "decorativeBlock2", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock2", 1, 9, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "decorativeBlock2", 1, 0, missing),
                        getModItem("ExtraUtilities", "curtains", 1, 0, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock2", 1, 10, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "decorativeBlock2", 1, 10, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 2804, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock2", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "chest", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17809, missing))
                .itemOutputs(getModItem("ExtraUtilities", "chestFull", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "flint", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17809, missing))
                .itemOutputs(getModItem("ExtraUtilities", "chestMini", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(50).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "decorativeBlock1", 4, 2, missing),
                        getModItem("IC2", "itemDensePlates", 4, 7, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock1", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 500)).noFluidOutputs().duration(600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "decorativeBlock1", 4, 1, missing),
                        getModItem("minecraft", "ender_eye", 3, 0, missing))
                .itemOutputs(getModItem("ExtraUtilities", "endConstructor", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(400).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Railcraft", "detector", 1, 2, missing),
                        getModItem("minecraft", "sticky_piston", 1, 0, missing))
                .itemOutputs(getModItem("ExtraUtilities", "budoff", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "budoff", 1, 0, missing),
                        getModItem("minecraft", "redstone_block", 4, 0, missing))
                .itemOutputs(getModItem("ExtraUtilities", "budoff", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "torch", 5, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 28500, missing))
                .itemOutputs(getModItem("ExtraUtilities", "chandelier", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 1440)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stone", 4, 0, missing),
                        getModItem("minecraft", "stonebrick", 5, 0, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock1", 9, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(180).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "decorativeBlock1", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock1", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "decorativeBlock1", 1, 4, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock1", 1, 7, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "gravel", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock1", 1, 6, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stone", 1, 0, missing),
                        getModItem("minecraft", "ice", 4, 0, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock1", 4, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(80).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "sand", 1, 0, missing),
                        getModItem("minecraft", "glass", 1, 0, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock1", 2, 9, missing)).noFluidInputs()
                .noFluidOutputs().duration(40).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "sandstone", 1, 0, missing),
                        getModItem("minecraft", "end_stone", 1, 0, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock1", 2, 13, missing)).noFluidInputs()
                .noFluidOutputs().duration(40).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "decorativeBlock1", 5, 6, missing),
                        getModItem("minecraft", "stone_slab", 5, 5, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock1", 5, 10, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "decorativeBlock1", 4, 1, missing),
                        getModItem("ExtraUtilities", "decorativeBlock1", 4, 8, missing))
                .itemOutputs(getModItem("ExtraUtilities", "decorativeBlock1", 1, 11, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(1200).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Railcraft", "machine.alpha", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 32470, missing))
                .itemOutputs(getModItem("ExtraUtilities", "trading_post", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("ExtraUtilities", "pipes", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redalloy", 36)).noFluidOutputs().duration(100).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "pipes", 1, 0, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing))
                .itemOutputs(getModItem("ExtraUtilities", "pipes", 1, 8, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "pipes", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("ExtraUtilities", "pipes", 1, 11, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redalloy", 216)).noFluidOutputs().duration(200).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "pipes", 4, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem("ExtraUtilities", "pipes", 1, 12, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "pipes", 1, 8, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing))
                .itemOutputs(getModItem("ExtraUtilities", "pipes", 1, 13, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "pipes", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing))
                .itemOutputs(getModItem("ExtraUtilities", "pipes", 1, 9, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "pipes", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32079, missing))
                .itemOutputs(getModItem("ExtraUtilities", "pipes", 1, 9, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "pipes", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32080, missing))
                .itemOutputs(getModItem("ExtraUtilities", "pipes", 1, 9, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "pipes", 1, 8, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 1, 0, missing))
                .itemOutputs(getModItem("ExtraUtilities", "pipes", 1, 10, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17303, missing),
                        getModItem("ExtraUtilities", "pipes", 1, 11, missing))
                .itemOutputs(getModItem("ExtraUtilities", "pipes", 1, 14, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "pipes", 1, 10, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32708, missing))
                .itemOutputs(getModItem("ExtraUtilities", "pipes.1", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "pipes", 1, 10, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32704, missing))
                .itemOutputs(getModItem("ExtraUtilities", "pipes.1", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "pipes", 1, 10, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32083, missing))
                .itemOutputs(getModItem("ExtraUtilities", "pipes.1", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "pipes", 1, 10, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32085, missing))
                .itemOutputs(getModItem("ExtraUtilities", "pipes.1", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 17032, missing),
                        getModItem("minecraft", "ender_pearl", 1, 0, missing))
                .itemOutputs(getModItem("ExtraUtilities", "trashcan", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "trashcan", 1, 0, missing),
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing))
                .itemOutputs(getModItem("ExtraUtilities", "trashcan", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "trashcan", 1, 0, missing),
                        getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowergold", 1, 0, missing))
                .itemOutputs(getModItem("ExtraUtilities", "trashcan", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemRecipePart", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19032, missing))
                .itemOutputs(getModItem("ExtraUtilities", "heatingElement", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).noFluidOutputs().duration(400).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemRecipePart", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19032, missing))
                .itemOutputs(getModItem("ExtraUtilities", "heatingElement", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 288)).noFluidOutputs().duration(400).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemRecipePart", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19032, missing))
                .itemOutputs(getModItem("ExtraUtilities", "heatingElement", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).noFluidOutputs().duration(400)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "ender_pearl", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 19086, missing))
                .itemOutputs(getModItem("ExtraUtilities", "golden_lasso", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32762, missing),
                        getModItem("minecraft", "ender_eye", 1, 0, missing))
                .itemOutputs(getModItem("ExtraUtilities", "scanner", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.integrated_circuit", 0, 9, missing),
                        getModItem("minecraft", "cobblestone", 9, 0, missing))
                .itemOutputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "dirt", 9, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 9, missing))
                .itemOutputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 8, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "gravel", 9, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 9, missing))
                .itemOutputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 12, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "sand", 9, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 9, missing))
                .itemOutputs(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 14, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);

        ThaumcraftApi.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem("ExtraUtilities", "angelRing", 1, 0, missing),
                30,
                new AspectList().add(Aspect.getAspect("praecantatio"), 200).add(Aspect.getAspect("volatus"), 200)
                        .add(Aspect.getAspect("tempestas"), 200).add(Aspect.getAspect("nebrisum"), 200)
                        .add(Aspect.getAspect("motus"), 200).add(Aspect.getAspect("terminus"), 200),
                createItemStack(
                        "TConstruct",
                        "travelWings",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:2.0d,Built:1b,MaxDefense:8.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}",
                        missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 28084, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27329, missing),
                        getModItem("dreamcraft", "item.EngravedGoldChip", 1, 0, missing),
                        getModItem("ExtraUtilities", "angelBlock", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                        getModItem("miscutils", "magicfeather", 1, 0, missing),
                        getModItem("minecraft", "nether_star", 1, 0, missing),
                        getModItem("Avaritia", "big_pearl", 1, 0, missing),
                        getModItem("minecraft", "nether_star", 1, 0, missing),
                        getModItem("miscutils", "magicfeather", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                        getModItem("ExtraUtilities", "angelBlock", 1, 0, missing),
                        getModItem("dreamcraft", "item.EngravedGoldChip", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27329, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem("ExtraUtilities", "angelRing", 1, 1, missing),
                4,
                new AspectList().add(Aspect.getAspect("permutatio"), 50).add(Aspect.getAspect("volatus"), 50)
                        .add(Aspect.getAspect("aer"), 50),
                getModItem("ExtraUtilities", "angelRing", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("TConstruct", "fletching", 1, 0, missing),
                        getModItem("TConstruct", "fletching", 1, 0, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem("ExtraUtilities", "angelRing", 1, 2, missing),
                4,
                new AspectList().add(Aspect.getAspect("permutatio"), 50).add(Aspect.getAspect("volatus"), 50)
                        .add(Aspect.getAspect("auram"), 50),
                getModItem("ExtraUtilities", "angelRing", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("TwilightForest", "tile.TFCicada", 1, 0, missing),
                        getModItem("TwilightForest", "tile.TFFirefly", 1, 0, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem("ExtraUtilities", "angelRing", 1, 3, missing),
                4,
                new AspectList().add(Aspect.getAspect("permutatio"), 50).add(Aspect.getAspect("bestia"), 50)
                        .add(Aspect.getAspect("infernus"), 50),
                getModItem("ExtraUtilities", "angelRing", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("minecraft", "dragon_egg", 1, 0, missing),
                        getModItem("Botania", "manaResource", 1, 9, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem("ExtraUtilities", "angelRing", 1, 4, missing),
                4,
                new AspectList().add(Aspect.getAspect("permutatio"), 50).add(Aspect.getAspect("metallum"), 50)
                        .add(Aspect.getAspect("lucrum"), 50),
                getModItem("ExtraUtilities", "angelRing", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 29351, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 29351, missing), });
        new ResearchItem(
                "EXURINGS",
                "ARTIFICE",
                new AspectList().add(Aspect.getAspect("praecantatio"), 10).add(Aspect.getAspect("volatus"), 10)
                        .add(Aspect.getAspect("tempestas"), 100).add(Aspect.getAspect("nebrisum"), 10)
                        .add(Aspect.getAspect("motus"), 10).add(Aspect.getAspect("terminus"), 10),
                1,
                -5,
                3,
                getModItem("TConstruct", "travelWings", 1, 0, missing)).setRound().setConcealed()
                        .setParentsHidden("INFUSION")
                        .setPages(
                                new ResearchPage("tc.research_page.EXURINGS.1"),
                                new ResearchPage("tc.research_page.EXURINGS.2"),
                                new ResearchPage("tc.research_page.EXURINGS.3"),
                                new ResearchPage("tc.research_page.EXURINGS.4"),
                                new ResearchPage("tc.research_page.EXURINGS.5"),
                                new ResearchPage("tc.research_page.EXURINGS.6"))
                        .registerResearchItem();
        new ResearchItem(
                "EXURINGS_CRAFTING",
                "ARTIFICE",
                new AspectList().add(Aspect.getAspect("praecantatio"), 10).add(Aspect.getAspect("volatus"), 10)
                        .add(Aspect.getAspect("tempestas"), 10).add(Aspect.getAspect("nebrisum"), 10)
                        .add(Aspect.getAspect("motus"), 10).add(Aspect.getAspect("terminus"), 10),
                -1,
                -5,
                3,
                getModItem("ExtraUtilities", "angelRing", 1, 0, missing)).setParents("EXURINGS").setConcealed()
                        .registerResearchItem();
        ThaumcraftApi.addWarpToResearch("EXURINGS_CRAFTING", 16);
        TCHelper.addResearchPage("EXURINGS_CRAFTING", new ResearchPage("tc.research_page.EXURINGS_CRAFTING.1"));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("ExtraUtilities", "angelRing", 1, 0, missing))));
        TCHelper.addResearchPage("EXURINGS_CRAFTING", new ResearchPage("tc.research_page.EXURINGS_CRAFTING.2"));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("ExtraUtilities", "angelRing", 1, 1, missing))));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("ExtraUtilities", "angelRing", 1, 2, missing))));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("ExtraUtilities", "angelRing", 1, 3, missing))));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("ExtraUtilities", "angelRing", 1, 4, missing))));
    }
}
