package com.ttbgz.huaweicloud.ivs.service;

/**
 * @author ttbgz
 */
public interface HuaweiIvsService {

    /**
     * 根据身份证号和姓名进行人实名认证
     * @param userName 名字
     * @param idCard 身份证号
     * @return
     */
    boolean ivsIdCardExtention(String userName,String idCard);

}
