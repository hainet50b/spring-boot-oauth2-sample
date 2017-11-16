package com.hainet.resource.server.domain.service;

import com.hainet.resource.server.domain.dao.SsoUserDao;
import com.hainet.resource.server.domain.entity.SsoUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SsoUserService {

    private final SsoUserDao ssoUserDao;

    public SsoUser findByUsername(final String username) {
        return ssoUserDao.findByUsername(username);
    }
}
