package com.qf.j1906.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: Brendan Li
 * @description jedis
 * @Date: 2019/11/27/16:09
 */
@Configuration
public class JedisConfig {

    @Value("${myredis.host}")
    private String host;
    @Value("${myredis.port}")
    private Integer port;

    @Bean
    public Jedis getJedis(){
        return new Jedis(host,port);
    }

    //封装jedispool配置对象 (将配置注入其中)
    @Bean
    public JedisPool getJedisPool(@Qualifier("jedisPoolConfig")JedisPoolConfig jedisPoolConfig){
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port);
        return  jedisPool;
    }

//    封装jedispool配置对象
    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxTotal(30);
        return jedisPoolConfig;
    }
}
