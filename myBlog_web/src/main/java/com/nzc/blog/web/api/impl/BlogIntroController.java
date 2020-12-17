package com.nzc.blog.web.api.impl;

import com.nzc.blog.common.constant.BlogConstants;
import com.nzc.blog.common.result.ResultInfo;
import com.nzc.blog.web.api.BlogIntroRestApi;
import com.nzc.blog.web.service.IBlogIntroService;
import com.nzc.blog.web.vo.BlogIntroVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("intro")
public class BlogIntroController implements BlogIntroRestApi {

    @Autowired
    IBlogIntroService blogIntroService;

    @GetMapping("/home")
    @Override
    public ResultInfo homePageBlogIntros() {
        List<BlogIntroVo> homeIntros = blogIntroService.homePageBlogIntros(BlogConstants.HOME_INTRO_SIZE);
        return ResultInfo.response(homeIntros);
    }
}
