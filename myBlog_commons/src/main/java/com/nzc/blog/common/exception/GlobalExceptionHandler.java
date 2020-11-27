package com.nzc.blog.common.exception;

import com.nzc.blog.common.constant.ResultCode;
import com.nzc.blog.common.result.ResultInfo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultInfo commonException(Exception ex){
        ex.printStackTrace();
        return new ResultInfo(ResultCode.ERROR.getCode(),ex.getMessage());
    }

    @ExceptionHandler(GlobalException.class)
    public ResultInfo customException(GlobalException ex){
        ex.printStackTrace();
        return new  ResultInfo(ex.getExCode(),ex.getMessage());
    }
}
