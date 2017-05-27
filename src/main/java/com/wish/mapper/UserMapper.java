package com.wish.mapper;

import com.wish.model.dto.UserDTO;
import org.apache.ibatis.annotations.Param;

/**
 * 用户Mapper
 * Created by wish on 2017/5/27.
 */
public interface UserMapper {
    /**
     * 根据用户名和密码查询用户
     * @param name 用户名
     * @param password 密码
     * @return
     */
    UserDTO findUserByUserNameAndPassword(@Param("name") String name, @Param("password") String password);

    /**
     * 更新上次登录时间为当前时间
     * @param userId
     */
    void updateLastLogin(Integer userId);
}
