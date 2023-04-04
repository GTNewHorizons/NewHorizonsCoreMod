package com.dreammaster.auxiliary;

import static gregtech.api.enums.Mods.Aroma1997Core;
import static gregtech.api.enums.Mods.BiblioCraft;
import static gregtech.api.enums.Mods.Chisel;
import static gregtech.api.enums.Mods.EnderZoo;
import static gregtech.api.enums.Mods.ExtraTrees;
import static gregtech.api.enums.Mods.ForgeRelocation;
import static gregtech.api.enums.Mods.MalisisDoors;
import static gregtech.api.enums.Mods.Mantle;
import static gregtech.api.enums.Mods.OpenSecurity;
import static gregtech.api.enums.Mods.SleepingBags;
import static gregtech.api.enums.Mods.ThaumicHorizons;
import static gregtech.api.enums.Mods.ThaumicMachina;
import static gregtech.api.enums.Mods.WarpTheory;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.enums.Mods.TwilightForest;

import net.minecraft.item.ItemStack;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

import com.dreammaster.item.food.QuantumBread;
import com.dreammaster.lib.Refstrings;
import com.dreammaster.main.MainRegistry;
import gregtech.api.util.GT_ModHandler;

public class NEIGTNewHorizonsConfig implements IConfigureNEI {

    @Override
    public void loadConfig() {
        hideFakeCircuits();
        API.hideItem(new ItemStack(QuantumBread.Instance()));
        if (Aroma1997Core.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(Aroma1997Core.ID, "wrenched", 1));
        }

        if (BiblioCraft.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(BiblioCraft.ID, "BiblioClipboard", 1));
        }

        if (EnderZoo.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(EnderZoo.ID, "enderZooIcon", 1));
        }

        if (ExtraTrees.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(ExtraTrees.ID, "multifence", 1, 16387));
        }

        if (ForgeRelocation.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(ForgeRelocation.ID, "relocation.blockmovingrow", 1));
        }

        if (GraviSuite.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(GraviSuite.ID, "BlockRelocatorPortal", 1));
        }

        if (HardcoreEnderExpansion.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "death_flower_pot", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "corrupted_energy_high", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "biome_core", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "corrupted_energy_low", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "enhanced_brewing_stand_block", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "temple_end_portal", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "laser_beam", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "item_special_effects", 1));
        }

        if (Mantle.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(Mantle.ID, "mantleBook", 1));
        }

        if (Thaumcraft.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(Thaumcraft.ID, "blockWarded", 1));
            API.hideItem(GT_ModHandler.getModItem(Thaumcraft.ID, "blockEldritchNothing", 1));
        }

        if (ThaumicHorizons.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(ThaumicHorizons.ID, "vatInterior", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicHorizons.ID, "evanescent", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicHorizons.ID, "portalTH", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicHorizons.ID, "syringeInjection", 1, 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicHorizons.ID, "syringeInjection", 1, 15));
            API.hideItem(GT_ModHandler.getModItem(ThaumicHorizons.ID, "dummyVat", 1));
        }

        if (ThaumicMachina.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(ThaumicMachina.ID, "metaphysicalBrick", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicMachina.ID, "metaphysicalRose", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicMachina.ID, "wandCore", 1));
        }

        if (ThaumicTinkerer.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(ThaumicTinkerer.ID, "gaseousLight", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicTinkerer.ID, "gaseousShadow", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicTinkerer.ID, "infusedGrainBlock", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicTinkerer.ID, "nitorGas", 1));
        }
        if (TwilightForest.isModLoaded()) {
            for (int i = 5; i <= 15; i++) {
                API.hideItem(GT_ModHandler.getModItem(TwilightForest.ID, "tile.TFBossSpawner", 1, i));
                API.hideItem(GT_ModHandler.getModItem(TwilightForest.ID, "tile.TFTowerTranslucent", 1, i));
            }
            API.hideItem(GT_ModHandler.getModItem(TwilightForest.ID, "tile.TFTrophy", 1));
        }

        if (WarpTheory.isModLoaded()){
            API.hideItem(GT_ModHandler.getModItem(WarpTheory.ID, "blockVanish", 1));
        }

        if (AppliedEnergistics2.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockPaint", 1));
        }

        if (BartWorks.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedGTEnhancementcapsule", 1, 477));
        }

        if (Chisel.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(Chisel.ID, "amber", 1));
            API.hideItem(GT_ModHandler.getModItem(Chisel.ID, "bloodBrick", 1));
        }
        if (PamsHarvestCraft.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "ovenon", 1));
            API.hideItem(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "churnon", 1));
            API.hideItem(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "quernon", 1));
        }
        if (MalisisDoors.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(MalisisDoors.ID, "null", 1));
        }

        if (OpenSecurity.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(OpenSecurity.ID, "SecurityDoor", 1));
            API.hideItem(GT_ModHandler.getModItem(OpenSecurity.ID, "SecurityDoorPrivate", 1));
        }
        if (SleepingBags.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(SleepingBags.ID, "sleepingBagBlock", 1));
        }

        MainRegistry.Logger.info("Added NEI Config");
    }

    private void hideFakeCircuits() {
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitULV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitLV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitMV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitHV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitEV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitIV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitLuV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitZPM", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitUV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitUHV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitUEV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitUIV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitUMV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitUXV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.CircuitMAX", 1));
    }

    @Override
    public String getName() {
        return "GTNewHorizons-NEIConfig";
    }

    @Override
    public String getVersion() {
        return Refstrings.VERSION;
    }
}
