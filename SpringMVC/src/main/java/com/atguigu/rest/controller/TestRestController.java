package com.atguigu.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *查询所有的用户信息：/user-->get
 *根据id查询用户信息：/user/1-->get
 *添加用户信息：/user-->post
 *修改用户信息：/user-->put
 *删除用户信息：/user/1-->delete
 */

@Controller
public class TestRestController {
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有的用户信息：/user-->get");
        return "success";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id){
        System.out.println("根据id查询用户信息：/user/"+id+"-->get");
        return "success";
    }
}
