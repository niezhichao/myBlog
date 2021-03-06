package com.nzc.blog.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzc.blog.admin.dao.TagDao;
import com.nzc.blog.admin.dto.TagDto;
import com.nzc.blog.admin.entity.Tag;
import com.nzc.blog.admin.service.ITagService;
import com.nzc.blog.common.constant.BlogConstants;
import com.nzc.blog.common.utils.BlogUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public class TagServiceImpl implements ITagService {

    @Autowired
    TagDao tagDao;

    @Transactional
    @Override
    public void insert(TagDto tagDto) {
        tagDto.setStatus(BlogConstants.STATUS_VALID);
        tagDto.setPid(BlogUtil.generateId());
        Tag target = new Tag();
        BeanUtils.copyProperties(tagDto,target);
        tagDao.insertOne(target);
    }

    @Transactional
    @Override
    public void update(TagDto tagDto) {
            Tag po = new Tag();
            BeanUtils.copyProperties(tagDto,po);
            tagDao.updateOne(po);
    }

    @Transactional
    @Override
    public void delete(TagDto tagDto) {

    }


    public void deleteById(Serializable id) {
        tagDao.deleteTagById(id);
    }

    @Override
    public void deleteByIds(List<Serializable> ids) {

    }

    public PageInfo queryListWithPage(TagDto tagDto) {
        PageHelper.startPage(tagDto.getPageNum(),tagDto.getPageSize());
        Tag target = new Tag();
        BeanUtils.copyProperties(tagDto,target);
        List<Tag> tagList = tagDao.queryList(target);
        return new PageInfo<>(tagList);
    }

    public PageInfo queryAllWithPage(int currentPage,int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Tag> tagPoList = tagDao.queryAll();
        return new PageInfo<>(tagPoList);
    }

    public List<Tag> queryAll() {
        return tagDao.queryAll();
    }


}
