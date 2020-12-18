package com.nzc.blog.web.service.impl;

import com.nzc.blog.common.constant.BlogConstants;
import com.nzc.blog.web.dao.BlogIntroDao;
import com.nzc.blog.web.service.IBlogIntroService;
import com.nzc.blog.web.vo.BlogIntroVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogIntroServiceImpl implements IBlogIntroService {

    @Autowired
    BlogIntroDao blogIntroDao;

    @Override
    public List<BlogIntroVo> homePageBlogIntros(int size) {
        return blogIntroDao.homePageBlogIntros(size);
    }

    @Override
    public List<BlogIntroVo> homePageBlogIntrosBySortId(String id) {
        return blogIntroDao.homePageBlogIntrosBySortId(id,BlogConstants.HOME_INTRO_SIZE);
    }
}
