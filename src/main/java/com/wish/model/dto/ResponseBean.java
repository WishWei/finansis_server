package com.wish.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 响应
 * Created by wish on 2017/5/28.
 */
@ApiModel("响应")
public class ResponseBean <T> {

    //成功
    public static Integer CODE_SUCCESS = 200;
    //失败
    public static Integer CODE_ERROR = 201;

    @ApiModelProperty("code，200：成功 201失败")
    private int code;
    @ApiModelProperty("内容")
    private T content;
    @ApiModelProperty("消息")
    private String message;

    public static ResponseBean responseSuccess(Object content) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.code = CODE_SUCCESS;
        responseBean.content = content;
        return responseBean;
    }

    public static ResponseBean responseSuccess(Object content, String message) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.code = CODE_SUCCESS;
        responseBean.content = content;
        responseBean.message = message;
        return responseBean;
    }

    public static ResponseBean responseError(String message) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.code = CODE_ERROR;
        responseBean.message = message;
        return responseBean;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
