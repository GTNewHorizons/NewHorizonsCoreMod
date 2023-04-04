package com.dreammaster.witchery;

import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.StevesCarts2;
import static com.dreammaster.witchery.WitcheryBrewRegistryAccessor.*;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;

import java.util.Arrays;
import java.util.EnumSet;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import alkalus.main.api.RecipeManager.Kettle;
import alkalus.main.api.RecipeManager.SpinningWheel;
import alkalus.main.api.plugin.base.BasePluginWitchery;

import com.emoniph.witchery.Witchery;
import com.emoniph.witchery.brewing.AltarPower;
import com.emoniph.witchery.brewing.BrewItemKey;
import com.emoniph.witchery.brewing.WitcheryBrewRegistry;
import com.emoniph.witchery.brewing.action.BrewAction;
import com.emoniph.witchery.brewing.action.BrewActionModifier;
import com.emoniph.witchery.brewing.action.BrewActionRitualRecipe;
import com.emoniph.witchery.crafting.KettleRecipes;
import com.emoniph.witchery.crafting.SpinningRecipes;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class WitcheryPlugin extends BasePluginWitchery {

    public WitcheryPlugin() {
        super(EnumSet.of(LoadPhase.INIT));
    }

    @Override
    public String getPluginName() {
        return "GTNH Witchery Plugin";
    }

    @Override
    public boolean preInit() {
        return true;
    }

    /**
     * Add a brew action for given stack. This action will do nothing upon added beyond consuming alter power This is
     * necessary for an item to be able to tossed into the cauldron.
     *
     * @param item  The stack that should be tossed into the cauldron, stack size does not matter
     * @param power The power to consume. Can be 0.
     */
    private static void ensureItemHaveBrewAction(ItemStack item, int power) {
        if (item != null && WitcheryBrewRegistry.INSTANCE.getActionForItemStack(item) == null) {
            registerBrewAction(new EmptyBrewActionModifier(item, power));
        }
    }

    /**
     * Add a brew recipe matching given items.
     *
     * @param lastItem The last item in the recipe, i.e. the recipe you used to complete the brew
     * @param items    items in recipe. order does not matter. DOES NOT INCLUDE lastItem!
     */
    private static void addBrewRecipe(int power, ItemStack result, ItemStack lastItem, ItemStack... items) {
        if (ingredient == null) return;
        final BrewItemKey key = BrewItemKey.fromStack(lastItem);
        BrewAction action = ingredient.get(key);
        if (action instanceof EmptyBrewActionModifier) {
            action = null;
        }
        // last item should not have a default action
        for (ItemStack item : items) {
            ensureItemHaveBrewAction(item, 0);
        }
        if (action == null) {
            registerBrewAction(
                    new BrewActionRitualRecipe(
                            key,
                            new AltarPower(power),
                            new BrewActionRitualRecipe.Recipe(result, items)));
        } else if (action instanceof BrewActionRitualRecipe) {
            final BrewActionRitualRecipe ritualRecipe = (BrewActionRitualRecipe) action;
            final BrewActionRitualRecipe.Recipe[] old = getRecipes(ritualRecipe);
            final BrewActionRitualRecipe.Recipe[] recipes = Arrays.copyOf(old, old.length + 1);
            recipes[recipes.length - 1] = new BrewActionRitualRecipe.Recipe(result, items);
            modifyBrewRecipe(ritualRecipe, recipes);
        } else {
            log.warn("Conflicting brew recipe! key: {}", lastItem);
        }
    }

    private static void removeAllBrewRecipes(ItemStack lastItem) {
        if (ingredient == null) return;
        final BrewItemKey key = BrewItemKey.fromStack(lastItem);
        final BrewAction action = ingredient.get(key);
        if (action == null) {
            log.warn("There is no brew using {} as last item", lastItem);
            return;
        }
        if (action instanceof BrewActionRitualRecipe) {
            removeAction((BrewActionRitualRecipe) action);
        } else {
            log.warn("There is no cauldron recipe matching using {} as last item:", lastItem);
        }
    }

    /**
     * Remove a brew recipe matching given items.
     *
     * @param lastItem The last item in the recipe, i.e. the recipe you used to complete the brew
     * @param items    items in recipe. order does not matter. DOES NOT INCLUDE lastItem!
     */
    private static void removeBrewRecipe(ItemStack lastItem, ItemStack... items) {
        if (ingredient == null) return;
        final BrewItemKey key = BrewItemKey.fromStack(lastItem);
        final BrewAction action = ingredient.get(key);
        if (action == null) {
            log.warn("There is no brew using {} as last item", lastItem);
            return;
        }
        if (action instanceof BrewActionRitualRecipe) {
            final BrewActionRitualRecipe ritualRecipe = (BrewActionRitualRecipe) action;
            for (BrewActionRitualRecipe.Recipe recipe : ritualRecipe.getExpandedRecipes()) {
                if (isCauldronRecipeMatch(recipe, lastItem, items)) {
                    if (ritualRecipe.getExpandedRecipes().size() > 1) {
                        // preserve other recipes
                        modifyBrewRecipe(
                                ritualRecipe,
                                ritualRecipe.getExpandedRecipes().stream().filter(r -> r != recipe)
                                        .map(
                                                r -> new BrewActionRitualRecipe.Recipe(
                                                        r.result,
                                                        Arrays.copyOf(r.ingredients, r.ingredients.length - 1)))
                                        .toArray(BrewActionRitualRecipe.Recipe[]::new));
                    } else {
                        removeAction(ritualRecipe);
                    }
                    return;
                }
            }
        }
        log.warn(
                "There is no cauldron recipe matching these items: last: {}, rest: " + Arrays.toString(items),
                lastItem);
    }

    private static void removeAllKettleRecipe(ItemStack output) {
        KettleRecipes.instance().recipes.removeIf(recipe -> recipe.output.isItemEqual(output));
    }

    private static void removeRecipe(KettleRecipes.KettleRecipe recipe) {
        if (!KettleRecipes.instance().recipes.remove(recipe)) log.warn("Recipe already removed: {}", recipe);
    }

    @Override
    public boolean init() {

        // remove a Spinning Wheel recipes
        SpinningWheel.removeRecipe(
                Witchery.Items.GENERIC.itemGoldenThread.createStack(3),
                new ItemStack(Blocks.hay_block),
                Witchery.Items.GENERIC.itemWhiffOfMagic.createStack(1));
        SpinningRecipes.instance().recipes
                .remove(SpinningWheel.getRecipe(new ItemStack(Items.string, 8, 0), new ItemStack[0]));
        SpinningWheel.removeRecipe(
                Witchery.Items.GENERIC.itemTormentedTwine.createStack(1),
                Witchery.Items.GENERIC.itemDisturbedCotton.createStack(4),
                new ItemStack(Items.string),
                Witchery.Items.GENERIC.itemReekOfMisfortune.createStack(1));
        SpinningWheel.removeRecipe(
                Witchery.Items.GENERIC.itemFancifulThread.createStack(1),
                new ItemStack(Witchery.Blocks.WISPY_COTTON, 4),
                new ItemStack(Items.string),
                Witchery.Items.GENERIC.itemOdourOfPurity.createStack(1));

        // add a Spinning Wheel recipes
        SpinningWheel.addRecipe(
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 8L),
                Witchery.Items.GENERIC.itemGoldenThread.createStack(1),
                new ItemStack[] { new ItemStack(Items.string, 8, 0),
                        Witchery.Items.GENERIC.itemWhiffOfMagic.createStack(1) });
        SpinningWheel.addRecipe(
                Witchery.Items.GENERIC.itemGoldenThread.createStack(1),
                Witchery.Items.GENERIC.itemFancifulThread.createStack(1),
                new ItemStack[] { new ItemStack(Witchery.Blocks.WISPY_COTTON, 4),
                        Witchery.Items.GENERIC.itemOdourOfPurity.createStack(1) });
        SpinningWheel.addRecipe(
                GT_ModHandler.getModItem(BloodArsenal.ID, "blood_burned_string", 1L),
                Witchery.Items.GENERIC.itemTormentedTwine.createStack(1),
                new ItemStack[] { Witchery.Items.GENERIC.itemDisturbedCotton.createStack(4),
                        Witchery.Items.GENERIC.itemReekOfMisfortune.createStack(1) });
        SpinningWheel.addRecipe(
                new ItemStack(Items.string, 8, 0),
                new ItemStack(Blocks.web, 1, 0),
                new ItemStack[] { Witchery.Items.GENERIC.itemWhiffOfMagic.createStack(1) });

        // remove a Kettle recipe
        removeAllKettleRecipe(Witchery.Items.GENERIC.itemSpiritOfOtherwhere.createStack());

        // add a Kettle recipes
        Kettle.addRecipe(
                Witchery.Items.GENERIC.itemSpiritOfOtherwhere.createStack(2),
                0,
                0,
                6000.0F,
                -7128833,
                0,
                true,
                Witchery.Items.GENERIC.itemRedstoneSoup.createStack(),
                Witchery.Items.GENERIC.itemBrewOfFlowingSpirit.createStack(),
                GT_ModHandler.getModItem(StevesCarts2.ID, "ModuleComponents", 1L, 45),
                GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "end_powder", 1L),
                Witchery.Items.GENERIC.itemDropOfLuck.createStack(),
                Witchery.Items.GENERIC.itemBatWool.createStack());

        // remove a Cauldron recipe
        removeAllBrewRecipes(new ItemStack(Witchery.Items.CHALK_RITUAL));

        // add a Cauldron recipes
        addBrewRecipe(
                1000,
                new ItemStack(Witchery.Items.CHALK_GOLDEN),
                new ItemStack(Witchery.Items.CHALK_RITUAL),
                Witchery.Items.GENERIC.itemMandrakeRoot.createStack(),
                GT_ModHandler.getModItem(GregTech.ID, "gt.metaitem.01", 1L, 2086),
                Witchery.Items.GENERIC.itemDiamondVapour.createStack());
        addBrewRecipe(
                2000,
                new ItemStack(Witchery.Items.CHALK_INFERNAL),
                new ItemStack(Witchery.Items.CHALK_RITUAL),
                new ItemStack(Items.nether_wart),
                new ItemStack(Items.blaze_rod),
                new ItemStack(Items.nether_star));
        if (HardcoreEnderExpansion.isModLoaded()) {
            addBrewRecipe(
                    4000,
                    new ItemStack(Witchery.Items.CHALK_OTHERWHERE),
                    new ItemStack(Witchery.Items.CHALK_RITUAL),
                    GT_ModHandler.getModItem(GregTech.ID, "gt.metaitem.01", 1L, 2533),
                    GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "end_powder", 1L),
                    Witchery.Items.GENERIC.itemTearOfTheGoddess.createStack(),
                    GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ManyullynCrystal", 1L, 0));
        }
        // rites
        // TODO write doc

        // remove cauldron recipes

        return true;
    }

    @Override
    public boolean postInit() {
        return true;
    }

    private static class EmptyBrewActionModifier extends BrewActionModifier {

        public EmptyBrewActionModifier(ItemStack item, int power) {
            super(BrewItemKey.fromStack(item), null, new AltarPower(power));
        }
    }
}
