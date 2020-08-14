package com.taokoo.www.service;

import com.taokoo.www.dao.mysql.LoveFriendRecruitDao;
import com.taokoo.www.domain.vo.LoveFriendRecruitVo;
import com.taokoo.www.domain.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoveFriendRecruitService {

    @Autowired
    private LoveFriendRecruitDao loveFriendRecruitDao;

    public Result findLoveFriend(LoveFriendRecruitVo vo){
        return Result.success("添加成功");
    }
}
