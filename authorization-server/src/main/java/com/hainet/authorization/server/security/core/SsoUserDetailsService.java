package com.hainet.authorization.server.security.core;

import com.hainet.authorization.server.domain.dao.SsoUserDao;
import com.hainet.authorization.server.domain.entity.SsoUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@Transactional
@RequiredArgsConstructor
public class SsoUserDetailsService implements UserDetailsService {

    private final SsoUserDao dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws AuthenticationException {
        SsoUser ssoUser = dao.findByUsername(username);
        if (ssoUser == null) {
            throw new UsernameNotFoundException("Invalid Username!");
        }

        return new User(
                ssoUser.getUsername(),
                ssoUser.getPassword(),
                Collections.emptyList());
    }
}
