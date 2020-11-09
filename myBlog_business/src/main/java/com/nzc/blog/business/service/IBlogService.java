package com.nzc.blog.business.service;

import com.github.pagehelper.PageInfo;
import com.nzc.blog.business.dto.BlogDto;
import com.nzc.blog.common.base.BaseService;

import java.io.Serializable;

public interface IBlogService extends BaseService<BlogDto> {

    void deleteById(Serializable id);
    PageInfo queryListWithPage(BlogDto blogDto);
    PageInfo queryAllWithPage(int currentPage,int pageSize);

}
