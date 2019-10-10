package com.demo.tool.result;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年10月10日 16:27
 */
public class ResultTool {

    public static Result builder(){
        return new Result();
    }

    public static Result success(){
        return new Result(ResultEnum.success);
    }

    public static Result errorDenied(){
        return new Result(ResultEnum.error_403);
    }

    public static Result error(){
        return new Result(ResultEnum.error_404);
    }

    public static Result error(String msg){
        return builder().setCode(ResultEnum.error_404.getCode()).setMsg(msg);
    }
}
