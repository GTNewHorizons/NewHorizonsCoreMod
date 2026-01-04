package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.AvaritiaAddons;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.UniversalSingularities;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.hammerRecipes;
import static gregtech.api.recipe.RecipeMaps.neutroniumCompressorRecipes;
import static gregtech.api.recipe.RecipeMaps.plasmaArcFurnaceRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.avaritia.Config;
import fox.spiteful.avaritia.blocks.LudicrousBlocks;
import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import fox.spiteful.avaritia.items.LudicrousItems;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.recipe.metadata.CompressionTierKey;
import gregtech.api.util.GTOreDictUnificator;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.item.block.ItemBlockSpecialFlower;

public class ScriptAvaritiaAddons implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Avaritia addons";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                AppliedEnergistics2.ID,
                Avaritia.ID,
                AvaritiaAddons.ID,
                Botania.ID,
                EternalSingularity.ID,
                ForbiddenMagic.ID,
                IronChests.ID,
                UniversalSingularities.ID,
                Witchery.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(AvaritiaAddons.ID, "CompressedChest", 1),
                "stickNichrome",
                ItemList.Electric_Piston_HV.get(1),
                "stickNichrome",
                "plateDenseObsidian",
                "chestObsidian",
                "plateDenseObsidian",
                "craftingToolWrench",
                getModItem(IronChests.ID, "BlockIronChest", 1, 9, missing),
                "craftingToolScrewdriver");

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 6),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 9),
                        ItemList.Electric_Piston_HV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Obsidian, 1),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Nichrome, 1))
                .circuit(1).itemOutputs(getModItem(AvaritiaAddons.ID, "CompressedChest", 1)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        addShapedRecipe(
                getModItem(AvaritiaAddons.ID, "ExtremeAutoCrafter", 1),
                "plateRedAlloy",
                ItemList.Cover_Crafting.get(1L),
                "plateRedAlloy",
                ItemList.Electric_Motor_EV.get(1L),
                getModItem(Avaritia.ID, "Dire_Crafting", 1),
                ItemList.Electric_Motor_EV.get(1L),
                ItemList.Conveyor_Module_EV.get(1L),
                "circuitElite",
                ItemList.Conveyor_Module_EV.get(1L));

        // clearing NBT of th
        addShapelessRecipe(
                getModItem(AvaritiaAddons.ID, "ExtremeAutoCrafter", 1),
                getModItem(AvaritiaAddons.ID, "ExtremeAutoCrafter", 1, wildcard),
                "platePaper");

        // Infinity Chest
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(AvaritiaAddons.ID, "InfinityChest", 1),
                "abbbcbbba",
                "bddefeddb",
                "bbbbabbbb",
                "bbbbabbbb",
                "cgggggggc",
                "bghhhhhgb",
                "bghhhhhgb",
                "bgggggggb",
                "abbbcbbba",
                'a',
                "blockCosmicNeutronium",
                'b',
                getModItem(Avaritia.ID, "Resource", 1),
                'c',
                "blockInfinity",
                'd',
                "ingotInfinity",
                'e',
                getModItem(Avaritia.ID, "Resource", 1, 5),
                'f',
                getModItem(EternalSingularity.ID, "eternal_singularity", 1),
                'g',
                ItemList.Quantum_Chest_IV.get(1L),
                'h',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 60));
        // Asgardandelion
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                ItemBlockSpecialFlower.ofType("asgardandelion"),
                "RXDXGXEXM",
                "X009i900X",
                "d0957490n",
                "X0iAZai0X",
                "T098B690r",
                "X109i901X",
                "t1102011H",
                "X0112110X",
                "eXK131SXm",
                'R',
                getModItem(Botania.ID, "corporeaSpark", 1, 1),
                'D',
                getModItem(Botania.ID, "rune", 1, 10),
                'G',
                getModItem(Botania.ID, "rune", 1, 9),
                'E',
                getModItem(Botania.ID, "rune", 1, 11),
                'M',
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 11),
                'd',
                getModItem(Botania.ID, "rune", 1, 12),
                'n',
                getModItem(Botania.ID, "rune", 1, 13),
                'T',
                getModItem(Botania.ID, "rune", 1, 14),
                'r',
                getModItem(Botania.ID, "rune", 1, 15),
                't',
                getModItem(Botania.ID, "rune", 1, 3),
                'H',
                getModItem(Botania.ID, "rune", 1, 6),
                'e',
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 7),
                'K',
                getModItem(Botania.ID, "rune", 1, 5),
                'X',
                getModItem(Botania.ID, "bifrostPermPane", 1, 0),
                '3',
                new ItemStack(ModItems.blackLotus, 1, 1),
                'S',
                getModItem(Botania.ID, "rune", 1, 4),
                'm',
                getModItem(Botania.ID, "lightRelay", 1, 1),
                'Z',
                new ItemStack(LudicrousBlocks.infinitato),
                '1',
                new ItemStack(LudicrousItems.resource, 1, 3), // Neutronium nugget
                '2',
                "blockCosmicNeutronium",
                'i',
                "plateInfinity",
                'A',
                "gemExquisiteBotaniaDragonstone",
                'a',
                "gemExquisiteManaDiamond",
                'B',
                "plateGaiaSpirit",
                '4',
                "plateLivingwood",
                '5',
                "plateLivingrock",
                '6',
                getModItem(ForbiddenMagic.ID, "WandCaps", 1, 5),
                '7',
                getModItem(ForbiddenMagic.ID, "WandCaps", 1, 3),
                '8',
                getModItem(ForbiddenMagic.ID, "WandCaps", 1, 2),
                '9',
                "nuggetInfinity");
        // Infinity Egg (Witchery)
        if (Config.witch) {

            Block egg = GameRegistry.findBlock(Witchery.ID, "infinityegg");

            ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                    new ItemStack(egg, 1, 0),
                    " NNNNNNN ",
                    "NCIIAIICN",
                    "NIIIDIIIN",
                    "NIIDHDIIN",
                    "NAIHEHIAN",
                    "NIIDHDIIN",
                    "NIIIDIIIN",
                    "NCIIAIICN",
                    " NNNNNNN ",
                    'D',
                    getModItem(Witchery.ID, "ingredient", 1, 23),
                    'N',
                    "plateCosmicNeutronium",
                    'H',
                    new ItemStack(Blocks.dragon_egg),
                    'E',
                    getModItem(Witchery.ID, "stew", 1),
                    'C',
                    getModItem(Witchery.ID, "chalkinfernal", 1),
                    'A',
                    getModItem(Witchery.ID, "chalkotherwhere", 1),
                    'I',
                    "plateInfinity");
        }
        // Chronic Singularity
        {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(EternalSingularity.ID, "eternal_singularity", 8, 0, missing),
                            ItemList.Timepiece.get(1))
                    .itemOutputs(getModItem(EternalSingularity.ID, "combined_singularity", 1, 15, missing))
                    .fluidInputs(Materials.MHDCSM.getMolten(288), Materials.ExcitedDTSC.getFluid(10000))
                    .fluidOutputs(Materials.Hydrogen.getPlasma(576), Materials.Helium.getPlasma(576))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_UXV).addTo(hammerRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(EternalSingularity.ID, "eternal_singularity", 1, 0, missing))
                    .itemOutputs(getModItem(EternalSingularity.ID, "combined_singularity", 1, 15, missing))
                    .fluidInputs(Materials.Eternity.getMolten(144)).fluidOutputs(Materials.Infinity.getMolten(576))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_UXV).addTo(plasmaArcFurnaceRecipes);

            // Spaghettic Singularity
            GTValues.RA.stdBuilder().itemInputs(
                    // fluxed electrum singularity
                    getModItem(UniversalSingularities.ID, "universal.general.singularity", 1L, 20))
                    .fluidInputs(Materials.Mellion.getMolten(4 * 144L))
                    .itemOutputs(getModItem(EternalSingularity.ID, "combined_singularity", 1L, 2)).duration(1 * SECONDS)
                    .eut(TierEU.RECIPE_UMV).metadata(CompressionTierKey.INSTANCE, 2).addTo(neutroniumCompressorRecipes);

            // Cryptic Singularity
            GTValues.RA.stdBuilder().itemInputs(
                    // iron singularity
                    getModItem(Avaritia.ID, "Singularity", 1L, 0)).fluidInputs(Materials.Creon.getMolten(4 * 144L))
                    .itemOutputs(getModItem(EternalSingularity.ID, "combined_singularity", 1L, 4)).duration(1 * SECONDS)
                    .eut(TierEU.RECIPE_UMV).metadata(CompressionTierKey.INSTANCE, 2).addTo(neutroniumCompressorRecipes);
        }
    }
}
