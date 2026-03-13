package com.dreammaster.scripts;

import static com.dreammaster.main.MainRegistry.Module_CustomFuels;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.CarpentersBlocks;
import static gregtech.api.enums.Mods.EnderStorage;
import static gregtech.api.enums.Mods.EtFuturumRequiem;
import static gregtech.api.enums.Mods.ExtraTrees;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.Fether;
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IguanaTweaksTinkerConstruct;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.MagicBees;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.TaintedMagic;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidExtractionRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.util.GTModHandler.RecipeBits.BITS;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static net.minecraftforge.fluids.FluidRegistry.getFluidStack;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.dreammaster.item.NHItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.ToolDictNames;
import gregtech.api.objects.OreDictItemStack;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;

public class ScriptMinecraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Minecraft";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Backpack.ID,
                BiomesOPlenty.ID,
                BloodArsenal.ID,
                Botania.ID,
                CarpentersBlocks.ID,
                EnderStorage.ID,
                EtFuturumRequiem.ID,
                ExtraTrees.ID,
                ExtraUtilities.ID,
                Fether.ID,
                ForbiddenMagic.ID,
                Forestry.ID,
                GalacticraftAmunRa.ID,
                GalaxySpace.ID,
                HardcoreEnderExpansion.ID,
                IguanaTweaksTinkerConstruct.ID,
                IndustrialCraft2.ID,
                MagicBees.ID,
                Natura.ID,
                PamsHarvestCraft.ID,
                Railcraft.ID,
                StevesCarts2.ID,
                TaintedMagic.ID,
                Thaumcraft.ID,
                ThaumicBases.ID,
                TinkerConstruct.ID,
                TwilightForest.ID,
                Witchery.ID);
    }

    @Override
    public void loadRecipes() {
        craftingRecipes();

        GTModHandler.addSmeltingRecipe(NHItemList.UnfiredClayBrick.get(), getModItem(Minecraft.ID, "brick", 1, 0));
        GTModHandler.addSmeltingRecipe(ItemList.Food_Raw_Bread.get(1L), getModItem(Minecraft.ID, "bread", 1, 0));
        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 3))
                .itemOutputs(getModItem(Minecraft.ID, "blaze_powder", 1, 0)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 2))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemResource", 1, 3)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "hay_block", 1, 0))
                .itemOutputs(getModItem(Minecraft.ID, "wheat", 9, 0)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Fether.ID, "glow_flower", 2, 0))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 1L)).duration(15 * SECONDS)
                .eut(2).addTo(extractorRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "clay_ball", 1, 0), ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "brick", 1, 0)).duration(10 * SECONDS).eut(2)
                .addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Netherrack, 1L),
                        ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "netherbrick", 1, 0)).duration(10 * SECONDS).eut(2)
                .addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(BloodArsenal.ID, "glass_shard", 2, 0), ItemList.Shape_Mold_Block.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 1, 0)).duration(5).eut(TierEU.RECIPE_MV / 2)
                .addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 5L),
                        NHItemList.MoldHelmet.get(0))
                .itemOutputs(getModItem(Minecraft.ID, "iron_helmet", 1, 0)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 8L),
                        NHItemList.MoldChestplate.get(0))
                .itemOutputs(getModItem(Minecraft.ID, "iron_chestplate", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 7L),
                        NHItemList.MoldLeggings.get(0))
                .itemOutputs(getModItem(Minecraft.ID, "iron_leggings", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 4L), NHItemList.MoldBoots.get(0))
                .itemOutputs(getModItem(Minecraft.ID, "iron_boots", 1, 0)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Gold, 5L),
                        NHItemList.MoldHelmet.get(0))
                .itemOutputs(getModItem(Minecraft.ID, "golden_helmet", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Gold, 8L),
                        NHItemList.MoldChestplate.get(0))
                .itemOutputs(getModItem(Minecraft.ID, "golden_chestplate", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Gold, 7L),
                        NHItemList.MoldLeggings.get(0))
                .itemOutputs(getModItem(Minecraft.ID, "golden_leggings", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Gold, 4L), NHItemList.MoldBoots.get(0))
                .itemOutputs(getModItem(Minecraft.ID, "golden_boots", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "barleyFood", 2, 3)).circuit(1)
                .itemOutputs(getModItem(Minecraft.ID, "string", 1, 0)).duration(10 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "wheat", 9, 0), getModItem(Minecraft.ID, "string", 2, 0))
                .itemOutputs(getModItem(Minecraft.ID, "hay_block", 1, 0)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "heatsand", 1, 0), getModItem(Natura.ID, "soil.tainted", 4, 0))
                .itemOutputs(getModItem(Minecraft.ID, "soul_sand", 1, 0)).fluidInputs(Materials.Water.getFluid(1000))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(MagicBees.ID, "miscResources", 6, 4)).circuit(6)
                .itemOutputs(getModItem(Minecraft.ID, "skull", 1, 1)).fluidInputs(Materials.Thaumium.getMolten(216))
                .duration(10 * SECONDS).eut(96).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1L))
                .itemOutputs(getModItem(Minecraft.ID, "torch", 4, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L))
                .itemOutputs(getModItem(Minecraft.ID, "torch", 6, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 4L),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_door", 1, 0)).fluidInputs(Materials.Iron.getMolten(16))
                .duration(20 * SECONDS).eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 4L),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_door", 1, 0)).fluidInputs(Materials.Copper.getMolten(16))
                .duration(20 * SECONDS).eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L), NHItemList.SteelBars.get())
                .itemOutputs(getModItem(Minecraft.ID, "iron_door", 1, 0)).fluidInputs(Materials.Steel.getMolten(16))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 0),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Minecraft.ID, "trapdoor", 4, 0)).fluidInputs(Materials.Iron.getMolten(16))
                .duration(30 * SECONDS).eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 0),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Minecraft.ID, "trapdoor", 6, 0)).fluidInputs(Materials.Steel.getMolten(16))
                .duration(30 * SECONDS).eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "planks", 6, wildcard), getModItem(Minecraft.ID, "book", 3, 0))
                .itemOutputs(getModItem(Minecraft.ID, "bookshelf", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new OreDictItemStack("logWood", 1), getModItem(Minecraft.ID, "flint", 2, 0))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        getModItem(Minecraft.ID, "planks", 2, 0))
                .itemOutputs(getModItem(Minecraft.ID, "fence_gate", 1, 0)).duration(15 * SECONDS).eut(TierEU.RECIPE_ULV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new OreDictItemStack("logWood", 2), new OreDictItemStack("plankWood", 2))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        getModItem(Minecraft.ID, "stone_button", 1, 0))
                .itemOutputs(getModItem(Minecraft.ID, "lever", 1, 0)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L))
                .circuit(6).itemOutputs(getModItem(Minecraft.ID, "ladder", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L))
                .circuit(6).itemOutputs(getModItem(Minecraft.ID, "ladder", 4, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L))
                .circuit(6).itemOutputs(getModItem(Minecraft.ID, "ladder", 8, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Aluminium, 1L))
                .circuit(6).itemOutputs(getModItem(Minecraft.ID, "ladder", 32, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "brick", 8, 0)).circuit(1)
                .itemOutputs(getModItem(Minecraft.ID, "brick_block", 2, 0)).fluidInputs(Materials.Water.getFluid(500))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L), ItemList.Plank_Oak.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Spruce.get(1L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "item_sign_spruce", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Birch.get(1L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "item_sign_birch", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Jungle.get(1L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "item_sign_jungle", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Acacia.get(1L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "item_sign_acacia", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_DarkOak.get(1L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "item_sign_dark_oak", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Cherry_EFR.get(1L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "cherry_sign", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Larch.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L), ItemList.Plank_Teak.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Acacia_Green.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L), ItemList.Plank_Lime.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Chestnut.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Wenge.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Baobab.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Sequoia.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Kapok.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Ebony.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Mahagony.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Balsa.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Willow.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Walnut.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Greenheart.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Plank_Oak.get(2L), GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_pressure_plate", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Plank_Oak.get(2L),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_pressure_plate", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Plank_Oak.get(2L),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.PigIron, 1))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_pressure_plate", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "stone_slab", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(Minecraft.ID, "stone_pressure_plate", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "stone_slab", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1))
                .itemOutputs(getModItem(Minecraft.ID, "stone_pressure_plate", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "stone_slab", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.PigIron, 1))
                .itemOutputs(getModItem(Minecraft.ID, "stone_pressure_plate", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                        getModItem(Minecraft.ID, "comparator", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Gold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Gold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 1L))
                .circuit(1).itemOutputs(getModItem(Minecraft.ID, "clock", 1, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "leather", 4, 0),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 2L))
                .circuit(1).itemOutputs(getModItem(Minecraft.ID, "saddle", 1, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.dirt, 16), getModItem(Botania.ID, "grassSeeds", 1, 0))
                .circuit(1).itemOutputs(new ItemStack(Blocks.grass, 16)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.dirt, 16), getModItem(Botania.ID, "grassSeeds", 1, 1))
                .circuit(1).itemOutputs(new ItemStack(Blocks.dirt, 16, 2)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.dirt, 16), getModItem(Botania.ID, "grassSeeds", 1, 2))
                .circuit(1).itemOutputs(new ItemStack(Blocks.mycelium, 16)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.ArtificialLeather.get(4),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 2L))
                .circuit(1).itemOutputs(getModItem(Minecraft.ID, "saddle", 1, 0)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_button", 2, 0)).fluidInputs(Materials.Water.getFluid(4))
                .duration(2 * SECONDS + 10 * TICKS).eut(4).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_button", 2, 0))
                .fluidInputs(getFluidStack("ic2distilledwater", 3)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_button", 2, 0)).fluidInputs(getFluidStack("lubricant", 1))
                .duration(1 * SECONDS + 5 * TICKS).eut(4).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_button", 2, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(6 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0))
                .itemOutputs(getModItem(Minecraft.ID, "stone_button", 2, 0)).fluidInputs(Materials.Water.getFluid(4))
                .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_ULV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0))
                .itemOutputs(getModItem(Minecraft.ID, "stone_button", 2, 0))
                .fluidInputs(getFluidStack("ic2distilledwater", 3)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_ULV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0))
                .itemOutputs(getModItem(Minecraft.ID, "stone_button", 2, 0)).fluidInputs(getFluidStack("lubricant", 1))
                .duration(1 * SECONDS + 5 * TICKS).eut(TierEU.RECIPE_ULV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0))
                .itemOutputs(getModItem(Minecraft.ID, "stone_button", 2, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(6 * TICKS)
                .eut(TierEU.RECIPE_ULV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "sand", 1, wildcard))
                .fluidOutputs(Materials.Glass.getMolten(144)).duration(10 * SECONDS).eut(48)
                .addTo(fluidExtractionRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "sand", 4, wildcard),
                        getModItem(Minecraft.ID, "dirt", 1, wildcard),
                        getModItem(MagicBees.ID, "wax", 4, 1))
                .itemOutputs(getModItem(Minecraft.ID, "soul_sand", 4, 0)).fluidInputs(Materials.Water.getFluid(1000))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "blaze_powder", 3, 0),
                        getModItem(Minecraft.ID, "gunpowder", 3, 0),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 3L))
                .itemOutputs(getModItem(Minecraft.ID, "fire_charge", 1, 0)).duration(20 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "melon_block", 1, 0), ItemList.Shape_Slicer_Flat.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "melon", 8, 0)).duration(5 * SECONDS).eut(TierEU.RECIPE_ULV)
                .addTo(cutterRecipes);
        Module_CustomFuels.registerCustomFuelValue(getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0), (short) 75);

    }

    private void craftingRecipes() {
        addShapedRecipe(
                getModItem(Minecraft.ID, "crafting_table", 1, 0),
                getModItem(Minecraft.ID, "flint", 1, 0),
                getModItem(Minecraft.ID, "flint", 1, 0),
                "logWood",
                "logWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "chest", 1, 0),
                "logWood",
                "plankWood",
                "logWood",
                "plankWood",
                getModItem(Minecraft.ID, "flint", 1, 0),
                "plankWood",
                "logWood",
                "plankWood",
                "logWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "trapped_chest", 1, 0),
                null,
                getModItem(Minecraft.ID, "tripwire_hook", 1, 0),
                null,
                "screwAnyIron",
                getModItem(Minecraft.ID, "chest", 1, 0),
                "screwAnyIron",
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "furnace", 1, 0),
                "cobblestone",
                "cobblestone",
                "cobblestone",
                getModItem(Minecraft.ID, "flint", 1, 0),
                getModItem(Minecraft.ID, "flint", 1, 0),
                getModItem(Minecraft.ID, "flint", 1, 0),
                "cobblestone",
                "cobblestone",
                "cobblestone");
        addShapedRecipe(
                getModItem(Minecraft.ID, "dispenser", 1, 0),
                "cobblestone",
                "ringAnyIron",
                "cobblestone",
                "springIron",
                getModItem(Minecraft.ID, "string", 1, 0),
                "springIron",
                "gearGtSmallAnyIron",
                "stickRedAlloy",
                "gearGtSmallAnyIron");
        addShapedRecipe(
                getModItem(Minecraft.ID, "dropper", 1, 0),
                "cobblestone",
                "ringAnyIron",
                "cobblestone",
                "springSmallIron",
                getModItem(Minecraft.ID, "string", 1, 0),
                "springSmallIron",
                "gearGtSmallAnyIron",
                "stickRedAlloy",
                "gearGtSmallAnyIron");
        addShapedRecipe(
                getModItem(Minecraft.ID, "piston", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "gearGtSmallAnyIron",
                "fenceWood",
                "gearGtSmallAnyIron",
                "cobblestone",
                "plateRedAlloy",
                "cobblestone");
        addShapedRecipe(
                getModItem(Minecraft.ID, "sticky_piston", 1, 0),
                null,
                ToolDictNames.craftingToolSoftMallet.name(),
                null,
                null,
                "slimeball",
                null,
                null,
                getModItem(Minecraft.ID, "piston", 1, 0),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "rail", 8, 0),
                "screwAnyIron",
                null,
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                "craftingToolScrewdriver",
                null,
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Minecraft.ID, "detector_rail", 1, 0),
                "screwAnyIron",
                getModItem(Railcraft.ID, "detector", 1, 1),
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                "craftingToolScrewdriver",
                "stickRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Minecraft.ID, "activator_rail", 2, 0),
                "screwAnyIron",
                getModItem(Minecraft.ID, "redstone_torch", 1, 0),
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                getModItem(Railcraft.ID, "part.railbed", 1, 0),
                getModItem(Railcraft.ID, "part.rail", 1, 0),
                "craftingToolScrewdriver",
                "stickRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Minecraft.ID, "noteblock", 1, 0),
                "plankWood",
                "plankWood",
                "plankWood",
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                "gearWood",
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                "plankWood",
                "stickRedAlloy",
                "plankWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "jukebox", 1, 0),
                "logWood",
                GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Diamond, 1L),
                "logWood",
                getModItem(Minecraft.ID, "noteblock", 1, 0),
                "record",
                getModItem(Minecraft.ID, "noteblock", 1, 0),
                "logWood",
                "gearAnyIron",
                "logWood");
        addShapelessRecipe(
                getModItem(Minecraft.ID, "lit_pumpkin", 1, 0),
                getModItem(Minecraft.ID, "pumpkin", 1, 0),
                getModItem(Minecraft.ID, "torch", 1, 0),
                "craftingToolKnife");
        addShapedRecipe(
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "flint", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "trapdoor", 2, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 0),
                "stickWood",
                "screwAnyIron",
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "trapdoor", 3, 0),
                getModItem(Minecraft.ID, "wooden_slab", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 0),
                "stickWood",
                "screwSteel",
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "stone_pressure_plate", 2, 0),
                "screwIron",
                "craftingToolHardHammer",
                "screwIron",
                getModItem(EtFuturumRequiem.ID, "stone_slab", 1, 0),
                "springAnyIron",
                getModItem(EtFuturumRequiem.ID, "stone_slab", 1, 0),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wooden_pressure_plate", 2, 0),
                "screwWood",
                "craftingToolHardHammer",
                "screwWood",
                ItemList.Plank_Oak.get(1L),
                "springAnyIron",
                ItemList.Plank_Oak.get(1L),
                "screwWood",
                "craftingToolScrewdriver",
                "screwWood");
        addShapelessRecipe(getModItem(Minecraft.ID, "glass_pane", 2, 0), "craftingToolSaw", "glass");
        addShapedRecipe(getModItem(Minecraft.ID, "torch", 3, 0), "gemCoal", null, "stickWood", null);
        addShapedRecipe(getModItem(Minecraft.ID, "torch", 2, 0), "gemCharcoal", null, "stickWood", null);
        addShapedRecipe(getModItem(Minecraft.ID, "torch", 1, 0), "gemLignite", null, "stickWood", null);
        addShapedRecipe(getModItem(Minecraft.ID, "torch", 5, 0), "fuelCoke", null, "stickWood", null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "torch", 5, 0),
                "blockWool",
                getModItem(Railcraft.ID, "fluid.creosote.bucket", 1, 0),
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "torch", 5, 0),
                "blockWool",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketCreosote", 1, 0),
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "torch", 4, 0),
                getModItem(TwilightForest.ID, "item.torchberries", 1, 0),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "torch", 3, 0),
                "itemBeeswax",
                getModItem(Minecraft.ID, "string", 1, 0),
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "torch", 2, 0),
                getModItem(IndustrialCraft2.ID, "itemHarz", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                "stickWood",
                null);
        addShapelessRecipe(
                getModItem(Minecraft.ID, "lever", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "stone_button", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "stone_button", 2, 0),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "wooden_button", 2, 0),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "redstone_torch", 1, 0),
                "dustRedstone",
                null,
                getModItem(Minecraft.ID, "torch", 1, 0),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "ladder", 2, 0),
                "stickWood",
                "craftingToolScrewdriver",
                "stickWood",
                getModItem(Minecraft.ID, "string", 1, 0),
                "screwWood",
                getModItem(Minecraft.ID, "string", 1, 0),
                "stickWood",
                ToolDictNames.craftingToolSoftMallet.name(),
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "ladder", 4, 0),
                "stickWood",
                "craftingToolScrewdriver",
                "stickWood",
                getModItem(Minecraft.ID, "string", 1, 0),
                "screwAnyIron",
                getModItem(Minecraft.ID, "string", 1, 0),
                "stickWood",
                ToolDictNames.craftingToolSoftMallet.name(),
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "ladder", 8, 0),
                "stickWood",
                "craftingToolScrewdriver",
                "stickWood",
                getModItem(Minecraft.ID, "string", 1, 0),
                "screwSteel",
                getModItem(Minecraft.ID, "string", 1, 0),
                "stickWood",
                ToolDictNames.craftingToolSoftMallet.name(),
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0),
                "stickWood",
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0),
                "stickWood",
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0),
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence", 2, 0),
                "screwAnyIron",
                "craftingToolScrewdriver",
                "screwAnyIron",
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0),
                "stickWood",
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0),
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence", 4, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0),
                "stickWood",
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0),
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence", 2, 0),
                null,
                null,
                null,
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "stickWood",
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence", 4, 0),
                "screwAnyIron",
                "craftingToolScrewdriver",
                "screwAnyIron",
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "stickWood",
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence", 6, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "stickWood",
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence_gate", 1, 0),
                getModItem(Minecraft.ID, "flint", 1, 0),
                null,
                getModItem(Minecraft.ID, "flint", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence_gate", 2, 0),
                "screwAnyIron",
                "craftingToolScrewdriver",
                "screwAnyIron",
                getModItem(Minecraft.ID, "planks", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence_gate", 4, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                getModItem(Minecraft.ID, "planks", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence_gate", 2, 0),
                null,
                null,
                null,
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence_gate", 4, 0),
                "screwAnyIron",
                "craftingToolScrewdriver",
                "screwAnyIron",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence_gate", 6, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0),
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "redstone_lamp", 1, 0),
                getModItem(Minecraft.ID, "glass_pane", 1, 0),
                getModItem(Minecraft.ID, "glass_pane", 1, 0),
                getModItem(Minecraft.ID, "glass_pane", 1, 0),
                getModItem(Minecraft.ID, "glass_pane", 1, 0),
                getModItem(Minecraft.ID, "glowstone", 1, 0),
                getModItem(Minecraft.ID, "glass_pane", 1, 0),
                getModItem(Minecraft.ID, "glass_pane", 1, 0),
                "stickRedAlloy",
                getModItem(Minecraft.ID, "glass_pane", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "tripwire_hook", 1, 0),
                "ringAnyIron",
                "stickWood",
                "ringAnyIron",
                getModItem(Minecraft.ID, "string", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "string", 1, 0),
                null,
                getModItem(Minecraft.ID, "string", 1, 0),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "anvil", 1, 0),
                "blockIron",
                "blockIron",
                "blockIron",
                "screwAnyIron",
                "blockIron",
                "screwAnyIron",
                "plateAnyIron",
                "blockIron",
                "plateAnyIron");
        addShapedRecipe(
                getModItem(Minecraft.ID, "daylight_detector", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                "plateNetherQuartz",
                "plateCertusQuartz",
                "plateNetherQuartz",
                "slabWood",
                "stickRedAlloy",
                "slabWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "hopper", 1, 0),
                "plateAnyIron",
                getModItem(Minecraft.ID, "chest", 1, 0),
                "plateAnyIron",
                "plateAnyIron",
                "gearAnyIron",
                "plateAnyIron",
                "craftingToolHardHammer",
                "plateAnyIron",
                "craftingToolFile");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 0),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeWhite",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 0), "blockWool", "dyeWhite");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                null,
                getModItem(Minecraft.ID, "string", 1, 0),
                null,
                getModItem(Minecraft.ID, "string", 1, 0),
                null,
                getModItem(Minecraft.ID, "string", 1, 0),
                null,
                getModItem(Minecraft.ID, "string", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 1, 0),
                getModItem(BiomesOPlenty.ID, "plants", 1, 7),
                getModItem(BiomesOPlenty.ID, "plants", 1, 7),
                getModItem(BiomesOPlenty.ID, "plants", 1, 7),
                getModItem(BiomesOPlenty.ID, "plants", 1, 7),
                getModItem(BiomesOPlenty.ID, "plants", 1, 7),
                getModItem(BiomesOPlenty.ID, "plants", 1, 7),
                getModItem(BiomesOPlenty.ID, "plants", 1, 7),
                getModItem(BiomesOPlenty.ID, "plants", 1, 7),
                getModItem(BiomesOPlenty.ID, "plants", 1, 7));
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 1),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeOrange",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 1), "blockWool", "dyeOrange");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 2),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeMagenta",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 2), "blockWool", "dyeMagenta");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 3),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeLightBlue",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 3), "blockWool", "dyeLightBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 4),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeYellow",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 4), "blockWool", "dyeYellow");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 5),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeLime",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 5), "blockWool", "dyeLime");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 6),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyePink",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 6), "blockWool", "dyePink");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 7),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeGray",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 7), "blockWool", "dyeGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 8),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeLightGray",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 8), "blockWool", "dyeLightGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 9),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeCyan",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 9), "blockWool", "dyeCyan");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 10),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyePurple",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 10), "blockWool", "dyePurple");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 11),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeBlue",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 11), "blockWool", "dyeBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 12),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeBrown",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 12), "blockWool", "dyeBrown");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 13),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeGreen",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 13), "blockWool", "dyeGreen");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 14),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeRed",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 14), "blockWool", "dyeRed");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 15),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeBlack",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 15), "blockWool", "dyeBlack");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 0),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeWhite",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 0), "glass", "dyeWhite");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 1),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeOrange",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 1), "glass", "dyeOrange");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 2),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeMagenta",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 2), "glass", "dyeMagenta");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 3),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeLightBlue",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 3), "glass", "dyeLightBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 4),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeYellow",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 4), "glass", "dyeYellow");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 5),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeLime",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 5), "glass", "dyeLime");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 6),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyePink",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 6), "glass", "dyePink");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 7),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeGray",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 7), "glass", "dyeGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 8),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeLightGray",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 8), "glass", "dyeLightGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 9),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeCyan",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 9), "glass", "dyeCyan");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 10),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyePurple",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 10), "glass", "dyePurple");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 11),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeBlue",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 11), "glass", "dyeBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 12),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeBrown",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 12), "glass", "dyeBrown");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 13),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeGreen",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 13), "glass", "dyeGreen");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 14),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeRed",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 14), "glass", "dyeRed");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 15),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeBlack",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 15), "glass", "dyeBlack");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 0),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeWhite",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 0), "paneGlass", "dyeWhite");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 1),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeOrange",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 1), "paneGlass", "dyeOrange");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 2),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeMagenta",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 2), "paneGlass", "dyeMagenta");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 3),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeLightBlue",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 3), "paneGlass", "dyeLightBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 4),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeYellow",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 4), "paneGlass", "dyeYellow");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 5),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeLime",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 5), "paneGlass", "dyeLime");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 6),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyePink",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 6), "paneGlass", "dyePink");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 7),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeGray",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 7), "paneGlass", "dyeGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 8),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeLightGray",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 8), "paneGlass", "dyeLightGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 9),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeCyan",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 9), "paneGlass", "dyeCyan");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 10),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyePurple",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 10), "paneGlass", "dyePurple");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 11),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeBlue",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 11), "paneGlass", "dyeBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 12),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeBrown",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 12), "paneGlass", "dyeBrown");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 13),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeGreen",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 13), "paneGlass", "dyeGreen");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 14),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeRed",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 14), "paneGlass", "dyeRed");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 15),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeBlack",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 15), "paneGlass", "dyeBlack");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "wool", 1, 0),
                getModItem(Minecraft.ID, "wool", 1, 0),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 0),
                getModItem(Minecraft.ID, "wool", 1, 0),
                getModItem(Minecraft.ID, "wool", 1, 0),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 1),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeOrange",
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 1),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeOrange");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 1),
                getModItem(Minecraft.ID, "wool", 1, 1),
                getModItem(Minecraft.ID, "wool", 1, 1),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 1),
                getModItem(Minecraft.ID, "wool", 1, 1),
                getModItem(Minecraft.ID, "wool", 1, 1),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 2),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeMagenta",
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 2),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeMagenta");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 2),
                getModItem(Minecraft.ID, "wool", 1, 2),
                getModItem(Minecraft.ID, "wool", 1, 2),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 2),
                getModItem(Minecraft.ID, "wool", 1, 2),
                getModItem(Minecraft.ID, "wool", 1, 2),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 3),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeLightBlue",
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 3),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeLightBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 3),
                getModItem(Minecraft.ID, "wool", 1, 3),
                getModItem(Minecraft.ID, "wool", 1, 3),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 3),
                getModItem(Minecraft.ID, "wool", 1, 3),
                getModItem(Minecraft.ID, "wool", 1, 3),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 4),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeYellow",
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 4),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeYellow");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 4),
                getModItem(Minecraft.ID, "wool", 1, 4),
                getModItem(Minecraft.ID, "wool", 1, 4),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 4),
                getModItem(Minecraft.ID, "wool", 1, 4),
                getModItem(Minecraft.ID, "wool", 1, 4),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 5),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeLime",
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 5),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeLime");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 5),
                getModItem(Minecraft.ID, "wool", 1, 5),
                getModItem(Minecraft.ID, "wool", 1, 5),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 5),
                getModItem(Minecraft.ID, "wool", 1, 5),
                getModItem(Minecraft.ID, "wool", 1, 5),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 6),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyePink",
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 6),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyePink");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 6),
                getModItem(Minecraft.ID, "wool", 1, 6),
                getModItem(Minecraft.ID, "wool", 1, 6),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 6),
                getModItem(Minecraft.ID, "wool", 1, 6),
                getModItem(Minecraft.ID, "wool", 1, 6),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 7),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeGray",
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 7),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 7),
                getModItem(Minecraft.ID, "wool", 1, 7),
                getModItem(Minecraft.ID, "wool", 1, 7),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 7),
                getModItem(Minecraft.ID, "wool", 1, 7),
                getModItem(Minecraft.ID, "wool", 1, 7),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 8),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeLightGray",
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 8),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeLightGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 8),
                getModItem(Minecraft.ID, "wool", 1, 8),
                getModItem(Minecraft.ID, "wool", 1, 8),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 8),
                getModItem(Minecraft.ID, "wool", 1, 8),
                getModItem(Minecraft.ID, "wool", 1, 8),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 9),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeCyan",
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 9),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeCyan");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 9),
                getModItem(Minecraft.ID, "wool", 1, 9),
                getModItem(Minecraft.ID, "wool", 1, 9),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 9),
                getModItem(Minecraft.ID, "wool", 1, 9),
                getModItem(Minecraft.ID, "wool", 1, 9),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 10),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyePurple",
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 10),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyePurple");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 10),
                getModItem(Minecraft.ID, "wool", 1, 10),
                getModItem(Minecraft.ID, "wool", 1, 10),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 10),
                getModItem(Minecraft.ID, "wool", 1, 10),
                getModItem(Minecraft.ID, "wool", 1, 10),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 11),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeBlue",
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 11),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 11),
                getModItem(Minecraft.ID, "wool", 1, 11),
                getModItem(Minecraft.ID, "wool", 1, 11),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 11),
                getModItem(Minecraft.ID, "wool", 1, 11),
                getModItem(Minecraft.ID, "wool", 1, 11),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 12),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeBrown",
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 12),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeBrown");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 12),
                getModItem(Minecraft.ID, "wool", 1, 12),
                getModItem(Minecraft.ID, "wool", 1, 12),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 12),
                getModItem(Minecraft.ID, "wool", 1, 12),
                getModItem(Minecraft.ID, "wool", 1, 12),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 13),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeGreen",
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 13),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeGreen");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 13),
                getModItem(Minecraft.ID, "wool", 1, 13),
                getModItem(Minecraft.ID, "wool", 1, 13),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 13),
                getModItem(Minecraft.ID, "wool", 1, 13),
                getModItem(Minecraft.ID, "wool", 1, 13),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 14),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeRed",
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 14),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeRed");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 14),
                getModItem(Minecraft.ID, "wool", 1, 14),
                getModItem(Minecraft.ID, "wool", 1, 14),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 14),
                getModItem(Minecraft.ID, "wool", 1, 14),
                getModItem(Minecraft.ID, "wool", 1, 14),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 15),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeBlack",
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "carpet", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 15),
                getModItem(Minecraft.ID, "carpet", 1, 0),
                "dyeBlack");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 15),
                getModItem(Minecraft.ID, "wool", 1, 15),
                getModItem(Minecraft.ID, "wool", 1, 15),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 15),
                getModItem(Minecraft.ID, "wool", 1, 15),
                getModItem(Minecraft.ID, "wool", 1, 15),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeWhite",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeWhite");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 1),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeOrange",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 1),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeOrange");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 2),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeMagenta",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 2),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeMagenta");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 3),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeLightBlue",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 3),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeLightBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 4),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeYellow",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 4),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeYellow");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 5),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeLime",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 5),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeLime");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 6),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyePink",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 6),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyePink");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 7),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeGray",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 7),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 8),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeLightGray",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 8),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeLightGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 9),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeCyan",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 9),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeCyan");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 10),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyePurple",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 10),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyePurple");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 11),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeBlue",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 11),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 12),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeBrown",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 12),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeBrown");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 13),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeGreen",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 13),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeGreen");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 14),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeRed",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 14),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeRed");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 15),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeBlack",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 15),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0),
                "dyeBlack");
        addShapelessRecipe(
                getModItem(Minecraft.ID, "sugar", 1, 0),
                "craftingToolMortar",
                getModItem(Minecraft.ID, "reeds", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "stone_sword", 1, 0),
                null,
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Stone, 1L),
                null,
                "craftingToolFile",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Stone, 1L),
                "craftingToolHardHammer",
                null,
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "stone_shovel", 1, 0),
                "craftingToolFile",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Stone, 1L),
                "craftingToolHardHammer",
                null,
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null,
                null,
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "stone_pickaxe", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Stone, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Stone, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Stone, 1L),
                "craftingToolFile",
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                "craftingToolHardHammer",
                null,
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "stone_axe", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Stone, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Stone, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Stone, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null,
                "craftingToolFile",
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "stone_hoe", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Stone, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Stone, 1L),
                "craftingToolHardHammer",
                "craftingToolFile",
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null,
                null,
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_sword", 1, 0),
                null,
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                null,
                "craftingToolFile",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolHardHammer",
                null,
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_shovel", 1, 0),
                "craftingToolFile",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolHardHammer",
                null,
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null,
                null,
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_pickaxe", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                getModItem(Minecraft.ID, "diamond", 1, 0),
                getModItem(Minecraft.ID, "diamond", 1, 0),
                "craftingToolFile",
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                "craftingToolHardHammer",
                null,
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_axe", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                getModItem(Minecraft.ID, "diamond", 1, 0),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null,
                "craftingToolFile",
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_hoe", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                getModItem(Minecraft.ID, "diamond", 1, 0),
                "craftingToolHardHammer",
                "craftingToolFile",
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null,
                null,
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_helmet", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_chestplate", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L));
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_leggings", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                null,
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L));
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_boots", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                null,
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "iron_horse_armor", 1, 0),
                "craftingToolHardHammer",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "iron_helmet", 1, 0),
                "plateIron",
                getModItem(Minecraft.ID, "iron_chestplate", 1, 0),
                "plateIron",
                getModItem(Minecraft.ID, "iron_leggings", 1, 0),
                "screwIron",
                getModItem(Minecraft.ID, "iron_leggings", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "golden_horse_armor", 1, 0),
                "craftingToolHardHammer",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "golden_helmet", 1, 0),
                "plateGold",
                getModItem(Minecraft.ID, "golden_chestplate", 1, 0),
                "plateGold",
                getModItem(Minecraft.ID, "golden_leggings", 1, 0),
                "screwGold",
                getModItem(Minecraft.ID, "golden_leggings", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_horse_armor", 1, 0),
                "craftingToolHardHammer",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "diamond_helmet", 1, 0),
                "plateDiamond",
                getModItem(Minecraft.ID, "diamond_chestplate", 1, 0),
                "plateDiamond",
                getModItem(Minecraft.ID, "diamond_leggings", 1, 0),
                "screwDiamond",
                getModItem(Minecraft.ID, "diamond_leggings", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "saddle", 1, 0),
                "itemLeather",
                getModItem(Backpack.ID, "tannedLeather", 1, 0),
                "itemLeather",
                "itemLeather",
                getModItem(Minecraft.ID, "carpet", 1, wildcard),
                "itemLeather",
                "ringAnyIron",
                getModItem(Minecraft.ID, "string", 1, 0),
                "ringAnyIron");
        addShapedRecipe(
                getModItem(Minecraft.ID, "clock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Gold, 1L),
                "plateGold",
                GTOreDictUnificator.get(OrePrefixes.ring, Materials.Gold, 1L),
                GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 1L),
                getModItem(Minecraft.ID, "comparator", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 1L),
                "craftingToolScrewdriver",
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Gold, 1L),
                "craftingToolWrench");
        addShapedRecipe(
                getModItem(Minecraft.ID, "compass", 1, 0),
                "screwIron",
                "paneGlass",
                "boltIron",
                "ringZinc",
                "plateIron",
                "ringZinc",
                "boltRedAlloy",
                "craftingToolScrewdriver",
                "screwIron");
        addShapedRecipe(
                getModItem(Minecraft.ID, "clay", 2, 0),
                "itemClay",
                "itemClay",
                "itemClay",
                "itemClay",
                getModItem(Minecraft.ID, "water_bucket", 1, 0),
                "itemClay",
                "itemClay",
                "itemClay",
                "itemClay");
        addShapedRecipe(
                getModItem(Minecraft.ID, "clay", 2, 0),
                "itemClay",
                "itemClay",
                "itemClay",
                "itemClay",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0),
                "itemClay",
                "itemClay",
                "itemClay",
                "itemClay");
        addShapedRecipe(
                getModItem(Minecraft.ID, "pumpkin_seeds", 2, 0),
                getModItem(Minecraft.ID, "pumpkin", 1, 0),
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Minecraft.ID, "pumpkin_seeds", 2, 0),
                getModItem(Minecraft.ID, "pumpkin", 1, 0),
                ToolDictNames.craftingToolSoftMallet.name(),
                getModItem(Minecraft.ID, "pumpkin", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "melon_seeds", 1, 0),
                getModItem(Minecraft.ID, "melon", 1, 0),
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Minecraft.ID, "melon_seeds", 1, 0),
                getModItem(Minecraft.ID, "melon", 1, 0),
                ToolDictNames.craftingToolSoftMallet.name(),
                getModItem(Minecraft.ID, "melon", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "melon", 6, 0),
                "craftingToolKnife",
                getModItem(Minecraft.ID, "melon_block", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "gunpowder", 1, 0),
                "dustSmallGunpowder",
                "dustSmallGunpowder",
                "dustSmallGunpowder",
                "dustSmallGunpowder");
        addShapelessRecipe(
                ItemList.Food_Dough.get(1L),
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L));
        addShapelessRecipe(
                ItemList.Food_Dough.get(1L),
                getModItem(PamsHarvestCraft.ID, "freshwaterItem", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L),
                getModItem(PamsHarvestCraft.ID, "freshwaterItem", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "chest_minecart", 1, 0),
                "craftingToolHardHammer",
                getModItem(Minecraft.ID, "chest", 1, 0),
                "craftingToolWrench",
                null,
                getModItem(Minecraft.ID, "minecart", 1, 0),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "furnace_minecart", 1, 0),
                "craftingToolHardHammer",
                getModItem(Minecraft.ID, "furnace", 1, 0),
                "craftingToolWrench",
                null,
                getModItem(Minecraft.ID, "minecart", 1, 0),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "hopper_minecart", 1, 0),
                "craftingToolHardHammer",
                getModItem(Minecraft.ID, "hopper", 1, 0),
                "craftingToolWrench",
                null,
                getModItem(Minecraft.ID, "minecart", 1, 0),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapelessRecipe(
                getModItem(Minecraft.ID, "dye", 3, 15),
                getModItem(Minecraft.ID, "bone", 1, 0),
                "craftingToolMortar");
        addShapedRecipe(
                getModItem(Minecraft.ID, "lead", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                "slimeball",
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "pumpkin_pie", 1, 0),
                "craftingToolRollingPin",
                getModItem(Minecraft.ID, "pumpkin", 1, 0),
                "dustSugar",
                getModItem(Minecraft.ID, "pumpkin", 1, 0),
                "dustSugar",
                null,
                "dustSugar",
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "comparator", 1, 0),
                "screwIron",
                "craftingRedstoneTorch",
                "screwIron",
                "craftingRedstoneTorch",
                "plateNetherQuartz",
                "craftingRedstoneTorch",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "comparator", 1, 0),
                "screwIron",
                "craftingRedstoneTorch",
                "screwIron",
                "craftingRedstoneTorch",
                "plateCertusQuartz",
                "craftingRedstoneTorch",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "comparator", 1, 0),
                "screwIron",
                "craftingRedstoneTorch",
                "screwIron",
                "craftingRedstoneTorch",
                "plateChargedCertusQuartz",
                "craftingRedstoneTorch",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "comparator", 1, 0),
                "screwIron",
                "craftingRedstoneTorch",
                "screwIron",
                "craftingRedstoneTorch",
                "plateQuartzite",
                "craftingRedstoneTorch",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "repeater", 1, 0),
                "screwIron",
                null,
                "screwIron",
                "craftingRedstoneTorch",
                "craftingToolScrewdriver",
                "craftingRedstoneTorch",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0),
                "stickRedAlloy",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "item_frame", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                "ringAnyIron",
                getModItem(Minecraft.ID, "string", 1, 0),
                "stickWood",
                "itemLeather",
                "stickWood",
                "stickWood",
                "stickWood",
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "fishing_rod", 1, 0),
                null,
                null,
                "stickLongWood",
                null,
                "stickLongWood",
                getModItem(Minecraft.ID, "string", 1, 0),
                "stickLongWood",
                "craftingToolWireCutter",
                "ringAnyIron");
        addShapedRecipe(
                getModItem(Minecraft.ID, "paper", 2, 0),
                "dustWood",
                "dustWood",
                "dustWood",
                "dustWood",
                getModItem(Minecraft.ID, "water_bucket", 1, 0),
                "dustWood",
                "dustWood",
                "dustWood",
                "dustWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "paper", 2, 0),
                "dustWood",
                "dustWood",
                "dustWood",
                "dustWood",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0),
                "dustWood",
                "dustWood",
                "dustWood",
                "dustWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Natura.ID, "barleyFood", 1, 3),
                getModItem(Natura.ID, "barleyFood", 1, 3),
                getModItem(Natura.ID, "barleyFood", 1, 3));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "flower_pot", 1, 0),
                "craftingToolFile",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketFired", 1, 0));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stone_slab", 1, 0),
                "craftingToolSaw",
                getModItem(EtFuturumRequiem.ID, "smooth_stone", 1, 0));

        // Cobble slabs
        ItemStack cobblestoneSlab = getModItem(Minecraft.ID, "stone_slab", 1, 3);
        ItemStack mossyCobbleOutputSlab = getModItem(EtFuturumRequiem.ID, "stone_slab", 1, 1);
        addShapelessRecipe(cobblestoneSlab, "craftingToolSaw", getModItem(Minecraft.ID, "cobblestone", 1, 0));
        addShapelessRecipe(
                mossyCobbleOutputSlab,
                "craftingToolSaw",
                getModItem(Minecraft.ID, "mossy_cobblestone", 1, 0));
        for (int meta = 0; meta < 16; meta++) {
            addShapelessRecipe(
                    cobblestoneSlab,
                    "craftingToolSaw",
                    getModItem(ExtraUtilities.ID, "color_stonebrick", 1, meta));
        }

        // Stone brick slabs
        ItemStack stoneBrickSlab = getModItem(Minecraft.ID, "stone_slab", 1, 5);
        ItemStack mossyStoneBrickOutputSlab = getModItem(EtFuturumRequiem.ID, "stone_slab", 1, 2);
        addShapelessRecipe(stoneBrickSlab, "craftingToolSaw", getModItem(Minecraft.ID, "stonebrick", 1, 0));
        addShapelessRecipe(mossyStoneBrickOutputSlab, "craftingToolSaw", getModItem(Minecraft.ID, "stonebrick", 1, 1));
        addShapelessRecipe(stoneBrickSlab, "craftingToolSaw", getModItem(Minecraft.ID, "stonebrick", 1, 2));
        addShapelessRecipe(stoneBrickSlab, "craftingToolSaw", getModItem(Minecraft.ID, "stonebrick", 1, 3));

        // Sandstone slabs
        ItemStack sandstoneSlab = getModItem(Minecraft.ID, "stone_slab", 1, 1);
        ItemStack cutSandstoneOutputSlab = getModItem(EtFuturumRequiem.ID, "stone_slab", 1, 3);
        addShapelessRecipe(sandstoneSlab, "craftingToolSaw", getModItem(Minecraft.ID, "sandstone", 1, 0));
        addShapelessRecipe(sandstoneSlab, "craftingToolSaw", getModItem(Minecraft.ID, "sandstone", 1, 1));
        addShapelessRecipe(cutSandstoneOutputSlab, "craftingToolSaw", getModItem(Minecraft.ID, "sandstone", 1, 2));

        ItemStack stoneBrick = getModItem(Minecraft.ID, "stonebrick", 1, 0);
        addShapedRecipe(
                getModItem(Minecraft.ID, "stone_brick_stairs", 4, 0),
                stoneBrick,
                null,
                null,
                stoneBrick,
                stoneBrick,
                null,
                stoneBrick,
                stoneBrick,
                stoneBrick);
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stone_slab", 1, 4),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "brick_block", 1, 0));
        addShapelessRecipe(getModItem(Minecraft.ID, "stone_slab", 1, 6), "craftingToolSaw", "stoneNetherBrick");
        addShapelessRecipe(getModItem(Minecraft.ID, "stone_slab", 1, 7), "craftingToolSaw", "blockQuartz");
        addShapedRecipe(
                getModItem(Minecraft.ID, "brick_block", 2, 0),
                "ingotBrick",
                "ingotBrick",
                "ingotBrick",
                "ingotBrick",
                getModItem(Minecraft.ID, "water_bucket", 1, 0),
                "ingotBrick",
                "ingotBrick",
                "ingotBrick",
                "ingotBrick");
        addShapedRecipe(
                getModItem(Minecraft.ID, "brick_block", 2, 0),
                "ingotBrick",
                "ingotBrick",
                "ingotBrick",
                "ingotBrick",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0),
                "ingotBrick",
                "ingotBrick",
                "ingotBrick",
                "ingotBrick");
        addShapedRecipe(
                getModItem(Minecraft.ID, "nether_brick", 2, 0),
                "ingotBrickNether",
                "ingotBrickNether",
                "ingotBrickNether",
                "ingotBrickNether",
                getModItem(Minecraft.ID, "lava_bucket", 1, 0),
                "ingotBrickNether",
                "ingotBrickNether",
                "ingotBrickNether",
                "ingotBrickNether");
        addShapedRecipe(
                getModItem(Minecraft.ID, "nether_brick", 2, 0),
                "ingotBrickNether",
                "ingotBrickNether",
                "ingotBrickNether",
                "ingotBrickNether",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketLava", 1, 0),
                "ingotBrickNether",
                "ingotBrickNether",
                "ingotBrickNether",
                "ingotBrickNether");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wooden_door", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 0),
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 0),
                "ringAnyIron",
                "screwAnyIron",
                getModItem(Minecraft.ID, "planks", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 0),
                "craftingToolSaw");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wooden_door", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 0),
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 0),
                "ringCopper",
                "screwCopper",
                getModItem(Minecraft.ID, "planks", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 0),
                "craftingToolSaw");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wooden_door", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 0),
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 0),
                "ringAnyIron",
                "screwAnyIron",
                getModItem(Minecraft.ID, "planks", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 0),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wooden_door", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 0),
                getModItem(Minecraft.ID, "trapdoor", 1, 0),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 0),
                "ringCopper",
                "screwCopper",
                getModItem(Minecraft.ID, "planks", 1, 0),
                getModItem(Minecraft.ID, "planks", 1, 0),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(Minecraft.ID, "iron_door", 1, 0),
                "plateAnyIron",
                NHItemList.SteelBars.get(),
                "craftingToolHardHammer",
                "plateAnyIron",
                "ringSteel",
                "screwSteel",
                "plateAnyIron",
                "plateAnyIron",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(Minecraft.ID, "iron_door", 1, 0),
                "plateAnyIron",
                NHItemList.SteelBars.get(),
                "craftingToolScrewdriver",
                "plateAnyIron",
                "ringSteel",
                "screwSteel",
                "plateAnyIron",
                "plateAnyIron",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Oak.get(1L),
                ItemList.Plank_Oak.get(1L),
                ItemList.Plank_Oak.get(1L),
                ItemList.Plank_Oak.get(1L),
                ItemList.Plank_Oak.get(1L),
                ItemList.Plank_Oak.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(EtFuturumRequiem.ID, "item_sign_spruce", 3, 0),
                ItemList.Plank_Spruce.get(1L),
                ItemList.Plank_Spruce.get(1L),
                ItemList.Plank_Spruce.get(1L),
                ItemList.Plank_Spruce.get(1L),
                ItemList.Plank_Spruce.get(1L),
                ItemList.Plank_Spruce.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(EtFuturumRequiem.ID, "item_sign_birch", 3, 0),
                ItemList.Plank_Birch.get(1L),
                ItemList.Plank_Birch.get(1L),
                ItemList.Plank_Birch.get(1L),
                ItemList.Plank_Birch.get(1L),
                ItemList.Plank_Birch.get(1L),
                ItemList.Plank_Birch.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(EtFuturumRequiem.ID, "item_sign_jungle", 3, 0),
                ItemList.Plank_Jungle.get(1L),
                ItemList.Plank_Jungle.get(1L),
                ItemList.Plank_Jungle.get(1L),
                ItemList.Plank_Jungle.get(1L),
                ItemList.Plank_Jungle.get(1L),
                ItemList.Plank_Jungle.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(EtFuturumRequiem.ID, "item_sign_acacia", 3, 0),
                ItemList.Plank_Acacia.get(1L),
                ItemList.Plank_Acacia.get(1L),
                ItemList.Plank_Acacia.get(1L),
                ItemList.Plank_Acacia.get(1L),
                ItemList.Plank_Acacia.get(1L),
                ItemList.Plank_Acacia.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(EtFuturumRequiem.ID, "item_sign_dark_oak", 3, 0),
                ItemList.Plank_DarkOak.get(1L),
                ItemList.Plank_DarkOak.get(1L),
                ItemList.Plank_DarkOak.get(1L),
                ItemList.Plank_DarkOak.get(1L),
                ItemList.Plank_DarkOak.get(1L),
                ItemList.Plank_DarkOak.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(EtFuturumRequiem.ID, "cherry_sign", 3, 0),
                ItemList.Plank_Cherry_EFR.get(1L),
                ItemList.Plank_Cherry_EFR.get(1L),
                ItemList.Plank_Cherry_EFR.get(1L),
                ItemList.Plank_Cherry_EFR.get(1L),
                ItemList.Plank_Cherry_EFR.get(1L),
                ItemList.Plank_Cherry_EFR.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Larch.get(1L),
                ItemList.Plank_Larch.get(1L),
                ItemList.Plank_Larch.get(1L),
                ItemList.Plank_Larch.get(1L),
                ItemList.Plank_Larch.get(1L),
                ItemList.Plank_Larch.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Teak.get(1L),
                ItemList.Plank_Teak.get(1L),
                ItemList.Plank_Teak.get(1L),
                ItemList.Plank_Teak.get(1L),
                ItemList.Plank_Teak.get(1L),
                ItemList.Plank_Teak.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Acacia_Green.get(1L),
                ItemList.Plank_Acacia_Green.get(1L),
                ItemList.Plank_Acacia_Green.get(1L),
                ItemList.Plank_Acacia_Green.get(1L),
                ItemList.Plank_Acacia_Green.get(1L),
                ItemList.Plank_Acacia_Green.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Lime.get(1L),
                ItemList.Plank_Lime.get(1L),
                ItemList.Plank_Lime.get(1L),
                ItemList.Plank_Lime.get(1L),
                ItemList.Plank_Lime.get(1L),
                ItemList.Plank_Lime.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Chestnut.get(1L),
                ItemList.Plank_Chestnut.get(1L),
                ItemList.Plank_Chestnut.get(1L),
                ItemList.Plank_Chestnut.get(1L),
                ItemList.Plank_Chestnut.get(1L),
                ItemList.Plank_Chestnut.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Wenge.get(1L),
                ItemList.Plank_Wenge.get(1L),
                ItemList.Plank_Wenge.get(1L),
                ItemList.Plank_Wenge.get(1L),
                ItemList.Plank_Wenge.get(1L),
                ItemList.Plank_Wenge.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Baobab.get(1L),
                ItemList.Plank_Baobab.get(1L),
                ItemList.Plank_Baobab.get(1L),
                ItemList.Plank_Baobab.get(1L),
                ItemList.Plank_Baobab.get(1L),
                ItemList.Plank_Baobab.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Sequoia.get(1L),
                ItemList.Plank_Sequoia.get(1L),
                ItemList.Plank_Sequoia.get(1L),
                ItemList.Plank_Sequoia.get(1L),
                ItemList.Plank_Sequoia.get(1L),
                ItemList.Plank_Sequoia.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Kapok.get(1L),
                ItemList.Plank_Kapok.get(1L),
                ItemList.Plank_Kapok.get(1L),
                ItemList.Plank_Kapok.get(1L),
                ItemList.Plank_Kapok.get(1L),
                ItemList.Plank_Kapok.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Ebony.get(1L),
                ItemList.Plank_Ebony.get(1L),
                ItemList.Plank_Ebony.get(1L),
                ItemList.Plank_Ebony.get(1L),
                ItemList.Plank_Ebony.get(1L),
                ItemList.Plank_Ebony.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Mahagony.get(1L),
                ItemList.Plank_Mahagony.get(1L),
                ItemList.Plank_Mahagony.get(1L),
                ItemList.Plank_Mahagony.get(1L),
                ItemList.Plank_Mahagony.get(1L),
                ItemList.Plank_Mahagony.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Balsa.get(1L),
                ItemList.Plank_Balsa.get(1L),
                ItemList.Plank_Balsa.get(1L),
                ItemList.Plank_Balsa.get(1L),
                ItemList.Plank_Balsa.get(1L),
                ItemList.Plank_Balsa.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Willow.get(1L),
                ItemList.Plank_Willow.get(1L),
                ItemList.Plank_Willow.get(1L),
                ItemList.Plank_Willow.get(1L),
                ItemList.Plank_Willow.get(1L),
                ItemList.Plank_Willow.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Walnut.get(1L),
                ItemList.Plank_Walnut.get(1L),
                ItemList.Plank_Walnut.get(1L),
                ItemList.Plank_Walnut.get(1L),
                ItemList.Plank_Walnut.get(1L),
                ItemList.Plank_Walnut.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Greenheart.get(1L),
                ItemList.Plank_Greenheart.get(1L),
                ItemList.Plank_Greenheart.get(1L),
                ItemList.Plank_Greenheart.get(1L),
                ItemList.Plank_Greenheart.get(1L),
                ItemList.Plank_Greenheart.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Cherry.get(1L),
                ItemList.Plank_Cherry.get(1L),
                ItemList.Plank_Cherry.get(1L),
                ItemList.Plank_Cherry.get(1L),
                ItemList.Plank_Cherry.get(1L),
                ItemList.Plank_Cherry.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Mahoe.get(1L),
                ItemList.Plank_Mahoe.get(1L),
                ItemList.Plank_Mahoe.get(1L),
                ItemList.Plank_Mahoe.get(1L),
                ItemList.Plank_Mahoe.get(1L),
                ItemList.Plank_Mahoe.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Poplar.get(1L),
                ItemList.Plank_Poplar.get(1L),
                ItemList.Plank_Poplar.get(1L),
                ItemList.Plank_Poplar.get(1L),
                ItemList.Plank_Poplar.get(1L),
                ItemList.Plank_Poplar.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Palm.get(1L),
                ItemList.Plank_Palm.get(1L),
                ItemList.Plank_Palm.get(1L),
                ItemList.Plank_Palm.get(1L),
                ItemList.Plank_Palm.get(1L),
                ItemList.Plank_Palm.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Papaya.get(1L),
                ItemList.Plank_Papaya.get(1L),
                ItemList.Plank_Papaya.get(1L),
                ItemList.Plank_Papaya.get(1L),
                ItemList.Plank_Papaya.get(1L),
                ItemList.Plank_Papaya.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Pine.get(1L),
                ItemList.Plank_Pine.get(1L),
                ItemList.Plank_Pine.get(1L),
                ItemList.Plank_Pine.get(1L),
                ItemList.Plank_Pine.get(1L),
                ItemList.Plank_Pine.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Plum.get(1L),
                ItemList.Plank_Plum.get(1L),
                ItemList.Plank_Plum.get(1L),
                ItemList.Plank_Plum.get(1L),
                ItemList.Plank_Plum.get(1L),
                ItemList.Plank_Plum.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Maple.get(1L),
                ItemList.Plank_Maple.get(1L),
                ItemList.Plank_Maple.get(1L),
                ItemList.Plank_Maple.get(1L),
                ItemList.Plank_Maple.get(1L),
                ItemList.Plank_Maple.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0),
                ItemList.Plank_Citrus.get(1L),
                ItemList.Plank_Citrus.get(1L),
                ItemList.Plank_Citrus.get(1L),
                ItemList.Plank_Citrus.get(1L),
                ItemList.Plank_Citrus.get(1L),
                ItemList.Plank_Citrus.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "boat", 1, 0),
                "plankWood",
                null,
                "plankWood",
                "plankWood",
                "craftingToolKnife",
                "plankWood",
                "slabWood",
                "slabWood",
                "slabWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "painting", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                "ringAnyIron",
                getModItem(Minecraft.ID, "string", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "carpet", 1, wildcard),
                "stickWood",
                "stickWood",
                "stickWood",
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "flint_and_steel", 1, 0),
                null,
                "gearGtSmallSteel",
                null,
                null,
                getModItem(Minecraft.ID, "flint", 1, 0),
                null,
                null,
                "springSmallSteel",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "shears", 1, 0),
                "plateIron",
                "screwIron",
                "plateIron",
                "craftingToolHardHammer",
                "ringIron",
                "craftingToolFile",
                "stickWood",
                "craftingToolScrewdriver",
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "mossy_cobblestone", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(Minecraft.ID, "cobblestone", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0));
        addShapedRecipe(
                getModItem(Minecraft.ID, "book", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                "paperEmpty",
                "itemLeather",
                getModItem(Minecraft.ID, "string", 1, 0),
                "paperEmpty",
                getModItem(TinkerConstruct.ID, "buckets", 1, 25),
                getModItem(Minecraft.ID, "string", 1, 0),
                "paperEmpty",
                "itemLeather");
        addShapedRecipe(
                getModItem(Minecraft.ID, "bookshelf", 1, 0),
                "plateWood",
                "plateWood",
                "plateWood",
                getModItem(Minecraft.ID, "book", 1, 0),
                getModItem(Minecraft.ID, "book", 1, 0),
                getModItem(Minecraft.ID, "book", 1, 0),
                "plateWood",
                "plateWood",
                "plateWood");
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.nugget, Materials.Iron, 9),
                "craftingToolSaw",
                "ingotIron",
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "gold_nugget", 9, 0),
                "craftingToolSaw",
                "ingotGold",
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        GTModHandler.addCraftingRecipe(
                new ItemStack(Blocks.ender_chest, 1),
                BITS,
                new Object[] { "ABA", "ACA", "ADA", 'A', "plateObsidian", 'B', "plateDenseEnderium", 'C',
                        getModItem(EnderStorage.ID, "enderChest", 1, 0), 'D',
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45) });

    }
}
