package com.nzc.blog.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzc.blog.business.dao.TagDao;
import com.nzc.blog.business.dto.TagDto;
import com.nzc.blog.business.entity.Tag;
import com.nzc.blog.business.service.ITagService;
import com.nzc.blog.business.vo.TagVo;
import com.nzc.blog.common.constant.BlogCodeUtils;
import com.nzc.blog.utils.BlogUtil;
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
        tagDto.setStatus(BlogCodeUtils.STATUS_VALID);
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


    public PageInfo queryListWithPage(TagVo tagVo) {
        PageHelper.startPage(tagVo.getPageNum(),tagVo.getPageSize());
        Tag target = new Tag();
        BeanUtils.copyProperties(tagVo,target);
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
