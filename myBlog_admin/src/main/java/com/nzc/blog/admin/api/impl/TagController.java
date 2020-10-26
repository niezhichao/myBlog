package com.nzc.blog.admin.api.impl;

import com.nzc.blog.admin.api.TagRestApi;
import com.nzc.blog.business.entity.TagPo;
import com.nzc.blog.business.service.ITagService;
import com.nzc.blog.business.vo.TagVo;
import com.nzc.blog.business.result.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tag")
public class TagController implements TagRestApi {

    @Autowired
    ITagService tagService;

    @PostMapping("/add")
    @Override
    public ResultInfo insert(TagVo tagVo) {
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

    @GetMapping("/all")
    public ResultInfo getAll() {
        List<TagPo> data = tagService.queryAll();
        return ResultInfo.returnMapReulst(data);
    }
}
