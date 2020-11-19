package com.nzc.blog.file.api.impl;

import com.nzc.blog.business.result.ResultInfo;
import com.nzc.blog.common.constant.ResultCode;
import com.nzc.blog.file.api.FileRestApi;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@Api(value="文件操作接口",tags = "FileRestApi")
@RestController
@RequestMapping("file")
public class FileController implements FileRestApi {

    @PostMapping("/upload1")
    @Override
    public ResultInfo uploadFile(@RequestParam("upload") MultipartFile file) {
           if (file.isEmpty()){
               return ResultInfo.response(ResultCode.FILE_UPLOAD_EMPTY);
           }

           System.out.println("file OriginalFilename" + file.getOriginalFilename());
        System.out.println("file ContentType" + file.getContentType());
        System.out.println("file Name" + file.getName());
        System.out.println("file Size" + file.getSize());
        return ResultInfo.response(ResultCode.FILE_UPLOAD_SUCCESS);
    }

    @PostMapping("/upload")
    public ResultInfo upload(HttpServletRequest request) {
        CommonsMultipartResolver multipartFile = new CommonsMultipartResolver(request.getSession().getServletContext());
        System.out.println(multipartFile.isMultipart(request));
        return ResultInfo.response(ResultCode.FILE_UPLOAD_SUCCESS);
    }
}
