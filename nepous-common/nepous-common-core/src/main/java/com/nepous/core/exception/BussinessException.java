package com.nepous.core.exception;


import com.nepous.core.enums.ErrorCodeEnum;

/**
 * 业务异常
 */
public class BussinessException extends RuntimeException {

    protected int code;

    private static final long serialVersionUID = 3160241586346324994L;

    public BussinessException() {
    }
    public BussinessException(Throwable cause) {
        super(cause);
    }

    public BussinessException(String message) {
        super(message);
    }

    public BussinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BussinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BussinessException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
    }

    public BussinessException(ErrorCodeEnum codeEnum, Object... args) {
        super(String.format(codeEnum.msg(), args));
        this.code = codeEnum.code();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
