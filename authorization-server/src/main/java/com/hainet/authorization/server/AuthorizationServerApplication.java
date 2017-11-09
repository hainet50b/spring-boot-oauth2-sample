package com.hainet.authorization.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class AuthorizationServerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(AuthorizationServerApplication.class, args);
    }
}
