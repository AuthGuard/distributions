package com.authguard.distributions.postgresql;

import com.nexblocks.authguard.rest.Application;

public class PostgresqlDistribution {
    public static void main(final String[] args) {
        PostgresContainer.start();

        Runtime.getRuntime()
                .addShutdownHook(new Thread(PostgresContainer::stop, "Shutodown-hook"));

        Application.main(args);
    }
}
