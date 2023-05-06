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
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Items;

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
        GameRegistry.addRecipe(
                new ShapelessUniversalRecipe(
                        createItemStack(
                                EnhancedLootBags.ID,
                                "lootbag",
                                1,
                                1,
                                "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                                missing),
                        getModItem(EnhancedLootBags.ID, "lootbag", 1, 1, missing),
                        new NBTItem().item(Items.enchanted_book).setNBT("{StoredEnchantments:[0:{lvl:3s,id:35s}]}"),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(Minecraft.ID, "clay_ball", 1, 0, missing)));
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        2,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 2, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemHarz", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        4,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 4, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        5,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 5, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        6,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 6, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        7,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 7, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32603, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        8,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 8, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32604, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        9,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 9, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        10,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 10, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemBathSalts", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        11,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 11, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "WandCap", 1, 7, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        12,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 12, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        13,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 13, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "warpGate", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        14,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 14, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(DraconicEvolution.ID, "draconicCore", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        15,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 15, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(Minecraft.ID, "dragon_egg", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        16,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 16, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        17,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 17, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        18,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 18, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(BloodMagic.ID, "blockTeleposer", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        19,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 19, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(Forestry.ID, "waxCapsule", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        20,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 20, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(Forestry.ID, "craftingMaterial", 1, 6, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        21,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 21, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        22,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 22, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(GalacticraftCore.ID, "item.airFan", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        23,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 23, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 7, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        24,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 24, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.WaferTier3", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        25,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 25, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(Forestry.ID, "propolis", 1, 3, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        26,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 26, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(Forestry.ID, "royalJelly", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        27,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 27, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(Gendustry.ID, "MutagenBucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        28,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 28, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(Minecraft.ID, "cake", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        29,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 29, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32243, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        30,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 30, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "delightedmealItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        31,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 31, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(DraconicEvolution.ID, "dezilsMarshmallow", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        32,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 32, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        33,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 33, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        createItemStack(Railcraft.ID, "track", 1, 816, "{track:\"railcraft:track.speed\"}", missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        34,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 34, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        createItemStack(
                                Railcraft.ID,
                                "cart.loco.electric",
                                1,
                                0,
                                "{model:\"railcraft:default\"}",
                                missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        35,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 35, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemCropSeed", 1, 32767, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        36,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 36, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "beefwellingtonItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        37,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 37, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.LogicProcessorItemGoldCore", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        38,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 38, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.EngineeringProcessorItemDiamondCore", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        39,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 38, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.EngineeringProcessorItemEmeraldCore", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        40,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 38, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(
                                NewHorizonsCoreMod.ID,
                                "item.EngineeringProcessorItemAdvEmeraldCore",
                                1,
                                0,
                                missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        41,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 41, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32606, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        42,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 42, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32607, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        43,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 43, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32608, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        44,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 44, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32609, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        45,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 45, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(OpenComputers.ID, "eeprom", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        46,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 46, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(OpenComputers.ID, "item", 1, 1, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        47,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 47, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(OpenComputers.ID, "item", 1, 2, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        48,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 48, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(OpenComputers.ID, "item", 1, 38, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        49,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 49, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(OpenComputers.ID, "item", 1, 39, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        50,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 50, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(OpenComputers.ID, "item", 1, 69, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        51,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 51, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 341, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        52,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 52, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(Witchery.ID, "witchleaves", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        53,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 53, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(Witchery.ID, "ingredient", 1, 95, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        54,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 54, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(Witchery.ID, "ingredient", 1, 11, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        55,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 55, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(Witchery.ID, "ingredient", 1, 96, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        56,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 56, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(Witchery.ID, "leonardsurn", 1, 3, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        57,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 57, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "enderman_head", 1, 0, missing) });
        addShapelessCraftingRecipe(
                createItemStack(
                        EnhancedLootBags.ID,
                        "lootbag",
                        1,
                        58,
                        "{ench:[0:{lvl:3s,id:35s}],RepairCost:2}",
                        missing),
                new Object[] { getModItem(EnhancedLootBags.ID, "lootbag", 1, 58, missing),
                        getModItem(Minecraft.ID, "enchanted_book", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "rune", 1, 5, missing) });

    }
}
