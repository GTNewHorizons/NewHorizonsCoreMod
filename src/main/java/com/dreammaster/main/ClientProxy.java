package com.dreammaster.main;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import com.dreammaster.modbabychest.BlockBabyChest;
import com.dreammaster.modbabychest.RenderBabyChest;
import com.dreammaster.modbabychest.RenderItemBabyChest;
import com.dreammaster.modbabychest.TileEntityBabyChest;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy implements IResourceManagerReloadListener {

    @Override
    public void registerResourceReload() {
        ((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(this);
    }

    @Override
    public void registerRenderInfo() {
        BlockBabyChest.pRenderID = RenderingRegistry.getNextAvailableRenderId();
        TileEntitySpecialRenderer render = new RenderBabyChest();

        MinecraftForgeClient
                .registerItemRenderer(Item.getItemFromBlock(MainRegistry.blockBabyChest), new RenderItemBabyChest());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBabyChest.class, render);

        MinecraftForge.EVENT_BUS.register(new DebugHandler());
    }

    @Override
    public boolean isClient() {
        return true;
    }

    @Override
    public void onResourceManagerReload(IResourceManager p_110549_1_) {
        MainRegistry.Module_CustomToolTips.setConfigFileLocation();
        MainRegistry.Module_CustomToolTips.ReloadCustomToolTips();
    }
}
