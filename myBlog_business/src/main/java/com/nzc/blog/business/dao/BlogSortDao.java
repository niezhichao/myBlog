package com.nzc.blog.business.dao;

import com.nzc.blog.business.entity.BlogSort;
import com.nzc.blog.common.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Mapper
@Component
public interface BlogSortDao extends BaseDao<BlogSort> {
    void deleteBlogTypeById(@Param("id") Serializable id);
    List<BlogSort>  queryList(BlogSort blogSort);
    List<BlogSort>  queryAll();
}
