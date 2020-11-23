package com.dreammaster.witchery;

import alkalus.main.api.RecipeManager.*;
import alkalus.main.api.plugin.base.BasePluginWitchery;
import alkalus.main.core.crafting.OvenRecipes;
import com.emoniph.witchery.Witchery;
import com.emoniph.witchery.WitcheryItems;
import com.emoniph.witchery.crafting.DistilleryRecipes;
import com.emoniph.witchery.infusion.Infusion;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.EnumSet;

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

    @Override
    public boolean init() {
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
        {
            OvenRecipes.OvenRecipe r = WitchesOven.findRecipeForOutput(new ItemStack(Items.iron_ingot));
            WitchesOven.removeRecipe(r);
        }
        // this remove the first recipe that consumes an iron ingot
        // this does not respect oredict...
        {
            OvenRecipes.OvenRecipe r = WitchesOven.findRecipeUsingIngredient(new ItemStack(Items.iron_ingot));
            WitchesOven.removeRecipe(r);
        }
        // add recipe to distillery
        // distill an apple and a slime ball to an apple and a foul fume, consuming one jar
        // empty slots can be set to null safely
        Distillery.addRecipe(new ItemStack(Items.apple, 1),new ItemStack(Items.slime_ball, 1), 1, new ItemStack(Items.apple, 1),Witchery.Items.GENERIC.itemFoulFume.createStack(), null,null);
        // remove a distillery recipe
        // remove all recipe that uses an apple and a slime ball to produce some output
        {
            // witchery extra is unfortunately not useful in this regard...
            // we have to blow through the cover and call witchery itself
            // better synchronize on witchery extra even though I don't know how this could help
            // multiple different synchronized block should be merged together
            synchronized (Distillery.class) {
                for (DistilleryRecipes.DistilleryRecipe i : DistilleryRecipes.instance().recipes) {
                    if (i.uses(new ItemStack(Items.apple, 1)) && i.uses(new ItemStack(Items.slime_ball, 1))) {
                        Distillery.removeRecipe(i);
                        break;
                    }
                }
            }
        }
        // add a kettle recipe
        // arguments from first to last
        // output, in this case a slime ball
        // 1 if hat bonus applies, 0 if not
        // 0 if no familiar can boost. 1 if cat, 2 if toad, 3 if owl
        Kettle.addRecipe(new ItemStack(Items.slime_ball, 1), 1, 0, 1000.0F, 0xffffff, 0, true, new ItemStack(Items.apple, 1), new ItemStack(Items.sugar, 1))
        // remove a kettle recipe
        // remove the first recipe that produces a slime_ball, if any
        {
            Kettle.removeRecipe(new ItemStack(Items.slime_ball, 1));
        }
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

        // rites
        // TODO write doc
        */
        return true;
    }

    @Override
    public boolean postInit() {
        return true;
    }
}
