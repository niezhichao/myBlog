package com.nzc.blog.business.dao;

import com.nzc.blog.business.entity.BlogType;
import com.nzc.blog.common.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Mapper
@Component
public interface BlogTypeDao extends BaseDao<BlogType> {
    void deleteBlogTypeById(@Param("id") Serializable id);
}
