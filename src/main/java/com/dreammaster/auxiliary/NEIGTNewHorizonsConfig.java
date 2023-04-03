package com.dreammaster.auxiliary;

import static com.dreammaster.MissingModIDs.Aroma1997Core;
import static com.dreammaster.MissingModIDs.BiblioCraft;
import static com.dreammaster.MissingModIDs.Chisel;
import static com.dreammaster.MissingModIDs.EnderZoo;
import static com.dreammaster.MissingModIDs.ExtraTrees;
import static com.dreammaster.MissingModIDs.ForgeRelocation;
import static com.dreammaster.MissingModIDs.MalisisDoors;
import static com.dreammaster.MissingModIDs.Mantle;
import static com.dreammaster.MissingModIDs.OpenSecurity;
import static com.dreammaster.MissingModIDs.SleepingBags;
import static com.dreammaster.MissingModIDs.ThaumicHorizons;
import static com.dreammaster.MissingModIDs.ThaumicMachina;
import static com.dreammaster.MissingModIDs.WarpTheory;
import static gregtech.api.enums.ModIDs.AppliedEnergistics2;
import static gregtech.api.enums.ModIDs.BartWorks;
import static gregtech.api.enums.ModIDs.GraviSuite;
import static gregtech.api.enums.ModIDs.HardcoreEnderExpansion;
import static gregtech.api.enums.ModIDs.NewHorizonsCoreMod;
import static gregtech.api.enums.ModIDs.PamsHarvestCraft;
import static gregtech.api.enums.ModIDs.Thaumcraft;
import static gregtech.api.enums.ModIDs.ThaumicTinkerer;
import static gregtech.api.enums.ModIDs.TwilightForest;

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
            API.hideItem(GT_ModHandler.getModItem(Aroma1997Core.modID, "wrenched", 1));
        }

        if (BiblioCraft.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(BiblioCraft.modID, "BiblioClipboard", 1));
        }

        if (EnderZoo.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(EnderZoo.modID, "enderZooIcon", 1));
        }

        if (ExtraTrees.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(ExtraTrees.modID, "multifence", 1, 16387));
        }

        if (ForgeRelocation.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(ForgeRelocation.modID, "relocation.blockmovingrow", 1));
        }

        if (GraviSuite.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(GraviSuite.modID, "BlockRelocatorPortal", 1));
        }

        if (HardcoreEnderExpansion.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.modID, "death_flower_pot", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.modID, "corrupted_energy_high", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.modID, "biome_core", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.modID, "corrupted_energy_low", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.modID, "enhanced_brewing_stand_block", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.modID, "temple_end_portal", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.modID, "laser_beam", 1));
            API.hideItem(GT_ModHandler.getModItem(HardcoreEnderExpansion.modID, "item_special_effects", 1));
        }

        if (Mantle.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(Mantle.modID, "mantleBook", 1));
        }

        if (Thaumcraft.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(Thaumcraft.modID, "blockWarded", 1));
            API.hideItem(GT_ModHandler.getModItem(Thaumcraft.modID, "blockEldritchNothing", 1));
        }

        if (ThaumicHorizons.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(ThaumicHorizons.modID, "vatInterior", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicHorizons.modID, "evanescent", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicHorizons.modID, "portalTH", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicHorizons.modID, "syringeInjection", 1, 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicHorizons.modID, "syringeInjection", 1, 15));
            API.hideItem(GT_ModHandler.getModItem(ThaumicHorizons.modID, "dummyVat", 1));
        }

        if (ThaumicMachina.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(ThaumicMachina.modID, "metaphysicalBrick", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicMachina.modID, "metaphysicalRose", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicMachina.modID, "wandCore", 1));
        }

        if (ThaumicTinkerer.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(ThaumicTinkerer.modID, "gaseousLight", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicTinkerer.modID, "gaseousShadow", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicTinkerer.modID, "infusedGrainBlock", 1));
            API.hideItem(GT_ModHandler.getModItem(ThaumicTinkerer.modID, "nitorGas", 1));
        }
        if (TwilightForest.isModLoaded()) {
            for (int i = 5; i <= 15; i++) {
                API.hideItem(GT_ModHandler.getModItem(TwilightForest.modID, "tile.TFBossSpawner", 1, i));
                API.hideItem(GT_ModHandler.getModItem(TwilightForest.modID, "tile.TFTowerTranslucent", 1, i));
            }
            API.hideItem(GT_ModHandler.getModItem(TwilightForest.modID, "tile.TFTrophy", 1));
        }

        if (WarpTheory.isModLoaded()){
            API.hideItem(GT_ModHandler.getModItem(WarpTheory.modID, "blockVanish", 1));
        }

        if (AppliedEnergistics2.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(AppliedEnergistics2.modID, "tile.BlockPaint", 1));
        }

        if (BartWorks.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(BartWorks.modID, "gt.bwMetaGeneratedGTEnhancementcapsule", 1, 477));
        }

        if (Chisel.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(Chisel.modID, "amber", 1));
            API.hideItem(GT_ModHandler.getModItem(Chisel.modID, "bloodBrick", 1));
        }
        if (PamsHarvestCraft.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(PamsHarvestCraft.modID, "ovenon", 1));
            API.hideItem(GT_ModHandler.getModItem(PamsHarvestCraft.modID, "churnon", 1));
            API.hideItem(GT_ModHandler.getModItem(PamsHarvestCraft.modID, "quernon", 1));
        }
        if (MalisisDoors.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(MalisisDoors.modID, "null", 1));
        }

        if (OpenSecurity.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(OpenSecurity.modID, "SecurityDoor", 1));
            API.hideItem(GT_ModHandler.getModItem(OpenSecurity.modID, "SecurityDoorPrivate", 1));
        }
        if (SleepingBags.isModLoaded()) {
            API.hideItem(GT_ModHandler.getModItem(SleepingBags.modID, "sleepingBagBlock", 1));
        }

        MainRegistry.Logger.info("Added NEI Config");
    }

    private void hideFakeCircuits() {
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.modID, "item.CircuitULV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.modID, "item.CircuitLV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.modID, "item.CircuitMV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.modID, "item.CircuitHV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.modID, "item.CircuitEV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.modID, "item.CircuitIV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.modID, "item.CircuitLuV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.modID, "item.CircuitZPM", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.modID, "item.CircuitUV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.modID, "item.CircuitUHV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.modID, "item.CircuitUEV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.modID, "item.CircuitUIV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.modID, "item.CircuitUMV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.modID, "item.CircuitUXV", 1));
        API.hideItem(GT_ModHandler.getModItem(NewHorizonsCoreMod.modID, "item.CircuitMAX", 1));
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
