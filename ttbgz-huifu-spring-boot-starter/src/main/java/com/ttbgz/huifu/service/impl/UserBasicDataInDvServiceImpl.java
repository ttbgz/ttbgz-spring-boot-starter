package com.ttbgz.huifu.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.huifu.bspay.sdk.opps.client.BasePayClient;
import com.huifu.bspay.sdk.opps.core.exception.BasePayException;
import com.huifu.bspay.sdk.opps.core.request.*;
import com.huifu.bspay.sdk.opps.core.utils.DateTools;
import com.huifu.bspay.sdk.opps.core.utils.SequenceTools;
import com.ttbgz.huifu.entity.resp.*;
import com.ttbgz.huifu.entity.vo.*;
import com.ttbgz.huifu.enums.CertTypeEnum;
import com.ttbgz.huifu.properties.HuiFuProperties;
import com.ttbgz.huifu.service.UserBasicDataInDvService;
import com.ttbgz.huifu.entity.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 个人用户信息
 * @author ttbgz
 */
@Service
@Slf4j
public class UserBasicDataInDvServiceImpl implements UserBasicDataInDvService {
    @Autowired
    HuiFuProperties huiFuProperties;
    /**
     * 个人用户基本信息开户
     *
     */
   @Override
   public UserAccount personalUserBasicInformationToOpenAnAccount(UserBasicDataInDv userBasicDataInDv){
       log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>个人用户基本信息开户");

       // 2.组装请求参数
       V2UserBasicdataIndvRequest request = new V2UserBasicdataIndvRequest();
       // 请求流水号
       request.setReqSeqId(SequenceTools.getReqSeqId32());
       // 请求日期
       request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
       // 个人姓名
       request.setName(userBasicDataInDv.getName());
       // 个人证件类型
       request.setCertType(CertTypeEnum.ID_CARD.getCode());
       // 个人证件号码
       request.setCertNo(userBasicDataInDv.getCertNo());
       // 个人证件有效期类型
       request.setCertValidityType(userBasicDataInDv.getCertValidityType());
       // 个人证件有效期开始日期
       request.setCertBeginDate(userBasicDataInDv.getCertBeginDate());
       // 手机号
       request.setMobileNo(userBasicDataInDv.getMobileNo());

       // 设置非必填字段
       Map<String, Object> extendInfoMap = userBasicDataInDv.getExtendInfos();
       request.setExtendInfo(extendInfoMap);

       // 3. 发起API调用
       try {
           Map<String, Object> response = BasePayClient.request(request, false);
           log.info("个人用户基本信息开户 response:{}",JSON.toJSONString(response));
           return JSON.to(UserAccount.class,response);
       } catch (BasePayException | IllegalAccessException e) {
           throw new RuntimeException(e);
       }
    }

    @Override
    public UserBusiOpenRequestResp userServicesAreSettled(UserBusiOpenRequest userBasicDataInDv) {
        // 2.组装请求参数
        com.huifu.bspay.sdk.opps.core.request.V2UserBusiOpenRequest request = new com.huifu.bspay.sdk.opps.core.request.V2UserBusiOpenRequest();
        // 汇付ID
        request.setHuifuId(userBasicDataInDv.getHuifuId());
        // 请求流水号
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        // 请求日期
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        // 渠道商/商户汇付Id
        request.setUpperHuifuId(userBasicDataInDv.getUpperHuifuId());

        // 设置非必填字段
        Map<String, Object> extendInfoMap = userBasicDataInDv.getExtendInfos();
        request.setExtendInfo(extendInfoMap);

        // 3. 发起API调用
        try {
            Map<String, Object> response = BasePayClient.request(request, false);
            log.info("用户业务入驻 response:{}",JSON.toJSONString(response));
            return JSON.to(UserBusiOpenRequestResp.class,response);
        } catch (BasePayException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserBusiOpenRequestResp userServicesAreUpdate(UserBusiOpenRequest userBasicDataInDv) {
        return this.userServicesAreSettled(userBasicDataInDv);
    }

    @Override
    public IndvBaseInfo userServicesAreGet(String huifuId) {

        // 2.组装请求参数
        V2UserBasicdataQueryRequest request = new V2UserBasicdataQueryRequest();
        // 汇付客户Id
        request.setHuifuId("6666000105447846");
        // 请求流水号
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        // 请求日期
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());

        // 设置非必填字段
        request.setExtendInfo(new HashMap<>());
        // 3. 发起API调用
        try {
            Map<String, Object> response = BasePayClient.request(request, false);
            return JSON.to(IndvBaseInfo.class,response);
        } catch (Exception e) {
            log.error("个人用户信息查询异常:",e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public TradeSettlementEnchashmentResp userCashOut(TradeSettlementEnchashment tradeSettlementEnchashment) {
        // 2.组装请求参数
        V2TradeSettlementEnchashmentRequest request = new V2TradeSettlementEnchashmentRequest();
        // 请求日期
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        // 请求流水号
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        // 取现金额
        request.setCashAmt(tradeSettlementEnchashment.getCashAmt());
        // 商户号
        request.setHuifuId(tradeSettlementEnchashment.getHuifuId());
        // 到账日期类型
        request.setIntoAcctDateType(tradeSettlementEnchashment.getIntoAcctDateType().getCode());
        // 取现卡序列号
        request.setTokenNo(tradeSettlementEnchashment.getTokenNo());

        // 设置非必填字段
        Map<String, Object> extendInfoMap = tradeSettlementEnchashment.getExtendInfos();
        request.setExtendInfo(extendInfoMap);

        // 3. 发起API调用
        try {
            Map<String, Object> response = BasePayClient.request(request, false);
            return JSON.to(TradeSettlementEnchashmentResp.class,response);
        } catch (Exception e) {
            log.error("取现异常:",e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public AcctPaymentBalanceResp acctPaymentBalance(String huifuId) {
        // 2.组装请求参数
        V2TradeAcctpaymentBalanceQueryRequest request = new V2TradeAcctpaymentBalanceQueryRequest();
        // 请求日期
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        // 商户号
        request.setHuifuId(huifuId);

        // 设置非必填字段
        Map<String, Object> extendInfoMap = new HashMap<>();
        // 请求流水号
        extendInfoMap.put("req_seq_id", SequenceTools.getReqSeqId32());
        request.setExtendInfo(extendInfoMap);

        // 3. 发起API调用
        try {
            Map<String, Object> response = BasePayClient.request(request, false);
            return JSON.to(AcctPaymentBalanceResp.class,response);
        } catch (Exception e) {
            log.error("查询汇付余额异常:",e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public TradeAcctpaymentPayResp tradeAcctpaymentPay(TradeAcctpaymentPayVo tradeAcctpaymentPayVo) {
        // 2.组装请求参数
        V2TradeAcctpaymentPayRequest request = new V2TradeAcctpaymentPayRequest();
        // 请求流水号
        request.setReqSeqId(SequenceTools.getReqSeqId32());
        // 请求日期
        request.setReqDate(DateTools.getCurrentDateYYYYMMDD());
        // 出款方商户号
        request.setOutHuifuId(tradeAcctpaymentPayVo.getOutHuifuId());
        // 支付金额
        request.setOrdAmt(tradeAcctpaymentPayVo.getOrdAmt());
//        // 分账对象
        String string = JSON.toJSONString(tradeAcctpaymentPayVo.getAcctSplitBunch(),JSONWriter.Feature.IgnoreNoneSerializable);
        request.setAcctSplitBunch(string);
        // 安全信息
        String riskCheckDataString = JSON.toJSONString(tradeAcctpaymentPayVo.getRiskCheckData(), JSONWriter.Feature.IgnoreNoneSerializable);
        request.setRiskCheckData(riskCheckDataString);

        // 设置非必填字段
        Map<String, Object> extendInfoMap = tradeAcctpaymentPayVo.getExtendInfos();
        request.setExtendInfo(extendInfoMap);

        // 3. 发起API调用
        try {
            Map<String, Object> response = BasePayClient.request(request, false);
            return JSON.to(TradeAcctpaymentPayResp.class,response);
        } catch (Exception e) {
            log.error("取现异常:",e);
            throw new RuntimeException(e);
        }
    }


    private static String getAcctSplitBunch() {
        JSONObject dto = new JSONObject();
        // 分账明细
        dto.put("acct_infos", getAcctInfos());

        return dto.toJSONString();
    }

    private static String getRiskCheckData() {
        JSONObject dto = new JSONObject();
        // 转账原因
        dto.put("transfer_type", "04");
        // 产品子类
        dto.put("sub_product", "1");
        // 纬度
        // dto.put("latitude", "");
        // 经度
        // dto.put("longitude", "");
        // 基站地址
        // dto.put("base_atation", "");
        // IP地址
        // dto.put("ip_addr", "");

        return dto.toJSONString();
    }


    private static com.alibaba.fastjson.JSON getAcctInfos() {
        JSONObject dto = new JSONObject();
        // 分账金额
        dto.put("div_amt", "0.01");
        // 被分账方ID
        dto.put("huifu_id", "6666000018344461");
        // 被分账方账户号
        // dto.put("acct_id", "");

        JSONArray dtoList = new JSONArray();
        dtoList.add(dto);
        return dtoList;
    }


}
