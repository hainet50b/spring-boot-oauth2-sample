package com.hainet.bar.client.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableOAuth2Sso
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {

    @Value("${authorization-server.uri}")
    private String authorizationServerUri;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**").authorizeRequests()
                .anyRequest().authenticated().and()
                .logout()
                .logoutSuccessUrl(authorizationServerUri + "/user-logout");
    }
}
