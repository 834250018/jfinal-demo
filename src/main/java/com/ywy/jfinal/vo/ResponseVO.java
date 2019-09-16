package com.ywy.jfinal.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;

/**
 * @author ve
 * @data 2019/9/16 17:28
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class ResponseVO implements Serializable {
    String code;
    String msg;
    Object data;
}
