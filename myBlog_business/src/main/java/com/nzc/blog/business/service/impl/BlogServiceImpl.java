package com.nzc.blog.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzc.blog.business.common.BusinessUtil;
import com.nzc.blog.business.dao.RelationPoDao;
import com.nzc.blog.business.entity.RelationPo;
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

    @Autowired
    RelationPoDao relationPoDao;

    @Transactional
    @Override
    public void insert(BlogVo blogVo) {
        blogVo.setCreateTime(new Date());
        List<RelationPo> relationPoList = BusinessUtil.convertToRelationPoList(blogVo.getPid(),blogVo.getTags());
        String ifPublish = blogVo.getIfPublish();
        if (BlogCodeUtils.IFPUBLISHYES.equals(ifPublish)){
            blogVo.setPublicTime(new Date());
        }
        blogVo.setPid(BlogUtil.generateId());
        Blog target = new Blog();
        BeanUtils.copyProperties(blogVo,target);
        blogDao.insertOne(target);
        relationPoDao.insertList(relationPoList);
    }

    @Override
    public void update(BlogVo blogVo) {

    }

    @Override
    public void delete(BlogVo blogVo) {

    }

    /**
     *
     * @param blogVo
     * @return
     * PageHelper.startPage 方法后的第一个mapper方法 会进行分页
     * PageInfo或者Page对象可以取得分页信息
     */
    @Override
    public PageInfo queryListWithPage(BlogVo blogVo) {
        PageHelper.startPage(blogVo.getPageNum(),blogVo.getPageSize());
        Blog target = new Blog();
        BeanUtils.copyProperties(blogVo,target);
        List<Blog> blogList = blogDao.queryList(target);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        return pageInfo;
    }

    @Override
    public PageInfo queryAllWithPage(int currentPage,int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Blog> blogList = blogDao.queryAll();
        return new PageInfo<>(blogList);
    }
}
