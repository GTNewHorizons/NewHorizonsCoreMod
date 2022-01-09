package com.dreammaster.scripts;

import java.util.Arrays;
import java.util.List;

import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptForgeMultipart implements IScriptLoader{
    private long startTime;
    private long endTime;
    private static final String scriptName = "Forge Multipart";
    private static final List<String> dependencies = Arrays.asList("ForgeMicroblock");

    public ScriptForgeMultipart() {

    }
    @Override
    public void loadRecipes() {
        startTime = System.currentTimeMillis();
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
        endTime = System.currentTimeMillis();
    }

    @Override
    public long getExecutionTime(){
        return endTime-startTime;
    }

    @Override
    public List<String> getDependencies() {
        return dependencies;
    }

    @Override
    public String getScriptName() {
        return scriptName;
    }
}