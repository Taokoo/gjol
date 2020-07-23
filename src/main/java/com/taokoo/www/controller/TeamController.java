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
import com.taokoo.www.service.TeamService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: TeamController
 * @Description: 固定团Controller
 * @author Taokoo
 * @date 2020-7-21
 */
@SuppressWarnings("unused")
@RestController
@RequestMapping("/team")
@CrossOrigin
@Slf4j
public class TeamController {

	@Autowired
	private TeamService teamService;

	@ApiOperation(value = "创建固定团")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "authentication", value = "token", required = true, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "name", value = "固定团名称", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "introduce", value = "介绍/描述", required = true, dataType = "String", paramType = "query"), })
	@PostMapping("/addTeam")
	@Authentication
	public Result addTeam(@CurrentUser AuthenticatedUser authenticatedUser, String name, String introduce) {
		return teamService.add(name, introduce, authenticatedUser.getUserId());
	}

	@ApiOperation(value = "修改固定团资料")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "authentication", value = "token", required = true, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "id", value = "固定团id", required = true, dataType = "Integer", paramType = "header"),
			@ApiImplicitParam(name = "name", value = "固定团名称", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "introduce", value = "介绍/描述", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "status", value = "1：招募中   0：不进行招募", required = true, dataType = "Integer", paramType = "query"),
			@ApiImplicitParam(name = "isPublic", value = "是否公开信息", required = true, dataType = "Boolean", paramType = "query"),
			@ApiImplicitParam(name = "roleId", value = "新团长id", required = true, dataType = "Integer", paramType = "query"), })
	@PostMapping("/updateTeam")
	@Authentication
	public Result updateTeam(@CurrentUser AuthenticatedUser authenticatedUser, Integer id, String name,
			String introduce, Integer status, Boolean isPublic, Integer roleId) {
		return teamService.update(id, name, introduce, status, isPublic, roleId);
	}

	@ApiOperation(value = "查看固定团成员列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "authentication", value = "token", required = true, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "teamId", value = "固定团id", required = true, dataType = "Integer", paramType = "header"), })
	@PostMapping("/getRoleLst")
	@Authentication
	public Result getRoleLst(@CurrentUser AuthenticatedUser authenticatedUser, Integer teamId) {
		return teamService.getRoleLst(teamId);
	}
}
