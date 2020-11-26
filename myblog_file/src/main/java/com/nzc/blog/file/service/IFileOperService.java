package com.nzc.blog.file.service;

import com.nzc.blog.common.result.ResultInfo;
import org.springframework.web.multipart.MultipartFile;

public interface IFileOperService {

    String uploadFile(MultipartFile file);
}
