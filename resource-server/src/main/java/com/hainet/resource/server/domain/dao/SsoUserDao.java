package com.hainet.resource.server.domain.dao;

import com.hainet.resource.server.domain.entity.SsoUser;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface SsoUserDao {

    @Select
    SsoUser findByUsername(String username);
}
