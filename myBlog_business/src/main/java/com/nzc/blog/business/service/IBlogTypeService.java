package com.nzc.blog.business.service;

import com.github.pagehelper.PageInfo;
import com.nzc.blog.business.entity.BlogTypePo;
import com.nzc.blog.business.vo.BlogTypeVo;
import com.nzc.blog.common.base.BaseService;

import java.util.List;

public interface IBlogTypeService extends BaseService<BlogTypeVo,PageInfo,BlogTypePo> {

    List<BlogTypePo> queryAll();
}
