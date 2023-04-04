package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AE2FluidCraft;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.ExtraCells2;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.Materials;
import gregtech.api.enums.ModIDs;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;

public class ScriptEC2 implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "EC2";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ExtraCells2.ID, AE2FluidCraft.ID, AppliedEnergistics2.ID);
    }

    @Override
    public void loadRecipes() {
        final ItemStack CERTUS_PLATE = GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L);
        final ItemStack EC2_ADVANCED_HOUSING = getModItem(ExtraCells2.ID, "storage.casing", 1, 0);
        final ItemStack EC_FLUID_STORAGE_BUS = getModItem(ExtraCells2.ID, "part.base", 1, 2);
        final ItemStack AE2FC_FLUID_STORAGE_BUS = getModItem(AE2FluidCraft.ID, "part_fluid_storage_bus", 1, 0);
        final ItemStack AE2_ADVANCED_HOUSING = getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 61);
        final ItemStack AE2FC_FLUID_TERMINAL = getModItem(AE2FluidCraft.ID, "part_fluid_terminal", 1, 0);
        final ItemStack EC_FLUID_TERMINAL = getModItem(ExtraCells2.ID, "part.base", 1, 3);
        final ItemStack AE2FC_INTERFACE = getModItem(AE2FluidCraft.ID, "fluid_interface", 1, 0);
        final ItemStack EC2_INTERFACE = getModItem(ModIDs.ExtraCells2.ID, "ecbaseblock", 1, 0);
        final ItemStack AE2FC_AUTO_FILLER = getModItem(AE2FluidCraft.ID, "fluid_auto_filler", 1, 0);
        final ItemStack EC2_AUTO_FILLER = getModItem(ModIDs.ExtraCells2.ID, "ecbaseblock", 1, 1);
        final ItemStack AE2FC_PORTABLE_CELL = getModItem(AE2FluidCraft.ID, "portable_fluid_cell", 1, 0);
        final ItemStack EC2_PORTABLE_CELL = getModItem(ModIDs.ExtraCells2.ID, "storage.fluid.portable", 1, 0);
        final ItemStack AE2FC_TANK = getModItem(AE2FluidCraft.ID, "certus_quartz_tank", 1, 0);
        final ItemStack EC2_TANK = getModItem(ModIDs.ExtraCells2.ID, "certustank", 1, 0);

        final ItemStack[] ae_components = new ItemStack[] {
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 57), // 256k
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 58), // 1024k
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 59), // 4096k
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 60), // 16384k
                getModItem(AppliedEnergistics2.ID, "tile.BlockAdvancedCraftingStorage", 1, 0), // 256k
                getModItem(AppliedEnergistics2.ID, "tile.BlockAdvancedCraftingStorage", 1, 1), // 1024k
                getModItem(AppliedEnergistics2.ID, "tile.BlockAdvancedCraftingStorage", 1, 2), // 4096k
                getModItem(AppliedEnergistics2.ID, "tile.BlockAdvancedCraftingStorage", 1, 3), // 16384k
                getModItem(AppliedEnergistics2.ID, "item.ItemVoidStorageCell", 1, 0),
                getModItem(AE2FluidCraft.ID, "walrus", 1, 0),
                getModItem(AE2FluidCraft.ID, "part_fluid_export", 1, 0),
                getModItem(AE2FluidCraft.ID, "part_fluid_import", 1, 0),
                getModItem(AE2FluidCraft.ID, "part_fluid_level_emitter", 1, 0),
                getModItem(AE2FluidCraft.ID, "part_fluid_storage_monitor", 1, 0),
                getModItem(AE2FluidCraft.ID, "part_fluid_conversion_monitor", 1, 0),
                getModItem(AE2FluidCraft.ID, "wireless_fluid_terminal", 1, 0) };
        final ItemStack[] ec_components = new ItemStack[] {
                getModItem(ModIDs.ExtraCells2.ID, "storage.component", 1, 0), // 256k
                getModItem(ModIDs.ExtraCells2.ID, "storage.component", 1, 1), // 1024k
                getModItem(ModIDs.ExtraCells2.ID, "storage.component", 1, 2), // 4096k
                getModItem(ModIDs.ExtraCells2.ID, "storage.component", 1, 3), // 16384k
                getModItem(ModIDs.ExtraCells2.ID, "craftingstorage", 1, 0), // 256k
                getModItem(ModIDs.ExtraCells2.ID, "craftingstorage", 1, 1), // 1024k
                getModItem(ModIDs.ExtraCells2.ID, "craftingstorage", 1, 2), // 4096k
                getModItem(ModIDs.ExtraCells2.ID, "craftingstorage", 1, 3), // 16384k
                getModItem(ModIDs.ExtraCells2.ID, "storage.physical.void", 1, 0),
                getModItem(ModIDs.ExtraCells2.ID, "walrus", 1, 0),
                getModItem(ModIDs.ExtraCells2.ID, "part.base", 1, 0),
                getModItem(ModIDs.ExtraCells2.ID, "part.base", 1, 1),
                getModItem(ModIDs.ExtraCells2.ID, "part.base", 1, 4),
                getModItem(ModIDs.ExtraCells2.ID, "part.base", 1, 10),
                getModItem(ModIDs.ExtraCells2.ID, "part.base", 1, 11),
                getModItem(ModIDs.ExtraCells2.ID, "terminal.fluid.wireless", 1, OreDictionary.WILDCARD_VALUE) };

        // Covert recipes
        GameRegistry.addShapelessRecipe(AE2FC_FLUID_STORAGE_BUS, EC_FLUID_STORAGE_BUS);
        GameRegistry.addShapelessRecipe(AE2_ADVANCED_HOUSING, EC2_ADVANCED_HOUSING);
        GameRegistry.addShapelessRecipe(AE2FC_FLUID_TERMINAL, EC_FLUID_TERMINAL);
        GameRegistry.addShapelessRecipe(AE2FC_INTERFACE, EC2_INTERFACE, CERTUS_PLATE);
        GameRegistry.addShapelessRecipe(AE2FC_AUTO_FILLER, EC2_AUTO_FILLER);
        GameRegistry.addShapelessRecipe(AE2FC_PORTABLE_CELL, EC2_PORTABLE_CELL);
        for (int i = 0; i < ae_components.length; i++) {
            GameRegistry.addShapelessRecipe(ae_components[i], ec_components[i]);
        }

        // Item cell covert recipe
        GameRegistry.addRecipe(
                new NBTRecipe(
                        getModItem(ExtraCells2.ID, "storage.physical", 1, 0),
                        getModItem(AppliedEnergistics2.ID, "item.ItemAdvancedStorageCell.256k", 1)));
        GameRegistry.addRecipe(
                new NBTRecipe(
                        getModItem(ExtraCells2.ID, "storage.physical", 1, 1),
                        getModItem(AppliedEnergistics2.ID, "item.ItemAdvancedStorageCell.1024k", 1)));
        GameRegistry.addRecipe(
                new NBTRecipe(
                        getModItem(ExtraCells2.ID, "storage.physical", 1, 2),
                        getModItem(AppliedEnergistics2.ID, "item.ItemAdvancedStorageCell.4096k", 1)));
        GameRegistry.addRecipe(
                new NBTRecipe(
                        getModItem(ExtraCells2.ID, "storage.physical", 1, 3),
                        getModItem(AppliedEnergistics2.ID, "item.ItemAdvancedStorageCell.16384k", 1)));
        GameRegistry.addRecipe(
                new NBTRecipe(
                        getModItem(ExtraCells2.ID, "storage.physical", 1, 4),
                        getModItem(AppliedEnergistics2.ID, "item.ItemExtremeStorageCell.Container", 1)));
        GameRegistry.addRecipe(
                new NBTRecipe(
                        getModItem(ExtraCells2.ID, "storage.physical.advanced.quantum", 1, 0),
                        getModItem(AppliedEnergistics2.ID, "item.ItemExtremeStorageCell.Quantum", 1)));
        GameRegistry.addRecipe(
                new NBTRecipe(
                        getModItem(ExtraCells2.ID, "storage.physical.advanced.singularity", 1, 0),
                        getModItem(AppliedEnergistics2.ID, "item.ItemExtremeStorageCell.Singularity", 1)));
        GameRegistry.addRecipe(new NBTRecipe(EC2_TANK, AE2FC_TANK));
    }

    public static class NBTRecipe implements IRecipe {

        private final ItemStack input;
        private final ItemStack output;
        private NBTTagCompound outputNBT;

        public NBTRecipe(@Nonnull ItemStack in, @Nonnull ItemStack out) {
            this.input = in;
            this.output = out;
        }

        @Override
        public boolean matches(InventoryCrafting inv, World p_77569_2_) {
            ItemStack stack = null;
            for (int i = 0; i < inv.getSizeInventory(); i++) {
                ItemStack in = inv.getStackInSlot(i);
                if (stack == null && in != null) {
                    stack = in;
                } else if (stack != null && in != null) {
                    return false;
                }
            }
            if (stack == null) {
                return false;
            }
            if (this.input.isItemEqual(stack)) {
                this.outputNBT = stack.getTagCompound();
                return true;
            }
            return false;
        }

        @Override
        public ItemStack getCraftingResult(InventoryCrafting p_77572_1_) {
            ItemStack copy = this.output.copy();
            copy.setTagCompound(this.outputNBT);
            return copy;
        }

        @Override
        public int getRecipeSize() {
            return 1;
        }

        @Override
        public ItemStack getRecipeOutput() {
            return this.output;
        }
    }
}
