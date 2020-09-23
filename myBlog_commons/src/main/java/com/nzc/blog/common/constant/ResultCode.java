package com.nzc.blog.common.constant;

public enum ResultCode {

    SUCCESS("成功","00");
    private String msg;
    private String code;

    private ResultCode(String msg,String code){
        this.msg = msg;
        this.code = code;
    }

    public String getMsg(){
        return this.msg;
    }

    public String getCode(){
        return this.code;
    }
}
