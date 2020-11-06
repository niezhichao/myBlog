package com.nzc.blog.business.service;

import com.github.pagehelper.PageInfo;
import com.nzc.blog.business.dto.BlogSortDto;
import com.nzc.blog.business.entity.BlogSort;
import com.nzc.blog.common.base.BaseService;

import java.io.Serializable;
import java.util.List;

public interface IBlogSortService extends BaseService<BlogSortDto> {

    List<BlogSort> queryAll();
    void deleteById(Serializable id);
    PageInfo queryAllWithPage(int currentPage, int pageSize);
}
