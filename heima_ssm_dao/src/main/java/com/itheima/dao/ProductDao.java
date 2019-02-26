package com.itheima.dao;

import com.itheima.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {
    /**
     * 查找所有
     *
     * @return
     */
    @Select("select * from product")
    List<Product> findAll()throws Exception;

    /**
     * 保存操作
     *
     * @param product
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void saveProduct(Product product)throws Exception;

    /**
     * 根据id查找
     * @param id
     * @return
     */
    @Select("select * from product where id= #{id}")
    Product findById(String id)throws Exception;
}
