package com.taokoo.www.dao.mysql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taokoo.www.domain.po.Region;
import com.taokoo.www.domain.po.RoleForRegion;
import com.taokoo.www.domain.po.UserRole;

public interface RoleForRegionDao extends JpaRepository<RoleForRegion, Integer> {

	List<UserRole> findByRegionId(Integer regionId);
	
	List<Region> findByUserRoleId(Integer userRoleId);
}
