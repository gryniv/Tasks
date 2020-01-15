package org.training.restaurant.restaurant.food.extra.products;

import org.training.restaurant.restaurant.food.extra.Extra;

public class Ketchup implements Extra {

    @Override
    public String effect() {
        return "Ketchup";
//        Ketchup doubles the effect of a product
    }
}
