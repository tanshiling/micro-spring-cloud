package com.bm.consumer.controller;

import com.bm.consumer.feign.ConsumerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    ConsumerFeign consumerFeign;

    @RequestMapping("/hello/{name}")
    public String consumer(@PathVariable("name") String name){
        return consumerFeign.consumer(name);
    }
    /**
     * 测试负载均衡
     * @return
     */
    @RequestMapping("/test")
    public String testBalance(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("producer");
        System.err.println(serviceInstance.getServiceId()+":"+serviceInstance.getHost()+":"+serviceInstance.getPort());
        return "abc";
    }

    public String fallback(){
        return "This is fallback";
    }
}
