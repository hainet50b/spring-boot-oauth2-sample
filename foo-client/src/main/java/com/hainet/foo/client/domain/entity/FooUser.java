package com.hainet.foo.client.domain.entity;

import lombok.Data;
import org.seasar.doma.*;

import java.time.LocalDateTime;

@Entity
@Data
public class FooUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    @Transient
    LocalDateTime loggedInAt;

    @Transient
    LocalDateTime failedToLogInAt;
}
