package com.bm.consumer.feign;

import org.springframework.stereotype.Component;

@Component //@Service
public class Consumer2FeignImpl implements Consumer2Feign {

    @Override
    public String consumer2(String name) {
        return name+" is fallback2";
    }
}
