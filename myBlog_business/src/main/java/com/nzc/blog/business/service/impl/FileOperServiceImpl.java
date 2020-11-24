package com.nzc.blog.business.service.impl;

import com.nzc.blog.business.common.FileUtil;
import com.nzc.blog.business.result.ResultInfo;
import com.nzc.blog.business.service.IFileOperService;
import com.nzc.blog.common.constant.BlogCodeUtils;
import com.nzc.blog.common.constant.ResultCode;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class FileOperServiceImpl implements IFileOperService {

    @Override
    public ResultInfo uploadFile(MultipartFile file)  {
        if (file.isEmpty()){
            return ResultInfo.response(ResultCode.FILE_UPLOAD_EMPTY);
        }

        File dest = new File(BlogCodeUtils.FILE_PATH_BASE);
        String fileAbsoluteName  = file.getOriginalFilename();
        int suffixIndex = fileAbsoluteName.lastIndexOf(".");
        String suffix = fileAbsoluteName.substring(suffixIndex-1,fileAbsoluteName.length());
        if (!dest.exists()){
            dest.mkdir();
        }
        long len = file.getSize();
        String filePath = BlogCodeUtils.FILE_PATH_BASE+File.separator+FileUtil.getFileId()+suffix;
        if (len < 10*1024*2014){//小于10M
            try{
                file.transferTo(new File(filePath));
            }catch (IOException e){
                e.printStackTrace();
            }
                return ResultInfo.response(ResultCode.FILE_UPLOAD_SUCCESS);
        }

        try(FileOutputStream fos = new FileOutputStream(new File(filePath));
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            InputStream is = file.getInputStream(); BufferedInputStream bis = new BufferedInputStream(is);){

            byte [] bytes = file.getBytes();
            byte[] buf = new byte[1024];
            int length = 0;
            while((length=bis.read(buf)) != -1){//一次读取1024字节
                bos.write(buf,0,length);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return ResultInfo.response(ResultCode.FILE_UPLOAD_SUCCESS);
    }
}
