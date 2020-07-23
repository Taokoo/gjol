package com.taokoo.www.dao.mysql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taokoo.www.domain.po.RoleForTeam;
import com.taokoo.www.domain.po.Team;
import com.taokoo.www.domain.po.UserRole;

public interface RoleForTeamDao extends JpaRepository<RoleForTeam, Integer> {

	List<UserRole> findByTeamId(Integer teamId);
	
	List<Team> findByUserRoleId(Integer userRoleId);
}
