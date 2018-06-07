package com.spring.hibernate.controller;

import com.spring.hibernate.dao.UserDao;
import com.spring.hibernate.entity.User;
import com.spring.hibernate.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Tiny
 * @Date 2018/6/7 19:41
 * @Version 1.0
 */
@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/getUser")
    @ResponseBody
    public User getUserById(@RequestParam("id") Long id){
        User user = userService.findById(id);
        return user;
    }

    @GetMapping(value = "/getList")
    @ResponseBody
    public List<User> getList(){
        return userService.findAll();
    }

    @GetMapping(value = "/deleteById")
    @ResponseBody
    public Object deleteById(@RequestParam("id") Long id){
        Map<String,Object> data = new HashMap<>();
        userService.deleteById(id);
        data.put("code","0");
        data.put("message","删除成功");
        return data;
    }

    @GetMapping(value = "/update")
    @ResponseBody
    public Object update(@RequestParam("id")Long id,@RequestParam("userName") String userName,@RequestParam("password")String password,@RequestParam("email")String email){
        Map<String,Object> data = new HashMap<>();
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        userService.update(user);
        data.put("code","0");
        data.put("message","修改成功");
        return data;
    }

    @GetMapping(value = "/save")
    @ResponseBody
    public Object save(@RequestParam("userName") String userName,@RequestParam("password")String password,@RequestParam("email")String email){
        Map<String,Object> data = new HashMap<>();
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail("email");
        userService.save(user);
        data.put("code","0");
        data.put("message","保存成功");
        return data;
    }

}
