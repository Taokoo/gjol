package com.taokoo.www.domain;

public interface RedisEntity {
    String generateRedisKey();
    String generateRedisKey(Object key);
}
