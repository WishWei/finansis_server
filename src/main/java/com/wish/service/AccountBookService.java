package com.wish.service;

import com.wish.model.dto.AccountBookDTO;
import com.wish.model.dto.PageInfo;

/**
 * 账本service
 * Created by wish on 2017/5/28.
 */
public interface AccountBookService {
    /**
     * 保存账本
     *
     * @param accountBookDTO
     */
    void saveAccountBook(AccountBookDTO accountBookDTO);

    /**
     * 根据用户id分页查询账本
     *
     * @param userId 用户id
     * @param page 页
     * @param pageSize 每页条数
     * @return
     */
    PageInfo<AccountBookDTO> findAccountBookByUserIdPage(Integer userId, int page, int pageSize);
}
