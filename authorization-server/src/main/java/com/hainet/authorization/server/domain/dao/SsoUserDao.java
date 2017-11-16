package com.hainet.authorization.server.domain.dao;

import com.hainet.authorization.server.domain.entity.SsoUser;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface SsoUserDao {

    @Select
    SsoUser findByUsername(String username);

    @Update
    int update(SsoUser ssoUser);
}
