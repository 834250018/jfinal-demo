package com.ywy.jfinal.exception;

import lombok.Data;

/**
 * @author ve
 * @data 2019/9/16 17:24
 */
@Data
public class BusException extends RuntimeException {

    public BusException(BusErrorCode errorCode) {
        code = errorCode.getCode();
        msg = errorCode.getMsg();
    }

    public BusException(BusErrorCode errorCode, String appendMsg) {
        code = errorCode.getCode();
        msg = errorCode.getMsg() + " : " + appendMsg;
    }

    private String code;
    private String msg;

    @Override
    public String getMessage() {
        return getMsg();
    }

    // 业务异常不打印堆栈
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
