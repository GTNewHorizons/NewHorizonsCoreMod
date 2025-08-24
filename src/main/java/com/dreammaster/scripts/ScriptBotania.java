package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.recipe.RecipeMaps.autoclaveRecipes;
import static gregtech.api.recipe.RecipeMaps.centrifugeRecipes;
import static gregtech.api.recipe.RecipeMaps.multiblockChemicalReactorRecipes;
import static gregtech.api.recipe.RecipeMaps.sifterRecipes;
import static gregtech.api.util.GTRecipeBuilder.EIGHTH_INGOTS;
import static gregtech.api.util.GTRecipeBuilder.INGOTS;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import forestry.api.apiculture.EnumBeeType;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsBotania;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTRecipeConstants;
import gregtech.common.items.CombType;
import gregtech.loaders.misc.GTBeeDefinition;
import gregtech.loaders.misc.GTBees;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.recipe.RecipeElvenTrade;
import vazkii.botania.common.item.ModItems;

public class ScriptBotania implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Botania";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Botania.ID);
    }

    @Override
    public void loadRecipes() {
        runBeeRecipes();
    }

    public void runBeeRecipes() {
        // Manasteel -> Manasteel Centrifuge
        GTValues.RA.stdBuilder().itemInputs(GTBees.combs.getStackForType(CombType.MANASTEEL, 4))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, MaterialsBotania.Manasteel, 1))
                .fluidInputs(Materials.Steel.getMolten(1 * INGOTS)).duration(33 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(GTRecipeConstants.UniversalChemical);

        // Elven -> Dragonstone Autoclave
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTBees.combs.getStackForType(CombType.ELVEN, 6),
                        GTOreDictUnificator.get(OrePrefixes.gemFlawless, MaterialsBotania.ManaDiamond, 1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.gem, MaterialsBotania.BotaniaDragonstone, 1))
                .fluidInputs(Materials.Void.getMolten(1 * EIGHTH_INGOTS)).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(autoclaveRecipes);

        // Elven -> Pixie Dust Centrifuge
        GTValues.RA.stdBuilder().itemInputs(GTBees.combs.getStackForType(CombType.ELVEN, 1))
                .itemOutputs(new ItemStack(ModItems.manaResource, 1, 8)).outputChances(50 * 100).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);

        // Elven -> Eleven Elementium LCR
        GTValues.RA.stdBuilder().itemInputs(GTBees.combs.getStackForType(CombType.ELVEN, 4))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, MaterialsBotania.ElvenElementium, 1))
                .fluidInputs(MaterialsBotania.Manasteel.getMolten(2 * INGOTS)).duration(33 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(GTRecipeConstants.UniversalChemical);

        // Terrasteel -> Terrasteel LCR
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTBees.combs.getStackForType(CombType.TERRASTEEL, 4),
                        GTOreDictUnificator.get(OrePrefixes.ingot, MaterialsBotania.Terrasteel, 1))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, MaterialsBotania.Terrasteel, 1),
                        GTOreDictUnificator.get(OrePrefixes.nugget, MaterialsBotania.Terrasteel, 1))
                .fluidInputs(MaterialsBotania.ElvenElementium.getMolten(4 * INGOTS)).outputChances(100 * 100, 10 * 100)
                .duration(33 * SECONDS).eut(TierEU.RECIPE_EV).addTo(GTRecipeConstants.UniversalChemical);

        // Gaia -> Gaia Spirit LCR w/Elementium
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTBees.combs.getStackForType(CombType.GAIASPIRIT, 4),
                        new ItemStack(ModItems.manaResource, 4, 8),
                        new ItemStack(ModItems.dice, 1))
                .itemOutputs(new ItemStack(ModItems.manaResource, 4, 5))
                .fluidInputs(MaterialsBotania.ElvenElementium.getMolten(4 * INGOTS)).duration(33 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(multiblockChemicalReactorRecipes);

        // Gaia -> Gaia Spirit LCR w/Terrasteel
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTBees.combs.getStackForType(CombType.GAIASPIRIT, 4),
                        new ItemStack(ModItems.manaResource, 4, 8),
                        new ItemStack(ModItems.dice, 1))
                .itemOutputs(new ItemStack(ModItems.manaResource, 6, 5))
                .fluidInputs(MaterialsBotania.Terrasteel.getMolten(2 * INGOTS)).duration(33 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(multiblockChemicalReactorRecipes);
        // MMM -> Mana Fly
        GTValues.RA.stdBuilder().itemInputs(GTBees.combs.getStackForType(CombType.MMM, 1))
                .itemOutputs(ItemList.ManaFly.get(1)).outputChances(80 * 100).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(centrifugeRecipes);

        // Sifting Mana Bunches
        GTValues.RA.stdBuilder().itemInputs(ItemList.ManaFly.get(1))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.nugget, MaterialsBotania.Manasteel, 1),
                        new ItemStack(ModItems.manaResource, 1, 16),
                        new ItemStack(ModItems.manaResource, 1, 23),
                        new ItemStack(ModItems.quartz, 1, 1),
                        GTOreDictUnificator.get(OrePrefixes.gem, MaterialsBotania.ManaDiamond, 1),
                        new ItemStack(ModItems.manaResource, 1, 1),
                        new ItemStack(ModItems.manaCookie, 1))
                .outputChances(25 * 100, 15 * 100, 15 * 100, 15 * 100, 5 * 100, 5 * 100, 1 * 10).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(sifterRecipes);

        // Manasteel Bee -> Elven Bee Trade
        RecipeElvenTrade tradeBeeElven = BotaniaAPI.registerElvenTradeRecipe(
                GTBeeDefinition.ELVEN.getMemberStack(EnumBeeType.DRONE),
                GTBeeDefinition.MANASTEEL.getMemberStack(EnumBeeType.DRONE));
    }
}
