package com.spring.webmvc.chap04.v3.controller;

import com.spring.webmvc.chap04.View;
import com.spring.webmvc.chap04.v2.controller.ControllerV2;
import com.spring.webmvc.member.model.Member;
import com.spring.webmvc.member.repository.MemberRepository;
import com.spring.webmvc.member.repository.MemoryMemberRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ShowController implements ControllerV3 {

    private final MemberRepository repository = MemoryMemberRepo.getInstance();

    @Override
    public View process(Map<String, String> paramMap) {
        List<Member> members = repository.findAll();
        // request.setAttribute("mLists", members);
        return new View("/WEB-INF/views/members.jsp");
    }
}
