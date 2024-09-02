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
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;

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
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "planks", 8, wildcard), getModItem(Minecraft.ID, "chest", 1))
                .itemOutputs(getModItem(JABBA.ID, "barrel", 1)).duration(10 * SECONDS).eut(16).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(BiomesOPlenty.ID, "planks", 8, wildcard), getModItem(Minecraft.ID, "chest", 1))
                .itemOutputs(getModItem(JABBA.ID, "barrel", 1)).duration(10 * SECONDS).eut(16).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(ExtraTrees.ID, "planks", 8, wildcard), getModItem(Minecraft.ID, "chest", 1))
                .itemOutputs(getModItem(JABBA.ID, "barrel", 1)).duration(10 * SECONDS).eut(16).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 8, wildcard),
                        getModItem(Minecraft.ID, "chest", 1))
                .itemOutputs(getModItem(JABBA.ID, "barrel", 1)).duration(10 * SECONDS).eut(16).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Forestry.ID, "planks", 8, wildcard), getModItem(Minecraft.ID, "chest", 1))
                .itemOutputs(getModItem(JABBA.ID, "barrel", 1)).duration(10 * SECONDS).eut(16).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "planksFireproof", 8, wildcard),
                        getModItem(Minecraft.ID, "chest", 1))
                .itemOutputs(getModItem(JABBA.ID, "barrel", 1)).duration(10 * SECONDS).eut(16).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 8, wildcard), getModItem(Minecraft.ID, "chest", 1))
                .itemOutputs(getModItem(JABBA.ID, "barrel", 1)).duration(10 * SECONDS).eut(16).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1),
                        getModItem(Minecraft.ID, "piston", 1),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1)).duration(60 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1),
                        getModItem(Minecraft.ID, "sticky_piston", 1),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1)).duration(60 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "barrel", 1),
                        ItemList.Electric_Piston_LV.get(1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 3)).duration(60 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 1),
                        ItemList.Electric_Piston_LV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 4)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 1),
                        ItemList.Electric_Piston_MV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 2L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 5)).duration(1 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 1),
                        ItemList.Electric_Piston_HV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 4L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 6)).duration(2 * MINUTES).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 1),
                        ItemList.Electric_Piston_EV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 8L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 8)).duration(2 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 1),
                        ItemList.Electric_Piston_IV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 16L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 9)).duration(3 * MINUTES).eut(TierEU.RECIPE_IV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 1),
                        ItemList.Electric_Piston_LuV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 32L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 11)).duration(3 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 1),
                        ItemList.Electric_Piston_ZPM.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ZPM, 64L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 12)).duration(4 * MINUTES).eut(TierEU.RECIPE_ZPM)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(JABBA.ID, "upgradeCore", 1),
                        ItemList.Electric_Piston_UV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 64L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 64L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 13)).duration(4 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(JABBA.ID, "upgradeCore", 3), GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 4)).duration(45 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(JABBA.ID, "upgradeCore", 3, 4), GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 5)).duration(30 * SECONDS).eut(64)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(JABBA.ID, "upgradeCore", 3, 5), GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 6)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(JABBA.ID, "upgradeCore", 3, 6), GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 8)).duration(10 * SECONDS).eut(256)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(JABBA.ID, "upgradeCore", 3, 8), GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 9)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(JABBA.ID, "upgradeCore", 3, 9), GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 11)).duration(5 * SECONDS).eut(960)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(JABBA.ID, "upgradeCore", 3, 11), GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 12)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(JABBA.ID, "upgradeCore", 3, 12), GTUtility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(JABBA.ID, "upgradeCore", 1, 13)).duration(1 * SECONDS + 5 * TICKS).eut(4096)
                .addTo(assemblerRecipes);

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
                ItemList.Component_Minecart_Wheels_Iron.get(1L),
                "plateSteel",
                ItemList.Component_Minecart_Wheels_Iron.get(1L));

        addShapedRecipe(
                getModItem(JABBA.ID, "moverDiamond", 1),
                "stickDiamond",
                "stickDiamond",
                "roundPlastic",
                "stickDiamond",
                "craftingToolWrench",
                "roundPlastic",
                ItemList.Component_Minecart_Wheels_Steel.get(1L),
                "plateNetherStar",
                ItemList.Component_Minecart_Wheels_Steel.get(1L));

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
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                getModItem(JABBA.ID, "barrel", 1),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "stickWood",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
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
