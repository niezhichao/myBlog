package com.nzc.blog.business.result;

import com.github.pagehelper.PageInfo;
import com.nzc.blog.common.constant.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * created on 2020/09/23
 *
 * @author niezhichao
 * 统一响应信息类
 */
@NoArgsConstructor
@Data
public class ResultInfo {
    private String resCode;
    private String resMsg;
    Object response;
    private PageData page;

    public ResultInfo(String resCode, String resMsg) {
        this.resCode = resCode;
        this.resMsg = resMsg;
    }

    public <T> ResultInfo(PageData<T> page) {
        this(ResultCode.SUCCESS);
        this.page = page;
    }

    public static  ResultInfo response(Object data){
        return new ResultInfo(data);
    }

    public ResultInfo(Object data) {
        this(ResultCode.SUCCESS);
        this.response = data;
    }

    public static <T> ResultInfo page(PageData<T> page) {
        return new ResultInfo(page);
    }

    public static <T> ResultInfo page(PageInfo<T> pageInfo) {
        PageData<T> pageData = new PageData<>();
        pageData.setData(pageInfo.getList());
        pageData.setPageNum(pageInfo.getPageNum());
        pageData.setPageSize(pageInfo.getPageSize());
        pageData.setTotal(pageInfo.getTotal());
        return new ResultInfo(pageData);
    }

    public ResultInfo(ResultCode code) {
        this(code.getCode(), code.getMsg());
    }

    public static ResultInfo ok() {
        return new ResultInfo(ResultCode.SUCCESS);
    }
}
