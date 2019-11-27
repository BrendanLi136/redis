package com.qf.j1906;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@SpringBootApplication
public class J1906RedisSessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(J1906RedisSessionApplication.class, args);
    }

}
