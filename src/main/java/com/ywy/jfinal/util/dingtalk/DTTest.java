package com.ywy.jfinal.util.dingtalk;

import com.sd.kit.OKHttpKit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.junit.Test;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ve
 * @data 2019/8/23 10:46
 */
public class DTTest {
    @Test
    public void testTextMsg() throws Exception {

        Map headers = new HashMap<>();
        headers.put("", );
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .header("Content-Type"."application/json")
                .post(RequestBody.create(MediaType.parse("UTF-8"), con))
        client.newCall().execute();
        String str = OKHttpKit.postStream(TestParam.DING_TALK_URL, new TextMsg("测试发送消息").toJson(), headers);
//            String str1 = OKHttpKit.postStream(TestParam.DING_TALK_URL, new TextMsg("测试发送消息", true).toJson(), headers);
//            String str2 = OKHttpKit.postStream(TestParam.DING_TALK_URL, new TextMsg("测试发送消息", "17307539790").toJson(), headers);
//            System.out.println(str);
//            String str1 = new TextMsg("测试发送消息", true).toJson();
        System.out.println(str);
//            System.out.println(str2);
    }

    @Test
    public void testLinkMsg() throws Exception {
        Map headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        String str = OKHttpKit.postStream(TestParam.DING_TALK_URL, new LinkMsg("标题", "主题", "toUrl").toJson(), headers);
        String str1 = OKHttpKit.postStream(TestParam.DING_TALK_URL, new LinkMsg("标题", "主题", "toUrl", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2599059047,3703734503&fm=58&w=258&h=258&img.GIF").toJson(), headers);
        System.out.println(str);
        System.out.println(str1);
    }

    @Test
    public void testMarkdownMsg() throws Exception {
        Map headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
//            String str = OKHttpKit.postStream(TestParam.DING_TALK_URL, new MarkdownMsg("标题", "**方法拦截器 SignInterceptor**\n" +
//                    "\n" +
//                    "    检验必须参数是否齐全\n" +
//                    "\n" +
//                    "**方法体**").toJson(), headers);
        String str1 = OKHttpKit.postStream(TestParam.DING_TALK_URL, new MarkdownMsg("标题", "主题", true).toJson(), headers);
        String str2 = OKHttpKit.postStream(TestParam.DING_TALK_URL, new MarkdownMsg("标题", "主题@17307539790", new String[]{"17307539790"}).toJson(), headers);
//            System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
    }

    @Test
    public void testActionCardMsg() throws Exception {
        Map headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
//            String str = OKHttpKit.postStream(TestParam.DING_TALK_URL, new MarkdownMsg("标题", "**方法拦截器 SignInterceptor**\n" +
//                    "\n" +
//                    "    检验必须参数是否齐全\n" +
//                    "\n" +
//                    "**方法体**").toJson(), headers);
        BtnDO btnDO = new BtnDO("按钮1", "www.baidu.com");
        BtnDO btnDO1 = new BtnDO("按钮2", "www.google.com");
        String str1 = OKHttpKit.postStream(TestParam.DING_TALK_URL, ActionCardMsg.single("标题", "主题", "sing查看所有", "www.baidu.com").toJson(), headers);
        String str2 = OKHttpKit.postStream(TestParam.DING_TALK_URL, ActionCardMsg.btns("标题", "主题@17307539790", btnDO, btnDO1).toJson(), headers);
//            System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
    }

    @Test
    public void testFeedCardMsg() throws Exception {
        Map headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        LinkDO Link = new LinkDO("标题1", "www.baidu.com", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2599059047,3703734503&fm=58&w=258&h=258&img.GIF");
        LinkDO Link1 = new LinkDO("标题2", "www.google.com", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2599059047,3703734503&fm=58&w=258&h=258&img.GIF");
        String str = OKHttpKit.postStream(TestParam.DING_TALK_URL, new FeedCardMsg(Link, Link1, Link1).toJson(), headers);
        System.out.println(str);
    }
}
