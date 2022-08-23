package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import gregtech.api.enums.GT_Values;
import java.util.Arrays;
import net.minecraft.item.ItemStack;

public class ScriptJABBA implements IScriptLoader {

    public ScriptJABBA() {}

    @Override
    public void initScriptData() {
        scriptName.setLength(0);
        scriptName.append("JABBA");
        dependencies.clear();
        dependencies.addAll(Arrays.asList(
                "JABBA", "BiomesOPlenty", "ExtraTrees", "ExtraUtilities", "Forestry", "Natura", "gregtech"));
    }

    @Override
    public void loadRecipes() {
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {getModItem("minecraft", "planks", 8, 32767), getModItem("minecraft", "chest", 1)},
                GT_Values.NF,
                getModItem("JABBA", "barrel", 1),
                200,
                16);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {getModItem("BiomesOPlenty", "planks", 8, 32767), getModItem("minecraft", "chest", 1)},
                GT_Values.NF,
                getModItem("JABBA", "barrel", 1),
                200,
                16);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {getModItem("ExtraTrees", "planks", 8, 32767), getModItem("minecraft", "chest", 1)},
                GT_Values.NF,
                getModItem("JABBA", "barrel", 1),
                200,
                16);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    getModItem("ExtraUtilities", "colorWoodPlanks", 8, 32767), getModItem("minecraft", "chest", 1)
                },
                GT_Values.NF,
                getModItem("JABBA", "barrel", 1),
                200,
                16);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {getModItem("Forestry", "planks", 8, 32767), getModItem("minecraft", "chest", 1)},
                GT_Values.NF,
                getModItem("JABBA", "barrel", 1),
                200,
                16);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    getModItem("Forestry", "planksFireproof", 8, 32767), getModItem("minecraft", "chest", 1)
                },
                GT_Values.NF,
                getModItem("JABBA", "barrel", 1),
                200,
                16);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {getModItem("Natura", "planks", 8, 32767), getModItem("minecraft", "chest", 1)},
                GT_Values.NF,
                getModItem("JABBA", "barrel", 1),
                200,
                16);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {getModItem("JABBA", "barrel", 1), getModItem("minecraft", "piston", 1)},
                GT_Values.NF,
                getModItem("JABBA", "upgradeCore", 1),
                1200,
                16);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {getModItem("JABBA", "barrel", 1), getModItem("minecraft", "sticky_piston", 1)},
                GT_Values.NF,
                getModItem("JABBA", "upgradeCore", 1),
                1200,
                16);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    getModItem("JABBA", "upgradeCore", 3), getModItem("gregtech", "gt.integrated_circuit", 0, 3)
                },
                GT_Values.NF,
                getModItem("JABBA", "upgradeCore", 1, 4),
                900,
                30);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    getModItem("JABBA", "upgradeCore", 3, 4), getModItem("gregtech", "gt.integrated_circuit", 0, 3)
                },
                GT_Values.NF,
                getModItem("JABBA", "upgradeCore", 1, 5),
                600,
                64);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    getModItem("JABBA", "upgradeCore", 3, 5), getModItem("gregtech", "gt.integrated_circuit", 0, 3)
                },
                GT_Values.NF,
                getModItem("JABBA", "upgradeCore", 1, 6),
                400,
                120);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    getModItem("JABBA", "upgradeCore", 3, 6), getModItem("gregtech", "gt.integrated_circuit", 0, 3)
                },
                GT_Values.NF,
                getModItem("JABBA", "upgradeCore", 1, 8),
                200,
                256);
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    getModItem("JABBA", "upgradeCore", 3, 8), getModItem("gregtech", "gt.integrated_circuit", 0, 3)
                },
                GT_Values.NF,
                getModItem("JABBA", "upgradeCore", 1, 9),
                150,
                480);

        addShapedRecipe(getModItem("JABBA", "barrel", 1), new Object[] {
            "logWood", "slabWood", "logWood",
            "logWood", getModItem("minecraft", "chest", 1), "logWood",
            "logWood", "logWood", "logWood"
        });

        addShapedRecipe(getModItem("JABBA", "mover", 1), new Object[] {
            "stickAnyIron",
            "stickAnyIron",
            "roundAnyRubber",
            "stickAnyIron",
            "craftingToolWrench",
            "roundAnyRubber",
            getModItem("gregtech", "gt.metaitem.01", 1, 32100),
            "plateSteel",
            getModItem("gregtech", "gt.metaitem.01", 1, 32100)
        });

        addShapedRecipe(getModItem("JABBA", "moverDiamond", 1), new Object[] {
            "stickDiamond",
            "stickDiamond",
            "roundPlastic",
            "stickDiamond",
            "craftingToolWrench",
            "roundPlastic",
            getModItem("gregtech", "gt.metaitem.01", 1, 32101),
            "plateNetherStar",
            getModItem("gregtech", "gt.metaitem.01", 1, 32101)
        });

        addShapedRecipe(getModItem("JABBA", "hammer", 1), new Object[] {
            "ingotIron", "plateAnyIron", "ingotIron",
            "screwAnyIron", "stickAnyIron", "screwAnyIron",
            "craftingToolHardHammer", "stickAnyIron", getModItem("GTore", "craftingToolScrewdriver", 1)
        });

        addShapedRecipe(getModItem("JABBA", "tuningFork", 1), new Object[] {
            getModItem("GTore", "craftingToolScrewdriver", 1),
            "stickAnyIron",
            null,
            "screwAnyIron",
            "plateAnyIron",
            "stickAnyIron",
            "stickAnyIron",
            "screwAnyIron",
            "craftingToolHardHammer"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeStructural", 1), new Object[] {
            "stickWood",
            getModItem("gregtech", "gt.metaitem.01", 1, 17809),
            "stickWood",
            getModItem("gregtech", "gt.metaitem.01", 1, 17809),
            getModItem("JABBA", "barrel", 1),
            getModItem("gregtech", "gt.metaitem.01", 1, 17809),
            "stickWood",
            getModItem("gregtech", "gt.metaitem.01", 1, 17809),
            "stickWood"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeStructural", 1, 1), new Object[] {
            "stickCopper", "plateCopper", "stickCopper",
            "plateCopper", getModItem("JABBA", "barrel", 1), "plateCopper",
            "stickCopper", "plateCopper", "stickCopper"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeStructural", 1, 2), new Object[] {
            "stickIron", "plateIron", "stickIron",
            "plateIron", getModItem("JABBA", "barrel", 1), "plateIron",
            "stickIron", "plateIron", "stickIron"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeStructural", 1, 3), new Object[] {
            "stickBronze", "plateBronze", "stickBronze",
            "plateBronze", getModItem("JABBA", "barrel", 1), "plateBronze",
            "stickBronze", "plateBronze", "stickBronze"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeStructural", 1, 4), new Object[] {
            "stickSteel", "plateSteel", "stickSteel",
            "plateSteel", getModItem("JABBA", "barrel", 1), "plateSteel",
            "stickSteel", "plateSteel", "stickSteel"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeStructural", 1, 5), new Object[] {
            "stickAluminium", "plateAluminium", "stickAluminium",
            "plateAluminium", getModItem("JABBA", "barrel", 1), "plateAluminium",
            "stickAluminium", "plateAluminium", "stickAluminium"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeStructural", 1, 6), new Object[] {
            "stickStainlessSteel", "plateStainlessSteel", "stickStainlessSteel",
            "plateStainlessSteel", getModItem("JABBA", "barrel", 1), "plateStainlessSteel",
            "stickStainlessSteel", "plateStainlessSteel", "stickStainlessSteel"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeStructural", 1, 7), new Object[] {
            "stickTitanium", "plateTitanium", "stickTitanium",
            "plateTitanium", getModItem("JABBA", "barrel", 1), "plateTitanium",
            "stickTitanium", "plateTitanium", "stickTitanium"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeStructural", 1, 8), new Object[] {
            "stickTungstenSteel", "plateTungstenSteel", "stickTungstenSteel",
            "plateTungstenSteel", getModItem("JABBA", "barrel", 1), "plateTungstenSteel",
            "stickTungstenSteel", "plateTungstenSteel", "stickTungstenSteel"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeStructural", 1, 9), new Object[] {
            "stickChrome", "plateChrome", "stickChrome",
            "plateChrome", getModItem("JABBA", "barrel", 1), "plateChrome",
            "stickChrome", "plateChrome", "stickChrome"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeStructural", 1, 10), new Object[] {
            "stickIridium", "plateIridium", "stickIridium",
            "plateIridium", getModItem("JABBA", "barrel", 1), "plateIridium",
            "stickIridium", "plateIridium", "stickIridium"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeStructural", 1, 11), new Object[] {
            "stickOsmium", "plateOsmium", "stickOsmium",
            "plateOsmium", getModItem("JABBA", "barrel", 1), "plateOsmium",
            "stickOsmium", "plateOsmium", "stickOsmium"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeStructural", 1, 12), new Object[] {
            "stickNeutronium", "plateNeutronium", "stickNeutronium",
            "plateNeutronium", getModItem("JABBA", "barrel", 1), "plateNeutronium",
            "stickNeutronium", "plateNeutronium", "stickNeutronium"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeStructural", 1, 13), new Object[] {
            "stickBlackPlutonium", "plateBlackPlutonium", "stickBlackPlutonium",
            "plateBlackPlutonium", getModItem("JABBA", "barrel", 1), "plateBlackPlutonium",
            "stickBlackPlutonium", "plateBlackPlutonium", "stickBlackPlutonium"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeCore", 2, 1), new Object[] {
            "plateEnderEye",
            getModItem("minecraft", "piston", 1),
            "plateEnderEye",
            getModItem("minecraft", "piston", 1),
            getModItem("EnderStorage", "enderChest", 1),
            getModItem("minecraft", "piston", 1),
            "plateEnderEye",
            getModItem("minecraft", "piston", 1),
            "plateEnderEye"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeCore", 2, 1), new Object[] {
            "plateEnderEye",
            getModItem("minecraft", "sticky_piston", 1),
            "plateEnderEye",
            getModItem("minecraft", "piston", 1),
            getModItem("EnderStorage", "enderChest", 1),
            getModItem("minecraft", "piston", 1),
            "plateEnderEye",
            getModItem("minecraft", "sticky_piston", 1),
            "plateEnderEye"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeCore", 1, 2), new Object[] {
            "plateRedAlloy",
            getModItem("minecraft", "piston", 1),
            "plateRedAlloy",
            getModItem("minecraft", "piston", 1),
            getModItem("minecraft", "redstone_block", 1),
            getModItem("minecraft", "piston", 1),
            "plateRedAlloy",
            getModItem("minecraft", "piston", 1),
            "plateRedAlloy"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeCore", 1, 2), new Object[] {
            "plateRedAlloy",
            getModItem("minecraft", "sticky_piston", 1),
            "plateRedAlloy",
            getModItem("minecraft", "piston", 1),
            getModItem("minecraft", "redstone_block", 1),
            getModItem("minecraft", "piston", 1),
            "plateRedAlloy",
            getModItem("minecraft", "sticky_piston", 1),
            "plateRedAlloy"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeCore", 1, 3), new Object[] {
            "plateIron",
            getModItem("minecraft", "piston", 1),
            "plateIron",
            getModItem("minecraft", "piston", 1),
            getModItem("minecraft", "hopper", 1),
            getModItem("minecraft", "piston", 1),
            "plateIron",
            getModItem("minecraft", "piston", 1),
            "plateIron"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeCore", 1, 3), new Object[] {
            "plateIron",
            getModItem("minecraft", "sticky_piston", 1),
            "plateIron",
            getModItem("minecraft", "piston", 1),
            getModItem("minecraft", "hopper", 1),
            getModItem("minecraft", "piston", 1),
            "plateIron",
            getModItem("minecraft", "sticky_piston", 1),
            "plateIron"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeCore", 1, 7), new Object[] {
            "plateIron",
            getModItem("minecraft", "piston", 1),
            "plateIron",
            getModItem("minecraft", "piston", 1),
            getModItem("Railcraft", "machine.beta", 1, 11),
            getModItem("minecraft", "piston", 1),
            "plateIron",
            getModItem("minecraft", "piston", 1),
            "plateIron"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeCore", 1, 7), new Object[] {
            "plateIron",
            getModItem("minecraft", "sticky_piston", 1),
            "plateIron",
            getModItem("minecraft", "piston", 1),
            getModItem("Railcraft", "machine.beta", 1, 11),
            getModItem("minecraft", "piston", 1),
            "plateIron",
            getModItem("minecraft", "sticky_piston", 1),
            "plateIron"
        });

        addShapedRecipe(getModItem("JABBA", "upgradeCore", 1), new Object[] {
            "screwSteel",
            getModItem("minecraft", "piston", 1),
            "screwSteel",
            "screwSteel",
            getModItem("JABBA", "barrel", 1),
            "screwSteel",
            null,
            "craftingToolScrewdriver",
            null
        });

        addShapedRecipe(getModItem("JABBA", "upgradeCore", 1), new Object[] {
            "screwSteel",
            getModItem("minecraft", "sticky_piston", 1),
            "screwSteel",
            "screwSteel",
            getModItem("JABBA", "barrel", 1),
            "screwSteel",
            null,
            "craftingToolScrewdriver",
            null
        });
    }
}
