package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptAvaritia implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Avaritia";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Mods.Avaritia.ID,
                Mods.Thaumcraft.ID,
                Mods.ThaumicBases.ID,
                Mods.Gadomancy.ID,
                Mods.TaintedMagic.ID);
    }

    @Override
    public void loadRecipes() {

        addShapedRecipe(
                getModItem("Avaritia", "Dire_Crafting", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("Avaritia", "Triple_Craft", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing), "waferAdvanced",
                        getModItem("Avaritia", "Crystal_Matrix", 1, 0, missing), "waferAdvanced",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32642, missing), "circuitElite",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32642, missing) });
        addShapedRecipe(
                getModItem("Avaritia", "Resource", 1, 0, missing),
                new Object[] { "screwDiamond", "plateDiamond", "screwDiamond", "plateDiamond",
                        getModItem("dreamcraft", "item.StainlessSteelBars", 1, 0, missing), "plateDiamond",
                        "screwDiamond", "plateDiamond", "screwDiamond" });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Avaritia", "Resource", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32309, missing))
                .itemOutputs(getModItem("Avaritia", "Resource", 9, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(2400).eut(480).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Avaritia", "Resource_Block", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32306, missing))
                .itemOutputs(getModItem("Avaritia", "Resource", 9, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(4800).eut(480).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Avaritia", "Resource", 4, 0, missing),
                        getModItem("minecraft", "nether_star", 2, 0, missing))
                .itemOutputs(getModItem("Avaritia", "Resource", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Avaritia", "Resource_Block", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32355, missing))
                .itemOutputs(getModItem("Avaritia", "Resource", 9, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(1000).eut(524000).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Avaritia", "Resource_Block", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32355, missing))
                .itemOutputs(getModItem("Avaritia", "Resource", 9, 6, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(524000).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Avaritia", "Resource", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32350, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 17397, missing)).noFluidInputs()
                .noFluidOutputs().duration(4000).eut(524000).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 11397, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32350, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 17397, missing)).noFluidInputs()
                .noFluidOutputs().duration(4000).eut(524000).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Avaritia", "Resource", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32350, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 17982, missing)).noFluidInputs()
                .noFluidOutputs().duration(3000).eut(524000).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 11982, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32350, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 17982, missing)).noFluidInputs()
                .noFluidOutputs().duration(3000).eut(524000).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 17500, missing),
                        getModItem("dreamcraft", "item.StainlessSteelBars", 1, 0, missing))
                .itemOutputs(getModItem("Avaritia", "Resource", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(120).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Avaritia", "Resource", 1, 3, missing))
                .itemOutputs(getModItem("Avaritia", "Resource", 9, 2, missing)).outputChances(10000).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);

        TCHelper.removeInfusionRecipe(getModItem("Avaritia", "Akashic_Record", 1, 0, missing));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "AKASHIC",
                getModItem("Avaritia", "Akashic_Record", 1, 0, missing),
                24,
                new AspectList().add(Aspect.getAspect("praecantatio"), 512).add(Aspect.getAspect("cognitio"), 128)
                        .add(Aspect.getAspect("sensus"), 96).add(Aspect.getAspect("luxuria"), 96)
                        .add(Aspect.getAspect("tempus"), 64).add(Aspect.getAspect("terminus"), 128),
                getModItem("gregtech", "gt.metaitem.01", 1, 17397, missing),
                new ItemStack[] { getModItem("TaintedMagic", "ItemFocusTime", 1, 0, missing),
                        getModItem("thaumicbases", "knoseFragment", 1, 6, missing),
                        getModItem("thaumicbases", "knoseFragment", 1, 6, missing),
                        getModItem("thaumicbases", "knoseFragment", 1, 6, missing),
                        getModItem("thaumicbases", "knoseFragment", 1, 6, missing),
                        getModItem("Avaritia", "big_pearl", 1, 0, missing),
                        getModItem("gadomancy", "BlockKnowledgeBook", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemThaumonomicon", 1, 0, missing),
                        getModItem("TaintedMagic", "ItemFocusMeteorology", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemEldritchObject", 1, 1, missing),
                        getModItem("gadomancy", "BlockKnowledgeBook", 1, 0, missing),
                        getModItem("Avaritia", "big_pearl", 1, 0, missing),
                        getModItem("thaumicbases", "knoseFragment", 1, 6, missing),
                        getModItem("thaumicbases", "knoseFragment", 1, 6, missing),
                        getModItem("thaumicbases", "knoseFragment", 1, 6, missing),
                        getModItem("thaumicbases", "knoseFragment", 1, 6, missing), });
        TCHelper.refreshResearchPages("AKASHIC");
    }
}
