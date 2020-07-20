package com.taokoo.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taokoo.www.dao.mysql.UserRoleDao;
import com.taokoo.www.domain.po.UserRole;
import com.taokoo.www.domain.vo.Result;

@Component
public class UserRoleService {
	@Autowired
	private UserRoleDao userRoleDao;
	
	public Result addRole(Integer userId, String name, Integer regionId,Integer campId,Integer professionId,Integer equipLv,Boolean isBig,Boolean isPublic) {
		
		UserRole ur = new UserRole();
		
		userRoleDao.save(ur);
		return Result.success("添加成功");
	}
}
