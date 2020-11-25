package com.nzc.blog.admin.util;

import com.nzc.blog.admin.entity.Relation;

import com.nzc.blog.admin.entity.Tag;
import com.nzc.blog.common.constant.RelationTypeCode;
import com.nzc.blog.common.utils.BlogUtil;

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
