package com.nzc.blog.web.api;

import com.nzc.blog.common.result.ResultInfo;

public interface ArticleInfoRestApi {
    ResultInfo getArticleInfoById(String id);
}
