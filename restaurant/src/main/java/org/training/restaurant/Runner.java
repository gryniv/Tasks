package org.training.restaurant;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.restaurant.customer.Client;
import org.training.restaurant.order.Menu;

public class Runner {
    private static final Logger LOG = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
        Menu menu = new Menu();
        Client client = new Client();
            LOG.info(menu.getMenu());
//        LOG.info(client.order());

    }
}

