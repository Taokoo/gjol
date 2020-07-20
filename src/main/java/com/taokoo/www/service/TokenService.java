package com.taokoo.www.service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.taokoo.www.domain.AuthenticatedUser;
import com.taokoo.www.domain.po.User;
import com.taokoo.www.util.Constants;

/**
 * 对Token进行操作的接口
 */
@SuppressWarnings("all")
@Component
public class TokenService {
	
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private TokenService tokenService;

    /**
     * 创建一个token关联上指定用户
     * @param user 用户
     * @return 生成的token
     */
    
	public String createToken(User user){
        //使用uuid作为源token
        String token = UUID.randomUUID().toString();

        AuthenticatedUser authenticatedUser = new AuthenticatedUser(user, token);
        //存储到redis并设置过期时间
        redisTemplate.boundValueOps(authenticatedUser.generateRedisKey()).set(authenticatedUser, Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return token;
    }

    /**
     * 检查token是否有效
     * @param token 登录用户的token
     * @return 有效返回用户, 无效则返回null
     */
    public AuthenticatedUser checkToken(String token){
         if (token == null) return null;
         AuthenticatedUser authenticatedUser = (AuthenticatedUser) redisTemplate.opsForValue().get(new AuthenticatedUser().generateRedisKey(token));
         if (authenticatedUser == null) return null;
         //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
         redisTemplate.boundValueOps(authenticatedUser.generateRedisKey()).expire(Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
         return authenticatedUser;
     }

    /**
     * 清除token
     * @param token 登录用户的token
     */
    public void deleteToken(String token){
        redisTemplate.delete(new AuthenticatedUser().generateRedisKey(token));
    }

}
