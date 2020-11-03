package com.nzc.blog.admin.api.impl;

import com.github.pagehelper.PageInfo;
import com.nzc.blog.admin.api.BlogRestApi;
import com.nzc.blog.business.entity.Blog;
import com.nzc.blog.business.result.ResultInfo;
import com.nzc.blog.business.service.IBlogService;
import com.nzc.blog.business.vo.BlogVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "博客管理相关接口",tags = "BlogRestApi")
@RestController
@RequestMapping("blog")
public class BlogController implements BlogRestApi {
    @Autowired
    IBlogService blogService;

    /**
     *接收参数注释使用@RequestBody
     * 前端传过来的参数对象的属性名和vo参数的属性名相同就可接收参数
     * 参数在请求体中  所以必须要post方式提交
     * @param blogVo
     * @return
     */
    @ApiOperation(value = "添加博客",notes = "添加博客")
    @PostMapping("/add")
    @Override
    public ResultInfo insert(@RequestBody BlogVo blogVo) {
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


    @ApiOperation(value = "获取博客列表",notes = "获取博客列表")
    @PostMapping("/list")
    public ResultInfo getBlogList(@RequestBody BlogVo blogVo){
        PageInfo<List<Blog>> pageInfo = blogService.queryListWithPage(blogVo);
        return ResultInfo.page(pageInfo);
    }
}
