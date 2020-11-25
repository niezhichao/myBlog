package com.nzc.blog.admin.service;

import com.github.pagehelper.PageInfo;
import com.nzc.blog.admin.dto.BlogSortDto;
import com.nzc.blog.admin.entity.BlogSort;
import com.nzc.blog.common.base.BaseService;

import java.io.Serializable;
import java.util.List;

public interface IBlogSortService extends BaseService<BlogSortDto> {

    List<BlogSort> queryAll();
    void deleteById(Serializable id);
    PageInfo queryAllWithPage(int currentPage, int pageSize);
}
