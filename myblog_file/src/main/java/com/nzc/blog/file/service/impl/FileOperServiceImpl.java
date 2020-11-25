package com.nzc.blog.file.service.impl;

import com.nzc.blog.common.result.ResultInfo;
import com.nzc.blog.common.constant.BlogConstants;
import com.nzc.blog.common.constant.ResultCode;
import com.nzc.blog.common.utils.CommonUtil;
import com.nzc.blog.file.service.IFileOperService;
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

        File dest = new File(BlogConstants.FILE_PATH_BASE);
        String fileAbsoluteName  = file.getOriginalFilename();
        int suffixIndex = fileAbsoluteName.lastIndexOf(".");
        String suffix = fileAbsoluteName.substring(suffixIndex,fileAbsoluteName.length());
        if (!dest.exists()){
            dest.mkdir();
        }
        long len = file.getSize();
        String filePath = BlogConstants.FILE_PATH_BASE+File.separator+CommonUtil.getFileId() +suffix;
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
