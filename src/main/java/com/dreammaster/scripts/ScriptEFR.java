package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AE2Stuff;
import static gregtech.api.enums.Mods.AdventureBackpack;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BloodMagic;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.ElectroMagicTools;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.EtFuturumRequiem;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.MagicBees;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.PamsHarvestTheNether;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.TaintedMagic;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TinkersGregworks;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.enums.Mods.WitchingGadgets;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.autoclaveRecipes;
import static gregtech.api.recipe.RecipeMaps.centrifugeRecipes;
import static gregtech.api.recipe.RecipeMaps.compressorRecipes;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.recipe.RecipeMaps.extruderRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidCannerRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidExtractionRecipes;
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static gregtech.api.recipe.RecipeMaps.hammerRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.recipe.RecipeMaps.multiblockChemicalReactorRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.chemicalDehydratorRecipes;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.chisel.ChiselHelper;
import com.dreammaster.item.NHItemList;
import com.dreammaster.recipes.CustomItem;
import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptEFR implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Et Futurum Requiem";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(EtFuturumRequiem.ID, ExtraUtilities.ID, Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {
        long bits = GTModHandler.RecipeBits.NOT_REMOVABLE | GTModHandler.RecipeBits.REVERSIBLE
                | GTModHandler.RecipeBits.BUFFERED;
        GTModHandler.addCraftingRecipe(
                GTModHandler.getModItem(EtFuturumRequiem.ID, "observer", 1L),
                bits,
                new Object[] { "AEA", "BCD", "AAA", 'A', "cobblestone", 'B', "dustRedstone", 'C',
                        GTModHandler.getModItem(ExtraUtilities.ID, "budoff", 1, 0), 'D',
                        GTModHandler.getModItem(Minecraft.ID, "comparator", 1, 0), 'E', "gearGtSmallAnyIron" });

        GTModHandler.addCraftingRecipe(
                GTModHandler.getModItem(EtFuturumRequiem.ID, "cherry_trapdoor", 1L),
                bits,
                new Object[] { "ABA", "BCB", "ABA", 'A',
                        GTModHandler.getModItem(EtFuturumRequiem.ID, "wood_slab", 1L, 3), 'B', "stickWood", 'C',
                        "itemFlint" });

        GTModHandler.addCraftingRecipe(
                GTModHandler.getModItem(EtFuturumRequiem.ID, "cherry_trapdoor", 2L),
                bits,
                new Object[] { "ABA", "BCB", "ABA", 'A',
                        GTModHandler.getModItem(EtFuturumRequiem.ID, "wood_slab", 1L, 3), 'B', "stickWood", 'C',
                        "screwIron" });

        GTModHandler.addCraftingRecipe(
                GTModHandler.getModItem(EtFuturumRequiem.ID, "cherry_trapdoor", 3L),
                bits,
                new Object[] { "ABA", "BCB", "ABA", 'A',
                        GTModHandler.getModItem(EtFuturumRequiem.ID, "wood_slab", 1L, 3), 'B', "stickWood", 'C',
                        "screwSteel" });
        for (int i = 0; i < 16; i++) {
            addShapelessRecipe(
                    GTModHandler.getModItem(EtFuturumRequiem.ID, "banner", 1L, i),
                    new CustomItem.NBTItem(getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 8))
                            .setNBT("{color:" + i + "b}"));
            addShapelessRecipe(
                    createItemStack(Thaumcraft.ID, "blockWoodenDevice", 1, 8, "{color:" + i + "b}", missing),
                    GTModHandler.getModItem(EtFuturumRequiem.ID, "banner", 1L, i));
        }

        // Slabs

        final String[] slabInputs = { "red_sandstone:0", "red_sandstone:2", "purpur_block:0", "stone:0",
                "mossy_cobblestone:0", "stonebrick:1", "sandstone:2", "smooth_red_sandstone:0", "smooth_quartz:0",
                "red_netherbrick:0", "end_bricks:0", "cobbled_deepslate:0", "polished_deepslate:0",
                "deepslate_bricks:0", "deepslate_bricks:2", "tuff:0", "tuff:1", "tuff:2", "copper_block:4",
                "copper_block:5", "copper_block:6", "copper_block:7", "copper_block:12", "copper_block:13",
                "copper_block:14", "copper_block:15", "blackstone:0", "blackstone:1", "blackstone:2", "wood_planks:3" };
        final String[] slabOutputs = { "red_sandstone_slab:0", "red_sandstone_slab:1", "purpur_slab:0", "stone_slab:0",
                "stone_slab:1", "stone_slab:2", "stone_slab:3", "smooth_red_sandstone_slab:0", "smooth_quartz_slab:0",
                "red_netherbrick_slab:0", "end_brick_slab:0", "deepslate_slab:0", "deepslate_slab:1",
                "deepslate_brick_slab:0", "deepslate_brick_slab:1", "tuff_slab:0", "tuff_slab:1", "tuff_slab:2",
                "cut_copper_slab:0", "cut_copper_slab:1", "cut_copper_slab:2", "cut_copper_slab:3", "cut_copper_slab:4",
                "cut_copper_slab:5", "cut_copper_slab:6", "cut_copper_slab:7", "blackstone_slab:0", "blackstone_slab:1",
                "blackstone_slab:2", "wood_slab:3" };
        for (int i = 0; i < slabInputs.length; i++) {
            String[] inParts = slabInputs[i].split(":");
            String[] outParts = slabOutputs[i].split(":");

            String inName = inParts[0];
            int inMeta = Integer.parseInt(inParts[1]);

            String outName = outParts[0];
            int outMeta = Integer.parseInt(outParts[1]);

            if (inName.equals("stone") || inName.equals("mossy_cobblestone")
                    || inName.equals("stonebrick")
                    || inName.equals("sandstone")) {
                GTModHandler.addCraftingRecipe(
                        GTModHandler.getModItem(EtFuturumRequiem.ID, outName, 1, outMeta),
                        bits,
                        new Object[] { "BA ", "   ", "   ", 'A',
                                GTModHandler.getModItem(Minecraft.ID, inName, 1L, inMeta), 'B', "craftingToolSaw" });
                GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, inName, 1, inMeta, missing))
                        .itemOutputs(getModItem(EtFuturumRequiem.ID, outName, 2, outMeta, missing))
                        .fluidInputs(new FluidStack(FluidRegistry.getFluid("lubricant"), 1)).duration(25 * TICKS).eut(4)
                        .addTo(cutterRecipes);
                GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, inName, 1, inMeta, missing))
                        .itemOutputs(getModItem(EtFuturumRequiem.ID, outName, 2, outMeta, missing))
                        .fluidInputs(new FluidStack(FluidRegistry.getFluid("water"), 4)).duration(50 * TICKS).eut(4)
                        .addTo(cutterRecipes);
                GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, inName, 1, inMeta, missing))
                        .itemOutputs(getModItem(EtFuturumRequiem.ID, outName, 2, outMeta, missing))
                        .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2distilledwater"), 3))
                        .duration(50 * TICKS).eut(4).addTo(cutterRecipes);
            } else {
                if (inName.equals("wood_planks")) {
                    GTModHandler.addCraftingRecipe(
                            GTModHandler.getModItem(EtFuturumRequiem.ID, outName, 2, outMeta),
                            bits,
                            new Object[] { "BA ", "   ", "   ", 'A',
                                    GTModHandler.getModItem(EtFuturumRequiem.ID, inName, 1L, inMeta), 'B',
                                    "craftingToolSaw" });
                } else {
                    GTModHandler.addCraftingRecipe(
                            GTModHandler.getModItem(EtFuturumRequiem.ID, outName, 1, outMeta),
                            bits,
                            new Object[] { "BA ", "   ", "   ", 'A',
                                    GTModHandler.getModItem(EtFuturumRequiem.ID, inName, 1L, inMeta), 'B',
                                    "craftingToolSaw" });
                }
                GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, inName, 1, inMeta, missing))
                        .itemOutputs(getModItem(EtFuturumRequiem.ID, outName, 2, outMeta, missing))
                        .fluidInputs(new FluidStack(FluidRegistry.getFluid("lubricant"), 1)).duration(25 * TICKS).eut(4)
                        .addTo(cutterRecipes);
                GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, inName, 1, inMeta, missing))
                        .itemOutputs(getModItem(EtFuturumRequiem.ID, outName, 2, outMeta, missing))
                        .fluidInputs(new FluidStack(FluidRegistry.getFluid("water"), 4)).duration(50 * TICKS).eut(4)
                        .addTo(cutterRecipes);
                GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, inName, 1, inMeta, missing))
                        .itemOutputs(getModItem(EtFuturumRequiem.ID, outName, 2, outMeta, missing))
                        .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2distilledwater"), 3))
                        .duration(50 * TICKS).eut(4).addTo(cutterRecipes);
            }
        }

        // Pressure Plates

        final ItemStack[] pressurePlateInputs = { ItemList.Plank_Spruce.get(2), ItemList.Plank_Birch.get(2),
                ItemList.Plank_Jungle.get(2), ItemList.Plank_Acacia.get(2), ItemList.Plank_DarkOak.get(2),
                ItemList.Plank_Cherry_EFR.get(2) };
        final String[] pressurePlateOutputs = { "pressure_plate_spruce", "pressure_plate_birch",
                "pressure_plate_jungle", "pressure_plate_acacia", "pressure_plate_dark_oak", "cherry_pressure_plate" };
        for (int i = 0; i < pressurePlateInputs.length; i++) {

            ItemStack inParts = pressurePlateInputs[i];
            String outParts = pressurePlateOutputs[i];

            GTModHandler.addCraftingRecipe(
                    getModItem(EtFuturumRequiem.ID, outParts, 2L, 0, missing),
                    bits,
                    new Object[] { "ABA", "CDC", "AEA", 'A', "screwWood", 'B', "craftingToolHardHammer", 'C', inParts,
                            'D', "springAnyIron", 'E', "craftingToolScrewdriver" });
            GTValues.RA.stdBuilder()
                    .itemInputs(inParts, GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                    .itemOutputs(getModItem(EtFuturumRequiem.ID, outParts, 2)).duration(5 * SECONDS).eut(8)
                    .addTo(assemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(inParts, GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1L))
                    .itemOutputs(getModItem(EtFuturumRequiem.ID, outParts, 2)).duration(5 * SECONDS).eut(8)
                    .addTo(assemblerRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(inParts, GTOreDictUnificator.get(OrePrefixes.spring, Materials.PigIron, 1L))
                    .itemOutputs(getModItem(EtFuturumRequiem.ID, outParts, 2)).duration(5 * SECONDS).eut(8)
                    .addTo(assemblerRecipes);
        }

        GTModHandler.addCraftingRecipe(
                getModItem(EtFuturumRequiem.ID, "polished_blackstone_pressure_plate", 2L, 0, missing),
                bits,
                new Object[] { "ABA", "CDC", "AEA", 'A', "screwIron", 'B', "craftingToolHardHammer", 'C',
                        getModItem(EtFuturumRequiem.ID, "blackstone_slab", 1L, 1, missing), 'D', "springAnyIron", 'E',
                        "craftingToolScrewdriver" });
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "blackstone_slab", 2, 1),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "polished_blackstone_pressure_plate", 2))
                .duration(5 * SECONDS).eut(8).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "blackstone_slab", 2, 1),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "polished_blackstone_pressure_plate", 2))
                .duration(5 * SECONDS).eut(8).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "blackstone_slab", 2, 1),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.PigIron, 1L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "polished_blackstone_pressure_plate", 2))
                .duration(5 * SECONDS).eut(8).addTo(assemblerRecipes);

        // Buttons

        final String[] buttonInputs = { "pressure_plate_spruce", "pressure_plate_birch", "pressure_plate_jungle",
                "pressure_plate_acacia", "pressure_plate_dark_oak", "cherry_pressure_plate",
                "polished_blackstone_pressure_plate" };
        final String[] buttonOutputs = { "button_spruce", "button_birch", "button_jungle", "button_acacia",
                "button_dark_oak", "cherry_button", "polished_blackstone_button" };
        for (int i = 0; i < buttonInputs.length; i++) {

            String inParts = buttonInputs[i];
            String outParts = buttonOutputs[i];

            GTModHandler.addCraftingRecipe(
                    GTModHandler.getModItem(EtFuturumRequiem.ID, outParts, 2),
                    bits,
                    new Object[] { "BA ", "   ", "   ", 'A', GTModHandler.getModItem(EtFuturumRequiem.ID, inParts, 1L),
                            'B', "craftingToolSaw" });
            GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, inParts, 1))
                    .itemOutputs(getModItem(EtFuturumRequiem.ID, outParts, 2))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("lubricant"), 1)).duration(25 * TICKS).eut(4)
                    .addTo(cutterRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, inParts, 1))
                    .itemOutputs(getModItem(EtFuturumRequiem.ID, outParts, 2))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("water"), 4)).duration(50 * TICKS).eut(4)
                    .addTo(cutterRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, inParts, 1))
                    .itemOutputs(getModItem(EtFuturumRequiem.ID, outParts, 2))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2distilledwater"), 3)).duration(50 * TICKS)
                    .eut(4).addTo(cutterRecipes);
        }

        // Barrels

        GTModHandler.addCraftingRecipe(
                getModItem(EtFuturumRequiem.ID, "barrel", 1, 0, missing),
                bits,
                new Object[] { "hPs", "PCP", " P ", 'P', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                        'C', "chestWood" });
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 2L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "barrel", 1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        // Barrel Upgrades
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 2L),
                        GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "barrel_upgrade", 1, 0, missing)).duration(15 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 2L),
                        GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "barrel_upgrade", 1, 1, missing)).duration(15 * SECONDS)
                .eut(8).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 2L),
                        GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "barrel_upgrade", 1, 2, missing)).duration(25 * SECONDS)
                .eut(64).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 2L),
                        GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "barrel_upgrade", 1, 3, missing)).duration(30 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 2L),
                        GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "barrel_upgrade", 1, 4, missing)).duration(25 * SECONDS)
                .eut(64).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                        getModItem(IndustrialCraft2.ID, "itemDensePlates", 2, 7, missing),
                        GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "barrel_upgrade", 1, 5, missing)).duration(30 * SECONDS)
                .eut(256).addTo(assemblerRecipes);
        // GTValues.RA.stdBuilder()
        // .itemInputs(
        // GTOreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L),
        // GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Netherite, 1L),
        // GTUtility.getIntegratedCircuit(3))
        // .itemOutputs(getModItem(EtFuturumRequiem.ID, "barrel_upgrade", 1, 6, missing))
        // .duration(5 * SECONDS).eut(64)
        // .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 2L),
                        GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "barrel_upgrade", 1, 7, missing)).duration(20 * SECONDS)
                .eut(480).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 2L),
                        GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "barrel_upgrade", 1, 8, missing))
                .duration(7 * SECONDS + 10 * TICKS).eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Silver, 2L),
                        GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "barrel_upgrade", 1, 9, missing)).duration(20 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Silver, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 2L),
                        GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "barrel_upgrade", 1, 10, missing)).duration(10 * SECONDS)
                .eut(64).addTo(assemblerRecipes);

        // Iron Barrels
        addShapedRecipe(
                getModItem(EtFuturumRequiem.ID, "copper_barrel", 1, 0, missing),
                "screwCopper",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                "screwCopper",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                getModItem(EtFuturumRequiem.ID, "barrel", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                "craftingToolScrewdriver");
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "barrel", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "copper_barrel", 1, 0, missing))
                .duration(7 * SECONDS + 10 * TICKS).eut(8).addTo(assemblerRecipes);

        addShapedRecipe(
                getModItem(EtFuturumRequiem.ID, "iron_barrel", 1, 0, missing),
                "screwIron",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                "screwIron",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                getModItem(EtFuturumRequiem.ID, "barrel", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                "craftingToolScrewdriver");

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "barrel", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "iron_barrel", 1, 0, missing))
                .duration(7 * SECONDS + 10 * TICKS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "copper_barrel", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "iron_barrel", 1, 0, missing))
                .duration(7 * SECONDS + 10 * TICKS).eut(120).addTo(assemblerRecipes);

        addShapedRecipe(
                getModItem(EtFuturumRequiem.ID, "steel_barrel", 1, 0, missing),
                "screwSteel",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L),
                "screwSteel",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L),
                getModItem(EtFuturumRequiem.ID, "barrel", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L),
                "craftingToolScrewdriver");
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "barrel", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 3L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "steel_barrel", 1, 0, missing)).duration(10 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "copper_barrel", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "steel_barrel", 1, 0, missing)).duration(20 * SECONDS)
                .eut(30).addTo(assemblerRecipes);

        addShapedRecipe(
                getModItem(EtFuturumRequiem.ID, "silver_barrel", 1, 0, missing),
                "screwSilver",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Silver, 1L),
                "screwSilver",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Silver, 1L),
                getModItem(EtFuturumRequiem.ID, "barrel", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Silver, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Silver, 1L),
                "craftingToolScrewdriver");
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "barrel", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Silver, 3L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "silver_barrel", 1, 0, missing)).duration(10 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "copper_barrel", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Silver, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "silver_barrel", 1, 0, missing)).duration(20 * SECONDS)
                .eut(30).addTo(assemblerRecipes);

        addShapedRecipe(
                getModItem(EtFuturumRequiem.ID, "gold_barrel", 1, 0, missing),
                "screwGold",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                "screwGold",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                getModItem(EtFuturumRequiem.ID, "barrel", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                "craftingToolScrewdriver");
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "barrel", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 3L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "gold_barrel", 1, 0, missing))
                .duration(12 * SECONDS + 10 * TICKS).eut(64).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "iron_barrel", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "gold_barrel", 1, 0, missing)).duration(25 * SECONDS)
                .eut(64).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "silver_barrel", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "gold_barrel", 1, 0, missing)).duration(25 * SECONDS)
                .eut(64).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "steel_barrel", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "gold_barrel", 1, 0, missing)).duration(25 * SECONDS)
                .eut(64).addTo(assemblerRecipes);

        addShapedRecipe(
                getModItem(EtFuturumRequiem.ID, "diamond_barrel", 1, 0, missing),
                "screwDiamond",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "screwDiamond",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                getModItem(EtFuturumRequiem.ID, "barrel", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolScrewdriver");
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "barrel", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 4L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "diamond_barrel", 1, 0, missing)).duration(15 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "gold_barrel", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 2L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "diamond_barrel", 1, 0, missing)).duration(30 * SECONDS)
                .eut(120).addTo(assemblerRecipes);

        addShapedRecipe(
                getModItem(EtFuturumRequiem.ID, "obsidian_barrel", 1, 0, missing),
                "screwDiamond",
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7, missing),
                "screwDiamond",
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7, missing),
                getModItem(EtFuturumRequiem.ID, "diamond_barrel", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7, missing),
                "craftingToolHardHammer",
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7, missing),
                "craftingToolScrewdriver");
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "diamond_barrel", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemDensePlates", 2, 7, missing),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "obsidian_barrel", 1, 0, missing)).duration(30 * SECONDS)
                .eut(256).addTo(assemblerRecipes);

        addShapedRecipe(
                getModItem(EtFuturumRequiem.ID, "darksteel_barrel", 1, 0, missing),
                "screwDarkSteel",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                "screwDarkSteel",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                getModItem(EtFuturumRequiem.ID, "diamond_barrel", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                "craftingToolScrewdriver");
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "diamond_barrel", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 2L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "darksteel_barrel", 1, 0, missing)).duration(20 * SECONDS)
                .eut(480).addTo(assemblerRecipes);

        // TODO change to oredictunificator after GT5u#4074 is merged
        // addShapedRecipe(
        // getModItem(EtFuturumRequiem.ID, "netherite_barrel", 1, 0, missing),
        // "screwNetherite",
        // "plateDoubleNetherite",
        // "screwNetherite",
        // "plateDoubleNetherite",
        // getModItem(EtFuturumRequiem.ID, "diamond_barrel", 1, 0, missing),
        // "plateDoubleNetherite",
        // "craftingToolHardHammer",
        // "plateDoubleNetherite",
        // "craftingToolScrewdriver");
        // GTValues.RA.stdBuilder()
        // .itemInputs(
        // getModItem(EtFuturumRequiem.ID, "diamond_barrel", 1, 0, missing),
        // GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Netherite, 2L),
        // GTUtility.getIntegratedCircuit(2))
        // .itemOutputs(getModItem(EtFuturumRequiem.ID, "netherite_barrel", 1, 0, missing))
        // .duration(20 * SECONDS).eut(480)
        // .addTo(assemblerRecipes);

        GTModHandler.addCraftingRecipe(
                getModItem(EtFuturumRequiem.ID, "lantern", 1, 0, missing),
                bits,
                new Object[] { "IGI", "PCP", "III", 'I', "plateIron", 'G', "dustGlowstone", 'P', "paneGlassColorless",
                        'C', getModItem(PamsHarvestCraft.ID, "pamcandleDeco1", 1, 0, missing) });

        GTModHandler.addSmeltingRecipe(
                getModItem(Minecraft.ID, "stone", 1, 0, missing),
                getModItem(EtFuturumRequiem.ID, "smooth_stone", 1, 0, missing));

        GTModHandler.addSmeltingRecipe(
                new ItemStack(Blocks.stained_hardened_clay, 1, 15),
                getModItem(EtFuturumRequiem.ID, "black_glazed_terracotta", 1, 0, missing));
        GTModHandler.addSmeltingRecipe(
                new ItemStack(Blocks.stained_hardened_clay, 1, 14),
                getModItem(EtFuturumRequiem.ID, "red_glazed_terracotta", 1, 0, missing));
        GTModHandler.addSmeltingRecipe(
                new ItemStack(Blocks.stained_hardened_clay, 1, 13),
                getModItem(EtFuturumRequiem.ID, "green_glazed_terracotta", 1, 0, missing));
        GTModHandler.addSmeltingRecipe(
                new ItemStack(Blocks.stained_hardened_clay, 1, 12),
                getModItem(EtFuturumRequiem.ID, "brown_glazed_terracotta", 1, 0, missing));
        GTModHandler.addSmeltingRecipe(
                new ItemStack(Blocks.stained_hardened_clay, 1, 3),
                getModItem(EtFuturumRequiem.ID, "light_blue_glazed_terracotta", 1, 0, missing));
        GTModHandler.addSmeltingRecipe(
                new ItemStack(Blocks.stained_hardened_clay, 1, 4),
                getModItem(EtFuturumRequiem.ID, "yellow_glazed_terracotta", 1, 0, missing));
        GTModHandler.addSmeltingRecipe(
                new ItemStack(Blocks.stained_hardened_clay, 1, 5),
                getModItem(EtFuturumRequiem.ID, "lime_glazed_terracotta", 1, 0, missing));
        GTModHandler.addSmeltingRecipe(
                new ItemStack(Blocks.stained_hardened_clay, 1, 6),
                getModItem(EtFuturumRequiem.ID, "pink_glazed_terracotta", 1, 0, missing));
        GTModHandler.addSmeltingRecipe(
                new ItemStack(Blocks.stained_hardened_clay, 1, 0),
                getModItem(EtFuturumRequiem.ID, "white_glazed_terracotta", 1, 0, missing));
        GTModHandler.addSmeltingRecipe(
                new ItemStack(Blocks.stained_hardened_clay, 1, 7),
                getModItem(EtFuturumRequiem.ID, "gray_glazed_terracotta", 1, 0, missing));
        GTModHandler.addSmeltingRecipe(
                new ItemStack(Blocks.stained_hardened_clay, 1, 8),
                getModItem(EtFuturumRequiem.ID, "light_gray_glazed_terracotta", 1, 0, missing));
        GTModHandler.addSmeltingRecipe(
                new ItemStack(Blocks.stained_hardened_clay, 1, 9),
                getModItem(EtFuturumRequiem.ID, "cyan_glazed_terracotta", 1, 0, missing));
        GTModHandler.addSmeltingRecipe(
                new ItemStack(Blocks.stained_hardened_clay, 1, 10),
                getModItem(EtFuturumRequiem.ID, "purple_glazed_terracotta", 1, 0, missing));
        GTModHandler.addSmeltingRecipe(
                new ItemStack(Blocks.stained_hardened_clay, 1, 11),
                getModItem(EtFuturumRequiem.ID, "blue_glazed_terracotta", 1, 0, missing));
        GTModHandler.addSmeltingRecipe(
                new ItemStack(Blocks.stained_hardened_clay, 1, 2),
                getModItem(EtFuturumRequiem.ID, "magenta_glazed_terracotta", 1, 0, missing));
        GTModHandler.addSmeltingRecipe(
                new ItemStack(Blocks.stained_hardened_clay, 1, 1),
                getModItem(EtFuturumRequiem.ID, "orange_glazed_terracotta", 1, 0, missing));

        GTModHandler.addSmeltingRecipe(
                getModItem(Minecraft.ID, "quartz_block", 1, 0, missing),
                getModItem(EtFuturumRequiem.ID, "smooth_quartz", 1, 0, missing));

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.log, 1, 0), ItemList.Shape_Extruder_Block.get(0L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "log_stripped", 1, 0, missing)).duration(6 * SECONDS)
                .eut(80).addTo(extruderRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.log, 1, 2), ItemList.Shape_Extruder_Block.get(0L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "log_stripped", 1, 2, missing)).duration(6 * SECONDS)
                .eut(80).addTo(extruderRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.log2, 1, 0), ItemList.Shape_Extruder_Block.get(0L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "log2_stripped", 1, 0, missing)).duration(6 * SECONDS)
                .eut(80).addTo(extruderRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.log2, 1, 1), ItemList.Shape_Extruder_Block.get(0L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "log2_stripped", 1, 1, missing)).duration(6 * SECONDS)
                .eut(80).addTo(extruderRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.log, 1, 1), ItemList.Shape_Extruder_Block.get(0L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "log_stripped", 1, 1, missing)).duration(6 * SECONDS)
                .eut(80).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "cherry_log", 1, 0, missing),
                        ItemList.Shape_Extruder_Block.get(0L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "cherry_log", 1, 2, missing)).duration(6 * SECONDS).eut(80)
                .addTo(extruderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 8L),
                        GTOreDictUnificator.get(OrePrefixes.round, Materials.Steel, 8L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "chain", 16, 0, missing)).duration(20 * SECONDS).eut(28)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherStar, 2L),
                        new ItemStack(Blocks.red_flower, 1, 0),
                        getModItem(MagicBees.ID, "miscResources", 1, 4, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "wither_rose", 1, 0, missing)).duration(20 * SECONDS)
                .eut(28).addTo(formingPressRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TaintedMagic.ID, "BlockWarpwoodLeaves", 4, 0, missing),
                        getModItem(EtFuturumRequiem.ID, "nether_wart", 4, 0, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "nether_wart", 2, 1, missing)).duration(20 * SECONDS)
                .eut(28).addTo(formingPressRecipes);

        GTModHandler.addCraftingRecipe(
                getModItem(EtFuturumRequiem.ID, "blast_furnace", 1, 0, missing),
                bits,
                new Object[] { "PPP", "PFP", "SSS", 'S', getModItem(EtFuturumRequiem.ID, "smooth_stone", 1, 0, missing),
                        'F', getModItem(Minecraft.ID, "furnace", 1, 0, missing), 'P', "plateIron" });

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 5L),
                        getModItem(EtFuturumRequiem.ID, "smooth_stone", 3, 0, missing),
                        new ItemStack(Blocks.furnace, 1))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "blast_furnace", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "amethyst_block", 64, 0, missing),
                        getModItem(AE2Stuff.ID, "Grower", 6, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 6, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 6, 7, missing),
                        getModItem(EtFuturumRequiem.ID, "chorus_flower", 4, 0, missing),
                        getModItem(BloodMagic.ID, "enhancedFillingAgent", 1, 0, missing),
                        getModItem(Botania.ID, "rune", 1, 9, missing),
                        getModItem(Witchery.ID, "ingredient", 1, 10, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 32, 6, missing))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("molten.crystallinepinkslime"), 4320))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "budding_amethyst", 6, 0, missing)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GTModHandler.addCraftingRecipe(
                getModItem(Minecraft.ID, "leather", 1, 0, missing),
                bits,
                new Object[] { "SSS", "HHH", "SSS", 'S', getModItem(Minecraft.ID, "string", 1, 0, missing), 'H',
                        getModItem(EtFuturumRequiem.ID, "rabbit_hide", 1, 0, missing) });
        GTModHandler.addCraftingRecipe(
                getModItem(EtFuturumRequiem.ID, "soul_lantern", 1, 0, missing),
                bits,
                new Object[] { "IGI", "PCP", "III", 'I', "plateIron", 'G', "dustInfusedWater", 'P',
                        "paneGlassColorless", 'C', getModItem(EtFuturumRequiem.ID, "soul_torch", 1, 0, missing) });

        GTModHandler.addCraftingRecipe(
                getModItem(EtFuturumRequiem.ID, "target", 1, 0, missing),
                bits,
                new Object[] { "WTR", "CHD", "RTW", 'W', "blockWoolWhite", 'R', "blockWoolRed", 'T', "dustRedstone",
                        'C', GTModHandler.getModItem(Minecraft.ID, "comparator", 1, 0), 'H',
                        GTModHandler.getModItem(Minecraft.ID, "hay_block", 1, 0), 'D',
                        GTModHandler.getModItem(ExtraUtilities.ID, "budoff", 1, 0) });

        GTModHandler.addCraftingRecipe(
                getModItem(EtFuturumRequiem.ID, "smoker", 1, 0, missing),
                bits,
                new Object[] { "PhP", "PFP", "SCS", 'P', "plateIron", 'F',
                        getModItem(Minecraft.ID, "furnace", 1, 0, missing), 'S',
                        getModItem(EtFuturumRequiem.ID, "smooth_stone", 1, 0, missing), 'C',
                        getModItem(AdventureBackpack.ID, "blockCampFire", 1, 0, missing) });

        GTModHandler.addCraftingRecipe(
                getModItem(EtFuturumRequiem.ID, "end_crystal", 1, 0, missing),
                bits,
                new Object[] { "VGV", "VSV", "VQV", 'V',
                        getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzLamp", 1, 0, missing), 'G',
                        getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing), 'S',
                        getModItem(DraconicEvolution.ID, "wyvernCore", 1, 0, missing), 'Q',
                        ItemList.QuantumEye.get(1), });

        GTModHandler.addCraftingRecipe(
                getModItem(EtFuturumRequiem.ID, "smithing_table", 1, 0, missing),
                bits,
                new Object[] { "TT ", "GG ", "GG ", 'T',
                        GTModHandler.getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 5), 'G',
                        GTModHandler.getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6), });

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.magma_cream, 4))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("lava"), 1000))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "magma", 1, 0, missing)).duration(10 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "dye", 9, 15, missing))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "bone", 1, 0, missing)).duration(8 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, "magma", 1, 0, missing))
                .itemOutputs(new ItemStack(Items.magma_cream, 4))
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("lava"), 1000)).duration(10 * SECONDS).eut(48)
                .addTo(fluidExtractionRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "hardIce", 4, 0, missing))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "blue_ice", 1, 0, missing)).duration(8 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.nether_wart, 9))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "nether_wart", 1L)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(new ItemStack(Blocks.gravel, 4), getModItem(TinkerConstruct.ID, "CraftedSoil", 4L, 1))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "old_gravel", 8L)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.grass, 64), new ItemStack(Items.wooden_shovel, 1))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "grass_path", 64L)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.getIntegratedCircuit(21),
                        new ItemStack(Blocks.stone_slab, 1),
                        getModItem(Forestry.ID, "oakStick", 5L),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Iron, 3L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 2L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "wooden_armorstand", 1L)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "old_gravel", 4L),
                        getModItem(BiomesOPlenty.ID, "driedDirt", 4L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("steam"), 400))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "coarse_dirt", 8, 0, missing)).duration(8 * SECONDS).eut(2)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "slime.gel", 4L, 1),
                        getModItem(TinkerConstruct.ID, "GlueBlock", 4L, 0))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("steam"), 4000))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "slime", 16, 0, missing)).duration(40 * SECONDS).eut(2)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(HardcoreEnderExpansion.ID, "laboratory_obsidian", 16L),
                        getModItem(HardcoreEnderExpansion.ID, "spectral_tear", 1L, 0))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2distilledwater"), 4000))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "crying_obsidian", 16L)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        ChiselHelper.addVariationFromStack("EFRHoneyBlock", getModItem(BiomesOPlenty.ID, "honeyBlock", 1L));
        ChiselHelper.addVariationFromStack("EFRHoneyBlock", getModItem(EtFuturumRequiem.ID, "honey_block", 1L));

        ChiselHelper.addVariationFromStack(
                "EFRAmethystBlock",
                GTOreDictUnificator.get(OrePrefixes.block, Materials.Amethyst, 1L));
        ChiselHelper.addVariationFromStack("EFRAmethystBlock", getModItem(EtFuturumRequiem.ID, "amethyst_block", 1L));

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.glass, 2),
                        GTOreDictUnificator.get(OrePrefixes.gem, Materials.Amethyst, 4L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "tinted_glass", 2L)).duration(20 * SECONDS).eut(15)
                .addTo(alloySmelterRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 2L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "calcite", 1, 0, missing)).duration(8 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, "honeycomb", 4, 0, missing))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "honeycomb_block", 1, 0, missing)).duration(8 * SECONDS)
                .eut(2).addTo(compressorRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, "calcite", 1, 0, missing))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 2L)).duration(8 * SECONDS)
                .eut(2).addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, "leaves", 1, 1, missing))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "pink_petals", 4, 0, missing)).duration(8 * SECONDS).eut(2)
                .addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, "amethyst_block", 1, 0, missing))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.gem, Materials.Amethyst, 9L)).duration(8 * SECONDS)
                .eut(2).addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, "amethyst_cluster_2", 1, 6, missing))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.gem, Materials.Amethyst, 3L)).duration(8 * SECONDS)
                .eut(2).addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, "amethyst_block", 1, 0, missing))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Amethyst, 9L)).duration(13 * SECONDS)
                .eut(4).addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Amethyst, 13L),
                        GTOreDictUnificator.get(OrePrefixes.gem, Materials.Amethyst, 1L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "amethyst_cluster_2", 1, 6, missing))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("potion.mineralwater"), 2880)).duration(2 * MINUTES)
                .eut(TierEU.RECIPE_HV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Amethyst, 3L),
                        GTOreDictUnificator.get(OrePrefixes.gem, Materials.Amethyst, 1L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "amethyst_cluster_1", 1, 0, missing))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("potion.mineralwater"), 576)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_MV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Amethyst, 3L),
                        getModItem(EtFuturumRequiem.ID, "amethyst_cluster_1", 1, 0, missing))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "amethyst_cluster_1", 1, 6, missing))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("potion.mineralwater"), 576)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_MV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Amethyst, 3L),
                        getModItem(EtFuturumRequiem.ID, "amethyst_cluster_1", 1, 6, missing))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "amethyst_cluster_2", 1, 0, missing))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("potion.mineralwater"), 576)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_MV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Amethyst, 3L),
                        getModItem(EtFuturumRequiem.ID, "amethyst_cluster_2", 1, 0, missing))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "amethyst_cluster_2", 1, 6, missing))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("potion.mineralwater"), 576)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_MV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(BiomesOPlenty.ID, "misc", 1, 2, missing), GTUtility.getIntegratedCircuit(16))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "honeycomb", 1, 0, missing)).eut(30).duration(10 * SECONDS)
                .addTo(chemicalDehydratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, "honey_block", 1, 0, missing))
                .fluidOutputs(FluidRegistry.getFluidStack("for.honey", 1000)).duration(1 * MINUTES).eut(40)
                .addTo(fluidExtractionRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glass_bottle, 1))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "honey_bottle", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 250)).duration(1).eut(1)
                .addTo(fluidCannerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, "honey_bottle", 1, 0, missing))
                .itemOutputs(new ItemStack(Items.glass_bottle, 1))
                .fluidOutputs(FluidRegistry.getFluidStack("for.honey", 250)).duration(2 * SECONDS).eut(2)
                .addTo(fluidCannerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 8L),
                        getModItem(Botania.ID, "fertilizer", 3, 0, missing),
                        getModItem(ThaumicBases.ID, "genLeaves", 1, 3, missing),
                        GTUtility.getIntegratedCircuit(24))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "chorus_flower", 1, 0, missing))
                .fluidInputs(
                        new FluidStack(FluidRegistry.getFluid("endergoo"), 4000),
                        new FluidStack(FluidRegistry.getFluid("ender"), 1000))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, "tuff", 1, 0, missing))
                .itemOutputs(NHItemList.TuffDust.getIS(1)).duration(8 * SECONDS).eut(2).addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.TuffDust.getIS(36))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.VolcanicAsh, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 9L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Pumice, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.PotassiumFeldspar, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.GraniteBlack, 4L))
                .outputChances(5000, 2000, 1000, 750, 500, 250).duration(2 * MINUTES)
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("sulfurtrioxide"), 3600)).eut(TierEU.RECIPE_MV)
                .addTo(centrifugeRecipes);

        new ResearchItem(
                "UNDYINGTOTEM",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("infernus"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("spiritus"), 9)
                        .add(Aspect.getAspect("fames"), 6).add(Aspect.getAspect("corpus"), 3),
                -6,
                -7,
                3,
                getModItem(EtFuturumRequiem.ID, "totem_of_undying", 1, 0, missing)).setParents("GREENHEART")
                        .setConcealed().setRound()
                        .setPages(new ResearchPage("EtFuturumRequiem.research_page.UNDYINGTOTEM.1"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UNDYINGTOTEM",
                getModItem(EtFuturumRequiem.ID, "totem_of_undying", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("exanimis"), 100).add(Aspect.getAspect("ignis"), 150)
                        .add(Aspect.getAspect("lucrum"), 150).add(Aspect.getAspect("sano"), 200)
                        .add(Aspect.getAspect("praecantatio"), 200),
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 5, missing),
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Emerald, 1L),
                        getModItem(ThaumicBases.ID, "oldGold", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "BlockMetalStorage", 1, 2, missing),
                        getModItem(ThaumicBases.ID, "oldGold", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 5, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(ThaumicBases.ID, "oldGold", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "BlockMetalStorage", 1, 2, missing),
                        getModItem(ThaumicBases.ID, "oldGold", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.GreenSapphire, 1L), });
        TCHelper.addResearchPage(
                "UNDYINGTOTEM",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findInfusionRecipe(
                                        getModItem(EtFuturumRequiem.ID, "totem_of_undying", 1, 0, missing)))));
        ThaumcraftApi.addWarpToResearch("UNDYINGTOTEM", 3);
        // Shulker
        new ResearchItem(
                "SHULKER",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("infernus"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("spiritus"), 9)
                        .add(Aspect.getAspect("fames"), 6).add(Aspect.getAspect("corpus"), 3),
                -6,
                6,
                3,
                getModItem(EtFuturumRequiem.ID, "shulker_box", 1, 0, missing)).setParents("HUNGRYCHEST").setConcealed()
                        .setRound().setPages(new ResearchPage("EtFuturumRequiem.research_page.SHULKER.1"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SHULKER",
                getModItem(EtFuturumRequiem.ID, "shulker_box", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("terra"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("perditio"), 5),
                "aba",
                "cdc",
                "aba",
                'a',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'b',
                getModItem(EtFuturumRequiem.ID, "shulker_shell", 1, 0, missing),
                'c',
                GTOreDictUnificator.get("plateLivingwood", 1),
                'd',
                getModItem(EtFuturumRequiem.ID, "barrel", 1, 0, missing));
        TCHelper.addResearchPage(
                "SHULKER",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findArcaneRecipe(
                                        getModItem(EtFuturumRequiem.ID, "shulker_box", 1, 0, missing)))));

        // Netherite gear
        new ResearchItem(
                "NetheriteArmour",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("infernus"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("spiritus"), 9)
                        .add(Aspect.getAspect("fames"), 6).add(Aspect.getAspect("ignis"), 3),
                6,
                6,
                3,
                getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing)).setParents("ELDRITCHMINOR")
                        .setConcealed().setRound()
                        .setPages(new ResearchPage("EtFuturumRequiem.research_page.NetheriteArmour.1"))
                        .registerResearchItem();
        // Helmet
        ThaumcraftApi.addArcaneCraftingRecipe(
                "NetheriteArmour",
                getModItem(EtFuturumRequiem.ID, "netherite_helmet", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("perditio"), 15),
                "aba",
                "cdc",
                "aea",
                'a',
                getModItem(EtFuturumRequiem.ID, "netherite_scrap", 1, 0, missing),
                'b',
                createItemStack(
                        TinkersGregworks.ID,
                        "tGregToolPartLargePlate",
                        1,
                        1505,
                        "{material:\"Gold\"}",
                        missing),
                'c',
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0, missing),
                'd',
                getModItem(Botania.ID, "manaweaveHelm", 1, 0, missing),
                'e',
                GTOreDictUnificator.get("plateManaDiamond", 1));
        // Chestplate
        ThaumcraftApi.addArcaneCraftingRecipe(
                "NetheriteArmour",
                getModItem(EtFuturumRequiem.ID, "netherite_chestplate", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("perditio"), 15),
                "aba",
                "cdc",
                "aea",
                'a',
                getModItem(EtFuturumRequiem.ID, "netherite_scrap", 1, 0, missing),
                'b',
                createItemStack(
                        TinkersGregworks.ID,
                        "tGregToolPartLargePlate",
                        1,
                        1505,
                        "{material:\"Gold\"}",
                        missing),
                'c',
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0, missing),
                'd',
                getModItem(Botania.ID, "manaweaveChest", 1, 0, missing),
                'e',
                GTOreDictUnificator.get("plateManaDiamond", 1));
        // Leggins
        ThaumcraftApi.addArcaneCraftingRecipe(
                "NetheriteArmour",
                getModItem(EtFuturumRequiem.ID, "netherite_leggings", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("perditio"), 15),
                "aba",
                "cdc",
                "aea",
                'a',
                getModItem(EtFuturumRequiem.ID, "netherite_scrap", 1, 0, missing),
                'b',
                createItemStack(
                        TinkersGregworks.ID,
                        "tGregToolPartLargePlate",
                        1,
                        1505,
                        "{material:\"Gold\"}",
                        missing),
                'c',
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0, missing),
                'd',
                getModItem(Botania.ID, "manaweaveLegs", 1, 0, missing),
                'e',
                GTOreDictUnificator.get("plateManaDiamond", 1));
        // Boots
        ThaumcraftApi.addArcaneCraftingRecipe(
                "NetheriteArmour",
                getModItem(EtFuturumRequiem.ID, "netherite_boots", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("perditio"), 15),
                "aba",
                "cdc",
                "aea",
                'a',
                getModItem(EtFuturumRequiem.ID, "netherite_scrap", 1, 0, missing),
                'b',
                createItemStack(
                        TinkersGregworks.ID,
                        "tGregToolPartLargePlate",
                        1,
                        1505,
                        "{material:\"Gold\"}",
                        missing),
                'c',
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0, missing),
                'd',
                getModItem(Botania.ID, "manaweaveBoots", 1, 0, missing),
                'e',
                GTOreDictUnificator.get("plateManaDiamond", 1));
        // Pickaxe
        ThaumcraftApi.addArcaneCraftingRecipe(
                "NetheriteArmour",
                getModItem(EtFuturumRequiem.ID, "netherite_pickaxe", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("perditio"), 15),
                "aba",
                "cdc",
                "aea",
                'a',
                getModItem(EtFuturumRequiem.ID, "netherite_scrap", 1, 0, missing),
                'b',
                createItemStack(
                        TinkersGregworks.ID,
                        "tGregToolPartLargePlate",
                        1,
                        1505,
                        "{material:\"Gold\"}",
                        missing),
                'c',
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0, missing),
                'd',
                getModItem(Botania.ID, "manasteelPick", 1, 0, missing),
                'e',
                GTOreDictUnificator.get("plateManaDiamond", 1));
        // Hoe
        ThaumcraftApi.addArcaneCraftingRecipe(
                "NetheriteArmour",
                getModItem(EtFuturumRequiem.ID, "netherite_hoe", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("perditio"), 15),
                "aba",
                "cdc",
                "aea",
                'a',
                getModItem(EtFuturumRequiem.ID, "netherite_scrap", 1, 0, missing),
                'b',
                createItemStack(
                        TinkersGregworks.ID,
                        "tGregToolPartLargePlate",
                        1,
                        1505,
                        "{material:\"Gold\"}",
                        missing),
                'c',
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0, missing),
                'd',
                getModItem(PamsHarvestTheNether.ID, "Quartz Hoe", 1, 0, missing),
                'e',
                GTOreDictUnificator.get("plateManaDiamond", 1));
        // Shovel
        ThaumcraftApi.addArcaneCraftingRecipe(
                "NetheriteArmour",
                getModItem(EtFuturumRequiem.ID, "netherite_spade", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("perditio"), 15),
                "aba",
                "cdc",
                "aea",
                'a',
                getModItem(EtFuturumRequiem.ID, "netherite_scrap", 1, 0, missing),
                'b',
                createItemStack(
                        TinkersGregworks.ID,
                        "tGregToolPartLargePlate",
                        1,
                        1505,
                        "{material:\"Gold\"}",
                        missing),
                'c',
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0, missing),
                'd',
                getModItem(Botania.ID, "manasteelShovel", 1, 0, missing),
                'e',
                GTOreDictUnificator.get("plateManaDiamond", 1));
        // Sword
        ThaumcraftApi.addArcaneCraftingRecipe(
                "NetheriteArmour",
                getModItem(EtFuturumRequiem.ID, "netherite_sword", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("perditio"), 15),
                "aba",
                "cdc",
                "aea",
                'a',
                getModItem(EtFuturumRequiem.ID, "netherite_scrap", 1, 0, missing),
                'b',
                createItemStack(
                        TinkersGregworks.ID,
                        "tGregToolPartLargePlate",
                        1,
                        1505,
                        "{material:\"Gold\"}",
                        missing),
                'c',
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0, missing),
                'd',
                getModItem(Botania.ID, "manasteelSword", 1, 0, missing),
                'e',
                GTOreDictUnificator.get("plateManaDiamond", 1));
        // Axe
        ThaumcraftApi.addArcaneCraftingRecipe(
                "NetheriteArmour",
                getModItem(EtFuturumRequiem.ID, "netherite_axe", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("perditio"), 15),
                "aba",
                "cdc",
                "aea",
                'a',
                getModItem(EtFuturumRequiem.ID, "netherite_scrap", 1, 0, missing),
                'b',
                createItemStack(
                        TinkersGregworks.ID,
                        "tGregToolPartLargePlate",
                        1,
                        1505,
                        "{material:\"Gold\"}",
                        missing),
                'c',
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 0, missing),
                'd',
                getModItem(Botania.ID, "manasteelAxe", 1, 0, missing),
                'e',
                GTOreDictUnificator.get("plateManaDiamond", 1));
        TCHelper.addResearchPage(
                "NetheriteArmour",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findArcaneRecipe(
                                        getModItem(EtFuturumRequiem.ID, "netherite_helmet", 1, 0, missing)))));
        TCHelper.addResearchPage(
                "NetheriteArmour",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findArcaneRecipe(
                                        getModItem(EtFuturumRequiem.ID, "netherite_chestplate", 1, 0, missing)))));
        TCHelper.addResearchPage(
                "NetheriteArmour",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findArcaneRecipe(
                                        getModItem(EtFuturumRequiem.ID, "netherite_leggings", 1, 0, missing)))));
        TCHelper.addResearchPage(
                "NetheriteArmour",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findArcaneRecipe(
                                        getModItem(EtFuturumRequiem.ID, "netherite_boots", 1, 0, missing)))));
        TCHelper.addResearchPage(
                "NetheriteArmour",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findArcaneRecipe(
                                        getModItem(EtFuturumRequiem.ID, "netherite_pickaxe", 1, 0, missing)))));
        TCHelper.addResearchPage(
                "NetheriteArmour",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findArcaneRecipe(
                                        getModItem(EtFuturumRequiem.ID, "netherite_hoe", 1, 0, missing)))));
        TCHelper.addResearchPage(
                "NetheriteArmour",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findArcaneRecipe(
                                        getModItem(EtFuturumRequiem.ID, "netherite_spade", 1, 0, missing)))));
        TCHelper.addResearchPage(
                "NetheriteArmour",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findArcaneRecipe(
                                        getModItem(EtFuturumRequiem.ID, "netherite_sword", 1, 0, missing)))));
        TCHelper.addResearchPage(
                "NetheriteArmour",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findArcaneRecipe(
                                        getModItem(EtFuturumRequiem.ID, "netherite_axe", 1, 0, missing)))));
        ThaumcraftApi.addWarpToResearch("NetheriteArmour", 3);
        // Elytra
        new ResearchItem(
                "ELYTRA",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("spiritus"), 9)
                        .add(Aspect.getAspect("motus"), 12).add(Aspect.getAspect("tempestas"), 3),
                -4,
                6,
                3,
                getModItem(EtFuturumRequiem.ID, "elytra", 1, 0, missing)).setParents("FeatherWings").setConcealed()
                        .setPages(new ResearchPage("EtFuturumRequiem.research_page.ELYTRA.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ELYTRA",
                getModItem(EtFuturumRequiem.ID, "elytra", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("praecantatio"), 150)
                        .add(Aspect.getAspect("motus"), 150).add(Aspect.getAspect("tempestas"), 200)
                        .add(Aspect.getAspect("praecantatio"), 200),
                getModItem(WitchingGadgets.ID, "item.WG_Kama", 1, 4, missing),
                new ItemStack[] { getModItem(EnderIO.ID, "itemGliderWing", 1, 1, missing),
                        GregtechItemList.MagicFeather.get(1),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 14, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 59, missing),
                        getModItem(Botania.ID, "manaBeacon", 1, 10, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 59, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 14, missing),
                        GregtechItemList.MagicFeather.get(1), });
        TCHelper.addResearchPage(
                "ELYTRA",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findInfusionRecipe(
                                        getModItem(EtFuturumRequiem.ID, "elytra", 1, 0, missing)))));

    }
}
