package com.spring.webmvc.chap04.v2.controller;

import com.spring.webmvc.chap04.View;
import com.spring.webmvc.member.model.Member;
import com.spring.webmvc.member.repository.MemberRepository;
import com.spring.webmvc.member.repository.MemoryMemberRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowController implements ControllerV2 {

    private final MemberRepository repository = MemoryMemberRepo.getInstance();

    @Override
    public View process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = repository.findAll();
        // System.out.println(members);

        // Model : Controller & View 사이의 데이터(리스트)를 운반하는 수단 객체
        // - 여기서는 모델의 역할은 Request 객체가 담당
        request.setAttribute("mLists", members); // request 객체에 데이터를 저장

        return new View("/WEB-INF/views/members.jsp");
    }
}
