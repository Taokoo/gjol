package com.taokoo.www.domain;


import com.taokoo.www.domain.po.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticatedUser implements RedisEntity {
    private Integer userId;
    private String token;
    private String username;
    private String password;

    public AuthenticatedUser(User user, String token) {
        userId = user.getId();
        username = user.getUsername();
        password = user.getPassword();
        this.token = token;
    }

    @Override
    public String generateRedisKey() {
        return String.format("authenticated_user:%s:token", token);
    }

    @Override
    public String generateRedisKey(Object key) {
        return String.format("authenticated_user:%s:token", key);
    }
}
