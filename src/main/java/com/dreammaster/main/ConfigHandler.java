package com.dreammaster.main;

import net.minecraft.client.Minecraft;
import net.minecraft.crash.CrashReport;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by danie_000 on 19.11.2016.
 */
public class ConfigHandler {

    public static final ConfigHandler CONFIG_HANDLER = new ConfigHandler();

    @SubscribeEvent
    public void onDrawBlockHighlight(DrawBlockHighlightEvent aEvent) {
        Error e = new Error();
        e.setStackTrace(new StackTraceElement[] {});

        try {
            Class.forName("net.minecraftxray.loader.XRayForgeTweaker");
            Minecraft.getMinecraft().crashed(new CrashReport("", e));
            return;
        } catch (Exception ignored) {}

        try {
            Class.forName("de.Kradxn.Xray.mod_Xray");
            Minecraft.getMinecraft().crashed(new CrashReport("", e));
            return;
        } catch (Exception ignored) {}

        MinecraftForge.EVENT_BUS.unregister(CONFIG_HANDLER);
    }
}
