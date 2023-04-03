package com.dreammaster.scripts;

import static com.dreammaster.MissingModIDs.ExtraTrees;
import static com.dreammaster.MissingModIDs.JABBA;
import static gregtech.api.enums.ModIDs.BartWorks;
import static gregtech.api.enums.ModIDs.BiomesOPlanty;
import static gregtech.api.enums.ModIDs.EnderStorage;
import static gregtech.api.enums.ModIDs.ExtraUtilities;
import static gregtech.api.enums.ModIDs.Forestry;
import static gregtech.api.enums.ModIDs.GregTech;
import static gregtech.api.enums.ModIDs.Minecraft;
import static gregtech.api.enums.ModIDs.Natura;
import static gregtech.api.enums.ModIDs.Railcraft;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ScriptJABBA implements IScriptLoader {

    @Override
    public String getScriptName() {
        return JABBA.modID;
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                JABBA.modID,
                BiomesOPlanty.modID,
                ExtraTrees.modID,
                ExtraUtilities.modID,
                Forestry.modID,
                Natura.modID,
                GregTech.modID);
    }

    @Override
    public void loadRecipes() {
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(Minecraft.modID, "planks", 8, 32767),
                        getModItem(Minecraft.modID, "chest", 1) },
                GT_Values.NF,
                getModItem(JABBA.modID, "barrel", 1),
                200,
                16);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(BiomesOPlanty.modID, "planks", 8, 32767),
                        getModItem(Minecraft.modID, "chest", 1) },
                GT_Values.NF,
                getModItem(JABBA.modID, "barrel", 1),
                200,
                16);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(ExtraTrees.modID, "planks", 8, 32767),
                        getModItem(Minecraft.modID, "chest", 1) },
                GT_Values.NF,
                getModItem(JABBA.modID, "barrel", 1),
                200,
                16);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(ExtraUtilities.modID, "colorWoodPlanks", 8, 32767),
                        getModItem(Minecraft.modID, "chest", 1) },
                GT_Values.NF,
                getModItem(JABBA.modID, "barrel", 1),
                200,
                16);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(Forestry.modID, "planks", 8, 32767),
                        getModItem(Minecraft.modID, "chest", 1) },
                GT_Values.NF,
                getModItem(JABBA.modID, "barrel", 1),
                200,
                16);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(Forestry.modID, "planksFireproof", 8, 32767),
                        getModItem(Minecraft.modID, "chest", 1) },
                GT_Values.NF,
                getModItem(JABBA.modID, "barrel", 1),
                200,
                16);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(Natura.modID, "planks", 8, 32767),
                        getModItem(Minecraft.modID, "chest", 1) },
                GT_Values.NF,
                getModItem(JABBA.modID, "barrel", 1),
                200,
                16);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(JABBA.modID, "barrel", 1), getModItem(Minecraft.modID, "piston", 1),
                        GT_Utility.getIntegratedCircuit(1) },
                GT_Values.NF,
                getModItem(JABBA.modID, "upgradeCore", 1),
                1200,
                16);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(JABBA.modID, "barrel", 1), getModItem(Minecraft.modID, "sticky_piston", 1),
                        GT_Utility.getIntegratedCircuit(1) },
                GT_Values.NF,
                getModItem(JABBA.modID, "upgradeCore", 1),
                1200,
                16);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(JABBA.modID, "barrel", 1), ItemList.Electric_Piston_LV.get(1L),
                        GT_Utility.getIntegratedCircuit(2) },
                GT_Values.NF,
                getModItem(JABBA.modID, "upgradeCore", 3),
                1200,
                16);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(JABBA.modID, "upgradeCore", 1), ItemList.Electric_Piston_LV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),
                        GT_Utility.getIntegratedCircuit(1) },
                GT_Values.NF,
                getModItem(JABBA.modID, "upgradeCore", 1, 4),
                1200,
                30);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(JABBA.modID, "upgradeCore", 1), ItemList.Electric_Piston_MV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                        GT_Utility.getIntegratedCircuit(1) },
                GT_Values.NF,
                getModItem(JABBA.modID, "upgradeCore", 1, 5),
                1800,
                120);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(JABBA.modID, "upgradeCore", 1), ItemList.Electric_Piston_HV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4L),
                        GT_Utility.getIntegratedCircuit(1) },
                GT_Values.NF,
                getModItem(JABBA.modID, "upgradeCore", 1, 6),
                2400,
                480);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(JABBA.modID, "upgradeCore", 1), ItemList.Electric_Piston_EV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 8L),
                        GT_Utility.getIntegratedCircuit(1) },
                GT_Values.NF,
                getModItem(JABBA.modID, "upgradeCore", 1, 8),
                3000,
                1920);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(JABBA.modID, "upgradeCore", 1), ItemList.Electric_Piston_IV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 16L),
                        GT_Utility.getIntegratedCircuit(1) },
                GT_Values.NF,
                getModItem(JABBA.modID, "upgradeCore", 1, 9),
                3600,
                7680);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(JABBA.modID, "upgradeCore", 1), ItemList.Electric_Piston_LuV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 32L),
                        GT_Utility.getIntegratedCircuit(1) },
                GT_Values.NF,
                getModItem(JABBA.modID, "upgradeCore", 1, 11),
                4200,
                30720);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(JABBA.modID, "upgradeCore", 1), ItemList.Electric_Piston_ZPM.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 64L),
                        GT_Utility.getIntegratedCircuit(1) },
                GT_Values.NF,
                getModItem(JABBA.modID, "upgradeCore", 1, 12),
                4800,
                122880);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(JABBA.modID, "upgradeCore", 1), ItemList.Electric_Piston_UV.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Superconductor, 64L),
                        GT_Utility.getIntegratedCircuit(1) },
                GT_Values.NF,
                getModItem(JABBA.modID, "upgradeCore", 1, 13),
                5400,
                500000);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(JABBA.modID, "upgradeCore", 3),
                        getModItem(GregTech.modID, "gt.integrated_circuit", 0, 3) },
                GT_Values.NF,
                getModItem(JABBA.modID, "upgradeCore", 1, 4),
                900,
                30);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(JABBA.modID, "upgradeCore", 3, 4),
                        getModItem(GregTech.modID, "gt.integrated_circuit", 0, 3) },
                GT_Values.NF,
                getModItem(JABBA.modID, "upgradeCore", 1, 5),
                600,
                64);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(JABBA.modID, "upgradeCore", 3, 5),
                        getModItem(GregTech.modID, "gt.integrated_circuit", 0, 3) },
                GT_Values.NF,
                getModItem(JABBA.modID, "upgradeCore", 1, 6),
                400,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(JABBA.modID, "upgradeCore", 3, 6),
                        getModItem(GregTech.modID, "gt.integrated_circuit", 0, 3) },
                GT_Values.NF,
                getModItem(JABBA.modID, "upgradeCore", 1, 8),
                200,
                256);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(JABBA.modID, "upgradeCore", 3, 8),
                        getModItem(GregTech.modID, "gt.integrated_circuit", 0, 3) },
                GT_Values.NF,
                getModItem(JABBA.modID, "upgradeCore", 1, 9),
                150,
                480);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(JABBA.modID, "upgradeCore", 3, 9),
                        getModItem(GregTech.modID, "gt.integrated_circuit", 0, 3) },
                GT_Values.NF,
                getModItem(JABBA.modID, "upgradeCore", 1, 11),
                100,
                960);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(JABBA.modID, "upgradeCore", 3, 11),
                        getModItem(GregTech.modID, "gt.integrated_circuit", 0, 3) },
                GT_Values.NF,
                getModItem(JABBA.modID, "upgradeCore", 1, 12),
                50,
                1920);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(JABBA.modID, "upgradeCore", 3, 12),
                        getModItem(GregTech.modID, "gt.integrated_circuit", 0, 3) },
                GT_Values.NF,
                getModItem(JABBA.modID, "upgradeCore", 1, 13),
                25,
                4096);

        addShapedRecipe(
                getModItem(JABBA.modID, "barrel", 1),
                new Object[] { "logWood", "slabWood", "logWood", "logWood", getModItem(Minecraft.modID, "chest", 1),
                        "logWood", "logWood", "logWood", "logWood" });

        addShapedRecipe(
                getModItem(JABBA.modID, "mover", 1),
                new Object[] { "stickAnyIron", "stickAnyIron", "roundAnyRubber", "stickAnyIron", "craftingToolWrench",
                        "roundAnyRubber", getModItem(GregTech.modID, "gt.metaitem.01", 1, 32100), "plateSteel",
                        getModItem(GregTech.modID, "gt.metaitem.01", 1, 32100) });

        addShapedRecipe(
                getModItem(JABBA.modID, "moverDiamond", 1),
                new Object[] { "stickDiamond", "stickDiamond", "roundPlastic", "stickDiamond", "craftingToolWrench",
                        "roundPlastic", getModItem(GregTech.modID, "gt.metaitem.01", 1, 32101), "plateNetherStar",
                        getModItem(GregTech.modID, "gt.metaitem.01", 1, 32101) });

        addShapedRecipe(
                getModItem(JABBA.modID, "hammer", 1),
                new Object[] { "ingotIron", "plateAnyIron", "ingotIron", "screwAnyIron", "stickAnyIron", "screwAnyIron",
                        "craftingToolHardHammer", "stickAnyIron", getModItem("GTore", "craftingToolScrewdriver", 1) });

        addShapedRecipe(
                getModItem(JABBA.modID, "tuningFork", 1),
                new Object[] { getModItem("GTore", "craftingToolScrewdriver", 1), "stickAnyIron", null, "screwAnyIron",
                        "plateAnyIron", "stickAnyIron", "stickAnyIron", "screwAnyIron", "craftingToolHardHammer" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeStructural", 1),
                new Object[] { "stickWood", getModItem(GregTech.modID, "gt.metaitem.01", 1, 17809), "stickWood",
                        getModItem(GregTech.modID, "gt.metaitem.01", 1, 17809), getModItem(JABBA.modID, "barrel", 1),
                        getModItem(GregTech.modID, "gt.metaitem.01", 1, 17809), "stickWood",
                        getModItem(GregTech.modID, "gt.metaitem.01", 1, 17809), "stickWood" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeStructural", 1, 1),
                new Object[] { "stickCopper", "plateCopper", "stickCopper", "plateCopper",
                        getModItem(JABBA.modID, "barrel", 1), "plateCopper", "stickCopper", "plateCopper",
                        "stickCopper" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeStructural", 1, 2),
                new Object[] { "stickIron", "plateIron", "stickIron", "plateIron", getModItem(JABBA.modID, "barrel", 1),
                        "plateIron", "stickIron", "plateIron", "stickIron" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeStructural", 1, 3),
                new Object[] { "stickBronze", "plateBronze", "stickBronze", "plateBronze",
                        getModItem(JABBA.modID, "barrel", 1), "plateBronze", "stickBronze", "plateBronze",
                        "stickBronze" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeStructural", 1, 4),
                new Object[] { "stickSteel", "plateSteel", "stickSteel", "plateSteel",
                        getModItem(JABBA.modID, "barrel", 1), "plateSteel", "stickSteel", "plateSteel", "stickSteel" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeStructural", 1, 5),
                new Object[] { "stickAluminium", "plateAluminium", "stickAluminium", "plateAluminium",
                        getModItem(JABBA.modID, "barrel", 1), "plateAluminium", "stickAluminium", "plateAluminium",
                        "stickAluminium" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeStructural", 1, 6),
                new Object[] { "stickStainlessSteel", "plateStainlessSteel", "stickStainlessSteel",
                        "plateStainlessSteel", getModItem(JABBA.modID, "barrel", 1), "plateStainlessSteel",
                        "stickStainlessSteel", "plateStainlessSteel", "stickStainlessSteel" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeStructural", 1, 7),
                new Object[] { "stickTitanium", "plateTitanium", "stickTitanium", "plateTitanium",
                        getModItem(JABBA.modID, "barrel", 1), "plateTitanium", "stickTitanium", "plateTitanium",
                        "stickTitanium" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeStructural", 1, 8),
                new Object[] { "stickTungstenSteel", "plateTungstenSteel", "stickTungstenSteel", "plateTungstenSteel",
                        getModItem(JABBA.modID, "barrel", 1), "plateTungstenSteel", "stickTungstenSteel",
                        "plateTungstenSteel", "stickTungstenSteel" });

        if (BartWorks.isModLoaded()) {
            addShapedRecipe(
                    getModItem(JABBA.modID, "upgradeStructural", 1, 9),
                    new Object[] { "stickRhodium-PlatedPalladium", "plateRhodium-PlatedPalladium",
                            "stickRhodium-PlatedPalladium", "plateRhodium-PlatedPalladium",
                            getModItem(JABBA.modID, "barrel", 1), "plateRhodium-PlatedPalladium",
                            "stickRhodium-PlatedPalladium", "plateRhodium-PlatedPalladium",
                            "stickRhodium-PlatedPalladium" });

        } else {

            addShapedRecipe(
                    getModItem(JABBA.modID, "upgradeStructural", 1, 9),
                    new Object[] { "stickChrome", "plateChrome", "stickChrome", "plateChrome",
                            getModItem(JABBA.modID, "barrel", 1), "plateChrome", "stickChrome", "plateChrome",
                            "stickChrome" });
        }

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeStructural", 1, 10),
                new Object[] { "stickIridium", "plateIridium", "stickIridium", "plateIridium",
                        getModItem(JABBA.modID, "barrel", 1), "plateIridium", "stickIridium", "plateIridium",
                        "stickIridium" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeStructural", 1, 11),
                new Object[] { "stickOsmium", "plateOsmium", "stickOsmium", "plateOsmium",
                        getModItem(JABBA.modID, "barrel", 1), "plateOsmium", "stickOsmium", "plateOsmium",
                        "stickOsmium" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeStructural", 1, 12),
                new Object[] { "stickNeutronium", "plateNeutronium", "stickNeutronium", "plateNeutronium",
                        getModItem(JABBA.modID, "barrel", 1), "plateNeutronium", "stickNeutronium", "plateNeutronium",
                        "stickNeutronium" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeStructural", 1, 13),
                new Object[] { "stickBlackPlutonium", "plateBlackPlutonium", "stickBlackPlutonium",
                        "plateBlackPlutonium", getModItem(JABBA.modID, "barrel", 1), "plateBlackPlutonium",
                        "stickBlackPlutonium", "plateBlackPlutonium", "stickBlackPlutonium" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeCore", 2, 1),
                new Object[] { "plateEnderEye", getModItem(Minecraft.modID, "piston", 1), "plateEnderEye",
                        getModItem(Minecraft.modID, "piston", 1), getModItem(EnderStorage.modID, "enderChest", 1),
                        getModItem(Minecraft.modID, "piston", 1), "plateEnderEye",
                        getModItem(Minecraft.modID, "piston", 1), "plateEnderEye" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeCore", 2, 1),
                new Object[] { "plateEnderEye", getModItem(Minecraft.modID, "sticky_piston", 1), "plateEnderEye",
                        getModItem(Minecraft.modID, "piston", 1), getModItem(EnderStorage.modID, "enderChest", 1),
                        getModItem(Minecraft.modID, "piston", 1), "plateEnderEye",
                        getModItem(Minecraft.modID, "sticky_piston", 1), "plateEnderEye" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeCore", 1, 2),
                new Object[] { "plateRedAlloy", getModItem(Minecraft.modID, "piston", 1), "plateRedAlloy",
                        getModItem(Minecraft.modID, "piston", 1), getModItem(Minecraft.modID, "redstone_block", 1),
                        getModItem(Minecraft.modID, "piston", 1), "plateRedAlloy",
                        getModItem(Minecraft.modID, "piston", 1), "plateRedAlloy" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeCore", 1, 2),
                new Object[] { "plateRedAlloy", getModItem(Minecraft.modID, "sticky_piston", 1), "plateRedAlloy",
                        getModItem(Minecraft.modID, "piston", 1), getModItem(Minecraft.modID, "redstone_block", 1),
                        getModItem(Minecraft.modID, "piston", 1), "plateRedAlloy",
                        getModItem(Minecraft.modID, "sticky_piston", 1), "plateRedAlloy" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeCore", 1, 3),
                new Object[] { "plateIron", getModItem(Minecraft.modID, "piston", 1), "plateIron",
                        getModItem(Minecraft.modID, "piston", 1), getModItem(Minecraft.modID, "hopper", 1),
                        getModItem(Minecraft.modID, "piston", 1), "plateIron", getModItem(Minecraft.modID, "piston", 1),
                        "plateIron" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeCore", 1, 3),
                new Object[] { "plateIron", getModItem(Minecraft.modID, "sticky_piston", 1), "plateIron",
                        getModItem(Minecraft.modID, "piston", 1), getModItem(Minecraft.modID, "hopper", 1),
                        getModItem(Minecraft.modID, "piston", 1), "plateIron",
                        getModItem(Minecraft.modID, "sticky_piston", 1), "plateIron" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeCore", 1, 7),
                new Object[] { "plateIron", getModItem(Minecraft.modID, "piston", 1), "plateIron",
                        getModItem(Minecraft.modID, "piston", 1), getModItem(Railcraft.modID, "machine.beta", 1, 11),
                        getModItem(Minecraft.modID, "piston", 1), "plateIron", getModItem(Minecraft.modID, "piston", 1),
                        "plateIron" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeCore", 1, 7),
                new Object[] { "plateIron", getModItem(Minecraft.modID, "sticky_piston", 1), "plateIron",
                        getModItem(Minecraft.modID, "piston", 1), getModItem(Railcraft.modID, "machine.beta", 1, 11),
                        getModItem(Minecraft.modID, "piston", 1), "plateIron",
                        getModItem(Minecraft.modID, "sticky_piston", 1), "plateIron" });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeCore", 1),
                new Object[] { "screwSteel", getModItem(Minecraft.modID, "piston", 1), "screwSteel", "screwSteel",
                        getModItem(JABBA.modID, "barrel", 1), "screwSteel", null, "craftingToolScrewdriver", null });

        addShapedRecipe(
                getModItem(JABBA.modID, "upgradeCore", 1),
                new Object[] { "screwSteel", getModItem(Minecraft.modID, "sticky_piston", 1), "screwSteel",
                        "screwSteel", getModItem(JABBA.modID, "barrel", 1), "screwSteel", null,
                        "craftingToolScrewdriver", null });
    }
}
