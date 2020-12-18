package com.nzc.blog.web.service.impl;

import com.nzc.blog.web.dao.ArticleInfoDao;
import com.nzc.blog.web.service.IArticleInfoService;
import com.nzc.blog.web.vo.ArticleInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleInfoServiceImpl implements IArticleInfoService {

    @Autowired
    ArticleInfoDao articleInfoDao;

    @Override
    public ArticleInfoVo getArticleInfoById(String id) {
        return articleInfoDao.getArticleInfoById(id);
    }
}
