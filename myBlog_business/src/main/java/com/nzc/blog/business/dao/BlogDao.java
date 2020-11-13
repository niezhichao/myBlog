package com.nzc.blog.business.dao;

import com.nzc.blog.business.entity.Blog;
import com.nzc.blog.business.vo.BlogVo;
import com.nzc.blog.common.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Mapper
@Component
public interface BlogDao extends BaseDao<Blog> {
    List<BlogVo> queryList(Blog blog);
    List<Blog> queryAll();
    void deleteById(@Param("id") Serializable id);
    String getBlogContentById(@Param("id") Serializable id);
}
