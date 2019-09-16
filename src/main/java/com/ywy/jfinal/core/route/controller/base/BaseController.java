package com.ywy.jfinal.core.route.controller.base;

import com.jfinal.core.Controller;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class BaseController extends Controller {

    // 超类中的所有方法默认不会被映射为action,除非me.setMappingSuperClass(true);
    // 此处通过Controller3_2继承,且配置超类映射已经打开,所以访问路径为localhost/controller32/superMethod
    public void superMethod() {
        renderText("superMethod");
    }
}
