package com.dreammaster.coremod;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gtnewhorizon.gtnhmixins.IEarlyMixinLoader;

import cpw.mods.fml.relauncher.FMLLaunchHandler;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.MCVersion("1.7.10")
@IFMLLoadingPlugin.Name("DreamCoreMod")
public class DreamCoreMod implements IEarlyMixinLoader, IFMLLoadingPlugin {

    public static Logger logger = LogManager.getLogger("DreamCoreMod");
    public static Properties coremodConfig = new Properties();
    public static File coremodConfigFile;
    public static File debugOutputDir;
    public static boolean deobf;

    public static boolean showConfirmExitWindow;
    public static boolean patchItemFocusWarding;
    static boolean downloadOnlyOnce;

    @Override
    public String[] getASMTransformerClass() {
        return new String[] { DreamClassTransformer.class.getName() };
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return "com.dreammaster.coremod.DepLoader";
    }

    @Override
    public void injectData(Map<String, Object> data) {
        deobf = !(boolean) data.get("runtimeDeobfuscationEnabled");
        coremodConfig.setProperty("showConfirmExitWindow", "true");
        coremodConfig.setProperty("patchItemFocusWarding", "true");
        coremodConfig.setProperty("downloadOnlyOnce", "true");
        coremodConfig.setProperty("debug", "false");
        File mcLocation = (File) data.get("mcLocation");
        File configDir = new File(mcLocation, "config");
        // noinspection ResultOfMethodCallIgnored
        configDir.mkdir();
        File config = new File(configDir, "DreamCoreMod.properties");
        coremodConfigFile = config;
        try (Reader r = new FileReader(config)) {
            coremodConfig.load(r);
        } catch (FileNotFoundException ignored) {
            // not a problem
        } catch (IOException e) {
            logger.warn("Can't read coremod config. Proceeding with defaults!", e);
        }
        try (Writer r = new FileWriter(config)) {
            coremodConfig.store(r, "Config file for the ASM part of GTNHCoreMod");
        } catch (IOException e) {
            logger.warn("Can't write coremod config. Changes may not have been saved!", e);
        }
        showConfirmExitWindow = "true".equalsIgnoreCase(coremodConfig.getProperty("showConfirmExitWindow"));
        patchItemFocusWarding = "true".equalsIgnoreCase(coremodConfig.getProperty("patchItemFocusWarding"));
        downloadOnlyOnce = "true".equalsIgnoreCase(coremodConfig.getProperty("downloadOnlyOnce"));
        if ("true".equalsIgnoreCase(coremodConfig.getProperty("debug"))) {
            debugOutputDir = new File(mcLocation, ".asm_debug");
            try {
                if (debugOutputDir.exists()) FileUtils.deleteDirectory(debugOutputDir);
            } catch (IOException e) {
                logger.warn("Can't remove old debug stuff. Debug will be effective turned off!", e);
                debugOutputDir = null;
            }
            if (debugOutputDir != null && !debugOutputDir.mkdir()) {
                logger.warn("Can't make debug output dir. Debug will be effective turned off");
                debugOutputDir = null;
            }
        }
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

    @Override
    public String getMixinConfig() {
        return "mixins.dreamcraft.early.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedCoreMods) {
        final List<String> mixins = new ArrayList<>();
        if (FMLLaunchHandler.side().isClient()) {
            mixins.add("MixinMinecraft_ConfirmExit");
            mixins.add("MixinMinecraft_PackIcon");

            // neuter Open to LAN
            mixins.add("MixinIntegratedServer");
            mixins.add("MixinGuiShareToLan");
        }
        mixins.add("MixinTileEntityBeacon");
        return mixins;
    }

    /**
     * Disable to show the confirm exit window, and save it to the config.
     */
    public static void disableShowConfirmExitWindow() {
        showConfirmExitWindow = false;
        coremodConfig.setProperty("showConfirmExitWindow", "false");
        try (Writer w = new FileWriter(coremodConfigFile)) {
            coremodConfig.store(w, "Config file for the ASM part of GTNHCoreMod");
        } catch (IOException e) {
            logger.warn("Can't save coremod config.", e);
        }
    }

}
