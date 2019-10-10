package com.security.config;

import com.security.config.handler.SysAccessDeniedHandler;
import com.security.config.handler.SysAuthenticationFailureHandler;
import com.security.config.handler.SysAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年10月10日 15:16
 */
@Configuration
@EnableWebSecurity
//启用方法级别的权限认证
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SysFilterInvocationSecurityMetadataSource sysFilterInvocationSecurityMetadataSource;
    @Autowired
    private SysAccessDecisionManager sysAccessDecisionManager;
    @Autowired
    private SysAccessDeniedHandler sysAccessDeniedHandler;
    @Autowired
    private SysUserDetailsService sysUserDetailsService;
    @Autowired
    private SysAuthenticationFailureHandler sysAuthenticationFailureHandler;
    @Autowired
    private SysAuthenticationSuccessHandler sysAuthenticationSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(sysUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/index.html", "/static/**", "/login_p", "/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setSecurityMetadataSource(sysFilterInvocationSecurityMetadataSource);
                o.setAccessDecisionManager(sysAccessDecisionManager);
                return o;
            }
        }).and().formLogin().loginPage("/login_p").loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password").permitAll()
              .failureHandler(sysAuthenticationFailureHandler)
              .successHandler(sysAuthenticationSuccessHandler)
          .and().logout().permitAll()
          .and().csrf().disable().exceptionHandling().accessDeniedHandler(sysAccessDeniedHandler);
    }
}
