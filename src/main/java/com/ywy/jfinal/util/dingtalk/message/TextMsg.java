package com.ywy.jfinal.util.dingtalk.message;

import com.ywy.jfinal.util.dingtalk.message.pojo.AtDO;
import com.ywy.jfinal.util.dingtalk.base.BaseMsg;
import com.ywy.jfinal.util.dingtalk.consts.DTTypeEnum;
import lombok.Data;

/**
 * @author ve
 * @data 2019/8/23 16:19
 */
@Data
public class TextMsg extends BaseMsg {

    private TextDO text = new TextDO();
    private AtDO at = new AtDO();

    @Data
    public class TextDO {
        private String content;
    }

    public TextMsg(String content) {
        init(content);
    }

    public TextMsg(String content, boolean atAll) {
        init(content);
        at.setIsAtAll(atAll);
    }

    public TextMsg(String content, String... atMobiles) {
        init(content);
        at.setAtMobiles(atMobiles);
    }

    private void init(String content) {
        setMsgtype(DTTypeEnum.text);
        text.content = content;
    }
}
