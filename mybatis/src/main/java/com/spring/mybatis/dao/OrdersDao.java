package com.spring.mybatis.dao;

import com.spring.mybatis.model.Orders;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrdersDao {

    @Select("select id, userId, price,  content from s_orders where userId = #{userId}")
    Orders findOrdersByUserId(@Param("userId") Long userId);

    @Insert("inser into s_orders(userId, price, content) values (#{userId}, #{price}, #{content})")
    int insertOrders(@Param("userId") Long userId, @Param("price") Double price, @Param("content") String content);

    @Delete("delete from s_orders where id = #{id}")
    int deleteOrders(@Param("id") Long id);

    @Update("update s_orders set content = #{content} where userId = #{userId}")
    int updateOrders(@Param("content") String content, @Param("userId")Long userId);
}
