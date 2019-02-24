package com.itheima;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
@Test
    public void run1() throws IOException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        ProductService bean = ac.getBean(ProductService.class);
        List<Product> all = bean.findAll();
    }


}
