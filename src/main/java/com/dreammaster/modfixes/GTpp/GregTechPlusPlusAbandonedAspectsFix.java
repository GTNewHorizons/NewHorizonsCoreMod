package com.dreammaster.modfixes.GTpp;

import net.minecraft.util.ResourceLocation;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class GregTechPlusPlusAbandonedAspectsFix {

    static Object[] CUSTOMASPECTCOMPAT;
    static Constructor aspectConstructor;
    static Object[] tmpArray;
    static Class mAspectClass;
    static {
        try {
            mAspectClass = Class.forName("thaumcraft.api.aspects.Aspect");
            CUSTOMASPECTCOMPAT = new Object[5];
            tmpArray = new Object[5];
            aspectConstructor = mAspectClass.getConstructor(String.class, int.class, Array.newInstance(mAspectClass, 1).getClass(), ResourceLocation.class, int.class);
            for (int i = 0; i < tmpArray.length; i++) {
                tmpArray[i] = Array.newInstance(mAspectClass, 2);
            }
            Array.set(tmpArray[0], 0, mAspectClass.getField("COLD").get(null));
            Array.set(tmpArray[0], 1, mAspectClass.getField("FIRE").get(null));
            CUSTOMASPECTCOMPAT[0] = aspectConstructor.newInstance("custom1", 0x990099, tmpArray[0], new ResourceLocation("gregtech:textures/aspects/RADIO.png"), 1);
            Array.set(tmpArray[1], 0, mAspectClass.getField("MAGIC").get(null));
            Array.set(tmpArray[1], 1, mAspectClass.getField("SLIME").get(null));
            CUSTOMASPECTCOMPAT[1] = aspectConstructor.newInstance("custom2", 0xFFFF7F, tmpArray[1], new ResourceLocation("gregtech:textures/aspects/RADIO.png"), 1);
            Array.set(tmpArray[2], 0, mAspectClass.getField("ENERGY").get(null));
            Array.set(tmpArray[2], 1, mAspectClass.getField("ARMOR").get(null));
            CUSTOMASPECTCOMPAT[2] = aspectConstructor.newInstance("custom3", 0xC0FFFF, tmpArray[2], new ResourceLocation("gregtech:textures/aspects/RADIO.png"), 1);
            Array.set(tmpArray[3], 0, mAspectClass.getField("METAL").get(null));
            Array.set(tmpArray[3], 1, mAspectClass.getField("POISON").get(null));
            CUSTOMASPECTCOMPAT[3] = aspectConstructor.newInstance("custom4", 0xC0C0C0, tmpArray[3], new ResourceLocation("gregtech:textures/aspects/RADIO.png"), 1);
            Array.set(tmpArray[4], 0, mAspectClass.getField("LIGHT").get(null));
            Array.set(tmpArray[4], 1, mAspectClass.getField("SOUL").get(null));
            CUSTOMASPECTCOMPAT[4] = aspectConstructor.newInstance("custom5", 0xC0FFC0, tmpArray[4], new ResourceLocation("gregtech:textures/aspects/RADIO.png"), 1);
        } catch (NoSuchMethodException | ClassNotFoundException | NoSuchFieldException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
