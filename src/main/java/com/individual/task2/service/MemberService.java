package com.individual.task2.service;

import com.individual.task2.models.Member;
import com.individual.task2.models.MemberRepository;
import com.individual.task2.models.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    public Boolean isValidUsername(MemberRequestDto requestDto){
        return memberRepository.existsByUsername(requestDto.getUsername());
    }
}
