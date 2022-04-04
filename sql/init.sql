CREATE TABLE `t_student` (
     `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '（学生编码）自增主键',
     `name` varchar(31) NULL COMMENT '学生姓名',
     `description` varchar(100) COMMENT '学生介绍',
     `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     `mtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生信息表';

