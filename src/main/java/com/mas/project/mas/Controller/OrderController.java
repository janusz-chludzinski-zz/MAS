package com.mas.project.mas.Controller;

import com.mas.project.mas.Beans.OrderDTO;
import com.mas.project.mas.Entity.Order;
import com.mas.project.mas.Repository.OrderRepository;
import com.mas.project.mas.Service.MechanicService;
import com.mas.project.mas.Service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

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
        modelAndView.addObject("orderDTO", new OrderDTO());
        modelAndView.addObject("mechanics", mechanicService.findAllMechanics());
        modelAndView.setViewName("new-order");

        return modelAndView;
    }

    @PostMapping(value = {"/new"})
    public ModelAndView registerNewOrder(@ModelAttribute("orderDTO") @Valid OrderDTO orderDTO, BindingResult bindingResult, HttpServletRequest httpServletRequest){
        ModelAndView modelAndView = new ModelAndView();

        if(bindingResult.hasErrors()){
            modelAndView.addObject("mechanics", mechanicService.findAllMechanics());
            modelAndView.setViewName("new-order");
            return modelAndView;
        }

        orderDTO.setServiceList(Arrays.asList(httpServletRequest.getParameterValues("service")));
        Order order = orderService.saveOrder(orderDTO);
        modelAndView.setViewName("redirect:/order/" + order.getId());

        return modelAndView;
    }

    @GetMapping(value = {"/{orderId}"})
    public ModelAndView findOrder(@PathVariable Integer orderId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order-preview");
        modelAndView.addObject("order", orderService.findOneOrder(orderId));
        return modelAndView;
    }

    @GetMapping(value = {"/all"})
    public ModelAndView listAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Order> orders = orderService.findAllOrders();
        modelAndView.addObject("orders", orders);
        modelAndView.setViewName("all-orders");
        return modelAndView;
    }
}
