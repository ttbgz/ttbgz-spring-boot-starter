/**
 *
 **/
package com.ttbgz.leshua.sdk.util.httpclient.exception;


/**
 * 接口调用异常信息
 *
 * @author yehl
 * @date 2018年4月24日 下午4:25:49
 */

public class ApiException extends RuntimeException {

    private static final long serialVersionUID = -3715245765122725711L;

    String code;
    String message;
    String url;

    public ApiException() {
        super();
    }

    public ApiException(String code) {
        super();
        this.code = code;
    }

    public ApiException(String code, Throwable throwable) {
        super(throwable);
        this.code = code;
        this.message = throwable.getMessage();
    }

    public ApiException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ApiException(String code, String message, String detail) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ApiException(String code, String message, Throwable throwable) {
        super(throwable);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
