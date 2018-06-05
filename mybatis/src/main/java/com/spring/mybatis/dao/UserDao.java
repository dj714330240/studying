package com.spring.mybatis.dao;

import com.spring.mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 扫描xml
 * 映射对象和方法
 */
@Mapper
public interface UserDao {

    User findByUserName(String userName);

    void insertUser(User user);

    void deleteUserById(Long id);

    void updatePassword(User user);

}
