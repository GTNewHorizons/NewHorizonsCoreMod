package com.dreammaster.mixin.mixins.early;

import java.net.URL;

import javax.swing.*;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Util;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import com.dreammaster.client.util.IconLoader;
import com.dreammaster.lib.Refstrings;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

@Mixin(Minecraft.class)
public class MixinMinecraft_PackIcon {

    @Unique
    private boolean dreamcraft$loadedGTNHIcon;

    @ModifyArg(
            method = "startGame",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/lwjgl/opengl/Display;setTitle(Ljava/lang/String;)V",
                    remap = false))
    private String dreamcraft$changeWindowTitle(String original) {
        this.dreamcraft$loadedGTNHIcon = IconLoader.setCustomIcon("assets/dreamcraft/textures/icon/GTNH_42x42.png");
        return Refstrings.NAME + " " + Refstrings.MODPACKPACK_VERSION;
    }

    @ModifyExpressionValue(
            method = "startGame",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Util;getOSType()Lnet/minecraft/util/Util$EnumOS;"))
    private Util.EnumOS dreadmcraft$changeWindowIcon(Util.EnumOS osType) {
        return this.dreamcraft$loadedGTNHIcon ? Util.EnumOS.OSX : osType;
    }

    @Unique
    private boolean dreamcraft$isCloseRequested;

    @ModifyExpressionValue(
            method = "runGameLoop",
            at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/Display;isCloseRequested()Z", remap = false))
    private boolean dreamcraft$confirmGameShutdown(boolean isCloseRequested) {
        if (this.dreamcraft$isCloseRequested) {
            return true;
        }
        if (isCloseRequested) {
            new Thread(() -> {
                final JFrame frame = new JFrame();
                frame.setAlwaysOnTop(true);
                final URL resource = IconLoader.class.getClassLoader()
                        .getResource("assets/dreamcraft/textures/icon/GTNH_42x42.png");
                final ImageIcon imageIcon = resource == null ? null : new ImageIcon(resource);
                final int result = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to exit the game ?",
                        Refstrings.NAME,
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        imageIcon);
                if (result == JOptionPane.YES_OPTION) {
                    this.dreamcraft$isCloseRequested = true;
                }
            }).start();
            return false;
        }
        return false;
    }

}
