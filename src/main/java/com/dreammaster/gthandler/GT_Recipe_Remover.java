package com.dreammaster.gthandler;

import static com.dreammaster.scripts.IScriptLoader.wildcard;
import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.MineAndBladeBattleGear2;
import static gregtech.api.enums.Mods.NaturesCompass;
import static gregtech.api.enums.Mods.OpenPrinters;
import static gregtech.api.enums.Mods.OpenSecurity;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.Translocator;
import static gregtech.api.enums.Mods.ZTones;
import static gregtech.api.util.GTModHandler.getModItem;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.util.GTModHandler;

public class GT_Recipe_Remover implements Runnable {

    private static final String aTextMachineBeta = "machine.beta";
    private static final String aTextMachineAlpha = "machine.alpha";

    public void run() {

        // Vanilla
        GTModHandler.removeRecipeByOutputDelayed(new ItemStack(Blocks.iron_bars, 1, wildcard), true, false, true);
        // ASP
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1L, 1),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1L, 2),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1L, 3),
                true,
                false,
                true);
        // BG2
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "quiver", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "shield.wood", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "shield.hide", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "shield.iron", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "shield.gold", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "shield.diamond", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "dagger.wood", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "dagger.stone", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "dagger.iron", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "dagger.gold", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "dagger.diamond", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "spear.wood", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "spear.stone", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "spear.iron", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "spear.gold", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "spear.diamond", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.wood", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.stone", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.iron", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.gold", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.diamond", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "mace.wood", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "mace.stone", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "mace.iron", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "mace.gold", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "mace.diamond", 1L, 0),
                true,
                false,
                true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(MineAndBladeBattleGear2.ID, "chain", 1L, 0), true, false, true);
        // Draconic Evolution
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(DraconicEvolution.ID, "chaosShard", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(DraconicEvolution.ID, "chaosFragment", 1L, 2),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(DraconicEvolution.ID, "chaosFragment", 1L, 1),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(DraconicEvolution.ID, "chaosFragment", 1L, 0),
                true,
                false,
                true);
        // Ender IO
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 0), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 1), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 2), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 3), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 4), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 5), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 7), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 8), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 9), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMEConduit", 1L), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMEConduit", 1L, 1), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMEConduit", 1L, 2), true, false, true);
        // Forestry
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1L, 1), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1L, 2), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1L, 3), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1L, 4), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1L, 5), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1L, 6), true, false, true);

        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "engine", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "engine", 1L, 1), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "engine", 1L, 2), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "engine", 1L, 4), true, false, true);
        // IC2
        GTModHandler.removeRecipeByOutputDelayed(ItemList.IC2_Energium_Dust.get(1L));
        GTModHandler.removeRecipeByOutputDelayed(ItemList.IC2_LapotronCrystal.get(1L));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorNanoBoots", 1L));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorNanoChestplate", 1L));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorNanoHelmet", 1L));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorNanoLegs", 1L));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorQuantumBoots", 1L));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorQuantumChestplate", 1L));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorQuantumHelmet", 1L));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorQuantumLegs", 1L));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorBatpack", 1L));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorAdvBatpack", 1L));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorEnergypack", 1L));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemAdvBat", 1L));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemNightvisionGoggles", 1L));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorJetpackElectric", 1L));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorJetpack", 1L, GTValues.W));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemBatChargeRE", 1L, GTValues.W));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemBatChargeAdv", 1L, GTValues.W));
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemBatChargeCrystal", 1L, GTValues.W));
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(IndustrialCraft2.ID, "itemBatChargeLamaCrystal", 1L, GTValues.W));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemTreetapElectric", 1, GTValues.W));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolHoe", 1, GTValues.W));
        // Natural Compass
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(NaturesCompass.ID, "NaturesCompass", 1L, 0), true, false, true);
        // Open Printers
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenPrinters.ID, "openprinter.printer", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenPrinters.ID, "openprinter.shredder", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenPrinters.ID, "openprinter.printerInkBlack", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenPrinters.ID, "openprinter.printerInkColor", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenPrinters.ID, "openprinter.folder", 1L, 0),
                true,
                false,
                true);
        // Open Security
        GTModHandler.removeRecipeByOutputDelayed(getModItem(OpenSecurity.ID, "magreader", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(OpenSecurity.ID, "rfidreader", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(OpenSecurity.ID, "rfidwriter", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(OpenSecurity.ID, "alarm", 1L, 0), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(OpenSecurity.ID, "entitydetector", 1L, 0), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(OpenSecurity.ID, "doorcontroller", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.DataBlock", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.SwitchableHub", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.BlockKVM", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "energyTurretBlock", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(OpenSecurity.ID, "keypadLock", 1L, 0), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(OpenSecurity.ID, "biometricScanner", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.magCard", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.rfidCard", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.rfidReaderCard", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.secureNetworkCard", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.securityDoor", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.securityDoorPrivate", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.damageUpgrade", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.cooldownUpgrade", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.energyUpgrade", 1L, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.movementUpgrade", 1L, 0),
                true,
                false,
                true);
        // Railcraft
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1L, 1), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1L, 2), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1L, 3), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1L, 4), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1L, 5), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1L, 6), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1L, 7), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1L, 8), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1L, 9), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1L, 10), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1L, 11), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1L, 12), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1L, 13), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1L, 14), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1L, 15), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 1), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 2), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 3), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 5), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 6), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 8), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 9), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 10), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 11), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 12), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 13), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 14), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 15), true, false, true);

        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "tool.crowbar", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(Railcraft.ID, "tool.crowbar.reinforced", 1L, 0),
                true,
                false,
                true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "tool.whistle.tuner", 1L, 0), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.turbine.blade", 1L, 0), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.turbine.disk", 1L, 0), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.turbine.rotor", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "borehead.iron", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "borehead.steel", 1L, 0), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "borehead.diamond", 1L, 0), true, false, true);

        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(Railcraft.ID, "cart.loco.steam.solid", 1L, 0),
                true,
                false,
                true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "cart.loco.electric", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "cart.bore", 1L, 0), true, false, true);

        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.circuit", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.circuit", 1L, 1), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.circuit", 1L, 2), true, false, true);
        // Steve Carts
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1L, 9), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1L, 16),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1L, 18),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1L, 19),
                true,
                false,
                true);
        // Thaumcraft
        GTModHandler.removeRecipeByOutputDelayed(
                GTModHandler.getModItem(Thaumcraft.ID, "ItemEssence", 1L, 0),
                true,
                false,
                true);
        // Translocator
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(Translocator.ID, "diamondNugget", 2L, 0), true, false, true);
        // Ztones
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "ofanix", 1L, 0), true, false, true);
        GTModHandler.removeRecipeDelayed(getModItem(ZTones.ID, "ofanix", 1L, 0));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "stoneTile", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "auroraBlock", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "minicharcoal", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "minicoal", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "cleanDirt", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "booster", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "lampf", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "lampt", 1L, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "lampb", 1L, 0), true, false, true);
    }
}
