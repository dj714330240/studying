package com.spring.mybatis.service.impl;

import com.spring.mybatis.dao.OrdersDao;
import com.spring.mybatis.model.Orders;
import com.spring.mybatis.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 添加事物管理--报错--代码回滚
     * @param userId
     * @param price
     * @param content
     * @return
     */
    @Override
    @Transactional
    public void insertOrders(Long userId, Double price, String content) {
        ordersDao.insertOrders(userId, price, content);
//        int max = 2/0;    //正常情况下，代码执行到这报错，但是已经走了inserOrders方法。加上事物管理，他会把inserOrders方法回滚，你把注释放开看看
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
