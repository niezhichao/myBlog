package com.nzc.blog.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"com.nzc.blog.admin", "com.nzc.blog.admin.service.impl"})
@MapperScan("com.nzc.blog.admin.dao")
public class AdminApplication {
    public static void main(String[]  args){
        SpringApplication.run(AdminApplication.class,args);
    }
}
