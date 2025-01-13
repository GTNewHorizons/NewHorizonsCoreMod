package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.EtFuturumRequiem;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import com.dreammaster.recipes.CustomItem;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;

public class ScriptEFR implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Et Futurum Requiem";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(EtFuturumRequiem.ID, ExtraUtilities.ID, Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {
        long bits = GTModHandler.RecipeBits.NOT_REMOVABLE | GTModHandler.RecipeBits.REVERSIBLE
                | GTModHandler.RecipeBits.BUFFERED;
        GTModHandler.addCraftingRecipe(
                GTModHandler.getModItem(EtFuturumRequiem.ID, "observer", 1L),
                bits,
                new Object[] { "AEA", "BCD", "AAA", 'A', "cobblestone", 'B', "dustRedstone", 'C',
                        GTModHandler.getModItem(ExtraUtilities.ID, "budoff", 1, 0), 'D',
                        GTModHandler.getModItem(Minecraft.ID, "comparator", 1, 0), 'E', "gearGtSmallAnyIron" });

        GTModHandler.addCraftingRecipe(
                GTModHandler.getModItem(EtFuturumRequiem.ID, "cherry_trapdoor", 1L),
                bits,
                new Object[] { "ABA", "BCB", "ABA", 'A',
                        GTModHandler.getModItem(EtFuturumRequiem.ID, "wood_slab", 1L, 3), 'B', "stickWood", 'C',
                        "itemFlint" });

        GTModHandler.addCraftingRecipe(
                GTModHandler.getModItem(EtFuturumRequiem.ID, "cherry_trapdoor", 2L),
                bits,
                new Object[] { "ABA", "BCB", "ABA", 'A',
                        GTModHandler.getModItem(EtFuturumRequiem.ID, "wood_slab", 1L, 3), 'B', "stickWood", 'C',
                        "screwIron" });

        GTModHandler.addCraftingRecipe(
                GTModHandler.getModItem(EtFuturumRequiem.ID, "cherry_trapdoor", 3L),
                bits,
                new Object[] { "ABA", "BCB", "ABA", 'A',
                        GTModHandler.getModItem(EtFuturumRequiem.ID, "wood_slab", 1L, 3), 'B', "stickWood", 'C',
                        "screwSteel" });
        for (int i = 0; i < 16; i++) {
            addShapelessRecipe(
                    GTModHandler.getModItem(EtFuturumRequiem.ID, "banner", 1L, i),
                    new CustomItem.NBTItem(getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 8))
                            .setNBT("{color:" + i + "b}"));
            addShapelessRecipe(
                    createItemStack(Thaumcraft.ID, "blockWoodenDevice", 1, 8, "{color:" + i + "b}", missing),
                    GTModHandler.getModItem(EtFuturumRequiem.ID, "banner", 1L, i));
        }

        GTModHandler.addCraftingRecipe(
                getModItem(EtFuturumRequiem.ID, "barrel", 1, 0, missing),
                bits,
                new Object[] { "hPs", "PCP", " P ", 'P', GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                        'C', "chestWood" });
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 2L))
                .itemOutputs(getModItem(EtFuturumRequiem.ID, "barrel", 1L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);

        GTModHandler.addCraftingRecipe(
                getModItem(EtFuturumRequiem.ID, "lantern", 1, 0, missing),
                bits,
                new Object[] { "IGI", "PCP", "III", 'I', "plateIron", 'G', "dustGlowstone", 'P', "paneGlassColorless",
                        'C', getModItem(PamsHarvestCraft.ID, "pamcandleDeco1", 1, 0, missing) });

        GTModHandler.addCraftingRecipe(
                getModItem(EtFuturumRequiem.ID, "blast_furnace", 1, 0, missing),
                bits,
                new Object[] { "PPP", "PFP", "SSS", 'S', getModItem(Minecraft.ID, "stone", 1, 0, missing), 'F',
                        getModItem(Minecraft.ID, "furnace", 1, 0, missing), 'P', "plateIron" });
        GTModHandler.addCraftingRecipe(
                getModItem(Minecraft.ID, "leather", 1, 0, missing),
                bits,
                new Object[] { "SSS", "HHH", "SSS", 'S', getModItem(Minecraft.ID, "string", 1, 0, missing), 'H',
                        getModItem(EtFuturumRequiem.ID, "rabbit_hide", 1, 0, missing) });
    }
}
