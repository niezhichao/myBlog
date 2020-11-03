package com.nzc.blog.common.constant;

/**
 * 关联关系 类型
 */
public enum RelationTypeCode {

    BLOGANDTAG("01","博客信息和标签内容的关联关系");

    private String typeName;
    private String typeCode;

    private RelationTypeCode(String typeCode,String typeName){
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public String getTypeName(){return  this.typeName;}
    public String getTypeCode(){return this.typeCode;}
}
