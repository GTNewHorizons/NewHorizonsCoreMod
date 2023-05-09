package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BloodMagic;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.EnhancedLootBags;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Mods.Gendustry;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.recipes.NBTItem;
import com.dreammaster.recipes.ShapelessUniversalRecipe;

import cpw.mods.fml.common.registry.GameRegistry;

public class ScriptEnhancedLootBags implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Enhanced Loot Bags";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                EnhancedLootBags.ID,
                BloodMagic.ID,
                DraconicEvolution.ID,
                Forestry.ID,
                GalacticraftCore.ID,
                GalacticraftMars.ID,
                Gendustry.ID,
                HardcoreEnderExpansion.ID,
                IndustrialCraft2.ID,
                OpenComputers.ID,
                PamsHarvestCraft.ID,
                Railcraft.ID,
                Thaumcraft.ID,
                ThaumicTinkerer.ID,
                Witchery.ID);
    }

    @Override
    public void loadRecipes() {
        HashMap<Integer, ItemStack> metaExtraItemMap = new HashMap<>();
        metaExtraItemMap.put(1, new ItemStack(Items.clay_ball));
        metaExtraItemMap.put(2, getModItem(IndustrialCraft2.ID, "itemHarz", 1, 0, missing));
        metaExtraItemMap.put(4, getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing));
        metaExtraItemMap.put(5, getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing));
        metaExtraItemMap.put(6, getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing));
        metaExtraItemMap.put(7, getModItem(GregTech.ID, "gt.metaitem.01", 1, 32603, missing));
        metaExtraItemMap.put(8, getModItem(GregTech.ID, "gt.metaitem.01", 1, 32604, missing));
        metaExtraItemMap.put(9, getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing));
        metaExtraItemMap.put(10, getModItem(Thaumcraft.ID, "ItemBathSalts", 1, 0, missing));
        metaExtraItemMap.put(11, getModItem(Thaumcraft.ID, "WandCap", 1, 7, missing));
        metaExtraItemMap.put(12, getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0, missing));
        metaExtraItemMap.put(13, getModItem(ThaumicTinkerer.ID, "warpGate", 1, 0, missing));
        metaExtraItemMap.put(14, getModItem(DraconicEvolution.ID, "draconicCore", 1, 0, missing));
        metaExtraItemMap.put(15, new ItemStack(Blocks.dragon_egg));
        metaExtraItemMap.put(16, getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing));
        metaExtraItemMap.put(17, getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing));
        metaExtraItemMap.put(18, getModItem(BloodMagic.ID, "blockTeleposer", 1, 0, missing));
        metaExtraItemMap.put(19, getModItem(Forestry.ID, "waxCapsule", 1, 0, missing));
        metaExtraItemMap.put(20, getModItem(Forestry.ID, "craftingMaterial", 1, 6, missing));
        metaExtraItemMap.put(21, getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing));
        metaExtraItemMap.put(22, getModItem(GalacticraftCore.ID, "item.airFan", 1, 0, missing));
        metaExtraItemMap.put(23, getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 7, missing));
        metaExtraItemMap.put(24, getModItem(NewHorizonsCoreMod.ID, "item.WaferTier3", 1, 0, missing));
        metaExtraItemMap.put(25, getModItem(Forestry.ID, "propolis", 1, 3, missing));
        metaExtraItemMap.put(26, getModItem(Forestry.ID, "royalJelly", 1, 0, missing));
        metaExtraItemMap.put(27, getModItem(Gendustry.ID, "MutagenBucket", 1, 0, missing));
        metaExtraItemMap.put(28, getModItem(Minecraft.ID, "cake", 1, 0, missing));
        metaExtraItemMap.put(29, getModItem(GregTech.ID, "gt.metaitem.02", 1, 32243, missing));
        metaExtraItemMap.put(30, getModItem(PamsHarvestCraft.ID, "delightedmealItem", 1, 0, missing));
        metaExtraItemMap.put(31, getModItem(DraconicEvolution.ID, "dezilsMarshmallow", 1, 0, missing));
        metaExtraItemMap.put(32, new ItemStack(Items.minecart));
        metaExtraItemMap
                .put(33, createItemStack(Railcraft.ID, "track", 1, 816, "{track:\"railcraft:track.speed\"}", missing));
        metaExtraItemMap.put(
                34,
                createItemStack(Railcraft.ID, "cart.loco.electric", 1, 0, "{model:\"railcraft:default\"}", missing));
        metaExtraItemMap.put(35, getModItem(IndustrialCraft2.ID, "itemCropSeed", 1, 32767, missing));
        metaExtraItemMap.put(36, getModItem(PamsHarvestCraft.ID, "beefwellingtonItem", 1, 0, missing));
        metaExtraItemMap.put(37, getModItem(NewHorizonsCoreMod.ID, "item.LogicProcessorItemGoldCore", 1, 0, missing));
        metaExtraItemMap
                .put(38, getModItem(NewHorizonsCoreMod.ID, "item.EngineeringProcessorItemDiamondCore", 1, 0, missing));
        metaExtraItemMap
                .put(39, getModItem(NewHorizonsCoreMod.ID, "item.EngineeringProcessorItemEmeraldCore", 1, 0, missing));
        metaExtraItemMap.put(
                40,
                getModItem(NewHorizonsCoreMod.ID, "item.EngineeringProcessorItemAdvEmeraldCore", 1, 0, missing));
        metaExtraItemMap.put(41, getModItem(GregTech.ID, "gt.metaitem.01", 1, 32606, missing));
        metaExtraItemMap.put(42, getModItem(GregTech.ID, "gt.metaitem.01", 1, 32607, missing));
        metaExtraItemMap.put(43, getModItem(GregTech.ID, "gt.metaitem.01", 1, 32608, missing));
        metaExtraItemMap.put(44, getModItem(GregTech.ID, "gt.metaitem.01", 1, 32609, missing));
        metaExtraItemMap.put(45, getModItem(OpenComputers.ID, "eeprom", 1, 0, missing));
        metaExtraItemMap.put(46, getModItem(OpenComputers.ID, "item", 1, 1, missing));
        metaExtraItemMap.put(47, getModItem(OpenComputers.ID, "item", 1, 2, missing));
        metaExtraItemMap.put(48, getModItem(OpenComputers.ID, "item", 1, 38, missing));
        metaExtraItemMap.put(49, getModItem(OpenComputers.ID, "item", 1, 39, missing));
        metaExtraItemMap.put(50, getModItem(OpenComputers.ID, "item", 1, 69, missing));
        metaExtraItemMap.put(51, getModItem(GregTech.ID, "gt.blockmachines", 1, 341, missing));
        metaExtraItemMap.put(52, getModItem(Witchery.ID, "witchleaves", 1, 0, missing));
        metaExtraItemMap.put(53, getModItem(Witchery.ID, "ingredient", 1, 95, missing));
        metaExtraItemMap.put(54, getModItem(Witchery.ID, "ingredient", 1, 11, missing));
        metaExtraItemMap.put(55, getModItem(Witchery.ID, "ingredient", 1, 96, missing));
        metaExtraItemMap.put(56, getModItem(Witchery.ID, "leonardsurn", 1, 3, missing));
        metaExtraItemMap.put(57, getModItem(HardcoreEnderExpansion.ID, "enderman_head", 1, 0, missing));
        metaExtraItemMap.put(58, getModItem(HardcoreEnderExpansion.ID, "rune", 1, 5, missing));

        for (Map.Entry<Integer, ItemStack> entry : metaExtraItemMap.entrySet()) {
            GameRegistry.addRecipe(
                    new ShapelessUniversalRecipe(
                            createItemStack(
                                    EnhancedLootBags.ID,
                                    "lootbag",
                                    1,
                                    entry.getKey(),
                                    "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                                    missing),
                            getModItem(EnhancedLootBags.ID, "lootbag", 1, entry.getKey(), missing),
                            new NBTItem().item(Items.enchanted_book).setNBT("{StoredEnchantments:[0:{lvl:3s,id:35s}]}"),
                            entry.getValue()));
        }

    }
}
