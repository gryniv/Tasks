package org.training.restaurant;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.restaurant.customer.Client;
import org.training.restaurant.restaurant.Restaurant;

public class Runner {
    private static final Logger LOG = LogManager.getLogger(Runner.class);
    private static Restaurant yaponaHata = new Restaurant();
    private static Client client = new Client();

    public static void main(String[] args) {
        LOG.info(yaponaHata.getMenu());
        LOG.info(client.name());

    }
}

