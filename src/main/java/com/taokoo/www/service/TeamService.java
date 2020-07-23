package com.taokoo.www.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taokoo.www.dao.mysql.RoleForTeamDao;
import com.taokoo.www.dao.mysql.TeamDao;
import com.taokoo.www.dao.mysql.UserRoleDao;
import com.taokoo.www.domain.po.RoleForTeam;
import com.taokoo.www.domain.po.Team;
import com.taokoo.www.domain.po.UserRole;
import com.taokoo.www.domain.vo.Result;

@Component
public class TeamService {

	@Autowired
	private TeamDao teamDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private RoleForTeamDao roleForTeamDao;

	/**
 	  * 创建固定团
	 * @author Taokoo
	 */
	public Result add(String name, String introduce, Integer roleId) {
		Team t = new Team();
		t.setName(name);
		t.setIntroduce(introduce);
		t.setCreateDate(new Date());
		t.setStatus(1);
		t.setIsPublic(true);
		UserRole ur = new UserRole();
		ur.setId(roleId);
		t.setTeamLeader(ur);
		teamDao.save(t);
		return Result.success("固定团创建成功");
	}
	
	/**
	   * 修改固定团信息
	 * @author Taokoo
	 */
	public Result update(Integer id, String name, String introduce, Integer status, Boolean isPublic, Integer roleId) {
		List<Team> lst = teamDao.findById(id);
		if (lst.size() == 0)return Result.fail("未知错误");
		Team t = lst.get(0);
		t.setName(name);
		t.setIntroduce(introduce);
		t.setStatus(status);
		t.setIsPublic(isPublic);
		UserRole ur = t.getTeamLeader();
		ur.setId(roleId);
		t.setTeamLeader(ur);
		teamDao.saveAndFlush(t);
		return Result.success("固定团信息更新成功");
	}
	
	/**
	  * 获取固定团成员列表
	 * @Title: getLst  
	 * @author Taokoo
	 */
	public Result getRoleLst(Integer teamId) {
		return Result.success(roleForTeamDao.findByTeamId(teamId));
	}
	
	/**
	  * 固定团添加成员
	 * @Title: addRole  
	 * @author Taokoo
	 */
	public Result addRole(Integer roleId,Integer teamId) {
		List<UserRole> lst = userRoleDao.findById(roleId);
		if(lst.size() == 0)return Result.fail("没有找到对应的角色");
		UserRole ur = lst.get(0);
		List<Team> list = teamDao.findById(teamId);
		if(list.size() == 0)return Result.fail("没有找到对应的固定团");
		RoleForTeam rt = new RoleForTeam();
		rt.setUserRole(ur);
		rt.setTeam(list.get(0));
		
		userRoleDao.saveAndFlush(ur);
		roleForTeamDao.save(rt);
		
		return Result.success("添加成功");
	}
	
	/**
	  * 固定团移除成员
	 * @Title: delRole  
	 * @author Taokoo
	 */
	public Result delRole(Integer roleId,Integer teamId) {
		List<UserRole> lst = userRoleDao.findById(roleId);
		if(lst.size() == 0)return Result.fail("没有找到对应的角色");
		UserRole ur = lst.get(0);
		RoleForTeam rt = new RoleForTeam();
		rt.setUserRole(ur);
		Team team = new Team();
		team.setId(teamId);
		rt.setTeam(team);
		
		userRoleDao.saveAndFlush(ur);
		roleForTeamDao.delete(rt);
		return Result.success("移除成功");
	}
	
}
