package com.bm.redis.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @version V1.0
 * @Title: RedisConfig
 * @Package com.bm.redis.config
 * @Description: TODO()
 * @author: 北明软件
 * @date: 2018/10/8 16:12
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    /*
    //springboot 2.0 RedisCacheManager没有RedisTemplate传参构造方法
    @Bean
    public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate) {
        CacheManager cacheManager = new RedisCacheManager(redisTemplate);
        return cacheManager;
    }
    */

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisCacheManager redisCacheManager = RedisCacheManager.create(factory);
        return redisCacheManager;
    }

    //默认 jdk 序列方式，可以用来保存对象
    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }

    //默认 string 序列化方式，一般存储 string 格式
    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(factory);
        return stringRedisTemplate;
    }
}
