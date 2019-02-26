package com.itheima.dao;


import com.itheima.domain.Member;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {
    /**
     * 查找所有订单
     *
     * @return
     */
    @Select("Select * from Orders")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDes", column = "orderDes"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.itheima.dao.ProductDao.findById")),
    })
    List<Orders> findAll()throws Exception;

    /**
     * 根据id查询Orders详情
     *
     * @param id
     * @return
     */
    @Select("Select * from orders where id=#{OrdersId}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.itheima.dao.ProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "com.itheima.dao.MemberDao.findById")),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class, many = @Many(select = "com.itheima.dao.TravellerDao.findByOrdersId")),
    })
    Orders findById(String id)throws Exception;


}
