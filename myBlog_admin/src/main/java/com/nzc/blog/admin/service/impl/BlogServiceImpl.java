package com.nzc.blog.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzc.blog.admin.util.BusinessUtil;
import com.nzc.blog.admin.dao.RelationDao;
import com.nzc.blog.admin.dto.BlogDto;
import com.nzc.blog.admin.entity.Relation;
import com.nzc.blog.admin.entity.Tag;
import com.nzc.blog.admin.vo.BlogVo;
import com.nzc.blog.admin.dao.BlogDao;
import com.nzc.blog.admin.entity.Blog;
import com.nzc.blog.admin.service.IBlogService;
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
        List<Tag> tags = blogDto.getTags();
        if (null != tags && tags.size()>0){
            List<Relation> relationPoList = BusinessUtil.convertToRelationPoList(blogDto.getPid(),blogDto.getTags());
            relationDao.insertList(relationPoList);
        }

        String ifPublish = blogDto.getIfPublish();
        if (BlogConstants.IFPUBLISHYES.equals(ifPublish)){
            blogDto.setPublicTime(new Date());
        }
        Blog target = new Blog();
        BeanUtils.copyProperties(blogDto,target);
        target.setBlogSortedId(blogDto.getBlogSort().getPid());
        blogDao.insertOne(target);
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

    /**
     * 获取首页轮播
     * @param len 博客首页轮播条数
     * @return
     */
    @Override
    public List<Blog> getCarousalBlog(Integer len) {
        return blogDao.getCarousalBlog(len);
    }

    @Override
    public String getBlogContentById(Serializable id) {
        return blogDao.getBlogContentById(id);
    }
}
