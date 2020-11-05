package com.nzc.blog.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzc.blog.business.dao.BlogTypeDao;
import com.nzc.blog.business.entity.BlogType;
import com.nzc.blog.business.service.IBlogTypeService;
import com.nzc.blog.business.vo.BlogTypeVo;
import com.nzc.blog.common.constant.BlogCodeUtils;
import com.nzc.blog.utils.BlogUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
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
        BlogType target = new BlogType();
        BeanUtils.copyProperties(blogTypeVo,target);
        blogTypeDao.insertOne(target);
    }

    @Transactional
    @Override
    public void update(BlogTypeVo blogTypeVo) {

        BlogType po = new BlogType();
        BeanUtils.copyProperties(blogTypeVo,po);
        blogTypeDao.updateOne(po);
    }

    @Transactional
    @Override
    public void delete(BlogTypeVo blogTypeVo) {

    }

    @Override
    public void deleteById(Serializable id) {
        blogTypeDao.deleteBlogTypeById(id);
    }

    @Override
    public PageInfo queryListWithPage(BlogTypeVo blogTypeVo) {
        PageHelper.startPage(blogTypeVo.getPageNum(),blogTypeVo.getPageSize());
        BlogType target = new BlogType();
        BeanUtils.copyProperties(blogTypeVo,target);
        List<BlogType> blogTypes = blogTypeDao.queryList(target);
        return new PageInfo<>(blogTypes);
    }

    @Override
    public PageInfo queryAllWithPage(int currentPage,int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<BlogType> blogTypeList = blogTypeDao.queryAll();
        return  new PageInfo<>(blogTypeList);
    }


    @Override
    public List<BlogType> queryAll() {
        return blogTypeDao.queryAll();
    }
}
