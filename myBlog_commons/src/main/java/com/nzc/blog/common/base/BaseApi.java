package com.nzc.blog.common.base;

import com.nzc.blog.common.result.ResultInfo;

/**
 * controller接口基类
 * @param <T>
 */
public interface BaseApi<T> {
    ResultInfo insert(T t);
    ResultInfo update(T t);
    ResultInfo delete(T t);
}
