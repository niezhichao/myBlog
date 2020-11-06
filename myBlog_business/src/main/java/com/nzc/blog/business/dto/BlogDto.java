package com.nzc.blog.business.dto;

import com.nzc.blog.business.entity.BlogSort;
import com.nzc.blog.business.entity.Tag;
import com.nzc.blog.common.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto extends BaseDto {
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
     */
    private Date publicTime;
    private Date updateTime;
    private Date createTime;
    private List<Tag> tags;
}