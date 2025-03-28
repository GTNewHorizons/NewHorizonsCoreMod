package com.dreammaster.item;

import com.dreammaster.client.tesr.RenderTileGlobe;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderGlobeItem implements IItemRenderer {

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();

        if (type == ItemRenderType.INVENTORY) GL11.glRotated(180, 0, 1, 0);
        else if (type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
            GL11.glTranslated(0.5, 0.5, 0.5);
            if (type == ItemRenderType.EQUIPPED) GL11.glRotated(90, 0, 1, 0);
        }

        Minecraft.getMinecraft().renderEngine.bindTexture(RenderTileGlobe.iner_model_texture);
        GL11.glScaled(0.01, 0.01, 0.01);
        GL11.glRotatef(-180, 1F, 0F, 1F);
        GL11.glRotatef(90, 1F, 0F, 0F);
        GL11.glRotatef((System.currentTimeMillis() / 64f) % 360, 0F, 0F, 1F);
        RenderTileGlobe.modelCustom.renderAll();

        GL11.glPopMatrix();
    }
}