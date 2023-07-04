package com.sample.testapi.mapper.slave;

import java.util.List;
import com.sample.testapi.model.User;
import com.sample.testapi.model.UserAddressDto;

public interface SlaveUserMapper {
    // 회원 목록 조회
    List<User> findAll();

    // 회원 주소 포함 목록 조회
    List<UserAddressDto> findAllDetail();

    // 회원 상세 조회
    UserAddressDto findById(Integer id);
}
