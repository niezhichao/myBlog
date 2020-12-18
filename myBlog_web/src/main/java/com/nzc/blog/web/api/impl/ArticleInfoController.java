package com.nzc.blog.web.api.impl;

import com.nzc.blog.common.result.ResultInfo;
import com.nzc.blog.web.api.ArticleInfoRestApi;
import com.nzc.blog.web.dao.ArticleInfoDao;
import com.nzc.blog.web.service.IArticleInfoService;
import com.nzc.blog.web.vo.ArticleInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("art")
public class ArticleInfoController implements ArticleInfoRestApi {

    @Autowired
    IArticleInfoService articleInfoService;

    @GetMapping("/info")
    @Override
    public ResultInfo getArticleInfoById(@RequestParam("id") String id) {
        ArticleInfoVo res = articleInfoService.getArticleInfoById(id);
        return ResultInfo.response(res);
    }
}
