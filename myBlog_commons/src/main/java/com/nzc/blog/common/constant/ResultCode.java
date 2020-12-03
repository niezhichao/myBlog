package com.nzc.blog.common.constant;

public enum ResultCode {

    SUCCESS("Request successfully","0000"),
    ERROR("Application exception occurred","0001"),
    FILE_UPLOAD_SUCCESS("File upload successfully","FU000"),
    FILE_UPLOAD_FAILED("File upload failed","FU001"),
    FILE_UPLOAD_EMPTY("File is empty","FU002");
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
