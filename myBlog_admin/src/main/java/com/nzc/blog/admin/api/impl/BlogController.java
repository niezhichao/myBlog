package com.nzc.blog.admin.api.impl;

import com.nzc.blog.admin.api.BlogRestApi;
import com.nzc.blog.common.result.ResultInfo;
import com.nzc.blog.business.service.IBlogService;
import com.nzc.blog.business.vo.BlogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("blog")
public class BlogController implements BlogRestApi {
    @Autowired
    IBlogService blogService;

    @PostMapping("/add")
    @Override
    public ResultInfo insert(BlogVo blogVo) {
        blogService.insert(blogVo);
        return ResultInfo.ok();
    }

    @Override
    public ResultInfo update(BlogVo blogVo) {
        return null;
    }

    @Override
    public ResultInfo delete(BlogVo blogVo) {
            return null;
    }



}
