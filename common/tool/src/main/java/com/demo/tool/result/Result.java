package com.demo.tool.result;

import com.demo.tool.utils.JsonUtils;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年10月10日 15:49
 */
@Data
@Accessors(chain = true)
public class Result<T> {

    private int code;
    private String msg;
    private T data;

    Result(){}

    Result(int code){
        super();
        this.code=code;
    }

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

    @Override
    public String toString(){
        return JsonUtils.toJson(this);
    }

}
