package com.dreammaster.modfixes.gravisuite;

import java.lang.reflect.Field;

import com.dreammaster.modfixes.ModFixBase;
import cpw.mods.fml.common.Loader;

public class HoverModeFix extends ModFixBase {

    public HoverModeFix() {
        super("HoverModeFix");
    }

    @Override
    public boolean needsForgeEventBus() {
        return false;
    }

    @Override
    public boolean needsFMLEventBus() {
        return false;
    }

    @Override
    public boolean getIsActive() {
        return Loader.isModLoaded("GraviSuite");
    }

    @Override
    public boolean init() {
        try {
            Field hoverModeFallSpeed = Class.forName("gravisuite.armor.ItemAdvancedJetPack")
                    .getDeclaredField("hoverModeFallSpeed");
            hoverModeFallSpeed.setAccessible(true);
            hoverModeFallSpeed.setInt(null, 0);
            return true;
        } catch (ReflectiveOperationException e) {
            return false;
        }
    }
}
