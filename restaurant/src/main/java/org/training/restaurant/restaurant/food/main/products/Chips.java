package org.training.restaurant.restaurant.food.main.products;

import org.training.restaurant.restaurant.food.main.Products;

public class Chips implements Products {

    @Override
    public String name() {
        return "Chips";
    }

    @Override
    public String product() {
        return "Chips";
//        Chips increases client happiness by 5%
    }
}
