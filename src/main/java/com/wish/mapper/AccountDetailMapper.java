package com.wish.mapper;

import com.wish.model.dto.AccountDetailDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 账单明细mapper
 * Created by wish on 2017/5/29.
 */
public interface AccountDetailMapper {

    /**
     * 保存账本明细
     * @param accountDetailDTO
     */
    void saveAccountDetail(AccountDetailDTO accountDetailDTO);

    /**
     * 根据账本id分页查询明细
     * @param map
     * @return
     */
    List<AccountDetailDTO> findBookDetailByBookIdPage(@Param("map") Map<String,Object> map);

}
