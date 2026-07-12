package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.enums.Mods.MagicBees;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.RemoteIO;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.QFT_CATALYST;
import static gregtech.api.util.GTRecipeConstants.QFT_FOCUS_TIER;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.quantumForceTransformerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.block.BlockList;
import com.dreammaster.item.NHItemList;
import com.dreammaster.thaumcraft.TCMaterialAspectHelper;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import cpw.mods.fml.common.Optional;
import forestry.api.recipes.RecipeManagers;
import fox.spiteful.avaritia.compat.thaumcraft.Lucrum;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TCAspects;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2FluidShapes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.core.material.MaterialsAlloy;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import magicbees.api.MagicBeesAPI;
import thaumcraft.api.aspects.Aspect;

public class ScriptGregtechPlusPlus implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "GT++";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Avaritia.ID,
                EternalSingularity.ID,
                Forestry.ID,
                IndustrialCraft2.ID,
                IronTanks.ID,
                MagicBees.ID,
                RemoteIO.ID,
                Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {

        // Fish Trap
        addShapedRecipe(
                GregtechItemList.FishTrap.get(1),
                BlockList.SteelBars.get(),
                BlockList.SteelBars.get(),
                BlockList.SteelBars.get(),
                BlockList.SteelBars.get(),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.CastIron, 1),
                BlockList.SteelBars.get(),
                BlockList.SteelBars.get(),
                BlockList.SteelBars.get(),
                BlockList.SteelBars.get());

        // Shirabon and Eternity
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EternalSingularity.ID, "combined_singularity", 1, 15),
                        ItemList.EnergisedTesseract.get(1))
                .itemOutputs(GTOreDictUnificator.get("dustShirabon", 64), ItemList.Timepiece.get(1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.PrimordialMatter,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1152)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Eternity,
                                Materials2FluidShapes.fluidMolten,
                                (int) (9216)),
                        Materials.Time.getMolten(18432))
                .metadata(QFT_CATALYST, GregtechItemList.TemporalHarmonyCatalyst.get(0)).metadata(QFT_FOCUS_TIER, 4)
                .duration(20 * SECONDS).eut(TierEU.RECIPE_UMV).addTo(quantumForceTransformerRecipes);
        addForestryRecipes();
        addThaumcraftAspects();
    }

    @Optional.Method(modid = Mods.ModIDs.FORESTRY)
    private void addForestryRecipes() {

        // Arborist Frame
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.WoodSealed, Materials2Shapes.stickLong, (int) (4)),
                        MaterialLibAPI.getStack(Materials2Materials.WoodSealed, Materials2Shapes.stick, (int) (4)),
                        getModItem(Minecraft.ID, "paper", 1, 0),
                        getModItem(Forestry.ID, "frameImpregnated", 1, 0))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Redstone,
                                Materials2FluidShapes.fluidMolten,
                                (int) (576)))
                .itemOutputs(GregtechItemList.HiveFrameArborist.get(1)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Stabilization Frame
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Osmiridium, Materials2Shapes.stickLong, (int) (4)),
                        MaterialLibAPI.getStack(Materials2Materials.Osmiridium, Materials2Shapes.stick, (int) (4)),
                        MaterialLibAPI.getStack(Materials2Materials.Osmiridium, Materials2Shapes.foil, (int) (1)),
                        getModItem(Forestry.ID, "frameImpregnated", 1, 0))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Redstone,
                                Materials2FluidShapes.fluidMolten,
                                (int) (576)))
                .itemOutputs(GregtechItemList.HiveFrameStabilize.get(1)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Slowing Frame
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialsAlloy.TUMBAGA.getLongRod(4),
                        MaterialsAlloy.TUMBAGA.getRod(4),
                        MaterialLibAPI.getStack(Materials2Materials.Electrum, Materials2Shapes.foil, (int) (1)),
                        getModItem(Forestry.ID, "frameImpregnated", 1, 0))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Redstone,
                                Materials2FluidShapes.fluidMolten,
                                (int) (576)))
                .itemOutputs(GregtechItemList.HiveFrameSlow.get(1)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Decaying Frame
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.CastIron, Materials2Shapes.stickLong, (int) (4)),
                        MaterialLibAPI.getStack(Materials2Materials.CastIron, Materials2Shapes.stick, (int) (4)),
                        MaterialLibAPI.getStack(Materials2Materials.CastIron, Materials2Shapes.foil, (int) (1)),
                        getModItem(Forestry.ID, "frameImpregnated", 1, 0))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Redstone,
                                Materials2FluidShapes.fluidMolten,
                                (int) (576)))
                .itemOutputs(GregtechItemList.HiveFrameDecay.get(1)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Working Frame
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.BlueSteel, Materials2Shapes.stickLong, (int) (4)),
                        MaterialLibAPI.getStack(Materials2Materials.BlueSteel, Materials2Shapes.stick, (int) (4)),
                        GTOreDictUnificator.get(OrePrefixes.gem, Materials.NetherStar, 1),
                        getModItem(Forestry.ID, "frameImpregnated", 1, 0))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Redstone,
                                Materials2FluidShapes.fluidMolten,
                                (int) (576)))
                .itemOutputs(GregtechItemList.HiveFrameBusy.get(1)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Mutagenic Frame
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Uranium235, Materials2Shapes.stickLong, (int) (4)),
                        MaterialLibAPI.getStack(Materials2Materials.Plutonium241, Materials2Shapes.stick, (int) (4)),
                        MaterialLibAPI.getStack(Materials2Materials.Plutonium241, Materials2Shapes.foil, (int) (1)),
                        getModItem(Forestry.ID, "frameImpregnated", 1, 0))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Redstone,
                                Materials2FluidShapes.fluidMolten,
                                (int) (576)))
                .itemOutputs(GregtechItemList.HiveFrameMutagenic.get(1)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // Accelerated Frame
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Electrum, Materials2Shapes.stickLong, (int) (4)),
                        MaterialLibAPI.getStack(Materials2Materials.Electrum, Materials2Shapes.stick, (int) (4)),
                        MaterialLibAPI.getStack(Materials2Materials.Electrum, Materials2Shapes.foil, (int) (1)),
                        getModItem(Forestry.ID, "frameImpregnated", 1, 0))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Redstone,
                                Materials2FluidShapes.fluidMolten,
                                (int) (576)))
                .itemOutputs(GregtechItemList.HiveFrameAccelerated.get(1)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        addShapelessRecipe(NHItemList.CoinBeesI.get(16), GregtechItemList.HiveFrameVoid.get(1));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0),
                GregtechItemList.HiveFrameAccelerated.get(1),
                "abc",
                "def",
                "ghi",
                'a',
                MaterialLibAPI.getStack(Materials2Materials.Electrum, Materials2Shapes.stickLong, (int) (1L)),
                'b',
                MaterialLibAPI.getStack(Materials2Materials.Electrum, Materials2Shapes.stick, (int) (1L)),
                'c',
                MaterialLibAPI.getStack(Materials2Materials.Electrum, Materials2Shapes.stickLong, (int) (1L)),
                'd',
                MaterialLibAPI.getStack(Materials2Materials.Electrum, Materials2Shapes.stick, (int) (1L)),
                'e',
                MaterialLibAPI.getStack(Materials2Materials.Electrum, Materials2Shapes.foil, (int) (1L)),
                'f',
                MaterialLibAPI.getStack(Materials2Materials.Electrum, Materials2Shapes.stick, (int) (1L)),
                'g',
                MaterialLibAPI.getStack(Materials2Materials.Electrum, Materials2Shapes.stickLong, (int) (1L)),
                'h',
                MaterialLibAPI.getStack(Materials2Materials.Electrum, Materials2Shapes.stick, (int) (1L)),
                'i',
                MaterialLibAPI.getStack(Materials2Materials.Electrum, Materials2Shapes.stickLong, (int) (1L)));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0),
                GregtechItemList.HiveFrameMutagenic.get(1),
                "abc",
                "def",
                "ghi",
                'a',
                MaterialLibAPI.getStack(Materials2Materials.Uranium235, Materials2Shapes.stickLong, (int) (1L)),
                'b',
                MaterialLibAPI.getStack(Materials2Materials.Plutonium241, Materials2Shapes.stick, (int) (1L)),
                'c',
                MaterialLibAPI.getStack(Materials2Materials.Uranium235, Materials2Shapes.stickLong, (int) (1L)),
                'd',
                MaterialLibAPI.getStack(Materials2Materials.Plutonium241, Materials2Shapes.stick, (int) (1L)),
                'e',
                MaterialLibAPI.getStack(Materials2Materials.Plutonium241, Materials2Shapes.foil, (int) (1L)),
                'f',
                MaterialLibAPI.getStack(Materials2Materials.Plutonium241, Materials2Shapes.stick, (int) (1L)),
                'g',
                MaterialLibAPI.getStack(Materials2Materials.Uranium235, Materials2Shapes.stickLong, (int) (1L)),
                'h',
                MaterialLibAPI.getStack(Materials2Materials.Plutonium241, Materials2Shapes.stick, (int) (1L)),
                'i',
                MaterialLibAPI.getStack(Materials2Materials.Uranium235, Materials2Shapes.stickLong, (int) (1L)));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0),
                GregtechItemList.HiveFrameBusy.get(1),
                "abc",
                "def",
                "ghi",
                'a',
                MaterialLibAPI.getStack(Materials2Materials.BlueSteel, Materials2Shapes.stickLong, (int) (1L)),
                'b',
                MaterialLibAPI.getStack(Materials2Materials.BlueSteel, Materials2Shapes.stick, (int) (1L)),
                'c',
                MaterialLibAPI.getStack(Materials2Materials.BlueSteel, Materials2Shapes.stickLong, (int) (1L)),
                'd',
                MaterialLibAPI.getStack(Materials2Materials.BlueSteel, Materials2Shapes.stick, (int) (1L)),
                'e',
                getModItem(Minecraft.ID, "nether_star", 1, 0),
                'f',
                MaterialLibAPI.getStack(Materials2Materials.BlueSteel, Materials2Shapes.stick, (int) (1L)),
                'g',
                MaterialLibAPI.getStack(Materials2Materials.BlueSteel, Materials2Shapes.stickLong, (int) (1L)),
                'h',
                MaterialLibAPI.getStack(Materials2Materials.BlueSteel, Materials2Shapes.stick, (int) (1L)),
                'i',
                MaterialLibAPI.getStack(Materials2Materials.BlueSteel, Materials2Shapes.stickLong, (int) (1L)));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0),
                GregtechItemList.HiveFrameDecay.get(1),
                "abc",
                "def",
                "ghi",
                'a',
                MaterialLibAPI.getStack(Materials2Materials.CastIron, Materials2Shapes.stickLong, (int) (1)),
                'b',
                MaterialLibAPI.getStack(Materials2Materials.CastIron, Materials2Shapes.stick, (int) (1)),
                'c',
                MaterialLibAPI.getStack(Materials2Materials.CastIron, Materials2Shapes.stickLong, (int) (1)),
                'd',
                MaterialLibAPI.getStack(Materials2Materials.CastIron, Materials2Shapes.stick, (int) (1)),
                'e',
                MaterialLibAPI.getStack(Materials2Materials.CastIron, Materials2Shapes.foil, (int) (1)),
                'f',
                MaterialLibAPI.getStack(Materials2Materials.CastIron, Materials2Shapes.stick, (int) (1)),
                'g',
                MaterialLibAPI.getStack(Materials2Materials.CastIron, Materials2Shapes.stickLong, (int) (1)),
                'h',
                MaterialLibAPI.getStack(Materials2Materials.CastIron, Materials2Shapes.stick, (int) (1)),
                'i',
                MaterialLibAPI.getStack(Materials2Materials.CastIron, Materials2Shapes.stickLong, (int) (1)));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0),
                GregtechItemList.HiveFrameSlow.get(1),
                "abc",
                "def",
                "ghi",
                'a',
                MaterialsAlloy.TUMBAGA.getLongRod(1),
                'b',
                MaterialsAlloy.TUMBAGA.getRod(1),
                'c',
                MaterialsAlloy.TUMBAGA.getLongRod(1),
                'd',
                MaterialsAlloy.TUMBAGA.getRod(1),
                'e',
                MaterialLibAPI.getStack(Materials2Materials.Electrum, Materials2Shapes.foil, (int) (1L)),
                'f',
                MaterialsAlloy.TUMBAGA.getRod(1),
                'g',
                MaterialsAlloy.TUMBAGA.getLongRod(1),
                'h',
                MaterialsAlloy.TUMBAGA.getRod(1),
                'i',
                MaterialsAlloy.TUMBAGA.getLongRod(1));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0),
                GregtechItemList.HiveFrameStabilize.get(1),
                "abc",
                "def",
                "ghi",
                'a',
                MaterialLibAPI.getStack(Materials2Materials.Osmiridium, Materials2Shapes.stickLong, (int) (1L)),
                'b',
                MaterialLibAPI.getStack(Materials2Materials.Osmiridium, Materials2Shapes.stick, (int) (1L)),
                'c',
                MaterialLibAPI.getStack(Materials2Materials.Osmiridium, Materials2Shapes.stickLong, (int) (1L)),
                'd',
                MaterialLibAPI.getStack(Materials2Materials.Osmiridium, Materials2Shapes.stick, (int) (1L)),
                'e',
                MaterialLibAPI.getStack(Materials2Materials.Osmiridium, Materials2Shapes.foil, (int) (1L)),
                'f',
                MaterialLibAPI.getStack(Materials2Materials.Osmiridium, Materials2Shapes.stick, (int) (1L)),
                'g',
                MaterialLibAPI.getStack(Materials2Materials.Osmiridium, Materials2Shapes.stickLong, (int) (1L)),
                'h',
                MaterialLibAPI.getStack(Materials2Materials.Osmiridium, Materials2Shapes.stick, (int) (1L)),
                'i',
                MaterialLibAPI.getStack(Materials2Materials.Osmiridium, Materials2Shapes.stickLong, (int) (1L)));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem(Forestry.ID, "frameImpregnated", 1, 0),
                GregtechItemList.HiveFrameArborist.get(1),
                "abc",
                "def",
                "ghi",
                'a',
                MaterialLibAPI.getStack(Materials2Materials.WoodSealed, Materials2Shapes.stickLong, (int) (1L)),
                'b',
                MaterialLibAPI.getStack(Materials2Materials.WoodSealed, Materials2Shapes.stick, (int) (1L)),
                'c',
                MaterialLibAPI.getStack(Materials2Materials.WoodSealed, Materials2Shapes.stickLong, (int) (1L)),
                'd',
                MaterialLibAPI.getStack(Materials2Materials.WoodSealed, Materials2Shapes.stick, (int) (1L)),
                'e',
                getModItem(Minecraft.ID, "paper", 1, 0),
                'f',
                MaterialLibAPI.getStack(Materials2Materials.WoodSealed, Materials2Shapes.stick, (int) (1L)),
                'g',
                MaterialLibAPI.getStack(Materials2Materials.WoodSealed, Materials2Shapes.stickLong, (int) (1L)),
                'h',
                MaterialLibAPI.getStack(Materials2Materials.WoodSealed, Materials2Shapes.stick, (int) (1L)),
                'i',
                MaterialLibAPI.getStack(Materials2Materials.WoodSealed, Materials2Shapes.stickLong, (int) (1L)));
    }

    private void addThaumcraftAspects() {
        TCMaterialAspectHelper.registerMaterialAspects("Selenium", Aspect.METAL, TCAspects.VESANIA.getAspect());
        TCMaterialAspectHelper.registerMaterialAspects("Iodine", Aspect.METAL, Aspect.HEAL);
        TCMaterialAspectHelper.registerMaterialAspects("Rhenium", Aspect.METAL, Aspect.ELDRITCH);
        TCMaterialAspectHelper.registerMaterialAspects("Thallium", Aspect.METAL, TCAspects.STRONTIO.getAspect());
        TCMaterialAspectHelper.registerMaterialAspects("Germanium", Aspect.METAL, TCAspects.AEQUALITAS.getAspect());
        TCMaterialAspectHelper.registerMaterialAspects("Polonium", Aspect.METAL, TCAspects.RADIO.getAspect());
        TCMaterialAspectHelper.registerMaterialAspects("Radium", Aspect.METAL, TCAspects.RADIO.getAspect());
        TCMaterialAspectHelper.registerMaterialAspects("Protactinium", Aspect.METAL, TCAspects.RADIO.getAspect());
        TCMaterialAspectHelper.registerMaterialAspects("Curium", Aspect.METAL, TCAspects.RADIO.getAspect());
        TCMaterialAspectHelper.registerMaterialAspects("Neptunium", Aspect.METAL, TCAspects.RADIO.getAspect());
        TCMaterialAspectHelper.registerMaterialAspects("Fermium", Aspect.METAL, TCAspects.RADIO.getAspect());
        TCMaterialAspectHelper.registerMaterialAspects("Lithium7", Aspect.ENERGY, TCAspects.AEQUALITAS.getAspect());
        TCMaterialAspectHelper.registerMaterialAspects("Uranium232", Aspect.METAL, TCAspects.RADIO.getAspect());
        TCMaterialAspectHelper.registerMaterialAspects("Uranium233", Aspect.METAL, TCAspects.RADIO.getAspect());
        TCMaterialAspectHelper.registerMaterialAspects("Plutonium238", Aspect.METAL, TCAspects.RADIO.getAspect());
        TCMaterialAspectHelper.registerMaterialAspects("AdvancedNitinol", Aspect.METAL, TCAspects.VESANIA.getAspect());
        TCMaterialAspectHelper.registerMaterialAspects("AstralTitanium", Aspect.METAL, TCAspects.ASTRUM.getAspect());
        TCMaterialAspectHelper.registerMaterialAspects("CelestialTungsten", Aspect.METAL, TCAspects.ASTRUM.getAspect());
        TCMaterialAspectHelper.registerMaterialAspects("Hypogen", Aspect.METAL, TCAspects.GLORIA.getAspect());
        TCMaterialAspectHelper
                .registerMaterialAspects("ChromaticGlass", Aspect.CRYSTAL, TCAspects.PRIMORDIUM.getAspect());
        TCMaterialAspectHelper.registerMaterialAspects("BlackMetal", Aspect.METAL, TCAspects.RADIO.getAspect());
        TCMaterialAspectHelper
                .registerMaterialAspects("AncientGranite", Aspect.ENTROPY, TCAspects.PRIMORDIUM.getAspect());
        TCMaterialAspectHelper.registerMaterialAspects("Runite", Aspect.ENTROPY, TCAspects.PRIMORDIUM.getAspect());
        TCMaterialAspectHelper.registerMaterialAspects("Dragonblood", Aspect.METAL, Lucrum.ULTRA_DEATH);
        TCMaterialAspectHelper.registerMaterialAspects("Staballoy", Aspect.METAL, TCAspects.RADIO.getAspect());
        TCMaterialAspectHelper
                .registerMaterialAspects("Rhugnor", Lucrum.ULTRA_DEATH, (Aspect) MagicBeesAPI.thaumcraftAspectTempus);
    }
}
