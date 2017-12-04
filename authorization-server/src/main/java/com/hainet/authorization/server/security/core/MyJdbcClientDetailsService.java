package com.hainet.authorization.server.security.core;

import com.hainet.authorization.server.domain.dao.MyOauthClientDetailsDao;
import com.hainet.authorization.server.domain.entity.MyOauthClientDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class MyJdbcClientDetailsService implements ClientDetailsService {

    private final MyOauthClientDetailsDao dao;

    @Override
    public ClientDetails loadClientByClientId(final String clientId) throws ClientRegistrationException {
        MyOauthClientDetails myOauthClientDetails = dao.findByMyClientId(clientId);

        if (myOauthClientDetails == null) {
            throw new NoSuchClientException("No client with requested id: " + clientId);
        }

        BaseClientDetails details = new BaseClientDetails();
        details.setClientId(myOauthClientDetails.getMyClientId());
        details.setClientSecret(myOauthClientDetails.getMyClientSecret());
        details.setScope(Arrays.asList(myOauthClientDetails.getMyScope().split(",")));
        details.setAuthorizedGrantTypes(Arrays.asList(myOauthClientDetails.getMyAuthorizedGrantTypes().split(",")));
        details.setAutoApproveScopes(Arrays.asList(myOauthClientDetails.getMyAutoapprove().split(",")));

        return details;
    }
}
