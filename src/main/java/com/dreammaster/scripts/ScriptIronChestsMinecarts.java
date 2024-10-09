package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.IronChestsMinecarts;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GTValues;

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
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 3, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_copper", 1, 0, missing))
                .duration(5 * SECONDS).eut(2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 0, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_iron", 1, 0, missing))
                .duration(6 * SECONDS).eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 4, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_steel", 1, 0, missing))
                .duration(7 * SECONDS).eut(8).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 1, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_gold", 1, 0, missing))
                .duration(8 * SECONDS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 2, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_diamond", 1, 0, missing))
                .duration(9 * SECONDS).eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 5, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_crystal", 1, 0, missing))
                .duration(10 * SECONDS).eut(64).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 6, missing),
                        getModItem(Minecraft.ID, "minecart", 1, 0, missing))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_obsidian", 1, 0, missing))
                .duration(10 * SECONDS).eut(64).addTo(assemblerRecipes);

    }
}
