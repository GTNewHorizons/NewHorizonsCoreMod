package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import gregtech.api.enums.GT_Values;
import gregtech.api.util.GT_Utility;
import java.util.Arrays;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class ScriptOpenBlocks implements IScriptLoader {

    public ScriptOpenBlocks() {}

    @Override
    public void initScriptData() {
        scriptName.setLength(0);
        scriptName.append("OpenBlocks");
        dependencies.clear();
        dependencies.addAll(Arrays.asList("OpenBlocks", "RandomThings", "ExtraUtilities", "gregtech"));
    }

    @Override
    public void loadRecipes() {
        ItemStack devNull = getModItem("OpenBlocks", "devnull", 1);
        ItemStack voidDropFilter = getModItem("RandomThings", "dropFilter", 1, 1);
        ItemStack trashCan = getModItem("ExtraUtilities", "trashcan", 1);
        ItemStack circuit1 = GT_Utility.getIntegratedCircuit(1);

        FluidStack ender250 = FluidRegistry.getFluidStack("ender", 250);

        addShapelessCraftingRecipe(devNull, new Object[] {voidDropFilter});

        GT_Values.RA.addAssemblerRecipe(new ItemStack[] {trashCan, circuit1}, ender250, devNull, 300, 30);
    }
}
