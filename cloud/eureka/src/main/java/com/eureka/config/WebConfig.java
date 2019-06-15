package com.eureka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年06月15日
 * @description: TODO
 */
@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        更好的办法是,配置/eureka/**忽略csrf防御拦截,直接放行(/eureka/**是在application.yml中配置的eureka注册地址)
        http.csrf().ignoringAntMatchers("/eureka/**");
        http.csrf().disable();
        super.configure(http);
    }
}
