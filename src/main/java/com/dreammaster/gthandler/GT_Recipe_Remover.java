package com.dreammaster.gthandler;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.util.GT_ModHandler;

import static com.dreammaster.MissingModIDs.DraconicEvolution;
import static com.dreammaster.MissingModIDs.MineAndBladeBattleGear2;
import static com.dreammaster.MissingModIDs.NaturesCompass;
import static com.dreammaster.MissingModIDs.OpenPrinters;
import static com.dreammaster.MissingModIDs.OpenSecurity;
import static com.dreammaster.MissingModIDs.StevesCarts2;
import static com.dreammaster.MissingModIDs.ZTones;
import static gregtech.api.enums.ModIDs.AdvancedSolarPanel;
import static gregtech.api.enums.ModIDs.AppliedEnergistics2;
import static gregtech.api.enums.ModIDs.EnderIO;
import static gregtech.api.enums.ModIDs.Forestry;
import static gregtech.api.enums.ModIDs.GalacticraftCore;
import static gregtech.api.enums.ModIDs.GalacticraftMars;
import static gregtech.api.enums.ModIDs.GregTech;
import static gregtech.api.enums.ModIDs.IndustrialCraft2;
import static gregtech.api.enums.ModIDs.Railcraft;
import static gregtech.api.enums.ModIDs.Translocator;

public class GT_Recipe_Remover implements Runnable {

    private static final String aTextMachineBeta = "machine.beta";
    private static final String aTextMachineAlpha = "machine.alpha";

    public void run() {
        // Vanilla
        GT_ModHandler.removeRecipeByOutputDelayed(new ItemStack(Blocks.iron_bars, 1, 32767), true, false, true);
        // AE
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AppliedEnergistics2.modID, "tile.BlockCraftingUnit", 1, 2),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AppliedEnergistics2.modID, "tile.BlockCraftingUnit", 1, 3),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1, 36),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1, 536),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1, 556),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1, 56),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1, 76),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 1, 576),
                true,
                false,
                true);
        // ASP
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AdvancedSolarPanel.modID, "BlockAdvSolarPanel", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AdvancedSolarPanel.modID, "BlockAdvSolarPanel", 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AdvancedSolarPanel.modID, "BlockAdvSolarPanel", 1L, 2),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AdvancedSolarPanel.modID, "BlockAdvSolarPanel", 1L, 3),
                true,
                false,
                true);
        // BG2
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "quiver", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "shield.wood", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "shield.hide", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "shield.iron", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "shield.gold", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "shield.diamond", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "dagger.wood", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "dagger.stone", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "dagger.iron", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "dagger.gold", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "dagger.diamond", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "spear.wood", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "spear.stone", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "spear.iron", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "spear.gold", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "spear.diamond", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "waraxe.wood", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "waraxe.stone", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "waraxe.iron", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "waraxe.gold", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "waraxe.diamond", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "mace.wood", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "mace.stone", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "mace.iron", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "mace.gold", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "mace.diamond", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(MineAndBladeBattleGear2.modID, "chain", 1L, 0), true, false, true);
        // Draconic Evolution
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(DraconicEvolution.modID, "chaosShard", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(DraconicEvolution.modID, "chaosFragment", 1L, 2),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(DraconicEvolution.modID, "chaosFragment", 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(DraconicEvolution.modID, "chaosFragment", 1L, 0),
                true,
                false,
                true);
        // Ender IO
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.modID, "itemBasicCapacitor", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.modID, "itemBasicCapacitor", 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.modID, "itemBasicCapacitor", 1L, 2),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.modID, "itemBasicCapacitor", 1L, 3),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.modID, "itemBasicCapacitor", 1L, 4),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.modID, "itemBasicCapacitor", 1L, 5),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.modID, "itemBasicCapacitor", 1L, 7),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.modID, "itemBasicCapacitor", 1L, 8),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.modID, "itemBasicCapacitor", 1L, 9),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.modID, "itemMEConduit", 1L),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.modID, "itemMEConduit", 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.modID, "itemMEConduit", 1L, 2),
                true,
                false,
                true);
        // Forestry
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.modID, "stamps", 1L, 0), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.modID, "stamps", 1L, 1), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.modID, "stamps", 1L, 2), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.modID, "stamps", 1L, 3), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.modID, "stamps", 1L, 4), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.modID, "stamps", 1L, 5), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.modID, "stamps", 1L, 6), true, false, true);

        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.modID, "engine", 1L, 0), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.modID, "engine", 1L, 1), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.modID, "engine", 1L, 2), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.modID, "engine", 1L, 4), true, false, true);
        // IC2
        GT_ModHandler.removeRecipeByOutputDelayed(ItemList.IC2_Energium_Dust.get(1L));
        GT_ModHandler.removeRecipeByOutputDelayed(ItemList.IC2_LapotronCrystal.get(1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemArmorNanoBoots", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemArmorNanoChestplate", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemArmorNanoHelmet", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemArmorNanoLegs", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemArmorQuantumBoots", 1L));
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemArmorQuantumChestplate", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemArmorQuantumHelmet", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemArmorQuantumLegs", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemArmorBatpack", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemArmorAdvBatpack", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemArmorEnergypack", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemAdvBat", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemNightvisionGoggles", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemArmorJetpackElectric", 1L));
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemArmorJetpack", 1L, GT_Values.W));
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemBatChargeRE", 1L, GT_Values.W));
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemBatChargeAdv", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemBatChargeCrystal", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemBatChargeLamaCrystal", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemTreetapElectric", 1, GT_Values.W));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemToolHoe", 1, GT_Values.W));
        // Natural Compass
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(NaturesCompass.modID, "NaturesCompass", 1L, 0),
                true,
                false,
                true);
        // Open Printers
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenPrinters.modID, "openprinter.printer", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenPrinters.modID, "openprinter.shredder", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenPrinters.modID, "openprinter.printerInkBlack", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenPrinters.modID, "openprinter.printerInkColor", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenPrinters.modID, "openprinter.folder", 1L, 0),
                true,
                false,
                true);
        // Open Security
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "magreader", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "rfidreader", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "rfidwriter", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(OpenSecurity.modID, "alarm", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "entitydetector", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "doorcontroller", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "opensecurity.DataBlock", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "opensecurity.SwitchableHub", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "opensecurity.BlockKVM", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "energyTurretBlock", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "keypadLock", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "biometricScanner", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "opensecurity.magCard", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "opensecurity.rfidCard", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "opensecurity.rfidReaderCard", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "opensecurity.secureNetworkCard", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "opensecurity.securityDoor", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "opensecurity.securityDoorPrivate", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "opensecurity.damageUpgrade", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "opensecurity.cooldownUpgrade", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "opensecurity.energyUpgrade", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.modID, "opensecurity.movementUpgrade", 1L, 0),
                true,
                false,
                true);
        // Railcraft
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineBeta, 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineBeta, 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineBeta, 1L, 2),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineBeta, 1L, 3),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineBeta, 1L, 4),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineBeta, 1L, 5),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineBeta, 1L, 6),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineBeta, 1L, 7),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineBeta, 1L, 8),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineBeta, 1L, 9),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineBeta, 1L, 10),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineBeta, 1L, 11),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineBeta, 1L, 12),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineBeta, 1L, 13),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineBeta, 1L, 14),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineBeta, 1L, 15),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineAlpha, 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineAlpha, 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineAlpha, 1L, 2),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineAlpha, 1L, 3),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineAlpha, 1L, 5),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineAlpha, 1L, 6),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineAlpha, 1L, 8),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineAlpha, 1L, 9),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineAlpha, 1L, 10),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineAlpha, 1L, 11),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineAlpha, 1L, 12),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineAlpha, 1L, 13),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineAlpha, 1L, 14),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, aTextMachineAlpha, 1L, 15),
                true,
                false,
                true);

        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, "tool.crowbar", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, "tool.crowbar.reinforced", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, "tool.whistle.tuner", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, "part.turbine.blade", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, "part.turbine.disk", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, "part.turbine.rotor", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, "borehead.iron", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, "borehead.steel", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, "borehead.diamond", 1L, 0),
                true,
                false,
                true);

        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, "cart.loco.steam.solid", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, "cart.loco.electric", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, "cart.bore", 1L, 0),
                true,
                false,
                true);

        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, "part.circuit", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, "part.circuit", 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.modID, "part.circuit", 1L, 2),
                true,
                false,
                true);
        // Steve Carts
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(StevesCarts2.modID, "ModuleComponents", 1L, 9),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(StevesCarts2.modID, "ModuleComponents", 1L, 16),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(StevesCarts2.modID, "ModuleComponents", 1L, 18),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(StevesCarts2.modID, "ModuleComponents", 1L, 19),
                true,
                false,
                true);
        // Translocator
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Translocator.modID, "diamondNugget", 2L, 0),
                true,
                false,
                true);
        // Ztones
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(ZTones.modID, "ofanix", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeDelayed(GT_ModHandler.getModItem(ZTones.modID, "ofanix", 1L, 0));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(ZTones.modID, "stoneTile", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(ZTones.modID, "auroraBlock", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(ZTones.modID, "minicharcoal", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(ZTones.modID, "minicoal", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(ZTones.modID, "cleanDirt", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(ZTones.modID, "booster", 1L, 0), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(ZTones.modID, "lampf", 1L, 0), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(ZTones.modID, "lampt", 1L, 0), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(ZTones.modID, "lampb", 1L, 0), true, false, true);

        // Galacticraft

        // --- Rocket Launch Pad
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.landingPad", 1L, 0),
                true,
                false,
                true);

        // --- Buggy Fueling Pad
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.landingPad", 1L, 1),
                true,
                false,
                true);

        // --- Oxygen Collector
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.oxygenCollector", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Compressor
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.oxygenCompressor", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Decompressor
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.oxygenCompressor", 1L, 4),
                true,
                false,
                true);

        // --- Oxygen Storage Module
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.machine2", 1L, 8),
                true,
                false,
                true);

        // --- Oxygen Bubble Distributor
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.distributor", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Sealer
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.sealer", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Detector
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.oxygenDetector", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.oxygenPipe", 1L, 0),
                true,
                false,
                true);

        // --- Refinery
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.refinery", 1L, 0),
                true,
                false,
                true);

        // --- Fuel Loader
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.fuelLoader", 1L, 0),
                true,
                false,
                true);

        // --- Sealeable Oxygen Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.enclosed", 1L, 1),
                true,
                false,
                true);

        // --- Sealeable Copper Cable
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.enclosed", 1L, 2),
                true,
                false,
                true);

        // --- Sealeable Gold Cable
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.enclosed", 1L, 3),
                true,
                false,
                true);

        // --- Sealeable HV Cable
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.enclosed", 1L, 4),
                true,
                false,
                true);

        // --- Sealeable Glass Fibre Cable
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.enclosed", 1L, 5),
                true,
                false,
                true);

        // --- Sealeable Tin Cable
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.enclosed", 1L, 6),
                true,
                false,
                true);

        // --- Fuel Loader
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.fuelLoader", 1L, 0),
                true,
                false,
                true);

        // --- Cargo Loader
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.cargo", 1L, 0),
                true,
                false,
                true);

        // --- Cargo Unloader
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.cargo", 1L, 4),
                true,
                false,
                true);

        // --- Tin Decoration Block
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.gcBlockCore", 1L, 3),
                true,
                false,
                true);
        // -
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.gcBlockCore", 1L, 4),
                true,
                false,
                true);

        // --- Copper Block
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.gcBlockCore", 1L, 9),
                true,
                false,
                true);

        // --- Tin Block
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.gcBlockCore", 1L, 10),
                true,
                false,
                true);

        // --- Aluminum Block
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.gcBlockCore", 1L, 11),
                true,
                false,
                true);

        // --- Meteoric Iron Ingot
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GregTech.modID, "gt.metaitem.01", 1L, 11340),
                true,
                false,
                true);

        // --- Solid Meteoric Iron
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.gcBlockCore", 1L, 12),
                true,
                false,
                true);

        // --- Air Lock Frame
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.airLockFrame", 1L, 0),
                true,
                false,
                true);

        // --- Air Lock Controller
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.airLockFrame", 1L, 1),
                true,
                false,
                true);

        // --- Sealable Oxygen Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.enclosed", 1L, 1),
                true,
                false,
                true);

        // --- Sealable Aluminium Wire
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.enclosed", 1L, 14),
                true,
                false,
                true);

        // --- Sealable ME Wire
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.enclosed", 1L, 13),
                true,
                false,
                true);

        // --- Sealable heavy Aluminium Wire
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.enclosed", 1L, 15),
                true,
                false,
                true);

        // --- Aluminium Wire
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.aluminumWire", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Aluminium Wire
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.aluminumWire", 1L, 1),
                true,
                false,
                true);

        // --- Basic Solar Panel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.solar", 1L, 0),
                true,
                false,
                true);

        // --- Advanced Solar Panel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.solar", 1L, 4),
                true,
                false,
                true);

        // --- Wafer Solar
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.basicItem", 1L, 12),
                true,
                false,
                true);

        // --- Single Solar Modul
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.basicItem", 1L, 0),
                true,
                false,
                true);

        // --- Full Solar Panel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.basicItem", 1L, 1),
                true,
                false,
                true);

        // --- Coal Generator
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.machine", 1L, 0),
                true,
                false,
                true);

        // --- Compressor
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.machine", 1L, 12),
                true,
                false,
                true);

        // --- Electric Compressor
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.machine2", 1L, 0),
                true,
                false,
                true);

        // --- Circuit Fabricator
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.machine2", 1L, 4),
                true,
                false,
                true);

        // --- Energy Storage Module
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.machineTiered", 1L, 0),
                true,
                false,
                true);

        // --- Electric Furnace
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.machineTiered", 1L, 4),
                true,
                false,
                true);

        // --- Energy Storage Cluster
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.machineTiered", 1L, 8),
                true,
                false,
                true);

        // --- Electric Arc Furnace
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.machineTiered", 1L, 12),
                true,
                false,
                true);

        // --- Glowstone Torch
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.glowstoneTorch", 1L, 0),
                true,
                false,
                true);

        // --- Spin Truster
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.spinThruster", 1L, 0),
                true,
                false,
                true);

        // --- Display Screen
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.viewScreen", 1L, 0),
                true,
                false,
                true);

        // --- Telemetry Unit
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.telemetry", 1L, 0),
                true,
                false,
                true);

        // --- Arc Lamp
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.arclamp", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Mask
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.oxygenMask", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Gear
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.oxygenGear", 1L, 0),
                true,
                false,
                true);

        // --- Sensor Lens
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.sensorLens", 1L, 0),
                true,
                false,
                true);

        // --- Sensor Glasses
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.sensorGlasses", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Pickaxe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.steel_pickaxe", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Axe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.steel_axe", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Hoe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.steel_hoe", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Shovel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.steel_shovel", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Sword
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.steel_sword", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Helmet
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.steel_helmet", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Chest Plate
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.steel_chestplate", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Leggings
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.steel_leggings", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Boots
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.steel_boots", 1L, 0),
                true,
                false,
                true);

        // --- Tin Canister
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.canister", 1L, 0),
                true,
                false,
                true);

        // --- Copper Canister
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.canister", 1L, 1),
                true,
                false,
                true);

        // --- Oxygen Vent
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.airVent", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Fan
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.airFan", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Concentrator
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.oxygenConcentrator", 1L, 0),
                true,
                false,
                true);

        // --- Tier 1 Rocket Engine
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.engine", 1L, 0),
                true,
                false,
                true);

        // --- Tier 1 Booster
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.engine", 1L, 1),
                true,
                false,
                true);

        // --- Nose Cone
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.noseCone", 1L, 0),
                true,
                false,
                true);

        // --- Steel Pole
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.steelPole", 1L, 0),
                true,
                false,
                true);

        // --- Canister
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.oilCanisterPartial", 1L, 1001),
                true,
                false,
                true);

        // --- Oil Extractor
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.oilExtractor", 1L, 0),
                true,
                false,
                true);

        // --- Buggy Wheel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.buggymat", 1L, 0),
                true,
                false,
                true);

        // --- Buggy Seat
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.buggymat", 1L, 1),
                true,
                false,
                true);

        // --- Buggy Storage Box
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.buggymat", 1L, 2),
                true,
                false,
                true);

        // --- Standard Wrench
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.standardWrench", 1L, 0),
                true,
                false,
                true);

        // --- Can of Food
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.basicItem", 1L, 15),
                true,
                false,
                true);
        // -
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.basicItem", 1L, 16),
                true,
                false,
                true);
        // -
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.basicItem", 1L, 17),
                true,
                false,
                true);
        // -
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.basicItem", 1L, 18),
                true,
                false,
                true);

        // --- Frequency Module
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.basicItem", 1L, 19),
                true,
                false,
                true);

        // --- Battery
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.battery", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Pickaxe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.titanium_pickaxe", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Axe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.titanium_axe", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Hoe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.titanium_hoe", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Shovel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.titanium_shovel", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Sword
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.titanium_sword", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Helmet
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.titanium_helmet", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Chest Plate
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.titanium_chestplate", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Leggings
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.titanium_leggings", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Boots
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.titanium_boots", 1L, 0),
                true,
                false,
                true);

        // --- Desh Block
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.mars", 1L, 8),
                true,
                false,
                true);

        // --- Desh Ingot
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem("ore", "ingotDesh", 1L, 0), true, false, true);

        // --- Desh Stick
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.null", 1L, 1),
                true,
                false,
                true);

        // --- Gas Liquifier
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.marsMachineT2", 1L, 0),
                true,
                false,
                true);

        // --- Methan Synthesizer
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.marsMachineT2", 1L, 4),
                true,
                false,
                true);

        // --- Water Electrolyzer
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.marsMachineT2", 1L, 8),
                true,
                false,
                true);

        // --- Walkway
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.walkway", 1L, 0),
                true,
                false,
                true);

        // --- Walkway Aluminium
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.walkwayWire", 1L, 0),
                true,
                false,
                true);

        // --- Walkway Pipes
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.walkwayOxygenPipe", 1L, 0),
                true,
                false,
                true);

        // --- Thermal Cloth
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.itemBasicAsteroids", 1L, 7),
                true,
                false,
                true);

        // --- Atmospheric Valve
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.atmosphericValve", 1L, 0),
                true,
                false,
                true);

        // --- Rocket Fins
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.rocketFins", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Rocket Fins
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.itemBasicAsteroids", 1L, 2),
                true,
                false,
                true);

        // --- Heavy Rocket Engine
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.itemBasicAsteroids", 1L, 1),
                true,
                false,
                true);

        // --- Heavy Nose Cone
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.heavyNoseCone", 1L, 0),
                true,
                false,
                true);

        // --- Red Core
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.itemBasicAsteroids", 1L, 8),
                true,
                false,
                true);

        // --- Fluid Manipulator
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.null", 1L, 6),
                true,
                false,
                true);

        // --- Energy Beam Reflector
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.beamReflector", 1L, 0),
                true,
                false,
                true);

        // --- Energy Beam Receiver
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.beamReceiver", 1L, 0),
                true,
                false,
                true);

        // --- Short range Teleporter
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.telepadShort", 1L, 0),
                true,
                false,
                true);

        // --- Cryogenic Chamber
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.marsMachine", 1L, 4),
                true,
                false,
                true);

        // --- Terraformer
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.marsMachine", 1L, 0),
                true,
                false,
                true);

        // --- Launch Controller
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.marsMachine", 1L, 8),
                true,
                false,
                true);

        // --- Grappler
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.grapple", 1L, 0),
                true,
                false,
                true);

        // --- Hydrogen Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.hydrogenPipe", 1L, 0),
                true,
                false,
                true);

        // --- Carbon Fragments
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.carbonFragments", 1L, 0),
                true,
                false,
                true);

        // --- Thermal Padding Helm
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.thermalPadding", 1L, 0),
                true,
                false,
                true);

        // --- Thermal Padding Chestpiece
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.thermalPadding", 1L, 1),
                true,
                false,
                true);

        // --- Thermal Padding Leggings
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.thermalPadding", 1L, 2),
                true,
                false,
                true);

        // --- Thermal Padding Boots
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.thermalPadding", 1L, 3),
                true,
                false,
                true);

        // --- Desh Helmet
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.deshHelmet", 1L, 0),
                true,
                false,
                true);

        // --- Desh Chest Plate
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.deshChestplate", 1L, 0),
                true,
                false,
                true);

        // --- Desh Leggings
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.deshLeggings", 1L, 0),
                true,
                false,
                true);

        // --- Desh Boots
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.deshBoots", 1L, 0),
                true,
                false,
                true);

        // --- Desh Pickaxe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.deshPick", 1L, 0),
                true,
                false,
                true);

        // --- Desh Axe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.deshAxe", 1L, 0),
                true,
                false,
                true);

        // --- Desh Hoe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.deshHoe", 1L, 0),
                true,
                false,
                true);

        // --- Desh Shovel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.deshSpade", 1L, 0),
                true,
                false,
                true);

        // --- Desh Sword
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.deshSword", 1L, 0),
                true,
                false,
                true);

        // --- Sealable Cobblestone Transport Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.enclosed", 1L, 8),
                true,
                false,
                true);

        // --- Sealable Stone Transport Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.enclosed", 1L, 7),
                true,
                false,
                true);

        // --- Sealable Cobblestone Fluid Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.enclosed", 1L, 10),
                true,
                false,
                true);

        // --- Sealable Stone Fluid Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.enclosed", 1L, 9),
                true,
                false,
                true);

        // --- Sealable Stone Kinesis Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.enclosed", 1L, 11),
                true,
                false,
                true);

        // --- Sealable Gold Kinesis Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.enclosed", 1L, 12),
                true,
                false,
                true);

        // --- Astro Miner Base
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.minerBase", 1L, 0),
                true,
                false,
                true);

        // --- Orion Drive
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.modID, "item.orionDrive", 1L, 0),
                true,
                false,
                true);

        // --- Canvas
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.canvas", 1L, 0),
                true,
                false,
                true);

        // --- Ambient Thermal Controller
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.basicItem", 1L, 20),
                true,
                false,
                true);

        // --- Parachute
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.modID, "item.parachute", 1L, 0),
                true,
                false,
                true);

    }
}
