package com.ywy.jfinal.util.dingtalk;

import lombok.Data;

/**
 * @author ve
 * @data 2019/8/23 16:19
 */
@Data
public class MarkdownMsg extends BaseMsg {

    private MarkdownDO markdown = new MarkdownDO();

    private AtDO at = new AtDO();

    @Data
    public class MarkdownDO {
        private String title;
        private String text;
    }

    public MarkdownMsg(String title, String text) {
        init(title, text);
    }

    /**
     * 不知道什么原因,无法@所有人
     * @param title
     * @param text
     * @param atAll
     */
    @Deprecated
    public MarkdownMsg(String title, String text, boolean atAll) {
        init(title, text);
        at.setIsAtAll(atAll);
    }

    /**
     * 需要在第二个参数包含 @手机号
     * @param title
     * @param text
     * @param atMobiles
     */
    public MarkdownMsg(String title, String text, String[] atMobiles) {
        init(title, text);
        at.setAtMobiles(atMobiles);
    }

    private void init(String title, String text) {
        setMsgtype(DTTypeEnum.markdown);
        markdown.title = title;
        markdown.text = text;
    }

}
