package com.ywy.jfinal.util.dingtalk.base;

import com.jfinal.kit.JsonKit;
import com.jfinal.kit.Kv;
import com.ywy.jfinal.util.OkHttpKit;
import com.ywy.jfinal.util.dingtalk.consts.DTTypeEnum;
import com.ywy.jfinal.util.dingtalk.consts.DingTalkConsts;
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

    public String sendTo(String robot_token) {
        return OkHttpKit.post(DingTalkConsts.DING_TALK_URL + robot_token, toJson(), Kv.by("Content-Type", "application/json"));
    }

}
