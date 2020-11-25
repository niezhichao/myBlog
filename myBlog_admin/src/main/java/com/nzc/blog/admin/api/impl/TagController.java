package com.nzc.blog.admin.api.impl;

import com.github.pagehelper.PageInfo;
import com.nzc.blog.admin.api.TagRestApi;
import com.nzc.blog.admin.dto.TagDto;
import com.nzc.blog.admin.entity.Tag;
import com.nzc.blog.admin.service.ITagService;
import com.nzc.blog.common.result.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
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
    public ResultInfo insert(@RequestBody TagDto tagDto) {
        tagService.insert(tagDto);
        return ResultInfo.ok();
    }
    @ApiOperation(value = "更新标签",notes = "更新标签")
    @PostMapping("/update")
    @Override
    public ResultInfo update(@RequestBody TagDto tagDto) {
        tagService.update(tagDto);
        return ResultInfo.ok();
    }

    @ApiOperation(value = "删除标签",notes = "删除标签")
    @PostMapping("/delete")
    public ResultInfo deleteById(@RequestParam("id") Serializable id){
        tagService.deleteById(id);
        return ResultInfo.ok();
    }

    @Override
    public ResultInfo deleteByIds(List<Serializable> ids) {
        return null;
    }

    @Override
    public ResultInfo delete(TagDto tagDto) {
        return null;
    }

    @ApiOperation(value = "获取所有标签",notes = "获取所有标签")
    @GetMapping("/all")
    public ResultInfo getAll() {
        List<Tag> res = tagService.queryAll();
        return ResultInfo.response(res);
    }

    @ApiOperation(value = "获取所有标签(分页)",notes = "获取所有标签(分页)")
    @GetMapping("/page/all")
    public ResultInfo getAllWithPage(int currentPage,int pageSize){
        PageInfo<Tag> pageInfo = tagService.queryAllWithPage(currentPage, pageSize);
        return  ResultInfo.page(pageInfo);
    }
}
