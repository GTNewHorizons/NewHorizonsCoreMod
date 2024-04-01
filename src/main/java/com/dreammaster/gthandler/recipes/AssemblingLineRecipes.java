package com.dreammaster.gthandler.recipes;

import static com.github.technus.tectech.loader.recipe.BaseRecipeLoader.getItemContainer;
import static com.google.common.math.LongMath.pow;
import static gregtech.api.enums.Mods.*;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.HOURS;
import static gregtech.api.util.GT_RecipeBuilder.INGOTS;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.WILDCARD;
import static gregtech.api.util.GT_RecipeConstants.AssemblyLine;
import static gregtech.api.util.GT_RecipeConstants.RESEARCH_ITEM;
import static gregtech.api.util.GT_RecipeConstants.RESEARCH_TIME;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;
import com.github.technus.tectech.recipe.TT_recipeAdder;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsBotania;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import vazkii.botania.api.BotaniaAPI;

public class AssemblingLineRecipes implements Runnable {

    @Override
    public void run() {
        Fluid solderIndalloy = FluidRegistry.getFluid("molten.indalloy140") != null
                ? FluidRegistry.getFluid("molten.indalloy140")
                : FluidRegistry.getFluid("molten.solderingalloy");

        // Heavy duty alloy ingot T5
        GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, CustomItemList.HeavyDutyPlateTier4.get(1L))
                .metadata(RESEARCH_TIME, 4 * MINUTES + 10 * SECONDS)
                .itemInputs(
                        CustomItemList.HeavyDutyPlateTier4.get(1L),
                        CustomItemList.QuantinumCompressedPlate.get(4L),
                        CustomItemList.QuantinumCompressedPlate.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Europium, 8))
                .fluidInputs(new FluidStack(solderIndalloy, 72))
                .itemOutputs(CustomItemList.HeavyDutyAlloyIngotT5.get(1L)).eut(TierEU.RECIPE_ZPM).duration(15 * SECONDS)
                .addTo(AssemblyLine);

        // Heavy duty alloy ingot T6
        GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, CustomItemList.HeavyDutyPlateTier5.get(1L))
                .metadata(RESEARCH_TIME, 375 * SECONDS)
                .itemInputs(
                        CustomItemList.HeavyDutyPlateTier5.get(1L),
                        CustomItemList.LeadOriharukonPlate.get(5L),
                        CustomItemList.LeadOriharukonPlate.get(5L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tritanium, 8))
                .fluidInputs(new FluidStack(solderIndalloy, 144))
                .itemOutputs(CustomItemList.HeavyDutyAlloyIngotT6.get(1L)).eut(TierEU.RECIPE_UV).duration(15 * SECONDS)
                .addTo(AssemblyLine);

        // Heavy duty alloy ingot T7
        GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, CustomItemList.HeavyDutyPlateTier6.get(1L))
                .metadata(RESEARCH_TIME, 500 * SECONDS)
                .itemInputs(
                        CustomItemList.HeavyDutyPlateTier6.get(1L),
                        CustomItemList.MysteriousCrystalCompressedPlate.get(6L),
                        CustomItemList.MysteriousCrystalCompressedPlate.get(6L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Neutronium, 10))
                .fluidInputs(new FluidStack(solderIndalloy, 288))
                .itemOutputs(CustomItemList.HeavyDutyAlloyIngotT7.get(1L)).eut(TierEU.RECIPE_UHV).duration(15 * SECONDS)
                .addTo(AssemblyLine);

        // Heavy duty alloy ingot T8
        GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, CustomItemList.HeavyDutyPlateTier7.get(1L))
                .metadata(RESEARCH_TIME, 625 * SECONDS)
                .itemInputs(
                        CustomItemList.HeavyDutyPlateTier7.get(1L),
                        CustomItemList.BlackPlutoniumCompressedPlate.get(7L),
                        CustomItemList.BlackPlutoniumCompressedPlate.get(7L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.BlackPlutonium, 12))
                .fluidInputs(new FluidStack(solderIndalloy, 576))
                .itemOutputs(CustomItemList.HeavyDutyAlloyIngotT8.get(1L)).eut(TierEU.RECIPE_UEV).duration(15 * SECONDS)
                .addTo(AssemblyLine);

        // Mainframe Circuits and Neuro CPU
        GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Circuit_Chip_Stemcell.get(1L))
                .metadata(RESEARCH_TIME, 1 * HOURS)
                .itemInputs(
                        ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                        ItemList.Circuit_Chip_Stemcell.get(16L),
                        ItemList.Circuit_Parts_Reinforced_Glass_Tube.get(16L),
                        GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Polybenzimidazole, 8L),
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.NaquadahEnriched, 4L),
                        new Object[] { OrePrefixes.foil.get(Materials.AnySyntheticRubber), 64L },
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 32L))
                .fluidInputs(
                        Materials.GrowthMediumSterilized.getFluid(250L),
                        Materials.UUMatter.getFluid(250L),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000))
                .itemOutputs(ItemList.Circuit_Chip_NeuroCPU.get(1L)).eut(TierEU.RECIPE_ZPM).duration(30 * SECONDS)
                .addTo(AssemblyLine);

        GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Circuit_Chip_NeuroCPU.get(1L))
                .metadata(RESEARCH_TIME, 2 * HOURS)
                .itemInputs(
                        ItemList.Circuit_Board_Bio_Ultra.get(1L),
                        ItemList.Circuit_Chip_Biocell.get(16L),
                        ItemList.Circuit_Parts_Reinforced_Glass_Tube.get(16L),
                        GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Polybenzimidazole, 16),
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.ElectrumFlux, 16L),
                        new Object[] { OrePrefixes.foil.get(Materials.AnySyntheticRubber), 64L },
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSS, 32L))
                .fluidInputs(
                        Materials.BioMediumSterilized.getFluid(500L),
                        Materials.UUMatter.getFluid(500L),
                        new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000))
                .itemOutputs(ItemList.Circuit_Chip_BioCPU.get(1L)).eut(TierEU.RECIPE_UHV / 2).duration(30 * SECONDS)
                .addTo(AssemblyLine);

        GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Energy_LapotronicOrb.get(1L))
                .metadata(RESEARCH_TIME, 4 * HOURS)
                .itemInputs(
                        ItemList.Circuit_Board_Multifiberglass.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NaquadahAlloy, 64L),
                        new Object[] { OrePrefixes.circuit.get(Materials.Master), 4L },
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(36L),
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(36L),
                        ItemList.Circuit_Chip_HPIC.get(64L),
                        ItemList.Circuit_Parts_DiodeASMD.get(8L),
                        ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                        ItemList.Circuit_Parts_ResistorASMD.get(8L),
                        ItemList.Circuit_Parts_TransistorASMD.get(8L),
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 64))
                .fluidInputs(new FluidStack(solderIndalloy, 720)).itemOutputs(ItemList.Energy_LapotronicOrb2.get(1L))
                .eut(TierEU.RECIPE_ZPM).duration(50 * SECONDS).addTo(AssemblyLine);

        // Advanced Stocking Input Bus (ME)
        GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Hatch_Input_Bus_ME.get(1L))
                .metadata(RESEARCH_TIME, 1 * HOURS)
                .itemInputs(
                        ItemList.Hatch_Input_Bus_LuV.get(1L),
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1L),
                        ItemList.Conveyor_Module_IV.get(1L),
                        // Acceleration Card
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4L, 30))
                .fluidInputs(new FluidStack(solderIndalloy, 288), FluidRegistry.getFluidStack("lubricant", 500))
                .itemOutputs(ItemList.Hatch_Input_Bus_ME_Advanced.get(1L)).eut(TierEU.RECIPE_LuV).duration(15 * SECONDS)
                .addTo(AssemblyLine);

        if (TecTech.isModLoaded()) {

            TT_recipeAdder.addResearchableAssemblylineRecipe(
                    ItemList.Electric_Motor_UXV.get(1L),
                    2_000_000_000,
                    2_000_000,
                    (int) TierEU.RECIPE_MAX,
                    1_024_000,
                    new Object[] { GT_OreDictUnificator.get(OrePrefixes.stickLong, MaterialsBotania.GaiaSpirit, 18L),
                            GT_OreDictUnificator.get(OrePrefixes.plateDense, MaterialsBotania.Terrasteel, 19L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, MaterialsUEVplus.MagMatter, 61L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, MaterialsUEVplus.MagMatter, 63L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, MaterialsUEVplus.MagMatter, 62L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, MaterialsUEVplus.MagMatter, 59L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUMV, 18L),
                            CustomItemList.PikoCircuit.get(15L),
                            GT_OreDictUnificator.get(OrePrefixes.nanite, MaterialsUEVplus.Universium, 14L) },

                    new FluidStack[] { Materials.Lubricant.getFluid(2880000L),
                            MaterialsBotania.GaiaSpirit.getMolten(2880L),
                            MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter.getMolten(2880L),
                            MaterialsUEVplus.MagMatter.getMolten(5760L),

                    },
                    ItemList.Electric_Motor_MAX.get(1L),
                    3 * HOURS + 2 * MINUTES + 5 * SECONDS,
                    (int) TierEU.RECIPE_MAX);

            TT_recipeAdder.addResearchableAssemblylineRecipe(
                    ItemList.Electric_Piston_UXV.get(1L),
                    2_000_000_000,
                    2_000_000,
                    (int) TierEU.RECIPE_MAX,
                    1_024_000,
                    new Object[] { ItemList.Electric_Motor_MAX.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.plateDense, MaterialsBotania.Terrasteel, 7L),
                            GT_OreDictUnificator.get(OrePrefixes.plateDense, MaterialsUEVplus.MagMatter, 9L),
                            GT_OreDictUnificator.get(OrePrefixes.stick, MaterialsUEVplus.BlackDwarfMatter, 34L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, MaterialsBotania.GaiaSpirit, 62L),
                            GT_OreDictUnificator.get(OrePrefixes.round, MaterialsUEVplus.MagMatter, 61L),
                            GT_OreDictUnificator.get(OrePrefixes.round, MaterialsBotania.Terrasteel, 59L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUMV, 47),
                            CustomItemList.QuantumCircuit.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.nanite, MaterialsUEVplus.Universium, 32) },

                    new FluidStack[] { Materials.Lubricant.getFluid(2880000L),
                            MaterialsBotania.GaiaSpirit.getMolten(2880L),
                            MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter.getMolten(2880L),
                            MaterialsUEVplus.MagMatter.getMolten(5760L),

                    },
                    ItemList.Electric_Piston_MAX.get(1L),
                    3 * HOURS + 2 * MINUTES + 5 * SECONDS,
                    (int) TierEU.RECIPE_MAX);

            TT_recipeAdder
                    .addResearchableAssemblylineRecipe(
                            ItemList.Electric_Pump_UXV.get(1L),
                            2_000_000_000,
                            2_000_000,
                            (int) TierEU.RECIPE_MAX,
                            1_024_000,
                            new Object[] { ItemList.Electric_Motor_MAX.get(3L),
                                    GT_OreDictUnificator.get(OrePrefixes.plateDense, MaterialsBotania.Terrasteel, 11L),
                                    GT_OreDictUnificator.get(OrePrefixes.plateDense, MaterialsUEVplus.MagMatter, 9L),
                                    GT_OreDictUnificator.get(OrePrefixes.pipeHuge, MaterialsUEVplus.SpaceTime, 45L),
                                    GT_OreDictUnificator.get(OrePrefixes.rotor, MaterialsBotania.GaiaSpirit, 62L),
                                    GT_OreDictUnificator.get(
                                            OrePrefixes.ring,
                                            MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter,
                                            22L),
                                    GT_OreDictUnificator.get(OrePrefixes.round, MaterialsUEVplus.MagMatter, 64L),
                                    GT_OreDictUnificator.get(
                                            OrePrefixes.round,
                                            MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter,
                                            57L),
                                    GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUMV, 37L),
                                    CustomItemList.QuantumCircuit.get(14L),
                                    GT_OreDictUnificator.get(OrePrefixes.nanite, MaterialsUEVplus.Universium, 45L) },

                            new FluidStack[] { Materials.Lubricant.getFluid(2880000L),
                                    MaterialsBotania.GaiaSpirit.getMolten(2880L),
                                    MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter.getMolten(2880L),
                                    MaterialsUEVplus.MagMatter.getMolten(5760L),

                            },
                            ItemList.Electric_Pump_MAX.get(1L),
                            3 * HOURS + 2 * MINUTES + 5 * SECONDS,
                            (int) TierEU.RECIPE_MAX);

            TT_recipeAdder.addResearchableAssemblylineRecipe(
                    ItemList.Conveyor_Module_UXV.get(1L),
                    2_000_000_000,
                    2_000_000,
                    (int) TierEU.RECIPE_MAX,
                    1_024_000,
                    new Object[] { ItemList.Electric_Motor_MAX.get(8L),
                            GT_OreDictUnificator.get(OrePrefixes.plateDense, MaterialsBotania.Terrasteel, 6L),
                            GT_OreDictUnificator.get(OrePrefixes.plateDense, MaterialsUEVplus.MagMatter, 9L),
                            GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.StyreneButadieneRubber, 64L),
                            GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.StyreneButadieneRubber, 64L),
                            GT_OreDictUnificator.get(OrePrefixes.ring, MaterialsUEVplus.BlackDwarfMatter, 64L),
                            GT_OreDictUnificator.get(OrePrefixes.round, MaterialsUEVplus.MagMatter, 64L),
                            GT_OreDictUnificator.get(
                                    OrePrefixes.round,
                                    MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter,
                                    64L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUMV, 32L),
                            CustomItemList.QuantumCircuit.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.nanite, MaterialsUEVplus.Universium, 64L) },

                    new FluidStack[] { Materials.Rubber.getFluid(2_000_000_000),
                            MaterialsBotania.GaiaSpirit.getMolten(2880L),
                            MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter.getMolten(2880L),
                            MaterialsUEVplus.MagMatter.getMolten(5760L),

                    },
                    ItemList.Conveyor_Module_MAX.get(1L),
                    3 * HOURS + 2 * MINUTES + 5 * SECONDS,
                    (int) TierEU.RECIPE_MAX);

            TT_recipeAdder.addResearchableAssemblylineRecipe(
                    ItemList.Robot_Arm_UXV.get(1L),
                    2_000_000_000,
                    2_000_000,
                    (int) TierEU.RECIPE_MAX,
                    1_024_000,
                    new Object[] { ItemList.Electric_Motor_MAX.get(5L), ItemList.Electric_Piston_MAX.get(3L),
                            ItemList.Conveyor_Module_UXV.get(10L), CustomItemList.QuantumCircuit.get(63L),
                            CustomItemList.PikoCircuit.get(62L), CustomItemList.QuantumCircuit.get(61L),
                            new Object[] { OrePrefixes.circuit.get(Materials.Master), 60L },
                            GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Alumite, 31L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUMV, 37L),
                            GT_OreDictUnificator.get(OrePrefixes.nanite, MaterialsUEVplus.Universium, 31L)

                    },

                    new FluidStack[] { Materials.Lubricant.getFluid(2134567L),
                            MaterialsBotania.GaiaSpirit.getMolten(12345L),
                            MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter.getMolten(100_000L),
                            MaterialsUEVplus.MagMatter.getMolten(5432L),

                    },
                    ItemList.Robot_Arm_MAX.get(1L),
                    3 * HOURS + 2 * MINUTES + 5 * SECONDS,
                    (int) TierEU.RECIPE_MAX);

            TT_recipeAdder.addResearchableAssemblylineRecipe(
                    ItemList.Emitter_UXV.get(1L),
                    2_000_000_000,
                    2_000_000,
                    (int) TierEU.RECIPE_MAX,
                    1_024_000,
                    new Object[] { ItemList.Electric_Motor_MAX.get(3L), CustomItemList.QuantumCircuit.get(64L),
                            new Object[] { OrePrefixes.circuit.get(Materials.Master), 31L },
                            GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Alumite, 31L),
                            GT_OreDictUnificator.get(OrePrefixes.foil, MaterialsBotania.Terrasteel, 31L),
                            GT_OreDictUnificator.get(OrePrefixes.foil, MaterialsUEVplus.WhiteDwarfMatter, 46L),
                            GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Praseodymium, 42L),
                            GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silver, 47L),
                            GT_OreDictUnificator.get(OrePrefixes.foil, Materials.SamariumMagnetic, 22L),
                            GT_OreDictUnificator.get(OrePrefixes.foil, MaterialsUEVplus.MagMatter, 4L),
                            GT_OreDictUnificator.get(
                                    OrePrefixes.foil,
                                    MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter,
                                    37L),
                            GT_OreDictUnificator.get(OrePrefixes.foil, MaterialsBotania.GaiaSpirit, 17L),
                            GT_OreDictUnificator.get(OrePrefixes.foil, MaterialsBotania.ElvenElementium, 64L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUV, 55L),
                            GT_OreDictUnificator.get(OrePrefixes.nanite, MaterialsUEVplus.Universium, 22L)

                    },

                    new FluidStack[] { Materials.Benzene.getFluid(2586756L),
                            MaterialsBotania.GaiaSpirit.getMolten(8675L),
                            MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter.getMolten(68574),
                            MaterialsUEVplus.MagMatter.getMolten(6757),

                    },
                    ItemList.Emitter_MAX.get(1L),
                    6 * HOURS + 3 * MINUTES + 5 * SECONDS,
                    (int) TierEU.RECIPE_MAX);

            TT_recipeAdder.addResearchableAssemblylineRecipe(
                    ItemList.Sensor_UXV.get(1L),
                    2_000_000_000,
                    2_000_000,
                    (int) TierEU.RECIPE_MAX,
                    1_024_000,
                    new Object[] { ItemList.Electric_Motor_MAX.get(6L), CustomItemList.QuantumCircuit.get(1L),
                            new Object[] { OrePrefixes.circuit.get(Materials.Ultimate), 1L },
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Alumite, 31L),
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, MaterialsBotania.Terrasteel, 31L),
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, MaterialsUEVplus.WhiteDwarfMatter, 46L),
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Praseodymium, 42L),
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Silver, 47L),
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.SamariumMagnetic, 22L),
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, MaterialsUEVplus.MagMatter, 4L),
                            GT_OreDictUnificator.get(
                                    OrePrefixes.frameGt,
                                    MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter,
                                    37L),
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, MaterialsBotania.GaiaSpirit, 17L),
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, MaterialsBotania.ElvenElementium, 64L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorEV, 55L),
                            GT_OreDictUnificator.get(OrePrefixes.nanite, MaterialsUEVplus.Universium, 22L)

                    },

                    new FluidStack[] { Materials.AceticAcid.getFluid(2586756L),
                            MaterialsBotania.GaiaSpirit.getMolten(8675L),
                            MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter.getMolten(68574),
                            MaterialsUEVplus.MagMatter.getMolten(6757),

                    },
                    ItemList.Sensor_MAX.get(1L),
                    6 * HOURS + 3 * MINUTES + 5 * SECONDS,
                    (int) TierEU.RECIPE_MAX);

            TT_recipeAdder.addResearchableAssemblylineRecipe(
                    ItemList.Field_Generator_UXV.get(1L),
                    2_000_000_000,
                    2_000_000,
                    (int) TierEU.RECIPE_MAX,
                    1_024_000,
                    new Object[] { ItemList.Field_Generator_LV.get(32L), ItemList.Field_Generator_MV.get(25L),
                            ItemList.Field_Generator_HV.get(63L), ItemList.Field_Generator_EV.get(22L),
                            ItemList.Field_Generator_IV.get(31L), ItemList.Field_Generator_LuV.get(8L),
                            ItemList.Field_Generator_ZPM.get(12L), ItemList.Field_Generator_UV.get(8L),
                            ItemList.Field_Generator_UHV.get(4L), ItemList.Field_Generator_UEV.get(2L),
                            ItemList.Field_Generator_UIV.get(1L), ItemList.Field_Generator_UMV.get(11L),
                            ItemList.Field_Generator_UXV.get(22L)

                    },

                    new FluidStack[] { Materials.Infinity.getMolten(500_000_000), Materials.BioDiesel.getFluid(9793),
                            Materials.Grade1PurifiedWater.getFluid(1857476),
                            MaterialsUEVplus.MagMatter.getMolten(12222),

                    },
                    ItemList.Field_Generator_MAX.get(1L),
                    MINUTES * HOURS,
                    (int) TierEU.RECIPE_LV);

            TT_recipeAdder.addResearchableAssemblylineRecipe(
                    CustomItemList.HighEnergyFlowCircuit.get(1L),
                    1_000_000,
                    64,
                    (int) TierEU.RECIPE_LuV,
                    32,
                    new Object[] { ItemList.Transformer_LV_ULV.get(1L), ItemList.Transformer_MV_LV.get(2L),
                            ItemList.Transformer_HV_MV.get(3L), ItemList.Transformer_EV_HV.get(4L),
                            ItemList.Transformer_IV_EV.get(5L), ItemList.Transformer_LuV_IV.get(6L),
                            ItemList.Transformer_ZPM_LuV.get(7L), ItemList.Transformer_UV_ZPM.get(1L),
                            ItemList.Transformer_MAX_UV.get(1L), CustomItemList.HighEnergyFlowCircuit.get(5L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 64L) },

                    new FluidStack[] { Materials.Lubricant.getFluid(2000), Materials.Cobalt.getMolten(144 * 20) },
                    com.github.technus.tectech.thing.CustomItemList.Machine_Multi_Transformer.get(1L),
                    10 * MINUTES,
                    (int) TierEU.RECIPE_ZPM);

            TT_recipeAdder.addResearchableAssemblylineRecipe(
                    com.github.technus.tectech.thing.CustomItemList.SpacetimeCompressionFieldGeneratorTier8.get(1),
                    10 * 48_000_000,
                    10 * 16_384,
                    (int) TierEU.RECIPE_MAX,
                    10 * 8,
                    new Object[] { com.github.technus.tectech.thing.CustomItemList.EOH_Reinforced_Spatial_Casing.get(1),
                            // T10 Yotta cell.
                            GT_ModHandler.getModItem(GoodGenerator.ID, "yottaFluidTankCells", 1, 9),
                            // quantum tank V (max tier)
                            ItemList.Quantum_Tank_IV.get(4 * 10),
                            // Inf chest
                            GT_ModHandler.getModItem(AvaritiaAddons.ID, "InfinityChest", 10),
                            // Spacetime continuum ripper
                            GT_ModHandler.getModItem(GTPlusPlus.ID, "gtplusplus.blockcasings.5", 4, 10),
                            GT_ModHandler.getModItem("appliedenergistics2", "tile.BlockSingularityCraftingStorage", 1),
                            GT_ModHandler
                                    .getModItem("appliedenergistics2", "item.ItemExtremeStorageCell.Singularity", 1),
                            GT_ModHandler
                                    .getModItem("appliedenergistics2", "item.ItemExtremeStorageCell.Singularity", 1),
                            GT_ModHandler
                                    .getModItem("appliedenergistics2", "item.ItemExtremeStorageCell.Singularity", 1),
                            GT_ModHandler
                                    .getModItem("appliedenergistics2", "item.ItemExtremeStorageCell.Singularity", 1),
                            GT_ModHandler
                                    .getModItem("appliedenergistics2", "item.ItemExtremeStorageCell.Singularity", 1),
                            GT_ModHandler
                                    .getModItem("appliedenergistics2", "item.ItemExtremeStorageCell.Singularity", 1),
                            GT_ModHandler
                                    .getModItem("appliedenergistics2", "item.ItemExtremeStorageCell.Singularity", 1),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, MaterialsUEVplus.MagMatter, 2),
                            GT_OreDictUnificator.get(
                                    OrePrefixes.bolt,
                                    MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter,
                                    32),
                            getItemContainer("QuantumCircuit").get(3) },
                    new FluidStack[] {
                            new FluidStack(
                                    FluidRegistry.getFluid("molten.mutatedlivingsolder"),
                                    (int) (2_880 * pow(2L, 9))),
                            MaterialsUEVplus.Space.getMolten(1_440 * 10), MaterialsUEVplus.SpaceTime.getMolten(1_440),
                            MaterialsBotania.Terrasteel.getMolten(144 * 4096) },
                    CustomItemList.SpacetimeCompressionFieldGeneratorTier10.get(1),
                    10 * 4_000 * 20,
                    (int) TierEU.RECIPE_UXV);

            TT_recipeAdder
                    .addResearchableAssemblylineRecipe(
                            com.github.technus.tectech.thing.CustomItemList.TimeAccelerationFieldGeneratorTier8.get(1),
                            10 * 48_000_000,
                            10 * 16_384,
                            (int) TierEU.RECIPE_MAX,
                            10 * 8,
                            new Object[] {
                                    com.github.technus.tectech.thing.CustomItemList.EOH_Reinforced_Temporal_Casing
                                            .get(1),
                                    GregtechItemList.FusionComputer_UV3.get(1),
                                    getModItem(GoodGenerator.ID, "compactFusionCoil", 1, 4),
                                    // UV Solar panel
                                    getModItem(SuperSolarPanels.ID, "PhotonicSolarPanel", 10, 0),
                                    getItemContainer("QuantumCircuit").get(10),
                                    // Red Spectral Component
                                    getModItem(SuperSolarPanels.ID, "redcomponent", 64),
                                    // Green Spectral Component
                                    getModItem(SuperSolarPanels.ID, "greencomponent", 64),
                                    // Blue Spectral Component
                                    getModItem(SuperSolarPanels.ID, "bluecomponent", 64),

                                    GT_OreDictUnificator.get(OrePrefixes.bolt, MaterialsUEVplus.MagMatter, 2),
                                    GT_OreDictUnificator.get(
                                            OrePrefixes.bolt,
                                            MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter,
                                            32),
                                    // Dyson Swarm Module Deployment Unit Base Casing
                                    getModItem(GalaxySpace.ID, "dysonswarmparts", 10 * 4, 2),
                                    // Dyson Swarm Energy Receiver Dish Block
                                    getModItem(GalaxySpace.ID, "dysonswarmparts", 10 * 4, 1),
                                    // Ultimate Time Anomaly.
                                    getModItem(GregTech.ID, "gt.blockmachines", 10 * 4, 11107),

                                    ItemList.Energy_Module.get(10),
                                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorUMV, 10 * 4),

                            },
                            new FluidStack[] {
                                    new FluidStack(
                                            FluidRegistry.getFluid("molten.mutatedlivingsolder"),
                                            (int) (2_880 * pow(2L, 9))),
                                    MaterialsUEVplus.Time.getMolten(1_440 * 10),
                                    MaterialsUEVplus.SpaceTime.getMolten(1_440),
                                    MaterialsBotania.Terrasteel.getMolten(144 * 4096) },
                            CustomItemList.TimeAccelerationFieldGeneratorTier10.get(1),
                            10 * 4_000 * 20,
                            (int) TierEU.RECIPE_UXV);

            TT_recipeAdder.addResearchableAssemblylineRecipe(
                    com.github.technus.tectech.thing.CustomItemList.StabilisationFieldGeneratorTier8.get(1),
                    10 * 48_000_000,
                    10 * 16_384,
                    (int) TierEU.RECIPE_MAX,
                    10 * 8,
                    new Object[] {
                            com.github.technus.tectech.thing.CustomItemList.TimeAccelerationFieldGeneratorTier8.get(1),
                            com.github.technus.tectech.thing.CustomItemList.SpacetimeCompressionFieldGeneratorTier8
                                    .get(1),
                            com.github.technus.tectech.thing.CustomItemList.EOH_Infinite_Energy_Casing.get(1),
                            // Dyson Swarm Module.
                            getModItem(GalaxySpace.ID, "item.DysonSwarmParts", 4 * 10, 0),

                            GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.SuperconductorUMVBase, 4 * 10),
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.SuperconductorUIVBase, 4 * 10),
                            GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.SuperconductorUEVBase, 4 * 10),
                            GT_OreDictUnificator
                                    .get(OrePrefixes.frameGt, Materials.Longasssuperconductornameforuhvwire, 4 * 10),

                            // Gravitation Engine
                            getModItem(GraviSuite.ID, "itemSimpleItem", 64, 3),
                            getModItem(GraviSuite.ID, "itemSimpleItem", 64, 3),
                            getModItem(GraviSuite.ID, "itemSimpleItem", 64, 3),
                            getModItem(GraviSuite.ID, "itemSimpleItem", 64, 3),

                            GT_OreDictUnificator.get(
                                    OrePrefixes.bolt,
                                    MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter,
                                    32),
                            getItemContainer("QuantumCircuit").get(2 * 10),
                            GT_OreDictUnificator.get(OrePrefixes.gearGt, MaterialsUEVplus.SpaceTime, 10),
                            GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, MaterialsUEVplus.MagMatter, 1)

                    },
                    new FluidStack[] {
                            new FluidStack(
                                    FluidRegistry.getFluid("molten.mutatedlivingsolder"),
                                    (int) (2_880 * pow(2L, 9))),
                            MaterialsUEVplus.Time.getMolten(1_440 * 10), MaterialsUEVplus.Space.getMolten(1_440 * 10),
                            MaterialsUEVplus.SpaceTime.getMolten(1_440) },
                    CustomItemList.StabilisationFieldGeneratorTier10.get(1),
                    10 * 4_000 * 20,
                    (int) TierEU.RECIPE_UXV);

            BotaniaAPI.registerElvenTradeRecipe(
                    CustomItemList.Mega_EoH.get(2),
                    com.github.technus.tectech.thing.CustomItemList.Machine_Multi_EyeOfHarmony.get(29));

            TT_recipeAdder.addResearchableAssemblylineRecipe(
                    ItemList.Hatch_CraftingInput_Bus_ME_ItemOnly.get(1L),
                    2000 * 60 * 8,
                    2000,
                    3000000,
                    2,
                    new ItemStack[] { ItemList.Hatch_Input_Bus_ME.get(1L), ItemList.Hatch_Input_Multi_2x2_UEV.get(1L),
                            // 16384k storage component
                            GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 8, 60),
                            // 16384k fluid storage component
                            GT_ModHandler.getModItem(AE2FluidCraft.ID, "fluid_part", 8, 7),
                            // ME Controller
                            GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockController", 1, WILDCARD),
                            // Dual Interface
                            GT_ModHandler.getModItem(AE2FluidCraft.ID, "part_fluid_interface", 1, WILDCARD),
                            // Pattern capacity card
                            GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 3, 54) },
                    new FluidStack[] { FluidRegistry.getFluidStack("molten.spacetime", 16 * INGOTS),
                            FluidRegistry.getFluidStack("molten.mutatedlivingsolder", 2000), },
                    ItemList.Hatch_CraftingInput_Bus_ME.get(1L),
                    30 * SECONDS,
                    (int) TierEU.RECIPE_UIV);
        }

        GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Hatch_Input_Bus_ME_Advanced.get(1L))
                .metadata(RESEARCH_TIME, 1 * HOURS).itemInputs(
                        ItemList.Hatch_Input_Bus_ME_Advanced.get(1L),
                        // 4096k Me Storage Component
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 59),
                        // ME Controller
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockController", 1, WILDCARD),
                        // Interface
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440),
                        // Pattern capacity card
                        GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 3, 54))
                .fluidInputs(new FluidStack(solderIndalloy, 1152))
                .itemOutputs(ItemList.Hatch_CraftingInput_Bus_ME_ItemOnly.get(1L)).eut(TierEU.RECIPE_LuV)
                .duration(30 * SECONDS).addTo(AssemblyLine);

        if (GraviSuite.isModLoaded()) {
            GT_Values.RA.stdBuilder()
                    .metadata(RESEARCH_ITEM, GT_ModHandler.getIC2Item("quantumBodyarmor", 1L, GT_Values.W))
                    .metadata(RESEARCH_TIME, 2 * HOURS)
                    .itemInputs(
                            GT_ModHandler.getIC2Item("quantumBodyarmor", 1L, WILDCARD),
                            ItemList.Transformer_ZPM_LuV.get(1L),
                            GT_ModHandler.getModItem(GraviSuite.ID, "ultimateLappack", 1, WILDCARD),
                            GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 6, 1),
                            GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 2, 2),
                            GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 2, 3),
                            new Object[] { OrePrefixes.circuit.get(Materials.Ultimate), 2L },
                            GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Duranium, 2),
                            ItemList.Energy_LapotronicOrb2.get(1L),
                            ItemList.Field_Generator_IV.get(2L),
                            ItemList.Electric_Motor_ZPM.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Duranium, 4))
                    .fluidInputs(new FluidStack(solderIndalloy, 2304), Materials.Tritanium.getMolten(1440L))
                    .itemOutputs(GT_ModHandler.getModItem(GraviSuite.ID, "graviChestPlate", 1, 26))
                    .eut(TierEU.RECIPE_LuV / 2).duration(1 * MINUTES + 15 * SECONDS).addTo(AssemblyLine);

            GT_Values.RA.stdBuilder().metadata(RESEARCH_ITEM, ItemList.Casing_Coil_Superconductor.get(1L))
                    .metadata(RESEARCH_TIME, 4 * HOURS)
                    .itemInputs(
                            ItemList.Casing_Fusion_Coil.get(16L),
                            GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUV, 16L),
                            new Object[] { OrePrefixes.circuit.get(Materials.SuperconductorUHV), 16L },
                            ItemList.Sensor_UV.get(16L),
                            ItemList.Emitter_UV.get(16L),
                            ItemList.Field_Generator_UV.get(8L),
                            ItemList.Circuit_Wafer_QPIC.get(64L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                            GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L))
                    .fluidInputs(
                            Materials.Longasssuperconductornameforuvwire.getMolten(2880L),
                            Materials.Americium.getPlasma(2880L),
                            Materials.Enderium.getMolten(5760L))
                    .itemOutputs(GT_ModHandler.getModItem(GraviSuite.ID, "relocator", 1, 26)).eut(TierEU.RECIPE_UV)
                    .duration(50 * MINUTES).addTo(AssemblyLine);

        }

    }
}
