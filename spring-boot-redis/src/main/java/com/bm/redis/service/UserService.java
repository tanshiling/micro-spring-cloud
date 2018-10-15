package com.bm.redis.service;

import com.bm.redis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 * @Title: UserService
 * @Package com.bm.redis.service
 * @Description: TODO()
 * @author: 北明软件
 * @date: 2018/10/8 16:27
 */
@Service
public class UserService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    //根据 key 存储user对象
    public void set(String key, User user){
        redisTemplate.opsForValue().set(key,user);
    }

    public User get(String key){
        return  (User) redisTemplate.boundValueOps(key);
    }

    //存储key，value均为string的操作，有效时长60s，过期数据自动销毁
    public void setCode(String key,String code){
        stringRedisTemplate.opsForValue().set(key,code,60, TimeUnit.SECONDS);
    }

    public String getCode(String key){
        return stringRedisTemplate.boundValueOps(key).get();
    }
}
