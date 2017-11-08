package com.hainet.authorization.server.security.core;

import com.hainet.authorization.server.domain.dao.SingleSignOnUserDao;
import com.hainet.authorization.server.domain.entity.SingleSignOnUser;
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
public class SingleSignOnUserDetailsService implements UserDetailsService {

    private final SingleSignOnUserDao dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws AuthenticationException {
        SingleSignOnUser singleSignOnUser = dao.findByUsername(username);
        if (singleSignOnUser == null) {
            throw new UsernameNotFoundException("Invalid Username!");
        }

        return new User(
                singleSignOnUser.getUsername(),
                singleSignOnUser.getPassword(),
                Collections.emptyList());
    }
}
