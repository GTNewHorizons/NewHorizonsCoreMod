package com.dreammaster.gthandler;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.util.GT_ModHandler;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class GT_Recipe_Remover implements Runnable {
	private static final String aTextRailcraft = "Railcraft";
    private static final String aTextMachineBeta = "machine.beta";
    private static final String aTextMachineAlpha = "machine.alpha";
    private static final String aTextIron1 = "X X";
    private static final String aTextIron2 = "XXX";
    private static final String aTextForestry = "Forestry";
	
	public void run() {

        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 1), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 2), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1L, 3), true, false, true);

        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "quiver", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "shield.wood", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "shield.hide", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "shield.iron", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "shield.gold", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "shield.diamond", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "dagger.wood", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "dagger.stone", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "dagger.iron", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "dagger.gold", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "dagger.diamond", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "spear.wood", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "spear.stone", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "spear.iron", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "spear.gold", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "spear.diamond", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "waraxe.wood", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "waraxe.stone", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "waraxe.iron", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "waraxe.gold", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "waraxe.diamond", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "mace.wood", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "mace.stone", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "mace.iron", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "mace.gold", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "mace.diamond", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("battlegear2", "chain", 1L, 0), true, false, true);
        //railcraft
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 1), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 2), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 3), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 4), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 5), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 6), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 7), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 8), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 9), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 10), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 11), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 12), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 13), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 14), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineBeta, 1L, 15), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 1), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 2), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 3), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 5), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 6), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 8), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 9), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 10), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 11), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 12), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 13), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 14), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, aTextMachineAlpha, 1L, 15), true, false, true);

        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, "tool.crowbar", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, "tool.crowbar.reinforced", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, "tool.whistle.tuner", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, "part.turbine.blade", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, "part.turbine.disk", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, "part.turbine.rotor", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, "borehead.iron", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, "borehead.steel", 1L, 0),true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, "borehead.diamond", 1L, 0),true, false, true);

        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, "cart.loco.steam.solid", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, "cart.loco.electric", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, "cart.bore", 1L, 0), true, false, true);

        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, "part.circuit", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, "part.circuit", 1L, 1), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextRailcraft, "part.circuit", 1L, 2), true, false, true);
        //forestry
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "stamps", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "stamps", 1L, 1), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "stamps", 1L, 2), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "stamps", 1L, 3), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "stamps", 1L, 4), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "stamps", 1L, 5), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "stamps", 1L, 6), true, false, true);

        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "engine", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "engine", 1L, 1), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "engine", 1L, 2), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "engine", 1L, 4), true, false, true);
        //Steve Carts
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 9), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("StevesCarts", "ModuleComponents", 1L, 16), true, false, true);
        //Vanilla
        GT_ModHandler.removeRecipeByOutput(new ItemStack(Blocks.iron_bars, 1, 32767), true, false, true);
        //Natural Compass
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("naturescompass", "NaturesCompass", 1L, 0), true, false, true);
        //IC2
        GT_ModHandler.removeRecipeByOutput(ItemList.IC2_Energium_Dust.get(1L));
        GT_ModHandler.removeRecipeByOutput(ItemList.IC2_LapotronCrystal.get(1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","itemArmorNanoBoots", 1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","itemArmorNanoChestplate", 1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","itemArmorNanoHelmet", 1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","itemArmorNanoLegs", 1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","itemArmorQuantumBoots", 1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","itemArmorQuantumChestplate", 1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","itemArmorQuantumHelmet", 1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","itemArmorQuantumLegs", 1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","itemArmorBatpack", 1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","itemArmorAdvBatpack", 1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","itemArmorEnergypack", 1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","itemAdvBat", 1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","itemNightvisionGoggles", 1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","itemArmorJetpackElectric", 1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","itemArmorJetpack", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","itemBatChargeRE", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","itemBatChargeAdv", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","itemBatChargeCrystal", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2","itemBatChargeLamaCrystal", 1L, GT_Values.W));
        //Open Printers
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("openprinter", "openprinter.printer", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("openprinter", "openprinter.shredder", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("openprinter", "openprinter.printerInkBlack", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("openprinter", "openprinter.printerInkColor", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("openprinter", "openprinter.folder", 1L, 0), true, false, true);
        //Open Security
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "magreader", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "rfidreader", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "rfidwriter", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "alarm", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "entitydetector", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "doorcontroller", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "opensecurity.DataBlock", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "opensecurity.SwitchableHub", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "opensecurity.BlockKVM", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "energyTurretBlock", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "keypadLock", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "biometricScanner", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "opensecurity.magCard", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "opensecurity.rfidCard", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "opensecurity.rfidReaderCard", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "opensecurity.secureNetworkCard", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "opensecurity.securityDoor", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "opensecurity.securityDoorPrivate", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "opensecurity.damageUpgrade", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "opensecurity.cooldownUpgrade", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "opensecurity.energyUpgrade", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("opensecurity", "opensecurity.movementUpgrade", 1L, 0), true, false, true);
        //Open Glasses
        //GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("openglasses", "openglassesterminal", 1L, 0), true, false, true);
        //GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("openglasses", "openglasses", 1L, 0), true, false, true);
        //Computronics
        //GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.ironNoteBlock", 1L, 0), true, false, true);
        //GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.speaker", 1L, 0), true, false, true);
        //GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.tapeReader", 1L, 0), true, false, true);
        //GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.camera", 1L, 0), true, false, true);
        //GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.chatBox", 1L, 0), true, false, true);
        //GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.cipher", 1L, 0), true, false, true);
        //GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.cipher_advanced", 1L, 0), true, false, true);
        //GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.radar", 1L, 0), true, false, true);
        //GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.colorfulLamp", 1L, 0), true, false, true);
        //GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.locomotiveRelay", 1L, 0), true, false, true);
        //GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.digitalReceiverBox", 1L, 0), true, false, true);
        //GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.digitalControllerBox", 1L, 0), true, false, true);
        //GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.detector", 1L, 0), true, false, true);
        //GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.ticketMachine", 1L, 0), true, false, true);
        //GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("computronics", "computronics.speechBox", 1L, 0), true, false, true);
	}

}
