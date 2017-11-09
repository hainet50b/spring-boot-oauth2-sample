package com.hainet.authorization.server.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.sql.DataSource;

@Configuration
public class AuthorizationServerConfigWithJdbc extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(final AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .checkTokenAccess("isAuthenticated()");
    }

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .jdbc(dataSource);
    }
}
