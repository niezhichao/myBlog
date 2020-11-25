package com.nzc.blog.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzc.blog.admin.dao.BlogSortDao;
import com.nzc.blog.admin.dto.BlogSortDto;
import com.nzc.blog.admin.entity.BlogSort;
import com.nzc.blog.admin.service.IBlogSortService;
import com.nzc.blog.common.constant.BlogConstants;
import com.nzc.blog.common.utils.BlogUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Service
public class BlogSortServiceImpl implements IBlogSortService {

    @Autowired
    BlogSortDao blogSortDao;

    @Transactional
    @Override
    public void insert(BlogSortDto blogSortDto) {
        blogSortDto.setStatus(BlogConstants.STATUS_VALID);
        blogSortDto.setPid(BlogUtil.generateId());
        BlogSort target = new BlogSort();
        BeanUtils.copyProperties(blogSortDto,target);
        target.setCreateTime(new Date());
        blogSortDao.insertOne(target);
    }

    @Transactional
    @Override
    public void update(BlogSortDto blogSortDto) {
        BlogSort po = new BlogSort();
        BeanUtils.copyProperties(blogSortDto,po);
        blogSortDao.updateOne(po);
    }

    @Transactional
    @Override
    public void delete(BlogSortDto blogSortDto) {

    }

    @Override
    public void deleteByIds(List<Serializable> ids) {

    }

    public void deleteById(Serializable id) {
        blogSortDao.deleteBlogTypeById(id);
    }

    public PageInfo queryListWithPage(BlogSortDto blogSortDto) {
        PageHelper.startPage(blogSortDto.getPageNum(),blogSortDto.getPageSize());
        BlogSort target = new BlogSort();
        BeanUtils.copyProperties(blogSortDto,target);
        List<BlogSort> blogTypes = blogSortDao.queryList(target);
        return new PageInfo<>(blogTypes);
    }

    public PageInfo queryAllWithPage(int currentPage,int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<BlogSort> blogTypeList = blogSortDao.queryAll();
        return  new PageInfo<>(blogTypeList);
    }


    @Override
    public List<BlogSort> queryAll() {
        return blogSortDao.queryAll();
    }
}
