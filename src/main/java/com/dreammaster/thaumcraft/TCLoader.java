package com.dreammaster.thaumcraft;

import java.util.HashSet;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import com.dreammaster.lib.Refstrings;
import com.dreammaster.main.MainRegistry;

import cpw.mods.fml.common.registry.GameRegistry;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.crafting.InfusionEnchantmentRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchCategories;

public class TCLoader {

    public static final String category = "NEWHORIZONS";

    public static void run() {
        ResearchCategories.registerCategory(
                category,
                new ResourceLocation(Refstrings.MODID, "textures/thaumcraft/icon/icon_GTNH.png"),
                new ResourceLocation(Refstrings.MODID, "textures/thaumcraft/tab/tab_GTNH.png"));
    }

    public static void checkRecipeProblems() {
        HashSet<String> availableResearches = new HashSet<>();
        ResearchCategories.researchCategories.values()
                .forEach(rc -> rc.research.forEach((k, v) -> availableResearches.add(k)));
        for (Object recipe : ThaumcraftApi.getCraftingRecipes()) {
            String researchName = null;
            Object output = null;
            if (recipe instanceof InfusionRecipe) {
                researchName = ((InfusionRecipe) recipe).getResearch();
                output = ((InfusionRecipe) recipe).getRecipeOutput();
            } else if (recipe instanceof IArcaneRecipe) {
                researchName = ((IArcaneRecipe) recipe).getResearch();
                output = ((IArcaneRecipe) recipe).getRecipeOutput();
            } else if (recipe instanceof CrucibleRecipe) {
                researchName = ((CrucibleRecipe) recipe).key;
                output = ((CrucibleRecipe) recipe).getRecipeOutput();
            } else if (recipe instanceof InfusionEnchantmentRecipe) {
                researchName = ((InfusionEnchantmentRecipe) recipe).getResearch();
                output = "Enchantment recipe (effectId: "
                        + ((InfusionEnchantmentRecipe) recipe).getEnchantment().effectId
                        + ")";
            }
            if (researchName == null || (!(output instanceof ItemStack) && !(output instanceof String))) continue;
            String outputString;
            if (output instanceof ItemStack)
                outputString = GameRegistry.findUniqueIdentifierFor(((ItemStack) output).getItem()).toString() + ":"
                        + ((ItemStack) output).getItemDamage();
            else outputString = (String) output;
            if (!availableResearches.contains(researchName)) {
                MainRegistry.Logger.error(
                        "WARNING!! Thaumcraft recipe for " + outputString
                                + " has invalid research name ("
                                + researchName
                                + ")!");
            }
        }
    }

}
