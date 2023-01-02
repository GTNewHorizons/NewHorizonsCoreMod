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
                        .add(Aspect.AIR, 1)
                        .add(Aspect.FIRE, 1)
                        .add(Aspect.ORDER, 1)
                        .add(Aspect.ENTROPY, 1)
                        .add(Aspect.EARTH, 1)
                        .add(Aspect.WATER, 1),
                SingularityDrive,
                CECInfusionItems);
    }
}
