package com.security.config.handler;

import com.demo.tool.result.Result;
import com.demo.tool.result.ResultEnum;
import com.demo.tool.result.ResultTool;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年10月10日 17:32
 */
@Component
public class SysAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        Result result = ResultTool.builder().setCode(ResultEnum.error_404.getCode());
        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
            result.setMsg("用户名或密码输入错误，登录失败!");
        } else if (e instanceof DisabledException) {
            result.setMsg("账户被禁用，登录失败，请联系管理员!");
        } else {
            result.setMsg("登录失败!");
        }
        out.write(result.toString());
        out.flush();
        out.close();
    }
}
