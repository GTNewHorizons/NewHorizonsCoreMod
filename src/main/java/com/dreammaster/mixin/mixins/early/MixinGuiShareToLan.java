package com.dreammaster.mixin.mixins.early;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiShareToLan;
import net.minecraft.util.ChatComponentTranslation;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiShareToLan.class)
public abstract class MixinGuiShareToLan extends GuiScreen {

    @Inject(
            method = "actionPerformed",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/GuiNewChat;printChatMessage(Lnet/minecraft/util/IChatComponent;)V",
                    shift = At.Shift.AFTER))
    private void dreamcraft$appendShareToLANChatMessage(GuiButton button, CallbackInfo ci) {
        this.mc.ingameGUI.getChatGUI()
                .printChatMessage(new ChatComponentTranslation("dreamcraft.gui.sharetolan.message"));
    }
}
