package com.nzc.blog.utils;

public class BlogUtil {

    /**
     * 生成id主键
     * @return
     */
    public static String generateId() {
        StringBuilder keyBuidler = new StringBuilder(String.valueOf(System.currentTimeMillis()));
        return keyBuidler.append(CommonUtil.getRandom8key()).toString();
    }

}
