package com.hainet.authorization.server.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AES256 {

    public AES256(
            @Value("${encryptor.secret}") final String secret,
            @Value("${encryptor.salt}") final String salt) {
        this.secret = secret;
        this.salt = salt;
    }

    private final String secret;
    private final String salt;

    private TextEncryptor encryptor;

    @PostConstruct
    private void init() {
        encryptor = Encryptors.delux(secret, salt);
    }

    public String encrypt(final String raw) {
        return encryptor.encrypt(raw);
    }

    public String decrypt(final String encrypted) {
        return encryptor.decrypt(encrypted);
    }
}
