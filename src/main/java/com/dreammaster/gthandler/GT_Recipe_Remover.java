package com.dreammaster.gthandler;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.util.GT_ModHandler;

public class GT_Recipe_Remover implements Runnable {

    private static final String modNameAE = "appliedenergistics2";
    private static final String modNameBG2 = "battlegear2";
    private static final String modNameEIO = "EnderIO";
    private static final String modNameFor = "Forestry";
    private static final String modNameIC2 = "IC2";
    private static final String modNameOS = "opensecurity";
    private static final String modNameRC = "Railcraft";
    private static final String modNameZt = "Ztones";
    private static final String aTextMachineBeta = "machine.beta";
    private static final String aTextMachineAlpha = "machine.alpha";

    public void run() {
        // Vanilla
        GT_ModHandler.removeRecipeByOutputDelayed(new ItemStack(Blocks.iron_bars, 1, 32767), true, false, true);
        // AE
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameAE, "tile.BlockCraftingUnit", 1, 2),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameAE, "tile.BlockCraftingUnit", 1, 3),
                true,
                false,
                true);
        // ASP
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 2),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 3),
                true,
                false,
                true);
        // BG2
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameBG2, "quiver", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "shield.wood", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "shield.hide", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "shield.iron", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "shield.gold", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "shield.diamond", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "dagger.wood", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "dagger.stone", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "dagger.iron", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "dagger.gold", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "dagger.diamond", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "spear.wood", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "spear.stone", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "spear.iron", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "spear.gold", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "spear.diamond", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "waraxe.wood", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "waraxe.stone", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "waraxe.iron", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "waraxe.gold", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "waraxe.diamond", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "mace.wood", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "mace.stone", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "mace.iron", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "mace.gold", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameBG2, "mace.diamond", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameBG2, "chain", 1L, 0), true, false, true);
        // Draconic Evolution
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("DraconicEvolution", "chaosShard", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("DraconicEvolution", "chaosFragment", 1L, 2),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("DraconicEvolution", "chaosFragment", 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("DraconicEvolution", "chaosFragment", 1L, 0),
                true,
                false,
                true);
        // Ender IO
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameEIO, "itemBasicCapacitor", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameEIO, "itemBasicCapacitor", 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameEIO, "itemBasicCapacitor", 1L, 2),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameEIO, "itemBasicCapacitor", 1L, 3),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameEIO, "itemBasicCapacitor", 1L, 4),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameEIO, "itemBasicCapacitor", 1L, 5),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameEIO, "itemBasicCapacitor", 1L, 7),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameEIO, "itemBasicCapacitor", 1L, 8),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameEIO, "itemBasicCapacitor", 1L, 9),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameEIO, "itemMEConduit", 1L),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameEIO, "itemMEConduit", 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameEIO, "itemMEConduit", 1L, 2),
                true,
                false,
                true);
        // Forestry
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameFor, "stamps", 1L, 0), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameFor, "stamps", 1L, 1), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameFor, "stamps", 1L, 2), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameFor, "stamps", 1L, 3), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameFor, "stamps", 1L, 4), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameFor, "stamps", 1L, 5), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameFor, "stamps", 1L, 6), true, false, true);

        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameFor, "engine", 1L, 0), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameFor, "engine", 1L, 1), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameFor, "engine", 1L, 2), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameFor, "engine", 1L, 4), true, false, true);
        // IC2
        GT_ModHandler.removeRecipeByOutputDelayed(ItemList.IC2_Energium_Dust.get(1L));
        GT_ModHandler.removeRecipeByOutputDelayed(ItemList.IC2_LapotronCrystal.get(1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameIC2, "itemArmorNanoBoots", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameIC2, "itemArmorNanoChestplate", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameIC2, "itemArmorNanoHelmet", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameIC2, "itemArmorNanoLegs", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameIC2, "itemArmorQuantumBoots", 1L));
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameIC2, "itemArmorQuantumChestplate", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameIC2, "itemArmorQuantumHelmet", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameIC2, "itemArmorQuantumLegs", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameIC2, "itemArmorBatpack", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameIC2, "itemArmorAdvBatpack", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameIC2, "itemArmorEnergypack", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameIC2, "itemAdvBat", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameIC2, "itemNightvisionGoggles", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameIC2, "itemArmorJetpackElectric", 1L));
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameIC2, "itemArmorJetpack", 1L, GT_Values.W));
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameIC2, "itemBatChargeRE", 1L, GT_Values.W));
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameIC2, "itemBatChargeAdv", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameIC2, "itemBatChargeCrystal", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameIC2, "itemBatChargeLamaCrystal", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameIC2, "itemTreetapElectric", 1, GT_Values.W));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameIC2, "itemToolHoe", 1, GT_Values.W));
        // Natural Compass
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("naturescompass", "NaturesCompass", 1L, 0),
                true,
                false,
                true);
        // Open Printers
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("openprinter", "openprinter.printer", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("openprinter", "openprinter.shredder", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("openprinter", "openprinter.printerInkBlack", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("openprinter", "openprinter.printerInkColor", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("openprinter", "openprinter.folder", 1L, 0),
                true,
                false,
                true);
        // Open Security
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "magreader", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "rfidreader", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "rfidwriter", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameOS, "alarm", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "entitydetector", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "doorcontroller", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "opensecurity.DataBlock", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "opensecurity.SwitchableHub", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "opensecurity.BlockKVM", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "energyTurretBlock", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "keypadLock", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "biometricScanner", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "opensecurity.magCard", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "opensecurity.rfidCard", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "opensecurity.rfidReaderCard", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "opensecurity.secureNetworkCard", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "opensecurity.securityDoor", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "opensecurity.securityDoorPrivate", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "opensecurity.damageUpgrade", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "opensecurity.cooldownUpgrade", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "opensecurity.energyUpgrade", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameOS, "opensecurity.movementUpgrade", 1L, 0),
                true,
                false,
                true);
        // Railcraft
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineBeta, 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineBeta, 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineBeta, 1L, 2),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineBeta, 1L, 3),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineBeta, 1L, 4),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineBeta, 1L, 5),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineBeta, 1L, 6),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineBeta, 1L, 7),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineBeta, 1L, 8),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineBeta, 1L, 9),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineBeta, 1L, 10),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineBeta, 1L, 11),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineBeta, 1L, 12),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineBeta, 1L, 13),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineBeta, 1L, 14),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineBeta, 1L, 15),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineAlpha, 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineAlpha, 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineAlpha, 1L, 2),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineAlpha, 1L, 3),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineAlpha, 1L, 5),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineAlpha, 1L, 6),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineAlpha, 1L, 8),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineAlpha, 1L, 9),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineAlpha, 1L, 10),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineAlpha, 1L, 11),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineAlpha, 1L, 12),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineAlpha, 1L, 13),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineAlpha, 1L, 14),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, aTextMachineAlpha, 1L, 15),
                true,
                false,
                true);

        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, "tool.crowbar", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, "tool.crowbar.reinforced", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, "tool.whistle.tuner", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, "part.turbine.blade", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, "part.turbine.disk", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, "part.turbine.rotor", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, "borehead.iron", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, "borehead.steel", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, "borehead.diamond", 1L, 0),
                true,
                false,
                true);

        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, "cart.loco.steam.solid", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, "cart.loco.electric", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, "cart.bore", 1L, 0),
                true,
                false,
                true);

        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, "part.circuit", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, "part.circuit", 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameRC, "part.circuit", 1L, 2),
                true,
                false,
                true);
        // Steve Carts
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 9),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 16),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 18),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 19),
                true,
                false,
                true);
        // Translocator
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("Translocator", "diamondNugget", 2L, 0),
                true,
                false,
                true);
        // Ztones
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameZt, "ofanix", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeDelayed(GT_ModHandler.getModItem(modNameZt, "ofanix", 1L, 0));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameZt, "stoneTile", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameZt, "auroraBlock", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameZt, "minicharcoal", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameZt, "minicoal", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(modNameZt, "cleanDirt", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameZt, "booster", 1L, 0), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameZt, "lampf", 1L, 0), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameZt, "lampt", 1L, 0), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(modNameZt, "lampb", 1L, 0), true, false, true);

        // Galacticraft

        // --- Rocket Launch Pad
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.landingPad", 1L, 0),
                true,
                false,
                true);

        // --- Buggy Fueling Pad
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.landingPad", 1L, 1),
                true,
                false,
                true);

        // --- Oxygen Collector
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenCollector", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Compressor
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenCompressor", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Decompressor
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenCompressor", 1L, 4),
                true,
                false,
                true);

        // --- Oxygen Storage Module
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.machine2", 1L, 8),
                true,
                false,
                true);

        // --- Oxygen Bubble Distributor
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.distributor", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Sealer
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.sealer", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Detector
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenDetector", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.oxygenPipe", 1L, 0),
                true,
                false,
                true);

        // --- Refinery
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.refinery", 1L, 0),
                true,
                false,
                true);

        // --- Fuel Loader
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.fuelLoader", 1L, 0),
                true,
                false,
                true);

        // --- Sealeable Oxygen Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 1),
                true,
                false,
                true);

        // --- Sealeable Copper Cable
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 2),
                true,
                false,
                true);

        // --- Sealeable Gold Cable
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 3),
                true,
                false,
                true);

        // --- Sealeable HV Cable
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 4),
                true,
                false,
                true);

        // --- Sealeable Glass Fibre Cable
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 5),
                true,
                false,
                true);

        // --- Sealeable Tin Cable
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 6),
                true,
                false,
                true);

        // --- Fuel Loader
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.fuelLoader", 1L, 0),
                true,
                false,
                true);

        // --- Cargo Loader
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.cargo", 1L, 0),
                true,
                false,
                true);

        // --- Cargo Unloader
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.cargo", 1L, 4),
                true,
                false,
                true);

        // --- Tin Decoration Block
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.gcBlockCore", 1L, 3),
                true,
                false,
                true);
        // -
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.gcBlockCore", 1L, 4),
                true,
                false,
                true);

        // --- Copper Block
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.gcBlockCore", 1L, 9),
                true,
                false,
                true);

        // --- Tin Block
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.gcBlockCore", 1L, 10),
                true,
                false,
                true);

        // --- Aluminum Block
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.gcBlockCore", 1L, 11),
                true,
                false,
                true);

        // --- Meteoric Iron Ingot
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("gregtech", "gt.metaitem.01", 1L, 11340),
                true,
                false,
                true);

        // --- Solid Meteoric Iron
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.gcBlockCore", 1L, 12),
                true,
                false,
                true);

        // --- Air Lock Frame
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.airLockFrame", 1L, 0),
                true,
                false,
                true);

        // --- Air Lock Controller
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.airLockFrame", 1L, 1),
                true,
                false,
                true);

        // --- Sealable Oxygen Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 1),
                true,
                false,
                true);

        // --- Sealable Aluminium Wire
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 14),
                true,
                false,
                true);

        // --- Sealable ME Wire
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 13),
                true,
                false,
                true);

        // --- Sealable heavy Aluminium Wire
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 15),
                true,
                false,
                true);

        // --- Aluminium Wire
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.aluminumWire", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Aluminium Wire
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.aluminumWire", 1L, 1),
                true,
                false,
                true);

        // --- Basic Solar Panel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.solar", 1L, 0),
                true,
                false,
                true);

        // --- Advanced Solar Panel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.solar", 1L, 4),
                true,
                false,
                true);

        // --- Wafer Solar
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 12),
                true,
                false,
                true);

        // --- Single Solar Modul
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 0),
                true,
                false,
                true);

        // --- Full Solar Panel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 1),
                true,
                false,
                true);

        // --- Coal Generator
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.machine", 1L, 0),
                true,
                false,
                true);

        // --- Compressor
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.machine", 1L, 12),
                true,
                false,
                true);

        // --- Electric Compressor
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.machine2", 1L, 0),
                true,
                false,
                true);

        // --- Circuit Fabricator
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.machine2", 1L, 4),
                true,
                false,
                true);

        // --- Energy Storage Module
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.machineTiered", 1L, 0),
                true,
                false,
                true);

        // --- Electric Furnace
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.machineTiered", 1L, 4),
                true,
                false,
                true);

        // --- Energy Storage Cluster
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.machineTiered", 1L, 8),
                true,
                false,
                true);

        // --- Electric Arc Furnace
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.machineTiered", 1L, 12),
                true,
                false,
                true);

        // --- Glowstone Torch
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.glowstoneTorch", 1L, 0),
                true,
                false,
                true);

        // --- Spin Truster
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.spinThruster", 1L, 0),
                true,
                false,
                true);

        // --- Display Screen
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.viewScreen", 1L, 0),
                true,
                false,
                true);

        // --- Telemetry Unit
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.telemetry", 1L, 0),
                true,
                false,
                true);

        // --- Arc Lamp
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.arclamp", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Mask
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenMask", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Gear
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenGear", 1L, 0),
                true,
                false,
                true);

        // --- Sensor Lens
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.sensorLens", 1L, 0),
                true,
                false,
                true);

        // --- Sensor Glasses
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.sensorGlasses", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Pickaxe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.steel_pickaxe", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Axe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.steel_axe", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Hoe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.steel_hoe", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Shovel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.steel_shovel", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Sword
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.steel_sword", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Helmet
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.steel_helmet", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Chest Plate
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.steel_chestplate", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Leggings
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.steel_leggings", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Boots
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.steel_boots", 1L, 0),
                true,
                false,
                true);

        // --- Tin Canister
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.canister", 1L, 0),
                true,
                false,
                true);

        // --- Copper Canister
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.canister", 1L, 1),
                true,
                false,
                true);

        // --- Oxygen Vent
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.airVent", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Fan
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.airFan", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Concentrator
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.oxygenConcentrator", 1L, 0),
                true,
                false,
                true);

        // --- Tier 1 Rocket Engine
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.engine", 1L, 0),
                true,
                false,
                true);

        // --- Tier 1 Booster
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.engine", 1L, 1),
                true,
                false,
                true);

        // --- Nose Cone
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.noseCone", 1L, 0),
                true,
                false,
                true);

        // --- Steel Pole
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.steelPole", 1L, 0),
                true,
                false,
                true);

        // --- Canister
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.oilCanisterPartial", 1L, 1001),
                true,
                false,
                true);

        // --- Oil Extractor
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.oilExtractor", 1L, 0),
                true,
                false,
                true);

        // --- Buggy Wheel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.buggymat", 1L, 0),
                true,
                false,
                true);

        // --- Buggy Seat
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.buggymat", 1L, 1),
                true,
                false,
                true);

        // --- Buggy Storage Box
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.buggymat", 1L, 2),
                true,
                false,
                true);

        // --- Standard Wrench
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.standardWrench", 1L, 0),
                true,
                false,
                true);

        // --- Can of Food
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 15),
                true,
                false,
                true);
        // -
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 16),
                true,
                false,
                true);
        // -
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 17),
                true,
                false,
                true);
        // -
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 18),
                true,
                false,
                true);

        // --- Frequency Module
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 19),
                true,
                false,
                true);

        // --- Battery
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.battery", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Pickaxe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.titanium_pickaxe", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Axe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.titanium_axe", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Hoe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.titanium_hoe", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Shovel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.titanium_shovel", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Sword
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.titanium_sword", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Helmet
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.titanium_helmet", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Chest Plate
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.titanium_chestplate", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Leggings
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.titanium_leggings", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Boots
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.titanium_boots", 1L, 0),
                true,
                false,
                true);

        // --- Desh Block
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.mars", 1L, 8),
                true,
                false,
                true);

        // --- Desh Ingot
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem("ore", "ingotDesh", 1L, 0), true, false, true);

        // --- Desh Stick
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.null", 1L, 1),
                true,
                false,
                true);

        // --- Gas Liquifier
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.marsMachineT2", 1L, 0),
                true,
                false,
                true);

        // --- Methan Synthesizer
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.marsMachineT2", 1L, 4),
                true,
                false,
                true);

        // --- Water Electrolyzer
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.marsMachineT2", 1L, 8),
                true,
                false,
                true);

        // --- Walkway
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.walkway", 1L, 0),
                true,
                false,
                true);

        // --- Walkway Aluminium
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.walkwayWire", 1L, 0),
                true,
                false,
                true);

        // --- Walkway Pipes
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.walkwayOxygenPipe", 1L, 0),
                true,
                false,
                true);

        // --- Thermal Cloth
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 7),
                true,
                false,
                true);

        // --- Atmospheric Valve
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.atmosphericValve", 1L, 0),
                true,
                false,
                true);

        // --- Rocket Fins
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.rocketFins", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Rocket Fins
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 2),
                true,
                false,
                true);

        // --- Heavy Rocket Engine
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 1),
                true,
                false,
                true);

        // --- Heavy Nose Cone
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.heavyNoseCone", 1L, 0),
                true,
                false,
                true);

        // --- Red Core
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L, 8),
                true,
                false,
                true);

        // --- Fluid Manipulator
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.null", 1L, 6),
                true,
                false,
                true);

        // --- Energy Beam Reflector
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.beamReflector", 1L, 0),
                true,
                false,
                true);

        // --- Energy Beam Receiver
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.beamReceiver", 1L, 0),
                true,
                false,
                true);

        // --- Short range Teleporter
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.telepadShort", 1L, 0),
                true,
                false,
                true);

        // --- Cryogenic Chamber
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.marsMachine", 1L, 4),
                true,
                false,
                true);

        // --- Terraformer
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.marsMachine", 1L, 0),
                true,
                false,
                true);

        // --- Launch Controller
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.marsMachine", 1L, 8),
                true,
                false,
                true);

        // --- Grappler
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.grapple", 1L, 0),
                true,
                false,
                true);

        // --- Hydrogen Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.hydrogenPipe", 1L, 0),
                true,
                false,
                true);

        // --- Carbon Fragments
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.carbonFragments", 1L, 0),
                true,
                false,
                true);

        // --- Thermal Padding Helm
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.thermalPadding", 1L, 0),
                true,
                false,
                true);

        // --- Thermal Padding Chestpiece
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.thermalPadding", 1L, 1),
                true,
                false,
                true);

        // --- Thermal Padding Leggings
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.thermalPadding", 1L, 2),
                true,
                false,
                true);

        // --- Thermal Padding Boots
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.thermalPadding", 1L, 3),
                true,
                false,
                true);

        // --- Desh Helmet
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.deshHelmet", 1L, 0),
                true,
                false,
                true);

        // --- Desh Chest Plate
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.deshChestplate", 1L, 0),
                true,
                false,
                true);

        // --- Desh Leggings
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.deshLeggings", 1L, 0),
                true,
                false,
                true);

        // --- Desh Boots
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.deshBoots", 1L, 0),
                true,
                false,
                true);

        // --- Desh Pickaxe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.deshPick", 1L, 0),
                true,
                false,
                true);

        // --- Desh Axe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.deshAxe", 1L, 0),
                true,
                false,
                true);

        // --- Desh Hoe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.deshHoe", 1L, 0),
                true,
                false,
                true);

        // --- Desh Shovel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.deshSpade", 1L, 0),
                true,
                false,
                true);

        // --- Desh Sword
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.deshSword", 1L, 0),
                true,
                false,
                true);

        // --- Sealable Cobblestone Transport Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 8),
                true,
                false,
                true);

        // --- Sealable Stone Transport Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 7),
                true,
                false,
                true);

        // --- Sealable Cobblestone Fluid Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 10),
                true,
                false,
                true);

        // --- Sealable Stone Fluid Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 9),
                true,
                false,
                true);

        // --- Sealable Stone Kinesis Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 11),
                true,
                false,
                true);

        // --- Sealable Gold Kinesis Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.enclosed", 1L, 12),
                true,
                false,
                true);

        // --- Astro Miner Base
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.minerBase", 1L, 0),
                true,
                false,
                true);

        // --- Orion Drive
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftMars", "item.orionDrive", 1L, 0),
                true,
                false,
                true);

        // --- Canvas
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.canvas", 1L, 0),
                true,
                false,
                true);

        // --- Ambient Thermal Controller
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 20),
                true,
                false,
                true);

        // --- Parachute
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem("GalacticraftCore", "item.parachute", 1L, 0),
                true,
                false,
                true);

    }
}
