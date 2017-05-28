package com.wish.mapper;

import com.wish.model.dto.AccountBookDTO;

/**
 * 账本mapper
 * Created by wish on 2017/5/28.
 */
public interface AccountBookMapper {
    /**
     * 保存账本
     * @param accountBookDTO
     */
    void saveAccountBook(AccountBookDTO accountBookDTO);
}
