package com.atguigu.ioc_annotation.controller;

import com.atguigu.ioc_annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
//@Controller("controller")
public class UserController {
    @Autowired
    //@Qualifier("userServiceImpl")
    //@Qualifier("service")
    private UserService userService;

    //@Autowired
    /*public UserController(UserService userService) {
        this.userService = userService;
    }*/

    //@Autowired
    /*public void setUserService(UserService userService) {
        this.userService = userService;
    }*/

    public void saveUser(){
        userService.saveUser();
    }
}
