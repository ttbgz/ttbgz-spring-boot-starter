package com.ttbgz.huifu.enums;

import lombok.Getter;

/**
 * @author ttbgz
 */
@Getter
public enum CertTypeEnum {
    ID_CARD("00","身份证"),
    PASSPORT("01","护照"),
    MILITARY_ID("02","军官证"),
    SOLDIER_S_CARD("03","士兵证"),
    HOME_RETURN_PERMIT("04","回乡证"),
    HUKOU_BOOKLET("05","户口本"),
    FOREIGN_PASSPORTS("06","外国护照"),
    OTHER("07","其他"),
    TEMPORARY_RESIDENCE_PERMIT("08","暂住证"),
    POLICE_OFFICER_ID("09","警官证"),
    CIVILIAN_CADRE_CERTIFICATE("10","文职干部证"),
    HONG_KONG_MACAO_AND_TAIWAN_COMPATRIOTS_PASS("11","港澳台同胞通行证"),
    ALIEN_RESIDENCE("13","外国人居留证"),
    TAIWAN("14","台胞证"),
    HONG_KONG("15","港澳台居住证");


    private final String code;
    private final String desc;

    CertTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
