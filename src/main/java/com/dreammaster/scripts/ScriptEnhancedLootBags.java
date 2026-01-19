package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BloodMagic;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.EnhancedLootBags;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Mods.Gendustry;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.util.GTModHandler.getModItem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.item.NHItemList;
import com.dreammaster.recipes.CustomItem;
import com.dreammaster.recipes.ShapelessUniversalRecipe;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.ItemList;

public class ScriptEnhancedLootBags implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Enhanced Loot Bags";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                BloodMagic.ID,
                DraconicEvolution.ID,
                EnhancedLootBags.ID,
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
        // Gaps in this map are from lootbags which gain no benefit from being enchanted or deleted lootbags.
        // This is because the only effect of enchanting lootbags is to remove their "trash" drops.
        HashMap<Integer, ItemStack> metaExtraItemMap = new HashMap<>();
        metaExtraItemMap.put(1, new ItemStack(Items.clay_ball));
        metaExtraItemMap.put(2, getModItem(IndustrialCraft2.ID, "itemHarz", 1, 0, missing));
        metaExtraItemMap.put(4, ItemList.Electric_Motor_LV.get(1L));
        metaExtraItemMap.put(5, ItemList.Electric_Motor_MV.get(1L));
        metaExtraItemMap.put(6, ItemList.Electric_Motor_HV.get(1L));
        metaExtraItemMap.put(7, ItemList.Electric_Motor_EV.get(1L));
        metaExtraItemMap.put(8, ItemList.Electric_Motor_IV.get(1L));
        metaExtraItemMap.put(9, getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing));
        metaExtraItemMap.put(10, getModItem(Thaumcraft.ID, "ItemBathSalts", 1, 0, missing));
        metaExtraItemMap.put(11, getModItem(Thaumcraft.ID, "WandCap", 1, 7, missing));
        metaExtraItemMap.put(16, getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing));
        metaExtraItemMap.put(17, getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing));
        metaExtraItemMap.put(18, getModItem(BloodMagic.ID, "blockTeleposer", 1, 0, missing));
        metaExtraItemMap.put(19, getModItem(Forestry.ID, "waxCapsule", 1, 0, missing));
        metaExtraItemMap.put(20, getModItem(Forestry.ID, "craftingMaterial", 1, 6, missing));
        metaExtraItemMap.put(21, getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing));
        metaExtraItemMap.put(25, getModItem(Forestry.ID, "propolis", 1, 3, missing));
        metaExtraItemMap.put(26, getModItem(Forestry.ID, "royalJelly", 1, 0, missing));
        metaExtraItemMap.put(27, getModItem(Gendustry.ID, "MutagenBucket", 1, 0, missing));
        metaExtraItemMap.put(28, getModItem(Minecraft.ID, "cake", 1, 0, missing));
        metaExtraItemMap.put(29, ItemList.Food_Large_Sandwich_Bacon.get(1L));
        metaExtraItemMap.put(30, getModItem(PamsHarvestCraft.ID, "delightedmealItem", 1, 0, missing));
        metaExtraItemMap.put(32, new ItemStack(Items.minecart));
        metaExtraItemMap
                .put(33, createItemStack(Railcraft.ID, "track", 1, 816, "{track:\"railcraft:track.speed\"}", missing));
        metaExtraItemMap.put(37, NHItemList.LogicProcessorItemGoldCore.get());
        metaExtraItemMap.put(38, NHItemList.EngineeringProcessorItemDiamondCore.get());
        metaExtraItemMap.put(41, ItemList.Electric_Motor_LuV.get(1L));
        metaExtraItemMap.put(42, ItemList.Electric_Motor_ZPM.get(1L));
        metaExtraItemMap.put(43, ItemList.Electric_Motor_UV.get(1L));
        metaExtraItemMap.put(44, ItemList.ZPM3.get(1L));
        metaExtraItemMap.put(46, getModItem(OpenComputers.ID, "item", 1, 1, missing));
        metaExtraItemMap.put(51, ItemList.Machine_LV_Scanner.get(1L));
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
                            new CustomItem.EnchantedBookMatcher().addEnchantment(35, 3),
                            entry.getValue()));
        }

    }
}
