package com.nzc.blog.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@EnableEurekaClient
@ComponentScan({"com.nzc.blog.web.api.impl"})
@SpringBootApplication
public class WebApplication {
    public static void main(String[]  args){
        SpringApplication.run(WebApplication.class,args);
    }
}
