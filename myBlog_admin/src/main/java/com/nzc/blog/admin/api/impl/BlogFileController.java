package com.nzc.blog.admin.api.impl;

import com.nzc.blog.admin.feign.FileOperFeign;
import com.nzc.blog.common.result.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class BlogFileController {

    @Autowired
    FileOperFeign fileOperFeign;

    @PostMapping("blog/file")
    public ResultInfo uploadFile(@RequestBody  MultipartFile file){
        return  fileOperFeign.uploadFile(file);
    }

    @PostMapping("blog/test")
    public ResultInfo test(){
        return fileOperFeign.test();
    }
}
