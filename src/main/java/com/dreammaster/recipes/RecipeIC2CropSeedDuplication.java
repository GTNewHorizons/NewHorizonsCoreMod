package com.dreammaster.recipes;

import gregtech.api.util.GTUtility;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.recipe.RecipeManaInfusion;

import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.util.GTModHandler.getModItem;

public class RecipeIC2CropSeedDuplication extends RecipeManaInfusion {
    private static final ThreadLocal<ItemStack> currentOutput = new ThreadLocal<>();

    // 10 mins per stack of seeds with 2048 mana/s
    // also conveniently don't fit in a diluted pool
    public static final int MANA_COST = 19200;
    private static boolean registered = false;

    public RecipeIC2CropSeedDuplication() {
        super(getOutputDisplay(), getModItem(IndustrialCraft2.ID, "itemCropSeed", 1, OreDictionary.WILDCARD_VALUE), MANA_COST);
        setConjuration(true);
    }

    @Override
    public boolean matches(ItemStack stack) {
        if (!super.matches(stack)) {
            return false;
        } else {
            currentOutput.set(GTUtility.copyAmount(2, stack));
            return true;
        }
    }

    @Override
    public ItemStack getOutput() {
        ItemStack output = currentOutput.get();
        if (output == null) {
            return super.getOutput();
        }
        currentOutput.remove();
        return output;
    }

    private static ItemStack getOutputDisplay() {
        ItemStack seed = getModItem(IndustrialCraft2.ID, "itemCropSeed", 2);
        seed.setStackDisplayName("Same type and stat as input");
        return seed;
    }

    public static void register() {
        if (registered) return;
        BotaniaAPI.manaInfusionRecipes.add(new RecipeIC2CropSeedDuplication());
        registered = true;
    }
}
