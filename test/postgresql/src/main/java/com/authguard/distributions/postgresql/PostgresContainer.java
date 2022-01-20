package com.authguard.distributions.postgresql;

import com.github.dockerjava.api.command.CreateContainerCmd;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.function.Consumer;

public class PostgresContainer {
    private static GenericContainer container;

    static void start() {
        if (container == null) {
            Consumer<CreateContainerCmd> cmd =
                    e -> e.withPortBindings(new PortBinding(Ports.Binding.bindPort(5432), new ExposedPort(5432)));

            container = new PostgreSQLContainer()
                    .withUsername("admin")
                    .withPassword("mysecretpassword")
                    .withCreateContainerCmdModifier(cmd);
        }

        if (!container.isRunning()) {
            container.start();
        }
    }

    static void stop() {
        container.stop();
    }
}
