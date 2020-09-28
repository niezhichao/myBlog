
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

