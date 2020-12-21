package com.nzc.blog.web.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nzc.blog.common.base.BaseVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogIntroVo extends BaseVo {
    public String title;//标题
    public String introDesc;//简介内容
    public String sortName;//分类名称
    public String sortId;//类型 id
    /**
     * 发布时间
     * DateTimeFormat 入参格式化
     * JsonFormat 出参格式化
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publicTime;
}
