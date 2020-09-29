package com.nzc.blog.common.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类 基类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable {

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
     * 排序字段
     */
    private int sort;
}
