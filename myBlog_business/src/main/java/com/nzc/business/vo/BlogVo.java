package com.nzc.business.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogVo {
    private  String blogId;
    private  String title;
    private  String content;
    private  String tagId;
    private  String fileId;
    private  String status;
    private  Date createTime;
    private Date updateTime;

    private  String ifOriginal;
    private  String author;
    private  String articlesQuoted;
    private  String blogSortedId;
    private  String ifPublish;
    private  String sort;
}
