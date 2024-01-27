package com.dreammaster.mantle;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

import java.util.function.Consumer;

import net.minecraft.item.ItemStack;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dreammaster.recipes.Recipe;

import mantle.lib.client.MantleClientRegistry;

@ExtendWith(MockitoExtension.class)
class MantleClientRegistryProxyTest {

    @Mock
    Recipe RECIPE;

    @Mock
    ItemStack ITEMSTACK;

    private static final String RECIPE_NAME = "RecipeName";
    private MantleClientRegistryProxy fixture;
    private MockedStatic<MantleClientRegistry> mantleRegistry;

    @BeforeEach
    void beforeEach() {
        fixture = new MantleClientRegistryProxy();
        mantleRegistry = mockStatic(MantleClientRegistry.class);
    }

    @AfterEach
    void afterEach() {
        mantleRegistry.close();
    }

    @Test
    void registerCraftingRecipeWithNullName() {
        MantleClientRegistryProxy mantleClientRegistryProxy = new MantleClientRegistryProxy();

        assertThatThrownBy(() -> mantleClientRegistryProxy.manualShapedCraftingRecipeNamed(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void registerSmeltingRecipeWithNullName() {
        MantleClientRegistryProxy mantleClientRegistryProxy = new MantleClientRegistryProxy();

        assertThatThrownBy(() -> mantleClientRegistryProxy.manualSmeltingRecipeNamed(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void craftingRecipeUnder4Ingredients() {
        ItemStack[] expectedIngredients = { ITEMSTACK, null, null, null };

        registerIngredients(ITEMSTACK, new ItemStack[] { ITEMSTACK });

        mantleRegistry.verify(
                () -> MantleClientRegistry.registerManualSmallRecipe(RECIPE_NAME, ITEMSTACK, expectedIngredients));
        mantleRegistry.verify(() -> MantleClientRegistry.registerManualLargeRecipe(any(), any(), any()), never());
        mantleRegistry.verify(() -> MantleClientRegistry.registerManualFurnaceRecipe(any(), any(), any()), never());
    }

    private void registerIngredients(ItemStack result, ItemStack[] ingredients) {
        when(RECIPE.getResult()).thenReturn(result);
        when(RECIPE.flattenWith(notNull())).thenReturn(ingredients);
        Consumer<Recipe> registry = fixture.manualShapedCraftingRecipeNamed(RECIPE_NAME);

        registry.accept(RECIPE);
    }

    @Test
    void craftingRecipeExactly4Ingredients() {
        ItemStack[] expectedIngredients = { ITEMSTACK, null, null, ITEMSTACK };

        registerIngredients(ITEMSTACK, new ItemStack[] { ITEMSTACK, null, null, ITEMSTACK });

        mantleRegistry.verify(
                () -> MantleClientRegistry.registerManualSmallRecipe(RECIPE_NAME, ITEMSTACK, expectedIngredients));
        mantleRegistry.verify(() -> MantleClientRegistry.registerManualLargeRecipe(any(), any(), any()), never());
        mantleRegistry.verify(() -> MantleClientRegistry.registerManualFurnaceRecipe(any(), any(), any()), never());
    }

    @Test
    void craftingRecipeOver4Ingredients() {
        ItemStack[] expectedIngredients = { ITEMSTACK, null, null, ITEMSTACK, null, null, null, null, null };

        registerIngredients(ITEMSTACK, new ItemStack[] { ITEMSTACK, null, null, ITEMSTACK, null });

        mantleRegistry.verify(() -> MantleClientRegistry.registerManualSmallRecipe(any(), any(), any()), never());
        mantleRegistry.verify(
                () -> MantleClientRegistry.registerManualLargeRecipe(RECIPE_NAME, ITEMSTACK, expectedIngredients));
        mantleRegistry.verify(() -> MantleClientRegistry.registerManualFurnaceRecipe(any(), any(), any()), never());
    }

    @Test
    void craftingRecipeExactly9Ingredients() {
        ItemStack[] expectedIngredients = { ITEMSTACK, null, null, ITEMSTACK, null, null, null, null, ITEMSTACK };

        registerIngredients(
                ITEMSTACK,
                new ItemStack[] { ITEMSTACK, null, null, ITEMSTACK, null, null, null, null, ITEMSTACK });

        mantleRegistry.verify(() -> MantleClientRegistry.registerManualSmallRecipe(any(), any(), any()), never());
        mantleRegistry.verify(
                () -> MantleClientRegistry.registerManualLargeRecipe(RECIPE_NAME, ITEMSTACK, expectedIngredients));
        mantleRegistry.verify(() -> MantleClientRegistry.registerManualFurnaceRecipe(any(), any(), any()), never());
    }

    @Test
    void craftingRecipeOver9Ingredients() {
        ItemStack[] ingredients = { ITEMSTACK, null, null, ITEMSTACK, null, null, null, null, ITEMSTACK, ITEMSTACK };

        ThrowableAssert.ThrowingCallable code = () -> registerIngredients(ITEMSTACK, ingredients);

        assertThatThrownBy(code).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void addSmeltingRecipe() {
        ItemStack[] ingredients = { ITEMSTACK, ITEMSTACK };
        ItemStack expectedIngredient = ITEMSTACK;

        MantleClientRegistryProxy mantleClientRegistryProxy = new MantleClientRegistryProxy();
        Consumer<Recipe> registry = mantleClientRegistryProxy.manualSmeltingRecipeNamed(RECIPE_NAME);
        when(RECIPE.getResult()).thenReturn(ITEMSTACK);
        when(RECIPE.flatten()).thenReturn(ingredients);

        registry.accept(RECIPE);

        mantleRegistry.verify(() -> MantleClientRegistry.registerManualSmallRecipe(any(), any(), any()), never());
        mantleRegistry.verify(() -> MantleClientRegistry.registerManualLargeRecipe(any(), any(), any()), never());
        mantleRegistry.verify(
                () -> MantleClientRegistry.registerManualFurnaceRecipe(RECIPE_NAME, ITEMSTACK, expectedIngredient));
    }
}
