package com.individual.task2.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Setter
public class Member {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    public Member(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Member(MemberRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
    }

}
