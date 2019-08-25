package com.ywy.jfinal.util.dingtalk.message;

import com.ywy.jfinal.util.dingtalk.message.pojo.BtnDO;
import com.ywy.jfinal.util.dingtalk.base.BaseMsg;
import com.ywy.jfinal.util.dingtalk.consts.DTTypeEnum;
import lombok.Data;

/**
 * @author ve
 * @data 2019/8/23 16:19
 */
@Data
public class ActionCardMsg extends BaseMsg {

    private ActionCardDO actionCard = new ActionCardDO();

    @Data
    public class ActionCardDO {
        private String title;
        private String text;

        private String btnOrientation; // 0-按钮竖直排列，1-按钮横向排列
        private String hideAvatar; // 0-正常发消息者头像，1-隐藏发消息者头像

        // 整体跳转独有参数
        private String singleTitle; // 单个按钮的方案。(设置此项和singleURL后btns无效)
        private String singleURL; // 点击singleTitle按钮触发的URL

        // 独立跳转独有参数
        private BtnDO[] btns; // 按钮的信息：title-按钮方案，actionURL-点击按钮触发的URL
    }

    private ActionCardMsg(String title, String text) {
        setMsgtype(DTTypeEnum.actionCard);
        actionCard.title = title;
        actionCard.text = text;
    }

    /**
     *
     * @param title
     * @param text
     * @param singleTitle
     * @param singleURL 需要加协议,如http
     * @return
     */
    public static ActionCardMsg single(String title, String text, String singleTitle, String singleURL) {
        ActionCardMsg actionCardMsg = new ActionCardMsg(title, text);
        actionCardMsg.actionCard.singleTitle = singleTitle;
        actionCardMsg.actionCard.singleURL = singleURL;
        return actionCardMsg;
    }

    /**
     *
     * @param title
     * @param text
     * @param btns 请求路径需要加协议,如http
     * @return
     */
    public static ActionCardMsg btns(String title, String text, BtnDO... btns) {
        ActionCardMsg actionCardMsg = new ActionCardMsg(title, text);
        actionCardMsg.actionCard.btns = btns;
        return actionCardMsg;
    }

    /**
     * 按钮竖直排列
     */
    public void setBtnOrientation0() {
        actionCard.btnOrientation = "0";
    }

    /**
     * 按钮横向排列
     */
    public void setBtnOrientation1() {
        actionCard.btnOrientation = "1";
    }

    /**
     * 正常发消息者头像
     */
    public void setHideAvatar0() {
        actionCard.hideAvatar = "0";
    }

    /**
     * 隐藏发消息者头像
     */
    public void setHideAvatar1() {
        actionCard.hideAvatar = "1";
    }

}
