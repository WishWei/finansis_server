package com.wish.service.impl;

import com.wish.mapper.UserMapper;
import com.wish.model.dto.UserDTO;
import com.wish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wish on 2017/5/27.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDTO login(String name, String password) {
        UserDTO userDTO = userMapper.findUserByUserNameAndPassword(name, password);
        if(userDTO != null) {
            //更新上次登录时间为当前时间
            userMapper.updateLastLogin(userDTO.getId());
        }
        return userDTO;
    }
}
