package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.BloodMagic;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.ElectroMagicTools;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.EnderStorage;
import static gregtech.api.enums.Mods.EnderZoo;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.Genetics;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.enums.Mods.MineAndBladeBattleGear2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCompressorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCutterRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import WayofTime.alchemicalWizardry.api.alchemy.AlchemyRecipeRegistry;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
import WayofTime.alchemicalWizardry.api.bindingRegistry.BindingRegistry;
import WayofTime.alchemicalWizardry.api.items.ShapedBloodOrbRecipe;

import com.dreammaster.bloodmagic.BloodMagicHelper;
import com.dreammaster.thaumcraft.TCHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.GT_Values;

public class ScriptBloodMagic implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Blood Magic";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                BloodMagic.ID,
                BloodArsenal.ID,
                Thaumcraft.ID,
                Witchery.ID,
                ExtraUtilities.ID,
                EnderIO.ID,
                TinkerConstruct.ID,
                MineAndBladeBattleGear2.ID,
                Railcraft.ID,
                IndustrialCraft2.ID,
                BuildCraftFactory.ID,
                IronChests.ID,
                ThaumicTinkerer.ID,
                IronTanks.ID,
                ElectroMagicTools.ID,
                StevesCarts2.ID,
                EnderStorage.ID,
                DraconicEvolution.ID,
                Avaritia.ID,
                ForbiddenMagic.ID,
                AppliedEnergistics2.ID,
                BiomesOPlenty.ID,
                EnderZoo.ID,
                Genetics.ID,
                ThaumicBases.ID,
                TwilightForest.ID);
    }

    @Override
    public void loadRecipes() {

        addShapelessCraftingRecipe(
                getModItem(BloodMagic.ID, "telepositionFocus", 1, 0, missing),
                new Object[] { getModItem(BloodMagic.ID, "telepositionFocus", 1, 0, missing) });
        addShapedRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 3, 2, missing),
                new Object[] { "platePlastic", "platePlastic", "platePlastic",
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing), "platePlastic", "platePlastic",
                        "platePlastic" });
        addShapedRecipe(
                getModItem(BloodMagic.ID, "inputRoutingFocus", 1, 0, missing),
                new Object[] { getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 32, missing),
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(BloodMagic.ID, "bloodMagicIncenseItem", 1, 0, missing),
                new Object[] { getModItem(Witchery.ID, "ingredient", 1, 18, missing),
                        getModItem(Witchery.ID, "ingredient", 1, 18, missing),
                        getModItem(Witchery.ID, "ingredient", 1, 18, missing),
                        getModItem(Witchery.ID, "ingredient", 1, 18, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2816, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2816, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                        getModItem(BiomesOPlenty.ID, "misc", 1, 1, missing) });
        addShapedRecipe(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellModifier", 1, 0, missing),
                new Object[] { getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing), "plateRoseGold",
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 14, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 18, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing), "plateRoseGold",
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing) });
        addShapedRecipe(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellModifier", 1, 1, missing),
                new Object[] { getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing), "plateRoseGold",
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 14, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 19, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing), "plateRoseGold",
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing) });
        addShapedRecipe(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellModifier", 1, 2, missing),
                new Object[] { getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing), "plateRoseGold",
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 14, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 20, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing), "plateRoseGold",
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing) });
        addShapedRecipe(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellModifier", 1, 3, missing),
                new Object[] { getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing), "plateRoseGold",
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 14, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 21, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing), "plateRoseGold",
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing) });
        addShapedRecipe(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellEffect", 1, 0, missing),
                new Object[] { getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing), "plateBlueSteel",
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 14, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 10, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing), "plateBlueSteel",
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing) });
        addShapedRecipe(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellEffect", 1, 1, missing),
                new Object[] { getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing), "plateBlueSteel",
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 14, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 11, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing), "plateBlueSteel",
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing) });
        addShapedRecipe(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellEffect", 1, 2, missing),
                new Object[] { getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing), "plateBlueSteel",
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 14, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 12, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing), "plateBlueSteel",
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing) });
        addShapedRecipe(
                getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellEffect", 1, 3, missing),
                new Object[] { getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing), "plateBlueSteel",
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 14, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 13, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing), "plateBlueSteel",
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing) });

        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "weakBloodOrb", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "apprenticeBloodOrb", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "archmageBloodOrb", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "transcendentBloodOrb", 1, 0, missing));
        BloodMagicHelper.removeBindingRecipe(getModItem(BloodMagic.ID, "energySword", 1, 0, missing));
        BloodMagicHelper.removeBindingRecipe(getModItem(BloodMagic.ID, "boundPickaxe", 1, 0, missing));
        BloodMagicHelper.removeBindingRecipe(getModItem(BloodMagic.ID, "boundAxe", 1, 0, missing));
        BloodMagicHelper.removeBindingRecipe(getModItem(BloodMagic.ID, "boundShovel", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodArsenal.ID, "blood_stone", 1, 1, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "crystallos", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "sanctus", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "weakFillingAgent", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "alchemyFlask", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "weakBindingAgent", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "standardBindingAgent", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "mundaneLengtheningCatalyst", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "averageLengtheningCatalyst", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "greaterLengtheningCatalyst", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "mundanePowerCatalyst", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "averagePowerCatalyst", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "greaterPowerCatalyst", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "blankSpell", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "aether", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(Minecraft.ID, "web", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 5, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(Minecraft.ID, "leather", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(Minecraft.ID, "fire_charge", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "daggerOfSacrifice", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "incendium", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "magicales", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "crepitous", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "terrae", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "aquasalus", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "tennebrae", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "activationCrystal", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "bloodSocket", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "waterScribeTool", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "fireScribeTool", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "earthScribeTool", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "airScribeTool", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "duskScribeTool", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "dawnScribeTool", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "activationCrystal", 1, 1, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "standardFillingAgent", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "enhancedFillingAgent", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "telepositionFocus", 1, 0, missing));
        BloodMagicHelper.removeAltarRecipe(getModItem(BloodMagic.ID, "enhancedTelepositionFocus", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 4, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "itemComplexSpellCrystal", 1, 0, missing));
        BloodMagicHelper.removeBindingRecipe(getModItem(BloodMagic.ID, "energyBlaster", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 15, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 16, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 30, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 0, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 2, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 7, missing));
        BloodMagicHelper.removeAlchemyRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing));

        orbRecipes();
        altarAlchemyRecipes();

        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.ArcaneSlate", 9, 0, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodMagic.ID, "blankSlate", 9, 0, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodMagic.ID, "reinforcedSlate", 9, 0, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodMagic.ID, "imbuedSlate", 9, 0, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodMagic.ID, "demonicSlate", 9, 0, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 9, 27, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "blankSlate", 4, 0, missing),
                        getModItem(BloodMagic.ID, "weakBloodOrb", 0, 0, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 1152)).noFluidOutputs().duration(200).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "blankSlate", 4, 0, missing),
                        getModItem(BloodMagic.ID, "apprenticeBloodOrb", 0, 0, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 1152)).noFluidOutputs().duration(200).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "blankSlate", 4, 0, missing),
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 0, 0, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 1152)).noFluidOutputs().duration(200).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "blankSlate", 4, 0, missing),
                        getModItem(BloodMagic.ID, "masterBloodOrb", 0, 0, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 1152)).noFluidOutputs().duration(200).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "blankSlate", 4, 0, missing),
                        getModItem(BloodMagic.ID, "archmageBloodOrb", 0, 0, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 1152)).noFluidOutputs().duration(200).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "blankSlate", 4, 0, missing),
                        getModItem(BloodMagic.ID, "transcendentBloodOrb", 0, 0, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 1152)).noFluidOutputs().duration(200).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "blankSlate", 4, 0, missing),
                        getModItem(BloodArsenal.ID, "transparent_orb", 0, 0, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 1152)).noFluidOutputs().duration(200).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "blankSlate", 4, 0, missing),
                        getModItem(ForbiddenMagic.ID, "EldritchOrb", 0, 0, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 1152)).noFluidOutputs().duration(200).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "blankSlate", 4, 0, missing),
                        getModItem(Avaritia.ID, "Orb_Armok", 0, 0, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 1152)).noFluidOutputs().duration(200).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 0, missing),
                        getModItem(Minecraft.ID, "redstone_torch", 2, 0, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "ritualDismantler", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "inputRoutingFocus", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "outputRoutingFocus", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "inputRoutingFocus", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "outputRoutingFocus", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "inputRoutingFocus", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "outputRoutingFocus", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "inputRoutingFocus", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "outputRoutingFocus", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodMagic.ID, "inputRoutingFocus", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "outputRoutingFocus", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.ArcaneSlate", 9, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lifeessence", 1000)).noFluidOutputs().duration(200).eut(48)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 0, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "blankSlate", 9, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lifeessence", 1000)).noFluidOutputs().duration(400).eut(64)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 1, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "reinforcedSlate", 9, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lifeessence", 1000)).noFluidOutputs().duration(600).eut(120)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 2, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "imbuedSlate", 9, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lifeessence", 1000)).noFluidOutputs().duration(800).eut(480)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 3, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "demonicSlate", 9, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lifeessence", 1000)).noFluidOutputs().duration(1000).eut(1920)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 4, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 9, 27, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lifeessence", 1000)).noFluidOutputs().duration(1200).eut(7680)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0, missing))
                .itemOutputs(getModItem(BloodMagic.ID, "blankSlate", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lifeessence", 250)).noFluidOutputs().duration(400).eut(64)
                .addTo(sCutterRecipes);

        TCHelper.removeInfusionRecipe(getModItem(BloodArsenal.ID, "wand_caps", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(BloodArsenal.ID, "wand_cores", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(BloodArsenal.ID, "wand_cores", 1, 1, missing));
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
                getModItem(BloodMagic.ID, "Altar", 1, 0, missing))
                        .setPages(
                                new ResearchPage("tc.research_page.BLOODALTAR.1"),
                                new ResearchPage("tc.research_page.BLOODALTAR.2"),
                                new ResearchPage("tc.research_page.BLOODALTAR.3"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BLOODALTAR",
                getModItem(BloodMagic.ID, "Altar", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("terra"), 20).add(Aspect.getAspect("aqua"), 20)
                        .add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("perditio"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7, missing),
                'b',
                getModItem(Witchery.ID, "ingredient", 1, 10, missing),
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7, missing),
                'd',
                getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 1, missing),
                'e',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 0, missing),
                'f',
                getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 1, missing),
                'g',
                getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing),
                'h',
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 0, missing),
                'i',
                getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing));
        TCHelper.addResearchPage(
                "BLOODALTAR",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "Altar", 1, 0, missing))));
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
                getModItem(BloodArsenal.ID, "life_infuser", 1, 0, missing))
                        .setParents("BLOODALTAR", "INFUSION")
                        .setPages(
                                new ResearchPage("tc.research_page.LIFEINFUSER.1"),
                                new ResearchPage("tc.research_page.LIFEINFUSER.2"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "LIFEINFUSER",
                getModItem(BloodArsenal.ID, "life_infuser", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("victus"), 32).add(Aspect.getAspect("alienis"), 32)
                        .add(Aspect.getAspect("praecantatio"), 24).add(Aspect.getAspect("auram"), 16)
                        .add(Aspect.getAspect("fames"), 8).add(Aspect.getAspect("terra"), 8),
                getModItem(BloodMagic.ID, "Altar", 1, 0, missing),
                new ItemStack[] { getModItem(Minecraft.ID, "nether_star", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22977, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22977, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22977, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22977, missing), });
        TCHelper.addResearchPage(
                "LIFEINFUSER",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "life_infuser", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("LIFEINFUSER", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "LIFEINFUSER",
                getModItem(BloodArsenal.ID, "lp_materializer", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("aqua"), 50).add(Aspect.getAspect("ordo"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'b',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                'c',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'd',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                'e',
                getModItem(Minecraft.ID, "nether_star", 1, 0, missing),
                'f',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                'g',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'h',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                'i',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing));
        TCHelper.addResearchPage(
                "LIFEINFUSER",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(BloodArsenal.ID, "lp_materializer", 1, 0, missing))));
        new ResearchItem(
                "SOULCOMPACTER",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("spiritus"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("lucrum"), 9)
                        .add(Aspect.getAspect("vacuos"), 6).add(Aspect.getAspect("cognitio"), 3),
                0,
                -6,
                3,
                getModItem(BloodArsenal.ID, "compacter", 1, 0, missing)).setParents("MASTERRITUALSTONE")
                        .setPages(new ResearchPage("tc.research_page.SOULCOMPACTER")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SOULCOMPACTER",
                getModItem(BloodArsenal.ID, "compacter", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("ignis"), 75)
                        .add(Aspect.getAspect("terra"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                'b',
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                'c',
                getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                'd',
                getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32644, missing),
                'f',
                getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0, missing),
                'g',
                getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0, missing),
                'h',
                getModItem(BloodMagic.ID, "masterStone", 1, 0, missing),
                'i',
                getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0, missing));
        TCHelper.addResearchPage(
                "SOULCOMPACTER",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodArsenal.ID, "compacter", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "sacrificialKnife", 1, 0, missing))
                        .setParents("BLOODALTAR")
                        .setPages(
                                new ResearchPage("tc.research_page.SACRIFICIALKNIFE.1"),
                                new ResearchPage("tc.research_page.SACRIFICIALKNIFE.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SACRIFICIALKNIFE",
                getModItem(BloodMagic.ID, "sacrificialKnife", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("perditio"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "screwSteel",
                'b',
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                'c',
                "craftingToolScrewdriver",
                'd',
                "plateAluminium",
                'e',
                getModItem(MineAndBladeBattleGear2.ID, "dagger.diamond", 1, 0, missing),
                'f',
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                'g',
                "stickSteel",
                'h',
                "plateAluminium",
                'i',
                "screwSteel");
        TCHelper.addResearchPage(
                "SACRIFICIALKNIFE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "sacrificialKnife", 1, 0, missing))));
        new ResearchItem(
                "ALCHEMICCHEMSTRYSET",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("fabrico"), 15).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("victus"), 3),
                4,
                -4,
                3,
                getModItem(BloodMagic.ID, "blockWritingTable", 1, 0, missing))
                        .setParents("INFUSION", "SACRIFICIALKNIFE").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.ALCHEMICCHEMSTRYSET.1"),
                                new ResearchPage("tc.research_page.ALCHEMICCHEMSTRYSET.2"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ALCHEMICCHEMSTRYSET",
                getModItem(BloodMagic.ID, "blockWritingTable", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("fabrico"), 24).add(Aspect.getAspect("instrumentum"), 24)
                        .add(Aspect.getAspect("praecantatio"), 18).add(Aspect.getAspect("victus"), 12)
                        .add(Aspect.getAspect("ignis"), 12),
                getModItem(Minecraft.ID, "brewing_stand", 1, 0, missing),
                new ItemStack[] {
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"lifeessence\",Amount:1000}}",
                                missing),
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"lifeessence\",Amount:1000}}",
                                missing),
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"lifeessence\",Amount:1000}}",
                                missing),
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"lifeessence\",Amount:1000}}",
                                missing),
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"lifeessence\",Amount:1000}}",
                                missing),
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"lifeessence\",Amount:1000}}",
                                missing),
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "ALCHEMICCHEMSTRYSET",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "blockWritingTable", 1, 0, missing))));
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
                getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing))
                        .setParents("INFUSION", "ALCHEMICCHEMSTRYSET").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.AMORPHICCATALYST")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "AMORPHICCATALYST",
                getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("aqua"), 16).add(Aspect.getAspect("ignis"), 16)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("aer"), 16)
                        .add(Aspect.getAspect("ordo"), 16).add(Aspect.getAspect("perditio"), 16),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                new ItemStack[] { getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        getModItem(BloodMagic.ID, "crystallos", 1, 0, missing),
                        getModItem(BloodMagic.ID, "sanctus", 1, 0, missing),
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        getModItem(BloodMagic.ID, "crepitous", 1, 0, missing),
                        getModItem(BloodMagic.ID, "incendium", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aquasalus", 1, 0, missing),
                        getModItem(BloodMagic.ID, "tennebrae", 1, 0, missing), });
        TCHelper.addResearchPage(
                "AMORPHICCATALYST",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing))));
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
                getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0, missing))
                        .setParents("INFUSION", "AMORPHICCATALYST").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.BIDIAMONDBLOCK")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "BIDIAMONDBLOCK",
                getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0, missing),
                7,
                new AspectList().add(Aspect.getAspect("ira"), 32).add(Aspect.getAspect("alienis"), 16)
                        .add(Aspect.getAspect("victus"), 24).add(Aspect.getAspect("ignis"), 48)
                        .add(Aspect.getAspect("aqua"), 64).add(Aspect.getAspect("perditio"), 16),
                getModItem(Minecraft.ID, "diamond_block", 1, 0, missing),
                new ItemStack[] { getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0, missing), });
        TCHelper.addResearchPage(
                "BIDIAMONDBLOCK",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "divinationSigil", 1, 0, missing))
                        .setParents("INFUSION", "NITOR", "BLOODALTAR").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.DIVINATIONSIGIL.1"),
                                new ResearchPage("tc.research_page.DIVINATIONSIGIL.2"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "DIVINATIONSIGIL",
                getModItem(BloodMagic.ID, "divinationSigil", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("vitreus"), 24).add(Aspect.getAspect("terra"), 18)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("instrumentum"), 6)
                        .add(Aspect.getAspect("metallum"), 4),
                getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), });
        TCHelper.addResearchPage(
                "DIVINATIONSIGIL",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "divinationSigil", 1, 0, missing))));
        new ResearchItem(
                "SPEEDRUNE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("motus"), 15).add(Aspect.getAspect("volatus"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("fames"), 3),
                -2,
                0,
                3,
                getModItem(BloodMagic.ID, "speedRune", 1, 0, missing)).setParents("INFUSION", "BLOODALTAR")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.SPEEDRUNE.1"),
                                new ResearchPage("tc.research_page.SPEEDRUNE.2"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SPEEDRUNE",
                getModItem(BloodMagic.ID, "speedRune", 1, 0, missing),
                4,
                new AspectList().add(Aspect.getAspect("motus"), 24).add(Aspect.getAspect("volatus"), 24)
                        .add(Aspect.getAspect("potentia"), 18).add(Aspect.getAspect("aer"), 12)
                        .add(Aspect.getAspect("fames"), 4),
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0, missing),
                new ItemStack[] { getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SPEEDRUNE",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "speedRune", 1, 0, missing))));
        new ResearchItem(
                "IMPERFECTRITUALSTONE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("tenebrae"), 3),
                -2,
                -2,
                3,
                getModItem(BloodMagic.ID, "imperfectRitualStone", 1, 0, missing))
                        .setParents("BLOODALTAR")
                        .setPages(
                                new ResearchPage("tc.research_page.IMPERFECTRITUALSTONE.1"),
                                new ResearchPage("tc.research_page.IMPERFECTRITUALSTONE.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IMPERFECTRITUALSTONE",
                getModItem(BloodMagic.ID, "imperfectRitualStone", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 1).add(Aspect.getAspect("ignis"), 6)
                        .add(Aspect.getAspect("terra"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "obsidian", 1, 0, missing),
                'b',
                getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                'c',
                getModItem(Minecraft.ID, "obsidian", 1, 0, missing),
                'd',
                getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                'e',
                getModItem(BloodArsenal.ID, "blood_stone", 1, 0, missing),
                'f',
                getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                'g',
                getModItem(Minecraft.ID, "obsidian", 1, 0, missing),
                'h',
                getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                'i',
                getModItem(Minecraft.ID, "obsidian", 1, 0, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IMPERFECTRITUALSTONE",
                getModItem(BloodMagic.ID, "imperfectRitualStone", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 2).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("terra"), 16),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Minecraft.ID, "obsidian", 1, 0, missing),
                'd',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                'e',
                getModItem(Railcraft.ID, "brick.bloodstained", 1, 2, missing),
                'f',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                'h',
                getModItem(Minecraft.ID, "obsidian", 1, 0, missing));
        TCHelper.addResearchPage(
                "IMPERFECTRITUALSTONE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "imperfectRitualStone", 1, 0, missing))));
        new ResearchItem(
                "RITUALSTONE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("aer"), 3),
                -2,
                -4,
                3,
                getModItem(BloodMagic.ID, "ritualStone", 1, 0, missing)).setParents("INFUSION", "IMPERFECTRITUALSTONE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.RITUALSTONE"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RITUALSTONE",
                getModItem(BloodMagic.ID, "ritualStone", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("terra"), 12).add(Aspect.getAspect("ignis"), 9)
                        .add(Aspect.getAspect("tenebrae"), 6).add(Aspect.getAspect("praecantatio"), 3)
                        .add(Aspect.getAspect("aer"), 2),
                getModItem(BloodMagic.ID, "imperfectRitualStone", 1, 0, missing),
                new ItemStack[] { getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1, missing),
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1, missing),
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing), });
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RITUALSTONE",
                getModItem(BloodMagic.ID, "ritualStone", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 3).add(Aspect.getAspect("ignis"), 18)
                        .add(Aspect.getAspect("terra"), 24),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "obsidian", 1, 0, missing),
                'b',
                getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                'c',
                getModItem(Minecraft.ID, "obsidian", 1, 0, missing),
                'd',
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                'e',
                getModItem(BloodMagic.ID, "imperfectRitualStone", 1, 0, missing),
                'f',
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                'g',
                getModItem(Minecraft.ID, "obsidian", 1, 0, missing),
                'h',
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                'i',
                getModItem(Minecraft.ID, "obsidian", 1, 0, missing));
        TCHelper.addResearchPage(
                "RITUALSTONE",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "ritualStone", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "blockHomHeart", 1, 0, missing)).setParents("INFUSION", "RITUALSTONE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SPELLTABLE"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SPELLTABLE",
                getModItem(BloodMagic.ID, "blockHomHeart", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 40).add(Aspect.getAspect("ignis"), 40)
                        .add(Aspect.getAspect("terra"), 40).add(Aspect.getAspect("aqua"), 40)
                        .add(Aspect.getAspect("ordo"), 40).add(Aspect.getAspect("perditio"), 40),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "largeBloodStoneBrick", 1, 0, missing),
                'b',
                getModItem(BloodMagic.ID, "largeBloodStoneBrick", 1, 0, missing),
                'c',
                getModItem(BloodMagic.ID, "largeBloodStoneBrick", 1, 0, missing),
                'd',
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                'f',
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1, missing),
                'g',
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1, missing),
                'h',
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1, missing),
                'i',
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1, missing));
        TCHelper.addResearchPage(
                "SPELLTABLE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "blockHomHeart", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "masterStone", 1, 0, missing)).setParents("INFUSION", "RITUALSTONE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.MASTERRITUALSTONE"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "MASTERRITUALSTONE",
                getModItem(BloodMagic.ID, "masterStone", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("terra"), 36).add(Aspect.getAspect("ignis"), 24)
                        .add(Aspect.getAspect("tenebrae"), 16).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("cognitio"), 8),
                getModItem(BloodMagic.ID, "ritualStone", 1, 0, missing),
                new ItemStack[] { getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_stone", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1, missing),
                        getModItem(BloodArsenal.ID, "blood_stone", 1, 1, missing),
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1, missing),
                        getModItem(BloodArsenal.ID, "blood_stone", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_stone", 1, 1, missing), });
        TCHelper.addResearchPage(
                "MASTERRITUALSTONE",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "masterStone", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "waterSigil", 1, 0, missing)).setParents("INFUSION", "DIVINATIONSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.WATERSIGIL"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "WATERSIGIL",
                getModItem(BloodMagic.ID, "waterSigil", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("aqua"), 40).add(Aspect.getAspect("terra"), 32)
                        .add(Aspect.getAspect("praecantatio"), 24).add(Aspect.getAspect("instrumentum"), 16)
                        .add(Aspect.getAspect("metallum"), 8),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                new ItemStack[] { getModItem(Witchery.ID, "divinerwater", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 1, missing),
                        getModItem(BloodMagic.ID, "aquasalus", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aquasalus", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 1, missing),
                        getModItem(BloodMagic.ID, "aquasalus", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aquasalus", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 1, missing), });
        TCHelper.addResearchPage(
                "WATERSIGIL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "waterSigil", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "lavaSigil", 1, 0, missing)).setParents("INFUSION", "SIGILOFTHEBLOODLAMP")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.LAVASIGIL")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "LAVASIGIL",
                getModItem(BloodMagic.ID, "lavaSigil", 1, 0, missing),
                7,
                new AspectList().add(Aspect.getAspect("ignis"), 64).add(Aspect.getAspect("terra"), 40)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("instrumentum"), 24)
                        .add(Aspect.getAspect("metallum"), 16),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                new ItemStack[] { getModItem(Witchery.ID, "divinerlava", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 2, missing),
                        getModItem(BloodMagic.ID, "incendium", 1, 0, missing),
                        getModItem(BloodMagic.ID, "incendium", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 2, missing),
                        getModItem(BloodMagic.ID, "lavaCrystal", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 2, missing),
                        getModItem(BloodMagic.ID, "incendium", 1, 0, missing),
                        getModItem(BloodMagic.ID, "incendium", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 2, missing), });
        TCHelper.addResearchPage(
                "LAVASIGIL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "lavaSigil", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing)).setParents("INFUSION", "BLOODALTAR")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.EMPTYCORE")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "EMPTYCORE",
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("perditio"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17351, missing),
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17306, missing),
                'e',
                getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17306, missing),
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17351, missing),
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing));
        TCHelper.addResearchPage(
                "EMPTYCORE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing))));
        new ResearchItem(
                "BMLAVACRYSTAL",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("infernus"), 12)
                        .add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("aer"), 3),
                0,
                -4,
                3,
                getModItem(BloodMagic.ID, "lavaCrystal", 1, 0, missing))
                        .setParents("INFUSION", "EMPTYCORE", "LAVACRYSTAL", "WARDEDARCANA").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.BMLAVACRYSTAL")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "BMLAVACRYSTAL",
                getModItem(BloodMagic.ID, "lavaCrystal", 1, 0, missing),
                4,
                new AspectList().add(Aspect.getAspect("ignis"), 24).add(Aspect.getAspect("terra"), 18)
                        .add(Aspect.getAspect("praecantatio"), 18).add(Aspect.getAspect("infernus"), 6)
                        .add(Aspect.getAspect("aer"), 6),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing),
                new ItemStack[] { getModItem(TinkerConstruct.ID, "materials", 1, 7, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 29500, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing), });
        TCHelper.addResearchPage(
                "BMLAVACRYSTAL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "lavaCrystal", 1, 0, missing))));
        new ResearchItem(
                "RUNESACRIFICE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("fames"), 15).add(Aspect.getAspect("infernus"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                -4,
                0,
                3,
                getModItem(BloodMagic.ID, "runeOfSacrifice", 1, 0, missing)).setParents("INFUSION", "SPEEDRUNE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.RUNESACRIFICE"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNESACRIFICE",
                getModItem(BloodMagic.ID, "runeOfSacrifice", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("fames"), 24).add(Aspect.getAspect("infernus"), 24)
                        .add(Aspect.getAspect("potentia"), 18).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("terra"), 4),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1, missing),
                new ItemStack[] { getModItem(BloodMagic.ID, "tennebrae", 1, 0, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "incendium", 1, 0, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "tennebrae", 1, 0, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "incendium", 1, 0, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "RUNESACRIFICE",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "runeOfSacrifice", 1, 0, missing))));
        new ResearchItem(
                "RUNESELFSACRIFICE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("fames"), 15).add(Aspect.getAspect("infernus"), 12)
                        .add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                -4,
                2,
                3,
                getModItem(BloodMagic.ID, "runeOfSelfSacrifice", 1, 0, missing)).setParents("INFUSION", "SPEEDRUNE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.RUNESELFSACRIFICE"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNESELFSACRIFICE",
                getModItem(BloodMagic.ID, "runeOfSelfSacrifice", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("fames"), 24).add(Aspect.getAspect("infernus"), 24)
                        .add(Aspect.getAspect("lucrum"), 18).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("terra"), 4),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1, missing),
                new ItemStack[] { getModItem(BloodMagic.ID, "tennebrae", 1, 0, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "sanctus", 1, 0, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "tennebrae", 1, 0, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "sanctus", 1, 0, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "RUNESELFSACRIFICE",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "runeOfSelfSacrifice", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "airSigil", 1, 0, missing)).setParents("INFUSION", "LAVASIGIL").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.AIRSIGIL")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "AIRSIGIL",
                getModItem(BloodMagic.ID, "airSigil", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("volatus"), 64).add(Aspect.getAspect("aer"), 48)
                        .add(Aspect.getAspect("motus"), 32).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("iter"), 18).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("cognitio"), 6),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                new ItemStack[] { getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 30004, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 30004, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 30004, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 30004, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing), });
        TCHelper.addResearchPage(
                "AIRSIGIL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "airSigil", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "sigilOfTheFastMiner", 1, 0, missing))
                        .setParents("INFUSION", "DIVINATIONSIGIL").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.FASTERMINING")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FASTERMINING",
                getModItem(BloodMagic.ID, "sigilOfTheFastMiner", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("instrumentum"), 36).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("metallum"), 18).add(Aspect.getAspect("perfodio"), 12)
                        .add(Aspect.getAspect("motus"), 8),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7, missing),
                        getModItem(Thaumcraft.ID, "ItemPickThaumium", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7, missing),
                        getModItem(Thaumcraft.ID, "ItemShovelThaumium", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7, missing),
                        getModItem(Thaumcraft.ID, "ItemAxeThaumium", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing), });
        TCHelper.addResearchPage(
                "FASTERMINING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "sigilOfTheFastMiner", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "growthSigil", 1, 0, missing)).setParents("INFUSION", "DIVINATIONSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.GREENGROW")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "GREENGROW",
                getModItem(BloodMagic.ID, "growthSigil", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("instrumentum"), 36).add(Aspect.getAspect("terra"), 24)
                        .add(Aspect.getAspect("herba"), 18).add(Aspect.getAspect("arbor"), 12)
                        .add(Aspect.getAspect("victus"), 8),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                new ItemStack[] { getModItem(Witchery.ID, "witchsapling", 1, 0, missing),
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        getModItem(Witchery.ID, "witchsapling", 1, 1, missing),
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 1, missing),
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 0, missing),
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "slime.sapling", 1, 0, missing),
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing), });
        TCHelper.addResearchPage(
                "GREENGROW",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "growthSigil", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "voidSigil", 1, 0, missing)).setParents("INFUSION", "WATERSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.VOIDSIGIL")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "VOIDSIGIL",
                getModItem(BloodMagic.ID, "voidSigil", 1, 0, missing),
                7,
                new AspectList().add(Aspect.getAspect("vacuos"), 64).add(Aspect.getAspect("terra"), 40)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("auram"), 24)
                        .add(Aspect.getAspect("metallum"), 16),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                new ItemStack[] { getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17970, missing),
                        getModItem(Minecraft.ID, "bucket", 1, 0, missing),
                        getModItem(BloodMagic.ID, "tennebrae", 1, 0, missing),
                        getModItem(Minecraft.ID, "bucket", 1, 0, missing),
                        getModItem(BloodMagic.ID, "tennebrae", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                        getModItem(BloodMagic.ID, "tennebrae", 1, 0, missing),
                        getModItem(Minecraft.ID, "bucket", 1, 0, missing),
                        getModItem(BloodMagic.ID, "tennebrae", 1, 0, missing),
                        getModItem(Minecraft.ID, "bucket", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17970, missing), });
        TCHelper.addResearchPage(
                "VOIDSIGIL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "voidSigil", 1, 0, missing))));
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
                getModItem(BloodArsenal.ID, "sigil_of_swimming", 1, 0, missing)).setParents("INFUSION", "VOIDSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFSWIMMING"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFSWIMMING",
                getModItem(BloodArsenal.ID, "sigil_of_swimming", 1, 0, missing),
                12,
                new AspectList().add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("aqua"), 64)
                        .add(Aspect.getAspect("vacuos"), 64).add(Aspect.getAspect("terra"), 48)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("auram"), 24)
                        .add(Aspect.getAspect("metallum"), 16),
                getModItem(BloodMagic.ID, "voidSigil", 1, 0, missing),
                new ItemStack[] { getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 30711, missing),
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"liquidoxygen\",Amount:1000}}",
                                missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 30711, missing),
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"liquidoxygen\",Amount:1000}}",
                                missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"liquidoxygen\",Amount:1000}}",
                                missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 30711, missing),
                        createItemStack(
                                IndustrialCraft2.ID,
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"liquidoxygen\",Amount:1000}}",
                                missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 30711, missing), });
        TCHelper.addResearchPage(
                "SIGILOFSWIMMING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "sigil_of_swimming", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "itemBloodPack", 1, 0, missing))
                        .setParents("SACRIFICIALKNIFE").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.BLOODLETTERSPACK.1"),
                                new ResearchPage("tc.research_page.BLOODLETTERSPACK.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BLOODLETTERSPACK",
                getModItem(BloodMagic.ID, "itemBloodPack", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 30).add(Aspect.getAspect("aqua"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                'b',
                getModItem(BloodMagic.ID, "sacrificialKnife", 1, 0, missing),
                'c',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                'd',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                'e',
                getModItem(Thaumcraft.ID, "ItemChestplateThaumium", 1, 0, missing),
                'f',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                'g',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                'h',
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                'i',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing));
        TCHelper.addResearchPage(
                "BLOODLETTERSPACK",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "itemBloodPack", 1, 0, missing))));
        new ResearchItem(
                "IMBUEARMOR",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("sano"), 15).add(Aspect.getAspect("tutamen"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("metallum"), 6)
                        .add(Aspect.getAspect("potentia"), 3),
                4,
                -6,
                3,
                createItemStack(BloodArsenal.ID, "life_imbued_chestplate", 1, 0, "{LPStored:0}", missing))
                        .setParents("BLOODLETTERSPACK").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.IMBUEARMOR")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IMBUEARMOR",
                createItemStack(BloodArsenal.ID, "life_imbued_helmet", 1, 0, "{LPStored:0}", missing),
                new AspectList().add(Aspect.getAspect("terra"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'b',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'c',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'd',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'e',
                getModItem(Thaumcraft.ID, "ItemHelmetThaumium", 1, 0, missing),
                'f',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'h',
                "craftingToolHardHammer");
        TCHelper.addResearchPage(
                "IMBUEARMOR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack(
                                        BloodArsenal.ID,
                                        "life_imbued_helmet",
                                        1,
                                        0,
                                        "{LPStored:0}",
                                        missing))));
        ThaumcraftApi.addWarpToResearch("IMBUEARMOR", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IMBUEARMOR",
                createItemStack(BloodArsenal.ID, "life_imbued_chestplate", 1, 0, "{LPStored:0}", missing),
                new AspectList().add(Aspect.getAspect("terra"), 60).add(Aspect.getAspect("ignis"), 60)
                        .add(Aspect.getAspect("ordo"), 60).add(Aspect.getAspect("perditio"), 60),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'b',
                getModItem(Thaumcraft.ID, "ItemChestplateThaumium", 1, 0, missing),
                'c',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'd',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'e',
                "craftingToolHardHammer",
                'f',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'g',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'h',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'i',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing));
        TCHelper.addResearchPage(
                "IMBUEARMOR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack(
                                        BloodArsenal.ID,
                                        "life_imbued_chestplate",
                                        1,
                                        0,
                                        "{LPStored:0}",
                                        missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IMBUEARMOR",
                createItemStack(BloodArsenal.ID, "life_imbued_leggings", 1, 0, "{LPStored:0}", missing),
                new AspectList().add(Aspect.getAspect("terra"), 45).add(Aspect.getAspect("ignis"), 45)
                        .add(Aspect.getAspect("ordo"), 45).add(Aspect.getAspect("perditio"), 45),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'b',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'c',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'd',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'e',
                getModItem(Thaumcraft.ID, "ItemLeggingsThaumium", 1, 0, missing),
                'f',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'g',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'h',
                "craftingToolHardHammer",
                'i',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing));
        TCHelper.addResearchPage(
                "IMBUEARMOR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack(
                                        BloodArsenal.ID,
                                        "life_imbued_leggings",
                                        1,
                                        0,
                                        "{LPStored:0}",
                                        missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IMBUEARMOR",
                createItemStack(BloodArsenal.ID, "life_imbued_boots", 1, 0, "{LPStored:0}", missing),
                new AspectList().add(Aspect.getAspect("terra"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'd',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'e',
                getModItem(Thaumcraft.ID, "ItemBootsThaumium", 1, 0, missing),
                'f',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'g',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing),
                'h',
                "craftingToolHardHammer",
                'i',
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 251, missing));
        TCHelper.addResearchPage(
                "IMBUEARMOR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack(BloodArsenal.ID, "life_imbued_boots", 1, 0, "{LPStored:0}", missing))));
        new ResearchItem(
                "WEAKORB",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                2,
                0,
                2,
                getModItem(NewHorizonsCoreMod.ID, "item.WeakOrb", 1, 0, missing)).setParents("BLOODALTAR")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.WEAKORB.1"),
                                new ResearchPage("tc.research_page.WEAKORB.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "WEAKORB",
                getModItem(NewHorizonsCoreMod.ID, "item.WeakOrb", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("aqua"), 20)
                        .add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("perditio"), 20).add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'b',
                "gemDiamond",
                'd',
                getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                'e',
                getModItem(NewHorizonsCoreMod.ID, "item.RawOrbTier1", 1, 0, missing),
                'f',
                getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                'h',
                "gemDiamond");
        TCHelper.addResearchPage(
                "WEAKORB",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(NewHorizonsCoreMod.ID, "item.WeakOrb", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("WEAKORB", 1);
        new ResearchItem(
                "APPRENTICEORB",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 12).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("cognitio"), 3),
                4,
                0,
                3,
                getModItem(NewHorizonsCoreMod.ID, "item.ApprenticeOrb", 1, 0, missing)).setParents("WEAKORB")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.APPRENTICEORB.1"),
                                new ResearchPage("tc.research_page.APPRENTICEORB.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "APPRENTICEORB",
                getModItem(NewHorizonsCoreMod.ID, "item.ApprenticeOrb", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 40).add(Aspect.getAspect("aqua"), 40)
                        .add(Aspect.getAspect("ignis"), 40).add(Aspect.getAspect("terra"), 40)
                        .add(Aspect.getAspect("perditio"), 40).add(Aspect.getAspect("ordo"), 40),
                "abc",
                "def",
                "ghi",
                'b',
                "gemFlawlessEmerald",
                'd',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                'e',
                getModItem(NewHorizonsCoreMod.ID, "item.RawOrbTier2", 1, 0, missing),
                'f',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                'h',
                "gemFlawlessEmerald");
        TCHelper.addResearchPage(
                "APPRENTICEORB",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(NewHorizonsCoreMod.ID, "item.ApprenticeOrb", 1, 0, missing))));
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
                getModItem(NewHorizonsCoreMod.ID, "item.MagicianOrb", 1, 0, missing)).setParents("APPRENTICEORB")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.MAGICANORB.1"),
                                new ResearchPage("tc.research_page.MAGICANORB.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MAGICANORB",
                getModItem(NewHorizonsCoreMod.ID, "item.MagicianOrb", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 60).add(Aspect.getAspect("aqua"), 60)
                        .add(Aspect.getAspect("ignis"), 60).add(Aspect.getAspect("terra"), 60)
                        .add(Aspect.getAspect("perditio"), 60).add(Aspect.getAspect("ordo"), 60),
                "abc",
                "def",
                "ghi",
                'b',
                "blockGold",
                'd',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                'e',
                getModItem(NewHorizonsCoreMod.ID, "item.RawOrbTier3", 1, 0, missing),
                'f',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                'h',
                "blockGold");
        TCHelper.addResearchPage(
                "MAGICANORB",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(NewHorizonsCoreMod.ID, "item.MagicianOrb", 1, 0, missing))));
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
                getModItem(NewHorizonsCoreMod.ID, "item.MasterOrb", 1, 0, missing)).setParents("MAGICANORB")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.MASTERORB")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MASTERORB",
                getModItem(NewHorizonsCoreMod.ID, "item.MasterOrb", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 80).add(Aspect.getAspect("aqua"), 80)
                        .add(Aspect.getAspect("ignis"), 80).add(Aspect.getAspect("terra"), 80)
                        .add(Aspect.getAspect("perditio"), 80).add(Aspect.getAspect("ordo"), 80),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                'd',
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                'e',
                getModItem(NewHorizonsCoreMod.ID, "item.RawOrbTier4", 1, 0, missing),
                'f',
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                'h',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing));
        TCHelper.addResearchPage(
                "MASTERORB",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(NewHorizonsCoreMod.ID, "item.MasterOrb", 1, 0, missing))));
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
                getModItem(NewHorizonsCoreMod.ID, "item.ArchmageOrb", 1, 0, missing)).setParents("MASTERORB")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.ARCHMAGEORB.1"),
                                new ResearchPage("tc.research_page.ARCHMAGEORB.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ARCHMAGEORB",
                getModItem(NewHorizonsCoreMod.ID, "item.ArchmageOrb", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("aqua"), 100)
                        .add(Aspect.getAspect("ignis"), 100).add(Aspect.getAspect("terra"), 100)
                        .add(Aspect.getAspect("perditio"), 100).add(Aspect.getAspect("ordo"), 100),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(BloodMagic.ID, "demonBloodShard", 1, 0, missing),
                'd',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27, missing),
                'e',
                getModItem(NewHorizonsCoreMod.ID, "item.RawOrbTier5", 1, 0, missing),
                'f',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27, missing),
                'h',
                getModItem(BloodMagic.ID, "demonBloodShard", 1, 0, missing));
        TCHelper.addResearchPage(
                "ARCHMAGEORB",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(NewHorizonsCoreMod.ID, "item.ArchmageOrb", 1, 0, missing))));
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
                getModItem(NewHorizonsCoreMod.ID, "item.TranscendentOrb", 1, 0, missing)).setParents("ARCHMAGEORB")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.TRANSCENDENTORB.1"),
                                new ResearchPage("tc.research_page.TRANSCENDENTORB.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TRANSCENDENTORB",
                getModItem(NewHorizonsCoreMod.ID, "item.TranscendentOrb", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 150).add(Aspect.getAspect("aqua"), 150)
                        .add(Aspect.getAspect("ignis"), 150).add(Aspect.getAspect("terra"), 150)
                        .add(Aspect.getAspect("perditio"), 150).add(Aspect.getAspect("ordo"), 150),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(BloodMagic.ID, "blockCrystal", 1, 0, missing),
                'd',
                getModItem(BloodArsenal.ID, "sigil_of_lightning", 1, 0, missing),
                'e',
                getModItem(NewHorizonsCoreMod.ID, "item.RawOrbTier6", 1, 0, missing),
                'f',
                getModItem(BloodArsenal.ID, "sigil_of_lightning", 1, 0, missing),
                'h',
                getModItem(BloodMagic.ID, "blockCrystal", 1, 0, missing));
        TCHelper.addResearchPage(
                "TRANSCENDENTORB",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(NewHorizonsCoreMod.ID, "item.TranscendentOrb", 1, 0, missing))));
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
                getModItem(BloodArsenal.ID, "transparent_orb", 1, 0, missing)).setParents("TRANSCENDENTORB")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.TRANSPARENTORB"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TRANSPARENTORB",
                getModItem(BloodArsenal.ID, "transparent_orb", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 175).add(Aspect.getAspect("aqua"), 175)
                        .add(Aspect.getAspect("ignis"), 175).add(Aspect.getAspect("terra"), 175)
                        .add(Aspect.getAspect("perditio"), 175).add(Aspect.getAspect("ordo"), 175),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodArsenal.ID, "blood_stained_glass", 1, 0, missing),
                'b',
                getModItem(BloodArsenal.ID, "blood_lamp", 1, 0, missing),
                'c',
                getModItem(BloodArsenal.ID, "blood_stained_glass", 1, 0, missing),
                'd',
                getModItem(BloodArsenal.ID, "blood_stained_glass", 1, 0, missing),
                'e',
                getModItem(BloodMagic.ID, "transcendentBloodOrb", 1, 0, missing),
                'f',
                getModItem(BloodArsenal.ID, "blood_stained_glass", 1, 0, missing),
                'g',
                getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                'h',
                getModItem(BloodMagic.ID, "divinationSigil", 1, 0, missing),
                'i',
                getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing));
        TCHelper.addResearchPage(
                "TRANSPARENTORB",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(BloodArsenal.ID, "transparent_orb", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "emptySocket", 1, 0, missing)).setParents("BLOODLETTERSPACK").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.EMPTYSOCKET")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "EMPTYSOCKET",
                getModItem(BloodMagic.ID, "emptySocket", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("ignis"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("perditio"), 50).add(Aspect.getAspect("ordo"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                'b',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                'c',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                'd',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                'e',
                getModItem(NewHorizonsCoreMod.ID, "tile.DiamondFrameBox", 1, 0, missing),
                'f',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                'g',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                'h',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                'i',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing));
        TCHelper.addResearchPage(
                "EMPTYSOCKET",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "emptySocket", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "armourForge", 1, 0, missing)).setParents("INFUSION", "EMPTYSOCKET")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.SOULARMORFORGE.1"),
                                new ResearchPage("tc.research_page.SOULARMORFORGE.2"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SOULARMORFORGE",
                getModItem(BloodMagic.ID, "armourForge", 1, 0, missing),
                7,
                new AspectList().add(Aspect.getAspect("tutamen"), 64).add(Aspect.getAspect("metallum"), 40)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("auram"), 24)
                        .add(Aspect.getAspect("tenebrae"), 16).add(Aspect.getAspect("exanimis"), 8),
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 6, missing),
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodSocket", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing),
                        getModItem(BloodArsenal.ID, "blood_stone", 1, 2, missing),
                        getModItem(BloodMagic.ID, "bloodSocket", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_stone", 1, 2, missing),
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodSocket", 1, 0, missing),
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_stone", 1, 2, missing),
                        getModItem(BloodMagic.ID, "bloodSocket", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_stone", 1, 2, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing), });
        TCHelper.addResearchPage(
                "SOULARMORFORGE",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "armourForge", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 1, missing))
                        .setParents("INFUSION", "RUNESACRIFICE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.RUNEOFARGUMENTEDCAPACITY")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNEOFARGUMENTEDCAPACITY",
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 1, missing),
                7,
                new AspectList().add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("lucrum"), 24)
                        .add(Aspect.getAspect("fames"), 18).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("terra"), 8).add(Aspect.getAspect("vacuos"), 4),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1, missing),
                new ItemStack[] { getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "RUNEOFARGUMENTEDCAPACITY",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 1, missing))));
        new ResearchItem(
                "RUNEOFDISLOCATION",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("aqua"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("cognitio"), 3),
                -6,
                2,
                3,
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 2, missing))
                        .setParents("INFUSION", "RUNESACRIFICE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.RUNEOFDISLOCATION")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNEOFDISLOCATION",
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 2, missing),
                7,
                new AspectList().add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("motus"), 18).add(Aspect.getAspect("tempus"), 12)
                        .add(Aspect.getAspect("terra"), 8).add(Aspect.getAspect("cognitio"), 4),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 1, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32613, missing),
                        getModItem(BloodMagic.ID, "aquasalus", 1, 0, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aquasalus", 1, 0, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32613, missing),
                        getModItem(BloodMagic.ID, "aquasalus", 1, 0, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aquasalus", 1, 0, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "RUNEOFDISLOCATION",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 2, missing))));
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
                getModItem(BloodMagic.ID, "sigilOfElementalAffinity", 1, 0, missing)).setParents("INFUSION", "AIRSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFELEMENTALAFFINITY"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFELEMENTALAFFINITY",
                getModItem(BloodMagic.ID, "sigilOfElementalAffinity", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("volatus"), 64).add(Aspect.getAspect("aer"), 48)
                        .add(Aspect.getAspect("aqua"), 48).add(Aspect.getAspect("ignis"), 48)
                        .add(Aspect.getAspect("motus"), 32).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("iter"), 18).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("cognitio"), 6),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                new ItemStack[] { getModItem(BloodMagic.ID, "earthScribeTool", 1, 0, missing),
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        getModItem(BloodMagic.ID, "lavaSigil", 1, 0, missing),
                        getModItem(BloodMagic.ID, "fireScribeTool", 1, 0, missing),
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        getModItem(BloodMagic.ID, "waterSigil", 1, 0, missing),
                        getModItem(BloodMagic.ID, "waterScribeTool", 1, 0, missing),
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        getModItem(BloodMagic.ID, "airSigil", 1, 0, missing),
                        getModItem(BloodMagic.ID, "airScribeTool", 1, 0, missing),
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFELEMENTALAFFINITY",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(BloodMagic.ID, "sigilOfElementalAffinity", 1, 0, missing))));
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
                getModItem(BloodArsenal.ID, "sigil_of_lightning", 1, 0, missing))
                        .setParents("INFUSION", "SIGILOFELEMENTALAFFINITY").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.SIGILOFLIGHTNING.1"),
                                new ResearchPage("tc.research_page.SIGILOFLIGHTNING.2"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFLIGHTNING",
                getModItem(BloodArsenal.ID, "sigil_of_lightning", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("tempestas"), 32).add(Aspect.getAspect("aer"), 72)
                        .add(Aspect.getAspect("aqua"), 72).add(Aspect.getAspect("terra"), 64)
                        .add(Aspect.getAspect("potentia"), 48).add(Aspect.getAspect("tenebrae"), 8)
                        .add(Aspect.getAspect("ira"), 8).add(Aspect.getAspect("electrum"), 16),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27, missing),
                new ItemStack[] { getModItem(BloodMagic.ID, "airSigil", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_stone", 1, 3, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0, missing),
                        getModItem(BloodMagic.ID, "waterSigil", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_stone", 1, 3, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFLIGHTNING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "sigil_of_lightning", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "sigilOfHolding", 1, 0, missing)).setParents("INFUSION", "SIGILOFMAGNETISM")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFHOLDING"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFHOLDING",
                getModItem(BloodMagic.ID, "sigilOfHolding", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("lucrum"), 32).add(Aspect.getAspect("cognitio"), 24)
                        .add(Aspect.getAspect("gula"), 16).add(Aspect.getAspect("superbia"), 16)
                        .add(Aspect.getAspect("limus"), 16).add(Aspect.getAspect("praecantatio"), 8),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                new ItemStack[] { getModItem(IronChests.ID, "BlockIronChest", 1, 0, missing),
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        getModItem(BloodMagic.ID, "crepitous", 1, 0, missing),
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "crepitous", 1, 0, missing),
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFHOLDING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "sigilOfHolding", 1, 0, missing))));
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
                getModItem(BloodArsenal.ID, "sigil_of_augmented_holding", 1, 0, missing))
                        .setParents("INFUSION", "SIGILOFHOLDING").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.SIGILOFAUGMENTETHOLDING")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFAUGMENTETHOLDING",
                getModItem(BloodArsenal.ID, "sigil_of_augmented_holding", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("vacuos"), 48).add(Aspect.getAspect("lucrum"), 32)
                        .add(Aspect.getAspect("cognitio"), 24).add(Aspect.getAspect("gula"), 16)
                        .add(Aspect.getAspect("superbia"), 16).add(Aspect.getAspect("limus"), 16)
                        .add(Aspect.getAspect("praecantatio"), 8),
                getModItem(BloodMagic.ID, "sigilOfHolding", 1, 0, missing),
                new ItemStack[] { getModItem(IronChests.ID, "BlockIronChest", 1, 2, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17977, missing),
                        getModItem(Minecraft.ID, "blaze_rod", 1, 0, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        getModItem(Minecraft.ID, "blaze_rod", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17977, missing),
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFAUGMENTETHOLDING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(BloodArsenal.ID, "sigil_of_augmented_holding", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "sigilOfTheBridge", 1, 0, missing)).setParents("INFUSION", "VOIDSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFPHANTOMBRIDGE"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFPHANTOMBRIDGE",
                getModItem(BloodMagic.ID, "sigilOfTheBridge", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("terra"), 48).add(Aspect.getAspect("alienis"), 32)
                        .add(Aspect.getAspect("iter"), 24).add(Aspect.getAspect("vitreus"), 16)
                        .add(Aspect.getAspect("potentia"), 8).add(Aspect.getAspect("praecantatio"), 8),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                new ItemStack[] { getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1, missing),
                        getModItem(EnderIO.ID, "blockIngotStorage", 1, 7, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1, missing),
                        getModItem(EnderIO.ID, "blockIngotStorage", 1, 7, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1, missing),
                        getModItem(EnderIO.ID, "blockIngotStorage", 1, 7, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1, missing),
                        getModItem(EnderIO.ID, "blockIngotStorage", 1, 7, missing), });
        TCHelper.addResearchPage(
                "SIGILOFPHANTOMBRIDGE",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "sigilOfTheBridge", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "sigilOfMagnetism", 1, 0, missing)).setParents("INFUSION", "WATERSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFMAGNETISM"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFMAGNETISM",
                getModItem(BloodMagic.ID, "sigilOfMagnetism", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("magneto"), 24)
                        .add(Aspect.getAspect("electrum"), 24).add(Aspect.getAspect("auram"), 16)
                        .add(Aspect.getAspect("cognitio"), 12).add(Aspect.getAspect("praecantatio"), 6),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.blockmetal5", 1, 1, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmetal5", 1, 1, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmetal5", 1, 1, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmetal5", 1, 1, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFMAGNETISM",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "sigilOfMagnetism", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "itemBloodLightSigil", 1, 0, missing)).setParents("INFUSION", "WATERSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFTHEBLOODLAMP"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFTHEBLOODLAMP",
                getModItem(BloodMagic.ID, "itemBloodLightSigil", 1, 0, missing),
                4,
                new AspectList().add(Aspect.getAspect("lux"), 48).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("sensus"), 16).add(Aspect.getAspect("praecantatio"), 8),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                new ItemStack[] { getModItem(ThaumicTinkerer.ID, "brightNitor", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6, missing),
                        getModItem(BloodArsenal.ID, "blood_stone", 1, 2, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6, missing),
                        getModItem(ThaumicTinkerer.ID, "brightNitor", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6, missing),
                        getModItem(BloodArsenal.ID, "blood_stone", 1, 2, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6, missing), });
        TCHelper.addResearchPage(
                "SIGILOFTHEBLOODLAMP",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "itemBloodLightSigil", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "seerSigil", 1, 0, missing)).setParents("INFUSION", "DIVINATIONSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFSIGHT"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFSIGHT",
                getModItem(BloodMagic.ID, "seerSigil", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("ordo"), 24).add(Aspect.getAspect("sensus"), 18)
                        .add(Aspect.getAspect("cognitio"), 12).add(Aspect.getAspect("vitreus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 4),
                getModItem(BloodMagic.ID, "divinationSigil", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(BloodMagic.ID, "crystallos", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(BloodMagic.ID, "crystallos", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFSIGHT",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "seerSigil", 1, 0, missing))));
        new ResearchItem(
                "RITUALDIVINER",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("aer"), 18).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 12).add(Aspect.getAspect("aqua"), 9)
                        .add(Aspect.getAspect("perditio"), 6).add(Aspect.getAspect("ordo"), 3),
                -2,
                -8,
                3,
                getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 0, missing))
                        .setParents("INFUSION", "MASTERRITUALSTONE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.RITUALDIVINER.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RITUALDIVINER",
                getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("terra"), 32).add(Aspect.getAspect("aqua"), 32)
                        .add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("ordo"), 16),
                getModItem(BloodMagic.ID, "seerSigil", 1, 0, missing),
                new ItemStack[] { getModItem(Witchery.ID, "chalkritual", 1, 0, missing),
                        getModItem(BloodMagic.ID, "waterScribeTool", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 29500, missing),
                        getModItem(BloodMagic.ID, "fireScribeTool", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 29501, missing),
                        getModItem(BloodMagic.ID, "earthScribeTool", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 29500, missing),
                        getModItem(BloodMagic.ID, "airScribeTool", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 29501, missing), });
        TCHelper.addResearchPage(
                "RITUALDIVINER",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("RITUALDIVINER", 3);
        TCHelper.addResearchPage("RITUALDIVINER", new ResearchPage("tc.research_page.RITUALDIVINER.2"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RITUALDIVINER",
                getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 1, missing),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 48).add(Aspect.getAspect("ignis"), 48)
                        .add(Aspect.getAspect("terra"), 48).add(Aspect.getAspect("aqua"), 48)
                        .add(Aspect.getAspect("perditio"), 24).add(Aspect.getAspect("ordo"), 24),
                getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 0, missing),
                new ItemStack[] { getModItem(BloodMagic.ID, "duskScribeTool", 1, 0, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "duskScribeTool", 1, 0, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "duskScribeTool", 1, 0, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "duskScribeTool", 1, 0, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "RITUALDIVINER",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 1, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RITUALDIVINER",
                getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 2, missing),
                9,
                new AspectList().add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("ignis"), 64)
                        .add(Aspect.getAspect("terra"), 64).add(Aspect.getAspect("aqua"), 64)
                        .add(Aspect.getAspect("perditio"), 32).add(Aspect.getAspect("ordo"), 32),
                getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 1, missing),
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27, missing),
                        getModItem(BloodMagic.ID, "dawnScribeTool", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27, missing),
                        getModItem(BloodMagic.ID, "dawnScribeTool", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27, missing),
                        getModItem(BloodMagic.ID, "dawnScribeTool", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27, missing),
                        getModItem(BloodMagic.ID, "dawnScribeTool", 1, 0, missing), });
        TCHelper.addResearchPage(
                "RITUALDIVINER",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "itemRitualDiviner", 1, 2, missing))));
        new ResearchItem(
                "RUNEOFTHEORB",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("potentia"), 15).add(Aspect.getAspect("victus"), 12)
                        .add(Aspect.getAspect("motus"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                -6,
                -2,
                3,
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 3, missing))
                        .setParents("INFUSION", "RUNESACRIFICE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.RUNEOFTHEORB")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNEOFTHEORB",
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 3, missing),
                6,
                new AspectList().add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("victus"), 24)
                        .add(Aspect.getAspect("motus"), 16).add(Aspect.getAspect("lucrum"), 8)
                        .add(Aspect.getAspect("praecantatio"), 4),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 3, missing),
                new ItemStack[] { getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_stone", 1, 3, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem(BloodArsenal.ID, "blood_stone", 1, 3, missing), });
        TCHelper.addResearchPage(
                "RUNEOFTHEORB",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 3, missing))));
        new ResearchItem(
                "RUNEOFSUPERIORCAPACITY",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("potentia"), 18).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("cognitio"), 12).add(Aspect.getAspect("lucrum"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("alienis"), 3),
                -8,
                -2,
                3,
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 4, missing))
                        .setParents("INFUSION", "RUNEOFARGUMENTEDCAPACITY").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.RUNEOFSUPERIORCAPACITY.1"),
                                new ResearchPage("tc.research_page.RUNEOFSUPERIORCAPACITY.2"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNEOFSUPERIORCAPACITY",
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 4, missing),
                8,
                new AspectList().add(Aspect.getAspect("potentia"), 48).add(Aspect.getAspect("aqua"), 32)
                        .add(Aspect.getAspect("cognitio"), 24).add(Aspect.getAspect("lucrum"), 16)
                        .add(Aspect.getAspect("praecantatio"), 8).add(Aspect.getAspect("alienis"), 4),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 3, missing),
                new ItemStack[] { getModItem(IronTanks.ID, "diamondTank", 1, 0, missing),
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_stone", 1, 3, missing),
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 24, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        getModItem(IronTanks.ID, "diamondTank", 1, 0, missing),
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_stone", 1, 3, missing),
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 24, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "RUNEOFSUPERIORCAPACITY",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 4, missing))));
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
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 5, missing))
                        .setParents("INFUSION", "RUNEOFARGUMENTEDCAPACITY", "RUNEOFDISLOCATION").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.RUNEOFACCELERATION")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNEOFACCELERATION",
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 5, missing),
                10,
                new AspectList().add(Aspect.getAspect("potentia"), 64).add(Aspect.getAspect("aqua"), 48)
                        .add(Aspect.getAspect("motus"), 32).add(Aspect.getAspect("cognitio"), 24)
                        .add(Aspect.getAspect("tempus"), 16).add(Aspect.getAspect("praecantatio"), 8)
                        .add(Aspect.getAspect("terra"), 4),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 4, missing),
                new ItemStack[] { getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 2, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 24, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem(BloodArsenal.ID, "blood_stone", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32614, missing),
                        getModItem(BloodMagic.ID, "speedRune", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 24, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem(BloodArsenal.ID, "blood_stone", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32614, missing), });
        TCHelper.addResearchPage(
                "RUNEOFACCELERATION",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 5, missing))));
        new ResearchItem(
                "ARCANEPEDESTALANDPLINTH",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                -4,
                -6,
                3,
                getModItem(BloodMagic.ID, "blockPedestal", 1, 0, missing)).setParents("INFUSION", "MASTERRITUALSTONE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.ARCANEPEDESTALANDPLINTH.1"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ARCANEPEDESTALANDPLINTH",
                getModItem(BloodMagic.ID, "blockPedestal", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 30).add(Aspect.getAspect("terra"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0, missing),
                'b',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                'c',
                getModItem(BloodMagic.ID, "AlchemicalWizardrybloodRune", 1, 0, missing),
                'd',
                getModItem(BloodMagic.ID, "largeBloodStoneBrick", 1, 0, missing),
                'e',
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 1, missing),
                'f',
                getModItem(BloodMagic.ID, "largeBloodStoneBrick", 1, 0, missing),
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7, missing),
                'h',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7, missing));
        TCHelper.addResearchPage(
                "ARCANEPEDESTALANDPLINTH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "blockPedestal", 1, 0, missing))));
        TCHelper.addResearchPage(
                "ARCANEPEDESTALANDPLINTH",
                new ResearchPage("tc.research_page.ARCANEPEDESTALANDPLINTH.2"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ARCANEPEDESTALANDPLINTH",
                getModItem(BloodMagic.ID, "blockPlinth", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("metallum"), 64).add(Aspect.getAspect("ignis"), 48)
                        .add(Aspect.getAspect("terra"), 32).add(Aspect.getAspect("tenebrae"), 24)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("alienis"), 8),
                getModItem(BloodMagic.ID, "blockPedestal", 1, 0, missing),
                new ItemStack[] { getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0, missing),
                        getModItem(Witchery.ID, "ingredient", 1, 130, missing),
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0, missing),
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        getModItem(Witchery.ID, "ingredient", 1, 130, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0, missing),
                        getModItem(Witchery.ID, "ingredient", 1, 130, missing),
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0, missing),
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        getModItem(Witchery.ID, "ingredient", 1, 130, missing), });
        TCHelper.addResearchPage(
                "ARCANEPEDESTALANDPLINTH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "blockPlinth", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "blockAlchemicCalcinator", 1, 0, missing))
                        .setParents("ARCANEPEDESTALANDPLINTH").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ALCHEMICCALCINATOR")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ALCHEMICCALCINATOR",
                getModItem(BloodMagic.ID, "blockAlchemicCalcinator", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("terra"), 50).add(Aspect.getAspect("aer"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 15, missing),
                'b',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'c',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 15, missing),
                'd',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'e',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 4, missing),
                'f',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7, missing),
                'h',
                getModItem(Witchery.ID, "cauldron", 1, 0, missing),
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7, missing));
        TCHelper.addResearchPage(
                "ALCHEMICCALCINATOR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(BloodMagic.ID, "blockAlchemicCalcinator", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "itemAttunedCrystal", 1, 0, missing)).setParents("ALCHEMICCALCINATOR")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.ALCHEMICTOOLS.1"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ALCHEMICTOOLS",
                getModItem(BloodMagic.ID, "itemAttunedCrystal", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ordo"), 15)
                        .add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                'b',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0, missing),
                'e',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 4, missing),
                'f',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0, missing),
                'g',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0, missing),
                'i',
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing));
        TCHelper.addResearchPage(
                "ALCHEMICTOOLS",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "itemAttunedCrystal", 1, 0, missing))));
        TCHelper.addResearchPage("ALCHEMICTOOLS", new ResearchPage("tc.research_page.ALCHEMICTOOLS.2"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ALCHEMICTOOLS",
                getModItem(BloodMagic.ID, "itemDestinationClearer", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aer"), 15)
                        .add(Aspect.getAspect("perditio"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0, missing),
                'b',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing),
                'c',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0, missing),
                'd',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing),
                'f',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing),
                'g',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0, missing),
                'h',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing),
                'i',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0, missing));
        TCHelper.addResearchPage(
                "ALCHEMICTOOLS",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "itemDestinationClearer", 1, 0, missing))));
        TCHelper.addResearchPage("ALCHEMICTOOLS", new ResearchPage("tc.research_page.ALCHEMICTOOLS.3"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ALCHEMICTOOLS",
                getModItem(BloodMagic.ID, "itemTankSegmenter", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aer"), 15)
                        .add(Aspect.getAspect("ignis"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Witchery.ID, "chalkheart", 1, 0, missing),
                'b',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0, missing),
                'c',
                getModItem(BloodMagic.ID, "mundanePowerCatalyst", 1, 0, missing),
                'e',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 4, missing),
                'f',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0, missing),
                'g',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0, missing),
                'i',
                getModItem(Witchery.ID, "chalkheart", 1, 0, missing));
        TCHelper.addResearchPage(
                "ALCHEMICTOOLS",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "itemTankSegmenter", 1, 0, missing))));
        new ResearchItem(
                "BELLJAR",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 18).add(Aspect.getAspect("aer"), 15)
                        .add(Aspect.getAspect("terra"), 12).add(Aspect.getAspect("ordo"), 9)
                        .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("arbor"), 3),
                -6,
                -12,
                3,
                getModItem(BloodMagic.ID, "blockCrystalBelljar", 1, 0, missing)).setParents("ALCHEMICCALCINATOR")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.BELLJAR")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BELLJAR",
                getModItem(BloodMagic.ID, "blockCrystalBelljar", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'b',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'd',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'e',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 4, missing),
                'f',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'g',
                getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0, missing),
                'h',
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing),
                'i',
                getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0, missing));
        TCHelper.addResearchPage(
                "BELLJAR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "blockCrystalBelljar", 1, 0, missing))));
        new ResearchItem(
                "ALCHEMYRELAY",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("metallum"), 18).add(Aspect.getAspect("bestia"), 15)
                        .add(Aspect.getAspect("pannus"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("alienis"), 6).add(Aspect.getAspect("potentia"), 3),
                -2,
                -12,
                3,
                getModItem(BloodMagic.ID, "blockReagentConduit", 1, 0, missing)).setParents("ALCHEMICCALCINATOR")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.ALCHEMYRELAY"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ALCHEMYRELAY",
                getModItem(BloodMagic.ID, "blockReagentConduit", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 25).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("ignis"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                'b',
                getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                'c',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                'd',
                getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                'e',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 4, missing),
                'f',
                getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                'g',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                'h',
                getModItem(BloodArsenal.ID, "blood_burned_string", 1, 0, missing),
                'i',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing));
        TCHelper.addResearchPage(
                "ALCHEMYRELAY",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "blockReagentConduit", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "blockCrystal", 1, 0, missing)).setParents("INFUSION", "RUNEOFACCELERATION")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.CRYSTALCLUSTER"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CRYSTALCLUSTER",
                getModItem(BloodMagic.ID, "blockCrystal", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("potentia"), 72).add(Aspect.getAspect("victus"), 64)
                        .add(Aspect.getAspect("spiritus"), 64).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("tenebrae"), 32).add(Aspect.getAspect("alienis"), 16)
                        .add(Aspect.getAspect("cognitio"), 16),
                getModItem(BloodArsenal.ID, "blood_stone", 1, 4, missing),
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 28, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 29, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 28, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 29, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 28, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 29, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 28, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 29, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 28, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 29, missing), });
        TCHelper.addResearchPage(
                "CRYSTALCLUSTER",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "blockCrystal", 1, 0, missing))));
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
                getModItem(GregTech.ID, "gt.blockmetal8", 1, 13, missing)).setParents("INFUSION", "CRYSTALCLUSTER")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.ICHORIUMBLOCK.1"),
                                new ResearchPage("tc.research_page.ICHORIUMBLOCK.2"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ICHORIUMBLOCK",
                getModItem(GregTech.ID, "gt.blockmetal8", 1, 13, missing),
                12,
                new AspectList().add(Aspect.getAspect("victus"), 64).add(Aspect.getAspect("fames"), 48)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("infernus"), 24)
                        .add(Aspect.getAspect("alienis"), 16).add(Aspect.getAspect("superbia"), 16)
                        .add(Aspect.getAspect("terra"), 8),
                getModItem(NewHorizonsCoreMod.ID, "tile.Mytryl", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 28, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0, missing),
                        getModItem(BloodMagic.ID, "standardBindingAgent", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 29, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 4, missing), });
        TCHelper.addResearchPage(
                "ICHORIUMBLOCK",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(GregTech.ID, "gt.blockmetal8", 1, 13, missing))));
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
                getModItem(BloodMagic.ID, "blockStabilityGlyph", 1, 0, missing))
                        .setParents("INFUSION", "SOULARMORFORGE").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.GLYPHSTONE.1"),
                                new ResearchPage("tc.research_page.GLYPHSTONE.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GLYPHSTONE",
                getModItem(BloodMagic.ID, "blockStabilityGlyph", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("aqua"), 20).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("perditio"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "crepitous", 1, 0, missing),
                'b',
                getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                'c',
                getModItem(BloodMagic.ID, "crepitous", 1, 0, missing),
                'd',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17, missing),
                'e',
                getModItem(BloodArsenal.ID, "blood_stone", 1, 4, missing),
                'f',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17, missing),
                'g',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1, missing),
                'h',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 30, missing),
                'i',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1, missing));
        TCHelper.addResearchPage(
                "GLYPHSTONE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "blockStabilityGlyph", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("GLYPHSTONE", 3);
        TCHelper.addResearchPage("GLYPHSTONE", new ResearchPage("tc.research_page.GLYPHSTONE.2"));
        TCHelper.addResearchPage("GLYPHSTONE", new ResearchPage("tc.research_page.GLYPHSTONE.3"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GLYPHSTONE",
                getModItem(BloodMagic.ID, "blockEnchantmentGlyph", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("terra"), 30)
                        .add(Aspect.getAspect("aqua"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 0, missing),
                'b',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 28, missing),
                'c',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 0, missing),
                'd',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17, missing),
                'e',
                getModItem(BloodArsenal.ID, "blood_stone", 1, 4, missing),
                'f',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17, missing),
                'g',
                getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                'h',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 30, missing),
                'i',
                getModItem(BloodMagic.ID, "magicales", 1, 0, missing));
        TCHelper.addResearchPage(
                "GLYPHSTONE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "blockEnchantmentGlyph", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GLYPHSTONE",
                getModItem(BloodMagic.ID, "blockEnchantmentGlyph", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("terra"), 30)
                        .add(Aspect.getAspect("aqua"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6, missing),
                'b',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 29, missing),
                'c',
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6, missing),
                'd',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17, missing),
                'e',
                getModItem(BloodArsenal.ID, "blood_stone", 1, 4, missing),
                'f',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17, missing),
                'g',
                getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                'h',
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 30, missing),
                'i',
                getModItem(BloodMagic.ID, "magicales", 1, 0, missing));
        TCHelper.addResearchPage(
                "GLYPHSTONE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "blockEnchantmentGlyph", 1, 1, missing))));
        new ResearchItem(
                "KEYOFBINDING",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                4,
                -2,
                3,
                getModItem(BloodMagic.ID, "itemKeyOfDiablo", 1, 0, missing)).setParents("SACRIFICIALKNIFE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.KEYOFBINDING"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "KEYOFBINDING",
                getModItem(BloodMagic.ID, "itemKeyOfDiablo", 1, 0, missing),
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
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                'e',
                getModItem(Thaumcraft.ID, "ArcaneDoorKey", 1, 1, missing),
                'f',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                'g',
                "gemFlawlessDiamond",
                'h',
                "plateRoseGold");
        TCHelper.addResearchPage(
                "KEYOFBINDING",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "itemKeyOfDiablo", 1, 0, missing))));
        new ResearchItem(
                "ARMORINHIBITOR",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("spiritus"), 9).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                4,
                -8,
                3,
                getModItem(BloodMagic.ID, "armourInhibitor", 1, 0, missing)).setParents("SOULARMORFORGE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ARMORINHIBITOR")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ARMORINHIBITOR",
                getModItem(BloodMagic.ID, "armourInhibitor", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("aer"), 30)
                        .add(Aspect.getAspect("aqua"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                'b',
                "plateRoseGold",
                'd',
                "plateRoseGold",
                'e',
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                'f',
                "plateRoseGold",
                'h',
                "plateRoseGold",
                'i',
                getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing));
        TCHelper.addResearchPage(
                "ARMORINHIBITOR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "armourInhibitor", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "sigilOfHaste", 1, 0, missing)).setParents("INFUSION", "AIRSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFHASTE"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFHASTE",
                getModItem(BloodMagic.ID, "sigilOfHaste", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("iter"), 64).add(Aspect.getAspect("motus"), 32)
                        .add(Aspect.getAspect("aer"), 24).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("alienis"), 8)
                        .add(Aspect.getAspect("cognitio"), 8),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem(Minecraft.ID, "cookie", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        getModItem(Minecraft.ID, "sugar", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem(Minecraft.ID, "sugar", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        getModItem(Minecraft.ID, "cookie", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFHASTE",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "sigilOfHaste", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "sigilOfWind", 1, 0, missing)).setParents("INFUSION", "AIRSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFWHIRLWIND"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFWHIRLWIND",
                getModItem(BloodMagic.ID, "sigilOfWind", 1, 0, missing),
                12,
                new AspectList().add(Aspect.getAspect("aer"), 72).add(Aspect.getAspect("tutamen"), 48)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("victus"), 32)
                        .add(Aspect.getAspect("sano"), 16).add(Aspect.getAspect("cognitio"), 16)
                        .add(Aspect.getAspect("superbia"), 8).add(Aspect.getAspect("nebrisum"), 8),
                getModItem(BloodMagic.ID, "airSigil", 1, 0, missing),
                new ItemStack[] { getModItem(TwilightForest.ID, "item.tfFeather", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        getModItem(TwilightForest.ID, "item.tfFeather", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFWHIRLWIND",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "sigilOfWind", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "sigilOfSupression", 1, 0, missing)).setParents("INFUSION", "VOIDSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFSUPRESSION"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFSUPRESSION",
                getModItem(BloodMagic.ID, "sigilOfSupression", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("vacuos"), 72).add(Aspect.getAspect("auram"), 16)
                        .add(Aspect.getAspect("aqua"), 64).add(Aspect.getAspect("metallum"), 8)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("terra"), 32)
                        .add(Aspect.getAspect("motus"), 16),
                getModItem(BloodMagic.ID, "voidSigil", 1, 0, missing),
                new ItemStack[] { getModItem(BloodMagic.ID, "blockTeleposer", 1, 0, missing),
                        getModItem(Minecraft.ID, "bucket", 1, 0, missing),
                        getModItem(BloodMagic.ID, "tennebrae", 1, 0, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        getModItem(Minecraft.ID, "bucket", 1, 0, missing),
                        getModItem(BloodMagic.ID, "tennebrae", 1, 0, missing),
                        getModItem(Minecraft.ID, "bucket", 1, 0, missing),
                        getModItem(BloodMagic.ID, "tennebrae", 1, 0, missing),
                        getModItem(Minecraft.ID, "bucket", 1, 0, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "tennebrae", 1, 0, missing),
                        getModItem(Minecraft.ID, "bucket", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFSUPRESSION",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "sigilOfSupression", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "sigilOfEnderSeverance", 1, 0, missing))
                        .setParents("INFUSION", "SIGILOFELEMENTALAFFINITY", "OCULUS").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.SIGILOFENDERSEVERANCE")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFENDERSEVERANCE",
                getModItem(BloodMagic.ID, "sigilOfEnderSeverance", 1, 0, missing),
                17,
                new AspectList().add(Aspect.getAspect("alienis"), 16).add(Aspect.getAspect("cognitio"), 72)
                        .add(Aspect.getAspect("humanus"), 16).add(Aspect.getAspect("potentia"), 64)
                        .add(Aspect.getAspect("vinculum"), 48).add(Aspect.getAspect("limus"), 32)
                        .add(Aspect.getAspect("nebrisum"), 8),
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45, missing),
                        getModItem(TinkerConstruct.ID, "slime.gel", 1, 2, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32724, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 7, missing),
                        getModItem(TinkerConstruct.ID, "slime.gel", 1, 2, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFENDERSEVERANCE",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(BloodMagic.ID, "sigilOfEnderSeverance", 1, 0, missing))));
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
                getModItem(BloodArsenal.ID, "sigil_of_ender", 1, 0, missing))
                        .setParents("INFUSION", "SIGILOFENDERSEVERANCE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ENDERSIGIL")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ENDERSIGIL",
                getModItem(BloodArsenal.ID, "sigil_of_ender", 1, 0, missing),
                20,
                new AspectList().add(Aspect.getAspect("vacuos"), 16).add(Aspect.getAspect("alienis"), 16)
                        .add(Aspect.getAspect("cognitio"), 72).add(Aspect.getAspect("humanus"), 16)
                        .add(Aspect.getAspect("potentia"), 64).add(Aspect.getAspect("vinculum"), 48)
                        .add(Aspect.getAspect("limus"), 32).add(Aspect.getAspect("nebrisum"), 8),
                getModItem(BloodMagic.ID, "sigilOfEnderSeverance", 1, 0, missing),
                new ItemStack[] { getModItem(EnderStorage.ID, "enderChest", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32726, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17770, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32724, missing),
                        getModItem(Minecraft.ID, "ender_eye", 1, 0, missing),
                        getModItem(Minecraft.ID, "ender_eye", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32724, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17770, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32726, missing), });
        TCHelper.addResearchPage(
                "ENDERSIGIL",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "sigil_of_ender", 1, 0, missing))));
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
                getModItem(BloodArsenal.ID, "sigil_of_divinity", 1, 0, missing))
                        .setParents("INFUSION", "SIGILOFENDERSEVERANCE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.SIGILOFDIVINITY")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFDIVINITY",
                getModItem(BloodArsenal.ID, "sigil_of_divinity", 1, 0, missing),
                25,
                new AspectList().add(Aspect.getAspect("tutamen"), 64).add(Aspect.getAspect("aer"), 72)
                        .add(Aspect.getAspect("ignis"), 64).add(Aspect.getAspect("aqua"), 48)
                        .add(Aspect.getAspect("terra"), 32).add(Aspect.getAspect("ordo"), 32)
                        .add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("sano"), 8),
                getModItem(BloodMagic.ID, "sigilOfElementalAffinity", 1, 0, missing),
                new ItemStack[] { getModItem(BloodArsenal.ID, "blood_stone", 1, 4, missing),
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "diamondApple", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_glowstone", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32726, missing),
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_glowstone", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "diamondApple", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFDIVINITY",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "sigil_of_divinity", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "itemHarvestSigil", 1, 0, missing))
                        .setParents("INFUSION", "SIGILOFENDERSEVERANCE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.HARVESTGODDESSSIGIL")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "HARVESTGODDESSSIGIL",
                getModItem(BloodMagic.ID, "itemHarvestSigil", 1, 0, missing),
                20,
                new AspectList().add(Aspect.getAspect("herba"), 72).add(Aspect.getAspect("arbor"), 64)
                        .add(Aspect.getAspect("meto"), 8).add(Aspect.getAspect("messis"), 16)
                        .add(Aspect.getAspect("cognitio"), 24).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("alienis"), 16),
                getModItem(BloodMagic.ID, "growthSigil", 1, 0, missing),
                new ItemStack[] { getModItem(BloodArsenal.ID, "bound_sickle", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 2, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 2, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 2, missing), });
        TCHelper.addResearchPage(
                "HARVESTGODDESSSIGIL",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "itemHarvestSigil", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "itemCompressionSigil", 1, 0, missing))
                        .setParents("INFUSION", "SIGILOFMAGNETISM").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.SIGILOFCOMPRESSION")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFCOMPRESSION",
                getModItem(BloodMagic.ID, "itemCompressionSigil", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("metallum"), 32).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("machina"), 16).add(Aspect.getAspect("lucrum"), 16)
                        .add(Aspect.getAspect("superbia"), 8),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                new ItemStack[] { getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32644, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32604, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32604, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32644, missing), });
        TCHelper.addResearchPage(
                "SIGILOFCOMPRESSION",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodMagic.ID, "itemCompressionSigil", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "energyBazooka", 1, 0, missing))
                        .setParents("CRYSTALCLUSTER", "ICHOR_SWORD_GEM", "PRIMALCRUSHER").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ENERGYBAZOOKAI")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENERGYBAZOOKAI",
                getModItem(BloodMagic.ID, "energyBazooka", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 150).add(Aspect.getAspect("ignis"), 150)
                        .add(Aspect.getAspect("terra"), 150).add(Aspect.getAspect("aer"), 150)
                        .add(Aspect.getAspect("perditio"), 150).add(Aspect.getAspect("ordo"), 150),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                'b',
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                'd',
                getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0, missing),
                'e',
                getModItem(BloodMagic.ID, "energyBlasterThirdTier", 1, 0, missing),
                'f',
                getModItem(BloodArsenal.ID, "blood_infused_diamond_block", 1, 0, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing),
                'h',
                getModItem(BloodMagic.ID, "demonicTelepositionFocus", 1, 0, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11978, missing));
        TCHelper.addResearchPage(
                "ENERGYBAZOOKAI",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(BloodMagic.ID, "energyBazooka", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "energyBazookaSecondTier", 1, 0, missing))
                        .setParents("INFUSION", "ENERGYBAZOOKAI").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ENERGYBAZOOKAII")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ENERGYBAZOOKAII",
                getModItem(BloodMagic.ID, "energyBazookaSecondTier", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("potentia"), 96).add(Aspect.getAspect("instrumentum"), 72)
                        .add(Aspect.getAspect("telum"), 64).add(Aspect.getAspect("infernus"), 64)
                        .add(Aspect.getAspect("superbia"), 32).add(Aspect.getAspect("fames"), 32)
                        .add(Aspect.getAspect("nebrisum"), 16).add(Aspect.getAspect("ira"), 8),
                getModItem(BloodMagic.ID, "energyBazooka", 1, 0, missing),
                new ItemStack[] { getModItem(DraconicEvolution.ID, "draconium", 1, 2, missing),
                        getModItem(DraconicEvolution.ID, "draconicCore", 1, 0, missing),
                        getModItem(BloodMagic.ID, "dawnScribeTool", 1, 0, missing),
                        getModItem(DraconicEvolution.ID, "wyvernCore", 1, 0, missing),
                        getModItem(BloodMagic.ID, "duskScribeTool", 1, 0, missing),
                        getModItem(DraconicEvolution.ID, "draconium", 1, 2, missing),
                        getModItem(BloodMagic.ID, "duskScribeTool", 1, 0, missing),
                        getModItem(DraconicEvolution.ID, "draconicCore", 1, 0, missing),
                        getModItem(BloodMagic.ID, "dawnScribeTool", 1, 0, missing),
                        getModItem(DraconicEvolution.ID, "wyvernCore", 1, 0, missing), });
        TCHelper.addResearchPage(
                "ENERGYBAZOOKAII",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(BloodMagic.ID, "energyBazookaSecondTier", 1, 0, missing))));
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
                getModItem(BloodMagic.ID, "energyBazookaThirdTier", 1, 0, missing))
                        .setParents("INFUSION", "ENERGYBAZOOKAII").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ENERGYBAZOOKAIII")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ENERGYBAZOOKAIII",
                getModItem(BloodMagic.ID, "energyBazookaThirdTier", 1, 0, missing),
                20,
                new AspectList().add(Aspect.getAspect("potentia"), 128).add(Aspect.getAspect("instrumentum"), 96)
                        .add(Aspect.getAspect("telum"), 72).add(Aspect.getAspect("terminus"), 64)
                        .add(Aspect.getAspect("infernus"), 72).add(Aspect.getAspect("superbia"), 48)
                        .add(Aspect.getAspect("fames"), 32).add(Aspect.getAspect("nebrisum"), 16)
                        .add(Aspect.getAspect("ira"), 8),
                getModItem(BloodMagic.ID, "energyBazookaSecondTier", 1, 0, missing),
                new ItemStack[] { getModItem(Avaritia.ID, "big_pearl", 1, 0, missing),
                        getModItem(Avaritia.ID, "Resource", 1, 6, missing),
                        getModItem(DraconicEvolution.ID, "awakenedCore", 1, 0, missing),
                        getModItem(Avaritia.ID, "Resource_Block", 1, 0, missing),
                        getModItem(Avaritia.ID, "Resource", 1, 6, missing),
                        getModItem(Avaritia.ID, "Resource", 1, 6, missing),
                        getModItem(Avaritia.ID, "Resource_Block", 1, 0, missing),
                        getModItem(DraconicEvolution.ID, "chaoticCore", 1, 0, missing),
                        getModItem(Avaritia.ID, "Resource", 1, 6, missing), });
        TCHelper.addResearchPage(
                "ENERGYBAZOOKAIII",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(BloodMagic.ID, "energyBazookaThirdTier", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("ENERGYBAZOOKAIII", 20);
        TCHelper.clearPages("CAP_blood_iron");
        TCHelper.addResearchPage("CAP_blood_iron", new ResearchPage("blood_arsenal.research_page.CAP_blood_iron.1"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CAP_blood_iron",
                getModItem(BloodArsenal.ID, "wand_caps", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("victus"), 24).add(Aspect.getAspect("metallum"), 16)
                        .add(Aspect.getAspect("ignis"), 8),
                getModItem(ForbiddenMagic.ID, "WandCaps", 1, 0, missing),
                new ItemStack[] { getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17977, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28977, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17977, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17977, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28977, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17977, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0, missing), });
        TCHelper.addResearchPage(
                "CAP_blood_iron",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "wand_caps", 1, 0, missing))));
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
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ROD_blood_wood",
                getModItem(BloodArsenal.ID, "wand_cores", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("instrumentum"), 24)
                        .add(Aspect.getAspect("victus"), 32).add(Aspect.getAspect("arbor"), 16)
                        .add(Aspect.getAspect("potentia"), 8),
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 3, missing),
                new ItemStack[] { getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0, missing), });
        TCHelper.addResearchPage(
                "ROD_blood_wood",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "wand_cores", 1, 0, missing))));
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
                "RODBLOODWOODSTAFF",
                "FORBIDDEN",
                new AspectList().add(Aspect.getAspect("victus"), 18).add(Aspect.getAspect("instrumentum"), 15)
                        .add(Aspect.getAspect("aqua"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("potentia"), 6).add(Aspect.getAspect("tenebrae"), 3),
                7,
                -5,
                3,
                getModItem(BloodArsenal.ID, "wand_cores", 1, 1, missing))
                        .setParents("ROD_blood_staff", "ROD_blood_wood").setConcealed().setSpecial()
                        .setPages(new ResearchPage("blood_arsenal.research_page.ROD_blood_wood_staff.1"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RODBLOODWOODSTAFF",
                getModItem(BloodArsenal.ID, "wand_cores", 1, 1, missing),
                12,
                new AspectList().add(Aspect.getAspect("victus"), 64).add(Aspect.getAspect("aqua"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("instrumentum"), 48)
                        .add(Aspect.getAspect("metallum"), 16).add(Aspect.getAspect("ignis"), 16)
                        .add(Aspect.getAspect("infernus"), 8).add(Aspect.getAspect("arbor"), 32),
                getModItem(ForbiddenMagic.ID, "WandCores", 1, 9, missing),
                new ItemStack[] { getModItem(BloodArsenal.ID, "wand_cores", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "wand_cores", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_wood", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        getModItem(BloodArsenal.ID, "blood_infused_glowstone_dust", 1, 0, missing), });
        TCHelper.addResearchPage(
                "RODBLOODWOODSTAFF",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(BloodArsenal.ID, "wand_cores", 1, 1, missing))));
        ThaumcraftApi.addWarpToResearch("RODBLOODWOODSTAFF", 7);
        TCHelper.refreshResearchPages("CAP_blood_iron");
        TCHelper.refreshResearchPages("ROD_blood_wood");
    }

    private void orbRecipes() {
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(NewHorizonsCoreMod.ID, "item.TeleposerFrame", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'b',
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        'c',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                        'e',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0, missing),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                        'g',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "telepositionFocus", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'b',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 32, missing),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'e',
                        getModItem(NewHorizonsCoreMod.ID, "item.TeleposerFrame", 1, 0, missing),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "blockTeleposer", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "plateRoseGold",
                        'b',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0, missing),
                        'c',
                        "plateRoseGold",
                        'd',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 32, missing),
                        'e',
                        getModItem(BloodMagic.ID, "telepositionFocus", 1, 0, missing),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 32, missing),
                        'g',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        'h',
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4412, missing),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "reinforcedTelepositionFocus", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'b',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "enhancedTelepositionFocus", 1, 0, missing),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'g',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "archmageBloodOrb", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "demonicTelepositionFocus", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'b',
                        getModItem(BloodMagic.ID, "demonBloodShard", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "demonBloodShard", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "reinforcedTelepositionFocus", 1, 0, missing),
                        'f',
                        getModItem(BloodMagic.ID, "demonBloodShard", 1, 0, missing),
                        'g',
                        getModItem(BloodMagic.ID, "archmageBloodOrb", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "demonBloodShard", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "transcendentBloodOrb", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(NewHorizonsCoreMod.ID, "item.Blaster", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "apprenticeBloodOrb", 1, 0, missing),
                        'b',
                        getModItem(BloodMagic.ID, "crepitous", 1, 0, missing),
                        'c',
                        "gemFlawlessDiamond",
                        'd',
                        getModItem(BloodMagic.ID, "crepitous", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 3, missing),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 15, missing),
                        'g',
                        "gemFlawlessDiamond",
                        'h',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 15, missing),
                        'i',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "energyBlasterSecondTier", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "archmageBloodOrb", 1, 0, missing),
                        'b',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        'c',
                        "gemExquisiteDiamond",
                        'd',
                        getModItem(BloodArsenal.ID, "amorphic_catalyst", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "energyBlaster", 1, 0, missing),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17, missing),
                        'g',
                        "gemExquisiteDiamond",
                        'h',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17, missing),
                        'i',
                        getModItem(BloodMagic.ID, "demonBloodShard", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "energyBlasterThirdTier", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "transcendentBloodOrb", 1, 0, missing),
                        'b',
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0, missing),
                        'c',
                        "gemExquisiteDiamond",
                        'd',
                        getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "energyBlasterSecondTier", 1, 0, missing),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 30, missing),
                        'g',
                        "gemExquisiteDiamond",
                        'h',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 30, missing),
                        'i',
                        getModItem(BloodMagic.ID, "demonPlacer", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 3, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "weakBloodOrb", 1, 0, missing),
                        'b',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        'c',
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                        'd',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        'e',
                        getModItem(NewHorizonsCoreMod.ID, "item.ArcaneSlate", 1, 0, missing),
                        'f',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        'g',
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                        'h',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 4, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "apprenticeBloodOrb", 1, 0, missing),
                        'b',
                        "plateStone",
                        'c',
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        'd',
                        "plateStone",
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 3, missing),
                        'f',
                        "plateStone",
                        'g',
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        'h',
                        "plateStone"));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'b',
                        "plateObsidian",
                        'c',
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        'd',
                        "plateObsidian",
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 4, missing),
                        'f',
                        "plateObsidian",
                        'g',
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        'h',
                        "plateObsidian"));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 31, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0, missing),
                        'b',
                        "plateRoseGold",
                        'c',
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        'd',
                        "plateRoseGold",
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                        'f',
                        "plateRoseGold",
                        'g',
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                        'h',
                        "plateRoseGold",
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 28, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 5, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        'b',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 25028, missing),
                        'c',
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'g',
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 6, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "sanctus", 1, 0, missing),
                        'b',
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                        'c',
                        getModItem(BloodMagic.ID, "sanctus", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'g',
                        getModItem(BloodMagic.ID, "sanctus", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "sanctus", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 7, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "incendium", 1, 0, missing),
                        'b',
                        getModItem(Minecraft.ID, "fire_charge", 1, 0, missing),
                        'c',
                        getModItem(BloodMagic.ID, "incendium", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'g',
                        getModItem(BloodMagic.ID, "incendium", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "incendium", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 10, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "incendium", 1, 0, missing),
                        'b',
                        getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                        'c',
                        getModItem(BloodMagic.ID, "incendium", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'g',
                        getModItem(BloodMagic.ID, "incendium", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "incendium", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 11, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "crystallos", 1, 0, missing),
                        'b',
                        getModItem(Thaumcraft.ID, "FocusFrost", 1, 0, missing),
                        'c',
                        getModItem(BloodMagic.ID, "crystallos", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'g',
                        getModItem(BloodMagic.ID, "crystallos", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "crystallos", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 12, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        'b',
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 30004, missing),
                        'c',
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'g',
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 13, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        'b',
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 29500, missing),
                        'c',
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'g',
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 18, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing),
                        'b',
                        "plateRoseGold",
                        'c',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'g',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 19, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 0, missing),
                        'b',
                        getModItem(Thaumcraft.ID, "ItemSwordThaumium", 1, 0, missing),
                        'c',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'g',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 20, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1, missing),
                        'b',
                        getModItem(Thaumcraft.ID, "ItemChestplateThaumium", 1, 0, missing),
                        'c',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1, missing),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'g',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1, missing),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 21, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 2, missing),
                        'b',
                        getModItem(EnderIO.ID, "itemMaterial", 1, 8, missing),
                        'c',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 2, missing),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'g',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 2, missing),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 2, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 22, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6, missing),
                        'b',
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, 32767, missing),
                        'c',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6, missing),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'g',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6, missing),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 23, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 7, missing),
                        'b',
                        "plateSoularium",
                        'c',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 7, missing),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'g',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 7, missing),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 7, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 24, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        'b',
                        getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                        'c',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'g',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        'h',
                        getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 26, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        'b',
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 6, missing),
                        'c',
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 1, missing),
                        'f',
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        'g',
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 8, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        'b',
                        "plateTitanium",
                        'c',
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'f',
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                        'g',
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        'h',
                        "plateTitanium",
                        'i',
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 14, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                        'b',
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        'e',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 2, missing),
                        'g',
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 2, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 2, missing),
                        'b',
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing),
                        'c',
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 2, missing),
                        'e',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'f',
                        getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "blockCrucible", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "plateAluminium",
                        'b',
                        getModItem(BloodMagic.ID, "apprenticeBloodOrb", 1, 0, missing),
                        'c',
                        "plateAluminium",
                        'd',
                        "plateAluminium",
                        'e',
                        getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 0, missing),
                        'f',
                        "plateAluminium",
                        'g',
                        getModItem(Minecraft.ID, "stone_slab", 1, 0, missing),
                        'h',
                        getModItem(Minecraft.ID, "stone_slab", 1, 0, missing),
                        'i',
                        getModItem(Minecraft.ID, "stone_slab", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "blockConduit", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0, missing),
                        'b',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'c',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 2, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 2, missing),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 2, missing),
                        'g',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0, missing),
                        'h',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0, missing),
                        'i',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellParadigm", 1, 0, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "plateRoseGold",
                        'b',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                        'c',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 8, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 5, missing),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9, missing),
                        'g',
                        "plateRoseGold",
                        'h',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellParadigm", 1, 1, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "plateRoseGold",
                        'b',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                        'c',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 8, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 6, missing),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9, missing),
                        'g',
                        "plateRoseGold",
                        'h',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellParadigm", 1, 2, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "plateRoseGold",
                        'b',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                        'c',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 8, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 7, missing),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9, missing),
                        'g',
                        "plateRoseGold",
                        'h',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing)));
        GameRegistry.addRecipe(
                new ShapedBloodOrbRecipe(
                        getModItem(BloodMagic.ID, "AlchemicalWizardrytile.blockSpellParadigm", 1, 3, missing),
                        "abc",
                        "def",
                        "ghi",
                        'a',
                        "plateRoseGold",
                        'b',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing),
                        'c',
                        getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                        'd',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 8, missing),
                        'e',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 26, missing),
                        'f',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 9, missing),
                        'g',
                        "plateRoseGold",
                        'h',
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 25, missing)));
    }

    private void altarAlchemyRecipes() {
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "weakBloodOrb", 1, 0, missing),
                getModItem(NewHorizonsCoreMod.ID, "item.WeakOrb", 1, 0, missing),
                1,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "apprenticeBloodOrb", 1, 0, missing),
                getModItem(NewHorizonsCoreMod.ID, "item.ApprenticeOrb", 1, 0, missing),
                2,
                10000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "magicianBloodOrb", 1, 0, missing),
                getModItem(NewHorizonsCoreMod.ID, "item.MagicianOrb", 1, 0, missing),
                3,
                30000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "masterBloodOrb", 1, 0, missing),
                getModItem(NewHorizonsCoreMod.ID, "item.MasterOrb", 1, 0, missing),
                4,
                60000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "archmageBloodOrb", 1, 0, missing),
                getModItem(NewHorizonsCoreMod.ID, "item.ArchmageOrb", 1, 0, missing),
                5,
                120000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "transcendentBloodOrb", 1, 0, missing),
                getModItem(NewHorizonsCoreMod.ID, "item.TranscendentOrb", 1, 0, missing),
                6,
                300000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                getModItem(NewHorizonsCoreMod.ID, "item.ArcaneSlate", 1, 0, missing),
                1,
                1000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                2,
                2500,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                getModItem(BloodMagic.ID, "reinforcedSlate", 1, 0, missing),
                3,
                7500,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                4,
                20000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27, missing),
                getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing),
                5,
                60000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                createItemStack(
                        IndustrialCraft2.ID,
                        "itemFluidCell",
                        1,
                        0,
                        "{Fluid:{FluidName:\"lifeessence\",Amount:1000}}",
                        missing),
                getModItem(IndustrialCraft2.ID, "itemFluidCell", 1, 0, missing),
                1,
                1000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "alchemyFlask", 1, 0, missing),
                getModItem(Thaumcraft.ID, "ItemEssence", 1, 0, missing),
                2,
                4000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "blankSpell", 1, 0, missing),
                createItemStack(IndustrialCraft2.ID, "itemBatCrystal", 1, 1, "{charge:1000000.0d}", missing),
                2,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "daggerOfSacrifice", 1, 0, missing),
                getModItem(BloodMagic.ID, "sacrificialKnife", 1, 0, missing),
                2,
                10000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "activationCrystal", 1, 0, missing),
                getModItem(BloodMagic.ID, "blankSpell", 1, 0, missing),
                3,
                20000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "bloodSocket", 1, 0, missing),
                getModItem(BloodMagic.ID, "emptySocket", 1, 0, missing),
                3,
                40000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "waterScribeTool", 1, 0, missing),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing),
                3,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "fireScribeTool", 1, 0, missing),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1, missing),
                3,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "earthScribeTool", 1, 0, missing),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3, missing),
                3,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "airScribeTool", 1, 0, missing),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing),
                3,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "duskScribeTool", 1, 0, missing),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5, missing),
                4,
                10000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "dawnScribeTool", 1, 0, missing),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6, missing),
                6,
                100000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 32, missing),
                getModItem(EnderZoo.ID, "enderFragment", 1, 0, missing),
                4,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodMagic.ID, "enhancedTelepositionFocus", 1, 0, missing),
                getModItem(BloodMagic.ID, "telepositionFocus", 1, 0, missing),
                4,
                20000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(NewHorizonsCoreMod.ID, "tile.BloodyThaumium", 1, 0, missing),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 4, missing),
                2,
                5000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(NewHorizonsCoreMod.ID, "tile.BloodyVoid", 1, 0, missing),
                getModItem(ThaumicBases.ID, "voidBlock", 1, 0, missing),
                3,
                10000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(NewHorizonsCoreMod.ID, "tile.BloodyIchorium", 1, 0, missing),
                getModItem(GregTech.ID, "gt.blockmetal8", 1, 13, missing),
                5,
                50000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(BloodArsenal.ID, "blood_infused_diamond_bound", 1, 0, missing),
                getModItem(BloodArsenal.ID, "blood_infused_diamond_active", 1, 0, missing),
                5,
                10000,
                20,
                20,
                false);
        AltarRecipeRegistry.registerAltarRecipe(
                getModItem(Railcraft.ID, "brick.bloodstained", 1, 2, missing),
                getModItem(Minecraft.ID, "sandstone", 1, 2, missing),
                2,
                3500,
                20,
                20,
                false);
        BindingRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "energySword", 1, 0, missing),
                getModItem(Thaumcraft.ID, "ItemSwordElemental", 1, 0, missing));
        BindingRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "boundPickaxe", 1, 0, missing),
                getModItem(Thaumcraft.ID, "ItemPickaxeElemental", 1, 0, missing));
        BindingRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "boundAxe", 1, 0, missing),
                getModItem(Thaumcraft.ID, "ItemAxeElemental", 1, 0, missing));
        BindingRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "boundShovel", 1, 0, missing),
                getModItem(Thaumcraft.ID, "ItemShovelElemental", 1, 0, missing));
        BindingRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "energyBlaster", 1, 0, missing),
                getModItem(NewHorizonsCoreMod.ID, "item.Blaster", 1, 0, missing));
        BindingRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0, missing),
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23522, missing));
        BindingRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0, missing),
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23516, missing));
        BindingRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 0, missing),
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23523, missing));
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "largeBloodStoneBrick", 4, 0, missing),
                25,
                new ItemStack[] { getModItem(BloodMagic.ID, "ritualStone", 1, 0, missing),
                        getModItem(BloodMagic.ID, "ritualStone", 1, 0, missing),
                        getModItem(BloodMagic.ID, "ritualStone", 1, 0, missing),
                        getModItem(BloodMagic.ID, "ritualStone", 1, 0, missing),
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing),
                5,
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemEssence", 1, 0, missing),
                        getModItem(Genetics.ID, "misc", 1, 4, missing),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                        getModItem(Minecraft.ID, "gunpowder", 1, 0, missing) },
                1);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "crystallos", 1, 0, missing),
                10,
                new ItemStack[] { getModItem(BiomesOPlenty.ID, "hardIce", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "sanctus", 1, 0, missing),
                10,
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 2351, missing),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2890, missing),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "weakFillingAgent", 1, 0, missing),
                20,
                new ItemStack[] { getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                        getModItem(Minecraft.ID, "nether_wart", 1, 0, missing),
                        getModItem(Minecraft.ID, "blaze_powder", 1, 0, missing) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "weakBindingAgent", 1, 0, missing),
                20,
                new ItemStack[] { getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2020, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2805, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2805, missing) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "mundaneLengtheningCatalyst", 1, 0, missing),
                40,
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 2028, missing),
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing),
                        getModItem(BloodMagic.ID, "weakBindingAgent", 1, 0, missing) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "averageLengtheningCatalyst", 1, 0, missing),
                60,
                new ItemStack[] { getModItem(BloodMagic.ID, "standardBindingAgent", 1, 0, missing),
                        getModItem(BloodMagic.ID, "mundaneLengtheningCatalyst", 1, 0, missing),
                        getModItem(BloodMagic.ID, "mundaneLengtheningCatalyst", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing) },
                4);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "greaterLengtheningCatalyst", 1, 0, missing),
                80,
                new ItemStack[] { getModItem(BloodMagic.ID, "aquasalus", 1, 0, missing),
                        getModItem(BloodMagic.ID, "averageLengtheningCatalyst", 1, 0, missing),
                        getModItem(BloodMagic.ID, "averageLengtheningCatalyst", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing) },
                4);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "mundanePowerCatalyst", 1, 0, missing),
                40,
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 2028, missing),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing),
                        getModItem(BloodMagic.ID, "weakBindingAgent", 1, 0, missing) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "averagePowerCatalyst", 1, 0, missing),
                60,
                new ItemStack[] { getModItem(BloodMagic.ID, "standardBindingAgent", 1, 0, missing),
                        getModItem(BloodMagic.ID, "mundanePowerCatalyst", 1, 0, missing),
                        getModItem(BloodMagic.ID, "mundanePowerCatalyst", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing) },
                4);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "greaterPowerCatalyst", 1, 0, missing),
                80,
                new ItemStack[] { getModItem(BloodMagic.ID, "incendium", 1, 0, missing),
                        getModItem(BloodMagic.ID, "averagePowerCatalyst", 1, 0, missing),
                        getModItem(BloodMagic.ID, "averagePowerCatalyst", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing) },
                4);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "standardBindingAgent", 1, 0, missing),
                40,
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 2028, missing),
                        getModItem(BloodMagic.ID, "weakBindingAgent", 1, 0, missing),
                        getModItem(BloodMagic.ID, "weakBindingAgent", 1, 0, missing),
                        getModItem(BloodMagic.ID, "sanctus", 1, 0, missing),
                        getModItem(BloodMagic.ID, "crystallos", 1, 0, missing) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                10,
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8, missing),
                        getModItem(Minecraft.ID, "feather", 1, 0, missing),
                        getModItem(Minecraft.ID, "feather", 1, 0, missing),
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(Minecraft.ID, "web", 1, 0, missing),
                5,
                new ItemStack[] { getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing) },
                1);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 5, missing),
                5,
                new ItemStack[] { getModItem(Minecraft.ID, "bone", 1, 0, missing),
                        getModItem(Minecraft.ID, "bone", 1, 0, missing),
                        getModItem(Minecraft.ID, "bone", 1, 0, missing),
                        getModItem(Minecraft.ID, "bone", 1, 0, missing),
                        getModItem(Minecraft.ID, "gunpowder", 1, 0, missing) },
                1);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(Minecraft.ID, "leather", 3, 0, missing),
                6,
                new ItemStack[] { getModItem(Minecraft.ID, "rotten_flesh", 1, 0, missing),
                        getModItem(Minecraft.ID, "rotten_flesh", 1, 0, missing),
                        getModItem(Minecraft.ID, "rotten_flesh", 1, 0, missing),
                        getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 1, 0, missing) },
                1);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(Minecraft.ID, "fire_charge", 1, 0, missing),
                9,
                new ItemStack[] { getModItem(Minecraft.ID, "blaze_powder", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2535, missing),
                        getModItem(Minecraft.ID, "gunpowder", 1, 0, missing) },
                1);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "incendium", 1, 0, missing),
                10,
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 2541, missing),
                        getModItem(Minecraft.ID, "blaze_powder", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1347, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2807, missing),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                10,
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2330, missing),
                        getModItem(Minecraft.ID, "gunpowder", 1, 0, missing),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "crepitous", 1, 0, missing),
                10,
                new ItemStack[] { getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                        getModItem(Minecraft.ID, "gunpowder", 1, 0, missing),
                        getModItem(Minecraft.ID, "gunpowder", 1, 0, missing),
                        getModItem(BloodMagic.ID, "blankSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                10,
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 45, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2935, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2936, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2804, missing),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "aquasalus", 1, 0, missing),
                10,
                new ItemStack[] { getModItem(Minecraft.ID, "potion", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2543, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2543, missing),
                        getModItem(Minecraft.ID, "dye", 1, 0, missing),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "tennebrae", 1, 0, missing),
                10,
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 2804, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2535, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2536, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2538, missing),
                        getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing) },
                2);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "activationCrystal", 1, 1, missing),
                500,
                new ItemStack[] { getModItem(BloodMagic.ID, "activationCrystal", 1, 0, missing),
                        getModItem(BloodMagic.ID, "demonBloodShard", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aquasalus", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing) },
                4);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "standardFillingAgent", 1, 0, missing),
                40,
                new ItemStack[] { getModItem(BloodMagic.ID, "weakFillingAgent", 1, 0, missing),
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aquasalus", 1, 0, missing) },
                4);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "enhancedFillingAgent", 1, 0, missing),
                60,
                new ItemStack[] { getModItem(BloodMagic.ID, "standardFillingAgent", 1, 0, missing),
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        getModItem(BloodMagic.ID, "crystallos", 1, 0, missing),
                        getModItem(BloodMagic.ID, "aether", 1, 0, missing),
                        getModItem(BloodMagic.ID, "sanctus", 1, 0, missing) },
                4);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing),
                15,
                new ItemStack[] { getModItem(BloodMagic.ID, "simpleCatalyst", 1, 0, missing),
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        getModItem(Minecraft.ID, "dye", 1, 15, missing),
                        getModItem(Minecraft.ID, "nether_wart", 1, 0, missing) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 4, missing),
                30,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1086, missing) },
                4);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "itemComplexSpellCrystal", 1, 0, missing),
                150,
                new ItemStack[] { getModItem(BloodMagic.ID, "blankSpell", 1, 0, missing),
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.EngravedGoldChip", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.EngravedDiamondCrystalChip", 1, 0, missing) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 2, 15, missing),
                20,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 4, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "imbuedSlate", 1, 0, missing),
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing),
                        getModItem(BloodMagic.ID, "magicales", 1, 0, missing) },
                4);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 16, missing),
                60,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 15, missing),
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        getModItem(BloodMagic.ID, "demonicSlate", 1, 0, missing) },
                5);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17, missing),
                120,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 16, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 16, missing),
                        getModItem(BloodMagic.ID, "aquasalus", 1, 0, missing),
                        getModItem(BloodMagic.ID, "incendium", 1, 0, missing) },
                5);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 30, missing),
                250,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 17, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 29, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 29, missing),
                        getModItem(BloodMagic.ID, "weakBloodShard", 1, 0, missing),
                        getModItem(BloodMagic.ID, "bloodMagicBaseItems", 1, 27, missing) },
                6);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 0, missing),
                20,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing),
                        getModItem(BloodMagic.ID, "incendium", 1, 0, missing),
                        getModItem(BloodMagic.ID, "incendium", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 25028, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 25028, missing) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 1, missing),
                20,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing),
                        getModItem(BloodMagic.ID, "tennebrae", 1, 0, missing),
                        getModItem(BloodMagic.ID, "tennebrae", 1, 0, missing),
                        getModItem(Witchery.ID, "ingredient", 1, 56, missing),
                        getModItem(Witchery.ID, "ingredient", 1, 56, missing) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 2, missing),
                20,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing),
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        getModItem(BloodMagic.ID, "terrae", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2542, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2542, missing) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 6, missing),
                40,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2346, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2346, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.ChargedCertusQuartzDust", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.ChargedCertusQuartzDust", 1, 0, missing) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 7, missing),
                40,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2702, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2379, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2379, missing) },
                3);
        AlchemyRecipeRegistry.registerRecipe(
                getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 8, missing),
                40,
                new ItemStack[] { getModItem(BloodMagic.ID, "bloodMagicBaseAlchemyItems", 1, 3, missing),
                        getModItem(IndustrialCraft2.ID, "itemDust2", 1, 2, missing),
                        getModItem(IndustrialCraft2.ID, "itemDust2", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2367, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2367, missing) },
                3);
    }
}
