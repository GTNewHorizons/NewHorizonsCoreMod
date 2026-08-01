package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.Gendustry;
import static gregtech.api.enums.Mods.Genetics;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.chemicalReactorRecipes;
import static gregtech.api.recipe.RecipeMaps.multiblockChemicalReactorRecipes;
import static gregtech.api.util.GTRecipeBuilder.INGOTS;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeBuilder.WILDCARD;
import static gregtech.api.util.GTRecipeConstants.UniversalChemical;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.FluidShapes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.material.MaterialUtils;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gregtech.common.items.CombType;
import gregtech.loaders.misc.GTBees;
import ic2.core.Ic2Items;

public class ChemicalReactorRecipes implements Runnable {

    @Override
    public void run() {
        singleBlockOnly();
        multiBlockOnly();

        // Cr + 2O = CrO2
        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, (int) (1)))
                .circuit(1)
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (2000)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.ChromiumDioxide, Shapes.dust, (int) (3)))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(UniversalChemical);
        // Rock Salt

        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.PotassiumHydroxideGT5U, 3)).circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials.RockSalt, Shapes.dust, (int) (2)))
                .fluidInputs(MaterialUtils.fluid(Materials.HydrochloricAcidGT5U, 1000))
                .fluidOutputs(GTUtility.getWater(1000)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(UniversalChemical);

        // NaAlO2 + 2H2O = Al(OH)3 + NaOH

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (4)))
                .circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.AluminiumHydroxide, Shapes.dust, (int) (4)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 3))
                .fluidInputs(GTUtility.getWater(2000L)).duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Phenolic.get(1L),
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.foil, (int) (4)))
                .itemOutputs(ItemList.Circuit_Board_Phenolic_Good.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.IronIIIChloride, FluidShapes.fluidLiquid, (int) (100L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Phenolic.get(1L),
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.foil, (int) (4)))
                .itemOutputs(ItemList.Circuit_Board_Phenolic_Good.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SodiumPersulfate, FluidShapes.fluidLiquid, (int) (200)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Plastic, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.foil, (int) (4)))
                .itemOutputs(ItemList.Circuit_Board_Plastic.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SulfuricAcid, FluidShapes.fluidLiquid, (int) (500L)))
                .duration(25 * SECONDS).eut(10).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.PolyvinylChloride, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.foil, (int) (4)))
                .itemOutputs(ItemList.Circuit_Board_Plastic.get(2L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SulfuricAcid, FluidShapes.fluidLiquid, (int) (500L)))
                .duration(25 * SECONDS).eut(10).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Polytetrafluoroethylene, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.foil, (int) (4)))
                .itemOutputs(ItemList.Circuit_Board_Plastic.get(4L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SulfuricAcid, FluidShapes.fluidLiquid, (int) (500L)))
                .duration(25 * SECONDS).eut(10).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Polybenzimidazole, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.foil, (int) (4)))
                .itemOutputs(ItemList.Circuit_Board_Plastic.get(8L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SulfuricAcid, FluidShapes.fluidLiquid, (int) (500L)))
                .duration(25 * SECONDS).eut(10).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic.get(1L),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.foil, (int) (6)))
                .itemOutputs(ItemList.Circuit_Board_Plastic_Advanced.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.IronIIIChloride, FluidShapes.fluidLiquid, (int) (250L)))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic.get(1L),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.foil, (int) (6)))
                .itemOutputs(ItemList.Circuit_Board_Plastic_Advanced.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SodiumPersulfate, FluidShapes.fluidLiquid, (int) (500)))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_LV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Epoxid, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.foil, (int) (8)))
                .itemOutputs(ItemList.Circuit_Board_Epoxy.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SulfuricAcid, FluidShapes.fluidLiquid, (int) (500L)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Epoxy.get(1L),
                        MaterialLibAPI.getStack(Materials.Electrum, Shapes.foil, (int) (8)))
                .itemOutputs(ItemList.Circuit_Board_Epoxy_Advanced.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.IronIIIChloride, FluidShapes.fluidLiquid, (int) (500L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_LV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Epoxy.get(1L),
                        MaterialLibAPI.getStack(Materials.Electrum, Shapes.foil, (int) (8)))
                .itemOutputs(ItemList.Circuit_Board_Epoxy_Advanced.get(1L))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.SodiumPersulfate, FluidShapes.fluidLiquid, (int) (1000L)))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_LV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.EpoxidFiberReinforced, Shapes.plate, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.foil, (int) (12)))
                .itemOutputs(ItemList.Circuit_Board_Fiberglass.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SulfuricAcid, FluidShapes.fluidLiquid, (int) (500L)))
                .duration(25 * SECONDS).eut(10).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Fiberglass.get(1L),
                        MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.foil, (int) (12)))
                .itemOutputs(ItemList.Circuit_Board_Fiberglass_Advanced.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.IronIIIChloride, FluidShapes.fluidLiquid, (int) (1000L)))
                .requiresCleanRoom().duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Fiberglass.get(1L),
                        MaterialLibAPI.getStack(Materials.EnergeticAlloy, Shapes.foil, (int) (12)))
                .itemOutputs(ItemList.Circuit_Board_Fiberglass_Advanced.get(1L))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.SodiumPersulfate, FluidShapes.fluidLiquid, (int) (2000L)))
                .requiresCleanRoom().duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Fiberglass.get(2L),
                        MaterialLibAPI.getStack(Materials.Palladium, Shapes.foil, (int) (16)))
                .itemOutputs(ItemList.Circuit_Board_Multifiberglass.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.SulfuricAcid, FluidShapes.fluidLiquid, (int) (500L)))
                .requiresCleanRoom().duration(30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass.get(1L),
                        MaterialLibAPI.getStack(Materials.Platinum, Shapes.foil, (int) (8)))
                .itemOutputs(ItemList.Circuit_Board_Multifiberglass_Elite.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.IronIIIChloride, FluidShapes.fluidLiquid, (int) (2000L)))
                .requiresCleanRoom().duration(2 * MINUTES).eut(TierEU.RECIPE_MV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Wetware.get(1L),
                        MaterialLibAPI.getStack(Materials.NiobiumTitanium, Shapes.foil, (int) (32)))
                .itemOutputs(ItemList.Circuit_Board_Wetware_Extreme.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.IronIIIChloride, FluidShapes.fluidLiquid, (int) (5000L)))
                .requiresCleanRoom().duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass.get(1L),
                        MaterialLibAPI.getStack(Materials.Platinum, Shapes.foil, (int) (8)))
                .itemOutputs(ItemList.Circuit_Board_Multifiberglass_Elite.get(1L))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.SodiumPersulfate, FluidShapes.fluidLiquid, (int) (4000L)))
                .requiresCleanRoom().duration(2 * MINUTES).eut(TierEU.RECIPE_MV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Wetware.get(1L),
                        MaterialLibAPI.getStack(Materials.NiobiumTitanium, Shapes.foil, (int) (32)))
                .itemOutputs(ItemList.Circuit_Board_Wetware_Extreme.get(1L))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.SodiumPersulfate, FluidShapes.fluidLiquid, (int) (10000L)))
                .requiresCleanRoom().duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Bio.get(1L),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.foil, (int) (24)))
                .itemOutputs(ItemList.Circuit_Board_Bio_Ultra.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.IronIIIChloride, FluidShapes.fluidLiquid, (int) (7500L)))
                .requiresCleanRoom().duration(3 * MINUTES).eut(TierEU.RECIPE_EV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Bio.get(1L),
                        MaterialLibAPI.getStack(Materials.Neutronium, Shapes.foil, (int) (24)))
                .itemOutputs(ItemList.Circuit_Board_Bio_Ultra.get(1L))
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials.SodiumPersulfate, FluidShapes.fluidLiquid, (int) (15000L)))
                .requiresCleanRoom().duration(3 * MINUTES).eut(TierEU.RECIPE_EV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.MutatedEgg.get(),
                        MaterialLibAPI.getStack(Materials.HeeEndium, Shapes.dust, (int) (64)))
                .itemOutputs(NHItemList.EnderEgg.get()).fluidInputs(FluidRegistry.getFluidStack("ender", 1000))
                .requiresCleanRoom().duration(60 * MINUTES).eut(TierEU.RECIPE_HV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Wafer_PIC.get(1L),
                        MaterialLibAPI.getStack(Materials.IndiumGalliumPhosphide, Shapes.dust, (int) (2)))
                .itemOutputs(ItemList.Circuit_Wafer_HPIC.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.VanadiumGallium, FluidShapes.fluidMolten, (int) (288L)))
                .requiresCleanRoom().duration(60 * SECONDS).eut(TierEU.RECIPE_IV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Wafer_HPIC.get(1L),
                        MaterialLibAPI.getStack(Materials.IndiumGalliumPhosphide, Shapes.dust, (int) (8)))
                .itemOutputs(ItemList.Circuit_Wafer_UHPIC.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Naquadah, FluidShapes.fluidMolten, (int) (576L)))
                .requiresCleanRoom().duration(60 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Wafer_NPIC.get(1L),
                        MaterialLibAPI.getStack(Materials.IndiumGalliumPhosphide, Shapes.dust, (int) (64)))
                .itemOutputs(ItemList.Circuit_Wafer_PPIC.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Sunnarium, FluidShapes.fluidMolten, (int) (1440L)))
                .requiresCleanRoom().duration(60 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Wafer_QPIC.get(1L),
                        MaterialLibAPI.getStack(Materials.Iodine, Shapes.dust, (int) (64)))
                .itemOutputs(ItemList.Circuit_Wafer_FPIC.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.InfinityCatalyst, FluidShapes.fluidMolten, (int) (576L)))
                .requiresCleanRoom().duration(60 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Circuit_Wafer_CPU.get(1L), GTUtility.copyAmount(16, Ic2Items.carbonFiber))
                .itemOutputs(ItemList.Circuit_Wafer_NanoCPU.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Glowstone, FluidShapes.fluidMolten, (int) (576L)))
                .requiresCleanRoom().duration(60 * SECONDS).eut(TierEU.RECIPE_EV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Wafer_NanoCPU.get(1L),
                        MaterialLibAPI.getStack(Materials.IndiumGalliumPhosphide, Shapes.dust, (int) (1)))
                .itemOutputs(ItemList.Circuit_Wafer_QuantumCPU.get(1L))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Radon, FluidShapes.fluidGas, (int) (50L)))
                .requiresCleanRoom().duration(60 * SECONDS).eut(TierEU.RECIPE_EV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_NanoCPU.get(1L), ItemList.QuantumEye.get(2L))
                .itemOutputs(ItemList.Circuit_Wafer_QuantumCPU.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.GalliumArsenide, FluidShapes.fluidMolten, (int) (288L)))
                .requiresCleanRoom().duration(45 * SECONDS).eut(TierEU.RECIPE_EV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.ghast_tear)).circuit(1)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Potassium, Shapes.dustTiny, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Lithium, Shapes.dustTiny, (int) (1)))
                .fluidInputs(GTUtility.getWater(1000L))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.SaltWater, FluidShapes.fluidLiquid, (int) (1000L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(UniversalChemical);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.ghast_tear, 9, 0)).circuit(9)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Potassium, Shapes.dust, (int) (1)),
                        MaterialLibAPI.getStack(Materials.Lithium, Shapes.dust, (int) (1)))
                .fluidInputs(GTUtility.getWater(9000L))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.SaltWater, FluidShapes.fluidLiquid, (int) (9000L)))
                .duration(3 * MINUTES).eut(TierEU.RECIPE_LV).addTo(UniversalChemical);

        if (HardcoreEnderExpansion.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            NHItemList.EnderEgg.get(),
                            MaterialLibAPI.getStack(Materials.Draconium, Shapes.dust, (int) (64)))
                    .itemOutputs(NHItemList.DraconiumEgg.get())
                    .fluidInputs(FluidRegistry.getFluidStack("endergoo", 1000)).requiresCleanRoom()
                    .duration(60 * MINUTES).eut(TierEU.RECIPE_EV / 2).addTo(UniversalChemical);

        }

        if (DraconicEvolution.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(NHItemList.DraconiumEgg.get(), getModItem(DraconicEvolution.ID, "dragonHeart", 0, 0))
                    .itemOutputs(new ItemStack(Blocks.dragon_egg, 1, 0))
                    .fluidInputs(
                            MaterialLibAPI
                                    .getFluidStack(Materials.Enderium, FluidShapes.fluidMolten, (int) (7 * INGOTS)))
                    .requiresCleanRoom().duration(60 * MINUTES).eut(TierEU.RECIPE_EV).addTo(UniversalChemical);

        }

        if (Genetics.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(new ItemStack(Items.spawn_egg, 1, WILDCARD), getModItem(Genetics.ID, "misc", 64, 4))
                    .itemOutputs(NHItemList.TheBigEgg.get())
                    .fluidInputs(FluidRegistry.getFluidStack("binnie.bacteria", 1000)).requiresCleanRoom()
                    .duration(60 * MINUTES).eut(TierEU.RECIPE_MV).addTo(UniversalChemical);

            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(Botania.ID, "cocoon", 1, 0), getModItem(Genetics.ID, "misc", 64, 4))
                    .itemOutputs(NHItemList.TheBigEgg.get())
                    .fluidInputs(FluidRegistry.getFluidStack("binnie.bacteria", 1000)).requiresCleanRoom()
                    .duration(60 * MINUTES).eut(TierEU.RECIPE_MV).addTo(UniversalChemical);

        }

        if (Gendustry.isModLoaded() && IndustrialCraft2.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(NHItemList.TheBigEgg.get(), ItemList.IC2_Uranium_238.get(64))
                    .itemOutputs(NHItemList.MutatedEgg.get()).fluidInputs(FluidRegistry.getFluidStack("mutagen", 1000))
                    .requiresCleanRoom().duration(60 * MINUTES).eut(TierEU.RECIPE_HV / 2).addTo(UniversalChemical);

        }

        if (TinkerConstruct.isModLoaded()) {
            // Chemical Reactor

            GTValues.RA.stdBuilder()
                    .itemInputs(new ItemStack(Blocks.diamond_block, 8, 0), new ItemStack(Items.golden_apple, 1, 1))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "diamondApple", 1, 0))
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Blaze, FluidShapes.fluidMolten, (int) (144)))
                    .duration(3 * MINUTES).eut(TierEU.RECIPE_HV).addTo(UniversalChemical);

        }

        if (Botania.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(Botania.ID, "manaBottle", 1, 0),
                            getModItem(HardcoreEnderExpansion.ID, "essence", 1, 0))
                    .itemOutputs(getModItem(Botania.ID, "manaResource", 1, 15))
                    .fluidInputs(FluidRegistry.getFluidStack("liquidair", 1000)).duration(1 * MINUTES)
                    .eut(TierEU.RECIPE_MV).addTo(UniversalChemical);

        }

    }

    public static void singleBlockOnly() {
        // 6HF + Al(OH)3 + 3NaOH = Na3AlF6 + 6H2O

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 9L),
                        MaterialLibAPI.getStack(Materials.AluminiumHydroxide, Shapes.dust, (int) (4L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Cryolite, Shapes.dust, (int) (10L)))
                .fluidInputs(MaterialUtils.fluid(Materials.HydrofluoricAcidGT5U, 6000L))
                .fluidOutputs(GTUtility.getWater(6000L)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(chemicalReactorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Bauxite, Shapes.dust, (int) (4L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 12L))
                .itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (16L)))
                .fluidInputs(GTUtility.getWater(1000L)).duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(chemicalReactorRecipes);

    }

    public static void multiBlockOnly() {

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.AluminiumHydroxide, Shapes.dust, (int) (28L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 63L))
                .circuit(24)
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Cryolite, Shapes.dust, (int) (64L)),
                        MaterialLibAPI.getStack(Materials.Cryolite, Shapes.dust, (int) (6L)))
                .fluidInputs(MaterialUtils.fluid(Materials.HydrofluoricAcidGT5U, 42000L))
                .fluidOutputs(GTUtility.getWater(42000L)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Bauxite, Shapes.dust, (int) (16L)),
                        MaterialLibAPI.getStack(Materials.SodiumCarbonate, Shapes.dust, (int) (16L)),
                        MaterialLibAPI.getStack(Materials.Coal, Shapes.dust, (int) (16L)))
                .circuit(24).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (64L)))
                .fluidInputs(GTUtility.getWater(2000L))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, (int) (1000L)),
                        MaterialLibAPI.getFluidStack(Materials.CarbonDioxide, FluidShapes.fluidGas, (int) (4000L)),
                        MaterialLibAPI.getFluidStack(Materials.RedMud, FluidShapes.fluidLiquid, (int) (1000L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Bauxite, Shapes.dust, (int) (16L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 48L))
                .circuit(24).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (64L)))
                .fluidInputs(GTUtility.getWater(4000L)).fluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Mica, Shapes.dust, (int) (16L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 48L))
                .circuit(24).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (64L)))
                .fluidInputs(GTUtility.getWater(4000L)).fluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Zeolite, Shapes.dust, (int) (16L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 48L))
                .circuit(24).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (64L)))
                .fluidInputs(GTUtility.getWater(4000L)).fluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Tanzanite, Shapes.dust, (int) (16L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 48L))
                .circuit(24).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (64L)))
                .fluidInputs(GTUtility.getWater(4000L)).fluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Lazurite, Shapes.dust, (int) (16L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 48L))
                .circuit(24).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (64L)))
                .fluidInputs(GTUtility.getWater(4000L)).fluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Sodalite, Shapes.dust, (int) (16L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 48L))
                .circuit(24).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (64L)))
                .fluidInputs(GTUtility.getWater(4000L)).fluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Biotite, Shapes.dust, (int) (16L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 48L))
                .circuit(24).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (64L)))
                .fluidInputs(GTUtility.getWater(4000L)).fluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Glauconite, Shapes.dust, (int) (16L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 48L))
                .circuit(24).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (64L)))
                .fluidInputs(GTUtility.getWater(4000L)).fluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Lepidolite, Shapes.dust, (int) (16L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 48L))
                .circuit(24).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (64L)))
                .fluidInputs(GTUtility.getWater(4000L)).fluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.GlauconiteSand, Shapes.dust, (int) (16L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 48L))
                .circuit(24).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (64L)))
                .fluidInputs(GTUtility.getWater(4000L)).fluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Vermiculite, Shapes.dust, (int) (16L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 48L))
                .circuit(24).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (64L)))
                .fluidInputs(GTUtility.getWater(4000L)).fluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.RawPicoWafer.get(),
                        MaterialLibAPI.getStack(Materials.MysteriousCrystal, Shapes.dust, (int) (2)),
                        MaterialLibAPI.getStack(Materials.InfinityCatalyst, Shapes.dustTiny, (int) (1L)).copy()
                                .splitStack(0),
                        NHItemList.TCetiESeaweedExtract.get(1))
                .itemOutputs(NHItemList.PicoWafer.get())
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Neutronium, FluidShapes.fluidMolten, (int) (144L)))
                .duration(2 * MINUTES + 30 * SECONDS).eut((GTValues.V[9] - (GTValues.V[9] / 10)))
                .addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.dust, (int) (16L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxideGT5U, 48L))
                .circuit(24).itemOutputs(MaterialLibAPI.getStack(Materials.SodiumAluminate, Shapes.dust, (int) (64L)))
                .fluidInputs(GTUtility.getWater(16000L))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, (int) (48000L)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder()
                .fluidInputs(FluidRegistry.getFluidStack("blood", 1000), FluidRegistry.getFluidStack("netherair", 100))
                .fluidOutputs(FluidRegistry.getFluidStack("hell_blood", 1000)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Wafer_Bioware.get(1L),
                        MaterialLibAPI.getStack(Materials.Tartarite, Shapes.dust, (int) (2)),
                        MaterialLibAPI.getStack(Materials.RadoxPoly, Shapes.dust, (int) (1)),
                        NHItemList.TCetiESeaweedExtract.get(1))
                .itemOutputs(ItemList.Circuit_Wafer_APIC.get(1L))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials.DimensionallyTranscendentResidue,
                                FluidShapes.fluidLiquid,
                                (int) (1000L)))
                .requiresCleanRoom().duration(60 * SECONDS).eut(TierEU.RECIPE_UEV)
                .addTo(multiblockChemicalReactorRecipes);

        if (Forestry.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.Aluminium, Shapes.dust, (int) (36L)),
                            GTBees.combs.getStackForType(CombType.INDIUM, 4))
                    .circuit(3).itemOutputs(MaterialLibAPI.getStack(Materials.Indium, Shapes.dust, (int) (3L)))
                    .fluidInputs(new FluidStack(ItemList.sIndiumConcentrate, 72000))
                    .fluidOutputs(new FluidStack(ItemList.sLeadZincSolution, 72000)).duration(22 * SECONDS + 10 * TICKS)
                    .eut(TierEU.RECIPE_HV).addTo(multiblockChemicalReactorRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.IndiumPhosphate, Shapes.dust, (int) (12)),
                            MaterialLibAPI.getStack(Materials.Calcium, Shapes.dust, (int) (3)),
                            GTBees.combs.getStackForType(CombType.INDIUM, 8))
                    .circuit(2)
                    .itemOutputs(
                            MaterialLibAPI.getStack(Materials.Indium, Shapes.dust, (int) (6)),
                            MaterialLibAPI.getStack(Materials.TricalciumPhosphate, Shapes.dust, (int) (5)))
                    .duration(1 * SECONDS).eut(TierEU.RECIPE_LV).addTo(multiblockChemicalReactorRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.Indium, Shapes.crushed, (int) (4)),
                            GTBees.combs.getStackForType(CombType.INDIUM, 16))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Indium, Shapes.crushedPurified, (int) (12)))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(Materials.phtalicacid, FluidShapes.fluidLiquid, (int) (2688)))
                    .duration(14 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_IV).addTo(UniversalChemical);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            MaterialLibAPI.getStack(Materials.Roquesite, Shapes.dust, (int) (4)),
                            GTBees.combs.getStackForType(CombType.INDIUM, 4))
                    .itemOutputs(
                            MaterialLibAPI.getStack(Materials.Copper, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Indium, Shapes.dust, (int) (3)),
                            MaterialLibAPI.getStack(Materials.Sulfur, Shapes.dust, (int) (2)))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(Materials.phtalicacid, FluidShapes.fluidLiquid, (int) (90)))
                    .duration(3 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_HV).addTo(multiblockChemicalReactorRecipes);
        }
    }

}
