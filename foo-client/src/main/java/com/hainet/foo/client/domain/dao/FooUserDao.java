package com.hainet.foo.client.domain.dao;

import com.hainet.foo.client.domain.entity.FooUser;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface FooUserDao {

    @Select
    FooUser findByUsername(String username);
}
