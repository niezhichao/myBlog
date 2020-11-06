package com.nzc.blog.business.common;

import com.nzc.blog.business.entity.Relation;

import com.nzc.blog.business.entity.Tag;
import com.nzc.blog.business.vo.TagVo;
import com.nzc.blog.common.constant.RelationTypeCode;
import com.nzc.blog.utils.BlogUtil;

import java.util.ArrayList;
import java.util.List;

public class BusinessUtil {

    public static List<Relation> convertToRelationPoList(String blogId, List<Tag> tagPoList){
        List<Relation> res = new ArrayList<>();
        for (Tag po: tagPoList){
            Relation temp = new Relation(blogId,RelationTypeCode.BLOGANDTAG.getTypeCode(),po.getPid());
            temp.setPid(BlogUtil.generateId());
            res.add(temp);
        }
        return res;
    }
}
