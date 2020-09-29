package com.nzc.blog.business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nzc.business")
public class BusiApp {
    public static void main(String[] args){
        SpringApplication.run(BusiApp.class,args);
    }
}
