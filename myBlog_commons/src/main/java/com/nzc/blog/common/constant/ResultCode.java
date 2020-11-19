package com.nzc.blog.common.constant;

public enum ResultCode {

    SUCCESS("成功","00"),
    FILE_UPLOAD_SUCCESS("文件上传成功","FU000"),
    FILE_UPLOAD_FAILED("文件上失败","FU001"),
    FILE_UPLOAD_EMPTY("文件为空","FU002");
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
