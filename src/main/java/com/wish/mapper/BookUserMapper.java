package com.wish.mapper;

import com.wish.model.dto.BookUserDTO;

/**
 * 账本用户关系
 * Created by wish on 2017/5/28.
 */
public interface BookUserMapper {

    /**
     * 保存账本用户关系
     * @param bookUserDTO
     */
    void saveBookUser(BookUserDTO bookUserDTO);
}
