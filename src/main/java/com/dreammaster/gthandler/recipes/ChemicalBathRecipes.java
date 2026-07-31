package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.LogisticsPipes;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.OpenModularTurrets;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.recipe.RecipeMaps.chemicalBathRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeBuilder.WILDCARD;
import static net.minecraftforge.fluids.FluidRegistry.getFluidStack;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.GregTechAPI;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2FluidShapes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.material.MU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;

public class ChemicalBathRecipes implements Runnable {

    @Override
    public void run() {

        ItemStack missing = new ItemStack(Blocks.fire);

        // tanned leather
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.leather, 2, 0))
                .itemOutputs(getModItem(Backpack.ID, "tannedLeather", 1, 0))
                .fluidInputs(MU.materialOf(Materials2Materials.PhosphoricAcidGT5U).getFluid(250)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.ArtificialLeather.get(2))
                .itemOutputs(getModItem(Backpack.ID, "tannedLeather", 1, 0))
                .fluidInputs(MU.materialOf(Materials2Materials.PhosphoricAcidGT5U).getFluid(250)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);

        // Chlorine cleaning of pistons
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.sticky_piston, 1, 0))
                .itemOutputs(new ItemStack(Blocks.piston, 1, 0))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Chlorine,
                                Materials2FluidShapes.fluidGas,
                                (int) (10L)))
                .duration(1 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);

        // Coated Circuit Board
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.plate, (int) (1)))
                .itemOutputs(ItemList.Circuit_Board_Basic.get(1)).duration(100 * TICKS).eut(8)
                .fluidInputs(FluidRegistry.getFluidStack("glue", 144)).addTo(chemicalBathRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.plate, (int) (1)))
                .itemOutputs(ItemList.Circuit_Board_Basic.get(1)).duration(100 * TICKS).eut(8)
                .fluidInputs(
                        MaterialLibAPI
                                .getFluidStack(Materials2Materials.Glue, Materials2FluidShapes.fluidLiquid, (int) (72)))
                .addTo(chemicalBathRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.plate, (int) (1)))
                .itemOutputs(ItemList.Circuit_Board_Basic.get(2)).duration(100 * TICKS).eut(8)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Plastic,
                                Materials2FluidShapes.fluidMolten,
                                (int) (36)))
                .addTo(chemicalBathRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.plate, (int) (1)))
                .itemOutputs(ItemList.Circuit_Board_Basic.get(2)).duration(100 * TICKS).eut(8)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Polytetrafluoroethylene,
                                Materials2FluidShapes.fluidMolten,
                                (int) (18)))
                .addTo(chemicalBathRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.plate, (int) (1)))
                .itemOutputs(ItemList.Circuit_Board_Basic.get(3)).duration(100 * TICKS).eut(8)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Epoxid,
                                Materials2FluidShapes.fluidMolten,
                                (int) (18)))
                .addTo(chemicalBathRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Wood, Materials2Shapes.plate, (int) (1)))
                .itemOutputs(ItemList.Circuit_Board_Basic.get(4)).duration(100 * TICKS).eut(8)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Polybenzimidazole,
                                Materials2FluidShapes.fluidMolten,
                                (int) (9)))
                .addTo(chemicalBathRecipes);

        // Cooling Hot Netherrack Bricks
        GTValues.RA.stdBuilder().itemInputs(NHItemList.HotNetherrackBrick.get())
                .itemOutputs(NHItemList.InfernalBrick.get())
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250))
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
        // Cooling Hot Kanthal MV
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Kanthal, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Kanthal, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250))
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(chemicalBathRecipes);
        // Cooling Hot Tantalum MV
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Tantalum, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Tantalum, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250))
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_MV).addTo(chemicalBathRecipes);
        // Cooling Hot Silicon MV
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Silicon, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Silicon, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250))
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(chemicalBathRecipes);
        // Cooling Hot SiliconSG MV
        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.SiliconSolarGrade, Materials2Shapes.ingotHot, (int) (1L)))
                .itemOutputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconSolarGrade, Materials2Shapes.ingot, (int) (1L)))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250))
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(chemicalBathRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MysteriousCrystalGemExquisite.get())
                .itemOutputs(NHItemList.MysteriousCrystalLens.get())
                .fluidInputs(MU.materialOf(Materials2Materials.UUMatter).getFluid(144)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(chemicalBathRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Parts_GlassFiber.get(1L)).itemOutputs(
                MaterialLibAPI.getStack(Materials2Materials.EpoxidFiberReinforced, Materials2Shapes.plate, (int) (1)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Epoxid,
                                Materials2FluidShapes.fluidMolten,
                                (int) (144L)))
                .duration(12 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getIC2Item("carbonFiber", 1)).itemOutputs(
                MaterialLibAPI.getStack(Materials2Materials.EpoxidFiberReinforced, Materials2Shapes.plate, (int) (1)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Epoxid,
                                Materials2FluidShapes.fluidMolten,
                                (int) (144L)))
                .duration(12 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(chemicalBathRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterBlack", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblack", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterRed", 1, 0)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyered", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterGreen", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterBrown", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyebrown", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterBlue", 1, 0)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterPurple", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepurple", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterCyan", 1, 0)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyecyan", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterLightGrey", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightgray", 144)).duration(10 * SECONDS)
                .eut(2).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterDarkGrey", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegray", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterPink", 1, 0)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepink", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterLime", 1, 0)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelime", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterYellow", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeyellow", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterCloud", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightblue", 144)).duration(10 * SECONDS)
                .eut(2).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterMagenta", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyemagenta", 144)).duration(10 * SECONDS)
                .eut(2).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterOrange", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterWhite", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyewhite", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);

        // Laser Resistant Plate
        GTValues.RA.stdBuilder().itemInputs(ItemList.Block_ReinforcedConcrete.get(1L))
                .itemOutputs(new ItemStack(GregTechAPI.sLaserRender))
                .fluidInputs(FluidRegistry.getFluidStack("molten.hastelloyx", 1152)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(chemicalBathRecipes);

        // Neutronium Casing
        GTValues.RA.stdBuilder().itemInputs(ItemList.Casing_AdvancedRadiationProof.get(1))
                .itemOutputs(ItemList.Neutronium_Casing.get(1))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Neutronium,
                                Materials2FluidShapes.fluidMolten,
                                (int) (8 * 144)))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_UV).addTo(chemicalBathRecipes);

        // Superplasticizer-treated high strength concrete
        Fluid naphthalene = FluidRegistry.getFluid("fluid.naphthalene");
        GTValues.RA.stdBuilder().itemInputs(ItemList.Block_ReinforcedConcrete.get(1L))
                .fluidInputs(new FluidStack(naphthalene, 1000))
                .itemOutputs(ItemList.BlockIndustrialStrengthConcrete.get(1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(chemicalBathRecipes);

        if (BiomesOPlenty.isModLoaded() && HardcoreEnderExpansion.isModLoaded() && Thaumcraft.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 0))
                    .itemOutputs(
                            getModItem(Minecraft.ID, "bone", 8, 0),
                            getModItem(Minecraft.ID, "bone", 6, 0),
                            getModItem(Minecraft.ID, "bone", 4, 0))
                    .outputChances(10000, 7500, 5000).fluidInputs(getFluidStack("hell_blood", 1000))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 1))
                    .itemOutputs(
                            getModItem(Minecraft.ID, "coal_block", 2, 0),
                            getModItem(Minecraft.ID, "coal_block", 1, 0),
                            getModItem(Minecraft.ID, "coal_block", 1, 0))
                    .outputChances(10000, 7500, 5000).fluidInputs(getFluidStack("hell_blood", 1000))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 4))
                    .itemOutputs(
                            getModItem(Minecraft.ID, "gunpowder", 4, 0),
                            getModItem(Minecraft.ID, "gunpowder", 3, 0),
                            getModItem(Minecraft.ID, "gunpowder", 2, 0))
                    .outputChances(10000, 7500, 5000).fluidInputs(getFluidStack("hell_blood", 1000))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "enderman_head", 1, 0))
                    .itemOutputs(
                            getModItem(Minecraft.ID, "ender_pearl", 1, 0),
                            getModItem(Minecraft.ID, "ender_pearl", 1, 0),
                            getModItem(Minecraft.ID, "ender_pearl", 1, 0))
                    .outputChances(10000, 5000, 2500).fluidInputs(getFluidStack("hell_blood", 1000))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 3))
                    .itemOutputs(getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0)).outputChances(1000)
                    .fluidInputs(getFluidStack("hell_blood", 1000)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 2))
                    .itemOutputs(
                            getModItem(Minecraft.ID, "rotten_flesh", 4, 0),
                            getModItem(Minecraft.ID, "leather", 2, 0),
                            MaterialLibAPI.getStack(Materials2Materials.MeatRaw, Materials2Shapes.dust, (int) (4)))
                    .outputChances(10000, 3000, 5000).fluidInputs(getFluidStack("hell_blood", 1000))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
        }

        if (Forestry.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemBiochaff", 1, 0))
                    .itemOutputs(
                            getModItem(Forestry.ID, "mulch", 8, 0),
                            getModItem(Forestry.ID, "mulch", 4, 0),
                            getModItem(Forestry.ID, "mulch", 4, 0))
                    .outputChances(10000, 3300, 2000)
                    .fluidInputs(MU.materialOf(Materials2Materials.Water).getFluid(750L)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
        }

        if (EnderIO.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1, 4))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"), 72))
                    .duration(25 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1, 1))
                    .itemOutputs(getModItem(EnderIO.ID, "blockFusedQuartz", 1, 5))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"), 72))
                    .duration(25 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemConduitFacade", 1, 0))
                    .itemOutputs(getModItem(EnderIO.ID, "itemConduitFacade", 1, 1)).outputChances(10000)
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Obsidian,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (576L)))
                    .duration(10 * SECONDS).eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemMaterial", 1, 2))
                    .itemOutputs(
                            getModItem(EnderIO.ID, "itemMaterial", 2, 1),
                            getModItem(EnderIO.ID, "itemMaterial", 2, 1),
                            getModItem(EnderIO.ID, "itemMaterial", 1, 1))
                    .outputChances(10000, 9000, 5000)
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Rubber,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (144L)))
                    .duration(10 * SECONDS).eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemMaterial", 1, 2))
                    .itemOutputs(
                            getModItem(EnderIO.ID, "itemMaterial", 2, 1),
                            getModItem(EnderIO.ID, "itemMaterial", 2, 1),
                            getModItem(EnderIO.ID, "itemMaterial", 2, 1))
                    .outputChances(10000, 10000, 10000)
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Silicone,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (144L)))
                    .duration(10 * SECONDS).eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemMaterial", 1, 2))
                    .itemOutputs(
                            getModItem(EnderIO.ID, "itemMaterial", 2, 1),
                            getModItem(EnderIO.ID, "itemMaterial", 2, 1),
                            getModItem(EnderIO.ID, "itemMaterial", 2, 1))
                    .outputChances(10000, 10000, 10000)
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.StyreneButadieneRubber,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (144L)))
                    .duration(10 * SECONDS).eut(2).addTo(chemicalBathRecipes);
        }

        if (PamsHarvestCraft.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0))
                    .itemOutputs(NHItemList.ArtificialLeather.get())
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.PolyvinylChloride,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (72L)))
                    .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(chemicalBathRecipes);
        }
        if (LogisticsPipes.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, WILDCARD))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0))
                    .fluidInputs(FluidRegistry.getFluidStack("chlorine", 1000)).duration(1 * MINUTES + 20 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 1))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyeblack", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 2))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyered", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 3))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyegreen", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 4))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyebrown", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 5))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyeblue", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 6))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyepurple", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 7))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyecyan", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 8))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyelightgray", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 9))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyegray", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 10))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyepink", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 11))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyelime", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 12))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyeyellow", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 13))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyelightblue", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 14))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyemagenta", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 15))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyeorange", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 16))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyewhite", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
        }
        if (OpenModularTurrets.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(
                    GTOreDictUnificator.get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.WoodSealed), 1L))
                    .itemOutputs(getModItem(OpenModularTurrets.ID, "hardWallTierOne", 1, 0))
                    .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV / 2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator
                                    .get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.ElectricalSteel), 1L))
                    .itemOutputs(getModItem(OpenModularTurrets.ID, "hardWallTierTwo", 1, 0))
                    .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(
                    GTOreDictUnificator.get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.DarkSteel), 1L))
                    .itemOutputs(getModItem(OpenModularTurrets.ID, "hardWallTierThree", 1, 0))
                    .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_MV / 2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(
                    GTOreDictUnificator.get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.EnergeticAlloy), 1L))
                    .itemOutputs(getModItem(OpenModularTurrets.ID, "hardWallTierFour", 1, 0))
                    .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(
                    GTOreDictUnificator.get(OrePrefixes.frameGt, MU.materialOf(Materials2Materials.VibrantAlloy), 1L))
                    .itemOutputs(getModItem(OpenModularTurrets.ID, "hardWallTierFive", 1, 0))
                    .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(chemicalBathRecipes);
        }
        if (StevesCarts2.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 34))
                    .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 37))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Redstone,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (144L)))
                    .duration(10 * SECONDS).eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35))
                    .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38))
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Redstone,
                                    Materials2FluidShapes.fluidMolten,
                                    (int) (576L)))
                    .duration(15 * SECONDS).eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 24))
                    .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 864)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 24))
                    .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 864)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
        }
    }
}
