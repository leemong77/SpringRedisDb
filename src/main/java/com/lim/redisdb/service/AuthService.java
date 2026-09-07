package com.lim.redisdb.service;

import com.lim.redisdb.domain.Account;
import com.lim.redisdb.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AccountMapper accountMapper;

    @Cacheable(value = "auth", key = "#token", unless = "#result == null")
    public Account validateToken(String token) {
        log.info("토큰 DB 조회 발생: token={}", token);
        return accountMapper.findByToken(token);
    }
}