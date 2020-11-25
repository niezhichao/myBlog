package com.nzc.blog.admin.dto;

import com.nzc.blog.admin.vo.TagVo;
import com.nzc.blog.common.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogSortDto extends BaseDto {
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 类型简介
     */
    private String content;

    private List<TagVo> tags;

    public BlogSortDto(int pageNum, int pageSize){
        this.setPageNum(pageNum);
        this.setPageSize(pageSize);
    }
}
