package com.sample.testapi.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sample.testapi.model.UserAddressDto;
import com.sample.testapi.model.UserDto;
import com.sample.testapi.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserAddressDto> findAll() {
        return this.userService.findAllDetail();
    }

    // 회원 상세 조회
    @GetMapping("/{userId}")
    public UserAddressDto findById(@PathVariable Integer userId) {
        return userService.findById(userId);
    }

    // 회원 등록
    @PostMapping
    private void createUser(@RequestBody UserDto dto) {
        this.userService.createUser(dto);
    }

    // 회원 수정
    @PutMapping("/{userId}")
    private void editUserInfo(@PathVariable Integer userId, @RequestBody UserDto dto) {
        this.userService.updateUser(userId, dto);
    }

    // 회원 삭제
    @DeleteMapping("/{userId}")
    private void deleteUser(@PathVariable Integer userId) {
        this.userService.deleteUser(userId);
    }
}
