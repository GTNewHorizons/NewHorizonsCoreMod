package com.dreammaster.mixins.late.witchery;

import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.emoniph.witchery.blocks.BlockSilverVat;

@Mixin(BlockSilverVat.class)
public class MixinBlockSilverVat {

    @Inject(method = "onBlockAdded", at = @At("HEAD"))
    private void witcheryextras$blockAdded(World world, int x, int y, int z, CallbackInfo ci) {
        world.setBlockToAir(x, y, z);
        world.removeTileEntity(x, y, z);
    }
}
