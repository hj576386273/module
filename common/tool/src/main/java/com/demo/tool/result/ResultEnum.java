package com.demo.tool.result;


/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年10月10日 15:51
 */
public enum ResultEnum {


    success(200, "success"),
    error_403(403, "权限不足"),
    error_404(404, "404 error"),
    error_500(500, "500 error"),
    ;

    ResultEnum(int code, String msg){
        this.code=code;
        this.msg=msg;
    }


    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
