package com.hainet.bar.client.domain.dao;

import com.hainet.bar.client.domain.entity.BarUser;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface BarUserDao {

    @Select
    BarUser findByUsername(String username);
}
