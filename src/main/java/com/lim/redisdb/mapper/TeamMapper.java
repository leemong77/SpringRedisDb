package com.lim.redisdb.mapper;

import com.lim.redisdb.domain.Team;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeamMapper {
    Team findById(Long id);
    List<Team> findAll();
    int update(Team team);
    int deleteById(Long id);
}