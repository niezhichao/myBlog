package com.nzc.blog.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nzc.blog.common.base.BaseVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 文章内容返回
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleInfoVo extends BaseVo {
    private String content;//文章内容
    private String sortName;//分类名称
    private String sortId;//分类id
    private String title;//标题
    /**
     * 发布时间
     * DateTimeFormat 入参格式化
     * JsonFormat 出参格式化
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publicTime;//发布时间
}
