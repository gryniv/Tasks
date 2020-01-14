package org.training.restaurant.customer;

import org.training.restaurant.order.Menu;
import org.training.restaurant.order.extra.Ketchup;
import org.training.restaurant.order.mainproduct.Chips;

import java.util.ArrayDeque;
import java.util.Random;

public class Order {
    private static Random random = new Random();
    private static int happiness = random.nextInt(100);
    private static ArrayDeque order;
    private static Menu menu = new Menu();
    private static Ketchup ketchup = new Ketchup();
    private static Chips chips = new Chips();

    public ArrayDeque order() { //String  ...a
        order.add(ketchup.extra());

        return order;
    }
    public ArrayDeque unOrder() { //String  ...a
        order.add(ketchup.extra());

        return order;
    }

    private void checkHappiness(String... a) {
        int startHappiness = happiness;
        int end;

    }
}
