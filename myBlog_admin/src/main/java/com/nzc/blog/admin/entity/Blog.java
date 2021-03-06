package com.nzc.blog.admin.entity;

import com.nzc.blog.common.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("Blog")
public class Blog extends BaseEntity {
    private  String title;
    private  String content;
    private  String fileId;
    private  String ifOriginal;
    private  String author;
    private  String articlesQuoted;
    private  String blogSortedId;
    private  String ifPublish;

}
