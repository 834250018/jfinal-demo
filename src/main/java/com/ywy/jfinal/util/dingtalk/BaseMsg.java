package com.ywy.jfinal.util.dingtalk;

import com.jfinal.kit.JsonKit;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ve
 * @data Data/8/23 16:04
 */
@Data
public abstract class BaseMsg implements Serializable {

    private DTTypeEnum msgtype;

    public String toJson() {
        return JsonKit.toJson(this);
    }

}
