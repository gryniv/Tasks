package org.training.restaurant;

import org.training.restaurant.customer.Client;

import java.util.LinkedList;
import java.util.Queue;

public class Restaurant {

    public static String name;
    Queue<Client> clientList = new LinkedList<>();


    public Restaurant(String name) {
        Restaurant.name = name;
    }

    public void newClient(String name, String... order) {
        clientList.offer(new Client(name, order));
    }

    public void giveOrder() {
        effect ();
        clientList.poll();
    }

    public void effect () {
        clientList.peek().takeOrder();

    }

}
