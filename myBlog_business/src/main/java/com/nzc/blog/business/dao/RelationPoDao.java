package com.nzc.blog.business.dao;

import com.nzc.blog.business.entity.RelationPo;
import com.nzc.blog.common.base.BaseDao;

import java.util.List;

public interface RelationPoDao extends BaseDao<RelationPo> {
    void insertList(List<RelationPo> relationPoList);
}
