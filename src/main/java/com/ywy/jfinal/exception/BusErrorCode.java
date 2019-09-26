package com.ywy.jfinal.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ve
 * @data 2019/9/16 17:52
 */
@Data
@AllArgsConstructor
public class BusErrorCode {
    public static BusErrorCode CODE_400 = new BusErrorCode("400", "参数校验不通过");
    public static BusErrorCode CODE_123 = new BusErrorCode("123", "123业务异常");
    public static BusErrorCode CODE_124 = new BusErrorCode("124", "124业务异常");

    private String code;
    private String msg;

}
