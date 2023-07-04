package com.sample.testapi.service;

import java.util.List;
import com.sample.testapi.model.User;
import com.sample.testapi.model.UserAddressDto;
import com.sample.testapi.model.UserDto;

public interface UserService {
    // 회원 목록 조회
    List<User> findAll();

    List<UserAddressDto> findAllDetail();

    // 회원 상세 조회
    UserAddressDto findById(Integer id);

    // 회원 등록
    void createUser(UserDto userDto);

    // 회원 수정
    void updateUser(Integer userId, UserDto userDto);

    // 회원 삭제
    void deleteUser(Integer id);
}
