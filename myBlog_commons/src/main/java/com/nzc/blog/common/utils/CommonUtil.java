package com.nzc.blog.common.utils;


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



    public static String getFileId(){
        String currentTimeStr = String.valueOf(System.currentTimeMillis());
        String UUID = java.util.UUID.randomUUID().toString().replace("-","");
        String pre = UUID.substring(0,5);
        return pre+currentTimeStr;
    }
}
