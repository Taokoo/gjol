package com.taokoo.www.service;

import com.taokoo.www.dao.mysql.ApplyDao;
import com.taokoo.www.dao.mysql.RecruitDao;
import com.taokoo.www.dao.mysql.UserRoleDao;
import com.taokoo.www.domain.po.Apply;
import com.taokoo.www.domain.po.Recruit;
import com.taokoo.www.domain.po.Team;
import com.taokoo.www.domain.po.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taokoo.www.domain.vo.Result;

import java.util.List;

@Component
public class RecruitService {

	@Autowired
	private UserRoleDao userRoleDao;

	@Autowired
	private RecruitDao recruitDao;

	@Autowired
	private ApplyDao applyDao;

	/**
	 * 开启一个新招募
	 * @Title: openRecruit  
	 * @author Taokoo
	 */
	public Result openRecruit(Integer userRoleId, String title, String body) {
		List<UserRole> userRoles = userRoleDao.findById(userRoleId);
		if(userRoles.size() == 0)return Result.fail("没有找到对应角色");
		if(userRoles.get(0).getIsLeader() == false)return Result.fail("非固定团团长不能开启招募");
		UserRole ur = userRoles.get(0);
		Recruit r = new Recruit();
		r.setStatus(1);//招募中
		r.setTitle(title);
		r.setBody(body);
		r.setTeam(ur.getTeam());
		recruitDao.save(r);
		return Result.success("招募开启成功");
	}

	/**
	 * 发起一个申请
	 * @Title: launchApply
	 * @author Taokoo
	 */
	public Result launchApply(Integer userRoleId,Integer recruitId,String message){
		Apply apply = new Apply();
		UserRole ur = new UserRole();
		ur.setId(userRoleId);
		Recruit rr = new Recruit();
		rr.setId(recruitId);
		apply.setUserRole(ur);
		apply.setRecruit(rr);
		apply.setMessage(message);
		apply.setStatus(1);//已发出申请
		applyDao.save(apply);
		return Result.success("已申请");
	}
}
