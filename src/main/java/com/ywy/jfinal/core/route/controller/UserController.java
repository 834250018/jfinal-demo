package com.ywy.jfinal.core.route.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class UserController extends Controller {

    public void index() {
        renderText("user index(/hello)");
    }

    public void test() {
        renderText("Hello t(/hello/test)");
    }

    @ActionKey("/login5")
    public void test1() {
        renderText("Hello t1(/login)");
    }
}
