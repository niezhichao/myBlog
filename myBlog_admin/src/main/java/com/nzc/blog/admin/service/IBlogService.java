package com.nzc.blog.admin.service;

import com.github.pagehelper.PageInfo;
import com.nzc.blog.admin.dto.BlogDto;
import com.nzc.blog.admin.entity.Blog;
import com.nzc.blog.common.base.BaseService;

import java.io.Serializable;
import java.util.List;

public interface IBlogService extends BaseService<BlogDto> {

    void deleteById(Serializable id);
    PageInfo queryListWithPage(BlogDto blogDto);
    PageInfo queryAllWithPage(int currentPage,int pageSize);
    String   getBlogContentById(Serializable id);
    List<Blog> getCarousalBlog(Integer len);
}
