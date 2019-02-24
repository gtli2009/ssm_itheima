package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {
@Autowired
private ProductDao productDao;
    /**
     * 查找所有商品
     * @return
     */
    @Override
    public List<Product> findAll() {
        return  productDao.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    @Override
    public Product findById(String id) {
        return productDao.findById(id);
    }
}
