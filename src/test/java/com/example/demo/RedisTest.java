package com.example.demo;

import com.entity.Day;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @Auther: ZAT
 * @Date: 2019/12/19 16:02
 * @Description:
 */
@SpringBootTest
class RedisTest {
    @Autowired
    private RedisTemplate<String, Day> redisTemplate;

    @Resource
    private Day d;

    public void before(){
        d=new Day();
        d.setDate("123");
        d.setDaysId("456");
        d.setItemNumber(123);
        d.setOpenId("dawda");
        d.setTitle("title");
    }

    @Test
    public void testSet(){
        before();
        redisTemplate.opsForValue().set("days",d);
        System.out.println((redisTemplate.opsForValue().get("days")));
    }

}
