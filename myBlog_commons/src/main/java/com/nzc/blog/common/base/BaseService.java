package com.nzc.blog.common.base;

import java.util.List;

/**
 * service接口基类
 * @param <T>
 */
public interface BaseService<T,R,K> {
    void insert(T t);
    void update(T t);
    void delete(T t);
    R queryList(T t);
    List<K> queryAll();

}
