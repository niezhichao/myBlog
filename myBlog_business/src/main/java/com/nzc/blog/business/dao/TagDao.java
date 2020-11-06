package com.nzc.blog.business.dao;

import com.nzc.blog.business.entity.Tag;
import com.nzc.blog.common.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Mapper
@Component
public interface TagDao extends BaseDao<Tag> {

    void insertList(List<Tag> tagPoList);
    void deleteTagById(@Param("id") Serializable id);
    List<Tag> queryList(Tag tag);
    List<Tag> queryAll();
}
