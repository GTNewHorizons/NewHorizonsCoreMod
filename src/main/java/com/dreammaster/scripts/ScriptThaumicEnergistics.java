package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AE2Stuff;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.Gadomancy;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.TaintedMagic;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicEnergistics;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.circuitAssemblerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.thaumcraft.TCHelper;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchPage;

public class ScriptThaumicEnergistics implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "ThaumicEnergistics";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                TaintedMagic.ID,
                Gadomancy.ID,
                ThaumicEnergistics.ID,
                EternalSingularity.ID,
                AppliedEnergistics2.ID,
                AE2Stuff.ID,
                TinkerConstruct.ID,
                BartWorks.ID,
                IndustrialCraft2.ID,
                Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {

        final ItemStack PrimalCharm = getModItem(Thaumcraft.ID, "ItemResource", 1, 15, missing);

        final ItemStack EssentialComponent1K = getModItem(ThaumicEnergistics.ID, "storage.component", 1, 0, missing);
        final ItemStack EssentialComponent4K = getModItem(ThaumicEnergistics.ID, "storage.component", 1, 1, missing);
        final ItemStack EssentialComponent16K = getModItem(ThaumicEnergistics.ID, "storage.component", 1, 2, missing);
        final ItemStack EssentialComponent64K = getModItem(ThaumicEnergistics.ID, "storage.component", 1, 3, missing);
        final ItemStack EssentialComponent256K = getModItem(ThaumicEnergistics.ID, "storage.component", 1, 5, missing);
        final ItemStack EssentialComponent1024K = getModItem(ThaumicEnergistics.ID, "storage.component", 1, 6, missing);
        final ItemStack EssentialComponent4096K = getModItem(ThaumicEnergistics.ID, "storage.component", 1, 7, missing);
        final ItemStack EssentialComponent16384K = getModItem(
                ThaumicEnergistics.ID,
                "storage.component",
                1,
                8,
                missing);

        final ItemStack EssentialCellCreative = getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 4, missing);

        final ItemStack DiffusionCore = getModItem(ThaumicEnergistics.ID, "material", 1, 0, missing);
        final ItemStack CoalescenceCore = getModItem(ThaumicEnergistics.ID, "material", 1, 1, missing);
        final ItemStack IronGear = getModItem(ThaumicEnergistics.ID, "material", 1, 2, missing);

        final ItemStack CraftingUnit = getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1, missing);
        final ItemStack LogicProcessor = getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing);
        final ItemStack CalcProcessor = getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23, missing);
        final ItemStack EngProcessor = getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing);

        final ItemStack InfusionIntercepter = getModItem("thaumicinsurgence", "infusionIntercepter", 1, 0);

        final ItemStack ZPMEmitter = ItemList.Emitter_ZPM.get(1);
        final ItemStack ZPMSensor = ItemList.Sensor_ZPM.get(1);

        final FluidStack[] solders = new FluidStack[] { Materials.Lead.getMolten(288), Materials.Tin.getMolten(144),
                Materials.SolderingAlloy.getMolten(72) };

        // Creates ItemStack for CEC craft input
        ItemStack[] CECInfusionItems = { ItemList.Field_Generator_UIV.get(1),
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1),
                getModItem(Gadomancy.ID, "BlockNodeManipulator", 1, 5),
                getModItem(Gadomancy.ID, "BlockEssentiaCompressor", 1), ItemList.Field_Generator_UIV.get(1),
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1),
                getModItem(Gadomancy.ID, "BlockNodeManipulator", 1, 5),
                getModItem(Gadomancy.ID, "BlockEssentiaCompressor", 1), ItemList.Field_Generator_UIV.get(1),
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1),
                getModItem(Gadomancy.ID, "BlockNodeManipulator", 1, 5),
                getModItem(Gadomancy.ID, "BlockEssentiaCompressor", 1), ItemList.Field_Generator_UIV.get(1),
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1),
                getModItem(Gadomancy.ID, "BlockNodeManipulator", 1, 5),
                getModItem(Gadomancy.ID, "BlockEssentiaCompressor", 1) };

        // ItemStacks for in/out
        ItemStack DigitalSingularity = getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 10);
        // Creative Essentia Cell
        ItemStack CEC = EssentialCellCreative;

        ThaumcraftApi.addInfusionCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                CEC,
                10,
                new AspectList().add(Aspect.AIR, 2000).add(Aspect.FIRE, 2000).add(Aspect.ORDER, 2000)
                        .add(Aspect.ENTROPY, 2000).add(Aspect.EARTH, 2000).add(Aspect.WATER, 2000),
                DigitalSingularity,
                CECInfusionItems);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ToolWirelessTerminal", 1, wildcard, missing),
                        getModItem(ThaumicEnergistics.ID, "part.base", 1, 4, missing))
                .itemOutputs(getModItem(ThaumicEnergistics.ID, "wireless.essentia.terminal", 1, 0, missing))
                .duration(30 * SECONDS).eut(120).addTo(assemblerRecipes);

        for (FluidStack solder : solders) {
            // 1k Essentia Storage Component
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 2),
                            getModItem(Thaumcraft.ID, "ItemResource", 2, 14, missing),
                            CustomItemList.EngineeringProcessorEssentiaPulsatingCore.get(1L),
                            ItemList.Circuit_Board_Coated.get(1L),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(EssentialComponent1K).fluidInputs(solder).duration(10 * SECONDS).eut(30)
                    .addTo(circuitAssemblerRecipes);
            // 4k Essentia Storage Component
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 16),
                            CustomItemList.EngineeringProcessorEssentiaPulsatingCore.get(1L),
                            ItemList.Circuit_Board_Coated_Basic.get(1L),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(EssentialComponent4K).fluidInputs(solder).duration(10 * SECONDS).eut(30)
                    .addTo(circuitAssemblerRecipes);
            // 16k Essentia Storage Component
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 16),
                            CustomItemList.EngineeringProcessorEssentiaPulsatingCore.get(1L),
                            ItemList.Circuit_Board_Phenolic_Good.get(1L),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(EssentialComponent16K).fluidInputs(solder).duration(10 * SECONDS).eut(120)
                    .addTo(circuitAssemblerRecipes);
            // 64k Essentia Storage Component
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 16),
                            CustomItemList.EngineeringProcessorEssentiaPulsatingCore.get(1L),
                            ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(EssentialComponent64K).fluidInputs(solder).duration(10 * SECONDS).eut(480)
                    .addTo(circuitAssemblerRecipes);
            // 256k Essentia Storage Component
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 16),
                            CustomItemList.EngineeringProcessorEssentiaPulsatingCore.get(1L),
                            ItemList.Circuit_Board_Fiberglass_Advanced.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(EssentialComponent256K).fluidInputs(solder).requiresCleanRoom().duration(10 * SECONDS)
                    .eut(1920).addTo(circuitAssemblerRecipes);
            // 1024k Essentia Storage Component
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 16),
                            CustomItemList.EngineeringProcessorEssentiaPulsatingCore.get(1L),
                            ItemList.Circuit_Board_Multifiberglass_Elite.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(EssentialComponent1024K).fluidInputs(solder).requiresCleanRoom().duration(10 * SECONDS)
                    .eut(7680).addTo(circuitAssemblerRecipes);
            // 4096k Essentia Storage Component
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 16),
                            CustomItemList.EngineeringProcessorEssentiaPulsatingCore.get(1L),
                            ItemList.Circuit_Board_Wetware_Extreme.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(EssentialComponent4096K).fluidInputs(solder).requiresCleanRoom().duration(10 * SECONDS)
                    .eut(30720).addTo(circuitAssemblerRecipes);
            // 16384k Essentia Storage Component
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 4),
                            GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 16),
                            CustomItemList.EngineeringProcessorEssentiaPulsatingCore.get(1L),
                            ItemList.Circuit_Board_Bio_Ultra.get(1),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(EssentialComponent16384K).fluidInputs(solder).requiresCleanRoom()
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_UV).addTo(circuitAssemblerRecipes);
        }

        TCHelper.removeInfusionRecipe(
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.essentia.provider", 1, 0, missing));
        TCHelper.removeArcaneRecipe(IronGear);
        TCHelper.removeArcaneRecipe(
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.gear.box", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicEnergistics.ID, "part.base", 1, 5, missing));
        TCHelper.removeArcaneRecipe(DiffusionCore);
        TCHelper.removeArcaneRecipe(CoalescenceCore);
        TCHelper.removeArcaneRecipe(getModItem(ThaumicEnergistics.ID, "part.base", 1, 4, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicEnergistics.ID, "part.base", 4, 1, missing));
        TCHelper.removeArcaneRecipe(
                getModItem(
                        ThaumicEnergistics.ID,
                        "thaumicenergistics.block.essentia.vibration.chamber",
                        1,
                        0,
                        missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicEnergistics.ID, "part.base", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicEnergistics.ID, "part.base", 1, 3, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicEnergistics.ID, "part.base", 1, 2, missing));
        TCHelper.removeArcaneRecipe(
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.distillation.encoder", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicEnergistics.ID, "focus.aewrench", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicEnergistics.ID, "golem.wifi.backpack", 1, 0, missing));
        TCHelper.removeArcaneRecipe(EssentialComponent1K);
        TCHelper.removeArcaneRecipe(EssentialComponent4K);
        TCHelper.removeArcaneRecipe(EssentialComponent16K);
        TCHelper.removeArcaneRecipe(EssentialComponent64K);
        TCHelper.removeArcaneRecipe(EssentialComponent256K);
        TCHelper.removeArcaneRecipe(EssentialComponent1024K);
        TCHelper.removeArcaneRecipe(EssentialComponent4096K);
        TCHelper.removeArcaneRecipe(EssentialComponent16384K);

        TCHelper.removeArcaneRecipe(getModItem(ThaumicEnergistics.ID, "part.base", 1, 6, missing));
        TCHelper.removeCrucibleRecipe(
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.golem.gear.box", 1, 0, missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(
                        ThaumicEnergistics.ID,
                        "thaumicenergistics.block.arcane.assembler",
                        1,
                        0,
                        "{stored_vis:[0:{amount:1500,key:\"aer\"},1:{amount:1500,key:\"aqua\"},2:{amount:1500,key:\"ignis\"},3:{amount:1500,key:\"ordo\"},4:{amount:1500,key:\"perditio\"},5:{amount:1500,key:\"terra\"}]}",
                        missing));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicEnergistics.ID, "knowledge.core", 1, 0, missing));
        TCHelper.removeArcaneRecipe(
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.knowledge.inscriber", 1, 0, missing));
        TCHelper.removeInfusionRecipe(
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.infusion.provider", 1, 0, missing));
        TCHelper.removeInfusionRecipe(
                getModItem(
                        ThaumicEnergistics.ID,
                        "thaumicenergistics.block.advanced.infusion.provider",
                        1,
                        0,
                        missing));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "thaumicenergistics.TEESSPROV",
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.essentia.provider", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("machina"), 64).add(Aspect.getAspect("praecantatio"), 48)
                        .add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("permutatio"), 24)
                        .add(Aspect.getAspect("aqua"), 16).add(Aspect.getAspect("cognitio"), 8)
                        .add(Aspect.getAspect("lucrum"), 4),
                getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "blockTube", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L), DiffusionCore,
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(Thaumcraft.ID, "blockTube", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing), CoalescenceCore,
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing), });
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEESSPROV",
                new AspectList().add(Aspect.getAspect("sensus"), 21).add(Aspect.getAspect("praecantatio"), 18)
                        .add(Aspect.getAspect("lucrum"), 15).add(Aspect.getAspect("metallum"), 12)
                        .add(Aspect.getAspect("ordo"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("machina"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEESSPROV", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEIRONGEARBOX",
                IronGear,
                new AspectList().add(Aspect.getAspect("terra"), 10).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "stickIron",
                'b',
                "plateIron",
                'c',
                "stickIron",
                'd',
                "plateIron",
                'e',
                "gearWood",
                'f',
                "plateIron",
                'g',
                "stickIron",
                'h',
                "plateIron",
                'i',
                "stickIron");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEIRONGEARBOX",
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.gear.box", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("ordo"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6, missing),
                'b',
                "gearIron",
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6, missing),
                'd',
                "gearIron",
                'e',
                ItemList.Electric_Motor_MV.get(1L),
                'f',
                "gearIron",
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6, missing),
                'h',
                "gearIron",
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6, missing));
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEIRONGEARBOX",
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("metallum"), 15)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("permutatio"), 6));
        TCHelper.setResearchComplexity("thaumicenergistics.TEIRONGEARBOX", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEARCANETERM",
                getModItem(ThaumicEnergistics.ID, "part.base", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 25).add(Aspect.getAspect("ignis"), 25)
                        .add(Aspect.getAspect("aer"), 25).add(Aspect.getAspect("terra"), 25)
                        .add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("perditio"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedEarth, 1L),
                'b',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 360, missing),
                'c',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedEarth, 1L),
                'd',
                EngProcessor,
                'e',
                getModItem(Thaumcraft.ID, "blockTable", 1, 15, missing),
                'f',
                CalcProcessor,
                'g',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedEarth, 1L),
                'h',
                LogicProcessor,
                'i',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedEarth, 1L));
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEARCANETERM",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("machina"), 6)
                        .add(Aspect.getAspect("vacuos"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEARCANETERM", 3);
        TCHelper.setResearchAspects(
                "thaumicenergistics.TECERTUSDUPE",
                new AspectList().add(Aspect.getAspect("vitreus"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TECERTUSDUPE", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TECORES",
                DiffusionCore,
                new AspectList().add(Aspect.getAspect("aqua"), 20).add(Aspect.getAspect("perditio"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3, missing),
                'b',
                "gemAmber",
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3, missing),
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5, missing),
                'e',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44, missing),
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5, missing),
                'g',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3, missing),
                'h',
                "gemAmber",
                'i',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TECORES",
                CoalescenceCore,
                new AspectList().add(Aspect.getAspect("aqua"), 20).add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3, missing),
                'b',
                "gemAmber",
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3, missing),
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4, missing),
                'e',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43, missing),
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4, missing),
                'g',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3, missing),
                'h',
                "gemAmber",
                'i',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3, missing));
        TCHelper.setResearchAspects(
                "thaumicenergistics.TECORES",
                new AspectList().add(Aspect.getAspect("cognitio"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("machina"), 6).add(Aspect.getAspect("limus"), 9)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TECORES", 3);
        TCHelper.clearPages("thaumicenergistics.TEESSTERM");
        TCHelper.addResearchPage(
                "thaumicenergistics.TEESSTERM",
                new ResearchPage("thaumicenergistics.research_page.TEESSTERM.1"));
        TCHelper.addResearchPage(
                "thaumicenergistics.TEESSTERM",
                new ResearchPage("thaumicenergistics.research_page.TEESSTERM.2"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEESSTERM",
                getModItem(ThaumicEnergistics.ID, "part.base", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 25).add(Aspect.getAspect("ordo"), 25)
                        .add(Aspect.getAspect("ignis"), 25).add(Aspect.getAspect("terra"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                CalcProcessor,
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8, missing),
                'c',
                LogicProcessor,
                'd',
                DiffusionCore,
                'e',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 380, missing),
                'f',
                CoalescenceCore,
                'g',
                "plateInfusedWater",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 8, missing),
                'i',
                "plateInfusedWater");
        TCHelper.addResearchPage(
                "thaumicenergistics.TEESSTERM",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ThaumicEnergistics.ID, "part.base", 1, 4, missing))));
        TCHelper.addResearchPage(
                "thaumicenergistics.TEESSTERM",
                new ResearchPage("thaumicenergistics.research_page.TEESSTERM.3"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEESSTERM",
                getModItem(ThaumicEnergistics.ID, "part.base", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("ignis"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'b',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 280, missing),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3, missing));
        TCHelper.addResearchPage(
                "thaumicenergistics.TEESSTERM",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ThaumicEnergistics.ID, "part.base", 1, 1, missing))));
        TCHelper.addResearchPage(
                "thaumicenergistics.TEESSTERM",
                new ResearchPage("thaumicenergistics.research_page.TEESSTERM.4"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEESSTERM",
                getModItem(ThaumicEnergistics.ID, "part.base", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("ordo"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolScrewdriver",
                'b',
                "itemIlluminatedPanel",
                'c',
                "craftingToolHardHammer",
                'd',
                "screwInfusedWater",
                'e',
                getModItem(ThaumicEnergistics.ID, "part.base", 1, 1, missing),
                'f',
                "screwInfusedWater",
                'g',
                "plateInfusedOrder",
                'h',
                "plateInfusedOrder",
                'i',
                "plateInfusedOrder");
        TCHelper.addResearchPage(
                "thaumicenergistics.TEESSTERM",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ThaumicEnergistics.ID, "part.base", 1, 7, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEESSTERM",
                getModItem(ThaumicEnergistics.ID, "part.base", 1, 8, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolScrewdriver",
                'b',
                getModItem(ThaumicEnergistics.ID, "part.base", 1, 7, missing),
                'c',
                "craftingToolHardHammer",
                'd',
                "screwInfusedFire",
                'e',
                DiffusionCore,
                'f',
                "screwInfusedFire",
                'g',
                "plateInfusedOrder",
                'h',
                CoalescenceCore,
                'i',
                "plateInfusedOrder");
        TCHelper.addResearchPage(
                "thaumicenergistics.TEESSTERM",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ThaumicEnergistics.ID, "part.base", 1, 8, missing))));
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEESSTERM",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("sensus"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("aqua"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEESSTERM", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEESSVIBCMBR",
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.essentia.vibration.chamber", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 35).add(Aspect.getAspect("ordo"), 35)
                        .add(Aspect.getAspect("perditio"), 35).add(Aspect.getAspect("aqua"), 35),
                "abc",
                "def",
                "ghi",
                'a',
                "plateInfusedOrder",
                'b',
                getModItem(ThaumicEnergistics.ID, "part.base", 1, 4, missing),
                'c',
                "plateInfusedOrder",
                'd',
                DiffusionCore,
                'e',
                getModItem(AppliedEnergistics2.ID, "tile.BlockVibrationChamber", 1, 0, missing),
                'f',
                DiffusionCore,
                'g',
                "plateInfusedEntropy",
                'h',
                getModItem(Thaumcraft.ID, "blockJar", 1, 0, missing),
                'i',
                "plateInfusedEntropy");
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEESSVIBCMBR",
                new AspectList().add(Aspect.getAspect("vitreus"), 18).add(Aspect.getAspect("machina"), 15)
                        .add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("aqua"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEESSVIBCMBR", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEIO",
                getModItem(ThaumicEnergistics.ID, "part.base", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("terra"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'b',
                DiffusionCore,
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'd',
                "plateInfusedOrder",
                'e',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 240, missing),
                'f',
                "plateInfusedOrder",
                'g',
                getModItem(Thaumcraft.ID, "blockJar", 1, 0, missing),
                'h',
                getModItem(Thaumcraft.ID, "blockTube", 1, 3, missing),
                'i',
                getModItem(Thaumcraft.ID, "blockJar", 1, 0, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEIO",
                getModItem(ThaumicEnergistics.ID, "part.base", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("terra"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockJar", 1, 0, missing),
                'b',
                getModItem(Thaumcraft.ID, "blockTube", 1, 3, missing),
                'c',
                getModItem(Thaumcraft.ID, "blockJar", 1, 0, missing),
                'd',
                "plateInfusedOrder",
                'e',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 260, missing),
                'f',
                "plateInfusedOrder",
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'h',
                CoalescenceCore,
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEIO",
                getModItem(ThaumicEnergistics.ID, "part.base", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("aqua"), 20)
                        .add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("terra"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockJar", 1, 0, missing),
                'b',
                "plateInfusedWater",
                'c',
                getModItem(Thaumcraft.ID, "blockJar", 1, 0, missing),
                'd',
                DiffusionCore,
                'e',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 220, missing),
                'f',
                CoalescenceCore,
                'g',
                getModItem(Thaumcraft.ID, "blockTube", 1, 3, missing),
                'h',
                "plateInfusedWater",
                'i',
                getModItem(Thaumcraft.ID, "blockTube", 1, 3, missing));
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEIO",
                new AspectList().add(Aspect.getAspect("motus"), 18).add(Aspect.getAspect("machina"), 15)
                        .add(Aspect.getAspect("metallum"), 12).add(Aspect.getAspect("vitreus"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("aqua"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEIO", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEDISTILLATIONPATTERNENCODER",
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.distillation.encoder", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("perditio"), 25)
                        .add(Aspect.getAspect("ignis"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                "plateInfusedFire",
                'b',
                getModItem(Thaumcraft.ID, "ItemThaumometer", 1, 0, missing),
                'c',
                "plateInfusedFire",
                'd',
                LogicProcessor,
                'e',
                getModItem(AE2Stuff.ID, "Encoder", 1, 0, missing),
                'f',
                LogicProcessor,
                'g',
                "plateInfusedOrder",
                'h',
                EngProcessor,
                'i',
                "plateInfusedOrder");
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEDISTILLATIONPATTERNENCODER",
                new AspectList().add(Aspect.getAspect("ordo"), 21).add(Aspect.getAspect("fabrico"), 18)
                        .add(Aspect.getAspect("permutatio"), 15).add(Aspect.getAspect("perditio"), 12)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEDISTILLATIONPATTERNENCODER", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEFOCUSWRENCH",
                getModItem(ThaumicEnergistics.ID, "focus.aewrench", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("aer"), 25)
                        .add(Aspect.getAspect("ignis"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing),
                'b',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 10, missing),
                'c',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1, missing),
                'd',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 11, missing),
                'e',
                getModItem(AppliedEnergistics2.ID, "item.ToolCertusQuartzWrench", 1, 0, missing),
                'f',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 11, missing),
                'g',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1, missing),
                'h',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 10, missing),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing));
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEFOCUSWRENCH",
                new AspectList().add(Aspect.getAspect("ignis"), 18).add(Aspect.getAspect("aer"), 15)
                        .add(Aspect.getAspect("machina"), 12).add(Aspect.getAspect("instrumentum"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("metallum"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEFOCUSWRENCH", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEGOLEMWIFIBACKPACK",
                getModItem(ThaumicEnergistics.ID, "golem.wifi.backpack", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("aer"), 30)
                        .add(Aspect.getAspect("ignis"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440, missing),
                'c',
                "plateThaumium",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                'e',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41, missing),
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                'g',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9, missing),
                'h',
                getModItem(AppliedEnergistics2.ID, "tile.BlockCharger", 1, 0, missing),
                'i',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9, missing));
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEGOLEMWIFIBACKPACK",
                new AspectList().add(Aspect.getAspect("vacuos"), 21).add(Aspect.getAspect("potentia"), 18)
                        .add(Aspect.getAspect("auram"), 15).add(Aspect.getAspect("cognitio"), 12)
                        .add(Aspect.getAspect("tutamen"), 9).add(Aspect.getAspect("motus"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEGOLEMWIFIBACKPACK", 3);
        TCHelper.clearPages("thaumicenergistics.TESTORAGE");
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage("thaumicenergistics.research_page.TESTORAGE.1"));
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage("thaumicenergistics.research_page.TESTORAGE.2"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                EssentialComponent1K,
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("ignis"), 10)
                        .add(Aspect.getAspect("aqua"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "circuitPrimitive",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'c',
                "circuitPrimitive",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'e',
                CustomItemList.EngineeringProcessorEssentiaPulsatingCore.get(1L),
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'g',
                "circuitPrimitive",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'i',
                "circuitPrimitive");
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(TCHelper.findArcaneRecipe(EssentialComponent1K)));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                EssentialComponent4K,
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("aqua"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "circuitBasic",
                'b',
                EssentialComponent1K,
                'c',
                "circuitBasic",
                'd',
                EssentialComponent1K,
                'e',
                CustomItemList.EngineeringProcessorEssentiaPulsatingCore.get(1L),
                'f',
                EssentialComponent1K,
                'g',
                "circuitBasic",
                'h',
                EssentialComponent1K,
                'i',
                "circuitBasic");
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(TCHelper.findArcaneRecipe(EssentialComponent4K)));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                EssentialComponent16K,
                new AspectList().add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("aqua"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                "circuitGood",
                'b',
                EssentialComponent4K,
                'c',
                "circuitGood",
                'd',
                EssentialComponent4K,
                'e',
                CustomItemList.EngineeringProcessorEssentiaPulsatingCore.get(1L),
                'f',
                EssentialComponent4K,
                'g',
                "circuitGood",
                'h',
                EssentialComponent4K,
                'i',
                "circuitGood");
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(TCHelper.findArcaneRecipe(EssentialComponent16K)));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                EssentialComponent64K,
                new AspectList().add(Aspect.getAspect("ordo"), 40).add(Aspect.getAspect("ignis"), 40)
                        .add(Aspect.getAspect("aqua"), 40),
                "abc",
                "def",
                "ghi",
                'a',
                "circuitAdvanced",
                'b',
                EssentialComponent16K,
                'c',
                "circuitAdvanced",
                'd',
                EssentialComponent16K,
                'e',
                CustomItemList.EngineeringProcessorEssentiaPulsatingCore.get(1L),
                'f',
                EssentialComponent16K,
                'g',
                "circuitAdvanced",
                'h',
                EssentialComponent16K,
                'i',
                "circuitAdvanced");
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(TCHelper.findArcaneRecipe(EssentialComponent64K)));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                EssentialComponent256K,
                new AspectList().add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("ignis"), 50)
                        .add(Aspect.getAspect("aqua"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                "circuitData",
                'b',
                EssentialComponent64K,
                'c',
                "circuitData",
                'd',
                EssentialComponent64K,
                'e',
                CustomItemList.EngineeringProcessorEssentiaPulsatingCore.get(1L),
                'f',
                EssentialComponent64K,
                'g',
                "circuitData",
                'h',
                EssentialComponent64K,
                'i',
                "circuitData");
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(TCHelper.findArcaneRecipe(EssentialComponent256K)));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                EssentialComponent1024K,
                new AspectList().add(Aspect.getAspect("ordo"), 60).add(Aspect.getAspect("ignis"), 60)
                        .add(Aspect.getAspect("aqua"), 60),
                "abc",
                "def",
                "ghi",
                'a',
                "circuitElite",
                'b',
                EssentialComponent256K,
                'c',
                "circuitElite",
                'd',
                EssentialComponent256K,
                'e',
                CustomItemList.EngineeringProcessorEssentiaPulsatingCore.get(1L),
                'f',
                EssentialComponent256K,
                'g',
                "circuitElite",
                'h',
                EssentialComponent256K,
                'i',
                "circuitElite");
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(TCHelper.findArcaneRecipe(EssentialComponent1024K)));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                EssentialComponent4096K,
                new AspectList().add(Aspect.getAspect("ordo"), 70).add(Aspect.getAspect("ignis"), 70)
                        .add(Aspect.getAspect("aqua"), 70),
                "abc",
                "def",
                "ghi",
                'a',
                "circuitMaster",
                'b',
                EssentialComponent1024K,
                'c',
                "circuitMaster",
                'd',
                EssentialComponent1024K,
                'e',
                CustomItemList.EngineeringProcessorEssentiaPulsatingCore.get(1L),
                'f',
                EssentialComponent1024K,
                'g',
                "circuitMaster",
                'h',
                EssentialComponent1024K,
                'i',
                "circuitMaster");
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(TCHelper.findArcaneRecipe(EssentialComponent4096K)));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                EssentialComponent16384K,
                new AspectList().add(Aspect.getAspect("ordo"), 80).add(Aspect.getAspect("ignis"), 80)
                        .add(Aspect.getAspect("aqua"), 80),
                "abc",
                "def",
                "ghi",
                'a',
                "circuitSuperconductor",
                'b',
                EssentialComponent4096K,
                'c',
                "circuitSuperconductor",
                'd',
                EssentialComponent4096K,
                'e',
                CustomItemList.EngineeringProcessorEssentiaPulsatingCore.get(1L),
                'f',
                EssentialComponent4096K,
                'g',
                "circuitSuperconductor",
                'h',
                EssentialComponent4096K,
                'i',
                "circuitSuperconductor");
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(TCHelper.findArcaneRecipe(EssentialComponent16384K)));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem(ThaumicEnergistics.ID, "storage.casing", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("aqua"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'b',
                "plateInfusedFire",
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'd',
                "plateInfusedEarth",
                'e',
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                'f',
                "plateInfusedEarth",
                'g',
                "plateThaumium",
                'h',
                "plateThaumium",
                'i',
                "plateThaumium");
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ThaumicEnergistics.ID, "storage.casing", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("aqua"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'b',
                "plateInfusedFire",
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'd',
                "plateInfusedEarth",
                'e',
                EssentialComponent1K,
                'f',
                "plateInfusedEarth",
                'g',
                "plateThaumium",
                'h',
                "plateThaumium",
                'i',
                "plateThaumium");
        ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("terra"), 5)
                        .add(Aspect.getAspect("aqua"), 5),
                getModItem(ThaumicEnergistics.ID, "storage.casing", 1, 0, missing),
                EssentialComponent1K);
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("terra"), 25)
                        .add(Aspect.getAspect("aqua"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'b',
                "plateInfusedFire",
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'd',
                "plateInfusedEarth",
                'e',
                EssentialComponent4K,
                'f',
                "plateInfusedEarth",
                'g',
                "plateThaumium",
                'h',
                "plateThaumium",
                'i',
                "plateThaumium");
        ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("aqua"), 15),
                getModItem(ThaumicEnergistics.ID, "storage.casing", 1, 0, missing),
                EssentialComponent4K);
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 1, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 35).add(Aspect.getAspect("terra"), 35)
                        .add(Aspect.getAspect("aqua"), 35),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'b',
                "plateInfusedFire",
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'd',
                "plateInfusedEarth",
                'e',
                EssentialComponent16K,
                'f',
                "plateInfusedEarth",
                'g',
                "plateThaumium",
                'h',
                "plateThaumium",
                'i',
                "plateThaumium");
        ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("terra"), 25)
                        .add(Aspect.getAspect("aqua"), 25),
                getModItem(ThaumicEnergistics.ID, "storage.casing", 1, 0, missing),
                EssentialComponent16K);
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 2, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 45).add(Aspect.getAspect("terra"), 45)
                        .add(Aspect.getAspect("aqua"), 45),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'b',
                "plateInfusedFire",
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'd',
                "plateInfusedEarth",
                'e',
                EssentialComponent64K,
                'f',
                "plateInfusedEarth",
                'g',
                "plateThaumium",
                'h',
                "plateThaumium",
                'i',
                "plateThaumium");
        ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 35).add(Aspect.getAspect("terra"), 35)
                        .add(Aspect.getAspect("aqua"), 35),
                getModItem(ThaumicEnergistics.ID, "storage.casing", 1, 0, missing),
                EssentialComponent64K);
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 3, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 55).add(Aspect.getAspect("terra"), 55)
                        .add(Aspect.getAspect("aqua"), 55),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'b',
                "plateInfusedFire",
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'd',
                "plateInfusedEarth",
                'e',
                EssentialComponent256K,
                'f',
                "plateInfusedEarth",
                'g',
                "plateThaumium",
                'h',
                "plateThaumium",
                'i',
                "plateThaumium");
        ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 45).add(Aspect.getAspect("terra"), 45)
                        .add(Aspect.getAspect("aqua"), 45),
                getModItem(ThaumicEnergistics.ID, "storage.casing", 1, 0, missing),
                EssentialComponent256K);
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 5, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 65).add(Aspect.getAspect("terra"), 65)
                        .add(Aspect.getAspect("aqua"), 65),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'b',
                "plateInfusedFire",
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'd',
                "plateInfusedEarth",
                'e',
                EssentialComponent1024K,
                'f',
                "plateInfusedEarth",
                'g',
                "plateThaumium",
                'h',
                "plateThaumium",
                'i',
                "plateThaumium");
        ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 55).add(Aspect.getAspect("terra"), 55)
                        .add(Aspect.getAspect("aqua"), 55),
                getModItem(ThaumicEnergistics.ID, "storage.casing", 1, 0, missing),
                EssentialComponent1024K);
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 6, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("aqua"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'b',
                "plateInfusedFire",
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'd',
                "plateInfusedEarth",
                'e',
                EssentialComponent4096K,
                'f',
                "plateInfusedEarth",
                'g',
                "plateThaumium",
                'h',
                "plateThaumium",
                'i',
                "plateThaumium");
        ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 65).add(Aspect.getAspect("terra"), 65)
                        .add(Aspect.getAspect("aqua"), 65),
                getModItem(ThaumicEnergistics.ID, "storage.casing", 1, 0, missing),
                EssentialComponent4096K);
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 7, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 8, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 85).add(Aspect.getAspect("terra"), 85)
                        .add(Aspect.getAspect("aqua"), 85),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'b',
                "plateInfusedFire",
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'd',
                "plateInfusedEarth",
                'e',
                EssentialComponent16384K,
                'f',
                "plateInfusedEarth",
                'g',
                "plateThaumium",
                'h',
                "plateThaumium",
                'i',
                "plateThaumium");
        ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 8, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("aqua"), 75),
                getModItem(ThaumicEnergistics.ID, "storage.casing", 1, 0, missing),
                EssentialComponent16384K);
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 8, missing))));

        // Fluid Quantum Drive
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 9, missing),
                "---------",
                "----a----",
                "---bdb---",
                "--bcdcb--",
                "-addedda-",
                "--bcdcb--",
                "---bdb---",
                "----a----",
                "---------",
                'a',
                "blockCosmicNeutronium",
                'b',
                "plateDenseNeutronium",
                'c',
                "circuitInfinite",
                'd',
                EssentialComponent16384K,
                'e',
                getModItem(ThaumicEnergistics.ID, "storage.casing", 1, 0, missing));

        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.essentia.cell.workbench", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("ignis"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolScrewdriver",
                'b',
                EssentialComponent1K,
                'c',
                "craftingToolWrench",
                'd',
                "screwInfusedEarth",
                'e',
                getModItem(AppliedEnergistics2.ID, "tile.BlockCellWorkbench", 1, 0, missing),
                'f',
                "screwInfusedEarth",
                'g',
                "plateInfusedOrder",
                'h',
                LogicProcessor,
                'i',
                "plateInfusedOrder");
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(
                                        ThaumicEnergistics.ID,
                                        "thaumicenergistics.block.essentia.cell.workbench",
                                        1,
                                        0,
                                        missing))));
        TCHelper.setResearchAspects(
                "thaumicenergistics.TESTORAGE",
                new AspectList().add(Aspect.getAspect("vacuos"), 21).add(Aspect.getAspect("potentia"), 18)
                        .add(Aspect.getAspect("vitreus"), 15).add(Aspect.getAspect("metallum"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("aqua"), 6)
                        .add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TESTORAGE", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEVISINT",
                getModItem(ThaumicEnergistics.ID, "part.base", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("aqua"), 20)
                        .add(Aspect.getAspect("perditio"), 20).add(Aspect.getAspect("aer"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6, missing),
                'b',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 440, missing),
                'c',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6, missing),
                'd',
                "screwInfusedEarth",
                'e',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 460, missing),
                'f',
                "screwInfusedEarth",
                'g',
                "plateInfusedOrder",
                'h',
                "plateInfusedOrder",
                'i',
                "plateInfusedOrder");
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEVISINT",
                new AspectList().add(Aspect.getAspect("vacuos"), 21).add(Aspect.getAspect("potentia"), 18)
                        .add(Aspect.getAspect("auram"), 15).add(Aspect.getAspect("metallum"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("machina"), 6)
                        .add(Aspect.getAspect("aqua"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEVISINT", 3);
        ThaumcraftApi.addCrucibleRecipe(
                "thaumicenergistics.TETHAUMGBOX",
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.golem.gear.box", 1, 0, missing),
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.gear.box", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 32).add(Aspect.getAspect("praecantatio"), 32));
        TCHelper.setResearchAspects(
                "thaumicenergistics.TETHAUMGBOX",
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("machina"), 12)
                        .add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TETHAUMGBOX", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "thaumicenergistics.TEARCANEASSEMBLER",
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.arcane.assembler", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("auram"), 16).add(Aspect.getAspect("fabrico"), 64)
                        .add(Aspect.getAspect("metallum"), 8).add(Aspect.getAspect("permutatio"), 32)
                        .add(Aspect.getAspect("lucrum"), 16).add(Aspect.getAspect("praecantatio"), 48)
                        .add(Aspect.getAspect("vitreus"), 16),
                getModItem(AppliedEnergistics2.ID, "tile.BlockMolecularAssembler", 1, 0, missing),
                new ItemStack[] { createItemStack(
                        Thaumcraft.ID,
                        "WandCasting",
                        1,
                        wildcard,
                        "{aqua:15000,ignis:15000,terra:15000,cap:\"thaumium\",rod:\"silverwood\",ordo:15000,sceptre:1b,perditio:15000,aer:15000}",
                        missing), getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 4, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 5, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 6, missing), });
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEARCANEASSEMBLER",
                new AspectList().add(Aspect.getAspect("lucrum"), 24).add(Aspect.getAspect("fabrico"), 21)
                        .add(Aspect.getAspect("machina"), 18).add(Aspect.getAspect("cognitio"), 15)
                        .add(Aspect.getAspect("permutatio"), 12).add(Aspect.getAspect("auram"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("aqua"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEARCANEASSEMBLER", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEKNOWLEDGEINSCRIBER",
                getModItem(ThaumicEnergistics.ID, "knowledge.core", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("aqua"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "plateInfusedOrder",
                'b',
                "plateInfusedWater",
                'c',
                "plateInfusedOrder",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 9, missing),
                'e',
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0, missing),
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 9, missing),
                'g',
                "plateInfusedOrder",
                'h',
                CalcProcessor,
                'i',
                "plateInfusedOrder");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEKNOWLEDGEINSCRIBER",
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.knowledge.inscriber", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("aqua"), 20)
                        .add(Aspect.getAspect("perditio"), 20).add(Aspect.getAspect("aer"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 400, missing),
                'c',
                "plateThaumium",
                'd',
                "plateInfusedEntropy",
                'e',
                getModItem(ThaumicEnergistics.ID, "knowledge.core", 1, 0, missing),
                'f',
                "plateInfusedEntropy",
                'g',
                "plateThaumium",
                'h',
                getModItem(Thaumcraft.ID, "ItemThaumonomicon", 1, 0, missing),
                'i',
                "plateThaumium");
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEKNOWLEDGEINSCRIBER",
                new AspectList().add(Aspect.getAspect("cognitio"), 18).add(Aspect.getAspect("machina"), 15)
                        .add(Aspect.getAspect("fabrico"), 12).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEKNOWLEDGEINSCRIBER", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "thaumicenergistics.TEINFPROV",
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.infusion.provider", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("machina"), 64).add(Aspect.getAspect("ordo"), 48)
                        .add(Aspect.getAspect("permutatio"), 32).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("alienis"), 24).add(Aspect.getAspect("spiritus"), 8),
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.essentia.provider", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "blockMirror", 1, 6, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing),
                        getModItem(ThaumicEnergistics.ID, "part.base", 1, 0, missing), DiffusionCore,
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(Thaumcraft.ID, "blockMirror", 1, 6, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing), CoalescenceCore,
                        getModItem(ThaumicEnergistics.ID, "part.base", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEINFPROV",
                new AspectList().add(Aspect.getAspect("permutatio"), 21).add(Aspect.getAspect("motus"), 18)
                        .add(Aspect.getAspect("sensus"), 15).add(Aspect.getAspect("machina"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("spiritus"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEINFPROV", 3);

        ThaumcraftApi.addInfusionCraftingRecipe(
                "thaumicenergistics.TEADVINFPROV",
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.advanced.infusion.provider", 1, 0, missing),
                30,
                new AspectList().add(Aspect.MECHANISM, 64).add(Aspect.MAGIC, 64).add(Aspect.EXCHANGE, 64)
                        .add(Aspect.MIND, 64).add(Aspect.GREED, 64),
                getModItem(ThaumicEnergistics.ID, "thaumicenergistics.block.infusion.provider", 1, 0, missing),
                new ItemStack[] { InfusionIntercepter, PrimalCharm, DiffusionCore, ZPMEmitter, DiffusionCore,
                        PrimalCharm, CraftingUnit, PrimalCharm, EngProcessor, ZPMSensor, EngProcessor, PrimalCharm });

        TCHelper.refreshResearchPages("thaumicenergistics.TEESSPROV");
        TCHelper.refreshResearchPages("thaumicenergistics.TEIRONGEARBOX");
        TCHelper.refreshResearchPages("thaumicenergistics.TEARCANETERM");
        TCHelper.refreshResearchPages("thaumicenergistics.TECERTUSDUPE");
        TCHelper.refreshResearchPages("thaumicenergistics.TECORES");
        TCHelper.refreshResearchPages("thaumicenergistics.TEESSTERM");
        TCHelper.refreshResearchPages("thaumicenergistics.TEESSVIBCMBR");
        TCHelper.refreshResearchPages("thaumicenergistics.TEIO");
        TCHelper.refreshResearchPages("thaumicenergistics.TEDISTILLATIONPATTERNENCODER");
        TCHelper.refreshResearchPages("thaumicenergistics.TEFOCUSWRENCH");
        TCHelper.refreshResearchPages("thaumicenergistics.TEGOLEMWIFIBACKPACK");
        TCHelper.refreshResearchPages("thaumicenergistics.TESTORAGE");
        TCHelper.refreshResearchPages("thaumicenergistics.TEVISINT");
        TCHelper.refreshResearchPages("thaumicenergistics.TETHAUMGBOX");
        TCHelper.refreshResearchPages("thaumicenergistics.TEARCANEASSEMBLER");
        TCHelper.refreshResearchPages("thaumicenergistics.TEKNOWLEDGEINSCRIBER");
        TCHelper.refreshResearchPages("thaumicenergistics.TEINFPROV");
        TCHelper.refreshResearchPages("thaumicenergistics.TEADVINFPROV");
    }
}
