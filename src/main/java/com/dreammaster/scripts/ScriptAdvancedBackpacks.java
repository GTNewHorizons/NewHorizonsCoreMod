package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AdventureBackpack;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.SleepingBags;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sBrewingRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.GT_Values;

public class ScriptAdvancedBackpacks implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Advanced Backpacks";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                AdventureBackpack.ID,
                BuildCraftFactory.ID,
                IndustrialCraft2.ID,
                GalacticraftCore.ID,
                SleepingBags.ID,
                Backpack.ID,
                PamsHarvestCraft.ID,
                Railcraft.ID);
    }

    @Override
    public void loadRecipes() {

        GameRegistry.addRecipe(
                new AdvancedBackpackConversionRecipe(
                        getModItem(AdventureBackpack.ID, "adventureBackpack", 1, 0, missing),
                        (byte) 0,
                        (byte) 0,
                        "aaa",
                        "aba",
                        "aaa",
                        'a',
                        getModItem(Minecraft.ID, "dye", 1, 15, missing),
                        'b',
                        getModItem(AdventureBackpack.ID, "adventureBackpack", 1, 0, missing)));
        addShapedRecipe(
                createItemStack(AdventureBackpack.ID, "adventureBackpack", 1, 0, "{wearableData:{type:0b}}", missing),
                new Object[] { "materialHardenedleather", "plateAluminium", "materialHardenedleather",
                        getModItem(AdventureBackpack.ID, "backpackComponent", 1, 2, missing), "chestIron",
                        getModItem(AdventureBackpack.ID, "backpackComponent", 1, 2, missing), "materialHardenedleather",
                        getModItem(AdventureBackpack.ID, "backpackComponent", 1, 1, missing),
                        "materialHardenedleather" });
        addShapedRecipe(
                createItemStack(AdventureBackpack.ID, "adventureBackpack", 1, 0, "{wearableData:{type:0b}}", missing),
                new Object[] { "materialHardenedleather", "plateAluminium", "materialHardenedleather",
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing), "chestIron",
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing), "materialHardenedleather",
                        getModItem(SleepingBags.ID, "sleepingBag", 1, 0, missing), "materialHardenedleather" });
        GameRegistry.addRecipe(
                new AdvancedBackpackConversionRecipe(
                        getModItem(AdventureBackpack.ID, "adventureBackpack", 1, 2, missing),
                        (byte) 0,
                        (byte) 2,
                        "aba",
                        "cdc",
                        "eee",
                        'a',
                        "itemLeather",
                        'b',
                        getModItem(IndustrialCraft2.ID, "itemNightvisionGoggles", 1, 1, missing),
                        'c',
                        getModItem(Minecraft.ID, "potion", 1, 8262, missing),
                        'd',
                        getModItem(AdventureBackpack.ID, "adventureBackpack", 1, 0, missing),
                        'e',
                        "blockWoolBlack"));
        GameRegistry.addRecipe(
                new AdvancedBackpackConversionRecipe(
                        getModItem(AdventureBackpack.ID, "adventureBackpack", 1, 11, missing),
                        (byte) 0,
                        (byte) 11,
                        "aba",
                        "cdc",
                        "efe",
                        'a',
                        "itemLeather",
                        'b',
                        getModItem(Minecraft.ID, "red_flower", 1, 0, missing),
                        'c',
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        'd',
                        getModItem(AdventureBackpack.ID, "adventureBackpack", 1, 0, missing),
                        'e',
                        "plateIron",
                        'f',
                        getModItem(IndustrialCraft2.ID, "itemArmorRubBoots", 1, 0, missing)));
        GameRegistry.addRecipe(
                new AdvancedBackpackConversionRecipe(
                        getModItem(AdventureBackpack.ID, "adventureBackpack", 1, 62, missing),
                        (byte) 0,
                        (byte) 62,
                        "aba",
                        "cdc",
                        "efe",
                        'a',
                        "itemLeather",
                        'b',
                        getModItem(GalacticraftCore.ID, "item.oxygenMask", 1, 0, missing),
                        'c',
                        getModItem(Minecraft.ID, "potion", 1, 8269, missing),
                        'd',
                        getModItem(AdventureBackpack.ID, "adventureBackpack", 1, 0, missing),
                        'e',
                        "blockWoolBlue",
                        'f',
                        getModItem(Minecraft.ID, "dye", 1, 0, missing)));
        addShapelessCraftingRecipe(
                getModItem(AdventureBackpack.ID, "backpackComponent", 1, 2, missing),
                new Object[] { getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                new Object[] { getModItem(AdventureBackpack.ID, "backpackComponent", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem(AdventureBackpack.ID, "backpackComponent", 1, 1, missing),
                new Object[] { getModItem(SleepingBags.ID, "sleepingBag", 1, 0, missing) });
        addShapedRecipe(
                getModItem(AdventureBackpack.ID, "machete", 1, 0, missing),
                new Object[] { "screwAnyIron", "craftingToolFile", "plateAnyIron", "craftingToolScrewdriver",
                        "plateAnyIron", "plateAnyIron",
                        getModItem(AdventureBackpack.ID, "backpackComponent", 1, 4, missing), "screwAnyIron",
                        "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(AdventureBackpack.ID, "backpackComponent", 1, 4, missing),
                new Object[] { "dyeYellow", "screwAnyIron", "dyeYellow", "dyeBlue", "stickAnyIron", "dyeBlue", "dyeRed",
                        "dyeBlack", "dyeRed" });
        addShapedRecipe(
                getModItem(AdventureBackpack.ID, "adventureHat", 1, 0, missing),
                new Object[] { null, "craftingToolScrewdriver", null,
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Minecraft.ID, "leather_helmet", 1, 0, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), null, "screwGold", null });
        addShapedRecipe(
                getModItem(AdventureBackpack.ID, "backpackComponent", 1, 3, missing),
                new Object[] { "screwAnyIron", "pipeTinyBronze", "screwAnyIron", "springSmallAnyIron",
                        getModItem(Minecraft.ID, "stone_button", 1, 0, missing), "springSmallAnyIron", null,
                        "craftingToolScrewdriver", null });
        addShapedRecipe(
                createItemStack(
                        AdventureBackpack.ID,
                        "backpackHose",
                        1,
                        0,
                        "{mode:-1L,amount:0,fluid:\"None\",tank:-1L}",
                        missing),
                new Object[] { "plateAnyRubber", getModItem(AdventureBackpack.ID, "backpackComponent", 1, 3, missing),
                        "plateAnyRubber", "plateAnyRubber", "dyeGreen", "plateAnyRubber", "plateAnyRubber", "dyeGreen",
                        "plateAnyRubber" });
        addShapedRecipe(
                getModItem(AdventureBackpack.ID, "backpackComponent", 1, 5, missing),
                new Object[] { "plateSteel", "plateSteel", "plateSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32641, missing), "pipeLargeSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32641, missing), "plateSteel",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 1111, missing), "plateSteel" });
        addShapedRecipe(
                getModItem(AdventureBackpack.ID, "backpackComponent", 1, 6, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12, missing), "screwSteel",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12, missing), "screwSteel", "gearSteel",
                        "screwSteel", getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12, missing),
                        "craftingToolScrewdriver", getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 12, missing) });
        addShapedRecipe(
                createItemStack(
                        AdventureBackpack.ID,
                        "copterPack",
                        1,
                        0,
                        "{wearableData:{fuelTank:{Empty:\"\"}}}",
                        missing),
                new Object[] { "screwDiamond", getModItem(AdventureBackpack.ID, "backpackComponent", 1, 6, missing),
                        "screwDiamond", getModItem(AdventureBackpack.ID, "backpackComponent", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing), "pipeTinySteel", "pipeTinySteel",
                        getModItem(AdventureBackpack.ID, "backpackComponent", 1, 5, missing), "pipeTinySteel" });
        addShapedRecipe(
                createItemStack(
                        AdventureBackpack.ID,
                        "copterPack",
                        1,
                        0,
                        "{wearableData:{fuelTank:{Empty:\"\"}}}",
                        missing),
                new Object[] { "screwDiamond", getModItem(AdventureBackpack.ID, "backpackComponent", 1, 6, missing),
                        "screwDiamond", getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing), "pipeTinySteel", "pipeTinySteel",
                        getModItem(AdventureBackpack.ID, "backpackComponent", 1, 5, missing), "pipeTinySteel" });
        addShapedRecipe(
                getModItem(AdventureBackpack.ID, "backpackComponent", 1, 7, missing),
                new Object[] { "plateAnyRubber", "craftingToolWrench", "plateAnyRubber", "plateAnyRubber",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing), "plateAnyRubber",
                        "plateAnyRubber", "plateAnyRubber", "plateAnyRubber" });
        addShapedRecipe(
                getModItem(AdventureBackpack.ID, "backpackComponent", 1, 9, missing),
                new Object[] { "turbineBladeSteel", "screwSteel", "turbineBladeSteel", "screwSteel", "gearGtSmallSteel",
                        "screwSteel", "turbineBladeSteel", "craftingToolScrewdriver", "turbineBladeSteel" });
        addShapedRecipe(
                getModItem(AdventureBackpack.ID, "pistonBoots", 1, 0, missing),
                new Object[] { getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "plateAnyRubber",
                        getModItem(Minecraft.ID, "leather_boots", 1, 0, missing), "plateAnyRubber", "craftingPiston",
                        "screwBronze", "craftingPiston" });
        addShapedRecipe(
                getModItem(AdventureBackpack.ID, "pistonBoots", 1, 0, missing),
                new Object[] { "string", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "string",
                        "plateAnyRubber", getModItem(AdventureBackpack.ID, "pistonBoots", 1, 32767, missing),
                        "plateAnyRubber", null, null, null });
        addShapedRecipe(
                getModItem(AdventureBackpack.ID, "adventureSuit", 1, 0, missing),
                new Object[] { getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                        getModItem(Minecraft.ID, "leather_chestplate", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "screwBronze",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing) });
        addShapedRecipe(
                getModItem(AdventureBackpack.ID, "adventurePants", 1, 0, missing),
                new Object[] { getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                        getModItem(Minecraft.ID, "leather_leggings", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "screwBronze",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing) });
        addShapedRecipe(
                getModItem(AdventureBackpack.ID, "clockworkCrossbow", 1, 0, missing),
                new Object[] { "springSmallSteel", getModItem(Minecraft.ID, "bow", 1, 0, missing), "springSmallSteel",
                        "stickSteel", "wireFineSteel", "stickSteel", "screwSteel", "craftingToolScrewdriver",
                        "screwSteel" });
        addShapedRecipe(
                createItemStack(
                        AdventureBackpack.ID,
                        "coalJetpack",
                        1,
                        0,
                        "{wearableData:{waterTank:{Empty:\"\"}}}",
                        missing),
                new Object[] { "plateAluminium", "screwSteel", "plateAluminium",
                        getModItem(AdventureBackpack.ID, "backpackComponent", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                        getModItem(AdventureBackpack.ID, "backpackComponent", 1, 2, missing), "pipeTinySteel",
                        getModItem(Railcraft.ID, "machine.beta", 1, 5, missing), "pipeTinySteel" });
        addShapedRecipe(
                createItemStack(
                        AdventureBackpack.ID,
                        "coalJetpack",
                        1,
                        0,
                        "{wearableData:{waterTank:{Empty:\"\"}}}",
                        missing),
                new Object[] { "plateAluminium", "screwSteel", "plateAluminium",
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing), "pipeTinySteel",
                        getModItem(Railcraft.ID, "machine.beta", 1, 5, missing), "pipeTinySteel" });

        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "melon", 1, 0, missing)).noItemOutputs()
                .fluidInputs(FluidRegistry.getFluidStack("water", 750))
                .fluidOutputs(FluidRegistry.getFluidStack("melonjuice", 750)).duration(128).eut(4)
                .addTo(sBrewingRecipes);

    }

    private static class AdvancedBackpackConversionRecipe extends ShapedOreRecipe {

        byte inType;
        byte outType;

        public AdvancedBackpackConversionRecipe(ItemStack result, byte inType, byte outType, Object... recipe) {
            super(result, recipe);
            this.inType = inType;
            this.outType = outType;
        }

        @Override
        public ItemStack getCraftingResult(InventoryCrafting crafting) {
            ItemStack result = super.getCraftingResult(crafting);
            Item resultItem = result.getItem();
            for (int i = 0, imax = crafting.getSizeInventory(); i < imax; i++) {
                ItemStack stack = crafting.getStackInSlot(i);
                if (stack != null && stack.getItem() == resultItem) {
                    result.stackTagCompound = new NBTTagCompound();
                    NBTTagCompound wearableData = new NBTTagCompound();
                    wearableData.setByte("type", outType);
                    if (stack.stackTagCompound.getCompoundTag("wearableData").hasKey("inventory")) wearableData.setTag(
                            "inventory",
                            stack.stackTagCompound.getCompoundTag("wearableData").getCompoundTag("inventory").copy());
                    result.stackTagCompound.setTag("wearableData", wearableData);
                    break;
                }
            }
            return result;
        }

        @Override
        public boolean matches(InventoryCrafting inv, World world) {
            if (!super.matches(inv, world)) return false;
            for (int i = 0, imax = inv.getSizeInventory(); i < imax; i++) {
                ItemStack stack = inv.getStackInSlot(i);
                if (stack != null && stack.getItem() == getRecipeOutput().getItem()) {
                    if (stack.stackTagCompound == null || !stack.stackTagCompound.hasKey("wearableData")) return false;
                    NBTTagCompound wearableData = stack.stackTagCompound.getCompoundTag("wearableData");
                    if (wearableData == null || !wearableData.hasKey("type")) return false;
                    return wearableData.getByte("type") == inType;
                }
            }
            return false;
        }
    }
}
