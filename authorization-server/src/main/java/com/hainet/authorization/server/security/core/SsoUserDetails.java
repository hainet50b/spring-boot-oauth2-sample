package com.hainet.authorization.server.security.core;

import com.hainet.authorization.server.domain.entity.SsoUser;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Data
public class SsoUserDetails extends User {

    public SsoUserDetails(
            final String username,
            final String password,
            final Collection<? extends GrantedAuthority> authorities,
            final SsoUser ssoUser) {
        super(username, password, authorities);
        this.ssoUser = ssoUser;
    }

    private SsoUser ssoUser;
}
