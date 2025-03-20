package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.*;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.compressorRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidCannerRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidExtractionRecipes;
import static gregtech.api.recipe.RecipeMaps.hammerRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.recipe.RecipeMaps.multiblockChemicalReactorRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.*;
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
                        getModItem(EtFuturumRequiem.ID, "barrel", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 2L),
                        GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "barrel_upgrade", 1, 0, missing)).duration(15 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "barrel", 1, 0, missing),
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
                getModItem(Minecraft.ID, "quartz_block", 1, 0, missing),
                getModItem(EtFuturumRequiem.ID, "smooth_quartz", 1, 0, missing));

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

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.getIntegratedCircuit(20),
                        new ItemStack(Blocks.stone_slab, 1),
                        new ItemStack(Items.stick, 5),
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
                        new ItemStack(Blocks.netherrack, 16),
                        getModItem(EtFuturumRequiem.ID, "nether_wart", 1, 1, missing))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("blood"), 1000))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "nylium", 16, 1, missing)).duration(40 * SECONDS).eut(2)
                .addTo(mixerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Blocks.netherrack, 16),
                        getModItem(EtFuturumRequiem.ID, "nether_wart", 1, 0, missing))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("blood"), 1000))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "nylium", 16, 0, missing)).duration(40 * SECONDS).eut(2)
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

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 9L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "calcite", 1, 0, missing)).duration(8 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "moss", 9, 0, missing))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "moss_block", 1, 0, missing)).duration(8 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, "honeycomb", 4, 0, missing))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "honeycomb_block", 1, 0, missing)).duration(8 * SECONDS)
                .eut(2).addTo(compressorRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, "moss_carpet", 9, 0, missing))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "moss_block", 1, 0, missing)).duration(8 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, "calcite", 1, 0, missing))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 9L)).duration(8 * SECONDS)
                .eut(2).addTo(hammerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(EtFuturumRequiem.ID, "leaves", 1, 1, missing))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "pink_petals", 4, 0, missing)).duration(8 * SECONDS).eut(2)
                .addTo(hammerRecipes);

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

        GTModHandler.addCraftingRecipe(
                GTModHandler.getModItem(EtFuturumRequiem.ID, "azalea", 1L, 1),
                bits,
                new Object[] { "AAA", "ABA", "AAA", 'A',
                        GTModHandler.getModItem(EtFuturumRequiem.ID, "pink_petals", 1L, 0), 'B',
                        GTModHandler.getModItem(EtFuturumRequiem.ID, "azalea", 1L, 0) });
        GTModHandler.addCraftingRecipe(
                GTModHandler.getModItem(EtFuturumRequiem.ID, "azalea", 1L, 0),
                bits,
                new Object[] { "AAA", "ABA", "AAA", 'A',
                        GTModHandler.getModItem(EtFuturumRequiem.ID, "moss_block", 1L, 0), 'B',
                        new ItemStack(Blocks.sapling, 1) });
        // Totem
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
                getModItem(EtFuturumRequiem.ID, "shulker_box", 1, 0, missing)).setParents("ENDERPOUCHE").setConcealed()
                        .setRound().setPages(new ResearchPage("EtFuturumRequiem.research_page.SHULKER.1"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SHULKER",
                getModItem(EtFuturumRequiem.ID, "shulker_box", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("perditio"), 25),
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
        ThaumcraftApi.addInfusionCraftingRecipe(
                "NetheriteArmour",
                getModItem(EtFuturumRequiem.ID, "netherite_helmet", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("infernus"), 16).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("lucrum"), 64).add(Aspect.getAspect("tutamen"), 64)
                        .add(Aspect.getAspect("vitreus"), 64).add(Aspect.getAspect("metallum"), 32)
                        .add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("praecantatio"), 16),
                getModItem(Botania.ID, "manasteelHelm", 1, 0, missing),
                new ItemStack[] { getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        GTOreDictUnificator.get("plateManaDiamond", 1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get("plateManaDiamond", 1), });
        // Chestplate
        ThaumcraftApi.addInfusionCraftingRecipe(
                "NetheriteArmour",
                getModItem(EtFuturumRequiem.ID, "netherite_chestplate", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("infernus"), 16).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("lucrum"), 64).add(Aspect.getAspect("tutamen"), 64)
                        .add(Aspect.getAspect("vitreus"), 64).add(Aspect.getAspect("metallum"), 32)
                        .add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("praecantatio"), 16),
                getModItem(Botania.ID, "manasteelChest", 1, 0, missing),
                new ItemStack[] { getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        GTOreDictUnificator.get("plateManaDiamond", 1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get("plateManaDiamond", 1), });
        // Leggins
        ThaumcraftApi.addInfusionCraftingRecipe(
                "NetheriteArmour",
                getModItem(EtFuturumRequiem.ID, "netherite_leggings", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("infernus"), 16).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("lucrum"), 64).add(Aspect.getAspect("tutamen"), 64)
                        .add(Aspect.getAspect("vitreus"), 64).add(Aspect.getAspect("metallum"), 32)
                        .add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("praecantatio"), 16),
                getModItem(Botania.ID, "manasteelLegs", 1, 0, missing),
                new ItemStack[] { getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        GTOreDictUnificator.get("plateManaDiamond", 1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get("plateManaDiamond", 1), });
        // Boots
        ThaumcraftApi.addInfusionCraftingRecipe(
                "NetheriteArmour",
                getModItem(EtFuturumRequiem.ID, "netherite_boots", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("infernus"), 16).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("lucrum"), 64).add(Aspect.getAspect("tutamen"), 64)
                        .add(Aspect.getAspect("vitreus"), 64).add(Aspect.getAspect("metallum"), 32)
                        .add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("praecantatio"), 16),
                getModItem(Botania.ID, "manasteelBoots", 1, 0, missing),
                new ItemStack[] { getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        GTOreDictUnificator.get("plateManaDiamond", 1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get("plateManaDiamond", 1), });
        // Pickaxe
        ThaumcraftApi.addInfusionCraftingRecipe(
                "NetheriteArmour",
                getModItem(EtFuturumRequiem.ID, "netherite_pickaxe", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("infernus"), 16).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("lucrum"), 64).add(Aspect.getAspect("tutamen"), 64)
                        .add(Aspect.getAspect("vitreus"), 64).add(Aspect.getAspect("metallum"), 32)
                        .add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("praecantatio"), 16),
                getModItem(Botania.ID, "manasteelPick", 1, 0, missing),
                new ItemStack[] { getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        GTOreDictUnificator.get("plateManaDiamond", 1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get("plateManaDiamond", 1), });
        // Hoe
        ThaumcraftApi.addInfusionCraftingRecipe(
                "NetheriteArmour",
                getModItem(EtFuturumRequiem.ID, "netherite_hoe", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("infernus"), 16).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("lucrum"), 64).add(Aspect.getAspect("tutamen"), 64)
                        .add(Aspect.getAspect("vitreus"), 64).add(Aspect.getAspect("metallum"), 32)
                        .add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("praecantatio"), 16),
                getModItem(ExtraUtilities.ID, "temporalHoe", 1, 0, missing),
                new ItemStack[] { getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        GTOreDictUnificator.get("plateManaDiamond", 1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get("plateManaDiamond", 1), });
        // Shovel
        ThaumcraftApi.addInfusionCraftingRecipe(
                "NetheriteArmour",
                getModItem(EtFuturumRequiem.ID, "netherite_spade", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("infernus"), 16).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("lucrum"), 64).add(Aspect.getAspect("tutamen"), 64)
                        .add(Aspect.getAspect("vitreus"), 64).add(Aspect.getAspect("metallum"), 32)
                        .add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("praecantatio"), 16),
                getModItem(Botania.ID, "manasteelShovel", 1, 0, missing),
                new ItemStack[] { getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        GTOreDictUnificator.get("plateManaDiamond", 1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get("plateManaDiamond", 1), });
        // Sword
        ThaumcraftApi.addInfusionCraftingRecipe(
                "NetheriteArmour",
                getModItem(EtFuturumRequiem.ID, "netherite_sword", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("infernus"), 16).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("lucrum"), 64).add(Aspect.getAspect("tutamen"), 64)
                        .add(Aspect.getAspect("vitreus"), 64).add(Aspect.getAspect("metallum"), 32)
                        .add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("praecantatio"), 16),
                getModItem(Botania.ID, "manasteelSword", 1, 0, missing),
                new ItemStack[] { getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        GTOreDictUnificator.get("plateManaDiamond", 1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get("plateManaDiamond", 1), });
        // Axe
        ThaumcraftApi.addInfusionCraftingRecipe(
                "NetheriteArmour",
                getModItem(EtFuturumRequiem.ID, "netherite_axe", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("infernus"), 16).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("lucrum"), 64).add(Aspect.getAspect("tutamen"), 64)
                        .add(Aspect.getAspect("vitreus"), 64).add(Aspect.getAspect("metallum"), 32)
                        .add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("praecantatio"), 16),
                getModItem(Botania.ID, "manasteelAxe", 1, 0, missing),
                new ItemStack[] { getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        GTOreDictUnificator.get("plateManaDiamond", 1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        getModItem(EtFuturumRequiem.ID, "ancient_debris", 1, 0, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get("plateManaDiamond", 1), });
        TCHelper.addResearchPage(
                "NetheriteArmour",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findInfusionRecipe(
                                        getModItem(EtFuturumRequiem.ID, "netherite_helmet", 1, 0, missing)))));
        TCHelper.addResearchPage(
                "NetheriteArmour",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findInfusionRecipe(
                                        getModItem(EtFuturumRequiem.ID, "netherite_chestplate", 1, 0, missing)))));
        TCHelper.addResearchPage(
                "NetheriteArmour",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findInfusionRecipe(
                                        getModItem(EtFuturumRequiem.ID, "netherite_leggings", 1, 0, missing)))));
        TCHelper.addResearchPage(
                "NetheriteArmour",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findInfusionRecipe(
                                        getModItem(EtFuturumRequiem.ID, "netherite_boots", 1, 0, missing)))));
        TCHelper.addResearchPage(
                "NetheriteArmour",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findInfusionRecipe(
                                        getModItem(EtFuturumRequiem.ID, "netherite_pickaxe", 1, 0, missing)))));
        TCHelper.addResearchPage(
                "NetheriteArmour",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findInfusionRecipe(
                                        getModItem(EtFuturumRequiem.ID, "netherite_hoe", 1, 0, missing)))));
        TCHelper.addResearchPage(
                "NetheriteArmour",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findInfusionRecipe(
                                        getModItem(EtFuturumRequiem.ID, "netherite_spade", 1, 0, missing)))));
        TCHelper.addResearchPage(
                "NetheriteArmour",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findInfusionRecipe(
                                        getModItem(EtFuturumRequiem.ID, "netherite_sword", 1, 0, missing)))));
        TCHelper.addResearchPage(
                "NetheriteArmour",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findInfusionRecipe(
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
