package com.nzc.blog.admin.api.impl;

import com.github.pagehelper.PageInfo;
import com.nzc.blog.admin.api.BlogTypeRestApi;
import com.nzc.blog.business.entity.BlogType;
import com.nzc.blog.business.service.IBlogTypeService;
import com.nzc.blog.business.vo.BlogTypeVo;
import com.nzc.blog.business.result.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@Api(value = "分类管理接口",tags = "BlogTypeRestApi")
@RestController
@RequestMapping("blogType")
public class BlogTypeController implements BlogTypeRestApi {

    @Autowired
    IBlogTypeService  blogTypeService;

    @ApiOperation(value = "添加分类",notes = "添加分类")
    @PostMapping("/add")
    @Override
    public ResultInfo insert(@RequestBody BlogTypeVo blogTypeVo) {
        blogTypeService.insert(blogTypeVo);
        return ResultInfo.ok();
    }
    @ApiOperation(value = "更新分类信息",notes = "更新分类信息")
    @PostMapping("/update")
    @Override
    public ResultInfo update(@RequestBody BlogTypeVo blogTypeVo) {
        blogTypeService.update(blogTypeVo);
        return ResultInfo.ok();
    }

    @Override
    public ResultInfo delete(BlogTypeVo blogTypeVo) {
        return null;
    }

    @ApiOperation(value = "删除分类",notes = "删除分类")
    @PostMapping("/delete")
    public ResultInfo deleteById(@RequestParam("id") Serializable id){
        blogTypeService.deleteById(id);
        return ResultInfo.ok();
    }

    @ApiOperation(value = "获取所有分类",notes = "获取所有分类")
    @GetMapping("/all")
    public  ResultInfo getAll(){
        List<BlogType> res = blogTypeService.queryAll();
        return ResultInfo.returnMapReulst(res);
    }

    @ApiOperation(value = "获取所有分类(分页)",notes = "获取所有分类(分页)")
    @GetMapping("/page/all")
    public ResultInfo getAllWithPage(@RequestParam(name="currentPage") int currentPage,@RequestParam(name="pageSize")int pageSize){
        PageInfo<BlogType> pageInfo = blogTypeService.queryAllWithPage(currentPage, pageSize);
        return  ResultInfo.page(pageInfo);
    }
}
