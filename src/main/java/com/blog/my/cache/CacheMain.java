package com.blog.my.cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class CacheMain {

    private static final String redisHost = "localhost";
    private static final Integer redisPort = 6379;

    private static JedisPool pool = null;

    public CacheMain(){
        pool = new JedisPool(redisHost, redisPort);
    }

    public void addSets() {
        String key = "members";
        String member1 = "Sedarius";
        String member2 = "Richard";
        String member3 = "Joe";

        Jedis jedis = pool.getResource();

        jedis.sadd(key, member1, member2, member3);

        Set members = jedis.smembers(key);
        for (Object member : members) {
            System.out.println(member);
        }
    }


    public void addHash() {
        String key = "javapointers";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Java Pointers");
        map.put("domain", "www.javapointers.com");
        map.put("description", "Learn how to program in Java");

        Jedis jedis = pool.getResource();
        jedis.hmset(key, map);

        Map<String, String> retrieveMap = jedis.hgetAll(key);
        for (String keyMap : retrieveMap.keySet()) {
            System.out.println(keyMap + " " + retrieveMap.get(keyMap));
        }
    }
}
