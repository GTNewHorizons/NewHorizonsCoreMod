package com.dreammaster.recipes;

import java.util.function.UnaryOperator;

public class ShapedIngredientsResolver implements UnaryOperator<Object[]> {

    @Override
    public Object[] apply(Object[] ingredients) {
        return new ShapedUniversalRecipe(ShapedUniversalRecipe.MISSING, ingredients).getInput();
    }
}
