package com.nzc.blog.web.entity;

import com.nzc.blog.common.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 博客简介
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogIntro extends BaseEntity {
    public String title;//标题
    public String introDesc;//简介内容
    private  String blogSortedId;
}
