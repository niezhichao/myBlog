package com.nzc.blog.common.base;

import java.util.List;

public interface BaseDao<T> {
    void insertOne(T t);
    void updateOne(T t);
    void deleteOne(T t);
    void queryOneById(String id);
    <T>List<T> queryList(T t);
}
