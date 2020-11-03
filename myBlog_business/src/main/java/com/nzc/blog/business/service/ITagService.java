package com.nzc.blog.business.service;

import com.github.pagehelper.PageInfo;
import com.nzc.blog.business.entity.TagPo;
import com.nzc.blog.business.vo.TagVo;
import com.nzc.blog.common.base.BaseService;

import java.util.List;

public interface ITagService extends BaseService<TagVo,PageInfo,TagPo> {
    List<TagPo> queryAll();
}
