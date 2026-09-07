package com.lim.redisdb.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lim.redisdb.domain.Team;
import com.lim.redisdb.mapper.TeamMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamMapper teamMapper;

    @Cacheable(value = "team", key = "#id")
    public Team getTeam(Long id) {
        log.info("DB 조회 발생: id={}", id);
        return teamMapper.findById(id);
    }

    public List<Team> getAllTeams() {
        return teamMapper.findAll();
    }
    
    @CachePut(value = "team", key = "#team.id")
    public Team updateTeam(Team team) {
        teamMapper.update(team);
        return team;
    }

    @CacheEvict(value = "team", key = "#id")
    public void deleteTeam(Long id) {
        teamMapper.deleteById(id);
    }
}