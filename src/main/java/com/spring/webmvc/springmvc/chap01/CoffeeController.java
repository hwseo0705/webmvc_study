package com.spring.webmvc.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {

    @RequestMapping("/menu")
    public String form() {
        return "chap01/coffee-form";
    }

}
