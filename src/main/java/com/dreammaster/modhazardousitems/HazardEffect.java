package com.dreammaster.modhazardousitems;

import com.dreammaster.modhazardousitems.cause.HazardCause;
import net.minecraft.entity.player.EntityPlayer;

public abstract class HazardEffect {
    protected abstract void apply(HazardCause cause, EntityPlayer player);
}
