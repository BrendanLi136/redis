package com.qf.j1906.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * @Author: Brendan Li
 * @description
 * @Date: 2019/11/27/16:30
 */
@Component
public class JedisUtilsPool implements JedisUtils {
    @Autowired
    private JedisPool jedisPool;
    private Jedis jedis = null;
    private Jedis getJedis(){
        if (jedis == null)
        jedis = jedisPool.getResource();
        return jedis;
    }

    @Override
    public String get(String key) {
        return this.getJedis().get(key);
    }

    @Override
    public String set(String key, String value) {
        return null;
    }

    @Override
    public Long ttl(String key) {
        return null;
    }

    @Override
    public Long expire(String key, int seconds) {
        return null;
    }

    @Override
    public Long hset(String key, String field, String value) {
        return this.getJedis().hset(key,field,value);
    }

    @Override
    public String hget(String key, String field) {
        return this.getJedis().hget(key,field);
    }
}
