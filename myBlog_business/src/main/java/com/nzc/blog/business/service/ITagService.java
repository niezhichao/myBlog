package com.nzc.blog.business.service;

import com.github.pagehelper.PageInfo;
import com.nzc.blog.business.dto.TagDto;
import com.nzc.blog.business.entity.Tag;
import com.nzc.blog.common.base.BaseService;

import java.io.Serializable;
import java.util.List;

public interface ITagService extends BaseService<TagDto> {
    List<Tag> queryAll();
    void deleteById(Serializable id);
    PageInfo queryAllWithPage(int currentPage, int pageSize);
}
