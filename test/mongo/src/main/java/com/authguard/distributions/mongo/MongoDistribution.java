package com.authguard.distributions.mongo;

import com.nexblocks.authguard.rest.Application;

public class MongoDistribution {
    public static void main(String[] args) {
        MongoContainer.start();

        Runtime.getRuntime()
                .addShutdownHook(new Thread(MongoContainer::stop, "Shutodown-hook"));

        Application.main(args);
    }
}
