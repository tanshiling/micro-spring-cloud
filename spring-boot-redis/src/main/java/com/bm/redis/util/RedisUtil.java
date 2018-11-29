package com.bm.redis.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 * @Title: RedisUtil
 * @Package com.bm.redis.util
 * @Description: TODO()
 * @author: 北明软件
 * @date: 2018/10/8 16:04
 */
public class RedisUtil {

    private RedisTemplate<String,Object> redisTemplate;

    public boolean expire(String key, long time){
        try {
            if (time>0){
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public long getExpire(String key){
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void del(String... key){
        if (key!=null && key.length>0){
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time);
            } else {
                set(key,value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
