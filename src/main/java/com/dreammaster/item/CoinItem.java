package com.dreammaster.item;

import com.dreammaster.lib.Refstrings;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class CoinItem extends Item {

    private final String coinType;
    private final int coinTier;

    private IIcon coinTypeIcon;

    public CoinItem(String coinType, int coinTier){
        this.coinType = coinType;
        this.coinTier = coinTier;
    }

    @Override
    public IIcon getIconFromDamageForRenderPass(int damage, int pass) {
        return pass == 0 ? itemIcon : coinTypeIcon;
    }

    @Override
    public boolean requiresMultipleRenderPasses() {
        return coinType != null;
    }

    @Override
    public void registerIcons(IIconRegister register) {
        itemIcon = register.registerIcon(Refstrings.MODID + ":coins/background/big" + coinTier);
        if(coinType != null){
            coinTypeIcon = register.registerIcon(Refstrings.MODID + ":coins/icons/" + coinType + coinTier);
        }
    }
}
