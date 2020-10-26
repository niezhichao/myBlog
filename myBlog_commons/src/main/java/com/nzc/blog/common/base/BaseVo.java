package com.nzc.blog.common.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * vo基类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseVo {
    /**
     * 分页大小
     */
    private Integer pageSize;

    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 唯一id
     */
    private String pid;
    /**
     * 状态： 0 失效 1 正常
     */
    private  String status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     *  更新时间
     */
    private Date updateTime;

    /**
     * 发布时间
     */
    private Date publicTime;
}
