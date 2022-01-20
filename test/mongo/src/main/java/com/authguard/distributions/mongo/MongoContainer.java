package com.authguard.distributions.mongo;

import com.github.dockerjava.api.command.CreateContainerCmd;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MongoDBContainer;

import java.util.function.Consumer;

public class MongoContainer {
    private static GenericContainer container;

    static void start() {
        if (container == null) {
            Consumer<CreateContainerCmd> cmd =
                    e -> e.withPortBindings(new PortBinding(Ports.Binding.bindPort(27017), new ExposedPort(27017)));

            container = new MongoDBContainer()
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
