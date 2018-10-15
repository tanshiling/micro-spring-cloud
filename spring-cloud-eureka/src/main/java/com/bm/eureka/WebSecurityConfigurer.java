package com.bm.eureka;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *  springboot 2.0.x 加上security安全时需要关闭csrf，否则客户端注册失败，1.5.x 不需要
 */
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        //http.csrf().ignoringAntMatchers("/eureka/**");

        //http.csrf().ignoringAntMatchers("/**").and().authorizeRequests().anyRequest().authenticated().and().httpBasic();
        super.configure(http);
    }
}
