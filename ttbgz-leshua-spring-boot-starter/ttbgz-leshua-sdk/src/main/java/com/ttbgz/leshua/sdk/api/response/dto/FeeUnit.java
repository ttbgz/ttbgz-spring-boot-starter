package com.ttbgz.leshua.sdk.api.response.dto;

import java.io.Serializable;

public class FeeUnit implements Serializable {

    private static final long serialVersionUID = 2390821965605196650L;

    //单位均为万分之一
    private Integer rate;//费率
    private Integer minCharge;//最低收费
    private Integer maxCharge;//最高收费
    private Integer fixedCharge;//每笔固定收费
    private Integer extRate;//额外收费

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getMinCharge() {
        return minCharge;
    }

    public void setMinCharge(Integer minCharge) {
        this.minCharge = minCharge;
    }

    public Integer getMaxCharge() {
        return maxCharge;
    }

    public void setMaxCharge(Integer maxCharge) {
        this.maxCharge = maxCharge;
    }

    public Integer getFixedCharge() {
        return fixedCharge;
    }

    public void setFixedCharge(Integer fixedCharge) {
        this.fixedCharge = fixedCharge;
    }

    public Integer getExtRate() {
        return extRate;
    }

    public void setExtRate(Integer extRate) {
        this.extRate = extRate;
    }

    @Override
    public String toString() {
        return "{" +
                "rate=" + rate +
                ", minCharge=" + minCharge +
                ", maxCharge=" + maxCharge +
                ", fixedCharge=" + fixedCharge +
                ", extRate=" + extRate +
                '}';
    }
}
