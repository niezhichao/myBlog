package com.nzc.test;

import com.nzc.blog.business.BusiApp;
import com.nzc.blog.business.dao.BlogDao;
import com.nzc.blog.business.entity.Blog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusiApp.class)
@EnableAutoConfiguration
public class BlogInfoDaoTest {

    @Autowired
    BlogDao blogDao;

    @Test
    public void testDao() {
        Blog blog = new Blog();
        blog.setBlogId("112");
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blogDao.insertOne(blog);
    }
}
