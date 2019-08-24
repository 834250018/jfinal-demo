package com.ywy.jfinal.util.dingtalk.message;

import com.ywy.jfinal.util.dingtalk.message.pojo.LinkDO;
import com.ywy.jfinal.util.dingtalk.base.BaseMsg;
import com.ywy.jfinal.util.dingtalk.consts.DTTypeEnum;
import lombok.Data;

/**
 * @author ve
 * @data 2019/8/23 16:19
 */
@Data
public class FeedCardMsg extends BaseMsg {

    private FeedCardDO feedCard = new FeedCardDO();

    @Data
    public class FeedCardDO {
        private LinkDO[] links;
    }

    public FeedCardMsg(LinkDO... links) {
        setMsgtype(DTTypeEnum.feedCard);
        feedCard.links = links;
    }

}
