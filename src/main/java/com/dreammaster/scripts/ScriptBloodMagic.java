package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.createItemStack;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.BloodMagic;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.ElectroMagicTools;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.EnderStorage;
import static gregtech.api.enums.Mods.EnderZoo;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.Genetics;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TinkersGregworks;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.block.BlockList;
import com.dreammaster.bloodmagic.BloodMagicHelper;
import com.dreammaster.item.NHItemList;
import com.dreammaster.thaumcraft.TCHelper;

import WayofTime.alchemicalWizardry.api.alchemy.AlchemyRecipeRegistry;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
import WayofTime.alchemicalWizardry.api.bindingRegistry.BindingRegistry;
import WayofTime.alchemicalWizardry.api.bindingRegistry.UnbindingRegistry;
import WayofTime.alchemicalWizardry.api.items.ShapedBloodOrbRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptBloodMagic implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Blood Magic";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                AppliedEnergistics2.ID,
                Avaritia.ID,
                BiomesOPlenty.ID,
                BloodArsenal.ID,
                BloodMagic.ID,
                Botania.ID,
                BuildCraftFactory.ID,
                DraconicEvolution.ID,
                ElectroMagicTools.ID,
                EnderIO.ID,
                EnderStorage.ID,
                EnderZoo.ID,
                ExtraUtilities.ID,
                ForbiddenMagic.ID,
                Genetics.ID,
                IndustrialCraft2.ID,
                IronChests.ID,
                IronTanks.ID,
                Railcraft.ID,
                StevesCarts2.ID,
                Thaumcraft.ID,
                ThaumicBases.ID,
                ThaumicTinkerer.ID,
                TinkerConstruct.ID,
                TinkersGregworks.ID,
                TwilightForest.ID,
                Witchery.ID);
    }

    @Override
    public void loadRecipes() {

        addShapelessRecipe(
                getModItem(BloodMagic.ID, "telepositionFocus", 1, 0),
                getModItem(BloodMagic.ID, "telepositionFocus", 1, 0));
        addShapedRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 3, 2),
                "platePlastic",
                "platePlastic",
                "platePlastic",
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                "platePlastic",
                "platePlastic",
                "platePlastic");
        addShapedRecipe(
                getModItem(BloodMagic.ID, "inputRoutingFocus", 1, 0),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 32),
                getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0));
        addShapelessRecipe(
                getModItem(BloodMagic.ID, "bloodMagicIncenseItem", 1, 0),
                getModItem(Witchery.ID, "ingredient", 1, 18),
                getModItem(Witchery.ID, "ingredient", 1, 18),
                getModItem(Witchery.ID, "ingredient", 1, 18),
                getModItem(Witchery.ID, "ingredient", 1, 18),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.AshDark, 1L),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.AshDark, 1L),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L),
                getModItem(BiomesOPlenty.ID, "misc", 1, 1));
        addShapedRecipe(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellModifier", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                "plateRoseGold",
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 14),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 18),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                "plateRoseGold",
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25));
        addShapedRecipe(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellModifier", 1, 1),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                "plateRoseGold",
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 14),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 19),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                "plateRoseGold",
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25));
        addShapedRecipe(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellModifier", 1, 2),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                "plateRoseGold",
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 14),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 20),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                "plateRoseGold",
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25));
        addShapedRecipe(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellModifier", 1, 3),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                "plateRoseGold",
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 14),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 21),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                "plateRoseGold",
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25));
        addShapedRecipe(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellEffect", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                "plateBlueSteel",
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 14),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 10),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                "plateBlueSteel",
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25));
        addShapedRecipe(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellEffect", 1, 1),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                "plateBlueSteel",
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 14),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 11),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                "plateBlueSteel",
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25));
        addShapedRecipe(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellEffect", 1, 2),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                "plateBlueSteel",
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 14),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 12),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                "plateBlueSteel",
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25));
        addShapedRecipe(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellEffect", 1, 3),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                "plateBlueSteel",
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 14),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 13),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                "plateBlueSteel",
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25));

        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "weakBloodOrb", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "apprenticeBloodOrb", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "archmageBloodOrb", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "transcendentBloodOrb", 1, 0));
        BloodMagicHelper.removeBindingRecipe(getModItem(BloodMagic.ID, "energySword", 1, 0));
        BloodMagicHelper.removeBindingRecipe(getModItem(BloodMagic.ID, "boundPickaxe", 1, 0));
        BloodMagicHelper.removeBindingRecipe(getModItem(BloodMagic.ID, "boundAxe", 1, 0));
        BloodMagicHelper.removeBindingRecipe(getModItem(BloodMagic.ID, "boundShovel", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "blankSlate", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodArsenal.ID, "blood_stone", 1, 1));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "imbuedSlate", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "demonicSlate", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "crystallos", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "sanctus", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "weakFillingAgent", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "alchemyFlask", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "weakBindingAgent", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "standardBindingAgent", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "mundaneLengtheningCatalyst", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "averageLengtheningCatalyst", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "greaterLengtheningCatalyst", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "mundanePowerCatalyst", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "averagePowerCatalyst", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "greaterPowerCatalyst", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "blankSpell", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "aether", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(Minecraft.ID, "web", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 5));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(Minecraft.ID, "leather", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(Minecraft.ID, "fire_charge", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "daggerOfSacrifice", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "incendium", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "magicales", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "crepitous", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "terrae", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "aquasalus", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "tennebrae", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "activationCrystal", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "bloodSocket", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "waterScribeTool", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "fireScribeTool", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "earthScribeTool", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "airScribeTool", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "duskScribeTool", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "dawnScribeTool", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "activationCrystal", 1, 1));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "standardFillingAgent", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "enhancedFillingAgent", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "telepositionFocus", 1, 0));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "enhancedTelepositionFocus", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 4));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "itemComplexSpellCrystal", 1, 0));
        BloodMagicHelper.removeBindingRecipe(getModItem(BloodMagic.ID, "energyBlaster", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 15));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 16));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 30));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 0));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 2));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 7));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8));

        orbRecipes();
        altarAlchemyRecipes();

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "blankSlate", 4, 0),
                        getModItem(BloodMagic.ID, "weakBloodOrb", 0, 0))
                .itemOutputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 1152)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "blankSlate", 4, 0),
                        getModItem(BloodMagic.ID, "apprenticeBloodOrb", 0, 0))
                .itemOutputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 1152)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "blankSlate", 4, 0),
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 0, 0))
                .itemOutputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 1152)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "blankSlate", 4, 0),
                        getModItem(BloodMagic.ID, "masterBloodOrb", 0, 0))
                .itemOutputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 1152)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "blankSlate", 4, 0),
                        getModItem(BloodMagic.ID, "archmageBloodOrb", 0, 0))
                .itemOutputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 1152)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "blankSlate", 4, 0),
                        getModItem(BloodMagic.ID, "transcendentBloodOrb", 0, 0))
                .itemOutputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 1152)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "blankSlate", 4, 0),
                        getModItem(BloodArsenal.ID, "transparent_orb", 0, 0))
                .itemOutputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 1152)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "blankSlate", 4, 0),
                        getModItem(ForbiddenMagic.ID, "EldritchOrb", 0, 0))
                .itemOutputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 1152)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(BloodMagic.ID, "blankSlate", 4, 0), getModItem(Avaritia.ID, "Orb_Armok", 0, 0))
                .itemOutputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 1152)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 0),
                        getModItem(Minecraft.ID, "redstone_torch", 2, 0))
                .itemOutputs(getModItem(BloodMagic.ID, "ritualDismantler", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(BloodMagic.ID, "inputRoutingFocus", 1, 0)).circuit(1)
                .itemOutputs(getModItem(BloodMagic.ID, "outputRoutingFocus", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(BloodMagic.ID, "inputRoutingFocus", 1, 0)).circuit(2)
                .itemOutputs(getModItem(BloodMagic.ID, "outputRoutingFocus", 1, 1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(BloodMagic.ID, "inputRoutingFocus", 1, 0)).circuit(3)
                .itemOutputs(getModItem(BloodMagic.ID, "outputRoutingFocus", 1, 2)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(BloodMagic.ID, "inputRoutingFocus", 1, 0)).circuit(4)
                .itemOutputs(getModItem(BloodMagic.ID, "outputRoutingFocus", 1, 3)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(BloodMagic.ID, "inputRoutingFocus", 1, 0)).circuit(5)
                .itemOutputs(getModItem(BloodMagic.ID, "outputRoutingFocus", 1, 4)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6))
                .itemOutputs(NHItemList.ArcaneSlate.get(9))
                .fluidInputs(FluidRegistry.getFluidStack("lifeessence", 1000)).duration(10 * SECONDS).eut(48)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 0))
                .itemOutputs(getModItem(BloodMagic.ID, "blankSlate", 9, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lifeessence", 1000)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 1))
                .itemOutputs(getModItem(BloodMagic.ID, "reinforcedSlate", 9, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lifeessence", 1000)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 2))
                .itemOutputs(getModItem(BloodMagic.ID, "imbuedSlate", 9, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lifeessence", 1000)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 3))
                .itemOutputs(getModItem(BloodMagic.ID, "demonicSlate", 9, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lifeessence", 1000)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 4))
                .itemOutputs(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 9, 27))
                .fluidInputs(FluidRegistry.getFluidStack("lifeessence", 1000)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_IV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0))
                .itemOutputs(getModItem(BloodMagic.ID, "blankSlate", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lifeessence", 250)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(cutterRecipes);

        TCHelper.removeInfusionRecipe(getModItem(BloodArsenal.ID, "wand_caps", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(BloodArsenal.ID, "wand_cores", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(BloodArsenal.ID, "wand_cores", 1, 1));
        ResearchCategories.registerCategory(
                "BLOODMAGIC",
                new ResourceLocation("dreamcraft:textures/thaumcraft/icon/icon_BloodMagic.png"),
                new ResourceLocation("dreamcraft:textures/thaumcraft/tab/tab_BloodMagic.png"));
        new ResearchItem(
                "BLOODALTAR",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("fames"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                0,
                0,
                3,
                getModItem(BloodMagic.ID, "Altar", 1, 0))
                        .setPages(
                                new ResearchPage("tc.research_page.BLOODALTAR.1"),
                                new ResearchPage("tc.research_page.BLOODALTAR.2"),
                                new ResearchPage("tc.research_page.BLOODALTAR.3"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BLOODALTAR",
                getModItem(BloodMagic.ID, "Altar", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("terra"), 20).add(Aspect.getAspect("aqua"), 20)
                        .add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("perditio"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                'b',
                getModItem(Witchery.ID, "ingredient", 1, 10),
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                'd',
                getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 1),
                'e',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 0),
                'f',
                getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 1),
                'g',
                getModItem(EnderIO.ID, "itemMaterial", 1, 5),
                'h',
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 0),
                'i',
                getModItem(EnderIO.ID, "itemMaterial", 1, 5));
        TCHelper.addResearchPage(
                "BLOODALTAR",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "Altar", 1, 0))));
        TCHelper.addResearchPage("BLOODALTAR", new ResearchPage("tc.research_page.BLOODALTAR.4"));
        ThaumcraftApi.addWarpToResearch("BLOODALTAR", 2);
        new ResearchItem(
                "LIFEINFUSER",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("victus"), 18).add(Aspect.getAspect("alienis"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("auram"), 9)
                        .add(Aspect.getAspect("fames"), 6).add(Aspect.getAspect("terra"), 3),
                -2,
                2,
                3,
                getModItem(BloodArsenal.ID, "life_infuser", 1, 0))
                        .setParents("BLOODALTAR", "INFUSION")
                        .setPages(
                                new ResearchPage("tc.research_page.LIFEINFUSER.1"),
                                new ResearchPage("tc.research_page.LIFEINFUSER.2"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "LIFEINFUSER",
                getModItem(BloodArsenal.ID, "life_infuser", 1, 0),
                5,
                new AspectList().add(Aspect.getAspect("victus"), 32).add(Aspect.getAspect("alienis"), 32)
                        .add(Aspect.getAspect("praecantatio"), 24).add(Aspect.getAspect("auram"), 16)
                        .add(Aspect.getAspect("fames"), 8).add(Aspect.getAspect("terra"), 8),
                getModItem(BloodMagic.ID, "Altar", 1, 0),
                getModItem(Minecraft.ID, "nether_star", 1, 0),
                OrePrefixes.stickLong.get(Materials.BloodInfusedIron),
                OrePrefixes.stickLong.get(Materials.BloodInfusedIron),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                OrePrefixes.stickLong.get(Materials.BloodInfusedIron),
                OrePrefixes.stickLong.get(Materials.BloodInfusedIron));
        TCHelper.addResearchPage(
                "LIFEINFUSER",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "life_infuser", 1, 0))));
        ThaumcraftApi.addWarpToResearch("LIFEINFUSER", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "LIFEINFUSER",
                getModItem(BloodArsenal.ID, "lp_materializer", 1, 0),
                new AspectList().add(Aspect.getAspect("ignis"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("aqua"), 50).add(Aspect.getAspect("ordo"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'b',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                'c',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'd',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                'e',
                getModItem(Minecraft.ID, "nether_star", 1, 0),
                'f',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                'g',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'h',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                'i',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251));
        TCHelper.addResearchPage(
                "LIFEINFUSER",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodArsenal.ID, "lp_materializer", 1, 0))));
        new ResearchItem(
                "SOULCOMPACTER",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("spiritus"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("lucrum"), 9)
                        .add(Aspect.getAspect("vacuos"), 6).add(Aspect.getAspect("cognitio"), 3),
                0,
                -6,
                3,
                getModItem(BloodArsenal.ID, "compacter", 1, 0)).setParents("MASTERRITUALSTONE")
                        .setPages(new ResearchPage("tc.research_page.SOULCOMPACTER")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SOULCOMPACTER",
                getModItem(BloodArsenal.ID, "compacter", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("ignis"), 75)
                        .add(Aspect.getAspect("terra"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0),
                'b',
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0),
                'c',
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0),
                'd',
                getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0),
                'e',
                ItemList.Electric_Piston_IV.get(1L),
                'f',
                getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0),
                'g',
                getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0),
                'h',
                getModItem(BloodMagic.ID, "masterStone", 1, 0),
                'i',
                getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0));
        TCHelper.addResearchPage(
                "SOULCOMPACTER",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodArsenal.ID, "compacter", 1, 0))));
        ThaumcraftApi.addWarpToResearch("SOULCOMPACTER", 3);
        new ResearchItem(
                "SACRIFICIALKNIFE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("telum"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("fames"), 6)
                        .add(Aspect.getAspect("fabrico"), 3),
                2,
                -2,
                3,
                getModItem(BloodMagic.ID, "sacrificialKnife", 1, 0))
                        .setParents("BLOODALTAR")
                        .setPages(
                                new ResearchPage("tc.research_page.SACRIFICIALKNIFE.1"),
                                new ResearchPage("tc.research_page.SACRIFICIALKNIFE.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SACRIFICIALKNIFE",
                getModItem(BloodMagic.ID, "sacrificialKnife", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("perditio"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "screwSteel",
                'b',
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1),
                'c',
                "craftingToolScrewdriver",
                'd',
                "plateAluminium",
                'e',
                getModItem(Botania.ID, "enderDagger", 1, 0),
                'f',
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1),
                'g',
                "stickSteel",
                'h',
                "plateAluminium",
                'i',
                "screwSteel");
        TCHelper.addResearchPage(
                "SACRIFICIALKNIFE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "sacrificialKnife", 1, 0))));
        new ResearchItem(
                "ALCHEMICCHEMSTRYSET",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("fabrico"), 15).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("victus"), 3),
                4,
                -4,
                3,
                getModItem(BloodMagic.ID, "blockWritingTable", 1, 0)).setParents("INFUSION", "SACRIFICIALKNIFE")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.ALCHEMICCHEMSTRYSET.1"),
                                new ResearchPage("tc.research_page.ALCHEMICCHEMSTRYSET.2"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ALCHEMICCHEMSTRYSET",
                getModItem(BloodMagic.ID, "blockWritingTable", 1, 0),
                5,
                new AspectList().add(Aspect.getAspect("fabrico"), 24).add(Aspect.getAspect("instrumentum"), 24)
                        .add(Aspect.getAspect("praecantatio"), 18).add(Aspect.getAspect("victus"), 12)
                        .add(Aspect.getAspect("ignis"), 12),
                getModItem(Minecraft.ID, "brewing_stand", 1, 0),
                Materials.LifeEssence.getCells(1),
                getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                Materials.LifeEssence.getCells(1),
                getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                Materials.LifeEssence.getCells(1),
                getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                Materials.LifeEssence.getCells(1),
                getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                Materials.LifeEssence.getCells(1),
                getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                Materials.LifeEssence.getCells(1),
                getModItem(BloodMagic.ID, "blankSlate", 1, 0));
        TCHelper.addResearchPage(
                "ALCHEMICCHEMSTRYSET",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "blockWritingTable", 1, 0))));
        ThaumcraftApi.addWarpToResearch("ALCHEMICCHEMSTRYSET", 3);
        new ResearchItem(
                "AMORPHICCATALYST",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("aqua"), 18).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 12).add(Aspect.getAspect("aer"), 9)
                        .add(Aspect.getAspect("ordo"), 6).add(Aspect.getAspect("perditio"), 3),
                6,
                -4,
                3,
                getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0)).setParents("INFUSION", "ALCHEMICCHEMSTRYSET")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.AMORPHICCATALYST"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "AMORPHICCATALYST",
                getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0),
                5,
                new AspectList().add(Aspect.getAspect("aqua"), 16).add(Aspect.getAspect("ignis"), 16)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("aer"), 16)
                        .add(Aspect.getAspect("ordo"), 16).add(Aspect.getAspect("perditio"), 16),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0),
                getModItem(BloodMagic.ID, "aether", 1, 0),
                getModItem(BloodMagic.ID, "terrae", 1, 0),
                getModItem(BloodMagic.ID, "crystallos", 1, 0),
                getModItem(BloodMagic.ID, "sanctus", 1, 0),
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                getModItem(BloodMagic.ID, "crepitous", 1, 0),
                getModItem(BloodMagic.ID, "incendium", 1, 0),
                getModItem(BloodMagic.ID, "aquasalus", 1, 0),
                getModItem(BloodMagic.ID, "tennebrae", 1, 0));
        TCHelper.addResearchPage(
                "AMORPHICCATALYST",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0))));
        ThaumcraftApi.addWarpToResearch("AMORPHICCATALYST", 2);
        new ResearchItem(
                "BIDIAMONDBLOCK",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("aqua"), 18).add(Aspect.getAspect("ignis"), 24)
                        .add(Aspect.getAspect("victus"), 12).add(Aspect.getAspect("ira"), 6)
                        .add(Aspect.getAspect("perditio"), 3),
                8,
                -4,
                3,
                getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0))
                        .setParents("INFUSION", "AMORPHICCATALYST").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.BIDIAMONDBLOCK")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "BIDIAMONDBLOCK",
                getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0),
                7,
                new AspectList().add(Aspect.getAspect("ira"), 32).add(Aspect.getAspect("alienis"), 16)
                        .add(Aspect.getAspect("victus"), 24).add(Aspect.getAspect("ignis"), 48)
                        .add(Aspect.getAspect("aqua"), 64).add(Aspect.getAspect("perditio"), 16),
                getModItem(Botania.ID, "storage", 1, 3),
                getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0));
        TCHelper.addResearchPage(
                "BIDIAMONDBLOCK",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0))));
        ThaumcraftApi.addWarpToResearch("BIDIAMONDBLOCK", 3);
        new ResearchItem(
                "DIVINATIONSIGIL",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("metallum"), 3),
                0,
                2,
                3,
                getModItem(BloodMagic.ID, "divinationSigil", 1, 0)).setParents("INFUSION", "NITOR", "BLOODALTAR")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.DIVINATIONSIGIL.1"),
                                new ResearchPage("tc.research_page.DIVINATIONSIGIL.2"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "DIVINATIONSIGIL",
                getModItem(BloodMagic.ID, "divinationSigil", 1, 0),
                3,
                new AspectList().add(Aspect.getAspect("vitreus"), 24).add(Aspect.getAspect("terra"), 18)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("instrumentum"), 6)
                        .add(Aspect.getAspect("metallum"), 4),
                getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0));
        TCHelper.addResearchPage(
                "DIVINATIONSIGIL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "divinationSigil", 1, 0))));
        new ResearchItem(
                "SPEEDRUNE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("motus"), 15).add(Aspect.getAspect("volatus"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("fames"), 3),
                -2,
                0,
                3,
                getModItem(BloodMagic.ID, "speedRune", 1, 0))
                        .setParents("INFUSION", "BLOODALTAR").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.SPEEDRUNE.1"),
                                new ResearchPage("tc.research_page.SPEEDRUNE.2"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SPEEDRUNE",
                getModItem(BloodMagic.ID, "speedRune", 1, 0),
                4,
                new AspectList().add(Aspect.getAspect("motus"), 24).add(Aspect.getAspect("volatus"), 24)
                        .add(Aspect.getAspect("potentia"), 18).add(Aspect.getAspect("aer"), 12)
                        .add(Aspect.getAspect("fames"), 4),
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0),
                getModItem(BloodMagic.ID, "aether", 1, 0),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                getModItem(BloodMagic.ID, "aether", 1, 0),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0));
        TCHelper.addResearchPage(
                "SPEEDRUNE",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "speedRune", 1, 0))));
        new ResearchItem(
                "IMPERFECTRITUALSTONE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("tenebrae"), 3),
                -2,
                -2,
                3,
                getModItem(BloodMagic.ID, "imperfectRitualStone", 1, 0))
                        .setParents("BLOODALTAR")
                        .setPages(
                                new ResearchPage("tc.research_page.IMPERFECTRITUALSTONE.1"),
                                new ResearchPage("tc.research_page.IMPERFECTRITUALSTONE.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IMPERFECTRITUALSTONE",
                getModItem(BloodMagic.ID, "imperfectRitualStone", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 1).add(Aspect.getAspect("ignis"), 6)
                        .add(Aspect.getAspect("terra"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "obsidian", 1, 0),
                'b',
                getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                'c',
                getModItem(Minecraft.ID, "obsidian", 1, 0),
                'd',
                getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                'e',
                getModItem(BloodArsenal.ID, "blood_stone", 1, 0),
                'f',
                getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                'g',
                getModItem(Minecraft.ID, "obsidian", 1, 0),
                'h',
                getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                'i',
                getModItem(Minecraft.ID, "obsidian", 1, 0));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IMPERFECTRITUALSTONE",
                getModItem(BloodMagic.ID, "imperfectRitualStone", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 2).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("terra"), 16),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Minecraft.ID, "obsidian", 1, 0),
                'd',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                'e',
                getModItem(Railcraft.ID, "brick.bloodstained", 1, 2),
                'f',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                'h',
                getModItem(Minecraft.ID, "obsidian", 1, 0));
        TCHelper.addResearchPage(
                "IMPERFECTRITUALSTONE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "imperfectRitualStone", 1, 0))));
        new ResearchItem(
                "RITUALSTONE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("aer"), 3),
                -2,
                -4,
                3,
                getModItem(BloodMagic.ID, "ritualStone", 1, 0)).setParents("INFUSION", "IMPERFECTRITUALSTONE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.RITUALSTONE"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "RITUALSTONE",
                getModItem(BloodMagic.ID, "ritualStone", 1, 0),
                6,
                new AspectList().add(Aspect.getAspect("terra"), 12).add(Aspect.getAspect("ignis"), 9)
                        .add(Aspect.getAspect("tenebrae"), 6).add(Aspect.getAspect("praecantatio"), 3)
                        .add(Aspect.getAspect("aer"), 2),
                getModItem(BloodMagic.ID, "imperfectRitualStone", 1, 0),
                getModItem(BloodMagic.ID, "terrae", 1, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                getModItem(BloodMagic.ID, "terrae", 1, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RITUALSTONE",
                getModItem(BloodMagic.ID, "ritualStone", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 3).add(Aspect.getAspect("ignis"), 18)
                        .add(Aspect.getAspect("terra"), 24),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "obsidian", 1, 0),
                'b',
                getModItem(BloodMagic.ID, "terrae", 1, 0),
                'c',
                getModItem(Minecraft.ID, "obsidian", 1, 0),
                'd',
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                'e',
                getModItem(BloodMagic.ID, "imperfectRitualStone", 1, 0),
                'f',
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                'g',
                getModItem(Minecraft.ID, "obsidian", 1, 0),
                'h',
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                'i',
                getModItem(Minecraft.ID, "obsidian", 1, 0));
        TCHelper.addResearchPage(
                "RITUALSTONE",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "ritualStone", 1, 0))));
        ThaumcraftApi.addWarpToResearch("RITUALSTONE", 1);
        new ResearchItem(
                "SPELLTABLE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("terra"), 18).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("tenebrae"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("infernus"), 3),
                -4,
                -4,
                3,
                getModItem(BloodMagic.ID, "blockHomHeart", 1, 0)).setParents("INFUSION", "RITUALSTONE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.SPELLTABLE")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SPELLTABLE",
                getModItem(BloodMagic.ID, "blockHomHeart", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 40).add(Aspect.getAspect("ignis"), 40)
                        .add(Aspect.getAspect("terra"), 40).add(Aspect.getAspect("aqua"), 40)
                        .add(Aspect.getAspect("ordo"), 40).add(Aspect.getAspect("perditio"), 40),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "largeBloodStoneBrick", 1, 0),
                'b',
                getModItem(BloodMagic.ID, "largeBloodStoneBrick", 1, 0),
                'c',
                getModItem(BloodMagic.ID, "largeBloodStoneBrick", 1, 0),
                'd',
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1),
                'e',
                ItemList.Cover_Crafting.get(1L),
                'f',
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1),
                'g',
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1),
                'h',
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1),
                'i',
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1));
        TCHelper.addResearchPage(
                "SPELLTABLE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "blockHomHeart", 1, 0))));
        ThaumcraftApi.addWarpToResearch("SPELLTABLE", 4);
        new ResearchItem(
                "MASTERRITUALSTONE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("terra"), 18).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("tenebrae"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("aer"), 6),
                -2,
                -6,
                3,
                getModItem(BloodMagic.ID, "masterStone", 1, 0)).setParents("INFUSION", "RITUALSTONE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.MASTERRITUALSTONE")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "MASTERRITUALSTONE",
                getModItem(BloodMagic.ID, "masterStone", 1, 0),
                8,
                new AspectList().add(Aspect.getAspect("terra"), 36).add(Aspect.getAspect("ignis"), 24)
                        .add(Aspect.getAspect("tenebrae"), 16).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("cognitio"), 8),
                getModItem(BloodMagic.ID, "ritualStone", 1, 0),
                getModItem(BloodMagic.ID, "terrae", 1, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 0),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1),
                getModItem(BloodMagic.ID, "terrae", 1, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 0),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1));
        TCHelper.addResearchPage(
                "MASTERRITUALSTONE",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "masterStone", 1, 0))));
        ThaumcraftApi.addWarpToResearch("MASTERRITUALSTONE", 2);
        new ResearchItem(
                "WATERSIGIL",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("metallum"), 3),
                0,
                4,
                3,
                getModItem(BloodMagic.ID, "waterSigil", 1, 0)).setParents("INFUSION", "DIVINATIONSIGIL").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.WATERSIGIL")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "WATERSIGIL",
                getModItem(BloodMagic.ID, "waterSigil", 1, 0),
                5,
                new AspectList().add(Aspect.getAspect("aqua"), 40).add(Aspect.getAspect("terra"), 32)
                        .add(Aspect.getAspect("praecantatio"), 24).add(Aspect.getAspect("instrumentum"), 16)
                        .add(Aspect.getAspect("metallum"), 8),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                getModItem(Witchery.ID, "divinerwater", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 1),
                getModItem(BloodMagic.ID, "aquasalus", 1, 0),
                getModItem(BloodMagic.ID, "aquasalus", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 1),
                getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 1),
                getModItem(BloodMagic.ID, "aquasalus", 1, 0),
                getModItem(BloodMagic.ID, "aquasalus", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 1));
        TCHelper.addResearchPage(
                "WATERSIGIL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "waterSigil", 1, 0))));
        ThaumcraftApi.addWarpToResearch("WATERSIGIL", 2);
        new ResearchItem(
                "LAVASIGIL",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("metallum"), 3),
                0,
                8,
                3,
                getModItem(BloodMagic.ID, "lavaSigil", 1, 0)).setParents("INFUSION", "SIGILOFTHEBLOODLAMP")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.LAVASIGIL")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "LAVASIGIL",
                getModItem(BloodMagic.ID, "lavaSigil", 1, 0),
                7,
                new AspectList().add(Aspect.getAspect("ignis"), 64).add(Aspect.getAspect("terra"), 40)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("instrumentum"), 24)
                        .add(Aspect.getAspect("metallum"), 16),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(Witchery.ID, "divinerlava", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 2),
                getModItem(BloodMagic.ID, "incendium", 1, 0),
                getModItem(BloodMagic.ID, "incendium", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 2),
                getModItem(BloodMagic.ID, "lavaCrystal", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 2),
                getModItem(BloodMagic.ID, "incendium", 1, 0),
                getModItem(BloodMagic.ID, "incendium", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 2));
        TCHelper.addResearchPage(
                "LAVASIGIL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "lavaSigil", 1, 0))));
        ThaumcraftApi.addWarpToResearch("LAVASIGIL", 4);
        new ResearchItem(
                "EMPTYCORE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("metallum"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                0,
                -2,
                3,
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1)).setParents("INFUSION", "BLOODALTAR")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.EMPTYCORE")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "EMPTYCORE",
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("perditio"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                'b',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                'd',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1L),
                'e',
                getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0),
                'f',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1L),
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                'h',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2));
        TCHelper.addResearchPage(
                "EMPTYCORE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1))));
        new ResearchItem(
                "BMLAVACRYSTAL",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("infernus"), 12)
                        .add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("aer"), 3),
                0,
                -4,
                3,
                getModItem(BloodMagic.ID, "lavaCrystal", 1, 0))
                        .setParents("INFUSION", "EMPTYCORE", "LAVACRYSTAL", "WARDEDARCANA").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.BMLAVACRYSTAL")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "BMLAVACRYSTAL",
                getModItem(BloodMagic.ID, "lavaCrystal", 1, 0),
                4,
                new AspectList().add(Aspect.getAspect("ignis"), 24).add(Aspect.getAspect("terra"), 18)
                        .add(Aspect.getAspect("praecantatio"), 18).add(Aspect.getAspect("infernus"), 6)
                        .add(Aspect.getAspect("aer"), 6),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1),
                getModItem(TinkerConstruct.ID, "materials", 1, 7),
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                OrePrefixes.gemFlawless.get(Materials.Diamond),
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2));
        TCHelper.addResearchPage(
                "BMLAVACRYSTAL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "lavaCrystal", 1, 0))));
        new ResearchItem(
                "RUNESACRIFICE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("fames"), 15).add(Aspect.getAspect("infernus"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                -4,
                0,
                3,
                getModItem(BloodMagic.ID, "runeOfSacrifice", 1, 0)).setParents("INFUSION", "SPEEDRUNE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.RUNESACRIFICE")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "RUNESACRIFICE",
                getModItem(BloodMagic.ID, "runeOfSacrifice", 1, 0),
                5,
                new AspectList().add(Aspect.getAspect("fames"), 24).add(Aspect.getAspect("infernus"), 24)
                        .add(Aspect.getAspect("potentia"), 18).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("terra"), 4),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1),
                getModItem(BloodMagic.ID, "tennebrae", 1, 0),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(BloodMagic.ID, "incendium", 1, 0),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(BloodMagic.ID, "tennebrae", 1, 0),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(BloodMagic.ID, "incendium", 1, 0),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0));
        TCHelper.addResearchPage(
                "RUNESACRIFICE",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "runeOfSacrifice", 1, 0))));
        new ResearchItem(
                "RUNESELFSACRIFICE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("fames"), 15).add(Aspect.getAspect("infernus"), 12)
                        .add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                -4,
                2,
                3,
                getModItem(BloodMagic.ID, "runeOfSelfSacrifice", 1, 0)).setParents("INFUSION", "SPEEDRUNE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.RUNESELFSACRIFICE"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "RUNESELFSACRIFICE",
                getModItem(BloodMagic.ID, "runeOfSelfSacrifice", 1, 0),
                5,
                new AspectList().add(Aspect.getAspect("fames"), 24).add(Aspect.getAspect("infernus"), 24)
                        .add(Aspect.getAspect("lucrum"), 18).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("terra"), 4),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1),
                getModItem(BloodMagic.ID, "tennebrae", 1, 0),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(BloodMagic.ID, "sanctus", 1, 0),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(BloodMagic.ID, "tennebrae", 1, 0),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(BloodMagic.ID, "sanctus", 1, 0),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0));
        TCHelper.addResearchPage(
                "RUNESELFSACRIFICE",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "runeOfSelfSacrifice", 1, 0))));
        new ResearchItem(
                "AIRSIGIL",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("volatus"), 21).add(Aspect.getAspect("aer"), 18)
                        .add(Aspect.getAspect("motus"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("iter"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("cognitio"), 3),
                0,
                10,
                3,
                getModItem(BloodMagic.ID, "airSigil", 1, 0)).setParents("INFUSION", "LAVASIGIL").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.AIRSIGIL")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "AIRSIGIL",
                getModItem(BloodMagic.ID, "airSigil", 1, 0),
                9,
                new AspectList().add(Aspect.getAspect("volatus"), 64).add(Aspect.getAspect("aer"), 48)
                        .add(Aspect.getAspect("motus"), 32).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("iter"), 18).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("cognitio"), 6),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(Minecraft.ID, "ghast_tear", 1, 0),
                getModItem(BloodMagic.ID, "aether", 1, 0),
                OrePrefixes.cell.get(Materials.Helium),
                getModItem(BloodMagic.ID, "aether", 1, 0),
                OrePrefixes.cell.get(Materials.Helium),
                getModItem(BloodMagic.ID, "aether", 1, 0),
                getModItem(Minecraft.ID, "ghast_tear", 1, 0),
                getModItem(BloodMagic.ID, "aether", 1, 0),
                OrePrefixes.cell.get(Materials.Helium),
                getModItem(BloodMagic.ID, "aether", 1, 0),
                OrePrefixes.cell.get(Materials.Helium),
                getModItem(BloodMagic.ID, "aether", 1, 0));
        TCHelper.addResearchPage(
                "AIRSIGIL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "airSigil", 1, 0))));
        ThaumcraftApi.addWarpToResearch("AIRSIGIL", 6);
        new ResearchItem(
                "FASTERMINING",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("perfodio"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("metallum"), 6)
                        .add(Aspect.getAspect("motus"), 3),
                -2,
                4,
                3,
                getModItem(BloodMagic.ID, "sigilOfTheFastMiner", 1, 0)).setParents("INFUSION", "DIVINATIONSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.FASTERMINING"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "FASTERMINING",
                getModItem(BloodMagic.ID, "sigilOfTheFastMiner", 1, 0),
                5,
                new AspectList().add(Aspect.getAspect("instrumentum"), 36).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("metallum"), 18).add(Aspect.getAspect("perfodio"), 12)
                        .add(Aspect.getAspect("motus"), 8),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                getModItem(Thaumcraft.ID, "ItemPickThaumium", 1, 0),
                getModItem(BloodMagic.ID, "aether", 1, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                getModItem(Thaumcraft.ID, "ItemShovelThaumium", 1, 0),
                getModItem(BloodMagic.ID, "aether", 1, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                getModItem(Thaumcraft.ID, "ItemAxeThaumium", 1, 0),
                getModItem(BloodMagic.ID, "aether", 1, 0));
        TCHelper.addResearchPage(
                "FASTERMINING",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "sigilOfTheFastMiner", 1, 0))));
        ThaumcraftApi.addWarpToResearch("FASTERMINING", 2);
        new ResearchItem(
                "GREENGROW",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("herba"), 9).add(Aspect.getAspect("arbor"), 6)
                        .add(Aspect.getAspect("victus"), 3),
                2,
                4,
                3,
                getModItem(BloodMagic.ID, "growthSigil", 1, 0)).setParents("INFUSION", "DIVINATIONSIGIL").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.GREENGROW")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "GREENGROW",
                getModItem(BloodMagic.ID, "growthSigil", 1, 0),
                5,
                new AspectList().add(Aspect.getAspect("instrumentum"), 36).add(Aspect.getAspect("terra"), 24)
                        .add(Aspect.getAspect("herba"), 18).add(Aspect.getAspect("arbor"), 12)
                        .add(Aspect.getAspect("victus"), 8),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                getModItem(Witchery.ID, "witchsapling", 1, 0),
                getModItem(BloodMagic.ID, "terrae", 1, 0),
                getModItem(Witchery.ID, "witchsapling", 1, 1),
                getModItem(BloodMagic.ID, "terrae", 1, 0),
                getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 1),
                getModItem(BloodMagic.ID, "terrae", 1, 0),
                getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 0),
                getModItem(BloodMagic.ID, "terrae", 1, 0),
                getModItem(TinkerConstruct.ID, "slime.sapling", 1, 0),
                getModItem(BloodMagic.ID, "terrae", 1, 0));
        TCHelper.addResearchPage(
                "GREENGROW",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "growthSigil", 1, 0))));
        ThaumcraftApi.addWarpToResearch("GREENGROW", 2);
        new ResearchItem(
                "VOIDSIGIL",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vacuos"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("metallum"), 3),
                -2,
                6,
                3,
                getModItem(BloodMagic.ID, "voidSigil", 1, 0)).setParents("INFUSION", "WATERSIGIL").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.VOIDSIGIL")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "VOIDSIGIL",
                getModItem(BloodMagic.ID, "voidSigil", 1, 0),
                7,
                new AspectList().add(Aspect.getAspect("vacuos"), 64).add(Aspect.getAspect("terra"), 40)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("auram"), 24)
                        .add(Aspect.getAspect("metallum"), 16),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Minecraft.ID, "bucket", 1, 0),
                getModItem(BloodMagic.ID, "tennebrae", 1, 0),
                getModItem(Minecraft.ID, "bucket", 1, 0),
                getModItem(BloodMagic.ID, "tennebrae", 1, 0),
                getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0),
                getModItem(BloodMagic.ID, "tennebrae", 1, 0),
                getModItem(Minecraft.ID, "bucket", 1, 0),
                getModItem(BloodMagic.ID, "tennebrae", 1, 0),
                getModItem(Minecraft.ID, "bucket", 1, 0),
                OrePrefixes.plate.get(Materials.Void));
        TCHelper.addResearchPage(
                "VOIDSIGIL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "voidSigil", 1, 0))));
        ThaumcraftApi.addWarpToResearch("VOIDSIGIL", 4);
        new ResearchItem(
                "SIGILOFSWIMMING",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("aer"), 21).add(Aspect.getAspect("aqua"), 18)
                        .add(Aspect.getAspect("vacuos"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("metallum"), 3),
                -4,
                8,
                3,
                getModItem(BloodArsenal.ID, "sigil_of_swimming", 1, 0)).setParents("INFUSION", "VOIDSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFSWIMMING"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SIGILOFSWIMMING",
                getModItem(BloodArsenal.ID, "sigil_of_swimming", 1, 0),
                12,
                new AspectList().add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("aqua"), 64)
                        .add(Aspect.getAspect("vacuos"), 64).add(Aspect.getAspect("terra"), 48)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("auram"), 24)
                        .add(Aspect.getAspect("metallum"), 16),
                getModItem(BloodMagic.ID, "voidSigil", 1, 0),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                Materials.FishOil.getCells(1),
                Materials.LiquidOxygen.getCells(1),
                Materials.FishOil.getCells(1),
                Materials.LiquidOxygen.getCells(1),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                Materials.LiquidOxygen.getCells(1),
                Materials.FishOil.getCells(1),
                Materials.LiquidOxygen.getCells(1),
                Materials.FishOil.getCells(1));
        TCHelper.addResearchPage(
                "SIGILOFSWIMMING",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "sigil_of_swimming", 1, 0))));
        ThaumcraftApi.addWarpToResearch("SIGILOFSWIMMING", 6);
        new ResearchItem(
                "BLOODLETTERSPACK",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("telum"), 15).add(Aspect.getAspect("sano"), 12)
                        .add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("tutamen"), 6)
                        .add(Aspect.getAspect("pannus"), 3),
                2,
                -4,
                3,
                getModItem(BloodMagic.ID, "itemBloodPack", 1, 0))
                        .setParents("SACRIFICIALKNIFE").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.BLOODLETTERSPACK.1"),
                                new ResearchPage("tc.research_page.BLOODLETTERSPACK.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BLOODLETTERSPACK",
                getModItem(BloodMagic.ID, "itemBloodPack", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 30).add(Aspect.getAspect("aqua"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                'b',
                getModItem(BloodMagic.ID, "sacrificialKnife", 1, 0),
                'c',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                'd',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                'e',
                getModItem(Thaumcraft.ID, "ItemChestplateThaumium", 1, 0),
                'f',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                'g',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                'h',
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                'i',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0));
        TCHelper.addResearchPage(
                "BLOODLETTERSPACK",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "itemBloodPack", 1, 0))));
        new ResearchItem(
                "IMBUEARMOR",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("sano"), 15).add(Aspect.getAspect("tutamen"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("metallum"), 6)
                        .add(Aspect.getAspect("potentia"), 3),
                4,
                -6,
                3,
                createItemStack(BloodArsenal.ID, "life_imbued_chestplate", 1, 0, "{LPStored:0}"))
                        .setParents("BLOODLETTERSPACK").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.IMBUEARMOR")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IMBUEARMOR",
                createItemStack(BloodArsenal.ID, "life_imbued_helmet", 1, 0, "{LPStored:0}"),
                new AspectList().add(Aspect.getAspect("terra"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'b',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'c',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'd',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'e',
                getModItem(Thaumcraft.ID, "ItemHelmetThaumium", 1, 0),
                'f',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'h',
                "craftingToolHardHammer");
        TCHelper.addResearchPage(
                "IMBUEARMOR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack(BloodArsenal.ID, "life_imbued_helmet", 1, 0, "{LPStored:0}"))));
        ThaumcraftApi.addWarpToResearch("IMBUEARMOR", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IMBUEARMOR",
                createItemStack(BloodArsenal.ID, "life_imbued_chestplate", 1, 0, "{LPStored:0}"),
                new AspectList().add(Aspect.getAspect("terra"), 60).add(Aspect.getAspect("ignis"), 60)
                        .add(Aspect.getAspect("ordo"), 60).add(Aspect.getAspect("perditio"), 60),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'b',
                getModItem(Thaumcraft.ID, "ItemChestplateThaumium", 1, 0),
                'c',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'd',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'e',
                "craftingToolHardHammer",
                'f',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'g',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'h',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'i',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251));
        TCHelper.addResearchPage(
                "IMBUEARMOR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack(BloodArsenal.ID, "life_imbued_chestplate", 1, 0, "{LPStored:0}"))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IMBUEARMOR",
                createItemStack(BloodArsenal.ID, "life_imbued_leggings", 1, 0, "{LPStored:0}"),
                new AspectList().add(Aspect.getAspect("terra"), 45).add(Aspect.getAspect("ignis"), 45)
                        .add(Aspect.getAspect("ordo"), 45).add(Aspect.getAspect("perditio"), 45),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'b',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'c',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'd',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'e',
                getModItem(Thaumcraft.ID, "ItemLeggingsThaumium", 1, 0),
                'f',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'g',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'h',
                "craftingToolHardHammer",
                'i',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251));
        TCHelper.addResearchPage(
                "IMBUEARMOR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack(BloodArsenal.ID, "life_imbued_leggings", 1, 0, "{LPStored:0}"))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IMBUEARMOR",
                createItemStack(BloodArsenal.ID, "life_imbued_boots", 1, 0, "{LPStored:0}"),
                new AspectList().add(Aspect.getAspect("terra"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'd',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'e',
                getModItem(Thaumcraft.ID, "ItemBootsThaumium", 1, 0),
                'f',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'g',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251),
                'h',
                "craftingToolHardHammer",
                'i',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251));
        TCHelper.addResearchPage(
                "IMBUEARMOR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack(BloodArsenal.ID, "life_imbued_boots", 1, 0, "{LPStored:0}"))));
        new ResearchItem(
                "WEAKORB",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                2,
                0,
                2,
                NHItemList.WeakOrb.get())
                        .setParents("BLOODALTAR").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.WEAKORB.1"),
                                new ResearchPage("tc.research_page.WEAKORB.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "WEAKORB",
                NHItemList.WeakOrb.get(),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("aqua"), 20)
                        .add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("perditio"), 20).add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Botania.ID, "manaResource", 1, 2),
                'd',
                getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                'e',
                NHItemList.RawOrbTier1.get(),
                'f',
                getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                'h',
                getModItem(Botania.ID, "manaResource", 1, 2));
        TCHelper.addResearchPage("WEAKORB", new ResearchPage(TCHelper.findArcaneRecipe(NHItemList.WeakOrb.get())));
        ThaumcraftApi.addWarpToResearch("WEAKORB", 1);
        new ResearchItem(
                "APPRENTICEORB",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 12).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("cognitio"), 3),
                4,
                0,
                3,
                NHItemList.ApprenticeOrb.get())
                        .setParents("WEAKORB").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.APPRENTICEORB.1"),
                                new ResearchPage("tc.research_page.APPRENTICEORB.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "APPRENTICEORB",
                NHItemList.ApprenticeOrb.get(),
                new AspectList().add(Aspect.getAspect("aer"), 40).add(Aspect.getAspect("aqua"), 40)
                        .add(Aspect.getAspect("ignis"), 40).add(Aspect.getAspect("terra"), 40)
                        .add(Aspect.getAspect("perditio"), 40).add(Aspect.getAspect("ordo"), 40),
                "abc",
                "def",
                "ghi",
                'b',
                "gemFlawlessEmerald",
                'd',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                'e',
                NHItemList.RawOrbTier2.get(),
                'f',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                'h',
                "gemFlawlessEmerald");
        TCHelper.addResearchPage(
                "APPRENTICEORB",
                new ResearchPage(TCHelper.findArcaneRecipe(NHItemList.ApprenticeOrb.get())));
        ThaumcraftApi.addWarpToResearch("APPRENTICEORB", 2);
        new ResearchItem(
                "MAGICANORB",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("cognitio"), 6)
                        .add(Aspect.getAspect("sano"), 3),
                6,
                0,
                3,
                NHItemList.MagicianOrb.get())
                        .setParents("APPRENTICEORB").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.MAGICANORB.1"),
                                new ResearchPage("tc.research_page.MAGICANORB.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MAGICANORB",
                NHItemList.MagicianOrb.get(),
                new AspectList().add(Aspect.getAspect("aer"), 60).add(Aspect.getAspect("aqua"), 60)
                        .add(Aspect.getAspect("ignis"), 60).add(Aspect.getAspect("terra"), 60)
                        .add(Aspect.getAspect("perditio"), 60).add(Aspect.getAspect("ordo"), 60),
                "abc",
                "def",
                "ghi",
                'b',
                "blockGold",
                'd',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                'e',
                NHItemList.RawOrbTier3.get(),
                'f',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                'h',
                "blockGold");
        TCHelper.addResearchPage(
                "MAGICANORB",
                new ResearchPage(TCHelper.findArcaneRecipe(NHItemList.MagicianOrb.get())));
        ThaumcraftApi.addWarpToResearch("MAGICANORB", 3);
        new ResearchItem(
                "MASTERORB",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 18).add(Aspect.getAspect("potentia"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("cognitio"), 9)
                        .add(Aspect.getAspect("sano"), 6).add(Aspect.getAspect("aqua"), 3),
                8,
                0,
                3,
                NHItemList.MasterOrb.get()).setParents("MAGICANORB").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.MASTERORB")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MASTERORB",
                NHItemList.MasterOrb.get(),
                new AspectList().add(Aspect.getAspect("aer"), 80).add(Aspect.getAspect("aqua"), 80)
                        .add(Aspect.getAspect("ignis"), 80).add(Aspect.getAspect("terra"), 80)
                        .add(Aspect.getAspect("perditio"), 80).add(Aspect.getAspect("ordo"), 80),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                'd',
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                'e',
                NHItemList.RawOrbTier4.get(),
                'f',
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                'h',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0));
        TCHelper.addResearchPage("MASTERORB", new ResearchPage(TCHelper.findArcaneRecipe(NHItemList.MasterOrb.get())));
        ThaumcraftApi.addWarpToResearch("MASTERORB", 4);
        new ResearchItem(
                "ARCHMAGEORB",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 21).add(Aspect.getAspect("potentia"), 18)
                        .add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("cognitio"), 12)
                        .add(Aspect.getAspect("sano"), 9).add(Aspect.getAspect("aqua"), 6)
                        .add(Aspect.getAspect("infernus"), 3),
                10,
                0,
                3,
                NHItemList.ArchmageOrb.get())
                        .setParents("MASTERORB").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.ARCHMAGEORB.1"),
                                new ResearchPage("tc.research_page.ARCHMAGEORB.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ARCHMAGEORB",
                NHItemList.ArchmageOrb.get(),
                new AspectList().add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("aqua"), 100)
                        .add(Aspect.getAspect("ignis"), 100).add(Aspect.getAspect("terra"), 100)
                        .add(Aspect.getAspect("perditio"), 100).add(Aspect.getAspect("ordo"), 100),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(BloodMagic.ID, "demonBloodShard", 1, 0),
                'd',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27),
                'e',
                NHItemList.RawOrbTier5.get(),
                'f',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27),
                'h',
                getModItem(BloodMagic.ID, "demonBloodShard", 1, 0));
        TCHelper.addResearchPage(
                "ARCHMAGEORB",
                new ResearchPage(TCHelper.findArcaneRecipe(NHItemList.ArchmageOrb.get())));
        ThaumcraftApi.addWarpToResearch("ARCHMAGEORB", 5);
        new ResearchItem(
                "TRANSCENDENTORB",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 24).add(Aspect.getAspect("potentia"), 21)
                        .add(Aspect.getAspect("praecantatio"), 18).add(Aspect.getAspect("cognitio"), 15)
                        .add(Aspect.getAspect("sano"), 12).add(Aspect.getAspect("aqua"), 9)
                        .add(Aspect.getAspect("infernus"), 6).add(Aspect.getAspect("electrum"), 3),
                12,
                0,
                3,
                NHItemList.TranscendentOrb.get())
                        .setParents("ARCHMAGEORB").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.TRANSCENDENTORB.1"),
                                new ResearchPage("tc.research_page.TRANSCENDENTORB.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TRANSCENDENTORB",
                NHItemList.TranscendentOrb.get(),
                new AspectList().add(Aspect.getAspect("aer"), 150).add(Aspect.getAspect("aqua"), 150)
                        .add(Aspect.getAspect("ignis"), 150).add(Aspect.getAspect("terra"), 150)
                        .add(Aspect.getAspect("perditio"), 150).add(Aspect.getAspect("ordo"), 150),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(BloodMagic.ID, "blockCrystal", 1, 0),
                'd',
                getModItem(BloodArsenal.ID, "sigil_of_lightning", 1, 0),
                'e',
                NHItemList.RawOrbTier6.get(),
                'f',
                getModItem(BloodArsenal.ID, "sigil_of_lightning", 1, 0),
                'h',
                getModItem(BloodMagic.ID, "blockCrystal", 1, 0));
        TCHelper.addResearchPage(
                "TRANSCENDENTORB",
                new ResearchPage(TCHelper.findArcaneRecipe(NHItemList.TranscendentOrb.get())));
        ThaumcraftApi.addWarpToResearch("TRANSCENDENTORB", 6);
        new ResearchItem(
                "TRANSPARENTORB",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 27).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("praecantatio"), 21).add(Aspect.getAspect("cognitio"), 18)
                        .add(Aspect.getAspect("sano"), 15).add(Aspect.getAspect("aqua"), 12)
                        .add(Aspect.getAspect("infernus"), 9).add(Aspect.getAspect("electrum"), 6)
                        .add(Aspect.getAspect("alienis"), 3),
                14,
                0,
                3,
                getModItem(BloodArsenal.ID, "transparent_orb", 1, 0)).setParents("TRANSCENDENTORB").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.TRANSPARENTORB")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TRANSPARENTORB",
                getModItem(BloodArsenal.ID, "transparent_orb", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 175).add(Aspect.getAspect("aqua"), 175)
                        .add(Aspect.getAspect("ignis"), 175).add(Aspect.getAspect("terra"), 175)
                        .add(Aspect.getAspect("perditio"), 175).add(Aspect.getAspect("ordo"), 175),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodArsenal.ID, "blood_stained_glass", 1, 0),
                'b',
                getModItem(BloodArsenal.ID, "blood_lamp", 1, 0),
                'c',
                getModItem(BloodArsenal.ID, "blood_stained_glass", 1, 0),
                'd',
                getModItem(BloodArsenal.ID, "blood_stained_glass", 1, 0),
                'e',
                getModItem(BloodMagic.ID, "transcendentBloodOrb", 1, 0),
                'f',
                getModItem(BloodArsenal.ID, "blood_stained_glass", 1, 0),
                'g',
                getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0),
                'h',
                getModItem(BloodMagic.ID, "divinationSigil", 1, 0),
                'i',
                getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0));
        TCHelper.addResearchPage(
                "TRANSPARENTORB",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodArsenal.ID, "transparent_orb", 1, 0))));
        ThaumcraftApi.addWarpToResearch("TRANSPARENTORB", 7);
        new ResearchItem(
                "EMPTYSOCKET",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("tutamen"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("tenebrae"), 6)
                        .add(Aspect.getAspect("sano"), 3),
                2,
                -6,
                3,
                getModItem(BloodMagic.ID, "emptySocket", 1, 0)).setParents("BLOODLETTERSPACK").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.EMPTYSOCKET")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "EMPTYSOCKET",
                getModItem(BloodMagic.ID, "emptySocket", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("ignis"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("perditio"), 50).add(Aspect.getAspect("ordo"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                'b',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                'c',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                'd',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                'e',
                BlockList.DiamondFrameBox.get(),
                'f',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                'g',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                'h',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                'i',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0));
        TCHelper.addResearchPage(
                "EMPTYSOCKET",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "emptySocket", 1, 0))));
        ThaumcraftApi.addWarpToResearch("EMPTYSOCKET", 2);
        new ResearchItem(
                "SOULARMORFORGE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("tutamen"), 18).add(Aspect.getAspect("metallum"), 15)
                        .add(Aspect.getAspect("praecantatio"), 21).add(Aspect.getAspect("tenebrae"), 6)
                        .add(Aspect.getAspect("exanimis"), 3),
                2,
                -8,
                3,
                getModItem(BloodMagic.ID, "armourForge", 1, 0))
                        .setParents("INFUSION", "EMPTYSOCKET").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.SOULARMORFORGE.1"),
                                new ResearchPage("tc.research_page.SOULARMORFORGE.2"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SOULARMORFORGE",
                getModItem(BloodMagic.ID, "armourForge", 1, 0),
                7,
                new AspectList().add(Aspect.getAspect("tutamen"), 64).add(Aspect.getAspect("metallum"), 40)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("auram"), 24)
                        .add(Aspect.getAspect("tenebrae"), 16).add(Aspect.getAspect("exanimis"), 8),
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 6),
                getModItem(BloodMagic.ID, "bloodSocket", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 2),
                getModItem(BloodMagic.ID, "bloodSocket", 1, 0),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 2),
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                getModItem(BloodMagic.ID, "bloodSocket", 1, 0),
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 2),
                getModItem(BloodMagic.ID, "bloodSocket", 1, 0),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 2),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3));
        TCHelper.addResearchPage(
                "SOULARMORFORGE",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "armourForge", 1, 0))));
        ThaumcraftApi.addWarpToResearch("SOULARMORFORGE", 4);
        new ResearchItem(
                "RUNEOFARGUMENTEDCAPACITY",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("aqua"), 18).add(Aspect.getAspect("fames"), 15)
                        .add(Aspect.getAspect("lucrum"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("vacuos"), 3),
                -6,
                0,
                3,
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 1)).setParents("INFUSION", "RUNESACRIFICE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.RUNEOFARGUMENTEDCAPACITY"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "RUNEOFARGUMENTEDCAPACITY",
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 1),
                7,
                new AspectList().add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("lucrum"), 24)
                        .add(Aspect.getAspect("fames"), 18).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("terra"), 8).add(Aspect.getAspect("vacuos"), 4),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0));
        TCHelper.addResearchPage(
                "RUNEOFARGUMENTEDCAPACITY",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 1))));
        new ResearchItem(
                "RUNEOFDISLOCATION",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("aqua"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("cognitio"), 3),
                -6,
                2,
                3,
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 2)).setParents("INFUSION", "RUNESACRIFICE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.RUNEOFDISLOCATION"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "RUNEOFDISLOCATION",
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 2),
                7,
                new AspectList().add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("motus"), 18).add(Aspect.getAspect("tempus"), 12)
                        .add(Aspect.getAspect("terra"), 8).add(Aspect.getAspect("cognitio"), 4),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1),
                ItemList.Electric_Pump_EV.get(1L),
                getModItem(BloodMagic.ID, "aquasalus", 1, 0),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(BloodMagic.ID, "aquasalus", 1, 0),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                ItemList.Electric_Pump_EV.get(1L),
                getModItem(BloodMagic.ID, "aquasalus", 1, 0),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(BloodMagic.ID, "aquasalus", 1, 0),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0));
        TCHelper.addResearchPage(
                "RUNEOFDISLOCATION",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 2))));
        new ResearchItem(
                "SIGILOFELEMENTALAFFINITY",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("volatus"), 27).add(Aspect.getAspect("ignis"), 24)
                        .add(Aspect.getAspect("aqua"), 21).add(Aspect.getAspect("aer"), 18)
                        .add(Aspect.getAspect("motus"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("iter"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("cognitio"), 3),
                0,
                12,
                3,
                getModItem(BloodMagic.ID, "sigilOfElementalAffinity", 1, 0)).setParents("INFUSION", "AIRSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFELEMENTALAFFINITY"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SIGILOFELEMENTALAFFINITY",
                getModItem(BloodMagic.ID, "sigilOfElementalAffinity", 1, 0),
                9,
                new AspectList().add(Aspect.getAspect("volatus"), 64).add(Aspect.getAspect("aer"), 48)
                        .add(Aspect.getAspect("aqua"), 48).add(Aspect.getAspect("ignis"), 48)
                        .add(Aspect.getAspect("motus"), 32).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("iter"), 18).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("cognitio"), 6),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(BloodMagic.ID, "earthScribeTool", 1, 0),
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                getModItem(BloodMagic.ID, "lavaSigil", 1, 0),
                getModItem(BloodMagic.ID, "fireScribeTool", 1, 0),
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                getModItem(BloodMagic.ID, "waterSigil", 1, 0),
                getModItem(BloodMagic.ID, "waterScribeTool", 1, 0),
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                getModItem(BloodMagic.ID, "airSigil", 1, 0),
                getModItem(BloodMagic.ID, "airScribeTool", 1, 0),
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0));
        TCHelper.addResearchPage(
                "SIGILOFELEMENTALAFFINITY",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "sigilOfElementalAffinity", 1, 0))));
        ThaumcraftApi.addWarpToResearch("SIGILOFELEMENTALAFFINITY", 8);
        new ResearchItem(
                "SIGILOFLIGHTNING",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("tempestas"), 24).add(Aspect.getAspect("aer"), 21)
                        .add(Aspect.getAspect("aqua"), 18).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("tenebrae"), 9)
                        .add(Aspect.getAspect("ira"), 6).add(Aspect.getAspect("electrum"), 3),
                2,
                14,
                3,
                getModItem(BloodArsenal.ID, "sigil_of_lightning", 1, 0))
                        .setParents("INFUSION", "SIGILOFELEMENTALAFFINITY").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.SIGILOFLIGHTNING.1"),
                                new ResearchPage("tc.research_page.SIGILOFLIGHTNING.2"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SIGILOFLIGHTNING",
                getModItem(BloodArsenal.ID, "sigil_of_lightning", 1, 0),
                15,
                new AspectList().add(Aspect.getAspect("tempestas"), 32).add(Aspect.getAspect("aer"), 72)
                        .add(Aspect.getAspect("aqua"), 72).add(Aspect.getAspect("terra"), 64)
                        .add(Aspect.getAspect("potentia"), 48).add(Aspect.getAspect("tenebrae"), 8)
                        .add(Aspect.getAspect("ira"), 8).add(Aspect.getAspect("electrum"), 16),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27),
                getModItem(BloodMagic.ID, "airSigil", 1, 0),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 3),
                getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0),
                getModItem(BloodMagic.ID, "waterSigil", 1, 0),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 3),
                getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0));
        TCHelper.addResearchPage(
                "SIGILOFLIGHTNING",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "sigil_of_lightning", 1, 0))));
        ThaumcraftApi.addWarpToResearch("SIGILOFLIGHTNING", 12);
        new ResearchItem(
                "SIGILOFHOLDING",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("lucrum"), 18).add(Aspect.getAspect("cognitio"), 15)
                        .add(Aspect.getAspect("gula"), 12).add(Aspect.getAspect("superbia"), 9)
                        .add(Aspect.getAspect("limus"), 6).add(Aspect.getAspect("praecantatio"), 3),
                4,
                6,
                3,
                getModItem(BloodMagic.ID, "sigilOfHolding", 1, 0)).setParents("INFUSION", "SIGILOFMAGNETISM")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFHOLDING"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SIGILOFHOLDING",
                getModItem(BloodMagic.ID, "sigilOfHolding", 1, 0),
                9,
                new AspectList().add(Aspect.getAspect("lucrum"), 32).add(Aspect.getAspect("cognitio"), 24)
                        .add(Aspect.getAspect("gula"), 16).add(Aspect.getAspect("superbia"), 16)
                        .add(Aspect.getAspect("limus"), 16).add(Aspect.getAspect("praecantatio"), 8),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(IronChests.ID, "BlockIronChest", 1, 0),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                getModItem(BloodMagic.ID, "crepitous", 1, 0),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                getModItem(BloodMagic.ID, "crepitous", 1, 0),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0));
        TCHelper.addResearchPage(
                "SIGILOFHOLDING",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "sigilOfHolding", 1, 0))));
        ThaumcraftApi.addWarpToResearch("SIGILOFHOLDING", 2);
        new ResearchItem(
                "SIGILOFAUGMENTETHOLDING",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vacuos"), 21).add(Aspect.getAspect("lucrum"), 18)
                        .add(Aspect.getAspect("cognitio"), 15).add(Aspect.getAspect("gula"), 12)
                        .add(Aspect.getAspect("superbia"), 9).add(Aspect.getAspect("limus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                4,
                8,
                3,
                getModItem(BloodArsenal.ID, "sigil_of_augmented_holding", 1, 0))
                        .setParents("INFUSION", "SIGILOFHOLDING").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.SIGILOFAUGMENTETHOLDING")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SIGILOFAUGMENTETHOLDING",
                getModItem(BloodArsenal.ID, "sigil_of_augmented_holding", 1, 0),
                15,
                new AspectList().add(Aspect.getAspect("vacuos"), 48).add(Aspect.getAspect("lucrum"), 32)
                        .add(Aspect.getAspect("cognitio"), 24).add(Aspect.getAspect("gula"), 16)
                        .add(Aspect.getAspect("superbia"), 16).add(Aspect.getAspect("limus"), 16)
                        .add(Aspect.getAspect("praecantatio"), 8),
                getModItem(BloodMagic.ID, "sigilOfHolding", 1, 0),
                getModItem(IronChests.ID, "BlockIronChest", 1, 2),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(Minecraft.ID, "ghast_tear", 1, 0),
                OrePrefixes.plate.get(Materials.BloodInfusedIron),
                getModItem(Minecraft.ID, "blaze_rod", 1, 0),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(Minecraft.ID, "ghast_tear", 1, 0),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(Minecraft.ID, "blaze_rod", 1, 0),
                OrePrefixes.plate.get(Materials.BloodInfusedIron),
                getModItem(Minecraft.ID, "ghast_tear", 1, 0),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0));
        TCHelper.addResearchPage(
                "SIGILOFAUGMENTETHOLDING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "sigil_of_augmented_holding", 1, 0))));
        ThaumcraftApi.addWarpToResearch("SIGILOFAUGMENTETHOLDING", 4);
        new ResearchItem(
                "SIGILOFPHANTOMBRIDGE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("terra"), 18).add(Aspect.getAspect("alienis"), 15)
                        .add(Aspect.getAspect("iter"), 12).add(Aspect.getAspect("vitreus"), 9)
                        .add(Aspect.getAspect("potentia"), 6).add(Aspect.getAspect("praecantatio"), 3),
                -4,
                6,
                3,
                getModItem(BloodMagic.ID, "sigilOfTheBridge", 1, 0)).setParents("INFUSION", "VOIDSIGIL").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.SIGILOFPHANTOMBRIDGE")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SIGILOFPHANTOMBRIDGE",
                getModItem(BloodMagic.ID, "sigilOfTheBridge", 1, 0),
                9,
                new AspectList().add(Aspect.getAspect("terra"), 48).add(Aspect.getAspect("alienis"), 32)
                        .add(Aspect.getAspect("iter"), 24).add(Aspect.getAspect("vitreus"), 16)
                        .add(Aspect.getAspect("potentia"), 8).add(Aspect.getAspect("praecantatio"), 8),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1),
                getModItem(EnderIO.ID, "blockIngotStorage", 1, 7),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1),
                getModItem(EnderIO.ID, "blockIngotStorage", 1, 7),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1),
                getModItem(EnderIO.ID, "blockIngotStorage", 1, 7),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1),
                getModItem(EnderIO.ID, "blockIngotStorage", 1, 7));
        TCHelper.addResearchPage(
                "SIGILOFPHANTOMBRIDGE",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "sigilOfTheBridge", 1, 0))));
        ThaumcraftApi.addWarpToResearch("SIGILOFPHANTOMBRIDGE", 4);
        new ResearchItem(
                "SIGILOFMAGNETISM",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("magneto"), 21).add(Aspect.getAspect("potentia"), 18)
                        .add(Aspect.getAspect("electrum"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("auram"), 6).add(Aspect.getAspect("cognitio"), 3),
                2,
                6,
                3,
                getModItem(BloodMagic.ID, "sigilOfMagnetism", 1, 0)).setParents("INFUSION", "WATERSIGIL").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.SIGILOFMAGNETISM")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SIGILOFMAGNETISM",
                getModItem(BloodMagic.ID, "sigilOfMagnetism", 1, 0),
                9,
                new AspectList().add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("magneto"), 24)
                        .add(Aspect.getAspect("electrum"), 24).add(Aspect.getAspect("auram"), 16)
                        .add(Aspect.getAspect("cognitio"), 12).add(Aspect.getAspect("praecantatio"), 6),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                OrePrefixes.block.get(Materials.NeodymiumMagnetic),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                OrePrefixes.block.get(Materials.NeodymiumMagnetic),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                OrePrefixes.block.get(Materials.NeodymiumMagnetic),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                OrePrefixes.block.get(Materials.NeodymiumMagnetic),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0));
        TCHelper.addResearchPage(
                "SIGILOFMAGNETISM",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "sigilOfMagnetism", 1, 0))));
        ThaumcraftApi.addWarpToResearch("SIGILOFMAGNETISM", 2);
        new ResearchItem(
                "SIGILOFTHEBLOODLAMP",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("lux"), 18).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("sensus"), 6).add(Aspect.getAspect("praecantatio"), 3),
                0,
                6,
                3,
                getModItem(BloodMagic.ID, "itemBloodLightSigil", 1, 0)).setParents("INFUSION", "WATERSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFTHEBLOODLAMP"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SIGILOFTHEBLOODLAMP",
                getModItem(BloodMagic.ID, "itemBloodLightSigil", 1, 0),
                4,
                new AspectList().add(Aspect.getAspect("lux"), 48).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("sensus"), 16).add(Aspect.getAspect("praecantatio"), 8),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(ThaumicTinkerer.ID, "brightNitor", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 2),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6),
                getModItem(ThaumicTinkerer.ID, "brightNitor", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 2),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6));
        TCHelper.addResearchPage(
                "SIGILOFTHEBLOODLAMP",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "itemBloodLightSigil", 1, 0))));
        ThaumcraftApi.addWarpToResearch("SIGILOFTHEBLOODLAMP", 3);
        new ResearchItem(
                "SIGILOFSIGHT",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("sensus"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("vitreus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                2,
                2,
                3,
                getModItem(BloodMagic.ID, "seerSigil", 1, 0)).setParents("INFUSION", "DIVINATIONSIGIL").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.SIGILOFSIGHT")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SIGILOFSIGHT",
                getModItem(BloodMagic.ID, "seerSigil", 1, 0),
                3,
                new AspectList().add(Aspect.getAspect("ordo"), 24).add(Aspect.getAspect("sensus"), 18)
                        .add(Aspect.getAspect("cognitio"), 12).add(Aspect.getAspect("vitreus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 4),
                getModItem(BloodMagic.ID, "divinationSigil", 1, 0),
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                getModItem(BloodMagic.ID, "crystallos", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                getModItem(BloodMagic.ID, "crystallos", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0));
        TCHelper.addResearchPage(
                "SIGILOFSIGHT",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "seerSigil", 1, 0))));
        new ResearchItem(
                "RITUALDIVINER",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("aer"), 18).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 12).add(Aspect.getAspect("aqua"), 9)
                        .add(Aspect.getAspect("perditio"), 6).add(Aspect.getAspect("ordo"), 3),
                -2,
                -8,
                3,
                getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 0)).setParents("INFUSION", "MASTERRITUALSTONE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.RITUALDIVINER.1"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "RITUALDIVINER",
                getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 0),
                3,
                new AspectList().add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("terra"), 32).add(Aspect.getAspect("aqua"), 32)
                        .add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("ordo"), 16),
                getModItem(BloodMagic.ID, "seerSigil", 1, 0),
                getModItem(Witchery.ID, "chalkritual", 1, 0),
                getModItem(BloodMagic.ID, "waterScribeTool", 1, 0),
                OrePrefixes.gemFlawless.get(Materials.Diamond),
                getModItem(BloodMagic.ID, "fireScribeTool", 1, 0),
                OrePrefixes.gemFlawless.get(Materials.Emerald),
                getModItem(BloodMagic.ID, "earthScribeTool", 1, 0),
                OrePrefixes.gemFlawless.get(Materials.Diamond),
                getModItem(BloodMagic.ID, "airScribeTool", 1, 0),
                OrePrefixes.gemFlawless.get(Materials.Emerald));
        TCHelper.addResearchPage(
                "RITUALDIVINER",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 0))));
        ThaumcraftApi.addWarpToResearch("RITUALDIVINER", 3);
        TCHelper.addResearchPage("RITUALDIVINER", new ResearchPage("tc.research_page.RITUALDIVINER.2"));
        TCHelper.addInfusionCraftingRecipe(
                "RITUALDIVINER",
                getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 1),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 48).add(Aspect.getAspect("ignis"), 48)
                        .add(Aspect.getAspect("terra"), 48).add(Aspect.getAspect("aqua"), 48)
                        .add(Aspect.getAspect("perditio"), 24).add(Aspect.getAspect("ordo"), 24),
                getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 0),
                getModItem(BloodMagic.ID, "duskScribeTool", 1, 0),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(BloodMagic.ID, "duskScribeTool", 1, 0),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(BloodMagic.ID, "duskScribeTool", 1, 0),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(BloodMagic.ID, "duskScribeTool", 1, 0),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0));
        TCHelper.addResearchPage(
                "RITUALDIVINER",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 1))));
        TCHelper.addInfusionCraftingRecipe(
                "RITUALDIVINER",
                getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 2),
                9,
                new AspectList().add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("ignis"), 64)
                        .add(Aspect.getAspect("terra"), 64).add(Aspect.getAspect("aqua"), 64)
                        .add(Aspect.getAspect("perditio"), 32).add(Aspect.getAspect("ordo"), 32),
                getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 1),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27),
                getModItem(BloodMagic.ID, "dawnScribeTool", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27),
                getModItem(BloodMagic.ID, "dawnScribeTool", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27),
                getModItem(BloodMagic.ID, "dawnScribeTool", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27),
                getModItem(BloodMagic.ID, "dawnScribeTool", 1, 0));
        TCHelper.addResearchPage(
                "RITUALDIVINER",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 2))));
        new ResearchItem(
                "RUNEOFTHEORB",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("potentia"), 15).add(Aspect.getAspect("victus"), 12)
                        .add(Aspect.getAspect("motus"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                -6,
                -2,
                3,
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 3)).setParents("INFUSION", "RUNESACRIFICE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.RUNEOFTHEORB"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "RUNEOFTHEORB",
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 3),
                6,
                new AspectList().add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("victus"), 24)
                        .add(Aspect.getAspect("motus"), 16).add(Aspect.getAspect("lucrum"), 8)
                        .add(Aspect.getAspect("praecantatio"), 4),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 3),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 3),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 3));
        TCHelper.addResearchPage(
                "RUNEOFTHEORB",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 3))));
        new ResearchItem(
                "RUNEOFSUPERIORCAPACITY",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("potentia"), 18).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("cognitio"), 12).add(Aspect.getAspect("lucrum"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("alienis"), 3),
                -8,
                -2,
                3,
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 4))
                        .setParents("INFUSION", "RUNEOFARGUMENTEDCAPACITY").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.RUNEOFSUPERIORCAPACITY.1"),
                                new ResearchPage("tc.research_page.RUNEOFSUPERIORCAPACITY.2"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "RUNEOFSUPERIORCAPACITY",
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 4),
                8,
                new AspectList().add(Aspect.getAspect("potentia"), 48).add(Aspect.getAspect("aqua"), 32)
                        .add(Aspect.getAspect("cognitio"), 24).add(Aspect.getAspect("lucrum"), 16)
                        .add(Aspect.getAspect("praecantatio"), 8).add(Aspect.getAspect("alienis"), 4),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 3),
                getModItem(IronTanks.ID, "diamondTank", 1, 0),
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 3),
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 24),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(IronTanks.ID, "diamondTank", 1, 0),
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 3),
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 24),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0));
        TCHelper.addResearchPage(
                "RUNEOFSUPERIORCAPACITY",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 4))));
        new ResearchItem(
                "RUNEOFACCELERATION",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("potentia"), 21).add(Aspect.getAspect("tempus"), 18)
                        .add(Aspect.getAspect("cognitio"), 15).add(Aspect.getAspect("aqua"), 12)
                        .add(Aspect.getAspect("motus"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                -8,
                0,
                3,
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 5))
                        .setParents("INFUSION", "RUNEOFARGUMENTEDCAPACITY", "RUNEOFDISLOCATION").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.RUNEOFACCELERATION")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "RUNEOFACCELERATION",
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 5),
                10,
                new AspectList().add(Aspect.getAspect("potentia"), 64).add(Aspect.getAspect("aqua"), 48)
                        .add(Aspect.getAspect("motus"), 32).add(Aspect.getAspect("cognitio"), 24)
                        .add(Aspect.getAspect("tempus"), 16).add(Aspect.getAspect("praecantatio"), 8)
                        .add(Aspect.getAspect("terra"), 4),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 4),
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 2),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 24),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 4),
                ItemList.Electric_Pump_IV.get(1L),
                getModItem(BloodMagic.ID, "speedRune", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 24),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 4),
                ItemList.Electric_Pump_IV.get(1L));
        TCHelper.addResearchPage(
                "RUNEOFACCELERATION",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 5))));
        new ResearchItem(
                "RUNEOFQUICKNESS",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("potentia"), 48).add(Aspect.getAspect("tempus"), 35)
                        .add(Aspect.getAspect("cognitio"), 35).add(Aspect.getAspect("machina"), 23)
                        .add(Aspect.getAspect("motus"), 27).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("terra"), 7),
                -10,
                -2,
                3,
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 6))
                        .setParents("INFUSION", "RUNEOFACCELERATION", "RUNEOFDISLOCATION", "SPEEDRUNE").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.RUNEOFQUICKNESS.1"),
                                new ResearchPage("tc.research_page.RUNEOFQUICKNESS.2"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "RUNEOFQUICKNESS",
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 6),
                15,
                new AspectList().add(Aspect.getAspect("potentia"), 96).add(Aspect.getAspect("machina"), 48)
                        .add(Aspect.getAspect("motus"), 64).add(Aspect.getAspect("cognitio"), 32)
                        .add(Aspect.getAspect("tempus"), 32).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("terra"), 8),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 4),
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 5),
                ItemList.AcceleratorLuV.get(1L, missing),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 24),
                getModItem(BloodMagic.ID, "speedRune", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 4),
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 5),
                ItemList.AcceleratorLuV.get(1L, missing),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 24),
                getModItem(BloodMagic.ID, "speedRune", 1, 0),
                getModItem(BloodMagic.ID, "aether", 1, 0),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 4));
        TCHelper.addResearchPage(
                "RUNEOFQUICKNESS",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 6))));
        new ResearchItem(
                "ARCANEPEDESTALANDPLINTH",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                -4,
                -6,
                3,
                getModItem(BloodMagic.ID, "blockPedestal", 1, 0)).setParents("INFUSION", "MASTERRITUALSTONE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.ARCANEPEDESTALANDPLINTH.1"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ARCANEPEDESTALANDPLINTH",
                getModItem(BloodMagic.ID, "blockPedestal", 1, 0),
                new AspectList().add(Aspect.getAspect("ignis"), 30).add(Aspect.getAspect("terra"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0),
                'b',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                'c',
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0),
                'd',
                getModItem(BloodMagic.ID, "largeBloodStoneBrick", 1, 0),
                'e',
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 1),
                'f',
                getModItem(BloodMagic.ID, "largeBloodStoneBrick", 1, 0),
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                'h',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7));
        TCHelper.addResearchPage(
                "ARCANEPEDESTALANDPLINTH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "blockPedestal", 1, 0))));
        TCHelper.addResearchPage(
                "ARCANEPEDESTALANDPLINTH",
                new ResearchPage("tc.research_page.ARCANEPEDESTALANDPLINTH.2"));
        TCHelper.addInfusionCraftingRecipe(
                "ARCANEPEDESTALANDPLINTH",
                getModItem(BloodMagic.ID, "blockPlinth", 1, 0),
                10,
                new AspectList().add(Aspect.getAspect("metallum"), 64).add(Aspect.getAspect("ignis"), 48)
                        .add(Aspect.getAspect("terra"), 32).add(Aspect.getAspect("tenebrae"), 24)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("alienis"), 8),
                getModItem(BloodMagic.ID, "blockPedestal", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0),
                getModItem(Witchery.ID, "ingredient", 1, 130),
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0),
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                getModItem(Witchery.ID, "ingredient", 1, 130),
                getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0),
                getModItem(Witchery.ID, "ingredient", 1, 130),
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0),
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                getModItem(Witchery.ID, "ingredient", 1, 130));
        TCHelper.addResearchPage(
                "ARCANEPEDESTALANDPLINTH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "blockPlinth", 1, 0))));
        TCHelper.addResearchPage(
                "ARCANEPEDESTALANDPLINTH",
                new ResearchPage("tc.research_page.ARCANEPEDESTALANDPLINTH.3"));
        TCHelper.addResearchPage(
                "ARCANEPEDESTALANDPLINTH",
                new ResearchPage("tc.research_page.ARCANEPEDESTALANDPLINTH.4"));
        ThaumcraftApi.addWarpToResearch("ARCANEPEDESTALANDPLINTH", 2);
        new ResearchItem(
                "ALCHEMICCALCINATOR",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("praecantatio"), 18).add(Aspect.getAspect("vitreus"), 15)
                        .add(Aspect.getAspect("terra"), 12).add(Aspect.getAspect("perditio"), 9)
                        .add(Aspect.getAspect("aqua"), 6).add(Aspect.getAspect("ignis"), 3),
                -4,
                -8,
                3,
                getModItem(BloodMagic.ID, "blockAlchemicCalcinator", 1, 0)).setParents("ARCANEPEDESTALANDPLINTH")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.ALCHEMICCALCINATOR"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ALCHEMICCALCINATOR",
                getModItem(BloodMagic.ID, "blockAlchemicCalcinator", 1, 0),
                new AspectList().add(Aspect.getAspect("ignis"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("terra"), 50).add(Aspect.getAspect("aer"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 15),
                'b',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                'c',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 15),
                'd',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                'e',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 4),
                'f',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                'h',
                getModItem(Witchery.ID, "cauldron", 1, 0),
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7));
        TCHelper.addResearchPage(
                "ALCHEMICCALCINATOR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "blockAlchemicCalcinator", 1, 0))));
        ThaumcraftApi.addWarpToResearch("ALCHEMICCALCINATOR", 3);
        new ResearchItem(
                "ALCHEMICTOOLS",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("aer"), 3),
                -4,
                -12,
                3,
                getModItem(BloodMagic.ID, "itemAttunedCrystal", 1, 0)).setParents("ALCHEMICCALCINATOR").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ALCHEMICTOOLS.1")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ALCHEMICTOOLS",
                getModItem(BloodMagic.ID, "itemAttunedCrystal", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ordo"), 15)
                        .add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                'b',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0),
                'e',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 4),
                'f',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0),
                'g',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0),
                'i',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0));
        TCHelper.addResearchPage(
                "ALCHEMICTOOLS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "itemAttunedCrystal", 1, 0))));
        TCHelper.addResearchPage("ALCHEMICTOOLS", new ResearchPage("tc.research_page.ALCHEMICTOOLS.2"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ALCHEMICTOOLS",
                getModItem(BloodMagic.ID, "itemDestinationClearer", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aer"), 15)
                        .add(Aspect.getAspect("perditio"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0),
                'b',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3),
                'c',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0),
                'd',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3),
                'f',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3),
                'g',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0),
                'h',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3),
                'i',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0));
        TCHelper.addResearchPage(
                "ALCHEMICTOOLS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "itemDestinationClearer", 1, 0))));
        TCHelper.addResearchPage("ALCHEMICTOOLS", new ResearchPage("tc.research_page.ALCHEMICTOOLS.3"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ALCHEMICTOOLS",
                getModItem(BloodMagic.ID, "itemTankSegmenter", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aer"), 15)
                        .add(Aspect.getAspect("ignis"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Witchery.ID, "chalkheart", 1, 0),
                'b',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0),
                'c',
                getModItem(BloodMagic.ID, "mundanePowerCatalyst", 1, 0),
                'e',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 4),
                'f',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0),
                'g',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0),
                'i',
                getModItem(Witchery.ID, "chalkheart", 1, 0));
        TCHelper.addResearchPage(
                "ALCHEMICTOOLS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "itemTankSegmenter", 1, 0))));
        new ResearchItem(
                "BELLJAR",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 18).add(Aspect.getAspect("aer"), 15)
                        .add(Aspect.getAspect("terra"), 12).add(Aspect.getAspect("ordo"), 9)
                        .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("arbor"), 3),
                -6,
                -12,
                3,
                getModItem(BloodMagic.ID, "blockCrystalBelljar", 1, 0)).setParents("ALCHEMICCALCINATOR").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.BELLJAR")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BELLJAR",
                getModItem(BloodMagic.ID, "blockCrystalBelljar", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                'b',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                'd',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                'e',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 4),
                'f',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                'g',
                getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0),
                'h',
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0),
                'i',
                getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0));
        TCHelper.addResearchPage(
                "BELLJAR",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "blockCrystalBelljar", 1, 0))));
        new ResearchItem(
                "ALCHEMYRELAY",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("metallum"), 18).add(Aspect.getAspect("bestia"), 15)
                        .add(Aspect.getAspect("pannus"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("alienis"), 6).add(Aspect.getAspect("potentia"), 3),
                -2,
                -12,
                3,
                getModItem(BloodMagic.ID, "blockReagentConduit", 1, 0)).setParents("ALCHEMICCALCINATOR").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ALCHEMYRELAY")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ALCHEMYRELAY",
                getModItem(BloodMagic.ID, "blockReagentConduit", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 25).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("ignis"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                'b',
                getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0),
                'c',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                'd',
                getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0),
                'e',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 4),
                'f',
                getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0),
                'g',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                'h',
                getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0),
                'i',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0));
        TCHelper.addResearchPage(
                "ALCHEMYRELAY",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "blockReagentConduit", 1, 0))));
        new ResearchItem(
                "CRYSTALCLUSTER",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("victus"), 21).add(Aspect.getAspect("spiritus"), 18)
                        .add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("tenebrae"), 6)
                        .add(Aspect.getAspect("cognitio"), 3),
                -10,
                0,
                3,
                getModItem(BloodMagic.ID, "blockCrystal", 1, 0)).setParents("INFUSION", "RUNEOFACCELERATION")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.CRYSTALCLUSTER"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "CRYSTALCLUSTER",
                getModItem(BloodMagic.ID, "blockCrystal", 1, 0),
                15,
                new AspectList().add(Aspect.getAspect("potentia"), 72).add(Aspect.getAspect("victus"), 64)
                        .add(Aspect.getAspect("spiritus"), 64).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("tenebrae"), 32).add(Aspect.getAspect("alienis"), 16)
                        .add(Aspect.getAspect("cognitio"), 16),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 4),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 28),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 29),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 28),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 29),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 28),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 29),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 28),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 29),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 28),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 29));
        TCHelper.addResearchPage(
                "CRYSTALCLUSTER",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "blockCrystal", 1, 0))));
        ThaumcraftApi.addWarpToResearch("CRYSTALCLUSTER", 5);
        new ResearchItem(
                "ICHORIUMBLOCK",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("victus"), 21).add(Aspect.getAspect("fames"), 18)
                        .add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("infernus"), 12)
                        .add(Aspect.getAspect("alienis"), 9).add(Aspect.getAspect("superbia"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                -10,
                2,
                3,
                GTOreDictUnificator.get(OrePrefixes.block, Materials.Ichorium, 1L))
                        .setParents("INFUSION", "CRYSTALCLUSTER").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.ICHORIUMBLOCK.1"),
                                new ResearchPage("tc.research_page.ICHORIUMBLOCK.2"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ICHORIUMBLOCK",
                GTOreDictUnificator.get(OrePrefixes.block, Materials.Ichorium, 1L),
                12,
                new AspectList().add(Aspect.getAspect("victus"), 64).add(Aspect.getAspect("fames"), 48)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("infernus"), 24)
                        .add(Aspect.getAspect("alienis"), 16).add(Aspect.getAspect("superbia"), 16)
                        .add(Aspect.getAspect("terra"), 8),
                BlockList.Mytryl.get(),
                OrePrefixes.ingot.get(Materials.Ichorium),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 28),
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0),
                getModItem(BloodMagic.ID, "standardBindingAgent", 1, 0),
                OrePrefixes.ingot.get(Materials.Ichorium),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 29),
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 4));
        TCHelper.addResearchPage(
                "ICHORIUMBLOCK",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                GTOreDictUnificator.get(OrePrefixes.block, Materials.Ichorium, 1L))));
        ThaumcraftApi.addWarpToResearch("ICHORIUMBLOCK", 3);
        new ResearchItem(
                "GLYPHSTONE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("terra"), 21).add(Aspect.getAspect("superbia"), 18)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("cognitio"), 12)
                        .add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("alienis"), 3),
                2,
                -10,
                3,
                getModItem(BloodMagic.ID, "blockStabilityGlyph", 1, 0)).setParents("INFUSION", "SOULARMORFORGE")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.GLYPHSTONE.1"),
                                new ResearchPage("tc.research_page.GLYPHSTONE.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GLYPHSTONE",
                getModItem(BloodMagic.ID, "blockStabilityGlyph", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("aqua"), 20).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("perditio"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "crepitous", 1, 0),
                'b',
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                'c',
                getModItem(BloodMagic.ID, "crepitous", 1, 0),
                'd',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17),
                'e',
                getModItem(BloodArsenal.ID, "blood_stone", 1, 4),
                'f',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17),
                'g',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1),
                'h',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 30),
                'i',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1));
        TCHelper.addResearchPage(
                "GLYPHSTONE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "blockStabilityGlyph", 1, 0))));
        ThaumcraftApi.addWarpToResearch("GLYPHSTONE", 3);
        TCHelper.addResearchPage("GLYPHSTONE", new ResearchPage("tc.research_page.GLYPHSTONE.2"));
        TCHelper.addResearchPage("GLYPHSTONE", new ResearchPage("tc.research_page.GLYPHSTONE.3"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GLYPHSTONE",
                getModItem(BloodMagic.ID, "blockEnchantmentGlyph", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("terra"), 30)
                        .add(Aspect.getAspect("aqua"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 0),
                'b',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 28),
                'c',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 0),
                'd',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17),
                'e',
                getModItem(BloodArsenal.ID, "blood_stone", 1, 4),
                'f',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17),
                'g',
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                'h',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 30),
                'i',
                getModItem(BloodMagic.ID, "magicales", 1, 0));
        TCHelper.addResearchPage(
                "GLYPHSTONE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "blockEnchantmentGlyph", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GLYPHSTONE",
                getModItem(BloodMagic.ID, "blockEnchantmentGlyph", 1, 1),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("terra"), 30)
                        .add(Aspect.getAspect("aqua"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6),
                'b',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 29),
                'c',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6),
                'd',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17),
                'e',
                getModItem(BloodArsenal.ID, "blood_stone", 1, 4),
                'f',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17),
                'g',
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                'h',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 30),
                'i',
                getModItem(BloodMagic.ID, "magicales", 1, 0));
        TCHelper.addResearchPage(
                "GLYPHSTONE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "blockEnchantmentGlyph", 1, 1))));
        new ResearchItem(
                "KEYOFBINDING",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                4,
                -2,
                3,
                getModItem(BloodMagic.ID, "itemKeyOfDiablo", 1, 0)).setParents("SACRIFICIALKNIFE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.KEYOFBINDING")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "KEYOFBINDING",
                getModItem(BloodMagic.ID, "itemKeyOfDiablo", 1, 0),
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ordo"), 15)
                        .add(Aspect.getAspect("ignis"), 15),
                "abc",
                "def",
                "ghi",
                'b',
                "plateRoseGold",
                'c',
                "gemFlawlessDiamond",
                'd',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                'e',
                getModItem(Thaumcraft.ID, "ArcaneDoorKey", 1, 1),
                'f',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                'g',
                "gemFlawlessDiamond",
                'h',
                "plateRoseGold");
        TCHelper.addResearchPage(
                "KEYOFBINDING",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "itemKeyOfDiablo", 1, 0))));
        new ResearchItem(
                "ARMORINHIBITOR",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("spiritus"), 9).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                4,
                -8,
                3,
                getModItem(BloodMagic.ID, "armourInhibitor", 1, 0)).setParents("SOULARMORFORGE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ARMORINHIBITOR")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ARMORINHIBITOR",
                getModItem(BloodMagic.ID, "armourInhibitor", 1, 0),
                new AspectList().add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("aer"), 30)
                        .add(Aspect.getAspect("aqua"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                'b',
                "plateRoseGold",
                'd',
                "plateRoseGold",
                'e',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                'f',
                "plateRoseGold",
                'h',
                "plateRoseGold",
                'i',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0));
        TCHelper.addResearchPage(
                "ARMORINHIBITOR",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "armourInhibitor", 1, 0))));
        new ResearchItem(
                "SIGILOFHASTE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("iter"), 21).add(Aspect.getAspect("motus"), 18)
                        .add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("cognitio"), 3),
                -2,
                12,
                3,
                getModItem(BloodMagic.ID, "sigilOfHaste", 1, 0)).setParents("INFUSION", "AIRSIGIL").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.SIGILOFHASTE")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SIGILOFHASTE",
                getModItem(BloodMagic.ID, "sigilOfHaste", 1, 0),
                8,
                new AspectList().add(Aspect.getAspect("iter"), 64).add(Aspect.getAspect("motus"), 32)
                        .add(Aspect.getAspect("aer"), 24).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("alienis"), 8)
                        .add(Aspect.getAspect("cognitio"), 8),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                getModItem(Botania.ID, "manaCookie", 1, 0),
                getModItem(BloodMagic.ID, "aether", 1, 0),
                getModItem(BloodMagic.ID, "aether", 1, 0),
                getModItem(Minecraft.ID, "sugar", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                getModItem(Minecraft.ID, "sugar", 1, 0),
                getModItem(BloodMagic.ID, "aether", 1, 0),
                getModItem(BloodMagic.ID, "aether", 1, 0),
                getModItem(Botania.ID, "manaCookie", 1, 0));
        TCHelper.addResearchPage(
                "SIGILOFHASTE",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "sigilOfHaste", 1, 0))));
        ThaumcraftApi.addWarpToResearch("SIGILOFHASTE", 3);
        new ResearchItem(
                "SIGILOFWHIRLWIND",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("aer"), 24).add(Aspect.getAspect("tutamen"), 21)
                        .add(Aspect.getAspect("potentia"), 18).add(Aspect.getAspect("victus"), 15)
                        .add(Aspect.getAspect("sano"), 12).add(Aspect.getAspect("cognitio"), 9)
                        .add(Aspect.getAspect("superbia"), 6).add(Aspect.getAspect("nebrisum"), 3),
                2,
                12,
                3,
                getModItem(BloodMagic.ID, "sigilOfWind", 1, 0)).setParents("INFUSION", "AIRSIGIL").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.SIGILOFWHIRLWIND")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SIGILOFWHIRLWIND",
                getModItem(BloodMagic.ID, "sigilOfWind", 1, 0),
                12,
                new AspectList().add(Aspect.getAspect("aer"), 72).add(Aspect.getAspect("tutamen"), 48)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("victus"), 32)
                        .add(Aspect.getAspect("sano"), 16).add(Aspect.getAspect("cognitio"), 16)
                        .add(Aspect.getAspect("superbia"), 8).add(Aspect.getAspect("nebrisum"), 8),
                getModItem(BloodMagic.ID, "airSigil", 1, 0),
                getModItem(TwilightForest.ID, "item.tfFeather", 1, 0),
                getModItem(BloodMagic.ID, "aether", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(Minecraft.ID, "ghast_tear", 1, 0),
                getModItem(BloodMagic.ID, "aether", 1, 0),
                getModItem(TwilightForest.ID, "item.tfFeather", 1, 0),
                getModItem(BloodMagic.ID, "aether", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(Minecraft.ID, "ghast_tear", 1, 0),
                getModItem(BloodMagic.ID, "aether", 1, 0));
        TCHelper.addResearchPage(
                "SIGILOFWHIRLWIND",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "sigilOfWind", 1, 0))));
        ThaumcraftApi.addWarpToResearch("SIGILOFWHIRLWIND", 4);
        new ResearchItem(
                "SIGILOFSUPRESSION",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vacuos"), 21).add(Aspect.getAspect("auram"), 18)
                        .add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("metallum"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("motus"), 3),
                -2,
                8,
                3,
                getModItem(BloodMagic.ID, "sigilOfSupression", 1, 0)).setParents("INFUSION", "VOIDSIGIL").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.SIGILOFSUPRESSION")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SIGILOFSUPRESSION",
                getModItem(BloodMagic.ID, "sigilOfSupression", 1, 0),
                15,
                new AspectList().add(Aspect.getAspect("vacuos"), 72).add(Aspect.getAspect("auram"), 16)
                        .add(Aspect.getAspect("aqua"), 64).add(Aspect.getAspect("metallum"), 8)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("terra"), 32)
                        .add(Aspect.getAspect("motus"), 16),
                getModItem(BloodMagic.ID, "voidSigil", 1, 0),
                getModItem(BloodMagic.ID, "blockTeleposer", 1, 0),
                getModItem(Minecraft.ID, "bucket", 1, 0),
                getModItem(BloodMagic.ID, "tennebrae", 1, 0),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(Minecraft.ID, "bucket", 1, 0),
                getModItem(BloodMagic.ID, "tennebrae", 1, 0),
                getModItem(Minecraft.ID, "bucket", 1, 0),
                getModItem(BloodMagic.ID, "tennebrae", 1, 0),
                getModItem(Minecraft.ID, "bucket", 1, 0),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(BloodMagic.ID, "tennebrae", 1, 0),
                getModItem(Minecraft.ID, "bucket", 1, 0));
        TCHelper.addResearchPage(
                "SIGILOFSUPRESSION",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "sigilOfSupression", 1, 0))));
        ThaumcraftApi.addWarpToResearch("SIGILOFSUPRESSION", 5);
        new ResearchItem(
                "SIGILOFENDERSEVERANCE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("alienis"), 21).add(Aspect.getAspect("cognitio"), 18)
                        .add(Aspect.getAspect("humanus"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("vinculum"), 9).add(Aspect.getAspect("limus"), 6)
                        .add(Aspect.getAspect("nebrisum"), 3),
                0,
                14,
                3,
                getModItem(BloodMagic.ID, "sigilOfEnderSeverance", 1, 0))
                        .setParents("INFUSION", "SIGILOFELEMENTALAFFINITY", "OCULUS").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.SIGILOFENDERSEVERANCE")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SIGILOFENDERSEVERANCE",
                getModItem(BloodMagic.ID, "sigilOfEnderSeverance", 1, 0),
                17,
                new AspectList().add(Aspect.getAspect("alienis"), 16).add(Aspect.getAspect("cognitio"), 72)
                        .add(Aspect.getAspect("humanus"), 16).add(Aspect.getAspect("potentia"), 64)
                        .add(Aspect.getAspect("vinculum"), 48).add(Aspect.getAspect("limus"), 32)
                        .add(Aspect.getAspect("nebrisum"), 8),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 2),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 7),
                ItemList.QuantumEye.get(1L),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 7),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 2),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0));
        TCHelper.addResearchPage(
                "SIGILOFENDERSEVERANCE",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "sigilOfEnderSeverance", 1, 0))));
        ThaumcraftApi.addWarpToResearch("SIGILOFENDERSEVERANCE", 6);
        new ResearchItem(
                "ENDERSIGIL",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vacuos"), 24).add(Aspect.getAspect("alienis"), 21)
                        .add(Aspect.getAspect("cognitio"), 18).add(Aspect.getAspect("humanus"), 15)
                        .add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("vinculum"), 9)
                        .add(Aspect.getAspect("limus"), 6).add(Aspect.getAspect("nebrisum"), 3),
                -2,
                16,
                3,
                getModItem(BloodArsenal.ID, "sigil_of_ender", 1, 0)).setParents("INFUSION", "SIGILOFENDERSEVERANCE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.ENDERSIGIL"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ENDERSIGIL",
                getModItem(BloodArsenal.ID, "sigil_of_ender", 1, 0),
                20,
                new AspectList().add(Aspect.getAspect("vacuos"), 16).add(Aspect.getAspect("alienis"), 16)
                        .add(Aspect.getAspect("cognitio"), 72).add(Aspect.getAspect("humanus"), 16)
                        .add(Aspect.getAspect("potentia"), 64).add(Aspect.getAspect("vinculum"), 48)
                        .add(Aspect.getAspect("limus"), 32).add(Aspect.getAspect("nebrisum"), 8),
                getModItem(BloodMagic.ID, "sigilOfEnderSeverance", 1, 0),
                getModItem(EnderStorage.ID, "enderChest", 1, 0),
                ItemList.Gravistar.get(1L),
                OrePrefixes.plate.get(Materials.Endium),
                ItemList.QuantumEye.get(1L),
                getModItem(Minecraft.ID, "ender_eye", 1, 0),
                getModItem(Minecraft.ID, "ender_eye", 1, 0),
                ItemList.QuantumEye.get(1L),
                OrePrefixes.plate.get(Materials.Endium),
                ItemList.Gravistar.get(1L));
        TCHelper.addResearchPage(
                "ENDERSIGIL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "sigil_of_ender", 1, 0))));
        ThaumcraftApi.addWarpToResearch("ENDERSIGIL", 8);
        new ResearchItem(
                "SIGILOFDIVINITY",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("tutamen"), 24).add(Aspect.getAspect("aer"), 21)
                        .add(Aspect.getAspect("ignis"), 18).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("terra"), 12).add(Aspect.getAspect("ordo"), 9)
                        .add(Aspect.getAspect("perditio"), 6).add(Aspect.getAspect("sano"), 3),
                2,
                16,
                3,
                getModItem(BloodArsenal.ID, "sigil_of_divinity", 1, 0)).setParents("INFUSION", "SIGILOFENDERSEVERANCE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFDIVINITY"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SIGILOFDIVINITY",
                getModItem(BloodArsenal.ID, "sigil_of_divinity", 1, 0),
                25,
                new AspectList().add(Aspect.getAspect("tutamen"), 64).add(Aspect.getAspect("aer"), 72)
                        .add(Aspect.getAspect("ignis"), 64).add(Aspect.getAspect("aqua"), 48)
                        .add(Aspect.getAspect("terra"), 32).add(Aspect.getAspect("ordo"), 32)
                        .add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("sano"), 8),
                getModItem(BloodMagic.ID, "sigilOfElementalAffinity", 1, 0),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 4),
                getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0),
                getModItem(TinkerConstruct.ID, "diamondApple", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_glowstone", 1, 0),
                getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0),
                ItemList.Gravistar.get(1L),
                getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_glowstone", 1, 0),
                getModItem(TinkerConstruct.ID, "diamondApple", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0),
                getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0));
        TCHelper.addResearchPage(
                "SIGILOFDIVINITY",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "sigil_of_divinity", 1, 0))));
        ThaumcraftApi.addWarpToResearch("SIGILOFDIVINITY", 10);
        new ResearchItem(
                "HARVESTGODDESSSIGIL",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("herba"), 21).add(Aspect.getAspect("arbor"), 18)
                        .add(Aspect.getAspect("meto"), 15).add(Aspect.getAspect("messis"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("alienis"), 3),
                0,
                16,
                3,
                getModItem(BloodMagic.ID, "itemHarvestSigil", 1, 0)).setParents("INFUSION", "SIGILOFENDERSEVERANCE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.HARVESTGODDESSSIGIL"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "HARVESTGODDESSSIGIL",
                getModItem(BloodMagic.ID, "itemHarvestSigil", 1, 0),
                20,
                new AspectList().add(Aspect.getAspect("herba"), 72).add(Aspect.getAspect("arbor"), 64)
                        .add(Aspect.getAspect("meto"), 8).add(Aspect.getAspect("messis"), 16)
                        .add(Aspect.getAspect("cognitio"), 24).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("alienis"), 16),
                getModItem(BloodMagic.ID, "growthSigil", 1, 0),
                getModItem(BloodArsenal.ID, "bound_sickle", 1, 0),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 2),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 2),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27),
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 2));
        TCHelper.addResearchPage(
                "HARVESTGODDESSSIGIL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "itemHarvestSigil", 1, 0))));
        ThaumcraftApi.addWarpToResearch("HARVESTGODDESSSIGIL", 7);
        new ResearchItem(
                "SIGILOFCOMPRESSION",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("superbia"), 3),
                2,
                8,
                3,
                getModItem(BloodMagic.ID, "itemCompressionSigil", 1, 0)).setParents("INFUSION", "SIGILOFMAGNETISM")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFCOMPRESSION"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SIGILOFCOMPRESSION",
                getModItem(BloodMagic.ID, "itemCompressionSigil", 1, 0),
                10,
                new AspectList().add(Aspect.getAspect("metallum"), 32).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("machina"), 16).add(Aspect.getAspect("lucrum"), 16)
                        .add(Aspect.getAspect("superbia"), 8),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                ItemList.Electric_Piston_IV.get(1L),
                ItemList.Cover_Crafting.get(1L),
                ItemList.Electric_Motor_IV.get(1L),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                ItemList.Electric_Motor_IV.get(1L),
                ItemList.Cover_Crafting.get(1L),
                ItemList.Electric_Piston_IV.get(1L));
        TCHelper.addResearchPage(
                "SIGILOFCOMPRESSION",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "itemCompressionSigil", 1, 0))));
        ThaumcraftApi.addWarpToResearch("SIGILOFCOMPRESSION", 2);
        new ResearchItem(
                "ENERGYBAZOOKAI",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("potentia"), 21).add(Aspect.getAspect("instrumentum"), 18)
                        .add(Aspect.getAspect("telum"), 15).add(Aspect.getAspect("superbia"), 12)
                        .add(Aspect.getAspect("fames"), 9).add(Aspect.getAspect("nebrisum"), 6)
                        .add(Aspect.getAspect("ira"), 3),
                -12,
                0,
                3,
                getModItem(BloodMagic.ID, "energyBazooka", 1, 0))
                        .setParents("CRYSTALCLUSTER", "ICHOR_SWORD_GEM", "PRIMALCRUSHER").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ENERGYBAZOOKAI")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENERGYBAZOOKAI",
                getModItem(BloodMagic.ID, "energyBazooka", 1, 0),
                new AspectList().add(Aspect.getAspect("aqua"), 150).add(Aspect.getAspect("ignis"), 150)
                        .add(Aspect.getAspect("terra"), 150).add(Aspect.getAspect("aer"), 150)
                        .add(Aspect.getAspect("perditio"), 150).add(Aspect.getAspect("ordo"), 150),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Ichorium, 1L),
                'b',
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3),
                'c',
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Ichorium, 1L),
                'd',
                getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0),
                'e',
                getModItem(BloodMagic.ID, "energyBlasterThirdTier", 1, 0),
                'f',
                getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0),
                'g',
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Ichorium, 1L),
                'h',
                getModItem(BloodMagic.ID, "demonicTelepositionFocus", 1, 0),
                'i',
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Ichorium, 1L));
        TCHelper.addResearchPage(
                "ENERGYBAZOOKAI",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "energyBazooka", 1, 0))));
        ThaumcraftApi.addWarpToResearch("ENERGYBAZOOKAI", 5);
        new ResearchItem(
                "ENERGYBAZOOKAII",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("potentia"), 24).add(Aspect.getAspect("instrumentum"), 21)
                        .add(Aspect.getAspect("telum"), 18).add(Aspect.getAspect("infernus"), 15)
                        .add(Aspect.getAspect("superbia"), 12).add(Aspect.getAspect("fames"), 9)
                        .add(Aspect.getAspect("nebrisum"), 6).add(Aspect.getAspect("ira"), 3),
                -14,
                0,
                3,
                getModItem(BloodMagic.ID, "energyBazookaSecondTier", 1, 0)).setParents("INFUSION", "ENERGYBAZOOKAI")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.ENERGYBAZOOKAII"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ENERGYBAZOOKAII",
                getModItem(BloodMagic.ID, "energyBazookaSecondTier", 1, 0),
                15,
                new AspectList().add(Aspect.getAspect("potentia"), 96).add(Aspect.getAspect("instrumentum"), 72)
                        .add(Aspect.getAspect("telum"), 64).add(Aspect.getAspect("infernus"), 64)
                        .add(Aspect.getAspect("superbia"), 32).add(Aspect.getAspect("fames"), 32)
                        .add(Aspect.getAspect("nebrisum"), 16).add(Aspect.getAspect("ira"), 8),
                getModItem(BloodMagic.ID, "energyBazooka", 1, 0),
                getModItem(DraconicEvolution.ID, "draconium", 1, 2),
                getModItem(DraconicEvolution.ID, "draconicCore", 1, 0),
                getModItem(BloodMagic.ID, "dawnScribeTool", 1, 0),
                getModItem(DraconicEvolution.ID, "wyvernCore", 1, 0),
                getModItem(BloodMagic.ID, "duskScribeTool", 1, 0),
                getModItem(DraconicEvolution.ID, "draconium", 1, 2),
                getModItem(BloodMagic.ID, "duskScribeTool", 1, 0),
                getModItem(DraconicEvolution.ID, "draconicCore", 1, 0),
                getModItem(BloodMagic.ID, "dawnScribeTool", 1, 0),
                getModItem(DraconicEvolution.ID, "wyvernCore", 1, 0));
        TCHelper.addResearchPage(
                "ENERGYBAZOOKAII",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "energyBazookaSecondTier", 1, 0))));
        ThaumcraftApi.addWarpToResearch("ENERGYBAZOOKAII", 10);
        new ResearchItem(
                "ENERGYBAZOOKAIII",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("potentia"), 27).add(Aspect.getAspect("instrumentum"), 24)
                        .add(Aspect.getAspect("telum"), 21).add(Aspect.getAspect("terminus"), 18)
                        .add(Aspect.getAspect("infernus"), 15).add(Aspect.getAspect("superbia"), 12)
                        .add(Aspect.getAspect("fames"), 9).add(Aspect.getAspect("nebrisum"), 6)
                        .add(Aspect.getAspect("ira"), 3),
                -16,
                0,
                3,
                getModItem(BloodMagic.ID, "energyBazookaThirdTier", 1, 0)).setParents("INFUSION", "ENERGYBAZOOKAII")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.ENERGYBAZOOKAIII"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ENERGYBAZOOKAIII",
                getModItem(BloodMagic.ID, "energyBazookaThirdTier", 1, 0),
                20,
                new AspectList().add(Aspect.getAspect("potentia"), 128).add(Aspect.getAspect("instrumentum"), 96)
                        .add(Aspect.getAspect("telum"), 72).add(Aspect.getAspect("terminus"), 64)
                        .add(Aspect.getAspect("infernus"), 72).add(Aspect.getAspect("superbia"), 48)
                        .add(Aspect.getAspect("fames"), 32).add(Aspect.getAspect("nebrisum"), 16)
                        .add(Aspect.getAspect("ira"), 8),
                getModItem(BloodMagic.ID, "energyBazookaSecondTier", 1, 0),
                getModItem(Avaritia.ID, "big_pearl", 1, 0),
                getModItem(Avaritia.ID, "Resource", 1, 6),
                getModItem(DraconicEvolution.ID, "awakenedCore", 1, 0),
                getModItem(Avaritia.ID, "Resource_Block", 1, 0),
                getModItem(Avaritia.ID, "Resource", 1, 6),
                getModItem(Avaritia.ID, "Resource", 1, 6),
                getModItem(Avaritia.ID, "Resource_Block", 1, 0),
                getModItem(DraconicEvolution.ID, "chaoticCore", 1, 0),
                getModItem(Avaritia.ID, "Resource", 1, 6));
        TCHelper.addResearchPage(
                "ENERGYBAZOOKAIII",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "energyBazookaThirdTier", 1, 0))));
        ThaumcraftApi.addWarpToResearch("ENERGYBAZOOKAIII", 20);
        TCHelper.clearPages("CAP_blood_iron");
        TCHelper.addResearchPage("CAP_blood_iron", new ResearchPage("blood_arsenal.research_page.CAP_blood_iron.1"));
        TCHelper.addInfusionCraftingRecipe(
                "CAP_blood_iron",
                getModItem(BloodArsenal.ID, "wand_caps", 1, 0),
                10,
                new AspectList().add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("victus"), 24).add(Aspect.getAspect("metallum"), 16)
                        .add(Aspect.getAspect("ignis"), 8),
                getModItem(ForbiddenMagic.ID, "WandCaps", 1, 0),
                getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0),
                OrePrefixes.plate.get(Materials.BloodInfusedIron),
                OrePrefixes.ring.get(Materials.BloodInfusedIron),
                OrePrefixes.plate.get(Materials.BloodInfusedIron),
                getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0),
                getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0),
                OrePrefixes.plate.get(Materials.BloodInfusedIron),
                OrePrefixes.ring.get(Materials.BloodInfusedIron),
                OrePrefixes.plate.get(Materials.BloodInfusedIron),
                getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0));
        TCHelper.addResearchPage(
                "CAP_blood_iron",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "wand_caps", 1, 0))));
        TCHelper.setResearchAspects(
                "CAP_blood_iron",
                new AspectList().add(Aspect.getAspect("victus"), 18).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("tenebrae"), 12)
                        .add(Aspect.getAspect("metallum"), 6));
        TCHelper.setResearchComplexity("CAP_blood_iron", 3);
        ThaumcraftApi.addWarpToResearch("CAP_blood_iron", 3);
        TCHelper.clearPages("ROD_blood_wood");
        TCHelper.addResearchPage("ROD_blood_wood", new ResearchPage("blood_arsenal.research_page.ROD_blood_wood.1"));
        TCHelper.addResearchPage("ROD_blood_wood", new ResearchPage("blood_arsenal.research_page.ROD_blood_wood.2"));
        TCHelper.addInfusionCraftingRecipe(
                "ROD_blood_wood",
                getModItem(BloodArsenal.ID, "wand_cores", 1, 0),
                8,
                new AspectList().add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("instrumentum"), 24)
                        .add(Aspect.getAspect("victus"), 32).add(Aspect.getAspect("arbor"), 16)
                        .add(Aspect.getAspect("potentia"), 8),
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 3),
                getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0),
                getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0));
        TCHelper.addResearchPage(
                "ROD_blood_wood",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "wand_cores", 1, 0))));
        TCHelper.setResearchAspects(
                "ROD_blood_wood",
                new AspectList().add(Aspect.getAspect("victus"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("aqua"), 12).add(Aspect.getAspect("tenebrae"), 9)
                        .add(Aspect.getAspect("instrumentum"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ROD_blood_wood", 3);
        ThaumcraftApi.addWarpToResearch("ROD_blood_wood", 5);
        TCHelper.orphanResearch("ROD_blood_wood_staff");
        TCHelper.removeResearch("ROD_blood_wood_staff");
        new ResearchItem(
                "ROD_blood_wood_staff",
                "FORBIDDEN",
                new AspectList().add(Aspect.getAspect("victus"), 18).add(Aspect.getAspect("instrumentum"), 15)
                        .add(Aspect.getAspect("aqua"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("potentia"), 6).add(Aspect.getAspect("tenebrae"), 3),
                7,
                -5,
                3,
                getModItem(BloodArsenal.ID, "wand_cores", 1, 1)).setParents("ROD_blood_staff", "ROD_blood_wood")
                        .setConcealed().setSpecial()
                        .setPages(new ResearchPage("blood_arsenal.research_page.ROD_blood_wood_staff.1"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ROD_blood_wood_staff",
                getModItem(BloodArsenal.ID, "wand_cores", 1, 1),
                12,
                new AspectList().add(Aspect.getAspect("victus"), 64).add(Aspect.getAspect("aqua"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("instrumentum"), 48)
                        .add(Aspect.getAspect("metallum"), 16).add(Aspect.getAspect("ignis"), 16)
                        .add(Aspect.getAspect("infernus"), 8).add(Aspect.getAspect("arbor"), 32),
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 9),
                getModItem(BloodArsenal.ID, "wand_cores", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0),
                getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0),
                getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0),
                getModItem(BloodArsenal.ID, "wand_cores", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0),
                getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0),
                getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0));
        TCHelper.addResearchPage(
                "ROD_blood_wood_staff",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "wand_cores", 1, 1))));
        ThaumcraftApi.addWarpToResearch("ROD_blood_wood_staff", 7);
        TCHelper.refreshResearchPages("CAP_blood_iron");
        TCHelper.refreshResearchPages("ROD_blood_wood");
        new ResearchItem(
                "INCENSECRUCIBLE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("victus"), 18)
                        .add(Aspect.getAspect("potentia"), 6),
                6,
                -2,
                3,
                getModItem(BloodMagic.ID, "blockCrucible", 1, 0)).setParents("SACRIFICIALKNIFE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.INCENSECRUCIBLE")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "INCENSECRUCIBLE",
                getModItem(BloodMagic.ID, "blockCrucible", 1, 0),
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("aer"), 15)
                        .add(Aspect.getAspect("ordo"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                "plateAluminium",
                'b',
                getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                'c',
                "plateAluminium",
                'd',
                "plateAluminium",
                'e',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 0),
                'f',
                "plateAluminium",
                'g',
                getModItem(Minecraft.ID, "stone_slab", 1, 0),
                'h',
                getModItem(Minecraft.ID, "stone_slab", 1, 0),
                'i',
                getModItem(Minecraft.ID, "stone_slab", 1, 0));
        TCHelper.addResearchPage(
                "INCENSECRUCIBLE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "blockCrucible", 1, 0))));
        ThaumcraftApi.addWarpToResearch("INCENSECRUCIBLE", 2);
    }

    private void orbRecipes() {
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        NHItemList.TeleposerFrame.get(),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'b',
                        getModItem(BloodMagic.ID, "magicales", 1, 0),
                        'c',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                        'e',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                        'g',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'h',
                        getModItem(BloodMagic.ID, "magicales", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "telepositionFocus", 1, 0),
                        "abc",
                        "def",
                        "ghi",
                        'b',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 32),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'e',
                        NHItemList.TeleposerFrame.get(),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "blockTeleposer", 1, 0),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "plateRoseGold",
                        'b',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0),
                        'c',
                        "plateRoseGold",
                        'd',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 32),
                        'e',
                        getModItem(BloodMagic.ID, "telepositionFocus", 1, 0),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 32),
                        'g',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                        'h',
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1L),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "reinforcedTelepositionFocus", 1, 0),
                        "abc",
                        "def",
                        "ghi",
                        'b',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "enhancedTelepositionFocus", 1, 0),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'g',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0),
                        'h',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "archmageBloodOrb", 1, 0)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "demonicTelepositionFocus", 1, 0),
                        "abc",
                        "def",
                        "ghi",
                        'b',
                        getModItem(BloodMagic.ID, "demonBloodShard", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "demonBloodShard", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "reinforcedTelepositionFocus", 1, 0),
                        'f',
                        getModItem(BloodMagic.ID, "demonBloodShard", 1, 0),
                        'g',
                        getModItem(BloodMagic.ID, "archmageBloodOrb", 1, 0),
                        'h',
                        getModItem(BloodMagic.ID, "demonBloodShard", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "transcendentBloodOrb", 1, 0)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        NHItemList.Blaster.get(1),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "apprenticeBloodOrb", 1, 0),
                        'b',
                        getModItem(BloodMagic.ID, "crepitous", 1, 0),
                        'c',
                        "gemFlawlessDiamond",
                        'd',
                        getModItem(BloodMagic.ID, "crepitous", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 3),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 15),
                        'g',
                        "gemFlawlessDiamond",
                        'h',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 15),
                        'i',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "energyBlasterSecondTier", 1, 0),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "archmageBloodOrb", 1, 0),
                        'b',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0),
                        'c',
                        "gemExquisiteDiamond",
                        'd',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "energyBlaster", 1, 0),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17),
                        'g',
                        "gemExquisiteDiamond",
                        'h',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17),
                        'i',
                        getModItem(BloodMagic.ID, "demonBloodShard", 1, 0)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "energyBlasterThirdTier", 1, 0),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "transcendentBloodOrb", 1, 0),
                        'b',
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0),
                        'c',
                        "gemExquisiteDiamond",
                        'd',
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "energyBlasterSecondTier", 1, 0),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 30),
                        'g',
                        "gemExquisiteDiamond",
                        'h',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 30),
                        'i',
                        getModItem(BloodMagic.ID, "demonPlacer", 1, 0)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 3),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "weakBloodOrb", 1, 0),
                        'b',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                        'c',
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                        'd',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                        'e',
                        NHItemList.ArcaneSlate.get(),
                        'f',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                        'g',
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                        'h',
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 4),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "apprenticeBloodOrb", 1, 0),
                        'b',
                        "plateStone",
                        'c',
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                        'd',
                        "plateStone",
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 3),
                        'f',
                        "plateStone",
                        'g',
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                        'h',
                        "plateStone"));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0),
                        'b',
                        "plateObsidian",
                        'c',
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                        'd',
                        "plateObsidian",
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 4),
                        'f',
                        "plateObsidian",
                        'g',
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                        'h',
                        "plateObsidian"));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 31),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0),
                        'b',
                        "plateRoseGold",
                        'c',
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                        'd',
                        "plateRoseGold",
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                        'f',
                        "plateRoseGold",
                        'g',
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                        'h',
                        "plateRoseGold",
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 28)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 5),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "magicales", 1, 0),
                        'b',
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartArrowHead",
                                1,
                                1520,
                                "{material:\"Titanium\"}"),
                        'c',
                        getModItem(BloodMagic.ID, "magicales", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'g',
                        getModItem(BloodMagic.ID, "magicales", 1, 0),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "magicales", 1, 0)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 6),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "sanctus", 1, 0),
                        'b',
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                        'c',
                        getModItem(BloodMagic.ID, "sanctus", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'g',
                        getModItem(BloodMagic.ID, "sanctus", 1, 0),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "sanctus", 1, 0)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 7),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "incendium", 1, 0),
                        'b',
                        getModItem(Minecraft.ID, "fire_charge", 1, 0),
                        'c',
                        getModItem(BloodMagic.ID, "incendium", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'g',
                        getModItem(BloodMagic.ID, "incendium", 1, 0),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "incendium", 1, 0)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 10),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "incendium", 1, 0),
                        'b',
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0),
                        'c',
                        getModItem(BloodMagic.ID, "incendium", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'g',
                        getModItem(BloodMagic.ID, "incendium", 1, 0),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "incendium", 1, 0)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 11),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "crystallos", 1, 0),
                        'b',
                        getModItem(Thaumcraft.ID, "FocusFrost", 1, 0),
                        'c',
                        getModItem(BloodMagic.ID, "crystallos", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'g',
                        getModItem(BloodMagic.ID, "crystallos", 1, 0),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "crystallos", 1, 0)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 12),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "aether", 1, 0),
                        'b',
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1L),
                        'c',
                        getModItem(BloodMagic.ID, "aether", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'g',
                        getModItem(BloodMagic.ID, "aether", 1, 0),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "aether", 1, 0)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 13),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "terrae", 1, 0),
                        'b',
                        GTOreDictUnificator.get(OrePrefixes.gemFlawless, Materials.Diamond, 1L),
                        'c',
                        getModItem(BloodMagic.ID, "terrae", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'g',
                        getModItem(BloodMagic.ID, "terrae", 1, 0),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "terrae", 1, 0)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 18),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3),
                        'b',
                        "plateRoseGold",
                        'c',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'g',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 19),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 0),
                        'b',
                        getModItem(Thaumcraft.ID, "ItemSwordThaumium", 1, 0),
                        'c',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'g',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 0),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 0)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 20),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1),
                        'b',
                        getModItem(Thaumcraft.ID, "ItemChestplateThaumium", 1, 0),
                        'c',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'g',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 21),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 2),
                        'b',
                        getModItem(EnderIO.ID, "itemMaterial", 1, 8),
                        'c',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 2),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'g',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 2),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 2)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 22),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6),
                        'b',
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard),
                        'c',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'g',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 23),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 7),
                        'b',
                        "plateSoularium",
                        'c',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 7),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'g',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 7),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 7)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 24),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                        'b',
                        getModItem(EnderIO.ID, "itemMaterial", 1, 6),
                        'c',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'g',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 26),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "terrae", 1, 0),
                        'b',
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 6),
                        'c',
                        getModItem(BloodMagic.ID, "terrae", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        'g',
                        getModItem(BloodMagic.ID, "terrae", 1, 0),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "terrae", 1, 0)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 8),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                        'b',
                        "plateTitanium",
                        'c',
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0),
                        'f',
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                        'g',
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                        'h',
                        "plateTitanium",
                        'i',
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 14),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                        'b',
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                        'e',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 2),
                        'g',
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                        'h',
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 2)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 2),
                        'b',
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0),
                        'c',
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 2),
                        'e',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0),
                        'f',
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                        'h',
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "blockConduit", 1, 0),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0),
                        'b',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0),
                        'c',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 2),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 2),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 2),
                        'g',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0),
                        'h',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellParadigm", 1, 0),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "plateRoseGold",
                        'b',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                        'c',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 8),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 5),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9),
                        'g',
                        "plateRoseGold",
                        'h',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellParadigm", 1, 1),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "plateRoseGold",
                        'b',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                        'c',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 8),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 6),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9),
                        'g',
                        "plateRoseGold",
                        'h',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellParadigm", 1, 2),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "plateRoseGold",
                        'b',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                        'c',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 8),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 7),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9),
                        'g',
                        "plateRoseGold",
                        'h',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellParadigm", 1, 3),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "plateRoseGold",
                        'b',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25),
                        'c',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0),
                        'd',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 8),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 26),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9),
                        'g',
                        "plateRoseGold",
                        'h',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25)));
    }

    private void altarAlchemyRecipes() {
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "weakBloodOrb", 1, 0),
                NHItemList.WeakOrb.get(),
                1,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "apprenticeBloodOrb", 1, 0),
                NHItemList.ApprenticeOrb.get(),
                2,
                10000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0),
                NHItemList.MagicianOrb.get(),
                3,
                30000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0),
                NHItemList.MasterOrb.get(),
                4,
                60000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "archmageBloodOrb", 1, 0),
                NHItemList.ArchmageOrb.get(),
                5,
                120000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "transcendentBloodOrb", 1, 0),
                NHItemList.TranscendentOrb.get(),
                6,
                300000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                NHItemList.ArcaneSlate.get(),
                1,
                1000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                2,
                2500,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0),
                3,
                7500,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                4,
                20000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0),
                5,
                60000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                Materials.LifeEssence.getCells(1),
                Materials.Empty.getCells(1),
                1,
                1000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "alchemyFlask", 1, 0),
                getModItem(Thaumcraft.ID, "ItemEssence", 1, 0),
                2,
                4000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "blankSpell", 1, 0),
                createItemStack(IndustrialCraft2.ID, "itemBatCrystal", 1, 1, "{charge:1000000.0d}"),
                2,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "daggerOfSacrifice", 1, 0),
                getModItem(BloodMagic.ID, "sacrificialKnife", 1, 0),
                2,
                10000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "activationCrystal", 1, 0),
                getModItem(BloodMagic.ID, "blankSpell", 1, 0),
                3,
                20000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "bloodSocket", 1, 0),
                getModItem(BloodMagic.ID, "emptySocket", 1, 0),
                3,
                40000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "waterScribeTool", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                3,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "fireScribeTool", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                3,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "earthScribeTool", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                3,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "airScribeTool", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                3,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "duskScribeTool", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                4,
                10000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "dawnScribeTool", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                6,
                100000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 32),
                getModItem(EnderZoo.ID, "enderFragment", 1, 0),
                4,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "enhancedTelepositionFocus", 1, 0),
                getModItem(BloodMagic.ID, "telepositionFocus", 1, 0),
                4,
                20000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                BlockList.BloodyThaumium.get(),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 4),
                2,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                BlockList.BloodyVoid.get(),
                getModItem(ThaumicBases.ID, "voidBlock", 1, 0),
                3,
                10000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                BlockList.BloodyIchorium.get(),
                GTOreDictUnificator.get(OrePrefixes.block, Materials.Ichorium, 1L),
                5,
                50000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0),
                getModItem(BloodArsenal.ID, "blood_infused_diamond_active", 1, 0),
                5,
                10000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(Railcraft.ID, "brick.bloodstained", 1, 2),
                getModItem(Minecraft.ID, "sandstone", 1, 2),
                2,
                3500,
                20,
                20,
                false);
        BindingRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "energySword", 1, 0),
                getModItem(Thaumcraft.ID, "ItemSwordElemental", 1, 0));
        BindingRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "boundPickaxe", 1, 0),
                getModItem(Thaumcraft.ID, "ItemPickaxeElemental", 1, 0));
        BindingRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "boundAxe", 1, 0),
                getModItem(Thaumcraft.ID, "ItemAxeElemental", 1, 0));
        BindingRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "boundShovel", 1, 0),
                getModItem(Thaumcraft.ID, "ItemShovelElemental", 1, 0));
        BindingRegistry.registerRecipe(getModItem(BloodMagic.ID, "energyBlaster", 1, 0), NHItemList.Blaster.get(1));
        BindingRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.NetherQuartz, 1L));
        BindingRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.CertusQuartz, 1L));
        BindingRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Quartzite, 1L));

        UnbindingRegistry.unbindingRecipes.clear();
        UnbindingRegistry.addAllUnbindingRecipesFromBinding();

        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "largeBloodStoneBrick", 4, 0),
                25,
                new ItemStack[] { getModItem(BloodMagic.ID, "ritualStone", 1, 0),
                        getModItem(BloodMagic.ID, "ritualStone", 1, 0), getModItem(BloodMagic.ID, "ritualStone", 1, 0),
                        getModItem(BloodMagic.ID, "ritualStone", 1, 0),
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0),
                5,
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemEssence", 1, 0), getModItem(Genetics.ID, "misc", 1, 4),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0), getModItem(Minecraft.ID, "redstone", 1, 0),
                        getModItem(Minecraft.ID, "gunpowder", 1, 0) },
                1);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "crystallos", 1, 0),
                10,
                new ItemStack[] { getModItem(BiomesOPlenty.ID, "hardIce", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 1L),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "sanctus", 1, 0),
                10,
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.dust, Materials.RoseGold, 1L),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "weakFillingAgent", 1, 0),
                20,
                new ItemStack[] { getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0), getModItem(Minecraft.ID, "redstone", 1, 0),
                        getModItem(Minecraft.ID, "nether_wart", 1, 0), getModItem(Minecraft.ID, "blaze_powder", 1, 0) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "weakBindingAgent", 1, 0),
                20,
                new ItemStack[] { getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "mundaneLengtheningCatalyst", 1, 0),
                40,
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
                        getModItem(Minecraft.ID, "redstone", 1, 0), getModItem(Minecraft.ID, "redstone", 1, 0),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0),
                        getModItem(BloodMagic.ID, "weakBindingAgent", 1, 0) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "averageLengtheningCatalyst", 1, 0),
                60,
                new ItemStack[] { getModItem(BloodMagic.ID, "standardBindingAgent", 1, 0),
                        getModItem(BloodMagic.ID, "mundaneLengtheningCatalyst", 1, 0),
                        getModItem(BloodMagic.ID, "mundaneLengtheningCatalyst", 1, 0),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3) },
                4);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "greaterLengtheningCatalyst", 1, 0),
                80,
                new ItemStack[] { getModItem(BloodMagic.ID, "aquasalus", 1, 0),
                        getModItem(BloodMagic.ID, "averageLengtheningCatalyst", 1, 0),
                        getModItem(BloodMagic.ID, "averageLengtheningCatalyst", 1, 0),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3) },
                4);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "mundanePowerCatalyst", 1, 0),
                40,
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0),
                        getModItem(BloodMagic.ID, "weakBindingAgent", 1, 0) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "averagePowerCatalyst", 1, 0),
                60,
                new ItemStack[] { getModItem(BloodMagic.ID, "standardBindingAgent", 1, 0),
                        getModItem(BloodMagic.ID, "mundanePowerCatalyst", 1, 0),
                        getModItem(BloodMagic.ID, "mundanePowerCatalyst", 1, 0),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3) },
                4);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "greaterPowerCatalyst", 1, 0),
                80,
                new ItemStack[] { getModItem(BloodMagic.ID, "incendium", 1, 0),
                        getModItem(BloodMagic.ID, "averagePowerCatalyst", 1, 0),
                        getModItem(BloodMagic.ID, "averagePowerCatalyst", 1, 0),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3) },
                4);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "standardBindingAgent", 1, 0),
                40,
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
                        getModItem(BloodMagic.ID, "weakBindingAgent", 1, 0),
                        getModItem(BloodMagic.ID, "weakBindingAgent", 1, 0), getModItem(BloodMagic.ID, "sanctus", 1, 0),
                        getModItem(BloodMagic.ID, "crystallos", 1, 0) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "aether", 1, 0),
                10,
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8),
                        getModItem(Minecraft.ID, "feather", 1, 0), getModItem(Minecraft.ID, "feather", 1, 0),
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(Minecraft.ID, "web", 1, 0),
                5,
                new ItemStack[] { getModItem(Minecraft.ID, "string", 1, 0), getModItem(Minecraft.ID, "string", 1, 0),
                        getModItem(Minecraft.ID, "string", 1, 0), getModItem(Minecraft.ID, "string", 1, 0),
                        getModItem(Minecraft.ID, "string", 1, 0) },
                1);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 5),
                5,
                new ItemStack[] { getModItem(Minecraft.ID, "bone", 1, 0), getModItem(Minecraft.ID, "bone", 1, 0),
                        getModItem(Minecraft.ID, "bone", 1, 0), getModItem(Minecraft.ID, "bone", 1, 0),
                        getModItem(Minecraft.ID, "gunpowder", 1, 0) },
                1);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(Minecraft.ID, "leather", 3, 0),
                6,
                new ItemStack[] { getModItem(Minecraft.ID, "rotten_flesh", 1, 0),
                        getModItem(Minecraft.ID, "rotten_flesh", 1, 0), getModItem(Minecraft.ID, "rotten_flesh", 1, 0),
                        getModItem(Minecraft.ID, "water_bucket", 1, 0), getModItem(Minecraft.ID, "flint", 1, 0) },
                1);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(Minecraft.ID, "fire_charge", 1, 0),
                9,
                new ItemStack[] { getModItem(Minecraft.ID, "blaze_powder", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                        getModItem(Minecraft.ID, "gunpowder", 1, 0) },
                1);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "incendium", 1, 0),
                10,
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.dust, Materials.InfusedFire, 1L),
                        getModItem(Minecraft.ID, "blaze_powder", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Firestone, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Netherrack, 1L),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "magicales", 1, 0),
                10,
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 1L),
                        getModItem(Minecraft.ID, "gunpowder", 1, 0),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "crepitous", 1, 0),
                10,
                new ItemStack[] { getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                        getModItem(Minecraft.ID, "gunpowder", 1, 0), getModItem(Minecraft.ID, "gunpowder", 1, 0),
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "terrae", 1, 0),
                10,
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 45),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BasalticMineralSand, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.GraniticMineralSand, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "aquasalus", 1, 0),
                10,
                new ItemStack[] { getModItem(Natura.ID, "waterdrop", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.InfusedWater, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.InfusedWater, 1L),
                        getModItem(Minecraft.ID, "dye", 1, 0), getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "tennebrae", 1, 0),
                10,
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1L),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "activationCrystal", 1, 1),
                500,
                new ItemStack[] { getModItem(BloodMagic.ID, "activationCrystal", 1, 0),
                        getModItem(BloodMagic.ID, "demonBloodShard", 1, 0),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 0),
                        getModItem(BloodMagic.ID, "aquasalus", 1, 0), getModItem(BloodMagic.ID, "aether", 1, 0) },
                4);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "standardFillingAgent", 1, 0),
                40,
                new ItemStack[] { getModItem(BloodMagic.ID, "weakFillingAgent", 1, 0),
                        getModItem(BloodMagic.ID, "terrae", 1, 0), getModItem(BloodMagic.ID, "aquasalus", 1, 0) },
                4);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "enhancedFillingAgent", 1, 0),
                60,
                new ItemStack[] { getModItem(BloodMagic.ID, "standardFillingAgent", 1, 0),
                        getModItem(BloodMagic.ID, "magicales", 1, 0), getModItem(BloodMagic.ID, "crystallos", 1, 0),
                        getModItem(BloodMagic.ID, "aether", 1, 0), getModItem(BloodMagic.ID, "sanctus", 1, 0) },
                4);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3),
                15,
                new ItemStack[] { getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0),
                        getModItem(BloodMagic.ID, "terrae", 1, 0), getModItem(BloodMagic.ID, "terrae", 1, 0),
                        getModItem(Minecraft.ID, "dye", 1, 15), getModItem(Minecraft.ID, "nether_wart", 1, 0) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 4),
                30,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 5),
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gold, 1L) },
                4);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "itemComplexSpellCrystal", 1, 0),
                150,
                new ItemStack[] { getModItem(BloodMagic.ID, "blankSpell", 1, 0),
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0), NHItemList.EngravedGoldChip.get(1),
                        NHItemList.EngravedDiamondCrystalChip.get() },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 2, 15),
                20,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 4),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0), getModItem(BloodMagic.ID, "imbuedSlate", 1, 0),
                        getModItem(BloodMagic.ID, "magicales", 1, 0), getModItem(BloodMagic.ID, "magicales", 1, 0) },
                4);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 16),
                60,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 15),
                        getModItem(BloodMagic.ID, "terrae", 1, 0), getModItem(BloodMagic.ID, "terrae", 1, 0),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0) },
                5);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17),
                120,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 16),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 16),
                        getModItem(BloodMagic.ID, "aquasalus", 1, 0), getModItem(BloodMagic.ID, "incendium", 1, 0) },
                5);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 30),
                250,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 29),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 29),
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27) },
                6);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 0),
                20,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3),
                        getModItem(BloodMagic.ID, "incendium", 1, 0), getModItem(BloodMagic.ID, "incendium", 1, 0),
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartArrowHead",
                                1,
                                1520,
                                "{material:\"Titanium\"}"),
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartArrowHead",
                                1,
                                1520,
                                "{material:\"Titanium\"}") },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1),
                20,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3),
                        getModItem(BloodMagic.ID, "tennebrae", 1, 0), getModItem(BloodMagic.ID, "tennebrae", 1, 0),
                        getModItem(Witchery.ID, "ingredient", 1, 56), getModItem(Witchery.ID, "ingredient", 1, 56) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 2),
                20,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3),
                        getModItem(BloodMagic.ID, "terrae", 1, 0), getModItem(BloodMagic.ID, "terrae", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.InfusedEarth, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.InfusedEarth, 1L) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6),
                40,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.FierySteel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.FierySteel, 1L),
                        NHItemList.ChargedCertusQuartzDust.get(), NHItemList.ChargedCertusQuartzDust.get() },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 7),
                40,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 1L) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8),
                40,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3),
                        getModItem(IndustrialCraft2.ID, "itemDust2", 1, 2),
                        getModItem(IndustrialCraft2.ID, "itemDust2", 1, 2),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 1L) },
                3);
    }
}
