package com.nzc.blog.business.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageCommon {

    private int pageNum;
    private int pageSize;
    private long total;

}
