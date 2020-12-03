package com.nzc.blog.common.exception;

import brave.Span;
import brave.Tracer;
import brave.sampler.Sampler;
import com.nzc.blog.common.constant.BlogConstants;
import com.nzc.blog.common.constant.ResultCode;
import com.nzc.blog.common.result.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public ResultInfo commonException(Exception ex){
        ex.printStackTrace();
        logger.error("系统异常",ex);
        return new ResultInfo(getResponseMap(),ResultCode.ERROR);
    }

    @ExceptionHandler(GlobalException.class)
    public ResultInfo customException(GlobalException ex){
        ex.printStackTrace();
        logger.error("自定义异常",ex);
        Map<String,String> response = getResponseMap();
        response.put(ex.getExCode(),ex.getMessage());
        return new  ResultInfo(response,ResultCode.ERROR);
    }

    /**
     * MDC(Mapped Diagnostic Context，映射调试上下文):是 log4j 、logback及log4j2 提供的一种方便在多线程条件
     * 下记录日志的功能,MDC 可以看成是一个与当前线程绑定的哈希表
     *
     * 1 从MDC中取出取出zipkin的TraceId
     * 2 从MDC中取出取出requestId(跟踪日志的Id)
     */
    private Map<String,String> getResponseMap(){
        Map<String,String> traceIdMap = new HashMap<>();
        String zipkinTraceId = MDC.get(BlogConstants.ZIPKIN_TRACEID_KEY);
        traceIdMap.put(BlogConstants.ZIPKIN_TRACEID_KEY,zipkinTraceId);
        String logId = MDC.get(BlogConstants.LOG_ID_KEY);
        traceIdMap.put(BlogConstants.LOG_ID_KEY,logId);
        return traceIdMap;
    }
}
