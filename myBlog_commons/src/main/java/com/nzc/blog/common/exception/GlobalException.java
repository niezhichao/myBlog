package com.nzc.blog.common.exception;

import com.nzc.blog.common.constant.ResultCode;

/**
 * 自定义全局异常
 */
public class GlobalException extends RuntimeException{

    private String exCode;

    public GlobalException(String exCode, String exMsg){
        super(exMsg);
        this.exCode = exCode;
    }

    public GlobalException(ResultCode resultCode){
        this(resultCode.getCode(), resultCode.getMsg());
    }

    public String getExCode() {
        return exCode;
    }
}
