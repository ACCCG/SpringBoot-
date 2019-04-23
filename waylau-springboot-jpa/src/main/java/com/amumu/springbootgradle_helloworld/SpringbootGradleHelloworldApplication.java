package com.amumu.springbootgradle_helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@SpringBootApplication
public class SpringbootGradleHelloworldApplication {

    @GetMapping("")
    public ModelAndView Redict() {
        return new ModelAndView("redirect:/users");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootGradleHelloworldApplication.class, args);
    }

}
