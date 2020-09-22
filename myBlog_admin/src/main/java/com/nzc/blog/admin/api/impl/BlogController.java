package com.nzc.blog.admin.api.impl;

import com.nzc.blog.admin.api.BlogRestApi;
import com.nzc.business.service.IBlogService;
import com.nzc.business.vo.BlogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BlogController implements BlogRestApi {
    @Autowired
    IBlogService blogService;

    @GetMapping("/add")
    @Override
    public void insert(BlogVo blogVo) {
        BlogVo test = new BlogVo();
        test.setBlogId("1111");
        Date date =  new Date();
        test.setCreateTime(date);
        test.setUpdateTime(date);
        blogService.insert(test);
    }

    @Override
    public void update(BlogVo blogVo) {
    }

    @Override
    public void delete(BlogVo blogVo) {

    }



}
