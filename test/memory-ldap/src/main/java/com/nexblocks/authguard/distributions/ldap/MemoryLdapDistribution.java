package com.nexblocks.authguard.distributions.ldap;

import com.nexblocks.authguard.rest.Application;

public class MemoryLdapDistribution {
    public static void main(String[] args) {
        LdapContainer.start();

        Runtime.getRuntime()
                .addShutdownHook(new Thread(LdapContainer::stop, "Shutodown-hook"));

        Application.main(args);
    }
}
