package com.dreammaster.modess;

import com.dreammaster.creativetab.ModTabList;
import com.dreammaster.main.MainRegistry;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class EESHandler {
    public final Block block;

    public EESHandler() {
        block = new BlockEldritchElementalSplitter()
                .setCreativeTab(MainRegistry.TabManager.GetCreativeTabInstance(ModTabList.ModThaumcraftTab));
        GameRegistry.registerBlock(block, "eesblock");
        TileEntity.addMapping(TEESS.class, "EldritchElementalSplitter");
        // TODO move this to proxy
        if (FMLCommonHandler.instance().getSide().isClient()) {
            ClientRegistry.bindTileEntitySpecialRenderer(TEESS.class, new RendererEldritchElementalSplitter());
        }
    }
}
