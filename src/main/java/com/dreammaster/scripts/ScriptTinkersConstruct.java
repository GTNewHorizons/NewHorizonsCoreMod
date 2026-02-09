package com.dreammaster.scripts;

import static com.dreammaster.scripts.GameRegistryProxy.shapedRecipes;
import static com.dreammaster.scripts.GameRegistryProxy.shapelessRecipes;
import static com.dreammaster.tinkersConstruct.SmelteryFluidTypes.getMoltenPatternFluidTypeName;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.BuildCraftCore;
import static gregtech.api.enums.Mods.Chisel;
import static gregtech.api.enums.Mods.ElectroMagicTools;
import static gregtech.api.enums.Mods.ExtraTrees;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.ForgeMicroblocks;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.IguanaTweaksTinkerConstruct;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Mantle;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.RandomThings;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TinkersMechworks;
import static gregtech.api.enums.Mods.WitchingGadgets;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidSolidifierRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.chemicalDehydratorRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.chisel.ChiselHelper;
import com.dreammaster.item.NHItemList;
import com.dreammaster.mantle.MantleManualRecipeRegistry;
import com.dreammaster.oredict.OreDictHelper;
import com.dreammaster.recipes.Recipe;
import com.dreammaster.tinkersConstruct.TConstructHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.ToolDictNames;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import mantle.lib.client.MantleClientRegistry;
import tconstruct.TConstruct;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.DryingRackRecipes;
import tconstruct.library.crafting.FluidType;
import tconstruct.library.crafting.Smeltery;

public class ScriptTinkersConstruct implements IScriptLoader {

    private static final MantleManualRecipeRegistry MANTLE = MantleManualRecipeRegistry.getInstance();

    @Override
    public String getScriptName() {
        return "Tinkers Construct";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Backpack.ID,
                BiomesOPlenty.ID,
                BloodArsenal.ID,
                BuildCraftCore.ID,
                Chisel.ID,
                ElectroMagicTools.ID,
                ExtraTrees.ID,
                ExtraUtilities.ID,
                Forestry.ID,
                ForgeMicroblocks.ID,
                GalaxySpace.ID,
                IguanaTweaksTinkerConstruct.ID,
                IndustrialCraft2.ID,
                Mantle.ID,
                Natura.ID,
                PamsHarvestCraft.ID,
                Railcraft.ID,
                RandomThings.ID,
                Thaumcraft.ID,
                TinkerConstruct.ID,
                TinkersMechworks.ID,
                WitchingGadgets.ID);
    }

    @Override
    public void loadRecipes() {
        OreDictionary.registerOre("bucketEnder", getModItem(TinkerConstruct.ID, "buckets", 1, 23, missing));
        OreDictHelper.removeOreDict("nuggetAluminium", getModItem(TinkerConstruct.ID, "oreBerries", 1, 4, missing));

        Recipe.of(
                getModItem(TinkerConstruct.ID, "LavaTank", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterytank1"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "LavaTankNether", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(Minecraft.ID, "furnace", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterycontroller"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(Natura.ID, "NetherFurnace", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "Smeltery", 2, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("searedbricks"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Smeltery", 2, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SmelteryNether", 2, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(Minecraft.ID, "lava_bucket", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SmelteryNether", 2, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketLava", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterydrain"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "SearedBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 4, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterytable"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlockNether", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "SearedBlock", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterybasin"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlockNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("castingchannel"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlock", 2, 1, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlockNether", 2, 1, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 1, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "SearedBlock", 1, 1, missing),
                null,
                null,
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelteryfaucet"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlockNether", 1, 1, missing),
                null,
                null,
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "LavaTank", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                "glassReinforced",
                "blockGlass",
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterytank2"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "LavaTankNether", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                "glassReinforced",
                "blockGlass",
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "LavaTank", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                "blockGlass",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterytank3"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "LavaTankNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                "blockGlass",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing));
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "helmetWood", 1, 0, missing),
                new Object[] { "LLL", "LrL", "   ", 'L', "logWood" });
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "chestplateWood", 1, 0, missing),
                new Object[] { "LrL", "LLL", "LLL", 'L', "logWood" });
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "leggingsWood", 1, 0, missing),
                new Object[] { "LLL", "LrL", "L L", 'L', "logWood" });
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "bootsWood", 1, 0, missing),
                new Object[] { "LrL", "L L", "   ", 'L', "logWood" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPane", 2, 0, missing),
                "craftingToolSaw",
                null,
                null,
                null,
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                null);
        Recipe.of(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                "sand",
                "sand",
                "sand",
                "dustClay",
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                "dustClay",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("grout"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "dustClay",
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                "dustClay",
                "sand",
                "sand",
                "sand");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                "sand",
                "dustClay",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "sand",
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "sand",
                "dustClay",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "dustClay",
                "sand",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                "sand",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "dustClay",
                "sand");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                "sand",
                "sand",
                "sand",
                "dustClay",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing),
                "dustClay",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "dustClay",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing),
                "dustClay",
                "sand",
                "sand",
                "sand");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                "sand",
                "dustClay",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "sand",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "sand",
                "dustClay",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "dustClay",
                "sand",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing),
                "sand",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "dustClay",
                "sand");
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6, missing),
                getModItem(Minecraft.ID, "nether_wart", 1, 0, missing),
                getModItem(Minecraft.ID, "soul_sand", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6, missing),
                getModItem(Minecraft.ID, "nether_wart", 1, 0, missing),
                getModItem(Minecraft.ID, "soul_sand", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6, missing),
                getModItem(Minecraft.ID, "nether_wart", 1, 0, missing),
                getModItem(Natura.ID, "soil.tainted", 1, 0, missing),
                getModItem(Natura.ID, "heatsand", 1, 0, missing),
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6, missing),
                getModItem(Minecraft.ID, "nether_wart", 1, 0, missing),
                getModItem(Natura.ID, "soil.tainted", 1, 0, missing),
                getModItem(Natura.ID, "heatsand", 1, 0, missing),
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                "platePaper",
                "platePaper",
                "platePaper",
                "platePaper").provideTo(shapelessRecipes())
                .provideTo(MANTLE.manualShapelessCraftingRecipeNamed("blankpattern"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingStation", 1, 0, missing),
                "craftingToolSaw",
                "craftingTableWood");
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 0, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "CraftingStation", 1, 0, missing));
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 0, missing),
                new Object[] { "SPS", "SCS", " r ", 'S', "stickWood", 'P',
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing), 'C',
                        getModItem(TinkerConstruct.ID, "CraftingStation", 1, 0, missing) });
        Recipe.of(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 0, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                "stickWood",
                "stickWood",
                getModItem(Minecraft.ID, "crafting_table", 1, 0, missing),
                "stickWood",
                null,
                ToolDictNames.craftingToolSoftMallet.name(),
                null).provideTo(shapedRecipes()).provideTo(MANTLE.manualShapedCraftingRecipeNamed("toolstation"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 0, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "trap.barricade.oak", 1, 0, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "trap.barricade.oak", 1, 0, missing),
                null,
                ToolDictNames.craftingToolSoftMallet.name(),
                null).provideTo(shapedRecipes()).provideTo(MANTLE.manualShapedCraftingRecipeNamed("partcrafter"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 2, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 3, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 4, missing));
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 2, missing),
                new Object[] { "SPS", "BSB", " r ", 'S', "stickWood", 'P',
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing), 'B',
                        getModItem(TinkerConstruct.ID, "trap.barricade.spruce", 1, 0, missing) });
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 3, missing),
                new Object[] { "SPS", "BSB", " r ", 'S', "stickWood", 'P',
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing), 'B',
                        getModItem(TinkerConstruct.ID, "trap.barricade.birch", 1, 0, missing) });
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 4, missing),
                new Object[] { "SPS", "BSB", " r ", 'S', "stickWood", 'P',
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing), 'B',
                        getModItem(TinkerConstruct.ID, "trap.barricade.jungle", 1, 0, missing) });
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 2, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 2, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 2, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 2, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 3, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 2, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 4, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 5, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                "stickWood",
                "stickWood",
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                "stickWood",
                null,
                ToolDictNames.craftingToolSoftMallet.name(),
                null).provideTo(shapedRecipes()).provideTo(MANTLE.manualShapedCraftingRecipeNamed("patternchest"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 4, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 5, missing));
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10, missing),
                new Object[] { "SPS", "FSF", " r ", 'S', "stickWood", 'P',
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing), 'F', "fenceWood" });
        Recipe.of(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                "stickWood",
                Blocks.fence,
                "stickWood",
                Blocks.fence,
                null,
                ToolDictNames.craftingToolSoftMallet.name(),
                null).provideTo(MANTLE.manualShapedCraftingRecipeNamed("stenciltable"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10, missing),
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 11, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10, missing),
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 12, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10, missing),
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 13, missing));
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 11, missing),
                new Object[] { "SPS", "FSF", " r ", 'S', "stickWood", 'P',
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing), 'F',
                        createItemStack(ExtraTrees.ID, "multifence", 1, 16387, "{meta:65537}", missing) });
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 12, missing),
                new Object[] { "SPS", "FSF", " r ", 'S', "stickWood", 'P',
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing), 'F',
                        createItemStack(ExtraTrees.ID, "multifence", 1, 16387, "{meta:131074}", missing) });
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 13, missing),
                new Object[] { "SPS", "FSF", " r ", 'S', "stickWood", 'P',
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing), 'F',
                        createItemStack(ExtraTrees.ID, "multifence", 1, 16387, "{meta:196611}", missing) });
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 3, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 3, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 11, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 3, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 12, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 3, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 13, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockIron",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockIron",
                "blockIron",
                "craftingToolHardHammer",
                "blockIron").provideTo(shapedRecipes()).provideTo(MANTLE.manualShapedCraftingRecipeNamed("toolforge"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockGold",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockGold",
                "blockGold",
                "craftingToolHardHammer",
                "blockGold");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockDiamond",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockDiamond",
                "blockDiamond",
                "craftingToolHardHammer",
                "blockDiamond");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 3, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockEmerald",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockEmerald",
                "blockEmerald",
                "craftingToolHardHammer",
                "blockEmerald");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 4, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockCobalt",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockCobalt",
                "blockCobalt",
                "craftingToolHardHammer",
                "blockCobalt");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 5, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockArdite",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockArdite",
                "blockArdite",
                "craftingToolHardHammer",
                "blockArdite");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 6, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockManyullyn",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockManyullyn",
                "blockManyullyn",
                "craftingToolHardHammer",
                "blockManyullyn");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 7, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockCopper",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockCopper",
                "blockCopper",
                "craftingToolHardHammer",
                "blockCopper");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 8, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockBronze",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockBronze",
                "blockBronze",
                "craftingToolHardHammer",
                "blockBronze");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 9, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockTin",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockTin",
                "blockTin",
                "craftingToolHardHammer",
                "blockTin");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 10, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockAluminium",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockAluminium",
                "blockAluminium",
                "craftingToolHardHammer",
                "blockAluminium");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 11, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockAluminiumBrass",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockAluminiumBrass",
                "blockAluminiumBrass",
                "craftingToolHardHammer",
                "blockAluminiumBrass");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 12, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockAlumite",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockAlumite",
                "blockAlumite",
                "craftingToolHardHammer",
                "blockAlumite");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 13, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockSteel",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockSteel",
                "blockSteel",
                "craftingToolHardHammer",
                "blockSteel");
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "FurnaceSlab", 1, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "furnace", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 5, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, wildcard, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 0, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 1, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 4, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 2, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 5, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 3, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 6, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 4, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 8, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 5, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 9, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 6, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 10, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 7, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 11, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 7, missing),
                "craftingToolHardHammer",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 0, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 1, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 1, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 2, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 2, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 3, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 3, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 4, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 4, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 5, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 5, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 6, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 6, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 7, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 7, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "trap.punji", 2, 0, missing),
                getModItem(Minecraft.ID, "reeds", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "reeds", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "reeds", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "reeds", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "reeds", 1, 0, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("punji"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 0, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 1, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 1, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 2, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 2, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 3, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 3, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 4, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 4, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 5, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 5, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 6, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 6, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 7, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 7, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 0, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 8, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 1, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 9, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 2, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 10, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 3, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 11, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 4, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 12, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 5, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 13, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 6, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 14, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 7, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 15, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "trap.barricade.oak", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "log", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 0, missing),
                null).provideTo(shapedRecipes()).provideTo(MANTLE.manualShapedCraftingRecipeNamed("barricade"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "trap.barricade.spruce", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 1, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 1, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "log", 1, 1, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 1, missing),
                null);
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "trap.barricade.birch", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 2, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 2, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "log", 1, 2, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 2, missing),
                null);
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "trap.barricade.jungle", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 3, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 3, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "log", 1, 3, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 3, missing),
                null);
        Recipe.of(
                getModItem(TinkerConstruct.ID, "slime.channel", 1, 0, missing),
                "slimeball",
                "slimeball",
                "slimeball",
                "dustRedstone",
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                "dustRedstone",
                "slimeball",
                "slimeball",
                "slimeball").provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("slimechannel"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "blood.channel", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                "dustRedstone",
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                "dustRedstone",
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "slime.pad", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "slime.channel", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "slime.channel", 1, 0, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("bouncepad"));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 0, missing),
                getModItem(Minecraft.ID, "slime_ball", 1, 0, missing),
                getModItem(Minecraft.ID, "slime_ball", 1, 0, missing),
                getModItem(Minecraft.ID, "slime_ball", 1, 0, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 1, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                getModItem(Minecraft.ID, "slime_ball", 1, 0, missing),
                getModItem(Minecraft.ID, "slime_ball", 1, 0, missing),
                getModItem(Minecraft.ID, "slime_ball", 1, 0, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("slimymud"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 1, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 3, missing),
                "dustBone",
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0, missing),
                "dustBone",
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0, missing),
                "dustBone",
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0, missing),
                "dustBone").provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("graveyardsoil"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeWhite",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeWhite");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 1, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeOrange",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeOrange");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 2, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeMagenta",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeMagenta");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 3, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeLightBlue",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 3, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeLightBlue");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 4, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeYellow",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 4, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeYellow");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 5, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeLime",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 5, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeLime");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 6, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyePink",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 6, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyePink");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 7, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeGray",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 7, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeGray");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 8, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeLightGray",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 8, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeLightGray");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 9, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeCyan",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 9, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeCyan");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 10, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyePurple",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 10, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyePurple");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 11, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeBlue",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 11, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeBlue");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 12, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeBrown",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 12, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeBrown");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 13, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeGreen",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 13, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeGreen");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 14, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeRed",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 14, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeRed");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 15, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeBlack",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeBlack");

        // Add TiCon Stained Glass to Chisel
        String[] colors = new String[] { "white", "orange", "magenta", "lightblue", "yellow", "lime", "pink", "gray",
                "lightgray", "cyan", "purple", "blue", "brown", "green", "red", "black" };
        for (int i = 0; i < 16; i++) {
            ChiselHelper.addVariationFromStack(
                    "stained_glass_pane_" + colors[i],
                    getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, i));
        }

        Recipe.of(
                getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 0, missing),
                "slabWood",
                "slabWood",
                "slabWood",
                "screwWood",
                "craftingToolScrewdriver",
                "screwWood").provideTo(shapedRecipes()).provideTo(MANTLE.manualShapedCraftingRecipeNamed("dryingrack"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 5, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 5, missing),
                getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 0, missing),
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing),
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                getModItem(Minecraft.ID, "stone", 1, 0, missing),
                getModItem(Railcraft.ID, "detector", 1, 1, missing),
                getModItem(Minecraft.ID, "stone", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 1, missing),
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing),
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                getModItem(Minecraft.ID, "stone", 1, 0, missing),
                getModItem(Railcraft.ID, "detector", 1, 3, missing),
                getModItem(Minecraft.ID, "stone", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 2, missing),
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing),
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                getModItem(Minecraft.ID, "stone", 1, 0, missing),
                getModItem(Railcraft.ID, "detector", 1, 5, missing),
                getModItem(Minecraft.ID, "stone", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 3, missing),
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing),
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                getModItem(Minecraft.ID, "stone", 1, 0, missing),
                getModItem(Railcraft.ID, "detector", 1, 4, missing),
                getModItem(Minecraft.ID, "stone", 1, 0, missing));
        // Obsidian Stick conversions
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "toolRod", 2, 6, missing),
                "stickObsidian",
                null,
                null,
                null,
                "stickObsidian",
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(RandomThings.ID, "ingredient", 2, 1, missing),
                null,
                "stickObsidian",
                null,
                null,
                "stickObsidian",
                null,
                null,
                null,
                null);
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Obsidian, 2L),
                null,
                null,
                "stickObsidian",
                null,
                "stickObsidian",
                null,
                null,
                null,
                null);
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0, missing));
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelGoggles",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:0.0d,Built:1b,MaxDefense:4.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}",
                        missing),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                "boltElectrum",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                "ringElectrum",
                getModItem(Minecraft.ID, "diamond_helmet", 1, 0, missing),
                "ringElectrum",
                "lensDiamond",
                "circuitAdvanced",
                "lensDiamond");
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelVest",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:4.0d,Built:1b,MaxDefense:10.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}",
                        missing),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                "circuitAdvanced",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                "plateObsidian",
                getModItem(Minecraft.ID, "diamond_chestplate", 1, 0, missing),
                "plateObsidian",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                "plateObsidian",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing));
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelGlove",
                        1,
                        0,
                        "{TinkerAccessory:{BaseDurability:500,Built:1b,Damage:0,BonusDurability:0,TotalDurability:500,ModDurability:0.0f,Modifiers:5,Broken:0b}}",
                        missing),
                null,
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                "plateDiamond",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                null,
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                "circuitAdvanced");
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelWings",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:2.0d,Built:1b,MaxDefense:8.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}",
                        missing),
                "plateDiamond",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                "plateDiamond",
                getModItem(TinkerConstruct.ID, "fletching", 1, 0, missing),
                "circuitAdvanced",
                getModItem(TinkerConstruct.ID, "fletching", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "fletching", 1, 0, missing),
                getModItem(Minecraft.ID, "diamond_leggings", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "fletching", 1, 0, missing));
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelBelt",
                        1,
                        0,
                        "{TinkerAccessory:{BaseDurability:500,Built:1b,Damage:0,BonusDurability:0,TotalDurability:500,ModDurability:0.0f,Modifiers:5,Broken:0b}}",
                        missing),
                null,
                "circuitAdvanced",
                null,
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                "plateDiamond",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                null,
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing));
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelBoots",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:2.0d,Built:1b,MaxDefense:6.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}",
                        missing),
                null,
                "plateDiamond",
                "plateDiamond",
                null,
                getModItem(Minecraft.ID, "diamond_boots", 1, 0, missing),
                "circuitAdvanced",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                ItemList.Electric_Piston_HV.get(1L),
                ItemList.Electric_Piston_HV.get(1L));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "materials", 1, 3, missing),
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L));
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L),
                getModItem(TinkerConstruct.ID, "materials", 1, 3, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "materials", 1, 5, missing),
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Manyullyn, 1L));
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Manyullyn, 1L),
                getModItem(TinkerConstruct.ID, "materials", 1, 5, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "decoration.stoneladder", 4, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(TinkersMechworks.ID, "LengthWire", 1, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(TinkersMechworks.ID, "LengthWire", 1, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "slime_boots", 1, 0, missing),
                getModItem(Backpack.ID, "tannedLeather", 1),
                null,
                getModItem(Backpack.ID, "tannedLeather", 1),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "slime.pad", 1, 0, missing),
                getModItem(Minecraft.ID, "leather_boots", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "slime.pad", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "slimesling", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 1, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                null,
                getModItem(TinkerConstruct.ID, "slime.channel", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "slime.pad", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 1, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                null);

        TConstructHelper.removeBasinRecipe(getModItem(Minecraft.ID, "iron_block", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem(Minecraft.ID, "gold_block", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem(Minecraft.ID, "obsidian", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem(Minecraft.ID, "emerald_block", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 1, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 2, missing));
        TConstructHelper.removeBasinRecipe(getModItem(IndustrialCraft2.ID, "blockMetal", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem(IndustrialCraft2.ID, "blockMetal", 1, 2, missing));
        TConstructHelper.removeBasinRecipe(getModItem(IndustrialCraft2.ID, "blockMetal", 1, 1, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 6, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 7, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 8, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "GlueBlock", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(GTOreDictUnificator.get(OrePrefixes.block, Materials.PigIron, 1L));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 2, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "Smeltery", 1, 4, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "Smeltery", 1, 5, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 10, missing));
        TConstructHelper.removeMeltingRecipe(new ItemStack(GregTechAPI.sBlockOres1, 1, 33));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "SearedBrick", 1, 1, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(GalaxySpace.ID, "phobosblocks", 1, 4, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "GravelOre", 1, 5, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 39, missing));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "SearedBrick", 1, 2, missing));
        TConstructHelper.removeMeltingRecipe(new ItemStack(GregTechAPI.sBlockOres1, 1, 382));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 38, missing));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ardite, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 29, missing));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.nugget, Materials.Ardite, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 1, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 41, missing));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 30, missing));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.nugget, Materials.Manyullyn, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 2, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 10, missing));
        TConstructHelper.removeTableRecipe(getModItem(BuildCraftCore.ID, "ironGearItem", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(BuildCraftCore.ID, "goldGearItem", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(Forestry.ID, "gearBronze", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(Forestry.ID, "gearCopper", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(Forestry.ID, "gearTin", 1, 0, missing));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Platinum, 1L));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Nickel, 1L));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Silver, 1L));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Silver, 1L));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Electrum, 1L));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Invar, 1L));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Lead, 1L));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Lead, 1L));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Steel, 1L));
        TConstructHelper.removeTableRecipe(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 1, missing));
        TConstructHelper.removeTableRecipe(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 2, missing));
        TConstructHelper.removeTableRecipe(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 3, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "chainmail_helmet", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "chainmail_chestplate", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "chainmail_leggings", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "chainmail_boots", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.nugget, Materials.Cobalt, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 3, missing));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(GalaxySpace.ID, "item.Ingots", 1, 1, missing));
        TConstructHelper.removeMeltingRecipe(new ItemStack(GregTechAPI.sBlockMetal2, 1, 5));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "sand", 1, 0, missing));
        TConstructHelper.removeSmelterAlloyMix(FluidRegistry.getFluidStack("alumite.molten", 32));
        TConstructHelper.removeSmelterAlloyMix(FluidRegistry.getFluidStack("aluminumbrass.molten", 32));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 1, missing));
        TConstructHelper.removeTableRecipe(getModItem(Minecraft.ID, "golden_apple", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "gearCast", 1, 0, missing));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Enderium, 1L));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Ardite, 1L));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Manyullyn, 1L));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Invar, 1L));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Electrum, 1L));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Platinum, 1L));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Nickel, 1L));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Enderium, 1L));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 29, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 30, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 4, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 5, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 11, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 22, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "snowball", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 14, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 15, missing));
        TConstructHelper.removeBasinRecipe(getModItem(IndustrialCraft2.ID, "blockMetal", 1, 5, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(Thaumcraft.ID, "ItemNugget", 1, 19, missing));
        TConstructHelper
                .getMeltingAdder(
                        GameRegistry.findBlock("gregtech", "gt.blockmachines"),
                        1585,
                        500,
                        "aluminum.molten",
                        144)
                .add(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 1))
                .withAmount(16)
                .add(
                        GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Aluminium, 1L),
                        getModItem(TinkerConstruct.ID, "oreBerries", 1, 4, missing))
                .withAmount(36).add(GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Aluminium, 1L));
        Smeltery.addMelting(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L),
                GameRegistry.findBlock("minecraft", "sand"),
                0,
                800,
                FluidRegistry.getFluidStack("glass.molten", 1000));
        Smeltery.addMelting(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Electrum, 1L),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                400,
                FluidRegistry.getFluidStack("electrum.molten", 144));
        TConstructRegistry.getTableCasting().addCastingRecipe(
                GTOreDictUnificator.get(OrePrefixes.nugget, Materials.Copper, 1L),
                FluidRegistry.getFluidStack("copper.molten", 16),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 27, missing),
                false,
                20);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                GTOreDictUnificator.get(OrePrefixes.nugget, Materials.Tin, 1L),
                FluidRegistry.getFluidStack("tin.molten", 16),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 27, missing),
                false,
                20);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                GTOreDictUnificator.get(OrePrefixes.nugget, Materials.Iron, 1),
                FluidRegistry.getFluidStack("iron.molten", 16),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 27, missing),
                false,
                20);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                GTOreDictUnificator.get(OrePrefixes.nugget, Materials.AnyBronze, 1L),
                FluidRegistry.getFluidStack("bronze.molten", 16),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 27, missing),
                false,
                20);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 1L),
                FluidRegistry.getFluidStack("copper.molten", 144),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0, missing),
                false,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 1L),
                FluidRegistry.getFluidStack("tin.molten", 144),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0, missing),
                false,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 1L),
                FluidRegistry.getFluidStack("bronze.molten", 144),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0, missing),
                false,
                100);
        TConstructHelper.getMeltingAdder(FluidType.getFluidType(getMoltenPatternFluidTypeName()), 150, 72).add(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 3, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 4, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 5, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 6, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 7, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 8, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 9, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 10, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 11, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 12, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 13, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 14, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 16, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 17, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 18, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 19, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 20, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 21, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 22, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 25, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 26, missing),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 27, missing),
                getModItem(TinkerConstruct.ID, "Cast", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "Cast", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "Cast", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Cast", 1, 3, missing));
        TConstructHelper.getMeltingAdder(FluidType.getFluidType("Iron"), 100, 144).add(
                new ItemStack(GregTechAPI.sBlockOres1, 1, 32),
                GTOreDictUnificator.get(OrePrefixes.rawOre, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.AnyIron, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ore, Materials.BrownLimonite, 1L),
                GTOreDictUnificator.get(OrePrefixes.rawOre, Materials.BrownLimonite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.BrownLimonite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreEndstone, Materials.BrownLimonite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.BrownLimonite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.BrownLimonite, 1L),
                GTOreDictUnificator.get(OrePrefixes.ore, Materials.YellowLimonite, 1L),
                GTOreDictUnificator.get(OrePrefixes.rawOre, Materials.YellowLimonite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.YellowLimonite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreEndstone, Materials.YellowLimonite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.YellowLimonite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.YellowLimonite, 1L),
                GTOreDictUnificator.get(OrePrefixes.ore, Materials.BandedIron, 1L),
                GTOreDictUnificator.get(OrePrefixes.rawOre, Materials.BandedIron, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.BandedIron, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreEndstone, Materials.BandedIron, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.BandedIron, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.BandedIron, 1L),
                GTOreDictUnificator.get(OrePrefixes.ore, Materials.GraniticMineralSand, 1L),
                GTOreDictUnificator.get(OrePrefixes.rawOre, Materials.GraniticMineralSand, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.GraniticMineralSand, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreEndstone, Materials.GraniticMineralSand, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.GraniticMineralSand, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.GraniticMineralSand, 1L),
                GTOreDictUnificator.get(OrePrefixes.ore, Materials.Magnetite, 1L),
                GTOreDictUnificator.get(OrePrefixes.rawOre, Materials.Magnetite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Magnetite, 1L),
                new ItemStack(GregTechAPI.sBlockOres1, 1, 28706),
                GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Magnetite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Magnetite, 1L),
                GTOreDictUnificator.get(OrePrefixes.ore, Materials.Pyrite, 1L),
                GTOreDictUnificator.get(OrePrefixes.rawOre, Materials.Pyrite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Pyrite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Pyrite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Pyrite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Pyrite, 1L));
        TConstructHelper.getMeltingAdder(FluidType.getFluidType("Copper"), 50, 144).add(
                new ItemStack(GregTechAPI.sBlockOres1, 1, 35),
                GTOreDictUnificator.get(OrePrefixes.rawOre, Materials.Copper, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Copper, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Copper, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Copper, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Copper, 1L),
                new ItemStack(GregTechAPI.sBlockOres1, 1, 871),
                GTOreDictUnificator.get(OrePrefixes.rawOre, Materials.Malachite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Malachite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Malachite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Malachite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Malachite, 1L),
                GTOreDictUnificator.get(OrePrefixes.ore, Materials.Tetrahedrite, 1L),
                GTOreDictUnificator.get(OrePrefixes.rawOre, Materials.Tetrahedrite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Tetrahedrite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Tetrahedrite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Tetrahedrite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Tetrahedrite, 1L),
                GTOreDictUnificator.get(OrePrefixes.ore, Materials.Chalcopyrite, 1L),
                GTOreDictUnificator.get(OrePrefixes.rawOre, Materials.Chalcopyrite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Chalcopyrite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Chalcopyrite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Chalcopyrite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Chalcopyrite, 1L));
        TConstructHelper.getMeltingAdder(FluidType.getFluidType("Tin"), 0, 144).add(
                new ItemStack(GregTechAPI.sBlockOres1, 1, 57),
                GTOreDictUnificator.get(OrePrefixes.rawOre, Materials.Tin, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Tin, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Tin, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Tin, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Tin, 1L));
        TConstructHelper.getMeltingAdder(FluidType.getFluidType("Tin"), 200, 288).add(
                GTOreDictUnificator.get(OrePrefixes.ore, Materials.Cassiterite, 1L),
                GTOreDictUnificator.get(OrePrefixes.rawOre, Materials.Cassiterite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Cassiterite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Cassiterite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Cassiterite, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Cassiterite, 1L),
                GTOreDictUnificator.get(OrePrefixes.ore, Materials.CassiteriteSand, 1L),
                GTOreDictUnificator.get(OrePrefixes.rawOre, Materials.CassiteriteSand, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.CassiteriteSand, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreEndstone, Materials.CassiteriteSand, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.CassiteriteSand, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.CassiteriteSand, 1L));
        TConstructHelper.getMeltingAdder(FluidType.getFluidType("Gold"), 200, 144).add(
                new ItemStack(GregTechAPI.sBlockOres1, 1, 86),
                GTOreDictUnificator.get(OrePrefixes.rawOre, Materials.Gold, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Gold, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Gold, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Gold, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Gold, 1L));
        TConstructHelper.getMeltingAdder(FluidType.getFluidType("Aluminum"), 50, 144).add(
                new ItemStack(GregTechAPI.sBlockOres1, 1, 19),
                GTOreDictUnificator.get(OrePrefixes.rawOre, Materials.Aluminium, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Aluminium, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Aluminium, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Aluminium, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Aluminium, 1L));
        TConstructHelper.getMeltingAdder(FluidType.getFluidType("Emerald"), 225, 640).add(
                new ItemStack(GregTechAPI.sBlockOres1, 1, 501),
                GTOreDictUnificator.get(OrePrefixes.rawOre, Materials.Emerald, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Emerald, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Emerald, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Emerald, 1L),
                GTOreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Emerald, 1L));
        TConstructHelper.getMeltingAdder(FluidType.getFluidType("Steel"), 100, 576).add(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Plate.get(1L),
                ItemList.Shape_Mold_Casing.get(1L),
                ItemList.Shape_Mold_Gear.get(1L),
                ItemList.Shape_Mold_Credit.get(1L),
                ItemList.Shape_Mold_Bottle.get(1L),
                ItemList.Shape_Mold_Ingot.get(1L),
                ItemList.Shape_Mold_Ball.get(1L),
                ItemList.Shape_Mold_Block.get(1L),
                ItemList.Shape_Mold_Nugget.get(1L),
                ItemList.Shape_Mold_Bun.get(1L),
                ItemList.Shape_Mold_Bread.get(1L),
                ItemList.Shape_Mold_Baguette.get(1L),
                ItemList.Shape_Mold_Cylinder.get(1L),
                ItemList.Shape_Mold_Anvil.get(1L),
                ItemList.Shape_Mold_Name.get(1L),
                ItemList.Shape_Mold_Arrow.get(1L),
                ItemList.Shape_Mold_Gear_Small.get(1L),
                ItemList.Shape_Mold_Rod.get(1L),
                ItemList.Shape_Mold_Bolt.get(1L),
                ItemList.Shape_Mold_Round.get(1L),
                ItemList.Shape_Mold_Screw.get(1L),
                ItemList.Shape_Mold_Ring.get(1L),
                ItemList.Shape_Mold_Rod_Long.get(1L),
                ItemList.Shape_Mold_Rotor.get(1L),
                ItemList.Shape_Mold_Turbine_Blade.get(1L),
                ItemList.Shape_Mold_Pipe_Tiny.get(1L),
                ItemList.Shape_Mold_Pipe_Small.get(1L),
                ItemList.Shape_Mold_Pipe_Medium.get(1L),
                ItemList.Shape_Mold_Pipe_Large.get(1L),
                ItemList.Shape_Mold_Pipe_Huge.get(1L),
                ItemList.Shape_Extruder_Plate.get(1L),
                ItemList.Shape_Extruder_Rod.get(1L),
                ItemList.Shape_Extruder_Bolt.get(1L),
                ItemList.Shape_Extruder_Ring.get(1L),
                ItemList.Shape_Extruder_Cell.get(1L),
                ItemList.Shape_Extruder_Ingot.get(1L),
                ItemList.Shape_Extruder_Casing.get(1L),
                ItemList.Shape_Extruder_Pipe_Tiny.get(1L),
                ItemList.Shape_Extruder_Pipe_Small.get(1L),
                ItemList.Shape_Extruder_Pipe_Medium.get(1L),
                ItemList.Shape_Extruder_Pipe_Large.get(1L),
                ItemList.Shape_Extruder_Pipe_Huge.get(1L),
                ItemList.Shape_Extruder_Block.get(1L),
                ItemList.Shape_Extruder_Sword.get(1L),
                ItemList.Shape_Extruder_Pickaxe.get(1L),
                ItemList.Shape_Extruder_Shovel.get(1L),
                ItemList.Shape_Extruder_Axe.get(1L),
                ItemList.Shape_Extruder_Hoe.get(1L),
                ItemList.Shape_Extruder_Hammer.get(1L),
                ItemList.Shape_Extruder_File.get(1L),
                ItemList.Shape_Extruder_Saw.get(1L),
                ItemList.Shape_Extruder_Gear.get(1L),
                ItemList.Shape_Extruder_Bottle.get(1L),
                ItemList.Shape_Extruder_Rotor.get(1L),
                ItemList.Shape_Extruder_Small_Gear.get(1L),
                ItemList.Shape_Extruder_Turbine_Blade.get(1L),
                NHItemList.ExtruderShapeBoat.get(1),
                NHItemList.MarshmallowForm.get(),
                NHItemList.MoldChestplate.get(),
                NHItemList.MoldHelmet.get(),
                NHItemList.MoldLeggings.get(),
                NHItemList.MoldBoots.get());
        TConstructHelper.getMeltingAdder(FluidType.getFluidType("Glue"), 125, 144)
                .add(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Rubber, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Rubber, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 1L))
                .withAmount(576).add(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 10, missing)).withAmount(288)
                .add(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8, missing));
        Smeltery.addMelting(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L),
                GameRegistry.findBlock("TConstruct", "GravelOre"),
                5,
                650,
                FluidRegistry.getFluidStack("cobalt.molten", 144));
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(TinkerConstruct.ID, "materials", 1, 12, missing),
                FluidRegistry.getFluidStack("aluminum.molten", 144),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0, missing),
                false,
                200);
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "materials", 1, 12, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                6,
                500,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        TConstructRegistry.getTableCasting().addCastingRecipe(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L),
                FluidRegistry.getFluidStack("steel.molten", 144),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0, missing),
                false,
                800);
        TConstructRegistry.getBasinCasting().addCastingRecipe(
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 4, missing),
                FluidRegistry.getFluidStack("stone.seared", 360),
                null,
                false,
                245);
        TConstructRegistry.getBasinCasting().addCastingRecipe(
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 5, missing),
                FluidRegistry.getFluidStack("stone.seared", 360),
                getModItem(Minecraft.ID, "cobblestone", 1, 0, missing),
                false,
                245);
        TConstructHelper.getMeltingAdder(FluidType.getFluidType("Obsidian"), 100, 288).add(
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 0, missing),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1, missing));
        TConstructRegistry.getBasinCasting().addCastingRecipe(
                getModItem(TinkerConstruct.ID, "MetalBlock", 1, 10, missing),
                FluidRegistry.getFluidStack("ender", 2250),
                null,
                false,
                250);
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "MetalBlock", 1, 10, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                10,
                250,
                FluidRegistry.getFluidStack("ender", 2250));
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "glass_bottle", 1, 0, missing),
                FluidRegistry.getFluidStack("glass.molten", 1000),
                ItemList.Shape_Mold_Bottle.get(1L),
                false,
                200);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorBronzeHelmet", 1, 0, missing),
                FluidRegistry.getFluidStack("bronze.molten", 720),
                NHItemList.MoldHelmet.get(),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorBronzeChestplate", 1, 0, missing),
                FluidRegistry.getFluidStack("bronze.molten", 1152),
                NHItemList.MoldChestplate.get(),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorBronzeLegs", 1, 0, missing),
                FluidRegistry.getFluidStack("bronze.molten", 1008),
                NHItemList.MoldLeggings.get(),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorBronzeBoots", 1, 0, missing),
                FluidRegistry.getFluidStack("bronze.molten", 576),
                NHItemList.MoldBoots.get(),
                false,
                400);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Railcraft.ID, "armor.steel.helmet", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 720),
                NHItemList.MoldHelmet.get(),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Railcraft.ID, "armor.steel.plate", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 1152),
                NHItemList.MoldChestplate.get(),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Railcraft.ID, "armor.steel.legs", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 1008),
                NHItemList.MoldLeggings.get(),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Railcraft.ID, "armor.steel.boots", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldBoots.get(),
                false,
                400);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "iron_helmet", 1, 0, missing),
                FluidRegistry.getFluidStack("iron.molten", 720),
                NHItemList.MoldHelmet.get(),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "iron_chestplate", 1, 0, missing),
                FluidRegistry.getFluidStack("iron.molten", 1152),
                NHItemList.MoldChestplate.get(),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "iron_leggings", 1, 0, missing),
                FluidRegistry.getFluidStack("iron.molten", 1008),
                NHItemList.MoldLeggings.get(),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "iron_boots", 1, 0, missing),
                FluidRegistry.getFluidStack("iron.molten", 576),
                NHItemList.MoldBoots.get(),
                false,
                400);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "golden_helmet", 1, 0, missing),
                FluidRegistry.getFluidStack("gold.molten", 720),
                NHItemList.MoldHelmet.get(),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "golden_chestplate", 1, 0, missing),
                FluidRegistry.getFluidStack("gold.molten", 1152),
                NHItemList.MoldChestplate.get(),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "golden_leggings", 1, 0, missing),
                FluidRegistry.getFluidStack("gold.molten", 1008),
                NHItemList.MoldLeggings.get(),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "golden_boots", 1, 0, missing),
                FluidRegistry.getFluidStack("gold.molten", 576),
                NHItemList.MoldBoots.get(),
                false,
                400);
        Smeltery.addAlloyMixing(
                FluidRegistry.getFluidStack("alumite.molten", TConstruct.nuggetLiquidValue * 2),
                FluidRegistry.getFluidStack("molten.zinc", TConstruct.nuggetLiquidValue * 5),
                FluidRegistry.getFluidStack("steel.molten", TConstruct.nuggetLiquidValue * 2),
                FluidRegistry.getFluidStack("obsidian.molten", TConstruct.nuggetLiquidValue * 2));
        Smeltery.addSmelteryFuel(FluidRegistry.getFluid("ic2hotcoolant"), 900, 55);
        Smeltery.addSmelteryFuel(FluidRegistry.getFluid("ic2pahoehoelava"), 3000, 90);
        DryingRackRecipes.addDryingRecipe(
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                6000,
                getModItem(TinkerConstruct.ID, "jerky", 1, 7, missing));
        DryingRackRecipes.addDryingRecipe(
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing),
                6000,
                getModItem(TinkerConstruct.ID, "jerky", 1, 6, missing));
        DryingRackRecipes.addDryingRecipe(
                getModItem(PamsHarvestCraft.ID, "muttonrawItem", 1, 0, missing),
                12000,
                getModItem(TinkerConstruct.ID, "jerky", 1, 3, missing));

        Recipe.of(getModItem(TinkerConstruct.ID, "materials", 1, 2, missing), NHItemList.UnfiredSearedBrick.get())
                .provideTo(recipe -> GTModHandler.addSmeltingRecipe(recipe.flatten()[0], recipe.getResult()))
                .provideTo(MANTLE.manualSmeltingRecipeNamed("searedbrick"));
        GTModHandler.addSmeltingRecipe(
                NHItemList.UnfiredSlimeSoilBrick.get(),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing));
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "CraftedSoil", 2, 0, missing),
                        ItemList.Shape_Mold_Ball.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 1, missing)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "CraftedSoil", 2, 2, missing),
                        ItemList.Shape_Mold_Ball.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 17, missing)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 9, 32, missing),
                        ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 15, missing)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 9, 27, missing),
                        ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 18, missing)).duration(10 * SECONDS).eut(4)
                .addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 9, 24, missing),
                        ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 14, missing)).duration(10 * SECONDS).eut(2)
                .addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 1, missing),
                        ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 2, missing)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6, missing),
                        ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 37, missing)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "slime.gel", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "mud", 1, 1, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 5, missing)).duration(10 * SECONDS).eut(2)
                .addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 7, 0, missing),
                        getModItem(TinkersMechworks.ID, "LengthWire", 1, 0, missing))
                .circuit(6).itemOutputs(getModItem(TinkerConstruct.ID, "decoration.stoneladder", 4, 0, missing))
                .duration(3 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing)).circuit(16)
                .itemOutputs(getModItem(TinkerConstruct.ID, "jerky", 1, 7, missing)).eut(TierEU.RECIPE_LV)
                .duration(2 * MINUTES).addTo(chemicalDehydratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing)).circuit(16)
                .itemOutputs(getModItem(TinkerConstruct.ID, "jerky", 1, 6, missing)).eut(TierEU.RECIPE_LV)
                .duration(2 * MINUTES).addTo(chemicalDehydratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "muttonrawItem", 1, 0, missing)).circuit(16)
                .itemOutputs(getModItem(TinkerConstruct.ID, "jerky", 1, 3, missing)).eut(TierEU.RECIPE_LV)
                .duration(2 * MINUTES).addTo(chemicalDehydratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.SnowQueenBlood.get(16)).circuit(16)
                .itemOutputs(getModItem(TinkerConstruct.ID, "strangeFood", 16, 1, missing)).eut(TierEU.RECIPE_LV)
                .duration(2 * MINUTES).addTo(chemicalDehydratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0, missing)).circuit(16)
                .itemOutputs(getModItem(WitchingGadgets.ID, "item.WG_MagicFood", 1, 2, missing)).eut(TierEU.RECIPE_LV)
                .duration(2 * MINUTES).addTo(chemicalDehydratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("blood"), 160)).duration(20 * TICKS)
                .eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Block.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 10, missing))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ender"), 2250)).duration(20 * TICKS)
                .eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Block.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "Smeltery", 1, 4, missing))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("stone.seared"), 360)).duration(20 * TICKS)
                .eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

        registerManualIcons();
    }

    private void registerManualIcons() {
        MantleClientRegistry.registerManualIcon("paper", new ItemStack(Items.paper, 64, 0));
        MantleClientRegistry.registerManualIcon("steam_compressor", ItemList.Machine_Bronze_Compressor.get(1));
    }

}
