package com.ywy.jfinal.core.aop;

import com.jfinal.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ve
 * @data 2019/8/13 18:24
 */
public class MyHandler extends Handler {
    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
        // 拦截所有的请求,在请求中放入一个属性
        request.setAttribute("attribute", "value");
        // 考虑安全问题,将所有的Option指向成功
        if ("OPTIONS".equals(request.getMethod())) {
            target = "/hello";
        }
        next.handle(target, request, response, isHandled);
    }
}
