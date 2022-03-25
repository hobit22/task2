package com.individual.task2.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class MemberRequestDto {
    private final String username;
    private final String password;
}
