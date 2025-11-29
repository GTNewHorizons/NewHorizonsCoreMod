package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.enums.Mods.IronTanksMinecarts;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.indemnity83.irontank.reference.TankType;

import gregtech.api.enums.GTValues;

public class ScriptIronTankMinecarts implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Iron Tank Minecarts";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Railcraft.ID, IronTanks.ID, IronTanksMinecarts.ID);
    }

    @Override
    public void loadRecipes() {
        for (TankType type : TankType.values()) {
            if (type == TankType.GLASS) {
                continue;
            }
            ItemStack tank = getModItem(IronTanks.ID, type.name, 1, 0, missing);
            ItemStack cart = getModItem(
                    IronTanksMinecarts.ID,
                    "minecart_tank_" + secondderivative.irontankminecarts.IronTankMinecarts.tankTypeName(type),
                    1,
                    0,
                    missing);
            addShapedRecipe(
                    cart,
                    "craftingToolHardHammer",
                    tank,
                    "craftingToolWrench",
                    null,
                    getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                    null,
                    null,
                    "craftingToolScrewdriver",
                    null);
            GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "minecart", 1, 0, missing), tank).circuit(1)
                    .itemOutputs(cart).duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);
        }
    }
}
