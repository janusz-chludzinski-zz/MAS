package com.mas.project.mas.Controller;

import com.mas.project.mas.Entity.User;
import com.mas.project.mas.Service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Janusz on 09.06.2017.
 */

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LogManager.getLogger(LoginController.class);


    @RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
    public ModelAndView log(){
        logger.debug(" >>>>>>>>>>>>>>>>>>>>>>>> test output");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }


    @RequestMapping(value={"/zyziek"}, method = RequestMethod.GET)
    public ModelAndView zyziek(){
        logger.debug("....home method start");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("zyziek");

        return modelAndView;
    }

    @RequestMapping(value ={"/login"}, method = RequestMethod.POST)
    public ModelAndView login() {
        logger.debug("....login method start");
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("user", user);
        modelAndView.setViewName("home");
        return modelAndView;
    }

}
