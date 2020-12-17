package com.nzc.blog.web.service;

import com.nzc.blog.web.vo.BlogIntroVo;

import java.util.List;

public interface IBlogIntroService {

    List<BlogIntroVo> homePageBlogIntros(int size);
}
