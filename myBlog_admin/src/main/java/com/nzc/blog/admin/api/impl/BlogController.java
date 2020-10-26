package com.nzc.blog.admin.api.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.nzc.blog.admin.api.BlogRestApi;
import com.nzc.blog.business.entity.Blog;
import com.nzc.blog.business.result.ResultInfo;
import com.nzc.blog.business.service.IBlogService;
import com.nzc.blog.business.vo.BlogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blog")
public class BlogController implements BlogRestApi {
    @Autowired
    IBlogService blogService;

    /**
     *接收参数注释使用@RequestBody
     * 前端传过来的参数对象的属性名和vo参数的属性名相同就可接收参数
     * 参数在请求体中  所以必须要post方式提交
     * @param blogVo
     * @return
     */
    @PostMapping("/add")
    @Override
    public ResultInfo insert(@RequestBody BlogVo blogVo) {
        blogService.insert(blogVo);
        return ResultInfo.ok();
    }

    @Override
    public ResultInfo update(BlogVo blogVo) {
        return null;
    }

    @Override
    public ResultInfo delete(BlogVo blogVo) {
        return null;
    }

    @PostMapping("/list")
    public ResultInfo getBlogList(@RequestBody BlogVo blogVo){
        PageInfo<List<Blog>> pageInfo = blogService.queryList(blogVo);
        ResultInfo resultInfo = new ResultInfo(pageInfo.getList());
        Long total = pageInfo.getTotal();
        resultInfo.setTotal(total);
        resultInfo.setPageNum(pageInfo.getPageNum());
        resultInfo.setPageSize(pageInfo.getPageSize());
        return resultInfo;
    }
}
