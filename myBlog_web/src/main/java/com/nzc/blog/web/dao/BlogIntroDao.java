package com.nzc.blog.web.dao;

import com.nzc.blog.web.vo.BlogIntroVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BlogIntroDao {
    List<BlogIntroVo>  getBlogIntros();
    List<BlogIntroVo> homePageBlogIntros(@Param("size") int size);
    List<BlogIntroVo> homePageBlogIntrosBySortId(@Param("id") String id,@Param("size") int size);
}
