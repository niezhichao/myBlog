package com.nzc.blog.file.api.impl;

import com.nzc.blog.common.result.ResultInfo;
import com.nzc.blog.common.constant.ResultCode;
import com.nzc.blog.file.api.FileRestApi;
import com.nzc.blog.file.service.IFileOperService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;

@Api(value="文件操作接口",tags = "FileRestApi")
@RestController
@RequestMapping("file")
public class FileController implements FileRestApi {

    @Autowired
    IFileOperService fileOperService;

    @PostMapping("/upload")
    @Override
    public ResultInfo uploadFile(@RequestBody MultipartFile file) {
        String filePath = fileOperService.uploadFile(file);
        return ResultInfo.response(filePath,ResultCode.FILE_UPLOAD_SUCCESS);
    }

    @PostMapping("/uploadFiles")
    public ResultInfo upload(HttpServletRequest request) {
        CommonsMultipartResolver multipartFile = new CommonsMultipartResolver(request.getSession().getServletContext());
        System.out.println(multipartFile.isMultipart(request));
        return ResultInfo.response(ResultCode.FILE_UPLOAD_SUCCESS);
    }


    @PostMapping("/test")
    public ResultInfo test(){
        return ResultInfo.response(ResultCode.SUCCESS);
    }
}
