package com.taokoo.www.service;

import com.taokoo.www.domain.AuthenticatedUser;
import com.taokoo.www.domain.po.user.User;

/**
 * 对Token进行操作的接口
 */
public interface TokenService {

	/**
	 * 创建一个token关联上指定用户
	 * 
	 * @param user 用户
	 * @return 生成的token
	 */
	String createToken(User user);

	/**
	 * 检查token是否有效
	 * 
	 * @param token 登录用户的token
	 * @return 有效返回用户, 无效则返回null
	 */
	AuthenticatedUser checkToken(String token);

	/**
	 * 清除token
	 * 
	 * @param token 登录用户的token
	 */
	void deleteToken(String token);

	/**
	 * 指定缓存失效时间
	 * 
	 * @param key  键
	 * @param time 时间(秒)
	 * @return
	 */
	boolean expire(String key, long time);

	/**
	 * 普通缓存获取
	 * 
	 * @param key 键
	 * @return 值
	 */
	Object get(String key);

	/**
	 * 普通缓存放入
	 * 
	 * @param key   键
	 * @param value 值
	 * @return true成功 false失败
	 */
	boolean set(String key, Object value);

	/**
	 * 删除缓存
	 * 
	 * @param key 可以传一个值 或多个
	 */
	void del(String key);

	/**
	 * 判断key是否存在
	 * 
	 * @param key 键
	 * @return true 存在 false不存在
	 */
	boolean hasKey(String key);
}
