package com.spring.webmvc.springmvc.chap03;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
public class RequestController {

    @RequestMapping(value = "/req/hello", method = RequestMethod.POST) // only works with 'post' (not 'get')
    @ResponseBody
    public String hello() {
        log.info("/req/hello requested");
        return "hello!!!";
    }

    @GetMapping("/req/bye") // same as the above code but with 'get' instead of 'post' <-> PostMapping
    @ResponseBody
    public String bye() {
        log.info("/req/bye GET requested");
        return "bye!!!";
    }
    
    // URL에서 파라미터 얻기
    @GetMapping("/member/{userName}") // -> 무조건 GET, no POST
    @ResponseBody
    public String member(@PathVariable String userName) { // 같은 이름이면 PV("") 생략 가능
        return "I am " + userName;
    }
}
