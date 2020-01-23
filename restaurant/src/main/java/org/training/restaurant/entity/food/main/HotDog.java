package org.training.restaurant.entity.food.main;

import org.training.restaurant.entity.food.Products;

import static org.training.restaurant.constant.RestaurantConstants.HOT_DOG;

public class HotDog implements Products {

    private final String name;

    public HotDog(){
        this.name = HOT_DOG;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String effect() {
        return HOT_DOG;
//        Hot dog increases client happiness by 2
    }
}
