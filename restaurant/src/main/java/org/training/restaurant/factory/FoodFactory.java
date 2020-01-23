package org.training.restaurant.factory;

import org.training.restaurant.entity.food.Products;

import java.util.List;

import static org.training.restaurant.constant.RestaurantConstants.*;

public class FoodFactory {


    public FoodFactory() {

    }

    public String checkEffect(List<Products> orderList) {
        boolean mustard = false;
        String productEffects = "";
        String extraEffects = "";
        for (Products o : orderList) {

            switch (o.name()) {
                case KETCHUP:
                    productEffects.concat("+1");
                    break;
                case MUSTARD:
                    productEffects.concat("*2");
                    mustard = true;
                    break;
                case HOT_DOG:
                    productEffects.concat("+5%");
                    break;
                case CHIPS:
                    productEffects.concat("+2");
                    break;
            }
        }
        if (mustard) {
            productEffects = "";
        }
        return productEffects.concat(extraEffects);
    }
}

