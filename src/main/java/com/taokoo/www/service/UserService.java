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
import com.taokoo.www.util.MailUtil;
import com.taokoo.www.util.VailCodeUtil;

@Component
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private LoginRecordDao loginRecordDao;

	public Result login(String username, String password) {
		List<User> lst = userDao.findByUsernameAndPassword(username, password);
		if (lst.size() > 0) {
			User user = lst.get(0);
			String token = tokenService.createToken(user);
			// 统计登录
			LoginRecord loginRecord = new LoginRecord();
			loginRecord.setTime(new Date());
			loginRecord.setUserId(user.getId());
			loginRecordDao.save(loginRecord);
			return Result.success(token);
		}
		return Result.fail("账号或密码不正确~");
	}

	public Result sendMail(String mail) {
		Integer code = VailCodeUtil.getVailCode();
		MailUtil.sendMail(mail, "您的验证码是：" + code + "，验证码3分钟内有效", "古剑奇谭网络版玩家社区注册验证码");
		tokenService.set(mail, code);//验证码存入缓存
		tokenService.expire(mail, 180);//设置3分钟过期时间
		return Result.success(code);
	}
	
	public Result register(String username,String password,String mail,Integer code) {
		List<User> lst = userDao.findByUsername(username);
		if(lst.size() > 0) return Result.fail("该账号已被注册");
		Integer vCode = Integer.valueOf((String)tokenService.get(mail));
		if(vCode != code)return Result.fail("验证码不正确");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setMail(mail);
		userDao.save(user);
		return Result.success("注册成功");
	}
}
