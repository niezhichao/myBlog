package com.nzc.blog.business.common;

import com.nzc.blog.business.entity.RelationPo;

import com.nzc.blog.business.vo.TagVo;
import com.nzc.blog.common.constant.RelationTypeCode;
import com.nzc.blog.utils.BlogUtil;

import java.util.ArrayList;
import java.util.List;

public class BusinessUtil {

    public static List<RelationPo> convertToRelationPoList(String blogId, List<TagVo> tagPoList){
        List<RelationPo> res = new ArrayList<>();
        for (TagVo po: tagPoList){
            RelationPo temp = new RelationPo(blogId,RelationTypeCode.BLOGANDTAG.getTypeCode(),po.getPid());
            temp.setPid(BlogUtil.generateId());
            res.add(temp);
        }
        return res;
    }
}
