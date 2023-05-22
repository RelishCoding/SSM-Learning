package com.atguigu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 1.@RequestMapping注解所标识的位置：
 * @RequestMapping标识一个类：设置映射请求的请求路径的初始信息
 * @RequestMapping标识一个方法：设置映射请求请求路径的具体信息
 *
 * 2.@RequestMapping注解value属性：
 * 作用：通过请求的请求路径匹配请求
 * value属性是数组类型，即当前浏览器所发送请求的请求路径匹配value属性中的任何一个值
 * 则当前请求就会被注解所标识的方法进行处理
 *
 * 3.@RequestMapping注解的method属性
 * 作用：通过请求的请求方式匹配请求
 * method属性是RequestMethod类型的数组，即当前浏览器所发送请求的请求方式匹配method属性中的任何一种请求方式
 * 则当前请求就会被注解所标识的方法进行处理
 * 若浏览器所发送的请求的请求路径和@RequestMapping注解的value属性匹配，但是请求方式不匹配
 * 此时页面报错：405 - Request method 'GET' not supported
 * 在RequestMapping的基础上，结合请求方式的一些派生注解：
 * @GetMapping，@PostMapping，@DeleteMapping，@PutMapping
 *
 * 4.@RequestMapping注解的params属性
 * 作用：通过请求的请求参数匹配请求，即浏览器发送的请求的请求参数必须满足params属性的设置
 * params可以使用四种表达式：
 * "param"：表示当前请求的请求参数中必须携带param参数
 * "!param"：表示当前请求的请求参数中一定不能携带param参数
 * "param=value"：表示当前请求的请求参数中必须携带param参数且值必须为value
 * "param!=value"：表示当前请求的请求参数中可以不携带param参数，若携带值一定不能是value
 * 若浏览器所发送的请求的请求路径和@RequestMapping注解的value属性匹配，但是请求参数不匹配
 * 此时页面报错：400 - Parameter conditions "username" not met for actual request parameters:
 */

@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {
    //此时控制器方法所匹配的请求的请求路径为/test/hello
    @RequestMapping(
            value = {"/hello","/abc"},
            method = {RequestMethod.POST,RequestMethod.GET}
            //params = {"username","!password","age=20","gender!=女"}
    )
    public String hello(){
        return "success";
    }
}
