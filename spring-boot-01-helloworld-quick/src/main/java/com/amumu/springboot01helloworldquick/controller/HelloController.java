package com.amumu.springboot01helloworldquick.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * RequestMapping写在这里
 * 这个类的所有方法返回数据直接写给浏览器
 */
/*@RequestMapping("/hello")
@Controller*/
/**
 * RestController 可以直接替代 ResponseBody + Controller
 * */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World quick";
    }
}
