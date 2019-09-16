package com.ywy.jfinal.core.route.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class Controller3_4 extends Controller {

    // http://localhost/controller34/111?str=fff
    public void index(
            @Para("str") String str) {
        String urlPara = get(0);// 获取urlPara中第一个参数,即111
        String parStr = get("str");// 获取表单或url中间问好挂餐的域值,即fff
        renderText("此方法是一个action");
    }

}
