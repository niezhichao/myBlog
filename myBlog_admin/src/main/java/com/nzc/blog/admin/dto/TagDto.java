package com.nzc.blog.admin.dto;

import com.nzc.blog.common.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagDto extends BaseDto {

    /**
     * 标签内容
     */
    private String tagContent;
}
