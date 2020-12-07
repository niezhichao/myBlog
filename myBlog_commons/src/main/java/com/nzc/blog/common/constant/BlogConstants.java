package com.nzc.blog.common.constant;


import java.io.File;

public class BlogConstants {

    /**
     * 是否发布
    * IFPUBLISHYES 1 发布
    * IFPUBLISHNO 0 未发布
    * **/
    public static final String IFPUBLISHYES = "1";
    public static  final String IFPUBLISHNO = "0";

    /**
     * 状态码
     * 1 有效  0 无效
     */
    public static final String  STATUS_INVALID = "0";
    public static final String  STATUS_VALID = "1";

    public static final String FILE_PATH_BASE ="E:"+ File.separator+"blogFile";

    public static final String LOG_ID_KEY = "requestId";
    public static final String ZIPKIN_TRACEID_KEY = "X-B3-TraceId";
    public static final String REQUEST_URI_KEY="requestUri";
    public static final String RESULT_EXCEPTION_KEY="exception";
}
