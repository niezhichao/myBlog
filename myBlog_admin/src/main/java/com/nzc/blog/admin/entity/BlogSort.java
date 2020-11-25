package com.nzc.blog.admin.entity;

import com.nzc.blog.common.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("BlogSort")
public class BlogSort extends BaseEntity {
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 类型简介
     */
    private String content;
}
