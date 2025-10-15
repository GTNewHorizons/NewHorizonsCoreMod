package com.dreammaster.mixin.mixins.early;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiShareToLan;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(GuiShareToLan.class)
public abstract class MixinGuiShareToLan extends GuiScreen {

    @ModifyArg(
            method = "actionPerformed",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/GuiNewChat;printChatMessage(Lnet/minecraft/util/IChatComponent;)V"))
    public IChatComponent dreamcraft$changeShareToLANChatMessage(IChatComponent p_146227_1_) {

        return new ChatComponentTranslation("dreamcraft.gui.sharetolan.message");
    }
}
