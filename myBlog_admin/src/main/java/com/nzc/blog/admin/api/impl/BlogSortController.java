package com.nzc.blog.admin.api.impl;

import com.github.pagehelper.PageInfo;
import com.nzc.blog.admin.api.BlogSortRestApi;
import com.nzc.blog.business.dto.BlogSortDto;
import com.nzc.blog.business.entity.BlogSort;
import com.nzc.blog.business.result.ResultInfo;
import com.nzc.blog.business.service.IBlogSortService;
import com.nzc.blog.business.vo.BlogSortVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@Api(value = "分类管理接口",tags = "BlogTypeRestApi")
@RestController
@RequestMapping("blogSort")
public class BlogSortController implements BlogSortRestApi {

    @Autowired
    IBlogSortService blogSortService;

    @ApiOperation(value = "添加分类",notes = "添加分类")
    @PostMapping("/add")
    @Override
    public ResultInfo insert(@RequestBody BlogSortDto blogSortDto) {
        blogSortService.insert(blogSortDto);
        return ResultInfo.ok();
    }

    @ApiOperation(value = "更新分类信息",notes = "更新分类信息")
    @PostMapping("/update")
    @Override
    public ResultInfo update(@RequestBody  BlogSortDto blogSortDto) {
        blogSortService.update(blogSortDto);
        return ResultInfo.ok();
    }

    @ApiOperation(value = "删除分类",notes = "删除分类")
    @PostMapping("/delete")
    public ResultInfo deleteById(@RequestParam("id") Serializable id){
        blogSortService.deleteById(id);
        return ResultInfo.ok();
    }

    @ApiOperation(value = "获取所有分类",notes = "获取所有分类")
    @GetMapping("/all")
    public  ResultInfo getAll(){
        List<BlogSort> res = blogSortService.queryAll();
        return ResultInfo.response(res);
    }

    @ApiOperation(value = "获取所有分类(分页)",notes = "获取所有分类(分页)")
    @GetMapping("/page/all")
    public ResultInfo getAllWithPage(@RequestParam(name="currentPage") int currentPage,@RequestParam(name="pageSize")int pageSize){
        PageInfo<BlogSort> pageInfo = blogSortService.queryAllWithPage(currentPage, pageSize);
        return  ResultInfo.page(pageInfo);
    }

    @Override
    public ResultInfo delete(BlogSortDto blogSortDto) {
        return null;
    }
}
