package com.nzc.blog.business.service.impl;

import com.github.pagehelper.PageInfo;
import com.nzc.blog.business.dao.BlogTypeDao;
import com.nzc.blog.business.entity.BlogTypePo;
import com.nzc.blog.business.service.IBlogTypeService;
import com.nzc.blog.business.vo.BlogTypeVo;
import com.nzc.blog.utils.BlogUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BlogTypeServiceImpl implements IBlogTypeService{

    @Autowired
    BlogTypeDao blogTypeDao;

    @Transactional
    @Override
    public void insert(BlogTypeVo blogTypeVo) {
        blogTypeVo.setCreateTime(new Date());
        blogTypeVo.setPid(BlogUtil.generateId());
        BlogTypePo target = new BlogTypePo();
        BeanUtils.copyProperties(blogTypeVo,target);
        blogTypeDao.insertOne(target);
    }

    @Transactional
    @Override
    public void update(BlogTypeVo blogTypeVo) {

    }

    @Transactional
    @Override
    public void delete(BlogTypeVo blogTypeVo) {

    }

    @Override
    public PageInfo queryList(BlogTypeVo blogTypeVo) {
        return null;
    }

    public List<BlogTypePo> queryAll() {
        return blogTypeDao.queryAll();
    }
}
