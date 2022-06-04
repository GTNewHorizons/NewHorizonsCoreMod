package com.dreammaster.modfixes.GTpp;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;

import com.dreammaster.lib.Refstrings;

import net.minecraft.util.ResourceLocation;

public class GregTechPlusPlusAbandonedAspectsFix {

    /**
     * Custom aspects for GTNH.
     * <blockquote><table>
     * <tr><th>Array Index<th>Aspect    <th>Components
     * <tr><td>0          <td>Aequalitas<td>Cognito + Ordo
     * <tr><td>1          <td>Vesania   <td>Cognito + Vitium
     * <tr><td>2          <td>Primordium<td>Vacous  + Motus
     * <tr><td>3          <td>Astrum    <td>Lux + Primordium
     * <tr><td>4          <td>Gloria    <td>Humanus + Iter
     * </table></blockquote>
     * @author glowredman
     * @author bartimaeusnek
     */
    public static Object[] CUSTOMASPECTCOMPAT = new Object[5];

    static {
        try {
            Class<?> mAspectClass = Class.forName("thaumcraft.api.aspects.Aspect");
            Class<?> mNamedAspectClass = Class.forName("com.dreammaster.modfixes.GTpp.LocalizedAspect");
            Object[] tmpArray = new Object[5];
            Constructor<?> aspectConstructor = mNamedAspectClass.getConstructor(String.class, int.class, Array.newInstance(mAspectClass, 1).getClass(), ResourceLocation.class, int.class);

            for (int i = 0; i < tmpArray.length; i++) {
                tmpArray[i] = Array.newInstance(mAspectClass, 2);
            }

            //Aequalitas
            Array.set(tmpArray[0], 0, mAspectClass.getField("MIND").get(null));
            Array.set(tmpArray[0], 1, mAspectClass.getField("ORDER").get(null));
            CUSTOMASPECTCOMPAT[0] = aspectConstructor.newInstance("custom1", 0xEEF0EA, tmpArray[0], new ResourceLocation(Refstrings.MODID + ":textures/thaumcraft/aspect/aequalitas.png"), 1);
            //Vesania
            Array.set(tmpArray[1], 0, mAspectClass.getField("MIND").get(null));
            Array.set(tmpArray[1], 1, mAspectClass.getField("TAINT").get(null));
            CUSTOMASPECTCOMPAT[1] = aspectConstructor.newInstance("custom2", 0x1B122C, tmpArray[1], new ResourceLocation(Refstrings.MODID + ":textures/thaumcraft/aspect/vesania.png"), 1);
            //Primordium
            Array.set(tmpArray[2], 0, mAspectClass.getField("VOID").get(null));
            Array.set(tmpArray[2], 1, mAspectClass.getField("MOTION").get(null));
            CUSTOMASPECTCOMPAT[2] = aspectConstructor.newInstance("custom3", 0xF7F7DB, tmpArray[2], new ResourceLocation(Refstrings.MODID + ":textures/thaumcraft/aspect/primordium.png"), 1);
            //Astrum
            Array.set(tmpArray[3], 0, mAspectClass.getField("LIGHT").get(null));
            Array.set(tmpArray[3], 1, CUSTOMASPECTCOMPAT[2]);
            CUSTOMASPECTCOMPAT[3] = aspectConstructor.newInstance("custom4", 0x2D2C2B, tmpArray[3], new ResourceLocation(Refstrings.MODID + ":textures/thaumcraft/aspect/astrum.png"), 1);
            //Gloria
            Array.set(tmpArray[4], 0, mAspectClass.getField("MAN").get(null));
            Array.set(tmpArray[4], 1, mAspectClass.getField("TRAVEL").get(null));
            CUSTOMASPECTCOMPAT[4] = aspectConstructor.newInstance("custom5", 0xFFE980, tmpArray[4], new ResourceLocation(Refstrings.MODID + ":textures/thaumcraft/aspect/gloria.png"), 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
