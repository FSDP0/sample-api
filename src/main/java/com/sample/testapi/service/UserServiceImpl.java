package com.sample.testapi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sample.testapi.mapper.master.MasterUserMapper;
import com.sample.testapi.mapper.slave.SlaveUserMapper;
import com.sample.testapi.model.User;
import com.sample.testapi.model.UserAddressDto;
import com.sample.testapi.model.UserDto;

@Service
public class UserServiceImpl implements UserService {
    private final MasterUserMapper masterUserMapper; // INSERT, UPDATE, DELETE
    private final SlaveUserMapper slaveUserMapper; // SELECT

    public UserServiceImpl(MasterUserMapper masterUserMapper, SlaveUserMapper slaveUserMapper) {
        this.masterUserMapper = masterUserMapper;
        this.slaveUserMapper = slaveUserMapper;
    }

    @Override
    public List<User> findAll() {
        return this.slaveUserMapper.findAll();
    }

    @Override
    public List<UserAddressDto> findAllDetail() {
        return this.slaveUserMapper.findAllDetail();
    }

    @Override
    public UserAddressDto findById(Integer id) {
        return this.slaveUserMapper.findById(id);
    }

    @Override
    public void createUser(UserDto userDto) {
        this.masterUserMapper.createUser(userDto);
    }

    @Override
    public void updateUser(Integer userId, UserDto userDto) {
        this.masterUserMapper.updateUser(userId, userDto);
    }

    @Override
    public void deleteUser(Integer id) {
        this.masterUserMapper.deleteUser(id);
    }

}
