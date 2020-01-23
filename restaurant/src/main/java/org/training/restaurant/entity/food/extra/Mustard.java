package org.training.restaurant.entity.food.extra;

import org.training.restaurant.entity.food.Products;

import static org.training.restaurant.constant.RestaurantConstants.MUSTARD;

public class Mustard implements Products{

    private final String name;

    public Mustard(){
        this.name = MUSTARD;
    }

    @Override
    public String name() {
        return MUSTARD;
    }

    @Override
    public String effect() {
        return MUSTARD;
//        Mustard increases client happiness by 1 and removes the effect of the product
    }
}
