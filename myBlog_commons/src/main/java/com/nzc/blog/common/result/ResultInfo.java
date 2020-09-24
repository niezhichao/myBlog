package com.nzc.blog.common.result;

import com.nzc.blog.common.constant.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created on 2020/09/23
 * @author niezhichao
 * 统一响应信息类
 */
@NoArgsConstructor
@Data
public class ResultInfo {
    private String resCode;
    private String resMsg;

    ResultInfo(String resCode, String resMsg){
        this.resCode = resCode;
        this.resMsg = resMsg;
    }

    ResultInfo(ResultCode code){
        this(code.getCode(),code.getMsg());
    }

    public static ResultInfo ok(){
        return new ResultInfo(ResultCode.SUCCESS);
    }
}