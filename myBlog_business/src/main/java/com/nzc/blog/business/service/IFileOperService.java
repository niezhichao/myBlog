package com.nzc.blog.business.service;

import com.nzc.blog.business.result.ResultInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileOperService {

    ResultInfo uploadFile(MultipartFile file);
}
