package com.dreammaster.scripts;

import java.util.Arrays;

import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptForgeMultipart implements IScriptLoader{

    public ScriptForgeMultipart() {

    }

    @Override
    public void initScriptData() {
        scriptName.setLength(0);
        scriptName.append("Forge Multipart");
        dependencies.clear();
        dependencies.addAll(Arrays.asList("ForgeMicroblock"));
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(getModItem("ForgeMicroblock", "sawStone", 1), new Object[]{
                "stickWood","stickStone","stickStone",
                "stickWood",getModItem("dreamcraft", "item.SawBladeStone", 1),"stickStone",
                null,null,null});

        addShapedRecipe(getModItem("ForgeMicroblock", "sawIron", 1), new Object[]{
                "stickWood","stickIron","stickIron",
                "stickWood","toolHeadSawIron","stickIron",
                null,null,null});

        addShapedRecipe(getModItem("ForgeMicroblock", "sawDiamond", 1), new Object[]{
                "stickWood","stickSteel","stickSteel",
                "stickWood",getModItem("dreamcraft", "item.SawBladeDiamond", 1),"stickSteel",
                null,null,null});

        addShapedRecipe(getModItem("ForgeMicroblock", "stoneRod", 2), new Object[]{
                "stone",null,null,
                "stone",null,null,
                null,null,null});

        addShapedRecipe(getModItem("ForgeMicroblock", "stoneRod", 4), new Object[]{
                "craftingToolSaw",null,null,
                "stone",null,null,
                "stone",null,null});
    }
}