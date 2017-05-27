package com.wish.service;

import com.wish.model.dto.UserDTO;

/**
 * 用户service
 * Created by wish on 2017/5/27.
 */
public interface UserService {
    /**
     * 登录
     * @param name 用户名
     * @param password 密码
     * @return
     */
    UserDTO login(String name, String password);
}
