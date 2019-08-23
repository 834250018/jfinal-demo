package com.ywy.jfinal.util.dingtalk;

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
