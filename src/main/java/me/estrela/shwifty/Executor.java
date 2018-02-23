package me.estrela.shwifty;

import java.util.UUID;

public class Executor {

    private static final HttpLogger LOGGER = new ShwiftyLogger();

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            LOGGER.info(UUID.randomUUID().toString());
        }
    }
}
