package com.dreammaster.witchery;

import alkalus.main.api.RecipeManager.*;
import alkalus.main.api.plugin.base.BasePluginWitchery;
import com.emoniph.witchery.Witchery;
import com.emoniph.witchery.brewing.AltarPower;
import com.emoniph.witchery.brewing.BrewItemKey;
import com.emoniph.witchery.brewing.WitcheryBrewRegistry;
import com.emoniph.witchery.brewing.action.BrewAction;
import com.emoniph.witchery.brewing.action.BrewActionModifier;
import com.emoniph.witchery.brewing.action.BrewActionRitualRecipe;
import com.emoniph.witchery.crafting.SpinningRecipes;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.stream.Stream;

import static com.dreammaster.witchery.WitcheryBrewRegistryAccessor.*;

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
     * Add a brew action for given stack. This action will do nothing upon added beyond consuming alter power
     * This is necessary for an item to be able to tossed into the cauldron.
     *
     * @param item  The stack that should be tossed into the cauldron, stack size does not matter
     * @param power The power to consume. Can be 0.
     */
    private static void ensureItemHaveBrewAction(ItemStack item, int power) {
        if (WitcheryBrewRegistry.INSTANCE.getActionForItemStack(item) == null) {
            registerBrewAction(new BrewActionModifier(BrewItemKey.fromStack(item), null, new AltarPower(power)) {
            });
        }
    }

    /**
     * Add a brew recipe matching given items.
     *
     * @param lastItem The last item in the recipe, i.e. the recipe you used to complete the brew
     * @param items    items in recipe. order does not matter. DOES NOT INCLUDE lastItem!
     */
    private static void addBrewRecipe(int power, ItemStack result, ItemStack lastItem, ItemStack... items) {
        if (ingredient == null)
            return;
        final BrewItemKey key = BrewItemKey.fromStack(lastItem);
        final BrewAction action = ingredient.get(key);
        ensureItemHaveBrewAction(lastItem,0);
        for (ItemStack item : items) {
            ensureItemHaveBrewAction(item, 0);
        }
        if (action == null) {
            registerBrewAction(new BrewActionRitualRecipe(key, new AltarPower(power), new BrewActionRitualRecipe.Recipe(result)));
        } else if (action instanceof BrewActionRitualRecipe) {
            modifyBrewRecipe((BrewActionRitualRecipe) action, s -> Stream.concat(s, Stream.of(new BrewActionRitualRecipe.Recipe(result, items))));
        } else {
            log.warn("Conflicting brew recipe! key: {}", lastItem);
        }
    }

    /**
     * Remove a brew recipe matching given items.
     *
     * @param lastItem The last item in the recipe, i.e. the recipe you used to complete the brew
     * @param items    items in recipe. order does not matter. DOES NOT INCLUDE lastItem!
     */
    private static void removeBrewRecipe(ItemStack lastItem, ItemStack... items) {
        if (ingredient == null)
            return;
        final BrewItemKey key = BrewItemKey.fromStack(lastItem);
        final BrewAction action = ingredient.get(key);
        if (action == null) {
            log.warn("There is no brew for this last item: {}", lastItem);
            return;
        }
        if (action instanceof BrewActionRitualRecipe) {
            final BrewActionRitualRecipe ritualRecipe = (BrewActionRitualRecipe) action;
            for (BrewActionRitualRecipe.Recipe recipe : ritualRecipe.getExpandedRecipes()) {
                if (isCauldronRecipeMatch(recipe, lastItem, items)) {
                    if (ritualRecipe.getExpandedRecipes().size() > 1) {
                        // preserve other recipes
                        modifyBrewRecipe(ritualRecipe, s -> s.filter(r -> r != recipe));
                    } else {
                        removeAction(ritualRecipe);
                    }
                    return;
                }
            }
        }
        log.warn("There is no cauldron recipe matching these items: last: {}, rest: " + Arrays.toString(items), lastItem);
    }

    @Override
    public boolean init() {
        //OvenRecipes.OvenRecipe r = WitchesOven.findRecipeForOutput(new ItemStack(Items.iron_ingot));
        //WitchesOven.removeRecipe(r);
        //WitchesOven.addRecipe(GT_ModHandler.getModItem("Thaumcraft","blockCosmeticSlabStone",4L), null, 2, new ItemStack(Items.coal, 1, 1), 1, Witchery.Items.GENERIC.itemFoulFume.createStack(), 2);
        //WitchesOven.removeRecipe(WitchesOven.findRecipeForOutput(new ItemStack(Items.iron_ingot)));
        //WitchesOven.removeRecipe(WitchesOven.getOvenResult(new ItemStack(Items.iron_ingot), 3));
        //Distillery.removeRecipe(Distillery.findRecipeForOutput(new ItemStack(Items.iron_ingot)));
        //Distillery.removeRecipe(Distillery.getDistillingResult(new ItemStack(Items.iron_ingot), new ItemStack(Items.string), Witchery.Items.GENERIC.itemEmptyClayJar.createStack(2)));
        //Distillery.addRecipe(new ItemStack(Items.apple, 1),new ItemStack(Items.slime_ball, 1), 1, new ItemStack(Items.apple, 1),Witchery.Items.GENERIC.itemFoulFume.createStack(), null,null);
        //Kettle.addRecipe(new ItemStack(Items.slime_ball, 1), 1, 0, 1000.0F, 0xffffff, 0, true, new ItemStack(Items.apple, 1), new ItemStack(Items.sugar, 1));
        //Kettle.removeRecipe(new ItemStack(Items.slime_ball, 1));
        //SpinningWheel.addRecipe(new ItemStack(Blocks.web, 3), new ItemStack(Items.string), new ItemStack[]{new ItemStack(Items.apple, 2),new ItemStack(Items.slime_ball, 1), Witchery.Items.GENERIC.itemFoulFume.createStack() });

        //Remove Oven Recipes
        //WitchesOven.removeRecipe(WitchesOven.findRecipeForOutput(Witchery.Items.GENERIC.itemExhaleOfTheHornedOne.createStack()));
        //OvenRecipes.OvenRecipe r = WitchesOven.findRecipeForOutput(Witchery.Items.GENERIC.itemExhaleOfTheHornedOne.createStack());
        //WitchesOven.removeRecipe(r);

        //Add new Oven Recipes
        //WitchesOven.addRecipe(new ItemStack(Blocks.bookshelf), null,1, new ItemStack(Items.coal, 1, 1), 1, Witchery.Items.GENERIC.itemExhaleOfTheHornedOne.createStack(), 1);

        //remove Spinning Wheel Recipes
        SpinningWheel.removeRecipe(Witchery.Items.GENERIC.itemGoldenThread.createStack(3), new ItemStack(Blocks.hay_block), Witchery.Items.GENERIC.itemWhiffOfMagic.createStack(1));
        //SpinningWheel.removeRecipe(new ItemStack(Items.string, 8, 0), null, new ItemStack(Blocks.web, 1, 0));
        SpinningRecipes.instance().recipes.remove(SpinningWheel.getRecipe(new ItemStack(Items.string, 8, 0), new ItemStack[0]));
        SpinningWheel.removeRecipe(Witchery.Items.GENERIC.itemTormentedTwine.createStack(1), Witchery.Items.GENERIC.itemDisturbedCotton.createStack(4), new ItemStack(Items.string), Witchery.Items.GENERIC.itemReekOfMisfortune.createStack(1));
        SpinningWheel.removeRecipe(Witchery.Items.GENERIC.itemFancifulThread.createStack(1), new ItemStack(Witchery.Blocks.WISPY_COTTON, 4), new ItemStack(Items.string), Witchery.Items.GENERIC.itemOdourOfPurity.createStack(1));

        //Add new Spinning Wheel Recipes
        SpinningWheel.addRecipe(GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 8L), Witchery.Items.GENERIC.itemGoldenThread.createStack(1), new ItemStack[]{new ItemStack(Items.string, 8, 0), Witchery.Items.GENERIC.itemWhiffOfMagic.createStack(1)});
        SpinningWheel.addRecipe(Witchery.Items.GENERIC.itemGoldenThread.createStack(1), Witchery.Items.GENERIC.itemFancifulThread.createStack(1), new ItemStack[]{new ItemStack(Witchery.Blocks.WISPY_COTTON, 4), Witchery.Items.GENERIC.itemOdourOfPurity.createStack(1)});
        SpinningWheel.addRecipe(GT_ModHandler.getModItem("BloodArsenal","blood_burned_string",1L), Witchery.Items.GENERIC.itemTormentedTwine.createStack(1), new ItemStack[]{Witchery.Items.GENERIC.itemDisturbedCotton.createStack(4), Witchery.Items.GENERIC.itemReekOfMisfortune.createStack(1)});
        SpinningWheel.addRecipe(new ItemStack(Items.string, 8, 0), new ItemStack(Blocks.web, 1, 0), new ItemStack[]{Witchery.Items.GENERIC.itemWhiffOfMagic.createStack(1)});



/*
        // examples:
        // add an oven recipe

        // does not use oredict on input
        // smelt an apple to charcoal, filling 2 jar into 2 foul fume
        // notice: you can't have different input/output jar count, even if it is not a jar.
        WitchesOven.addRecipe(new ItemStack(Items.apple, 1), null, 2, new ItemStack(Items.coal, 1, 1), 1, Witchery.Items.GENERIC.itemFoulFume.createStack(), 2);

        // use oredict on input
        // smelt an iron ingot into 6 iron bar, filling 2 jar into 2 foul fume
        // notice: you can't have different input/output jar count, even if it is not a jar.
        WitchesOven.addRecipe(null, "ingotIron", 2, new ItemStack(Blocks.iron_bars, 6), 1, Witchery.Items.GENERIC.itemFoulFume.createStack(), 2);

        // notice: if this recipe already have a vanilla furnace counterpart, e.g. smelt iron dust to iron ingot
        // you don't need to specify the 4th and 5th argument.
        // smelt an iron dust to an iron ingot, filling 3 jar into 3 foul fume
        WitchesOven.addRecipe(null, "dustIron", 2, null, 0, Witchery.Items.GENERIC.itemFoulFume.createStack(), 3);

        // remove an oven recipe
        // this remove the first recipe that produce an iron ingot
        // this does not respect oredict...
        WitchesOven.removeRecipe(WitchesOven.findRecipeForOutput(new ItemStack(Items.iron_ingot)));
        // this remove the first recipe that consumes an iron ingot
        // this does not respect oredict...
        WitchesOven.removeRecipe(WitchesOven.findRecipeUsingIngredient(new ItemStack(Items.iron_ingot)));

        // add recipe to distillery
        // distill an apple and a slime ball to an apple and a foul fume, consuming one jar
        // empty slots can be set to null safely
        Distillery.addRecipe(new ItemStack(Items.apple, 1),new ItemStack(Items.slime_ball, 1), 1, new ItemStack(Items.apple, 1),Witchery.Items.GENERIC.itemFoulFume.createStack(), null,null);
        // remove a distillery recipe
        // remove all recipe that uses an apple and a slime ball to produce some output
        Distillery.removeRecipe(Distillery.getDistillingResult(new ItemStack(Items.apple, 1), new ItemStack(Items.slime_ball, 1), Witchery.Items.GENERIC.itemEmptyClayJar.createStack(jarCount)));

        // add a kettle recipe
        // arguments from first to last
        // output, in this case a slime ball
        // 1 if hat bonus applies, 0 if not
        // 0 if no familiar can boost. 1 if cat, 2 if toad, 3 if owl
        Kettle.addRecipe(new ItemStack(Items.slime_ball, 1), 1, 0, 1000.0F, 0xffffff, 0, true, new ItemStack(Items.apple, 1), new ItemStack(Items.sugar, 1))
        // remove a kettle recipe
        // remove the first recipe that produces a slime_ball, if any
        Kettle.removeRecipe(new ItemStack(Items.slime_ball, 1));

        // add a spinning wheel recipe
        // add 2 apple, 1 slime ball and 1 foul fume into string to get 3 cobweb
        SpinningWheel.addRecipe(new ItemStack(Blocks.web, 3), new ItemStack(Items.string), new ItemStack[]{new ItemStack(Items.apple, 2),new ItemStack(Items.slime_ball, 1), Witchery.Items.GENERIC.itemFoulFume.createStack() });
        // remove a spinning wheel recipe
        // remove a recipe that produce 1 iron bar from a string that got combined with 2 apple and 1 slime ball
        SpinningWheel.removeRecipe(new ItemStack(Blocks.iron_bars), new ItemStack(Items.string), new ItemStack(Items.apple, 2),new ItemStack(Items.slime_ball, 1));
        // remove a recipe that produce 1 iron bar from a string that got combined with 2 apple, 1 slime ball and 1 foul fume
        SpinningWheel.removeRecipe(new ItemStack(Blocks.web, 3), new ItemStack(Items.string), new ItemStack(Items.apple, 2),new ItemStack(Items.slime_ball, 1), Witchery.Items.GENERIC.itemFoulFume.createStack());

        // add a infusion
        // seems complex and require code, ask a coder for that
        // remove a infusion
        // remove infusion with id 1.
        // don't know what infusion 1 is though. probably shouldn't do this anyway.
        Infusions.remove(Infusions.getInfusion(1));

        // cauldron
        // add recipe
        // add a recipe for apple that takes 1000 alter power and 1 string and 1 iron bar, with string as the last item.
        addBrewRecipe(1000, new ItemStack(Items.apple, 2), new ItemStack(Items.string), new ItemStack(Blocks.iron_bars));
        // remove recipe
        // removes the vanilla recipe for CHALK_OTHERWHERE
        removeBrewRecipe(new ItemStack(Witchery.Items.CHALK_RITUAL), new ItemStack(Items.nether_wart), Witchery.Items.GENERIC.itemTearOfTheGoddess.createStack(), new ItemStack(Items.ender_pearl));
*/
        // rites
        // TODO write doc

        return true;
    }

    @Override
    public boolean postInit() {
        return true;
    }
}
