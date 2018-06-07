package com.spring.hibernate.service;

import com.spring.hibernate.entity.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

    void deleteById(Long id);

    User update(User user);

    User save(User user);


}
