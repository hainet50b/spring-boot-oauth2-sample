package com.hainet.authorization.server.domain.dao;

import com.hainet.authorization.server.domain.entity.SingleSignOnUser;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface SingleSignOnUserDao {

    @Select
    SingleSignOnUser findByUsername(String username);
}
