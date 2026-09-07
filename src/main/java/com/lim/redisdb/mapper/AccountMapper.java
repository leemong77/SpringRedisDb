package com.lim.redisdb.mapper;

import com.lim.redisdb.domain.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    Account findByToken(String token);
}