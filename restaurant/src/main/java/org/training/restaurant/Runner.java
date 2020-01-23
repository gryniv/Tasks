package org.training.restaurant;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    private static final Logger LOG = LogManager.getLogger(Runner.class);


    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Yapona Hata");
        restaurant.newClient("Bob","HotDog", "Ketchup");
        restaurant.newClient("Tanya", "Chips", "Mustard");
        restaurant.newClient("Will", "HotDog", "Ketchup");
        restaurant.newClient("Andrew", "HotDog", "Ketchup");
        restaurant.newClient("Andrew", "HotDog", "Ketchup");
        restaurant.giveOrder();
        restaurant.newClient("Andrew", "Chips", "Ketchup", "Chips");
        restaurant.newClient("Andrew", "HotDog", "Ketchup");
    }
}

