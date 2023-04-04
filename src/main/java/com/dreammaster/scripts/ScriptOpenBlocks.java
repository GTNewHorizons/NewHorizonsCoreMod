package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.RandomThings;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.util.GT_Utility;

public class ScriptOpenBlocks implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "OpenBlocks";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(OpenBlocks.ID, RandomThings.ID, ExtraUtilities.ID);
    }

    @Override
    public void loadRecipes() {
        ItemStack devNull = getModItem(OpenBlocks.ID, "devnull", 1);
        ItemStack voidDropFilter = getModItem(RandomThings.ID, "dropFilter", 1, 1);
        ItemStack trashCan = getModItem(ExtraUtilities.ID, "trashcan", 1);
        ItemStack circuit2 = GT_Utility.getIntegratedCircuit(2);

        FluidStack ender250 = FluidRegistry.getFluidStack("ender", 250);

        addShapelessCraftingRecipe(devNull, new Object[] { voidDropFilter });

        GT_Values.RA.addAssemblerRecipe(new ItemStack[] { trashCan, circuit2 }, ender250, devNull, 300, 30);
    }
}
