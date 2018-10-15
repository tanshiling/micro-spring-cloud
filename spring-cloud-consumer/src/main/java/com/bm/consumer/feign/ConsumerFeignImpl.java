package com.bm.consumer.feign;

import org.springframework.stereotype.Component;

@Component //@Service
public class ConsumerFeignImpl implements ConsumerFeign {

    @Override
    public String consumer(String name) {
        return name+" is fallback";
    }
}
