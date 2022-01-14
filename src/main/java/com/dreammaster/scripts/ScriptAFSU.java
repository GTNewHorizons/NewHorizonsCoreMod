package com.dreammaster.scripts;

import gregtech.api.enums.GT_Values;
import net.minecraft.item.ItemStack;

import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptAFSU implements IScriptLoader{

    public ScriptAFSU(){
        scriptName.append("AFSU");
        dependencies.add("AFSU");
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(getModItem("AFSU", "AFSU", 1), new Object[]{
                "cableGt01Platinum","itemCasingTungstenSteel","cableGt01Platinum",
                "itemCasingTungstenSteel",getModItem("gregtech", "gt.blockmachines", 1, 15),"itemCasingTungstenSteel",
                "circuitMaster",getModItem("AFSU", "ALC", 1),"circuitMaster"});

        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{
                        getModItem("gregtech", "gt.metaitem.03", 1, 32086),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32597)},
                GT_Values.NF,
                getModItem("AFSU", "ALC", 1),
                2400, 1920);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{
                        getModItem("gregtech", "gt.metaitem.03", 1, 32084),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32597)},
                GT_Values.NF,
                getModItem("AFSU", "ALC", 1),
                2400, 1920);
        GT_Values.RA.addAssemblerRecipe(new ItemStack[]{
                        getModItem("gregtech", "gt.metaitem.03", 1, 32089),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32597)},
                GT_Values.NF,
                getModItem("AFSU", "ALC", 1),
                2400, 1920);
    }
}
