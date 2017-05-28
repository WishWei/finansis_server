package com.wish.service.impl;

import com.wish.mapper.AccountBookMapper;
import com.wish.mapper.BookUserMapper;
import com.wish.model.dto.AccountBookDTO;
import com.wish.model.dto.BookUserDTO;
import com.wish.model.dto.PageInfo;
import com.wish.service.AccountBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wish on 2017/5/28.
 */
@Service
@Transactional
public class AccountBookServiceImpl implements AccountBookService{

    @Autowired
    private AccountBookMapper accountBookMapper;

    @Autowired
    private BookUserMapper bookUserMapper;

    @Override
    public void saveAccountBook(AccountBookDTO accountBookDTO) {
        //保存账本
        accountBookMapper.saveAccountBook(accountBookDTO);
        //添加账本后将创建人添加到账本
        BookUserDTO bookUserDTO = new BookUserDTO();
        bookUserDTO.setBookId(accountBookDTO.getId());
        bookUserDTO.setUserId(accountBookDTO.getCreateBy());
        bookUserMapper.saveBookUser(bookUserDTO);
    }

    @Override
    public PageInfo<AccountBookDTO> findAccountBookByUserIdPage(Integer userId, int page, int pageSize) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPage(page);
        pageInfo.setPageSize(pageSize);
        Map<String,Object> params = new HashMap<>();
        params.put("page", pageInfo);
        params.put("userId", userId);
        List<AccountBookDTO> accountBookDTOList = accountBookMapper.findBookByUserIdPage(params);
        pageInfo.setItems(accountBookDTOList);
        return pageInfo;
    }
}
