package com.ywy.jfinal.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.NotAction;
import com.ywy.jfinal.controller.base.BaseController;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class Controller3_2 extends BaseController {

    // localhost/controller32
    public void index() {
        renderText("此方法是一个action");
    }

    // C:/demo/jfinaldemo/controller32/test.html
//    public String test() {
//        return "index.html";
//    }

    // 如果输入localhost/controller32/no 会进入index方法
    @NotAction
    public void no() {
        renderText("no");
    }

    // localhost/c32
    @ActionKey("/c32")
    public void c32() {
        renderText("c32");
    }
}
