package com.nzc.blog.business.dao;

import com.nzc.blog.business.entity.Blog;
import com.nzc.blog.common.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogDao extends BaseDao<Blog> {

}
