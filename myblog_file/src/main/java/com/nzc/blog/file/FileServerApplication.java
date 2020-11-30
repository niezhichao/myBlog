package com.nzc.blog.file;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"com.nzc.blog.file"})
@MapperScan("com.nzc.blog.admin.dao")
public class FileServerApplication {
    public static void main(String[]  args){
        SpringApplication.run(FileServerApplication.class,args);
    }
}
