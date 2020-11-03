package com.nzc.blog.business.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageData<T> {
    private int pageNum;
    private int pageSize;
    private long total;
    private List<T> data;
}
