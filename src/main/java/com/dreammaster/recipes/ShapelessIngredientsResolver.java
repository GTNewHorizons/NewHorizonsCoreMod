package com.dreammaster.recipes;

import static com.dreammaster.recipes.ShapedUniversalRecipe.MISSING;

import java.util.function.UnaryOperator;

public class ShapelessIngredientsResolver implements UnaryOperator<Object[]> {

    @Override
    public Object[] apply(Object[] ingredients) {
        return new ShapelessUniversalRecipe(MISSING, ingredients).getInput().toArray();
    }
}
