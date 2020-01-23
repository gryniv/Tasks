package org.training.restaurant.entity.food.extra;

import org.training.restaurant.entity.food.Products;

import static org.training.restaurant.constant.RestaurantConstants.KETCHUP;

public class Ketchup implements Products{

    private final String name;

    public Ketchup(){
        this.name = KETCHUP;
    }

    @Override
    public String name() {
        return KETCHUP;
    }

    @Override
    public String effect() {
        return KETCHUP;
//        Ketchup doubles the effect of a product
    }
}
