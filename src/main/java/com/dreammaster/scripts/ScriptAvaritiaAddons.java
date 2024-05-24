package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.AvaritiaAddons;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.hammerRecipes;
import static gregtech.api.recipe.RecipeMaps.plasmaArcFurnaceRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.avaritia.Config;
import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ScriptAvaritiaAddons implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Avaritia addons";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                AppliedEnergistics2.ID,
                AvaritiaAddons.ID,
                EternalSingularity.ID,
                GregTech.ID,
                Avaritia.ID,
                IronChests.ID,
                Witchery.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(AvaritiaAddons.ID, "CompressedChest", 1),
                "stickObsidian",
                ItemList.Electric_Piston_HV.get(1),
                "stickObsidian",
                "plateDenseObsidian",
                "chestObsidian",
                "plateDenseObsidian",
                "craftingToolWrench",
                getModItem(IronChests.ID, "BlockIronChest", 1, 9, missing),
                "craftingToolScrewdriver");

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 6),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 9),
                        ItemList.Electric_Piston_HV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Obsidian, 1),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(AvaritiaAddons.ID, "CompressedChest", 1)).duration(30 * SECONDS)
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
            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            getModItem(EternalSingularity.ID, "eternal_singularity", 8, 0, missing),
                            ItemList.Timepiece.get(1))
                    .itemOutputs(getModItem(EternalSingularity.ID, "combined_singularity", 1, 15, missing))
                    .fluidInputs(
                            MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter.getMolten(288),
                            MaterialsUEVplus.ExcitedDTSC.getFluid(10000))
                    .fluidOutputs(Materials.Hydrogen.getPlasma(576), Materials.Helium.getPlasma(576))
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_UXV).addTo(hammerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(getModItem(EternalSingularity.ID, "eternal_singularity", 1, 0, missing))
                    .itemOutputs(getModItem(EternalSingularity.ID, "combined_singularity", 1, 15, missing))
                    .fluidInputs(MaterialsUEVplus.Eternity.getMolten(144))
                    .fluidOutputs(Materials.Infinity.getMolten(576)).duration(5 * SECONDS).eut(TierEU.RECIPE_UXV)
                    .addTo(plasmaArcFurnaceRecipes);
        }
    }
}
