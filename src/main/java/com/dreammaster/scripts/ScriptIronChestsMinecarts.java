package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.IronChestsMinecarts;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GT_Values;

public class ScriptIronChestsMinecarts implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Iron Chests Minecarts";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(IronChestsMinecarts.ID, IronChests.ID);
    }

    @Override
    public void loadRecipes() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 3, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_copper", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 0, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_iron", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(120).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 4, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_steel", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(140).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 1, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_gold", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(160).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 2, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_diamond", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(180).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 5, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_crystal", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 6, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_obsidian", 1, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);

    }
}
