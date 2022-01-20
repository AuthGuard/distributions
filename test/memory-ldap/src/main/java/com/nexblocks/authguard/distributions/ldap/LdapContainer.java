package com.nexblocks.authguard.distributions.ldap;

import com.github.dockerjava.api.command.CreateContainerCmd;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;

import java.util.function.Consumer;

public class LdapContainer {
    private static GenericContainer ldapContainer;

    static void start() {
        final Network network = Network.newNetwork();

        if (ldapContainer == null) {
            final Consumer<CreateContainerCmd> ldapCommand =
                    e -> e.withPortBindings(new PortBinding(Ports.Binding.bindPort(1389), new ExposedPort(1389)),
                                new PortBinding(Ports.Binding.bindPort(1636), new ExposedPort(1636)));

            ldapContainer = (GenericContainer) new GenericContainer("bitnami/openldap:2")
                    .withNetwork(network)
                    .withNetworkAliases("ldap_server")
                    .withEnv("LDAP_ADMIN_USERNAME", "admin")
                    .withEnv("LDAP_ADMIN_PASSWORD", "password")
                    .withEnv("LDAP_USERS", "user01,user02")
                    .withEnv("LDAP_PASSWORDS", "password1,password2");

            ldapContainer = ldapContainer.withCreateContainerCmdModifier(ldapCommand);
        }

        if (!ldapContainer.isRunning()) {
            ldapContainer.start();
        }
    }

    static void stop() {
        ldapContainer.stop();
    }
}
