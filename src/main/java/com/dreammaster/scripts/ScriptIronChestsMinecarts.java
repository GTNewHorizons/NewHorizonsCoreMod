package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.IronChestsMinecarts;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.TierEU;

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
                        getModItem(IronChests.ID, "BlockIronChest", 1, 3),
                        getModItem(Minecraft.ID, "minecart", 1, 0))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_copper", 1, 0)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 0),
                        getModItem(Minecraft.ID, "minecart", 1, 0))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_iron", 1, 0)).duration(6 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 4),
                        getModItem(Minecraft.ID, "minecart", 1, 0))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_steel", 1, 0)).duration(7 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 1),
                        getModItem(Minecraft.ID, "minecart", 1, 0))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_gold", 1, 0)).duration(8 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 2),
                        getModItem(Minecraft.ID, "minecart", 1, 0))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_diamond", 1, 0)).duration(9 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 5),
                        getModItem(Minecraft.ID, "minecart", 1, 0))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_crystal", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 6),
                        getModItem(Minecraft.ID, "minecart", 1, 0))
                .itemOutputs(getModItem(IronChestsMinecarts.ID, "minecart_chest_obsidian", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);

    }
}
