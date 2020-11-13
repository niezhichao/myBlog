package com.nzc.blog.admin.api;

import com.nzc.blog.business.dto.BlogDto;
import com.nzc.blog.business.result.ResultInfo;
import com.nzc.blog.common.base.BaseApi;

import java.io.Serializable;

public interface BlogRestApi extends BaseApi<BlogDto,ResultInfo> {

    ResultInfo getBlogContentById(Serializable id);
}
