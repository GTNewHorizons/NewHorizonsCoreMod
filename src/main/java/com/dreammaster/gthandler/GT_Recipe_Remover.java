package com.dreammaster.gthandler;

import static com.dreammaster.scripts.IScriptLoader.wildcard;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
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
import static gregtech.api.util.GTRecipeBuilder.WILDCARD;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

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
                getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1, 1),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1, 2),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1, 3),
                true,
                false,
                true);
        // BG2
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(MineAndBladeBattleGear2.ID, "quiver", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "shield.wood", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "shield.hide", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "shield.iron", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "shield.gold", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "shield.diamond", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "dagger.wood", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "dagger.stone", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "dagger.iron", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "dagger.gold", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "dagger.diamond", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "spear.wood", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "spear.stone", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "spear.iron", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "spear.gold", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "spear.diamond", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.wood", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.stone", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.iron", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.gold", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "waraxe.diamond", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "mace.wood", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "mace.stone", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "mace.iron", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "mace.gold", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(MineAndBladeBattleGear2.ID, "mace.diamond", 1, 0),
                true,
                false,
                true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(MineAndBladeBattleGear2.ID, "chain", 1, 0), true, false, true);
        // Draconic Evolution
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(DraconicEvolution.ID, "chaosShard", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(DraconicEvolution.ID, "chaosFragment", 1, 2),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(DraconicEvolution.ID, "chaosFragment", 1, 1),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(DraconicEvolution.ID, "chaosFragment", 1, 0),
                true,
                false,
                true);
        // Ender IO
        GTModHandler.removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 3), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 4), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 5), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMEConduit", 1), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMEConduit", 1, 1), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMEConduit", 1, 2), true, false, true);
        // Forestry
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1, 1), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1, 2), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1, 3), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1, 4), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1, 5), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1, 6), true, false, true);

        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "engine", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "engine", 1, 1), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "engine", 1, 2), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Forestry.ID, "engine", 1, 4), true, false, true);
        // IC2
        GTModHandler.removeRecipeByOutputDelayed(ItemList.IC2_Energium_Dust.get(1L));
        GTModHandler.removeRecipeByOutputDelayed(ItemList.IC2_LapotronCrystal.get(1L));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorNanoBoots", 1));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorNanoChestplate", 1));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorNanoHelmet", 1));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorNanoLegs", 1));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorQuantumBoots", 1));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorQuantumChestplate", 1));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorQuantumHelmet", 1));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorQuantumLegs", 1));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorBatpack", 1));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorAdvBatpack", 1));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorEnergypack", 1));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemAdvBat", 1));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemNightvisionGoggles", 1));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorJetpackElectric", 1));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorJetpack", 1, WILDCARD));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemBatChargeRE", 1, WILDCARD));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemBatChargeAdv", 1, WILDCARD));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemBatChargeCrystal", 1, WILDCARD));
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemBatChargeLamaCrystal", 1, WILDCARD));
        // Natural Compass
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(NaturesCompass.ID, "NaturesCompass", 1, 0), true, false, true);
        // Open Printers
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenPrinters.ID, "openprinter.printer", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenPrinters.ID, "openprinter.shredder", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenPrinters.ID, "openprinter.printerInkBlack", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenPrinters.ID, "openprinter.printerInkColor", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenPrinters.ID, "openprinter.folder", 1, 0),
                true,
                false,
                true);
        // Open Security
        GTModHandler.removeRecipeByOutputDelayed(getModItem(OpenSecurity.ID, "magreader", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(OpenSecurity.ID, "rfidreader", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(OpenSecurity.ID, "rfidwriter", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(OpenSecurity.ID, "alarm", 1, 0), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(OpenSecurity.ID, "entitydetector", 1, 0), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(OpenSecurity.ID, "doorcontroller", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.DataBlock", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.SwitchableHub", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.BlockKVM", 1, 0),
                true,
                false,
                true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(OpenSecurity.ID, "energyTurretBlock", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(OpenSecurity.ID, "keypadLock", 1, 0), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(OpenSecurity.ID, "biometricScanner", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.magCard", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.rfidCard", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.rfidReaderCard", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.secureNetworkCard", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.securityDoor", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.securityDoorPrivate", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.damageUpgrade", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.cooldownUpgrade", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.energyUpgrade", 1, 0),
                true,
                false,
                true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(OpenSecurity.ID, "opensecurity.movementUpgrade", 1, 0),
                true,
                false,
                true);
        // Railcraft
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1, 1), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1, 2), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1, 3), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1, 4), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1, 5), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1, 6), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1, 7), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1, 8), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1, 9), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1, 10), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1, 11), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1, 12), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1, 13), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1, 14), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineBeta, 1, 15), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1, 1), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1, 2), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1, 3), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1, 5), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1, 6), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1, 8), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1, 9), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1, 10), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1, 11), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1, 12), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1, 13), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1, 14), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, aTextMachineAlpha, 1, 15), true, false, true);

        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "tool.crowbar", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(Railcraft.ID, "tool.crowbar.reinforced", 1, 0),
                true,
                false,
                true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "tool.whistle.tuner", 1, 0), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.turbine.blade", 1, 0), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.turbine.disk", 1, 0), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.turbine.rotor", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "borehead.iron", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "borehead.steel", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "borehead.diamond", 1, 0), true, false, true);

        GTModHandler.removeRecipeByOutputDelayed(
                getModItem(Railcraft.ID, "cart.loco.steam.solid", 1, 0),
                true,
                false,
                true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "cart.loco.electric", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "cart.bore", 1, 0), true, false, true);

        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.circuit", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.circuit", 1, 1), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.circuit", 1, 2), true, false, true);
        // Steve Carts
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 18), true, false, true);
        GTModHandler
                .removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 19), true, false, true);
        // Thaumcraft
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemEssence", 1, 0), true, false, true);
        // Translocator
        GTModHandler.removeRecipeByOutputDelayed(getModItem(Translocator.ID, "diamondNugget", 2, 0), true, false, true);
        // Ztones
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "ofanix", 1, 0), true, false, true);
        GTModHandler.removeRecipeDelayed(getModItem(ZTones.ID, "ofanix", 1, 0));
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "stoneTile", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "auroraBlock", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "minicharcoal", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "minicoal", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "cleanDirt", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "booster", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "lampf", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "lampt", 1, 0), true, false, true);
        GTModHandler.removeRecipeByOutputDelayed(getModItem(ZTones.ID, "lampb", 1, 0), true, false, true);
    }
}
