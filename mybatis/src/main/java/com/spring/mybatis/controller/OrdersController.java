package com.spring.mybatis.controller;

import com.spring.mybatis.model.Orders;
import com.spring.mybatis.model.User;
import com.spring.mybatis.service.impl.OrdersServiceImpl;
import com.spring.mybatis.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName OrdersController
 * @Description TODO
 * @Author Tiny
 * @Date 2018/6/5
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/order")
public class OrdersController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private OrdersServiceImpl ordersService;

    @GetMapping(value = "/findOrdersByUserId")
    @ResponseBody
    public Object findOrdersByUserId(@Param("userName") String userName){
        Map<String,Object> data = new HashMap<>();
        User user = userService.findByUserName(userName);
        if (null != user) {
            Orders order = ordersService.findOrdersByUserId(user.getId());
            if (null != order) {
                data.put("order", order);
                data.put("user", user);
                data.put("code", "0");
                data.put("message", "操作成功！");
            } else {
                data.put("user", user);
                data.put("code", "0");
                data.put("message", "该用户下没有订单！");
            }
        } else {
            data.put("code", "1");
            data.put("message", "用户不存在！");
        }
        return data;
    }

    @GetMapping(value = "/insertOrders")
    @ResponseBody
    public Object insertOrders(@Param("userName") String userName,@Param("price") Double price,@Param("content") String content){
        Map<String,Object> data = new HashMap<>();
        User user = userService.findByUserName(userName);
        if (null != user) {
            int count = ordersService.insertOrders(user.getId(), price, content);
            if (count > 0){
                data.put("message", "添加成功");
                data.put("code", "0");
            } else {
                data.put("message", "添加成功");
                data.put("code", "0");
            }
        } else {
            data.put("code", "1");
            data.put("message", "用户不存在！");
        }
        return data;
    }

    @GetMapping(value = "/deleteOrders")
    @ResponseBody
    public Object deleteOrders(@Param("id") Long orderId){
        Map<String,Object> data = new HashMap<>();
        int count = ordersService.deleteOrders(orderId);
        data.put("count",count);
        return data;
    }

    @GetMapping(value = "/updateOrders")
    @ResponseBody
    public Object updateOrders(@Param("userName")String userName, @Param("content") String content){
        Map<String,Object> data = new HashMap<>();
        User user = userService.findByUserName(userName);
        if (null != user) {
            int count = ordersService.updateOrders(content, user.getId());
            if (count > 0) {
                data.put("message", "修改成功");
                data.put("code", "0");
            }else {
                data.put("message", "修改失败");
                data.put("code", "1");
            }
        } else {
            data.put("code", "1");
            data.put("message", "用户不存在！");
        }
        return data;
    }

}
