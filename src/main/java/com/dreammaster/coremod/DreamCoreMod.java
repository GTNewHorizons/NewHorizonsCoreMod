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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dreammaster.lib.Refstrings;
import com.gtnewhorizon.gtnhmixins.IEarlyMixinLoader;

import cpw.mods.fml.relauncher.FMLLaunchHandler;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.MCVersion("1.7.10")
@IFMLLoadingPlugin.Name("DreamCoreMod")
public class DreamCoreMod implements IEarlyMixinLoader, IFMLLoadingPlugin {

    public static Logger logger = LogManager.getLogger("DreamCoreMod");
    public static Properties coremodConfig = new Properties();
    public static File coremodConfigFile;
    private static Boolean isObf;
    private static boolean modpackHasUpdated;

    public static boolean showConfirmExitWindow;
    public static boolean patchItemFocusWarding;
    static boolean downloadOnlyOnce;
    static String downloadUA;

    @Override
    public String[] getASMTransformerClass() {
        return new String[] { "com.dreammaster.coremod.DreamClassTransformer" };
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
        isObf = (boolean) data.get("runtimeDeobfuscationEnabled");
        coremodConfig.setProperty("showConfirmExitWindow", "true");
        coremodConfig.setProperty("patchItemFocusWarding", "true");
        coremodConfig.setProperty("downloadOnlyOnce", "true");
        File mcLocation = (File) data.get("mcLocation");
        File configDir = new File(mcLocation, "config");
        // noinspection ResultOfMethodCallIgnored
        configDir.mkdir();
        File config = new File(configDir, "DreamCoreMod.properties");
        File modpackUpdate = new File(configDir, "modpack-update");
        if (modpackUpdate.exists()) {
            modpackHasUpdated = true;
        }
        coremodConfigFile = config;
        try (Reader r = new FileReader(config)) {
            coremodConfig.load(r);
        } catch (FileNotFoundException ignored) {
            // not a problem
        } catch (IOException e) {
            logger.warn("Can't read coremod config. Proceeding with defaults!", e);
        }
        if (!Refstrings.VERSION.equals(coremodConfig.get("savedVersion"))) {
            modpackHasUpdated = true;
        }
        coremodConfig.setProperty("savedVersion", Refstrings.VERSION);
        try (Writer r = new FileWriter(config)) {
            coremodConfig.store(r, "Config file for the ASM part of GTNHCoreMod");
        } catch (IOException e) {
            logger.warn("Can't write coremod config. Changes may not have been saved!", e);
        }
        showConfirmExitWindow = "true".equalsIgnoreCase(coremodConfig.getProperty("showConfirmExitWindow"));
        patchItemFocusWarding = "true".equalsIgnoreCase(coremodConfig.getProperty("patchItemFocusWarding"));
        downloadOnlyOnce = "true".equalsIgnoreCase(coremodConfig.getProperty("downloadOnlyOnce"));
        downloadUA = coremodConfig.getProperty(
                "downloadUA",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:147.0) Gecko/20100101 Firefox/147.0");
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

    public static boolean isObf() {
        if (isObf == null) {
            throw new IllegalStateException("Obfuscation stated accessed too early!");
        }
        return isObf;
    }

    /**
     * Returns true if the file "modpack-update" is present in the config folder which means the modpack has just been
     * updated, and it's the first time the game is running after the update.
     */
    public static boolean modpackHasUpdated() {
        return modpackHasUpdated;
    }

}
