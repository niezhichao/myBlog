package com.nzc.blog.common.base;


/**
 * controller接口基类
 * @param <T>
 */
public interface BaseApi<T,R> {
    R insert(T t);
    R update(T t);
    R delete(T t);
}
