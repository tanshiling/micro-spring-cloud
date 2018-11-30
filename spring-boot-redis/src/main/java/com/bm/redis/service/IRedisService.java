package com.bm.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract class IRedisService<T> {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Resource
    HashOperations<String, String, T> hashOperations;

    /**
     * 存入 redis 中的 key
     *
     * @return
     */
    protected abstract String getRedisKey();

    /**
     * 添加
     *
     * @param key    key
     * @param domain    对象
     * @param expire    过期时间（单位：秒），-1代表无限制
     */
    public void put(String key, T domain, long expire) {
        hashOperations.put(getRedisKey(), key, domain);
        if (expire != 1) {
            redisTemplate.expire(getRedisKey(), expire, TimeUnit.SECONDS);
        }
    }

    /**
     * 删除
     *
     * @param key
     */
    public void remove(String key) {
        hashOperations.delete(getRedisKey(), key);
    }

    /**
     * 查询
     *
     * @param key
     * @return
     */
    public T get(String key) {
        return hashOperations.get(getRedisKey(), key);
    }

    /**
     * 查询所有对象
     *
     * @return
     */
    public List<T> getAll() {
        return hashOperations.values(getRedisKey());
    }

    /**
     * 获取所有key
     *
     * @return
     */
    public Set<String> getKeys() {
        return hashOperations.keys(getRedisKey());
    }

    /**
     * 查询是否存在
     *
     * @param key
     * @return
     */
    public boolean isKeyExists(String key) {
        return hashOperations.hasKey(getRedisKey(), key);
    }

    /**
     * 查询当前key下缓存数量
     *
     * @return
     */
    public long count() {
        return hashOperations.size(getRedisKey());
    }

    /**
     * 清空redis
     *
     */
    public void empty() {
        Set<String> set = hashOperations.keys(getRedisKey());
        set.stream().forEach(key -> hashOperations.delete(getRedisKey(),key));
    }
}
