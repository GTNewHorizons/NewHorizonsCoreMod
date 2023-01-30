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
    }
}
