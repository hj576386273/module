package com.security.controller;

import com.demo.tool.result.Result;
import com.demo.tool.result.ResultTool;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年10月10日 15:45
 */
@RestController
@RequestMapping(value = "/security-test")
public class SecurityTestController {

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(String username){
        return "username: " + username;
    }

    @RequestMapping("/login_p")
    public Result login() {
        return ResultTool.error("未登录");
    }
}
