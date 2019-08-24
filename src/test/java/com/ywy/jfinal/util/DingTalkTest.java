package com.ywy.jfinal.util;

import com.ywy.jfinal.util.dingtalk.consts.DingTalkConsts;
import com.ywy.jfinal.util.dingtalk.message.*;
import com.ywy.jfinal.util.dingtalk.message.pojo.BtnDO;
import com.ywy.jfinal.util.dingtalk.message.pojo.LinkDO;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ve
 * @data 2019/8/23 10:46
 */
//@Log4j
public class DingTalkTest {

    @Test
    public void testTextMsg() throws Exception {
        String str = new TextMsg("测试发送消息").sendTo(DingTalkConsts.MY_ROBOT_TOKEN+"fdsfa");
//            String str1 =new TextMsg("测试发送消息", true).sendTo(DingTalkConsts.MY_ROBOT_TOKEN);
//            String str2 =new TextMsg("测试发送消息", "17307539790").sendTo(DingTalkConsts.MY_ROBOT_TOKEN);
//            System.out.println(str);
//            String str1 = new TextMsg("测试发送消息", true).toJson();
        System.out.println(str);
//            System.out.println(str2);
    }

    @Test
    public void testLinkMsg() throws Exception {
        Map headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        String str = new LinkMsg("标题", "主题", "toUrl").sendTo(DingTalkConsts.MY_ROBOT_TOKEN);
        String str1 = new LinkMsg("标题", "主题", "toUrl", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2599059047,3703734503&fm=58&w=258&h=258&img.GIF").sendTo(DingTalkConsts.MY_ROBOT_TOKEN);
        System.out.println(str);
        System.out.println(str1);
    }

    @Test
    public void testMarkdownMsg() throws Exception {
        Map headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
//            String str =new MarkdownMsg("标题", "**方法拦截器 SignInterceptor**\n" +
//                    "\n" +
//                    "    检验必须参数是否齐全\n" +
//                    "\n" +
//                    "**方法体**").sendTo(DingTalkConsts.MY_ROBOT_TOKEN);
        String str1 = new MarkdownMsg("标题", "主题", true).sendTo(DingTalkConsts.MY_ROBOT_TOKEN);
        String str2 = new MarkdownMsg("标题", "主题@17307539790", new String[]{"17307539790"}).sendTo(DingTalkConsts.MY_ROBOT_TOKEN);
//            System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
    }

    @Test
    public void testActionCardMsg() throws Exception {
        Map headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
//            String str =new MarkdownMsg("标题", "**方法拦截器 SignInterceptor**\n" +
//                    "\n" +
//                    "    检验必须参数是否齐全\n" +
//                    "\n" +
//                    "**方法体**").sendTo(DingTalkConsts.MY_ROBOT_TOKEN);
        BtnDO btnDO = new BtnDO("按钮1", "www.baidu.com");
        BtnDO btnDO1 = new BtnDO("按钮2", "www.google.com");
        String str1 = ActionCardMsg.single("标题", "主题", "sing查看所有", "www.baidu.com").sendTo(DingTalkConsts.MY_ROBOT_TOKEN);
        String str2 = ActionCardMsg.btns("标题", "主题@17307539790", btnDO, btnDO1).sendTo(DingTalkConsts.MY_ROBOT_TOKEN);
//            System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
    }

    @Test
    public void testFeedCardMsg() throws Exception {
        Map headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        LinkDO Link = new LinkDO("标题1", "www.baidu.com", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2599059047,3703734503&fm=58&w=258&h=258&img.GIF");
        LinkDO Link1 = new LinkDO("标题2", "www.google.com", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2599059047,3703734503&fm=58&w=258&h=258&img.GIF");
        String str = new FeedCardMsg(Link, Link1, Link1).sendTo(DingTalkConsts.MY_ROBOT_TOKEN);
        System.out.println(str);
    }
}
