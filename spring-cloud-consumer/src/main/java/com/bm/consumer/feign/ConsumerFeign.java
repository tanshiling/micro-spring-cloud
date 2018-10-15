package com.bm.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "producer",fallback = ConsumerFeignImpl.class)
public interface ConsumerFeign {

    @RequestMapping(value = "/hello")
    public String consumer(@RequestParam(value = "name") String name);

}
