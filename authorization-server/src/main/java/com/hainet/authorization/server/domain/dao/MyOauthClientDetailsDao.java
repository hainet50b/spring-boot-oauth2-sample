package com.hainet.authorization.server.domain.dao;

import com.hainet.authorization.server.domain.entity.MyOauthClientDetails;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface MyOauthClientDetailsDao {

    @Select
    MyOauthClientDetails findByMyClientId(String myClientId);
}
