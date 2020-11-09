package com.nzc.blog.common.base;

import java.io.Serializable;
import java.util.List;

/**
 * service接口基类
 * @param <T>
 */
public interface BaseService<T> {
    void insert(T t);
    void update(T t);
    void delete(T t);
    void deleteByIds(List<Serializable> ids);
}
