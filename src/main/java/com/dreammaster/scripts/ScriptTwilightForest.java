package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import gregtech.api.enums.GT_Values;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class ScriptTwilightForest implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "TwilightForest";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(TwilightForest.ID, Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {

        final ItemStack TF_ROOF_TILE = getModItem(TwilightForest.ID, "tile.CastleBrick", 8, 3);
        addShapedRecipe(
                TF_ROOF_TILE,
                new Object[] { Blocks.cobblestone, Blocks.stone, Blocks.cobblestone, Blocks.cobblestone, "dyeBlack",
                        Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone });

        addShapedRecipe(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 12, missing),
                new Object[] { getModItem(TwilightForest.ID, "tile.TFTowerStone", 1, 1, missing),
                        getModItem(TwilightForest.ID, "item.carminite", 1, 0, missing),
                        getModItem(TwilightForest.ID, "tile.TFTowerStone", 1, 1, missing),
                        getModItem(TwilightForest.ID, "item.carminite", 1, 0, missing), "blockRedstone",
                        getModItem(TwilightForest.ID, "item.carminite", 1, 0, missing),
                        getModItem(TwilightForest.ID, "tile.TFTowerStone", 1, 1, missing),
                        getModItem(TwilightForest.ID, "item.carminite", 1, 0, missing),
                        getModItem(TwilightForest.ID, "tile.TFTowerStone", 1, 1, missing) });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2339, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32306, missing))
                .itemOutputs(getModItem(TwilightForest.ID, "item.steeleafIngot", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(4).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "ItemResource", 2, 14, missing),
                        getModItem(TwilightForest.ID, "item.trophy", 0, 1, missing))
                .itemOutputs(getModItem(TwilightForest.ID, "item.nagaScale", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "ItemResource", 6, 14, missing),
                        getModItem(TwilightForest.ID, "item.trophy", 0, 0, missing))
                .itemOutputs(getModItem(TwilightForest.ID, "item.fieryBlood", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(1024).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                        getModItem(TwilightForest.ID, "item.trophy", 0, 3, missing))
                .itemOutputs(getModItem(TwilightForest.ID, "item.fieryTears", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1500).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "ItemResource", 8, 14, missing),
                        getModItem(TwilightForest.ID, "item.trophy", 0, 3, missing))
                .itemOutputs(getModItem(TwilightForest.ID, "item.carminite", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1500).eut(4096).addTo(sAssemblerRecipes);

        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFRoots", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFRoots", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("praecantatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.liveRoot", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("praecantatio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFFirefly", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("victus"), 1).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFCicada", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("victus"), 1).add(Aspect.getAspect("volatus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPortal", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("tempus"), 4).add(Aspect.getAspect("praecantatio"), 4)
                        .add(Aspect.getAspect("iter"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFHedge", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFFireflyJar", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("vitreus"), 2).add(Aspect.getAspect("arbor"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("herba"), 2).add(Aspect.getAspect("victus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 8, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 9, missing),
                new AspectList().add(Aspect.getAspect("herba"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 10, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 11, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1).add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 13, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFFireJet", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 2).add(Aspect.getAspect("aer"), 2)
                        .add(Aspect.getAspect("machina"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFFireJet", 1, 8, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("motus"), 2)
                        .add(Aspect.getAspect("machina"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFNagastone", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("terra"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFNagastone", 1, 13, missing),
                new AspectList().add(Aspect.getAspect("terra"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFSapling", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("arbor"), 2)
                        .add(Aspect.getAspect("tempus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFSapling", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("arbor"), 2)
                        .add(Aspect.getAspect("praecantatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFSapling", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("arbor"), 2)
                        .add(Aspect.getAspect("perfodio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFSapling", 1, 9, missing),
                new AspectList().add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("arbor"), 2)
                        .add(Aspect.getAspect("sensus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMoonworm", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("victus"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMagicLogSpecial", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 4).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("tempus"), 2).add(Aspect.getAspect("herba"), 2)
                        .add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMagicLogSpecial", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 4).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("aer"), 2).add(Aspect.getAspect("herba"), 2)
                        .add(Aspect.getAspect("invidia"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMagicLogSpecial", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 4).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("perfodio"), 2).add(Aspect.getAspect("herba"), 2)
                        .add(Aspect.getAspect("lucrum"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMagicLogSpecial", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 4).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("motus"), 2).add(Aspect.getAspect("herba"), 2)
                        .add(Aspect.getAspect("cognitio"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("potentia"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("potentia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("potentia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("potentia"), 2).add(Aspect.getAspect("iter"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 9, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 2)
                        .add(Aspect.getAspect("potentia"), 4).add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 10, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 2)
                        .add(Aspect.getAspect("potentia"), 4).add(Aspect.getAspect("vinculum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFShield", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("machina"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTrophyPedestal", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 7).add(Aspect.getAspect("ordo"), 4)
                        .add(Aspect.getAspect("lucrum"), 4).add(Aspect.getAspect("instrumentum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTrophyPedestal", 1, 15, missing),
                new AspectList().add(Aspect.getAspect("terra"), 7).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("lucrum"), 12).add(Aspect.getAspect("instrumentum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFAuroraBrick", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFUnderBrick", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFUnderBrick", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFUnderBrick", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFThorns", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("fabrico"), 1)
                        .add(Aspect.getAspect("telum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFThorns", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("herba"), 3).add(Aspect.getAspect("fabrico"), 1)
                        .add(Aspect.getAspect("telum"), 1).add(Aspect.getAspect("aqua"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFBurntThorns", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFThornRose", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFLeaves3", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFLeaves3", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFDeadrock", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 8).add(Aspect.getAspect("ignis"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFDeadrock", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("terra"), 8).add(Aspect.getAspect("ignis"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFDeadrock", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("terra"), 8).add(Aspect.getAspect("ignis"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.DarkLeaves", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.AuroraPillar", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.AuroraSlab", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2).add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.AuroraDoubleSlab", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TrollSteinn", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("potentia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.WispyCloud", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 1).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("aqua"), 1).add(Aspect.getAspect("tempestas"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.FluffyCloud", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 1).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 1).add(Aspect.getAspect("tempestas"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.HugeStalk", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.UberousSoil", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("aqua"), 4)
                        .add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("victus"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.HugeGloomBlock", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("tenebrae"), 2)
                        .add(Aspect.getAspect("herba"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.KnightmetalBlock", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 18).add(Aspect.getAspect("lucrum"), 9));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.UnripeTrollBer", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1).add(Aspect.getAspect("terra"), 1)
                        .add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TrollBer", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1).add(Aspect.getAspect("terra"), 1)
                        .add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.HugeLilyPad", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 8).add(Aspect.getAspect("aqua"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.HugeWaterLily", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 3));
    }
}
