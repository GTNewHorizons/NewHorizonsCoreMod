package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.BuildCraftTransport;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.ProjectRedIllumination;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.RandomThings;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.enums.Mods.WirelessRedstoneCBECore;
import static gregtech.api.enums.Mods.WirelessRedstoneCBELogic;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByte;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.item.NHItemList;
import com.dreammaster.recipes.CustomItem;
import com.dreammaster.thaumcraft.TCHelper;
import com.dreammaster.tinkersConstruct.TConstructHelper;
import com.rwtema.extrautils.tileentity.enderconstructor.EnderConstructorRecipesHandler;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptExtraUtilities implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "ExtraUtilities";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                ExtraUtilities.ID,
                Thaumcraft.ID,
                ProjectRedIllumination.ID,
                TinkerConstruct.ID,
                Avaritia.ID,
                GTPlusPlus.ID,
                TwilightForest.ID,
                Botania.ID,
                WirelessRedstoneCBECore.ID,
                WirelessRedstoneCBELogic.ID,
                BuildCraftFactory.ID,
                BuildCraftTransport.ID,
                HardcoreEnderExpansion.ID,
                IndustrialCraft2.ID,
                IronChests.ID,
                PamsHarvestCraft.ID,
                Railcraft.ID,
                RandomThings.ID);
    }

    @Override
    public void loadRecipes() {

        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 12, missing),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 11, missing),
                "plateDiamond",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 11, missing),
                "plateTitanium",
                "circuitData",
                "plateTitanium",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 11, missing),
                "plateDiamond",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 11, missing));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "curtains", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 15, missing),
                getModItem(Minecraft.ID, "carpet", 1, 15, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 15, missing),
                getModItem(Minecraft.ID, "carpet", 1, 15, missing),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 15, missing),
                getModItem(Minecraft.ID, "carpet", 1, 15, missing),
                null);
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "timer", 1, 0, missing),
                "plateRedAlloy",
                "gearWood",
                "plateRedAlloy",
                "gearWood",
                getModItem(Minecraft.ID, "clock", 1, 0, missing),
                "gearWood",
                "plateRedAlloy",
                "stickRedAlloy",
                "plateRedAlloy");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1, missing),
                "plateStainlessSteel",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1, missing),
                "plateStainlessSteel",
                "gemEnderEye",
                "plateStainlessSteel",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1, missing),
                "plateStainlessSteel",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1, missing));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 1, missing),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 4, missing),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 11, missing),
                "gearDiamond",
                getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 11, missing),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 4, missing),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 2, missing),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 26, missing),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing),
                "plateTitanium",
                "gearDiamond",
                "plateTitanium",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 26, missing),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 3, missing),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing),
                "plateTitanium",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing),
                "plateTitanium",
                "gearDiamond",
                "plateTitanium",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing),
                "plateTitanium",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 4, missing),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing),
                "plateTungstenSteel",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing),
                "plateTungstenSteel",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 3, missing),
                "plateTungstenSteel",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing),
                "plateTungstenSteel",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 5, missing),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing),
                "plateChrome",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing),
                "plateChrome",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 4, missing),
                "plateChrome",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing),
                "plateChrome",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 6, missing),
                ItemList.AcceleratorHV.get(1),
                "gearTitanium",
                ItemList.AcceleratorHV.get(1),
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0, missing),
                "gearDiamond",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0, missing),
                ItemList.AcceleratorHV.get(1),
                "gearTitanium",
                ItemList.AcceleratorHV.get(1));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 7, missing),
                ItemList.AcceleratorEV.get(1),
                "gearTungstenSteel",
                ItemList.AcceleratorEV.get(1),
                "gearTungstenSteel",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 6, missing),
                "gearTungstenSteel",
                ItemList.AcceleratorEV.get(1),
                "gearTungstenSteel",
                ItemList.AcceleratorEV.get(1));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 8, missing),
                ItemList.AcceleratorIV.get(1),
                "gearChrome",
                ItemList.AcceleratorIV.get(1),
                "gearChrome",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 7, missing),
                "gearChrome",
                ItemList.AcceleratorIV.get(1),
                "gearChrome",
                ItemList.AcceleratorIV.get(1));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 9, missing),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "enderThermicPump", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing),
                "pipeLargeTungstenSteel",
                "pipeSmallStainlessSteel",
                "pipeLargeTungstenSteel",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "enderThermicPump", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0, missing),
                "plateRedAlloy",
                "plateDiamond",
                "plateRedAlloy",
                "plateDiamond",
                "gearStainlessSteel",
                "plateDiamond",
                "plateRedAlloy",
                "plateDiamond",
                "plateRedAlloy");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 1, missing),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "gearStainlessSteel",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "plateRedAlloy");
        addShapelessRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 1, missing),
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 1, missing));
        GameRegistry.addRecipe(
                new FilterRecipe(
                        getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 1, missing),
                        Collections.singletonMap("Inverted", new NBTTagByte((byte) 1)),
                        "craftingRedstoneTorch"));
        GameRegistry.addRecipe(
                new FilterRecipe(
                        getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 1, missing),
                        Collections.singletonMap("FuzzyNBT", new NBTTagByte((byte) 1)),
                        "blockWool"));
        GameRegistry.addRecipe(
                new FilterRecipe(
                        getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 1, missing),
                        Collections.singletonMap("FuzzyMeta", new NBTTagByte((byte) 1)),
                        "stickWood"));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 10, missing),
                "plateLapis",
                CustomItemList.SteelBars.get(1L),
                "plateLapis",
                CustomItemList.SteelBars.get(1L),
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 1, missing),
                CustomItemList.SteelBars.get(1L),
                "plateLapis",
                CustomItemList.SteelBars.get(1L),
                "plateLapis");
        addShapelessRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 10, missing),
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 10, missing));
        GameRegistry.addRecipe(
                new FilterRecipe(
                        getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 10, missing),
                        Collections.singletonMap("Inverted", new NBTTagByte((byte) 1)),
                        "craftingRedstoneTorch"));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 2, missing),
                "plateLapis",
                getModItem(Minecraft.ID, "diamond_pickaxe", 1, 0, missing),
                "plateLapis",
                getModItem(Minecraft.ID, "iron_pickaxe", 1, 0, missing),
                "gearDiamond",
                getModItem(Minecraft.ID, "iron_pickaxe", 1, 0, missing),
                "plateLapis",
                getModItem(Minecraft.ID, "diamond_pickaxe", 1, 0, missing),
                "plateLapis");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 5, missing),
                "plateEnderEye",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 2, missing),
                "plateEnderEye",
                "gearIridium",
                getModItem(WirelessRedstoneCBELogic.ID, "wirelessLogic", 1, 0, missing),
                "gearIridium",
                "plateEnderEye",
                "plateNetherStar",
                "plateEnderEye");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 6, missing),
                "plateEnderEye",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 2, missing),
                "plateEnderEye",
                "gearIridium",
                getModItem(WirelessRedstoneCBECore.ID, "recieverDish", 1, 0, missing),
                "gearIridium",
                "plateEnderEye",
                "plateNetherStar",
                "plateEnderEye");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 7, missing),
                "plateRedAlloy",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0, missing),
                "plateRedAlloy",
                "craftingToolWrench",
                "gearDiamond",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0, missing),
                "plateRedAlloy",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0, missing),
                "plateRedAlloy");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 8, missing),
                "plateRedAlloy",
                "craftingToolWrench",
                "plateRedAlloy",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0, missing),
                "gearDiamond",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0, missing),
                "plateRedAlloy",
                null,
                "plateRedAlloy");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 8, missing),
                "plateRedAlloy",
                null,
                "plateRedAlloy",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0, missing),
                "gearDiamond",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0, missing),
                "plateRedAlloy",
                "craftingToolWrench",
                "plateRedAlloy");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 9, missing),
                "plateRedAlloy",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0, missing),
                "plateRedAlloy",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0, missing),
                "gearDiamond",
                "craftingToolWrench",
                "plateRedAlloy",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0, missing),
                "plateRedAlloy");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 3, missing),
                "plateRedAlloy",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0, missing),
                "plateRedAlloy",
                "craftingToolWrench",
                "gearDiamond",
                ItemList.Electric_Piston_MV.get(1L),
                "plateRedAlloy",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0, missing),
                "plateRedAlloy");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                null,
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                null,
                "stickWood",
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                "stickWood",
                null,
                null);
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "drum", 1, 0, missing),
                "plateSteel",
                "ringMeteoricSteel",
                "plateSteel",
                "plateSteel",
                "pipeHugeSteel",
                "plateSteel",
                "plateSteel",
                "ringMeteoricSteel",
                "plateSteel");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "drum", 1, 1, missing),
                "plateBedrockium",
                "ringTungstenSteel",
                "plateBedrockium",
                "plateBedrockium",
                getModItem(ExtraUtilities.ID, "drum", 1, 0, missing),
                "plateBedrockium",
                "plateBedrockium",
                "ringTungstenSteel",
                "plateBedrockium");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "conveyor", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(Minecraft.ID, "rail", 1, 0, missing),
                "craftingToolWrench",
                ItemList.Conveyor_Module_LV.get(1L),
                "frameGtSteel",
                ItemList.Conveyor_Module_LV.get(1L),
                "gearGtSmallSteel",
                ItemList.Electric_Motor_LV.get(1L),
                "gearGtSmallSteel");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "filing", 1, 0, missing),
                "plateSteel",
                "chestWood",
                "plateSteel",
                "screwSteel",
                getModItem(IronChests.ID, "BlockIronChest", 1, 0, missing),
                "screwSteel",
                "plateSteel",
                "chestWood",
                "plateSteel");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "filing", 1, 1, missing),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 8, missing),
                getModItem(ExtraUtilities.ID, "filing", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 8, missing),
                "screwSteel",
                getModItem(ExtraUtilities.ID, "filing", 1, 0, missing),
                "screwSteel",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 8, missing),
                getModItem(ExtraUtilities.ID, "filing", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 8, missing));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "watering_can", 1, 1, missing),
                "craftingToolHardHammer",
                "ringSteel",
                "craftingToolScrewdriver",
                "plateAnyIron",
                "plateAnyIron",
                "stickAnyIron",
                "plateAnyIron",
                "plateAnyIron",
                "screwSteel");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "watering_can", 1, 1, missing),
                "craftingToolScrewdriver",
                "ringSteel",
                "craftingToolHardHammer",
                "plateAnyIron",
                "plateAnyIron",
                "stickAnyIron",
                "plateAnyIron",
                "plateAnyIron",
                "screwSteel");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "watering_can", 1, 3, missing),
                "craftingToolHardHammer",
                "ringNeutronium",
                "craftingToolScrewdriver",
                "plateBedrockium",
                "plateBedrockium",
                "plateBedrockium",
                "plateBedrockium",
                "plateBedrockium",
                "screwNeutronium");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "watering_can", 1, 3, missing),
                "craftingToolScrewdriver",
                "ringNeutronium",
                "craftingToolHardHammer",
                "plateBedrockium",
                "plateBedrockium",
                "plateBedrockium",
                "plateBedrockium",
                "plateBedrockium",
                "screwNeutronium");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "sound_muffler", 1, 0, missing),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                getModItem(Minecraft.ID, "noteblock", 1, 0, missing),
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "budoff", 1, 0, missing),
                "blockWool");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "sound_muffler", 1, 1, missing),
                "blockWool",
                getModItem(ExtraUtilities.ID, "sound_muffler", 1, 0, missing),
                "blockWool",
                getModItem(ExtraUtilities.ID, "sound_muffler", 1, 0, missing),
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "sound_muffler", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "sound_muffler", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "budoff", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "sound_muffler", 1, 0, missing));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "pipes", 1, 0, missing),
                "foilSteel",
                "plateSteel",
                "foilSteel",
                "craftingToolWrench",
                "stickRedAlloy",
                "craftingToolHardHammer",
                "foilSteel",
                "plateSteel",
                "foilSteel");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "pipes", 1, 8, missing),
                "foilSteel",
                "circuitBasic",
                "foilSteel",
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, 0, missing),
                "craftingToolHardHammer",
                "foilSteel",
                "circuitBasic",
                "foilSteel");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "pipes", 1, 9, missing),
                "foilSteel",
                "circuitGood",
                "foilSteel",
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, 0, missing),
                "craftingToolHardHammer",
                "foilSteel",
                "circuitGood",
                "foilSteel");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "pipes", 1, 10, missing),
                "foilSteel",
                "circuitAdvanced",
                "foilSteel",
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, 8, missing),
                "craftingToolHardHammer",
                "foilSteel",
                "circuitAdvanced",
                "foilSteel");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "pipes.1", 1, 0, missing),
                "foilSteel",
                "circuitData",
                "foilSteel",
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, 10, missing),
                "craftingToolHardHammer",
                "foilSteel",
                "circuitData",
                "foilSteel");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "pipes", 1, 11, missing),
                "foilRedAlloy",
                "plateRedAlloy",
                "foilRedAlloy",
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, 0, missing),
                "craftingToolHardHammer",
                "foilRedAlloy",
                "plateRedAlloy",
                "foilRedAlloy");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "pipes", 1, 12, missing),
                "craftingToolHardHammer",
                getModItem(ExtraUtilities.ID, "pipes", 1, 0, missing),
                "screwSteel",
                getModItem(ExtraUtilities.ID, "pipes", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "pipes", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "pipes", 1, 0, missing),
                "screwSteel",
                getModItem(ExtraUtilities.ID, "pipes", 1, 0, missing),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "pipes", 1, 12, missing),
                "craftingToolScrewdriver",
                getModItem(ExtraUtilities.ID, "pipes", 1, 0, missing),
                "screwSteel",
                getModItem(ExtraUtilities.ID, "pipes", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "pipes", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "pipes", 1, 0, missing),
                "screwSteel",
                getModItem(ExtraUtilities.ID, "pipes", 1, 0, missing),
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "pipes", 1, 13, missing),
                "foilSteel",
                "circuitBasic",
                "foilSteel",
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, 8, missing),
                "craftingToolHardHammer",
                "foilSteel",
                "circuitBasic",
                "foilSteel");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "pipes", 1, 14, missing),
                "foilElectrum",
                "plateElectrum",
                "foilElectrum",
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, 11, missing),
                "craftingToolHardHammer",
                "foilElectrum",
                "plateElectrum",
                "foilElectrum");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "extractor_base_remote", 1, 0, missing),
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, wildcard, missing),
                "craftingToolHardHammer",
                "screwEnderPearl",
                ItemList.Conveyor_Module_LV.get(1L),
                "screwEnderPearl",
                getModItem(ExtraUtilities.ID, "extractor_base", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "extractor_base", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "extractor_base", 1, 0, missing));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "extractor_base_remote", 1, 6, missing),
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, wildcard, missing),
                "craftingToolHardHammer",
                "screwEnderPearl",
                ItemList.Electric_Pump_LV.get(1L),
                "screwEnderPearl",
                getModItem(ExtraUtilities.ID, "extractor_base", 1, 6, missing),
                getModItem(ExtraUtilities.ID, "extractor_base", 1, 6, missing),
                getModItem(ExtraUtilities.ID, "extractor_base", 1, 6, missing));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "extractor_base", 1, 0, missing),
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, wildcard, missing),
                "craftingToolHardHammer",
                "screwEnderPearl",
                ItemList.Conveyor_Module_LV.get(1L),
                "screwEnderPearl",
                GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1L),
                "pipeMediumBrass",
                GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1L));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "extractor_base", 1, 6, missing),
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, wildcard, missing),
                "craftingToolHardHammer",
                "screwEnderPearl",
                ItemList.Electric_Pump_LV.get(1L),
                "screwEnderPearl",
                GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L),
                ItemList.Electric_Pump_LV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "trashcan", 1, 0, missing),
                "plateIron",
                "craftingToolHardHammer",
                "plateIron",
                "plateIron",
                "gemEnderPearl",
                "plateIron",
                "plateIron",
                "plateIron",
                "plateIron");
        addShapelessRecipe(
                getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(ExtraUtilities.ID, "unstableingot", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "unstableingot", 1, 2, missing));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "chestMini", 1, 0, missing),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "craftingToolSaw",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "itemFlint",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                null,
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                null);
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderCollector", 1, 0, missing),
                "lensEnderPearl",
                "blockEnderObsidian",
                "lensEnderPearl",
                "craftingToolHardHammer",
                "blockEnderObsidian",
                "craftingToolWrench",
                "stoneObsidian",
                "stoneObsidian",
                "stoneObsidian");
        addShapelessRecipe(
                getModItem(ExtraUtilities.ID, "enderCollector", 1, 0, missing),
                getModItem(RandomThings.ID, "advancedItemCollector", 1, 0, missing));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "endConstructor", 1, 0, missing),
                "plateEnderEye",
                getModItem(HardcoreEnderExpansion.ID, "altar_nexus", 1, 0, missing),
                "plateEnderEye",
                "blockEnderObsidian",
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 2, missing),
                "blockEnderObsidian",
                "plateTitanium",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 12, missing),
                "plateTitanium");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "spike_base_wood", 2, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "wooden_sword", 1, 0, missing),
                "craftingToolScrewdriver",
                "screwWood",
                "plateWood",
                "screwWood",
                "plateWood",
                "logWood",
                "plateWood");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "spike_base", 2, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "iron_sword", 1, 0, missing),
                "craftingToolScrewdriver",
                "screwIron",
                "plateAnyIron",
                "screwIron",
                "plateAnyIron",
                "blockIron",
                "plateAnyIron");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "spike_base_gold", 2, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "golden_sword", 1, 0, missing),
                "craftingToolScrewdriver",
                "screwGold",
                "plateGold",
                "screwGold",
                "plateGold",
                "blockGold",
                "plateGold");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "spike_base_diamond", 2, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "diamond_sword", 1, 0, missing),
                "craftingToolScrewdriver",
                "screwDiamond",
                "plateDiamond",
                "screwDiamond",
                "plateDiamond",
                "blockDiamond",
                "plateDiamond");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "builderswand", 1, 0, missing),
                null,
                null,
                "ingotUnstable",
                null,
                "ingotUnstable",
                null,
                "stickObsidian",
                null,
                null);
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "creativebuilderswand", 1, 0, missing),
                null,
                "ingotUnstable",
                "ingotUnstable",
                null,
                "ingotUnstable",
                "ingotUnstable",
                "stickObsidian",
                null,
                null);
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "shears", 1, 0, missing),
                "ingotUnstable",
                null,
                "ingotUnstable",
                getModItem(ExtraUtilities.ID, "angelBlock", 1, 0, missing),
                getModItem(Minecraft.ID, "shears", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "angelBlock", 1, 0, missing));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "ethericsword", 1, 0, missing),
                null,
                "ingotUnstable",
                null,
                null,
                "ingotUnstable",
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1, missing),
                null);
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "lawSword", 1, 0, missing),
                null,
                getModItem(TinkerConstruct.ID, "largeSwordBlade", 1, 314, missing),
                null,
                null,
                "ingotUnstable",
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1, missing),
                null);
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "erosionShovel", 1, 0, missing),
                null,
                "ingotUnstable",
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1, missing),
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1, missing),
                null);
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "destructionpickaxe", 1, 0, missing),
                "ingotUnstable",
                "ingotUnstable",
                "ingotUnstable",
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1, missing),
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1, missing),
                null);
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "defoliageAxe", 1, 0, missing),
                "ingotUnstable",
                "ingotUnstable",
                null,
                "ingotUnstable",
                getModItem(RandomThings.ID, "ingredient", 1, 1, missing),
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1, missing),
                null);
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "temporalHoe", 1, 0, missing),
                "ingotUnstable",
                "ingotUnstable",
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1, missing),
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1, missing),
                null);

        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "unstableingot", 1, 0, missing),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing),
                null,
                null,
                new CustomItem.NBTItem(getModItem(ExtraUtilities.ID, "divisionSigil", 1, 0)).setNBT("{damage:256}")
                        .noValues(),
                null,
                null,
                getModItem(Minecraft.ID, "diamond", 1, 0, missing),
                null,
                null);
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "unstableingot", 1, 2, missing),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing),
                null,
                null,
                new CustomItem.NBTItem(getModItem(ExtraUtilities.ID, "divisionSigil", 1, 0)).setNBT("{stable:1b}"),
                null,
                null,
                getModItem(Minecraft.ID, "diamond", 1, 0, missing),
                null,
                null);

        // mods.extraUtils.QED.removeRecipe(<*>); // <- scripts
        EnderConstructorRecipesHandler.recipes.clear();

        TConstructHelper.removeTableRecipe(getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem(ExtraUtilities.ID, "block_bedrockium", 1, 0, missing));
        EnderConstructorRecipesHandler.registerRecipe(
                new ShapedOreRecipe(
                        getModItem(ExtraUtilities.ID, "enderQuarry", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "plateEuropium",
                        'b',
                        ItemList.Field_Generator_LuV.get(1L),
                        'c',
                        "plateEuropium",
                        'd',
                        getModItem(ExtraUtilities.ID, "enderThermicPump", 1, 0, missing),
                        'e',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 12, missing),
                        'f',
                        getModItem(ExtraUtilities.ID, "enderThermicPump", 1, 0, missing),
                        'g',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 11, missing),
                        'h',
                        ItemList.OreDrill2.get(1L),
                        'i',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 11, missing)));
        EnderConstructorRecipesHandler.registerRecipe(
                new ShapedOreRecipe(
                        getModItem(ExtraUtilities.ID, "enderThermicPump", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1, missing),
                        'b',
                        "circuitData",
                        'c',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1, missing),
                        'd',
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        'e',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 11, missing),
                        'f',
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        'g',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1, missing),
                        'h',
                        ItemList.Pump_HV.get(1L),
                        'i',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1, missing)));
        EnderConstructorRecipesHandler.registerRecipe(
                new ShapedOreRecipe(
                        getModItem(ExtraUtilities.ID, "magnumTorch", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(Minecraft.ID, "potion", 1, 8225, missing),
                        'b',
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                        'c',
                        getModItem(Minecraft.ID, "potion", 1, 8229, missing),
                        'd',
                        getModItem(ExtraUtilities.ID, "chandelier", 1, 0, missing),
                        'e',
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 1L),
                        'f',
                        getModItem(ExtraUtilities.ID, "chandelier", 1, 0, missing),
                        'g',
                        getModItem(ExtraUtilities.ID, "chandelier", 1, 0, missing),
                        'h',
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 1L),
                        'i',
                        getModItem(ExtraUtilities.ID, "chandelier", 1, 0, missing)));
        EnderConstructorRecipesHandler.registerRecipe(
                new ShapedOreRecipe(
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 12, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 0, missing),
                        'b',
                        getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerdiamond", 1, 0, missing),
                        'c',
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 0, missing),
                        'd',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1L),
                        'e',
                        getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 8, missing),
                        'f',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1L),
                        'g',
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 0, missing),
                        'h',
                        getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerdiamond", 1, 0, missing),
                        'i',
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 0, missing)));
        EnderConstructorRecipesHandler.registerRecipe(
                new ShapedOreRecipe(
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 13, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 12, missing),
                        'b',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1L),
                        'c',
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 12, missing),
                        'd',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1L),
                        'e',
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Bedrockium, 1L),
                        'f',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1L),
                        'g',
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 12, missing),
                        'h',
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 12, missing),
                        'i',
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 12, missing)));
        EnderConstructorRecipesHandler.registerRecipe(
                new ShapedOreRecipe(
                        GregtechItemList.InvertedObsidian.get(1),
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
                        "dustRedstone"));
        EnderConstructorRecipesHandler.registerRecipe(
                new ShapedOreRecipe(
                        getModItem(ExtraUtilities.ID, "endMarker", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'b',
                        getModItem(Minecraft.ID, "ender_eye", 1, 0, missing),
                        'e',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1, missing),
                        'h',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1, missing)));

        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "cobblestone", 9, 0, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 1, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 0, missing))
                .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 2, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 1, missing))
                .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 3, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 2, missing))
                .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 4, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 3, missing))
                .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 5, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 4, missing))
                .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 6, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 5, missing))
                .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 7, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 6, missing))
                .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 8, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dirt", 9, 0, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 9, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 8, missing))
                .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 10, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 9, missing))
                .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 11, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 10, missing))
                .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 12, missing))
                .itemOutputs(getModItem(Minecraft.ID, "gravel", 9, 0, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 13, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 12, missing))
                .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 14, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sand", 9, 0, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 15, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 14, missing))
                .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "quartz_block", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 1L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 2, missing)).duration(4 * SECONDS)
                .eut(64).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 4L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 5, missing)).duration(10 * SECONDS)
                .eut(8).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 4, missing)).duration(10 * SECONDS)
                .eut(8).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0, missing),
                        getModItem(Minecraft.ID, "gunpowder", 1, 0, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 3, missing)).duration(10 * SECONDS)
                .eut(8).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 4L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 7, missing)).duration(20 * SECONDS)
                .eut(16).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0, missing),
                        getModItem(Minecraft.ID, "dye", 1, 9, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 8, missing)).duration(10 * SECONDS)
                .eut(8).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "cobblestone_compressed", 4, 3, missing),
                        getModItem(Minecraft.ID, "diamond_block", 1, 0, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1, 0, missing)).duration(30 * SECONDS)
                .eut(256).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 1, missing)).duration(5 * SECONDS)
                .eut(8).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0, missing),
                        GTUtility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 2, missing)).duration(5 * SECONDS)
                .eut(8).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0, missing),
                        GTUtility.getIntegratedCircuit(5))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 6, missing)).duration(5 * SECONDS)
                .eut(8).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0, missing),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 9, missing)).duration(5 * SECONDS)
                .eut(8).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "curtains", 1, 0, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 10, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 10, missing),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 4L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 11, missing)).duration(20 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "flint", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 2L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "chestMini", 1, 0, missing))
                .duration(2 * SECONDS + 10 * TICKS).eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 4, 2, missing),
                        getModItem(IndustrialCraft2.ID, "itemDensePlates", 4, 7, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 500)).duration(30 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 4, 1, missing),
                        getModItem(Minecraft.ID, "ender_eye", 3, 0, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "endConstructor", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).duration(20 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Railcraft.ID, "detector", 1, 2, missing),
                        getModItem(Minecraft.ID, "sticky_piston", 1, 0, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "budoff", 1, 0, missing)).duration(10 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "budoff", 1, 0, missing),
                        getModItem(Minecraft.ID, "redstone_block", 4, 0, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "budoff", 1, 3, missing)).duration(10 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 5, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.gemFlawed, Materials.Diamond, 1L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "chandelier", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 1440)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stone", 4, 0, missing),
                        getModItem(Minecraft.ID, "stonebrick", 5, 0, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 9, 0, missing)).duration(9 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 0, missing),
                        GTUtility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 4, missing)).duration(20).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 4, missing),
                        GTUtility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 7, missing)).duration(20).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "gravel", 1, 0, missing), GTUtility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 6, missing)).duration(20).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stone", 1, 0, missing),
                        getModItem(Minecraft.ID, "ice", 4, 0, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 4, 3, missing)).duration(4 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "sand", 1, 0, missing),
                        getModItem(Minecraft.ID, "glass", 1, 0, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 2, 9, missing)).duration(2 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "sandstone", 1, 0, missing),
                        getModItem(Minecraft.ID, "end_stone", 1, 0, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 2, 13, missing)).duration(2 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 5, 6, missing),
                        getModItem(Minecraft.ID, "stone_slab", 5, 5, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 5, 10, missing)).duration(5 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 4, 1, missing),
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 4, 8, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 11, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).duration(1 * MINUTES).eut(120)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Railcraft.ID, "machine.alpha", 1, 6, missing), ItemList.Plank_Oak.get(4L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "trading_post", 1, 0, missing)).duration(15 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redalloy", 36)).duration(5 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "pipes", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1))
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes", 1, 8, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(ExtraUtilities.ID, "pipes", 1, 0, missing), GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes", 1, 11, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redalloy", 216)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(ExtraUtilities.ID, "pipes", 4, 0, missing), GTUtility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes", 1, 12, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "pipes", 1, 8, missing),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1))
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes", 1, 13, missing)).duration(15 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "pipes", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1))
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes", 1, 9, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "pipes", 1, 8, missing),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1))
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes", 1, 10, missing)).duration(15 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Electrum, 2L),
                        getModItem(ExtraUtilities.ID, "pipes", 1, 11, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes", 1, 14, missing)).duration(15 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(ExtraUtilities.ID, "pipes", 1, 10, missing), ItemList.Tool_DataStick.get(1L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes.1", 1, 0, missing)).duration(20 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "pipes", 1, 10, missing),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 1))
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes.1", 1, 0, missing)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                        getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "trashcan", 1, 0, missing)).duration(10 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "trashcan", 1, 0, missing),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "trashcan", 1, 1, missing)).duration(10 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "trashcan", 1, 0, missing),
                        getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowergold", 1, 0, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "trashcan", 1, 2, missing)).duration(10 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 2, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Iron, 4L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "heatingElement", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).duration(20 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 2, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Iron, 4L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "heatingElement", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 288)).duration(20 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 2, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Iron, 4L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "heatingElement", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).duration(20 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "golden_lasso", 1, 0, missing)).duration(10 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Tool_Scanner.get(1L), getModItem(Minecraft.ID, "ender_eye", 1, 0, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "scanner", 1, 0, missing)).duration(30 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(GTUtility.getIntegratedCircuit(9), getModItem(Minecraft.ID, "cobblestone", 9, 0, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 0, missing))
                .duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "dirt", 9, 0, missing), GTUtility.getIntegratedCircuit(9))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 8, missing))
                .duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "gravel", 9, 0, missing), GTUtility.getIntegratedCircuit(9))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 12, missing))
                .duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "sand", 9, 0, missing), GTUtility.getIntegratedCircuit(9))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 14, missing))
                .duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);

        TCHelper.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem(ExtraUtilities.ID, "angelRing", 1, 0, missing),
                30,
                new AspectList().add(Aspect.getAspect("praecantatio"), 200).add(Aspect.getAspect("volatus"), 200)
                        .add(Aspect.getAspect("tempestas"), 200).add(Aspect.getAspect("nebrisum"), 200)
                        .add(Aspect.getAspect("motus"), 200).add(Aspect.getAspect("terminus"), 200),
                createItemStack(
                        TinkerConstruct.ID,
                        "travelWings",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:2.0d,Built:1b,MaxDefense:8.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}",
                        missing),
                OrePrefixes.ring.get(Materials.Iridium),
                OrePrefixes.screw.get(Materials.Tritanium),
                NHItemList.EngravedGoldChip.getIS(1),
                getModItem(ExtraUtilities.ID, "angelBlock", 1, 0, missing),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15, missing),
                GregtechItemList.MagicFeather.get(1),
                getModItem(Minecraft.ID, "nether_star", 1, 0, missing),
                getModItem(Avaritia.ID, "big_pearl", 1, 0, missing),
                getModItem(Minecraft.ID, "nether_star", 1, 0, missing),
                GregtechItemList.MagicFeather.get(1),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15, missing),
                getModItem(ExtraUtilities.ID, "angelBlock", 1, 0, missing),
                NHItemList.EngravedGoldChip.getIS(1),
                OrePrefixes.screw.get(Materials.Tritanium));
        TCHelper.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem(ExtraUtilities.ID, "angelRing", 1, 1, missing),
                4,
                new AspectList().add(Aspect.getAspect("permutatio"), 50).add(Aspect.getAspect("volatus"), 50)
                        .add(Aspect.getAspect("aer"), 50),
                getModItem(ExtraUtilities.ID, "angelRing", 1, 0, missing),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                getModItem(TinkerConstruct.ID, "fletching", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "fletching", 1, 0, missing));
        TCHelper.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem(ExtraUtilities.ID, "angelRing", 1, 2, missing),
                4,
                new AspectList().add(Aspect.getAspect("permutatio"), 50).add(Aspect.getAspect("volatus"), 50)
                        .add(Aspect.getAspect("auram"), 50),
                getModItem(ExtraUtilities.ID, "angelRing", 1, 0, missing),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                getModItem(TwilightForest.ID, "tile.TFCicada", 1, 0, missing),
                getModItem(TwilightForest.ID, "tile.TFFirefly", 1, 0, missing));
        TCHelper.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem(ExtraUtilities.ID, "angelRing", 1, 3, missing),
                4,
                new AspectList().add(Aspect.getAspect("permutatio"), 50).add(Aspect.getAspect("bestia"), 50)
                        .add(Aspect.getAspect("infernus"), 50),
                getModItem(ExtraUtilities.ID, "angelRing", 1, 0, missing),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                getModItem(Minecraft.ID, "dragon_egg", 1, 0, missing),
                getModItem(Botania.ID, "manaResource", 1, 9, missing));
        TCHelper.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem(ExtraUtilities.ID, "angelRing", 1, 4, missing),
                4,
                new AspectList().add(Aspect.getAspect("permutatio"), 50).add(Aspect.getAspect("metallum"), 50)
                        .add(Aspect.getAspect("lucrum"), 50),
                getModItem(ExtraUtilities.ID, "angelRing", 1, 0, missing),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                OrePrefixes.foil.get(Materials.RoseGold),
                OrePrefixes.foil.get(Materials.RoseGold));
        new ResearchItem(
                "EXURINGS",
                "ARTIFICE",
                new AspectList().add(Aspect.getAspect("praecantatio"), 10).add(Aspect.getAspect("volatus"), 10)
                        .add(Aspect.getAspect("tempestas"), 100).add(Aspect.getAspect("nebrisum"), 10)
                        .add(Aspect.getAspect("motus"), 10).add(Aspect.getAspect("terminus"), 10),
                1,
                -5,
                3,
                getModItem(TinkerConstruct.ID, "travelWings", 1, 0, missing)).setRound().setConcealed()
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
                getModItem(ExtraUtilities.ID, "angelRing", 1, 0, missing)).setParents("EXURINGS").setConcealed()
                        .registerResearchItem();
        ThaumcraftApi.addWarpToResearch("EXURINGS_CRAFTING", 16);
        TCHelper.addResearchPage("EXURINGS_CRAFTING", new ResearchPage("tc.research_page.EXURINGS_CRAFTING.1"));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ExtraUtilities.ID, "angelRing", 1, 0, missing))));
        TCHelper.addResearchPage("EXURINGS_CRAFTING", new ResearchPage("tc.research_page.EXURINGS_CRAFTING.2"));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ExtraUtilities.ID, "angelRing", 1, 1, missing))));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ExtraUtilities.ID, "angelRing", 1, 2, missing))));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ExtraUtilities.ID, "angelRing", 1, 3, missing))));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ExtraUtilities.ID, "angelRing", 1, 4, missing))));
    }

    private static class FilterRecipe extends ShapelessOreRecipe {

        private final Map<String, NBTBase> NBTToUpdate;

        public FilterRecipe(ItemStack result, Map<String, NBTBase> NBTToUpdate, Object recipeModifier) {
            super(result, result, recipeModifier);
            this.NBTToUpdate = NBTToUpdate;
        }

        @Override
        public ItemStack getRecipeOutput() {
            ItemStack stack = super.getRecipeOutput();
            if (stack.stackTagCompound == null && !NBTToUpdate.isEmpty()) {
                for (Map.Entry<String, NBTBase> entry : NBTToUpdate.entrySet())
                    stack.setTagInfo(entry.getKey(), entry.getValue());
            }
            return stack;
        }

        @Override
        public ItemStack getCraftingResult(InventoryCrafting crafting) {
            ItemStack result = super.getCraftingResult(crafting);
            for (int i = 0, imax = crafting.getSizeInventory(); i < imax; i++) {
                ItemStack stack = crafting.getStackInSlot(i);
                if (stack != null && stack.isItemEqual(result)) {
                    result.stackTagCompound = stack.stackTagCompound;
                    for (Map.Entry<String, NBTBase> entry : NBTToUpdate.entrySet())
                        result.setTagInfo(entry.getKey(), entry.getValue());
                    break;
                }
            }
            return result;
        }
    }
}
