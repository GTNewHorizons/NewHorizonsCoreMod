package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.createItemStack;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Materials.Void;
import static gregtech.api.enums.Mods.CarpentersBlocks;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.enums.Mods.TinkersGregworks;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.enums.OrePrefixes.plate;
import static gregtech.api.recipe.RecipeMaps.compressorRecipes;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidExtractionRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static thaumcraft.api.aspects.Aspect.getAspect;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.item.NHItemList;
import com.dreammaster.oredict.OreDictHelper;
import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptThaumicBases implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Thaumic Bases";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                CarpentersBlocks.ID,
                ExtraUtilities.ID,
                IndustrialCraft2.ID,
                IronTanks.ID,
                Railcraft.ID,
                Thaumcraft.ID,
                ThaumicBases.ID,
                ThaumicTinkerer.ID,
                TinkersGregworks.ID,
                TwilightForest.ID);
    }

    @Override
    public void loadRecipes() {

        addShapelessRecipe(
                getModItem(ThaumicBases.ID, "relocator", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                getModItem(ThaumicBases.ID, "relocator", 1, 6),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1));

        addShapelessRecipe(
                getModItem(ThaumicBases.ID, "relocator", 1, 6),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0),
                getModItem(ThaumicBases.ID, "relocator", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0));

        OreDictHelper.removeOreDict("gravel", getModItem(ThaumicBases.ID, "oldGravel", 1, 0));

        GTModHandler.addSmeltingRecipe(
                getModItem(ThaumicBases.ID, "quicksilverBlock", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 9, 3));
        GTModHandler.addSmeltingRecipe(
                getModItem(ThaumicBases.ID, "quicksilverBrick", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 9, 3));

        registerSlabRecipe("eldritchArk", 0, "genericSlab", 0);
        registerSlabRecipe("oldBrick", 0, "genericSlab", 1);
        registerSlabRecipe("oldCobble", 0, "genericSlab", 2);
        registerSlabRecipe("oldCobbleMossy", 0, "genericSlab", 3);
        registerSlabRecipe("crystalBlock", 0, "crystalSlab", 0);
        registerSlabRecipe("crystalBlock", 1, "crystalSlab", 1);
        registerSlabRecipe("crystalBlock", 2, "crystalSlab", 2);
        registerSlabRecipe("crystalBlock", 3, "crystalSlab", 3);
        registerSlabRecipe("crystalBlock", 4, "crystalSlab", 4);
        registerSlabRecipe("crystalBlock", 5, "crystalSlab", 5);
        registerSlabRecipe("crystalBlock", 6, "crystalSlab", 6);
        registerSlabRecipe("crystalBlock", 7, "crystalSlab", 7);

        GTValues.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "quicksilverBlock", 1, 0))
                .fluidOutputs(FluidRegistry.getFluidStack("mercury", 9000)).duration(1152).eut(4)
                .addTo(fluidExtractionRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "quicksilverBrick", 1, 0))
                .fluidOutputs(FluidRegistry.getFluidStack("mercury", 9000)).duration(1152).eut(4)
                .addTo(fluidExtractionRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "resource", 9, 1))
                .itemOutputs(getModItem(ThaumicBases.ID, "thauminiteBlock", 1, 0)).duration(8 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "relocator", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "relocator", 1, 6));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "advAlchFurnace", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "thaumicAnvil", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "resource", 1, 3));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "bloodyChest", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "bloodyLeggings", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "bloodyBoots", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "spike", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "spike", 1, 2));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "spike", 1, 4));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "voidAnvil", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "voidSeed", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "fociExperience", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "fociActivation", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "fociDrain", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "fociFlux", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "cryingObsidian", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 1));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 2));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 3));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 4));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 11));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 5));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 6));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 7));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 8));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 9));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 10));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 12));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 1));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 2));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 3));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 4));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 5));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 6));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 7));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 8));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 9));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeManipulator", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "resource", 1, 4));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "entityDeconstructor", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "nodeLinker", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "overchanter", 1, 0));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Relocator",
                getModItem(ThaumicBases.ID, "relocator", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("aqua"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                'b',
                "plateInfusedAir",
                'c',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                'e',
                "rotorThaumium",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                'g',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                'h',
                "plateInfusedWater",
                'i',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Relocator",
                getModItem(ThaumicBases.ID, "relocator", 1, 6),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("aqua"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                'b',
                "plateInfusedWater",
                'c',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0),
                'e',
                "rotorThaumium",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0),
                'g',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6),
                'h',
                "plateInfusedAir",
                'i',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6));
        TCHelper.addInfusionCraftingRecipe(
                "TB.AdvAlc",
                getModItem(ThaumicBases.ID, "advAlchFurnace", 1, 0),
                6,
                new AspectList().add(Aspect.getAspect("ignis"), 48).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("machina"), 16).add(Aspect.getAspect("metallum"), 16)
                        .add(Aspect.getAspect("praecantatio"), 24),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 0),
                getModItem(Railcraft.ID, "machine.beta", 1, 4),
                OrePrefixes.plateDense.get(Materials.Steel),
                OrePrefixes.block.get(Materials.Thaumium),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 0),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 1),
                OrePrefixes.block.get(Materials.Thaumium),
                OrePrefixes.plateDense.get(Materials.Steel));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.ThaumicAnvil",
                getModItem(ThaumicBases.ID, "thaumicAnvil", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("ignis"), 50)
                        .add(Aspect.getAspect("aqua"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                "blockThaumium",
                'b',
                "blockThaumium",
                'c',
                "blockThaumium",
                'd',
                "screwThaumium",
                'e',
                "blockThaumium",
                'f',
                "screwThaumium",
                'g',
                "plateThaumium",
                'h',
                "blockThaumium",
                'i',
                "plateThaumium");
        TCHelper.addInfusionCraftingRecipe(
                "ROD_tbthaumium",
                getModItem(ThaumicBases.ID, "resource", 1, 3),
                6,
                new AspectList().add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("auram"), 16)
                        .add(Aspect.getAspect("metallum"), 16).add(Aspect.getAspect("vitreus"), 16)
                        .add(Aspect.getAspect("instrumentum"), 32),
                OrePrefixes.stick.get(Materials.Thaumium),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                OrePrefixes.dust.get(Materials.Thaumium),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                OrePrefixes.dust.get(Materials.Thaumium),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                OrePrefixes.dust.get(Materials.Thaumium),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                OrePrefixes.dust.get(Materials.Thaumium),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                OrePrefixes.dust.get(Materials.Thaumium),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                OrePrefixes.dust.get(Materials.Thaumium));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.BloodyRobes",
                getModItem(ThaumicBases.ID, "bloodyChest", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 25).add(Aspect.getAspect("ignis"), 25)
                        .add(Aspect.getAspect("aqua"), 25).add(Aspect.getAspect("ordo"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(ThaumicBases.ID, "resource", 1, 8),
                'b',
                "plateThaumium",
                'c',
                getModItem(ThaumicBases.ID, "resource", 1, 8),
                'd',
                getModItem(ThaumicBases.ID, "resource", 1, 8),
                'e',
                "plateThaumium",
                'f',
                getModItem(ThaumicBases.ID, "resource", 1, 8),
                'g',
                getModItem(ThaumicBases.ID, "resource", 1, 8),
                'h',
                getModItem(ThaumicBases.ID, "resource", 1, 8),
                'i',
                getModItem(ThaumicBases.ID, "resource", 1, 8));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.BloodyRobes",
                getModItem(ThaumicBases.ID, "bloodyLeggings", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 25).add(Aspect.getAspect("ignis"), 25)
                        .add(Aspect.getAspect("aqua"), 25).add(Aspect.getAspect("perditio"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(ThaumicBases.ID, "resource", 1, 8),
                'b',
                getModItem(ThaumicBases.ID, "resource", 1, 8),
                'c',
                getModItem(ThaumicBases.ID, "resource", 1, 8),
                'd',
                getModItem(ThaumicBases.ID, "resource", 1, 8),
                'e',
                "plateThaumium",
                'f',
                getModItem(ThaumicBases.ID, "resource", 1, 8),
                'g',
                getModItem(ThaumicBases.ID, "resource", 1, 8),
                'h',
                "plateThaumium",
                'i',
                getModItem(ThaumicBases.ID, "resource", 1, 8));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.BloodyRobes",
                getModItem(ThaumicBases.ID, "bloodyBoots", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 25).add(Aspect.getAspect("ignis"), 25)
                        .add(Aspect.getAspect("aqua"), 25).add(Aspect.getAspect("terra"), 25),
                "abc",
                "def",
                "ghi",
                'd',
                getModItem(ThaumicBases.ID, "resource", 1, 8),
                'e',
                "plateThaumium",
                'f',
                getModItem(ThaumicBases.ID, "resource", 1, 8),
                'g',
                getModItem(ThaumicBases.ID, "resource", 1, 8),
                'h',
                "plateThaumium",
                'i',
                getModItem(ThaumicBases.ID, "resource", 1, 8));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Spike.Iron",
                getModItem(ThaumicBases.ID, "spike", 1, 0),
                new AspectList().add(Aspect.getAspect("perditio"), 20).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("terra"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolSaw",
                'c',
                "craftingToolScrewdriver",
                'd',
                "screwSteel",
                'e',
                "ingotSteel",
                'f',
                "screwSteel",
                'g',
                "ingotSteel",
                'h',
                "blockSteel",
                'i',
                "ingotSteel");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Spike.Thaumic",
                getModItem(ThaumicBases.ID, "spike", 1, 2),
                new AspectList().add(Aspect.getAspect("perditio"), 50).add(Aspect.getAspect("ignis"), 50)
                        .add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("terra"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolSaw",
                'c',
                "craftingToolScrewdriver",
                'd',
                "screwThaumium",
                'e',
                "ingotThaumium",
                'f',
                "screwThaumium",
                'g',
                "ingotThaumium",
                'h',
                "blockThaumium",
                'i',
                "ingotThaumium");
        TCHelper.addInfusionCraftingRecipe(
                "TB.Spike.Void",
                getModItem(ThaumicBases.ID, "spike", 1, 4),
                5,
                new AspectList().add(getAspect("telum"), 32).add(getAspect("instrumentum"), 32)
                        .add(getAspect("tenebrae"), 16).add(getAspect("alienis"), 16).add(getAspect("metallum"), 16)
                        .add(getAspect("mortuus"), 16),
                getModItem(ThaumicBases.ID, "spike", 1, 2),
                plate.get(Void),
                createItemStack(TinkersGregworks.ID, "tGregToolPartArrowHead", 1, 1520, "{material:\"Titanium\"}"),
                getModItem(Thaumcraft.ID, "ItemSwordVoid", 1, 0),
                getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0),
                plate.get(Void),
                getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0),
                getModItem(Thaumcraft.ID, "ItemSwordVoid", 1, 0),
                createItemStack(TinkersGregworks.ID, "tGregToolPartArrowHead", 1, 1583, "{material:\"Void\"}"),
                plate.get(Void));
        TCHelper.addInfusionCraftingRecipe(
                "TB.VoidAnvil",
                getModItem(ThaumicBases.ID, "voidAnvil", 1, 0),
                9,
                new AspectList().add(Aspect.getAspect("telum"), 32).add(Aspect.getAspect("instrumentum"), 32)
                        .add(Aspect.getAspect("fabrico"), 32).add(Aspect.getAspect("alienis"), 32)
                        .add(Aspect.getAspect("tenebrae"), 16).add(Aspect.getAspect("vacuos"), 16)
                        .add(Aspect.getAspect("metallum"), 16).add(Aspect.getAspect("praecantatio"), 16),
                getModItem(ThaumicBases.ID, "thaumicAnvil", 1, 0),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(ThaumicBases.ID, "voidBlock", 1, 0),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(ThaumicBases.ID, "voidBlock", 1, 0),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(ThaumicBases.ID, "voidBlock", 1, 0),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(ThaumicBases.ID, "voidBlock", 1, 0),
                OrePrefixes.plate.get(Materials.Void));
        TCHelper.addInfusionCraftingRecipe(
                "TB.VoidSeed",
                getModItem(ThaumicBases.ID, "voidSeed", 1, 0),
                10,
                new AspectList().add(Aspect.getAspect("messis"), 64).add(Aspect.getAspect("herba"), 64)
                        .add(Aspect.getAspect("victus"), 32).add(Aspect.getAspect("auram"), 32)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("alienis"), 16)
                        .add(Aspect.getAspect("tenebrae"), 16).add(Aspect.getAspect("desidia"), 8)
                        .add(Aspect.getAspect("nebrisum"), 8),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 17),
                getModItem(ThaumicBases.ID, "lazulliaSeeds", 1, 0),
                getModItem(ThaumicBases.ID, "lucriteSeeds", 1, 0),
                getModItem(ThaumicBases.ID, "redlonSeeds", 1, 0),
                getModItem(ThaumicBases.ID, "rainbowCactus", 1, 0),
                getModItem(ThaumicBases.ID, "metalleatSeeds", 1, 0),
                getModItem(ThaumicBases.ID, "plaxSeed", 1, 0),
                getModItem(ThaumicBases.ID, "briar", 1, 0),
                getModItem(ThaumicBases.ID, "aurelia", 1, 0),
                getModItem(ThaumicBases.ID, "ashroom", 1, 0),
                getModItem(ThaumicBases.ID, "knoseSeed", 1, 0),
                getModItem(ThaumicBases.ID, "flaxium", 1, 0),
                getModItem(ThaumicBases.ID, "glieoniaSeed", 1, 0));
        TCHelper.addInfusionCraftingRecipe(
                "CAP_thauminite",
                getModItem(ThaumicBases.ID, "resource", 1, 2),
                6,
                new AspectList().add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("auram"), 16)
                        .add(Aspect.getAspect("metallum"), 16).add(Aspect.getAspect("vitreus"), 16)
                        .add(Aspect.getAspect("instrumentum"), 32),
                getModItem(Thaumcraft.ID, "WandCap", 1, 2),
                getModItem(ThaumicBases.ID, "resource", 1, 1),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3),
                getModItem(ThaumicBases.ID, "resource", 1, 1),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3),
                getModItem(ThaumicBases.ID, "resource", 1, 1),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3));
        TCHelper.addInfusionCraftingRecipe(
                "TB.Foci.Experience",
                getModItem(ThaumicBases.ID, "fociExperience", 1, 0),
                6,
                new AspectList().add(Aspect.getAspect("lucrum"), 32).add(Aspect.getAspect("vitreus"), 32)
                        .add(Aspect.getAspect("cognitio"), 16).add(Aspect.getAspect("permutatio"), 16),
                OrePrefixes.lens.get(Materials.Emerald),
                getModItem(Thaumcraft.ID, "FocusExcavation", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                OrePrefixes.gemFlawless.get(Materials.Emerald),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                OrePrefixes.gemFlawless.get(Materials.Emerald),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3));
        TCHelper.addInfusionCraftingRecipe(
                "TB.Foci.Activation",
                getModItem(ThaumicBases.ID, "fociActivation", 1, 0),
                4,
                new AspectList().add(Aspect.getAspect("motus"), 32).add(Aspect.getAspect("vitreus"), 32)
                        .add(Aspect.getAspect("iter"), 16).add(Aspect.getAspect("sensus"), 16),
                OrePrefixes.lens.get(Materials.InfusedOrder),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                ItemList.Emitter_LV.get(1L),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                ItemList.Sensor_LV.get(1L),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4));
        TCHelper.addInfusionCraftingRecipe(
                "TB.Foci.Drain",
                getModItem(ThaumicBases.ID, "fociDrain", 1, 0),
                5,
                new AspectList().add(Aspect.getAspect("vacuos"), 32).add(Aspect.getAspect("perditio"), 32)
                        .add(Aspect.getAspect("aqua"), 16),
                OrePrefixes.lens.get(Materials.InfusedWater),
                getModItem(Minecraft.ID, "bucket", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                getModItem(Thaumcraft.ID, "blockJar", 1, 3),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                getModItem(IronTanks.ID, "ironTank", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                getModItem(ExtraUtilities.ID, "trashcan", 1, 1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2));
        TCHelper.addInfusionCraftingRecipe(
                "TB.Foci.Flux",
                getModItem(ThaumicBases.ID, "fociFlux", 1, 0),
                7,
                new AspectList().add(Aspect.getAspect("vitium"), 32).add(Aspect.getAspect("perditio"), 32)
                        .add(Aspect.getAspect("ordo"), 16).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("sano"), 16),
                OrePrefixes.lens.get(Materials.EnderEye),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 4),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 14),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6));
        TCHelper.addInfusionCraftingRecipe(
                "TB.CryingObs",
                getModItem(ThaumicBases.ID, "cryingObsidian", 1, 0),
                5,
                new AspectList().add(Aspect.getAspect("iter"), 32).add(Aspect.getAspect("vinculum"), 32)
                        .add(Aspect.getAspect("desidia"), 16).add(Aspect.getAspect("sensus"), 16),
                GregtechItemList.DoubleCompressedObsidian.get(1),
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 8),
                getModItem(CarpentersBlocks.ID, "itemCarpentersBed", 1, 0),
                OrePrefixes.gemFlawless.get(Materials.Diamond),
                OrePrefixes.plateDense.get(Materials.Thaumium));
        TCHelper.addInfusionCraftingRecipe(
                "TB.TaintFlask",
                getModItem(ThaumicBases.ID, "concentratedTaint", 1, 0),
                10,
                new AspectList().add(Aspect.getAspect("vitium"), 64).add(Aspect.getAspect("venenum"), 32)
                        .add(Aspect.getAspect("perditio"), 16),
                getModItem(Thaumcraft.ID, "ItemBottleTaint", 1, 0),
                getModItem(ThaumicBases.ID, "knoseFragment", 1, 7),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(ThaumicBases.ID, "knoseFragment", 1, 7),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(ThaumicBases.ID, "knoseFragment", 1, 7));
        TCHelper.addInfusionCraftingRecipe(
                "TB.EntityDec",
                getModItem(ThaumicBases.ID, "entityDeconstructor", 1, 0),
                5,
                new AspectList().add(Aspect.getAspect("cognitio"), 32).add(Aspect.getAspect("spiritus"), 24)
                        .add(Aspect.getAspect("mortuus"), 16).add(Aspect.getAspect("praecantatio"), 16),
                getModItem(Thaumcraft.ID, "blockTable", 1, 14),
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0),
                OrePrefixes.lens.get(Materials.InfusedAir),
                OrePrefixes.lens.get(Materials.InfusedFire),
                OrePrefixes.lens.get(Materials.InfusedWater),
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0),
                OrePrefixes.lens.get(Materials.InfusedEarth),
                OrePrefixes.lens.get(Materials.InfusedEntropy),
                OrePrefixes.lens.get(Materials.InfusedOrder));
        TCHelper.addInfusionCraftingRecipe(
                "ROD_tbvoid",
                getModItem(ThaumicBases.ID, "resource", 1, 4),
                8,
                new AspectList().add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("auram"), 32)
                        .add(Aspect.getAspect("vitreus"), 16).add(Aspect.getAspect("instrumentum"), 32)
                        .add(Aspect.getAspect("potentia"), 40).add(Aspect.getAspect("vacuos"), 24),
                getModItem(ThaumicBases.ID, "resource", 1, 3),
                getModItem(ThaumicBases.ID, "knoseFragment", 1, 7),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 7),
                getModItem(ThaumicBases.ID, "knoseFragment", 1, 7),
                getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 7),
                getModItem(ThaumicBases.ID, "knoseFragment", 1, 7),
                getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0),
                OrePrefixes.plate.get(Materials.Void));
        TCHelper.addInfusionCraftingRecipe(
                "TB.NodeMan",
                getModItem(ThaumicBases.ID, "nodeManipulator", 1, 0),
                9,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("auram"), 48)
                        .add(Aspect.getAspect("praecantatio"), 40).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("vacuos"), 32).add(Aspect.getAspect("tenebrae"), 24),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 11),
                getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0),
                ItemList.Emitter_EV.get(1L),
                OrePrefixes.plate.get(Materials.Knightmetal),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 10),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 10),
                ItemList.Sensor_EV.get(1L),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 14),
                ItemList.Sensor_EV.get(1L),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 10),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 10),
                OrePrefixes.plate.get(Materials.Knightmetal),
                ItemList.Emitter_EV.get(1L));
        TCHelper.addInfusionCraftingRecipe(
                "TB.NodeLinker",
                getModItem(ThaumicBases.ID, "nodeLinker", 1, 0),
                5,
                new AspectList().add(Aspect.getAspect("potentia"), 64).add(Aspect.getAspect("machina"), 48)
                        .add(Aspect.getAspect("instrumentum"), 40).add(Aspect.getAspect("ordo"), 32)
                        .add(Aspect.getAspect("electrum"), 32),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 11),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 14),
                ItemList.Emitter_MV.get(1L),
                NHItemList.ReinforcedGlassLense.get(),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                NHItemList.ReinforcedGlassLense.get(),
                ItemList.Emitter_MV.get(1L));
        TCHelper.addInfusionCraftingRecipe(
                "TB.Overchanter",
                getModItem(ThaumicBases.ID, "overchanter", 1, 0),
                15,
                new AspectList().add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("aqua"), 32)
                        .add(Aspect.getAspect("terra"), 32).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("perditio"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("machina"), 32)
                        .add(Aspect.getAspect("cognitio"), 32),
                getModItem(Minecraft.ID, "enchanting_table", 1, 0),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 0),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 1),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 2),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 3),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 4),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 5),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 6),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 6),
                getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0),
                OrePrefixes.block.get(Materials.Thaumium),
                OrePrefixes.block.get(Materials.Thaumium));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Iron",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("aqua"), 30).add(Aspect.getAspect("terra"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                "screwAluminium",
                'b',
                getModItem(TwilightForest.ID, "item.nagaScale", 1, 0),
                'c',
                "screwAluminium",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 0),
                'e',
                "stickIron",
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 0),
                'g',
                "boltIron",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltIron");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Gold",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 1),
                new AspectList().add(Aspect.getAspect("aer"), 60).add(Aspect.getAspect("ignis"), 60)
                        .add(Aspect.getAspect("aqua"), 60).add(Aspect.getAspect("terra"), 60)
                        .add(Aspect.getAspect("ordo"), 60).add(Aspect.getAspect("perditio"), 60),
                "abc",
                "def",
                "ghi",
                'a',
                "screwStainlessSteel",
                'b',
                NHItemList.LichBone.get(),
                'c',
                "screwStainlessSteel",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 1),
                'e',
                "stickGold",
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 1),
                'g',
                "boltGold",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltGold");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Greatwood",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 2),
                new AspectList().add(Aspect.getAspect("aer"), 90).add(Aspect.getAspect("ignis"), 90)
                        .add(Aspect.getAspect("aqua"), 90).add(Aspect.getAspect("terra"), 90)
                        .add(Aspect.getAspect("ordo"), 90).add(Aspect.getAspect("perditio"), 90),
                "abc",
                "def",
                "ghi",
                'a',
                "screwStainlessSteel",
                'b',
                NHItemList.LichBone.get(),
                'c',
                "screwStainlessSteel",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 1),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 0),
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 1),
                'g',
                "boltRoseGold",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltRoseGold");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Reed",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 5),
                new AspectList().add(Aspect.getAspect("aer"), 120).add(Aspect.getAspect("ignis"), 120)
                        .add(Aspect.getAspect("aqua"), 120).add(Aspect.getAspect("terra"), 120)
                        .add(Aspect.getAspect("ordo"), 120).add(Aspect.getAspect("perditio"), 120),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTitanium",
                'b',
                getModItem(TwilightForest.ID, "item.fieryBlood", 1, 0),
                'c',
                "screwTitanium",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 5),
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2),
                'g',
                "boltThaumium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Bone",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 6),
                new AspectList().add(Aspect.getAspect("aer"), 120).add(Aspect.getAspect("ignis"), 120)
                        .add(Aspect.getAspect("aqua"), 120).add(Aspect.getAspect("terra"), 120)
                        .add(Aspect.getAspect("ordo"), 120).add(Aspect.getAspect("perditio"), 120),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTitanium",
                'b',
                getModItem(TwilightForest.ID, "item.fieryBlood", 1, 0),
                'c',
                "screwTitanium",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 7),
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2),
                'g',
                "boltThaumium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Obsidian",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 7),
                new AspectList().add(Aspect.getAspect("aer"), 120).add(Aspect.getAspect("ignis"), 120)
                        .add(Aspect.getAspect("aqua"), 120).add(Aspect.getAspect("terra"), 120)
                        .add(Aspect.getAspect("ordo"), 120).add(Aspect.getAspect("perditio"), 120),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTitanium",
                'b',
                getModItem(TwilightForest.ID, "item.fieryBlood", 1, 0),
                'c',
                "screwTitanium",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 1),
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2),
                'g',
                "boltThaumium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Blaze",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 8),
                new AspectList().add(Aspect.getAspect("aer"), 120).add(Aspect.getAspect("ignis"), 120)
                        .add(Aspect.getAspect("aqua"), 120).add(Aspect.getAspect("terra"), 120)
                        .add(Aspect.getAspect("ordo"), 120).add(Aspect.getAspect("perditio"), 120),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTitanium",
                'b',
                getModItem(TwilightForest.ID, "item.fieryBlood", 1, 0),
                'c',
                "screwTitanium",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 6),
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2),
                'g',
                "boltThaumium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Ice",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 9),
                new AspectList().add(Aspect.getAspect("aer"), 120).add(Aspect.getAspect("ignis"), 120)
                        .add(Aspect.getAspect("aqua"), 120).add(Aspect.getAspect("terra"), 120)
                        .add(Aspect.getAspect("ordo"), 120).add(Aspect.getAspect("perditio"), 120),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTitanium",
                'b',
                getModItem(TwilightForest.ID, "item.fieryBlood", 1, 0),
                'c',
                "screwTitanium",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 3),
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2),
                'g',
                "boltThaumium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Quartz",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 10),
                new AspectList().add(Aspect.getAspect("aer"), 120).add(Aspect.getAspect("ignis"), 120)
                        .add(Aspect.getAspect("aqua"), 120).add(Aspect.getAspect("terra"), 120)
                        .add(Aspect.getAspect("ordo"), 120).add(Aspect.getAspect("perditio"), 120),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTitanium",
                'b',
                getModItem(TwilightForest.ID, "item.fieryBlood", 1, 0),
                'c',
                "screwTitanium",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 4),
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2),
                'g',
                "boltThaumium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Thaumium",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 3),
                new AspectList().add(Aspect.getAspect("aer"), 135).add(Aspect.getAspect("ignis"), 135)
                        .add(Aspect.getAspect("aqua"), 135).add(Aspect.getAspect("terra"), 135)
                        .add(Aspect.getAspect("ordo"), 135).add(Aspect.getAspect("perditio"), 135),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTitanium",
                'b',
                getModItem(TwilightForest.ID, "item.fieryTears", 1, 0),
                'c',
                "screwTitanium",
                'd',
                getModItem(ThaumicBases.ID, "resource", 1, 2),
                'e',
                getModItem(ThaumicBases.ID, "resource", 1, 3),
                'f',
                getModItem(ThaumicBases.ID, "resource", 1, 2),
                'g',
                "boltThaumium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Silverwood",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 4),
                new AspectList().add(Aspect.getAspect("aer"), 150).add(Aspect.getAspect("ignis"), 150)
                        .add(Aspect.getAspect("aqua"), 150).add(Aspect.getAspect("terra"), 150)
                        .add(Aspect.getAspect("ordo"), 150).add(Aspect.getAspect("perditio"), 150),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTungstenSteel",
                'b',
                getModItem(TwilightForest.ID, "item.carminite", 1, 0),
                'c',
                "screwTungstenSteel",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 7),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 2),
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 7),
                'g',
                "boltVoid",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltVoid");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Void",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 11),
                new AspectList().add(Aspect.getAspect("aer"), 150).add(Aspect.getAspect("ignis"), 150)
                        .add(Aspect.getAspect("aqua"), 150).add(Aspect.getAspect("terra"), 150)
                        .add(Aspect.getAspect("ordo"), 150).add(Aspect.getAspect("perditio"), 150),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTungstenSteel",
                'b',
                getModItem(TwilightForest.ID, "item.carminite", 1, 0),
                'c',
                "screwTungstenSteel",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 7),
                'e',
                getModItem(ThaumicBases.ID, "resource", 1, 4),
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 7),
                'g',
                "boltVoid",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltVoid");
        TCHelper.addInfusionCraftingRecipe(
                "TB.Bracelet.Primal",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 12),
                10,
                new AspectList().add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("ignis"), 64)
                        .add(Aspect.getAspect("aqua"), 64).add(Aspect.getAspect("terra"), 64)
                        .add(Aspect.getAspect("ordo"), 64).add(Aspect.getAspect("perditio"), 64)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("alienis"), 32),
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 4),
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 4),
                NHItemList.SnowQueenBlood.get(),
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 5),
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 6),
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 7),
                OrePrefixes.screw.get(Materials.Iridium),
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 4),
                OrePrefixes.screw.get(Materials.Iridium),
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 8),
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 9),
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 10),
                NHItemList.SnowQueenBlood.get());
        TCHelper.addInfusionCraftingRecipe(
                "TB.NodeFoci.Bright",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 0),
                10,
                new AspectList().add(Aspect.getAspect("auram"), 256).add(Aspect.getAspect("lux"), 192)
                        .add(Aspect.getAspect("potentia"), 128).add(Aspect.getAspect("superbia"), 64)
                        .add(Aspect.getAspect("nebrisum"), 32),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3),
                getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 7),
                getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 7),
                getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 7),
                getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0));
        TCHelper.addInfusionCraftingRecipe(
                "TB.NodeFoci.Destr",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 1),
                8,
                new AspectList().add(Aspect.getAspect("auram"), 128).add(Aspect.getAspect("perditio"), 96)
                        .add(Aspect.getAspect("vacuos"), 64).add(Aspect.getAspect("mortuus"), 32),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12),
                getModItem(Thaumcraft.ID, "FocusPrimal", 1, 0),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 5),
                GregtechItemList.DoubleCompressedObsidian.get(1),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 5),
                GregtechItemList.DoubleCompressedObsidian.get(1),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 5),
                GregtechItemList.DoubleCompressedObsidian.get(1),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 5));
        TCHelper.addInfusionCraftingRecipe(
                "TB.NodeFoci.Efficiency",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 2),
                7,
                new AspectList().add(Aspect.getAspect("auram"), 128).add(Aspect.getAspect("potentia"), 96)
                        .add(Aspect.getAspect("electrum"), 64).add(Aspect.getAspect("machina"), 64),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 1),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 9),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 1),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 9),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 1),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 9),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 1));
        TCHelper.addInfusionCraftingRecipe(
                "TB.NodeFoci.Hunger",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 3),
                10,
                new AspectList().add(Aspect.getAspect("auram"), 256).add(Aspect.getAspect("fames"), 192)
                        .add(Aspect.getAspect("lucrum"), 128).add(Aspect.getAspect("vacuos"), 96)
                        .add(Aspect.getAspect("gula"), 64),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0),
                getModItem(ThaumicBases.ID, "voidBlock", 1, 0),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 11),
                getModItem(ThaumicBases.ID, "voidBlock", 1, 0),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 11),
                getModItem(ThaumicBases.ID, "voidBlock", 1, 0),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 11),
                getModItem(ThaumicBases.ID, "voidBlock", 1, 0));
        TCHelper.addInfusionCraftingRecipe(
                "TB.NodeFoci.Unstable",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 4),
                8,
                new AspectList().add(Aspect.getAspect("auram"), 128).add(Aspect.getAspect("alienis"), 96)
                        .add(Aspect.getAspect("vacuos"), 64).add(Aspect.getAspect("perditio"), 32),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12),
                getModItem(Minecraft.ID, "ender_pearl", 1, 0),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 2),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 7),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 2),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 7),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 2),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 7),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 2));
        TCHelper.addInfusionCraftingRecipe(
                "TB.NodeFoci.Purity",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 5),
                8,
                new AspectList().add(Aspect.getAspect("auram"), 128).add(Aspect.getAspect("sano"), 96)
                        .add(Aspect.getAspect("victus"), 64).add(Aspect.getAspect("vitreus"), 32),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 6),
                getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 1),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 6),
                getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 1),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 6),
                getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 1),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 6));
        TCHelper.addInfusionCraftingRecipe(
                "TB.NodeFoci.Sinister",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 6),
                9,
                new AspectList().add(Aspect.getAspect("auram"), 128).add(Aspect.getAspect("tenebrae"), 96)
                        .add(Aspect.getAspect("exanimis"), 64).add(Aspect.getAspect("spiritus"), 32),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12),
                getModItem(Thaumcraft.ID, "ItemCompassStone", 1, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1),
                getModItem(Minecraft.ID, "skull", 1, 1),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1),
                getModItem(Minecraft.ID, "skull", 1, 1),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1),
                getModItem(Minecraft.ID, "skull", 1, 1),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1));
        TCHelper.addInfusionCraftingRecipe(
                "TB.NodeFoci.Speed",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 7),
                8,
                new AspectList().add(Aspect.getAspect("auram"), 128).add(Aspect.getAspect("potentia"), 96)
                        .add(Aspect.getAspect("motus"), 64).add(Aspect.getAspect("aer"), 32),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12),
                getModItem(Minecraft.ID, "sugar", 1, 0),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 2),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 2),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 2),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 0));
        TCHelper.addInfusionCraftingRecipe(
                "TB.NodeFoci.Stability",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 8),
                7,
                new AspectList().add(Aspect.getAspect("auram"), 128).add(Aspect.getAspect("cognitio"), 96)
                        .add(Aspect.getAspect("instrumentum"), 64).add(Aspect.getAspect("ordo"), 32),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 10),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 4),
                getModItem(ThaumicBases.ID, "thauminiteBlock", 1, 0),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 4),
                getModItem(ThaumicBases.ID, "thauminiteBlock", 1, 0),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 4),
                getModItem(ThaumicBases.ID, "thauminiteBlock", 1, 0),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 4));
        TCHelper.addInfusionCraftingRecipe(
                "TB.NodeFoci.Taint",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 9),
                10,
                new AspectList().add(Aspect.getAspect("auram"), 256).add(Aspect.getAspect("vitium"), 192)
                        .add(Aspect.getAspect("venenum"), 128).add(Aspect.getAspect("perditio"), 64)
                        .add(Aspect.getAspect("strontio"), 32),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 11),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 7),
                getModItem(ThaumicBases.ID, "concentratedTaint", 1, 0),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 7),
                getModItem(ThaumicBases.ID, "concentratedTaint", 1, 0),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 7),
                getModItem(ThaumicBases.ID, "concentratedTaint", 1, 0),
                getModItem(ThaumicBases.ID, "crystalBlock", 1, 7));
        ThaumcraftApi.addCrucibleRecipe(
                "TB.SM",
                getModItem(Thaumcraft.ID, "ItemResource", 2, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                new AspectList().add(Aspect.getAspect("aer"), 4).add(Aspect.getAspect("aqua"), 4)
                        .add(Aspect.getAspect("ignis"), 4).add(Aspect.getAspect("praecantatio"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("perditio"), 4)
                        .add(Aspect.getAspect("terra"), 4));
        ThaumcraftApi.addCrucibleRecipe(
                "TB.Amber",
                getModItem(Thaumcraft.ID, "ItemResource", 1, 6),
                getModItem(Minecraft.ID, "sapling", 1, 1),
                new AspectList().add(Aspect.getAspect("vinculum"), 4));
        ThaumcraftApi.addCrucibleRecipe(
                "TB.Quicksilver",
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3),
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 1),
                new AspectList().add(Aspect.getAspect("ordo"), 1).add(Aspect.getAspect("venenum"), 1));
        CrucibleRecipe leatherHelmetBP = ThaumcraftApi.addCrucibleRecipe(
                "TB.Backprocessing",
                getModItem(Minecraft.ID, "leather", 5),
                getModItem(Minecraft.ID, "leather_helmet", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 1)
                        .add(Aspect.getAspect("tutamen"), 1).add(Aspect.getAspect("perditio"), 1));
        CrucibleRecipe leatherChestplateBP = ThaumcraftApi.addCrucibleRecipe(
                "TB.Backprocessing",
                getModItem(Minecraft.ID, "leather", 8),
                getModItem(Minecraft.ID, "leather_chestplate", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 1)
                        .add(Aspect.getAspect("tutamen"), 1).add(Aspect.getAspect("perditio"), 1));
        CrucibleRecipe leatherLeggingsBP = ThaumcraftApi.addCrucibleRecipe(
                "TB.Backprocessing",
                getModItem(Minecraft.ID, "leather", 7),
                getModItem(Minecraft.ID, "leather_leggings", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 1)
                        .add(Aspect.getAspect("tutamen"), 1).add(Aspect.getAspect("perditio"), 1));
        CrucibleRecipe leatherBootsBP = ThaumcraftApi.addCrucibleRecipe(
                "TB.Backprocessing",
                getModItem(Minecraft.ID, "leather", 4),
                getModItem(Minecraft.ID, "leather_boots", 1, 0),
                new AspectList().add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 1)
                        .add(Aspect.getAspect("tutamen"), 1).add(Aspect.getAspect("perditio"), 1));

        TCHelper.addResearchPage("TB.Backprocessing", new ResearchPage(Objects.requireNonNull(leatherHelmetBP)));
        TCHelper.addResearchPage("TB.Backprocessing", new ResearchPage(Objects.requireNonNull(leatherChestplateBP)));
        TCHelper.addResearchPage("TB.Backprocessing", new ResearchPage(Objects.requireNonNull(leatherLeggingsBP)));
        TCHelper.addResearchPage("TB.Backprocessing", new ResearchPage(Objects.requireNonNull(leatherBootsBP)));
        TCHelper.refreshResearchPages("TB.Relocator");
        TCHelper.clearPages("TB.Knose");
        TCHelper.addResearchPage("TB.Knose", new ResearchPage("tb.rec.knose.page.0"));
        TCHelper.addResearchPage("TB.Knose", new ResearchPage("tb.rec.knose.page.1NH"));
        TCHelper.addResearchPage(
                "TB.Knose",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findCrucibleRecipe(getModItem(ThaumicBases.ID, "knoseSeed", 1, 0)))));
        TCHelper.refreshResearchPages("TB.Knose");
        TCHelper.clearPages("TB.AdvAlc");
        TCHelper.addResearchPage("TB.AdvAlc", new ResearchPage("tb.rec.advAlc.page.0"));
        TCHelper.addResearchPage(
                "TB.AdvAlc",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ThaumicBases.ID, "advAlchFurnace", 1, 0))));
        TCHelper.refreshResearchPages("TB.ThaumicAnvil");
        ThaumcraftApi.addWarpToResearch("TB.ThaumicAnvil", 1);
        TCHelper.clearPages("ROD_tbthaumium");
        TCHelper.addResearchPage("ROD_tbthaumium", new ResearchPage("tb.rec.thaumRod.page.0"));
        TCHelper.addResearchPage(
                "ROD_tbthaumium",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ThaumicBases.ID, "resource", 1, 3))));
        TCHelper.refreshResearchPages("TB.BloodyRobes");
        ThaumcraftApi.addWarpToResearch("TB.BloodyRobes", 3);
        TCHelper.refreshResearchPages("TB.Spike.Iron");
        TCHelper.refreshResearchPages("TB.Spike.Thaumic");
        ThaumcraftApi.addWarpToResearch("TB.Spike.Thaumic", 2);
        TCHelper.clearPages("TB.Spike.Void");
        TCHelper.addResearchPage("TB.Spike.Void", new ResearchPage("tb.rec.spikeVoid.page.0"));
        TCHelper.addResearchPage(
                "TB.Spike.Void",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ThaumicBases.ID, "spike", 1, 4))));
        ThaumcraftApi.addWarpToResearch("TB.Spike.Void", 3);
        TCHelper.refreshResearchPages("TB.VoidAnvil");
        ThaumcraftApi.addWarpToResearch("TB.VoidAnvil", 4);
        TCHelper.refreshResearchPages("TB.VoidSeed");
        ThaumcraftApi.addWarpToResearch("TB.VoidSeed", 5);
        TCHelper.clearPages("CAP_thauminite");
        TCHelper.addResearchPage("CAP_thauminite", new ResearchPage("tb.rec.capthauminite.page.NH.0"));
        TCHelper.addResearchPage("CAP_thauminite", new ResearchPage("tb.rec.capthauminite.page.NH.1"));
        TCHelper.addResearchPage(
                "CAP_thauminite",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ThaumicBases.ID, "resource", 1, 2))));
        ThaumcraftApi.addWarpToResearch("CAP_thauminite", 2);
        TCHelper.refreshResearchPages("TB.Foci.Experience");
        TCHelper.refreshResearchPages("TB.Foci.Activation");
        TCHelper.refreshResearchPages("TB.Foci.Drain");
        TCHelper.refreshResearchPages("TB.Foci.Flux");
        TCHelper.refreshResearchPages("TB.CryingObs");
        TCHelper.refreshResearchPages("TB.Bracelet.Iron");
        TCHelper.refreshResearchPages("TB.Bracelet.Gold");
        TCHelper.refreshResearchPages("TB.Bracelet.Greatwood");
        TCHelper.refreshResearchPages("TB.Bracelet.Thaumium");
        TCHelper.refreshResearchPages("TB.Bracelet.Primal");
        TCHelper.clearPages("TB.Bracelet.Silverwood");
        TCHelper.addResearchPage("TB.Bracelet.Silverwood", new ResearchPage("tb.rec.bracelet.silverwood.page.0"));
        TCHelper.addResearchPage(
                "TB.Bracelet.Silverwood",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 4))));
        TCHelper.clearPages("TB.Bracelet.Void");
        TCHelper.addResearchPage("TB.Bracelet.Void", new ResearchPage("tb.rec.bracelet.void.page.0"));
        TCHelper.addResearchPage(
                "TB.Bracelet.Void",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 11))));
        TCHelper.clearPages("TB.Bracelet.Blaze");
        TCHelper.addResearchPage("TB.Bracelet.Blaze", new ResearchPage("tb.rec.bracelet.blaze.page.0"));
        TCHelper.addResearchPage(
                "TB.Bracelet.Blaze",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 8))));
        TCHelper.clearPages("TB.Bracelet.Reed");
        TCHelper.addResearchPage("TB.Bracelet.Reed", new ResearchPage("tb.rec.bracelet.reed.page.0"));
        TCHelper.addResearchPage(
                "TB.Bracelet.Reed",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 5))));
        TCHelper.clearPages("TB.Bracelet.Bone");
        TCHelper.addResearchPage("TB.Bracelet.Bone", new ResearchPage("tb.rec.bracelet.bone.page.0"));
        TCHelper.addResearchPage(
                "TB.Bracelet.Bone",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 6))));
        TCHelper.clearPages("TB.Bracelet.Obsidian");
        TCHelper.addResearchPage("TB.Bracelet.Obsidian", new ResearchPage("tb.rec.bracelet.obsidian.page.0"));
        TCHelper.addResearchPage(
                "TB.Bracelet.Obsidian",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 7))));
        TCHelper.clearPages("TB.Bracelet.Quartz");
        TCHelper.addResearchPage("TB.Bracelet.Quartz", new ResearchPage("tb.rec.bracelet.quartz.page.0"));
        TCHelper.addResearchPage(
                "TB.Bracelet.Quartz",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 10))));
        TCHelper.clearPages("TB.Bracelet.Ice");
        TCHelper.addResearchPage("TB.Bracelet.Ice", new ResearchPage("tb.rec.bracelet.ice.page.0"));
        TCHelper.addResearchPage(
                "TB.Bracelet.Ice",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 9))));
        TCHelper.refreshResearchPages("TB.NodeMan");
        TCHelper.refreshResearchPages("TB.NodeFoci.Bright");
        TCHelper.refreshResearchPages("TB.NodeFoci.Speed");
        TCHelper.refreshResearchPages("TB.NodeFoci.Unstable");
        TCHelper.refreshResearchPages("TB.NodeFoci.Efficiency");
        TCHelper.refreshResearchPages("TB.NodeFoci.Hunger");
        TCHelper.refreshResearchPages("TB.NodeFoci.Stability");
        TCHelper.refreshResearchPages("TB.NodeFoci.Purity");
        TCHelper.refreshResearchPages("TB.NodeFoci.Destr");
        TCHelper.refreshResearchPages("TB.NodeFoci.Sinister");
        TCHelper.refreshResearchPages("TB.NodeFoci.Taint");
        new ResearchItem(
                "TB.TaintFlask",
                "THAUMICBASES",
                new AspectList().add(Aspect.getAspect("vitium"), 10).add(Aspect.getAspect("alienis"), 15)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("permutatio"), 12),
                1,
                -1,
                3,
                getModItem(ThaumicBases.ID, "concentratedTaint", 1, 0)).setPages(
                        new ResearchPage("tb.rec.TB.TaintFlask.page.NH.0"),
                        new ResearchPage(
                                TCHelper.findInfusionRecipe(getModItem(ThaumicBases.ID, "concentratedTaint", 1, 0))))
                        .setParents("TB.INFUSION").setParentsHidden("BOTTLETAINT").registerResearchItem();
        ThaumcraftApi.addWarpToResearch("TB.TaintFlask", 5);
        ThaumcraftApi.addWarpToItem(getModItem(ThaumicBases.ID, "concentratedTaint", 1, 0), 3);
        TCHelper.refreshResearchPages("ROD_tbvoid");
        ThaumcraftApi.addWarpToResearch("ROD_tbvoid", 4);
        TCHelper.refreshResearchPages("TB.EntityDec");
        TCHelper.clearPages("TB.NodeLinker");
        TCHelper.addResearchPage("TB.NodeLinker", new ResearchPage("tb.rec.nodeLink.page.0"));
        TCHelper.addResearchPage("TB.NodeLinker", new ResearchPage("tb.rec.nodeLink.page.1"));
        TCHelper.addResearchPage("TB.NodeLinker", new ResearchPage("tb.rec.nodeLink.page.2"));
        TCHelper.addResearchPage(
                "TB.NodeLinker",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ThaumicBases.ID, "nodeLinker", 1, 0))));
        TCHelper.refreshResearchPages("TB.SM");
        TCHelper.refreshResearchPages("TB.Overchanter");
    }

    private void registerSlabRecipe(final String blockId, final int blockMeta, final String slabId,
            final int slabMeta) {
        addShapelessRecipe(
                getModItem(ThaumicBases.ID, slabId, 1, slabMeta),
                "craftingToolSaw",
                getModItem(ThaumicBases.ID, blockId, 1, blockMeta));

        GTValues.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, blockId, 1, blockMeta))
                .itemOutputs(getModItem(ThaumicBases.ID, slabId, 2, slabMeta))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, blockId, 1, blockMeta))
                .itemOutputs(getModItem(ThaumicBases.ID, slabId, 2, slabMeta))
                .fluidInputs(GTModHandler.getDistilledWater(20)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, blockId, 1, blockMeta))
                .itemOutputs(getModItem(ThaumicBases.ID, slabId, 2, slabMeta))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, blockId, 1, blockMeta))
                .itemOutputs(getModItem(ThaumicBases.ID, slabId, 2, slabMeta))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(2)).duration(4 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
    }
}
