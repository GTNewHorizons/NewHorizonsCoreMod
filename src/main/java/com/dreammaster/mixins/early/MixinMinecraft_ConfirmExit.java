package com.dreammaster.mixins.early;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.minecraft.client.Minecraft;
import net.minecraft.util.StatCollector;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.dreammaster.client.util.IconLoader;
import com.dreammaster.coremod.DreamCoreMod;
import com.dreammaster.lib.Refstrings;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft_ConfirmExit {

    @Unique
    private boolean dreamcraft$isCloseRequested;

    @Unique
    private boolean dreamcraft$waitingDialogQuit;

    @Shadow
    public abstract void shutdown();

    @Inject(method = "shutdown", at = @At(value = "HEAD"), cancellable = true)
    private void dreamcraft$confirmGameShutdown(CallbackInfo ci) {
        if (!DreamCoreMod.showConfirmExitWindow || this.dreamcraft$isCloseRequested) {
            return;
        }
        if (!this.dreamcraft$waitingDialogQuit) {
            this.dreamcraft$waitingDialogQuit = true;
            new Thread(() -> {
                final JFrame frame = new JFrame();
                frame.setAlwaysOnTop(true);
                final URL resource = IconLoader.class.getClassLoader()
                        .getResource("assets/dreamcraft/textures/icon/GTNH_42x42.png");
                final ImageIcon imageIcon = resource == null ? null : new ImageIcon(resource);
                final Object[] options = new String[] {
                        dreamcraft$translateOrDefault("dreamcraft.gui.quitmessage.yes", "Yes"),
                        dreamcraft$translateOrDefault("dreamcraft.gui.quitmessage.no", "No"),
                        dreamcraft$translateOrDefault("dreamcraft.gui.quitmessage.never", "Don't Show Again!") };
                final int result = JOptionPane.showOptionDialog(
                        frame,
                        // When FML encounters an error, the only way to close the window is through the close button,
                        // which will show this message, unfortunately at this point, no localisations will have been
                        // loaded, so we add a hardcoded fallback message here.
                        dreamcraft$translateOrDefault(
                                "dreamcraft.gui.quitmessage",
                                "Are you sure you want to exit the game?"),
                        Refstrings.NAME,
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        imageIcon,
                        options,
                        null);
                if (result == JOptionPane.YES_OPTION) {
                    this.dreamcraft$isCloseRequested = true;
                    this.shutdown();
                } else if (result == JOptionPane.CANCEL_OPTION) {
                    this.dreamcraft$isCloseRequested = true;
                    DreamCoreMod.disableShowConfirmExitWindow();
                    this.shutdown();
                }
                this.dreamcraft$waitingDialogQuit = false;
            }).start();
        }
        ci.cancel();
    }

    @Unique
    private static String dreamcraft$translateOrDefault(String key, String defaultValue) {
        return StatCollector.canTranslate(key) ? StatCollector.translateToLocal(key) : defaultValue;
    }
}
