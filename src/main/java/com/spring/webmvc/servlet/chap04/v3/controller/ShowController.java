package com.spring.webmvc.servlet.chap04.v3.controller;

import com.spring.webmvc.servlet.chap04.ModelAndView;
import com.spring.webmvc.servlet.chap04.v5.member.model.Member;
import com.spring.webmvc.servlet.chap04.v5.member.repository.MemberRepository;
import com.spring.webmvc.servlet.chap04.v5.member.repository.MemoryMemberRepo;

import java.util.List;
import java.util.Map;

public class ShowController implements ControllerV3 {

    private final MemberRepository repository = MemoryMemberRepo.getInstance();

    @Override
    public ModelAndView process(Map<String, String> paramMap) {
        List<Member> members = repository.findAll();
        ModelAndView mv = new ModelAndView("members");
        // request.setAttribute("mLists", members);
        mv.addAttribute("mLists", members);
        return mv;
    }
}
