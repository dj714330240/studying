package com.spring.mybatis.service;

import com.spring.mybatis.model.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Tiny
 * @Date 2018/6/5
 * @Version 1.0
 */
public interface UserService {

    User findByUserName(String userName);

    void insertUser(User user);

    void deleteUserById(Long id);

    void updatePassword(User user);

}
