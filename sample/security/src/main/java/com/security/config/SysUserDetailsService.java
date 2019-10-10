package com.security.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年10月10日 15:22
 */
@Service
public class SysUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("zhangsan".equals(username)) {
            SysUserDetails sysUser = new SysUserDetails("zhangsan", new BCryptPasswordEncoder().encode("123456"));
            return sysUser;
        } else if ("lisi".equals(username)) {
            SysUserDetails sysUser = new SysUserDetails("lisi", new BCryptPasswordEncoder().encode("123456"));
            return sysUser;
        } else {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
    }
}
