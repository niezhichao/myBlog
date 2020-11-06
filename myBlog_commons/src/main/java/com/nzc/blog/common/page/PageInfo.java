package com.nzc.blog.common.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageInfo {

    private int pageNum;
    private int pageSize;
    private long total;

}
