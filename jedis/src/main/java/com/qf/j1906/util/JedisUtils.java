package com.qf.j1906.util;

/**
 * @Author: Brendan Li
 * @description 封装常见的redis操作
 * @Date: 2019/11/27/16:25
 */

public interface JedisUtils {

    String get(String key);
    String set(String key, String value);
    Long ttl(String key);
    Long expire(String key, int seconds);
    Long hset(String key, String field, String value);
    String hget(String key, String field);

}
