package com.dreammaster.coremod;

import static net.minecraft.util.StatCollector.translateToLocal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

import org.apache.commons.io.Charsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RealWinGame extends GuiScreen {

    private static final Logger logger = LogManager.getLogger();
    private static final ResourceLocation field_146576_f = new ResourceLocation("mainmenu:textures/logo2.png");
    private static final ResourceLocation field_146577_g = new ResourceLocation("textures/misc/vignette.png");
    private static final ResourceLocation devlogo = new ResourceLocation("dreamcraft:textures/icon/dev.png");
    private static final ResourceLocation contributorlogo = new ResourceLocation(
            "dreamcraft:textures/icon/contributor.png");
    private static final ResourceLocation donorlogo = new ResourceLocation("dreamcraft:textures/icon/donor.png");
    private static final ResourceLocation gateforcelogo = new ResourceLocation(
            "dreamcraft:textures/icon/gateforce.png");
    private int field_146581_h;
    private List field_146582_i;
    private List admindesc;
    private List admin;
    private List staff;
    private List devdesc;
    private List dev;
    private List contributordesc;
    private List contributor;
    private List donordesc;
    private List donor;
    private List gatedesc;
    private List gate;
    private List cg;
    private int textsize;
    private int field_146579_r;
    private float field_146578_s = 0.5F;
    int y = 0;

    public RealWinGame() {}

    public void updateScreen() {
        ++this.field_146581_h;
        float f = (float) (this.field_146579_r + this.height + this.height + 24) / this.field_146578_s;
        if ((float) this.field_146581_h > f) {
            this.func_146574_g();
        }

    }

    protected void keyTyped(char typedChar, int keyCode) {
        if (keyCode == 1) {
            this.func_146574_g();
        }

    }

    private void func_146574_g() {
        this.mc.getSoundHandler().stopSounds();
        this.mc.displayGuiScreen((GuiScreen) null);
    }

    public boolean doesGuiPauseGame() {
        return true;
    }

    public void initGui() {
        if (this.field_146582_i == null) {
            this.admindesc = new ArrayList();
            this.admin = new ArrayList();
            this.staff = new ArrayList();
            this.devdesc = new ArrayList();
            this.dev = new ArrayList();
            this.contributordesc = new ArrayList();
            this.contributor = new ArrayList();
            this.donordesc = new ArrayList();
            this.donor = new ArrayList();
            this.gatedesc = new ArrayList();
            this.gate = new ArrayList();
            this.cg = new ArrayList();
            this.field_146582_i = new ArrayList();
            // this.field_146582_i.addAll(this.mc.fontRenderer.listFormattedStringToWidth("12223333333", 274));
            // this.field_146582_i.add("");
            try {
                String s = "";
                String s01 = "";
                String s1 = "§l";
                String s11 = "";
                String s02 = "";
                String s2 = "§l";
                String s03 = "";
                String s3 = "";
                String s04 = "";
                String s4 = "";
                String s05 = "";
                String s5 = "";
                String cg = "";
                BufferedReader bufferedreader = new BufferedReader(
                        new InputStreamReader(
                                this.mc.getResourceManager()
                                        .getResource(new ResourceLocation("dreamcraft:RealWinGameData.txt"))
                                        .getInputStream(),
                                Charsets.UTF_8));
                while ((s = bufferedreader.readLine()) != null) {
                    if (s.contains(":")) {
                        if (s.contains(":admin")) {
                            s1 = s1 + s.substring(0, s.indexOf(":")) + "   ";
                        }
                        if (s.contains(":staff")) {
                            s11 = s11 + s.substring(0, s.indexOf(":")) + "   ";
                        }
                        if (s.contains(":dev")) {
                            s2 = s2 + s.substring(0, s.indexOf(":")) + "   ";
                        }
                        if (s.contains(":contributor")) {
                            s3 = s3 + s.substring(0, s.indexOf(":")) + "   ";
                        }
                        if (s.contains(":stargate")) {
                            s5 = s5 + s.substring(0, s.indexOf(":")) + "   ";
                        }
                        if (s.contains(":gatefinity")) {
                            s5 = s5 + "§5" + s.substring(0, s.indexOf(":")) + "   ";
                        }
                        if (s.contains(":gateforce")) {
                            s5 = s5 + "§u" + s.substring(0, s.indexOf(":")) + "   ";
                        }
                    }
                }
                try (final Scanner tScanner = new Scanner(
                        new URL(
                                "https://raw.githubusercontent.com/GTNewHorizons/CustomGTCapeHook-Cape-List/master/capes.txt")
                                        .openStream())) {
                    while (tScanner.hasNextLine()) {
                        String tName = tScanner.nextLine();
                        if (tName.contains(":capedonor") || tName.contains(":cape_stargate")
                                || tName.contains(":cape_neutronium")
                                || tName.contains(":cape_steam")
                                || tName.contains(":cape_titanium")) {
                            s4 = s4 + tName.substring(0, tName.indexOf(":")) + "   ";
                        }
                    }
                }
                if (!s5.contains(this.mc.getSession().getUsername())) {
                    s5 = s5 + ("§o§d" + this.mc.getSession().getUsername() + "   ");
                }

                this.admindesc.addAll(
                        this.mc.fontRenderer.listFormattedStringToWidth(translateToLocal("dc.wingame.admindesc"), 320));
                this.admin.addAll(this.mc.fontRenderer.listFormattedStringToWidth(s1, 320));
                this.staff.addAll(this.mc.fontRenderer.listFormattedStringToWidth(s11, 320));
                this.devdesc.addAll(
                        this.mc.fontRenderer.listFormattedStringToWidth(translateToLocal("dc.wingame.devdesc"), 320));
                this.dev.addAll(this.mc.fontRenderer.listFormattedStringToWidth(s2, 320));
                this.contributordesc.addAll(
                        this.mc.fontRenderer
                                .listFormattedStringToWidth(translateToLocal("dc.wingame.contributordesc"), 320));
                this.contributor.addAll(this.mc.fontRenderer.listFormattedStringToWidth(s3, 320));
                this.donordesc.addAll(
                        this.mc.fontRenderer
                                .listFormattedStringToWidth(translateToLocal("dc.wingame.donatordesc"), 320));
                this.donor.addAll(this.mc.fontRenderer.listFormattedStringToWidth(s4, 320));
                this.gatedesc.addAll(
                        this.mc.fontRenderer.listFormattedStringToWidth(translateToLocal("dc.wingame.gatedesc"), 320));
                this.gate.addAll(this.mc.fontRenderer.listFormattedStringToWidth(s5, 320));
                this.cg.addAll(
                        this.mc.fontRenderer.listFormattedStringToWidth(
                                (translateToLocal("dc.wingame.gc") + "\n\n"
                                        + translateToLocal("dc.wingame.gc1")
                                        + "\n\n"
                                        + translateToLocal("dc.wingame.gc2")
                                        + "\n\n"
                                        + translateToLocal("dc.wingame.gc3")
                                        + "\n\n"
                                        + translateToLocal("dc.wingame.gc4")),
                                320));
            } catch (Exception var9) {
                logger.error("Couldn't load credits", var9);
            }
            // this.field_146579_r = this.field_146582_i.size() * 12;
            textsize = this.admin.size() + this.staff.size()
                    + this.dev.size()
                    + this.contributor.size()
                    + this.donor.size()
                    + this.gate.size()
                    + this.admindesc.size()
                    + this.devdesc.size()
                    + this.contributordesc.size()
                    + this.donordesc.size()
                    + this.gatedesc.size()
                    + this.cg.size();
            this.field_146579_r = textsize * 12 + 360; // + offsets
        }
    }

    private void func_146575_b(int p_146575_1_, int p_146575_2_, float p_146575_3_) {
        Tessellator tessellator = Tessellator.instance;
        this.mc.getTextureManager().bindTexture(Gui.optionsBackground);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F);
        int k = this.width;
        float f1 = 0.0F - ((float) this.field_146581_h + p_146575_3_) * 0.5F * this.field_146578_s;
        float f2 = (float) this.height - ((float) this.field_146581_h + p_146575_3_) * 0.5F * this.field_146578_s;
        float f3 = 0.015625F;
        float f4 = ((float) this.field_146581_h + p_146575_3_ - 0.0F) * 0.02F;
        float f5 = (float) (this.field_146579_r + this.height + this.height + 24) / this.field_146578_s;
        float f6 = (f5 - 20.0F - ((float) this.field_146581_h + p_146575_3_)) * 0.005F;
        if (f6 < f4) {
            f4 = f6;
        }

        if (f4 > 1.0F) {
            f4 = 1.0F;
        }

        f4 *= f4;
        f4 = f4 * 96.0F / 255.0F;
        tessellator.setColorOpaque_F(f4, f4, f4);
        tessellator.addVertexWithUV(0.0, (double) this.height, (double) this.zLevel, 0.0, (double) (f1 * f3));
        tessellator.addVertexWithUV(
                (double) k,
                (double) this.height,
                (double) this.zLevel,
                (double) ((float) k * f3),
                (double) (f1 * f3));
        tessellator
                .addVertexWithUV((double) k, 0.0, (double) this.zLevel, (double) ((float) k * f3), (double) (f2 * f3));
        tessellator.addVertexWithUV(0.0, 0.0, (double) this.zLevel, 0.0, (double) (f2 * f3));
        tessellator.draw();
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        if (y == 0) {
            mc.getSoundHandler().stopSounds();
            mc.getSoundHandler().playSound(
                    PositionedSoundRecord.func_147673_a(new ResourceLocation("dreamcraft", "credits.wingame")));
            y++;
        }
        this.func_146575_b(mouseX, mouseY, partialTicks);
        Tessellator tessellator = Tessellator.instance;
        int k = this.width / 2 - 160;
        int l = this.height + 50;
        float f1 = -((float) this.field_146581_h + partialTicks) * this.field_146578_s;
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, f1, 0.0F);
        this.mc.getTextureManager().bindTexture(field_146576_f);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.func_146110_a(this.width / 2 - 322 / 2, l, 0, 0, 322, 250, 322, 250);
        tessellator.setColorOpaque_I(16777215);
        int i1 = l + 266;

        int j1;

        for (j1 = 0; j1 < this.admindesc.size(); ++j1) {
            String s = (String) this.admindesc.get(j1);
            this.fontRendererObj.fontRandom.setSeed((long) j1 * 4238972211L + (long) (this.field_146581_h / 4));
            this.fontRendererObj.drawStringWithShadow(s, k, i1, 16777215);
            i1 += 8;
        }
        i1 += 16;
        for (j1 = 0; j1 < this.admin.size(); ++j1) {
            String s = (String) this.admin.get(j1);
            s = s.replaceFirst("\\s*", "");
            s = s.replaceAll("\\s+$", "");
            // GL11.glPushMatrix(); // remember current
            // GL11.glScalef(2.5F, 2.5F, 1.0F); // scale
            this.fontRendererObj.fontRandom.setSeed((long) j1 * 4238972211L + (long) (this.field_146581_h / 4));
            this.fontRendererObj
                    .drawStringWithShadow(s, this.width / 2 - this.fontRendererObj.getStringWidth(s) / 2, i1, 11141120);
            // GL11.glPopMatrix(); // restore
            i1 += 12;
        }

        i1 += 32;

        for (j1 = 0; j1 < this.staff.size(); ++j1) {
            String s = (String) this.staff.get(j1);
            s = s.replaceFirst("\\s*", "");
            s = s.replaceAll("\\s+$", "");
            // GL11.glPushMatrix(); // remember current
            // GL11.glScalef(2.5F, 2.5F, 1.0F); // scale
            this.fontRendererObj.fontRandom.setSeed((long) j1 * 4238972211L + (long) (this.field_146581_h / 4));
            this.fontRendererObj
                    .drawStringWithShadow(s, this.width / 2 - this.fontRendererObj.getStringWidth(s) / 2, i1, 43690);
            // GL11.glPopMatrix(); // restore
            i1 += 12;
        }

        i1 += 32;

        GL11.glPushMatrix();
        this.mc.getTextureManager().bindTexture(devlogo);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.func_146110_a(this.width / 2 - 80 / 2, i1, 0, 0, 80, 80, 80, 80);
        tessellator.setColorOpaque_I(16777215);
        GL11.glPopMatrix();

        i1 += 96;

        for (j1 = 0; j1 < this.devdesc.size(); ++j1) {
            String s = (String) this.devdesc.get(j1);
            this.fontRendererObj.fontRandom.setSeed((long) j1 * 4238972211L + (long) (this.field_146581_h / 4));
            this.fontRendererObj.drawStringWithShadow(s, k, i1, 16777215);
            i1 += 8;
        }
        i1 += 16;
        for (j1 = 0; j1 < this.dev.size(); ++j1) {
            String s = (String) this.dev.get(j1);
            s = s.replaceFirst("\\s*", "");
            s = s.replaceAll("\\s+$", "");
            this.fontRendererObj.fontRandom.setSeed((long) j1 * 4238972211L + (long) (this.field_146581_h / 4));
            this.fontRendererObj
                    .drawStringWithShadow(s, this.width / 2 - this.fontRendererObj.getStringWidth(s) / 2, i1, 16777045);
            i1 += 12;
        }

        i1 += 13;

        GL11.glPushMatrix();
        this.mc.getTextureManager().bindTexture(contributorlogo);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.func_146110_a(this.width / 2 - 81 / 2, i1, 0, 0, 81, 53, 81, 53);
        tessellator.setColorOpaque_I(16777215);
        GL11.glPopMatrix();

        i1 += 60;

        for (j1 = 0; j1 < this.contributordesc.size(); ++j1) {
            String s = (String) this.contributordesc.get(j1);
            this.fontRendererObj.fontRandom.setSeed((long) j1 * 4238972211L + (long) (this.field_146581_h / 4));
            this.fontRendererObj.drawStringWithShadow(s, k, i1, 16777215);
            i1 += 8;
        }
        i1 += 16;
        for (j1 = 0; j1 < this.contributor.size(); ++j1) {
            String s = (String) this.contributor.get(j1);
            s = s.replaceFirst("\\s*", "");
            s = s.replaceAll("\\s+$", "");
            this.fontRendererObj.fontRandom.setSeed((long) j1 * 4238972211L + (long) (this.field_146581_h / 4));
            this.fontRendererObj
                    .drawStringWithShadow(s, this.width / 2 - this.fontRendererObj.getStringWidth(s) / 2, i1, 16777045);
            i1 += 10;
        }

        i1 += 15;

        GL11.glPushMatrix();
        this.mc.getTextureManager().bindTexture(donorlogo);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.func_146110_a(this.width / 2 - 80 / 2, i1, 0, 0, 80, 75, 80, 75);
        tessellator.setColorOpaque_I(16777215);
        GL11.glPopMatrix();

        i1 += 91;

        for (j1 = 0; j1 < this.donordesc.size(); ++j1) {
            String s = (String) this.donordesc.get(j1);
            this.fontRendererObj.fontRandom.setSeed((long) j1 * 4238972211L + (long) (this.field_146581_h / 4));
            this.fontRendererObj.drawStringWithShadow(s, k, i1, 16777215);
            i1 += 8;
        }
        i1 += 16;
        for (j1 = 0; j1 < this.donor.size(); ++j1) {
            String s = (String) this.donor.get(j1);
            s = s.replaceFirst("\\s*", "");
            s = s.replaceAll("\\s+$", "");
            this.fontRendererObj.fontRandom.setSeed((long) j1 * 4238972211L + (long) (this.field_146581_h / 4));
            this.fontRendererObj
                    .drawStringWithShadow(s, this.width / 2 - this.fontRendererObj.getStringWidth(s) / 2, i1, 16755200);
            i1 += 10;
        }

        i1 += 10;

        GL11.glPushMatrix();
        this.mc.getTextureManager().bindTexture(gateforcelogo);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.func_146110_a(this.width / 2 - 80 / 2, i1, 0, 0, 80, 80, 80, 80);
        tessellator.setColorOpaque_I(16777215);
        GL11.glPopMatrix();

        i1 += 90;

        for (j1 = 0; j1 < this.gatedesc.size(); ++j1) {
            String s = (String) this.gatedesc.get(j1);
            this.fontRendererObj.fontRandom.setSeed((long) j1 * 4238972211L + (long) (this.field_146581_h / 4));
            this.fontRendererObj.drawStringWithShadow(s, k, i1, 16777215);
            i1 += 8;
        }
        i1 += 16;
        for (j1 = 0; j1 < this.gate.size(); ++j1) {
            String s = (String) this.gate.get(j1);
            s = s.replaceFirst("\\s*", "");
            s = s.replaceAll("\\s+$", "");
            this.fontRendererObj.fontRandom.setSeed((long) j1 * 4238972211L + (long) (this.field_146581_h / 4));
            this.fontRendererObj
                    .drawStringWithShadow(s, this.width / 2 - this.fontRendererObj.getStringWidth(s) / 2, i1, 3107718);
            i1 += 10;
        }
        i1 += 120;
        for (j1 = 0; j1 < this.cg.size(); ++j1) {
            if (j1 == this.cg.size() - 1) {
                float f2 = (float) i1 + f1 - (float) (this.height / 2 - 6);
                if (f2 < 0.0F) {
                    GL11.glTranslatef(0.0F, -f2, 0.0F);
                }
            }
            String s = (String) this.cg.get(j1);
            this.fontRendererObj.fontRandom.setSeed((long) j1 * 4238972211L + (long) (this.field_146581_h / 4));
            this.fontRendererObj.drawStringWithShadow(s, k, i1, 16777215);
            i1 += 12;
        }

        GL11.glPopMatrix();
        this.mc.getTextureManager().bindTexture(field_146577_g);
        GL11.glEnable(3042);
        GL11.glBlendFunc(0, 769);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F);
        j1 = this.width;
        int k1 = this.height;
        tessellator.addVertexWithUV(0.0, (double) k1, (double) this.zLevel, 0.0, 1.0);
        tessellator.addVertexWithUV((double) j1, (double) k1, (double) this.zLevel, 1.0, 1.0);
        tessellator.addVertexWithUV((double) j1, 0.0, (double) this.zLevel, 1.0, 0.0);
        tessellator.addVertexWithUV(0.0, 0.0, (double) this.zLevel, 0.0, 0.0);
        tessellator.draw();
        GL11.glDisable(3042);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
