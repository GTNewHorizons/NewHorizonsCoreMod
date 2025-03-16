package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.util.GTModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Mods;
import gregtech.api.util.GTModHandler;

public class ScriptOpenComputers implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Open Computers";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.OpenComputers.ID, HardcoreEnderExpansion.ID, IndustrialCraft2.ID);
    }

    public static ItemStack getTransposer(int aAmount, int rate) {
        ItemStack transposer = GTModHandler.getModItem(OpenComputers.ID, "transposer", aAmount, 0);
        transposer.setTagCompound(new NBTTagCompound());
        transposer.getTagCompound().setInteger("oc:fluidTransferRate", rate);
        return transposer;
    }

    @Override
    public void loadRecipes() {
        addShapelessRecipe(
                getModItem(OpenComputers.ID, "item", 1, 23, missing),
                ItemList.Circuit_Parts_Transistor.get(1));
        addShapelessRecipe(
                ItemList.Circuit_Parts_Transistor.get(1),
                getModItem(OpenComputers.ID, "item", 1, 23, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(OpenComputers.ID, "item", 1, 69, missing),
                "---------",
                "---------",
                "--aaaaa--",
                "--abcba--",
                "--adeda--",
                "--abcba--",
                "--aaaaa--",
                "---------",
                "---------",
                'a',
                "circuitMaster",
                'b',
                "circuitElite",
                'c',
                "circuitSuperconductor",
                'd',
                getModItem(OpenComputers.ID, "item", 1, 103, missing),
                'e',
                getModItem(OpenComputers.ID, "case3", 1, 0, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(OpenComputers.ID, "item", 1, 103, missing),
                "---------",
                "---------",
                "--aaaaa--",
                "--abcba--",
                "--adefa--",
                "--abcba--",
                "--aaaaa--",
                "---------",
                "---------",
                'a',
                "circuitElite",
                'b',
                "circuitMaster",
                'c',
                "circuitSuperconductor",
                'd',
                getModItem(OpenComputers.ID, "item", 1, 10, missing),
                'e',
                getModItem(OpenComputers.ID, "item", 1, 102, missing),
                'f',
                getModItem(OpenComputers.ID, "item", 1, 43, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(OpenComputers.ID, "item", 1, 90, missing),
                "---------",
                "---------",
                "--abcbd--",
                "--eeeee--",
                "--efgfe--",
                "--eeeee--",
                "--dbcba--",
                "---------",
                "---------",
                'a',
                "wireGt16Electrum",
                'b',
                "circuitMaster",
                'c',
                "circuitSuperconductor",
                'd',
                "circuitElite",
                'e',
                "plateDenseObsidian",
                'f',
                getModItem(IndustrialCraft2.ID, "itemRTGPellet", 1, 0, missing),
                'g',
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 6, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(OpenComputers.ID, "item", 1, 93, missing),
                "---------",
                "---------",
                "--abcba--",
                "--ddedd--",
                "--dfgfd--",
                "--ddddd--",
                "--abcba--",
                "---------",
                "---------",
                'a',
                "circuitMaster",
                'b',
                "circuitElite",
                'c',
                "circuitSuperconductor",
                'd',
                "plateDenseChrome",
                'e',
                getModItem(OpenComputers.ID, "screen3", 1, 0, missing),
                'f',
                getModItem(IndustrialCraft2.ID, "itemRTGPellet", 1, 0, missing),
                'g',
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 6, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(OpenComputers.ID, "item", 1, 91, missing),
                "---------",
                "---------",
                "--ababa--",
                "--cdedc--",
                "--fdgdf--",
                "--cdedc--",
                "--ababa--",
                "---------",
                "---------",
                'a',
                "circuitMaster",
                'b',
                ItemList.Electric_Motor_LuV.get(1L),
                'c',
                "circuitElite",
                'd',
                "turbineBladeChrome",
                'e',
                "circuitSuperconductor",
                'f',
                getModItem(HardcoreEnderExpansion.ID, "biome_compass", 1, 0, missing),
                'g',
                getModItem(OpenComputers.ID, "item", 1, 90, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(OpenComputers.ID, "item", 1, 114, missing),
                "aaaaaaaaa",
                "abacdcaba",
                "aaaaaaaaa",
                "abaefeaba",
                "aaaagaaaa",
                "abaefeaba",
                "aaaaaaaaa",
                "abacdcaba",
                "aaaaaaaaa",
                'a',
                getModItem(OpenComputers.ID, "item", 1, 72, missing),
                'b',
                getModItem(OpenComputers.ID, "item", 1, 39, missing),
                'c',
                getModItem(OpenComputers.ID, "item", 1, 26, missing),
                'd',
                getModItem(OpenComputers.ID, "item", 1, 106, missing),
                'e',
                ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                'f',
                "circuitSuperconductor",
                'g',
                getModItem(OpenComputers.ID, "item", 1, 7, missing));

    }
}
