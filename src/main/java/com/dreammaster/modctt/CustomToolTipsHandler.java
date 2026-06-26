package com.dreammaster.modctt;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import com.dreammaster.lib.Refstrings;
import com.dreammaster.main.MainRegistry;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class CustomToolTipsHandler {

    private String _mConfigFileName;
    private CustomToolTips _mCustomToolTips;
    private boolean _mInitialized;

    public static CustomToolTips.ItemToolTip createCustomItemToolTip(String pUnlocalizedName, String pToolTip) {
        CustomToolTips.ItemToolTip itt = new CustomToolTips.ItemToolTip();
        itt.mToolTip = pToolTip;
        itt.mUnlocalizedName = pUnlocalizedName;

        return itt;
    }

    public CustomToolTipsHandler() {
        setConfigFileLocation();
        _mInitialized = false;
    }

    @Deprecated
    public void setConfigFileLocation() {
        String locale = FMLCommonHandler.instance().getCurrentLanguage();
        String localeAwareFileName = String.format("config/%s/CustomToolTips_%s.xml", Refstrings.COLLECTIONID, locale);
        if (new File(localeAwareFileName).isFile()) {
            _mConfigFileName = localeAwareFileName;
        } else {
            _mConfigFileName = String.format("config/%s/CustomToolTips.xml", Refstrings.COLLECTIONID);
        }
    }

    public void InitSampleConfig() {
        _mCustomToolTips = new CustomToolTips();
        _mCustomToolTips.getToolTips().add(createCustomItemToolTip("minecraft:stone", "Wow, such stone, much rock"));
        _mCustomToolTips.getToolTips().add(createCustomItemToolTip("minecraft:coal", "This is coal..."));
        _mCustomToolTips.getToolTips().add(createCustomItemToolTip("minecraft:coal:1", "...and this charcoal!"));
    }

    /**
     * Save customtooltips to disk, overwriting any existing xml file
     *
     * @return
     */
    public boolean SaveCustomToolTips() {
        try {
            JAXBContext tJaxbCtx = JAXBContext.newInstance(CustomToolTips.class);
            Marshaller jaxMarsh = tJaxbCtx.createMarshaller();
            jaxMarsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxMarsh.marshal(_mCustomToolTips, new FileOutputStream(_mConfigFileName, false));

            MainRegistry.LOGGER.debug("[CTT.SaveCustomToolTips] Config file written");
            return true;
        } catch (Exception e) {
            MainRegistry.LOGGER
                    .error("[CTT.SaveCustomToolTips] Unable to create new CustomToolTips.xml. What did you do??");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Initial Loading of config with automatic creation of default xml
     */
    public void LoadConfig() {
        if (_mInitialized) {
            MainRegistry.LOGGER.error("[CTT] Something just called LoadConfig AFTER it has been initialized!");
            return;
        }

        MainRegistry.LOGGER.debug("[CTT.LoadConfig] entering state: LOAD CONFIG");
        File tConfigFile = new File(_mConfigFileName);
        if (!tConfigFile.exists()) {
            MainRegistry.LOGGER
                    .debug("[CTT.LoadConfig] Config file not found, assuming first-start. Creating default one");
            InitSampleConfig();
            SaveCustomToolTips();
        }

        // Fix for broken XML file; If it can't be loaded on reboot, keep it
        // there to be fixed, but load
        // default setting instead, so an Op/Admin can do reload ingame
        if (!reload()) {
            MainRegistry.LOGGER.error(
                    "[CTT.LoadConfig] Configuration File seems to be damaged, loading does-nothing-evil default config. You should fix your file and reload it");
            InitSampleConfig();
        }
        _mInitialized = true;
    }

    /**
     * Initiate reload. Will reload the config from disk and replace the internal list. If the file contains errors,
     * nothing will be replaced, and an errormessage will be sent to the command issuer.
     * <p>
     * This method will just load the config the first time it is called, as this will happen in the servers
     * load/postinit phase. After that, every call is caused by someone who tried to do an ingame reload. If that is
     * successful, the updated config is broadcasted to every connected client
     *
     * @return
     */
    public boolean reload() {
        boolean tState = ReloadCustomToolTips();
        if (_mInitialized && !tState) {
            MainRegistry.LOGGER.error("[CTT.ReloadCustomToolTips] Reload of tooltip file failed.");
        }
        return tState;
    }

    /**
     * Reload tooltip configuration from disk. Will overwrite current List without restart, if the config file is valid
     *
     * @return
     */
    public boolean ReloadCustomToolTips() {
        boolean tResult = false;

        MainRegistry.LOGGER.debug("[CTT.ReloadCustomToolTips] will now try to load it's configuration");
        try {
            JAXBContext tJaxbCtx = JAXBContext.newInstance(CustomToolTips.class);
            Unmarshaller jaxUnmarsh = tJaxbCtx.createUnmarshaller();

            CustomToolTips tNewItemCollection;

            File tConfigFile = new File(_mConfigFileName);
            tNewItemCollection = (CustomToolTips) jaxUnmarsh.unmarshal(tConfigFile);
            MainRegistry.LOGGER.debug("[CTT.ReloadCustomToolTips] Config file has been loaded. Entering Verify state");

            _mCustomToolTips = tNewItemCollection;
            tResult = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tResult;
    }

    @SubscribeEvent
    public void onToolTip(ItemTooltipEvent pEvent) {
        if (pEvent.entity == null) {
            return;
        }
        CustomToolTips.ItemToolTip itt = _mCustomToolTips.FindItemToolTip(pEvent.itemStack);
        if (itt != null) {
            final String[] formatArgs = itt.getFormatArgs();
            final String tooltip;
            if (formatArgs == null) {
                tooltip = StatCollector.translateToLocal(itt.getToolTip());
            } else {
                tooltip = StatCollector.translateToLocalFormatted(itt.getToolTip(), (Object[]) formatArgs);
            }
            String[] tToolTips = tooltip.split("\\\\n");

            for (String tPartTip : tToolTips) {
                pEvent.toolTip.add(tPartTip.replace("&", "§"));
            }
        }
    }
}
