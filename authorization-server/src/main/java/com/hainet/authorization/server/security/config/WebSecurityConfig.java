package com.hainet.authorization.server.security.config;

import com.hainet.authorization.server.security.core.SsoUserAuthenticationProvider;
import com.hainet.authorization.server.security.web.SsoUserLoginFailureHandler;
import com.hainet.authorization.server.security.web.SsoUserLogoutSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final SsoUserLoginFailureHandler loginFailureHandler;
    private final SsoUserLogoutSuccessHandler logoutSuccessHandler;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login").permitAll()
                    .failureHandler(loginFailureHandler)
                    .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessHandler(logoutSuccessHandler);
                    // プログラマブルにログアウト処理を行う場合
                    // new SecurityContextLogoutHandler().logout(request, null, null);
    }

    private final SsoUserAuthenticationProvider provider;

    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(provider);
    }
}
