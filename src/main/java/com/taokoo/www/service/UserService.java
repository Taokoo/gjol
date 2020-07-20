package com.taokoo.www.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taokoo.www.dao.mysql.LoginRecordDao;
import com.taokoo.www.dao.mysql.UserDao;
import com.taokoo.www.domain.po.LoginRecord;
import com.taokoo.www.domain.po.User;
import com.taokoo.www.domain.vo.Result;

@Component
public class UserService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private LoginRecordDao loginRecordDao;
    
    public Result login(String username,String password) {
    	List<User> lst = userDao.findByUsernameAndPassword(username, password);
    	if(lst.size() > 0) {
    		User user = lst.get(0);
            String token = tokenService.createToken(user);
            //统计登录
            LoginRecord loginRecord = new LoginRecord();
            loginRecord.setTime(new Date());
            loginRecord.setUserId(user.getId());
            loginRecordDao.save(loginRecord);
            return Result.success(token);
    	}
    	return Result.fail("账号或密码不正确~");
    }
}
