package com.nzc.blog.file.api.impl;

import com.nzc.blog.business.result.ResultInfo;
import com.nzc.blog.business.service.IFileOperService;
import com.nzc.blog.common.constant.ResultCode;
import com.nzc.blog.file.api.FileRestApi;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public ResultInfo uploadFile(@RequestParam("file") MultipartFile file) {
        return fileOperService.uploadFile(file);
    }

    @PostMapping("/uploadFiles")
    public ResultInfo upload(HttpServletRequest request) {
        CommonsMultipartResolver multipartFile = new CommonsMultipartResolver(request.getSession().getServletContext());
        System.out.println(multipartFile.isMultipart(request));
        return ResultInfo.response(ResultCode.FILE_UPLOAD_SUCCESS);
    }
}
