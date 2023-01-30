package com.dreammaster.modhazardousitems;

import net.minecraft.entity.player.EntityPlayer;

import com.dreammaster.modhazardousitems.cause.HazardCause;

public abstract class HazardEffect {

    protected abstract void apply(HazardCause cause, EntityPlayer player);
}
