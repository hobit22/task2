package com.individual.task2.controller;

import com.individual.task2.models.Member;
import com.individual.task2.models.MemberRepository;
import com.individual.task2.models.MemberRequestDto;
import com.individual.task2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginPage(){

        return "/user/login";
    }

    @PostMapping("/login")
    public String loginProcess(@RequestParam String username, @RequestParam String password, Model model){
        Member member = memberRepository.findByUsername(username);
        String encodePassword = passwordEncoder.encode(password);
        if(member == null){
            return "error";
        }
        System.out.println("password = " + password);
        System.out.println("encodePassword = " + encodePassword);
        System.out.println("member.password = " + member.getPassword());
        boolean check = passwordEncoder.matches(password, member.getPassword());
        if(!check){
            System.out.println("비밀번호 다름!");
            return "error";
        }
        System.out.println("로그인 성공!");
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
        String encodePassword = passwordEncoder.encode(requestDto.getPassword());

        Member member= new Member(requestDto);
        member.setPassword(encodePassword);
        memberRepository.save(member);
        return "/user/login";
    }
}
