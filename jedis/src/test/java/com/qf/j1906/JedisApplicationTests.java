package com.qf.j1906;

import com.qf.j1906.pojo.Emp;
import com.qf.j1906.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class JedisApplicationTests {

    @Test
    public void testJedis() {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        String stu = jedis.set("stu", "61");
        log.info("stu:"+stu);
        String s = jedis.get("stu");
        log.info(s);

    }

    @Autowired
    private EmpService service;
    @Test
    public void testService(){
        List<Emp> emps = service.getEmps();
        for (Emp emp : emps) {
            log.info(emp.toString());
        }
    }

}
