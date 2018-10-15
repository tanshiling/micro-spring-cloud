package com.bm.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "producer",fallback = Consumer2FeignImpl.class)
public interface Consumer2Feign {

    @RequestMapping(value = "/hello")
    public String consumer2(@RequestParam(value = "name") String name);
}
