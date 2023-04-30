package com.dreammaster.main;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import com.dreammaster.config.CoreModConfig;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public final class DebugHandler {

    @SubscribeEvent
    public void onDrawDebug(RenderGameOverlayEvent.Text event) {
        if (Minecraft.getMinecraft().gameSettings.showDebugInfo) {
            if (MainRegistry.CoreConfig.ModDebugVersionDisplay_Enabled) {
                event.left.add(1, String.format("%s %s", "GT: New Horizons", CoreModConfig.ModPackVersion));
            }
        }
    }
}
