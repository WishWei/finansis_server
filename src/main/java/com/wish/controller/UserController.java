package com.wish.controller;

import com.wish.model.dto.ResponseBean;
import com.wish.model.dto.UserDTO;
import com.wish.service.UserService;
import com.wish.util.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户Controller
 * Created by wish on 2017/5/27.
 */
@Controller
@RequestMapping("user")
@Api(value = "用户", description = "用户相关")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "用户登录", notes = "通过用户名和密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "账号", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query", dataType = "String")
    })
    public ResponseBean<UserDTO> login(@RequestParam("name") String name, @RequestParam("password") String password) {
        //密码加密
        String md5Password = MD5Util.MD5(password);
        UserDTO userDTO = userService.login(name,md5Password);
        if(userDTO == null) {
            return ResponseBean.responseError("用户名或密码错误");
        }
        return ResponseBean.responseSuccess(userDTO, "登录成功");

    }
}
