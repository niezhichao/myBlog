package com.nzc.blog.common.base;

import java.util.List;

/**
 * dao接口基类
 * @param <T>
 */
public interface BaseDao<T> {
    void insertOne(T t);
    void updateOne(T t);
    void deleteOne(T t);
    void queryOneById(String id);
    List<T> queryList(T t);
    List<T> queryAll();
}
