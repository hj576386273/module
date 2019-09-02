package com.demo.tool.exception;

public class CheckException extends RuntimeException  {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4525940889962260348L;
	
	private Integer errorCode = 301;
    private String msg;

    public CheckException(String msg) {
    	super(msg);
    	this.msg = msg;
    }

    public CheckException(Integer errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer code) {
        this.errorCode = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
