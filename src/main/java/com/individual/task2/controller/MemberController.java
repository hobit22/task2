package com.individual.task2.controller;

import com.individual.task2.models.Member;
import com.individual.task2.models.MemberRepository;
import com.individual.task2.models.MemberRequestDto;
import com.individual.task2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @GetMapping("/login")
    public String loginPage(){

        return "/user/login";
    }

    @PostMapping("/login")
    public String loginProcess(@RequestParam String username, @RequestParam String password, Model model){
        System.out.println(username);
        System.out.println(password);
        model.addAttribute("username", username);
        return "index";
    }

    @GetMapping("/signup")
    public String signInPage(){
        return "/user/signup";
    }

    @PostMapping("/signup")
    public String signInPage(@ModelAttribute MemberRequestDto requestDto){
        if(memberService.isValidUsername(requestDto)){
            System.out.println("이미존재해");
            return "/user/signup";
        }
        System.out.println("등록가능");
        Member member= new Member(requestDto);
        memberRepository.save(member);
        return "/user/login";
    }
}
