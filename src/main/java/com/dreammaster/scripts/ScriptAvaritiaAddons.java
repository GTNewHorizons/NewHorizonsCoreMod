package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.AvaritiaAddons;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

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
                new Object[] { "plateDenseObsidian", "plateDenseObsidian", "plateDenseObsidian", "chestDiamond",
                        ItemList.Electric_Piston_HV.get(1), "chestDiamond", "plateDenseObsidian", "plateDenseObsidian",
                        "plateDenseObsidian" });
        addShapedRecipe(
                getModItem(AvaritiaAddons.ID, "CompressedChest", 1),
                new Object[] { "stickObsidian", ItemList.Electric_Piston_HV.get(1), "stickObsidian",
                        "plateDenseObsidian", "chestObsidian", "plateDenseObsidian", "craftingToolWrench",
                        "chestDiamond", "craftingToolScrewdriver" });
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(IronChests.ID, "BlockIronChest", 2, 2),
                        ItemList.Electric_Piston_HV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Obsidian, 4),
                        GT_Utility.getIntegratedCircuit(1), },
                GT_Values.NF,
                getModItem(AvaritiaAddons.ID, "CompressedChest", 1),
                600,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(IronChests.ID, "BlockIronChest", 1, 6),
                        getModItem(IronChests.ID, "BlockIronChest", 1, 2), ItemList.Electric_Piston_HV.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Obsidian, 1),
                        GT_Utility.getIntegratedCircuit(3), },
                GT_Values.NF,
                getModItem(AvaritiaAddons.ID, "CompressedChest", 1),
                600,
                480);

        addShapedRecipe(
                getModItem(AvaritiaAddons.ID, "ExtremeAutoCrafter", 1),
                new Object[] { "plateRedAlloy", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744), "plateRedAlloy",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32603),
                        getModItem(Avaritia.ID, "Dire_Crafting", 1),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32603),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32633), "circuitElite",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32633) });

        // clearing NBT of th
        addShapelessCraftingRecipe(
                getModItem(AvaritiaAddons.ID, "ExtremeAutoCrafter", 1),
                new Object[] { getModItem(AvaritiaAddons.ID, "ExtremeAutoCrafter", 1, 32767), "platePaper" });

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
                getModItem(GregTech.ID, "gt.blockmachines", 1, 129),
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
    }
}
