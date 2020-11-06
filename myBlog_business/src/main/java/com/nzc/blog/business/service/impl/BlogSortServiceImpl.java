package com.nzc.blog.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzc.blog.business.dao.BlogSortDao;
import com.nzc.blog.business.dto.BlogSortDto;
import com.nzc.blog.business.entity.BlogSort;
import com.nzc.blog.business.service.IBlogSortService;
import com.nzc.blog.business.vo.BlogSortVo;
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
public class BlogSortServiceImpl implements IBlogSortService {

    @Autowired
    BlogSortDao blogSortDao;

    @Transactional
    @Override
    public void insert(BlogSortDto blogSortDto) {
        blogSortDto.setStatus(BlogCodeUtils.STATUS_VALID);
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

    public void deleteById(Serializable id) {
        blogSortDao.deleteBlogTypeById(id);
    }

    public PageInfo queryListWithPage(BlogSortVo blogSortVo) {
        PageHelper.startPage(blogSortVo.getPageNum(),blogSortVo.getPageSize());
        BlogSort target = new BlogSort();
        BeanUtils.copyProperties(blogSortVo,target);
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
