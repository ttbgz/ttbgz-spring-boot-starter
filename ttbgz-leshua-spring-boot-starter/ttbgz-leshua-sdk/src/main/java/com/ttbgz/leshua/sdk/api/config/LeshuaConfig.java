package com.ttbgz.leshua.sdk.api.config;

/**
 * claire
 * 配置类
 */
public class LeshuaConfig {
    /**
     * 请求地址
     */
    private String serverUrl = "http://t-saas-mch.lepass.cn";
    /**
     * 代理商编号
     */
    private String agentId;
    private String version = "1.0";
    /**
     * 加签KEY,请勿泄漏
     */
    private String key;
    /**
     *
     */
    private String charset = "utf-8";
    /**
     * 连接超时时间
     */
    private int connectTimeout = 3000;
    /**
     * 超时时间
     */
    private int readTimeout = 15000;

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }
}
