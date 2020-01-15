package org.training.restaurant.customer;

import java.util.Random;

public class Client implements Customer {
    private static Random random;

    @Override
    public void happiness() {
        int startHappiness = random.nextInt(100);
    }

    @Override
    public String name() {
        return "Bob";
    }
}
