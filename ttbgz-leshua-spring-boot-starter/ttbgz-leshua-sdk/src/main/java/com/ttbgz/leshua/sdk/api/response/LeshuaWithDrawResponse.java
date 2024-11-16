package com.ttbgz.leshua.sdk.api.response;

public class LeshuaWithDrawResponse<T> extends LeshuaBasicResponse<T> {
    public LeshuaWithDrawResponse(  String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;
    private String reqSerialNo;
    private String error_msg;
    private String error_code;

    public LeshuaWithDrawResponse() {
    }

    @Override
    public boolean isSuccess() {
        return "0".equals(code) || "0".equals(error_code);
    }


    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }


    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        if (this.msg != null) {
            return msg;
        }
        return this.error_msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getReqSerialNo() {
        return reqSerialNo;
    }

    public void setReqSerialNo(String reqSerialNo) {
        this.reqSerialNo = reqSerialNo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("response {");
        if (this.code != null) {
            sb.append("\n\t code=" + code);
        }
        if (this.msg != null) {
            sb.append("\n\t msg=" + msg);
        }
        if (this.reqSerialNo != null) {
            sb.append("\n\t reqSerialNo=" + reqSerialNo);
        }
        if (this.error_code != null) {
            sb.append("\n\t error_code='" + error_code);
        }
        if (this.error_msg != null) {
            sb.append("\n\t error_msg='" + error_msg);
        }
        if (this.getData() != null) {
            sb.append("\n\t data=" + this.getData());
        }
        sb.append("\n }");
        return sb.toString();


    }
}
