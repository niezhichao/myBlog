package com.nzc.blog.common.exception;

import brave.Span;
import brave.Tracer;
import brave.sampler.Sampler;
import com.nzc.blog.common.constant.ResultCode;
import com.nzc.blog.common.result.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestTemplate;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private RestTemplate restTemplate = new RestTemplate();
    @ExceptionHandler(Exception.class)
    public ResultInfo commonException(Exception ex){
        ex.printStackTrace();
        ResponseEntity<String>  res = restTemplate.postForEntity("localhost:8897",new HttpHeaders(),String.class);
        logger.error("系统异常",ex);
        System.out.println(res.getBody());
        return new ResultInfo(ResultCode.ERROR.getCode(),ex.getMessage());
    }

    @ExceptionHandler(GlobalException.class)
    public ResultInfo customException(GlobalException ex){
        ex.printStackTrace();
        logger.error("系统异常",ex);
        return new  ResultInfo(ex.getExCode(),ex.getMessage());
    }
}
