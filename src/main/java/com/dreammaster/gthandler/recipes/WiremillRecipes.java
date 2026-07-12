package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.recipe.RecipeMaps.wiremillRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.util.GTRecipeRegistrator;

public class WiremillRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.MeteoricIron, Materials2Shapes.stickLong, (int) (1L)))
                .itemOutputs(NHItemList.MeteoricIronString.get(4)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(wiremillRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Tungsten, Materials2Shapes.stickLong, (int) (1L)))
                .itemOutputs(NHItemList.TungstenString.get(4)).duration(60 * SECONDS).eut(TierEU.RECIPE_EV / 2)
                .addTo(wiremillRecipes);

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.BorosilicateGlass, Materials2Shapes.ingot, (int) (1)))
                .circuit(3).itemOutputs(ItemList.Circuit_Parts_GlassFiber.get(8L)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(wiremillRecipes);

        GTRecipeRegistrator.registerWiremillRecipes(Materials.NetherStar, 200, 4);

        if (Natura.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "barleyFood", 2, 3))
                    .itemOutputs(new ItemStack(Items.string, 1, 0)).duration(10 * SECONDS).eut(TierEU.RECIPE_ULV)
                    .addTo(wiremillRecipes);
        }
    }
}
