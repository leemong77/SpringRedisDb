package com.lim.redisdb.domain;

import lombok.Data;
import java.io.Serializable;

@Data
public class Team implements Serializable {
    private Long id;
    private String name;
}