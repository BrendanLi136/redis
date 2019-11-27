package com.qf.j1906.service.impl;



import com.qf.j1906.mapper.EmpMapper;
import com.qf.j1906.pojo.Emp;
import com.qf.j1906.pojo.EmpExample;
import com.qf.j1906.service.EmpService;
import com.qf.j1906.util.JedisUtils;
import com.qf.j1906.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: Brendan Li
 * @description
 * @Date: 2019/11/27/14:56
 */
@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
//    @Autowired
//    private Jedis jedis;
    @Autowired
    private JedisUtils jedisUtils;

    @Override
    public List<Emp> getEmps() {

//        Jedis jedis = new Jedis("127.0.0.1",6379);

        //1.从redis取值
        try {
//            String hget = jedis.hget("my", "emp");
            String hget = jedisUtils.hget("my", "emp");
            if(!StringUtils.isEmpty(hget)){
                log.info("redis query...");
                List<Emp> emps = JsonUtils.jsonToList(hget, Emp.class);
                return emps;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //2.从db取值
        log.info("db query...");
        EmpExample empExample = new EmpExample();
        List<Emp> emps = empMapper.selectByExample(empExample);

        //3.将结果放入redis中
        String empJson = JsonUtils.objectToJson(emps);
//        jedis.hset("my","emp",empJson);
        jedisUtils.hset("my","emp",empJson);
        return emps;

    }
}
