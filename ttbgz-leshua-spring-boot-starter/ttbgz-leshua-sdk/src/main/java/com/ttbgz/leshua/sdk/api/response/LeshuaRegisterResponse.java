package com.ttbgz.leshua.sdk.api.response;


public class LeshuaRegisterResponse<T> extends LeshuaBasicResponse<T> {
    public LeshuaRegisterResponse(String respCode, String respMsg) {
        this.respCode = respCode;
        this.respMsg = respMsg;
    }

    public LeshuaRegisterResponse() {
    }

    private String respCode;
    private String respMsg;
    private String reqSerialNo;
    private T data;
    private String version;


    @Override
    public boolean isSuccess() {
        return "000000".equals(respCode);
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public String getReqSerialNo() {
        return reqSerialNo;
    }

    public void setReqSerialNo(String reqSerialNo) {
        this.reqSerialNo = reqSerialNo;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "LeshuaRegisterResponse{" +
                "respCode='" + respCode + '\'' +
                ", respMsg='" + respMsg + '\'' +
                ", reqSerialNo='" + reqSerialNo + '\'' +
                ", data=" + data +
                ", version='" + version + '\'' +
                '}';
    }
}
