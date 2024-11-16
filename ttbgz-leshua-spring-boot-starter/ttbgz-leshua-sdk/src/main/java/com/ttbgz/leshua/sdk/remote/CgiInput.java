package com.ttbgz.leshua.sdk.remote;


import com.ttbgz.leshua.sdk.util.httpclient.ApiInput;
import com.ttbgz.leshua.sdk.util.httpclient.annotation.API;
import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiConstants;
import com.ttbgz.leshua.sdk.util.httpclient.constant.ApiInvokeMethod;

@API(method = ApiInvokeMethod.POST, contentType = ApiConstants.APPLICATION_FORM_URLENCODED_VALUE)
public class CgiInput extends ApiInput {

    // 字段详细作用见 https://www.yuque.com/leshuazf/doc/zcwyff#6TMlX
    private String service;
    private Integer t0;
    private String sign_type;
    private String pay_way;
    private String merchant_id;
    private String user_name;
    private String third_order_id;
    private String amount;
    private String jspay_flag;
    private String appid;
    private String sub_openid;
    private String jump_url;
    private String notify_url;
    private String client_ip;
    private String body;
    private String shop_no;
    private String pos_no;
    private String attach;
    private String limit_pay;
    private String goods_tag;
    private String goods_detail;
    private String order_expiration;
    private String hb_fq_num;
    private String front_url;
    private String front_fail_url;
    private String nonce_str;
    private String sign;
    private String device_info;
    private String store_id;
    private String ass_merchant_id;
    private String pnrins_id_cd;
    private String gps_info;
    private String bs_info;
    private Boolean need_receipt;
    private Object terminal_info;
    private Object extend_business_params;
    private Object scene_info;//
    private String auth_code;
    private String leshua_order_id;
    private String merchant_refund_id;
    private String refund_amount;
    private String refund_type;
    private String app_up_identifier;
    private String royalty;

    public String getRoyalty() {
        return royalty;
    }

    public void setRoyalty(String royalty) {
        this.royalty = royalty;
    }

    public String getApp_up_identifier() {
        return app_up_identifier;
    }

    public void setApp_up_identifier(String app_up_identifier) {
        this.app_up_identifier = app_up_identifier;
    }

    public String getRefund_type() {
        return refund_type;
    }

    public void setRefund_type(String refund_type) {
        this.refund_type = refund_type;
    }


    public String getRefund_amount() {
        return refund_amount;
    }

    public void setRefund_amount(String refund_amount) {
        this.refund_amount = refund_amount;
    }

    public String getMerchant_refund_id() {
        return merchant_refund_id;
    }

    public void setMerchant_refund_id(String merchant_refund_id) {
        this.merchant_refund_id = merchant_refund_id;
    }

    public String getLeshua_order_id() {
        return leshua_order_id;
    }

    public void setLeshua_order_id(String leshua_order_id) {
        this.leshua_order_id = leshua_order_id;
    }

    public String getAuth_code() {
        return auth_code;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Integer getT0() {
        return t0;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getPay_way() {
        return pay_way;
    }

    public void setPay_way(String pay_way) {
        this.pay_way = pay_way;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getThird_order_id() {
        return third_order_id;
    }

    public void setThird_order_id(String third_order_id) {
        this.third_order_id = third_order_id;
    }


    public String getJspay_flag() {
        return jspay_flag;
    }

    public void setJspay_flag(String jspay_flag) {
        this.jspay_flag = jspay_flag;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSub_openid() {
        return sub_openid;
    }

    public void setSub_openid(String sub_openid) {
        this.sub_openid = sub_openid;
    }

    public String getJump_url() {
        return jump_url;
    }

    public void setJump_url(String jump_url) {
        this.jump_url = jump_url;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getShop_no() {
        return shop_no;
    }

    public void setShop_no(String shop_no) {
        this.shop_no = shop_no;
    }

    public String getPos_no() {
        return pos_no;
    }

    public void setPos_no(String pos_no) {
        this.pos_no = pos_no;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getLimit_pay() {
        return limit_pay;
    }

    public void setLimit_pay(String limit_pay) {
        this.limit_pay = limit_pay;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    public String getGoods_detail() {
        return goods_detail;
    }

    public void setGoods_detail(String goods_detail) {
        this.goods_detail = goods_detail;
    }

    public String getOrder_expiration() {
        return order_expiration;
    }

    public void setOrder_expiration(String order_expiration) {
        this.order_expiration = order_expiration;
    }

    public String getHb_fq_num() {
        return hb_fq_num;
    }

    public void setHb_fq_num(String hb_fq_num) {
        this.hb_fq_num = hb_fq_num;
    }

    public String getFront_url() {
        return front_url;
    }

    public void setFront_url(String front_url) {
        this.front_url = front_url;
    }

    public String getFront_fail_url() {
        return front_fail_url;
    }

    public void setFront_fail_url(String front_fail_url) {
        this.front_fail_url = front_fail_url;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getAss_merchant_id() {
        return ass_merchant_id;
    }

    public void setAss_merchant_id(String ass_merchant_id) {
        this.ass_merchant_id = ass_merchant_id;
    }

    public String getPnrins_id_cd() {
        return pnrins_id_cd;
    }

    public void setPnrins_id_cd(String pnrins_id_cd) {
        this.pnrins_id_cd = pnrins_id_cd;
    }

    public String getGps_info() {
        return gps_info;
    }

    public void setGps_info(String gps_info) {
        this.gps_info = gps_info;
    }

    public String getBs_info() {
        return bs_info;
    }

    public void setBs_info(String bs_info) {
        this.bs_info = bs_info;
    }

    public void setT0(Integer t0) {
        this.t0 = t0;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Boolean getNeed_receipt() {
        return need_receipt;
    }

    public void setNeed_receipt(Boolean need_receipt) {
        this.need_receipt = need_receipt;
    }

    public Object getTerminal_info() {
        return terminal_info;
    }

    public void setTerminal_info(Object terminal_info) {
        this.terminal_info = terminal_info;
    }

    public Object getExtend_business_params() {
        return extend_business_params;
    }

    public void setExtend_business_params(Object extend_business_params) {
        this.extend_business_params = extend_business_params;
    }

    public Object getScene_info() {
        return scene_info;
    }

    public void setScene_info(Object scene_info) {
        this.scene_info = scene_info;
    }
}
