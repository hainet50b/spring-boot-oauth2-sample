package com.hainet.foo.client.domain.entity;

import lombok.Data;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;

import java.time.LocalDateTime;

@Entity
@Data
public class FooUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    LocalDateTime loggedInAt;

    LocalDateTime failedToLogInAt;
}
