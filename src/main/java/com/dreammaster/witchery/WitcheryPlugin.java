package com.dreammaster.witchery;

import alkalus.main.api.RecipeManager.SpinningWheel;
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
        if (ingredient == null)
            return;
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
            registerBrewAction(new BrewActionRitualRecipe(key, new AltarPower(power), new BrewActionRitualRecipe.Recipe(result, items)));
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
        if (ingredient == null)
            return;
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
        if (ingredient == null)
            return;
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
                        modifyBrewRecipe(ritualRecipe, ritualRecipe.getExpandedRecipes()
                                .stream()
                                .filter(r -> r != recipe)
                                .map(r -> new BrewActionRitualRecipe.Recipe(r.result, Arrays.copyOf(r.ingredients, r.ingredients.length - 1)))
                                .toArray(BrewActionRitualRecipe.Recipe[]::new)
                        );
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

        //remove a Spinning Wheel Recipes
        SpinningWheel.removeRecipe(Witchery.Items.GENERIC.itemGoldenThread.createStack(3), new ItemStack(Blocks.hay_block), Witchery.Items.GENERIC.itemWhiffOfMagic.createStack(1));
        //SpinningWheel.removeRecipe(new ItemStack(Items.string, 8, 0), null, new ItemStack(Blocks.web, 1, 0));
        SpinningRecipes.instance().recipes.remove(SpinningWheel.getRecipe(new ItemStack(Items.string, 8, 0), new ItemStack[0]));
        SpinningWheel.removeRecipe(Witchery.Items.GENERIC.itemTormentedTwine.createStack(1), Witchery.Items.GENERIC.itemDisturbedCotton.createStack(4), new ItemStack(Items.string), Witchery.Items.GENERIC.itemReekOfMisfortune.createStack(1));
        SpinningWheel.removeRecipe(Witchery.Items.GENERIC.itemFancifulThread.createStack(1), new ItemStack(Witchery.Blocks.WISPY_COTTON, 4), new ItemStack(Items.string), Witchery.Items.GENERIC.itemOdourOfPurity.createStack(1));

        //Add a Spinning Wheel Recipes
        SpinningWheel.addRecipe(GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 8L), Witchery.Items.GENERIC.itemGoldenThread.createStack(1), new ItemStack[]{new ItemStack(Items.string, 8, 0), Witchery.Items.GENERIC.itemWhiffOfMagic.createStack(1)});
        SpinningWheel.addRecipe(Witchery.Items.GENERIC.itemGoldenThread.createStack(1), Witchery.Items.GENERIC.itemFancifulThread.createStack(1), new ItemStack[]{new ItemStack(Witchery.Blocks.WISPY_COTTON, 4), Witchery.Items.GENERIC.itemOdourOfPurity.createStack(1)});
        SpinningWheel.addRecipe(GT_ModHandler.getModItem("BloodArsenal","blood_burned_string",1L), Witchery.Items.GENERIC.itemTormentedTwine.createStack(1), new ItemStack[]{Witchery.Items.GENERIC.itemDisturbedCotton.createStack(4), Witchery.Items.GENERIC.itemReekOfMisfortune.createStack(1)});
        SpinningWheel.addRecipe(new ItemStack(Items.string, 8, 0), new ItemStack(Blocks.web, 1, 0), new ItemStack[]{Witchery.Items.GENERIC.itemWhiffOfMagic.createStack(1)});

        //remove a Kettle recipe
        //KettleRecipes.KettleRecipe r = Kettle.findRecipeWithSomeInputsAndAnOutput(new ItemStack[]{Witchery.Items.GENERIC.itemRedstoneSoup.createStack(), new ItemStack(Items.potionitem, 1, 8258), new ItemStack(Items.ender_eye), new ItemStack(Items.ender_eye), Witchery.Items.GENERIC.itemDropOfLuck.createStack(), Witchery.Items.GENERIC.itemBatWool.createStack()},Witchery.Items.GENERIC.itemSpiritOfOtherwhere.createStack(2));
        //Kettle.removeRecipe (r);

        //Kettle.findRecipeWithSomeInputsAndAnOutput(new ItemStack[]{Witchery.Items.GENERIC.itemRedstoneSoup.createStack(), new ItemStack(Items.potionitem, 1, 8258), new ItemStack(Items.ender_eye), new ItemStack(Items.ender_eye), Witchery.Items.GENERIC.itemDropOfLuck.createStack(), Witchery.Items.GENERIC.itemBatWool.createStack()},Witchery.Items.GENERIC.itemSpiritOfOtherwhere.createStack(2));
        //Kettle.findRecipeWithSomeInputsAndAnOutput(new ItemStack[]{Witchery.Items.GENERIC.itemRedstoneSoup.createStack(), new ItemStack(Items.potionitem, 1, 16210), new ItemStack(Items.ender_eye), new ItemStack(Items.ender_eye), Witchery.Items.GENERIC.itemDropOfLuck.createStack(), Witchery.Items.GENERIC.itemBatWool.createStack()},Witchery.Items.GENERIC.itemSpiritOfOtherwhere.createStack(2));

        //add a Kettle recipes
        //Kettle.addRecipe(Witchery.Items.GENERIC.itemSpiritOfOtherwhere.createStack(1), 0, 0, 6000.0F, -7128833, 0, true, Witchery.Items.GENERIC.itemRedstoneSoup.createStack(), Witchery.Items.GENERIC.itemBrewOfFlowingSpirit.createStack(), GT_ModHandler.getModItem("StevesCarts","ModuleComponents",1L, 45), GT_ModHandler.getModItem("ThaumicTinkerer","skyPearl",1L), Witchery.Items.GENERIC.itemDropOfLuck.createStack(), Witchery.Items.GENERIC.itemBatWool.createStack());

        //remove cauldron recipes
        //removeBrewRecipe(new ItemStack(Witchery.Items.CHALK_RITUAL), new ItemStack(Items.nether_wart), Witchery.Items.GENERIC.itemTearOfTheGoddess.createStack(), new ItemStack(Items.ender_pearl));
        //removeBrewRecipe(new ItemStack(Witchery.Items.CHALK_RITUAL), Witchery.Items.GENERIC.itemMandrakeRoot.createStack(), new ItemStack(Items.gold_nugget));
        //removeBrewRecipe(new ItemStack(Witchery.Items.CHALK_RITUAL), new ItemStack(Items.blaze_powder), new ItemStack(Items.nether_wart));

        //add cauldron recipes
        //addBrewRecipe(4000, new ItemStack(Witchery.Items.CHALK_OTHERWHERE), new ItemStack(Witchery.Items.CHALK_RITUAL), new ItemStack(Items.nether_wart), GT_ModHandler.getModItem("gregtech","gt.metaitem.01",1L, 1506), Witchery.Items.GENERIC.itemTearOfTheGoddess.createStack(), GT_ModHandler.getModItem("dreamcraft","item.ManyullynCrystal",1L, 0));
        //addBrewRecipe(1000, new ItemStack(Witchery.Items.CHALK_GOLDEN), new ItemStack(Witchery.Items.CHALK_RITUAL), Witchery.Items.GENERIC.itemMandrakeRoot.createStack(), GT_ModHandler.getModItem("gregtech","gt.metaitem.01",4L, 29086), Witchery.Items.GENERIC.itemBreathOfTheGoddess.createStack());
        //addBrewRecipe(2000, new ItemStack(Witchery.Items.CHALK_INFERNAL), new ItemStack(Witchery.Items.CHALK_RITUAL), new ItemStack(Items.blaze_powder, 4, 0), GT_ModHandler.getModItem("gregtech","gt.metaitem.01",1L, 1506), Witchery.Items.GENERIC.itemFoulFume.createStack());

        //addBrewRecipe(1000, new ItemStack(Items.apple, 2), new ItemStack(Items.string), new ItemStack(Blocks.iron_bars));

        //new BrewActionRitualRecipe(new BrewItemKey(Witchery.Items.CHALK_RITUAL), new AltarPower(2000), new BrewActionRitualRecipe.Recipe[]{new BrewActionRitualRecipe.Recipe(new ItemStack(Witchery.Items.CHALK_OTHERWHERE), new ItemStack[]{new ItemStack(Items.nether_wart), Witchery.Items.GENERIC.itemTearOfTheGoddess.createStack(), new ItemStack(Items.ender_pearl)}),
        //new BrewActionRitualRecipe.Recipe(new ItemStack(Witchery.Items.CHALK_GOLDEN), new ItemStack[]{Witchery.Items.GENERIC.itemMandrakeRoot.createStack(), GT_ModHandler.getModItem("gregtech","gt.metaitem.01",4L, 29086), Witchery.Items.GENERIC.itemBreathOfTheGoddess.createStack()}),
        //new BrewActionRitualRecipe.Recipe(new ItemStack(Witchery.Items.CHALK_INFERNAL), new ItemStack[]{new ItemStack(Items.blaze_powder, 4, 0), GT_ModHandler.getModItem("gregtech","gt.metaitem.01",1L, 1506), Witchery.Items.GENERIC.itemFoulFume.createStack()})});

        //new BrewActionRitualRecipe(new BrewItemKey(Witchery.Items.CHALK_RITUAL), new AltarPower(4000), new BrewActionRitualRecipe.Recipe[]{new BrewActionRitualRecipe.Recipe(new ItemStack(Witchery.Items.CHALK_OTHERWHERE), new ItemStack[]new ItemStack(Items.nether_wart), GT_ModHandler.getModItem("gregtech","gt.metaitem.01",1L, 1506), Witchery.Items.GENERIC.itemTearOfTheGoddess.createStack(), GT_ModHandler.getModItem("dreamcraft","item.ManyullynCrystal",1L, 0)}), new ItemStack(Witchery.Items.CHALK_RITUAL), new ItemStack(Witchery.Items.CHALK_GOLDEN), Witchery.Items.GENERIC.itemMandrakeRoot.createStack(), GT_ModHandler.getModItem("gregtech","gt.metaitem.01",4L, 29086), Witchery.Items.GENERIC.itemBreathOfTheGoddess.createStack(), new ItemStack(Witchery.Items.CHALK_RITUAL));, new BrewActionRitualRecipe.Recipe(new ItemStack(Witchery.Items.CHALK_INFERNAL), new ItemStack[]{new ItemStack(Items.nether_wart), new ItemStack(Items.blaze_powder)})}));
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

    private static class EmptyBrewActionModifier extends BrewActionModifier {
        public EmptyBrewActionModifier(ItemStack item, int power) {
            super(BrewItemKey.fromStack(item), null, new AltarPower(power));
        }
    }
}
