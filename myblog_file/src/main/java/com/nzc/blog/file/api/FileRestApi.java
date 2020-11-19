package com.nzc.blog.file.api;

import com.nzc.blog.business.result.ResultInfo;
import org.springframework.web.multipart.MultipartFile;

public interface FileRestApi {
    ResultInfo uploadFile(MultipartFile file);

}
