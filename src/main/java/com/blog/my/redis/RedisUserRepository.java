package com.blog.my.redis;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class RedisUserRepository {

    private HashOperations hashOperations;

    private RedisTemplate redisTemplate;

    public RedisUserRepository(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void save(String name) {
        hashOperations.put("name", 1,name);
    }

    public String get(Integer id) {
        return (String) hashOperations.get("name", id);
    }
}
