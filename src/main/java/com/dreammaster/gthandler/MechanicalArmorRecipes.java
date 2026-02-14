package com.dreammaster.gthandler;

import static com.dreammaster.scripts.IScriptLoader.missing;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.BUCKETS;
import static gregtech.api.util.GTRecipeBuilder.INGOTS;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.WILDCARD;
import static gregtech.api.util.GTRecipeConstants.PRECISE_ASSEMBLER_CASING_TIER;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.item.NHItemList;

import bartworks.system.material.WerkstoffLoader;
import goodgenerator.api.recipe.GoodGeneratorRecipeMaps;
import goodgenerator.items.GGMaterial;
import goodgenerator.util.ItemRefer;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.core.material.MaterialsAlloy;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class MechanicalArmorRecipes {

    public static void run() {
        // Exoskeletons
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.MoldHelmet.get(0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 5),
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 5, 0, missing))
                .itemOutputs(ItemList.Mechanical_Helmet.get(1)).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.MoldChestplate.get(0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 8),
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 8, 0, missing))
                .itemOutputs(ItemList.Mechanical_Chestplate.get(1)).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.MoldLeggings.get(0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 7),
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 7, 0, missing))
                .itemOutputs(ItemList.Mechanical_Leggings.get(1)).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.MoldBoots.get(0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4),
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 4, 0, missing))
                .itemOutputs(ItemList.Mechanical_Boots.get(1)).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(formingPressRecipes);

        // Power cores

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.IC2_EnergyCrystal.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.EnergeticAlloy, 64),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1))
                .fluidInputs(Materials.RedstoneAlloy.getMolten(INGOTS * 10)).itemOutputs(ItemList.Armor_Core_T1.get(1))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Energy_LapotronicOrb.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.HSSG, 64),
                        ItemList.Field_Generator_EV.get(2))
                .fluidInputs(Materials.VanadiumGallium.getMolten(INGOTS * 10))
                .itemOutputs(ItemList.Armor_Core_T2.get(1)).duration(10 * SECONDS).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Energy_Module.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.SuperconductorLuV, 16),
                        ItemList.Field_Generator_ZPM.get(2))
                .fluidInputs(Materials.Tritanium.getMolten(INGOTS * 10)).itemOutputs(ItemList.Armor_Core_T3.get(1))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.ZPM2.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Infinity, 16),
                        ItemList.Field_Generator_UHV.get(2),
                        GTOreDictUnificator.get(OrePrefixes.nanite, Materials.Neutronium, 1))
                .fluidInputs(Materials.Silver.getPlasma(INGOTS * 10)).itemOutputs(ItemList.Armor_Core_T4.get(1))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);

        // T1 Frames

        GTValues.RA.stdBuilder().circuit(10)
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
                        ItemList.Electric_Piston_HV.get(1),
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 8, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 16))
                .fluidInputs(Materials.StainlessSteel.getMolten(INGOTS * 2))
                .itemOutputs(ItemList.Armor_Frame_Light.get(1)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().circuit(10)
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
                        ItemList.Electric_Piston_HV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.DarkSteel, 8),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 16))
                .fluidInputs(Materials.StainlessSteel.getMolten(INGOTS * 2))
                .itemOutputs(ItemList.Armor_Frame_Medium.get(1)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().circuit(10)
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
                        ItemList.Electric_Piston_HV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.DarkSteel, 8),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.EnergeticAlloy, 16))
                .fluidInputs(Materials.StainlessSteel.getMolten(INGOTS * 2))
                .itemOutputs(ItemList.Armor_Frame_Heavy.get(1)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        // T2 Frames

        GTValues.RA.stdBuilder().circuit(10)
                .itemInputs(
                        ItemList.Armor_Frame_Light.get(1),
                        ItemList.Electric_Piston_IV.get(1),
                        WerkstoffLoader.Rhodium.get(OrePrefixes.plate, 8),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Polybenzimidazole, 32))
                .fluidInputs(Materials.TungstenSteel.getMolten(INGOTS * 4))
                .itemOutputs(ItemList.Armor_Frame_Nimble.get(1)).duration(10 * SECONDS).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().circuit(10)
                .itemInputs(
                        ItemList.Armor_Frame_Medium.get(1),
                        ItemList.Electric_Piston_IV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 8),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Polybenzimidazole, 32))
                .fluidInputs(Materials.TungstenSteel.getMolten(INGOTS * 4))
                .itemOutputs(ItemList.Armor_Frame_Adaptive.get(1)).duration(10 * SECONDS).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().circuit(10)
                .itemInputs(
                        ItemList.Armor_Frame_Heavy.get(1),
                        ItemList.Electric_Piston_IV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 8),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.TungstenCarbide, 32))
                .fluidInputs(Materials.TungstenSteel.getMolten(INGOTS * 4))
                .itemOutputs(ItemList.Armor_Frame_Tough.get(1)).duration(10 * SECONDS).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        // T3 Frames

        GTValues.RA.stdBuilder().circuit(10)
                .itemInputs(
                        ItemList.Armor_Frame_Nimble.get(1),
                        ItemList.Electric_Piston_ZPM.get(1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.PrismaticNaquadah, 8),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Americium, 64))
                .fluidInputs(Materials.Osmiridium.getMolten(INGOTS * 8))
                .itemOutputs(ItemList.Armor_Frame_Lightning.get(1)).duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().circuit(10)
                .itemInputs(
                        ItemList.Armor_Frame_Adaptive.get(1),
                        ItemList.Electric_Piston_ZPM.get(1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 8),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Americium, 64))
                .fluidInputs(Materials.Osmiridium.getMolten(INGOTS * 8))
                .itemOutputs(ItemList.Armor_Frame_Morphic.get(1)).duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().circuit(10)
                .itemInputs(
                        ItemList.Armor_Frame_Tough.get(1),
                        ItemList.Electric_Piston_ZPM.get(1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 8),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Bedrockium, 64))
                .fluidInputs(Materials.Osmiridium.getMolten(INGOTS * 8))
                .itemOutputs(ItemList.Armor_Frame_Bulwark.get(1)).duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .addTo(assemblerRecipes);

        // Modification Table

        if (Forestry.isModLoaded()) {
            GTModHandler.addCraftingRecipe(
                    ItemList.ModificationTable.get(1L),
                    new Object[] { "PCP", "RWR", "PHP", 'P', OrePrefixes.plate.get(Materials.EnergeticAlloy), 'C',
                            ItemList.Cover_Screen, 'R', ItemList.Robot_Arm_HV, 'W',
                            getModItem(Forestry.ID, "factory2", 1, 2, missing), 'H', ItemList.Hull_HV });
        }

        // Augment Bases

        GTValues.RA.stdBuilder().circuit(10)
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4),
                        GTOreDictUnificator.get(OrePrefixes.cableGt02, Materials.Electrum, 2),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1))
                .fluidInputs(Materials.Gold.getMolten(INGOTS * 4)).itemOutputs(ItemList.Armor_Chip_T1.get(1))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().circuit(10)
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NiobiumTitanium, 8),
                        ItemList.Electric_Motor_IV.get(2),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 2))
                .fluidInputs(Materials.Tungsten.getMolten(INGOTS * 8)).itemOutputs(ItemList.Armor_Chip_T2.get(1))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Naquadria, 2),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 8),
                        ItemRefer.HiC_T2.get(8),
                        ItemList.Naquarite_Universal_Insulator_Foil.get(4))
                .fluidInputs(
                        Materials.NaquadahEnriched.getMolten(INGOTS * 4),
                        Materials.Sunnarium.getMolten(INGOTS * 4),
                        WerkstoffLoader.Krypton.getFluidOrGas(BUCKETS * 2))
                .itemOutputs(ItemList.Armor_Chip_T3.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, 1).addTo(GoodGeneratorRecipeMaps.preciseAssemblerRecipes);

        // T1 Augments

        GTModHandler.addCraftingRecipe(
                ItemList.Augment_Hazmat.get(4),
                new Object[] { "HPC", "PRP", "LPB", 'H',
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, 0, missing), 'C',
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatChestplate", 1, 0, missing), 'L',
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatLeggings", 1, 0, missing), 'B',
                        getModItem(IndustrialCraft2.ID, "itemArmorRubBoots", 1, 0, missing), 'P',
                        OrePrefixes.plate.get(Materials.Lead), 'R', ItemList.Armor_Chip_T1.get(1) });

        if (GalacticraftMars.isModLoaded() && GalacticraftCore.isModLoaded() && GalaxySpace.isModLoaded()) {
            GTModHandler.addCraftingRecipe(
                    ItemList.Augment_SpaceSuit.get(4),
                    new Object[] { "CDC", "URU", "LOL", 'C', OrePrefixes.circuit.get(Materials.EV), 'D',
                            GTModHandler.getModItem(GalacticraftMars.ID, "item.null", 2L, 5), 'U',
                            getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 2), 'L',
                            getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 3), 'O',
                            getModItem(GalacticraftCore.ID, "item.oxygenConcentrator", 1, 0), 'R',
                            ItemList.Armor_Chip_T1.get(1) });
        }

        if (Thaumcraft.isModLoaded()) {
            ThaumcraftApi.addArcaneCraftingRecipe(
                    "GOGGLES",
                    ItemList.Augment_GogglesOfRevealing.get(1),
                    new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("terra"), 30)
                            .add(Aspect.getAspect("ignis"), 30).add(Aspect.getAspect("aqua"), 30)
                            .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                    "gGg",
                    "PRP",
                    "gPg",
                    'g',
                    GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.StainlessSteel, 1),
                    'P',
                    GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1),
                    'G',
                    getModItem(Thaumcraft.ID, "ItemGoggles", 1, 0),
                    'R',
                    ItemList.Armor_Chip_T1.get(1));
        }

        GTModHandler.addCraftingRecipe(
                ItemList.Augment_WaterBreathing.get(1),
                new Object[] { "TST", "PRP", "FCF", 'S',
                        getModItem(IndustrialCraft2.ID, "itemArmorHazmatHelmet", 1, 0, missing), 'P',
                        ItemList.Electric_Pump_HV.get(1), 'F', new ItemStack(Items.fish, 1, 3), 'C',
                        OrePrefixes.circuit.get(Materials.HV), 'T', OrePrefixes.pipeSmall.get(Materials.StainlessSteel),
                        'R', ItemList.Armor_Chip_T1.get(1) });

        if (Forestry.isModLoaded()) {
            GTModHandler.addCraftingRecipe(
                    ItemList.Augment_Apiarist.get(1),
                    new Object[] { "HDC", "MRM", "LDB", 'H', getModItem(Forestry.ID, "apiaristHelmet", 1, 0, missing),
                            'C', getModItem(Forestry.ID, "apiaristChest", 1, 0, missing), 'L',
                            getModItem(Forestry.ID, "apiaristLegs", 1, 0, missing), 'B',
                            getModItem(Forestry.ID, "apiaristBoots", 1, 0, missing), 'D',
                            getModItem(Forestry.ID, "honeyDrop", 1, 0, missing), 'M', ItemList.Electric_Motor_HV.get(1),
                            'R', ItemList.Armor_Chip_T1.get(1) });
        }

        GTModHandler.addCraftingRecipe(
                ItemList.Augment_NightVision.get(1),
                new Object[] { "PGP", "ORO", "PCP", 'G',
                        getModItem(IndustrialCraft2.ID, "itemNightvisionGoggles", 1, WILDCARD, missing), 'P',
                        OrePrefixes.plate.get(Materials.StainlessSteel), 'O',
                        OrePrefixes.stick.get(Materials.StainlessSteel), 'C', OrePrefixes.circuit.get(Materials.HV),
                        'R', ItemList.Armor_Chip_T1.get(1) });

        if (GraviSuite.isModLoaded()) {
            GTModHandler.addCraftingRecipe(
                    ItemList.Augment_Jetpack.get(1),
                    new Object[] { "PJP", "ORO", "PCP", 'J',
                            getModItem(GraviSuite.ID, "advJetpack", 1, WILDCARD, missing), 'P',
                            OrePrefixes.plate.get(Materials.TungstenSteel), 'O',
                            OrePrefixes.stick.get(Materials.TungstenSteel), 'C', OrePrefixes.circuit.get(Materials.EV),
                            'R', ItemList.Armor_Chip_T1.get(1) });
        }

        GTModHandler.addCraftingRecipe(
                ItemList.Augment_SwimSpeed.get(1),
                new Object[] { "PBP", "CRC", "FLF", 'P', ItemList.Electric_Pump_HV.get(1), 'B',
                        getModItem(BiomesOPlenty.ID, "flippers", 1, 0, missing), 'F', "listAllfishraw", 'L',
                        new ItemStack(Item.getItemFromBlock(Blocks.waterlily), 1), 'C',
                        OrePrefixes.circuit.get(Materials.HV), 'R', ItemList.Armor_Chip_T1.get(1) });

        // T2 Augments

        GTModHandler.addCraftingRecipe(
                ItemList.Augment_OmniMovement.get(1),
                new Object[] { "TCT", "CRC", "TCT", 'T', OrePrefixes.plate.get(Materials.TungstenSteel), 'C',
                        ItemList.Conveyor_Module_HV.get(1), 'R', ItemList.Armor_Chip_T2.get(1) });

        if (PamsHarvestCraft.isModLoaded()) {
            GTModHandler.addCraftingRecipe(
                    ItemList.Augment_JumpBoost.get(1),
                    new Object[] { "LCL", "BRB", "PSP", 'L',
                            getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), 'P',
                            ItemList.Electric_Piston_IV.get(1), 'B',
                            getModItem(TinkerConstruct.ID, "slime.pad", 1, 0, missing), 'C',
                            OrePrefixes.circuit.get(Materials.IV), 'S', OrePrefixes.screw.get(Materials.TungstenSteel),
                            'R', ItemList.Armor_Chip_T2.get(1) });
        }

        GTModHandler.addCraftingRecipe(
                ItemList.Augment_SpeedBoost.get(1),
                new Object[] { "VDV", "MRM", "CDC", 'V', OrePrefixes.plate.get(Materials.VibrantAlloy), 'D',
                        OrePrefixes.plate.get(Materials.DarkSteel), 'M', ItemList.Electric_Motor_IV.get(1), 'C',
                        OrePrefixes.circuit.get(Materials.IV), 'R', ItemList.Armor_Chip_T2.get(1) });

        GTValues.RA.stdBuilder().circuit(10)
                .itemInputs(
                        ItemList.Armor_Chip_T2.get(1),
                        GTOreDictUnificator.get(OrePrefixes.rotor, Materials.HSSS, 4),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 4),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorIV, 8),
                        ItemList.Field_Generator_IV.get(1),
                        ItemList.Sensor_IV.get(1))
                .fluidInputs(MaterialsAlloy.STELLITE.getFluidStack(INGOTS * 8))
                .itemOutputs(ItemList.Augment_Jetpack_PerfectHover.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().circuit(10)
                .itemInputs(
                        ItemList.Armor_Chip_T2.get(1),
                        NHItemList.MicaInsulatorFoil.get(64),
                        GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.ZPM, 4))
                .fluidInputs(FluidRegistry.getFluidStack("pyrotheum", 4000))
                .itemOutputs(ItemList.Augment_FireImmunity.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().circuit(10)
                .itemInputs(
                        ItemList.Armor_Chip_T2.get(1),
                        GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.TungstenCarbide, 4),
                        ItemList.Sensor_IV.get(1))
                .fluidInputs(Materials.HSSS.getMolten(INGOTS * 4))
                .itemOutputs(ItemList.Augment_KnockbackResistance.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().circuit(10)
                .itemInputs(
                        ItemList.Armor_Chip_T2.get(1),
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.HSSG, 4),
                        ItemList.Electric_Piston_IV.get(2))
                .fluidInputs(Materials.HSSS.getMolten(INGOTS * 4)).itemOutputs(ItemList.Augment_FallProtection.get(1))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().circuit(10)
                .itemInputs(
                        ItemList.Armor_Chip_T2.get(1),
                        GGMaterial.marM200.get(OrePrefixes.spring, 4),
                        ItemList.Electric_Piston_IV.get(4),
                        ItemList.Sensor_IV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ZPM, 1))
                .fluidInputs(Materials.Palladium.getMolten(INGOTS * 8)).itemOutputs(ItemList.Augment_StepAssist.get(1))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_IV).addTo(assemblerRecipes);

        // T3 Augments

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Armor_Chip_T3.get(1),
                        ItemRefer.HiC_T2.get(4),
                        getModItem(GraviSuite.ID, "itemSimpleItem", 4, 3), // Gravitation Engine
                        ItemList.Field_Generator_LuV.get(2))
                .fluidInputs(Materials.Neutronium.getMolten(INGOTS * 20), Materials.Tritanium.getMolten(INGOTS * 10))
                .itemOutputs(ItemList.Augment_CreativeFlight.get(1)).duration(60 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, 2).addTo(GoodGeneratorRecipeMaps.preciseAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Armor_Chip_T3.get(1),
                        ItemRefer.HiC_T2.get(4),
                        ItemList.Sensor_ZPM.get(4), // Gravitation Engine
                        ItemList.Field_Generator_LuV.get(2))
                .fluidInputs(Materials.Neutronium.getMolten(INGOTS * 20), Materials.Tritanium.getMolten(INGOTS * 10))
                .itemOutputs(ItemList.Augment_InertiaCanceling.get(1)).duration(60 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, 2).addTo(GoodGeneratorRecipeMaps.preciseAssemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Armor_Chip_T3.get(1),
                        ItemRefer.HiC_T3.get(4),
                        ItemList.Emitter_ZPM.get(4),
                        ItemList.Field_Generator_ZPM.get(2))
                .fluidInputs(
                        GGMaterial.artheriumSn.getMolten(INGOTS * 20),
                        Materials.Neutronium.getMolten(INGOTS * 20),
                        Materials.CosmicNeutronium.getMolten(INGOTS * 20))
                .itemOutputs(ItemList.Augment_ForceField.get(1)).duration(60 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, 3).addTo(GoodGeneratorRecipeMaps.preciseAssemblerRecipes);
    }
}
