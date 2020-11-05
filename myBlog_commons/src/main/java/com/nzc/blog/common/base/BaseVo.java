package com.nzc.blog.common.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * vo基类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseVo  implements Serializable {

    /**
     * 唯一id
     */
    private String pid;


}
