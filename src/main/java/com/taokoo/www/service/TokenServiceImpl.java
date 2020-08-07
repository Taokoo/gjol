package com.taokoo.www.service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.taokoo.www.domain.AuthenticatedUser;
import com.taokoo.www.domain.po.user.User;
import com.taokoo.www.util.Constants;

/**
 * 通过Redis存储和验证token的实现类
 */
@Component
@SuppressWarnings("all")
public class TokenServiceImpl implements TokenService {
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private TokenService tokenService;

	@Override
	public String createToken(User user) {
		// 使用uuid作为源token
		String token = UUID.randomUUID().toString();

		AuthenticatedUser authenticatedUser = new AuthenticatedUser(user, token);
		// 存储到redis并设置过期时间
		redisTemplate.boundValueOps(authenticatedUser.generateRedisKey()).set(authenticatedUser,
				Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
		return token;
	}

	public AuthenticatedUser checkToken(String token) {
		if (token == null)
			return null;
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) redisTemplate.opsForValue()
				.get(new AuthenticatedUser().generateRedisKey(token));
		if (authenticatedUser == null)
			return null;
		// 如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
		redisTemplate.boundValueOps(authenticatedUser.generateRedisKey()).expire(Constants.TOKEN_EXPIRES_HOUR,
				TimeUnit.HOURS);
		return authenticatedUser;
	}

	public void deleteToken(String token) {
		redisTemplate.delete(new AuthenticatedUser().generateRedisKey(token));
	}

	@Override
	public boolean expire(String key, long time) {
		try {
			if (time > 0) {
				redisTemplate.expire(key, time, TimeUnit.SECONDS);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Object get(String key) {
		return key == null ? null : redisTemplate.opsForValue().get(key);
	}

	@Override
	public boolean set(String key, Object value) {
		redisTemplate.setEnableTransactionSupport(true);// 允许释放链接
		try {
			redisTemplate.opsForValue().set(key, value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void del(String key) {
		redisTemplate.delete(key);
	}

	@Override
	public boolean hasKey(String key) {
		try {
			return redisTemplate.hasKey(key);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
