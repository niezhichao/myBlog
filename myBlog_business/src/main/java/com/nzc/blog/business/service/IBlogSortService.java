package com.nzc.blog.business.service;

import com.github.pagehelper.PageInfo;
import com.nzc.blog.business.entity.BlogType;
import com.nzc.blog.business.vo.BlogTypeVo;
import com.nzc.blog.common.base.BaseService;

import java.util.List;

public interface IBlogTypeService extends BaseService<BlogTypeVo,PageInfo,BlogType> {

    List<BlogType> queryAll();
}
