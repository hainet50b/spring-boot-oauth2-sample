package com.hainet.foo.client.security;

import com.hainet.foo.client.domain.dao.FooGrantDao;
import com.hainet.foo.client.domain.entity.FooGrant;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FooClientAuthoritiesExtractor implements AuthoritiesExtractor {

    private final FooGrantDao dao;

    @Override
    public List<GrantedAuthority> extractAuthorities(Map<String, Object> map) {
        return AuthorityUtils.commaSeparatedStringToAuthorityList(
                dao.findByUsername(map.get("username").toString())
                        .stream()
                        .map(FooGrant:: getName)
                        .collect(Collectors.toList())
                        .toString()
                        .replaceAll("\\[", "")
                        .replaceAll("]", ""));
    }
}
