package com.ttbgz.leshua.sdk.api.response.dto;

//刷卡费率
public class CardFee {
    private FeeUnit t0Credit;//t日结算贷记卡费率
    private FeeUnit t0Debit;//t日结算借记卡费率
    private FeeUnit t0OverSee;//t日结算境外卡费率
    private FeeUnit t1Credit;//t+1日结算贷记卡费率
    private FeeUnit t1Debit;//	t+1日结算借记卡费率
    private FeeUnit t1OverSee;//t+1日结算境外卡费率

    public FeeUnit getT0Credit() {
        return t0Credit;
    }

    public void setT0Credit(FeeUnit t0Credit) {
        this.t0Credit = t0Credit;
    }

    public FeeUnit getT0Debit() {
        return t0Debit;
    }

    public void setT0Debit(FeeUnit t0Debit) {
        this.t0Debit = t0Debit;
    }

    public FeeUnit getT0OverSee() {
        return t0OverSee;
    }

    public void setT0OverSee(FeeUnit t0OverSee) {
        this.t0OverSee = t0OverSee;
    }

    public FeeUnit getT1Credit() {
        return t1Credit;
    }

    public void setT1Credit(FeeUnit t1Credit) {
        this.t1Credit = t1Credit;
    }

    public FeeUnit getT1Debit() {
        return t1Debit;
    }

    public void setT1Debit(FeeUnit t1Debit) {
        this.t1Debit = t1Debit;
    }

    public FeeUnit getT1OverSee() {
        return t1OverSee;
    }

    public void setT1OverSee(FeeUnit t1OverSee) {
        this.t1OverSee = t1OverSee;
    }

    @Override
    public String toString() {
        return "{" +
                "t0Credit:" + t0Credit +
                ", t0Debit:" + t0Debit +
                ", t0OverSee:" + t0OverSee +
                ", t1Credit:" + t1Credit +
                ", t1Debit:" + t1Debit +
                ", t1OverSee:" + t1OverSee +
                '}';
    }
}

