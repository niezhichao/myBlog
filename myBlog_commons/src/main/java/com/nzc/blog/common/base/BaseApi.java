package com.nzc.blog.common.base;

public interface BaseApi<T> {
    void insert(T t);
    void update(T t);
    void delete(T t);
}
