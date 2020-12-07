package com.nzc.blog.common.aop;

import com.nzc.blog.common.constant.BlogConstants;
import com.nzc.blog.common.utils.CommonUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author  niezhichao
 */
@Aspect
@Configuration
public class RequestAop {
    private static final Logger logger = LoggerFactory.getLogger(RequestAop.class);

    /**
     * 1  the the first sympol * in the expression of this Pointcut represent any returned value
     * 2  the seceond sympol *  represent random name of packege
     * 3  *(..): random method name and arguments
     */
    @Pointcut("execution(* com.nzc.blog.*.api.impl.*.*(..))")
    public void  executionService(){

    }

    /**
     *call this method before method of this pointcut called
     * @param joinPoint
     */
    @Before(value = "executionService()")
    public void doBefore(JoinPoint joinPoint){
        String traceId = CommonUtil.getRequestId();
        MDC.put(BlogConstants.LOG_ID_KEY,traceId);
        logger.info("The id trace current request is："+traceId);
    }


    @AfterReturning(pointcut = "executionService()",returning = "returnValue")
    public  void doAfter(JoinPoint joinPoint,Object returnValue){
        logger.info("Api responce successfully");
       MDC.clear();
    }

    @AfterThrowing(pointcut = "executionService()",throwing = "ex")
    public void afterThrowing(JoinPoint point, Exception ex){
        logger.error("Method afterThrowing:"+ex.getCause());
    }
}
