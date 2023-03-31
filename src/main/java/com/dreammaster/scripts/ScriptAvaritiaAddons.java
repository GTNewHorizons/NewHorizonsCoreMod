package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.avaritia.Config;
import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ScriptAvaritiaAddons implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Avaritia addons";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList("avaritiaddons", "eternalsingularity", "extracells", "gregtech", "Avaritia");
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("avaritiaddons", "CompressedChest", 1),
                new Object[] { "plateDenseObsidian", "plateDenseObsidian", "plateDenseObsidian", "chestDiamond",
                        ItemList.Electric_Piston_HV.get(1), "chestDiamond", "plateDenseObsidian", "plateDenseObsidian",
                        "plateDenseObsidian" });
        addShapedRecipe(
                getModItem("avaritiaddons", "CompressedChest", 1),
                new Object[] { "stickObsidian", ItemList.Electric_Piston_HV.get(1), "stickObsidian",
                        "plateDenseObsidian", "chestObsidian", "plateDenseObsidian", "craftingToolWrench",
                        "chestDiamond", "craftingToolScrewdriver" });
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem("IronChest", "BlockIronChest", 2, 2), ItemList.Electric_Piston_HV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Obsidian, 4),
                        GT_Utility.getIntegratedCircuit(1), },
                GT_Values.NF,
                getModItem("avaritiaddons", "CompressedChest", 1),
                600,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem("IronChest", "BlockIronChest", 1, 6),
                        getModItem("IronChest", "BlockIronChest", 1, 2), ItemList.Electric_Piston_HV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Obsidian, 1),
                        GT_Utility.getIntegratedCircuit(3), },
                GT_Values.NF,
                getModItem("avaritiaddons", "CompressedChest", 1),
                600,
                480);

        addShapedRecipe(
                getModItem("avaritiaddons", "ExtremeAutoCrafter", 1),
                new Object[] { "plateRedAlloy", getModItem("gregtech", "gt.metaitem.01", 1, 32744), "plateRedAlloy",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32603), getModItem("Avaritia", "Dire_Crafting", 1),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32603),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32633), "circuitElite",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32633) });

        // clearing NBT of th
        addShapelessCraftingRecipe(
                getModItem("avaritiaddons", "ExtremeAutoCrafter", 1),
                new Object[] { getModItem("avaritiaddons", "ExtremeAutoCrafter", 1, 32767), "platePaper" });

        // Infinity Chest
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("avaritiaddons", "InfinityChest", 1),
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
                getModItem("Avaritia", "Resource", 1),
                'c',
                "blockInfinity",
                'd',
                "ingotInfinity",
                'e',
                getModItem("Avaritia", "Resource", 1, 5),
                'f',
                getModItem("eternalsingularity", "eternal_singularity", 1),
                'g',
                getModItem("gregtech", "gt.blockmachines", 1, 129),
                'h',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 60));

        // Infinity Egg (Witchery)
        if (Loader.isModLoaded("witchery") && Config.witch) {

            Block egg = GameRegistry.findBlock("witchery", "infinityegg");

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
                    getModItem("witchery", "ingredient", 1, 23),
                    'N',
                    "plateCosmicNeutronium",
                    'H',
                    new ItemStack(Blocks.dragon_egg),
                    'E',
                    getModItem("witchery", "stew", 1),
                    'C',
                    getModItem("witchery", "chalkinfernal", 1),
                    'A',
                    getModItem("witchery", "chalkotherwhere", 1),
                    'I',
                    "plateInfinity");
        }
    }
}
