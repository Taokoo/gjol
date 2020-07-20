package com.taokoo.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taokoo.www.dao.mysql.UserRoleDao;

@Component
public class UserRoleService {
	@Autowired
	private UserRoleDao userRoleDao;
	
	
}
