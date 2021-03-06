package com.nzc.blog.admin.entity;

import com.nzc.blog.common.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("Tag")
public class Tag extends BaseEntity {

    /**
     * 标签内容
     */
    private String tagContent;
}
