package com.wish.service;

import com.wish.model.dto.AccountBookDTO;

/**
 * 账本service
 * Created by wish on 2017/5/28.
 */
public interface AccountBookService {
    /**
     * 保存账本
     * @param accountBookDTO
     */
    void saveAccountBook(AccountBookDTO accountBookDTO);
}
