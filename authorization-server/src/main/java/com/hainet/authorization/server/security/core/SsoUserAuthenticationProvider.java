package com.hainet.authorization.server.security.core;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class SsoUserAuthenticationProvider implements AuthenticationProvider {

    private final PasswordEncoder passwordEncoder;
    private final SsoUserDetailsService service;

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        final SsoUserDetails ssoUserDetails = service.loadUserByUsername(authentication.getName());
        if (!passwordEncoder.matches(
                authentication.getCredentials().toString(),
                ssoUserDetails.getPassword())) {
            ssoUserDetails.getSsoUser().setFailedToLogInAt(LocalDateTime.now());
            service.update(ssoUserDetails.getSsoUser());

            throw new UsernameNotFoundException("Invalid password!");
        }

        ssoUserDetails.getSsoUser().setLoggedInAt(LocalDateTime.now());
        service.update(ssoUserDetails.getSsoUser());

        ssoUserDetails.getSsoUser().setPassword("[PROTECTED]");

        return new UsernamePasswordAuthenticationToken(
                ssoUserDetails,
                ssoUserDetails.getPassword(),
                null);
    }

    @Override
    public boolean supports(final Class<?> token) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(token);
    }
}
