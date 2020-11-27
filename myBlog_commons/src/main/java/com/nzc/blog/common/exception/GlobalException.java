package com.nzc.blog.common.exception;

import com.nzc.blog.common.constant.ResultCode;

/**
 * 全局统一异常处理
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
