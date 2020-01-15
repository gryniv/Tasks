package org.training.restaurant.restaurant;

import org.training.restaurant.restaurant.food.extra.ExtraProducts;
import org.training.restaurant.restaurant.food.main.MainProducts;

import java.util.ArrayList;

public class Restaurant {

    ExtraProducts extraProducts = new ExtraProducts();
    MainProducts mainProducts = new MainProducts();

    public ArrayList<Object> getMenu() {
        return new ArrayList<Object>(mainProducts.getAll());
    }

}
