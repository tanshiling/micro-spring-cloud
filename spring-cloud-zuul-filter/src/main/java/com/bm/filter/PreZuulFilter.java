package com.bm.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

@Component
public class PreZuulFilter extends ZuulFilter {

    /**
     * 类型包含 pre post route error
     * pre 代表在代理之前执行
     * route 代表在代理的时候执行
     * error 代表在出错的时候执行
     * post 带表在route 或error 完成之后执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filter 是一个链式调用，一个filter会调用下面的一个filter
     * javaee 中是根据filter的配置先后顺序来决定
     * zuul 是根据order 决定，越小越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否使用过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("执行过滤器");
        return null;
    }
}
