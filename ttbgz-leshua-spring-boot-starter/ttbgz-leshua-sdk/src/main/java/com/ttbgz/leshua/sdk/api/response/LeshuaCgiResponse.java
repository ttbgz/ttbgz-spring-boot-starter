package com.ttbgz.leshua.sdk.api.response;


import io.micrometer.common.util.StringUtils;

public class LeshuaCgiResponse<T> extends LeshuaBasicResponse<T> {
    public LeshuaCgiResponse() {
    }

    public LeshuaCgiResponse(String resp_code, String resp_msg) {
        this.resp_code = resp_code;
        this.resp_msg = resp_msg;
    }

    private String resp_code;
    private String resp_msg;
    private String result_code;
    private String error_msg;
    private String error_code;

    public boolean failed() {
        return !"0".equals(resp_code) || !"0".equals(result_code) || StringUtils.isNotEmpty(error_msg);
    }

    @Override
    public boolean isSuccess() {
        return !failed();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("response {");
        if (this.resp_code != null) {
            sb.append("\n\t code=" + resp_code);
        }
        if (this.resp_msg != null) {
            sb.append("\n\t msg=" + resp_msg);
        }
        if (this.result_code != null) {
            sb.append("\n\t result_code=" + result_code);
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

    public String getResp_code() {
        return resp_code;
    }

    public void setResp_code(String resp_code) {
        this.resp_code = resp_code;
    }

    public String getResp_msg() {
        return resp_msg;
    }

    public void setResp_msg(String resp_msg) {
        this.resp_msg = resp_msg;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }


    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

}
