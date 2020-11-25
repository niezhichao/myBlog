package com.nzc.blog.admin.api;

import com.nzc.blog.admin.dto.BlogDto;
import com.nzc.blog.common.result.ResultInfo;
import com.nzc.blog.common.base.BaseApi;

import java.io.Serializable;

public interface BlogRestApi extends BaseApi<BlogDto,ResultInfo> {

    ResultInfo getBlogContentById(Serializable id);
}
