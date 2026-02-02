package com.dreammaster.client.util;

import java.net.URI;
import java.util.Arrays;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.event.GuiScreenEvent;

import org.lwjgl.opengl.GL11;

import com.dreammaster.lib.Refstrings;
import com.dreammaster.main.MainRegistry;
import com.gtnewhorizon.gtnhlib.util.FilesUtil;

import cpw.mods.fml.client.config.HoverChecker;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GTNHPauseScreen {

    private static final ResourceLocation GTNH_LOGO = new ResourceLocation(
            "dreamcraft",
            "textures/icon/GTNH_256x256.png");
    private static final int BUG_BUTTON_ID = -161518;
    private static final int WIKI_BUTTON_ID = -8998561;

    private HoverChecker shareToLANButtonHoverChecker;

    @SuppressWarnings("unchecked")
    @SubscribeEvent
    public void onInitGui(GuiScreenEvent.InitGuiEvent.Post event) {
        if (!(event.gui instanceof GuiIngameMenu)) return;
        final int buttonWidth = 80;
        event.buttonList.add(
                new GuiButton(
                        BUG_BUTTON_ID,
                        event.gui.width / 2 - 100 - 10 - buttonWidth,
                        event.gui.height / 4 + 24 - 16,
                        buttonWidth,
                        20,
                        StatCollector.translateToLocal("dreamcraft.pausemenu.bug")));
        event.buttonList.add(
                new GuiButton(
                        WIKI_BUTTON_ID,
                        event.gui.width / 2 - 100 - 10 - buttonWidth,
                        event.gui.height / 4 + 24 - 16 + 24,
                        buttonWidth,
                        20,
                        StatCollector.translateToLocal("dreamcraft.pausemenu.wiki")));
        // TODO add credits page

        // find the Share To LAN button and attach a tooltip to it
        for (Object element : event.buttonList) {
            if (element instanceof GuiButton button) {
                if (button.id == 7) {
                    shareToLANButtonHoverChecker = new HoverChecker(button, 200);
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onDrawScreen(GuiScreenEvent.DrawScreenEvent.Post event) {
        if (!(event.gui instanceof GuiIngameMenu)) return;
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        OpenGlHelper.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        event.gui.mc.getTextureManager().bindTexture(GTNH_LOGO);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        final int drawX = event.gui.width / 2 - 100 - 10 - 80 + (80 - 64) / 2;
        final int drawY = event.gui.height / 4 + 24 - 16 - 64;
        Gui.func_146110_a(drawX, drawY, 0f, 0f, 64, 64, 64f, 64f);
        GL11.glPopMatrix();

        drawShareToLANButtonTooltip(event.gui, event.mouseX, event.mouseY);
    }

    @SubscribeEvent
    public void onActionPerformed(GuiScreenEvent.ActionPerformedEvent.Post event) {
        if (!(event.gui instanceof GuiIngameMenu)) return;
        if (event.button.id == BUG_BUTTON_ID) {
            gtnh$openUrl(Refstrings.ISSUE_TRACKER_LINK);
        } else if (event.button.id == WIKI_BUTTON_ID) {
            gtnh$openUrl(Refstrings.WIKI_LINK);
        }
    }

    private static void gtnh$openUrl(String address) {
        try {
            final URI uri = new URI(address);
            FilesUtil.openUri(uri);
        } catch (Throwable throwable) {
            MainRegistry.LOGGER.error("Couldn't open link", throwable);
        }
    }

    private void drawShareToLANButtonTooltip(GuiScreen gui, int x, int y) {
        if (shareToLANButtonHoverChecker != null && shareToLANButtonHoverChecker.checkHover(x, y)) {
            gui.func_146283_a(
                    Arrays.asList(
                            StatCollector.translateToLocal("dreamcraft.pausemenu.sharetolan.tooltip").split("\\\\n")),
                    x,
                    y);
        }
    }

}
