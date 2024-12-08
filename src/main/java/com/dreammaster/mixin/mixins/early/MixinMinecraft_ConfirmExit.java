package com.dreammaster.mixin.mixins.early;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.minecraft.client.Minecraft;
import net.minecraft.util.StatCollector;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import com.dreammaster.client.util.IconLoader;
import com.dreammaster.coremod.DreamCoreMod;
import com.dreammaster.lib.Refstrings;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

@Mixin(Minecraft.class)
public class MixinMinecraft_ConfirmExit {

    @Unique
    private boolean dreamcraft$isCloseRequested;

    @Unique
    private boolean dreamcraft$waitingDialogQuit;

    @ModifyExpressionValue(
            method = "runGameLoop",
            at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/Display;isCloseRequested()Z", remap = false))
    private boolean dreamcraft$confirmGameShutdown(boolean isCloseRequested) {
        if (!DreamCoreMod.showConfirmExitWindow) {
            return isCloseRequested;
        }
        if (this.dreamcraft$isCloseRequested) {
            return true;
        }
        if (dreamcraft$waitingDialogQuit) return false;
        if (isCloseRequested) {
            dreamcraft$waitingDialogQuit = true;
            new Thread(() -> {
                final JFrame frame = new JFrame();
                frame.setAlwaysOnTop(true);
                final URL resource = IconLoader.class.getClassLoader()
                        .getResource("assets/dreamcraft/textures/icon/GTNH_42x42.png");
                final ImageIcon imageIcon = resource == null ? null : new ImageIcon(resource);
                final int result = JOptionPane.showConfirmDialog(
                        frame,
                        // When FML encounters an error, the only way to close the window is through the close button,
                        // which will show this message, unfortunately at this point, no localisations will have been
                        // loaded, so we add a hardcoded fallback message here.
                        StatCollector.canTranslate("dreamcraft.gui.quitmessage")
                                ? StatCollector.translateToLocal("dreamcraft.gui.quitmessage")
                                : "Are you sure you want to exit the game?",
                        Refstrings.NAME,
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        imageIcon);
                if (result == JOptionPane.YES_OPTION) {
                    this.dreamcraft$isCloseRequested = true;
                }
                dreamcraft$waitingDialogQuit = false;
            }).start();
            return false;
        }
        return false;
    }

}
