package com.ttbgz.leshua.sdk.api.response.dto;

public class UnionScanFee2 {
    private FeeUnit t1Credit;//	t+1日结算贷记卡费率
    private FeeUnit t1Debit;//t+1日结算借记卡费率

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

    @Override
    public String toString() {
        return "{" +
                "t1Credit:" + t1Credit +
                ", t1Debit:" + t1Debit +
                '}';
    }
}
