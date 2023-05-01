package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.Mods;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

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
