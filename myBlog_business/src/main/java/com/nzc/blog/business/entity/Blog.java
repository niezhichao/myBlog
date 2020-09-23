package com.nzc.blog.business.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("BlogInfo")
public class Blog implements Serializable {
    private  String blogId;
    private  String title;
    private  String content;
    private  String tagId;
    private  String fileId;
    private  String status;
    private Date createTime;
    private  Date updateTime;

    private  String ifOriginal;
    private  String author;
    private  String articlesQuoted;
    private  String blogSortedId;
    private  String ifPublish;
    private  String sort;

}
