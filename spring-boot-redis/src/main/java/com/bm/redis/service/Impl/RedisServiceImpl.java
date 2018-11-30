package com.bm.redis.service.Impl;

import com.bm.redis.entity.RedisModel;
import com.bm.redis.service.IRedisService;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl extends IRedisService<RedisModel> {

    public static final String REDIS_KEY = "TEST_REDIS_KEY";

    @Override
    protected String getRedisKey() {

        return this.REDIS_KEY;
    }
}
