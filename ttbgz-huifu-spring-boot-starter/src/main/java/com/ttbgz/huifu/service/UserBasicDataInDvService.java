package com.ttbgz.huifu.service;

import com.ttbgz.huifu.entity.resp.*;
import com.ttbgz.huifu.entity.vo.*;
import com.ttbgz.huifu.entity.vo.*;

/**
 * 个人用户信息
 * @author ttbgz
 */
public interface UserBasicDataInDvService {
    /**
     * 个人用户基本信息开户
     *
     */
    UserAccount personalUserBasicInformationToOpenAnAccount(UserBasicDataInDv userBasicDataInDv);

    /**
     * 用户业务入驻-入住
     *
     */
    UserBusiOpenRequestResp userServicesAreSettled(UserBusiOpenRequest userBasicDataInDv);

    /**
     * 用户业务入驻-修改
     *
     */
    UserBusiOpenRequestResp userServicesAreUpdate(UserBusiOpenRequest userBasicDataInDv);

    /**
     *  用户信息查询
     * @param huifuId h
     * @return indvBaseInfo
     */
    IndvBaseInfo userServicesAreGet(String huifuId);

    /**
     * 用户提现
     * @return tradeSettlementEncResp
     */
    TradeSettlementEnchashmentResp userCashOut(TradeSettlementEnchashment request);

    /**
     * 根据汇付id查询余额
     * @return tradeSettlementEncResp
     */
    AcctPaymentBalanceResp acctPaymentBalance(String huifuId);

    /**
     * 余额支付
     * @param tradeAcctpaymentPayVo  入参对象
     * @return result
     */
    TradeAcctpaymentPayResp tradeAcctpaymentPay(TradeAcctpaymentPayVo tradeAcctpaymentPayVo);
}
