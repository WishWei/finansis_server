package com.wish.mapper;

import com.wish.model.dto.AccountBookDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据用户id分页查询关联的账本
     * @param map
     * @return
     */
    List<AccountBookDTO> findBookByUserIdPage(@Param("map") Map<String,Object> map);
}
