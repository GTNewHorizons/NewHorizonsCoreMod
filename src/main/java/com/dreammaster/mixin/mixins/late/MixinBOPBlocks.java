package com.dreammaster.mixin.mixins.late;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.dreammaster.biomesoplenty.BOPWoodTypes;
import com.dreammaster.biomesoplenty.BlockBOPFence;
import com.dreammaster.biomesoplenty.BlockBOPFenceGate;

import biomesoplenty.common.core.BOPBlocks;

@Mixin(value = BOPBlocks.class, remap = false)
public class MixinBOPBlocks {

    @Inject(method = "registerBlocks", at = @At("RETURN"))
    private static void registerBlocks(CallbackInfo ci) {
        for (BOPWoodTypes woodType : BOPWoodTypes.values()) {
            BOPBlocks.registerBlock(new BlockBOPFence(woodType.name()).setBlockName(woodType.name() + "Fence"));
            BOPBlocks.registerBlock(new BlockBOPFenceGate(woodType.name()).setBlockName(woodType.name() + "FenceGate"));
        }
    }
}
