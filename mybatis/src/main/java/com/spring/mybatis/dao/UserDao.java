package com.spring.mybatis.dao;

import com.spring.mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    User findByUserName(String userName);

    void insertUser(User user);

    void deleteUserById(Long id);

    void updatePassword(User user);

}
