package com.spring.mybatis.controller;

import com.spring.mybatis.model.User;
import com.spring.mybatis.service.UserService;
import com.spring.mybatis.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Tiny
 * @Date 2018/6/5
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/inserUser")
    @ResponseBody
    public Object inserUser(@Param("userName") String userName,@Param("password") String password,@Param("email") String email){
        Map<String,Object> data = new HashMap<>();
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        userService.insertUser(user);
        data.put("code","1");
        data.put("message","添加成功！");
        return data;
    }

}
