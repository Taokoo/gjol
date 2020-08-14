package com.taokoo.www.service;

import com.taokoo.www.dao.mysql.LoveFriendRecruitDao;
import com.taokoo.www.dao.mysql.SexDao;
import com.taokoo.www.dao.mysql.UserRoleDao;
import com.taokoo.www.domain.po.enumData.Sects;
import com.taokoo.www.domain.po.enumData.Sex;
import com.taokoo.www.domain.po.enumData.Shape;
import com.taokoo.www.domain.po.socialContact.LoveFriendRecruit;
import com.taokoo.www.domain.po.user.UserRole;
import com.taokoo.www.domain.vo.LoveFriendRecruitVo;
import com.taokoo.www.domain.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoveFriendRecruitService {

    @Autowired
    private LoveFriendRecruitDao loveFriendRecruitDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private SexDao sexDao;

    /**
     * @Author Taokoo
     * @Description // 发起情缘招募
     **/

    public Result findLoveFriend(LoveFriendRecruitVo vo){
        LoveFriendRecruit po = new LoveFriendRecruit();
        List<UserRole> urLst = userRoleDao.findById(vo.getUserRoleId());
        if(urLst.size() == 0)return Result.fail("不存在此角色");
        po.setUserRole(urLst.get(0));
        po.setAge(vo.getAge());
        List<Sex> sexLst = sexDao.findById(vo.getSex());
        if(sexLst.size() > 0)po.setSex(sexLst.get(0));
        po.setTitle(vo.getTitle());
        po.setBody(vo.getBody());
        po.setRegion(vo.getRegion());
        String[] sectsList = vo.getSectsList().split(",");//期望门派
        List<Sects> SectsList = new ArrayList<>();
        for(String sects : sectsList){
            Sects s = new Sects();
            s.setId(Integer.valueOf(sects));
            SectsList.add(s);
        }
        po.setSectsList(SectsList);
        String[] shapeList = vo.getShapeList().split(",");//期望体型
        List<Shape> shapeLst = new ArrayList<>();
        for(String s : shapeList){
            Shape shape = new Shape();
            shape.setId(Integer.valueOf(s));
            shapeLst.add(shape);
        }
        po.setShapeList(shapeLst);

        //TODO 更新及状态处理待添加
        loveFriendRecruitDao.save(po);
        return Result.success("添加成功");
    }
}
