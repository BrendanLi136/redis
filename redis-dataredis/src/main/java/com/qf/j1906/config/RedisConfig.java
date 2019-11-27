package com.qf.j1906.config;

import com.qf.j1906.util.RedisUtilsSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author: Brendan Li
 * @description redis配置
 * @Date: 2019/11/27/19:20
 */
@Configuration
public class RedisConfig {

    //    自动加载application.propertis中关于redis的配置参数并初始化JedisConnectionFactory对象
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String,Object> redisTemplate(@Qualifier("jedisConnectionFactory")JedisConnectionFactory jedisConnectionFactory){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        //设置redisTemplate的对象配置参数
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        //设置redisTemplate对key值的序列化转换器
        redisTemplate.setKeySerializer(new RedisUtilsSerializer());
        //设置redisTemplate对Value值的序列化转换器
        redisTemplate.setValueSerializer(new RedisUtilsSerializer());
        return redisTemplate;
    }



}
