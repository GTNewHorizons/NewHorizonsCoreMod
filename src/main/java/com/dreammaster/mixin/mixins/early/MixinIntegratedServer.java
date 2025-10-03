package com.dreammaster.mixin.mixins.early;

import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.world.WorldSettings;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(IntegratedServer.class)
public abstract class MixinIntegratedServer {

    @Inject(method = "shareToLAN", at = @At(value = "HEAD"), cancellable = true)
    public void dreamcraft$neuterShareToLAN(WorldSettings.GameType type, boolean allowCheats,
            CallbackInfoReturnable<String> cir) {
        cir.setReturnValue(null);
        cir.cancel();
    }
}
