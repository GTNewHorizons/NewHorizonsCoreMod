package com.dreammaster.client.util;
import com.gtnewhorizon.gtnhlib.config.ConfigurationManager;
import com.gtnewhorizon.gtnhlib.util.numberformatting.NumberFormatConfig;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import cpw.mods.fml.client.config.GuiCheckBox;
import net.minecraft.util.StatCollector;
import com.dreammaster.config.CoreModConfig;

public class ConfigGUI extends GuiScreen {

    private GuiScreen parentScreen;

    public ConfigGUI(GuiScreen parentScreen) {
        this.parentScreen = parentScreen;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height - 30, 200, 20, "Back"));
        this.buttonList.add(new GuiCheckBox(1, this.width / 2 - 100, 50, "Weak?", NumberFormatConfig.useForgeFluidMillibuckets));
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            this.mc.displayGuiScreen(this.parentScreen);
        } else if (button.id == 1) {
            NumberFormatConfig.useForgeFluidMillibuckets = !NumberFormatConfig.useForgeFluidMillibuckets;
            ConfigurationManager.save(NumberFormatConfig.class);
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, StatCollector.translateToLocal("dreamcraft.configmenu.title"), this.width / 2, 15, 0xFFFFFF);
        if (!CoreModConfig.Modules.WasConfigScreenShown) {
            this.drawCenteredString(this.fontRendererObj, StatCollector.translateToLocal("dreamcraft.configmenu.firsttime"), this.width / 2, 25, 0x53E0E0);
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
