package com.dreammaster.scripts;

import com.dreammaster.main.MainRegistry;

public class ScriptLoader {
    static public void run(){
        IScriptLoader[] scripts = new IScriptLoader[]{
                new ScriptAE2FC(),
                new ScriptAFSU(),
                new ScriptAlveary(),
                new ScriptArchitectureCraft(),
                new ScriptAvaritiaAddons(),
                new ScriptBetterQuesting(),
                new ScriptBiblioCraft(),
                new ScriptBiblioWoodsBoP(),
                new ScriptBiblioWoodsForestry(),
                new ScriptBiblioWoodsNatura(),
                new ScriptComputronics(),
                new ScriptEnderZoo(),
                new ScriptForgeMultipart(),
                new ScriptHoloInventory(),
                new ScriptIguanaTweaks(),
                new ScriptJABBA(),
                new ScriptSleepingBags(),
                new ScriptSpiceOfLife(),
                new ScriptTranslocator()
        };

        for (IScriptLoader script: scripts){
            script.initScriptData();
            if (script.isScriptLoadable()){
                script.loadScript();
                MainRegistry.Logger.info(script.getScriptName()+" took "+script.getExecutionTime()+" ms.");
            }
            else {
                MainRegistry.Logger.info("missing requirements for the script "+script.getScriptName()+". It won't be loaded");
            }
        }
    }
}
