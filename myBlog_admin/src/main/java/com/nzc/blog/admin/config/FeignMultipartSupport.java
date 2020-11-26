package com.nzc.blog.admin.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Feign远程调用报错:
 * No serializer found for class java.io.FileDescriptor and no properties discovered to create BeanSerializer
 *
 * 加入这个配置类解决上述异常
 */
@Configuration
public class FeignMultipartSupport {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    public Encoder feignFormEncoder(){
        return  new SpringFormEncoder(new SpringEncoder(messageConverters));
    }
}
