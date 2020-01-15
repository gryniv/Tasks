package org.training.restaurant.restaurant.food.main.products;

import org.training.restaurant.restaurant.food.main.Products;

public class HotDog implements Products {

    @Override
    public String name() {
        return "HotDog";
    }

    @Override
    public String product() {
        return "HotDog";
//        Hot dog increases client happiness by 2
    }
}
