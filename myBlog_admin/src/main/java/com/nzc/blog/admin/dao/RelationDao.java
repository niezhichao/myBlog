package com.nzc.blog.admin.dao;

import com.nzc.blog.admin.entity.Relation;
import com.nzc.blog.common.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Mapper
@Component
public interface RelationDao extends BaseDao<Relation> {
    void insertList(List<Relation> relationPoList);
    void mergeInto(List<Relation> relationPoList);
    void deleteByMainRelationKey(@Param("mainRelationKey") Serializable mainRelationKey);
}
