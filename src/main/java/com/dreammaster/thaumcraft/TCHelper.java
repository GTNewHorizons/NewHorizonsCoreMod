package com.dreammaster.thaumcraft;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import net.glease.tc4tweak.api.infusionrecipe.InfusionRecipeExt;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import org.apache.commons.lang3.ArrayUtils;

import gregtech.api.objects.ItemData;
import gregtech.api.util.GTUtility;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.crafting.InfusionEnchantmentRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategoryList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class TCHelper {

    public static IRecipe findCraftingRecipe(ItemStack stack) {
        for (IRecipe recipe : CraftingManager.getInstance().getRecipeList()) {
            final ItemStack output = recipe.getRecipeOutput();
            if (output != null && GTUtility.areStacksEqual(output, stack, true)) {
                return recipe;
            }
        }
        return null;
    }

    public static IArcaneRecipe findArcaneRecipe(ItemStack stack) {
        for (Object craft : ThaumcraftApi.getCraftingRecipes()) {
            if (craft instanceof IArcaneRecipe recipe) {
                final ItemStack output = recipe.getRecipeOutput();
                if (output != null && GTUtility.areStacksEqual(output, stack, true)) {
                    return recipe;
                }
            }
        }
        return null;
    }

    public static IArcaneRecipe findArcaneRecipe(ItemStack stack, boolean ignoreNBT) {
        for (Object craft : ThaumcraftApi.getCraftingRecipes()) {
            if (craft instanceof IArcaneRecipe recipe) {
                final ItemStack output = recipe.getRecipeOutput();
                if (output != null && GTUtility.areStacksEqual(output, stack, ignoreNBT)) {
                    return recipe;
                }
            }
        }
        return null;
    }

    public static CrucibleRecipe findCrucibleRecipe(ItemStack stack) {
        for (Object craft : ThaumcraftApi.getCraftingRecipes()) {
            if (craft instanceof CrucibleRecipe recipe) {
                final ItemStack output = recipe.getRecipeOutput();
                if (output != null && GTUtility.areStacksEqual(output, stack, true)) {
                    return recipe;
                }
            }
        }
        return null;
    }

    public static InfusionRecipe findInfusionRecipe(ItemStack stack) {
        for (Object craft : ThaumcraftApi.getCraftingRecipes()) {
            if (craft instanceof InfusionRecipe recipe) {
                final Object output = recipe.getRecipeOutput();
                if (output instanceof ItemStack && GTUtility.areStacksEqual((ItemStack) output, stack, true)) {
                    return recipe;
                }
            }
        }
        return null;
    }

    public static InfusionEnchantmentRecipe findInfusionEnchantRecipe(int effectID) {
        for (Object craft : ThaumcraftApi.getCraftingRecipes()) {
            if (craft instanceof InfusionEnchantmentRecipe recipe) {
                final Enchantment enchantment = recipe.getEnchantment();
                if (enchantment != null && recipe.getEnchantment().effectId == effectID) {
                    return recipe;
                }
            }
        }
        return null;
    }

    public static void clearPages(final String research) {
        ResearchCategories.getResearch(research).setPages();
    }

    public static void addResearchPage(final String research, ResearchPage page) {
        ResearchItem ri = ResearchCategories.getResearch(research);
        ri.setPages(ArrayUtils.add(ri.getPages(), page));
    }

    public static void clearPrereq(final String research) {
        ResearchCategories.getResearch(research).setParents().setParentsHidden();
    }

    public static void addResearchPrereq(final String research, String prereq, boolean hidden) {
        ResearchItem ri = ResearchCategories.getResearch(research);
        if (hidden) ri.setParentsHidden(ArrayUtils.add(ri.parentsHidden, prereq));
        else ri.setParents(ArrayUtils.add(ri.parents, prereq));
    }

    public static void clearSiblings(final String research) {
        ResearchCategories.getResearch(research).setSiblings();
    }

    public static void addResearchSibling(final String research, String sibling) {
        ResearchItem ri = ResearchCategories.getResearch(research);
        ri.setSiblings(ArrayUtils.add(ri.siblings, sibling));
    }

    private static Field tags = null;

    public static void setResearchAspects(final String research, AspectList aspects) {
        try {
            if (tags == null) {
                tags = ResearchItem.class.getField("tags");
                tags.setAccessible(true);
            }
            tags.set(ResearchCategories.getResearch(research), aspects);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void setResearchComplexity(final String research, int complexity) {
        ResearchCategories.getResearch(research).setComplexity(complexity);
    }

    public static void refreshResearchPages(final String research) {
        ResearchItem target = ResearchCategories.getResearch(research);
        ResearchPage[] pages = target.getPages();
        for (int x = 0; x < pages.length; x++) {
            if (pages[x].recipe != null) {
                if (pages[x].recipe instanceof IRecipe recipe) {
                    final ItemStack outputSearched = recipe.getRecipeOutput();
                    for (IRecipe theCraft : CraftingManager.getInstance().getRecipeList()) {
                        final ItemStack output = theCraft.getRecipeOutput();
                        if (output != null && GTUtility.areStacksEqual(output, outputSearched)) {
                            pages[x] = new ResearchPage(theCraft);
                            break;
                        }
                    }
                } else if (pages[x].recipe instanceof IArcaneRecipe recipe) {
                    final ItemStack outputSearched = recipe.getRecipeOutput();
                    for (Object craft : ThaumcraftApi.getCraftingRecipes()) {
                        if (craft instanceof IArcaneRecipe arcaneRecipe) {
                            final ItemStack output = arcaneRecipe.getRecipeOutput();
                            if (output != null && GTUtility.areStacksEqual(output, outputSearched)) {
                                pages[x] = new ResearchPage(arcaneRecipe);
                                break;
                            }
                        }
                    }
                } else if (pages[x].recipe instanceof CrucibleRecipe recipe) {
                    final ItemStack outputSearched = recipe.getRecipeOutput();
                    for (Object craft : ThaumcraftApi.getCraftingRecipes()) {
                        if (craft instanceof CrucibleRecipe crucibleRecipe) {
                            final ItemStack output = crucibleRecipe.getRecipeOutput();
                            if (output != null && GTUtility.areStacksEqual(output, outputSearched)) {
                                pages[x] = new ResearchPage(crucibleRecipe);
                                break;
                            }
                        }
                    }
                } else if (pages[x].recipe instanceof InfusionRecipe recipe) {
                    if (recipe.getRecipeOutput() instanceof ItemStack outputSearched) {
                        for (Object craft : ThaumcraftApi.getCraftingRecipes()) {
                            if (craft instanceof InfusionRecipe theCraft) {
                                final Object output = theCraft.getRecipeOutput();
                                if (output instanceof ItemStack stack
                                        && GTUtility.areStacksEqual(stack, outputSearched)) {
                                    pages[x] = new ResearchPage(theCraft);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static Field displayColumnField = null;
    private static Field displayRowField = null;
    private static Field category = null;

    public static void moveResearch(final String research, final String destination, final int x, final int y) {
        ResearchItem ri = ResearchCategories.getResearch(research);
        try {
            if (displayColumnField == null) {

                Class<ResearchItem> RIClass = ResearchItem.class;
                displayColumnField = RIClass.getField("displayColumn");
                displayRowField = RIClass.getField("displayRow");
                category = RIClass.getField("category");
                displayColumnField.setAccessible(true);
                displayRowField.setAccessible(true);
                category.setAccessible(true);

            }

            removeResearch(research);
            displayColumnField.set(ri, x);
            displayRowField.set(ri, y);
            category.set(ri, destination);
            ri.registerResearchItem();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void orphanResearch(final String research) {
        final BiConsumer<String[], Consumer<String[]>> removeHelper = (list, setter) -> {
            if (list == null) return;
            for (int i = 0; i < list.length; i++) {
                if (list[i] != null && list[i].equals(research)) {
                    list = ArrayUtils.remove(list, i);
                    setter.accept(list);
                    i--;
                }
            }
        };
        for (ResearchCategoryList categoryList : ResearchCategories.researchCategories.values()) {
            for (Map.Entry<String, ResearchItem> entry : categoryList.research.entrySet()) {
                ResearchItem researchItem = entry.getValue();
                removeHelper.accept(researchItem.parents, researchItem::setParents);
                removeHelper.accept(researchItem.parentsHidden, researchItem::setParentsHidden);
                removeHelper.accept(researchItem.siblings, researchItem::setSiblings);
            }
        }
    }

    public static void removeResearch(final String research) {
        ResearchItem ri = ResearchCategories.getResearch(research);
        ResearchCategoryList rcl = ResearchCategories.getResearchList(ri.category);
        rcl.research.remove(research);
    }

    public static void removeArcaneRecipe(final ItemStack output) {
        ThaumcraftApi.getCraftingRecipes().removeIf(recipe -> {
            if (recipe instanceof IArcaneRecipe arcaneRecipe) {
                final ItemStack stack = arcaneRecipe.getRecipeOutput();
                return stack != null && GTUtility.areStacksEqual(stack, output);
            }
            return false;
        });
    }

    public static void removeCrucibleRecipe(final ItemStack output) {
        ThaumcraftApi.getCraftingRecipes().removeIf(recipe -> {
            if (recipe instanceof CrucibleRecipe crucibleRecipe) {
                final ItemStack stack = crucibleRecipe.getRecipeOutput();
                return stack != null && GTUtility.areStacksEqual(stack, output);
            }
            return false;
        });
    }

    public static void removeInfusionRecipe(final ItemStack output) {
        ThaumcraftApi.getCraftingRecipes().removeIf(recipe -> {
            if (recipe instanceof InfusionRecipe infusionRecipe) {
                final Object object = infusionRecipe.getRecipeOutput();
                return object instanceof ItemStack stack && GTUtility.areStacksEqual(stack, output);
            }
            return false;
        });
    }

    public static void removeInfusionEnchantmentRecipe(final int effectID) {
        ThaumcraftApi.getCraftingRecipes().removeIf(recipe -> {
            if (recipe instanceof InfusionEnchantmentRecipe infusionEnchantmentRecipe) {
                final Enchantment enchantment = infusionEnchantmentRecipe.getEnchantment();
                return enchantment != null && enchantment.effectId == effectID;
            }
            return false;
        });
    }

    private static Field infusionRecipeResearchField = null;

    public static void setRecipeResearch(final InfusionRecipe recipe, final String researchName) {
        try {
            if (infusionRecipeResearchField == null) {
                infusionRecipeResearchField = InfusionRecipe.class.getDeclaredField("research");
                infusionRecipeResearchField.setAccessible(true);
            }
            infusionRecipeResearchField.set(recipe, researchName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static InfusionRecipe addInfusionCraftingRecipe(String research, ItemStack result, int instability,
            AspectList aspects, Object input, Object... recipe) {

        if (result == null || result.getItem() == null) {
            return null;
        }
        if (input == null) {
            return null;
        }

        AspectList safeAspects = (aspects != null) ? aspects : new AspectList();

        Object safeInput = (input instanceof ItemData) ? input.toString() : input;

        Object[] safeRecipe;
        if (recipe == null || recipe.length == 0) {
            safeRecipe = new Object[0];
        } else {
            java.util.List<Object> tmp = new java.util.ArrayList<>(recipe.length);
            for (Object oby : recipe) {
                if (oby == null) continue;
                tmp.add(oby instanceof ItemData ? oby.toString() : oby);
            }
            safeRecipe = tmp.toArray(new Object[0]);
        }

        try {
            return InfusionRecipeExt.get()
                    .addInfusionCraftingRecipe(research, result, instability, safeAspects, safeInput, safeRecipe);
        } catch (RuntimeException e) {
            return null;
        }
    }
}
