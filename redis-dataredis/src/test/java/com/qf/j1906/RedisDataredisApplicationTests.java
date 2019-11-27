package com.qf.j1906;

import com.qf.j1906.pojo.Emp;
import com.qf.j1906.service.Emp2Service;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDataredisApplicationTests {

    @Autowired
    private Emp2Service empService;
    @Test
    public void testEmp() {

        List<Emp> emps = empService.getEmps();
        for (Emp emp : emps) {
            log.info(emp.toString());
        }
    }

}
