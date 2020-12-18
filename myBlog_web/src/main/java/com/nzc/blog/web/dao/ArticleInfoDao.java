package com.nzc.blog.web.dao;

import com.nzc.blog.web.vo.ArticleInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ArticleInfoDao {
    ArticleInfoVo getArticleInfoById(@Param("id") String id);
}
