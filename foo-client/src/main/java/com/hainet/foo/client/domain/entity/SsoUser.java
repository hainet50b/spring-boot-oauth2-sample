package com.hainet.foo.client.domain.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SsoUser {

    LocalDateTime loggedInAt;

    LocalDateTime failedToLogInAt;
}
