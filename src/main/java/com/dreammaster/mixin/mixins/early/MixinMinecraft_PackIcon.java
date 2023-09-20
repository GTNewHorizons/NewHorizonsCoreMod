package com.dreammaster.mixin.mixins.early;

import java.nio.ByteBuffer;

import net.minecraft.client.Minecraft;

import org.lwjgl.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.dreammaster.client.util.IconLoader;

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
        return "GT: New Horizons";
    }

    @Redirect(
            method = "startGame",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/lwjgl/opengl/Display;setIcon([Ljava/nio/ByteBuffer;)I",
                    remap = false))
    private int dreadmcraft$changeWindowIcon(ByteBuffer[] buffer) {
        return this.dreamcraft$loadedGTNHIcon ? 0 : Display.setIcon(buffer);
    }

}
