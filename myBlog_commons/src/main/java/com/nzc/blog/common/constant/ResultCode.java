package com.nzc.blog.common.constant;

public enum ResultCode {

    SUCCESS("REQUEST SUCCESS","0000"),
    ERROR("APPLICATION EXCEPTION","0001"),
    FILE_UPLOAD_SUCCESS("FILE UPLOAD SUCCESS","FU000"),
    FILE_UPLOAD_FAILED("FILE UPLOAD FAILED","FU001"),
    FILE_UPLOAD_EMPTY("FILE EMPTY","FU002");
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
