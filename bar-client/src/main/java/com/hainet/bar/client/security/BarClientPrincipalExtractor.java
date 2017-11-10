package com.hainet.bar.client.security;

import com.hainet.bar.client.domain.dao.BarUserDao;
import com.hainet.bar.client.domain.entity.BarUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class BarClientPrincipalExtractor implements PrincipalExtractor {

    @Value("${authorization-server.uri}")
    private String authorizationServerUri;

    private final BarUserDao dao;

    @Override
    public Object extractPrincipal(final Map<String, Object> map) {
        BarUser barUser = dao.findByUsername((String) map.get("username"));

        if (barUser == null) {
            throw new UsernameNotFoundException("Invalid username!");
        } else {
            return barUser;
        }
    }
}
