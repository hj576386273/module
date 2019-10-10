package com.demo.tool.result;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年10月10日 16:27
 */
public class ResultTool {

    public static Result success(){
        return new Result(ResultEnum.success);
    }

    public static Result error(){
        return new Result(ResultEnum.error_404);
    }

    public static Result error(String msg){
        return new Result(ResultEnum.error_404.getCode(), msg);
    }
}
