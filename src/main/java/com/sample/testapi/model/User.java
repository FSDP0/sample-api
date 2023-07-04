package com.sample.testapi.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class User {

    private Integer id; // 회원id

    private String name; // 이름

    private String email; // 메일

    private Integer gender; // 성별

    @Builder
    private User(Integer id, String name, String email, Integer gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}
