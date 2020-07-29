package com.taokoo.www.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taokoo.www.annotation.Authentication;
import com.taokoo.www.annotation.CurrentUser;
import com.taokoo.www.domain.AuthenticatedUser;
import com.taokoo.www.domain.vo.Result;
import com.taokoo.www.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
/**
 * @ClassName: UserController  
 * @Description: 用户管理Controller
 * @author Taokoo
 * @date 2020-7-20
 */
@SuppressWarnings("unused")
@RestController
@RequestMapping("/user")
@CrossOrigin
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "登录", notes = "根据账号和密码获取用户认证，认证成功后返回token")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "username", value = "账号", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query"),
	})
	@PostMapping("/login")
	public Result login(HttpServletRequest request,String username,String password) {
		return userService.login(username,password);
	}
	
	@ApiOperation(value = "验证邮箱", notes = "往指定邮箱发送验证码")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "mail", value = "邮箱", required = true, dataType = "String", paramType = "query"),
	})
	@PostMapping("/sendMail")
	public Result sendMail(HttpServletRequest request,String mail) {
		return userService.sendMail(mail);
	}
	
	@ApiOperation(value = "注册", notes = "注册账号")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "username", value = "账号", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "mail", value = "邮箱", required = true, dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "code", value = "验证码", required = true, dataType = "Integer", paramType = "query"),
	})
	@PostMapping("/register")
	public Result register(HttpServletRequest request,String username,String password,String mail,Integer code) {
		return userService.register(username,password,mail,code);
	}
	
	@ApiOperation(value = "查看用户信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "authentication", value = "token", required = true, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "userId", value = "被查看的用户的信息", required = true, dataType = "Integer", paramType = "query"), })
	@PostMapping("/getInfo")
	@Authentication
	public Result getInfo(@CurrentUser AuthenticatedUser authenticatedUser,Integer userId) {
		return userService.getInfo(userId);
	}
	
	@ApiOperation(value = "用户设置头像")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "authentication", value = "token", required = true, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "headPortrait", value = "头像的base64码（直接将base64码放在body里就好）", required = true, dataType = "string", paramType = "body"), })
	@PostMapping("/setHeadPortrait")
	@Authentication
	public Result setHeadPortrait(@CurrentUser AuthenticatedUser authenticatedUser,@RequestBody String headPortrait) {
		return userService.setHeadPortrait(authenticatedUser.getUserId(), headPortrait);
	}
	
	
}
