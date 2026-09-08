package com.lim.redisdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})  //Security 자동 설정을 제외합니다.
public class RedisdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisdbApplication.class, args);
	}

}
