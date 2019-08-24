package com.ywy.jfinal.util.dingtalk.message;

import com.ywy.jfinal.util.dingtalk.base.BaseMsg;
import com.ywy.jfinal.util.dingtalk.consts.DTTypeEnum;
import lombok.Data;

/**
 * @author ve
 * @data 2019/8/23 16:19
 */
@Data
public class LinkMsg extends BaseMsg {

    private LinkDO link = new LinkDO();

    @Data
    public class LinkDO {
        private String text;
        private String title;
        private String messageUrl;
        private String picUrl;
    }

    public LinkMsg(String title, String text, String messageUrl) {
        init(title, text, messageUrl);
    }

    public LinkMsg(String title, String text, String messageUrl, String picUrl) {
        init(title, text, messageUrl);
        link.picUrl = picUrl;
    }

    private void init(String title, String text, String messageUrl) {
        setMsgtype(DTTypeEnum.link);
        link.title = title;
        link.text = text;
        link.messageUrl = messageUrl;
    }
}
