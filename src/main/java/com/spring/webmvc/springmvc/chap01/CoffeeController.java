package com.spring.webmvc.springmvc.chap01;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/coffee")
public class CoffeeController {

    @RequestMapping("/form")
    public String form() {
        log.info("/coffee/form GET Request");
        return "chap01/coffee-form";
    }


    @RequestMapping("/result")
    public String result(String menu, int price, Model model) {
        log.info("/coffee/result POST Request : [" + menu + ", " + price + "]");

        model.addAttribute("menu", menu);
        model.addAttribute("p", price);

        return "chap01/coffee-result";
    }

}
