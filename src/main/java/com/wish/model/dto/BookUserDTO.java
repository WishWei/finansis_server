package com.wish.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by wish on 2017/5/28.
 */
@ApiModel("用户账本关系")
public class BookUserDTO {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("账本id")
    private Integer bookId;
    @ApiModelProperty("用户id")
    private Integer userId;
    @ApiModelProperty("邀请人id")
    private Integer invitedBy;
    @ApiModelProperty("加入时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date joinTime;
    @ApiModelProperty("0离开，1加入")
    private Integer status;
    @ApiModelProperty("被请出执行人id")
    private Integer leaveBy;
    @ApiModelProperty("离开时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date leaveTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getInvitedBy() {
        return invitedBy;
    }

    public void setInvitedBy(Integer invitedBy) {
        this.invitedBy = invitedBy;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLeaveBy() {
        return leaveBy;
    }

    public void setLeaveBy(Integer leaveBy) {
        this.leaveBy = leaveBy;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }
}
