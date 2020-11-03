package com.nzc.blog.utils;


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
}
