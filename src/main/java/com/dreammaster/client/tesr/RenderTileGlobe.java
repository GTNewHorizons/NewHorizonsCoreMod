package com.dreammaster.client.tesr;

import com.dreammaster.common.tile.TileGlobe;
import com.dreammaster.lib.Refstrings;
import cpw.mods.fml.client.FMLClientHandler;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class RenderTileGlobe extends TileEntitySpecialRenderer {

    public static final Object2ObjectOpenHashMap<String, ResourceLocation> RESOURCES = new Object2ObjectOpenHashMap<>();

    public static final ResourceLocation iner_model_texture = new ResourceLocation(
            Refstrings.MODID,
            "textures/models/Earth.png");
    public static IModelCustom modelCustom;

    public RenderTileGlobe() {
        modelCustom = AdvancedModelLoader
                .loadModel(new ResourceLocation(Refstrings.MODID, "models/Earth.obj"));
    }

    @Override
    public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float timeSinceLastTick) {
        if (!(tile instanceof TileGlobe globe)) return;

        float scale = 0.01f * globe.getSize();

        GL11.glPushMatrix();
        GL11.glColor4f(1F, 1F, 1F, 1F);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 150f, 150f);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glTranslated(x + 0.5, y + 0.5, z + 0.5);
        var tex = RESOURCES.computeIfAbsent(globe.getName(), n -> new ResourceLocation(Refstrings.MODID, "textures/globe/" + n + ".png"));
        FMLClientHandler.instance().getClient().getTextureManager().bindTexture(tex);

        float brightness = (float) Math.abs(Math.sin(Minecraft.getSystemTime() / 3000f) * 100f);

        GL11.glScalef(scale, scale, scale);
        GL11.glPushMatrix();
        GL11.glRotatef(-180, 1F, 0F, 1F);
        GL11.glRotatef(90, 1F, 0F, 0F);
        if (globe.getRotationSpeed() != 0) {
            GL11.glRotatef((System.currentTimeMillis() / globe.getRotationSpeed()) % 360, 0F, 0F, 1F);
        }
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 80f + brightness, 80f + brightness);
        modelCustom.renderAll();
        GL11.glPopMatrix();

        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_LIGHTING);

        GL11.glPopMatrix();
    }
}