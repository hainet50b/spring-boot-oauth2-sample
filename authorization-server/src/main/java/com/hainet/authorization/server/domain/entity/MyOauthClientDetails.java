package com.hainet.authorization.server.domain.entity;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity
@Data
public class MyOauthClientDetails {

    @Id
    private String myClientId;

    private String myClientSecret;

    private String myScope;

    private String myAuthorizedGrantTypes;

    private String myAutoapprove;
}
