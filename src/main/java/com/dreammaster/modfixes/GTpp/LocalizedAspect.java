package com.dreammaster.modfixes.GTpp;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import thaumcraft.api.aspects.Aspect;

/**
 * A subclass of {@link Aspect} which allows localization of the aspect's name.
 * 
 * @author glowredman
 */
public class LocalizedAspect extends Aspect {

    /**
     * A subclass of {@link Aspect} which allows localization of the aspect's name.
     * <p>
     * Unlocalized name: <code>tc.aspect.{tag}.name</code>
     * 
     * @author glowredman
     */
    public LocalizedAspect(String tag, int color, Aspect[] components) {
        super(tag, color, components);
    }

    /**
     * A subclass of {@link Aspect} which allows localization of the aspect's name.
     * <p>
     * Unlocalized name: <code>tc.aspect.{tag}.name</code>
     * 
     * @author glowredman
     */
    public LocalizedAspect(String tag, int color, Aspect[] components, int blend) {
        super(tag, color, components, blend);
    }

    /**
     * A subclass of {@link Aspect} which allows localization of the aspect's name.
     * <p>
     * Unlocalized name: <code>tc.aspect.{tag}.name</code>
     * 
     * @author glowredman
     */
    public LocalizedAspect(String tag, int color, String chatcolor, int blend) {
        super(tag, color, chatcolor, blend);
    }

    /**
     * A subclass of {@link Aspect} which allows localization of the aspect's name.
     * <p>
     * Unlocalized name: <code>tc.aspect.{tag}.name</code>
     * 
     * @author glowredman
     */
    public LocalizedAspect(String tag, int color, Aspect[] components, ResourceLocation image, int blend) {
        super(tag, color, components, image, blend);
    }

    /**
     * Localized version of {@link Aspect#getName()}
     * <p>
     * Unlocalized name: <code>tc.aspect.{tag}.name</code>
     * 
     * @author glowredman
     */
    @Override
    public String getName() {
        return StatCollector.translateToLocal("tc.aspect." + this.getTag() + ".name");
    }
}
