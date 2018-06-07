package com.spring.hibernate.service.impl;

import com.spring.hibernate.dao.UserDao;
import com.spring.hibernate.entity.User;
import com.spring.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Tiny
 * @Date 2018/6/7 20:06
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    @Override
    public User findById(Long id) {
        return userDao.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public User update(User user) {
        return userDao.saveAndFlush(user);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }
}
