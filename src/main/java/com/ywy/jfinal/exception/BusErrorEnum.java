package com.ywy.jfinal.exception;

import lombok.AllArgsConstructor;

/**
 * @author ve
 * @data 2019/9/16 17:52
 */
@AllArgsConstructor
public enum BusErrorEnum {
    CODE_123("123", "123业务异常"),
    CODE_124("124", "124业务异常"),
    ;
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
