package org.training.restaurant.customer;

import org.training.restaurant.entity.food.Products;
import org.training.restaurant.entity.food.extra.Ketchup;
import org.training.restaurant.entity.food.extra.Mustard;
import org.training.restaurant.entity.food.main.Chips;
import org.training.restaurant.entity.food.main.HotDog;
import org.training.restaurant.factory.FoodFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.training.restaurant.constant.RestaurantConstants.*;

public class Client implements Customer {
    private final String name;
    private final List<Products> orderList = new ArrayList<>();
    private final FoodFactory foodFactory = new FoodFactory();
    private int random = new Random().nextInt(100);
    private int happiness = random;


    public Client(String name, String[] order) {
        this.name = name;
        createOrder(order);
    }

    @Override
    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    @Override
    public String getName() {
        return name;
    }
    public List<Products> createOrder(String[] order) {
        for (String position : order) {
            switch (position) {
                case HOT_DOG:
                    orderList.add(new HotDog());
                    break;
                case CHIPS:
                    orderList.add(new Chips());
                    break;
                case KETCHUP:
                    orderList.add(new Ketchup());
                    break;
                case MUSTARD:
                    orderList.add(new Mustard());
                    break;
                default:
                    new NullPointerException();
            }
        }
        return orderList;
    }

    public void takeOrder(){
        foodFactory.checkEffect(orderList);
    }

}

