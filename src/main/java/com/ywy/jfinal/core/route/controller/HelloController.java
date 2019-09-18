package com.ywy.jfinal.core.route.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.ywy.jfinal.exception.BusErrorCode;
import com.ywy.jfinal.exception.BusException;
import com.ywy.jfinal.model.User;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class HelloController extends Controller {

    public void index(@Para("") User user) {
//        getModel(User.class, "user");
        User u1 = new User().set("id", "123456").set("name", "ywy");
        u1.save();
        u1.delete();
        renderText("hello index(/hello)");
    }

    public void test() {
        renderText("Hello t(/hello/test)");
    }

    @ActionKey("/login3")
    public void test1() {
        renderText("Hello t1(/login)");
    }

    public void test4() {
        throw new NullPointerException();
    }

    public void test5() {
        throw new BusException(BusErrorCode.CODE_123);
    }

    public void test6() {
        throw new BusException(BusErrorCode.CODE_124, "测试异常额外消息");
    }

    public void test7() {
        renderJson(new User().set("id", "bb"));
    }

}
