package com.taokoo.www.controller;

import com.taokoo.www.annotation.Authentication;
import com.taokoo.www.annotation.CurrentUser;
import com.taokoo.www.domain.AuthenticatedUser;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taokoo.www.domain.vo.Result;
import com.taokoo.www.service.RecruitService;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: RecruitController  
 * @Description: 固定团招募Controller
 * @author Taokoo
 * @date 2020-7-30
 */
@SuppressWarnings("unused")
@RestController
@RequestMapping("/recruit")
@CrossOrigin
@Slf4j
public class RecruitController {

	@Autowired
	private RecruitService recruitService;

	@ApiOperation(value = "开启新招募")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "authentication", value = "token", required = true, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "userRoleId", value = "创建者的角色id", required = true, dataType = "Integer", paramType = "query"),
			@ApiImplicitParam(name = "title", value = "招募标题", required = true, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "body", value = "招募内容", required = true, dataType = "String", paramType = "query"),
	})
	@PostMapping("/openRecruit")
	@Authentication
	public Result openRecruit(@CurrentUser AuthenticatedUser authenticatedUser,Integer userRoleId,String title,String body) {
		return recruitService.openRecruit(userRoleId,title,body);
	}
}
