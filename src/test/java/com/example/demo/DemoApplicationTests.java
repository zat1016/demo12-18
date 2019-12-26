package com.example.demo;

import com.entity.Day;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private RedisTemplate<String,String>redisTemplate;
    @Autowired
    private RedisTemplate<String,Day>redisTemplate2;

    @Autowired
    private RedisTemplate<String, Map>mapRedisTemplate;

    @Test
    public void set(){
        redisTemplate.opsForValue().set("myKey","myValue");
        System.out.println(redisTemplate.opsForValue().get("myKey"));
        rtest1();
        rTest2();
        mapRedisTemplate.delete("now");
    }

    public void rTest2(){
        Map map = new HashMap();
        map.put("sf",new Date().getTime());
        mapRedisTemplate.opsForValue().set("now",map);
        Map value = mapRedisTemplate.opsForValue().get("now");

        System.out.println(value.toString());
    }

    public void rtest1(){
        Day d=new Day();
        d.setDate("123");
        d.setDaysId("456");
        d.setItemNumber(123);
        d.setOpenId("dawda");
        d.setTitle("title");
        redisTemplate2.opsForValue().set("day",d);
        Day val = redisTemplate2.opsForValue().get("day");
        System.out.println(val.toString());
    }

//    @Test
//    void contextLoads() {
//        this.testSet();
//    }
//
//    @Autowired
//    private RedisTemplate<String, Day> redisTemplate;
//    @Resource
//    private Day d;
//
//    public void before(){
//        d=new Day();
//        d.setDate("123");
//        d.setDaysId("456");
//        d.setItemNumber(123);
//        d.setOpenId("dawda");
//        d.setTitle("title");
//    }
//
//    public void testSet(){
//        before();
//        redisTemplate.opsForValue().set("days",d);
//        System.out.println((redisTemplate.opsForValue().get("days")));
//
//    }

}
