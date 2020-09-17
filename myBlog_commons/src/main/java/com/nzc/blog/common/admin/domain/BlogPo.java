package com.nzc.blog.common.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPo implements Serializable {

    private String blogId;//主键
    private String title;//标题
    private String content;//博客内容
    private String tagId;//标签唯一id
    private String fileId;//文件唯一id
    private String status;//博客状态
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    boolean ifOriginal;//是否原创
    private String author;//博客作者
    private String articleQuoted;//文章出处
}
