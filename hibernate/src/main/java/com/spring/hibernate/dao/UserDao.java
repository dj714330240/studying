package com.spring.hibernate.dao;

import com.spring.hibernate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User 是对象名--而不是表名
 * Long 是主键类型--如果你定义的Intger类型的主键--这里就填Intger
 *
 * JpaRepository 接口其中包含了几个的单表查询的方法，非常的方便
 */
public interface UserDao extends JpaRepository<User,Long> {
}
