package com.nzc.blog.admin.api.impl;

import com.nzc.blog.admin.api.BlogTypeRestApi;
import com.nzc.blog.business.entity.BlogTypePo;
import com.nzc.blog.business.service.IBlogTypeService;
import com.nzc.blog.business.vo.BlogTypeVo;
import com.nzc.blog.business.result.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResultInfo insert(BlogTypeVo blogTypeVo) {
        blogTypeService.insert(blogTypeVo);
        return ResultInfo.ok();
    }

    @Override
    public ResultInfo update(BlogTypeVo blogTypeVo) {
        return null;
    }

    @Override
    public ResultInfo delete(BlogTypeVo blogTypeVo) {
        return null;
    }

    @GetMapping("/all")
    public  ResultInfo getAll(){
        List<BlogTypePo> data = blogTypeService.queryAll();
        return ResultInfo.returnMapReulst(data);
    }
}
