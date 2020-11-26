package com.nzc.blog.admin.feign;

import com.nzc.blog.common.result.ResultInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

@FeignClient("file-server")
@Component
public interface FileOperFeign {
    
    @PostMapping("file/upload")
    ResultInfo uploadFile(@RequestBody MultipartFile file);

    @PostMapping("/test")
    ResultInfo test();
}
