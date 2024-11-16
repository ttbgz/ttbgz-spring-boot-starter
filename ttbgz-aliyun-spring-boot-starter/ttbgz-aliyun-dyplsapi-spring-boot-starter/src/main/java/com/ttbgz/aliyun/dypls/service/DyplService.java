package com.ttbgz.aliyun.dypls.service;

import com.aliyun.dyplsapi20170525.models.UnbindSubscriptionResponse;
import com.ttbgz.aliyun.dypls.CallRestrictEnum;
import com.ttbgz.aliyun.dypls.pojo.SecretBindDTO;

import java.time.LocalDateTime;

/**
 * @author ttbgz
 */
public interface DyplService {

    /**
     * 创建AXB 号码 默认开启录音(录音好像只有A号码)
     * @param phoneNoA  AXB中的A号码
     * @param phoneNoB AXB中的B号码
     * @param expiration 绑定关系的过期时间
     * @return SecretBindDTO
     */
    SecretBindDTO createBindAxbRequest(String phoneNoA, String phoneNoB,LocalDateTime expiration);
    /**
     * 创建AXB 号码 关闭录音
     * @param phoneNoA  AXB中的A号码
     * @param phoneNoB AXB中的B号码
     * @param expiration 绑定关系的过期时间
     * @return SecretBindDTO
     */
    SecretBindDTO createBindAxbRequestCloseArs(String phoneNoA, String phoneNoB,LocalDateTime expiration);

    /**
     * 创建AXB 号码
     * @param phoneNoA  AXB中的A号码
     * @param phoneNoB AXB中的B号码
     * @param expiration 绑定关系的过期时间
     * @param enableArs 是否开启录音 (录音好像只有A号码)
     * @param outId 外部业务扩展字段，通话记录回执消息中会回传此参数。
     * @return SecretBindDTO
     */
    SecretBindDTO createBindAxbRequest(String phoneNoA, String phoneNoB,LocalDateTime expiration,boolean enableArs,String outId);

    /**
     * 创建AXB 号码 是否开启录音
     * @param phoneNoA  AXB中的A号码
     * @param phoneNoB AXB中的B号码
     * @param expiration 绑定关系的过期时间
     * @param enableArs 是否开启录音 (录音好像只有A号码)
     * @return SecretBindDTO
     */
    SecretBindDTO createBindAxbRequestEnableArs(String phoneNoA, String phoneNoB,LocalDateTime expiration,boolean enableArs);

    /**
     * 创建AXB 号码
     * @param phoneNoA  AXB中的A号码
     * @param phoneNoB AXB中的B号码
     * @param phoneNoX AXB中的X号码 X 号码是您绑定号码前在号码隐私保护控制台或通过 BuySecretNo 接口购买的电话号码，用于转接电话。 如果未指定 X 号码，将根据参数 ExpectCity 从指定号码池中随机指定一个号码作为 X 号码
     * @param expiration 绑定关系的过期时间
     * @param callRestrictEnum 号码绑定限制
     * @param enableArs 是否开启录音  (录音好像只有A号码)
     * @return SecretBindDTO
     */
    SecretBindDTO createBindAxbRequest(String phoneNoA, String phoneNoB, String phoneNoX, LocalDateTime expiration, CallRestrictEnum callRestrictEnum, boolean enableArs);

    /**
     * 创建AXB 号码
     * @param phoneNoA  AXB中的A号码
     * @param phoneNoB AXB中的B号码
     * @param phoneNoX AXB中的X号码 X 号码是您绑定号码前在号码隐私保护控制台或通过 BuySecretNo 接口购买的电话号码，用于转接电话。 如果未指定 X 号码，将根据参数 ExpectCity 从指定号码池中随机指定一个号码作为 X 号码
     * @param expiration 绑定关系的过期时间
     * @param callRestrictEnum 号码绑定限制
     * @param enableArs 是否开启录音  (录音好像只有A号码)
     * @param outId 外部业务扩展字段，通话记录回执消息中会回传此参数。
     * @return SecretBindDTO
     */
    SecretBindDTO createBindAxbRequest(String phoneNoA, String phoneNoB, String phoneNoX, LocalDateTime expiration, CallRestrictEnum callRestrictEnum,boolean enableArs,String outId);


    /**
     * 解绑隐私号
     * @param poolKey 号码池
     * @param secretNo 隐私号码
     * @param subsId 调用 BindAxb 等号码绑定 API 时查看返回参数中的 SubsId。
     * @return
     */
    UnbindSubscriptionResponse unbindSubscription(String poolKey, String secretNo, String subsId);
}
