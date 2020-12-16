package com.nzc.blog.web.vo;

import com.nzc.blog.common.base.BaseVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogIntroVo extends BaseVo {
    public String title;//标题
    public String introDesc;//简介内容
    public String sortName;//分类名称
}
