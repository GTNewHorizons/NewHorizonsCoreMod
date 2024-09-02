package com.dreammaster.oredict;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import gregtech.api.util.GTUtility;

public class OreDictHelper {

    private static List<ArrayList<ItemStack>> idToStack;

    @SuppressWarnings("unchecked")
    public static void removeOreDict(String oreDict, ItemStack toRemove) {
        if (idToStack == null) {
            try {
                Field idToStackField = OreDictionary.class.getDeclaredField("idToStack");
                idToStackField.setAccessible(true);
                idToStack = (List<ArrayList<ItemStack>>) idToStackField.get(null);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        idToStack.get(OreDictionary.getOreID(oreDict)).removeIf(s -> GTUtility.areStacksEqual(s, toRemove, true));
    }
}
