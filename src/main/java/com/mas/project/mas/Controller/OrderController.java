package com.mas.project.mas.Controller;

import com.mas.project.mas.Beans.OrderDTO;
import com.mas.project.mas.Service.MechanicService;
import com.mas.project.mas.Service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by Janusz on 11.06.2017.
 */
@Controller
@RequestMapping(value = {"/order"})
public class OrderController {

    @Autowired
    private MechanicService mechanicService;

    @Autowired
    OrderService orderService;

    private static final Logger logger = LogManager.getLogger(OrderController.class);

    @GetMapping(value = {"/new"})
    public ModelAndView newOrder(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("mechanics", mechanicService.findAllMechanics());
        modelAndView.setViewName("new-order");

        return modelAndView;
    }

    @PostMapping(value = {"/new"})
    public ModelAndView registerNewOrder(@ModelAttribute("orderDTO")OrderDTO orderDTO, HttpServletRequest httpServletRequest){
        orderDTO.setServiceList(Arrays.asList(httpServletRequest.getParameterValues("service")));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("order", orderService.saveOrder(orderDTO));
        modelAndView.setViewName("test");

        return modelAndView;
    }
}
