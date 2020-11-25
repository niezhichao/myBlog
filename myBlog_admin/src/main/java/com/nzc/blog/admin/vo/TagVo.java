package com.nzc.blog.admin.vo;

import com.nzc.blog.common.base.BaseVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagVo  extends BaseVo {
    /**
     * 标签内容
     */
    private String tagContent;
}
