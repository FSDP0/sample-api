package com.sample.testapi.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserAddressDto {

    private Integer id; // 회원id
    private String name; // 이름
    private String email; // 메일
    private Integer gender; // 성별
    private Integer zipCode; // 우편번호
    private String detailAddr; // 상세주소

    public User toUserEntity() {
        User user = User.builder().id(this.id).name(this.name).email(this.email).gender(this.gender)
                .build();
        return user;
    }

    public Address toAddressEntity() {
        Address address = Address.builder().id(this.id).zipCode(this.zipCode)
                .detailAddress(this.detailAddr).build();
        return address;
    }

    @Builder
    public UserAddressDto(Integer id, String name, String email, Integer gender, Integer zipCode,
            String detailAddress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.zipCode = zipCode;
        this.detailAddr = detailAddress;
    }
}
