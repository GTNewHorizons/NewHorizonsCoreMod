package com.dreammaster.mixins.early;

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

}
