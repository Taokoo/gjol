package com.taokoo.www.dao.mysql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taokoo.www.domain.po.team.Team;

public interface TeamDao extends JpaRepository<Team, Integer> {

	List<Team> findByName(String name);
	
	List<Team> findById(Integer id);

}
