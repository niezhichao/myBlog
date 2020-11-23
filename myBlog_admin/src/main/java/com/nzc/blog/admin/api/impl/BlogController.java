package com.nzc.blog.admin.api.impl;

import com.github.pagehelper.PageInfo;
import com.nzc.blog.admin.api.BlogRestApi;
import com.nzc.blog.business.dto.BlogDto;
import com.nzc.blog.business.entity.Blog;
import com.nzc.blog.business.result.ResultInfo;
import com.nzc.blog.business.service.IBlogService;
import com.nzc.blog.business.vo.BlogVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
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
     * @param blogDto
     * @return
     */
    @ApiOperation(value = "添加博客",notes = "添加博客")
    @PostMapping("/add")
    @Override
    public ResultInfo insert(@RequestBody BlogDto blogDto) {
        blogService.insert(blogDto);
        return ResultInfo.ok();
    }

    @ApiOperation(value = "更新博客",notes = "更新博客")
    @PostMapping("/update")
    @Override
    public ResultInfo update(@RequestBody(required = false) BlogDto blogDto) {
        blogService.update(blogDto);
        return ResultInfo.ok();
    }

    @Override
    public ResultInfo delete(BlogDto blogDto) {
        return null;
    }

    @ApiOperation(value = "删除博客",notes = "删除博客")
    @PostMapping("/delete/one")
    public ResultInfo deleteById(@RequestParam("id") Serializable id){
        blogService.deleteById(id);
        return ResultInfo.ok();
    }

    @ApiOperation(value = "批量删除博客",notes = "批量删除博客")
    @PostMapping("/delete/list")
    @Override
    public ResultInfo deleteByIds(@RequestParam(name="ids") List<Serializable> ids) {
        blogService.deleteByIds(ids);
        return ResultInfo.ok();
    }

    @ApiOperation(value = "获取博客列表",notes = "获取博客列表")
    @PostMapping("/list")
    public ResultInfo getBlogList(@RequestBody BlogDto blogDto){
        PageInfo<BlogVo> pageInfo = blogService.queryListWithPage(blogDto);
        return ResultInfo.page(pageInfo);
    }

    @ApiOperation(value = "博客预览",notes = "博客预览")
    @PostMapping("/content")
    @Override
    public ResultInfo getBlogContentById(@RequestParam("id") Serializable id) {
        String blogCnt = blogService.getBlogContentById(id);
        return ResultInfo.response(blogCnt);
    }

    @ApiOperation(value = "首页轮播",notes = "首页轮播")
    @PostMapping("/carousal")
    public ResultInfo getCarousalBlog(@RequestParam("len") Integer len){
        return  ResultInfo.response(blogService.getCarousalBlog(len));
    }
}
