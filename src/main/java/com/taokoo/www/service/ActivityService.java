package com.taokoo.www.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taokoo.www.dao.mysql.ActivityDao;
import com.taokoo.www.dao.mysql.UserRoleDao;
import com.taokoo.www.domain.po.Activity;
import com.taokoo.www.domain.po.UserRole;
import com.taokoo.www.domain.vo.Result;

@Component
public class ActivityService {

	@Autowired
	private ActivityDao activityDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	/**
 	  * 创建活动
	 * @Title: newActivity  
	 * @author Taokoo
	 */
	public Result newActivity(Integer userId,Integer teamId,String theme,String desc) {
		Activity at = new Activity();
		at.setTheme(theme);
		at.setDesc(desc);
		at.setTeamId(teamId);
		at.setCreateDate(new Date());
		
		activityDao.save(at);
		return Result.success("创建活动成功");
	}
	
	/**
	  * 角色加入活动
	 * @Title: joinActivity  
	 * @author Taokoo
	 */
	public Result joinActivity(Integer userRoleId,Integer activityId) {
		UserRole ur = userRoleDao.findOne(userRoleId);
		Activity at = activityDao.findOne(activityId);
		List<UserRole> lst = at.getRoles();
		lst.add(ur);
		at.setRoles(lst);
		activityDao.saveAndFlush(at);
		return Result.success("加入活动成功");
	}
}
