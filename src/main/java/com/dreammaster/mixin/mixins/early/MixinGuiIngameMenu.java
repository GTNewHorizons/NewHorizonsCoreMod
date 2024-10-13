package com.dreammaster.mixin.mixins.early;

import java.net.URI;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.dreammaster.main.MainRegistry;

@Mixin(GuiIngameMenu.class)
public class MixinGuiIngameMenu extends GuiScreen {

    @Unique
    private static final ResourceLocation gtnh$Logo = new ResourceLocation(
            "dreamcraft",
            "textures/icon/GTNH_256x256.png");

    @Inject(method = "initGui", at = @At("RETURN"))
    private void gtnh$addGTNHButtons(CallbackInfo ci) {
        final int buttonWidth = 80;
        this.buttonList.add(
                new GuiButton(
                        -161518,
                        this.width / 2 - 100 - 10 - buttonWidth,
                        this.height / 4 + 24 - 16,
                        buttonWidth,
                        20,
                        "Report a bug"));
        this.buttonList.add(
                new GuiButton(
                        -8998561,
                        this.width / 2 - 100 - 10 - buttonWidth,
                        this.height / 4 + 24 - 16 + 24,
                        buttonWidth,
                        20,
                        "Wiki"));
        // TODO add credits page
    }

    @Inject(method = "drawScreen", at = @At("RETURN"))
    private void gtnh$renderGTNHlogo(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        OpenGlHelper.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        this.mc.getTextureManager().bindTexture(gtnh$Logo);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        final int drawX = this.width / 2 - 100 - 10 - 80 + (80 - 64) / 2;
        final int drawY = this.height / 4 + 24 - 16 - 64;
        func_146110_a(drawX, drawY, 0f, 0f, 64, 64, 64f, 64f);
        GL11.glPopMatrix();
    }

    @Inject(method = "actionPerformed", at = @At("RETURN"))
    private void gtnh$GTNHAction(GuiButton button, CallbackInfo ci) {
        if (button.id == -161518) {
            gtnh$openUrl("https://github.com/GTNewHorizons/GT-New-Horizons-Modpack/issues");
        } else if (button.id == -8998561) {
            gtnh$openUrl("https://wiki.gtnewhorizons.com/wiki/Main_Page");
        }
    }

    @Unique
    private static void gtnh$openUrl(String address) {
        try {
            final URI uri = new URI(address);
            Class<?> oclass = Class.forName("java.awt.Desktop");
            Object object = oclass.getMethod("getDesktop", new Class[0]).invoke(null);
            oclass.getMethod("browse", new Class[] { URI.class }).invoke(object, uri);
        } catch (Throwable throwable) {
            MainRegistry.Logger.error("Couldn't open link", throwable);
        }
    }

}
