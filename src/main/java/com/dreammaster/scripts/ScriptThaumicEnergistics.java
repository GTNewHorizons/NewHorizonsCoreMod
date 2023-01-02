package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class ScriptThaumicEnergistics implements IScriptLoader {

    public ScriptThaumicEnergistics() {}

    @Override
    public void initScriptData() {
        scriptName.setLength(0);
        scriptName.append("ThaumicEnergistics");
        dependencies.clear();
        dependencies.addAll(java.util.Arrays.asList(
                "dreamcraft", "TaintedMagic", "gadomancy", "Thaumcraft", "thaumicenergistics", "extracells"));
    }

    @Override
    public void loadRecipes() {

        //Creates ItemStack for CEC craft input
        ItemStack[] CECInfusionItems = {
            getModItem("dreamcraft", "item.PikoCircuit", 1),
            getModItem("TaintedMagic", "ItemFocusDarkMatter", 1),
            getModItem("gadomancy", "BlockNodeManipulator", 1, 5),
            getModItem("gadomancy", "BlockEssentiaCompressor", 1),
            getModItem("dreamcraft", "item.PikoCircuit", 1),
            getModItem("TaintedMagic", "ItemFocusDarkMatter", 1),
            getModItem("gadomancy", "BlockNodeManipulator", 1, 5),
            getModItem("gadomancy", "BlockEssentiaCompressor", 1),
            getModItem("dreamcraft", "item.PikoCircuit", 1),
            getModItem("TaintedMagic", "ItemFocusDarkMatter", 1),
            getModItem("gadomancy", "BlockNodeManipulator", 1, 5),
            getModItem("gadomancy", "BlockEssentiaCompressor", 1),
            getModItem("dreamcraft", "item.PikoCircuit", 1),
            getModItem("TaintedMagic", "ItemFocusDarkMatter", 1),
            getModItem("gadomancy", "BlockNodeManipulator", 1, 5),
            getModItem("gadomancy", "BlockEssentiaCompressor", 1)
        };

        //ItemStacks for in/out
        ItemStack SingularityDrive = getModItem("extracells", "storage.physical.advanced.singularity", 1);
        ItemStack CEC = getModItem("thaumicenergistics", "storage.essentia", 1, 4);

        ThaumcraftApi.addInfusionCraftingRecipe(
                "INFUSION",
                CEC,
                0,
                new AspectList()
                        .add(Aspect.AIR, 2000)
                        .add(Aspect.FIRE, 2000)
                        .add(Aspect.ORDER, 2000)
                        .add(Aspect.ENTROPY, 2000)
                        .add(Aspect.EARTH, 2000)
                        .add(Aspect.WATER, 2000),
                SingularityDrive,
                CECInfusionItems);
    }
}
