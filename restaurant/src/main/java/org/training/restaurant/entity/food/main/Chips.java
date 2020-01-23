package org.training.restaurant.entity.food.main;

import org.training.restaurant.entity.food.Products;

import static org.training.restaurant.constant.RestaurantConstants.CHIPS;

public class Chips implements Products {


    private final String name;

    public Chips(){
        this.name = CHIPS;
    }

    @Override
    public String name() {
        return CHIPS;
    }

    @Override
    public String effect() {
        return CHIPS;
//        Chips increases client happiness by 5%
    }
}
