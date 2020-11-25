package com.nzc.blog.admin.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nzc.blog.admin.entity.BlogSort;
import com.nzc.blog.admin.entity.Tag;
import com.nzc.blog.common.base.BaseVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogVo extends BaseVo {
    private  String title;//标题
    private  String content;//内容
    private  String fileId;
    /**
     * 是否原创
     * 0 不是 1 是
     */
    private  String ifOriginal;
    private  String author;//作者
    private  String articlesQuoted;//文章来源
    private BlogSort blogSort;
    /**
     * 是否发布
     * 0 否 1 是
     */
    private  String ifPublish;
    private  String sort;
    /**
     * 发布时间
     * timezone = "GMT+8" 设置为东8区  不然时间会差8小时
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date publicTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    private List<Tag>  tags;
}
