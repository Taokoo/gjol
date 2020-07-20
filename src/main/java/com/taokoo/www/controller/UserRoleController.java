package com.taokoo.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taokoo.www.service.UserRoleService;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: UserRoleController  
 * @Description: 角色管理Controller
 * @author Taokoo
 * @date 2020-7-20
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
@Slf4j
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;
}
