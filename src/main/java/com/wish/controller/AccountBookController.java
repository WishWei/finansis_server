package com.wish.controller;

import com.wish.model.dto.AccountBookDTO;
import com.wish.model.dto.PageInfo;
import com.wish.model.dto.ResponseBean;
import com.wish.service.AccountBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 账本controller
 * Created by wish on 2017/5/28.
 */
@Controller
@RequestMapping("accountBook")
@Api(value = "账本", description = "账本相关")
public class AccountBookController {
    @Autowired
    private AccountBookService accountBookService;

    @RequestMapping(value = "/saveAccountBook.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "保存账本", notes = "保存账本")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginUserId", value = "登录用户id", required = true, paramType = "header", dataType = "String"),
            @ApiImplicitParam(name = "name", value = "名称", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "description", value = "描述", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "headImg", value = "封面图片", paramType = "query", dataType = "String"),
    })
    public ResponseBean saveAccountBook(@RequestHeader("loginUserId") Integer loginUserId, @RequestParam("name") String name,
                                        @RequestParam("description") String description, String headImg) {

        AccountBookDTO accountBookDTO = new AccountBookDTO();
        accountBookDTO.setName(name);
        accountBookDTO.setDescription(description);
        accountBookDTO.setHeadImg(headImg);
        accountBookDTO.setCreateBy(loginUserId);

        try {
            accountBookService.saveAccountBook(accountBookDTO);
            return ResponseBean.responseSuccess("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.responseError("保存失败");
        }

    }

    @RequestMapping(value = "/findAccountBookByUserIdPage.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据用户查询账本", notes = "根据用户查询关联的账本")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginUserId", value = "登录用户id", required = true, paramType = "header", dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, paramType = "query", dataType = "String"),
    })
    public ResponseBean<PageInfo<AccountBookDTO>> findAccountBookByUserIdPage(@RequestHeader("loginUserId") Integer loginUserId,int page, int pageSize) {
        try {
            PageInfo pageInfo = accountBookService.findAccountBookByUserIdPage(loginUserId, page, pageSize);
            return ResponseBean.responseSuccess(pageInfo, "查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.responseError("查询失败");
        }
    }
}
