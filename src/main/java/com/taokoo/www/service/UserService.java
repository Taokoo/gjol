package com.taokoo.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taokoo.www.dao.mysql.UserDao;
import com.taokoo.www.domain.po.User;
import com.taokoo.www.domain.vo.Result;

@Component
public class UserService {

    @Autowired
    private UserDao userDao;
    
    public Result login(String username,String password) {
    	List<User> lst = userDao.findByUsernameAndPassword(username, password);
    	if(lst.size() > 0) {
    		return Result.success(lst.get(0));
    	}
    	return Result.fail("账号或密码不正确~");
    }
}
