package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RequestMapping("/product")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 查询全部产品
     * @return
     * @throws Exception
     */
    @RolesAllowed("ADMIN")
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList", ps);
        mv.setViewName("productList");
        return mv;
    }

    /**
     * 新建一条数据
     * @param product
     * @return
     */
        @RequestMapping("/saveProduct")
        public String saveProduct (Product product)throws Exception{
            productService.saveProduct(product);
            return "redirect:findAll";

    }
}
