package com.spring.mybatis.service.impl;

import com.spring.mybatis.dao.OrdersDao;
import com.spring.mybatis.model.Orders;
import com.spring.mybatis.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrdersServiceImpl
 * @Description TODO
 * @Author Tiny
 * @Date 2018/6/5
 * @Version 1.0
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public Orders findOrdersByUserId(Long userId) {
        return ordersDao.findOrdersByUserId(userId);
    }

    @Override
    public int insertOrders(Long userId, Double price, String content) {
        return ordersDao.insertOrders(userId, price, content);
    }

    @Override
    public int deleteOrders(Long id) {
        return ordersDao.deleteOrders(id);
    }

    @Override
    public int updateOrders(String content, Long userId) {
        return ordersDao.updateOrders(content, userId);
    }
}
