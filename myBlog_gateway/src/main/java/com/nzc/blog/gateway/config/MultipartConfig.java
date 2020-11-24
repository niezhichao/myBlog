package com.nzc.blog.gateway.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * 配置请求大小的上限 和最大文件上传上限
 */
@Configuration
public class MultipartConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大10M,设置为100MB
        factory.setMaxFileSize(100*1024*1024);
        // 设置请求大小上限150MB
        factory.setMaxRequestSize(150*1024*1024);
        return factory.createMultipartConfig();
    }
}
