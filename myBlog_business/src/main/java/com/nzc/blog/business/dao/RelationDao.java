package com.nzc.blog.business.dao;

import com.nzc.blog.business.entity.Relation;
import com.nzc.blog.common.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RelationDao extends BaseDao<Relation> {
    void insertList(List<Relation> relationPoList);
    void mergeInto(List<Relation> relationPoList);
}
