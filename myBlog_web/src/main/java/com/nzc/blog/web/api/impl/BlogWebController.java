package com.nzc.blog.web.api.impl;

import com.nzc.blog.common.result.ResultInfo;
import com.nzc.blog.web.api.BlogWebRestApi;
import com.nzc.blog.web.feign.BlogInfoFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "博客首页接口",tags = "BlogWebRestApi")
@RestController
@RequestMapping("home")
public class BlogWebController implements BlogWebRestApi {

    @Autowired
    BlogInfoFeign blogInfoFeign;

    @ApiOperation(value = "获取首页头部菜单",notes = "获取首页头部菜单")
    @GetMapping("/header")
    @Override
    public ResultInfo getHeaderMenu() {
        return blogInfoFeign.getAll();
    }
}
