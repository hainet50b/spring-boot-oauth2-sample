package com.hainet.bar.client.domain.dao;

import com.hainet.bar.client.domain.entity.BarGrant;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@ConfigAutowireable
@Dao
public interface BarGrantDao {

    @Select
    List<BarGrant> findByUsername(String username);
}
