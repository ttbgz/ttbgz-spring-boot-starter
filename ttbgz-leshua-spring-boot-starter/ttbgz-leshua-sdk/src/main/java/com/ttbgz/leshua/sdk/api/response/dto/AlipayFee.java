package com.ttbgz.leshua.sdk.api.response.dto;

//支付宝扫码费率
public class AlipayFee {
    private FeeUnit t1;//线下扫码t+1日结算费率
    private FeeUnit bluesea;//蓝海活动费率
    private FeeUnit activityFee0;//0费率活动费率
    private FeeUnit activityFee0Dot1;//0.1费率活动费率

    public FeeUnit getT1() {
        return t1;
    }

    public void setT1(FeeUnit t1) {
        this.t1 = t1;
    }

    public FeeUnit getBluesea() {
        return bluesea;
    }

    public void setBluesea(FeeUnit bluesea) {
        this.bluesea = bluesea;
    }

    public FeeUnit getActivityFee0() {
        return activityFee0;
    }

    public void setActivityFee0(FeeUnit activityFee0) {
        this.activityFee0 = activityFee0;
    }

    public FeeUnit getActivityFee0Dot1() {
        return activityFee0Dot1;
    }

    public void setActivityFee0Dot1(FeeUnit activityFee0Dot1) {
        this.activityFee0Dot1 = activityFee0Dot1;
    }

    @Override
    public String toString() {
        return "{" +
                "t1:" + t1 +
                ", bluesea:" + bluesea +
                ", activityFee0:" + activityFee0 +
                ", activityFee0Dot1:" + activityFee0Dot1 +
                '}';
    }
}
