package com.hainet.bar.client.domain.dao;

import com.hainet.bar.client.domain.entity.Grant;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@ConfigAutowireable
@Dao
public interface GrantDao {

    @Select
    List<Grant> findByUsername(String username);
}
