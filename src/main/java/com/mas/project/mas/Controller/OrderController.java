package com.mas.project.mas.Controller;

import com.mas.project.mas.Beans.OrderCollector;
import com.mas.project.mas.Service.MechanicService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Janusz on 11.06.2017.
 */
@Controller
@RequestMapping(value = {"/order"})
public class OrderController {

    @Autowired
    private MechanicService mechanicService;

    private static final Logger logger = LogManager.getLogger(OrderController.class);

    @GetMapping(value = {"/new"})
    public ModelAndView newOrder(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("mechanics", mechanicService.findAllMechanics());
        modelAndView.setViewName("new-order");

        return modelAndView;
    }

    @PostMapping(value = {"/new"})
    public ModelAndView registerNewOrder(@ModelAttribute("orderCollector")OrderCollector orderCollector){
        logger.debug(" >> Inside registerNewOrde method");
        logger.debug(" >> Order collectro sample value: " + orderCollector.getLastName());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");

        return modelAndView;
    }
}
