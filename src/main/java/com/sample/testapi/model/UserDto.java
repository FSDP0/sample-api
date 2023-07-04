package com.sample.testapi.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private Integer gender;

    @Builder
    private UserDto(Integer id, String name, String email, Integer gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public User toEntity() {
        User user = User.builder().id(this.id).name(this.name).email(this.email).gender(this.gender)
                .build();
        return user;
    }
}
