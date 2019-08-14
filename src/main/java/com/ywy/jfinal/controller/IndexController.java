package com.ywy.jfinal.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class IndexController extends Controller {

    public void index() {
        renderText("index index(/hello)");
    }

    public void test() {
        renderText("Hello t(/hello/test)");
    }

    @ActionKey("/login4")
    public void test1() {
        renderText("Hello t1(/login)");
    }
}
