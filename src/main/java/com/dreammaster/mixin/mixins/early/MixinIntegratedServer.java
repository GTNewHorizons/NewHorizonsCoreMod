package com.dreammaster.mixin.mixins.early;

import java.io.File;
import java.net.Proxy;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.world.WorldSettings;

import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(IntegratedServer.class)
public abstract class MixinIntegratedServer extends MinecraftServer {

    @Shadow
    private static @Final Logger logger;

    public MixinIntegratedServer(File workDir, Proxy proxy) {
        super(workDir, proxy);
    }

    @Inject(method = "shareToLAN", at = @At(value = "HEAD"))
    public void dreamcraft$makeShareToLANSingleplayerOnly(WorldSettings.GameType type, boolean allowCheats,
            CallbackInfoReturnable<String> cir) {
        logger.info("Share to LAN was initiated. This is not officially supported by GTNH");
    }

}
