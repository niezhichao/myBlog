package com.nzc.blog.common.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {

    /**
     * 8位随机数
     *
     * @return
     */
    public static String getRandom8key() {
        StringBuilder keyBuilder = new StringBuilder(String.valueOf(Math.random()));
        return keyBuilder.substring(2, 10).toString();
    }

    /**
     * 生成MDC 请求的跟踪号
     * @return
     */
    public static String getRequestId(){
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss");
        String pre = format.format(new Date());
        String UUID = java.util.UUID.randomUUID().toString().replace("-","");
        return  pre+UUID.substring(0,10);
    }

    public static String getFileId(){
        String currentTimeStr = String.valueOf(System.currentTimeMillis());
        String UUID = java.util.UUID.randomUUID().toString().replace("-","");
        String pre = UUID.substring(0,5);
        return pre+currentTimeStr;
    }
}
