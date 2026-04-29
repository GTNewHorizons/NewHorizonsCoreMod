package com.dreammaster.scripts;

import static com.dreammaster.scripts.GameRegistryProxy.shapedRecipes;
import static com.dreammaster.scripts.GameRegistryProxy.shapelessRecipes;
import static com.dreammaster.scripts.IngredientFactory.createItemStack;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static com.dreammaster.tinkersConstruct.SmelteryFluidTypes.getMoltenPatternFluidTypeName;
import static gregtech.api.enums.ItemList.Electric_Piston_HV;
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
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.chemicalDehydratorRecipes;

import java.util.ArrayList;
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
import gregtech.GTMod;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.ToolDictNames;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
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
        OreDictionary.registerOre("bucketEnder", getModItem(TinkerConstruct.ID, "buckets", 1, 23));
        OreDictHelper.removeOreDict("nuggetAluminium", getModItem(TinkerConstruct.ID, "oreBerries", 1, 4));

        Recipe.of(
                getModItem(TinkerConstruct.ID, "LavaTank", 1, 0),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterytank1"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "LavaTankNether", 1, 0),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 0),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(Minecraft.ID, "furnace", 1, 0),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterycontroller"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 0),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(Natura.ID, "NetherFurnace", 1, 0),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "Smeltery", 2, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(Minecraft.ID, "water_bucket", 1, 0),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("searedbricks"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Smeltery", 2, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SmelteryNether", 2, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(Minecraft.ID, "lava_bucket", 1, 0),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SmelteryNether", 2, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketLava", 1, 0),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 1),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 0),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterydrain"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 1),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 0),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "SearedBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 4),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                null,
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterytable"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlockNether", 1, 0),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                null,
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "SearedBlock", 1, 2),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                null,
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                null,
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterybasin"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlockNether", 1, 2),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                null,
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                null,
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 0),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("castingchannel"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 1),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlock", 2, 1),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 0));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlockNether", 2, 1),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 1));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "SearedBlock", 1, 1),
                null,
                null,
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2),
                getModItem(TinkerConstruct.ID, "materials", 1, 2)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelteryfaucet"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlockNether", 1, 1),
                null,
                null,
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37),
                getModItem(TinkerConstruct.ID, "materials", 1, 37));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "LavaTank", 1, 1),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                "glassReinforced",
                "blockGlass",
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterytank2"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "LavaTankNether", 1, 1),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                "glassReinforced",
                "blockGlass",
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "LavaTank", 1, 2),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                "blockGlass",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterytank3"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "LavaTankNether", 1, 2),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                "blockGlass",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2));
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "helmetWood", 1, 0),
                new Object[] { "LLL", "LrL", "   ", 'L', "logWood" });
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "chestplateWood", 1, 0),
                new Object[] { "LrL", "LLL", "LLL", 'L', "logWood" });
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "leggingsWood", 1, 0),
                new Object[] { "LLL", "LrL", "L L", 'L', "logWood" });
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "bootsWood", 1, 0),
                new Object[] { "LrL", "L L", "   ", 'L', "logWood" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPane", 2, 0),
                "craftingToolSaw",
                null,
                null,
                null,
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                null);
        Recipe.of(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1),
                "sand",
                "sand",
                "sand",
                "dustClay",
                getModItem(Minecraft.ID, "water_bucket", 1, 0),
                "dustClay",
                getModItem(Minecraft.ID, "gravel", 1, 0),
                getModItem(Minecraft.ID, "gravel", 1, 0),
                getModItem(Minecraft.ID, "gravel", 1, 0)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("grout"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1),
                getModItem(Minecraft.ID, "gravel", 1, 0),
                getModItem(Minecraft.ID, "gravel", 1, 0),
                getModItem(Minecraft.ID, "gravel", 1, 0),
                "dustClay",
                getModItem(Minecraft.ID, "water_bucket", 1, 0),
                "dustClay",
                "sand",
                "sand",
                "sand");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1),
                "sand",
                "dustClay",
                getModItem(Minecraft.ID, "gravel", 1, 0),
                "sand",
                getModItem(Minecraft.ID, "water_bucket", 1, 0),
                getModItem(Minecraft.ID, "gravel", 1, 0),
                "sand",
                "dustClay",
                getModItem(Minecraft.ID, "gravel", 1, 0));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1),
                getModItem(Minecraft.ID, "gravel", 1, 0),
                "dustClay",
                "sand",
                getModItem(Minecraft.ID, "gravel", 1, 0),
                getModItem(Minecraft.ID, "water_bucket", 1, 0),
                "sand",
                getModItem(Minecraft.ID, "gravel", 1, 0),
                "dustClay",
                "sand");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1),
                "sand",
                "sand",
                "sand",
                "dustClay",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0),
                "dustClay",
                getModItem(Minecraft.ID, "gravel", 1, 0),
                getModItem(Minecraft.ID, "gravel", 1, 0),
                getModItem(Minecraft.ID, "gravel", 1, 0));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1),
                getModItem(Minecraft.ID, "gravel", 1, 0),
                getModItem(Minecraft.ID, "gravel", 1, 0),
                getModItem(Minecraft.ID, "gravel", 1, 0),
                "dustClay",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0),
                "dustClay",
                "sand",
                "sand",
                "sand");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1),
                "sand",
                "dustClay",
                getModItem(Minecraft.ID, "gravel", 1, 0),
                "sand",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0),
                getModItem(Minecraft.ID, "gravel", 1, 0),
                "sand",
                "dustClay",
                getModItem(Minecraft.ID, "gravel", 1, 0));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1),
                getModItem(Minecraft.ID, "gravel", 1, 0),
                "dustClay",
                "sand",
                getModItem(Minecraft.ID, "gravel", 1, 0),
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0),
                "sand",
                getModItem(Minecraft.ID, "gravel", 1, 0),
                "dustClay",
                "sand");
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6),
                getModItem(Minecraft.ID, "nether_wart", 1, 0),
                getModItem(Minecraft.ID, "soul_sand", 1, 0),
                getModItem(Minecraft.ID, "gravel", 1, 0),
                getModItem(Minecraft.ID, "water_bucket", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6),
                getModItem(Minecraft.ID, "nether_wart", 1, 0),
                getModItem(Minecraft.ID, "soul_sand", 1, 0),
                getModItem(Minecraft.ID, "gravel", 1, 0),
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6),
                getModItem(Minecraft.ID, "nether_wart", 1, 0),
                getModItem(Natura.ID, "soil.tainted", 1, 0),
                getModItem(Natura.ID, "heatsand", 1, 0),
                getModItem(Minecraft.ID, "water_bucket", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6),
                getModItem(Minecraft.ID, "nether_wart", 1, 0),
                getModItem(Natura.ID, "soil.tainted", 1, 0),
                getModItem(Natura.ID, "heatsand", 1, 0),
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0),
                "platePaper",
                "platePaper",
                "platePaper",
                "platePaper").provideTo(shapelessRecipes())
                .provideTo(MANTLE.manualShapelessCraftingRecipeNamed("blankpattern"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingStation", 1, 0),
                "craftingToolSaw",
                "craftingTableWood");
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 0),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "CraftingStation", 1, 0));
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 0),
                new Object[] { "SPS", "SCS", " r ", 'S', "stickWood", 'P',
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 0), 'C',
                        getModItem(TinkerConstruct.ID, "CraftingStation", 1, 0) });
        Recipe.of(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 0),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0),
                "stickWood",
                "stickWood",
                getModItem(Minecraft.ID, "crafting_table", 1, 0),
                "stickWood",
                null,
                ToolDictNames.craftingToolSoftMallet.name(),
                null).provideTo(shapedRecipes()).provideTo(MANTLE.manualShapedCraftingRecipeNamed("toolstation"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 0));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0),
                "stickWood",
                getModItem(TinkerConstruct.ID, "trap.barricade.oak", 1, 0),
                "stickWood",
                getModItem(TinkerConstruct.ID, "trap.barricade.oak", 1, 0),
                null,
                ToolDictNames.craftingToolSoftMallet.name(),
                null).provideTo(shapedRecipes()).provideTo(MANTLE.manualShapedCraftingRecipeNamed("partcrafter"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1),
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 2));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1),
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 3));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1),
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 4));
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 2),
                new Object[] { "SPS", "BSB", " r ", 'S', "stickWood", 'P',
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 0), 'B',
                        getModItem(TinkerConstruct.ID, "trap.barricade.spruce", 1, 0) });
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 3),
                new Object[] { "SPS", "BSB", " r ", 'S', "stickWood", 'P',
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 0), 'B',
                        getModItem(TinkerConstruct.ID, "trap.barricade.birch", 1, 0) });
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 4),
                new Object[] { "SPS", "BSB", " r ", 'S', "stickWood", 'P',
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 0), 'B',
                        getModItem(TinkerConstruct.ID, "trap.barricade.jungle", 1, 0) });
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 2),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 2),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 2));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 2),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 3));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 2),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 4));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 5),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0),
                "stickWood",
                "stickWood",
                getModItem(Minecraft.ID, "chest", 1, 0),
                "stickWood",
                null,
                ToolDictNames.craftingToolSoftMallet.name(),
                null).provideTo(shapedRecipes()).provideTo(MANTLE.manualShapedCraftingRecipeNamed("patternchest"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 4),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 5));
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10),
                new Object[] { "SPS", "FSF", " r ", 'S', "stickWood", 'P',
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 0), 'F', "fenceWood" });
        Recipe.of(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0),
                "stickWood",
                Blocks.fence,
                "stickWood",
                Blocks.fence,
                null,
                ToolDictNames.craftingToolSoftMallet.name(),
                null).provideTo(MANTLE.manualShapedCraftingRecipeNamed("stenciltable"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10),
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 11));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10),
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 12));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10),
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 13));
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 11),
                new Object[] { "SPS", "FSF", " r ", 'S', "stickWood", 'P',
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 0), 'F',
                        createItemStack(ExtraTrees.ID, "multifence", 1, 16387, "{meta:65537}") });
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 12),
                new Object[] { "SPS", "FSF", " r ", 'S', "stickWood", 'P',
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 0), 'F',
                        createItemStack(ExtraTrees.ID, "multifence", 1, 16387, "{meta:131074}") });
        GTModHandler.addCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 13),
                new Object[] { "SPS", "FSF", " r ", 'S', "stickWood", 'P',
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 0), 'F',
                        createItemStack(ExtraTrees.ID, "multifence", 1, 16387, "{meta:196611}") });
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 3),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 3),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 11));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 3),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 12));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 3),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 13));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                "blockIron",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1),
                "blockIron",
                "blockIron",
                "craftingToolHardHammer",
                "blockIron").provideTo(shapedRecipes()).provideTo(MANTLE.manualShapedCraftingRecipeNamed("toolforge"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 1),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                "blockGold",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1),
                "blockGold",
                "blockGold",
                "craftingToolHardHammer",
                "blockGold");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 2),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                "blockDiamond",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1),
                "blockDiamond",
                "blockDiamond",
                "craftingToolHardHammer",
                "blockDiamond");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 3),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                "blockEmerald",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1),
                "blockEmerald",
                "blockEmerald",
                "craftingToolHardHammer",
                "blockEmerald");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 4),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                "blockCobalt",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1),
                "blockCobalt",
                "blockCobalt",
                "craftingToolHardHammer",
                "blockCobalt");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 5),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                "blockArdite",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1),
                "blockArdite",
                "blockArdite",
                "craftingToolHardHammer",
                "blockArdite");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 6),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                "blockManyullyn",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1),
                "blockManyullyn",
                "blockManyullyn",
                "craftingToolHardHammer",
                "blockManyullyn");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 7),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                "blockCopper",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1),
                "blockCopper",
                "blockCopper",
                "craftingToolHardHammer",
                "blockCopper");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 8),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                "blockBronze",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1),
                "blockBronze",
                "blockBronze",
                "craftingToolHardHammer",
                "blockBronze");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 9),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                "blockTin",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1),
                "blockTin",
                "blockTin",
                "craftingToolHardHammer",
                "blockTin");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 10),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                "blockAluminium",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1),
                "blockAluminium",
                "blockAluminium",
                "craftingToolHardHammer",
                "blockAluminium");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 11),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                "blockAluminiumBrass",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1),
                "blockAluminiumBrass",
                "blockAluminiumBrass",
                "craftingToolHardHammer",
                "blockAluminiumBrass");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 12),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                "blockAlumite",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1),
                "blockAlumite",
                "blockAlumite",
                "craftingToolHardHammer",
                "blockAlumite");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 13),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15),
                "blockSteel",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1),
                "blockSteel",
                "blockSteel",
                "craftingToolHardHammer",
                "blockSteel");
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "FurnaceSlab", 1, 0),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "furnace", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 5),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, wildcard));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 0),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 1),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 4));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 2),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 5));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 3),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 6));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 4),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 8));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 5),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 9));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 6),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 10));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 7),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 11));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 7),
                "craftingToolHardHammer",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 0),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 1),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 1));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 2),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 2));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 3),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 3));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 4),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 4));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 5),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 5));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 6),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 6));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 7),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 7));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "trap.punji", 2, 0),
                getModItem(Minecraft.ID, "reeds", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "reeds", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "reeds", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "reeds", 1, 0),
                "stickWood",
                getModItem(Minecraft.ID, "reeds", 1, 0)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("punji"));
        for (int woolMeta = 0; woolMeta < 8; woolMeta++) {
            GTModHandler.addShapelessCraftingRecipe(
                    getModItem(TinkerConstruct.ID, "WoolSlab1", 2, woolMeta),
                    new Object[] { "craftingToolSaw", getModItem(Minecraft.ID, "wool", 1, woolMeta) });
            GTModHandler.addShapelessCraftingRecipe(
                    getModItem(TinkerConstruct.ID, "WoolSlab2", 2, woolMeta),
                    new Object[] { "craftingToolSaw", getModItem(Minecraft.ID, "wool", 1, woolMeta + 8) });
        }
        Recipe.of(
                getModItem(TinkerConstruct.ID, "trap.barricade.oak", 1, 0),
                null,
                getModItem(Minecraft.ID, "log", 1, 0),
                null,
                getModItem(Minecraft.ID, "log", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "log", 1, 0),
                null,
                getModItem(Minecraft.ID, "log", 1, 0),
                null).provideTo(shapedRecipes()).provideTo(MANTLE.manualShapedCraftingRecipeNamed("barricade"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "trap.barricade.spruce", 1, 0),
                null,
                getModItem(Minecraft.ID, "log", 1, 1),
                null,
                getModItem(Minecraft.ID, "log", 1, 1),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "log", 1, 1),
                null,
                getModItem(Minecraft.ID, "log", 1, 1),
                null);
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "trap.barricade.birch", 1, 0),
                null,
                getModItem(Minecraft.ID, "log", 1, 2),
                null,
                getModItem(Minecraft.ID, "log", 1, 2),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "log", 1, 2),
                null,
                getModItem(Minecraft.ID, "log", 1, 2),
                null);
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "trap.barricade.jungle", 1, 0),
                null,
                getModItem(Minecraft.ID, "log", 1, 3),
                null,
                getModItem(Minecraft.ID, "log", 1, 3),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "log", 1, 3),
                null,
                getModItem(Minecraft.ID, "log", 1, 3),
                null);
        Recipe.of(
                getModItem(TinkerConstruct.ID, "slime.channel", 1, 0),
                "slimeball",
                "slimeball",
                "slimeball",
                "dustRedstone",
                getModItem(Minecraft.ID, "water_bucket", 1, 0),
                "dustRedstone",
                "slimeball",
                "slimeball",
                "slimeball").provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("slimechannel"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "blood.channel", 1, 0),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1),
                "dustRedstone",
                getModItem(Minecraft.ID, "water_bucket", 1, 0),
                "dustRedstone",
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "slime.pad", 1, 0),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 0),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 0),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 0),
                getModItem(TinkerConstruct.ID, "slime.channel", 1, 0),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 1),
                getModItem(TinkerConstruct.ID, "slime.channel", 1, 0)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("bouncepad"));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 0),
                getModItem(Minecraft.ID, "slime_ball", 1, 0),
                getModItem(Minecraft.ID, "slime_ball", 1, 0),
                getModItem(Minecraft.ID, "slime_ball", 1, 0),
                getModItem(Minecraft.ID, "dirt", 1, 0),
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 1),
                getModItem(Minecraft.ID, "dirt", 1, 0),
                getModItem(Minecraft.ID, "slime_ball", 1, 0),
                getModItem(Minecraft.ID, "slime_ball", 1, 0),
                getModItem(Minecraft.ID, "slime_ball", 1, 0)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("slimymud"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 2),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0),
                getModItem(Minecraft.ID, "dirt", 1, 0),
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 1),
                getModItem(Minecraft.ID, "dirt", 1, 0),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 3),
                "dustBone",
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0),
                "dustBone",
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0),
                getModItem(Minecraft.ID, "dirt", 1, 0),
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0),
                "dustBone",
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0),
                "dustBone").provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("graveyardsoil"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeWhite",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeWhite");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 1),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeOrange",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 1),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeOrange");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 2),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeMagenta",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 2),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeMagenta");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 3),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeLightBlue",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 3),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeLightBlue");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 4),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeYellow",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 4),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeYellow");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 5),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeLime",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 5),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeLime");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 6),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyePink",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 6),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyePink");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 7),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeGray",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 7),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeGray");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 8),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeLightGray",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 8),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeLightGray");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 9),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeCyan",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 9),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeCyan");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 10),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyePurple",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 10),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyePurple");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 11),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeBlue",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 11),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeBlue");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 12),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeBrown",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 12),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeBrown");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 13),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeGreen",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 13),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeGreen");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 14),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeRed",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 14),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeRed");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 15),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                "dyeBlack",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 15),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
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
                getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 0),
                "slabWood",
                "slabWood",
                "slabWood",
                "screwWood",
                "craftingToolScrewdriver",
                "screwWood").provideTo(shapedRecipes()).provideTo(MANTLE.manualShapedCraftingRecipeNamed("dryingrack"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 0),
                getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 5));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 5),
                getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 0));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 0),
                getModItem(Minecraft.ID, "repeater", 1, 0),
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0),
                getModItem(Minecraft.ID, "repeater", 1, 0),
                getModItem(Minecraft.ID, "stone", 1, 0),
                getModItem(Railcraft.ID, "detector", 1, 1),
                getModItem(Minecraft.ID, "stone", 1, 0));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 1),
                getModItem(Minecraft.ID, "repeater", 1, 0),
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0),
                getModItem(Minecraft.ID, "repeater", 1, 0),
                getModItem(Minecraft.ID, "stone", 1, 0),
                getModItem(Railcraft.ID, "detector", 1, 3),
                getModItem(Minecraft.ID, "stone", 1, 0));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 2),
                getModItem(Minecraft.ID, "repeater", 1, 0),
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0),
                getModItem(Minecraft.ID, "repeater", 1, 0),
                getModItem(Minecraft.ID, "stone", 1, 0),
                getModItem(Railcraft.ID, "detector", 1, 5),
                getModItem(Minecraft.ID, "stone", 1, 0));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 3),
                getModItem(Minecraft.ID, "repeater", 1, 0),
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0),
                getModItem(Minecraft.ID, "repeater", 1, 0),
                getModItem(Minecraft.ID, "stone", 1, 0),
                getModItem(Railcraft.ID, "detector", 1, 4),
                getModItem(Minecraft.ID, "stone", 1, 0));
        // Obsidian Stick conversions
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "toolRod", 2, 6),
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
                getModItem(RandomThings.ID, "ingredient", 2, 1),
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
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0),
                getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0));
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelGoggles",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:0.0d,Built:1b,MaxDefense:4.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}"),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                "boltElectrum",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                "ringElectrum",
                getModItem(Minecraft.ID, "diamond_helmet", 1, 0),
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
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:4.0d,Built:1b,MaxDefense:10.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}"),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                "circuitAdvanced",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                "plateObsidian",
                getModItem(Minecraft.ID, "diamond_chestplate", 1, 0),
                "plateObsidian",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                "plateObsidian",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0));
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelGlove",
                        1,
                        0,
                        "{TinkerAccessory:{BaseDurability:500,Built:1b,Damage:0,BonusDurability:0,TotalDurability:500,ModDurability:0.0f,Modifiers:5,Broken:0b}}"),
                null,
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                "plateDiamond",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                null,
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                "circuitAdvanced");
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelWings",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:2.0d,Built:1b,MaxDefense:8.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}"),
                "plateDiamond",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                "plateDiamond",
                getModItem(TinkerConstruct.ID, "fletching", 1, 0),
                "circuitAdvanced",
                getModItem(TinkerConstruct.ID, "fletching", 1, 0),
                getModItem(TinkerConstruct.ID, "fletching", 1, 0),
                getModItem(Minecraft.ID, "diamond_leggings", 1, 0),
                getModItem(TinkerConstruct.ID, "fletching", 1, 0));
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelBelt",
                        1,
                        0,
                        "{TinkerAccessory:{BaseDurability:500,Built:1b,Damage:0,BonusDurability:0,TotalDurability:500,ModDurability:0.0f,Modifiers:5,Broken:0b}}"),
                null,
                "circuitAdvanced",
                null,
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                "plateDiamond",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                null,
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0));
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelBoots",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:2.0d,Built:1b,MaxDefense:6.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}"),
                null,
                "plateDiamond",
                "plateDiamond",
                null,
                getModItem(Minecraft.ID, "diamond_boots", 1, 0),
                "circuitAdvanced",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0),
                Electric_Piston_HV.get(1L),
                Electric_Piston_HV.get(1L));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "materials", 1, 3),
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L));
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L),
                getModItem(TinkerConstruct.ID, "materials", 1, 3));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "materials", 1, 5),
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Manyullyn, 1L));
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Manyullyn, 1L),
                getModItem(TinkerConstruct.ID, "materials", 1, 5));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "decoration.stoneladder", 4, 0),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(TinkersMechworks.ID, "LengthWire", 1, 0),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0),
                getModItem(TinkersMechworks.ID, "LengthWire", 1, 0),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "slime_boots", 1, 0),
                getModItem(Backpack.ID, "tannedLeather", 1),
                null,
                getModItem(Backpack.ID, "tannedLeather", 1),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 1),
                getModItem(TinkerConstruct.ID, "materials", 1, 1),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 1),
                getModItem(TinkerConstruct.ID, "slime.pad", 1, 0),
                getModItem(Minecraft.ID, "leather_boots", 1, 0),
                getModItem(TinkerConstruct.ID, "slime.pad", 1, 0));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "slimesling", 1, 0),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 1),
                getModItem(Minecraft.ID, "string", 1, 0),
                null,
                getModItem(TinkerConstruct.ID, "slime.channel", 1, 0),
                getModItem(TinkerConstruct.ID, "materials", 1, 1),
                getModItem(TinkerConstruct.ID, "slime.pad", 1, 0),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 1),
                getModItem(Minecraft.ID, "string", 1, 0),
                null);

        TConstructHelper.removeBasinRecipe(getModItem(Minecraft.ID, "iron_block", 1, 0));
        TConstructHelper.removeBasinRecipe(getModItem(Minecraft.ID, "gold_block", 1, 0));
        TConstructHelper.removeBasinRecipe(getModItem(Minecraft.ID, "obsidian", 1, 0));
        TConstructHelper.removeBasinRecipe(getModItem(Minecraft.ID, "emerald_block", 1, 0));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 0));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 1));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 2));
        TConstructHelper.removeBasinRecipe(getModItem(IndustrialCraft2.ID, "blockMetal", 1, 0));
        TConstructHelper.removeBasinRecipe(getModItem(IndustrialCraft2.ID, "blockMetal", 1, 2));
        TConstructHelper.removeBasinRecipe(getModItem(IndustrialCraft2.ID, "blockMetal", 1, 1));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 6));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 7));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 8));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "GlueBlock", 1, 0));
        TConstructHelper.removeBasinRecipe(GTOreDictUnificator.get(OrePrefixes.block, Materials.PigIron, 1L));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 2));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "Smeltery", 1, 4));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "Smeltery", 1, 5));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 10));
        TConstructHelper.removeMeltingRecipe(new ItemStack(GregTechAPI.sBlockOres1, 1, 33));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "SearedBrick", 1, 1));
        TConstructHelper.removeMeltingRecipe(getModItem(GalaxySpace.ID, "phobosblocks", 1, 4));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "GravelOre", 1, 5));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 39));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "SearedBrick", 1, 2));
        TConstructHelper.removeMeltingRecipe(new ItemStack(GregTechAPI.sBlockOres1, 1, 382));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 38));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ardite, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 29));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.nugget, Materials.Ardite, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 1));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 41));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 30));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.nugget, Materials.Manyullyn, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 2));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 10));
        TConstructHelper.removeTableRecipe(getModItem(BuildCraftCore.ID, "ironGearItem", 1, 0));
        TConstructHelper.removeTableRecipe(getModItem(BuildCraftCore.ID, "goldGearItem", 1, 0));
        TConstructHelper.removeTableRecipe(getModItem(Forestry.ID, "gearBronze", 1, 0));
        TConstructHelper.removeTableRecipe(getModItem(Forestry.ID, "gearCopper", 1, 0));
        TConstructHelper.removeTableRecipe(getModItem(Forestry.ID, "gearTin", 1, 0));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Platinum, 1L));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Nickel, 1L));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Silver, 1L));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Silver, 1L));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Electrum, 1L));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Invar, 1L));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Lead, 1L));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Lead, 1L));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Steel, 1L));
        TConstructHelper.removeTableRecipe(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 0));
        TConstructHelper.removeTableRecipe(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 1));
        TConstructHelper.removeTableRecipe(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 2));
        TConstructHelper.removeTableRecipe(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 3));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "chainmail_helmet", 1, 0));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "chainmail_chestplate", 1, 0));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "chainmail_leggings", 1, 0));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "chainmail_boots", 1, 0));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.nugget, Materials.Cobalt, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 3));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L));
        TConstructHelper.removeMeltingRecipe(new ItemStack(GregTechAPI.sBlockMetal2, 1, 5));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 0));
        TConstructHelper.removeBasinRecipe(getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "sand", 1, 0));
        TConstructHelper.removeSmelterAlloyMix(FluidRegistry.getFluidStack("alumite.molten", 32));
        TConstructHelper.removeSmelterAlloyMix(FluidRegistry.getFluidStack("aluminumbrass.molten", 32));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 1));
        TConstructHelper.removeTableRecipe(getModItem(Minecraft.ID, "golden_apple", 1, 0));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "gearCast", 1, 0));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Enderium, 1L));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Ardite, 1L));
        TConstructHelper.removeTableRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Manyullyn, 1L));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Invar, 1L));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Electrum, 1L));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Platinum, 1L));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Nickel, 1L));
        TConstructHelper.removeMeltingRecipe(GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Enderium, 1L));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 29));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 30));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 4));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 5));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 11));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 22));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "snowball", 1, 0));
        TConstructHelper.removeMeltingRecipe(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 14));
        TConstructHelper.removeMeltingRecipe(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 15));
        TConstructHelper.removeBasinRecipe(getModItem(IndustrialCraft2.ID, "blockMetal", 1, 5));
        TConstructHelper.removeMeltingRecipe(getModItem(Thaumcraft.ID, "ItemNugget", 1, 19));
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
                        getModItem(TinkerConstruct.ID, "oreBerries", 1, 4))
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
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 27),
                false,
                20);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                GTOreDictUnificator.get(OrePrefixes.nugget, Materials.Tin, 1L),
                FluidRegistry.getFluidStack("tin.molten", 16),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 27),
                false,
                20);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                GTOreDictUnificator.get(OrePrefixes.nugget, Materials.Iron, 1),
                FluidRegistry.getFluidStack("iron.molten", 16),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 27),
                false,
                20);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                GTOreDictUnificator.get(OrePrefixes.nugget, Materials.AnyBronze, 1L),
                FluidRegistry.getFluidStack("bronze.molten", 16),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 27),
                false,
                20);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 1L),
                FluidRegistry.getFluidStack("copper.molten", 144),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0),
                false,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 1L),
                FluidRegistry.getFluidStack("tin.molten", 144),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0),
                false,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 1L),
                FluidRegistry.getFluidStack("bronze.molten", 144),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0),
                false,
                100);
        TConstructHelper.getMeltingAdder(FluidType.getFluidType(getMoltenPatternFluidTypeName()), 150, 72).add(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 1),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 2),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 3),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 4),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 5),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 6),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 7),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 8),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 9),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 10),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 11),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 12),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 13),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 14),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 15),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 16),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 17),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 18),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 19),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 20),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 21),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 22),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 25),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 26),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 27),
                getModItem(TinkerConstruct.ID, "Cast", 1, 0),
                getModItem(TinkerConstruct.ID, "Cast", 1, 1),
                getModItem(TinkerConstruct.ID, "Cast", 1, 2),
                getModItem(TinkerConstruct.ID, "Cast", 1, 3));

        // Iron
        List<ItemStack> melterStacksIron = new ArrayList<>();
        addOresForMaterial(Materials.Iron, melterStacksIron);
        addOresForMaterial(Materials.BrownLimonite, melterStacksIron);
        addOresForMaterial(Materials.YellowLimonite, melterStacksIron);
        addOresForMaterial(Materials.BandedIron, melterStacksIron);
        addOresForMaterial(Materials.GraniticMineralSand, melterStacksIron);
        addOresForMaterial(Materials.Magnetite, melterStacksIron);
        addOresForMaterial(Materials.Pyrite, melterStacksIron);
        TConstructHelper.getMeltingAdder(FluidType.getFluidType("Iron"), 100, 144).add(melterStacksIron);

        // Copper
        List<ItemStack> melterStacksCopper = new ArrayList<>();
        addOresForMaterial(Materials.Copper, melterStacksCopper);
        addOresForMaterial(Materials.Malachite, melterStacksCopper);
        addOresForMaterial(Materials.Tetrahedrite, melterStacksCopper);
        addOresForMaterial(Materials.Chalcopyrite, melterStacksCopper);
        TConstructHelper.getMeltingAdder(FluidType.getFluidType("Copper"), 50, 144).add(melterStacksCopper);

        // Tin
        List<ItemStack> melterStacksTin = new ArrayList<>();
        addOresForMaterial(Materials.Tin, melterStacksTin);
        TConstructHelper.getMeltingAdder(FluidType.getFluidType("Tin"), 0, 144).add(melterStacksTin);

        // Cassiterite
        List<ItemStack> melterStacksCassiterite = new ArrayList<>();
        addOresForMaterial(Materials.Cassiterite, melterStacksCassiterite);
        addOresForMaterial(Materials.CassiteriteSand, melterStacksCassiterite);
        TConstructHelper.getMeltingAdder(FluidType.getFluidType("Tin"), 200, 288).add(melterStacksCassiterite);

        // Gold
        List<ItemStack> melterStacksGold = new ArrayList<>();
        addOresForMaterial(Materials.Gold, melterStacksGold);
        TConstructHelper.getMeltingAdder(FluidType.getFluidType("Gold"), 200, 144).add(melterStacksGold);

        // Aluminum
        List<ItemStack> melterStacksAluminum = new ArrayList<>();
        addOresForMaterial(Materials.Aluminium, melterStacksAluminum);
        TConstructHelper.getMeltingAdder(FluidType.getFluidType("Aluminum"), 50, 144).add(melterStacksAluminum);

        // Emerald
        List<ItemStack> melterStacksEmerald = new ArrayList<>();
        addOresForMaterial(Materials.Emerald, melterStacksEmerald);
        TConstructHelper.getMeltingAdder(FluidType.getFluidType("Emerald"), 225, 640).add(melterStacksEmerald);

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
                .withAmount(576).add(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 10)).withAmount(288)
                .add(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8));
        Smeltery.addMelting(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L),
                GameRegistry.findBlock("TConstruct", "GravelOre"),
                5,
                650,
                FluidRegistry.getFluidStack("cobalt.molten", 144));
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(TinkerConstruct.ID, "materials", 1, 12),
                FluidRegistry.getFluidStack("aluminum.molten", 144),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0),
                false,
                200);
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "materials", 1, 12),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                6,
                500,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        TConstructRegistry.getTableCasting().addCastingRecipe(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L),
                FluidRegistry.getFluidStack("steel.molten", 144),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0),
                false,
                800);
        TConstructRegistry.getBasinCasting().addCastingRecipe(
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 4),
                FluidRegistry.getFluidStack("stone.seared", 360),
                null,
                false,
                245);
        TConstructRegistry.getBasinCasting().addCastingRecipe(
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 5),
                FluidRegistry.getFluidStack("stone.seared", 360),
                getModItem(Minecraft.ID, "cobblestone", 1, 0),
                false,
                245);
        TConstructHelper.getMeltingAdder(FluidType.getFluidType("Obsidian"), 100, 288).add(
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1));
        TConstructRegistry.getBasinCasting().addCastingRecipe(
                getModItem(TinkerConstruct.ID, "MetalBlock", 1, 10),
                FluidRegistry.getFluidStack("ender", 2250),
                null,
                false,
                250);
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "MetalBlock", 1, 10),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                10,
                250,
                FluidRegistry.getFluidStack("ender", 2250));
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "glass_bottle", 1, 0),
                FluidRegistry.getFluidStack("glass.molten", 1000),
                ItemList.Shape_Mold_Bottle.get(1L),
                false,
                200);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorBronzeHelmet", 1, 0),
                FluidRegistry.getFluidStack("bronze.molten", 720),
                NHItemList.MoldHelmet.get(),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorBronzeChestplate", 1, 0),
                FluidRegistry.getFluidStack("bronze.molten", 1152),
                NHItemList.MoldChestplate.get(),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorBronzeLegs", 1, 0),
                FluidRegistry.getFluidStack("bronze.molten", 1008),
                NHItemList.MoldLeggings.get(),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorBronzeBoots", 1, 0),
                FluidRegistry.getFluidStack("bronze.molten", 576),
                NHItemList.MoldBoots.get(),
                false,
                400);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Railcraft.ID, "armor.steel.helmet", 1, 0),
                FluidRegistry.getFluidStack("steel.molten", 720),
                NHItemList.MoldHelmet.get(),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Railcraft.ID, "armor.steel.plate", 1, 0),
                FluidRegistry.getFluidStack("steel.molten", 1152),
                NHItemList.MoldChestplate.get(),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Railcraft.ID, "armor.steel.legs", 1, 0),
                FluidRegistry.getFluidStack("steel.molten", 1008),
                NHItemList.MoldLeggings.get(),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Railcraft.ID, "armor.steel.boots", 1, 0),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldBoots.get(),
                false,
                400);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "iron_helmet", 1, 0),
                FluidRegistry.getFluidStack("iron.molten", 720),
                NHItemList.MoldHelmet.get(),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "iron_chestplate", 1, 0),
                FluidRegistry.getFluidStack("iron.molten", 1152),
                NHItemList.MoldChestplate.get(),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "iron_leggings", 1, 0),
                FluidRegistry.getFluidStack("iron.molten", 1008),
                NHItemList.MoldLeggings.get(),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "iron_boots", 1, 0),
                FluidRegistry.getFluidStack("iron.molten", 576),
                NHItemList.MoldBoots.get(),
                false,
                400);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "golden_helmet", 1, 0),
                FluidRegistry.getFluidStack("gold.molten", 720),
                NHItemList.MoldHelmet.get(),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "golden_chestplate", 1, 0),
                FluidRegistry.getFluidStack("gold.molten", 1152),
                NHItemList.MoldChestplate.get(),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "golden_leggings", 1, 0),
                FluidRegistry.getFluidStack("gold.molten", 1008),
                NHItemList.MoldLeggings.get(),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "golden_boots", 1, 0),
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
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1),
                6000,
                getModItem(TinkerConstruct.ID, "jerky", 1, 7));
        DryingRackRecipes.addDryingRecipe(
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0),
                6000,
                getModItem(TinkerConstruct.ID, "jerky", 1, 6));
        DryingRackRecipes.addDryingRecipe(
                getModItem(PamsHarvestCraft.ID, "muttonrawItem", 1, 0),
                12000,
                getModItem(TinkerConstruct.ID, "jerky", 1, 3));

        Recipe.of(getModItem(TinkerConstruct.ID, "materials", 1, 2), NHItemList.UnfiredSearedBrick.get())
                .provideTo(recipe -> GTModHandler.addSmeltingRecipe(recipe.flatten()[0], recipe.getResult()))
                .provideTo(MANTLE.manualSmeltingRecipeNamed("searedbrick"));
        GTModHandler.addSmeltingRecipe(
                NHItemList.UnfiredSlimeSoilBrick.get(),
                getModItem(TinkerConstruct.ID, "materials", 1, 37));
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(TinkerConstruct.ID, "CraftedSoil", 2, 0), ItemList.Shape_Mold_Ball.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 1)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(TinkerConstruct.ID, "CraftedSoil", 2, 2), ItemList.Shape_Mold_Ball.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 17)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(TinkerConstruct.ID, "materials", 9, 32), ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 15)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(TinkerConstruct.ID, "materials", 9, 27), ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 18)).duration(10 * SECONDS).eut(4)
                .addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(TinkerConstruct.ID, "materials", 9, 24), ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 14)).duration(10 * SECONDS).eut(2)
                .addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 1), ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 2)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6), ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 37)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "slime.gel", 1, 0),
                        getModItem(BiomesOPlenty.ID, "mud", 1, 1))
                .itemOutputs(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 5)).duration(10 * SECONDS).eut(2)
                .addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 7, 0),
                        getModItem(TinkersMechworks.ID, "LengthWire", 1, 0))
                .circuit(6).itemOutputs(getModItem(TinkerConstruct.ID, "decoration.stoneladder", 4, 0))
                .duration(3 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "strangeFood", 1, 1)).circuit(16)
                .itemOutputs(getModItem(TinkerConstruct.ID, "jerky", 1, 7)).eut(TierEU.RECIPE_LV).duration(2 * MINUTES)
                .addTo(chemicalDehydratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "strangeFood", 1, 0)).circuit(16)
                .itemOutputs(getModItem(TinkerConstruct.ID, "jerky", 1, 6)).eut(TierEU.RECIPE_LV).duration(2 * MINUTES)
                .addTo(chemicalDehydratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "muttonrawItem", 1, 0)).circuit(16)
                .itemOutputs(getModItem(TinkerConstruct.ID, "jerky", 1, 3)).eut(TierEU.RECIPE_LV).duration(2 * MINUTES)
                .addTo(chemicalDehydratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.SnowQueenBlood.get(16)).circuit(16)
                .itemOutputs(getModItem(TinkerConstruct.ID, "strangeFood", 16, 1)).eut(TierEU.RECIPE_LV)
                .duration(2 * MINUTES).addTo(chemicalDehydratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0)).circuit(16)
                .itemOutputs(getModItem(WitchingGadgets.ID, "item.WG_MagicFood", 1, 2)).eut(TierEU.RECIPE_LV)
                .duration(2 * MINUTES).addTo(chemicalDehydratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "strangeFood", 1, 1))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("blood"), 160)).duration(20 * TICKS)
                .eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Block.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 10))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ender"), 2250)).duration(20 * TICKS)
                .eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Block.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "Smeltery", 1, 4))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("stone.seared"), 360)).duration(20 * TICKS)
                .eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 3))
                .itemOutputs(
                        GregtechItemList.RawHumanMeat.get(4),
                        getModItem(TinkerConstruct.ID, "strangeFood", 2, 1),
                        getModItem(BiomesOPlenty.ID, "misc", 4, 3))
                .outputChances(10000, 2500, 500).duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(maceratorRecipes);

        registerManualIcons();
    }

    private void registerManualIcons() {
        MantleClientRegistry.registerManualIcon("paper", new ItemStack(Items.paper, 64, 0));
        MantleClientRegistry.registerManualIcon("steam_compressor", ItemList.Machine_Bronze_Compressor.get(1));
    }

    private void addOresForMaterial(Materials material, List<ItemStack> stacks) {
        stacks.add(GTOreDictUnificator.get(OrePrefixes.rawOre, material, 1L));
        stacks.add(GTOreDictUnificator.get(OrePrefixes.ore, material, 1L));
        stacks.add(GTOreDictUnificator.get(OrePrefixes.oreNetherrack, material, 1L));
        stacks.add(GTOreDictUnificator.get(OrePrefixes.oreEndstone, material, 1L));
        if (GTMod.proxy.enableBlackGraniteOres) {
            stacks.add(GTOreDictUnificator.get(OrePrefixes.oreBlackgranite, material, 1L));
        }
        if (GTMod.proxy.enableRedGraniteOres) {
            stacks.add(GTOreDictUnificator.get(OrePrefixes.oreRedgranite, material, 1L));
        }
    }

}
