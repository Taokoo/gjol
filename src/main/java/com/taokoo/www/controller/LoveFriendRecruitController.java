package com.taokoo.www.controller;

import com.taokoo.www.annotation.Authentication;
import com.taokoo.www.annotation.CurrentUser;
import com.taokoo.www.domain.AuthenticatedUser;
import com.taokoo.www.domain.po.LoveFriendRecruit;
import com.taokoo.www.domain.vo.LoveFriendRecruitVo;
import com.taokoo.www.domain.vo.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: LoveFriendRecruitController
 * @Description: 情缘招募Controller
 * @author Taokoo
 * @date 2020-7-24
 */
@SuppressWarnings("unused")
@RestController
@RequestMapping("/loveFriendRecruit")
@CrossOrigin
@Slf4j
public class LoveFriendRecruitController {

    @ApiOperation(value = "测试接口1")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authentication", value = "token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "userRole", value = "角色id", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "shapeList", value = "期望体型", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "SectsList", value = "期望门派", required = true, dataType = "Integer", paramType = "query"),
    })
    @PostMapping("/test1")
    @Authentication
    public Result test1(@CurrentUser AuthenticatedUser authenticatedUser, LoveFriendRecruitVo vo) {
        System.out.println("接收到数据");
        return null;
    }
}
