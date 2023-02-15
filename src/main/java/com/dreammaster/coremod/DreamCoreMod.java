package com.dreammaster.coremod;

import java.io.*;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.MCVersion("1.7.10")
@IFMLLoadingPlugin.Name("DreamCoreMod")
@IFMLLoadingPlugin.TransformerExclusions("com.dreammaster.coremod")
public class DreamCoreMod implements IFMLLoadingPlugin {

    static boolean downloadOnlyOnce;
    static Properties coremodConfig = new Properties();

    public static Logger logger = LogManager.getLogger("DreamCoreMod");
    public static boolean deobf;
    public static boolean patchItemFocusWarding;
    public static File debugOutputDir;

    @Override
    public String[] getASMTransformerClass() {
        return new String[] { "com.dreammaster.coremod.transformers.DreamTransformer",
                "com.dreammaster.coremod.transformers.BibliocraftTransformer" };
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
        coremodConfig.setProperty("patchItemFocusWarding", "true");
        coremodConfig.setProperty("downloadOnlyOnce", "true");
        coremodConfig.setProperty("debug", "false");
        File mcLocation = (File) data.get("mcLocation");
        File configDir = new File(mcLocation, "config");
        configDir.mkdir();
        File config = new File(configDir, "DreamCoreMod.properties");
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
        downloadOnlyOnce = "true".equalsIgnoreCase(coremodConfig.getProperty("downloadOnlyOnce"));
        patchItemFocusWarding = "true".equalsIgnoreCase(coremodConfig.getProperty("patchItemFocusWarding"));
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
}
