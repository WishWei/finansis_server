package com.wish.service;

import com.wish.model.dto.AccountDetailDTO;
import com.wish.model.dto.PageInfo;

/**
 * Created by wish on 2017/5/29.
 */
public interface AccountDetailService {

    /**
     * 保存账本明细
     *
     * @param accountDetailDTO
     */
    void saveAccountDetail(AccountDetailDTO accountDetailDTO);

    /**
     * 根据账本id分页查询明细
     *
     * @param bookId 账本id
     * @param page 页
     * @param pageSize 每页条数
     * @return
     */
    PageInfo<AccountDetailDTO> findBookDetailByBookIdPage(Integer bookId, int page, int pageSize);
}
