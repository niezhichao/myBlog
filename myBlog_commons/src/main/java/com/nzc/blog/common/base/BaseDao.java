package com.nzc.blog.common.base;

import java.io.Serializable;
import java.util.List;

/**
 * dao接口基类
 * @param <T>
 */
public interface BaseDao<T> {
    void insertOne(T t);
    void updateOne(T t);
    void deleteOne(T t);
    void deleteByIds(List<Serializable> ids);
}
