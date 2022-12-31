package com.dreammaster.modess;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class RendererEldritchElementalSplitter extends TileEntitySpecialRenderer
        implements IResourceManagerReloadListener {
    private static final ResourceLocation MODEL_LOCATION =
            new ResourceLocation("dreamcraft", "textures/models/ees.obj");
    private static final ResourceLocation TEXTURE_LOCATION =
            new ResourceLocation("dreamcraft", "textures/models/ees.png");
    private IModelCustom model;

    public RendererEldritchElementalSplitter() {
        IResourceManager manager = Minecraft.getMinecraft().getResourceManager();
        if (manager instanceof IReloadableResourceManager) {
            ((IReloadableResourceManager) manager).registerReloadListener(this);
        }
    }

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks) {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y, z + 0.5);
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE_LOCATION);
        model.renderAll();
        GL11.glPopMatrix();
    }

    @Override
    public void onResourceManagerReload(IResourceManager p_110549_1_) {
        model = AdvancedModelLoader.loadModel(MODEL_LOCATION);
    }
}
