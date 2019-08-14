package com.ywy.jfinal.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.ywy.jfinal.model.User;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class Controller3_5 extends Controller {

    // http://localhost/controller35?user1.realName=hhhh&user2.real_name=hhhh
    public void index(
            @Para("str") String str) {
        User user1 = getBean(User.class, "user1"); // 表单传递过来的bean对象,通过set方法复制,即user1.realName
        User user2 = getModel(User.class, "user2"); // 表单传递过来的moodel对象,与数据库字段相同,即user2.real_name
        // user1传入的参数为bean的realName,通过getRealName获取
        // user2传入的参数为model的real_name,通过get("real_name")获取
        // 综上建议数据库设计不使用蛇形命名(下划线分割),而是使用小驼峰命名realName
        // 使用代码生成工具生成model
        renderText("controller35");
    }

}
