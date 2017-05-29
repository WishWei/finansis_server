package com.wish.service.impl;

import com.wish.mapper.AccountDetailMapper;
import com.wish.model.dto.AccountDetailDTO;
import com.wish.model.dto.PageInfo;
import com.wish.service.AccountDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 账单明细service
 * Created by wish on 2017/5/29.
 */
@Service
@Transactional
public class AccountDetailServiceImpl implements AccountDetailService{

    @Autowired
    private AccountDetailMapper accountDetailMapper;

    public void saveAccountDetail(AccountDetailDTO accountDetailDTO) {
        accountDetailMapper.saveAccountDetail(accountDetailDTO);
    }

    @Override
    public PageInfo<AccountDetailDTO> findBookDetailByBookIdPage(Integer bookId, int page, int pageSize) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPage(page);
        pageInfo.setPageSize(pageSize);
        Map<String,Object> params = new HashMap<>();
        params.put("page", pageInfo);
        params.put("bookId", bookId);
        List<AccountDetailDTO> accountDetailDTOS = accountDetailMapper.findBookDetailByBookIdPage(params);
        pageInfo.setItems(accountDetailDTOS);
        return pageInfo;
    }
}
