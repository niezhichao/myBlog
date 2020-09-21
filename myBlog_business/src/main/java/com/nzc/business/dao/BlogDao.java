package com.nzc.business.dao;

import com.nzc.blog.common.base.BaseDao;
import com.nzc.business.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogDao extends BaseDao<Blog> {

}
