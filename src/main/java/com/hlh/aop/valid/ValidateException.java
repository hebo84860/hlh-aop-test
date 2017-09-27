package com.hlh.aop.valid;

import java.io.Serializable;

public class ValidateException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 573708829882441641L;

    /** 错误消息 */
    private String errMessage;

    public ValidateException() {
        super();
    }

    public ValidateException(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

}
