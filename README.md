# studying--学习ing
首先我们把SpringBoot+mybatis了解一下
# mybatis
里面包含xml配置sql语句使用
和免xml使用
后期我们把分页和自动生成Dao加上
建表语句

CREATE TABLE `s_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `userName` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL COMMENT '密码',
  `email` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

CREATE TABLE `s_orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `price` double(20,0) DEFAULT NULL COMMENT '价钱',
  `content` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

