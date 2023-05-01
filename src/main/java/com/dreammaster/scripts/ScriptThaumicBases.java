package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.CarpentersBlocks;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCompressorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCutterRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.oredict.OreDictHelper;
import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.GT_Values;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptThaumicBases implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Thaumic Bases";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                ThaumicBases.ID,
                Thaumcraft.ID,
                Railcraft.ID,
                IronTanks.ID,
                ExtraUtilities.ID,
                GTPlusPlus.ID,
                CarpentersBlocks.ID,
                TwilightForest.ID,
                ThaumicTinkerer.ID,
                IndustrialCraft2.ID);
    }

    @Override
    public void loadRecipes() {

        addShapelessCraftingRecipe(
                getModItem(ThaumicBases.ID, "relocator", 1, 0, missing),
                new Object[] { getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                        getModItem(ThaumicBases.ID, "relocator", 1, 6, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing) });

        addShapelessCraftingRecipe(
                getModItem(ThaumicBases.ID, "relocator", 1, 6, missing),
                new Object[] { getModItem(Thaumcraft.ID, "ItemResource", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "relocator", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 0, missing) });

        GT_Values.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "ItemResource", 9, 3, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "quicksilverBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);

        OreDictHelper.removeOreDict("gravel", getModItem(ThaumicBases.ID, "oldGravel", 1, 0, missing));

        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "eldritchArk", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "eldritchArk", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 20)).noFluidOutputs().duration(200)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "eldritchArk", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldBrick", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldBrick", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 20)).noFluidOutputs().duration(200)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldBrick", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldCobble", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldCobble", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 20)).noFluidOutputs().duration(200)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldCobble", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldCobbleMossy", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldCobbleMossy", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 20)).noFluidOutputs().duration(200)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldCobbleMossy", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldDiamond", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldDiamond", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 20)).noFluidOutputs().duration(200)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldDiamond", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 32)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldGold", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldGold", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 20)).noFluidOutputs().duration(200)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldGold", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldIron", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldIron", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 20)).noFluidOutputs().duration(200)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldIron", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldLapis", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldLapis", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 20)).noFluidOutputs().duration(200)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "oldLapis", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "genericSlab", 2, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 20)).noFluidOutputs().duration(200)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 0, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 1, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 1, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 20)).noFluidOutputs().duration(200)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 1, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 2, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 2, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 20)).noFluidOutputs().duration(200)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 2, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 3, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 3, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 20)).noFluidOutputs().duration(200)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 3, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 4, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 4, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 20)).noFluidOutputs().duration(200)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 4, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 32)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 5, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 5, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 20)).noFluidOutputs().duration(200)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 5, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 6, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 6, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 20)).noFluidOutputs().duration(200)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 6, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 7, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 7, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 20)).noFluidOutputs().duration(200)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "crystalBlock", 1, 7, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "crystalSlab", 2, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);

        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "relocator", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "relocator", 1, 6, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "advAlchFurnace", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "thaumicAnvil", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "resource", 1, 3, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "bloodyChest", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "bloodyLeggings", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "bloodyBoots", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "spike", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "spike", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "spike", 1, 4, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "voidAnvil", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "voidSeed", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "fociExperience", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "fociActivation", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "fociDrain", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "fociFlux", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "cryingObsidian", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 1, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 3, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 4, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 11, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 5, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 6, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 7, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 8, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 9, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 10, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 12, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 1, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 2, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 3, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 4, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 5, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 6, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 7, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 8, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeFoci", 1, 9, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "nodeManipulator", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "resource", 1, 4, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "entityDeconstructor", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicBases.ID, "nodeLinker", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicBases.ID, "overchanter", 1, 0, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Relocator",
                getModItem(ThaumicBases.ID, "relocator", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("aqua"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6, missing),
                'b',
                "plateInfusedAir",
                'c',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6, missing),
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                'e',
                "rotorThaumium",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                'g',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6, missing),
                'h',
                "plateInfusedWater",
                'i',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Relocator",
                getModItem(ThaumicBases.ID, "relocator", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("aqua"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6, missing),
                'b',
                "plateInfusedWater",
                'c',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6, missing),
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0, missing),
                'e',
                "rotorThaumium",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0, missing),
                'g',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6, missing),
                'h',
                "plateInfusedAir",
                'i',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6, missing));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.AdvAlc",
                getModItem(ThaumicBases.ID, "advAlchFurnace", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("ignis"), 48).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("machina"), 16).add(Aspect.getAspect("metallum"), 16)
                        .add(Aspect.getAspect("praecantatio"), 24),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 0, missing),
                new ItemStack[] { getModItem(Railcraft.ID, "machine.beta", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 22305, missing),
                        getModItem(GregTech.ID, "gt.blockmetal7", 1, 4, missing),
                        getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.blockmetal7", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 22305, missing), });
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.ThaumicAnvil",
                getModItem(ThaumicBases.ID, "thaumicAnvil", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("ignis"), 50)
                        .add(Aspect.getAspect("aqua"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                "blockThaumium",
                'b',
                "blockThaumium",
                'c',
                "blockThaumium",
                'd',
                "screwThaumium",
                'e',
                "blockThaumium",
                'f',
                "screwThaumium",
                'g',
                "plateThaumium",
                'h',
                "blockThaumium",
                'i',
                "plateThaumium");
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ROD_tbthaumium",
                getModItem(ThaumicBases.ID, "resource", 1, 3, missing),
                6,
                new AspectList().add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("auram"), 16)
                        .add(Aspect.getAspect("metallum"), 16).add(Aspect.getAspect("vitreus"), 16)
                        .add(Aspect.getAspect("instrumentum"), 32),
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23330, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2330, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2330, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2330, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2330, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2330, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2330, missing), });
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.BloodyRobes",
                getModItem(ThaumicBases.ID, "bloodyChest", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 25).add(Aspect.getAspect("ignis"), 25)
                        .add(Aspect.getAspect("aqua"), 25).add(Aspect.getAspect("ordo"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(ThaumicBases.ID, "resource", 1, 8, missing),
                'b',
                "plateThaumium",
                'c',
                getModItem(ThaumicBases.ID, "resource", 1, 8, missing),
                'd',
                getModItem(ThaumicBases.ID, "resource", 1, 8, missing),
                'e',
                "plateThaumium",
                'f',
                getModItem(ThaumicBases.ID, "resource", 1, 8, missing),
                'g',
                getModItem(ThaumicBases.ID, "resource", 1, 8, missing),
                'h',
                getModItem(ThaumicBases.ID, "resource", 1, 8, missing),
                'i',
                getModItem(ThaumicBases.ID, "resource", 1, 8, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.BloodyRobes",
                getModItem(ThaumicBases.ID, "bloodyLeggings", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 25).add(Aspect.getAspect("ignis"), 25)
                        .add(Aspect.getAspect("aqua"), 25).add(Aspect.getAspect("perditio"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(ThaumicBases.ID, "resource", 1, 8, missing),
                'b',
                getModItem(ThaumicBases.ID, "resource", 1, 8, missing),
                'c',
                getModItem(ThaumicBases.ID, "resource", 1, 8, missing),
                'd',
                getModItem(ThaumicBases.ID, "resource", 1, 8, missing),
                'e',
                "plateThaumium",
                'f',
                getModItem(ThaumicBases.ID, "resource", 1, 8, missing),
                'g',
                getModItem(ThaumicBases.ID, "resource", 1, 8, missing),
                'h',
                "plateThaumium",
                'i',
                getModItem(ThaumicBases.ID, "resource", 1, 8, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.BloodyRobes",
                getModItem(ThaumicBases.ID, "bloodyBoots", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 25).add(Aspect.getAspect("ignis"), 25)
                        .add(Aspect.getAspect("aqua"), 25).add(Aspect.getAspect("terra"), 25),
                "abc",
                "def",
                "ghi",
                'd',
                getModItem(ThaumicBases.ID, "resource", 1, 8, missing),
                'e',
                "plateThaumium",
                'f',
                getModItem(ThaumicBases.ID, "resource", 1, 8, missing),
                'g',
                getModItem(ThaumicBases.ID, "resource", 1, 8, missing),
                'h',
                "plateThaumium",
                'i',
                getModItem(ThaumicBases.ID, "resource", 1, 8, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Spike.Iron",
                getModItem(ThaumicBases.ID, "spike", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 20).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("terra"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolSaw",
                'c',
                "craftingToolScrewdriver",
                'd',
                "screwSteel",
                'e',
                "ingotSteel",
                'f',
                "screwSteel",
                'g',
                "ingotSteel",
                'h',
                "blockSteel",
                'i',
                "ingotSteel");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Spike.Thaumic",
                getModItem(ThaumicBases.ID, "spike", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 50).add(Aspect.getAspect("ignis"), 50)
                        .add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("terra"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolSaw",
                'c',
                "craftingToolScrewdriver",
                'd',
                "screwThaumium",
                'e',
                "ingotThaumium",
                'f',
                "screwThaumium",
                'g',
                "ingotThaumium",
                'h',
                "blockThaumium",
                'i',
                "ingotThaumium");
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.Spike.Void",
                getModItem(ThaumicBases.ID, "spike", 1, 4, missing),
                5,
                new AspectList().add(Aspect.getAspect("telum"), 32).add(Aspect.getAspect("instrumentum"), 32)
                        .add(Aspect.getAspect("tenebrae"), 16).add(Aspect.getAspect("alienis"), 16)
                        .add(Aspect.getAspect("metallum"), 16).add(Aspect.getAspect("mortuus"), 16),
                getModItem(ThaumicBases.ID, "spike", 1, 2, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17970, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 14970, missing),
                        getModItem(Thaumcraft.ID, "ItemSwordVoid", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17970, missing),
                        getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemSwordVoid", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 14970, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17970, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.VoidAnvil",
                getModItem(ThaumicBases.ID, "voidAnvil", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("telum"), 32).add(Aspect.getAspect("instrumentum"), 32)
                        .add(Aspect.getAspect("fabrico"), 32).add(Aspect.getAspect("alienis"), 32)
                        .add(Aspect.getAspect("tenebrae"), 16).add(Aspect.getAspect("vacuos"), 16)
                        .add(Aspect.getAspect("metallum"), 16).add(Aspect.getAspect("praecantatio"), 16),
                getModItem(ThaumicBases.ID, "thaumicAnvil", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17970, missing),
                        getModItem(ThaumicBases.ID, "voidBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17970, missing),
                        getModItem(ThaumicBases.ID, "voidBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17970, missing),
                        getModItem(ThaumicBases.ID, "voidBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17970, missing),
                        getModItem(ThaumicBases.ID, "voidBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17970, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.VoidSeed",
                getModItem(ThaumicBases.ID, "voidSeed", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("messis"), 64).add(Aspect.getAspect("herba"), 64)
                        .add(Aspect.getAspect("victus"), 32).add(Aspect.getAspect("auram"), 32)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("alienis"), 16)
                        .add(Aspect.getAspect("tenebrae"), 16).add(Aspect.getAspect("desidia"), 8)
                        .add(Aspect.getAspect("nebrisum"), 8),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 17, missing),
                new ItemStack[] { getModItem(ThaumicBases.ID, "lazulliaSeeds", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "lucriteSeeds", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "redlonSeeds", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "rainbowCactus", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "metalleatSeeds", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "plaxSeed", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "briar", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "aurelia", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "ashroom", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "knoseSeed", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "flaxium", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "glieoniaSeed", 1, 0, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CAP_thauminite",
                getModItem(ThaumicBases.ID, "resource", 1, 2, missing),
                6,
                new AspectList().add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("auram"), 16)
                        .add(Aspect.getAspect("metallum"), 16).add(Aspect.getAspect("vitreus"), 16)
                        .add(Aspect.getAspect("instrumentum"), 32),
                getModItem(Thaumcraft.ID, "WandCap", 1, 2, missing),
                new ItemStack[] { getModItem(ThaumicBases.ID, "resource", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 3, missing),
                        getModItem(ThaumicBases.ID, "resource", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 3, missing),
                        getModItem(ThaumicBases.ID, "resource", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 3, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.Foci.Experience",
                getModItem(ThaumicBases.ID, "fociExperience", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("lucrum"), 32).add(Aspect.getAspect("vitreus"), 32)
                        .add(Aspect.getAspect("cognitio"), 16).add(Aspect.getAspect("permutatio"), 16),
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 24501, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "FocusExcavation", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 29501, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 29501, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 3, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.Foci.Activation",
                getModItem(ThaumicBases.ID, "fociActivation", 1, 0, missing),
                4,
                new AspectList().add(Aspect.getAspect("motus"), 32).add(Aspect.getAspect("vitreus"), 32)
                        .add(Aspect.getAspect("iter"), 16).add(Aspect.getAspect("sensus"), 16),
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 24545, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "blockCrystal", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32680, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 4, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32690, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 4, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.Foci.Drain",
                getModItem(ThaumicBases.ID, "fociDrain", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("vacuos"), 32).add(Aspect.getAspect("perditio"), 32)
                        .add(Aspect.getAspect("aqua"), 16),
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 24543, missing),
                new ItemStack[] { getModItem(Minecraft.ID, "bucket", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing),
                        getModItem(Thaumcraft.ID, "blockJar", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing),
                        getModItem(IronTanks.ID, "ironTank", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing),
                        getModItem(ExtraUtilities.ID, "trashcan", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.Foci.Flux",
                getModItem(ThaumicBases.ID, "fociFlux", 1, 0, missing),
                7,
                new AspectList().add(Aspect.getAspect("vitium"), 32).add(Aspect.getAspect("perditio"), 32)
                        .add(Aspect.getAspect("ordo"), 16).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("sano"), 16),
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 24533, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "blockCrystal", 1, 6, missing),
                        getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 4, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 6, missing),
                        getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 14, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 6, missing),
                        getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 6, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.CryingObs",
                getModItem(ThaumicBases.ID, "cryingObsidian", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("iter"), 32).add(Aspect.getAspect("vinculum"), 32)
                        .add(Aspect.getAspect("desidia"), 16).add(Aspect.getAspect("sensus"), 16),
                getModItem(GTPlusPlus.ID, "blockCompressedObsidian", 1, 1, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 8, missing),
                        getModItem(CarpentersBlocks.ID, "itemCarpentersBed", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 29500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 22330, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.TaintFlask",
                getModItem(ThaumicBases.ID, "concentratedTaint", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("vitium"), 64).add(Aspect.getAspect("venenum"), 32)
                        .add(Aspect.getAspect("perditio"), 16),
                getModItem(Thaumcraft.ID, "ItemBottleTaint", 1, 0, missing),
                new ItemStack[] { getModItem(ThaumicBases.ID, "knoseFragment", 1, 7, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(ThaumicBases.ID, "knoseFragment", 1, 7, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(ThaumicBases.ID, "knoseFragment", 1, 7, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.EntityDec",
                getModItem(ThaumicBases.ID, "entityDeconstructor", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("cognitio"), 32).add(Aspect.getAspect("spiritus"), 24)
                        .add(Aspect.getAspect("mortuus"), 16).add(Aspect.getAspect("praecantatio"), 16),
                getModItem(Thaumcraft.ID, "blockTable", 1, 14, missing),
                new ItemStack[] { getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 24540, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 24541, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 24543, missing),
                        getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 24542, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 24544, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 24545, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ROD_tbvoid",
                getModItem(ThaumicBases.ID, "resource", 1, 4, missing),
                8,
                new AspectList().add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("auram"), 32)
                        .add(Aspect.getAspect("vitreus"), 16).add(Aspect.getAspect("instrumentum"), 32)
                        .add(Aspect.getAspect("potentia"), 40).add(Aspect.getAspect("vacuos"), 24),
                getModItem(ThaumicBases.ID, "resource", 1, 3, missing),
                new ItemStack[] { getModItem(ThaumicBases.ID, "knoseFragment", 1, 7, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 7, missing),
                        getModItem(ThaumicBases.ID, "knoseFragment", 1, 7, missing),
                        getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17970, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 7, missing),
                        getModItem(ThaumicBases.ID, "knoseFragment", 1, 7, missing),
                        getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17970, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.NodeMan",
                getModItem(ThaumicBases.ID, "nodeManipulator", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("auram"), 48)
                        .add(Aspect.getAspect("praecantatio"), 40).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("vacuos"), 32).add(Aspect.getAspect("tenebrae"), 24),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 11, missing),
                new ItemStack[] { getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32683, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17362, missing),
                        getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 10, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 10, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32693, missing),
                        getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 14, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32693, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 10, missing),
                        getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 10, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17362, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32683, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.NodeLinker",
                getModItem(ThaumicBases.ID, "nodeLinker", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("potentia"), 64).add(Aspect.getAspect("machina"), 48)
                        .add(Aspect.getAspect("instrumentum"), 40).add(Aspect.getAspect("ordo"), 32)
                        .add(Aspect.getAspect("electrum"), 32),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 11, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 14, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.ReinforcedGlassLense", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.ReinforcedGlassLense", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32681, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.Overchanter",
                getModItem(ThaumicBases.ID, "overchanter", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("aqua"), 32)
                        .add(Aspect.getAspect("terra"), 32).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("perditio"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("machina"), 32)
                        .add(Aspect.getAspect("cognitio"), 32),
                getModItem(Minecraft.ID, "enchanting_table", 1, 0, missing),
                new ItemStack[] { getModItem(ThaumicBases.ID, "crystalBlock", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 1, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 2, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 3, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 4, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 5, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 6, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 6, missing),
                        getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmetal7", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.blockmetal7", 1, 4, missing), });
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Iron",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("aqua"), 30).add(Aspect.getAspect("terra"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                "screwAluminium",
                'b',
                getModItem(TwilightForest.ID, "item.nagaScale", 1, 0, missing),
                'c',
                "screwAluminium",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 0, missing),
                'e',
                "stickIron",
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 0, missing),
                'g',
                "boltIron",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltIron");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Gold",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aer"), 60).add(Aspect.getAspect("ignis"), 60)
                        .add(Aspect.getAspect("aqua"), 60).add(Aspect.getAspect("terra"), 60)
                        .add(Aspect.getAspect("ordo"), 60).add(Aspect.getAspect("perditio"), 60),
                "abc",
                "def",
                "ghi",
                'a',
                "screwStainlessSteel",
                'b',
                getModItem(NewHorizonsCoreMod.ID, "item.LichBone", 1, 0, missing),
                'c',
                "screwStainlessSteel",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 1, missing),
                'e',
                "stickGold",
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 1, missing),
                'g',
                "boltGold",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltGold");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Greatwood",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("aer"), 90).add(Aspect.getAspect("ignis"), 90)
                        .add(Aspect.getAspect("aqua"), 90).add(Aspect.getAspect("terra"), 90)
                        .add(Aspect.getAspect("ordo"), 90).add(Aspect.getAspect("perditio"), 90),
                "abc",
                "def",
                "ghi",
                'a',
                "screwStainlessSteel",
                'b',
                getModItem(NewHorizonsCoreMod.ID, "item.LichBone", 1, 0, missing),
                'c',
                "screwStainlessSteel",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 1, missing),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 0, missing),
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 1, missing),
                'g',
                "boltRoseGold",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltRoseGold");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Reed",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("aer"), 120).add(Aspect.getAspect("ignis"), 120)
                        .add(Aspect.getAspect("aqua"), 120).add(Aspect.getAspect("terra"), 120)
                        .add(Aspect.getAspect("ordo"), 120).add(Aspect.getAspect("perditio"), 120),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTitanium",
                'b',
                getModItem(TwilightForest.ID, "item.fieryBlood", 1, 0, missing),
                'c',
                "screwTitanium",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2, missing),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 5, missing),
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2, missing),
                'g',
                "boltThaumium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Bone",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("aer"), 120).add(Aspect.getAspect("ignis"), 120)
                        .add(Aspect.getAspect("aqua"), 120).add(Aspect.getAspect("terra"), 120)
                        .add(Aspect.getAspect("ordo"), 120).add(Aspect.getAspect("perditio"), 120),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTitanium",
                'b',
                getModItem(TwilightForest.ID, "item.fieryBlood", 1, 0, missing),
                'c',
                "screwTitanium",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2, missing),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 7, missing),
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2, missing),
                'g',
                "boltThaumium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Obsidian",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("aer"), 120).add(Aspect.getAspect("ignis"), 120)
                        .add(Aspect.getAspect("aqua"), 120).add(Aspect.getAspect("terra"), 120)
                        .add(Aspect.getAspect("ordo"), 120).add(Aspect.getAspect("perditio"), 120),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTitanium",
                'b',
                getModItem(TwilightForest.ID, "item.fieryBlood", 1, 0, missing),
                'c',
                "screwTitanium",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2, missing),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 1, missing),
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2, missing),
                'g',
                "boltThaumium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Blaze",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 8, missing),
                new AspectList().add(Aspect.getAspect("aer"), 120).add(Aspect.getAspect("ignis"), 120)
                        .add(Aspect.getAspect("aqua"), 120).add(Aspect.getAspect("terra"), 120)
                        .add(Aspect.getAspect("ordo"), 120).add(Aspect.getAspect("perditio"), 120),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTitanium",
                'b',
                getModItem(TwilightForest.ID, "item.fieryBlood", 1, 0, missing),
                'c',
                "screwTitanium",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2, missing),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 6, missing),
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2, missing),
                'g',
                "boltThaumium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Ice",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 9, missing),
                new AspectList().add(Aspect.getAspect("aer"), 120).add(Aspect.getAspect("ignis"), 120)
                        .add(Aspect.getAspect("aqua"), 120).add(Aspect.getAspect("terra"), 120)
                        .add(Aspect.getAspect("ordo"), 120).add(Aspect.getAspect("perditio"), 120),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTitanium",
                'b',
                getModItem(TwilightForest.ID, "item.fieryBlood", 1, 0, missing),
                'c',
                "screwTitanium",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2, missing),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 3, missing),
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2, missing),
                'g',
                "boltThaumium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Quartz",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 10, missing),
                new AspectList().add(Aspect.getAspect("aer"), 120).add(Aspect.getAspect("ignis"), 120)
                        .add(Aspect.getAspect("aqua"), 120).add(Aspect.getAspect("terra"), 120)
                        .add(Aspect.getAspect("ordo"), 120).add(Aspect.getAspect("perditio"), 120),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTitanium",
                'b',
                getModItem(TwilightForest.ID, "item.fieryBlood", 1, 0, missing),
                'c',
                "screwTitanium",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2, missing),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 4, missing),
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2, missing),
                'g',
                "boltThaumium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Thaumium",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("aer"), 135).add(Aspect.getAspect("ignis"), 135)
                        .add(Aspect.getAspect("aqua"), 135).add(Aspect.getAspect("terra"), 135)
                        .add(Aspect.getAspect("ordo"), 135).add(Aspect.getAspect("perditio"), 135),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTitanium",
                'b',
                getModItem(TwilightForest.ID, "item.fieryTears", 1, 0, missing),
                'c',
                "screwTitanium",
                'd',
                getModItem(ThaumicBases.ID, "resource", 1, 2, missing),
                'e',
                getModItem(ThaumicBases.ID, "resource", 1, 3, missing),
                'f',
                getModItem(ThaumicBases.ID, "resource", 1, 2, missing),
                'g',
                "boltThaumium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Silverwood",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("aer"), 150).add(Aspect.getAspect("ignis"), 150)
                        .add(Aspect.getAspect("aqua"), 150).add(Aspect.getAspect("terra"), 150)
                        .add(Aspect.getAspect("ordo"), 150).add(Aspect.getAspect("perditio"), 150),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTungstenSteel",
                'b',
                getModItem(TwilightForest.ID, "item.carminite", 1, 0, missing),
                'c',
                "screwTungstenSteel",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 7, missing),
                'e',
                getModItem(Thaumcraft.ID, "WandRod", 1, 2, missing),
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 7, missing),
                'g',
                "boltVoid",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltVoid");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TB.Bracelet.Void",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 11, missing),
                new AspectList().add(Aspect.getAspect("aer"), 150).add(Aspect.getAspect("ignis"), 150)
                        .add(Aspect.getAspect("aqua"), 150).add(Aspect.getAspect("terra"), 150)
                        .add(Aspect.getAspect("ordo"), 150).add(Aspect.getAspect("perditio"), 150),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTungstenSteel",
                'b',
                getModItem(TwilightForest.ID, "item.carminite", 1, 0, missing),
                'c',
                "screwTungstenSteel",
                'd',
                getModItem(Thaumcraft.ID, "WandCap", 1, 7, missing),
                'e',
                getModItem(ThaumicBases.ID, "resource", 1, 4, missing),
                'f',
                getModItem(Thaumcraft.ID, "WandCap", 1, 7, missing),
                'g',
                "boltVoid",
                'h',
                "craftingToolScrewdriver",
                'i',
                "boltVoid");
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.Bracelet.Primal",
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 12, missing),
                10,
                new AspectList().add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("ignis"), 64)
                        .add(Aspect.getAspect("aqua"), 64).add(Aspect.getAspect("terra"), 64)
                        .add(Aspect.getAspect("ordo"), 64).add(Aspect.getAspect("perditio"), 64)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("alienis"), 32),
                getModItem(ThaumicBases.ID, "castingBracelet", 1, 4, missing),
                new ItemStack[] { getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 4, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.SnowQueenBlood", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "castingBracelet", 1, 5, missing),
                        getModItem(ThaumicBases.ID, "castingBracelet", 1, 6, missing),
                        getModItem(ThaumicBases.ID, "castingBracelet", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27084, missing),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27084, missing),
                        getModItem(ThaumicBases.ID, "castingBracelet", 1, 8, missing),
                        getModItem(ThaumicBases.ID, "castingBracelet", 1, 9, missing),
                        getModItem(ThaumicBases.ID, "castingBracelet", 1, 10, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.SnowQueenBlood", 1, 0, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.NodeFoci.Bright",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("auram"), 256).add(Aspect.getAspect("lux"), 192)
                        .add(Aspect.getAspect("potentia"), 128).add(Aspect.getAspect("superbia"), 64)
                        .add(Aspect.getAspect("nebrisum"), 32),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3, missing),
                        getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 7, missing),
                        getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 7, missing),
                        getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 7, missing),
                        getModItem(ThaumicBases.ID, "blockSalisMundus", 1, 0, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.NodeFoci.Destr",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 1, missing),
                8,
                new AspectList().add(Aspect.getAspect("auram"), 128).add(Aspect.getAspect("perditio"), 96)
                        .add(Aspect.getAspect("vacuos"), 64).add(Aspect.getAspect("mortuus"), 32),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "FocusPrimal", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 5, missing),
                        getModItem(GTPlusPlus.ID, "blockCompressedObsidian", 1, 1, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 5, missing),
                        getModItem(GTPlusPlus.ID, "blockCompressedObsidian", 1, 1, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 5, missing),
                        getModItem(GTPlusPlus.ID, "blockCompressedObsidian", 1, 1, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 5, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.NodeFoci.Efficiency",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 2, missing),
                7,
                new AspectList().add(Aspect.getAspect("auram"), 128).add(Aspect.getAspect("potentia"), 96)
                        .add(Aspect.getAspect("electrum"), 64).add(Aspect.getAspect("machina"), 64),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12, missing),
                new ItemStack[] { getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 9, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 9, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 9, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 1, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.NodeFoci.Hunger",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 3, missing),
                10,
                new AspectList().add(Aspect.getAspect("auram"), 256).add(Aspect.getAspect("fames"), 192)
                        .add(Aspect.getAspect("lucrum"), 128).add(Aspect.getAspect("vacuos"), 96)
                        .add(Aspect.getAspect("gula"), 64),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "voidBlock", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 11, missing),
                        getModItem(ThaumicBases.ID, "voidBlock", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 11, missing),
                        getModItem(ThaumicBases.ID, "voidBlock", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 11, missing),
                        getModItem(ThaumicBases.ID, "voidBlock", 1, 0, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.NodeFoci.Unstable",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 4, missing),
                8,
                new AspectList().add(Aspect.getAspect("auram"), 128).add(Aspect.getAspect("alienis"), 96)
                        .add(Aspect.getAspect("vacuos"), 64).add(Aspect.getAspect("perditio"), 32),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12, missing),
                new ItemStack[] { getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 2, missing),
                        getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 7, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 2, missing),
                        getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 7, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 2, missing),
                        getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 7, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 2, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.NodeFoci.Purity",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 5, missing),
                8,
                new AspectList().add(Aspect.getAspect("auram"), 128).add(Aspect.getAspect("sano"), 96)
                        .add(Aspect.getAspect("victus"), 64).add(Aspect.getAspect("vitreus"), 32),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemResource", 1, 3, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 6, missing),
                        getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 1, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 6, missing),
                        getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 1, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 6, missing),
                        getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 1, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 6, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.NodeFoci.Sinister",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 6, missing),
                9,
                new AspectList().add(Aspect.getAspect("auram"), 128).add(Aspect.getAspect("tenebrae"), 96)
                        .add(Aspect.getAspect("exanimis"), 64).add(Aspect.getAspect("spiritus"), 32),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemCompassStone", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1, missing),
                        getModItem(Minecraft.ID, "skull", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1, missing),
                        getModItem(Minecraft.ID, "skull", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1, missing),
                        getModItem(Minecraft.ID, "skull", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.NodeFoci.Speed",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 7, missing),
                8,
                new AspectList().add(Aspect.getAspect("auram"), 128).add(Aspect.getAspect("potentia"), 96)
                        .add(Aspect.getAspect("motus"), 64).add(Aspect.getAspect("aer"), 32),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12, missing),
                new ItemStack[] { getModItem(Minecraft.ID, "sugar", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 2, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 2, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 2, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 0, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.NodeFoci.Stability",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 8, missing),
                7,
                new AspectList().add(Aspect.getAspect("auram"), 128).add(Aspect.getAspect("cognitio"), 96)
                        .add(Aspect.getAspect("instrumentum"), 64).add(Aspect.getAspect("ordo"), 32),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemResource", 1, 10, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 4, missing),
                        getModItem(ThaumicBases.ID, "thauminiteBlock", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 4, missing),
                        getModItem(ThaumicBases.ID, "thauminiteBlock", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 4, missing),
                        getModItem(ThaumicBases.ID, "thauminiteBlock", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 4, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB.NodeFoci.Taint",
                getModItem(ThaumicBases.ID, "nodeFoci", 1, 9, missing),
                10,
                new AspectList().add(Aspect.getAspect("auram"), 256).add(Aspect.getAspect("vitium"), 192)
                        .add(Aspect.getAspect("venenum"), 128).add(Aspect.getAspect("perditio"), 64)
                        .add(Aspect.getAspect("strontio"), 32),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 12, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemResource", 1, 11, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 7, missing),
                        getModItem(ThaumicBases.ID, "concentratedTaint", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 7, missing),
                        getModItem(ThaumicBases.ID, "concentratedTaint", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 7, missing),
                        getModItem(ThaumicBases.ID, "concentratedTaint", 1, 0, missing),
                        getModItem(ThaumicBases.ID, "crystalBlock", 1, 7, missing), });
        ThaumcraftApi.addCrucibleRecipe(
                "TB.SM",
                getModItem(Thaumcraft.ID, "ItemResource", 2, 14, missing),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("aer"), 4).add(Aspect.getAspect("aqua"), 4)
                        .add(Aspect.getAspect("ignis"), 4).add(Aspect.getAspect("praecantatio"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("perditio"), 4)
                        .add(Aspect.getAspect("terra"), 4));
        ThaumcraftApi.addCrucibleRecipe(
                "TB.Amber",
                getModItem(Thaumcraft.ID, "ItemResource", 1, 6, missing),
                getModItem(Minecraft.ID, "sapling", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("vinculum"), 4));
        ThaumcraftApi.addCrucibleRecipe(
                "TB.Quicksilver",
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3, missing),
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 1).add(Aspect.getAspect("venenum"), 1));
        TCHelper.refreshResearchPages("TB.Relocator");
        TCHelper.clearPages("TB.AdvAlc");
        TCHelper.addResearchPage("TB.AdvAlc", new ResearchPage("tb.rec.advAlc.page.0"));
        TCHelper.addResearchPage(
                "TB.AdvAlc",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ThaumicBases.ID, "advAlchFurnace", 1, 0, missing))));
        TCHelper.refreshResearchPages("TB.ThaumicAnvil");
        ThaumcraftApi.addWarpToResearch("TB.ThaumicAnvil", 1);
        TCHelper.clearPages("ROD_tbthaumium");
        TCHelper.addResearchPage("ROD_tbthaumium", new ResearchPage("tb.rec.thaumRod.page.0"));
        TCHelper.addResearchPage(
                "ROD_tbthaumium",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ThaumicBases.ID, "resource", 1, 3, missing))));
        TCHelper.refreshResearchPages("TB.BloodyRobes");
        ThaumcraftApi.addWarpToResearch("TB.BloodyRobes", 3);
        TCHelper.refreshResearchPages("TB.Spike.Iron");
        TCHelper.refreshResearchPages("TB.Spike.Thaumic");
        ThaumcraftApi.addWarpToResearch("TB.Spike.Thaumic", 2);
        TCHelper.clearPages("TB.Spike.Void");
        TCHelper.addResearchPage("TB.Spike.Void", new ResearchPage("tb.rec.spikeVoid.page.0"));
        TCHelper.addResearchPage(
                "TB.Spike.Void",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ThaumicBases.ID, "spike", 1, 4, missing))));
        ThaumcraftApi.addWarpToResearch("TB.Spike.Void", 3);
        TCHelper.refreshResearchPages("TB.VoidAnvil");
        ThaumcraftApi.addWarpToResearch("TB.VoidAnvil", 4);
        TCHelper.refreshResearchPages("TB.VoidSeed");
        ThaumcraftApi.addWarpToResearch("TB.VoidSeed", 5);
        TCHelper.clearPages("CAP_thauminite");
        TCHelper.addResearchPage("CAP_thauminite", new ResearchPage("tb.rec.capthauminite.page.NH.0"));
        TCHelper.addResearchPage("CAP_thauminite", new ResearchPage("tb.rec.capthauminite.page.NH.1"));
        TCHelper.addResearchPage(
                "CAP_thauminite",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ThaumicBases.ID, "resource", 1, 2, missing))));
        ThaumcraftApi.addWarpToResearch("CAP_thauminite", 2);
        TCHelper.refreshResearchPages("TB.Foci.Experience");
        TCHelper.refreshResearchPages("TB.Foci.Activation");
        TCHelper.refreshResearchPages("TB.Foci.Drain");
        TCHelper.refreshResearchPages("TB.Foci.Flux");
        TCHelper.refreshResearchPages("TB.CryingObs");
        TCHelper.refreshResearchPages("TB.Bracelet.Iron");
        TCHelper.refreshResearchPages("TB.Bracelet.Gold");
        TCHelper.refreshResearchPages("TB.Bracelet.Greatwood");
        TCHelper.refreshResearchPages("TB.Bracelet.Thaumium");
        TCHelper.refreshResearchPages("TB.Bracelet.Primal");
        TCHelper.clearPages("TB.Bracelet.Silverwood");
        TCHelper.addResearchPage("TB.Bracelet.Silverwood", new ResearchPage("tb.rec.bracelet.silverwood.page.0"));
        TCHelper.addResearchPage(
                "TB.Bracelet.Silverwood",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 4, missing))));
        TCHelper.clearPages("TB.Bracelet.Void");
        TCHelper.addResearchPage("TB.Bracelet.Void", new ResearchPage("tb.rec.bracelet.void.page.0"));
        TCHelper.addResearchPage(
                "TB.Bracelet.Void",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 11, missing))));
        TCHelper.clearPages("TB.Bracelet.Blaze");
        TCHelper.addResearchPage("TB.Bracelet.Blaze", new ResearchPage("tb.rec.bracelet.blaze.page.0"));
        TCHelper.addResearchPage(
                "TB.Bracelet.Blaze",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 8, missing))));
        TCHelper.clearPages("TB.Bracelet.Reed");
        TCHelper.addResearchPage("TB.Bracelet.Reed", new ResearchPage("tb.rec.bracelet.reed.page.0"));
        TCHelper.addResearchPage(
                "TB.Bracelet.Reed",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 5, missing))));
        TCHelper.clearPages("TB.Bracelet.Bone");
        TCHelper.addResearchPage("TB.Bracelet.Bone", new ResearchPage("tb.rec.bracelet.bone.page.0"));
        TCHelper.addResearchPage(
                "TB.Bracelet.Bone",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 6, missing))));
        TCHelper.clearPages("TB.Bracelet.Obsidian");
        TCHelper.addResearchPage("TB.Bracelet.Obsidian", new ResearchPage("tb.rec.bracelet.obsidian.page.0"));
        TCHelper.addResearchPage(
                "TB.Bracelet.Obsidian",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 7, missing))));
        TCHelper.clearPages("TB.Bracelet.Quartz");
        TCHelper.addResearchPage("TB.Bracelet.Quartz", new ResearchPage("tb.rec.bracelet.quartz.page.0"));
        TCHelper.addResearchPage(
                "TB.Bracelet.Quartz",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 10, missing))));
        TCHelper.clearPages("TB.Bracelet.Ice");
        TCHelper.addResearchPage("TB.Bracelet.Ice", new ResearchPage("tb.rec.bracelet.ice.page.0"));
        TCHelper.addResearchPage(
                "TB.Bracelet.Ice",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ThaumicBases.ID, "castingBracelet", 1, 9, missing))));
        TCHelper.refreshResearchPages("TB.NodeMan");
        TCHelper.refreshResearchPages("TB.NodeFoci.Bright");
        TCHelper.refreshResearchPages("TB.NodeFoci.Speed");
        TCHelper.refreshResearchPages("TB.NodeFoci.Unstable");
        TCHelper.refreshResearchPages("TB.NodeFoci.Efficiency");
        TCHelper.refreshResearchPages("TB.NodeFoci.Hunger");
        TCHelper.refreshResearchPages("TB.NodeFoci.Stability");
        TCHelper.refreshResearchPages("TB.NodeFoci.Purity");
        TCHelper.refreshResearchPages("TB.NodeFoci.Destr");
        TCHelper.refreshResearchPages("TB.NodeFoci.Sinister");
        TCHelper.refreshResearchPages("TB.NodeFoci.Taint");
        new ResearchItem(
                "TB.TaintFlask",
                "THAUMICBASES",
                new AspectList().add(Aspect.getAspect("vitium"), 10).add(Aspect.getAspect("alienis"), 15)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("permutatio"), 12),
                1,
                -1,
                3,
                getModItem(ThaumicBases.ID, "concentratedTaint", 1, 0, missing))
                        .setPages(
                                new ResearchPage("tb.rec.TB.TaintFlask.page.NH.0"),
                                new ResearchPage(
                                        TCHelper.findInfusionRecipe(
                                                getModItem(ThaumicBases.ID, "concentratedTaint", 1, 0, missing))))
                        .setParents("TB.INFUSION").setParentsHidden("BOTTLETAINT").registerResearchItem();
        ThaumcraftApi.addWarpToResearch("TB.TaintFlask", 5);
        ThaumcraftApi.addWarpToItem(getModItem(ThaumicBases.ID, "concentratedTaint", 1, 0, missing), 3);
        TCHelper.refreshResearchPages("ROD_tbvoid");
        ThaumcraftApi.addWarpToResearch("ROD_tbvoid", 4);
        TCHelper.refreshResearchPages("TB.EntityDec");
        TCHelper.clearPages("TB.NodeLinker");
        TCHelper.addResearchPage("TB.NodeLinker", new ResearchPage("tb.rec.nodeLink.page.0"));
        TCHelper.addResearchPage("TB.NodeLinker", new ResearchPage("tb.rec.nodeLink.page.1"));
        TCHelper.addResearchPage("TB.NodeLinker", new ResearchPage("tb.rec.nodeLink.page.2"));
        TCHelper.addResearchPage(
                "TB.NodeLinker",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ThaumicBases.ID, "nodeLinker", 1, 0, missing))));
        TCHelper.refreshResearchPages("TB.SM");
        TCHelper.refreshResearchPages("TB.Overchanter");
    }
}
