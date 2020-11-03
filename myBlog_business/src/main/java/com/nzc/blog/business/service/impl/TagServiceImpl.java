package com.nzc.blog.business.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nzc.blog.business.dao.TagDao;
import com.nzc.blog.business.entity.TagPo;
import com.nzc.blog.business.service.ITagService;
import com.nzc.blog.business.vo.TagVo;
import com.nzc.blog.common.constant.BlogCodeUtils;
import com.nzc.blog.utils.BlogUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TagServiceImpl implements ITagService {

    @Autowired
    TagDao tagDao;

    @Transactional
    @Override
    public void insert(TagVo tagVo) {
        tagVo.setStatus(BlogCodeUtils.STATUS_VALID);
        tagVo.setPid(BlogUtil.generateId());
        TagPo taget = new TagPo();
        BeanUtils.copyProperties(tagVo,taget);
        tagDao.insertOne(taget);
    }

    @Override
    public void update(TagVo tagVo) {

    }

    @Override
    public void delete(TagVo tagVo) {

    }

    @Override
    public PageInfo queryListWithPage(TagVo tagVo) {
        PageHelper.startPage(tagVo.getPageNum(),tagVo.getPageSize());
        TagPo target = new TagPo();
        BeanUtils.copyProperties(tagVo,target);
        List<TagPo> tagList = tagDao.queryList(target);
        return new PageInfo<>(tagList);
    }

    @Override
    public PageInfo queryAllWithPage(int currentPage,int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<TagPo> tagPoList = tagDao.queryAll();
        return new PageInfo<>(tagPoList);
    }

    @Override
    public List<TagPo> queryAll() {
        return tagDao.queryAll();
    }
}
