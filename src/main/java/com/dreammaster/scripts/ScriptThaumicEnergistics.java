package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Gadomancy;
import static gregtech.api.enums.Mods.ThaumicEnergistics;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.TaintedMagic;
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
        return Arrays.asList(TaintedMagic.ID, Gadomancy.ID, ThaumicEnergistics.ID, EternalSingularity.ID);
    }

    @Override
    public void loadRecipes() {
        // Creates ItemStack for CEC craft input
        ItemStack[] CECInfusionItems = { ItemList.Field_Generator_UIV.get(1),
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1),
                getModItem(Gadomancy.ID, "BlockNodeManipulator", 1, 5),
                getModItem(Gadomancy.ID, "BlockEssentiaCompressor", 1), ItemList.Field_Generator_UIV.get(1),
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1),
                getModItem(Gadomancy.ID, "BlockNodeManipulator", 1, 5),
                getModItem(Gadomancy.ID, "BlockEssentiaCompressor", 1), ItemList.Field_Generator_UIV.get(1),
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1),
                getModItem(Gadomancy.ID, "BlockNodeManipulator", 1, 5),
                getModItem(Gadomancy.ID, "BlockEssentiaCompressor", 1), ItemList.Field_Generator_UIV.get(1),
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1),
                getModItem(Gadomancy.ID, "BlockNodeManipulator", 1, 5),
                getModItem(Gadomancy.ID, "BlockEssentiaCompressor", 1) };

        // ItemStacks for in/out
        ItemStack SingularityDrive = getModItem(EternalSingularity.ID, "eternal_singularity", 1);
        ItemStack CEC = getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 4);

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
