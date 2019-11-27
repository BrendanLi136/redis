package com.qf.j1906.service.impl;

import com.qf.j1906.mapper.EmpMapper;
import com.qf.j1906.pojo.Emp;
import com.qf.j1906.pojo.EmpExample;
import com.qf.j1906.service.Emp2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Brendan Li
 * @description
 * @Date: 2019/11/27/19:19
 */
@Service
public class Emp2ServiceImpl implements Emp2Service {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Emp> getEmps() {

        List<Emp> empp = (List<Emp>)redisTemplate.opsForValue().get("empp");

        if (empp!=null)
          return empp;

        //从db取值
        EmpExample empExample = new EmpExample();
        List<Emp> emps = empMapper.selectByExample(empExample);


        //写入redis中
        redisTemplate.opsForValue().set("empp",emps);
        return emps;
    }
}
