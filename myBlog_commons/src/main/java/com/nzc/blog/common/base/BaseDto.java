package com.nzc.blog.common.base;


import com.nzc.blog.common.page.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * dto基类  前端到后端的数据传输
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDto extends PageInfo {
    /**
     * 唯一id
     */
    private String pid;

    /**
     * 状态： 0 失效 1 正常
     */
    private  String status;
}
