package com.nzc.blog.business.dao;

import com.nzc.blog.business.entity.TagPo;
import com.nzc.blog.common.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TagDao extends BaseDao<TagPo> {

    void insertList(List<TagPo> tagPoList);
}
