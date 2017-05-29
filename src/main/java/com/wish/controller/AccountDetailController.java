package com.wish.controller;

import com.wish.model.dto.AccountBookDTO;
import com.wish.model.dto.AccountDetailDTO;
import com.wish.model.dto.PageInfo;
import com.wish.model.dto.ResponseBean;
import com.wish.service.AccountDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * 账本明细controller
 * Created by wish on 2017/5/29.
 */
@Controller
@RequestMapping("accountDetail")
@Api(value = "账本明细", description = "账本明细相关")
public class AccountDetailController {

    @Autowired
    private AccountDetailService accountDetailService;

    @RequestMapping(value = "/saveAccountDetail.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "保存账本明细", notes = "保存账本明细")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginUserId", value = "登录用户id", required = true, paramType = "header", dataType = "String"),
            @ApiImplicitParam(name = "bookId", value = "账本id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "type", value = "类型 1支出 2充值到账本", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "money", value = "金额", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "accountTime", value = "交易时间 yyyy-MM-dd HH:mm:ss", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "category", value = "类别", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "remark", value = "备注", paramType = "query", dataType = "String"),
    })
    public ResponseBean saveAccountDetail(@RequestHeader("loginUserId") Integer loginUserId,
                                          @RequestParam("bookId") Integer bookId,
                                          @RequestParam("type") Integer type,
                                          @RequestParam("money") BigDecimal money,
                                          @RequestParam("accountTime") String accountTime,
                                          @RequestParam("category") String category,
                                          @RequestParam("remark") String remark) throws Exception{

        try {
            AccountDetailDTO accountDetailDTO = new AccountDetailDTO();
            accountDetailDTO.setUserId(loginUserId);
            accountDetailDTO.setBookId(bookId);
            accountDetailDTO.setType(type);
            accountDetailDTO.setMoney(money);
            accountDetailDTO.setAccountTime(DateUtils.parseDate(accountTime, new String[]{"yyyy-MM-dd HH:mm:ss"}));
            accountDetailDTO.setCategory(category);
            accountDetailDTO.setRemark(remark);
            accountDetailService.saveAccountDetail(accountDetailDTO);
            return ResponseBean.responseSuccess("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.responseError("保存失败");
        }

    }

    @RequestMapping(value = "/findBookDetailByBookIdPage.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据账本id分页查询明细", notes = "根据账本id分页查询明细")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bookId", value = "账本id", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, paramType = "query", dataType = "String"),
    })
    public ResponseBean<PageInfo<AccountBookDTO>> findAccountBookByUserIdPage(@RequestParam("bookId") Integer bookId, int page, int pageSize) {
        try {
            PageInfo pageInfo = accountDetailService.findBookDetailByBookIdPage(bookId, page, pageSize);
            return ResponseBean.responseSuccess(pageInfo, "查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.responseError("查询失败");
        }
    }

}
