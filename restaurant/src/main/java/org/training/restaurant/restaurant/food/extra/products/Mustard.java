package org.training.restaurant.restaurant.food.extra.products;

import org.training.restaurant.restaurant.food.extra.Extra;

public class Mustard implements Extra {
    @Override
    public String effect() {
        return "Mustard";
//        Mustard increases client happiness by 1 and removes the effect of the product
    }
}
