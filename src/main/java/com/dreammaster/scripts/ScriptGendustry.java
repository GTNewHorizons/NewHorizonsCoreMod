package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.ExtraBees;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.Gendustry;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.block.BlockList;
import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.Circuits;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.util.GTModHandler;
import gregtech.common.items.CombType;
import gregtech.loaders.misc.GTBees;

public class ScriptGendustry implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Gendustry";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ExtraBees.ID, Forestry.ID, Gendustry.ID, IndustrialCraft2.ID, IronTanks.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(Gendustry.ID, "Imprinter", 1, 0),
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0),
                "gearOsmium",
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0),
                getModItem(Gendustry.ID, "BeeReceptacle", 1, 0),
                getModItem(Forestry.ID, "hardenedMachine", 1, 0),
                getModItem(Gendustry.ID, "BeeReceptacle", 1, 0),
                "gearOsmium",
                getModItem(Gendustry.ID, "PowerModule", 1, 0),
                "gearOsmium");
        addShapedRecipe(
                getModItem(Gendustry.ID, "Sampler", 1, 0),
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0),
                getModItem(Gendustry.ID, "BeeReceptacle", 1, 0),
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0),
                NHItemList.EngravedDiamondCrystalChip.get(),
                getModItem(Forestry.ID, "hardenedMachine", 1, 0),
                NHItemList.EngravedDiamondCrystalChip.get(),
                "gearOsmium",
                getModItem(Gendustry.ID, "PowerModule", 1, 0),
                "gearOsmium");
        addShapedRecipe(
                getModItem(Gendustry.ID, "Liquifier", 1, 0),
                "gearOsmium",
                "blockHopper",
                "gearOsmium",
                ItemList.Electric_Piston_LuV.get(1L),
                getModItem(Forestry.ID, "hardenedMachine", 1, 0),
                ItemList.Electric_Piston_LuV.get(1L),
                "gearOsmium",
                getModItem(Gendustry.ID, "PowerModule", 1, 0),
                "gearOsmium");
        addShapedRecipe(
                getModItem(Gendustry.ID, "Extractor", 1, 0),
                ItemList.Electric_Piston_LuV.get(1L),
                getModItem(Gendustry.ID, "BeeReceptacle", 1, 0),
                ItemList.Electric_Piston_LuV.get(1L),
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0),
                getModItem(Forestry.ID, "hardenedMachine", 1, 0),
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0),
                "gearOsmium",
                getModItem(Gendustry.ID, "PowerModule", 1, 0),
                "gearOsmium");
        addShapedRecipe(
                getModItem(Gendustry.ID, "Transposer", 1, 0),
                ItemList.Robot_Arm_LuV.get(1L),
                "gearOsmium",
                ItemList.Robot_Arm_LuV.get(1L),
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0),
                getModItem(Forestry.ID, "hardenedMachine", 1, 0),
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0),
                "gearOsmium",
                getModItem(Gendustry.ID, "PowerModule", 1, 0),
                "gearOsmium");
        addShapedRecipe(
                getModItem(Gendustry.ID, "Replicator", 1, 0),
                ItemList.Robot_Arm_LuV.get(1L),
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0),
                ItemList.Robot_Arm_LuV.get(1L),
                getModItem(Gendustry.ID, "PowerModule", 1, 0),
                getModItem(Forestry.ID, "hardenedMachine", 1, 0),
                getModItem(Gendustry.ID, "PowerModule", 1, 0),
                "gearOsmium",
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0),
                "gearOsmium");
        addShapedRecipe(
                getModItem(Gendustry.ID, "BeeReceptacle", 1, 0),
                "screwHSSS",
                GTBees.combs.getStackForType(CombType.PLUTONIUM),
                "screwHSSS",
                NHItemList.IridiumAlloyItemCasing.get(),
                BlockList.OsmiumBars.get(),
                NHItemList.IridiumAlloyItemCasing.get(),
                "screwHSSS",
                "craftingToolScrewdriver",
                "screwHSSS");
        addShapedRecipe(
                getModItem(Gendustry.ID, "PowerModule", 1, 0),
                "cableGt01VanadiumGallium",
                GTBees.combs.getStackForType(CombType.NAQUADAH),
                "cableGt01VanadiumGallium",
                NHItemList.IridiumAlloyItemCasing.get(),
                "circuitMaster",
                NHItemList.IridiumAlloyItemCasing.get(),
                "gearGtSmallOsmium",
                ItemList.Electric_Motor_LuV.get(1L),
                "gearGtSmallOsmium");
        addShapedRecipe(
                getModItem(Gendustry.ID, "IndustrialGrafter", 1, 100),
                "screwStainlessSteel",
                getModItem(Forestry.ID, "grafter", 1, 0),
                "screwStainlessSteel",
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_LV.get(1L),
                "gearGtSmallStainlessSteel",
                "plateStainlessSteel",
                "batteryBasic",
                "plateStainlessSteel");
        addShapedRecipe(
                getModItem(Gendustry.ID, "IndustrialScoop", 1, 100),
                "screwStainlessSteel",
                "craftingToolScoop",
                "screwStainlessSteel",
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_LV.get(1L),
                "gearGtSmallStainlessSteel",
                "plateStainlessSteel",
                "batteryBasic",
                "plateStainlessSteel");
        addShapedRecipe(
                getModItem(Gendustry.ID, "ClimateModule", 1, 0),
                GTBees.combs.getStackForType(CombType.IRIDIUM),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0),
                GTBees.combs.getStackForType(CombType.URANIUM),
                "stickPalladium",
                "rotorOsmium",
                "stickPalladium",
                NHItemList.IridiumAlloyItemCasing.get(),
                ItemList.Electric_Motor_LuV.get(1L),
                NHItemList.IridiumAlloyItemCasing.get());

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(Gendustry.ID, "MutagenProducer", 1, 0),
                "---------",
                "---------",
                "--abcba--",
                "--defed--",
                "--ghihg--",
                "--djfjd--",
                "--abcba--",
                "---------",
                "---------",
                'a',
                getModItem(Gendustry.ID, "MutagenTank", 1, 0),
                'b',
                "plateBlackPlutonium",
                'c',
                getModItem(Gendustry.ID, "PowerModule", 1, 0),
                'd',
                ItemList.Electric_Pump_ZPM.get(1L),
                'e',
                ItemList.Robot_Arm_ZPM.get(1L),
                'f',
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0),
                'g',
                getModItem(Gendustry.ID, "BeeReceptacle", 1, 0),
                'h',
                "gearOsmium",
                'i',
                getModItem(Forestry.ID, "hardenedMachine", 1, 0),
                'j',
                ItemList.Electric_Motor_ZPM.get(1L));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(Gendustry.ID, "Mutatron", 1, 0),
                "---------",
                "---------",
                "--abcba--",
                "--defed--",
                "--ghihg--",
                "--defed--",
                "--abjba--",
                "---------",
                "---------",
                'a',
                ItemList.Casing_HeatProof.get(1L),
                'b',
                getModItem(ExtraBees.ID, "alveary", 1, 5),
                'c',
                getModItem(Forestry.ID, "factory", 1, 2),
                'd',
                GTBees.combs.getStackForType(CombType.NAQUADAH),
                'e',
                ItemList.Robot_Arm_LuV.get(1L),
                'f',
                getModItem(Gendustry.ID, "MutagenTank", 1, 0),
                'g',
                MaterialLibAPI.getStack(Materials.Ruthenium, Shapes.plate, (int) (1)),
                'h',
                getModItem(ExtraBees.ID, "alveary", 1, 6),
                'i',
                getModItem(Forestry.ID, "hardenedMachine", 1, 0),
                'j',
                getModItem(Forestry.ID, "factory", 1, 5));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(Gendustry.ID, "MutatronAdv", 1, 0),
                "---------",
                "-aaaaaaa-",
                "-abcccda-",
                "-aefgfea-",
                "-ahijika-",
                "-aefgfea-",
                "-alcccma-",
                "-aaaaaaa-",
                "---------",
                'a',
                MaterialLibAPI.getStack(Materials.Europium, Shapes.plateQuintuple, (int) (1L)),
                'b',
                getModItem(Gendustry.ID, "Replicator", 1, 0),
                'c',
                MaterialLibAPI.getStack(Materials.Naquadria, Shapes.plateQuintuple, (int) (1L)),
                'd',
                getModItem(Gendustry.ID, "Liquifier", 1, 0),
                'e',
                getModItem(Gendustry.ID, "Labware", 1, 0),
                'f',
                getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0),
                'g',
                ItemList.Robot_Arm_ZPM.get(1L),
                'h',
                getModItem(Gendustry.ID, "Sampler", 1, 0),
                'i',
                GTBees.combs.getStackForType(CombType.NEUTRONIUM),
                'j',
                getModItem(Gendustry.ID, "Mutatron", 1, 0),
                'k',
                getModItem(Gendustry.ID, "Imprinter", 1, 0),
                'l',
                getModItem(Gendustry.ID, "Transposer", 1, 0),
                'm',
                getModItem(Gendustry.ID, "Extractor", 1, 0));

        GTModHandler.addSmeltingRecipe(
                getModItem(Gendustry.ID, "GeneSample", 1, 0),
                getModItem(Gendustry.ID, "GeneSampleBlank", 1, 0));
        GTModHandler.addSmeltingRecipe(
                getModItem(Gendustry.ID, "GeneTemplate", 1, 0),
                getModItem(Gendustry.ID, "GeneTemplate", 1, 0));
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.ring, (int) (1L)))
                .itemOutputs(getModItem(Gendustry.ID, "Labware", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 576)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Tin, Shapes.plate, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.RedAlloy, Shapes.dust, (int) (1L)))
                .itemOutputs(getModItem(Gendustry.ID, "GeneSampleBlank", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 144)).duration(20).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Gendustry.ID, "GeneSampleBlank", 4, 0),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, (int) (1L)))
                .itemOutputs(getModItem(Gendustry.ID, "GeneTemplate", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronTanks.ID, "diamondTank", 1, 0),
                        MaterialLibAPI.getStack(Materials.Palladium, Shapes.plateDouble, (int) (1L)))
                .itemOutputs(getModItem(Gendustry.ID, "MutagenTank", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plutonium", 576)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.GeneticCircuit.get(1), Circuits.IV.get(1))
                .itemOutputs(getModItem(Gendustry.ID, "GeneticsProcessor", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.EnvironmentalCircuit.get(1), Circuits.IV.get(1))
                .itemOutputs(getModItem(Gendustry.ID, "EnvProcessor", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("liquiddna", 500)).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Palladium, Shapes.plate, (int) (1L)),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 3))
                .itemOutputs(getModItem(Gendustry.ID, "EjectCover", 1, 0)).duration(10 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Palladium, Shapes.plate, (int) (1L)),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 6))
                .itemOutputs(getModItem(Gendustry.ID, "ImportCover", 1, 0)).duration(10 * SECONDS).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Palladium, Shapes.plate, (int) (1L)),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 5))
                .itemOutputs(getModItem(Gendustry.ID, "ErrorSensorCover", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

    }
}
