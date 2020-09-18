package com.nzc.business.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

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
    private  String createTime;
    private  String updateTime;

    private  String ifOriginal;
    private  String author;
    private  String articlesQuoted;
    private  String blogSortedId;
    private  String ifPublish;
    private  String sort;

}
