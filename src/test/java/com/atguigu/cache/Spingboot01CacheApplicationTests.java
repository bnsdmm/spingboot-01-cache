package com.atguigu.cache;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Spingboot01CacheApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;  //操作k-v都是字符串

    @Autowired
    RedisTemplate redisTemplate;//k-v都是对象

    @Autowired
    RedisTemplate<Object,Employee> empRedisTemplate;

    @Test
    public void test01(){
        stringRedisTemplate.opsForValue().append("name","张三");
    }

    @Test
    public void test02(){
        Employee employee=employeeMapper.getEmpById(1);
       // System.out.println(employee);
        //redisTemplate.opsForValue().set("emp01",employee);
        //将数据以json的方式保存
        //手动将对象转为json
        //redisTemplate 默认的序列化规则；改编默认的序列化规则
        //Map map=new HashMap();
       // map.put("keyone","2019年十一月五日");
        //String mapStr= JSONObject.toJSONString(map);
        //stringRedisTemplate.opsForValue().set("emp-0",mapStr);
       // redisTemplate.opsForValue().set("emp-06",map);
       // System.out.println(redisTemplate.opsForValue().get("map-06"));
        empRedisTemplate.opsForValue().set("emp-00",employee);
    }

    @Test
    void contextLoads() {
        Employee employee=employeeMapper.getEmpById(1);
        System.out.println(employee);
    }

}
