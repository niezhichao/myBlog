package com.nzc.blog.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.nzc.blog.business.vo.BlogVo;
import com.nzc.blog.business.dao.BlogDao;
import com.nzc.blog.business.entity.Blog;
import com.nzc.blog.business.service.IBlogService;
import com.nzc.blog.common.constant.BlogCodeUtils;
import com.nzc.blog.utils.BlogUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    BlogDao blogDao;

    @Transactional
    @Override
    public void insert(BlogVo blogVo) {
        blogVo.setCreateTime(new Date());
        String ifPublish = blogVo.getIfPublish();
        if (BlogCodeUtils.IFPUBLISHYES.equals(ifPublish)){
            blogVo.setPublicTime(new Date());
        }
        blogVo.setPid(BlogUtil.generateId());
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

    @Override
    public List<Blog> queryAll() {
        return null;
    }
}
