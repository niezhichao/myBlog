package com.nzc.test;

import com.nzc.blog.business.entity.Blog;
import com.nzc.blog.business.entity.TagPo;
import com.nzc.blog.business.vo.BlogVo;
import com.nzc.blog.business.vo.TagVo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class BlogTest {
    public static void main(String args[]){
        List<TagVo> tagVoList = new ArrayList<>();
        List<TagPo> target = new ArrayList<>();
        tagVoList.add(new TagVo("1"));
        tagVoList.add(new TagVo("2"));
        tagVoList.add(new TagVo("3"));
        tagVoList.add(new TagVo("4"));
        BlogVo blogVo = new BlogVo();
        blogVo.setContent("test");
        blogVo.setTags(tagVoList);
        Blog blog = new Blog();

        BeanUtils.copyProperties(blogVo,blog);
        target = blog.getTags();
        System.out.println(target.size());

    }
}
