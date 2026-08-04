package com.dreammaster.client.util.UI;

import com.dreammaster.client.util.ConfigGUI;
import com.dreammaster.config.CoreModConfig;
import com.gtnewhorizon.gtnhlib.config.ConfigurationManager;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraftforge.client.event.GuiOpenEvent;

public class ConfigGUIFirstOpenHandler {

    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event) {
        if (event.gui instanceof GuiSelectWorld && !CoreModConfig.Modules.WasConfigScreenShown) {
            event.gui = new ConfigGUI(event.gui);
            CoreModConfig.Modules.WasConfigScreenShown = true;
            ConfigurationManager.save(CoreModConfig.Modules.class);
        }
    }
}
