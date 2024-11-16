package com.ttbgz.common;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AesDecrypto {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    // 16 bytes key for AES-128
    private static final byte[] KEY = "ELE2MNc3VDJ^mvN!tS!eQ0&V".getBytes(StandardCharsets.UTF_8);

    /**
     * 加密
     * @param valueToEnc
     * @return
     * @throws Exception
     */
    public static String encrypt(String valueToEnc) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKeySpec secretKey = new SecretKeySpec(KEY, ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(valueToEnc.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    /**
     * 解密
     * @param encryptedValue
     * @return
     * @throws Exception
     */
    public static String decrypt(String encryptedValue){
        try{
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            SecretKeySpec secretKey = new SecretKeySpec(KEY, ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedValue));

            return new String(original, StandardCharsets.UTF_8);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
