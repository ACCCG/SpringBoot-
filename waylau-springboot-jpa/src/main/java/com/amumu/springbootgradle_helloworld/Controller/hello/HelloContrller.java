package com.amumu.springbootgradle_helloworld.Controller.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  HelloContrller {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World~~";
    }
}
