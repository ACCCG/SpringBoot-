package com.amumu.springboot01helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {
    //说明要返回body
    @ResponseBody
    //接受浏览器的hell请求
    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }
}
