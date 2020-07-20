package com.taokoo.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taokoo.www.dao.mysql.UserRoleDao;
import com.taokoo.www.domain.po.Camp;
import com.taokoo.www.domain.po.Profession;
import com.taokoo.www.domain.po.Region;
import com.taokoo.www.domain.po.UserRole;
import com.taokoo.www.domain.vo.Result;

@Component
public class UserRoleService {
	@Autowired
	private UserRoleDao userRoleDao;
	
	public Result addRole(Integer userId, String name, Integer regionId,Integer campId,Integer professionId,Integer equipLv,Boolean isBig,Boolean isPublic) {
		List<UserRole> lst = userRoleDao.findByNameAndRegion(name,regionId);
		if(lst.size() > 0)return Result.fail("此角色已存在");
		UserRole ur = new UserRole();
		ur.setName(name);
		Region rg = new Region();
		rg.setId(regionId);
		ur.setRegion(rg);
		Camp cp = new Camp();
		cp.setId(campId);
		ur.setCamp(cp);
		Profession pf = new Profession();
		pf.setId(professionId);
		ur.setProfession(pf);
		ur.setEquipLv(equipLv);
		ur.setIsBig(isBig);
		ur.setIsPublic(isPublic);
		
		userRoleDao.save(ur);
		return Result.success("添加成功");
	}
}
