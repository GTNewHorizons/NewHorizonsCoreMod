package com.dreammaster.recipes;

import static com.dreammaster.scripts.IScriptLoader.missing;
import static com.dreammaster.scripts.IScriptLoader.wildcard;
import static gregtech.api.GregTechAPI.sBlockOres1;
import static gregtech.api.enums.Mods.AE2Stuff;
import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.enums.Mods.AkashicTome;
import static gregtech.api.enums.Mods.Automagy;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BetterBuildersWands;
import static gregtech.api.enums.Mods.BinnieCore;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.BloodMagic;
import static gregtech.api.enums.Mods.Botany;
import static gregtech.api.enums.Mods.CarpentersBlocks;
import static gregtech.api.enums.Mods.CatWalks;
import static gregtech.api.enums.Mods.Chisel;
import static gregtech.api.enums.Mods.CompactKineticGenerators;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.ElectroMagicTools;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.EnderZoo;
import static gregtech.api.enums.Mods.EtFuturumRequiem;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.ExtraBees;
import static gregtech.api.enums.Mods.ExtraTrees;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.FloodLights;
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Mods.Gendustry;
import static gregtech.api.enums.Mods.Genetics;
import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.GraviSuiteNEO;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IC2NuclearControl;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.MCFrames;
import static gregtech.api.enums.Mods.MagicBees;
import static gregtech.api.enums.Mods.MalisisDoors;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.OpenGlasses;
import static gregtech.api.enums.Mods.OpenModularTurrets;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.PamsHarvestTheNether;
import static gregtech.api.enums.Mods.ProjectRedCore;
import static gregtech.api.enums.Mods.ProjectRedExpansion;
import static gregtech.api.enums.Mods.ProjectRedExploration;
import static gregtech.api.enums.Mods.ProjectRedFabrication;
import static gregtech.api.enums.Mods.ProjectRedTransmission;
import static gregtech.api.enums.Mods.ProjectRedTransportation;
import static gregtech.api.enums.Mods.QuestBook;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.RandomThings;
import static gregtech.api.enums.Mods.RemoteIO;
import static gregtech.api.enums.Mods.SGCraft;
import static gregtech.api.enums.Mods.StevesAddons;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.TaintedMagic;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.ThaumicEnergistics;
import static gregtech.api.enums.Mods.ThaumicExploration;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TinkersDefence;
import static gregtech.api.enums.Mods.TinkersMechworks;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.enums.Mods.WirelessRedstoneCBEAddons;
import static gregtech.api.enums.Mods.WirelessRedstoneCBECore;
import static gregtech.api.enums.Mods.WirelessRedstoneCBELogic;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.util.GTModHandler.getModItem;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.dreammaster.main.MainRegistry;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gtPlusPlus.core.block.ModBlocks;
import gtPlusPlus.core.item.ModItems;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;

public class RecipeRemover {

    private static HashMap<GTUtility.ItemId, List<Function<IRecipe, Boolean>>> bufferMap;

    private static void addToBuffer(HashSet<GTUtility.ItemId> outputs, Function<IRecipe, Boolean> whenToRemove) {
        for (GTUtility.ItemId output : outputs) {
            bufferMap.computeIfAbsent(output, o -> new ArrayList<>()).add(whenToRemove);
        }
    }

    private static void flushBuffer() {
        final ArrayList<IRecipe> list = (ArrayList<IRecipe>) CraftingManager.getInstance().getRecipeList();
        int i = list.size();
        list.removeIf(r -> {
            ItemStack rCopy = r.getRecipeOutput();
            if (rCopy == null) {
                return false;
            }
            if (rCopy.getItem() == null) {
                MainRegistry.Logger.warn("Someone is adding recipes with null items!");
                return true;
            }
            if (rCopy.stackTagCompound != null) {
                rCopy = rCopy.copy();
                rCopy.stackTagCompound = null;
            }
            GTUtility.ItemId key = GTUtility.ItemId.createNoCopy(rCopy);
            rCopy = rCopy.copy();
            Items.feather.setDamage(rCopy, wildcard);
            GTUtility.ItemId keyWildcard = GTUtility.ItemId.createNoCopy(rCopy);
            List<Function<IRecipe, Boolean>> listWhenToRemove = bufferMap.get(key);
            if (listWhenToRemove == null) listWhenToRemove = bufferMap.get(keyWildcard);
            if (listWhenToRemove == null) return false;
            for (Function<IRecipe, Boolean> whenToRemove : listWhenToRemove) {
                if (whenToRemove.apply(r)) return true;
            }
            return false;
        });
        MainRegistry.Logger.info("Removed " + (i - list.size()) + " recipes!");
    }

    private static HashSet<GTUtility.ItemId> getItemsHashed(Object item, boolean includeWildcardVariants) {
        HashSet<GTUtility.ItemId> hashedItems = new HashSet<>();
        if (item instanceof ItemStack) {
            ItemStack iCopy = ((ItemStack) item).copy();
            iCopy.stackTagCompound = null;
            hashedItems.add(GTUtility.ItemId.createNoCopy(iCopy));
            if (includeWildcardVariants) {
                iCopy = iCopy.copy();
                Items.feather.setDamage(iCopy, wildcard);
                hashedItems.add(GTUtility.ItemId.createNoCopy(iCopy));
            }
        } else if (item instanceof String) {
            for (ItemStack stack : OreDictionary.getOres((String) item)) {
                hashedItems.add(GTUtility.ItemId.createNoCopy(stack));
                if (includeWildcardVariants) {
                    stack = stack.copy();
                    Items.feather.setDamage(stack, wildcard);
                    hashedItems.add(GTUtility.ItemId.createNoCopy(stack));
                }
            }
        } else if (item instanceof ArrayList) {
            // noinspection unchecked
            for (ItemStack stack : (ArrayList<ItemStack>) item) {
                ItemStack iCopy = stack.copy();
                iCopy.stackTagCompound = null;
                hashedItems.add(GTUtility.ItemId.createNoCopy(iCopy));
                if (includeWildcardVariants) {
                    iCopy = iCopy.copy();
                    Items.feather.setDamage(iCopy, wildcard);
                    hashedItems.add(GTUtility.ItemId.createNoCopy(iCopy));
                }
            }
        } else throw new IllegalArgumentException("Invalid input");
        return hashedItems;
    }

    /**
     * Removes only shapeless recipes by output and inputs, supports OreDictionary tags
     *
     * @author kuba6000
     */
    private static void removeRecipeShapelessDelayed(Object aOutput, Object... aRecipe) {
        ArrayList<Object> aRecipeList = new ArrayList<>(Arrays.asList(aRecipe));
        addToBuffer(getItemsHashed(aOutput, false), r -> {
            if (!(r instanceof ShapelessOreRecipe) && !(r instanceof ShapelessRecipes)) return false;
            if (aRecipeList.isEmpty()) return true;
            @SuppressWarnings("unchecked")
            ArrayList<Object> recipe = (ArrayList<Object>) aRecipeList.clone();
            List<?> rInputs = (r instanceof ShapelessOreRecipe ? ((ShapelessOreRecipe) r).getInput()
                    : ((ShapelessRecipes) r).recipeItems);
            for (Object rInput : rInputs) {
                HashSet<GTUtility.ItemId> rInputHashed;
                HashSet<GTUtility.ItemId> rInputHashedNoWildcard;
                try {
                    rInputHashed = getItemsHashed(rInput, true);
                    rInputHashedNoWildcard = getItemsHashed(rInput, false);
                } catch (Exception ex) {
                    return false;
                }
                boolean found = false;
                for (Iterator<Object> iterator = recipe.iterator(); iterator.hasNext();) {
                    Object o = iterator.next();
                    for (GTUtility.ItemId id : getItemsHashed(o, false)) {
                        if (rInputHashed.contains(id)) {
                            found = true;
                            iterator.remove();
                            break;
                        }
                    }
                    if (!found) {
                        for (GTUtility.ItemId id : getItemsHashed(o, true)) {
                            if (rInputHashedNoWildcard.contains(id)) {
                                found = true;
                                iterator.remove();
                                break;
                            }
                        }
                    }
                    if (found) break;
                }
                if (!found) return false;
            }
            return recipe.isEmpty();
        });
    }

    private static Field recipeWidthField = null;

    /**
     * Removes only shaped recipes by output and inputs, supports OreDictionary tags
     *
     * @author kuba6000
     */
    private static void removeRecipeShapedDelayed(Object aOutput, Object[] row1, Object[] row2, Object[] row3) {
        if (recipeWidthField == null) {
            try {
                recipeWidthField = ShapedOreRecipe.class.getDeclaredField("width");
                recipeWidthField.setAccessible(true);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        Object[][] recipe = new Object[][] { row1, row2, row3 };
        addToBuffer(getItemsHashed(aOutput, false), r -> {
            if (!(r instanceof ShapedOreRecipe) && !(r instanceof ShapedRecipes)) return false;
            Object[] inputs = (r instanceof ShapedOreRecipe ? ((ShapedOreRecipe) r).getInput()
                    : ((ShapedRecipes) r).recipeItems);
            int width;
            try {
                width = (r instanceof ShapedOreRecipe ? (int) recipeWidthField.get(r)
                        : ((ShapedRecipes) r).recipeWidth);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            int height = (r instanceof ShapedOreRecipe ? r.getRecipeSize() / width : ((ShapedRecipes) r).recipeHeight);

            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    Object rStack = (y >= height || x >= width ? null : inputs[x + y * width]);
                    Object rRecipe = (x >= recipe[y].length ? null : recipe[y][x]);
                    if (rStack == null ^ rRecipe == null) return false;
                    if (rStack == null) continue;
                    HashSet<GTUtility.ItemId> rInputHashed;
                    try {
                        rInputHashed = getItemsHashed(rStack, true);
                    } catch (Exception ex) {
                        return false;
                    }
                    boolean found = false;
                    for (GTUtility.ItemId id : getItemsHashed(rRecipe, false)) {
                        if (rInputHashed.contains(id)) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        rInputHashed = getItemsHashed(rStack, false);
                        for (GTUtility.ItemId id : getItemsHashed(rRecipe, true)) {
                            if (rInputHashed.contains(id)) {
                                found = true;
                                break;
                            }
                        }
                    }
                    if (!found) return false;
                }
            }

            return true;
        });
    }

    /**
     * Removes only shaped recipes by output, supports OreDictionary tag
     *
     * @author kuba6000
     */
    private static void removeRecipeShapedDelayed(Object aOutput) {
        addToBuffer(getItemsHashed(aOutput, false), r -> r instanceof ShapedOreRecipe || r instanceof ShapedRecipes);
    }

    /**
     * Removes recipes by output, supports OreDictionary tags
     *
     * @author kuba6000
     */
    private static void removeRecipeByOutputDelayed(Object aOutput) {
        addToBuffer(getItemsHashed(aOutput, false), r -> true);
    }

    public static void run() {
        bufferMap = new HashMap<>();
        final long timeStart = System.currentTimeMillis();

        if (EtFuturumRequiem.isModLoaded()) {
            removeRecipeByOutputDelayed(getModItem(EtFuturumRequiem.ID, "blast_furnace", 1, 0));
            removeRecipeByOutputDelayed(getModItem(EtFuturumRequiem.ID, "wooden_armorstand", 1, 0));
            removeRecipeByOutputDelayed(getModItem(EtFuturumRequiem.ID, "smoker", 1, 0));
            removeRecipeByOutputDelayed(getModItem(EtFuturumRequiem.ID, "end_crystal", 1, 0));
            removeRecipeByOutputDelayed(getModItem(EtFuturumRequiem.ID, "cherry_trapdoor", 1, 0));
            removeRecipeByOutputDelayed(getModItem(EtFuturumRequiem.ID, "smithing_table", 1, 0));
            for (int i = 0; i < 16; i++) {
                removeRecipeByOutputDelayed(getModItem(EtFuturumRequiem.ID, "banner", 1, i));
            }
            for (int i = 0; i < 9; i++) {
                removeRecipeByOutputDelayed(getModItem(EtFuturumRequiem.ID, "shulker_box_upgrade", 1, i));
            }
        }

        // AUTOGENERATED FROM SCRIPTS

        GTModHandler.removeFurnaceSmelting(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Sunnarium, 1L));
        GTModHandler.removeFurnaceSmelting(GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Sunnarium, 1L));

        GTModHandler.removeFurnaceSmelting(GTOreDictUnificator.get(OrePrefixes.spring, Materials.Sunnarium, 1L));
        GTModHandler.removeFurnaceSmelting(GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Sunnarium, 1L));
        GTModHandler.removeFurnaceSmelting(getModItem(Backpack.ID, "boundLeather", 1, wildcard, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Minecraft.ID, "gravel", 1, wildcard, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 10, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(EnderIO.ID, "itemMaterial", 1, 2, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Minecraft.ID, "quartz_block", 1, 0, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 7, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 9, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(FloodLights.ID, "rawFilament", 1, 0, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 1, 4, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1, 4, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(GalacticraftMars.ID, "item.null", 1, 0, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Minecraft.ID, "chainmail_boots", 1, 0, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(IndustrialCraft2.ID, "blockRubWood", 1, 0, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Minecraft.ID, "slime_ball", 1, 0, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(IndustrialCraft2.ID, "itemMugCoffee", 1, wildcard, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 4, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(IndustrialCraft2.ID, "itemOreIridium", 1, 0, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Minecraft.ID, "obsidian", 1, 0, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Minecraft.ID, "clay_ball", 1, wildcard, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Minecraft.ID, "netherrack", 1, wildcard, missing));
        GTModHandler.removeFurnaceSmelting(ItemList.Food_Raw_Bread.get(1L));
        GTModHandler.removeFurnaceSmelting(getModItem(TinkerConstruct.ID, "oreBerries", 1, 0, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(TinkerConstruct.ID, "oreBerries", 1, 1, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(TinkerConstruct.ID, "oreBerries", 1, 2, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(TinkerConstruct.ID, "oreBerries", 1, 3, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(TinkerConstruct.ID, "oreBerries", 1, 4, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Minecraft.ID, "sand", 1, wildcard, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Minecraft.ID, "soul_sand", 1, 0, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Natura.ID, "heatsand", 1, 0, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Natura.ID, "tree", 1, 0, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Natura.ID, "tree", 1, 1, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Natura.ID, "tree", 1, 2, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Natura.ID, "tree", 1, 3, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Natura.ID, "redwood", 1, 0, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Natura.ID, "redwood", 1, 1, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Natura.ID, "redwood", 1, 2, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Minecraft.ID, "stone", 1, wildcard, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 41, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 42, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 43, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 57, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 58, missing));
        GTModHandler.removeFurnaceSmelting(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.ore", 1, 6, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 46, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 48, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 18, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 11, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 21, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 1, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 2, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Thaumcraft.ID, "blockCustomOre", 1, 7, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(BiomesOPlenty.ID, "gemOre", 1, 14, missing));
        GTModHandler.removeFurnaceSmelting(GTOreDictUnificator.get(OrePrefixes.oreBasalt, Materials.Amber, 1L));
        GTModHandler.removeFurnaceSmelting(GTOreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Amber, 1L));
        GTModHandler.removeFurnaceSmelting(GTOreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Amber, 1L));
        GTModHandler.removeFurnaceSmelting(new ItemStack(sBlockOres1, 1, 514));
        GTModHandler.removeFurnaceSmelting(GTOreDictUnificator.get(OrePrefixes.oreMarble, Materials.Amber, 1L));
        GTModHandler.removeFurnaceSmelting(GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Amber, 1L));
        GTModHandler.removeFurnaceSmelting(GTOreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Amber, 1L));
        GTModHandler.removeFurnaceSmelting(getModItem(Thaumcraft.ID, "ItemShard", 1, 6, missing));
        GTModHandler.removeFurnaceSmelting(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L));
        GTModHandler.removeFurnaceSmelting(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L));
        GTModHandler.removeFurnaceSmelting(getModItem(IndustrialCraft2.ID, "itemDust", 1, 11, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(IndustrialCraft2.ID, "itemPlates", 1, 7, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Railcraft.ID, "dust", 1, 0, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(TwilightForest.ID, "tile.GiantObsidian", 1, wildcard, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(Railcraft.ID, "machine.beta", 1, 10, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(EnderIO.ID, "itemPowderIngot", 1, 7, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7, missing));
        GTModHandler.removeFurnaceSmelting(ItemList.Conveyor_Module_LV.get(1L));
        GTModHandler.removeFurnaceSmelting(getModItem(TinkerConstruct.ID, "materials", 1, 36, missing));
        GTModHandler.removeFurnaceSmelting(ItemList.Automation_ItemDistributor_ULV.get(1L));
        GTModHandler.removeFurnaceSmelting(ItemList.Automation_ItemDistributor_LV.get(1L));
        GTModHandler.removeFurnaceSmelting(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 0, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 2, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(TinkerConstruct.ID, "materials", 1, 39, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(TinkerConstruct.ID, "materials", 1, 38, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(TinkerConstruct.ID, "materials", 1, 41, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(TinkerConstruct.ID, "materials", 1, 42, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(TinkerConstruct.ID, "SearedBrick", 1, 5, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(TinkerConstruct.ID, "GravelOre", 1, 4, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(TinkerConstruct.ID, "materials", 1, 40, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 1, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6, missing));
        GTModHandler.removeFurnaceSmelting(getModItem(TwilightForest.ID, "item.ironwoodRaw", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(AE2Stuff.ID, "Encoder", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(AE2Stuff.ID, "Grower", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(AE2Stuff.ID, "Inscriber", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(AE2Stuff.ID, "Wireless", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(AE2Stuff.ID, "WirelessKit", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(AE2Stuff.ID, "Visualiser", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(AdvancedSolarPanel.ID, "BlockMolecularTransformer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(AdvancedSolarPanel.ID, "advanced_solar_helmet", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(AdvancedSolarPanel.ID, "hybrid_solar_helmet", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(AdvancedSolarPanel.ID, "ultimate_solar_helmet", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(AkashicTome.ID, "tome", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Automagy.ID, "blockHourglass", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Avaritia.ID, "Double_Craft", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Avaritia.ID, "Triple_Craft", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Avaritia.ID, "Resource", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Avaritia.ID, "Resource", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Avaritia.ID, "Dire_Crafting", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Avaritia.ID, "Crystal_Matrix", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Avaritia.ID, "Resource_Block", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Avaritia.ID, "Resource_Block", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Avaritia.ID, "Resource", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Avaritia.ID, "Resource", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Avaritia.ID, "Resource", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Avaritia.ID, "Resource", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(Avaritia.ID, "Resource", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(EternalSingularity.ID, "combined_singularity", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Backpack.ID, "backpack", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Backpack.ID, "workbenchbackpack", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Backpack.ID, "boundLeather", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BetterBuildersWands.ID, "wandStone", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BetterBuildersWands.ID, "wandIron", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BetterBuildersWands.ID, "wandDiamond", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(QuestBook.ID, "ItemQuestBook", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BinnieCore.ID, "fieldKit", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(BiomesOPlenty.ID, "gemOre", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(BiomesOPlenty.ID, "gems", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(BiomesOPlenty.ID, "jarEmpty", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BiomesOPlenty.ID, "dartBlower", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BiomesOPlenty.ID, "dart", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BiomesOPlenty.ID, "scytheDiamond", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BiomesOPlenty.ID, "ash", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "coal", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BiomesOPlenty.ID, "gems", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(BiomesOPlenty.ID, "gemOre", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(BiomesOPlenty.ID, "gemOre", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(BiomesOPlenty.ID, "gemOre", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_infused_iron", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_infused_planks", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_infused_stick", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_stained_glass", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_stained_ice", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_stained_ice_packed", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_infused_glowstone", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_lamp", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "life_infuser", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "lp_materializer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "compacter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_infused_pickaxe_wood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_infused_axe_wood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_infused_shovel_wood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_infused_sword_wood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_infused_pickaxe_iron", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_infused_axe_iron", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_infused_shovel_iron", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_infused_sword_iron", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_infused_pickaxe_diamond", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_infused_axe_diamond", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_infused_shovel_diamond", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_infused_sword_diamond", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_diamond", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_money", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_money", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_money", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "life_imbued_helmet", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "life_imbued_chestplate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "life_imbued_leggings", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "life_imbued_boots", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "transparent_orb", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "sigil_of_augmented_holding", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "sigil_of_lightning", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "sigil_of_swimming", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "sigil_of_ender", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "sigil_of_divinity", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "self_sacrifice_amulet", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "sacrifice_amulet", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "empowered_sacrifice_amulet", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "empowered_self_sacrifice_amulet", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "glass_sacrificial_dagger", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "glass_dagger_of_sacrifice", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "vampire_ring", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "Altar", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "sacrificialKnife", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_stone", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "blockWritingTable", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "waterSigil", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "lavaSigil", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_stone", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_stone", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_stone", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27, missing));
        removeRecipeByOutputDelayed(getModItem(BloodArsenal.ID, "blood_stone", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "divinationSigil", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "speedRune", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "ritualStone", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "masterStone", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "largeBloodStoneBrick", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "blockHomHeart", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "lavaCrystal", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "runeOfSacrifice", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "runeOfSelfSacrifice", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "airSigil", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "sigilOfTheFastMiner", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "growthSigil", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "voidSigil", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "itemBloodPack", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "emptySocket", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "armourForge", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "sigilOfElementalAffinity", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "sigilOfHolding", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "sigilOfTheBridge", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "sigilOfMagnetism", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "itemBloodLightSigil", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "seerSigil", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "imperfectRitualStone", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "ritualDismantler", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 32, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "blockTeleposer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "reinforcedTelepositionFocus", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "demonicTelepositionFocus", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "energyBazooka", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "blockPedestal", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "blockPlinth", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "blockAlchemicCalcinator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "itemAttunedCrystal", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "itemDestinationClearer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "itemTankSegmenter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "blockCrystalBelljar", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "blockReagentConduit", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "blockCrystal", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "blockStabilityGlyph", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "blockEnchantmentGlyph", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "blockEnchantmentGlyph", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 31, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 18, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 19, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 20, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 21, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 22, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 23, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 24, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 26, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 14, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "itemKeyOfDiablo", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "armourInhibitor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "inputRoutingFocus", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "outputRoutingFocus", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "outputRoutingFocus", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "outputRoutingFocus", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "outputRoutingFocus", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "inputRoutingFocus", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "sigilOfHaste", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "sigilOfWind", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "sigilOfSupression", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "sigilOfEnderSeverance", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "itemHarvestSigil", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "itemCompressionSigil", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "blockCrucible", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "blockConduit", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(BloodMagic.ID, "bloodMagicIncenseItem", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellParadigm", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellParadigm", 1, 1, missing));
        removeRecipeByOutputDelayed(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellParadigm", 1, 2, missing));
        removeRecipeByOutputDelayed(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellParadigm", 1, 3, missing));
        removeRecipeByOutputDelayed(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellModifier", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellModifier", 1, 1, missing));
        removeRecipeByOutputDelayed(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellModifier", 1, 2, missing));
        removeRecipeByOutputDelayed(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellModifier", 1, 3, missing));
        removeRecipeByOutputDelayed(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellEffect", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellEffect", 1, 1, missing));
        removeRecipeByOutputDelayed(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellEffect", 1, 2, missing));
        removeRecipeByOutputDelayed(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellEffect", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Botany.ID, "trowelWood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Botany.ID, "trowelStone", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Botany.ID, "trowelIron", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Botany.ID, "trowelGold", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Botany.ID, "trowelDiamond", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Botany.ID, "insulatedTube", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Botany.ID, "soilMeter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "blockCarpentersCollapsibleBlock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "itemCarpentersChisel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "itemCarpentersHammer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "blockCarpentersSafe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "blockCarpentersDaylightSensor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "itemCarpentersBed", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "blockCarpentersTorch", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "blockCarpentersGarageDoor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "blockCarpentersLadder", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "blockCarpentersBarrier", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "blockCarpentersPressurePlate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "blockCarpentersButton", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "blockCarpentersFlowerPot", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "blockCarpentersGate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "blockCarpentersHatch", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "blockCarpentersLever", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "blockCarpentersSlope", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "blockCarpentersStairs", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "itemCarpentersTile", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CarpentersBlocks.ID, "itemCarpentersDoor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CatWalks.ID, "support_column", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CatWalks.ID, "sturdy_rail_powered", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CatWalks.ID, "cagedLadder_north_unlit", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CatWalks.ID, "scaffold", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CatWalks.ID, "sturdy_rail_detector", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CatWalks.ID, "catwalk_unlit", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CatWalks.ID, "sturdy_rail", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CatWalks.ID, "sturdy_rail_activator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CatWalks.ID, "ropeLight", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CatWalks.ID, "steelgrate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CatWalks.ID, "blowtorch", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Chisel.ID, "chisel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Chisel.ID, "obsidianChisel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Chisel.ID, "diamondChisel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Chisel.ID, "netherStarChisel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Chisel.ID, "cloudinabottle", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Chisel.ID, "ballomoss", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Chisel.ID, "smashingrock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Chisel.ID, "autoChisel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Chisel.ID, "upgrade", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Chisel.ID, "upgrade", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Chisel.ID, "upgrade", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Chisel.ID, "upgrade", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Chisel.ID, "voidstone2", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CompactKineticGenerators.ID, "BlockCkg", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CompactKineticGenerators.ID, "BlockCkg", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(CompactKineticGenerators.ID, "BlockCkg", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(CompactKineticGenerators.ID, "BlockCkg", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(CompactKineticGenerators.ID, "BlockCkg", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(CompactKineticGenerators.ID, "BlockCkg", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(CompactKineticGenerators.ID, "BlockCkg", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(CompactKineticGenerators.ID, "BlockCkg", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(CompactKineticGenerators.ID, "BlockCkg", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(CompactKineticGenerators.ID, "BlockCkg", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(CompactKineticGenerators.ID, "BlockCkg", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(CompactKineticGenerators.ID, "BlockCkg", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(CompactKineticGenerators.ID, "IridiumBlade", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(CompactKineticGenerators.ID, "IridiumRotor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(DraconicEvolution.ID, "dissEnchanter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(ElectroMagicTools.ID, "DiamondChainsaw", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(ElectroMagicTools.ID, "FeatherWing", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(ElectroMagicTools.ID, "Omnitool", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockStirlingGenerator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockCombustionGenerator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockZombieGenerator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockFrankenzombieGenerator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockEnderGenerator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockSolarPanel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockSolarPanel", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockSolarPanel", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockSagMill", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockAlloySmelter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockCapBank", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockPainter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockCrafter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockVat", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockPowerMonitor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockFarmStation", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockWirelessCharger", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockTank", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockTank", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockReservoir", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockVacuumChest", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockTransceiver", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockBuffer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockBuffer", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockBuffer", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockInventoryPanel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMachinePart", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMaterial", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemGrindingBall", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemGrindingBall", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemGrindingBall", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemGrindingBall", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemGrindingBall", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemGrindingBall", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemGrindingBall", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemGrindingBall", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemGrindingBall", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "item.endSteel_helmet", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "item.endSteel_chestplate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "item.endSteel_leggings", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "item.endSteel_boots", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "item.endSteel_pickaxe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "item.endSteel_axe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "item.endSteel_sword", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMaterial", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockEnderIo", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockTravelAnchor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockTelePad", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockSliceAndSplice", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockSoulBinder", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockPoweredSpawner", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockKillerJoe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockAttractor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockSpawnGuard", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockExperienceObelisk", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockWeatherObelisk", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockEnchanter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockDarkSteelPressurePlate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockDarkSteelPressurePlate", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockDarkSteelAnvil", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockSoulariumBars", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockEndSteelBars", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockDarkSteelLadder", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockElectricLight", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockElectricLight", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockElectricLight", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockElectricLight", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockElectricLight", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockElectricLight", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "blockReinforcedObsidian", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemCoordSelector", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemFusedQuartzFrame", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemConduitFacade", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemConduitFacade", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemPowerConduit", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemPowerConduit", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemPowerConduit", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemItemConduit", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemLimitedItemFilter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemExistingItemFilter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemModItemFilter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBigFilterUpgrade", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemBigFilterUpgrade", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemPowerItemFilter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemFunctionUpgrade", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemYetaWrench", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemConduitProbe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemTravelStaff", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemXpTransfer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemSoulVessel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemGliderWing", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemGliderWing", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMagnet", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemOCConduit", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMachinePart", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMachinePart", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMaterial", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMaterial", 1, 14, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMaterial", 1, 15, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMaterial", 1, 16, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "itemMaterial", 1, 17, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "item.darkSteel_shears", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "item.stellar_pickaxe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "item.stellar_axe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "item.stellar_sword", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "item.stellar_helmet", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "item.stellar_chestplate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "item.stellar_leggings", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(EnderIO.ID, "item.stellar_boots", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraBees.ID, "alveary", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraBees.ID, "alveary", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraBees.ID, "alveary", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraBees.ID, "alveary", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraBees.ID, "alveary", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraBees.ID, "alveary", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraBees.ID, "alveary", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraBees.ID, "hiveFrame.cage", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraBees.ID, "hiveFrame.clay", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraBees.ID, "hiveFrame.cocoa", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraBees.ID, "hiveFrame.soul", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraBees.ID, "hiveFrame.clay", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraBees.ID, "hiveFrame.cocoa", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraBees.ID, "hiveFrame.cage", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraBees.ID, "hiveFrame.soul", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "machine", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "machine", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "machine", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "machine", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "machine", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "machine", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "machine", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "machine", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "misc", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "hammer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "durableHammer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "misc", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "misc", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "misc", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "misc", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "misc", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "misc", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "misc", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "misc", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "door", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "gate", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "fence", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraTrees.ID, "multifence", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "angelRing", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "angelRing", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "angelRing", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "angelRing", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "angelRing", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "enderQuarry", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "enderThermicPump", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "endMarker", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "curtains", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "timer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "enderQuarryUpgrade", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "drum", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "drum", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "block_bedrockium", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "angelBlock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "conveyor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "filing", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "filing", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "watering_can", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "magnumTorch", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "sound_muffler", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "sound_muffler", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "pipes", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "pipes", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "pipes", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "pipes", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "pipes.1", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "pipes", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "pipes", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "pipes", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "pipes", 1, 14, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "extractor_base_remote", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "extractor_base_remote", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "extractor_base", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "extractor_base", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "extractor_base", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "extractor_base", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 14, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 15, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "trashcan", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "trashcan", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "trashcan", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 14, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "dark_portal", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "dark_portal", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "chestFull", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "chestMini", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "enderCollector", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "endConstructor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "endConstructor", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "budoff", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "budoff", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "chandelier", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "trading_post", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "spike_base_wood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "spike_base", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "spike_base_gold", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "spike_base_diamond", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "generator", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "generator.8", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "generator.64", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "heatingElement", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "nodeUpgrade", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "golden_lasso", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "scanner", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "builderswand", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "creativebuilderswand", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "shears", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "ethericsword", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "lawSword", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "erosionShovel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "destructionpickaxe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "defoliageAxe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ExtraUtilities.ID, "temporalHoe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(FloodLights.ID, "electricFloodlight", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(FloodLights.ID, "carbonFloodlight", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(FloodLights.ID, "uvFloodlight", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(FloodLights.ID, "rawFilament", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(FloodLights.ID, "carbonDissolver", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(FloodLights.ID, "carbonLantern", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(FloodLights.ID, "mantle", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(FloodLights.ID, "growLight", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ForbiddenMagic.ID, "RidingCrop", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ForbiddenMagic.ID, "WandCaps", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "core", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "factory", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "factory", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "factory", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "factory", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "factory", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "factory", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "factory", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "factory", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "factory2", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "factory2", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "factory2", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "mail", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "mail", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "mulch", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "engine", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "ffarm", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "ffarm", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "ffarm", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "ffarm", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "ffarm", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "bronzePickaxe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "kitPickaxe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "bronzeShovel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "kitShovel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "infuser", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "canEmpty", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "waxCapsule", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "refractoryEmpty", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "gearBronze", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "gearCopper", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "gearTin", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "stamps", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "wrench", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "pipette", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "naturalistHelmet", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "soil", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "soil", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "craftingMaterial", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "fertilizerBio", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "fertilizerCompound", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "bituminousPeat", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "habitatLocator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "scoop", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "frameUntreated", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "waxCast", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "apiaristHelmet", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "apiaristChest", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "apiaristLegs", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "apiaristBoots", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "candle", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "honeyedSlice", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "ambrosia", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "honeyPot", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "letters", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "fencesFireproof", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "catalogue", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "apiaristBag", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "lepidopteristBag", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "minerBag", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "diggerBag", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "foresterBag", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "hunterBag", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "adventurerBag", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "builderBag", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "coinBag", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "apiculture", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "apiculture", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "apicultureChest", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "alveary", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "alveary", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "alveary", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "alveary", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "alveary", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "alveary", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "alveary", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "arboriculture", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "lepidopterology", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "fences", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Forestry.ID, "cart.beehouse", 1, wildcard, missing));
        removeRecipeByOutputDelayed(GregtechItemList.GT4_Thermal_Boiler.get(1));
        removeRecipeByOutputDelayed(new ItemStack(ModItems.itemPersonalCloakingDevice));
        removeRecipeByOutputDelayed(ItemList.Electric_Motor_UHV.get(1L));
        removeRecipeByOutputDelayed(ItemList.Electric_Pump_UHV.get(1L));
        removeRecipeByOutputDelayed(ItemList.Conveyor_Module_UHV.get(1L));
        removeRecipeByOutputDelayed(ItemList.Electric_Piston_UHV.get(1L));
        removeRecipeByOutputDelayed(ItemList.Robot_Arm_UHV.get(1L));
        removeRecipeByOutputDelayed(ItemList.Emitter_UHV.get(1L));
        removeRecipeByOutputDelayed(ItemList.Sensor_UHV.get(1L));
        removeRecipeByOutputDelayed(ItemList.Field_Generator_UHV.get(1L));
        removeRecipeByOutputDelayed(GregtechItemList.Industrial_WireFactory.get(1));
        removeRecipeByOutputDelayed(GregtechItemList.Boiler_Advanced_LV.get(1));
        removeRecipeByOutputDelayed(new ItemStack(ModItems.itemBoilerChassis, 1, 0));
        removeRecipeByOutputDelayed(GregtechItemList.Boiler_Advanced_MV.get(1));
        removeRecipeByOutputDelayed(new ItemStack(ModItems.itemBoilerChassis, 1, 1));
        removeRecipeByOutputDelayed(GregtechItemList.Boiler_Advanced_HV.get(1));
        removeRecipeByOutputDelayed(new ItemStack(ModItems.itemBoilerChassis, 1, 2));
        removeRecipeByOutputDelayed(GregtechItemList.GTFluidTank_HV.get(1));
        removeRecipeByOutputDelayed(new ItemStack(ModBlocks.blockCompressedObsidian, 1, 5));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "IndustrialApiary", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "MutagenProducer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "Mutatron", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "Imprinter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "Sampler", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "MutatronAdv", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "Liquifier", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "Extractor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "Transposer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "Replicator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "UpgradeFrame", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "Labware", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "MutagenTank", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "BeeReceptacle", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "PowerModule", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "EnvProcessor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "ApiaryUpgrade", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "IndustrialGrafter", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "IndustrialScoop", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "MutagenTank", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "BeeReceptacle", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "PowerModule", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "ClimateModule", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "EnvProcessor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "EjectCover", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "ImportCover", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Gendustry.ID, "ErrorSensorCover", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "misc", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "misc", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "misc", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "misc", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "misc", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "misc", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "misc", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "misc", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "misc", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "machine", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "machine", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "machine", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "machine", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "labMachine", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "labMachine", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "labMachine", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "labMachine", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "labMachine", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "advMachine", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "misc", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "misc", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "analyst", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Genetics.ID, "registry", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(GraviSuite.ID, "itemSimpleItem", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(GraviSuite.ID, "itemSimpleItem", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(GraviSuite.ID, "itemSimpleItem", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(GraviSuite.ID, "vajra", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(GraviSuite.ID, "itemSimpleItem", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(GraviSuite.ID, "advChainsaw", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(GraviSuite.ID, "advDDrill", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(GraviSuite.ID, "graviTool", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(GraviSuite.ID, "ultimateLappack", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(GraviSuiteNEO.ID, "epicLappack", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemRTGPellet", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemOreIridium", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicBases.ID, "resource", 1, 0, missing));
        removeRecipeByOutputDelayed(ItemList.Teleporter.get(1L));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "altar_nexus", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "essence_altar", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "void_chest", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "biome_compass", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "endium_ingot", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "obsidian_rod", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "ravaged_brick_slab", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "decomposition_table", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "experience_table", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "energy_extraction_table", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "accumulation_table", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "spectral_tear", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "energy_wand_core", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "energy_wand", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "spooky_log", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "spooky_leaves", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "blank_gem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "spatial_dash_gem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "transference_gem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "schorching_pickaxe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "charm_pouch", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 256, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 257, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 258, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 259, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 260, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 261, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 262, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 263, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 264, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 265, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(HardcoreEnderExpansion.ID, "curse", 1, 266, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "sink", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "market", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "spamcompressedsaltBlockalt", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "oven", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "mixingbowlItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "cuttingboardItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "mortarandpestleItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "bakewareItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "juicerItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "apiary", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "mortarandpestleItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "potItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "presser", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "skilletItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "saucepanItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "hardenedleatherhelmItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "hardenedleatherchestItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "hardenedleatherleggingsItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "hardenedleatherbootsItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "pamcandleDeco1", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "pamcandleDeco2", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "pamcandleDeco3", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "pamcandleDeco4", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "pamcandleDeco5", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "pamcandleDeco6", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "pamcandleDeco7", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "pamcandleDeco8", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "pamcandleDeco9", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "pamcandleDeco10", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "pamcandleDeco11", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "pamcandleDeco12", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "pamcandleDeco13", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "pamcandleDeco14", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "pamcandleDeco15", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "pamcandleDeco16", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "pamcandleDeco16", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "churn", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "quern", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "freshwaterItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "freshmilkItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "boiledeggItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "onionsoupItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "honeycombchocolatebarItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestTheNether.ID, "netherPlanks", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestTheNether.ID, "netherbedItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestTheNether.ID, "Quartz Sword", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestTheNether.ID, "Quartz Shovel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestTheNether.ID, "Quartz Pickaxe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestTheNether.ID, "Quartz Axe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestTheNether.ID, "Quartz Hoe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestTheNether.ID, "quartzhelmItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestTheNether.ID, "quartzchestItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestTheNether.ID, "quartzleggingsItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestTheNether.ID, "quartzbootsItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockReactorChamber", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockElectric", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockScaffold", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockIronScaffold", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMetal", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolMiningLaser", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockITNT", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "reactorPlating", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "reactorPlatingExplosive", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolCutter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemCable", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemCable", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemCable", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemCable", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemPartCoalChunk", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemPartCarbonMesh", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockAlloyGlass", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolIridiumDrill", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolWrenchElectric", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "windmeter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemwoodrotor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemironrotor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemsteelrotor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemwcarbonrotor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolWrench", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemupgradekit", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemFluidCell", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "reactorReflector", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "reactorVent", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "reactorVentCore", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "reactorVentGold", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "reactorVentSpread", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "reactorHeatSwitchCore", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "reactorCondensator", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "reactorCondensatorLap", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemTreetap", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemSteamTurbineBlade", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemSteamTurbine", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemIronBlockCuttingBlade", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemAdvIronBlockCuttingBlade", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemDiamondBlockCuttingBlade", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemBarrel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemMugEmpty", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemMugCoffee", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemMugCoffee", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemMugCoffee", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemBoat", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemBoat", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemBoat", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemDynamiteSticky", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemDynamite", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemWeedingTrowel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemCropnalyzer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolMEter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemScrapbox", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemPartCoalBall", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemPartCFPowder", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemDoorAlloy", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolPainterBlack", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolPainterRed", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolPainterGreen", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolPainterBrown", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolPainterBlue", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolPainterPurple", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolPainterCyan", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolPainterLightGrey", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolPainterDarkGrey", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolPainterPink", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolPainterLime", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolPainterYellow", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolPainterCloud", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolPainterMagenta", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolPainterOrange", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolPainterWhite", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemBatSU", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemRemote", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine", 1, 15, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemTFBP", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemTFBPCultivation", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemTFBPIrrigation", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemTFBPChilling", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemTFBPDesertification", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemTFBPFlatification", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemTFBPMushroom", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorHazmatChestplate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorHazmatLeggings", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorHazmatLeggings", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "reactorCoolantSimple", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "reactorCoolantTriple", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "reactorCoolantSix", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorRubBoots", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemStaticBoots", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockPersonal", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockCrop", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemFoamSprayer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorCFPack", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemArmorAlloyChestplate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemNanoSaber", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "obscurator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemScanner", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemScannerAdv", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemOreIridium", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemPlutonium", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemUran235small", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemUran235", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemLathingTool", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemTurningBlanksWood", 1, 209715, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemTurningBlanks", 1, 349525, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemContainmentbox", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemToolbox", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemPlutoniumSmall", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemMOX", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemUran", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockNuke", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockLuminatorDark", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockLuminator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine3", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockPersonal", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockPersonal", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine3", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine3", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine3", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine3", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine3", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 15, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 14, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMachine", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockChargepad", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockChargepad", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockChargepad", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockChargepad", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockreactorvessel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockReactorFluidPort", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockReactorAccessHatch", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockReactorRedstonePort", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 5, missing));
        removeRecipeByOutputDelayed(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1L));
        removeRecipeByOutputDelayed(GTOreDictUnificator.get(OrePrefixes.toolHeadSaw, Materials.Iridium, 1L));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemDust2", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(IndustrialCraft2.ID, "itemPartCFPowder", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "backpack.thaumaturgeT1", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "capsule.magic", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "capsule.void", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "miscResources", 1, 17, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "effectJar", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "miscResources", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "miscResources", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "miscResources", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "miscResources", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "miscResources", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "miscResources", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "magicApiary", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "frameMagic", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "frameResilient", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "frameGentle", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "frameMetabolic", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "frameNecrotic", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "frameTemporal", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "frameOblivion", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "miscResources", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "miscResources", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "miscResources", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "moonDial", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "magnet", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(MagicBees.ID, "magicbees.enchantedEarth", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "iron_trapdoor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "sliding_trapdoor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "player_sensor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "vanishing_block", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "vanishing_block", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "vanishing_block", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "vanishing_block", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "block_mixer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "door_factory", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "rustyHatch", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "garage_door", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.rustyHandle", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "rustyLadder", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.door_acacia", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.door_birch", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.door_dark_oak", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.door_jungle", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.door_spruce", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.wood_sliding_door", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.iron_sliding_door", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.jail_door", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.laboratory_door", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.factory_door", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.shoji_door", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.curtain_purple", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.curtain_yellow", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.curtain_magenta", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.curtain_pink", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.curtain_white", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.curtain_blue", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.curtain_gray", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.curtain_cyan", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.curtain_red", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.curtain_brown", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.curtain_lime", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.curtain_orange", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.curtain_silver", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.curtain_green", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.curtain_light_blue", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.curtain_black", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.saloon", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "item.forcefieldItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "acaciaFenceGate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "birchFenceGate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "darkOakFenceGate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "jungleFenceGate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "spruceFenceGate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "trapdoor_acacia", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "trapdoor_birch", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "trapdoor_dark_oak", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "trapdoor_jungle", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MalisisDoors.ID, "trapdoor_spruce", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkersMechworks.ID, "RedstoneMachine", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkersMechworks.ID, "RedstoneMachine", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(TinkersMechworks.ID, "RedstoneMachine", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(TinkersMechworks.ID, "RedstoneMachine", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkersMechworks.ID, "SignalBus", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkersMechworks.ID, "SignalTerminal", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkersMechworks.ID, "LengthWire", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkersMechworks.ID, "SpoolWire", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "chest", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "trapped_chest", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "furnace", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "bedrock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "dispenser", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "dropper", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "piston", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "sticky_piston", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "rail", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "golden_rail", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "detector_rail", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "activator_rail", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "noteblock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "jukebox", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "bookshelf", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "mossy_cobblestone", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stonebrick", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "lit_pumpkin", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "trapdoor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "torch", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "lever", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stone_button", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "glass_pane", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "ladder", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "fence", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "fence_gate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "enchanting_table", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "redstone_lamp", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "ender_chest", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "tripwire_hook", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "beacon", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "anvil", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "daylight_detector", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "hopper", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "book", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "bow", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "brick_block", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "saddle", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wool", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wool", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wool", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wool", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wool", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wool", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wool", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wool", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wool", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wool", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wool", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wool", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wool", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wool", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wool", 1, 14, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wool", 1, 15, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass", 1, 14, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass", 1, 15, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass_pane", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass_pane", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass_pane", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass_pane", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass_pane", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass_pane", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass_pane", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass_pane", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass_pane", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass_pane", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass_pane", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass_pane", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass_pane", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass_pane", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass_pane", 1, 14, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_glass_pane", 1, 15, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "carpet", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "carpet", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "carpet", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "carpet", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "carpet", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "carpet", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "carpet", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "carpet", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "carpet", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "carpet", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "carpet", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "carpet", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "carpet", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "carpet", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "carpet", 1, 14, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "carpet", 1, 15, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_hardened_clay", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_hardened_clay", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_hardened_clay", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_hardened_clay", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_hardened_clay", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_hardened_clay", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_hardened_clay", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_hardened_clay", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_hardened_clay", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_hardened_clay", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_hardened_clay", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_hardened_clay", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_hardened_clay", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_hardened_clay", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_hardened_clay", 1, 14, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stained_hardened_clay", 1, 15, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "sandstone", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "sandstone", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "sandstone", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "tnt", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "snow", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "clay", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "nether_brick", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "quartz_block", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "quartz_block", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "bookshelf", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "brewing_stand", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "clock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "compass", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stone_sword", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stone_shovel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stone_pickaxe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stone_axe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "stone_hoe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "diamond_sword", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "diamond_shovel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "diamond_pickaxe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "diamond_axe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "diamond_hoe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "diamond_helmet", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "diamond_chestplate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "diamond_leggings", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "diamond_boots", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "ender_eye", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "golden_apple", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "golden_apple", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "golden_carrot", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "cake", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "pumpkin_seeds", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "melon_seeds", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "fermented_spider_eye", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "magma_cream", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "fire_charge", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "melon_block", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "soul_sand", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "nether_brick_fence", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "name_tag", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "lead", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "pumpkin_pie", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "comparator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "repeater", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "skull", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "skull", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "skull", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "flower_pot", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "hay_block", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wheat", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "slime_ball", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "item_frame", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "bed", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "fishing_rod", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "poisonous_potato", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "sign", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "boat", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "painting", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "flint_and_steel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "dragon_egg", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "map", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wooden_door", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "iron_door", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "skull", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "shears", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "nether_star", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "wooden_door", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Minecraft.ID, "iron_door", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "planks", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "natura.stick", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "Natura.workbench", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "natura.flintandblaze", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "Natura.bookshelf", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "Natura.fence", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "plankSlab1", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "plankSlab2", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "pressureplate.eucalyptus", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "pressureplate.sakura", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "pressureplate.ghostwood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "pressureplate.redwood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "pressureplate.bloodwood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "pressureplate.hopseed", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "pressureplate.maple", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "pressureplate.amaranth", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "pressureplate.silverbell", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "pressureplate.tiger", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "pressureplate.willow", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "pressureplate.darkwood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "pressureplate.fusewood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "NetherPressurePlate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "trapdoor.eucalyptus", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "trapdoor.sakura", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "trapdoor.ghostwood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "trapdoor.redwood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "trapdoor.bloodwood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "trapdoor.hopseed", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "trapdoor.maple", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "trapdoor.amaranth", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "trapdoor.silverbell", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "trapdoor.tiger", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "trapdoor.willow", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "trapdoor.darkwood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "trapdoor.fusewood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "button.eucalyptus", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "button.sakura", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "button.ghostwood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "button.redwood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "button.bloodwood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "button.hopseed", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "button.maple", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "button.amaranth", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "button.silverbell", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "button.tiger", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "button.willow", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "button.darkwood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "button.fusewood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "fenceGate.eucalyptus", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "fenceGate.sakura", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "fenceGate.ghostwood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "fenceGate.redwood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "fenceGate.bloodwood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "fenceGate.hopseed", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "fenceGate.maple", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "fenceGate.amaranth", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "fenceGate.silverbell", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "fenceGate.tiger", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "fenceGate.willow", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "fenceGate.darkwood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "fenceGate.fusewood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "natura.emptybowl", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "redwoodDoorItem", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "blackberryItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "blueberryItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(PamsHarvestCraft.ID, "raspberryItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "Blazerail", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "BrailPowered", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "BrailDetector", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "BrailActivator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "NetherFurnace", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "Obelisk", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "NetherButton", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "NetherLever", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "natura.bow.ghostwood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "natura.bow.bloodwood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "natura.bow.darkwood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "natura.bow.fusewood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Natura.ID, "barleyFood", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "blockNuclearControlLight", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "blockNuclearControlLight", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "ItemToolThermometer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "ItemToolDigitalThermometer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "ItemRemoteSensorKit", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "ItemEnergySensorKit", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "ItemMultipleSensorKit", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "ItemMultipleSensorKit", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "ItemMultipleSensorKit", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "KitAppeng", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "ItemTimeCard", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "ItemUpgrade", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "ItemUpgrade", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "ItemTextCard", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "networkLink", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "remoteMonitor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(IC2NuclearControl.ID, "ItemVanilliaKit", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "hangglider", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "generic", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "luggage", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "autoenchantmenttable", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "autoanvil", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "xpdrain", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "path", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "fan", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "elevator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "vacuumhopper", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "sprinkler", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "guide", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "builder_guide", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "blockPlacer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "blockbreaker", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "itemDropper", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "sleepingBag", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "ropeladder", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "ladder", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "beartrap", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "cannon", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "sponge", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "goldenegg", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "village_highlighter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "sky", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "sky", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "projector", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "paintmixer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "canvas", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "xpbottler", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "generic", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "generic", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "drawingtable", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "imaginary", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "imaginary", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "xpshower", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "scaffolding", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "craneControl", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "generic", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "generic", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "generic", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "generic", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "craneBackpack", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "generic", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "generic", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "emptyMap", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "generic", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "cartographer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "slimalyzer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "sonicglasses", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "devnull", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "pedometer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "tastyClay", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenBlocks.ID, "cursor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenGlasses.ID, "openglassesterminal", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenGlasses.ID, "openglasses", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "baseTierWood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "baseTierOneBlock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "baseTierTwoBlock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "baseTierThreeBlock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "baseTierFourBlock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "sensorTierOneItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "sensorTierTwoItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "sensorTierThreeItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "sensorTierFiveItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "sensorTierFourItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "chamberTierOne", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "chamberTierTwo", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "chamberTierThree", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "chamberTierFour", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "chamberTierFive", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "barrelTierOne", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "barrelTierTwo", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "barrelTierThree", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "barrelTierFour", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "barrelTierFive", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "disposeItemTurret", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "potatoCannonTurret", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "machineGunTurret", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "incendiaryTurret", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "grenadeTurret", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "relativisticTurret", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "rocketTurret", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "teleporterTurret", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "railGunTurret", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "laserTurret", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "hardWallTierOne", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "hardWallTierTwo", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "hardWallTierThree", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "hardWallTierFour", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "hardWallTierFive", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "fenceTierOne", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "fenceTierTwo", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "fenceTierThree", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "fenceTierFour", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "fenceTierFive", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "ioBus", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "expanderPowerTierOne", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "expanderPowerTierTwo", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "expanderPowerTierThree", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "expanderPowerTierFour", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "expanderPowerTierFive", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "expanderInvTierOne", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "expanderInvTierTwo", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "expanderInvTierThree", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "expanderInvTierFour", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "expanderInvTierFive", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "leverBlock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "bulletCraftable", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "blazingClayCraftable", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "grenadeCraftable", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "rocketCraftable", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "ferroSlug", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "accuraccyUpgradeItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "fireRateUpgradeItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "rangeUpgradeItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "scattershotUpgradeItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "efficiencyUpgradeItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "damageAmpAddon", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "solarPanelAddon", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "serialPortAddon", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "concealerAddon", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "recyclerAddon", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "potentiaAddon", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(OpenModularTurrets.ID, "redstoneReactorAddon", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine1", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine1", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 5, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.solar_panel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedExpansion.ID, "projectred.expansion.battery", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 56, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.stone", 1, 11, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.backpack", 1, wildcard, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.barrel", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, wildcard, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.sawgold", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.sawruby", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.sawsapphire", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.sawperidot", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.rubyboots", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.rubychestplate", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.rubyhelmet", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.rubyleggings", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.sapphireboots", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.sapphirechestplate", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.sapphirehelmet", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.sapphireleggings", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.peridotboots", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.peridotchestplate", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.peridothelmet", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExploration.ID, "projectred.exploration.peridotleggings", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 41, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 42, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 43, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 40, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 15, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 57, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 58, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedExpansion.ID, "projectred.expansion.jetpack", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 19, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 20, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 21, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 22, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 23, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 24, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 25, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 26, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 27, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 28, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 29, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 30, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 31, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 32, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 33, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 34, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 44, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.screwdriver", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.wiredebugger", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedCore.ID, "projectred.core.datacard", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.electric_screwdriver", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 1, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 2, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 3, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 4, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 5, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 6, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 7, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 8, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 9, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 10, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 1, 1, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 1, 2, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 1, 3, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 1, 4, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 1, 5, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 1, 6, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 1, 7, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routingchip", 1, 8, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedTransportation.ID, "projectred.transportation.routerutil", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 9, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedFabrication.ID, "projectred.integration.icblock", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedFabrication.ID, "projectred.integration.icblock", 1, 1, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedFabrication.ID, "projectred.fabrication.icblueprint", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedFabrication.ID, "projectred.fabrication.icchip", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(MCFrames.ID, "mcframes.frame", 1, 0, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 10, missing));
        removeRecipeByOutputDelayed(
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(ProjectRedExpansion.ID, "projectred.expansion.plan", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "stair", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "stair", 1, 43, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "stair", 1, 40, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "stair", 1, 41, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "stair", 1, 42, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "stair", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "stair", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "lantern.stone", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "lantern.stone", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "lantern.stone", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "lantern.stone", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "lantern.stone", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "lantern.stone", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "lantern.stone", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "lantern.stone", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "lantern.stone", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "lantern.stone", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "lantern.metal", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "lantern.metal", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "lantern.metal", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "lantern.metal", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "lantern.metal", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "lantern.metal", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "cube", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "fuel.coke", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "cube", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "slab", 1, 38, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "cube", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "slab", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "anvil", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "track", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "track.elevator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "signal", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "signal", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "signal", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "signal", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "signal", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "signal", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "signal", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "signal", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "signal", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "signal", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "signal", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "signal", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "signal", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.railbed", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.railbed", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.rail", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.tie", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "detector", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "detector", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "detector", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "detector", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "detector", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "detector", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "detector", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "detector", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "detector", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "detector", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "detector", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "detector", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "detector", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "detector", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "detector", 1, 14, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "detector", 1, 15, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "detector", 1, 16, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "machine.gamma", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "machine.gamma", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "machine.gamma", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "machine.gamma", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "machine.gamma", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "machine.gamma", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "machine.gamma", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "machine.gamma", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "machine.gamma", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "machine.gamma", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "machine.epsilon", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "machine.epsilon", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "machine.epsilon", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "machine.epsilon", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "post", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "post", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "post", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "post", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "post", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.signal.lamp", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "glass", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.gear", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.gear", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.gear", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "part.gear", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "machine.alpha", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "brick.sandy", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "backpack.trackman.t1", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "backpack.iceman.t1", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "backpack.apothecary.t1", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "frame", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "tool.steel.shears", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "brick.infernal", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "upgrade.lapotron", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "cart.cargo", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "cart.track.relayer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "cart.undercutter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "cart.track.layer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "cart.track.remover", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "firestone.cut", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "firestone.refined", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "cart.redstone.flux", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "machine.gamma", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "machine.gamma", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(Railcraft.ID, "brick.bloodstained", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "onlineDetector", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "moonSensor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "bloodMoonSensor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "lapisLamp", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "imbuingStation", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "energyDistributor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "enderEnergyDistributor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "itemCollector", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "advancedItemCollector", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "dyeingMachine", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "playerinterface", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "filter", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "ingredient", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "fertilizedDirt", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "fluidDisplay", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "advancedFluidDisplay", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "wirelessLever", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "voidStone", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "dropFilter", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(RandomThings.ID, "spectreKey", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RemoteIO.ID, "tile.remote_interface", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RemoteIO.ID, "tile.machine", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RemoteIO.ID, "tile.machine", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(RemoteIO.ID, "skylight", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RemoteIO.ID, "intelligentWorkbench", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RemoteIO.ID, "item.wireless_transmitter", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RemoteIO.ID, "item.io_tool", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RemoteIO.ID, "item.blank_plate", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RemoteIO.ID, "item.chip.transfer", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(RemoteIO.ID, "item.chip.upgrade", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(RemoteIO.ID, "item.pda", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RemoteIO.ID, "item.remoteAccessor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(RemoteIO.ID, "item.linker", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(SGCraft.ID, "stargateRing", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(SGCraft.ID, "stargateRing", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(SGCraft.ID, "stargateBase", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(SGCraft.ID, "stargateController", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(SGCraft.ID, "naquadahBlock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(SGCraft.ID, "naquadahOre", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(SGCraft.ID, "ic2PowerUnit", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(SGCraft.ID, "rfPowerUnit", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(SGCraft.ID, "ocInterface", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(SGCraft.ID, "naquadahIngot", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(SGCraft.ID, "naquadah", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(SGCraft.ID, "sgChevronUpgrade", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(SGCraft.ID, "sgIrisUpgrade", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(SGCraft.ID, "sgIrisBlade", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(SGCraft.ID, "ic2Capacitor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "BlockCartAssembler", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "BlockCargoManager", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "BlockDistributor", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "BlockDetector", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "BlockActivator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "BlockDetector", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "BlockDetector", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "BlockDetector", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "BlockDetector", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "BlockAdvDetector", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "BlockJunction", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "BlockMetalStorage", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "BlockMetalStorage", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "BlockMetalStorage", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 22, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 47, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 49, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 23, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 82, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 37, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 38, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 39, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 81, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 42, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 43, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 20, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 83, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 84, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 44, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 45, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 56, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 69, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 70, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 58, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 30, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 32, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 34, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 37, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 39, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 14, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 84, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 15, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 79, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 80, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 61, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 62, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 63, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 21, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 22, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 23, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 24, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 51, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 52, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 53, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 58, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 88, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "BlockLiquidManager", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 24, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 29, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 26, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 48, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 33, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "upgrade", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "upgrade", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "upgrade", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "upgrade", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "upgrade", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "upgrade", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "upgrade", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "upgrade", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "upgrade", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "upgrade", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "upgrade", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "upgrade", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "upgrade", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "upgrade", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "upgrade", 1, 15, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "upgrade", 1, 16, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "upgrade", 1, 17, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "upgrade", 1, 18, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "upgrade", 1, 19, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 41, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 101, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 41, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 64, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 30, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 71, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 87, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 92, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 91, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 93, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 28, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 25, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 27, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 26, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 29, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 33, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 34, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 31, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 43, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 59, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 36, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 14, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 27, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 60, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 57, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 25, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 49, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 85, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 68, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 32, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 16, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 95, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 18, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 19, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 20, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 40, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 75, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 77, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 78, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 82, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 83, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 86, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 89, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 94, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "CartModule", 1, 99, missing));
        removeRecipeByOutputDelayed(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing));
        removeRecipeByOutputDelayed(getModItem(StevesAddons.ID, "cable_rf", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(StevesAddons.ID, "cable_ae", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(StevesAddons.ID, "duplicator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(StevesAddons.ID, "labeler", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TaintedMagic.ID, "ItemShadowmetalHoe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TaintedMagic.ID, "ItemShadowmetalPick", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TaintedMagic.ID, "ItemShadowmetalAxe", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TaintedMagic.ID, "ItemShadowmetalSpade", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TaintedMagic.ID, "ItemShadowmetalSword", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "blockCrystal", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "WandCap", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "WandCasting", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemResource", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "blockCandle", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemNugget", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemResource", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemNugget", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemThaumometer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "blockTable", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "blockCosmeticSlabStone", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "blockTaint", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemResource", 1, 16, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemNugget", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemAxeVoid", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemSwordVoid", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemPickVoid", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemShovelVoid", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemHoeVoid", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemHelmetVoid", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemChestplateVoid", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemLeggingsVoid", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Thaumcraft.ID, "ItemBootsVoid", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicBases.ID, "voidFAS", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicBases.ID, "voidShears", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicBases.ID, "quicksilverBlock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicEnergistics.ID, "wireless.essentia.terminal", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicEnergistics.ID, "part.base", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicEnergistics.ID, "part.base", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicEnergistics.ID, "storage.casing", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 10, missing));
        removeRecipeByOutputDelayed(
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.essentia.cell.workbench", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicExploration.ID, "blankSeal", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicTinkerer.ID, "shareBook", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicTinkerer.ID, "darkQuartzItem", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicTinkerer.ID, "darkQuartz", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicTinkerer.ID, "darkQuartz", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicTinkerer.ID, "darkQuartz", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicTinkerer.ID, "darkQuartzSlab", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "slime.gel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "slime.gel", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "LavaTank", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "LavaTankNether", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "Smeltery", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "helmetWood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "chestplateWood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "leggingsWood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "bootsWood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "Smeltery", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "Smeltery", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "Smeltery", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "Smeltery", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "heartCanister", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 25, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 26, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "toolRod", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "decoration.stoneladder", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "trap.punji", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 22, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "MeatBlock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "WoolSlab1", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "WoolSlab2", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SearedSlab", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SearedSlab", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SearedSlab", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SearedSlab", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SearedSlab", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SearedSlab", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SearedSlab", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "Smeltery", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SearedBlock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SearedBlockNether", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SearedBlock", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SearedBlockNether", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "CastingChannel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "CastingChannel", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SearedBlock", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SearedBlockNether", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "LavaTank", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "LavaTankNether", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "LavaTank", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "LavaTankNether", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 14, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 15, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 41, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 42, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 20, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 21, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 31, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 24, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 32, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 27, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 28, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 29, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 30, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 16, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 8, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 9, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 11, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 13, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 14, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 15, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "knapsack", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "travelGoggles", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "travelVest", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "travelGlove", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "travelWings", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "travelBelt", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "travelBoots", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "trap.barricade.oak", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "trap.barricade.spruce", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "trap.barricade.birch", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "trap.barricade.jungle", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "explosive.slime", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "slime.channel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "blood.channel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "slime.pad", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "rail.wood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "CraftingStation", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, wildcard, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "FurnaceSlab", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SpeedSlab", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SpeedSlab", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SpeedSlab", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SpeedSlab", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SpeedSlab", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SpeedSlab", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SpeedSlab", 1, 6, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "SpeedSlab", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "goldHead", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 5, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 14, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 15, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 18, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "diamondApple", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "heartCanister", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "heartCanister", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "heartCanister", 1, 4, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "materials", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 3, missing));
        removeRecipeByOutputDelayed(getModItem(TinkersDefence.ID, "AeonSteelIngot", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkersDefence.ID, "AeonSteelBlock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkersDefence.ID, "QueensGoldIngot", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkersDefence.ID, "QueensGoldBlock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkersDefence.ID, "DogbeariumIngot", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TinkersDefence.ID, "DogbeariumBlock", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TwilightForest.ID, "item.carminite", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(TwilightForest.ID, "item.emptyMagicMap", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TwilightForest.ID, "item.ironwoodRaw", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(TwilightForest.ID, "tile.TFUncraftingTable", 1, 0, missing));

        String[] materials = new String[] { "Twilight", "Canopy", "Mangrove", "Darkwood", "Time", "Trans", "Mine",
                "Sort" };
        for (int i = 0; i < materials.length; i++) {
            removeRecipeByOutputDelayed(getModItem(TwilightForest.ID, "tile.TFTrapDoor" + materials[i], 1, 0, missing));
            removeRecipeByOutputDelayed(getModItem(TwilightForest.ID, "item.door" + materials[i], 1, 0, missing));
        }

        removeRecipeByOutputDelayed(getModItem(WirelessRedstoneCBECore.ID, "obsidianStick", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(WirelessRedstoneCBECore.ID, "stoneBowl", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(WirelessRedstoneCBECore.ID, "retherPearl", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(WirelessRedstoneCBECore.ID, "wirelessTransceiver", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(WirelessRedstoneCBECore.ID, "blazeTransceiver", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(WirelessRedstoneCBECore.ID, "recieverDish", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(WirelessRedstoneCBECore.ID, "blazeRecieverDish", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(WirelessRedstoneCBELogic.ID, "wirelessLogic", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(WirelessRedstoneCBELogic.ID, "wirelessLogic", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(WirelessRedstoneCBELogic.ID, "wirelessLogic", 1, 2, missing));
        removeRecipeByOutputDelayed(getModItem(WirelessRedstoneCBEAddons.ID, "triangulator", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(WirelessRedstoneCBEAddons.ID, "remote", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(WirelessRedstoneCBEAddons.ID, "sniffer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(WirelessRedstoneCBEAddons.ID, "map", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(WirelessRedstoneCBEAddons.ID, "tracker", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(WirelessRedstoneCBEAddons.ID, "rep", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(WirelessRedstoneCBEAddons.ID, "psniffer", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "witchesovenidle", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "fumefunnel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "filteredfumefunnel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "ingredient", 1, 73, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "altar", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "ingredient", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "ingredient", 1, 1, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "kettle", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "arthana", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "ingredient", 1, 153, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "ingredient", 1, 16, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "ingredient", 1, 26, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "spinningwheel", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "distilleryidle", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "ingredient", 1, 140, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "ingredient", 1, 7, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "ingredient", 1, 81, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "ingredient", 1, 106, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "ingredient", 1, 127, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "ingredient", 1, 46, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "ingredient", 1, 107, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "cauldronbook", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "ingredient", 1, 47, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "ingredient", 1, 48, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "ingredient", 1, 49, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "chalkritual", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "circletalisman", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "earmuffs", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "ingredient", 1, 10, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "ingredient", 1, 92, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "ingredient", 1, 12, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "rubyslippers", 1, 0, missing));
        removeRecipeByOutputDelayed(getModItem(Witchery.ID, "snowpressureplate", 1, 0, missing));

        removeRecipeByOutputDelayed("nuggetLead");
        removeRecipeByOutputDelayed("nuggetSilver");
        removeRecipeByOutputDelayed("nuggetTin");
        removeRecipeByOutputDelayed("nuggetCopper");
        removeRecipeByOutputDelayed("nuggetSteel");
        removeRecipeByOutputDelayed("nuggetPulsatingIron");
        removeRecipeByOutputDelayed("nuggetVibrantAlloy");
        removeRecipeByOutputDelayed("nuggetDraconium");
        removeRecipeByOutputDelayed("nuggetDraconiumAwakened");
        removeRecipeByOutputDelayed("blockObsidian");
        removeRecipeByOutputDelayed("nuggetGold");
        removeRecipeByOutputDelayed("nuggetIron");
        removeRecipeByOutputDelayed("torchStone");

        removeRecipeShapelessDelayed(GTOreDictUnificator.get(OrePrefixes.gem, Materials.Ruby, 1L));
        removeRecipeShapelessDelayed(GTOreDictUnificator.get(OrePrefixes.gem, Materials.Sapphire, 1L));
        removeRecipeShapelessDelayed(getModItem(Minecraft.ID, "dye", 1, 4, missing));
        removeRecipeShapelessDelayed(
                getModItem(Minecraft.ID, "dye", 3, 15, missing),
                getModItem(BiomesOPlenty.ID, "bones", 1, 0, missing));
        removeRecipeShapelessDelayed(
                getModItem(Minecraft.ID, "dye", 6, 15, missing),
                getModItem(BiomesOPlenty.ID, "bones", 1, 1, missing));
        removeRecipeShapelessDelayed(
                getModItem(Minecraft.ID, "dye", 12, 15, missing),
                getModItem(BiomesOPlenty.ID, "bones", 1, 2, missing));
        removeRecipeShapelessDelayed(
                getModItem(BiomesOPlenty.ID, "misc", 1, 9, missing),
                getModItem(BiomesOPlenty.ID, "flowers", 1, 2, missing));
        removeRecipeShapelessDelayed(
                getModItem(BiomesOPlenty.ID, "misc", 1, 8, missing),
                getModItem(BiomesOPlenty.ID, "flowers", 1, 9, missing));
        removeRecipeShapelessDelayed(
                getModItem(BiomesOPlenty.ID, "misc", 1, 8, missing),
                getModItem(BiomesOPlenty.ID, "flowers2", 1, 1, missing));
        removeRecipeShapelessDelayed(
                getModItem(BiomesOPlenty.ID, "misc", 1, 5, missing),
                getModItem(BiomesOPlenty.ID, "flowers2", 1, 5, missing));
        removeRecipeShapelessDelayed(
                getModItem(BiomesOPlenty.ID, "misc", 1, 5, missing),
                getModItem(BiomesOPlenty.ID, "mushrooms", 1, 2, missing));
        removeRecipeShapelessDelayed(
                getModItem(BiomesOPlenty.ID, "misc", 1, 7, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing));
        removeRecipeShapelessDelayed(
                getModItem(BiomesOPlenty.ID, "misc", 1, 6, missing),
                getModItem(BiomesOPlenty.ID, "mushrooms", 1, 4, missing));
        removeRecipeShapelessDelayed(
                getModItem(BiomesOPlenty.ID, "misc", 1, 6, missing),
                getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing));
        removeRecipeShapelessDelayed(GTOreDictUnificator.get(OrePrefixes.gem, Materials.Ruby, 1L));
        removeRecipeShapelessDelayed(GTOreDictUnificator.get(OrePrefixes.gem, Materials.Sapphire, 1L));
        removeRecipeShapelessDelayed(getModItem(Minecraft.ID, "dye", 1, 4, missing));
        removeRecipeShapelessDelayed(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L));
        removeRecipeShapelessDelayed(GTOreDictUnificator.get(OrePrefixes.gem, Materials.Apatite, 1L));
        removeRecipeShapelessDelayed(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 1L));
        removeRecipeShapelessDelayed(GTOreDictUnificator.get(OrePrefixes.gem, Materials.Sapphire, 1L));
        removeRecipeShapelessDelayed(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L));
        removeRecipeShapelessDelayed(GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherStar, 1L));
        removeRecipeShapelessDelayed(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1L));
        removeRecipeShapelessDelayed(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Saltpeter, 1L));
        removeRecipeShapelessDelayed("dustEnderPearl");
        removeRecipeShapelessDelayed("gemEnderPearl");
        removeRecipeShapelessDelayed("dustEnderEye");
        removeRecipeShapelessDelayed("gemEnderEye");
        removeRecipeShapelessDelayed("dustRuby");
        removeRecipeShapelessDelayed("gemRuby");
        removeRecipeShapelessDelayed("dustSapphire");
        removeRecipeShapelessDelayed("gemSapphire");
        removeRecipeShapelessDelayed("dustGreenSapphire");
        removeRecipeShapelessDelayed("gemGreenSapphire");
        removeRecipeShapelessDelayed("dustOlivine");
        removeRecipeShapelessDelayed("gemOlivine");
        removeRecipeShapelessDelayed("dustTopaz");
        removeRecipeShapelessDelayed("gemTopaz");
        removeRecipeShapelessDelayed("dustTanzanite");
        removeRecipeShapelessDelayed("gemTanzanite");
        removeRecipeShapelessDelayed("dustAmethyst");
        removeRecipeShapelessDelayed("gemAmethyst");
        removeRecipeShapelessDelayed("dustJasper");
        removeRecipeShapelessDelayed("gemJasper");
        removeRecipeShapelessDelayed("dustGarnetYellow");
        removeRecipeShapelessDelayed("gemGarnetYellow");
        removeRecipeShapelessDelayed("dustGarnetRed");
        removeRecipeShapelessDelayed("gemGarnetRed");
        removeRecipeShapelessDelayed("dustForce");
        removeRecipeShapelessDelayed("gemForce");
        removeRecipeShapelessDelayed("dustForcillium");
        removeRecipeShapelessDelayed("gemForcillium");
        removeRecipeShapelessDelayed("dustForcicium");
        removeRecipeShapelessDelayed("gemForcicium");
        removeRecipeShapelessDelayed("dustDilithium");
        removeRecipeShapelessDelayed("gemDilithium");
        removeRecipeShapelessDelayed("dustAmber");
        removeRecipeShapelessDelayed("gemAmber");
        removeRecipeShapelessDelayed("dustFoolsRuby");
        removeRecipeShapelessDelayed("gemFoolsRuby");
        removeRecipeShapelessDelayed("dustBlueTopaz");
        removeRecipeShapelessDelayed("gemBlueTopaz");
        removeRecipeShapelessDelayed("dustMonazite");
        removeRecipeShapelessDelayed("gemMonazite");
        removeRecipeShapelessDelayed("dustQuartzite");
        removeRecipeShapelessDelayed("gemQuartzite");
        removeRecipeShapelessDelayed("dustLazurite");
        removeRecipeShapelessDelayed("gemLazurite");
        removeRecipeShapelessDelayed("dustSodalite");
        removeRecipeShapelessDelayed("gemSodalite");
        removeRecipeShapelessDelayed("dustNiter");
        removeRecipeShapelessDelayed("gemNiter");
        removeRecipeShapelessDelayed("dustTricalciumPhosphate");
        removeRecipeShapelessDelayed("gemTricalciumPhosphate");
        removeRecipeShapelessDelayed("dustLignite");
        removeRecipeShapelessDelayed("gemLignite");
        removeRecipeShapelessDelayed("dustInfusedEntropy");
        removeRecipeShapelessDelayed("gemInfusedEntropy");
        removeRecipeShapelessDelayed("dustInfusedOrder");
        removeRecipeShapelessDelayed("gemInfusedOrder");
        removeRecipeShapelessDelayed("dustVinteum");
        removeRecipeShapelessDelayed("gemVinteum");
        removeRecipeShapelessDelayed("dustInfusedAir");
        removeRecipeShapelessDelayed("gemInfusedAir");
        removeRecipeShapelessDelayed("dustInfusedFire");
        removeRecipeShapelessDelayed("gemInfusedFire");
        removeRecipeShapelessDelayed("dustInfusedEarth");
        removeRecipeShapelessDelayed("gemInfusedEarth");
        removeRecipeShapelessDelayed("dustInfusedWater");
        removeRecipeShapelessDelayed("gemInfusedWater");
        removeRecipeShapelessDelayed("dustCoal"/* ERRORSTACK <- itemcount */, "blockCoal");
        removeRecipeShapelessDelayed(
                getModItem(Minecraft.ID, "coal", 9, 1, missing),
                GTOreDictUnificator.get(OrePrefixes.block, Materials.Charcoal, 1L));
        removeRecipeShapelessDelayed(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 9L),
                GTOreDictUnificator.get(OrePrefixes.block, Materials.Charcoal, 1L));
        removeRecipeShapelessDelayed(getModItem(PamsHarvestCraft.ID, "cottonItem", 1, 0, missing));
        removeRecipeShapelessDelayed(
                getModItem(IndustrialCraft2.ID, "itemCofeePowder", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemCofeeBeans", 1, 0, missing));
        removeRecipeShapelessDelayed(getModItem(Thaumcraft.ID, "ItemShard", 1, 0, missing));
        removeRecipeShapelessDelayed(getModItem(Thaumcraft.ID, "ItemShard", 1, 1, missing));
        removeRecipeShapelessDelayed(getModItem(Thaumcraft.ID, "ItemShard", 1, 2, missing));
        removeRecipeShapelessDelayed(getModItem(Thaumcraft.ID, "ItemShard", 1, 3, missing));
        removeRecipeShapelessDelayed(getModItem(Thaumcraft.ID, "ItemShard", 1, 4, missing));
        removeRecipeShapelessDelayed(getModItem(Thaumcraft.ID, "ItemShard", 1, 5, missing));
        removeRecipeShapelessDelayed(getModItem(Minecraft.ID, "string", 1, 0, missing));
        removeRecipeShapelessDelayed(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1L));
        removeRecipeShapelessDelayed(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Emerald, 1L));
        removeRecipeShapelessDelayed(
                getModItem(Minecraft.ID, "gunpowder", 1, 0, missing),
                getModItem(Minecraft.ID, "coal", 1, 1, missing),
                getModItem(Minecraft.ID, "coal", 1, 1, missing),
                getModItem(Minecraft.ID, "coal", 1, 1, missing),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing));
        removeRecipeShapelessDelayed(
                getModItem(Minecraft.ID, "dye", 3, 15, missing),
                getModItem(Minecraft.ID, "bone", 1, 0, missing));
        removeRecipeShapelessDelayed(getModItem(Minecraft.ID, "nether_star", 1, 0, missing));
        removeRecipeShapelessDelayed(getModItem(Minecraft.ID, "sand", 1, 0, missing));
        removeRecipeShapelessDelayed(getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing));
        removeRecipeShapelessDelayed(getModItem(Minecraft.ID, "glass", 1, 0, missing));
        removeRecipeShapelessDelayed(
                getModItem(Natura.ID, "barleyFood", 1, 8, missing),
                getModItem(Natura.ID, "Bluebells", 1, 0, missing));
        removeRecipeShapelessDelayed(getModItem(Thaumcraft.ID, "ItemResource", 1, 6, missing));
        removeRecipeShapelessDelayed(
                getModItem(Thaumcraft.ID, "ItemInkwell", 1, 0, missing),
                getModItem(Minecraft.ID, "glass_bottle", 1, 0, missing),
                getModItem(Minecraft.ID, "feather", 1, 0, missing),
                "dyeBlack");
        removeRecipeShapelessDelayed(getModItem(TwilightForest.ID, "item.fieryIngot", 1, 0, missing));
        removeRecipeShapelessDelayed(
                getModItem(Witchery.ID, "ingredient", 1, 130, missing),
                getModItem(Witchery.ID, "ingredient", 1, 130, missing),
                getModItem(Minecraft.ID, "magma_cream", 1, 0, missing),
                getModItem(Minecraft.ID, "blaze_powder", 1, 0, missing));
        removeRecipeShapelessDelayed(
                "ingotThauminite",
                getModItem(ThaumicBases.ID, "resource", 1, 0, missing),
                getModItem(ThaumicBases.ID, "resource", 1, 0, missing),
                getModItem(ThaumicBases.ID, "resource", 1, 0, missing),
                getModItem(ThaumicBases.ID, "resource", 1, 0, missing),
                getModItem(ThaumicBases.ID, "resource", 1, 0, missing),
                getModItem(ThaumicBases.ID, "resource", 1, 0, missing),
                getModItem(ThaumicBases.ID, "resource", 1, 0, missing),
                getModItem(ThaumicBases.ID, "resource", 1, 0, missing),
                getModItem(ThaumicBases.ID, "resource", 1, 0, missing));

        removeRecipeShapedDelayed(getModItem(BinnieCore.ID, "storage", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(BinnieCore.ID, "storage", 1, 1, missing));
        removeRecipeShapedDelayed(getModItem(BinnieCore.ID, "storage", 1, 2, missing));
        removeRecipeShapedDelayed(getModItem(BinnieCore.ID, "storage", 1, 3, missing));
        removeRecipeShapedDelayed(getModItem(BinnieCore.ID, "storage", 1, 4, missing));
        removeRecipeShapedDelayed(getModItem(BinnieCore.ID, "storage", 1, 5, missing));
        removeRecipeShapedDelayed(
                getModItem(Minecraft.ID, "wheat", 1, 0, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "plants", 1, 6, missing),
                        getModItem(BiomesOPlenty.ID, "plants", 1, 6, missing),
                        getModItem(BiomesOPlenty.ID, "plants", 1, 6, missing) },
                new Object[0],
                new Object[0]);
        removeRecipeShapedDelayed(
                getModItem(EnderIO.ID, "itemAlloy", 1, 6, missing),
                new Object[] { "nuggetDarkSteel", "nuggetDarkSteel", "nuggetDarkSteel" },
                new Object[] { "nuggetDarkSteel", "nuggetDarkSteel", "nuggetDarkSteel" },
                new Object[] { "nuggetDarkSteel", "nuggetDarkSteel", "nuggetDarkSteel" });
        removeRecipeShapedDelayed(
                getModItem(EnderIO.ID, "itemAlloy", 1, 8, missing),
                new Object[] { getModItem(EnderIO.ID, "itemMaterial", 1, 11, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 11, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 11, missing) },
                new Object[] { getModItem(EnderIO.ID, "itemMaterial", 1, 11, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 11, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 11, missing) },
                new Object[] { getModItem(EnderIO.ID, "itemMaterial", 1, 11, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 11, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 11, missing) });
        removeRecipeShapedDelayed(
                getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing),
                new Object[] { getModItem(EnderIO.ID, "itemPowderIngot", 1, 5, missing),
                        getModItem(EnderIO.ID, "itemPowderIngot", 1, 5, missing),
                        getModItem(EnderIO.ID, "itemPowderIngot", 1, 5, missing) },
                new Object[] { getModItem(EnderIO.ID, "itemPowderIngot", 1, 5, missing),
                        getModItem(EnderIO.ID, "itemPowderIngot", 1, 5, missing),
                        getModItem(EnderIO.ID, "itemPowderIngot", 1, 5, missing) },
                new Object[] { getModItem(EnderIO.ID, "itemPowderIngot", 1, 5, missing),
                        getModItem(EnderIO.ID, "itemPowderIngot", 1, 5, missing),
                        getModItem(EnderIO.ID, "itemPowderIngot", 1, 5, missing) });
        removeRecipeShapedDelayed(
                getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing),
                new Object[] { null, getModItem(EnderZoo.ID, "enderFragment", 1, 0, missing), null },
                new Object[] { getModItem(EnderZoo.ID, "enderFragment", 1, 0, missing),
                        getModItem(EnderZoo.ID, "enderFragment", 1, 0, missing),
                        getModItem(EnderZoo.ID, "enderFragment", 1, 0, missing) },
                new Object[] { null, getModItem(EnderZoo.ID, "enderFragment", 1, 0, missing), null });
        removeRecipeShapedDelayed(
                getModItem(ExtraUtilities.ID, "unstableingot", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing) },
                new Object[] { getModItem(ExtraUtilities.ID, "divisionSigil", 1, 0, missing) },
                new Object[] { getModItem(Minecraft.ID, "diamond", 1, 0, missing) });
        removeRecipeShapedDelayed(
                getModItem(ForbiddenMagic.ID, "FMResource", 9, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "emerald", 1, 0, missing) },
                new Object[0],
                new Object[0]);
        removeRecipeShapedDelayed(getModItem(ForbiddenMagic.ID, "FMResource", 2, 1, missing));
        removeRecipeShapedDelayed(getModItem(Gendustry.ID, "GeneSampleBlank", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(Gendustry.ID, "GeneTemplate", 1, 0, missing));
        removeRecipeShapedDelayed(
                GTOreDictUnificator.get(OrePrefixes.gem, Materials.Apatite, 1L),
                new Object[] { getModItem(MagicBees.ID, "beeNugget", 1, 7), getModItem(MagicBees.ID, "beeNugget", 1, 7),
                        getModItem(MagicBees.ID, "beeNugget", 1, 7) },
                new Object[] { getModItem(MagicBees.ID, "beeNugget", 1, 7), getModItem(MagicBees.ID, "beeNugget", 1, 7),
                        getModItem(MagicBees.ID, "beeNugget", 1, 7) },
                new Object[] { getModItem(MagicBees.ID, "beeNugget", 1, 7), getModItem(MagicBees.ID, "beeNugget", 1, 7),
                        getModItem(MagicBees.ID, "beeNugget", 1, 7) });
        removeRecipeShapedDelayed(
                "ingotSilver",
                new Object[] { "nuggetSilver", "nuggetSilver", "nuggetSilver" },
                new Object[] { "nuggetSilver", "nuggetSilver", "nuggetSilver" },
                new Object[] { "nuggetSilver", "nuggetSilver", "nuggetSilver" });
        removeRecipeShapedDelayed(
                "ingotLead",
                new Object[] { "nuggetLead", "nuggetLead", "nuggetLead" },
                new Object[] { "nuggetLead", "nuggetLead", "nuggetLead" },
                new Object[] { "nuggetLead", "nuggetLead", "nuggetLead" });
        removeRecipeShapedDelayed(
                "ingotDraconium",
                new Object[] { "nuggetDraconium", "nuggetDraconium", "nuggetDraconium" },
                new Object[] { "nuggetDraconium", "nuggetDraconium", "nuggetDraconium" },
                new Object[] { "nuggetDraconium", "nuggetDraconium", "nuggetDraconium" });
        removeRecipeShapedDelayed(
                "ingotDraconiumAwakened",
                new Object[] { "nuggetDraconiumAwakened", "nuggetDraconiumAwakened", "nuggetDraconiumAwakened" },
                new Object[] { "nuggetDraconiumAwakened", "nuggetDraconiumAwakened", "nuggetDraconiumAwakened" },
                new Object[] { "nuggetDraconiumAwakened", "nuggetDraconiumAwakened", "nuggetDraconiumAwakened" });
        removeRecipeShapedDelayed(
                "ingotVibrantAlloy",
                new Object[] { "nuggetVibrantAlloy", "nuggetVibrantAlloy", "nuggetVibrantAlloy" },
                new Object[] { "nuggetVibrantAlloy", "nuggetVibrantAlloy", "nuggetVibrantAlloy" },
                new Object[] { "nuggetVibrantAlloy", "nuggetVibrantAlloy", "nuggetVibrantAlloy" });
        removeRecipeShapedDelayed(
                "ingotPulsatingIron",
                new Object[] { "nuggetPulsatingIron", "nuggetPulsatingIron", "nuggetPulsatingIron" },
                new Object[] { "nuggetPulsatingIron", "nuggetPulsatingIron", "nuggetPulsatingIron" },
                new Object[] { "nuggetPulsatingIron", "nuggetPulsatingIron", "nuggetPulsatingIron" });
        removeRecipeShapedDelayed(getModItem(Minecraft.ID, "stone_button", 1, 0, missing));
        removeRecipeShapedDelayed(
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                new Object[] { "cropCotton", "cropCotton", "cropCotton" },
                new Object[0],
                new Object[0]);
        removeRecipeShapedDelayed(getModItem(Minecraft.ID, "speckled_melon", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(Minecraft.ID, "stone_slab", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(Minecraft.ID, "stone_slab", 1, 1, missing));
        removeRecipeShapedDelayed(getModItem(Minecraft.ID, "stone_slab", 1, 3, missing));
        removeRecipeShapedDelayed(getModItem(Minecraft.ID, "stone_slab", 1, 4, missing));
        removeRecipeShapedDelayed(getModItem(Minecraft.ID, "stone_slab", 1, 5, missing));
        removeRecipeShapedDelayed(getModItem(Minecraft.ID, "stone_slab", 1, 6, missing));
        removeRecipeShapedDelayed(getModItem(Minecraft.ID, "stone_slab", 1, 7, missing));
        removeRecipeShapedDelayed(getModItem(Minecraft.ID, "bookshelf", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(Minecraft.ID, "packed_ice", 4, 0, missing));
        removeRecipeShapedDelayed(
                getModItem(Minecraft.ID, "gunpowder", 1, 0, missing),
                new Object[] { getModItem(Natura.ID, "barleyFood", 1, 4, missing),
                        getModItem(Natura.ID, "barleyFood", 1, 4, missing), null },
                new Object[] { getModItem(Natura.ID, "barleyFood", 1, 4, missing),
                        getModItem(Natura.ID, "barleyFood", 1, 4, missing), null },
                new Object[0]);
        removeRecipeShapedDelayed(getModItem(Minecraft.ID, "chest_minecart", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(Minecraft.ID, "furnace_minecart", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(Minecraft.ID, "hopper_minecart", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(Minecraft.ID, "tnt_minecart", 1, 0, missing));
        removeRecipeShapedDelayed(
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing),
                new Object[] { "nuggetIron", "nuggetIron", "nuggetIron" },
                new Object[] { "nuggetIron", "nuggetIron", "nuggetIron" },
                new Object[] { "nuggetIron", "nuggetIron", "nuggetIron" });
        removeRecipeShapedDelayed("nuggetIron");
        removeRecipeShapedDelayed(
                getModItem(Minecraft.ID, "gold_ingot", 1, 0, missing),
                new Object[] { "nuggetGold", "nuggetGold", "nuggetGold" },
                new Object[] { "nuggetGold", "nuggetGold", "nuggetGold" },
                new Object[] { "nuggetGold", "nuggetGold", "nuggetGold" });
        removeRecipeShapedDelayed(
                getModItem(Minecraft.ID, "wooden_slab", 6, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "planks", 1, 0, missing),
                        getModItem(Minecraft.ID, "planks", 1, 0, missing),
                        getModItem(Minecraft.ID, "planks", 1, 0, missing) },
                new Object[0],
                new Object[0]);
        removeRecipeShapedDelayed(
                getModItem(Minecraft.ID, "blaze_powder", 1, 0, missing),
                new Object[] { getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 3, missing) },
                new Object[0],
                new Object[0]);
        removeRecipeShapedDelayed(
                getModItem(Minecraft.ID, "leather_helmet", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing) },
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), null,
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing) },
                new Object[0]);
        removeRecipeShapedDelayed(
                getModItem(Minecraft.ID, "leather_chestplate", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), null,
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing) },
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing) },
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing) });
        removeRecipeShapedDelayed(
                getModItem(Minecraft.ID, "leather_leggings", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing) },
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), null,
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing) },
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), null,
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing) });
        removeRecipeShapedDelayed(
                getModItem(Minecraft.ID, "leather_boots", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), null,
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing) },
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), null,
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing) },
                new Object[0]);
        removeRecipeShapedDelayed(
                getModItem(Minecraft.ID, "emerald", 1, 0, missing),
                new Object[] { getModItem(ForbiddenMagic.ID, "FMResource", 1, 0, missing),
                        getModItem(ForbiddenMagic.ID, "FMResource", 1, 0, missing),
                        getModItem(ForbiddenMagic.ID, "FMResource", 1, 0, missing) },
                new Object[] { getModItem(ForbiddenMagic.ID, "FMResource", 1, 0, missing),
                        getModItem(ForbiddenMagic.ID, "FMResource", 1, 0, missing),
                        getModItem(ForbiddenMagic.ID, "FMResource", 1, 0, missing) },
                new Object[] { getModItem(ForbiddenMagic.ID, "FMResource", 1, 0, missing),
                        getModItem(ForbiddenMagic.ID, "FMResource", 1, 0, missing),
                        getModItem(ForbiddenMagic.ID, "FMResource", 1, 0, missing) });
        removeRecipeShapedDelayed(
                getModItem(Minecraft.ID, "diamond", 1, 0, missing),
                new Object[] { getModItem(MagicBees.ID, "beeNugget", 1, 5, missing),
                        getModItem(MagicBees.ID, "beeNugget", 1, 5, missing),
                        getModItem(MagicBees.ID, "beeNugget", 1, 5, missing) },
                new Object[] { getModItem(MagicBees.ID, "beeNugget", 1, 5, missing),
                        getModItem(MagicBees.ID, "beeNugget", 1, 5, missing),
                        getModItem(MagicBees.ID, "beeNugget", 1, 5, missing) },
                new Object[] { getModItem(MagicBees.ID, "beeNugget", 1, 5, missing),
                        getModItem(MagicBees.ID, "beeNugget", 1, 5, missing),
                        getModItem(MagicBees.ID, "beeNugget", 1, 5, missing) });
        removeRecipeShapedDelayed(
                getModItem(Minecraft.ID, "paper", 2, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "reeds", 1, 0, missing),
                        getModItem(Minecraft.ID, "reeds", 1, 0, missing),
                        getModItem(Minecraft.ID, "reeds", 1, 0, missing) },
                new Object[0],
                new Object[0]);
        removeRecipeShapedDelayed(getModItem(Minecraft.ID, "sand", 1, 0, missing));
        removeRecipeShapedDelayed(
                getModItem(Minecraft.ID, "leather", 1, 0, missing),
                new Object[] { getModItem(Natura.ID, "barleyFood", 1, 6, missing),
                        getModItem(Natura.ID, "barleyFood", 1, 6, missing) },
                new Object[] { getModItem(Natura.ID, "barleyFood", 1, 6, missing),
                        getModItem(Natura.ID, "barleyFood", 1, 6, missing) },
                new Object[0]);
        removeRecipeShapedDelayed(getModItem(OpenBlocks.ID, "paintBrush", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(OpenBlocks.ID, "goldenEye", 1, wildcard, missing));
        removeRecipeShapedDelayed(getModItem(Railcraft.ID, "cart.energy.batbox", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(Railcraft.ID, "cart.energy.cesu", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(Railcraft.ID, "cart.energy.mfe", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(Railcraft.ID, "cart.tank", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(Railcraft.ID, "cart.anchor.personal", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(Railcraft.ID, "cart.anchor", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(Railcraft.ID, "cart.work", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(Railcraft.ID, "tool.electric.meter", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(Railcraft.ID, "armor.goggles", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(Railcraft.ID, "tool.magnifying.glass", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(Railcraft.ID, "tool.signal.tuner", 1, 0, missing));
        removeRecipeShapedDelayed(getModItem(Railcraft.ID, "tool.surveyor", 1, 0, missing));
        removeRecipeShapedDelayed(
                getModItem(Thaumcraft.ID, "ItemResource", 1, 6, missing),
                new Object[] { getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 0, missing) },
                new Object[0],
                new Object[0]);
        removeRecipeShapedDelayed(
                getModItem(Thaumcraft.ID, "ItemResource", 1, 6, missing),
                new Object[] { getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 1, missing) },
                new Object[0],
                new Object[0]);
        removeRecipeShapedDelayed(
                "ingotThaumium",
                new Object[] { "nuggetThaumium", "nuggetThaumium", "nuggetThaumium" },
                new Object[] { "nuggetThaumium", "nuggetThaumium", "nuggetThaumium" },
                new Object[] { "nuggetThaumium", "nuggetThaumium", "nuggetThaumium" });
        removeRecipeShapedDelayed(getModItem(ThaumicBases.ID, "crystalSlab", 1, wildcard, missing));
        removeRecipeShapedDelayed(getModItem(ThaumicBases.ID, "genericSlab", 1, wildcard, missing));
        removeRecipeShapedDelayed(
                "ingotTin",
                new Object[] { "nuggetTin", "nuggetTin", "nuggetTin" },
                new Object[] { "nuggetTin", "nuggetTin", "nuggetTin" },
                new Object[] { "nuggetTin", "nuggetTin", "nuggetTin" });
        removeRecipeShapedDelayed(
                "ingotCopper",
                new Object[] { "nuggetCopper", "nuggetCopper", "nuggetCopper" },
                new Object[] { "nuggetCopper", "nuggetCopper", "nuggetCopper" },
                new Object[] { "nuggetCopper", "nuggetCopper", "nuggetCopper" });
        removeRecipeShapedDelayed(
                "ingotSteel",
                new Object[] { "nuggetSteel", "nuggetSteel", "nuggetSteel" },
                new Object[] { "nuggetSteel", "nuggetSteel", "nuggetSteel" },
                new Object[] { "nuggetSteel", "nuggetSteel", "nuggetSteel" });
        removeRecipeShapedDelayed(
                "ingotBronze",
                new Object[] { "nuggetBronze", "nuggetBronze", "nuggetBronze" },
                new Object[] { "nuggetBronze", "nuggetBronze", "nuggetBronze" },
                new Object[] { "nuggetBronze", "nuggetBronze", "nuggetBronze" });
        removeRecipeShapedDelayed(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 1),
                new Object[] { getModItem(TinkerConstruct.ID, "materials", 1, 22, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 22, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 22, missing) },
                new Object[] { getModItem(TinkerConstruct.ID, "materials", 1, 22, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 22, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 22, missing) },
                new Object[] { getModItem(TinkerConstruct.ID, "materials", 1, 22, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 22, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 22, missing) });
        removeRecipeShapedDelayed(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 1),
                new Object[] { getModItem(TinkerConstruct.ID, "materials", 1, 12, missing), null, null },
                new Object[0],
                new Object[0]);

        flushBuffer();
        bufferMap = null;
        final long timeToLoad = System.currentTimeMillis() - timeStart;
        MainRegistry.Logger.info("Recipes removal took " + timeToLoad + " ms.");
    }
}
