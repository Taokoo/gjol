package com.taokoo.www.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.taokoo.www.dao.mysql.RoleForCampDao;
import com.taokoo.www.dao.mysql.RoleForProfessionDao;
import com.taokoo.www.dao.mysql.RoleForRegionDao;
import com.taokoo.www.dao.mysql.UserRoleDao;
import com.taokoo.www.domain.po.Camp;
import com.taokoo.www.domain.po.Profession;
import com.taokoo.www.domain.po.Region;
import com.taokoo.www.domain.po.RoleForCamp;
import com.taokoo.www.domain.po.RoleForProfession;
import com.taokoo.www.domain.po.RoleForRegion;
import com.taokoo.www.domain.po.UserRole;
import com.taokoo.www.domain.vo.Result;

@Component
public class UserRoleService {
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private RoleForRegionDao roleForRegionDao;
	
	@Autowired
	private RoleForCampDao roleForCampDao;
	
	@Autowired
	private RoleForProfessionDao roleForProfessionDao;
	
	/**
	 * 创建角色
	 * @Title: addRole
	 * @author Taokoo
	 */
	@Transactional(rollbackFor = Exception.class)
	public Result addRole(Integer userId, String name, Integer regionId,Integer campId,Integer professionId,Integer equipLv,Boolean isPublic,Integer type) {
		List<UserRole> lst = roleForRegionDao.findByRegionId(regionId);
		if(lst.size() > 0)return Result.fail("此角色已存在");
		UserRole ur = new UserRole();
		ur.setName(name);
		Region rg = new Region();
		rg.setId(regionId);
		Camp cp = new Camp();
		cp.setId(campId);
		Profession pf = new Profession();
		pf.setId(professionId);
		ur.setEquipLv(equipLv);
		ur.setType(type);
		ur.setIsPublic(isPublic);
		ur.setCreateTime(new Date());
		
		RoleForRegion rfr = new RoleForRegion();
		rfr.setUserRole(ur);
		rfr.setRegion(rg);
		
		RoleForCamp rfc = new RoleForCamp();
		rfc.setUserRole(ur);
		rfc.setCamp(cp);
		
		RoleForProfession rfp = new RoleForProfession();
		rfp.setUserRole(ur);
		rfp.setProfession(pf);
		
		userRoleDao.save(ur);
		roleForRegionDao.save(rfr);//区服
		roleForCampDao.save(rfc);//阵营
		roleForProfessionDao.save(rfp);//职业
		
		return Result.success("添加成功");
	}
}
