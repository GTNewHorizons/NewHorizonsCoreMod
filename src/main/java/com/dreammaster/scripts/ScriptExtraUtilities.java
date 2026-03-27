package com.dreammaster.scripts;

import static com.dreammaster.item.NHItemList.EngravedGoldChip;
import static com.dreammaster.scripts.IngredientFactory.createItemStack;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Materials.Iridium;
import static gregtech.api.enums.Materials.Tritanium;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.BuildCraftTransport;
import static gregtech.api.enums.Mods.ExtraUtilities;
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
import static gregtech.api.enums.OrePrefixes.ring;
import static gregtech.api.enums.OrePrefixes.screw;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList.MagicFeather;
import static thaumcraft.api.aspects.Aspect.getAspect;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.dreammaster.block.BlockList;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByte;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

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
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
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
                Avaritia.ID,
                Botania.ID,
                BuildCraftFactory.ID,
                BuildCraftTransport.ID,
                ExtraUtilities.ID,
                HardcoreEnderExpansion.ID,
                IndustrialCraft2.ID,
                IronChests.ID,
                PamsHarvestCraft.ID,
                ProjectRedIllumination.ID,
                Railcraft.ID,
                RandomThings.ID,
                Thaumcraft.ID,
                TinkerConstruct.ID,
                TwilightForest.ID,
                WirelessRedstoneCBECore.ID,
                WirelessRedstoneCBELogic.ID);
    }

    @Override
    public void loadRecipes() {

        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 12),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 11),
                "plateDiamond",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 11),
                "plateTitanium",
                "circuitData",
                "plateTitanium",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 11),
                "plateDiamond",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 11));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "curtains", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 15),
                getModItem(Minecraft.ID, "carpet", 1, 15),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 15),
                getModItem(Minecraft.ID, "carpet", 1, 15),
                null,
                getModItem(Minecraft.ID, "carpet", 1, 15),
                getModItem(Minecraft.ID, "carpet", 1, 15),
                null);
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "timer", 1, 0),
                "plateRedAlloy",
                "gearWood",
                "plateRedAlloy",
                "gearWood",
                getModItem(Minecraft.ID, "clock", 1, 0),
                "gearWood",
                "plateRedAlloy",
                "stickRedAlloy",
                "plateRedAlloy");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1),
                "plateStainlessSteel",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1),
                "plateStainlessSteel",
                "gemEnderEye",
                "plateStainlessSteel",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1),
                "plateStainlessSteel",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 1),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0),
                getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 4),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0),
                getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 11),
                "gearDiamond",
                getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 11),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0),
                getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 4),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 2),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0),
                getModItem(TinkerConstruct.ID, "materials", 1, 26),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0),
                "plateTitanium",
                "gearDiamond",
                "plateTitanium",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0),
                getModItem(TinkerConstruct.ID, "materials", 1, 26),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 3),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0),
                "plateTitanium",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0),
                "plateTitanium",
                "gearDiamond",
                "plateTitanium",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0),
                "plateTitanium",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 4),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0),
                "plateTungstenSteel",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0),
                "plateTungstenSteel",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 3),
                "plateTungstenSteel",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0),
                "plateTungstenSteel",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 5),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0),
                "plateChrome",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0),
                "plateChrome",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 4),
                "plateChrome",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0),
                "plateChrome",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 6),
                ItemList.AcceleratorHV.get(1),
                "gearTitanium",
                ItemList.AcceleratorHV.get(1),
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0),
                "gearDiamond",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0),
                ItemList.AcceleratorHV.get(1),
                "gearTitanium",
                ItemList.AcceleratorHV.get(1));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 7),
                ItemList.AcceleratorEV.get(1),
                "gearTungstenSteel",
                ItemList.AcceleratorEV.get(1),
                "gearTungstenSteel",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 6),
                "gearTungstenSteel",
                ItemList.AcceleratorEV.get(1),
                "gearTungstenSteel",
                ItemList.AcceleratorEV.get(1));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 8),
                ItemList.AcceleratorIV.get(1),
                "gearChrome",
                ItemList.AcceleratorIV.get(1),
                "gearChrome",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 7),
                "gearChrome",
                ItemList.AcceleratorIV.get(1),
                "gearChrome",
                ItemList.AcceleratorIV.get(1));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 9),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0),
                getModItem(ExtraUtilities.ID, "enderThermicPump", 1, 0),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0),
                "pipeLargeTungstenSteel",
                "pipeSmallStainlessSteel",
                "pipeLargeTungstenSteel",
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0),
                getModItem(ExtraUtilities.ID, "enderThermicPump", 1, 0),
                getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0),
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
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 1),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                "gearStainlessSteel",
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                "plateRedAlloy");
        addShapelessRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 1),
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 1));
        GameRegistry.addRecipe(
                new FilterRecipe(
                        getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 1),
                        Collections.singletonMap("Inverted", new NBTTagByte((byte) 1)),
                        "craftingRedstoneTorch"));
        GameRegistry.addRecipe(
                new FilterRecipe(
                        getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 1),
                        Collections.singletonMap("FuzzyNBT", new NBTTagByte((byte) 1)),
                        "blockWool"));
        GameRegistry.addRecipe(
                new FilterRecipe(
                        getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 1),
                        Collections.singletonMap("FuzzyMeta", new NBTTagByte((byte) 1)),
                        "stickWood"));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 10),
                "plateLapis",
                BlockList.SteelBars.get(),
                "plateLapis",
                BlockList.SteelBars.get(),
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 1),
                BlockList.SteelBars.get(),
                "plateLapis",
                BlockList.SteelBars.get(),
                "plateLapis");
        addShapelessRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 10),
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 10));
        GameRegistry.addRecipe(
                new FilterRecipe(
                        getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 10),
                        Collections.singletonMap("Inverted", new NBTTagByte((byte) 1)),
                        "craftingRedstoneTorch"));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 2),
                "plateLapis",
                getModItem(Minecraft.ID, "diamond_pickaxe", 1, 0),
                "plateLapis",
                getModItem(Minecraft.ID, "iron_pickaxe", 1, 0),
                "gearDiamond",
                getModItem(Minecraft.ID, "iron_pickaxe", 1, 0),
                "plateLapis",
                getModItem(Minecraft.ID, "diamond_pickaxe", 1, 0),
                "plateLapis");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 5),
                "plateEnderEye",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 2),
                "plateEnderEye",
                "gearIridium",
                getModItem(WirelessRedstoneCBELogic.ID, "wirelessLogic", 1, 0),
                "gearIridium",
                "plateEnderEye",
                "plateNetherStar",
                "plateEnderEye");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 6),
                "plateEnderEye",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 2),
                "plateEnderEye",
                "gearIridium",
                getModItem(WirelessRedstoneCBECore.ID, "recieverDish", 1, 0),
                "gearIridium",
                "plateEnderEye",
                "plateNetherStar",
                "plateEnderEye");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 7),
                "plateRedAlloy",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0),
                "plateRedAlloy",
                "craftingToolWrench",
                "gearDiamond",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0),
                "plateRedAlloy",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0),
                "plateRedAlloy");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 8),
                "plateRedAlloy",
                "craftingToolWrench",
                "plateRedAlloy",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0),
                "gearDiamond",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0),
                "plateRedAlloy",
                null,
                "plateRedAlloy");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 8),
                "plateRedAlloy",
                null,
                "plateRedAlloy",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0),
                "gearDiamond",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0),
                "plateRedAlloy",
                "craftingToolWrench",
                "plateRedAlloy");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 9),
                "plateRedAlloy",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0),
                "plateRedAlloy",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0),
                "gearDiamond",
                "craftingToolWrench",
                "plateRedAlloy",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0),
                "plateRedAlloy");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 3),
                "plateRedAlloy",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0),
                "plateRedAlloy",
                "craftingToolWrench",
                "gearDiamond",
                ItemList.Electric_Piston_MV.get(1L),
                "plateRedAlloy",
                getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0),
                "plateRedAlloy");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                null,
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0),
                null,
                "stickWood",
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0),
                "stickWood",
                null,
                null);
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "drum", 1, 0),
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
                getModItem(ExtraUtilities.ID, "drum", 1, 1),
                "plateBedrockium",
                "ringTungstenSteel",
                "plateBedrockium",
                "plateBedrockium",
                getModItem(ExtraUtilities.ID, "drum", 1, 0),
                "plateBedrockium",
                "plateBedrockium",
                "ringTungstenSteel",
                "plateBedrockium");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "conveyor", 1, 0),
                "craftingToolHardHammer",
                getModItem(Minecraft.ID, "rail", 1, 0),
                "craftingToolWrench",
                ItemList.Conveyor_Module_LV.get(1L),
                "frameGtSteel",
                ItemList.Conveyor_Module_LV.get(1L),
                "gearGtSmallSteel",
                ItemList.Electric_Motor_LV.get(1L),
                "gearGtSmallSteel");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "filing", 1, 0),
                "plateSteel",
                "chestWood",
                "plateSteel",
                "screwSteel",
                getModItem(IronChests.ID, "BlockIronChest", 1, 0),
                "screwSteel",
                "plateSteel",
                "chestWood",
                "plateSteel");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "filing", 1, 1),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 8),
                getModItem(ExtraUtilities.ID, "filing", 1, 0),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 8),
                "screwSteel",
                getModItem(ExtraUtilities.ID, "filing", 1, 0),
                "screwSteel",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 8),
                getModItem(ExtraUtilities.ID, "filing", 1, 0),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 8));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "watering_can", 1, 1),
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
                getModItem(ExtraUtilities.ID, "watering_can", 1, 1),
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
                getModItem(ExtraUtilities.ID, "watering_can", 1, 3),
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
                getModItem(ExtraUtilities.ID, "watering_can", 1, 3),
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
                getModItem(ExtraUtilities.ID, "sound_muffler", 1, 0),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                getModItem(Minecraft.ID, "noteblock", 1, 0),
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "budoff", 1, 0),
                "blockWool");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "sound_muffler", 1, 1),
                "blockWool",
                getModItem(ExtraUtilities.ID, "sound_muffler", 1, 0),
                "blockWool",
                getModItem(ExtraUtilities.ID, "sound_muffler", 1, 0),
                getModItem(Minecraft.ID, "water_bucket", 1, 0),
                getModItem(ExtraUtilities.ID, "sound_muffler", 1, 0),
                getModItem(ExtraUtilities.ID, "sound_muffler", 1, 0),
                getModItem(ExtraUtilities.ID, "budoff", 1, 0),
                getModItem(ExtraUtilities.ID, "sound_muffler", 1, 0));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "pipes", 1, 0),
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
                getModItem(ExtraUtilities.ID, "pipes", 1, 8),
                "foilSteel",
                "circuitBasic",
                "foilSteel",
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, 0),
                "craftingToolHardHammer",
                "foilSteel",
                "circuitBasic",
                "foilSteel");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "pipes", 1, 9),
                "foilSteel",
                "circuitGood",
                "foilSteel",
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, 0),
                "craftingToolHardHammer",
                "foilSteel",
                "circuitGood",
                "foilSteel");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "pipes", 1, 10),
                "foilSteel",
                "circuitAdvanced",
                "foilSteel",
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, 8),
                "craftingToolHardHammer",
                "foilSteel",
                "circuitAdvanced",
                "foilSteel");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "pipes.1", 1, 0),
                "foilSteel",
                "circuitData",
                "foilSteel",
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, 10),
                "craftingToolHardHammer",
                "foilSteel",
                "circuitData",
                "foilSteel");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "pipes", 1, 11),
                "foilRedAlloy",
                "plateRedAlloy",
                "foilRedAlloy",
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, 0),
                "craftingToolHardHammer",
                "foilRedAlloy",
                "plateRedAlloy",
                "foilRedAlloy");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "pipes", 1, 12),
                "craftingToolHardHammer",
                getModItem(ExtraUtilities.ID, "pipes", 1, 0),
                "screwSteel",
                getModItem(ExtraUtilities.ID, "pipes", 1, 0),
                getModItem(ExtraUtilities.ID, "pipes", 1, 0),
                getModItem(ExtraUtilities.ID, "pipes", 1, 0),
                "screwSteel",
                getModItem(ExtraUtilities.ID, "pipes", 1, 0),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "pipes", 1, 12),
                "craftingToolScrewdriver",
                getModItem(ExtraUtilities.ID, "pipes", 1, 0),
                "screwSteel",
                getModItem(ExtraUtilities.ID, "pipes", 1, 0),
                getModItem(ExtraUtilities.ID, "pipes", 1, 0),
                getModItem(ExtraUtilities.ID, "pipes", 1, 0),
                "screwSteel",
                getModItem(ExtraUtilities.ID, "pipes", 1, 0),
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "pipes", 1, 13),
                "foilSteel",
                "circuitBasic",
                "foilSteel",
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, 8),
                "craftingToolHardHammer",
                "foilSteel",
                "circuitBasic",
                "foilSteel");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "pipes", 1, 14),
                "foilElectrum",
                "plateElectrum",
                "foilElectrum",
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, 11),
                "craftingToolHardHammer",
                "foilElectrum",
                "plateElectrum",
                "foilElectrum");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "extractor_base_remote", 1, 0),
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, wildcard),
                "craftingToolHardHammer",
                "screwEnderPearl",
                ItemList.Conveyor_Module_LV.get(1L),
                "screwEnderPearl",
                getModItem(ExtraUtilities.ID, "extractor_base", 1, 0),
                getModItem(ExtraUtilities.ID, "extractor_base", 1, 0),
                getModItem(ExtraUtilities.ID, "extractor_base", 1, 0));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "extractor_base_remote", 1, 6),
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, wildcard),
                "craftingToolHardHammer",
                "screwEnderPearl",
                ItemList.Electric_Pump_LV.get(1L),
                "screwEnderPearl",
                getModItem(ExtraUtilities.ID, "extractor_base", 1, 6),
                getModItem(ExtraUtilities.ID, "extractor_base", 1, 6),
                getModItem(ExtraUtilities.ID, "extractor_base", 1, 6));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "extractor_base", 1, 0),
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, wildcard),
                "craftingToolHardHammer",
                "screwEnderPearl",
                ItemList.Conveyor_Module_LV.get(1L),
                "screwEnderPearl",
                GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1L),
                "pipeMediumBrass",
                GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1L));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "extractor_base", 1, 6),
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "pipes", 1, wildcard),
                "craftingToolHardHammer",
                "screwEnderPearl",
                ItemList.Electric_Pump_LV.get(1L),
                "screwEnderPearl",
                GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L),
                ItemList.Electric_Pump_LV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "trashcan", 1, 0),
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
                getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        addShapelessRecipe(
                getModItem(ExtraUtilities.ID, "unstableingot", 1, 0),
                getModItem(ExtraUtilities.ID, "unstableingot", 1, 2));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "chestMini", 1, 0),
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
                getModItem(ExtraUtilities.ID, "enderCollector", 1, 0),
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
                getModItem(ExtraUtilities.ID, "enderCollector", 1, 0),
                getModItem(RandomThings.ID, "advancedItemCollector", 1, 0));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "endConstructor", 1, 0),
                "plateEnderEye",
                getModItem(HardcoreEnderExpansion.ID, "altar_nexus", 1, 0),
                "plateEnderEye",
                "blockEnderObsidian",
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 2),
                "blockEnderObsidian",
                "plateTitanium",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 12),
                "plateTitanium");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "spike_base_wood", 2, 0),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "wooden_sword", 1, 0),
                "craftingToolScrewdriver",
                "screwWood",
                "plateWood",
                "screwWood",
                "plateWood",
                "logWood",
                "plateWood");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "spike_base", 2, 0),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "iron_sword", 1, 0),
                "craftingToolScrewdriver",
                "screwIron",
                "plateAnyIron",
                "screwIron",
                "plateAnyIron",
                "blockIron",
                "plateAnyIron");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "spike_base_gold", 2, 0),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "golden_sword", 1, 0),
                "craftingToolScrewdriver",
                "screwGold",
                "plateGold",
                "screwGold",
                "plateGold",
                "blockGold",
                "plateGold");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "spike_base_diamond", 2, 0),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "diamond_sword", 1, 0),
                "craftingToolScrewdriver",
                "screwDiamond",
                "plateDiamond",
                "screwDiamond",
                "plateDiamond",
                "blockDiamond",
                "plateDiamond");
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "builderswand", 1, 0),
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
                getModItem(ExtraUtilities.ID, "creativebuilderswand", 1, 0),
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
                getModItem(ExtraUtilities.ID, "shears", 1, 0),
                "ingotUnstable",
                null,
                "ingotUnstable",
                getModItem(ExtraUtilities.ID, "angelBlock", 1, 0),
                getModItem(Minecraft.ID, "shears", 1, 0),
                getModItem(ExtraUtilities.ID, "angelBlock", 1, 0));
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "ethericsword", 1, 0),
                null,
                "ingotUnstable",
                null,
                null,
                "ingotUnstable",
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null);
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "lawSword", 1, 0),
                null,
                getModItem(TinkerConstruct.ID, "largeSwordBlade", 1, 314),
                null,
                null,
                "ingotUnstable",
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null);
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "erosionShovel", 1, 0),
                null,
                "ingotUnstable",
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null);
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "destructionpickaxe", 1, 0),
                "ingotUnstable",
                "ingotUnstable",
                "ingotUnstable",
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null);
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "defoliageAxe", 1, 0),
                "ingotUnstable",
                "ingotUnstable",
                null,
                "ingotUnstable",
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null);
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "temporalHoe", 1, 0),
                "ingotUnstable",
                "ingotUnstable",
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null);

        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "unstableingot", 1, 0),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0),
                null,
                null,
                new CustomItem.NBTItem(getModItem(ExtraUtilities.ID, "divisionSigil", 1, 0)).setNBT("{damage:256}")
                        .noValues(),
                null,
                null,
                getModItem(Minecraft.ID, "diamond", 1, 0),
                null,
                null);
        addShapedRecipe(
                getModItem(ExtraUtilities.ID, "unstableingot", 1, 2),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0),
                null,
                null,
                new CustomItem.NBTItem(getModItem(ExtraUtilities.ID, "divisionSigil", 1, 0)).setNBT("{stable:1b}"),
                null,
                null,
                getModItem(Minecraft.ID, "diamond", 1, 0),
                null,
                null);

        // mods.extraUtils.QED.removeRecipe(<*>); // <- scripts
        EnderConstructorRecipesHandler.recipes.clear();

        TConstructHelper.removeTableRecipe(getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1, 0));
        TConstructHelper.removeBasinRecipe(getModItem(ExtraUtilities.ID, "block_bedrockium", 1, 0));
        EnderConstructorRecipesHandler.registerRecipe(
                new ShapedOreRecipe(
                        getModItem(ExtraUtilities.ID, "enderQuarry", 1, 0),
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
                        getModItem(ExtraUtilities.ID, "enderThermicPump", 1, 0),
                        'e',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 12),
                        'f',
                        getModItem(ExtraUtilities.ID, "enderThermicPump", 1, 0),
                        'g',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 11),
                        'h',
                        ItemList.OreDrill2.get(1L),
                        'i',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 11)));
        EnderConstructorRecipesHandler.registerRecipe(
                new ShapedOreRecipe(
                        getModItem(ExtraUtilities.ID, "enderThermicPump", 1, 0),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1),
                        'b',
                        "circuitData",
                        'c',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1),
                        'd',
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                        'e',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 11),
                        'f',
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                        'g',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1),
                        'h',
                        ItemList.Pump_HV.get(1L),
                        'i',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1)));
        EnderConstructorRecipesHandler.registerRecipe(
                new ShapedOreRecipe(
                        getModItem(ExtraUtilities.ID, "magnumTorch", 1, 0),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(Minecraft.ID, "potion", 1, 8225),
                        'b',
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                        'c',
                        getModItem(Minecraft.ID, "potion", 1, 8229),
                        'd',
                        getModItem(ExtraUtilities.ID, "chandelier", 1, 0),
                        'e',
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 1L),
                        'f',
                        getModItem(ExtraUtilities.ID, "chandelier", 1, 0),
                        'g',
                        getModItem(ExtraUtilities.ID, "chandelier", 1, 0),
                        'h',
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 1L),
                        'i',
                        getModItem(ExtraUtilities.ID, "chandelier", 1, 0)));
        EnderConstructorRecipesHandler.registerRecipe(
                new ShapedOreRecipe(
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 12),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 0),
                        'b',
                        getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerdiamond", 1, 0),
                        'c',
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 0),
                        'd',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1L),
                        'e',
                        getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 8),
                        'f',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1L),
                        'g',
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 0),
                        'h',
                        getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerdiamond", 1, 0),
                        'i',
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 0)));
        EnderConstructorRecipesHandler.registerRecipe(
                new ShapedOreRecipe(
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 13),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 12),
                        'b',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1L),
                        'c',
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 12),
                        'd',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1L),
                        'e',
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Bedrockium, 1L),
                        'f',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1L),
                        'g',
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 12),
                        'h',
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 12),
                        'i',
                        getModItem(ExtraUtilities.ID, "extractor_base", 1, 12)));
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
                        getModItem(ExtraUtilities.ID, "endMarker", 1, 0),
                        "abc",
                        "def",
                        "ghi",
                        'b',
                        getModItem(Minecraft.ID, "ender_eye", 1, 0),
                        'e',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1),
                        'h',
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1)));

        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 0))
                .itemOutputs(getModItem(Minecraft.ID, "cobblestone", 9, 0)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 1))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 0)).duration(15 * SECONDS)
                .eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 2))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 1)).duration(15 * SECONDS)
                .eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 3))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 2)).duration(15 * SECONDS)
                .eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 4))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 3)).duration(15 * SECONDS)
                .eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 5))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 4)).duration(15 * SECONDS)
                .eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 6))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 5)).duration(15 * SECONDS)
                .eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 7))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 6)).duration(15 * SECONDS)
                .eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 8))
                .itemOutputs(getModItem(Minecraft.ID, "dirt", 9, 0)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 9))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 8)).duration(15 * SECONDS)
                .eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 10))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 9)).duration(15 * SECONDS)
                .eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 11))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 10)).duration(15 * SECONDS)
                .eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 12))
                .itemOutputs(getModItem(Minecraft.ID, "gravel", 9, 0)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 13))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 12)).duration(15 * SECONDS)
                .eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 14))
                .itemOutputs(getModItem(Minecraft.ID, "sand", 9, 0)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 15))
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 9, 14)).duration(15 * SECONDS)
                .eut(2).addTo(extractorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "quartz_block", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.AshDark, 1L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 2)).duration(4 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 4L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 5)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 4)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0),
                        getModItem(Minecraft.ID, "gunpowder", 1, 0))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 3)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 4L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 7)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0),
                        getModItem(Minecraft.ID, "dye", 1, 9))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 8)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "cobblestone_compressed", 4, 3),
                        getModItem(Minecraft.ID, "diamond_block", 1, 0))
                .itemOutputs(getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0)).circuit(1)
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0)).circuit(4)
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 2)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0)).circuit(5)
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 6)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0)).circuit(2)
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 9)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0),
                        getModItem(ExtraUtilities.ID, "curtains", 1, 0))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 10)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 10),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 4L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 11)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "flint", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 2L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "chestMini", 1, 0)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 4, 2),
                        getModItem(IndustrialCraft2.ID, "itemDensePlates", 4, 7))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 500)).duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 4, 1),
                        getModItem(Minecraft.ID, "ender_eye", 3, 0))
                .itemOutputs(getModItem(ExtraUtilities.ID, "endConstructor", 1, 2))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Railcraft.ID, "detector", 1, 2), getModItem(Minecraft.ID, "sticky_piston", 1, 0))
                .itemOutputs(getModItem(ExtraUtilities.ID, "budoff", 1, 0)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "budoff", 1, 0),
                        getModItem(Minecraft.ID, "redstone_block", 4, 0))
                .itemOutputs(getModItem(ExtraUtilities.ID, "budoff", 1, 3)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 5, 0),
                        GTOreDictUnificator.get(OrePrefixes.gemFlawed, Materials.Diamond, 1L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "chandelier", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 1440)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "stone", 4, 0), getModItem(Minecraft.ID, "stonebrick", 5, 0))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 9, 0)).duration(9 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 0)).circuit(4)
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 4)).duration(20).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 4)).circuit(4)
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 7)).duration(20).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "gravel", 1, 0)).circuit(2)
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 6)).duration(20).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "stone", 1, 0), getModItem(Minecraft.ID, "ice", 4, 0))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 4, 3)).duration(4 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "sand", 1, 0), getModItem(Minecraft.ID, "glass", 1, 0))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 2, 9)).duration(2 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "sandstone", 1, 0), getModItem(Minecraft.ID, "end_stone", 1, 0))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 2, 13)).duration(2 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 5, 6),
                        getModItem(Minecraft.ID, "stone_slab", 5, 5))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 5, 10)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 4, 1),
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 4, 8))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 11))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).duration(1 * MINUTES).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "machine.alpha", 1, 6), ItemList.Plank_Oak.get(4L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "trading_post", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2L)).circuit(2)
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redalloy", 36)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "pipes", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1))
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes", 1, 8)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "pipes", 1, 0)).circuit(1)
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes", 1, 11))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redalloy", 216)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "pipes", 4, 0)).circuit(4)
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes", 1, 12)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "pipes", 1, 8),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1))
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes", 1, 13)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "pipes", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1))
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes", 1, 9)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "pipes", 1, 8),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1))
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes", 1, 10)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Electrum, 2L),
                        getModItem(ExtraUtilities.ID, "pipes", 1, 11))
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes", 1, 14)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(ExtraUtilities.ID, "pipes", 1, 10), ItemList.Tool_DataStick.get(1L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes.1", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "pipes", 1, 10),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 1))
                .itemOutputs(getModItem(ExtraUtilities.ID, "pipes.1", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                        getModItem(Minecraft.ID, "ender_pearl", 1, 0))
                .itemOutputs(getModItem(ExtraUtilities.ID, "trashcan", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "trashcan", 1, 0),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0))
                .itemOutputs(getModItem(ExtraUtilities.ID, "trashcan", 1, 1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "trashcan", 1, 0),
                        getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowergold", 1, 0))
                .itemOutputs(getModItem(ExtraUtilities.ID, "trashcan", 1, 2)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Iron, 4L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "heatingElement", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Iron, 4L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "heatingElement", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 288)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Iron, 4L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "heatingElement", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "ender_pearl", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4L))
                .itemOutputs(getModItem(ExtraUtilities.ID, "golden_lasso", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(ItemList.Tool_Scanner.get(1L), getModItem(Minecraft.ID, "ender_eye", 1, 0))
                .itemOutputs(getModItem(ExtraUtilities.ID, "scanner", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "cobblestone", 9, 0)).circuit(9)
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "dirt", 9, 0)).circuit(9)
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 8)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "gravel", 9, 0)).circuit(9)
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 12)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "sand", 9, 0)).circuit(9)
                .itemOutputs(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 14)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        for (int i = 0; i < 16; i++) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "color_lightgem", 1, i))
                    .itemOutputs(new ItemStack(Items.glowstone_dust, 4)).duration(392 * TICKS).eut(4)
                    .addTo(maceratorRecipes);
        }

        TCHelper.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem(ExtraUtilities.ID, "angelRing", 1, 0),
                30,
                new AspectList().add(getAspect("praecantatio"), 200).add(getAspect("volatus"), 200)
                        .add(getAspect("tempestas"), 200).add(getAspect("nebrisum"), 200).add(getAspect("motus"), 200)
                        .add(getAspect("terminus"), 200),
                createItemStack(
                        TinkerConstruct.ID,
                        "travelWings",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:2.0d,Built:1b,MaxDefense:8.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}"),
                ring.get(Iridium),
                screw.get(Tritanium),
                EngravedGoldChip.get(1),
                getModItem(ExtraUtilities.ID, "angelBlock", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                MagicFeather.get(1),
                getModItem(Minecraft.ID, "nether_star", 1, 0),
                getModItem(Avaritia.ID, "big_pearl", 1, 0),
                getModItem(Minecraft.ID, "nether_star", 1, 0),
                MagicFeather.get(1),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                getModItem(ExtraUtilities.ID, "angelBlock", 1, 0),
                EngravedGoldChip.get(1),
                screw.get(Tritanium));
        TCHelper.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem(ExtraUtilities.ID, "angelRing", 1, 1),
                4,
                new AspectList().add(Aspect.getAspect("permutatio"), 50).add(Aspect.getAspect("volatus"), 50)
                        .add(Aspect.getAspect("aer"), 50),
                getModItem(ExtraUtilities.ID, "angelRing", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(TinkerConstruct.ID, "fletching", 1, 0),
                getModItem(TinkerConstruct.ID, "fletching", 1, 0));
        TCHelper.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem(ExtraUtilities.ID, "angelRing", 1, 2),
                4,
                new AspectList().add(Aspect.getAspect("permutatio"), 50).add(Aspect.getAspect("volatus"), 50)
                        .add(Aspect.getAspect("auram"), 50),
                getModItem(ExtraUtilities.ID, "angelRing", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(TwilightForest.ID, "item.critter", 1, 0),
                getModItem(TwilightForest.ID, "item.critter", 1, 1));
        TCHelper.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem(ExtraUtilities.ID, "angelRing", 1, 3),
                4,
                new AspectList().add(Aspect.getAspect("permutatio"), 50).add(Aspect.getAspect("bestia"), 50)
                        .add(Aspect.getAspect("infernus"), 50),
                getModItem(ExtraUtilities.ID, "angelRing", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Minecraft.ID, "dragon_egg", 1, 0),
                getModItem(Botania.ID, "manaResource", 1, 9));
        TCHelper.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem(ExtraUtilities.ID, "angelRing", 1, 4),
                4,
                new AspectList().add(Aspect.getAspect("permutatio"), 50).add(Aspect.getAspect("metallum"), 50)
                        .add(Aspect.getAspect("lucrum"), 50),
                getModItem(ExtraUtilities.ID, "angelRing", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
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
                getModItem(TinkerConstruct.ID, "travelWings", 1, 0)).setRound().setConcealed()
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
                getModItem(ExtraUtilities.ID, "angelRing", 1, 0)).setParents("EXURINGS").setConcealed()
                        .registerResearchItem();
        ThaumcraftApi.addWarpToResearch("EXURINGS_CRAFTING", 16);
        TCHelper.addResearchPage("EXURINGS_CRAFTING", new ResearchPage("tc.research_page.EXURINGS_CRAFTING.1"));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ExtraUtilities.ID, "angelRing", 1, 0))));
        TCHelper.addResearchPage("EXURINGS_CRAFTING", new ResearchPage("tc.research_page.EXURINGS_CRAFTING.2"));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ExtraUtilities.ID, "angelRing", 1, 1))));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ExtraUtilities.ID, "angelRing", 1, 2))));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ExtraUtilities.ID, "angelRing", 1, 3))));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ExtraUtilities.ID, "angelRing", 1, 4))));
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
