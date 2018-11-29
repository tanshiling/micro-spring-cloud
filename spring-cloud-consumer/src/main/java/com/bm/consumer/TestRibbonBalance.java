package com.bm.consumer;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注意路径问题
 */
@Configuration
@com.bm.consumer.ExcludeCommentScan
public class TestRibbonBalance {

    @Autowired
    IClientConfig clientConfig;

    /**
     * 创建负载均衡算法
     * @param config
     * @return
     */
    @Bean
    public IRule ribbonRule(IClientConfig config){
        return new RandomRule();//随机算法
    }
}
