package com.nzc.business.service.impl;

import com.nzc.business.dao.BlogDao;
import com.nzc.business.entity.Blog;
import com.nzc.business.service.IBlogService;
import com.nzc.business.vo.BlogVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    BlogDao blogDao;

    @Transactional
    @Override
    public void insert(BlogVo blogVo) {
        Blog target = new Blog();
        BeanUtils.copyProperties(blogVo,target);
        blogDao.insertOne(target);
    }

    @Override
    public void update(BlogVo blogVo) {

    }

    @Override
    public void delete(BlogVo blogVo) {

    }
}
