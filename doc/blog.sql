/**
*博客信息表
*/
CREATE TABLE `blog_info` (
  `blog_id` varchar(32) NOT NULL COMMENT '唯一id',
  `title` varchar(200) DEFAULT NULL COMMENT '博客标题',
  `content` longtext COMMENT '博客内容',
  `tag_id` varchar(255) DEFAULT NULL COMMENT '标签id',
  `file_id` varchar(255) DEFAULT NULL COMMENT '标题图片id',
  `status` tinyint(1) unsigned DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `is_original` varchar(1) DEFAULT '1' COMMENT '是否原创（0:不是 1：是）',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `articles_part` varchar(255) DEFAULT NULL COMMENT '文章来源',
  `blog_sort_id` varchar(32) DEFAULT NULL COMMENT '博客分类ID',
  `is_publish` varchar(1) DEFAULT '1' COMMENT '是否发布：0：否，1：是',
  `sort` int(11) DEFAULT '0' COMMENT '排序字段',
  PRIMARY KEY (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客表';

/**
*标签表
*/
DROP TABLE IF EXISTS `tag_info`;

CREATE TABLE `tag_info` (
  `tag_id` varchar(32) NOT NULL COMMENT '唯一uid',
  `tag_content` varchar(1000) NOT NULL COMMENT '标签内容',
  `status` tinyint(1) unsigned DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `sort` int(11) DEFAULT '0' COMMENT '排序字段，越大越靠前',
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签表';

DROP TABLE IF EXISTS `blog_type`;

CREATE TABLE `blog_type` (
  `blog_type_id` varchar(32) NOT NULL COMMENT '唯一id',
  `type_name` varchar(255) DEFAULT NULL COMMENT '分类内容',
  `content` varchar(255) DEFAULT NULL COMMENT '分类简介',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
  `sort` int(11) DEFAULT '0' COMMENT '排序字段，越大越靠前',
  PRIMARY KEY (`blog_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客分类表';