package com.dreammaster.scripts;

import net.minecraft.util.EnumChatFormatting;

import com.dreammaster.main.MainRegistry;

public class ScriptLoader {

    public static void run() {
        IScriptLoader.missing.setStackDisplayName(EnumChatFormatting.RED + "Missing item! Please report it on github!");

        IScriptLoader[] scripts = new IScriptLoader[] { new ScriptAdvancedBackpacks(), new ScriptAdvancedSolarPanel(),
                new ScriptAE2FC(), new ScriptAE2Stuff(), new ScriptAFSU(), new ScriptIndustrialApiary(),
                new ScriptAppliedEnergistics2(), new ScriptArchitectureCraft(), new ScriptAutomagy(),
                new ScriptAvaritia(), new ScriptAvaritiaAddons(), new ScriptBackpack(), new ScriptBetterBuildersWands(),
                new ScriptBetterQuesting(), new ScriptBiblioCraft(), new ScriptBiblioWoodsBoP(),
                new ScriptBiblioWoodsForestry(), new ScriptBiblioWoodsNatura(), new ScriptBinniesCore(),
                new ScriptBinniesMods(), new ScriptBiomesOPlenty(), new ScriptBloodArsenal(), new ScriptBloodMagic(),
                new ScriptBotany(), new ScriptBuildCraft(), new ScriptCarpentersBlocks(), new ScriptCatWalk(),
                new ScriptChisel(), new ScriptCompactKineticGenerators(), new ScriptComputronics(), new ScriptCoreMod(),
                new ScriptDraconicEvolution(), new ScriptEC2(), new ScriptEMT(), new ScriptEnderIO(),
                new ScriptEnderZoo(), new ScriptEnhancedLootBags(), new ScriptExtraBees(), new ScriptExtraTrees(),
                new ScriptExtraUtilities(), new ScriptFloodLight(), new ScriptForbiddenMagic(), new ScriptForestry(),
                new ScriptForgeMultipart(), new ScriptGadomancy(), new ScriptHoloInventory(), new ScriptIguanaTweaks(),
                new ScriptJABBA(), new ScriptMagicBees(), new ScriptNuclearControl(), new ScriptOpenBlocks(),
                new ScriptRailcraft(), new ScriptRunicTablet(), new ScriptSleepingBags(), new ScriptSpiceOfLife(),
                new ScriptTaintedMagic(), new ScriptTCCoreMod(), new ScriptThaumcraft(), new ScriptThaumicBases(),
                new ScriptTranslocator(), new ScriptTwilightForest(), new ScriptThaumicEnergistics(),
                new ScriptThaumicExploration(), new ScriptThaumicHorizons(), new ScriptThaumicMachina(),
                new ScriptThaumicTinkerer(), new ScriptWarpTheory(), new ScriptWitchery(), new ScriptTravellersGear() };

        for (IScriptLoader script : scripts) {
            if (script.isScriptLoadable()) {
                final long timeStart = System.currentTimeMillis();
                script.loadRecipes();
                final long timeToLoad = System.currentTimeMillis() - timeStart;
                MainRegistry.Logger.info("Loaded " + script.getScriptName() + " script in " + timeToLoad + " ms.");
            } else {
                MainRegistry.Logger.info(
                        "Missing dependencies to load " + script.getScriptName() + " script. It won't be loaded.");
            }
        }
    }
}
