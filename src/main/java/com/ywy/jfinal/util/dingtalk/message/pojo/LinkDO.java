package com.ywy.jfinal.util.dingtalk.message.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ve
 * @data 2019/8/23 16:19
 */
@Data
@AllArgsConstructor
public class LinkDO {
    private String title;
    private String messageURL;
    private String picURL;
}