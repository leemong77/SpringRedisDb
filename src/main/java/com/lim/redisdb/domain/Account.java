package com.lim.redisdb.domain;

import lombok.Data;
import java.io.Serializable;

@Data
public class Account implements Serializable {
    private Long id;
    private String token;
    private String role; // "USER", "ADMIN" 등
}