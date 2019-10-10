package com.demo.tool.result;

import lombok.Data;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年10月10日 15:49
 */
@Data
public class Result<T> {

    private int code;
    private String msg;
    private T data;

    Result(int code, String msg){
        super();
        this.code=code;
        this.msg=msg;
    }

    Result(int code, String msg, T data){
        super();
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    Result(ResultEnum resultEnum){
        super();
        this.code=resultEnum.getCode();
        this.msg=resultEnum.getMsg();
    }

    Result(ResultEnum resultEnum, T data){
        super();
        this.code=resultEnum.getCode();
        this.msg=resultEnum.getMsg();
        this.data=data;
    }

}
