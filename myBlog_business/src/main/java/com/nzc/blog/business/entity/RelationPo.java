package com.nzc.blog.business.entity;

import com.nzc.blog.common.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * 关联关系实体类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Alias("RelationPo")
public class RelationPo extends BaseEntity {
    private String mainRelationKey;//关联关系主体 id
    private String relationTypeCode;//关联关系类型
    private String relatedKey;//关联对象的 id
}