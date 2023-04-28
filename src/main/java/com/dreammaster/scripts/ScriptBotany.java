package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptBotany implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Botany";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.Botany.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessCraftingRecipe(
                getModItem("Botany", "database", 1, 0, missing),
                new Object[] { getModItem("Botany", "database", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Botany", "trowelWood", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), "craftingToolHardHammer",
                        null, "craftingToolFile", "stickWood", null, null, null, "stickWood" });
        addShapedRecipe(
                getModItem("Botany", "trowelStone", 1, 0, missing),
                new Object[] { "plateStone", "craftingToolHardHammer", null, "craftingToolFile", "stickWood", null,
                        null, null, "stickWood" });
        addShapedRecipe(
                getModItem("Botany", "trowelIron", 1, 0, missing),
                new Object[] { "plateIron", "craftingToolHardHammer", null, "craftingToolFile", "stickWood", null, null,
                        null, "stickWood" });
        addShapedRecipe(
                getModItem("Botany", "trowelGold", 1, 0, missing),
                new Object[] { "plateGold", "craftingToolHardHammer", null, "craftingToolFile", "stickWood", null, null,
                        null, "stickWood" });
        addShapedRecipe(
                getModItem("Botany", "trowelDiamond", 1, 0, missing),
                new Object[] { "plateDiamond", "craftingToolHardHammer", null, "craftingToolFile", "stickWood", null,
                        null, null, "stickWood" });
        addShapelessCraftingRecipe(
                getModItem("Botany", "misc", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 1815, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 1815, missing),
                new Object[] { getModItem("Botany", "misc", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Botany", "misc", 1, 1, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 1809, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 1809, missing),
                new Object[] { getModItem("Botany", "misc", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("Botany", "misc", 1, 3, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 1022, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 1022, missing),
                new Object[] { getModItem("Botany", "misc", 1, 3, missing) });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "clay", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 0, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "cobblestone", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 0, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 128, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "sand", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 0, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 256, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "hardened_clay", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 0, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 384, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stone", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 0, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 512, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "sandstone", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 0, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 640, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "clay", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 1, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "cobblestone", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 1, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 129, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "sand", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 1, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 257, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "hardened_clay", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 1, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 385, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stone", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 1, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 513, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "sandstone", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 1, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 641, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "clay", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 2, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "cobblestone", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 2, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 130, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "sand", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 2, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 258, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "hardened_clay", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 2, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 386, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stone", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 2, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 514, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "sandstone", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 2, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 642, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "clay", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 3, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "cobblestone", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 3, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 131, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "sand", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 3, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 259, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "hardened_clay", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 3, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 387, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stone", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 3, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 515, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "sandstone", 4, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 3, missing))
                .itemOutputs(getModItem("Botany", "insulatedTube", 1, 643, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 288)).noFluidOutputs().duration(800).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 23305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17086, missing))
                .itemOutputs(getModItem("Botany", "soilMeter", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(1200)
                .eut(64).addTo(sAssemblerRecipes);

    }
}
