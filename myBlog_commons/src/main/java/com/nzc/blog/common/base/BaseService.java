package com.nzc.blog.common.base;

import java.util.List;

/**
 * service接口基类
 * @param <T>
 */
public interface BaseService<T,R> {
    void insert(T t);
    void update(T t);
    void delete(T t);
    List<R> queryAll();
}
