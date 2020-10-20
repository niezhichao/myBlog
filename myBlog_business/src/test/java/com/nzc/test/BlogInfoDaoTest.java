
package com.nzc.test;

import com.nzc.blog.business.BusiApp;
import com.nzc.blog.business.dao.BlogDao;
import com.nzc.blog.business.dao.BlogTypeDao;
import com.nzc.blog.business.entity.Blog;
import com.nzc.blog.business.entity.BlogTypePo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusiApp.class)
@EnableAutoConfiguration
public class BlogInfoDaoTest {

    @Autowired
    BlogDao blogDao;

    @Autowired
    BlogTypeDao blogTypeDao;

    @Test
    public void blogTypeDaoTest() {
       List<BlogTypePo> list = blogTypeDao.queryAll();
       System.out.println(list.size());
    }
}
