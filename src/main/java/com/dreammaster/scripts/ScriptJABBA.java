package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.EnderStorage;
import static gregtech.api.enums.Mods.ExtraTrees;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.JABBA;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ScriptJABBA implements IScriptLoader {

    @Override
    public String getScriptName() {
        return JABBA.ID;
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                JABBA.ID,
                BiomesOPlenty.ID,
                ExtraTrees.ID,
                ExtraUtilities.ID,
                Forestry.ID,
                Natura.ID,
                GregTech.ID,
                BartWorks.ID,
                EnderStorage.ID,
                Railcraft.ID);
    }

    @Override
    public void loadRecipes() {
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "planks", 8, wildcard), getModItem(Minecraft.ID, "chest", 1))
                .itemOutputs(getModItem(JABBA.ID, "barrel", 1)).noFluidInputs().noFluidOutputs().duration(10 * SECONDS)
                .eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(BiomesOPlenty.ID, "planks", 8, wildcard), getModItem(Minecraft.ID, "chest", 1))
                .itemOutputs(getModItem(JABBA.ID, "barrel", 1)).noFluidInputs().noFluidOutputs().duration(10 * SECONDS)
                .eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(ExtraTrees.ID, "planks", 8, wildcard), getModItem(Minecraft.ID, "chest", 1))
                .itemOutputs(getModItem(JABBA.ID, "barrel", 1)).noFluidInputs().noFluidOutputs().duration(10 * SECONDS)
                .eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 8, wildcard),
                        getModItem(Minecraft.ID, "chest", 1))
                .itemOutputs(getModItem(JABBA.ID, "barrel", 1)).noFluidInputs().noFluidOutputs().duration(10 * SECONDS)
                .eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Forestry.ID, "planks", 8, wildcard), getModItem(Minecraft.ID, "chest", 1))
                .itemOutputs(getModItem(JABBA.ID, "barrel", 1)).noFluidInputs().noFluidOutputs().duration(10 * SECONDS)
                .eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "planksFireproof", 8, wildcard),
                        getModItem(Minecraft.ID, "chest", 1))
                .itemOutputs(getModItem(JABBA.ID, "barrel", 1)).noFluidInputs().noFluidOutputs().duration(10 * SECONDS)
                .eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 8, wildcard), getModItem(Minecraft.ID, "chest", 1))
                .itemOutputs(getModItem(JABBA.ID, "barrel", 1)).noFluidInputs().noFluidOutputs().duration(10 * SECONDS)
                .eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1),
                        getModItem(Minecraft.ID, "piston", 1),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1),
                        getModItem(Minecraft.ID, "sticky_piston", 1),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1),
                        ItemList.Electric_Piston_LV.get(1L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 3)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 1),
                        ItemList.Electric_Piston_LV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 4)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 1),
                        ItemList.Electric_Piston_MV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 5)).noFluidInputs().noFluidOutputs()
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 1),
                        ItemList.Electric_Piston_HV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 6)).noFluidInputs().noFluidOutputs()
                .duration(2 * MINUTES).eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 1),
                        ItemList.Electric_Piston_EV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 8L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 8)).noFluidInputs().noFluidOutputs()
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 1),
                        ItemList.Electric_Piston_IV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 16L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 9)).noFluidInputs().noFluidOutputs()
                .duration(3 * MINUTES).eut(TierEU.RECIPE_IV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 1),
                        ItemList.Electric_Piston_LuV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 32L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 11)).noFluidInputs().noFluidOutputs()
                .duration(3 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 1),
                        ItemList.Electric_Piston_ZPM.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 64L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 12)).noFluidInputs().noFluidOutputs()
                .duration(4 * MINUTES).eut(TierEU.RECIPE_ZPM).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 1),
                        ItemList.Electric_Piston_UV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.SuperconductorUHV, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.SuperconductorUHV, 64L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 13)).noFluidInputs().noFluidOutputs()
                .duration(4 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_UV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 3),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 4)).noFluidInputs().noFluidOutputs()
                .duration(45 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 3, 4),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 5)).noFluidInputs().noFluidOutputs()
                .duration(30 * SECONDS).eut(64).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 3, 5),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 6)).noFluidInputs().noFluidOutputs()
                .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 3, 6),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 8)).noFluidInputs().noFluidOutputs()
                .duration(10 * SECONDS).eut(256).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 3, 8),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 9)).noFluidInputs().noFluidOutputs()
                .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 3, 9),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 11)).noFluidInputs().noFluidOutputs()
                .duration(5 * SECONDS).eut(960).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 3, 11),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 12)).noFluidInputs().noFluidOutputs()
                .duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_EV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 3, 12),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 13)).noFluidInputs().noFluidOutputs()
                .duration(1 * SECONDS + 5 * TICKS).eut(4096).addTo(sAssemblerRecipes);

        addShapedRecipe(
                getModItem(JABBA.ID, "barrel", 1),
                "logWood",
                "slabWood",
                "logWood",
                "logWood",
                getModItem(Minecraft.ID, "chest", 1),
                "logWood",
                "logWood",
                "logWood",
                "logWood");

        addShapedRecipe(
                getModItem(JABBA.ID, "mover", 1),
                "stickAnyIron",
                "stickAnyIron",
                "roundAnyRubber",
                "stickAnyIron",
                "craftingToolWrench",
                "roundAnyRubber",
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32100),
                "plateSteel",
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32100));

        addShapedRecipe(
                getModItem(JABBA.ID, "moverDiamond", 1),
                "stickDiamond",
                "stickDiamond",
                "roundPlastic",
                "stickDiamond",
                "craftingToolWrench",
                "roundPlastic",
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32101),
                "plateNetherStar",
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32101));

        addShapedRecipe(
                getModItem(JABBA.ID, "hammer", 1),
                "ingotIron",
                "plateAnyIron",
                "ingotIron",
                "screwAnyIron",
                "stickAnyIron",
                "screwAnyIron",
                "craftingToolHardHammer",
                "stickAnyIron",
                "craftingToolScrewdriver");

        addShapedRecipe(
                getModItem(JABBA.ID, "tuningFork", 1),
                "craftingToolScrewdriver",
                "stickAnyIron",
                null,
                "screwAnyIron",
                "plateAnyIron",
                "stickAnyIron",
                "stickAnyIron",
                "screwAnyIron",
                "craftingToolHardHammer");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeStructural", 1),
                "stickWood",
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809),
                "stickWood",
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809),
                getModItem(JABBA.ID, "barrel", 1),
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809),
                "stickWood",
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809),
                "stickWood");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeStructural", 1, 1),
                "stickCopper",
                "plateCopper",
                "stickCopper",
                "plateCopper",
                getModItem(JABBA.ID, "barrel", 1),
                "plateCopper",
                "stickCopper",
                "plateCopper",
                "stickCopper");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeStructural", 1, 2),
                "stickIron",
                "plateIron",
                "stickIron",
                "plateIron",
                getModItem(JABBA.ID, "barrel", 1),
                "plateIron",
                "stickIron",
                "plateIron",
                "stickIron");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeStructural", 1, 3),
                "stickBronze",
                "plateBronze",
                "stickBronze",
                "plateBronze",
                getModItem(JABBA.ID, "barrel", 1),
                "plateBronze",
                "stickBronze",
                "plateBronze",
                "stickBronze");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeStructural", 1, 4),
                "stickSteel",
                "plateSteel",
                "stickSteel",
                "plateSteel",
                getModItem(JABBA.ID, "barrel", 1),
                "plateSteel",
                "stickSteel",
                "plateSteel",
                "stickSteel");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeStructural", 1, 5),
                "stickAluminium",
                "plateAluminium",
                "stickAluminium",
                "plateAluminium",
                getModItem(JABBA.ID, "barrel", 1),
                "plateAluminium",
                "stickAluminium",
                "plateAluminium",
                "stickAluminium");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeStructural", 1, 6),
                "stickStainlessSteel",
                "plateStainlessSteel",
                "stickStainlessSteel",
                "plateStainlessSteel",
                getModItem(JABBA.ID, "barrel", 1),
                "plateStainlessSteel",
                "stickStainlessSteel",
                "plateStainlessSteel",
                "stickStainlessSteel");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeStructural", 1, 7),
                "stickTitanium",
                "plateTitanium",
                "stickTitanium",
                "plateTitanium",
                getModItem(JABBA.ID, "barrel", 1),
                "plateTitanium",
                "stickTitanium",
                "plateTitanium",
                "stickTitanium");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeStructural", 1, 8),
                "stickTungstenSteel",
                "plateTungstenSteel",
                "stickTungstenSteel",
                "plateTungstenSteel",
                getModItem(JABBA.ID, "barrel", 1),
                "plateTungstenSteel",
                "stickTungstenSteel",
                "plateTungstenSteel",
                "stickTungstenSteel");

        if (BartWorks.isModLoaded()) {
            addShapedRecipe(
                    getModItem(JABBA.ID, "upgradeStructural", 1, 9),
                    "stickRhodium-PlatedPalladium",
                    "plateRhodium-PlatedPalladium",
                    "stickRhodium-PlatedPalladium",
                    "plateRhodium-PlatedPalladium",
                    getModItem(JABBA.ID, "barrel", 1),
                    "plateRhodium-PlatedPalladium",
                    "stickRhodium-PlatedPalladium",
                    "plateRhodium-PlatedPalladium",
                    "stickRhodium-PlatedPalladium");

        } else {

            addShapedRecipe(
                    getModItem(JABBA.ID, "upgradeStructural", 1, 9),
                    "stickChrome",
                    "plateChrome",
                    "stickChrome",
                    "plateChrome",
                    getModItem(JABBA.ID, "barrel", 1),
                    "plateChrome",
                    "stickChrome",
                    "plateChrome",
                    "stickChrome");
        }

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeStructural", 1, 10),
                "stickIridium",
                "plateIridium",
                "stickIridium",
                "plateIridium",
                getModItem(JABBA.ID, "barrel", 1),
                "plateIridium",
                "stickIridium",
                "plateIridium",
                "stickIridium");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeStructural", 1, 11),
                "stickOsmium",
                "plateOsmium",
                "stickOsmium",
                "plateOsmium",
                getModItem(JABBA.ID, "barrel", 1),
                "plateOsmium",
                "stickOsmium",
                "plateOsmium",
                "stickOsmium");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeStructural", 1, 12),
                "stickNeutronium",
                "plateNeutronium",
                "stickNeutronium",
                "plateNeutronium",
                getModItem(JABBA.ID, "barrel", 1),
                "plateNeutronium",
                "stickNeutronium",
                "plateNeutronium",
                "stickNeutronium");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeStructural", 1, 13),
                "stickBlackPlutonium",
                "plateBlackPlutonium",
                "stickBlackPlutonium",
                "plateBlackPlutonium",
                getModItem(JABBA.ID, "barrel", 1),
                "plateBlackPlutonium",
                "stickBlackPlutonium",
                "plateBlackPlutonium",
                "stickBlackPlutonium");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeCore", 2, 1),
                "plateEnderEye",
                getModItem(Minecraft.ID, "piston", 1),
                "plateEnderEye",
                getModItem(Minecraft.ID, "piston", 1),
                getModItem(EnderStorage.ID, "enderChest", 1),
                getModItem(Minecraft.ID, "piston", 1),
                "plateEnderEye",
                getModItem(Minecraft.ID, "piston", 1),
                "plateEnderEye");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeCore", 2, 1),
                "plateEnderEye",
                getModItem(Minecraft.ID, "sticky_piston", 1),
                "plateEnderEye",
                getModItem(Minecraft.ID, "piston", 1),
                getModItem(EnderStorage.ID, "enderChest", 1),
                getModItem(Minecraft.ID, "piston", 1),
                "plateEnderEye",
                getModItem(Minecraft.ID, "sticky_piston", 1),
                "plateEnderEye");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeCore", 1, 2),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "piston", 1),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "piston", 1),
                getModItem(Minecraft.ID, "redstone_block", 1),
                getModItem(Minecraft.ID, "piston", 1),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "piston", 1),
                "plateRedAlloy");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeCore", 1, 2),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "sticky_piston", 1),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "piston", 1),
                getModItem(Minecraft.ID, "redstone_block", 1),
                getModItem(Minecraft.ID, "piston", 1),
                "plateRedAlloy",
                getModItem(Minecraft.ID, "sticky_piston", 1),
                "plateRedAlloy");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeCore", 1, 3),
                "plateIron",
                getModItem(Minecraft.ID, "piston", 1),
                "plateIron",
                getModItem(Minecraft.ID, "piston", 1),
                getModItem(Minecraft.ID, "hopper", 1),
                getModItem(Minecraft.ID, "piston", 1),
                "plateIron",
                getModItem(Minecraft.ID, "piston", 1),
                "plateIron");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeCore", 1, 3),
                "plateIron",
                getModItem(Minecraft.ID, "sticky_piston", 1),
                "plateIron",
                getModItem(Minecraft.ID, "piston", 1),
                getModItem(Minecraft.ID, "hopper", 1),
                getModItem(Minecraft.ID, "piston", 1),
                "plateIron",
                getModItem(Minecraft.ID, "sticky_piston", 1),
                "plateIron");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeCore", 1, 7),
                "plateIron",
                getModItem(Minecraft.ID, "piston", 1),
                "plateIron",
                getModItem(Minecraft.ID, "piston", 1),
                getModItem(Railcraft.ID, "machine.beta", 1, 11),
                getModItem(Minecraft.ID, "piston", 1),
                "plateIron",
                getModItem(Minecraft.ID, "piston", 1),
                "plateIron");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeCore", 1, 7),
                "plateIron",
                getModItem(Minecraft.ID, "sticky_piston", 1),
                "plateIron",
                getModItem(Minecraft.ID, "piston", 1),
                getModItem(Railcraft.ID, "machine.beta", 1, 11),
                getModItem(Minecraft.ID, "piston", 1),
                "plateIron",
                getModItem(Minecraft.ID, "sticky_piston", 1),
                "plateIron");

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeCore", 1),
                "screwSteel",
                getModItem(Minecraft.ID, "piston", 1),
                "screwSteel",
                "screwSteel",
                getModItem(JABBA.ID, "barrel", 1),
                "screwSteel",
                null,
                "craftingToolScrewdriver",
                null);

        addShapedRecipe(
                getModItem(JABBA.ID, "upgradeCore", 1),
                "screwSteel",
                getModItem(Minecraft.ID, "sticky_piston", 1),
                "screwSteel",
                "screwSteel",
                getModItem(JABBA.ID, "barrel", 1),
                "screwSteel",
                null,
                "craftingToolScrewdriver",
                null);
    }
}
