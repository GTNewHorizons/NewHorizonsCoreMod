package com.dreammaster.gthandler;

import static gregtech.api.enums.GT_Values.DW;
import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.MineAndBladeBattleGear2;
import static gregtech.api.enums.Mods.NaturesCompass;
import static gregtech.api.enums.Mods.OpenPrinters;
import static gregtech.api.enums.Mods.OpenSecurity;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.Translocator;
import static gregtech.api.enums.Mods.ZTones;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_Utility;

public class GT_Recipe_Remover implements Runnable {

    private static final String aTextMachineBeta = "machine.beta";
    private static final String aTextMachineAlpha = "machine.alpha";

    public static boolean removeRecipeShapeless(ItemStack aOutput, ItemStack... aRecipe) {
        @SuppressWarnings("unchecked")
        ArrayList<IRecipe> tList = (ArrayList<IRecipe>) CraftingManager.getInstance().getRecipeList();
        InventoryCrafting aCrafting = new InventoryCrafting(new Container() {

            @Override
            public boolean canInteractWith(EntityPlayer player) {
                return false;
            }
        }, 3, 3);
        for (int i = 0; i < aRecipe.length && i < 9; i++) aCrafting.setInventorySlotContents(i, aRecipe[i]);
        return tList.removeIf(
                recipe -> (recipe instanceof ShapelessRecipes || recipe instanceof ShapelessOreRecipe)
                        && GT_Utility.areStacksEqual(recipe.getRecipeOutput(), aOutput, true)
                        && (aRecipe.length == 0 || recipe.matches(aCrafting, DW)));
    }

    public static boolean removeRecipeShaped(ItemStack aOutput, ItemStack... aRecipe) {
        @SuppressWarnings("unchecked")
        ArrayList<IRecipe> tList = (ArrayList<IRecipe>) CraftingManager.getInstance().getRecipeList();
        InventoryCrafting aCrafting = new InventoryCrafting(new Container() {

            @Override
            public boolean canInteractWith(EntityPlayer player) {
                return false;
            }
        }, 3, 3);
        for (int i = 0; i < aRecipe.length && i < 9; i++) aCrafting.setInventorySlotContents(i, aRecipe[i]);
        return tList.removeIf(
                recipe -> (recipe instanceof ShapedRecipes || recipe instanceof ShapedOreRecipe)
                        && GT_Utility.areStacksEqual(recipe.getRecipeOutput(), aOutput, true)
                        && (aRecipe.length == 0 || recipe.matches(aCrafting, DW)));
    }

    public void run() {
        // Vanilla
        GT_ModHandler.removeRecipeByOutputDelayed(new ItemStack(Blocks.iron_bars, 1, 32767), true, false, true);
        // AE
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 2),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, 3),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 36),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 536),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 556),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 56),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 76),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 576),
                true,
                false,
                true);
        // ASP
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1L, 2),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "BlockAdvSolarPanel", 1L, 3),
                true,
                false,
                true);
        // BG2
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "quiver", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "shield.wood", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "shield.hide", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "shield.iron", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "shield.gold", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "shield.diamond", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "dagger.wood", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "dagger.stone", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "dagger.iron", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "dagger.gold", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "dagger.diamond", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "spear.wood", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "spear.stone", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "spear.iron", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "spear.gold", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "spear.diamond", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "waraxe.wood", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "waraxe.stone", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "waraxe.iron", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "waraxe.gold", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "waraxe.diamond", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "mace.wood", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "mace.stone", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "mace.iron", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "mace.gold", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "mace.diamond", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(MineAndBladeBattleGear2.ID, "chain", 1L, 0),
                true,
                false,
                true);
        // Draconic Evolution
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(DraconicEvolution.ID, "chaosShard", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(DraconicEvolution.ID, "chaosFragment", 1L, 2),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(DraconicEvolution.ID, "chaosFragment", 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(DraconicEvolution.ID, "chaosFragment", 1L, 0),
                true,
                false,
                true);
        // Ender IO
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 2),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 3),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 4),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 5),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 7),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 8),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 9),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.ID, "itemMEConduit", 1L),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.ID, "itemMEConduit", 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(EnderIO.ID, "itemMEConduit", 1L, 2),
                true,
                false,
                true);
        // Forestry
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.ID, "stamps", 1L, 0), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.ID, "stamps", 1L, 1), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.ID, "stamps", 1L, 2), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.ID, "stamps", 1L, 3), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.ID, "stamps", 1L, 4), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.ID, "stamps", 1L, 5), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.ID, "stamps", 1L, 6), true, false, true);

        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.ID, "engine", 1L, 0), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.ID, "engine", 1L, 1), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.ID, "engine", 1L, 2), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(Forestry.ID, "engine", 1L, 4), true, false, true);
        // IC2
        GT_ModHandler.removeRecipeByOutputDelayed(ItemList.IC2_Energium_Dust.get(1L));
        GT_ModHandler.removeRecipeByOutputDelayed(ItemList.IC2_LapotronCrystal.get(1L));
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorNanoBoots", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorNanoChestplate", 1L));
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorNanoHelmet", 1L));
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorNanoLegs", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorQuantumBoots", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorQuantumChestplate", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorQuantumHelmet", 1L));
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorQuantumLegs", 1L));
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorBatpack", 1L));
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorAdvBatpack", 1L));
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorEnergypack", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemAdvBat", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemNightvisionGoggles", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorJetpackElectric", 1L));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemArmorJetpack", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatChargeRE", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatChargeAdv", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatChargeCrystal", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatChargeLamaCrystal", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemTreetapElectric", 1, GT_Values.W));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemToolHoe", 1, GT_Values.W));
        // Natural Compass
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(NaturesCompass.ID, "NaturesCompass", 1L, 0),
                true,
                false,
                true);
        // Open Printers
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenPrinters.ID, "openprinter.printer", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenPrinters.ID, "openprinter.shredder", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenPrinters.ID, "openprinter.printerInkBlack", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenPrinters.ID, "openprinter.printerInkColor", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenPrinters.ID, "openprinter.folder", 1L, 0),
                true,
                false,
                true);
        // Open Security
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "magreader", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "rfidreader", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "rfidwriter", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "alarm", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "entitydetector", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "doorcontroller", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.DataBlock", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.SwitchableHub", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.BlockKVM", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "energyTurretBlock", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "keypadLock", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "biometricScanner", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.magCard", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.rfidCard", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.rfidReaderCard", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.secureNetworkCard", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.securityDoor", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.securityDoorPrivate", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.damageUpgrade", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.cooldownUpgrade", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.energyUpgrade", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(OpenSecurity.ID, "opensecurity.movementUpgrade", 1L, 0),
                true,
                false,
                true);
        // Railcraft
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineBeta, 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineBeta, 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineBeta, 1L, 2),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineBeta, 1L, 3),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineBeta, 1L, 4),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineBeta, 1L, 5),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineBeta, 1L, 6),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineBeta, 1L, 7),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineBeta, 1L, 8),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineBeta, 1L, 9),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineBeta, 1L, 10),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineBeta, 1L, 11),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineBeta, 1L, 12),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineBeta, 1L, 13),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineBeta, 1L, 14),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineBeta, 1L, 15),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 2),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 3),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 5),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 6),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 8),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 9),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 10),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 11),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 12),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 13),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 14),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, aTextMachineAlpha, 1L, 15),
                true,
                false,
                true);

        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, "tool.crowbar", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, "tool.crowbar.reinforced", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, "tool.whistle.tuner", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, "part.turbine.blade", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, "part.turbine.disk", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, "part.turbine.rotor", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, "borehead.iron", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, "borehead.steel", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, "borehead.diamond", 1L, 0),
                true,
                false,
                true);

        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, "cart.loco.steam.solid", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, "cart.loco.electric", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, "cart.bore", 1L, 0),
                true,
                false,
                true);

        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, "part.circuit", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, "part.circuit", 1L, 1),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Railcraft.ID, "part.circuit", 1L, 2),
                true,
                false,
                true);
        // Steve Carts
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(StevesCarts2.ID, "ModuleComponents", 1L, 9),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(StevesCarts2.ID, "ModuleComponents", 1L, 16),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(StevesCarts2.ID, "ModuleComponents", 1L, 18),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(StevesCarts2.ID, "ModuleComponents", 1L, 19),
                true,
                false,
                true);
        // Translocator
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(Translocator.ID, "diamondNugget", 2L, 0),
                true,
                false,
                true);
        // Ztones
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(ZTones.ID, "ofanix", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeDelayed(GT_ModHandler.getModItem(ZTones.ID, "ofanix", 1L, 0));
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(ZTones.ID, "stoneTile", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(ZTones.ID, "auroraBlock", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(ZTones.ID, "minicharcoal", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(ZTones.ID, "minicoal", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(ZTones.ID, "cleanDirt", 1L, 0),
                true,
                false,
                true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(ZTones.ID, "booster", 1L, 0), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(ZTones.ID, "lampf", 1L, 0), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(ZTones.ID, "lampt", 1L, 0), true, false, true);
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem(ZTones.ID, "lampb", 1L, 0), true, false, true);

        // Galacticraft

        // --- Rocket Launch Pad
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.landingPad", 1L, 0),
                true,
                false,
                true);

        // --- Buggy Fueling Pad
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.landingPad", 1L, 1),
                true,
                false,
                true);

        // --- Oxygen Collector
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.oxygenCollector", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Compressor
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.oxygenCompressor", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Decompressor
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.oxygenCompressor", 1L, 4),
                true,
                false,
                true);

        // --- Oxygen Storage Module
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.machine2", 1L, 8),
                true,
                false,
                true);

        // --- Oxygen Bubble Distributor
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.distributor", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Sealer
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.sealer", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Detector
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.oxygenDetector", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.oxygenPipe", 1L, 0),
                true,
                false,
                true);

        // --- Refinery
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.refinery", 1L, 0),
                true,
                false,
                true);

        // --- Fuel Loader
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.fuelLoader", 1L, 0),
                true,
                false,
                true);

        // --- Sealeable Oxygen Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.enclosed", 1L, 1),
                true,
                false,
                true);

        // --- Sealeable Copper Cable
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.enclosed", 1L, 2),
                true,
                false,
                true);

        // --- Sealeable Gold Cable
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.enclosed", 1L, 3),
                true,
                false,
                true);

        // --- Sealeable HV Cable
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.enclosed", 1L, 4),
                true,
                false,
                true);

        // --- Sealeable Glass Fibre Cable
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.enclosed", 1L, 5),
                true,
                false,
                true);

        // --- Sealeable Tin Cable
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.enclosed", 1L, 6),
                true,
                false,
                true);

        // --- Fuel Loader
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.fuelLoader", 1L, 0),
                true,
                false,
                true);

        // --- Cargo Loader
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.cargo", 1L, 0),
                true,
                false,
                true);

        // --- Cargo Unloader
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.cargo", 1L, 4),
                true,
                false,
                true);

        // --- Tin Decoration Block
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1L, 3),
                true,
                false,
                true);
        // -
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1L, 4),
                true,
                false,
                true);

        // --- Copper Block
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1L, 9),
                true,
                false,
                true);

        // --- Tin Block
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1L, 10),
                true,
                false,
                true);

        // --- Aluminum Block
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1L, 11),
                true,
                false,
                true);

        // --- Meteoric Iron Ingot
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GregTech.ID, "gt.metaitem.01", 1L, 11340),
                true,
                false,
                true);

        // --- Solid Meteoric Iron
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.gcBlockCore", 1L, 12),
                true,
                false,
                true);

        // --- Air Lock Frame
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.airLockFrame", 1L, 0),
                true,
                false,
                true);

        // --- Air Lock Controller
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.airLockFrame", 1L, 1),
                true,
                false,
                true);

        // --- Sealable Oxygen Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.enclosed", 1L, 1),
                true,
                false,
                true);

        // --- Sealable Aluminium Wire
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.enclosed", 1L, 14),
                true,
                false,
                true);

        // --- Sealable ME Wire
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.enclosed", 1L, 13),
                true,
                false,
                true);

        // --- Sealable heavy Aluminium Wire
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.enclosed", 1L, 15),
                true,
                false,
                true);

        // --- Aluminium Wire
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Aluminium Wire
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.aluminumWire", 1L, 1),
                true,
                false,
                true);

        // --- Basic Solar Panel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.solar", 1L, 0),
                true,
                false,
                true);

        // --- Advanced Solar Panel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.solar", 1L, 4),
                true,
                false,
                true);

        // --- Wafer Solar
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 1L, 12),
                true,
                false,
                true);

        // --- Single Solar Modul
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 1L, 0),
                true,
                false,
                true);

        // --- Full Solar Panel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 1L, 1),
                true,
                false,
                true);

        // --- Coal Generator
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.machine", 1L, 0),
                true,
                false,
                true);

        // --- Compressor
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.machine", 1L, 12),
                true,
                false,
                true);

        // --- Electric Compressor
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.machine2", 1L, 0),
                true,
                false,
                true);

        // --- Circuit Fabricator
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.machine2", 1L, 4),
                true,
                false,
                true);

        // --- Energy Storage Module
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.machineTiered", 1L, 0),
                true,
                false,
                true);

        // --- Electric Furnace
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.machineTiered", 1L, 4),
                true,
                false,
                true);

        // --- Energy Storage Cluster
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.machineTiered", 1L, 8),
                true,
                false,
                true);

        // --- Electric Arc Furnace
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.machineTiered", 1L, 12),
                true,
                false,
                true);

        // --- Glowstone Torch
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.glowstoneTorch", 1L, 0),
                true,
                false,
                true);

        // --- Spin Truster
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.spinThruster", 1L, 0),
                true,
                false,
                true);

        // --- Display Screen
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.viewScreen", 1L, 0),
                true,
                false,
                true);

        // --- Telemetry Unit
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.telemetry", 1L, 0),
                true,
                false,
                true);

        // --- Arc Lamp
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.arclamp", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Mask
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.oxygenMask", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Gear
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.oxygenGear", 1L, 0),
                true,
                false,
                true);

        // --- Sensor Lens
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.sensorLens", 1L, 0),
                true,
                false,
                true);

        // --- Sensor Glasses
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.sensorGlasses", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Pickaxe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.steel_pickaxe", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Axe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.steel_axe", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Hoe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.steel_hoe", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Shovel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.steel_shovel", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Sword
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.steel_sword", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Helmet
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.steel_helmet", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Chest Plate
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.steel_chestplate", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Leggings
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.steel_leggings", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Duty Boots
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.steel_boots", 1L, 0),
                true,
                false,
                true);

        // --- Tin Canister
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.canister", 1L, 0),
                true,
                false,
                true);

        // --- Copper Canister
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.canister", 1L, 1),
                true,
                false,
                true);

        // --- Oxygen Vent
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.airVent", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Fan
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.airFan", 1L, 0),
                true,
                false,
                true);

        // --- Oxygen Concentrator
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.oxygenConcentrator", 1L, 0),
                true,
                false,
                true);

        // --- Tier 1 Rocket Engine
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.engine", 1L, 0),
                true,
                false,
                true);

        // --- Tier 1 Booster
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.engine", 1L, 1),
                true,
                false,
                true);

        // --- Nose Cone
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.noseCone", 1L, 0),
                true,
                false,
                true);

        // --- Steel Pole
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.steelPole", 1L, 0),
                true,
                false,
                true);

        // --- Canister
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.oilCanisterPartial", 1L, 1001),
                true,
                false,
                true);

        // --- Oil Extractor
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.oilExtractor", 1L, 0),
                true,
                false,
                true);

        // --- Buggy Wheel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.buggymat", 1L, 0),
                true,
                false,
                true);

        // --- Buggy Seat
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.buggymat", 1L, 1),
                true,
                false,
                true);

        // --- Buggy Storage Box
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.buggymat", 1L, 2),
                true,
                false,
                true);

        // --- Standard Wrench
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.standardWrench", 1L, 0),
                true,
                false,
                true);

        // --- Can of Food
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 1L, 15),
                true,
                false,
                true);
        // -
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 1L, 16),
                true,
                false,
                true);
        // -
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 1L, 17),
                true,
                false,
                true);
        // -
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 1L, 18),
                true,
                false,
                true);

        // --- Frequency Module
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 1L, 19),
                true,
                false,
                true);

        // --- Battery
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.battery", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Pickaxe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.titanium_pickaxe", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Axe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.titanium_axe", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Hoe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.titanium_hoe", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Shovel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.titanium_shovel", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Sword
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.titanium_sword", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Helmet
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.titanium_helmet", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Chest Plate
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.titanium_chestplate", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Leggings
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.titanium_leggings", 1L, 0),
                true,
                false,
                true);

        // --- Titanium Boots
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.titanium_boots", 1L, 0),
                true,
                false,
                true);

        // --- Desh Block
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.mars", 1L, 8),
                true,
                false,
                true);

        // --- Desh Ingot
        GT_ModHandler
                .removeRecipeByOutputDelayed(GT_ModHandler.getModItem("ore", "ingotDesh", 1L, 0), true, false, true);

        // --- Desh Stick
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.null", 1L, 1),
                true,
                false,
                true);

        // --- Gas Liquifier
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.marsMachineT2", 1L, 0),
                true,
                false,
                true);

        // --- Methan Synthesizer
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.marsMachineT2", 1L, 4),
                true,
                false,
                true);

        // --- Water Electrolyzer
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.marsMachineT2", 1L, 8),
                true,
                false,
                true);

        // --- Walkway
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.walkway", 1L, 0),
                true,
                false,
                true);

        // --- Walkway Aluminium
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.walkwayWire", 1L, 0),
                true,
                false,
                true);

        // --- Walkway Pipes
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.walkwayOxygenPipe", 1L, 0),
                true,
                false,
                true);

        // --- Thermal Cloth
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1L, 7),
                true,
                false,
                true);

        // --- Atmospheric Valve
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.atmosphericValve", 1L, 0),
                true,
                false,
                true);

        // --- Rocket Fins
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.rocketFins", 1L, 0),
                true,
                false,
                true);

        // --- Heavy Rocket Fins
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1L, 2),
                true,
                false,
                true);

        // --- Heavy Rocket Engine
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1L, 1),
                true,
                false,
                true);

        // --- Heavy Nose Cone
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.heavyNoseCone", 1L, 0),
                true,
                false,
                true);

        // --- Red Core
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1L, 8),
                true,
                false,
                true);

        // --- Fluid Manipulator
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.null", 1L, 6),
                true,
                false,
                true);

        // --- Energy Beam Reflector
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.beamReflector", 1L, 0),
                true,
                false,
                true);

        // --- Energy Beam Receiver
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.beamReceiver", 1L, 0),
                true,
                false,
                true);

        // --- Short range Teleporter
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.telepadShort", 1L, 0),
                true,
                false,
                true);

        // --- Cryogenic Chamber
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.marsMachine", 1L, 4),
                true,
                false,
                true);

        // --- Terraformer
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.marsMachine", 1L, 0),
                true,
                false,
                true);

        // --- Launch Controller
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.marsMachine", 1L, 8),
                true,
                false,
                true);

        // --- Grappler
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.grapple", 1L, 0),
                true,
                false,
                true);

        // --- Hydrogen Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.hydrogenPipe", 1L, 0),
                true,
                false,
                true);

        // --- Carbon Fragments
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.carbonFragments", 1L, 0),
                true,
                false,
                true);

        // --- Thermal Padding Helm
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.thermalPadding", 1L, 0),
                true,
                false,
                true);

        // --- Thermal Padding Chestpiece
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.thermalPadding", 1L, 1),
                true,
                false,
                true);

        // --- Thermal Padding Leggings
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.thermalPadding", 1L, 2),
                true,
                false,
                true);

        // --- Thermal Padding Boots
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.thermalPadding", 1L, 3),
                true,
                false,
                true);

        // --- Desh Helmet
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.deshHelmet", 1L, 0),
                true,
                false,
                true);

        // --- Desh Chest Plate
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.deshChestplate", 1L, 0),
                true,
                false,
                true);

        // --- Desh Leggings
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.deshLeggings", 1L, 0),
                true,
                false,
                true);

        // --- Desh Boots
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.deshBoots", 1L, 0),
                true,
                false,
                true);

        // --- Desh Pickaxe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.deshPick", 1L, 0),
                true,
                false,
                true);

        // --- Desh Axe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.deshAxe", 1L, 0),
                true,
                false,
                true);

        // --- Desh Hoe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.deshHoe", 1L, 0),
                true,
                false,
                true);

        // --- Desh Shovel
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.deshSpade", 1L, 0),
                true,
                false,
                true);

        // --- Desh Sword
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.deshSword", 1L, 0),
                true,
                false,
                true);

        // --- Sealable Cobblestone Transport Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.enclosed", 1L, 8),
                true,
                false,
                true);

        // --- Sealable Stone Transport Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.enclosed", 1L, 7),
                true,
                false,
                true);

        // --- Sealable Cobblestone Fluid Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.enclosed", 1L, 10),
                true,
                false,
                true);

        // --- Sealable Stone Fluid Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.enclosed", 1L, 9),
                true,
                false,
                true);

        // --- Sealable Stone Kinesis Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.enclosed", 1L, 11),
                true,
                false,
                true);

        // --- Sealable Gold Kinesis Pipe
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.enclosed", 1L, 12),
                true,
                false,
                true);

        // --- Astro Miner Base
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.minerBase", 1L, 0),
                true,
                false,
                true);

        // --- Orion Drive
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftMars.ID, "item.orionDrive", 1L, 0),
                true,
                false,
                true);

        // --- Canvas
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.canvas", 1L, 0),
                true,
                false,
                true);

        // --- Ambient Thermal Controller
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.basicItem", 1L, 20),
                true,
                false,
                true);

        // --- Parachute
        GT_ModHandler.removeRecipeByOutputDelayed(
                GT_ModHandler.getModItem(GalacticraftCore.ID, "item.parachute", 1L, 0),
                true,
                false,
                true);

    }
}
