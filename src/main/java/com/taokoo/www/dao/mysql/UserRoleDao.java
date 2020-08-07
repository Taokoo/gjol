package com.taokoo.www.dao.mysql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taokoo.www.domain.po.user.UserRole;

public interface UserRoleDao extends JpaRepository<UserRole, Integer>{

	List<UserRole> findById(Integer id);

	List<UserRole> findByNameAndRegionId(String name,Integer regionId);//通过区服和名字确定是否为唯一的角色

	List<UserRole> findByTeamId(Integer id);
}
