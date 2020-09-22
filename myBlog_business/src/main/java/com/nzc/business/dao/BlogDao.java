package com.nzc.business.dao;

import com.nzc.blog.common.base.BaseDao;
import com.nzc.business.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface BlogDao extends BaseDao<Blog> {

}
