package com.hainet.authorization.server.security.core;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SsoUserAuthenticationProvider implements AuthenticationProvider {

    private final PasswordEncoder passwordEncoder;
    private final SsoUserDetailsService service;

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        final UserDetails userDetails = service.loadUserByUsername(authentication.getName());
        if (!passwordEncoder.matches(
                authentication.getCredentials().toString(),
                userDetails.getPassword())) {
            throw new UsernameNotFoundException("Invalid password!");
        }

        return new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                null);
    }

    @Override
    public boolean supports(final Class<?> token) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(token);
    }
}
