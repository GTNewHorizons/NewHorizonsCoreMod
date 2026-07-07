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
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.ProjectRedIllumination;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.RandomThings;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.enums.Mods.UtilitiesInExcess;
import static gregtech.api.enums.Mods.WirelessRedstoneCBECore;
import static gregtech.api.enums.Mods.WirelessRedstoneCBELogic;
import static gregtech.api.enums.OrePrefixes.ring;
import static gregtech.api.enums.OrePrefixes.screw;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList.MagicFeather;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.dreammaster.thaumcraft.TCHelper;
import com.dreammaster.tinkersConstruct.TConstructHelper;
import com.fouristhenumber.utilitiesinexcess.api.EnderLocusRegistry;

import fox.spiteful.avaritia.compat.thaumcraft.Lucrum;
import fox.spiteful.forbidden.DarkAspects;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TCAspects;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptUtilitiesInExcess implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Utilities In Excess";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Avaritia.ID,
                Botania.ID,
                BuildCraftFactory.ID,
                BuildCraftTransport.ID,
                UtilitiesInExcess.ID,
                ForbiddenMagic.ID,
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

        // Diamond-Etched Computational Matrix
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 0),
                getModItem(UtilitiesInExcess.ID, "endspark", 1, 11),
                "plateDiamond",
                getModItem(UtilitiesInExcess.ID, "endspark", 1, 11),
                "plateTitanium",
                "circuitData",
                "plateTitanium",
                getModItem(UtilitiesInExcess.ID, "endspark", 1, 11),
                "plateDiamond",
                getModItem(UtilitiesInExcess.ID, "endspark", 1, 11));
        // Blackout Curtains
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "blackout_curtains", 1, 0),
                new ItemStack(Blocks.carpet, 1, 15),
                new ItemStack(Blocks.carpet, 1, 15),
                null,
                new ItemStack(Blocks.carpet, 1, 15),
                new ItemStack(Blocks.carpet, 1, 15),
                null,
                new ItemStack(Blocks.carpet, 1, 15),
                new ItemStack(Blocks.carpet, 1, 15),
                null);
        // Redstone Clock
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "redstone_clock", 1, 0),
                "plateRedAlloy",
                "gearWood",
                "plateRedAlloy",
                "gearWood",
                new ItemStack(Items.clock),
                "gearWood",
                "plateRedAlloy",
                "stickRedAlloy",
                "plateRedAlloy");
        // Void Quarry Upgrade: World Hole
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "void_quarry_upgrade", 1, 0),
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5),
                getModItem(UtilitiesInExcess.ID, "compressed_cobblestone", 1, 4),
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5),
                getModItem(UtilitiesInExcess.ID, "compressed_dirt", 1, 5),
                "gearDiamond",
                getModItem(UtilitiesInExcess.ID, "compressed_dirt", 1, 5),
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5),
                getModItem(UtilitiesInExcess.ID, "compressed_cobblestone", 1, 4),
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5));
        // Void Quarry Upgrade: Silk Touch
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "void_quarry_upgrade", 1, 1),
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5),
                getModItem(TinkerConstruct.ID, "materials", 1, 26),
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5),
                "plateTitanium",
                "gearDiamond",
                "plateTitanium",
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5),
                getModItem(TinkerConstruct.ID, "materials", 1, 26),
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5));
        // Void Quarry Upgrade: Fortune 1
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "void_quarry_upgrade", 1, 6),
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5),
                "plateTitanium",
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5),
                "plateTitanium",
                "gearDiamond",
                "plateTitanium",
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5),
                "plateTitanium",
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5));
        // Void Quarry Upgrade: Fortune 2
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "void_quarry_upgrade", 1, 7),
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5),
                "plateTungstenSteel",
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5),
                "plateTungstenSteel",
                getModItem(UtilitiesInExcess.ID, "void_quarry_upgrade", 1, 6),
                "plateTungstenSteel",
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5),
                "plateTungstenSteel",
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5));
        // Void Quarry Upgrade: Fortune 3
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "void_quarry_upgrade", 1, 8),
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5),
                "plateChrome",
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5),
                "plateChrome",
                getModItem(UtilitiesInExcess.ID, "enderQuarryUpgrade", 1, 7),
                "plateChrome",
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5),
                "plateChrome",
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5));
        // TODO: Void Quarry Upgrade: Speed 1 - Waiting on Transfer Node merge (Replace decorative block with speed
        // upgrade)
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "void_quarry_upgrade", 1, 3),
                ItemList.AcceleratorHV.get(1),
                "gearTitanium",
                ItemList.AcceleratorHV.get(1),
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 0),
                "gearDiamond",
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 0),
                ItemList.AcceleratorHV.get(1),
                "gearTitanium",
                ItemList.AcceleratorHV.get(1));
        // Void Quarry Upgrade: Speed 2
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "void_quarry_upgrade", 1, 4),
                ItemList.AcceleratorEV.get(1),
                "gearTungstenSteel",
                ItemList.AcceleratorEV.get(1),
                "gearTungstenSteel",
                getModItem(UtilitiesInExcess.ID, "void_quarry_upgrade", 1, 3),
                "gearTungstenSteel",
                ItemList.AcceleratorEV.get(1),
                "gearTungstenSteel",
                ItemList.AcceleratorEV.get(1));
        // Void Quarry Upgrade: Speed 3
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "void_quarry_upgrade", 1, 5),
                ItemList.AcceleratorIV.get(1),
                "gearChrome",
                ItemList.AcceleratorIV.get(1),
                "gearChrome",
                getModItem(UtilitiesInExcess.ID, "void_quarry_upgrade", 1, 4),
                "gearChrome",
                ItemList.AcceleratorIV.get(1),
                "gearChrome",
                ItemList.AcceleratorIV.get(1));
        // Void Quarry Upgrade: Fluid Pump
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "void_quarry_upgrade", 1, 2),
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5),
                getModItem(UtilitiesInExcess.ID, "smart_pump", 1, 0),
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5),
                "pipeLargeTungstenSteel",
                "pipeSmallStainlessSteel",
                "pipeLargeTungstenSteel",
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5),
                getModItem(UtilitiesInExcess.ID, "smart_pump", 1, 0),
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5));
        // TODO: transfer node upgrades - Waiting on transfer node merge
        /*
         * addShapedRecipe( getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 0), "plateRedAlloy", "plateDiamond",
         * "plateRedAlloy", "plateDiamond", "gearStainlessSteel", "plateDiamond", "plateRedAlloy", "plateDiamond",
         * "plateRedAlloy"); addShapedRecipe( getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 1), "plateRedAlloy",
         * getModItem(Minecraft.ID, "iron_bars", 1, 0), "plateRedAlloy", getModItem(Minecraft.ID, "iron_bars", 1, 0),
         * "gearStainlessSteel", getModItem(Minecraft.ID, "iron_bars", 1, 0), "plateRedAlloy", getModItem(Minecraft.ID,
         * "iron_bars", 1, 0), "plateRedAlloy"); addShapelessRecipe( getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1,
         * 1), getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 1)); GameRegistry.addRecipe( new FilterRecipe(
         * getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 1), Collections.singletonMap("Inverted", new
         * NBTTagByte((byte) 1)), "craftingRedstoneTorch")); GameRegistry.addRecipe( new FilterRecipe(
         * getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 1), Collections.singletonMap("FuzzyNBT", new
         * NBTTagByte((byte) 1)), "blockWool")); GameRegistry.addRecipe( new FilterRecipe(
         * getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 1), Collections.singletonMap("FuzzyMeta", new
         * NBTTagByte((byte) 1)), "stickWood")); addShapedRecipe( getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1,
         * 10), "plateLapis", BlockList.SteelBars.get(), "plateLapis", BlockList.SteelBars.get(),
         * getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 1), BlockList.SteelBars.get(), "plateLapis",
         * BlockList.SteelBars.get(), "plateLapis"); addShapelessRecipe( getModItem(UtilitiesInExcess.ID, "nodeUpgrade",
         * 1, 10), getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 10)); GameRegistry.addRecipe( new FilterRecipe(
         * getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 10), Collections.singletonMap("Inverted", new
         * NBTTagByte((byte) 1)), "craftingRedstoneTorch")); addShapedRecipe( getModItem(UtilitiesInExcess.ID,
         * "nodeUpgrade", 1, 2), "plateLapis", getModItem(Minecraft.ID, "diamond_pickaxe", 1, 0), "plateLapis",
         * getModItem(Minecraft.ID, "iron_pickaxe", 1, 0), "gearDiamond", getModItem(Minecraft.ID, "iron_pickaxe", 1,
         * 0), "plateLapis", getModItem(Minecraft.ID, "diamond_pickaxe", 1, 0), "plateLapis"); addShapedRecipe(
         * getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 5), "plateEnderEye", getModItem(UtilitiesInExcess.ID,
         * "nodeUpgrade", 1, 2), "plateEnderEye", "gearIridium", getModItem(WirelessRedstoneCBELogic.ID,
         * "wirelessLogic", 1, 0), "gearIridium", "plateEnderEye", "plateNetherStar", "plateEnderEye"); addShapedRecipe(
         * getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 6), "plateEnderEye", getModItem(UtilitiesInExcess.ID,
         * "nodeUpgrade", 1, 2), "plateEnderEye", "gearIridium", getModItem(WirelessRedstoneCBECore.ID, "recieverDish",
         * 1, 0), "gearIridium", "plateEnderEye", "plateNetherStar", "plateEnderEye"); addShapedRecipe(
         * getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 7), "plateRedAlloy", getModItem(UtilitiesInExcess.ID,
         * "nodeUpgrade", 1, 0), "plateRedAlloy", "craftingToolWrench", "gearDiamond", getModItem(UtilitiesInExcess.ID,
         * "nodeUpgrade", 1, 0), "plateRedAlloy", getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 0),
         * "plateRedAlloy"); addShapedRecipe( getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 8), "plateRedAlloy",
         * "craftingToolWrench", "plateRedAlloy", getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 0), "gearDiamond",
         * getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 0), "plateRedAlloy", null, "plateRedAlloy");
         * addShapedRecipe( getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 8), "plateRedAlloy", null,
         * "plateRedAlloy", getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 0), "gearDiamond",
         * getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 0), "plateRedAlloy", "craftingToolWrench",
         * "plateRedAlloy"); addShapedRecipe( getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 9), "plateRedAlloy",
         * getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 0), "plateRedAlloy", getModItem(UtilitiesInExcess.ID,
         * "nodeUpgrade", 1, 0), "gearDiamond", "craftingToolWrench", "plateRedAlloy", getModItem(UtilitiesInExcess.ID,
         * "nodeUpgrade", 1, 0), "plateRedAlloy"); addShapedRecipe( getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1,
         * 3), "plateRedAlloy", getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 0), "plateRedAlloy",
         * "craftingToolWrench", "gearDiamond", ItemList.Electric_Piston_MV.get(1L), "plateRedAlloy",
         * getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 0), "plateRedAlloy");
         */
        // Paint Roller
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "paint_roller", 1, 0),
                null,
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0),
                null,
                "stickWood",
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0),
                "stickWood",
                null,
                null);
        // Drum
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "drum", 1, 0),
                "plateSteel",
                "ringMeteoricSteel",
                "plateSteel",
                "plateSteel",
                "pipeHugeSteel",
                "plateSteel",
                "plateSteel",
                "ringMeteoricSteel",
                "plateSteel");
        // Bedrockium Drum
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "bedrockium_drum", 1, 0),
                "plateBedrockium",
                "ringTungstenSteel",
                "plateBedrockium",
                "plateBedrockium",
                getModItem(UtilitiesInExcess.ID, "drum", 1, 0),
                "plateBedrockium",
                "plateBedrockium",
                "ringTungstenSteel",
                "plateBedrockium");
        // Conveyor
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "conveyor", 1, 0),
                "craftingToolHardHammer",
                new ItemStack(Blocks.rail),
                "craftingToolWrench",
                ItemList.Conveyor_Module_LV.get(1L),
                "frameGtSteel",
                ItemList.Conveyor_Module_LV.get(1L),
                "gearGtSmallSteel",
                ItemList.Electric_Motor_LV.get(1L),
                "gearGtSmallSteel");
        // Filing Cabinet
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "filing_cabinet", 1, 0),
                "plateSteel",
                "chestWood",
                "plateSteel",
                "screwSteel",
                getModItem(IronChests.ID, "BlockIronChest", 1, 0),
                "screwSteel",
                "plateSteel",
                "chestWood",
                "plateSteel");
        // Advanced Filing Cabinet
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "filing_cabinet", 1, 1),
                getModItem(UtilitiesInExcess.ID, "magic_wood", 1, 0),
                getModItem(UtilitiesInExcess.ID, "filing_cabinet", 1, 0),
                getModItem(UtilitiesInExcess.ID, "magic_wood", 1, 0),
                "screwSteel",
                getModItem(UtilitiesInExcess.ID, "filing_cabinet", 1, 0),
                "screwSteel",
                getModItem(UtilitiesInExcess.ID, "magic_wood", 1, 0),
                getModItem(UtilitiesInExcess.ID, "filing_cabinet", 1, 0),
                getModItem(UtilitiesInExcess.ID, "magic_wood", 1, 0));
        // TODO: recipe for elite cabinet and upgrade
        // Watering Can
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "watering_can_basic", 1, 0),
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
                getModItem(UtilitiesInExcess.ID, "watering_can_basic", 1, 0),
                "craftingToolScrewdriver",
                "ringSteel",
                "craftingToolHardHammer",
                "plateAnyIron",
                "plateAnyIron",
                "stickAnyIron",
                "plateAnyIron",
                "plateAnyIron",
                "screwSteel");
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 1),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1))
                .circuit(5).fluidInputs(Materials.Water.getFluid(1000))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "watering_can_basic", 1, 0)).duration(4 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // TODO: figure out advanced
        // Elite Watering Can
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "watering_can_elite", 1, 0),
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
                getModItem(UtilitiesInExcess.ID, "watering_can_elite", 1, 0),
                "craftingToolScrewdriver",
                "ringNeutronium",
                "craftingToolHardHammer",
                "plateBedrockium",
                "plateBedrockium",
                "plateBedrockium",
                "plateBedrockium",
                "plateBedrockium",
                "screwNeutronium");
        // Sound Muffler
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "sound_muffler", 1, 0),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                new ItemStack(Blocks.noteblock),
                "blockWool",
                "blockWool",
                getModItem(UtilitiesInExcess.ID, "block_update_detector", 1, 0),
                "blockWool");
        // Rain Muffler
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "rain_muffler", 1, 1),
                "blockWool",
                getModItem(UtilitiesInExcess.ID, "sound_muffler", 1, 0),
                "blockWool",
                getModItem(UtilitiesInExcess.ID, "sound_muffler", 1, 0),
                new ItemStack(Items.water_bucket),
                getModItem(UtilitiesInExcess.ID, "sound_muffler", 1, 0),
                getModItem(UtilitiesInExcess.ID, "sound_muffler", 1, 0),
                getModItem(UtilitiesInExcess.ID, "block_update_detector", 1, 0),
                getModItem(UtilitiesInExcess.ID, "sound_muffler", 1, 0));
        // TODO: transfer nodes and pipes
        /*
         * addShapedRecipe( getModItem(UtilitiesInExcess.ID, "pipes", 1, 0), "foilSteel", "plateSteel", "foilSteel",
         * "craftingToolWrench", "stickRedAlloy", "craftingToolHardHammer", "foilSteel", "plateSteel", "foilSteel");
         * addShapedRecipe( getModItem(UtilitiesInExcess.ID, "pipes", 1, 8), "foilSteel", "circuitBasic", "foilSteel",
         * "craftingToolWrench", getModItem(UtilitiesInExcess.ID, "pipes", 1, 0), "craftingToolHardHammer", "foilSteel",
         * "circuitBasic", "foilSteel"); addShapedRecipe( getModItem(UtilitiesInExcess.ID, "pipes", 1, 9), "foilSteel",
         * "circuitGood", "foilSteel", "craftingToolWrench", getModItem(UtilitiesInExcess.ID, "pipes", 1, 0),
         * "craftingToolHardHammer", "foilSteel", "circuitGood", "foilSteel"); addShapedRecipe(
         * getModItem(UtilitiesInExcess.ID, "pipes", 1, 10), "foilSteel", "circuitAdvanced", "foilSteel",
         * "craftingToolWrench", getModItem(UtilitiesInExcess.ID, "pipes", 1, 8), "craftingToolHardHammer", "foilSteel",
         * "circuitAdvanced", "foilSteel"); addShapedRecipe( getModItem(UtilitiesInExcess.ID, "pipes.1", 1, 0),
         * "foilSteel", "circuitData", "foilSteel", "craftingToolWrench", getModItem(UtilitiesInExcess.ID, "pipes", 1,
         * 10), "craftingToolHardHammer", "foilSteel", "circuitData", "foilSteel"); addShapedRecipe(
         * getModItem(UtilitiesInExcess.ID, "pipes", 1, 11), "foilRedAlloy", "plateRedAlloy", "foilRedAlloy",
         * "craftingToolWrench", getModItem(UtilitiesInExcess.ID, "pipes", 1, 0), "craftingToolHardHammer",
         * "foilRedAlloy", "plateRedAlloy", "foilRedAlloy"); addShapedRecipe( getModItem(UtilitiesInExcess.ID, "pipes",
         * 1, 12), "craftingToolHardHammer", getModItem(UtilitiesInExcess.ID, "pipes", 1, 0), "screwSteel",
         * getModItem(UtilitiesInExcess.ID, "pipes", 1, 0), getModItem(UtilitiesInExcess.ID, "pipes", 1, 0),
         * getModItem(UtilitiesInExcess.ID, "pipes", 1, 0), "screwSteel", getModItem(UtilitiesInExcess.ID, "pipes", 1,
         * 0), "craftingToolScrewdriver"); addShapedRecipe( getModItem(UtilitiesInExcess.ID, "pipes", 1, 12),
         * "craftingToolScrewdriver", getModItem(UtilitiesInExcess.ID, "pipes", 1, 0), "screwSteel",
         * getModItem(UtilitiesInExcess.ID, "pipes", 1, 0), getModItem(UtilitiesInExcess.ID, "pipes", 1, 0),
         * getModItem(UtilitiesInExcess.ID, "pipes", 1, 0), "screwSteel", getModItem(UtilitiesInExcess.ID, "pipes", 1,
         * 0), "craftingToolHardHammer"); addShapedRecipe( getModItem(UtilitiesInExcess.ID, "pipes", 1, 13),
         * "foilSteel", "circuitBasic", "foilSteel", "craftingToolWrench", getModItem(UtilitiesInExcess.ID, "pipes", 1,
         * 8), "craftingToolHardHammer", "foilSteel", "circuitBasic", "foilSteel"); addShapedRecipe(
         * getModItem(UtilitiesInExcess.ID, "pipes", 1, 14), "foilElectrum", "plateElectrum", "foilElectrum",
         * "craftingToolWrench", getModItem(UtilitiesInExcess.ID, "pipes", 1, 11), "craftingToolHardHammer",
         * "foilElectrum", "plateElectrum", "foilElectrum"); addShapedRecipe( getModItem(UtilitiesInExcess.ID,
         * "extractor_base_remote", 1, 0), "craftingToolWrench", getModItem(UtilitiesInExcess.ID, "pipes", 1, wildcard),
         * "craftingToolHardHammer", "screwEnderPearl", ItemList.Conveyor_Module_LV.get(1L), "screwEnderPearl",
         * getModItem(UtilitiesInExcess.ID, "extractor_base", 1, 0), getModItem(UtilitiesInExcess.ID, "extractor_base",
         * 1, 0), getModItem(UtilitiesInExcess.ID, "extractor_base", 1, 0)); addShapedRecipe(
         * getModItem(UtilitiesInExcess.ID, "extractor_base_remote", 1, 6), "craftingToolWrench",
         * getModItem(UtilitiesInExcess.ID, "pipes", 1, wildcard), "craftingToolHardHammer", "screwEnderPearl",
         * ItemList.Electric_Pump_LV.get(1L), "screwEnderPearl", getModItem(UtilitiesInExcess.ID, "extractor_base", 1,
         * 6), getModItem(UtilitiesInExcess.ID, "extractor_base", 1, 6), getModItem(UtilitiesInExcess.ID,
         * "extractor_base", 1, 6)); addShapedRecipe( getModItem(UtilitiesInExcess.ID, "extractor_base", 1, 0),
         * "craftingToolWrench", getModItem(UtilitiesInExcess.ID, "pipes", 1, wildcard), "craftingToolHardHammer",
         * "screwEnderPearl", ItemList.Conveyor_Module_LV.get(1L), "screwEnderPearl",
         * GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1L), "pipeMediumBrass",
         * GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1L)); addShapedRecipe(
         * getModItem(UtilitiesInExcess.ID, "extractor_base", 1, 6), "craftingToolWrench",
         * getModItem(UtilitiesInExcess.ID, "pipes", 1, wildcard), "craftingToolHardHammer", "screwEnderPearl",
         * ItemList.Electric_Pump_LV.get(1L), "screwEnderPearl", GTOreDictUnificator.get(OrePrefixes.pipeMedium,
         * Materials.Steel, 1L), ItemList.Electric_Pump_LV.get(1L), GTOreDictUnificator.get(OrePrefixes.pipeMedium,
         * Materials.Steel, 1L));
         */
        // Smooth Glass
        addShapelessRecipe(
                getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        // Significantly Shrunk Chest
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "significantly_shrunk_chest", 1, 0),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "craftingToolSaw",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "itemFlint",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                null,
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                null);
        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Items.flint), GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 2L))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "significantly_shrunk_chest", 1, 0))
                .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Collector
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "collector", 1, 0),
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
                getModItem(UtilitiesInExcess.ID, "collector", 1, 0),
                getModItem(RandomThings.ID, "advancedItemCollector", 1, 0));
        // Ender Locus
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "ender_locus", 1, 0),
                "plateEnderEye",
                getModItem(HardcoreEnderExpansion.ID, "altar_nexus", 1, 0),
                "plateEnderEye",
                "blockEnderObsidian",
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 2),
                "blockEnderObsidian",
                "plateTitanium",
                getModItem(UtilitiesInExcess.ID, "decorativeBlock1", 1, 0),
                "plateTitanium");
        // Wood Spike
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "wood_spike", 2, 0),
                "craftingToolSaw",
                new ItemStack(Items.wooden_sword),
                "craftingToolScrewdriver",
                "screwWood",
                "plateWood",
                "screwWood",
                "plateWood",
                "logWood",
                "plateWood");
        // Iron Spike
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "iron_spike", 2, 0),
                "craftingToolSaw",
                new ItemStack(Items.iron_sword),
                "craftingToolScrewdriver",
                "screwIron",
                "plateAnyIron",
                "screwIron",
                "plateAnyIron",
                "blockIron",
                "plateAnyIron");
        // Gold Spike
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "gold_spike", 2, 0),
                "craftingToolSaw",
                new ItemStack(Items.golden_sword),
                "craftingToolScrewdriver",
                "screwGold",
                "plateGold",
                "screwGold",
                "plateGold",
                "blockGold",
                "plateGold");
        // Diamond Spike
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "diamond_spike", 2, 0),
                "craftingToolSaw",
                new ItemStack(Items.diamond_sword),
                "craftingToolScrewdriver",
                "screwDiamond",
                "plateDiamond",
                "screwDiamond",
                "plateDiamond",
                "blockDiamond",
                "plateDiamond");
        // Architect's Wand
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "architects_wand", 1, 0),
                null,
                null,
                "ingotInverted",
                null,
                "ingotInverted",
                null,
                "stickObsidian",
                null,
                null);
        // Super Architect's Wand
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "super_architects_wand", 1, 0),
                null,
                "ingotInverted",
                "ingotInverted",
                null,
                "ingotInverted",
                "ingotInverted",
                "stickObsidian",
                null,
                null);
        // Precision Shears
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "precision_shears", 1, 0),
                "ingotInverted",
                null,
                "ingotInverted",
                getModItem(UtilitiesInExcess.ID, "floating_block", 1, 0),
                new ItemStack(Items.shears),
                getModItem(UtilitiesInExcess.ID, "floating_block", 1, 0));
        // Etheric Sword
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "etheric_sword", 1, 0),
                null,
                "ingotInverted",
                null,
                null,
                "ingotInverted",
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null);
        // Chunchunmaru
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "chunchunmaru", 1, 0),
                null,
                getModItem(TinkerConstruct.ID, "largeSwordBlade", 1, 314),
                null,
                null,
                "ingotInverted",
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null);
        // Anti-Particulate Shovel
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "anti_particulate_shovel", 1, 0),
                null,
                "ingotInverted",
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null);
        // Destruction Pickaxe
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "destruction_pickaxe", 1, 0),
                "ingotInverted",
                "ingotInverted",
                "ingotInverted",
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null);
        // Gourmand's Axe
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "gourmands_axe", 1, 0),
                "ingotInverted",
                "ingotInverted",
                null,
                "ingotInverted",
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null);
        // Reversing Hoe
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "reversing_hoe", 1, 0),
                "ingotInverted",
                "ingotInverted",
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null,
                null,
                getModItem(RandomThings.ID, "ingredient", 1, 1),
                null);

        // Assembler Quasi-Normalized Inverted Ingot
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 1L),
                        getModItem(UtilitiesInExcess.ID, "pseudo_reversion_sigil", 0, 0),
                        GTOreDictUnificator.get(OrePrefixes.gem, Materials.Diamond, 1L))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "inverted_ingot", 1, 2)).nbtSensitive()
                .duration(42 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        TConstructHelper.removeTableRecipe(getModItem(UtilitiesInExcess.ID, "bedrockium_ingot", 1, 0));
        TConstructHelper.removeBasinRecipe(getModItem(UtilitiesInExcess.ID, "bedrockium_block", 1, 0));
        // Void Quarry
        EnderLocusRegistry.instance().addRecipe(
                getModItem(UtilitiesInExcess.ID, "void_quarry", 1, 0),
                new String[] { "ege", "pcp", "sds" },
                'e',
                "plateEuropium",
                'g',
                ItemList.Field_Generator_LuV.get(1L),
                'p',
                getModItem(UtilitiesInExcess.ID, "smart_pump", 1, 0),
                'c',
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 0),
                's',
                getModItem(UtilitiesInExcess.ID, "endspark", 1, 0),
                'd',
                ItemList.OreDrill2.get(1L));

        // Smart Pump
        EnderLocusRegistry.instance().addRecipe(
                getModItem(UtilitiesInExcess.ID, "smart_pump", 1, 0),
                new String[] { "oco", "tst", "opo" },
                'o',
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5),
                'c',
                "circuitData",
                's',
                getModItem(UtilitiesInExcess.ID, "endspark", 1, 0),
                't',
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                'p',
                ItemList.Pump_HV.get(1L));
        // Giga Torch
        EnderLocusRegistry.instance().addRecipe(
                getModItem(UtilitiesInExcess.ID, "giga_torch", 1, 0),
                new String[] { "rnh", "csc", "csc" },
                'r',
                new ItemStack(Items.potionitem, 1, 8225),
                'n',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                'h',
                new ItemStack(Items.potionitem, 1, 8229),
                'd',
                getModItem(UtilitiesInExcess.ID, "chandelier", 1, 0),
                's',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 1L),
                'c');
        // TODO: Tranfer nodes
        /*
         * EnderConstructorRecipesHandler.registerRecipe( new ShapedOreRecipe( getModItem(UtilitiesInExcess.ID,
         * "extractor_base", 1, 12), "abc", "def", "ghi", 'a', getModItem(UtilitiesInExcess.ID, "extractor_base", 1, 0),
         * 'b', getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerdiamond", 1, 0), 'c',
         * getModItem(UtilitiesInExcess.ID, "extractor_base", 1, 0), 'd', GTOreDictUnificator.get(OrePrefixes.plate,
         * Materials.EnderEye, 1L), 'e', getModItem(UtilitiesInExcess.ID, "nodeUpgrade", 1, 8), 'f',
         * GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1L), 'g', getModItem(UtilitiesInExcess.ID,
         * "extractor_base", 1, 0), 'h', getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerdiamond", 1,
         * 0), 'i', getModItem(UtilitiesInExcess.ID, "extractor_base", 1, 0)));
         * EnderConstructorRecipesHandler.registerRecipe( new ShapedOreRecipe( getModItem(UtilitiesInExcess.ID,
         * "extractor_base", 1, 13), "abc", "def", "ghi", 'a', getModItem(UtilitiesInExcess.ID, "extractor_base", 1,
         * 12), 'b', GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1L), 'c',
         * getModItem(UtilitiesInExcess.ID, "extractor_base", 1, 12), 'd', GTOreDictUnificator.get(OrePrefixes.plate,
         * Materials.EnderEye, 1L), 'e', GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Bedrockium, 1L), 'f',
         * GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1L), 'g', getModItem(UtilitiesInExcess.ID,
         * "extractor_base", 1, 12), 'h', getModItem(UtilitiesInExcess.ID, "extractor_base", 1, 12), 'i',
         * getModItem(UtilitiesInExcess.ID, "extractor_base", 1, 12)));
         */
        // Inverted Obsidian
        EnderLocusRegistry.instance().addRecipe(
                GregtechItemList.InvertedObsidian.get(1),
                new String[] { "rgr", "gog", "rgr" },
                'r',
                "dustRedstone",
                'g',
                "dustGlowstone",
                'o');
        // Void Marker
        EnderLocusRegistry.instance().addRecipe(
                getModItem(UtilitiesInExcess.ID, "void_marker", 1, 0),
                new String[] { " e ", " o ", " o " },
                'e',
                new ItemStack(Items.ender_eye),
                'o',
                getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5));

        // Compressed Block Extraction (To vanilla block)
        GTValues.RA.stdBuilder().itemInputs(getModItem(UtilitiesInExcess.ID, "compressed_cobblestone", 1, 0))
                .itemOutputs(new ItemStack(Blocks.cobblestone, 9)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(UtilitiesInExcess.ID, "compressed_dirt", 1, 0))
                .itemOutputs(new ItemStack(Blocks.dirt, 9)).duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(UtilitiesInExcess.ID, "compressed_sand", 1, 0))
                .itemOutputs(new ItemStack(Blocks.sand, 9)).duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(UtilitiesInExcess.ID, "compressed_gravel", 1, 0))
                .itemOutputs(new ItemStack(Blocks.gravel, 9)).duration(15 * SECONDS).eut(2).addTo(extractorRecipes);

        // Compressed Block Extraction (Downtier)
        for (int i = 0; i < 7; i++) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(UtilitiesInExcess.ID, "compressed_cobblestone", 1, i + 1))
                    .itemOutputs(getModItem(UtilitiesInExcess.ID, "compressed_cobblestone", 9, i))
                    .duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(UtilitiesInExcess.ID, "compressed_dirt", 1, i + 1))
                    .itemOutputs(getModItem(UtilitiesInExcess.ID, "compressed_dirt", 9, i)).duration(15 * SECONDS)
                    .eut(2).addTo(extractorRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(UtilitiesInExcess.ID, "compressed_sand", 1, i + 1))
                    .itemOutputs(getModItem(UtilitiesInExcess.ID, "compressed_sand", 9, i)).duration(15 * SECONDS)
                    .eut(2).addTo(extractorRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(UtilitiesInExcess.ID, "compressed_gravel", 1, i + 1))
                    .itemOutputs(getModItem(UtilitiesInExcess.ID, "compressed_gravel", 9, i)).duration(15 * SECONDS)
                    .eut(2).addTo(extractorRecipes);
        }

        // Compressed Block Assembly (From vanilla block)
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.cobblestone, 9)).circuit(9)
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "compressed_cobblestone", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.dirt, 9)).circuit(9)
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "compressed_dirt", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.sand, 9)).circuit(9)
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "compressed_sand", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.gravel, 9)).circuit(9)
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "compressed_gravel", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        // Burnt Quartz
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.quartz_block),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.AshDark, 1L))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 2)).duration(4 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(alloySmelterRecipes);

        // Bedrockium Ingot (Assembler)
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(UtilitiesInExcess.ID, "compressed_cobblestone", 4, 3),
                        new ItemStack(Blocks.diamond_block))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "bedrockium_ingot", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);

        // Obsidian Glass
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 4L))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 5)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(alloySmelterRecipes);
        // Gilded Glass
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 4)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(alloySmelterRecipes);
        // Creepy Glass
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 0), new ItemStack(Items.gunpowder))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 3)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(alloySmelterRecipes);
        // Glowing Glass
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 4L))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 7)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        // Beloved Glass
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 0), new ItemStack(Items.dye, 1, 9))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 8)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(alloySmelterRecipes);
        // Rimmed Glass
        GTValues.RA.stdBuilder().itemInputs(getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 0)).circuit(1)
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        // Bricked Glass
        GTValues.RA.stdBuilder().itemInputs(getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 0)).circuit(4)
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 2)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        // Vortex Glass
        GTValues.RA.stdBuilder().itemInputs(getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 0)).circuit(5)
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 6)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        // Tiled Glass
        GTValues.RA.stdBuilder().itemInputs(getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 0)).circuit(2)
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 9)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        // Dark Glass
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 0),
                        getModItem(UtilitiesInExcess.ID, "blackout_curtains", 1, 0))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 10)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        // Reinforced Dark Glass
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 10),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 4L))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_glass", 1, 11)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // TODO: Latticed Glass
        // Ender-Infused Obsidian
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(UtilitiesInExcess.ID, "decorative_block", 4, 2),
                        getModItem(IndustrialCraft2.ID, "itemDensePlates", 4, 7))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 5))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 500)).duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Convergence Crystal
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(UtilitiesInExcess.ID, "decorative_block", 4, 5),
                        new ItemStack(Items.ender_eye, 3))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "convergence_crystal", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Block Update Detector
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Railcraft.ID, "detector", 1, 2), new ItemStack(Blocks.sticky_piston))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "block_update_detector", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Advanced Block Update Detector
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(UtilitiesInExcess.ID, "block_update_detector", 1, 0),
                        new ItemStack(Blocks.redstone_block, 4))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "advanced_block_update_detector", 1, 0))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        // Chandelier
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.torch, 5),
                        GTOreDictUnificator.get(OrePrefixes.gemFlawed, Materials.Diamond, 1L))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "chandelier", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 1440)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // TODO: Alternate chandeliers
        // Edged Stone Bricks
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone, 4), new ItemStack(Blocks.stonebrick, 5))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_block", 9, 7)).duration(9 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        // Border Stone
        GTValues.RA.stdBuilder().itemInputs(getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 7)).circuit(4)
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 8)).duration(20).eut(4)
                .addTo(assemblerRecipes);
        // Border Stone (Alternate)
        GTValues.RA.stdBuilder().itemInputs(getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 8)).circuit(4)
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 9)).duration(20).eut(4)
                .addTo(assemblerRecipes);
        // Gravel Bricks
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.gravel)).circuit(2)
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_block", 1, 6)).duration(20).eut(4)
                .addTo(assemblerRecipes);
        // Frosted Stone
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone), new ItemStack(Blocks.ice, 4))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_block", 4, 4)).duration(4 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        // Sandy Glass
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.sand), new ItemStack(Blocks.glass))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_block", 2, 3)).duration(2 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        // Sand-Infused Endstone
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.sandstone), new ItemStack(Blocks.end_stone))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_block", 2, 1)).duration(2 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        // Gravel Road
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(UtilitiesInExcess.ID, "decorative_block", 5, 6),
                        new ItemStack(Blocks.stone_slab, 5, 5))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "decorative_block", 5, 10)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        // Endspark
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(UtilitiesInExcess.ID, "decorative_block", 4, 5),
                        getModItem(UtilitiesInExcess.ID, "magic_wood", 4, 0))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "endspark", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).duration(1 * MINUTES).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        // Trading Post
        GTValues.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "machine.alpha", 1, 6), ItemList.Plank_Oak.get(4L))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "trading_post", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // TODO: Transfer node
        /*
         * GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel,
         * 2L)).circuit(2) .itemOutputs(getModItem(UtilitiesInExcess.ID, "pipes", 1, 0))
         * .fluidInputs(FluidRegistry.getFluidStack("molten.redalloy", 36)).duration(5 * SECONDS) .eut(TierEU.RECIPE_MV
         * / 2).addTo(assemblerRecipes); GTValues.RA.stdBuilder() .itemInputs( getModItem(UtilitiesInExcess.ID, "pipes",
         * 1, 0), GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1))
         * .itemOutputs(getModItem(UtilitiesInExcess.ID, "pipes", 1, 8)).duration(10 * SECONDS) .eut(TierEU.RECIPE_MV /
         * 2).addTo(assemblerRecipes); GTValues.RA.stdBuilder().itemInputs(getModItem(UtilitiesInExcess.ID, "pipes", 1,
         * 0)).circuit(1) .itemOutputs(getModItem(UtilitiesInExcess.ID, "pipes", 1, 11))
         * .fluidInputs(FluidRegistry.getFluidStack("molten.redalloy", 216)).duration(10 * SECONDS)
         * .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
         * GTValues.RA.stdBuilder().itemInputs(getModItem(UtilitiesInExcess.ID, "pipes", 4, 0)).circuit(4)
         * .itemOutputs(getModItem(UtilitiesInExcess.ID, "pipes", 1, 12)).duration(10 * SECONDS) .eut(TierEU.RECIPE_MV /
         * 2).addTo(assemblerRecipes); GTValues.RA.stdBuilder() .itemInputs( getModItem(UtilitiesInExcess.ID, "pipes",
         * 1, 8), GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1))
         * .itemOutputs(getModItem(UtilitiesInExcess.ID, "pipes", 1, 13)).duration(15 * SECONDS) .eut(TierEU.RECIPE_MV /
         * 2).addTo(assemblerRecipes); GTValues.RA.stdBuilder() .itemInputs( getModItem(UtilitiesInExcess.ID, "pipes",
         * 1, 0), GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1))
         * .itemOutputs(getModItem(UtilitiesInExcess.ID, "pipes", 1, 9)).duration(10 * SECONDS) .eut(TierEU.RECIPE_MV /
         * 2).addTo(assemblerRecipes); GTValues.RA.stdBuilder() .itemInputs( getModItem(UtilitiesInExcess.ID, "pipes",
         * 1, 8), GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1))
         * .itemOutputs(getModItem(UtilitiesInExcess.ID, "pipes", 1, 10)).duration(15 * SECONDS) .eut(TierEU.RECIPE_MV /
         * 2).addTo(assemblerRecipes); GTValues.RA.stdBuilder() .itemInputs( GTOreDictUnificator.get(OrePrefixes.plate,
         * Materials.Electrum, 2L), getModItem(UtilitiesInExcess.ID, "pipes", 1, 11))
         * .itemOutputs(getModItem(UtilitiesInExcess.ID, "pipes", 1, 14)).duration(15 * SECONDS) .eut(TierEU.RECIPE_MV /
         * 2).addTo(assemblerRecipes); GTValues.RA.stdBuilder() .itemInputs(getModItem(UtilitiesInExcess.ID, "pipes", 1,
         * 10), ItemList.Tool_DataStick.get(1L)) .itemOutputs(getModItem(UtilitiesInExcess.ID, "pipes.1", 1,
         * 0)).duration(20 * SECONDS) .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes); GTValues.RA.stdBuilder()
         * .itemInputs( getModItem(UtilitiesInExcess.ID, "pipes", 1, 10), GTOreDictUnificator.get(OrePrefixes.circuit,
         * Materials.EV, 1)) .itemOutputs(getModItem(UtilitiesInExcess.ID, "pipes.1", 1, 0)).duration(10 * SECONDS)
         * .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
         */
        // Item Trash Can
        addShapedRecipe(
                getModItem(UtilitiesInExcess.ID, "trash_can_item", 1, 0),
                "plateIron",
                "craftingToolHardHammer",
                "plateIron",
                "plateIron",
                "gemEnderPearl",
                "plateIron",
                "plateIron",
                "plateIron",
                "plateIron");
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                        new ItemStack(Items.ender_pearl))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "trash_can_item", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Fluid Trash Can
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(UtilitiesInExcess.ID, "trash_can_item", 1, 0),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "trash_can_fluid", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Energy Trash Can
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(UtilitiesInExcess.ID, "trash_can_item", 1, 0),
                        getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowergold", 1, 0))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "trash_can_energy", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Fire Battery
        // TODO: we reflavored this item, maybe should redo recipe as well
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Iron, 4L))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "fire_battery", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Iron, 4L))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "fire_battery", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.lead", 288)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Iron, 4L))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "fire_battery", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 72)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Mob Jar
        // TODO: also reflavored maybe should change slightly. Just add a bottle probably
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.ender_pearl),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4L))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "mob_jar", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        // Block Analyzer
        GTValues.RA.stdBuilder().itemInputs(ItemList.Tool_Scanner.get(1L), new ItemStack(Items.ender_eye))
                .itemOutputs(getModItem(UtilitiesInExcess.ID, "block_analyzer", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        // TODO: figure out what we want to do with the many exu recipe pages...
        // Heavenly Rings
        TCHelper.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem(UtilitiesInExcess.ID, "heavenly_ring_magic", 1, 0),
                30,
                new AspectList().add(Aspect.MAGIC, 200).add(Aspect.FLIGHT, 200).add(Aspect.WEATHER, 200)
                        .add(TCAspects.NEBRISUM.getAspect(), 200).add(Aspect.MOTION, 200).add(Lucrum.ULTRA_DEATH, 200),
                createItemStack(
                        TinkerConstruct.ID,
                        "travelWings",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:2.0d,Built:1b,MaxDefense:8.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}"),
                ring.get(Iridium),
                screw.get(Tritanium),
                EngravedGoldChip.get(1),
                getModItem(UtilitiesInExcess.ID, "angelBlock", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                MagicFeather.get(1),
                new ItemStack(Items.nether_star),
                getModItem(Avaritia.ID, "big_pearl", 1, 0),
                new ItemStack(Items.nether_star),
                MagicFeather.get(1),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                getModItem(UtilitiesInExcess.ID, "angelBlock", 1, 0),
                EngravedGoldChip.get(1),
                screw.get(Tritanium));
        TCHelper.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem(UtilitiesInExcess.ID, "heavenly_ring_feather", 1, 0),
                4,
                new AspectList().add(Aspect.EXCHANGE, 50).add(Aspect.FLIGHT, 50).add(Aspect.AIR, 50),
                getModItem(UtilitiesInExcess.ID, "heavenly_ring_magic", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(TinkerConstruct.ID, "fletching", 1, 0),
                getModItem(TinkerConstruct.ID, "fletching", 1, 0));
        TCHelper.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem(UtilitiesInExcess.ID, "heavenly_ring_fairy", 1, 0),
                4,
                new AspectList().add(Aspect.EXCHANGE, 50).add(Aspect.FLIGHT, 50).add(Aspect.AURA, 50),
                getModItem(UtilitiesInExcess.ID, "heavenly_ring_magic", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(TwilightForest.ID, "item.critter", 1, 0),
                getModItem(TwilightForest.ID, "item.critter", 1, 1));
        TCHelper.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem(UtilitiesInExcess.ID, "heavenly_ring_dragon", 1, 0),
                4,
                new AspectList().add(Aspect.EXCHANGE, 50).add(Aspect.BEAST, 50).add(DarkAspects.NETHER, 50),
                getModItem(UtilitiesInExcess.ID, "heavenly_ring_magic", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                new ItemStack(Blocks.dragon_egg),
                getModItem(Botania.ID, "manaResource", 1, 9));
        TCHelper.addInfusionCraftingRecipe(
                "EXURINGS_CRAFTING",
                getModItem(UtilitiesInExcess.ID, "heavenly_ring_metal", 1, 0),
                4,
                new AspectList().add(Aspect.EXCHANGE, 50).add(Aspect.METAL, 50).add(Aspect.GREED, 50),
                getModItem(UtilitiesInExcess.ID, "heavenly_ring_magic", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                OrePrefixes.foil.get(Materials.RoseGold),
                OrePrefixes.foil.get(Materials.RoseGold));
        // Weird pointless inbetween research
        new ResearchItem(
                "EXURINGS",
                "ARTIFICE",
                new AspectList().add(Aspect.MAGIC, 10).add(Aspect.FLIGHT, 10).add(Aspect.WEATHER, 100)
                        .add(TCAspects.NEBRISUM.getAspect(), 10).add(Aspect.MOTION, 10).add(Lucrum.ULTRA_DEATH, 10),
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
                new AspectList().add(Aspect.MAGIC, 10).add(Aspect.FLIGHT, 10).add(Aspect.WEATHER, 10)
                        .add(TCAspects.NEBRISUM.getAspect(), 10).add(Aspect.MOTION, 10).add(Lucrum.ULTRA_DEATH, 10),
                -1,
                -5,
                3,
                getModItem(UtilitiesInExcess.ID, "angelRing", 1, 0)).setParents("EXURINGS").setConcealed()
                        .registerResearchItem();
        ThaumcraftApi.addWarpToResearch("EXURINGS_CRAFTING", 16);
        TCHelper.addResearchPage("EXURINGS_CRAFTING", new ResearchPage("tc.research_page.EXURINGS_CRAFTING.1"));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(UtilitiesInExcess.ID, "heavenly_ring_magic", 1, 0))));
        TCHelper.addResearchPage("EXURINGS_CRAFTING", new ResearchPage("tc.research_page.EXURINGS_CRAFTING.2"));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(UtilitiesInExcess.ID, "heavenly_ring_feather", 1, 0))));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(UtilitiesInExcess.ID, "heavenly_ring_fairy", 1, 0))));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(UtilitiesInExcess.ID, "heavenly_ring_dragon", 1, 0))));
        TCHelper.addResearchPage(
                "EXURINGS_CRAFTING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(UtilitiesInExcess.ID, "heavenly_ring_metal", 1, 0))));
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
