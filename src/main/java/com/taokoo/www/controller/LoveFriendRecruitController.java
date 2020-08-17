package com.taokoo.www.controller;

import com.taokoo.www.annotation.Authentication;
import com.taokoo.www.annotation.CurrentUser;
import com.taokoo.www.domain.AuthenticatedUser;
import com.taokoo.www.domain.vo.LoveFriendRecruitVo;
import com.taokoo.www.domain.vo.Result;
import com.taokoo.www.service.LoveFriendRecruitService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private LoveFriendRecruitService loveFriendRecruitService;

    @ApiOperation(value = "发起情缘招募")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authentication", value = "token", required = true, dataType = "string", paramType = "header"),
    })
    @PostMapping("/addLoveFriend")
    @Authentication
    public Result addLoveFriend(@CurrentUser AuthenticatedUser authenticatedUser, LoveFriendRecruitVo vo) {
        return loveFriendRecruitService.addLoveFriend(vo);
    }

    @ApiOperation(value = "根据角色获取以前的招募信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authentication", value = "token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "userRoleId", value = "角色id", required = true, dataType = "Integer", paramType = "query"),
    })
    @PostMapping("/findLoveFriend")
    @Authentication
    public Result findLoveFriend(@CurrentUser AuthenticatedUser authenticatedUser, Integer userRoleId) {
        return loveFriendRecruitService.findLoveFriend(userRoleId);
    }

    @ApiOperation(value = "关闭某个招募")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authentication", value = "token", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "id", value = "招募id", required = true, dataType = "Integer", paramType = "query"),
    })
    @GetMapping("/closeLoveFriend")
    @Authentication
    public Result closeLoveFriend(@CurrentUser AuthenticatedUser authenticatedUser, Integer id) {
        return loveFriendRecruitService.closeLoveFriend(id);
    }
}
