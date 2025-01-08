package com.dreammaster.variant.api;

import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerAboutToStartEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;

/**
 * A game variant which requires a full game load to properly initialize. Full game variants cannot be loaded on world
 * load, but must be configured externally and load alongside the full pack. <br>
 * <br>
 * A full game variant functions like a lightweight mod, this class mirrors an {@link cpw.mods.fml.common.Mod @Mod}
 * annotated class.
 *
 * @author serenibyss
 * @since todo
 */
public interface IFullGameVariant extends IGameVariant {

    default void construction(FMLConstructionEvent e) {}

    default void preInit(FMLPreInitializationEvent e) {}

    default void init(FMLInitializationEvent e) {}

    default void postInit(FMLPostInitializationEvent e) {}

    default void loadComplete(FMLLoadCompleteEvent e) {}

    default void serverAboutToStart(FMLServerAboutToStartEvent e) {}

    default void serverStarting(FMLServerStartingEvent e) {}

    default void serverStarted(FMLServerStartedEvent e) {}

    default void serverStopping(FMLServerStoppingEvent e) {}

    default void serverStopped(FMLServerStoppedEvent e) {}

    default void registerPackets() {}

    default boolean processIMC(FMLInterModComms.IMCMessage message) {
        return false;
    }
}
