package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/orders")
@Controller
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "4") int size) {
        ModelAndView mv = new ModelAndView();
        List<Orders> orders = ordersService.findAll(page, size);
        //pageInfo是pagehelper提供的分页
        PageInfo pageInfo = new PageInfo(orders);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("ordersPageList");
        return mv;
    }

    /**
     * 根据id查询orders详情
     *
     * @param
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String ordersId) {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
           mv.addObject("orders",orders);
           mv.setViewName("ordersShow");
           return mv;
    }

}
