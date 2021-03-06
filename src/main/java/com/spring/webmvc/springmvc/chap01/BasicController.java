package com.spring.webmvc.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller // 스프링 컨테이너에 빈 등록
// 스프링의 HandlerMapping이 찾아서 DispatcherServlet에 연결함.
public class BasicController {

    // Client 요청 받기
    @RequestMapping("/spring/about") // 요청 URL을 적용
    public String about() {
        System.out.println("about 요청이 들어옴!!!");

        // /WEB-INF/views/about.jsp 포워딩 
        return "about"; // jsp 파일 포워딩, 리다이렉트
    }

    @RequestMapping("/spring/hello") // 요청 URL을 적용
    public String hello() {
        System.out.println("hello 요청이 들어옴!!!");

        // /mvc/join 으로 재요청 (redirect)
        return "redirect:/mvc/join"; // jsp 파일 포워딩, 리다이렉트
    }

    // =================== 요청 파라미터 받기 (Query Parameter) =================== //

    //== 1. HTTPServletRequest 사용하기
    //== ex) /spring/person?name=kim&age=30
    @RequestMapping("/spring/person")
    public String person(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        return "";
    }

    //== 2. @RequestParam 사용하기
    //= ex) /spring/major?stu=kim&major=business&grade=3
    @RequestMapping("/spring/major")
    public String major(
            @RequestParam("stu") String student
            , @RequestParam("major") String major
            , @RequestParam("grade") int grade
    ) {
        System.out.println("stu = " + student);
        System.out.println("major = " + major);
        System.out.println("grade = " + grade);

        return "";
    }

    // 요청 파라미터 키값과 메서드 매개변수 이름이 같으면
    // @RequestParam 생략 가능
    @RequestMapping("/spring/major2")
    public String major2(String stu, String major, int grade) {
        System.out.println("stu2 = " + stu);
        System.out.println("major2 = " + major);
        System.out.println("grade2 = " + grade);

        return "";
    }
    
    //== 3. 커맨드 객체 이용하기
    //== ex) /spring/order?oNum=22&goods=구두&amount=3&price=10000....
    // *** 쿼리 파라미텉 키값과 커맨드객체 필드명이 같아야 인식함
    // *** 반드시 setter/getter 있어야 함.
    @RequestMapping("/spring/order")
    public String order(Order order) {
        System.out.println(order);
        return "";
    }
}

