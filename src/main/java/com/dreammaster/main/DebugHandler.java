package com.dreammaster.main;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import com.dreammaster.lib.Refstrings;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public final class DebugHandler {

    @SubscribeEvent
    public void onDrawDebug(RenderGameOverlayEvent.Text event) {
        if (Minecraft.getMinecraft().gameSettings.showDebugInfo) {
            if (MainRegistry.CoreConfig.ModDebugVersionDisplay_Enabled) {
                final String text = String.format("%s %s", Refstrings.NAME, Refstrings.MODPACKPACK_VERSION);
                if (event.left.isEmpty()) {
                    event.left.add(text);
                } else {
                    event.left.add(1, text);
                }
            }
        }
    }
}
