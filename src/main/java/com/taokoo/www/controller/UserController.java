package com.taokoo.www.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taokoo.www.domain.vo.Result;
import com.taokoo.www.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/user")
@CrossOrigin
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "登录", notes = "根据用户名和密码获取用户认证，认证成功后返回token")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "username", value = "账号/邮箱", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query"),
	})
	@PostMapping("/login")
	public Result login(HttpServletRequest request,String username,String password) {
		return userService.login(username,password);
	}

}
