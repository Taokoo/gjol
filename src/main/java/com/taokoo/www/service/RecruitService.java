package com.taokoo.www.service;

import com.taokoo.www.dao.mysql.RecruitDao;
import com.taokoo.www.dao.mysql.RoleForTeamDao;
import com.taokoo.www.dao.mysql.UserRoleDao;
import com.taokoo.www.domain.AuthenticatedUser;
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
	private RoleForTeamDao roleForTeamDao;

	@Autowired
	private RecruitDao recruitDao;

	/**
	 * 开启一个新招募
	 * @Title: openRecruit  
	 * @return 
	 * @author Taokoo
	 */
	public Result openRecruit(Integer userRoleId, String title, String body) {
		List<UserRole> userRoles = userRoleDao.findById(userRoleId);
		if(userRoles.size() == 0)return Result.fail("没有找到对应角色");
		if(userRoles.get(0).getIsLeader() == false)return Result.fail("非固定团团长不能开启招募");
		List<Team> teamList = roleForTeamDao.findByUserRoleId(userRoleId);
		if(teamList.size() == 0)return Result.fail("该角色非固定团成员");
		Recruit r = new Recruit();
		r.setStatus(1);//招募中
		r.setTitle(title);
		r.setBody(body);
		r.setTeam(teamList.get(0));
		recruitDao.save(r);
		return Result.success("招募开启成功");
	}
}
