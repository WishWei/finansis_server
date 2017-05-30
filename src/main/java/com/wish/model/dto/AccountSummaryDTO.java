package com.wish.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by wish on 2017/5/30.
 */
@ApiModel("账本统计")
public class AccountSummaryDTO {
    @ApiModelProperty("总金额")
    private BigDecimal totalMoney;
    @ApiModelProperty("明细数量")
    private int detailCount;

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getDetailCount() {
        return detailCount;
    }

    public void setDetailCount(int detailCount) {
        this.detailCount = detailCount;
    }
}
