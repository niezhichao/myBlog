package com.nzc.blog.common.exception;


import com.nzc.blog.common.constant.BlogConstants;
import com.nzc.blog.common.constant.ResultCode;
import com.nzc.blog.common.result.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public ResultInfo commonException(HttpServletRequest request,Exception ex){
        ex.printStackTrace();
        logger.error("System exception",ex);
        Map<String,String> response = getResponseMap();
        response.put(BlogConstants.REQUEST_URI_KEY,request.getRequestURI());
        return new ResultInfo(response,ResultCode.SYSTEM_ERROR);
    }

    @ExceptionHandler(GlobalException.class)
    public ResultInfo customException(GlobalException ex){
        ex.printStackTrace();
        logger.error("Customize exception:",ex);
        Map<String,String> response = getResponseMap();
        response.put(BlogConstants.RESULT_EXCEPTION_KEY,ex.getExCode()+":  "+ex.getMessage());
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

        MDC.clear();
        return traceIdMap;
    }
}
