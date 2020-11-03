package com.nzc.blog.admin.api.impl;

import com.github.pagehelper.PageInfo;
import com.nzc.blog.admin.api.TagRestApi;
import com.nzc.blog.business.entity.TagPo;
import com.nzc.blog.business.service.ITagService;
import com.nzc.blog.business.vo.TagVo;
import com.nzc.blog.business.result.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "标签管理接口",tags = "TagRestApi")
@RestController
@RequestMapping("tag")
public class TagController implements TagRestApi {

    @Autowired
    ITagService tagService;

    @ApiOperation(value = "添加标签",notes = "添加标签")
    @PostMapping("/add")
    @Override
    public ResultInfo insert(@RequestBody TagVo tagVo) {
        tagService.insert(tagVo);
        return ResultInfo.ok();
    }

    @Override
    public ResultInfo update(TagVo tagVo) {
        return null;
    }

    @Override
    public ResultInfo delete(TagVo tagVo) {
        return null;
    }

    @ApiOperation(value = "获取所有标签",notes = "获取所有标签")
    @GetMapping("/all")
    public ResultInfo getAll() {
        List<TagPo> res = tagService.queryAll();
        return ResultInfo.returnMapReulst(res);
    }

    @ApiOperation(value = "获取所有标签(分页)",notes = "获取所有标签(分页)")
    @GetMapping("/page/all")
    public ResultInfo getAllWithPage(int currentPage,int pageSize){
        PageInfo<TagPo> pageInfo = tagService.queryAllWithPage(currentPage, pageSize);
        return  ResultInfo.page(pageInfo);
    }
}
