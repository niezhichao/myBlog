package com.nzc.blog.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzc.blog.business.dao.BlogTypeDao;
import com.nzc.blog.business.entity.BlogTypePo;
import com.nzc.blog.business.service.IBlogTypeService;
import com.nzc.blog.business.vo.BlogTypeVo;
import com.nzc.blog.common.constant.BlogCodeUtils;
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
        blogTypeVo.setStatus(BlogCodeUtils.STATUS_VALID);
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
    public PageInfo queryListWithPage(BlogTypeVo blogTypeVo) {
        PageHelper.startPage(blogTypeVo.getPageNum(),blogTypeVo.getPageSize());
        BlogTypePo target = new BlogTypePo();
        BeanUtils.copyProperties(blogTypeVo,target);
        List<BlogTypePo>  blogTypePos = blogTypeDao.queryList(target);
        return new PageInfo<>(blogTypePos);
    }

    @Override
    public PageInfo queryAllWithPage(int currentPage,int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<BlogTypePo> blogTypePoList = blogTypeDao.queryAll();
        return  new PageInfo<>(blogTypePoList);
    }


    @Override
    public List<BlogTypePo> queryAll() {
        return blogTypeDao.queryAll();
    }
}
