package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import javax.annotation.Nonnull;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ScriptEC2 implements IScriptLoader {

    @Override
    public void initScriptData() {
        scriptName.setLength(0);
        scriptName.append("EC2");
        dependencies.clear();
        dependencies.addAll(java.util.Arrays.asList("extracells", "Avaritia", "eternalsingularity"));
    }

    @Override
    public void loadRecipes() {
        final ItemStack GLASS_PANE = new ItemStack(Blocks.glass_pane, 1);

        final ItemStack CERTUS_PLATE = GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L);

        final ItemStack EC2_ADVANCED_HOUSING = getModItem("extracells", "storage.casing", 1, 0);
        final ItemStack EC2_FLUID_HOUSING = getModItem("extracells", "storage.casing", 1, 1);

        // EC2 Housings
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GLASS_PANE, CERTUS_PLATE,
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2L),
                        GT_Utility.getIntegratedCircuit(3) },
                GT_Values.NF,
                EC2_ADVANCED_HOUSING,
                100,
                16);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GLASS_PANE, CERTUS_PLATE,
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 3),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2),
                        GT_Utility.getIntegratedCircuit(3) },
                GT_Values.NF,
                EC2_FLUID_HOUSING,
                100,
                16);
        // ME Digital Singularity
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("extracells", "storage.physical.advanced.singularity", 1),
                "----a----",
                "---aba---",
                "--ecdce--",
                "-acdddca-",
                "abddfddba",
                "-acdddca-",
                "--ecdce--",
                "---aba---",
                "----a----",
                'a',
                "blockCosmicNeutronium",
                'b',
                getModItem("Avaritia", "Resource", 1, 5),
                'c',
                getModItem("gregtech", "gt.blockmachines", 1, 129),
                'd',
                getModItem("extracells", "storage.component", 1, 3),
                'e',
                "blockInfinity",
                'f',
                getModItem("eternalsingularity", "eternal_singularity", 1));

        // ME Quantum Storage
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("extracells", "storage.physical.advanced.quantum", 1),
                "---------",
                "----a----",
                "---bdb---",
                "--bcdcb--",
                "-addedda-",
                "--bcdcb--",
                "---bdb---",
                "----a----",
                "---------",
                'a',
                "blockCosmicNeutronium",
                'b',
                "plateDenseNeutronium",
                'c',
                "circuitInfinite",
                'd',
                getModItem("extracells", "storage.component", 1, 3),
                'e',
                getModItem("extracells", "storage.casing", 1));

        // ME Void Storage
        addShapedRecipe(
                getModItem("extracells", "storage.physical.void", 1),
                new Object[] { "craftingToolHardHammer", "plateCertusQuartz", "screwCertusQuartz", "plateTungsten",
                        "gemEnderEye", "plateTungsten", "screwCertusQuartz", "plateTungsten",
                        "craftingToolScrewdriver" });

        // Item cell covert recipe
        GameRegistry.addRecipe(
                new NBTRecipe(
                        getModItem("extracells", "storage.physical", 1, 0),
                        getModItem("appliedenergistics2", "item.ItemAdvancedStorageCell.256k", 1)));
        GameRegistry.addRecipe(
                new NBTRecipe(
                        getModItem("extracells", "storage.physical", 1, 1),
                        getModItem("appliedenergistics2", "item.ItemAdvancedStorageCell.1024k", 1)));
        GameRegistry.addRecipe(
                new NBTRecipe(
                        getModItem("extracells", "storage.physical", 1, 2),
                        getModItem("appliedenergistics2", "item.ItemAdvancedStorageCell.4096k", 1)));
        GameRegistry.addRecipe(
                new NBTRecipe(
                        getModItem("extracells", "storage.physical", 1, 3),
                        getModItem("appliedenergistics2", "item.ItemAdvancedStorageCell.16384k", 1)));
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
