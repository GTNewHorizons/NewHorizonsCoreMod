package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.ElectroMagicTools;
import static gregtech.api.enums.Mods.EtFuturumRequiem;
import static gregtech.api.enums.Mods.MagicBees;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.enums.Mods.ZTones;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.compressorRecipes;
import static gregtech.api.recipe.RecipeMaps.multiblockChemicalReactorRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.mixerNonCellRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.item.NHItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.objects.OreDictItemStack;
import gregtech.api.util.GTOreDictUnificator;
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
        return Arrays.asList(
                ElectroMagicTools.ID,
                EtFuturumRequiem.ID,
                MagicBees.ID,
                Thaumcraft.ID,
                TwilightForest.ID,
                ZTones.ID);
    }

    @Override
    public void loadRecipes() {

        final ItemStack TF_ROOF_TILE = getModItem(TwilightForest.ID, "tile.CastleBrick", 8, 3);
        addShapedRecipe(
                TF_ROOF_TILE,
                Blocks.cobblestone,
                Blocks.stone,
                Blocks.cobblestone,
                Blocks.cobblestone,
                "dyeBlack",
                Blocks.cobblestone,
                Blocks.cobblestone,
                Blocks.cobblestone,
                Blocks.cobblestone);

        addShapedRecipe(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 12),
                getModItem(TwilightForest.ID, "tile.TFTowerStone", 1, 1),
                getModItem(TwilightForest.ID, "item.carminite", 1, 0),
                getModItem(TwilightForest.ID, "tile.TFTowerStone", 1, 1),
                getModItem(TwilightForest.ID, "item.carminite", 1, 0),
                "blockRedstone",
                getModItem(TwilightForest.ID, "item.carminite", 1, 0),
                getModItem(TwilightForest.ID, "tile.TFTowerStone", 1, 1),
                getModItem(TwilightForest.ID, "item.carminite", 1, 0),
                getModItem(TwilightForest.ID, "tile.TFTowerStone", 1, 1));
        String[] materials = new String[] { "Twilight", "Canopy", "Mangrove", "Darkwood", "Time", "Trans", "Mine",
                "Sort" };

        for (int i = 0; i < materials.length; i++) {
            addShapedRecipe(
                    getModItem(TwilightForest.ID, "tile.TFTrapDoor" + materials[i], 1, 0),
                    getModItem(TwilightForest.ID, "tile.TFWoodSlab", 1, i),
                    "stickWood",
                    getModItem(TwilightForest.ID, "tile.TFWoodSlab", 1, i),
                    "stickWood",
                    getModItem(Minecraft.ID, "flint", 1, 0),
                    "stickWood",
                    getModItem(TwilightForest.ID, "tile.TFWoodSlab", 1, i),
                    "stickWood",
                    getModItem(TwilightForest.ID, "tile.TFWoodSlab", 1, i));
            addShapedRecipe(
                    getModItem(TwilightForest.ID, "tile.TFTrapDoor" + materials[i], 2, 0),
                    getModItem(TwilightForest.ID, "tile.TFWoodSlab", 1, i),
                    "stickWood",
                    getModItem(TwilightForest.ID, "tile.TFWoodSlab", 1, i),
                    "stickWood",
                    "screwAnyIron",
                    "stickWood",
                    getModItem(TwilightForest.ID, "tile.TFWoodSlab", 1, i),
                    "stickWood",
                    getModItem(TwilightForest.ID, "tile.TFWoodSlab", 1, i));
            addShapedRecipe(
                    getModItem(TwilightForest.ID, "tile.TFTrapDoor" + materials[i], 3, 0),
                    getModItem(TwilightForest.ID, "tile.TFWoodSlab", 1, i),
                    "stickWood",
                    getModItem(TwilightForest.ID, "tile.TFWoodSlab", 1, i),
                    "stickWood",
                    "screwSteel",
                    "stickWood",
                    getModItem(TwilightForest.ID, "tile.TFWoodSlab", 1, i),
                    "stickWood",
                    getModItem(TwilightForest.ID, "tile.TFWoodSlab", 1, i));

            addShapedRecipe(
                    getModItem(TwilightForest.ID, "item.door" + materials[i], 1, 0),
                    getModItem(TwilightForest.ID, "tile.TFPlank", 1, i),
                    getModItem(TwilightForest.ID, "tile.TFTrapDoor" + materials[i], 1, 0),
                    "craftingToolScrewdriver",
                    getModItem(TwilightForest.ID, "tile.TFPlank", 1, i),
                    "ringAnyIron",
                    "screwAnyIron",
                    getModItem(TwilightForest.ID, "tile.TFPlank", 1, i),
                    getModItem(TwilightForest.ID, "tile.TFPlank", 1, i),
                    "craftingToolSaw");
            addShapedRecipe(
                    getModItem(TwilightForest.ID, "item.door" + materials[i], 1, 0),
                    getModItem(TwilightForest.ID, "tile.TFPlank", 1, i),
                    getModItem(TwilightForest.ID, "tile.TFTrapDoor" + materials[i], 1, 0),
                    "craftingToolScrewdriver",
                    getModItem(TwilightForest.ID, "tile.TFPlank", 1, i),
                    "ringCopper",
                    "screwCopper",
                    getModItem(TwilightForest.ID, "tile.TFPlank", 1, i),
                    getModItem(TwilightForest.ID, "tile.TFPlank", 1, i),
                    "craftingToolSaw");
            addShapedRecipe(
                    getModItem(TwilightForest.ID, "item.door" + materials[i], 1, 0),
                    getModItem(TwilightForest.ID, "tile.TFPlank", 1, i),
                    getModItem(TwilightForest.ID, "tile.TFTrapDoor" + materials[i], 1, 0),
                    "craftingToolSaw",
                    getModItem(TwilightForest.ID, "tile.TFPlank", 1, i),
                    "ringAnyIron",
                    "screwAnyIron",
                    getModItem(TwilightForest.ID, "tile.TFPlank", 1, i),
                    getModItem(TwilightForest.ID, "tile.TFPlank", 1, i),
                    "craftingToolScrewdriver");
            addShapedRecipe(
                    getModItem(TwilightForest.ID, "item.door" + materials[i], 1, 0),
                    getModItem(TwilightForest.ID, "tile.TFPlank", 1, i),
                    getModItem(TwilightForest.ID, "tile.TFTrapDoor" + materials[i], 1, 0),
                    "craftingToolSaw",
                    getModItem(TwilightForest.ID, "tile.TFPlank", 1, i),
                    "ringCopper",
                    "screwCopper",
                    getModItem(TwilightForest.ID, "tile.TFPlank", 1, i),
                    getModItem(TwilightForest.ID, "tile.TFPlank", 1, i),
                    "craftingToolScrewdriver");

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 4L),
                            getModItem(TwilightForest.ID, "tile.TFTrapDoor" + materials[i], 1, 0))
                    .itemOutputs(getModItem(TwilightForest.ID, "item.door" + materials[i], 1, 0))
                    .fluidInputs(Materials.Iron.getMolten(16)).duration(20 * SECONDS).eut(4).addTo(assemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 4L),
                            getModItem(TwilightForest.ID, "tile.TFTrapDoor" + materials[i], 1, 0))
                    .itemOutputs(getModItem(TwilightForest.ID, "item.door" + materials[i], 1, 0))
                    .fluidInputs(Materials.Copper.getMolten(16)).duration(20 * SECONDS).eut(4).addTo(assemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(TwilightForest.ID, "tile.TFWoodSlab", 4, i),
                            GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                    .itemOutputs(getModItem(TwilightForest.ID, "tile.TFTrapDoor" + materials[i], 4, 0))
                    .fluidInputs(Materials.Iron.getMolten(16)).duration(30 * SECONDS).eut(4).addTo(assemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(TwilightForest.ID, "tile.TFWoodSlab", 4, i),
                            GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                    .itemOutputs(getModItem(TwilightForest.ID, "tile.TFTrapDoor" + materials[i], 6, 0))
                    .fluidInputs(Materials.Steel.getMolten(16)).duration(30 * SECONDS).eut(4).addTo(assemblerRecipes);
        }

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stone", 64, 0),
                        getModItem(TwilightForest.ID, "item.trophy", 0, 1))
                .itemOutputs(getModItem(TwilightForest.ID, "tile.TFNagastoneHead", 64, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stone", 64, 0),
                        getModItem(TwilightForest.ID, "item.trophy", 0, 5))
                .itemOutputs(getModItem(TwilightForest.ID, "tile.TFMazestone", 64, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stone", 64, 0),
                        getModItem(TwilightForest.ID, "item.trophy", 0, 6))
                .itemOutputs(getModItem(TwilightForest.ID, "tile.TFUnderBrick", 64, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(TwilightForest.ID, "item.arcticFur", 9, 0))
                .itemOutputs(getModItem(TwilightForest.ID, "tile.ArcticFurBlock", 1, 0)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "cobblestone", 64, 0)).circuit(12)
                .itemOutputs(getModItem(TwilightForest.ID, "tile.GiantCobble", 1, 0)).duration(64 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "obsidian", 64, 0)).circuit(12)
                .itemOutputs(getModItem(TwilightForest.ID, "tile.GiantObsidian", 1, 0)).duration(64 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(new OreDictItemStack("logWood", 64)).circuit(12)
                .itemOutputs(getModItem(TwilightForest.ID, "tile.GiantLog", 1, 0)).duration(64 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(new OreDictItemStack("treeLeaves", 64)).circuit(12)
                .itemOutputs(getModItem(TwilightForest.ID, "tile.GiantLeaves", 1, 0)).duration(64 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);

        addShapedRecipe(
                getModItem(TwilightForest.ID, "tile.CastleDoor", 8, 0),
                getModItem(TwilightForest.ID, "tile.CastleBrick", 1, 0),
                getModItem(TwilightForest.ID, "tile.CastleBrick", 1, 0),
                getModItem(TwilightForest.ID, "tile.CastleBrick", 1, 0),
                getModItem(TwilightForest.ID, "tile.CastleBrick", 1, 0),
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 0),
                getModItem(TwilightForest.ID, "tile.CastleBrick", 1, 0),
                getModItem(TwilightForest.ID, "tile.CastleBrick", 1, 0),
                getModItem(TwilightForest.ID, "tile.CastleBrick", 1, 0),
                getModItem(TwilightForest.ID, "tile.CastleBrick", 1, 0));

        addShapedRecipe(
                getModItem(TwilightForest.ID, "tile.TFHedge", 1, 0),
                "treeLeaves",
                "treeLeaves",
                "treeLeaves",
                "treeLeaves",
                "stickWood",
                "treeLeaves",
                "treeLeaves",
                "treeLeaves",
                "treeLeaves");

        addShapedRecipe(
                getModItem(TwilightForest.ID, "tile.CastleBrick", 9, 0),
                "stoneMarble",
                "stoneMarble",
                "stoneMarble",
                "stoneMarble",
                "stoneBricks",
                "stoneMarble",
                "stoneMarble",
                "stoneMarble",
                "stoneMarble");

        addShapedRecipe(
                getModItem(TwilightForest.ID, "tile.TFNagastoneEtchedMossy", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(TwilightForest.ID, "tile.TFNagastoneEtched"),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0));

        addShapedRecipe(
                getModItem(TwilightForest.ID, "tile.TFNagastonePillarMossy", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(TwilightForest.ID, "tile.TFNagastonePillar"),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0));

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Steeleaf, 1L),
                        ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(TwilightForest.ID, "item.steeleafIngot", 1, 0)).duration(5 * SECONDS).eut(4)
                .addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "ItemResource", 2, 14),
                        getModItem(TwilightForest.ID, "item.trophy", 0, 1))
                .itemOutputs(getModItem(TwilightForest.ID, "item.nagaScale", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "ItemResource", 6, 14),
                        getModItem(TwilightForest.ID, "item.trophy", 0, 0))
                .itemOutputs(getModItem(TwilightForest.ID, "item.fieryBlood", 1, 0)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_EV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0),
                        getModItem(TwilightForest.ID, "item.trophy", 0, 3))
                .itemOutputs(getModItem(TwilightForest.ID, "item.fieryTears", 1, 0))
                .duration(1 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "ItemResource", 8, 14),
                        getModItem(TwilightForest.ID, "item.trophy", 0, 3))
                .itemOutputs(getModItem(TwilightForest.ID, "item.carminite", 1, 0)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_IV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TwilightForest.ID, "item.tfFeather", 1, 0),
                        getModItem(TwilightForest.ID, "item.torchberries", 1, 0))
                .fluidInputs(Materials.Glowstone.getMolten(144))
                .itemOutputs(getModItem(TwilightForest.ID, "item.magicMapFocus", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(ZTones.ID, "auroraBlock", 1, 0), NHItemList.StonePlate.get(16))
                .itemOutputs(getModItem(TwilightForest.ID, "tile.TFAuroraBrick", 16, 0))
                .fluidInputs(Materials.Helium3.getGas(1600), Materials.Helium.getGas(16000)).duration(3 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(mixerNonCellRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TwilightForest.ID, "item.fieryBlood", 1, 0),
                        getModItem(MagicBees.ID, "comb", 4, 7))
                .itemOutputs(getModItem(TwilightForest.ID, "item.fieryTears", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("hell_blood", 1000)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(TwilightForest.ID, "item.carminite", 9, 0))
                .itemOutputs(getModItem(TwilightForest.ID, "tile.CarminiteBlock", 1, 0)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "smoker", 1),
                        getModItem(TwilightForest.ID, "item.carminite", 1, 0),
                        getModItem(TwilightForest.ID, "tile.CastleBrick", 2, 3))
                .circuit(8).fluidInputs(new FluidStack(FluidRegistry.getFluid("water"), 1000))
                .itemOutputs(getModItem(TwilightForest.ID, "tile.TFFireJet", 1)).duration(12 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TwilightForest.ID, "tile.TFFireJet", 1),
                        new ItemStack(Items.fire_charge, 1),
                        getModItem(EtFuturumRequiem.ID, "magma", 1, 0))
                .circuit(8).fluidInputs(new FluidStack(FluidRegistry.getFluid("lava"), 1000))
                .itemOutputs(getModItem(TwilightForest.ID, "tile.TFFireJet", 1, 8)).duration(12 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFRoots", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFRoots", 1, 1),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("praecantatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "item.liveRoot", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("praecantatio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFFirefly", 1, 0),
                new AspectList().add(Aspect.getAspect("victus"), 1).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFCicada", 1, 0),
                new AspectList().add(Aspect.getAspect("victus"), 1).add(Aspect.getAspect("volatus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPortal", 1, 0),
                new AspectList().add(Aspect.getAspect("tempus"), 4).add(Aspect.getAspect("praecantatio"), 4)
                        .add(Aspect.getAspect("iter"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 1),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 2),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 3),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 4),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 5),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 6),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMazestone", 1, 7),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFHedge", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFFireflyJar", 1, 0),
                new AspectList().add(Aspect.getAspect("vitreus"), 2).add(Aspect.getAspect("arbor"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 3),
                new AspectList().add(Aspect.getAspect("herba"), 2).add(Aspect.getAspect("victus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 4),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 8),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 9),
                new AspectList().add(Aspect.getAspect("herba"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 10),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 11),
                new AspectList().add(Aspect.getAspect("herba"), 1).add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 13),
                new AspectList().add(Aspect.getAspect("herba"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 14),
                new AspectList().add(Aspect.getAspect("arbor"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFFireJet", 1, 0),
                new AspectList().add(Aspect.getAspect("ignis"), 2).add(Aspect.getAspect("aer"), 2)
                        .add(Aspect.getAspect("machina"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFFireJet", 1, 8),
                new AspectList().add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("motus"), 2)
                        .add(Aspect.getAspect("machina"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFNagastone", 1, 1),
                new AspectList().add(Aspect.getAspect("terra"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFNagastone", 1, 13),
                new AspectList().add(Aspect.getAspect("terra"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFSapling", 1, 5),
                new AspectList().add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("arbor"), 2)
                        .add(Aspect.getAspect("tempus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFSapling", 1, 6),
                new AspectList().add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("arbor"), 2)
                        .add(Aspect.getAspect("praecantatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFSapling", 1, 7),
                new AspectList().add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("arbor"), 2)
                        .add(Aspect.getAspect("perfodio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFSapling", 1, 9),
                new AspectList().add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("arbor"), 2)
                        .add(Aspect.getAspect("sensus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMoonworm", 1, 0),
                new AspectList().add(Aspect.getAspect("victus"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMagicLogSpecial", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 4).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("tempus"), 2).add(Aspect.getAspect("herba"), 2)
                        .add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMagicLogSpecial", 1, 1),
                new AspectList().add(Aspect.getAspect("arbor"), 4).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("aer"), 2).add(Aspect.getAspect("herba"), 2)
                        .add(Aspect.getAspect("invidia"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMagicLogSpecial", 1, 2),
                new AspectList().add(Aspect.getAspect("arbor"), 4).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("perfodio"), 2).add(Aspect.getAspect("herba"), 2)
                        .add(Aspect.getAspect("lucrum"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFMagicLogSpecial", 1, 3),
                new AspectList().add(Aspect.getAspect("arbor"), 4).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("motus"), 2).add(Aspect.getAspect("herba"), 2)
                        .add(Aspect.getAspect("cognitio"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 2),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("potentia"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 4),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("potentia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 5),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("potentia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 6),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("potentia"), 2).add(Aspect.getAspect("iter"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 9),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 2)
                        .add(Aspect.getAspect("potentia"), 4).add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTowerDevice", 1, 10),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 2)
                        .add(Aspect.getAspect("potentia"), 4).add(Aspect.getAspect("vinculum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFShield", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("machina"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTrophyPedestal", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 7).add(Aspect.getAspect("ordo"), 4)
                        .add(Aspect.getAspect("lucrum"), 4).add(Aspect.getAspect("instrumentum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFTrophyPedestal", 1, 15),
                new AspectList().add(Aspect.getAspect("terra"), 7).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("lucrum"), 12).add(Aspect.getAspect("instrumentum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFAuroraBrick", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFUnderBrick", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFUnderBrick", 1, 1),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFUnderBrick", 1, 2),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFThorns", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("fabrico"), 1)
                        .add(Aspect.getAspect("telum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFThorns", 1, 1),
                new AspectList().add(Aspect.getAspect("herba"), 3).add(Aspect.getAspect("fabrico"), 1)
                        .add(Aspect.getAspect("telum"), 1).add(Aspect.getAspect("aqua"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFBurntThorns", 1, 0),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFThornRose", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFLeaves3", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFLeaves3", 1, 1),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFDeadrock", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 8).add(Aspect.getAspect("ignis"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFDeadrock", 1, 1),
                new AspectList().add(Aspect.getAspect("terra"), 8).add(Aspect.getAspect("ignis"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TFDeadrock", 1, 2),
                new AspectList().add(Aspect.getAspect("terra"), 8).add(Aspect.getAspect("ignis"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.DarkLeaves", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.AuroraPillar", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.AuroraSlab", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 2).add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.AuroraDoubleSlab", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TrollSteinn", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("potentia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.WispyCloud", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 1).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("aqua"), 1).add(Aspect.getAspect("tempestas"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.FluffyCloud", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 1).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 1).add(Aspect.getAspect("tempestas"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.HugeStalk", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.UberousSoil", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("aqua"), 4)
                        .add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("victus"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.HugeGloomBlock", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("tenebrae"), 2)
                        .add(Aspect.getAspect("herba"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.KnightmetalBlock", 1, 0),
                new AspectList().add(Aspect.getAspect("metallum"), 18).add(Aspect.getAspect("lucrum"), 9));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.UnripeTrollBer", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 1).add(Aspect.getAspect("terra"), 1)
                        .add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.TrollBer", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 1).add(Aspect.getAspect("terra"), 1)
                        .add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.HugeLilyPad", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 8).add(Aspect.getAspect("aqua"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem(TwilightForest.ID, "tile.HugeWaterLily", 1, 0),
                new AspectList().add(Aspect.getAspect("herba"), 3));

        ThaumcraftApi.addCrucibleRecipe(
                "ThaumiumReinforcedWings",
                getModItem(TwilightForest.ID, "item.tfFeather", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 13),
                new AspectList().add(Aspect.getAspect("volatus"), 2).add(Aspect.getAspect("tenebrae"), 4)
                        .add(Aspect.getAspect("tempus"), 4));

    }
}
