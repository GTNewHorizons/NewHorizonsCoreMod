package com.dreammaster.mixin.mixins.early;

import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import com.dreammaster.amazingtrophies.AchievementHandler;
import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalIntRef;

import gregtech.api.GregTechAPI;

@Mixin(TileEntityBeacon.class)
public class MixinTileEntityBeacon extends TileEntity {

    @Inject(
            at = @At(
                    target = "Lnet/minecraft/world/World;getBlock(III)Lnet/minecraft/block/Block;",
                    value = "INVOKE_ASSIGN"),
            locals = LocalCapture.CAPTURE_FAILEXCEPTION,
            method = "func_146003_y")
    private void dreamcraft$countEternalBlocks(CallbackInfo ci, int i, int j, int k, boolean flag, int l, int i1,
            Block block, @Share("eternalCount") LocalIntRef eternalCount) {
        if (block == GregTechAPI.sBlockMetal9 && this.worldObj.getBlockMetadata(l, k, i1) == 9) {
            eternalCount.set(eternalCount.get() + 1);
        }
    }

    @Inject(
            at = @At(
                    target = "Lnet/minecraft/entity/player/EntityPlayer;triggerAchievement(Lnet/minecraft/stats/StatBase;)V",
                    shift = Shift.AFTER,
                    value = "INVOKE"),
            locals = LocalCapture.CAPTURE_FAILEXCEPTION,
            method = "func_146003_y")
    private void dreamcraft$triggerAchievement(CallbackInfo ci, int i, Iterator<EntityPlayer> iterator,
            EntityPlayer entityplayer, @Share("eternalCount") LocalIntRef eternalCount) {
        if (eternalCount.get() == 164) {
            entityplayer.triggerAchievement(AchievementHandler.eternityBeaconAchievement);
        }
    }

}
