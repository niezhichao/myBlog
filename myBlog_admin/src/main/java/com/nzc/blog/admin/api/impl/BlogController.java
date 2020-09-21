package com.nzc.blog.admin.api.impl;

import com.nzc.blog.admin.api.BlogRestApi;
import com.nzc.business.service.IBlogService;
import com.nzc.business.vo.BlogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController implements BlogRestApi {
    @Autowired
    IBlogService blogService;

    @Value("${from}")
    String temp;

    @GetMapping("/add")
    @Override
    public void insert(BlogVo blogVo) {
        System.out.println(this.temp);
    }

    @Override
    public void update(BlogVo blogVo) {
    }

    @Override
    public void delete(BlogVo blogVo) {

    }



}
