package com.nzc.blog.web.feign;

import com.nzc.blog.common.result.ResultInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("admin-api")
@Component
public interface BlogInfoFeign {

    @GetMapping("/blogSort/all")
    ResultInfo getAll();
}
