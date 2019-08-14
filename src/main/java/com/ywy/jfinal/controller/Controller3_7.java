package com.ywy.jfinal.controller;

import com.jfinal.core.Controller;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class Controller3_7 extends Controller {

    // http://localhost/controller37
    public void index() {

        // 指向: /src/main/resources/controller37/undertow.txt
        render("test.md");

        // 指向: /pom.xml
        render("/pom.xml");

        // render支持JFinal Template、FreeMarker、JSP、Velocity、JSON、File、Text、Html、QrCode 二维码 等等
        renderTemplate("");

        // 生成二维码,最后一个参数为纠错级别'H'、'Q'、'M'、'L'纠错率分别为：30%、25%、15%、7% 默认L
        renderQrCode("ffffffff", 100, 100, 'L');

//        renderFreeMarker("");
//        renderVelocity("");
        // 将所有setAttr(..)设置的变量转换成json并渲染
//        renderJson();

        // 直接渲染
//        renderJson("{aa:bb,cc:ee}");

        // 以users为根
//        renderJson("users", new ArrayList<>());

        // 仅将setAttr("user", user)与setAttr("blog", blog)设置的属性转换成json
//        renderJson(new String[]{"user", "blog"});

        // 渲染文件一般用于下载
        // 默认渲染基础路径(baseDownloadPath)为src/main/webapp/download,再拼接上文件路径
        // 路径linux mac 系统以斜杠打头是绝对路径,win系统以盘符打头也是绝对路径
//        renderFile("test.zip");
        // renderFile(File file)可以指向任何路径
//        renderFile(new File("c:/test.zip"));
        // 下载文件重命名
//        renderFile("test.zip", "newName.zip");


        // 渲染纯文本
//        renderText("test");
//        renderHtml("");

        // 渲染404.html且状态码为404
//        renderError(404, "404.html");
        // 渲染500.html且状态码为500
//        renderError(404, "500.html");
//        renderNull();

        // 除了JFinal支持的视图型以外，还可以通过继承Render抽象类来无限扩展视图类型。
//        render(new MyRender("直接渲染文本"));

        // 多次调用你render方法,只有最后一次会生效
//        renderText("上面的render都不会生效,除非有return拦截,或者抛出异常");
    }
}