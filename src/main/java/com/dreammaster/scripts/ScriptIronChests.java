package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptIronChests implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Iron Chests";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.IronChests.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("ironchestminecarts", "minecart_chest_copper", 1, 0, missing),
                new Object[] { null, "craftingToolScrewdriver", null, "screwCopper",
                        getModItem("IronChest", "BlockIronChest", 1, 3, missing), "screwCopper", "screwCopper",
                        getModItem("minecraft", "minecart", 1, 0, missing), "screwCopper" });
        addShapedRecipe(
                getModItem("ironchestminecarts", "minecart_chest_iron", 1, 0, missing),
                new Object[] { null, "craftingToolScrewdriver", null, "screwAnyIron",
                        getModItem("IronChest", "BlockIronChest", 1, 0, missing), "screwAnyIron", "screwAnyIron",
                        getModItem("minecraft", "minecart", 1, 0, missing), "screwAnyIron" });
        addShapedRecipe(
                getModItem("ironchestminecarts", "minecart_chest_steel", 1, 0, missing),
                new Object[] { null, "craftingToolScrewdriver", null, "screwSteel",
                        getModItem("IronChest", "BlockIronChest", 1, 4, missing), "screwSteel", "screwSteel",
                        getModItem("minecraft", "minecart", 1, 0, missing), "screwSteel" });
        addShapedRecipe(
                getModItem("ironchestminecarts", "minecart_chest_gold", 1, 0, missing),
                new Object[] { null, "craftingToolScrewdriver", null, "screwGold",
                        getModItem("IronChest", "BlockIronChest", 1, 1, missing), "screwGold", "screwGold",
                        getModItem("minecraft", "minecart", 1, 0, missing), "screwGold" });
        addShapedRecipe(
                getModItem("ironchestminecarts", "minecart_chest_diamond", 1, 0, missing),
                new Object[] { null, "craftingToolScrewdriver", null,
                        getModItem("gregtech", "gt.metaitem.01", 1, 27500, missing),
                        getModItem("IronChest", "BlockIronChest", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27500, missing),
                        getModItem("minecraft", "minecart", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27500, missing) });
        addShapedRecipe(
                getModItem("ironchestminecarts", "minecart_chest_crystal", 1, 0, missing),
                new Object[] { null, "craftingToolScrewdriver", null,
                        getModItem("gregtech", "gt.metaitem.01", 1, 27890, missing),
                        getModItem("IronChest", "BlockIronChest", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27890, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27890, missing),
                        getModItem("minecraft", "minecart", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27890, missing) });
        addShapedRecipe(
                getModItem("IronChest", "BlockIronChest", 1, 7, missing),
                new Object[] { getModItem("minecraft", "dirt", 1, 0, missing),
                        getModItem("minecraft", "dirt", 1, 0, missing), getModItem("minecraft", "dirt", 1, 0, missing),
                        getModItem("minecraft", "dirt", 1, 0, missing), getModItem("minecraft", "chest", 1, 0, missing),
                        getModItem("minecraft", "dirt", 1, 0, missing), getModItem("minecraft", "dirt", 1, 0, missing),
                        getModItem("minecraft", "dirt", 1, 0, missing),
                        getModItem("minecraft", "dirt", 1, 0, missing) });
        addShapedRecipe(
                getModItem("IronChest", "BlockIronChest", 1, 3, missing),
                new Object[] { "screwCopper", getModItem("gregtech", "gt.metaitem.01", 1, 18035, missing),
                        "screwCopper", getModItem("gregtech", "gt.metaitem.01", 1, 18035, missing),
                        getModItem("minecraft", "chest", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 18035, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 18035, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing),
                new Object[] { "screwCopper", getModItem("gregtech", "gt.metaitem.01", 1, 18035, missing),
                        "screwCopper", getModItem("gregtech", "gt.metaitem.01", 1, 18035, missing), "plankWood",
                        getModItem("gregtech", "gt.metaitem.01", 1, 18035, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 18035, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IronChest", "BlockIronChest", 1, 0, missing),
                new Object[] { "screwIron", getModItem("gregtech", "gt.metaitem.01", 1, 18032, missing), "screwIron",
                        getModItem("gregtech", "gt.metaitem.01", 1, 18032, missing),
                        getModItem("minecraft", "chest", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 18032, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 18032, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IronChest", "woodIronUpgrade", 1, 0, missing),
                new Object[] { "screwIron", getModItem("gregtech", "gt.metaitem.01", 1, 18032, missing), "screwIron",
                        getModItem("gregtech", "gt.metaitem.01", 1, 18032, missing), "plankWood",
                        getModItem("gregtech", "gt.metaitem.01", 1, 18032, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 18032, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IronChest", "copperIronUpgrade", 1, 0, missing),
                new Object[] { "screwIron", getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing), "screwIron",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IronChest", "BlockIronChest", 1, 4, missing),
                new Object[] { "screwSteel", getModItem("gregtech", "gt.metaitem.01", 1, 18305, missing), "screwSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 18305, missing),
                        getModItem("minecraft", "chest", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 18305, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 18305, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IronChest", "copperSteelUpgrade", 1, 0, missing),
                new Object[] { "screwSteel", getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing), "screwSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IronChest", "BlockIronChest", 1, 1, missing),
                new Object[] { "screwGold", getModItem("gregtech", "gt.metaitem.01", 1, 18086, missing), "screwGold",
                        getModItem("gregtech", "gt.metaitem.01", 1, 18086, missing),
                        getModItem("minecraft", "chest", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 18086, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 18086, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IronChest", "ironGoldUpgrade", 1, 0, missing),
                new Object[] { "screwGold", getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing), "screwGold",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IronChest", "steelGoldUpgrade", 1, 0, missing),
                new Object[] { "screwGold", getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing), "screwGold",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IronChest", "BlockIronChest", 1, 2, missing),
                new Object[] { "screwDiamond", getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        "screwDiamond", getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("minecraft", "chest", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IronChest", "goldDiamondUpgrade", 1, 0, missing),
                new Object[] { "screwDiamond", getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        "screwDiamond", null, getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing), null,
                        "craftingToolHardHammer", getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IronChest", "BlockIronChest", 1, 5, missing),
                new Object[] { "screwGlass", getModItem("gregtech", "gt.metaitem.01", 1, 17890, missing), "screwGlass",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17890, missing),
                        getModItem("IronChest", "BlockIronChest", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17890, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17890, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IronChest", "diamondCrystalUpgrade", 1, 0, missing),
                new Object[] { "screwGlass", getModItem("gregtech", "gt.metaitem.01", 1, 17890, missing), "screwGlass",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17890, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17890, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17890, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IronChest", "BlockIronChest", 1, 6, missing),
                new Object[] { "screwDiamond", getModItem("IC2", "itemDensePlates", 1, 7, missing), "screwDiamond",
                        getModItem("IC2", "itemDensePlates", 1, 7, missing),
                        getModItem("IronChest", "BlockIronChest", 1, 2, missing),
                        getModItem("IC2", "itemDensePlates", 1, 7, missing), "craftingToolHardHammer",
                        getModItem("IC2", "itemDensePlates", 1, 7, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IronChest", "diamondObsidianUpgrade", 1, 0, missing),
                new Object[] { "screwDiamond", getModItem("IC2", "itemDensePlates", 1, 7, missing), "screwDiamond",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17804, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17804, missing), "craftingToolHardHammer",
                        getModItem("IC2", "itemDensePlates", 1, 7, missing), "craftingToolScrewdriver" });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "chest", 1, 0, missing),
                        getModItem("minecraft", "dirt", 8, 0, missing))
                .itemOutputs(getModItem("IronChest", "BlockIronChest", 1, 7, missing)).noFluidInputs().noFluidOutputs()
                .duration(80).eut(1).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "chest", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing))
                .itemOutputs(getModItem("IronChest", "BlockIronChest", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "planks", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 10, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 11, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 12, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 13, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 14, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 15, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftAmunRa", "tile.wood1", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftAmunRa", "tile.wood1", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Thaumcraft", "blockWoodenDevice", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "planks", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "planks", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "planksFireproof", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 0, "{meta:0}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 1, "{meta:1}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 2, "{meta:2}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 3, "{meta:3}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 4, "{meta:4}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 5, "{meta:5}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 6, "{meta:6}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 7, "{meta:7}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 8, "{meta:8}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 9, "{meta:9}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 10, "{meta:10}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 11, "{meta:11}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 12, "{meta:12}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 13, "{meta:13}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 14, "{meta:14}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 15, "{meta:15}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 16, "{meta:16}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 17, "{meta:17}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 18, "{meta:18}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 19, "{meta:19}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 20, "{meta:20}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 21, "{meta:21}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 22, "{meta:22}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 23, "{meta:23}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 24, "{meta:24}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 25, "{meta:25}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 26, "{meta:26}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 27, "{meta:27}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 28, "{meta:28}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 29, "{meta:29}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 30, "{meta:30}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 31, "{meta:31}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 32, "{meta:32}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 33, "{meta:33}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 34, "{meta:34}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("thaumicbases", "enderPlanks", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("witchery", "witchwood", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalaxySpace", "barnardaCplanks", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TaintedMagic", "BlockWarpwoodPlanks", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestthenether", "netherPlanks", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TwilightForest", "tile.TFTowerStone", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TwilightForest", "tile.TFPlank", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ForbiddenMagic", "TaintPlank", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18035, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodCopperUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "chest", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing))
                .itemOutputs(getModItem("IronChest", "BlockIronChest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(150).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "planks", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 10, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 11, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 12, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 13, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 14, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "colorWoodPlanks", 1, 15, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftAmunRa", "tile.wood1", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftAmunRa", "tile.wood1", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Thaumcraft", "blockWoodenDevice", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "planks", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "planks", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "planksFireproof", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 0, "{meta:0}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 1, "{meta:1}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 2, "{meta:2}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 3, "{meta:3}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 4, "{meta:4}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 5, "{meta:5}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 6, "{meta:6}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 7, "{meta:7}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 8, "{meta:8}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 9, "{meta:9}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 10, "{meta:10}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 11, "{meta:11}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 12, "{meta:12}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 13, "{meta:13}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 14, "{meta:14}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 15, "{meta:15}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 16, "{meta:16}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 17, "{meta:17}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 18, "{meta:18}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 19, "{meta:19}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 20, "{meta:20}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 21, "{meta:21}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 22, "{meta:22}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 23, "{meta:23}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 24, "{meta:24}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 25, "{meta:25}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 26, "{meta:26}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 27, "{meta:27}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 28, "{meta:28}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 29, "{meta:29}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 30, "{meta:30}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 31, "{meta:31}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 32, "{meta:32}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 33, "{meta:33}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "planks", 1, 34, "{meta:34}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("thaumicbases", "enderPlanks", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("witchery", "witchwood", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalaxySpace", "barnardaCplanks", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TaintedMagic", "BlockWarpwoodPlanks", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestthenether", "netherPlanks", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TwilightForest", "tile.TFTowerStone", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TwilightForest", "tile.TFPlank", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ForbiddenMagic", "TaintPlank", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "woodIronUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 18032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "copperIronUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "chest", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18305, missing))
                .itemOutputs(getModItem("IronChest", "BlockIronChest", 1, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 18305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "copperSteelUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "chest", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 18086, missing))
                .itemOutputs(getModItem("IronChest", "BlockIronChest", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(250).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 18086, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "ironGoldUpgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(500).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 18086, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "steelGoldUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(500).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "chest", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17500, missing))
                .itemOutputs(getModItem("IronChest", "BlockIronChest", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17500, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "goldDiamondUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IronChest", "BlockIronChest", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17890, missing))
                .itemOutputs(getModItem("IronChest", "BlockIronChest", 1, 5, missing)).noFluidInputs().noFluidOutputs()
                .duration(350).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17890, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "diamondCrystalUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(700).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IronChest", "BlockIronChest", 1, 2, missing),
                        getModItem("IC2", "itemDensePlates", 3, 7, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "BlockIronChest", 1, 6, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("IC2", "itemDensePlates", 1, 7, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("IronChest", "diamondObsidianUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(800).eut(256).addTo(sAssemblerRecipes);

    }
}
