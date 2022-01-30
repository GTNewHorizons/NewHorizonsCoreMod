package com.dreammaster.scripts;

import java.util.Arrays;

import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptIguanaTweaks implements IScriptLoader{
    @Override
    public void initScriptData() {

        scriptName.setLength(0);
        scriptName.append("Iguana Tweajs Tinker Construct");
        dependencies.clear();
        dependencies.addAll(Arrays.asList("IguanaTweaksTConstruct", "Natura"));
    }

    @Override
    public void loadRecipes() {
        // --- Unfired Clay Bucket
        // If you change this recipe, be sure to update gregtech.api.enums.OrePrefixes!
        // bucketClay.mSecondaryMaterial controls what the clay bucket pulverizes into.
        addShapedRecipe(getModItem("IguanaTweaksTConstruct", "clayBucketUnfired", 1), new Object[]{
                null,null,null,
                "dustClay",null,"dustClay",
                "dustClay","dustClay","dustClay"});

        addShapedRecipe(getModItem("IguanaTweaksTConstruct", "clayBucketWater", 1), new Object[]{
                getModItem("Natura", "waterdrop", 1),getModItem("Natura", "waterdrop", 1),getModItem("Natura", "waterdrop", 1),
                getModItem("Natura", "waterdrop", 1),getModItem("IguanaTweaksTConstruct", "clayBucketFired", 1),getModItem("Natura", "waterdrop", 1),
                getModItem("Natura", "waterdrop", 1),getModItem("Natura", "waterdrop", 1),getModItem("Natura", "waterdrop", 1)});

        addShapedRecipe(getModItem("IguanaTweaksTConstruct", "sawArdite", 1), new Object[]{
                "stickWood","stickSteel","stickSteel",
                "stickWood",getModItem("dreamcraft", "item.SawBladeArdite", 1),"stickSteel",
                null,null,null});

        addShapedRecipe(getModItem("IguanaTweaksTConstruct", "sawCobalt", 1), new Object[]{
                "stickWood","stickSteel","stickSteel",
                "stickWood","toolHeadSawCobalt","stickSteel",
                null,null,null});

        addShapedRecipe(getModItem("IguanaTweaksTConstruct", "sawManyullyn", 1), new Object[]{
                "stickWood","stickSteel","stickSteel",
                "stickWood",getModItem("dreamcraft", "item.SawBladeManyullyn", 1),"stickSteel",
                null,null,null});

    }
}
