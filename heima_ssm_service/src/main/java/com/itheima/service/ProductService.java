package com.itheima.service;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductService {

    /**
     * 查找所有
     * @return
     */
    List<Product> findAll();

    /**
     * 保存方法
     * @param product
     */
    void saveProduct(Product product);

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    Product findById(String id);
}
