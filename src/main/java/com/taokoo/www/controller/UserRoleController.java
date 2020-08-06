package com.taokoo.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.taokoo.www.annotation.Authentication;
import com.taokoo.www.annotation.CurrentUser;
import com.taokoo.www.domain.AuthenticatedUser;
import com.taokoo.www.domain.vo.Result;
import com.taokoo.www.service.UserRoleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: UserRoleController
 * @Description: 角色管理Controller
 * @author Taokoo
 * @date 2020-7-20
 */
@SuppressWarnings("unused")
@RestController
@RequestMapping("/role")
@CrossOrigin
@Slf4j
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;

	@ApiOperation(value = "添加角色")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "authentication", value = "token", required = true, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "name", value = "角色名称", required = true, dataType = "String", paramType = "query"), 
			@ApiImplicitParam(name = "regionId", value = "区服id", required = true, dataType = "Integer", paramType = "query"), 
			@ApiImplicitParam(name = "campId", value = "阵营id", required = true, dataType = "Integer", paramType = "query"), 
			@ApiImplicitParam(name = "professionId", value = "职业id", required = true, dataType = "Integer", paramType = "query"), 
			@ApiImplicitParam(name = "equipLv", value = "装等", required = true, dataType = "Integer", paramType = "query"),
			@ApiImplicitParam(name = "isPublic", value = "是否公开信息", required = true, dataType = "Boolean", paramType = "query"),
			@ApiImplicitParam(name = "type", value = "1：大号   2：小号", required = true, dataType = "Integer", paramType = "query"),
			})
	@PostMapping("/addRole")
	@Authentication
	public Result addRole(@CurrentUser AuthenticatedUser authenticatedUser, String name, Integer regionId,Integer campId,Integer professionId,Integer equipLv,Boolean isPublic,Integer type) {
		return userRoleService.addRole(authenticatedUser.getUserId(), name, regionId, campId, professionId, equipLv, isPublic,type);
	}
}
