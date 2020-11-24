package com.nzc.blog.business.common;

import java.util.UUID;

public class FileUtil {

    public static String getFileId(){
       String currentTimeStr = String.valueOf(System.currentTimeMillis());
       String UUID = java.util.UUID.randomUUID().toString().replace("-","");
       String pre = UUID.substring(0,5);
        return pre+currentTimeStr;
    }
}
