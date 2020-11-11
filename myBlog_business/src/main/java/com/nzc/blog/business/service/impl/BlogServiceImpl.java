package com.nzc.blog.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzc.blog.business.common.BusinessUtil;
import com.nzc.blog.business.dao.RelationDao;
import com.nzc.blog.business.dto.BlogDto;
import com.nzc.blog.business.entity.Relation;
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

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    BlogDao blogDao;

    @Autowired
    RelationDao relationDao;

    @Transactional
    @Override
    public void insert(BlogDto blogDto) {
        blogDto.setCreateTime(new Date());
        blogDto.setPid(BlogUtil.generateId());
        List<Relation> relationPoList = BusinessUtil.convertToRelationPoList(blogDto.getPid(),blogDto.getTags());
        String ifPublish = blogDto.getIfPublish();
        if (BlogCodeUtils.IFPUBLISHYES.equals(ifPublish)){
            blogDto.setPublicTime(new Date());
        }
        Blog target = new Blog();
        BeanUtils.copyProperties(blogDto,target);
        target.setBlogSortedId(blogDto.getBlogSort().getPid());
        blogDao.insertOne(target);
        relationDao.insertList(relationPoList);
    }

    @Transactional
    @Override
    public void update(BlogDto blogDto) {
        blogDto.setUpdateTime(new Date());
        relationDao.deleteByMainRelationKey(blogDto.getPid());
        if (null != blogDto.getTags()){
            List<Relation> relationPoList = BusinessUtil.convertToRelationPoList(blogDto.getPid(),blogDto.getTags());
            relationDao.mergeInto(relationPoList);
        }
        Blog target = new Blog();
        BeanUtils.copyProperties(blogDto,target);
        target.setBlogSortedId(blogDto.getBlogSort().getPid());
        blogDao.updateOne(target);
    }

    @Override
    public void delete(BlogDto blogDto) {

    }

    @Override
    public void deleteByIds(List<Serializable> ids) {
        blogDao.deleteByIds(ids);
    }

    @Override
    public void deleteById(Serializable id) {
        blogDao.deleteById(id);
    }

    /**
     *
     * @param blogDto
     * @return
     * PageHelper.startPage 方法后的第一个mapper方法 会进行分页
     * PageInfo或者Page对象可以取得分页信息
     */
    @Override
    public PageInfo queryListWithPage(BlogDto blogDto) {
        PageHelper.startPage(blogDto.getPageNum(),blogDto.getPageSize());
        Blog target = new Blog();
        BeanUtils.copyProperties(blogDto,target);
        if (null != blogDto.getBlogSort()){
            target.setBlogSortedId(blogDto.getBlogSort().getPid());
        }
        List<BlogVo> blogList = blogDao.queryList(target);
        PageInfo<BlogVo> pageInfo = new PageInfo<>(blogList);
        return pageInfo;
    }

    @Override
    public PageInfo queryAllWithPage(int currentPage,int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Blog> blogList = blogDao.queryAll();
        return new PageInfo<>(blogList);
    }
}
