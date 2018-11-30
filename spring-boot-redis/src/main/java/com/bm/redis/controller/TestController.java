package com.bm.redis.controller;

import com.bm.redis.entity.RedisModel;
import com.bm.redis.service.Impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    RedisServiceImpl redisService;

    /**
     * 添加
     *
     */
    @RequestMapping("/add")
    public void test() {
        System.out.println("start...");

        RedisModel redisModel1 = new RedisModel();
        redisModel1.setName("张三");
        redisModel1.setTel("123");
        redisModel1.setAddress("北京");
        redisModel1.setRedisKey("zhangsan01");
        redisService.put(redisModel1.getRedisKey(),redisModel1,-1);

        RedisModel redisModel2 = new RedisModel();
        redisModel2.setName("张三");
        redisModel2.setTel("123");
        redisModel2.setAddress("北京");
        redisModel2.setRedisKey("zhangsan02");
        redisService.put(redisModel2.getRedisKey(),redisModel2,-1);

        RedisModel redisModel3 = new RedisModel();
        redisModel3.setName("张三");
        redisModel3.setTel("123");
        redisModel3.setAddress("北京");
        redisModel3.setRedisKey("zhangsan03");
        redisService.put(redisModel3.getRedisKey(),redisModel3,-1);
    }

    /**
     * 查询所有对象
     *
     * @return
     */
    @RequestMapping("/getAll")
    public Object getAll() {
        return redisService.getAll();
    }

    /**
     * 查询所有key
     *
     * @return
     */
    @RequestMapping("/getKeys")
    public Object getKeys() {
        return redisService.getKeys();
    }

    /**
     * 根据 key 查询
     *
     * @return
     */
    @RequestMapping("/get")
    public Object get() {
        RedisModel redisModel = new RedisModel();
        redisModel.setRedisKey("zhangsan02");
        return redisService.get(redisModel.getRedisKey());
    }

    /**
     * 删除
     */
    @RequestMapping("/remove")
    public void remove() {
        RedisModel redisModel = new RedisModel();
        redisModel.setRedisKey("zhangsan01");
        redisService.remove(redisModel.getRedisKey());
    }

    /**
     * 查询key是否存在
     *
     */
    @RequestMapping("/isKeyExists")
    public void isKeyExists() {
        RedisModel redisModel = new RedisModel();
        redisModel.setRedisKey("zhangsan02");
        boolean keyExists = redisService.isKeyExists(redisModel.getRedisKey());
        System.out.println("zhangsan02是否存在：" + keyExists);
    }

    /**
     * 查询当前缓存的数量
     */
    @RequestMapping("/count")
    public Object count() {
        return redisService.count();
    }

    /**
     * 清除keys
     */
    @RequestMapping("/empty")
    public void empty() {
        redisService.empty();
    }
}
