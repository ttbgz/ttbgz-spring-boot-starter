package com.ttbgz.leshua.sdk.api.response.dto;

import java.io.Serializable;

//微信扫码费率
public class WeixinFee implements Serializable {


    private static final long serialVersionUID = 2390821965605196650L;
    private FeeUnit t1;//线下t+1日结算费率
    private FeeUnit oasis;//绿洲活动费率
    private FeeUnit publicWeal;//公益费率
    private FeeUnit collegeCanteen;//	高校食堂费率
    private FeeUnit publicPayment;//公缴费率
    private FeeUnit privateSchool;//私立学校费率
    private FeeUnit insurance;//	保险费率
    private FeeUnit online;//线上费率

    public FeeUnit getT1() {
        return t1;
    }

    public void setT1(FeeUnit t1) {
        this.t1 = t1;
    }

    public FeeUnit getOasis() {
        return oasis;
    }

    public void setOasis(FeeUnit oasis) {
        this.oasis = oasis;
    }

    public FeeUnit getPublicWeal() {
        return publicWeal;
    }

    public void setPublicWeal(FeeUnit publicWeal) {
        this.publicWeal = publicWeal;
    }

    public FeeUnit getCollegeCanteen() {
        return collegeCanteen;
    }

    public void setCollegeCanteen(FeeUnit collegeCanteen) {
        this.collegeCanteen = collegeCanteen;
    }

    public FeeUnit getPublicPayment() {
        return publicPayment;
    }

    public void setPublicPayment(FeeUnit publicPayment) {
        this.publicPayment = publicPayment;
    }

    public FeeUnit getPrivateSchool() {
        return privateSchool;
    }

    public void setPrivateSchool(FeeUnit privateSchool) {
        this.privateSchool = privateSchool;
    }

    public FeeUnit getInsurance() {
        return insurance;
    }

    public void setInsurance(FeeUnit insurance) {
        this.insurance = insurance;
    }

    public FeeUnit getOnline() {
        return online;
    }

    public void setOnline(FeeUnit online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return "{" +
                "t1:" + t1 +
                ", oasis:" + oasis +
                ", publicWeal:" + publicWeal +
                ", collegeCanteen:" + collegeCanteen +
                ", publicPayment:" + publicPayment +
                ", privateSchool:" + privateSchool +
                ", insurance:" + insurance +
                ", online:" + online +
                '}';
    }
}
