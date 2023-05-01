package com.dreammaster.scripts;

import static com.dreammaster.scripts.TemporaryMods.ProjectRedExpansion;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.ExtraBees;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.MagicBees;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sFluidSolidficationRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sPressRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.forestry.ForestryHelper;
import com.dreammaster.thaumcraft.TCHelper;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GT_Values;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptForestry implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Forestry";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Forestry.ID,
                Thaumcraft.ID,
                MagicBees.ID,
                ProjectRedExpansion.ID,
                Backpack.ID,
                BiomesOPlenty.ID,
                BuildCraftFactory.ID,
                ExtraBees.ID,
                GTPlusPlus.ID,
                IndustrialCraft2.ID,
                Natura.ID,
                PamsHarvestCraft.ID,
                Railcraft.ID,
                TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {

        craftingRecipes();

        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "core", 1, 1, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "stamps", 9, 4, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "stamps", 9, 5, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "stamps", 9, 6, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "iodineCapsule", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "craftingMaterial", 1, 4, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "craftingMaterial", 1, 6, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "chipsets", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "chipsets", 1, 1, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "chipsets", 1, 2, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "chipsets", 1, 3, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem(Forestry.ID, "thermionicTubes", 4, 0, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem(Forestry.ID, "thermionicTubes", 4, 1, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem(Forestry.ID, "thermionicTubes", 4, 2, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem(Forestry.ID, "thermionicTubes", 4, 3, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem(Forestry.ID, "thermionicTubes", 4, 4, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem(Forestry.ID, "thermionicTubes", 4, 5, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem(Forestry.ID, "thermionicTubes", 4, 6, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem(Forestry.ID, "thermionicTubes", 4, 7, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem(Forestry.ID, "thermionicTubes", 4, 8, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem(Forestry.ID, "thermionicTubes", 4, 9, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem(Forestry.ID, "thermionicTubes", 4, 10, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem(Forestry.ID, "thermionicTubes", 4, 11, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem(Forestry.ID, "thermionicTubes", 4, 12, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem(Forestry.ID, "thermionicTubes", 4, 13, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "carton", 2, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "kitShovel", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "kitPickaxe", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "woodPulp", 4, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "solderingIron", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "oakStick", 2, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "candle", 24, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "candle", 6, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "stamps", 9, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "stamps", 9, 1, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "stamps", 9, 2, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "stamps", 9, 3, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "crate", 24, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Minecraft.ID, "torch", 2, 0, missing));
        ForestryHelper.removeCentrifugeRecipe(getModItem(Forestry.ID, "beeCombs", 1, 9, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "minerBagT2", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "diggerBagT2", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "foresterBagT2", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "hunterBagT2", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "adventurerBagT2", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "builderBagT2", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "beealyzer", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "treealyzer", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem(Forestry.ID, "flutterlyzer", 1, 0, missing));

        recipes1();
        recipes2();

        GT_Values.RA.addFuel(
                getModItem(Forestry.ID, "bucketShortMead", 1, 0, missing),
                getModItem(Minecraft.ID, "bucket", 1, 0, missing),
                4,
                0);
        GT_Values.RA.addFuel(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 30711, missing),
                getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 0, missing),
                2,
                0);
        GT_Values.RA.addFuel(
                getModItem(Forestry.ID, "canBiomass", 1, 0, missing),
                getModItem(Forestry.ID, "canEmpty", 1, 0, missing),
                8,
                0);
        OreDictionary.registerOre("foodHoneydrop", getModItem(Forestry.ID, "honeyDrop", 1, 0, missing));
        OreDictionary.registerOre("listAllsugar", getModItem(Forestry.ID, "honeyDrop", 1, 0, missing));

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "beeswax", 9, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem(Forestry.ID, "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "refractoryWax", 9, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem(Forestry.ID, "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "wax", 9, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem(Forestry.ID, "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "wax", 9, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem(Forestry.ID, "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "wax", 9, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem(Forestry.ID, "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "paper", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 2896, missing))
                .itemOutputs(getModItem(Forestry.ID, "letters", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(8).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "impregnatedCasing", 1, 0, missing),
                        getModItem(Forestry.ID, "craftingMaterial", 8, 6, missing))
                .itemOutputs(getModItem(Forestry.ID, "alveary", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockcasings", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 4, 2, missing))
                .itemOutputs(getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(800).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockcasings", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 18300, missing))
                .itemOutputs(getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(800).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 17500, missing))
                .itemOutputs(getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17057, missing),
                        getModItem(Minecraft.ID, "glass_pane", 1, 0, missing))
                .itemOutputs(getModItem(Forestry.ID, "canEmpty", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(120).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "craftingMaterial", 5, 3, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(Forestry.ID, "apiaristHelmet", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "craftingMaterial", 8, 3, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem(Forestry.ID, "apiaristChest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "craftingMaterial", 7, 3, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 7, missing))
                .itemOutputs(getModItem(Forestry.ID, "apiaristLegs", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "craftingMaterial", 4, 3, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem(Forestry.ID, "apiaristBoots", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "apiculture", 1, 2, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing))
                .itemOutputs(getModItem(Forestry.ID, "cart.beehouse", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "apiculture", 1, 0, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing))
                .itemOutputs(getModItem(Forestry.ID, "cart.beehouse", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "book", 1, 0, missing),
                        getModItem(Minecraft.ID, "crafting_table", 1, 0, missing),
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Forestry.ID, "factory2", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "hive", 1, 1, missing))
                .itemOutputs(getModItem(Forestry.ID, "propolis", 1, 0, missing)).outputChances(500).noFluidInputs()
                .noFluidOutputs().duration(400).eut(40).addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 0, 32309, missing))
                .itemOutputs(getModItem(Forestry.ID, "honeyDrop", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 200)).noFluidOutputs().duration(400).eut(8)
                .addTo(sFluidSolidficationRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "beeswax", 9, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem(Forestry.ID, "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "refractoryWax", 9, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem(Forestry.ID, "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "wax", 9, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem(Forestry.ID, "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "wax", 9, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem(Forestry.ID, "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "wax", 9, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem(Forestry.ID, "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sPressRecipes);

        new ResearchItem(
                "PROVENFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("potentia"), 6),
                7,
                0,
                3,
                getModItem(Forestry.ID, "frameProven", 1, 0, missing)).setParents("MB_EssenceArmor").setConcealed()
                        .setPages(new ResearchPage("Forestry.research_page.PROVENFRAME")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "PROVENFRAME",
                getModItem(Forestry.ID, "frameProven", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("perditio"), 15)
                        .add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("aqua"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem(Forestry.ID, "honeydew", 1, 0, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem(Forestry.ID, "propolis", 1, 0, missing),
                'e',
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                'f',
                getModItem(Forestry.ID, "propolis", 1, 3, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing));
        TCHelper.addResearchPage(
                "PROVENFRAME",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Forestry.ID, "frameProven", 1, 0, missing))));
        new ResearchItem(
                "PROVENGRAFTER",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("arbor"), 6),
                -5,
                -3,
                3,
                getModItem(Forestry.ID, "grafterProven", 1, 0, missing)).setParents("MB_Scoop").setConcealed()
                        .setPages(new ResearchPage("Forestry.research_page.PROVENGRAFTER")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "PROVENGRAFTER",
                getModItem(Forestry.ID, "grafterProven", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("instrumentum"), 25).add(Aspect.getAspect("permutatio"), 25)
                        .add(Aspect.getAspect("metallum"), 20).add(Aspect.getAspect("arbor"), 10),
                getModItem(Forestry.ID, "grafter", 1, 0, missing),
                new ItemStack[] { getModItem(Minecraft.ID, "sapling", 1, 1, missing),
                        getModItem(Minecraft.ID, "sapling", 1, 2, missing),
                        getModItem(Forestry.ID, "pollen", 1, 0, missing),
                        getModItem(Minecraft.ID, "sapling", 1, 3, missing),
                        getModItem(Minecraft.ID, "sapling", 1, 4, missing),
                        getModItem(Minecraft.ID, "sapling", 1, 5, missing),
                        getModItem(Forestry.ID, "pollen", 1, 1, missing),
                        getModItem(Minecraft.ID, "sapling", 1, 0, missing), });
        TCHelper.addResearchPage(
                "PROVENGRAFTER",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Forestry.ID, "grafterProven", 1, 0, missing))));
    }

    private void craftingRecipes() {
        addShapedRecipe(
                getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                new Object[] { "itemCasingBronze", "screwSteel", "itemCasingBronze", "screwSteel",
                        getModItem(GregTech.ID, "gt.blockcasings", 1, 1, missing), "screwSteel", "itemCasingBronze",
                        "screwSteel", "itemCasingBronze" });
        addShapedRecipe(
                getModItem(Forestry.ID, "core", 1, 0, missing),
                new Object[] { getModItem(Forestry.ID, "treealyzer", 1, 0, missing),
                        getModItem(Forestry.ID, "beealyzer", 1, 0, missing),
                        getModItem(Forestry.ID, "flutterlyzer", 1, 0, missing),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing), "circuitBasic",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "circuitBasic" });
        addShapedRecipe(
                getModItem(Forestry.ID, "factory", 1, 0, missing),
                new Object[] { "plateCupronickel", getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        "plateCupronickel", "ringAnyRubber", getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                        "ringAnyRubber", "gearGtSmallSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "gearGtSmallSteel" });
        addShapedRecipe(
                getModItem(Forestry.ID, "factory", 1, 1, missing),
                new Object[] { "plateCupronickel", getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        "plateCupronickel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing), "gearGtSmallSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "gearGtSmallSteel" });
        addShapedRecipe(
                getModItem(Forestry.ID, "factory", 1, 2, missing),
                new Object[] { "plateCupronickel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        "plateCupronickel", getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing),
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing), "gearGtSmallSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "gearGtSmallSteel" });
        addShapedRecipe(
                getModItem(Forestry.ID, "factory", 1, 3, missing),
                new Object[] { "plateCupronickel", getModItem(GregTech.ID, "gt.metaitem.02", 1, 21057, missing),
                        "plateCupronickel", getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing), "gearGtSmallSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "gearGtSmallSteel" });
        addShapedRecipe(
                getModItem(Forestry.ID, "factory", 1, 4, missing),
                new Object[] { "plateCupronickel", getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        "plateCupronickel", getModItem(GregTech.ID, "gt.metaitem.02", 1, 21057, missing),
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 21057, missing), "gearGtSmallSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "gearGtSmallSteel" });
        addShapedRecipe(
                getModItem(Forestry.ID, "factory", 1, 5, missing),
                new Object[] { "plateCupronickel", getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        "plateCupronickel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing), "gearGtSmallSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "gearGtSmallSteel" });
        addShapedRecipe(
                getModItem(Forestry.ID, "factory", 1, 6, missing),
                new Object[] { "plateCupronickel", getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                        "plateCupronickel", getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing), "gearGtSmallSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "gearGtSmallSteel" });
        addShapedRecipe(
                getModItem(Forestry.ID, "factory", 1, 7, missing),
                new Object[] { "plateCupronickel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        "plateCupronickel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32641, missing),
                        getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32641, missing), "gearGtSmallAluminium",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing), "gearGtSmallAluminium" });
        addShapedRecipe(
                getModItem(Forestry.ID, "factory2", 1, 1, missing),
                new Object[] { "plateIron", "ringIron", "plateIron", "plateIron", "craftingToolHardHammer", "plateIron",
                        "plateIron", "ringIron", "plateIron" });
        addShapedRecipe(
                getModItem(Forestry.ID, "factory2", 1, 2, missing),
                new Object[] { "screwIron", getModItem(Minecraft.ID, "bookshelf", 1, 0, missing), "screwIron",
                        "craftingToolSaw", getModItem(Minecraft.ID, "crafting_table", 1, 0, missing),
                        "craftingToolScrewdriver", "screwIron", getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        "screwIron" });
        addShapedRecipe(
                getModItem(Forestry.ID, "factory2", 1, 2, missing),
                new Object[] { "screwIron", getModItem(Minecraft.ID, "bookshelf", 1, 0, missing), "screwIron",
                        "craftingToolSaw", getModItem(TinkerConstruct.ID, "CraftingStation", 1, 0, missing),
                        "craftingToolScrewdriver", "screwIron", getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        "screwIron" });
        addShapedRecipe(
                getModItem(Forestry.ID, "mail", 1, 0, missing),
                new Object[] { "plateIron", getModItem(Minecraft.ID, "iron_bars", 1, 0, missing), "plateIron",
                        "dyeBlue", getModItem(IndustrialCraft2.ID, "blockMachine", 1, 0, missing), "dyeBlue",
                        "gearGtSmallBronze", "chestWood", "gearGtSmallBronze" });
        addShapedRecipe(
                getModItem(Forestry.ID, "mail", 1, 1, missing),
                new Object[] { getModItem(Forestry.ID, "thermionicTubes", 1, 9, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing),
                        getModItem(Forestry.ID, "thermionicTubes", 1, 9, missing), "plateSteel",
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing), "plateSteel", "gearGtSmallSteel",
                        "circuitBasic", "gearGtSmallSteel" });
        addShapedRecipe(
                getModItem(Forestry.ID, "engine", 1, 3, missing),
                new Object[] { "plateCupronickel", getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        "plateCupronickel", "circuitBasic", getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                        "circuitBasic", "gearGtSmallSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "gearGtSmallSteel" });
        addShapedRecipe(
                getModItem(Forestry.ID, "apiculture", 1, 2, missing),
                new Object[] { "slabWood", "slabWood", "slabWood",
                        getModItem(Forestry.ID, "frameUntreated", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.WoodenCasing", 1, 0, missing),
                        getModItem(Forestry.ID, "frameUntreated", 1, 0, missing), "beeComb", "slabWood", "beeComb" });
        addShapelessCraftingRecipe(
                getModItem(Forestry.ID, "apiculture", 1, 2, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "apiary", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Forestry.ID, "beealyzer", 1, 0, missing),
                new Object[] { getModItem(Forestry.ID, "beealyzer", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Forestry.ID, "treealyzer", 1, 0, missing),
                new Object[] { getModItem(Forestry.ID, "treealyzer", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Forestry.ID, "flutterlyzer", 1, 0, missing),
                new Object[] { getModItem(Forestry.ID, "flutterlyzer", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Forestry.ID, "infuser", 1, 0, missing),
                new Object[] { null, "stickBronze", null, null, "stickIron", null, "craftingToolHardHammer",
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing), "craftingToolFile" });
        addShapedRecipe(
                getModItem(Forestry.ID, "pipette", 1, 0, missing),
                new Object[] { null, "plateAnyRubber", "plateAnyRubber", null, "cellEmpty", "plateAnyRubber",
                        "boltGlass", null, null });
        addShapedRecipe(
                getModItem(Forestry.ID, "naturalistHelmet", 1, 0, missing),
                new Object[] { "screwIron", "ringIron", "screwIron", "lensGlass", null, "lensGlass", null, null,
                        null });
        addShapedRecipe(
                getModItem(Forestry.ID, "frameUntreated", 1, 0, missing),
                new Object[] { "slabWood", "slabWood", "slabWood", "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood", "stickWood", "stickWood",
                        "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "apiaristBag", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                        getModItem(Forestry.ID, "apicultureChest", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), "itemLeather",
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), "itemLeather", "itemLeather",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "itemLeather" });
        addShapelessCraftingRecipe(
                getModItem(Forestry.ID, "apiaristBag", 1, 0, missing),
                new Object[] { getModItem(Forestry.ID, "apiaristBag", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Forestry.ID, "lepidopteristBag", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                        getModItem(Forestry.ID, "lepidopterology", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), "itemLeather",
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), "itemLeather", "itemLeather",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "itemLeather" });
        addShapelessCraftingRecipe(
                getModItem(Forestry.ID, "lepidopteristBag", 1, 0, missing),
                new Object[] { getModItem(Forestry.ID, "lepidopteristBag", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Forestry.ID, "minerBag", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), "ingotIron",
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), "itemLeather", "ingotIron",
                        "itemLeather", "itemLeather", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "itemLeather" });
        addShapelessCraftingRecipe(
                getModItem(Forestry.ID, "minerBag", 1, 0, missing),
                new Object[] { getModItem(Forestry.ID, "minerBag", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Forestry.ID, "diggerBag", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), "stone",
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), "itemLeather", "stone",
                        "itemLeather", "itemLeather", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "itemLeather" });
        addShapelessCraftingRecipe(
                getModItem(Forestry.ID, "diggerBag", 1, 0, missing),
                new Object[] { getModItem(Forestry.ID, "diggerBag", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Forestry.ID, "foresterBag", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), "logWood",
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), "itemLeather", "logWood",
                        "itemLeather", "itemLeather", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "itemLeather" });
        addShapelessCraftingRecipe(
                getModItem(Forestry.ID, "foresterBag", 1, 0, missing),
                new Object[] { getModItem(Forestry.ID, "foresterBag", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Forestry.ID, "hunterBag", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                        getModItem(Minecraft.ID, "feather", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), "itemLeather",
                        getModItem(Minecraft.ID, "feather", 1, 0, missing), "itemLeather", "itemLeather",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "itemLeather" });
        addShapelessCraftingRecipe(
                getModItem(Forestry.ID, "hunterBag", 1, 0, missing),
                new Object[] { getModItem(Forestry.ID, "hunterBag", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Forestry.ID, "builderBag", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), "fenceWood",
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing), "itemLeather", "fenceWood",
                        "itemLeather", "itemLeather", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "itemLeather" });
        addShapelessCraftingRecipe(
                getModItem(Forestry.ID, "builderBag", 1, 0, missing),
                new Object[] { getModItem(Forestry.ID, "builderBag", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 0, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 0, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 0, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 0, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 0, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 1, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 1, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 1, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 1, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 1, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 1, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 1, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 1, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 1, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 1, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 2, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 2, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 2, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 2, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 2, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 2, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 2, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 2, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 2, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 2, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 3, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 3, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 3, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 3, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 3, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 3, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 3, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 3, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 3, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 3, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 4, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 4, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 4, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 4, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 4, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 4, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 4, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 4, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 4, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 4, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 5, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 5, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 5, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 5, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 5, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 5, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 5, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 5, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 5, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 5, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 6, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 6, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 6, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 6, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 6, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 6, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 6, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 6, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 6, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 6, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 7, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 7, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 7, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 7, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 7, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 7, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 7, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 7, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 7, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 7, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 8, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 8, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 8, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 8, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 8, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 8, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 8, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 8, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 8, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 8, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 9, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 9, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 9, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 9, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 9, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 9, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 9, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 9, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 9, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 9, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 10, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 10, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 10, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 10, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 10, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 10, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 10, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 10, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 10, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 10, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 11, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 11, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 11, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 11, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 11, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 11, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 11, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 11, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 11, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 11, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 12, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 12, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 12, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 12, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 12, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 12, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 12, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 12, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 12, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 12, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 13, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 13, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 13, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 13, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 13, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 13, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 13, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 13, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 13, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 13, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 14, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 14, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 14, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 14, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 14, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 14, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 14, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 14, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 14, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 14, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 15, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 15, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 15, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 15, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 15, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 15, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 15, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 15, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 15, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 15, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 16, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 16, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 16, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 16, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 16, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 16, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 16, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 16, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 16, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 16, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 17, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 17, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 17, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 17, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 17, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 17, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 17, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 17, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 17, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 17, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 18, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 18, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 18, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 18, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 18, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 18, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 18, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 18, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 18, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 18, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 19, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 19, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 19, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 19, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 19, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 19, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 19, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 19, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 19, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 19, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 20, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 20, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 20, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 20, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 20, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 20, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 20, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 20, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 20, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 20, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 21, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 21, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 21, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 21, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 21, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 21, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 21, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 21, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 21, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 21, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 22, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 22, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 22, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 22, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 22, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 22, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 22, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 22, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 22, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 22, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 23, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 23, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 23, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 23, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 23, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 23, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 23, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 23, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 23, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 23, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 24, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 24, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 24, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 24, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 24, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 24, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 24, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 24, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 24, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 24, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 25, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 25, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 25, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 25, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 25, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 25, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 25, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 25, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 25, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 25, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 26, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 26, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 26, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 26, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 26, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 26, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 26, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 26, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 26, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 26, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 27, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 27, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 27, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 27, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 27, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 27, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 27, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 27, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 27, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 27, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 1, 28, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 28, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 28, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 28, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 2, 28, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 28, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 28, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fences", 4, 28, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 28, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planks", 1, 28, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 0, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planks", 1, 29, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 0, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 0, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 0, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 1, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 1, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 1, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 1, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 1, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 1, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 1, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 1, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 1, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 1, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 2, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 2, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 2, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 2, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 2, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 2, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 2, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 2, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 2, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 2, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 3, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 3, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 3, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 3, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 3, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 3, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 3, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 3, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 3, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 3, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 4, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 4, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 4, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 4, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 4, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 4, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 4, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 4, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 4, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 4, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 5, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 5, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 5, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 5, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 5, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 5, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 5, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 5, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 5, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 5, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 6, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 6, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 6, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 6, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 6, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 6, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 6, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 6, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 6, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 6, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 7, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 7, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 7, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 7, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 7, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 7, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 7, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 7, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 7, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 7, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 8, missing),
                new Object[] { null, null, null, "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 8, missing),
                        "stickWood", "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 8, missing),
                        "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 8, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 8, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 8, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 8, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 8, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 8, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 9, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 9, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 9, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 9, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 9, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 9, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 9, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 9, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 9, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 9, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 10, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 10, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 10, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 10, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 10, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 10, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 10, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 10, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 10, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 10, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 11, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 11, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 11, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 11, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 11, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 11, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 11, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 11, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 11, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 11, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 12, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 12, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 12, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 12, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 12, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 12, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 12, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 12, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 12, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 12, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 13, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 13, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 13, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 13, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 13, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 13, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 13, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 13, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 13, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 13, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 14, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 14, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 14, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 14, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 14, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 14, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 14, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 14, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 14, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 14, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 15, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 15, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 15, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 15, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 15, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 15, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 15, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 15, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 15, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 15, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 16, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 16, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 16, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 16, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 16, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 16, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 16, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 16, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 16, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 16, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 17, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 17, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 17, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 17, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 17, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 17, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 17, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 17, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 17, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 17, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 18, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 18, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 18, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 18, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 18, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 18, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 18, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 18, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 18, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 18, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 19, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 19, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 19, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 19, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 19, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 19, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 19, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 19, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 19, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 19, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 20, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 20, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 20, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 20, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 20, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 20, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 20, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 20, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 20, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 20, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 21, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 21, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 21, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 21, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 21, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 21, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 21, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 21, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 21, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 21, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 22, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 22, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 22, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 22, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 22, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 22, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 22, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 22, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 22, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 22, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 23, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 23, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 23, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 23, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 23, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 23, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 23, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 23, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 23, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 23, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 24, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 24, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 24, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 24, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 24, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 24, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 24, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 24, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 24, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 24, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 25, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 25, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 25, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 25, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 25, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 25, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 25, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 25, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 25, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 25, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 26, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 26, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 26, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 26, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 26, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 26, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 26, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 26, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 26, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 26, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 27, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 27, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 27, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 27, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 27, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 27, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 27, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 27, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 27, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 27, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 1, 28, missing),
                new Object[] { "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 28, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 28, missing), "stickWood",
                        "stickWood", getModItem(Forestry.ID, "planksFireproof", 1, 28, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 2, 28, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 28, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 28, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Forestry.ID, "fencesFireproof", 4, 28, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 28, missing), "stickWood", "stickWood",
                        getModItem(Forestry.ID, "planksFireproof", 1, 28, missing), "stickWood" });
        addShapelessCraftingRecipe(
                getModItem(Forestry.ID, "factory2", 1, 2, missing),
                new Object[] { getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 10, missing) });
        addShapedRecipe(
                getModItem(Forestry.ID, "cart.beehouse", 1, 0, missing),
                new Object[] { null, "craftingToolScrewdriver", null, "screwSteel",
                        getModItem(Forestry.ID, "apiculture", 1, 2, missing), "screwSteel", "screwSteel",
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing), "screwSteel" });
        addShapedRecipe(
                getModItem(Forestry.ID, "cart.beehouse", 1, 1, missing),
                new Object[] { null, "craftingToolScrewdriver", null, "screwSteel",
                        getModItem(Forestry.ID, "apiculture", 1, 0, missing), "screwSteel", "screwSteel",
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing), "screwSteel" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                new Object[] { getModItem(Forestry.ID, "cart.beehouse", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                new Object[] { getModItem(Forestry.ID, "cart.beehouse", 1, 1, missing) });
    }

    private void recipes1() {
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 1152),
                getModItem(Forestry.ID, "factory2", 1, 2, missing),
                getModItem(Forestry.ID, "factory2", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                'e',
                getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                'f',
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 1000),
                null,
                getModItem(Forestry.ID, "core", 1, 1, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "planks", 1, 32767, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem(Minecraft.ID, "wooden_slab", 1, 32767, missing),
                'e',
                getModItem(Minecraft.ID, "wooden_slab", 1, 32767, missing),
                'f',
                getModItem(Minecraft.ID, "wooden_slab", 1, 32767, missing),
                'g',
                getModItem(Minecraft.ID, "fence", 1, 0, missing),
                'i',
                getModItem(Minecraft.ID, "fence", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 1000),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                getModItem(Forestry.ID, "apiculture", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem(Minecraft.ID, "wooden_slab", 1, 32767, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem(Forestry.ID, "apiculture", 1, 2, missing),
                'e',
                getModItem(Forestry.ID, "beeCombs", 1, 32767, missing),
                'f',
                getModItem(Forestry.ID, "apiculture", 1, 2, missing),
                'g',
                getModItem(Minecraft.ID, "fence", 1, 0, missing),
                'h',
                getModItem(Minecraft.ID, "wooden_slab", 1, 32767, missing),
                'i',
                getModItem(Minecraft.ID, "fence", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 1000),
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                getModItem(Forestry.ID, "apicultureChest", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "beeCombs", 1, 32767, missing),
                'b',
                getModItem(Forestry.ID, "beeCombs", 1, 32767, missing),
                'c',
                getModItem(Forestry.ID, "beeCombs", 1, 32767, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32403, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32403, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32403, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32403, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32403, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 1000),
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                getModItem(Forestry.ID, "apicultureChest", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "beeCombs", 1, 32767, missing),
                'b',
                getModItem(Forestry.ID, "beeCombs", 1, 32767, missing),
                'c',
                getModItem(Forestry.ID, "beeCombs", 1, 32767, missing),
                'd',
                getModItem(Forestry.ID, "crate", 1, 0, missing),
                'e',
                getModItem(Forestry.ID, "crate", 1, 0, missing),
                'f',
                getModItem(Forestry.ID, "crate", 1, 0, missing),
                'g',
                getModItem(Forestry.ID, "crate", 1, 0, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'i',
                getModItem(Forestry.ID, "crate", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 1000),
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                getModItem(Forestry.ID, "arboriculture", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "sapling", 1, 32767, missing),
                'b',
                getModItem(Forestry.ID, "sapling", 1, 32767, missing),
                'c',
                getModItem(Forestry.ID, "sapling", 1, 32767, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32403, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32403, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32403, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32403, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32403, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 1000),
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                getModItem(Forestry.ID, "arboriculture", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "sapling", 1, 32767, missing),
                'b',
                getModItem(Minecraft.ID, "sapling", 1, 32767, missing),
                'c',
                getModItem(Minecraft.ID, "sapling", 1, 32767, missing),
                'd',
                getModItem(Forestry.ID, "crate", 1, 0, missing),
                'e',
                getModItem(Forestry.ID, "crate", 1, 0, missing),
                'f',
                getModItem(Forestry.ID, "crate", 1, 0, missing),
                'g',
                getModItem(Forestry.ID, "crate", 1, 0, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'i',
                getModItem(Forestry.ID, "crate", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 1000),
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                getModItem(Forestry.ID, "lepidopterology", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "butterflyGE", 1, 32767, missing),
                'b',
                getModItem(Forestry.ID, "butterflyGE", 1, 32767, missing),
                'c',
                getModItem(Forestry.ID, "butterflyGE", 1, 32767, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32403, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32403, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32403, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32403, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32403, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 5000),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(Forestry.ID, "alveary", 1, 2, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 5, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 29351, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 5, missing),
                'd',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'e',
                getModItem(Forestry.ID, "frameProven", 1, 0, missing),
                'f',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 5, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 29351, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 5, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 5000),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(Forestry.ID, "alveary", 1, 3, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'b',
                getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'd',
                getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 21300, missing),
                'f',
                getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 5000),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(Forestry.ID, "alveary", 1, 4, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 7, missing),
                'b',
                getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 7, missing),
                'd',
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                'e',
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                'f',
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 7, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 7, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 5000),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(Forestry.ID, "alveary", 1, 5, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 6, missing),
                'b',
                "circuitGood",
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 6, missing),
                'd',
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                'e',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 5142, missing),
                'f',
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 6, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 6, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 5000),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(Forestry.ID, "alveary", 1, 6, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'b',
                getModItem(NewHorizonsCoreMod.ID, "item.ChargedCertusQuartzPlate", 1, 0, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                'e',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'h',
                getModItem(NewHorizonsCoreMod.ID, "item.ChargedCertusQuartzPlate", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 5000),
                getModItem(Forestry.ID, "alveary", 1, 0, missing),
                getModItem(Forestry.ID, "alveary", 1, 7, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 9, missing),
                'b',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 9, missing),
                'd',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'e',
                getModItem(Forestry.ID, "pollenFertile", 1, 32767, missing),
                'f',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 9, missing),
                'h',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 9, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                getModItem(Forestry.ID, "beealyzer", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18057, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18057, missing),
                'e',
                "circuitBasic",
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18057, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18057, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                getModItem(Forestry.ID, "treealyzer", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'e',
                "circuitBasic",
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                getModItem(Forestry.ID, "flutterlyzer", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18300, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18300, missing),
                'e',
                "circuitBasic",
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18300, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18300, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27500, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem(Minecraft.ID, "stonebrick", 1, 0, missing),
                createItemStack(Forestry.ID, "ffarm", 4, 0, "{FarmBlock:0}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem(Minecraft.ID, "stonebrick", 4, 1, missing),
                createItemStack(Forestry.ID, "ffarm", 4, 0, "{FarmBlock:1}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem(Minecraft.ID, "stonebrick", 1, 2, missing),
                createItemStack(Forestry.ID, "ffarm", 4, 0, "{FarmBlock:2}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem(Minecraft.ID, "brick_block", 1, 0, missing),
                createItemStack(Forestry.ID, "ffarm", 4, 0, "{FarmBlock:3}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem(Minecraft.ID, "sandstone", 1, 2, missing),
                createItemStack(Forestry.ID, "ffarm", 4, 0, "{FarmBlock:4}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem(Minecraft.ID, "sandstone", 1, 1, missing),
                createItemStack(Forestry.ID, "ffarm", 4, 0, "{FarmBlock:5}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem(Minecraft.ID, "nether_brick", 1, 0, missing),
                createItemStack(Forestry.ID, "ffarm", 4, 0, "{FarmBlock:6}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem(Minecraft.ID, "stonebrick", 1, 3, missing),
                createItemStack(Forestry.ID, "ffarm", 4, 0, "{FarmBlock:7}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem(Minecraft.ID, "quartz_block", 1, 0, missing),
                createItemStack(Forestry.ID, "ffarm", 4, 0, "{FarmBlock:8}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem(Minecraft.ID, "quartz_block", 1, 1, missing),
                createItemStack(Forestry.ID, "ffarm", 4, 0, "{FarmBlock:9}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem(Minecraft.ID, "quartz_block", 1, 2, missing),
                createItemStack(Forestry.ID, "ffarm", 4, 0, "{FarmBlock:10}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem(Forestry.ID, "thermionicTubes", 1, 10, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:0}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 2, "{FarmBlock:0}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:1}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 2, "{FarmBlock:1}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:2}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 2, "{FarmBlock:2}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:3}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 2, "{FarmBlock:3}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:4}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 2, "{FarmBlock:4}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:5}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 2, "{FarmBlock:5}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:6}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 2, "{FarmBlock:6}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:7}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 2, "{FarmBlock:7}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:8}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 2, "{FarmBlock:8}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:9}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 2, "{FarmBlock:9}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:10}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 2, "{FarmBlock:10}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:0}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 3, "{FarmBlock:0}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'h',
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:1}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 3, "{FarmBlock:1}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'h',
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:2}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 3, "{FarmBlock:2}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'h',
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:3}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 3, "{FarmBlock:3}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'h',
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:4}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 3, "{FarmBlock:4}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'h',
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:5}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 3, "{FarmBlock:5}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'h',
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:6}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 3, "{FarmBlock:6}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'h',
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:7}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 3, "{FarmBlock:7}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'h',
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:8}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 3, "{FarmBlock:8}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'h',
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:9}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 3, "{FarmBlock:9}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'h',
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:10}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 3, "{FarmBlock:10}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing),
                'h',
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:0}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 4, "{FarmBlock:0}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:1}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 4, "{FarmBlock:1}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:2}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 4, "{FarmBlock:2}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:3}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 4, "{FarmBlock:3}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:4}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 4, "{FarmBlock:4}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:5}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 4, "{FarmBlock:5}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:6}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 4, "{FarmBlock:6}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:7}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 4, "{FarmBlock:7}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:8}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 4, "{FarmBlock:8}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:9}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 4, "{FarmBlock:9}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 1, 0, "{FarmBlock:10}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 4, "{FarmBlock:10}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 2, 0, "{FarmBlock:0}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 5, "{FarmBlock:0}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'h',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 2, 0, "{FarmBlock:1}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 5, "{FarmBlock:1}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'h',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 2, 0, "{FarmBlock:2}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 5, "{FarmBlock:2}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'h',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 2, 0, "{FarmBlock:3}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 5, "{FarmBlock:3}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'h',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 2, 0, "{FarmBlock:4}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 5, "{FarmBlock:4}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'h',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 2, 0, "{FarmBlock:5}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 5, "{FarmBlock:5}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'h',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 2, 0, "{FarmBlock:6}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 5, "{FarmBlock:6}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'h',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 2, 0, "{FarmBlock:7}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 5, "{FarmBlock:7}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'h',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 2, 0, "{FarmBlock:8}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 5, "{FarmBlock:8}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'h',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 2, 0, "{FarmBlock:9}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 5, "{FarmBlock:9}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'h',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack(Forestry.ID, "ffarm", 2, 0, "{FarmBlock:10}", missing),
                createItemStack(Forestry.ID, "ffarm", 2, 5, "{FarmBlock:10}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing),
                'h',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem(Forestry.ID, "thermionicTubes", 1, 4, missing));
    }

    private void recipes2() {
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem(Forestry.ID, "fertilizerBio", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Minecraft.ID, "wheat", 1, 0, missing),
                'd',
                getModItem(Minecraft.ID, "wheat", 1, 0, missing),
                'e',
                getModItem(Minecraft.ID, "dirt", 1, 32767, missing),
                'f',
                getModItem(Minecraft.ID, "wheat", 1, 0, missing),
                'h',
                getModItem(Minecraft.ID, "wheat", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem(Forestry.ID, "fertilizerBio", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'e',
                getModItem(Minecraft.ID, "dirt", 1, 32767, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem(Forestry.ID, "fertilizerBio", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Natura.ID, "barleyFood", 1, 0, missing),
                'd',
                getModItem(Natura.ID, "barleyFood", 1, 0, missing),
                'e',
                getModItem(Minecraft.ID, "dirt", 1, 32767, missing),
                'f',
                getModItem(Natura.ID, "barleyFood", 1, 0, missing),
                'h',
                getModItem(Natura.ID, "barleyFood", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem(Forestry.ID, "fertilizerBio", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(PamsHarvestCraft.ID, "barleyItem", 1, 0, missing),
                'd',
                getModItem(PamsHarvestCraft.ID, "barleyItem", 1, 0, missing),
                'e',
                getModItem(Minecraft.ID, "dirt", 1, 32767, missing),
                'f',
                getModItem(PamsHarvestCraft.ID, "barleyItem", 1, 0, missing),
                'h',
                getModItem(PamsHarvestCraft.ID, "barleyItem", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem(Forestry.ID, "fertilizerBio", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(BiomesOPlenty.ID, "plants", 1, 6, missing),
                'd',
                getModItem(BiomesOPlenty.ID, "plants", 1, 6, missing),
                'e',
                getModItem(Minecraft.ID, "dirt", 1, 32767, missing),
                'f',
                getModItem(BiomesOPlenty.ID, "plants", 1, 6, missing),
                'h',
                getModItem(BiomesOPlenty.ID, "plants", 1, 6, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem(Forestry.ID, "fertilizerBio", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(PamsHarvestCraft.ID, "ryeItem", 1, 0, missing),
                'd',
                getModItem(PamsHarvestCraft.ID, "ryeItem", 1, 0, missing),
                'e',
                getModItem(Minecraft.ID, "dirt", 1, 32767, missing),
                'f',
                getModItem(PamsHarvestCraft.ID, "ryeItem", 1, 0, missing),
                'h',
                getModItem(PamsHarvestCraft.ID, "ryeItem", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem(Forestry.ID, "fertilizerBio", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(PamsHarvestCraft.ID, "oatsItem", 1, 0, missing),
                'd',
                getModItem(PamsHarvestCraft.ID, "oatsItem", 1, 0, missing),
                'e',
                getModItem(Minecraft.ID, "dirt", 1, 32767, missing),
                'f',
                getModItem(PamsHarvestCraft.ID, "oatsItem", 1, 0, missing),
                'h',
                getModItem(PamsHarvestCraft.ID, "oatsItem", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem(Forestry.ID, "fertilizerCompound", 5, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Minecraft.ID, "sand", 1, 32767, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2530, missing),
                'h',
                getModItem(Minecraft.ID, "sand", 1, 32767, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem(Forestry.ID, "fertilizerCompound", 6, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Minecraft.ID, "sand", 1, 32767, missing),
                'e',
                getModItem(MagicBees.ID, "miscResources", 1, 2, missing),
                'h',
                getModItem(Minecraft.ID, "sand", 1, 32767, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem(Forestry.ID, "fertilizerCompound", 10, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2530, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem(Forestry.ID, "fertilizerCompound", 12, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'e',
                getModItem(MagicBees.ID, "miscResources", 1, 2, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem(Forestry.ID, "fertilizerCompound", 2, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Minecraft.ID, "sand", 1, 32767, missing),
                'd',
                getModItem(Minecraft.ID, "dirt", 1, 32767, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2836, missing),
                'f',
                getModItem(Minecraft.ID, "dirt", 1, 32767, missing),
                'h',
                getModItem(Minecraft.ID, "sand", 1, 32767, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("for.honey", 1000),
                getModItem(Forestry.ID, "canEmpty", 1, 0, missing),
                getModItem(Forestry.ID, "iodineCapsule", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "honeydew", 1, 0, missing),
                'b',
                getModItem(Forestry.ID, "pollen", 1, 32767, missing),
                'c',
                getModItem(Forestry.ID, "honeydew", 1, 0, missing),
                'd',
                getModItem(Forestry.ID, "pollen", 1, 32767, missing),
                'e',
                getModItem(Forestry.ID, "propolis", 1, 32767, missing),
                'f',
                getModItem(Forestry.ID, "pollen", 1, 32767, missing),
                'g',
                getModItem(Minecraft.ID, "gunpowder", 1, 0, missing),
                'h',
                getModItem(Forestry.ID, "pollen", 1, 32767, missing),
                'i',
                getModItem(Minecraft.ID, "gunpowder", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("for.honey", 1000),
                getModItem(Forestry.ID, "canEmpty", 1, 0, missing),
                getModItem(Forestry.ID, "iodineCapsule", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "honeydew", 1, 0, missing),
                'b',
                getModItem(Forestry.ID, "pollen", 1, 32767, missing),
                'c',
                getModItem(Forestry.ID, "honeydew", 1, 0, missing),
                'd',
                getModItem(Forestry.ID, "pollen", 1, 32767, missing),
                'e',
                getModItem(ExtraBees.ID, "propolis", 1, 32767, missing),
                'f',
                getModItem(Forestry.ID, "pollen", 1, 32767, missing),
                'g',
                getModItem(Minecraft.ID, "gunpowder", 1, 0, missing),
                'h',
                getModItem(Forestry.ID, "pollen", 1, 32767, missing),
                'i',
                getModItem(Minecraft.ID, "gunpowder", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("for.honey", 1000),
                getModItem(Forestry.ID, "canEmpty", 1, 0, missing),
                getModItem(Forestry.ID, "iodineCapsule", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "honeydew", 1, 0, missing),
                'b',
                getModItem(Forestry.ID, "pollen", 1, 32767, missing),
                'c',
                getModItem(Forestry.ID, "honeydew", 1, 0, missing),
                'd',
                getModItem(Forestry.ID, "pollen", 1, 32767, missing),
                'e',
                getModItem(MagicBees.ID, "propolis", 1, 32767, missing),
                'f',
                getModItem(Forestry.ID, "pollen", 1, 32767, missing),
                'g',
                getModItem(Minecraft.ID, "gunpowder", 1, 0, missing),
                'h',
                getModItem(Forestry.ID, "pollen", 1, 32767, missing),
                'i',
                getModItem(Minecraft.ID, "gunpowder", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("for.honey", 1000),
                getModItem(Forestry.ID, "canEmpty", 1, 0, missing),
                getModItem(Forestry.ID, "craftingMaterial", 1, 4, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "honeydew", 1, 0, missing),
                'b',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'c',
                getModItem(Forestry.ID, "honeydew", 1, 0, missing),
                'd',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'e',
                getModItem(Forestry.ID, "propolis", 1, 32767, missing),
                'f',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'g',
                getModItem(Minecraft.ID, "gunpowder", 1, 0, missing),
                'h',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'i',
                getModItem(Minecraft.ID, "gunpowder", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("for.honey", 1000),
                getModItem(Forestry.ID, "canEmpty", 1, 0, missing),
                getModItem(Forestry.ID, "craftingMaterial", 1, 4, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "honeydew", 1, 0, missing),
                'b',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'c',
                getModItem(Forestry.ID, "honeydew", 1, 0, missing),
                'd',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'e',
                getModItem(ExtraBees.ID, "propolis", 1, 32767, missing),
                'f',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'g',
                getModItem(Minecraft.ID, "gunpowder", 1, 0, missing),
                'h',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'i',
                getModItem(Minecraft.ID, "gunpowder", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("for.honey", 1000),
                getModItem(Forestry.ID, "canEmpty", 1, 0, missing),
                getModItem(Forestry.ID, "craftingMaterial", 1, 4, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "honeydew", 1, 0, missing),
                'b',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'c',
                getModItem(Forestry.ID, "honeydew", 1, 0, missing),
                'd',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'e',
                getModItem(MagicBees.ID, "propolis", 1, 32767, missing),
                'f',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'g',
                getModItem(Minecraft.ID, "gunpowder", 1, 0, missing),
                'h',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'i',
                getModItem(Minecraft.ID, "gunpowder", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 1000),
                null,
                getModItem(Forestry.ID, "craftingMaterial", 1, 6, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 19086, missing),
                'b',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 19086, missing),
                'd',
                getModItem(Forestry.ID, "oakStick", 1, 0, missing),
                'e',
                getModItem(Forestry.ID, "oakStick", 1, 0, missing),
                'f',
                getModItem(Forestry.ID, "oakStick", 1, 0, missing),
                'g',
                getModItem(Forestry.ID, "beeswax", 1, 0, missing),
                'h',
                getModItem(Forestry.ID, "pollen", 1, 32767, missing),
                'i',
                getModItem(Forestry.ID, "beeswax", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("creosote", 200),
                null,
                getModItem(Forestry.ID, "bituminousPeat", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'd',
                getModItem(Forestry.ID, "peat", 1, 0, missing),
                'e',
                getModItem(Forestry.ID, "propolis", 1, 32767, missing),
                'f',
                getModItem(Forestry.ID, "peat", 1, 0, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing));
        RecipeManagers.carpenterManager.addRecipe(
                12,
                (FluidStack) null,
                null,
                getModItem(Forestry.ID, "bituminousPeat", 2, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'd',
                getModItem(Forestry.ID, "peat", 1, 0, missing),
                'e',
                getModItem(ExtraBees.ID, "propolis", 1, 7, missing),
                'f',
                getModItem(Forestry.ID, "peat", 1, 0, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing));
        RecipeManagers.carpenterManager.addRecipe(
                14,
                (FluidStack) null,
                null,
                getModItem(Forestry.ID, "bituminousPeat", 3, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'd',
                getModItem(Forestry.ID, "peat", 1, 0, missing),
                'e',
                getModItem(ExtraBees.ID, "propolis", 1, 1, missing),
                'f',
                getModItem(Forestry.ID, "peat", 1, 0, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing));
        RecipeManagers.carpenterManager.addRecipe(
                16,
                (FluidStack) null,
                null,
                getModItem(Forestry.ID, "bituminousPeat", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                'd',
                getModItem(Forestry.ID, "peat", 1, 0, missing),
                'e',
                getModItem(ExtraBees.ID, "propolis", 1, 2, missing),
                'f',
                getModItem(Forestry.ID, "peat", 1, 0, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("molten.redstone", 1152),
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32100, missing),
                getModItem(Forestry.ID, "chipsets", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 29032, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing),
                'd',
                "circuitPrimitive",
                'e',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 19032, missing),
                'f',
                "circuitPrimitive",
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 29032, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("molten.redstone", 1152),
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32100, missing),
                getModItem(Forestry.ID, "chipsets", 1, 1, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27300, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 29300, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27300, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 19300, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27300, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 29300, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27300, missing));
        RecipeManagers.carpenterManager.addRecipe(
                30,
                FluidRegistry.getFluidStack("molten.redstone", 1152),
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32101, missing),
                getModItem(Forestry.ID, "chipsets", 1, 2, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 29305, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'd',
                "circuitGood",
                'e',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 19305, missing),
                'f',
                "circuitGood",
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 29305, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("molten.redstone", 1152),
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32101, missing),
                getModItem(Forestry.ID, "chipsets", 1, 3, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27303, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 29303, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27303, missing),
                'd',
                "circuitAdvanced",
                'e',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 19303, missing),
                'f',
                "circuitAdvanced",
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27303, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 29303, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27303, missing));
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Forestry.ID, "thermionicTubes", 2, 0, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem(GregTech.ID, "gt.metaitem.02", 1, 22035, missing),
                        'd', getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22035, missing), 'f',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Forestry.ID, "thermionicTubes", 2, 1, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem(GregTech.ID, "gt.metaitem.02", 1, 22057, missing),
                        'd', getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22057, missing), 'f',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Forestry.ID, "thermionicTubes", 2, 2, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem(GregTech.ID, "gt.metaitem.02", 1, 22300, missing),
                        'd', getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22300, missing), 'f',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Forestry.ID, "thermionicTubes", 2, 3, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem(GregTech.ID, "gt.metaitem.02", 1, 22032, missing),
                        'd', getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22032, missing), 'f',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Forestry.ID, "thermionicTubes", 2, 4, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem(GregTech.ID, "gt.metaitem.02", 1, 22086, missing),
                        'd', getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22086, missing), 'f',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Forestry.ID, "thermionicTubes", 2, 5, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem(GregTech.ID, "gt.metaitem.02", 1, 22500, missing),
                        'd', getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22500, missing), 'f',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Forestry.ID, "thermionicTubes", 2, 6, missing),
                new Object[] { "abc", "def", "ghi", 'b',
                        getModItem(NewHorizonsCoreMod.ID, "item.LongObsidianRod", 1, 0, missing), 'd',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem(NewHorizonsCoreMod.ID, "item.LongObsidianRod", 1, 0, missing), 'f',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Forestry.ID, "thermionicTubes", 2, 7, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem(GregTech.ID, "gt.metaitem.02", 1, 22801, missing),
                        'd', getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22801, missing), 'f',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Forestry.ID, "thermionicTubes", 2, 8, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem(GregTech.ID, "gt.metaitem.02", 1, 22880, missing),
                        'd', getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22880, missing), 'f',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Forestry.ID, "thermionicTubes", 2, 9, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem(GregTech.ID, "gt.metaitem.02", 1, 22501, missing),
                        'd', getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22501, missing), 'f',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Forestry.ID, "thermionicTubes", 2, 10, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem(GregTech.ID, "gt.metaitem.02", 1, 22530, missing),
                        'd', getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22530, missing), 'f',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Forestry.ID, "thermionicTubes", 2, 11, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem(GregTech.ID, "gt.metaitem.02", 1, 22526, missing),
                        'd', getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22526, missing), 'f',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Forestry.ID, "thermionicTubes", 2, 12, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem(GregTech.ID, "gt.metaitem.02", 1, 22533, missing),
                        'd', getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22533, missing), 'f',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem(Forestry.ID, "thermionicTubes", 2, 13, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem(GregTech.ID, "gt.metaitem.02", 1, 22098, missing),
                        'd', getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22098, missing), 'f',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17533, missing), 'i',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 288),
                getModItem(Minecraft.ID, "compass", 1, 0, missing),
                getModItem(Forestry.ID, "habitatLocator", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27300, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18300, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27300, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18300, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 28305, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18300, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27300, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 18300, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27300, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                null,
                getModItem(Forestry.ID, "solderingIron", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23305, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 26305, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23305, missing),
                'i',
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 3, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                null,
                getModItem(Forestry.ID, "oakStick", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "stick", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                null,
                getModItem(Forestry.ID, "oakStick", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Natura.ID, "natura.stick", 1, 32767, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("seedoil", 250),
                null,
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Railcraft.ID, "slab", 1, 38, missing),
                'b',
                getModItem(Railcraft.ID, "slab", 1, 38, missing),
                'c',
                getModItem(Railcraft.ID, "slab", 1, 38, missing),
                'd',
                getModItem(Forestry.ID, "oakStick", 1, 0, missing),
                'e',
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                'f',
                getModItem(Forestry.ID, "oakStick", 1, 0, missing),
                'g',
                getModItem(Forestry.ID, "oakStick", 1, 0, missing),
                'h',
                getModItem(Forestry.ID, "oakStick", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "oakStick", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem(Forestry.ID, "candle", 2, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                'h',
                getModItem(Forestry.ID, "beeswax", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem(Forestry.ID, "candle", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(Forestry.ID, "craftingMaterial", 1, 2, missing),
                'h',
                getModItem(Forestry.ID, "beeswax", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem(Forestry.ID, "candle", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                'h',
                getModItem(Forestry.ID, "refractoryWax", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem(Forestry.ID, "candle", 8, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(Forestry.ID, "craftingMaterial", 1, 2, missing),
                'h',
                getModItem(Forestry.ID, "refractoryWax", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem(Forestry.ID, "candle", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                'h',
                getModItem(MagicBees.ID, "wax", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem(Forestry.ID, "candle", 8, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(Forestry.ID, "craftingMaterial", 1, 2, missing),
                'h',
                getModItem(MagicBees.ID, "wax", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem(Forestry.ID, "candle", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                'h',
                getModItem(MagicBees.ID, "wax", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem(Forestry.ID, "candle", 8, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(Forestry.ID, "craftingMaterial", 1, 2, missing),
                'h',
                getModItem(MagicBees.ID, "wax", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem(Forestry.ID, "candle", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                'h',
                getModItem(MagicBees.ID, "wax", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem(Forestry.ID, "candle", 8, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(Forestry.ID, "craftingMaterial", 1, 2, missing),
                'h',
                getModItem(MagicBees.ID, "wax", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 800),
                null,
                getModItem(Forestry.ID, "honeyedSlice", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32566, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("for.honey", 400),
                getModItem(Forestry.ID, "waxCapsule", 1, 0, missing),
                getModItem(Forestry.ID, "ambrosia", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "honeydew", 1, 0, missing),
                'b',
                getModItem(Forestry.ID, "honeydew", 1, 0, missing),
                'c',
                getModItem(Forestry.ID, "honeydew", 1, 0, missing),
                'd',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'e',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'f',
                getModItem(Forestry.ID, "royalJelly", 1, 0, missing),
                'g',
                getModItem(Forestry.ID, "honeydew", 1, 0, missing),
                'h',
                getModItem(Forestry.ID, "honeydew", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "honeydew", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                (FluidStack) null,
                getModItem(Forestry.ID, "waxCapsule", 1, 0, missing),
                getModItem(Forestry.ID, "honeyPot", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "honeyDrop", 1, 0, missing),
                'c',
                getModItem(Forestry.ID, "honeyDrop", 1, 0, missing),
                'e',
                getModItem(Forestry.ID, "honeyDrop", 1, 0, missing),
                'g',
                getModItem(Forestry.ID, "honeyDrop", 1, 0, missing),
                'i',
                getModItem(Forestry.ID, "honeyDrop", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("seedoil", 200),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Forestry.ID, "letters", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                'd',
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                'e',
                getModItem(Forestry.ID, "propolis", 1, 32767, missing),
                'f',
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                'h',
                getModItem(Minecraft.ID, "paper", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("seedoil", 200),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Forestry.ID, "letters", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                'd',
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                'e',
                getModItem(ExtraBees.ID, "propolis", 1, 32767, missing),
                'f',
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                'h',
                getModItem(Minecraft.ID, "paper", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("seedoil", 200),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Forestry.ID, "letters", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                'd',
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                'e',
                getModItem(MagicBees.ID, "propolis", 1, 32767, missing),
                'f',
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                'h',
                getModItem(Minecraft.ID, "paper", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("seedoil", 400),
                getModItem(Minecraft.ID, "book", 1, 0, missing),
                getModItem(Forestry.ID, "catalogue", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(Forestry.ID, "stamps", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("seedoil", 400),
                getModItem(Minecraft.ID, "book", 1, 0, missing),
                getModItem(Forestry.ID, "catalogue", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(Forestry.ID, "stamps", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("seedoil", 400),
                getModItem(Minecraft.ID, "book", 1, 0, missing),
                getModItem(Forestry.ID, "catalogue", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(Forestry.ID, "stamps", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("seedoil", 400),
                getModItem(Minecraft.ID, "book", 1, 0, missing),
                getModItem(Forestry.ID, "catalogue", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(Forestry.ID, "stamps", 1, 3, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("seedoil", 400),
                getModItem(Minecraft.ID, "book", 1, 0, missing),
                getModItem(Forestry.ID, "catalogue", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(Forestry.ID, "stamps", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("seedoil", 400),
                getModItem(Minecraft.ID, "book", 1, 0, missing),
                getModItem(Forestry.ID, "catalogue", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(Forestry.ID, "stamps", 1, 5, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("seedoil", 400),
                getModItem(Minecraft.ID, "book", 1, 0, missing),
                getModItem(Forestry.ID, "catalogue", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(Forestry.ID, "stamps", 1, 6, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("creosote", 400),
                null,
                getModItem(Forestry.ID, "crate", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 5000),
                getModItem(Forestry.ID, "minerBag", 1, 0, missing),
                getModItem(Forestry.ID, "minerBagT2", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'b',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'c',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'd',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'e',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'f',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'g',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'h',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'i',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 5000),
                getModItem(Forestry.ID, "diggerBag", 1, 0, missing),
                getModItem(Forestry.ID, "diggerBagT2", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'b',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'c',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'd',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'e',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'f',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'g',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'h',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'i',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 5000),
                getModItem(Forestry.ID, "foresterBag", 1, 0, missing),
                getModItem(Forestry.ID, "foresterBagT2", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'b',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'c',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'd',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'e',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'f',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'g',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'h',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'i',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 5000),
                getModItem(Forestry.ID, "hunterBag", 1, 0, missing),
                getModItem(Forestry.ID, "hunterBagT2", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'b',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'c',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'd',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'e',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'f',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'g',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'h',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'i',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 5000),
                getModItem(Forestry.ID, "builderBag", 1, 0, missing),
                getModItem(Forestry.ID, "builderBagT2", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'b',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'c',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'd',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'e',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'f',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'g',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'h',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'i',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("creosote", 500),
                null,
                getModItem(Minecraft.ID, "torch", 5, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(Minecraft.ID, "wool", 1, 32767, missing),
                'h',
                getModItem(Minecraft.ID, "stick", 1, 0, missing));
        RecipeManagers.fermenterManager.addRecipe(
                getModItem(GTPlusPlus.ID, "blockRainforestOakSapling", 1, 0, missing),
                75,
                1.f,
                FluidRegistry.getFluidStack("biomass", 1000),
                FluidRegistry.getFluidStack("juice", 1));
        RecipeManagers.fermenterManager.addRecipe(
                getModItem(GTPlusPlus.ID, "blockRainforestOakSapling", 1, 0, missing),
                75,
                1.f,
                FluidRegistry.getFluidStack("biomass", 1000),
                FluidRegistry.getFluidStack("for.honey", 1));
        RecipeManagers.fermenterManager.addRecipe(
                getModItem(GTPlusPlus.ID, "blockRainforestOakSapling", 1, 0, missing),
                75,
                1.f,
                FluidRegistry.getFluidStack("biomass", 1000),
                FluidRegistry.getFluidStack("honey", 1));
        RecipeManagers.fermenterManager.addRecipe(
                getModItem(GTPlusPlus.ID, "blockRainforestOakSapling", 1, 0, missing),
                50,
                1.f,
                FluidRegistry.getFluidStack("biomass", 1000),
                FluidRegistry.getFluidStack("water", 1));
    }
}
