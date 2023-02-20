package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import gregtech.api.enums.ItemList;

public class ScriptThaumicEnergistics implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "ThaumicEnergistics";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList("dreamcraft", "TaintedMagic", "gadomancy", "Thaumcraft", "thaumicenergistics");
    }

    @Override
    public void loadRecipes() {
        // Creates ItemStack for CEC craft input
        ItemStack[] CECInfusionItems = { ItemList.Field_Generator_UIV.get(1),
                getModItem("TaintedMagic", "ItemFocusEldritch", 1),
                getModItem("gadomancy", "BlockNodeManipulator", 1, 5),
                getModItem("gadomancy", "BlockEssentiaCompressor", 1), ItemList.Field_Generator_UIV.get(1),
                getModItem("TaintedMagic", "ItemFocusEldritch", 1),
                getModItem("gadomancy", "BlockNodeManipulator", 1, 5),
                getModItem("gadomancy", "BlockEssentiaCompressor", 1), ItemList.Field_Generator_UIV.get(1),
                getModItem("TaintedMagic", "ItemFocusEldritch", 1),
                getModItem("gadomancy", "BlockNodeManipulator", 1, 5),
                getModItem("gadomancy", "BlockEssentiaCompressor", 1), ItemList.Field_Generator_UIV.get(1),
                getModItem("TaintedMagic", "ItemFocusEldritch", 1),
                getModItem("gadomancy", "BlockNodeManipulator", 1, 5),
                getModItem("gadomancy", "BlockEssentiaCompressor", 1) };

        // ItemStacks for in/out
        ItemStack SingularityDrive = getModItem("eternalsingularity", "eternal_singularity", 1);
        ItemStack CEC = getModItem("thaumicenergistics", "storage.essentia", 1, 4);

        ThaumcraftApi.addInfusionCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                CEC,
                10,
                new AspectList().add(Aspect.AIR, 2000).add(Aspect.FIRE, 2000).add(Aspect.ORDER, 2000)
                        .add(Aspect.ENTROPY, 2000).add(Aspect.EARTH, 2000).add(Aspect.WATER, 2000),
                SingularityDrive,
                CECInfusionItems);
    }
}
