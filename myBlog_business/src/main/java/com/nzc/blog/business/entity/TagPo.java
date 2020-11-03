package com.nzc.blog.business.entity;

import com.nzc.blog.common.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("TagInfo")
public class TagPo extends BaseEntity {
    /**
     * 标签内容
     */
    private String tagContent;

}
