package com.nzc.blog.business.vo;

import com.nzc.blog.common.base.BaseVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogTypeVo extends BaseVo {
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 类型简介
     */
    private String content;

    private List<TagVo> tags;

    public BlogTypeVo(int pageNum, int pageSize){
        this.setPageNum(pageNum);
        this.setPageSize(pageSize);
    }
}
