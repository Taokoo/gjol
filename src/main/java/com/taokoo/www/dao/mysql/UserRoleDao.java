package com.taokoo.www.dao.mysql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taokoo.www.domain.po.UserRole;

public interface UserRoleDao extends JpaRepository<UserRole, Integer>{

	List<UserRole> findByNameAndRegion(String name,Integer regionId);
	
	List<UserRole> findById(Integer id);
	
	List<UserRole> findByTeam(Integer teamId);
}
