package com.config;

import com.entity.Day;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @Auther: ZAT
 * @Date: 2019/12/19 10:12
 * @Description: 配置序列化器
 */
@Configuration
public class RedisConfig{

    @Bean
    public RedisTemplate<String, Day> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String,Day> template=new RedisTemplate<>();
        //关联
        template.setConnectionFactory(factory);
        //设置key的序列化器
        template.setKeySerializer(new StringRedisSerializer());
        //设置value的序列化器
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Day.class));
        return template;
    }

    @Bean
    public RedisTemplate<String, Map> redisTemplate_Map(RedisConnectionFactory factory){
        RedisTemplate<String,Map> template=new RedisTemplate<>();
        //关联
        template.setConnectionFactory(factory);
        //设置key的序列化器
        template.setKeySerializer(new StringRedisSerializer());
        //设置value的序列化器
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Map.class));
        return template;
    }

}
