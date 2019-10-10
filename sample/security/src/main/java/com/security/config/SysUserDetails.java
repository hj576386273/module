package com.security.config;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年10月10日 15:33
 */
@Data
public class SysUserDetails implements UserDetails {

    private String username;
    private String password;

    private Collection<? extends GrantedAuthority> authorities;


    public SysUserDetails(String username, String password){
        super();
        this.username=username;
        this.password=password;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
